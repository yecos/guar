package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;

/* loaded from: classes3.dex */
public interface SchedulerMultiWorkerSupport {

    public interface WorkerCallback {
        void onWorker(int i10, @NonNull Scheduler.Worker worker);
    }

    void createWorkers(int i10, @NonNull WorkerCallback workerCallback);
}
