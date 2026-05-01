package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.android.gms.cast.MediaTrack;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Named;
import javax.inject.Singleton;

@Module
/* loaded from: classes2.dex */
public class SchedulerModule {
    @Provides
    @Singleton
    @Named("compute")
    public Scheduler providesComputeScheduler() {
        return Schedulers.computation();
    }

    @Provides
    @Singleton
    @Named("io")
    public Scheduler providesIOScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @Named(MediaTrack.ROLE_MAIN)
    public Scheduler providesMainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
