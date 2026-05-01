package com.google.firebase.inappmessaging;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.component.AbtComponent;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.internal.AbtIntegrationHelper;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent;
import com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent;
import com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ExecutorsModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule;
import com.google.firebase.inject.Deferred;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

@Keep
/* loaded from: classes2.dex */
public class FirebaseInAppMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fiam";
    private Qualified<Executor> backgroundExecutor = Qualified.qualified(Background.class, Executor.class);
    private Qualified<Executor> blockingExecutor = Qualified.qualified(Blocking.class, Executor.class);
    private Qualified<Executor> lightWeightExecutor = Qualified.qualified(Lightweight.class, Executor.class);

    /* JADX INFO: Access modifiers changed from: private */
    public FirebaseInAppMessaging providesFirebaseInAppMessaging(ComponentContainer componentContainer) {
        FirebaseApp firebaseApp = (FirebaseApp) componentContainer.get(FirebaseApp.class);
        FirebaseInstallationsApi firebaseInstallationsApi = (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class);
        Deferred deferred = componentContainer.getDeferred(AnalyticsConnector.class);
        Subscriber subscriber = (Subscriber) componentContainer.get(Subscriber.class);
        UniversalComponent build = DaggerUniversalComponent.builder().applicationModule(new ApplicationModule((Application) firebaseApp.getApplicationContext())).appMeasurementModule(new AppMeasurementModule(deferred, subscriber)).analyticsEventsModule(new AnalyticsEventsModule()).programmaticContextualTriggerFlowableModule(new ProgrammaticContextualTriggerFlowableModule(new ProgramaticContextualTriggers())).executorsModule(new ExecutorsModule((Executor) componentContainer.get(this.lightWeightExecutor), (Executor) componentContainer.get(this.backgroundExecutor), (Executor) componentContainer.get(this.blockingExecutor))).build();
        return DaggerAppComponent.builder().abtIntegrationHelper(new AbtIntegrationHelper(((AbtComponent) componentContainer.get(AbtComponent.class)).get("fiam"))).apiClientModule(new ApiClientModule(firebaseApp, firebaseInstallationsApi, build.clock())).grpcClientModule(new GrpcClientModule(firebaseApp)).universalComponent(build).transportFactory((TransportFactory) componentContainer.get(TransportFactory.class)).build().providesFirebaseInAppMessaging();
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebaseInAppMessaging.class).name(LIBRARY_NAME).add(Dependency.required((Class<?>) Context.class)).add(Dependency.required((Class<?>) FirebaseInstallationsApi.class)).add(Dependency.required((Class<?>) FirebaseApp.class)).add(Dependency.required((Class<?>) AbtComponent.class)).add(Dependency.deferred((Class<?>) AnalyticsConnector.class)).add(Dependency.required((Class<?>) TransportFactory.class)).add(Dependency.required((Class<?>) Subscriber.class)).add(Dependency.required(this.backgroundExecutor)).add(Dependency.required(this.blockingExecutor)).add(Dependency.required(this.lightWeightExecutor)).factory(new ComponentFactory() { // from class: com.google.firebase.inappmessaging.c
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                FirebaseInAppMessaging providesFirebaseInAppMessaging;
                providesFirebaseInAppMessaging = FirebaseInAppMessagingRegistrar.this.providesFirebaseInAppMessaging(componentContainer);
                return providesFirebaseInAppMessaging;
            }
        }).eagerInDefaultApp().build(), LibraryVersionComponent.create(LIBRARY_NAME, "20.3.1"));
    }
}
