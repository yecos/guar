package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class ExecutorsModule_ProvidesLightWeightExecutorFactory implements Factory<Executor> {
    private final ExecutorsModule module;

    public ExecutorsModule_ProvidesLightWeightExecutorFactory(ExecutorsModule executorsModule) {
        this.module = executorsModule;
    }

    public static ExecutorsModule_ProvidesLightWeightExecutorFactory create(ExecutorsModule executorsModule) {
        return new ExecutorsModule_ProvidesLightWeightExecutorFactory(executorsModule);
    }

    public static Executor providesLightWeightExecutor(ExecutorsModule executorsModule) {
        return (Executor) Preconditions.checkNotNull(executorsModule.providesLightWeightExecutor(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Executor get() {
        return providesLightWeightExecutor(this.module);
    }
}
