package com.google.firebase.inappmessaging.internal;

import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AbtIntegrationHelper_Factory implements Factory<AbtIntegrationHelper> {
    private final Provider<FirebaseABTesting> abTestingProvider;
    private final Provider<Executor> executorProvider;

    public AbtIntegrationHelper_Factory(Provider<FirebaseABTesting> provider, Provider<Executor> provider2) {
        this.abTestingProvider = provider;
        this.executorProvider = provider2;
    }

    public static AbtIntegrationHelper_Factory create(Provider<FirebaseABTesting> provider, Provider<Executor> provider2) {
        return new AbtIntegrationHelper_Factory(provider, provider2);
    }

    public static AbtIntegrationHelper newInstance(FirebaseABTesting firebaseABTesting) {
        return new AbtIntegrationHelper(firebaseABTesting);
    }

    @Override // javax.inject.Provider
    public AbtIntegrationHelper get() {
        AbtIntegrationHelper newInstance = newInstance(this.abTestingProvider.get());
        AbtIntegrationHelper_MembersInjector.injectExecutor(newInstance, this.executorProvider.get());
        return newInstance;
    }
}
