package com.google.firebase.inappmessaging.internal;

import io.reactivex.Scheduler;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class Schedulers {
    private final Scheduler computeScheduler;
    private final Scheduler ioScheduler;
    private final Scheduler mainThreadScheduler;

    @Inject
    public Schedulers(@Named("io") Scheduler scheduler, @Named("compute") Scheduler scheduler2, @Named("main") Scheduler scheduler3) {
        this.ioScheduler = scheduler;
        this.computeScheduler = scheduler2;
        this.mainThreadScheduler = scheduler3;
    }

    public Scheduler computation() {
        return this.computeScheduler;
    }

    public Scheduler io() {
        return this.ioScheduler;
    }

    public Scheduler mainThread() {
        return this.mainThreadScheduler;
    }
}
