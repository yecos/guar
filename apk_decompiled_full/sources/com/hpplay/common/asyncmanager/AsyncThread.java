package com.hpplay.common.asyncmanager;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class AsyncThread extends Thread {
    public static AtomicInteger mThreadCount = new AtomicInteger(0);

    public AsyncThread() {
        mThreadCount.getAndIncrement();
    }

    public void finalize() {
        super.finalize();
        mThreadCount.getAndDecrement();
    }

    public AsyncThread(Runnable runnable) {
        super(runnable);
        mThreadCount.getAndIncrement();
    }

    public AsyncThread(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
        mThreadCount.getAndIncrement();
    }

    public AsyncThread(String str) {
        super(str);
        mThreadCount.getAndIncrement();
    }

    public AsyncThread(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
        mThreadCount.getAndIncrement();
    }

    public AsyncThread(Runnable runnable, String str) {
        super(runnable, str);
        mThreadCount.getAndIncrement();
    }

    public AsyncThread(ThreadGroup threadGroup, Runnable runnable, String str) {
        super(threadGroup, runnable, str);
        mThreadCount.getAndIncrement();
    }

    public AsyncThread(ThreadGroup threadGroup, Runnable runnable, String str, long j10) {
        super(threadGroup, runnable, str, j10);
        mThreadCount.getAndIncrement();
    }
}
