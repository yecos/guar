package com.umeng.message.proguard;

import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class dx {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f12020a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f12021b;

    /* renamed from: c, reason: collision with root package name */
    private static long f12022c;

    /* renamed from: d, reason: collision with root package name */
    private static final cw f12023d;

    static {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        f12020a = atomicBoolean;
        f12023d = new cw(atomicBoolean);
    }

    public static boolean a() {
        AtomicBoolean atomicBoolean = f12020a;
        if (!atomicBoolean.get() && SystemClock.elapsedRealtime() - f12022c >= 12000) {
            f12022c = SystemClock.elapsedRealtime();
            c();
        }
        return atomicBoolean.get();
    }

    public static synchronized void b() {
        synchronized (dx.class) {
            if (f12021b) {
                return;
            }
            try {
                c();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                de.a().registerReceiver(f12023d, intentFilter);
                f12021b = true;
            } catch (Throwable th) {
                ce.a("Screen", "screen state error:" + th.getMessage());
            }
        }
    }

    private static void c() {
        boolean isInteractive;
        try {
            PowerManager powerManager = (PowerManager) de.a().getSystemService("power");
            if (powerManager != null) {
                if (Build.VERSION.SDK_INT < 20) {
                    f12020a.set(powerManager.isScreenOn());
                    return;
                }
                AtomicBoolean atomicBoolean = f12020a;
                isInteractive = powerManager.isInteractive();
                atomicBoolean.set(isInteractive);
            }
        } catch (Throwable th) {
            ce.a("Screen", "screen on state error:", th.getMessage());
        }
    }
}
