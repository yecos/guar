package com.umeng.message.proguard;

import java.lang.ref.WeakReference;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static WeakReference<Future<?>> f12125a;

    /* renamed from: b, reason: collision with root package name */
    private static WeakReference<Future<?>> f12126b;

    public static synchronized void a() {
        Future<?> future;
        synchronized (o.class) {
            WeakReference<Future<?>> weakReference = f12126b;
            if (weakReference == null || (future = weakReference.get()) == null || future.isDone() || future.isCancelled()) {
                f12126b = new WeakReference<>(b.b(new m()));
            }
        }
    }
}
