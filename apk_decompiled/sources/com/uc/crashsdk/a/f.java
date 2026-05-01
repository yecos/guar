package com.uc.crashsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f9621a = true;

    /* renamed from: b, reason: collision with root package name */
    private static volatile HandlerThread f9622b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile HandlerThread f9623c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile HandlerThread f9624d;

    /* renamed from: e, reason: collision with root package name */
    private static Handler f9625e;

    /* renamed from: f, reason: collision with root package name */
    private static Handler f9626f;

    /* renamed from: g, reason: collision with root package name */
    private static Handler f9627g;

    /* renamed from: h, reason: collision with root package name */
    private static Handler f9628h;

    /* renamed from: i, reason: collision with root package name */
    private static final HashMap<Object, Object[]> f9629i = new HashMap<>();

    public static Handler a(int i10) {
        if (i10 == 0) {
            if (f9622b == null) {
                a();
            }
            return f9625e;
        }
        if (i10 == 1) {
            if (f9623c == null) {
                b();
            }
            return f9626f;
        }
        if (i10 == 2) {
            if (f9627g == null) {
                f9627g = new Handler(Looper.getMainLooper());
            }
            return f9627g;
        }
        if (i10 == 3) {
            if (f9628h == null) {
                c();
            }
            return f9628h;
        }
        throw new RuntimeException("unknown thread type: " + i10);
    }

    public static boolean b(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return false;
        }
        HashMap<Object, Object[]> hashMap = f9629i;
        synchronized (hashMap) {
            objArr = hashMap.get(runnable);
        }
        return objArr != null;
    }

    private static synchronized void c() {
        synchronized (f.class) {
            if (f9624d == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKAnrHandler", 0);
                f9624d = handlerThread;
                handlerThread.start();
                f9628h = new Handler(f9624d.getLooper());
            }
        }
    }

    private static synchronized void b() {
        synchronized (f.class) {
            if (f9623c == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKNormalHandler", 0);
                f9623c = handlerThread;
                handlerThread.start();
                f9626f = new Handler(f9623c.getLooper());
            }
        }
    }

    public static boolean a(int i10, Runnable runnable, long j10) {
        Handler a10;
        if (runnable == null || (a10 = a(i10)) == null) {
            return false;
        }
        e eVar = new e(10, new Object[]{runnable});
        HashMap<Object, Object[]> hashMap = f9629i;
        synchronized (hashMap) {
            hashMap.put(runnable, new Object[]{eVar, Integer.valueOf(i10)});
        }
        return a10.postDelayed(eVar, j10);
    }

    public static void a(int i10, Object[] objArr) {
        if (i10 != 10) {
            if (!f9621a) {
                throw new AssertionError();
            }
        } else {
            if (!f9621a && objArr == null) {
                throw new AssertionError();
            }
            Runnable runnable = (Runnable) objArr[0];
            HashMap<Object, Object[]> hashMap = f9629i;
            synchronized (hashMap) {
                if (hashMap.get(runnable) != null) {
                    hashMap.remove(runnable);
                }
            }
            runnable.run();
        }
    }

    public static boolean a(int i10, Runnable runnable) {
        return a(i10, runnable, 0L);
    }

    public static void a(Runnable runnable) {
        Object[] objArr;
        Handler handler;
        if (runnable == null) {
            return;
        }
        HashMap<Object, Object[]> hashMap = f9629i;
        synchronized (hashMap) {
            objArr = hashMap.get(runnable);
        }
        if (objArr == null) {
            return;
        }
        int intValue = ((Integer) objArr[1]).intValue();
        if (intValue == 0) {
            handler = f9625e;
        } else if (intValue != 1) {
            handler = intValue != 2 ? null : f9627g;
        } else {
            handler = f9626f;
        }
        if (handler != null) {
            handler.removeCallbacks((Runnable) objArr[0]);
        }
        synchronized (hashMap) {
            if (hashMap.get(runnable) != null) {
                hashMap.remove(runnable);
            }
        }
    }

    private static synchronized void a() {
        synchronized (f.class) {
            if (f9622b == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKBkgdHandler", 10);
                f9622b = handlerThread;
                handlerThread.start();
                f9625e = new Handler(f9622b.getLooper());
            }
        }
    }
}
