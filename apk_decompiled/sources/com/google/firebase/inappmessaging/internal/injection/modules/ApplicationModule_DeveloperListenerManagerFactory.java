package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_DeveloperListenerManagerFactory implements Factory<DeveloperListenerManager> {
    private final Provider<Executor> backgroundExecutorProvider;
    private final ApplicationModule module;

    public ApplicationModule_DeveloperListenerManagerFactory(ApplicationModule applicationModule, Provider<Executor> provider) {
        this.module = applicationModule;
        this.backgroundExecutorProvider = provider;
    }

    public static ApplicationModule_DeveloperListenerManagerFactory create(ApplicationModule applicationModule, Provider<Executor> provider) {
        return new ApplicationModule_DeveloperListenerManagerFactory(applicationModule, provider);
    }

    public static DeveloperListenerManager developerListenerManager(ApplicationModule applicationModule, Executor executor) {
        return (DeveloperListenerManager) Preconditions.checkNotNull(applicationModule.developerListenerManager(executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public DeveloperListenerManager get() {
        return developerListenerManager(this.module, this.backgroundExecutorProvider.get());
    }
}
