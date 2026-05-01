package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import io.reactivex.Scheduler;

/* loaded from: classes2.dex */
public final class SchedulerModule_ProvidesMainThreadSchedulerFactory implements Factory<Scheduler> {
    private final SchedulerModule module;

    public SchedulerModule_ProvidesMainThreadSchedulerFactory(SchedulerModule schedulerModule) {
        this.module = schedulerModule;
    }

    public static SchedulerModule_ProvidesMainThreadSchedulerFactory create(SchedulerModule schedulerModule) {
        return new SchedulerModule_ProvidesMainThreadSchedulerFactory(schedulerModule);
    }

    public static Scheduler providesMainThreadScheduler(SchedulerModule schedulerModule) {
        return (Scheduler) Preconditions.checkNotNull(schedulerModule.providesMainThreadScheduler(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Scheduler get() {
        return providesMainThreadScheduler(this.module);
    }
}
