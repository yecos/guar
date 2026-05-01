package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.injection.modules.TransportClientModule;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.concurrent.Executor;

@Module
/* loaded from: classes2.dex */
public class TransportClientModule {
    private static final String TRANSPORT_NAME = "FIREBASE_INAPPMESSAGING";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] lambda$providesMetricsLoggerClient$0(byte[] bArr) {
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$providesMetricsLoggerClient$1(Transport transport, byte[] bArr) {
        transport.send(Event.ofData(bArr));
    }

    @Provides
    @FirebaseAppScope
    public static MetricsLoggerClient providesMetricsLoggerClient(FirebaseApp firebaseApp, TransportFactory transportFactory, AnalyticsConnector analyticsConnector, FirebaseInstallationsApi firebaseInstallationsApi, Clock clock, DeveloperListenerManager developerListenerManager, @Blocking Executor executor) {
        final Transport transport = transportFactory.getTransport(TRANSPORT_NAME, byte[].class, new Transformer() { // from class: o4.c
            @Override // com.google.android.datatransport.Transformer
            public final Object apply(Object obj) {
                byte[] lambda$providesMetricsLoggerClient$0;
                lambda$providesMetricsLoggerClient$0 = TransportClientModule.lambda$providesMetricsLoggerClient$0((byte[]) obj);
                return lambda$providesMetricsLoggerClient$0;
            }
        });
        return new MetricsLoggerClient(new MetricsLoggerClient.EngagementMetricsLoggerInterface() { // from class: o4.d
            @Override // com.google.firebase.inappmessaging.internal.MetricsLoggerClient.EngagementMetricsLoggerInterface
            public final void logEvent(byte[] bArr) {
                TransportClientModule.lambda$providesMetricsLoggerClient$1(Transport.this, bArr);
            }
        }, analyticsConnector, firebaseApp, firebaseInstallationsApi, clock, developerListenerManager, executor);
    }
}
