package com.efs.sdk.base.core.util.concurrent;

import android.os.HandlerThread;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static HandlerThread f6239a;

    static {
        HandlerThread handlerThread = new HandlerThread("efs-base", 10);
        f6239a = handlerThread;
        handlerThread.start();
    }
}
