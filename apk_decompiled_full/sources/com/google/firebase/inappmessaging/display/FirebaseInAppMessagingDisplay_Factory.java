package com.google.firebase.inappmessaging.display;

import android.app.Application;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FirebaseInAppMessagingDisplay_Factory implements Factory<FirebaseInAppMessagingDisplay> {
    private final Provider<FiamAnimator> animatorProvider;
    private final Provider<Application> applicationProvider;
    private final Provider<RenewableTimer> autoDismissTimerProvider;
    private final Provider<BindingWrapperFactory> bindingWrapperFactoryProvider;
    private final Provider<FirebaseInAppMessaging> headlessInAppMessagingProvider;
    private final Provider<FiamImageLoader> imageLoaderProvider;
    private final Provider<RenewableTimer> impressionTimerProvider;
    private final Provider<Map<String, Provider<InAppMessageLayoutConfig>>> layoutConfigsProvider;
    private final Provider<FiamWindowManager> windowManagerProvider;

    public FirebaseInAppMessagingDisplay_Factory(Provider<FirebaseInAppMessaging> provider, Provider<Map<String, Provider<InAppMessageLayoutConfig>>> provider2, Provider<FiamImageLoader> provider3, Provider<RenewableTimer> provider4, Provider<RenewableTimer> provider5, Provider<FiamWindowManager> provider6, Provider<Application> provider7, Provider<BindingWrapperFactory> provider8, Provider<FiamAnimator> provider9) {
        this.headlessInAppMessagingProvider = provider;
        this.layoutConfigsProvider = provider2;
        this.imageLoaderProvider = provider3;
        this.impressionTimerProvider = provider4;
        this.autoDismissTimerProvider = provider5;
        this.windowManagerProvider = provider6;
        this.applicationProvider = provider7;
        this.bindingWrapperFactoryProvider = provider8;
        this.animatorProvider = provider9;
    }

    public static FirebaseInAppMessagingDisplay_Factory create(Provider<FirebaseInAppMessaging> provider, Provider<Map<String, Provider<InAppMessageLayoutConfig>>> provider2, Provider<FiamImageLoader> provider3, Provider<RenewableTimer> provider4, Provider<RenewableTimer> provider5, Provider<FiamWindowManager> provider6, Provider<Application> provider7, Provider<BindingWrapperFactory> provider8, Provider<FiamAnimator> provider9) {
        return new FirebaseInAppMessagingDisplay_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static FirebaseInAppMessagingDisplay newInstance(FirebaseInAppMessaging firebaseInAppMessaging, Map<String, Provider<InAppMessageLayoutConfig>> map, FiamImageLoader fiamImageLoader, RenewableTimer renewableTimer, RenewableTimer renewableTimer2, FiamWindowManager fiamWindowManager, Application application, BindingWrapperFactory bindingWrapperFactory, FiamAnimator fiamAnimator) {
        return new FirebaseInAppMessagingDisplay(firebaseInAppMessaging, map, fiamImageLoader, renewableTimer, renewableTimer2, fiamWindowManager, application, bindingWrapperFactory, fiamAnimator);
    }

    @Override // javax.inject.Provider
    public FirebaseInAppMessagingDisplay get() {
        return newInstance(this.headlessInAppMessagingProvider.get(), this.layoutConfigsProvider.get(), this.imageLoaderProvider.get(), this.impressionTimerProvider.get(), this.autoDismissTimerProvider.get(), this.windowManagerProvider.get(), this.applicationProvider.get(), this.bindingWrapperFactoryProvider.get(), this.animatorProvider.get());
    }
}
