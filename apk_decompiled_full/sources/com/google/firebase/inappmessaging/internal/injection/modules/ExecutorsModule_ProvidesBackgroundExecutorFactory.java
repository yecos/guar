package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class ExecutorsModule_ProvidesBackgroundExecutorFactory implements Factory<Executor> {
    private final ExecutorsModule module;

    public ExecutorsModule_ProvidesBackgroundExecutorFactory(ExecutorsModule executorsModule) {
        this.module = executorsModule;
    }

    public static ExecutorsModule_ProvidesBackgroundExecutorFactory create(ExecutorsModule executorsModule) {
        return new ExecutorsModule_ProvidesBackgroundExecutorFactory(executorsModule);
    }

    public static Executor providesBackgroundExecutor(ExecutorsModule executorsModule) {
        return (Executor) Preconditions.checkNotNull(executorsModule.providesBackgroundExecutor(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Executor get() {
        return providesBackgroundExecutor(this.module);
    }
}
