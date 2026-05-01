package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class ExecutorsModule_ProvidesBlockingExecutorFactory implements Factory<Executor> {
    private final ExecutorsModule module;

    public ExecutorsModule_ProvidesBlockingExecutorFactory(ExecutorsModule executorsModule) {
        this.module = executorsModule;
    }

    public static ExecutorsModule_ProvidesBlockingExecutorFactory create(ExecutorsModule executorsModule) {
        return new ExecutorsModule_ProvidesBlockingExecutorFactory(executorsModule);
    }

    public static Executor providesBlockingExecutor(ExecutorsModule executorsModule) {
        return (Executor) Preconditions.checkNotNull(executorsModule.providesBlockingExecutor(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Executor get() {
        return providesBlockingExecutor(this.module);
    }
}
