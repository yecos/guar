package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: e, reason: collision with root package name */
    private static final int f11228e = 1;

    /* renamed from: a, reason: collision with root package name */
    private final long f11229a;

    /* renamed from: b, reason: collision with root package name */
    private final long f11230b;

    /* renamed from: c, reason: collision with root package name */
    private long f11231c;

    /* renamed from: f, reason: collision with root package name */
    private HandlerThread f11233f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f11234g;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11232d = false;

    /* renamed from: h, reason: collision with root package name */
    private Handler.Callback f11235h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (a.this) {
                if (a.this.f11232d) {
                    return true;
                }
                long elapsedRealtime = a.this.f11231c - SystemClock.elapsedRealtime();
                if (elapsedRealtime <= 0) {
                    a.this.c();
                    if (a.this.f11233f != null) {
                        a.this.f11233f.quit();
                    }
                } else if (elapsedRealtime < a.this.f11230b) {
                    a.this.f11234g.sendMessageDelayed(a.this.f11234g.obtainMessage(1), elapsedRealtime);
                } else {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    a.this.a(elapsedRealtime);
                    long elapsedRealtime3 = (elapsedRealtime2 + a.this.f11230b) - SystemClock.elapsedRealtime();
                    while (elapsedRealtime3 < 0) {
                        elapsedRealtime3 += a.this.f11230b;
                    }
                    a.this.f11234g.sendMessageDelayed(a.this.f11234g.obtainMessage(1), elapsedRealtime3);
                }
                return false;
            }
        }
    };

    public a(long j10, long j11) {
        this.f11229a = j10;
        this.f11230b = j11;
        if (d()) {
            this.f11234g = new Handler(this.f11235h);
            return;
        }
        HandlerThread handlerThread = new HandlerThread("CountDownTimerThread");
        this.f11233f = handlerThread;
        handlerThread.start();
        this.f11234g = new Handler(this.f11233f.getLooper(), this.f11235h);
    }

    public abstract void a(long j10);

    public abstract void c();

    private boolean d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public final synchronized void a() {
        this.f11232d = true;
        this.f11234g.removeMessages(1);
    }

    public final synchronized a b() {
        this.f11232d = false;
        if (this.f11229a <= 0) {
            c();
            return this;
        }
        this.f11231c = SystemClock.elapsedRealtime() + this.f11229a;
        Handler handler = this.f11234g;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}
