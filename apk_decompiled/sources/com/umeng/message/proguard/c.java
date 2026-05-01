package com.umeng.message.proguard;

import java.util.concurrent.Future;

/* loaded from: classes3.dex */
public abstract class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    protected Future<?> f11695a;

    public final c a() {
        this.f11695a = b();
        return this;
    }

    public abstract Future<?> b();

    public final void c() {
        Future<?> future = this.f11695a;
        if (future != null) {
            try {
                if (!future.isCancelled() && !future.isDone()) {
                    future.cancel(false);
                }
            } catch (Throwable unused) {
            }
        }
        this.f11695a = null;
    }

    public final boolean d() {
        Future<?> future = this.f11695a;
        return (future == null || future.isDone()) ? false : true;
    }
}
