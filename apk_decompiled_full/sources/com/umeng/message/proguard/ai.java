package com.umeng.message.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes3.dex */
public abstract class ai {

    /* renamed from: a, reason: collision with root package name */
    final long f11477a;

    /* renamed from: b, reason: collision with root package name */
    long f11478b;

    /* renamed from: d, reason: collision with root package name */
    private final long f11480d;

    /* renamed from: e, reason: collision with root package name */
    private long f11481e;

    /* renamed from: c, reason: collision with root package name */
    boolean f11479c = false;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f11482f = new Handler(Looper.getMainLooper()) { // from class: com.umeng.message.proguard.ai.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            synchronized (ai.this) {
                if (message.what == 1) {
                    ai aiVar = ai.this;
                    if (aiVar.f11479c) {
                        return;
                    }
                    long elapsedRealtime = aiVar.f11478b - SystemClock.elapsedRealtime();
                    if (elapsedRealtime <= 0) {
                        ai.this.e();
                    } else {
                        ai aiVar2 = ai.this;
                        if (elapsedRealtime < aiVar2.f11477a) {
                            aiVar2.a(elapsedRealtime);
                            sendMessageDelayed(obtainMessage(1), elapsedRealtime);
                        } else {
                            long elapsedRealtime2 = SystemClock.elapsedRealtime();
                            ai.this.a(elapsedRealtime);
                            long elapsedRealtime3 = (elapsedRealtime2 + ai.this.f11477a) - SystemClock.elapsedRealtime();
                            while (elapsedRealtime3 < 0) {
                                elapsedRealtime3 += ai.this.f11477a;
                            }
                            sendMessageDelayed(obtainMessage(1), elapsedRealtime3);
                        }
                    }
                }
            }
        }
    };

    public ai(long j10, long j11) {
        this.f11480d = j10;
        this.f11477a = j11;
    }

    public final synchronized void a() {
        this.f11479c = true;
        this.f11482f.removeMessages(1);
    }

    public abstract void a(long j10);

    public final synchronized ai b() {
        this.f11479c = false;
        if (this.f11480d <= 0) {
            e();
            return this;
        }
        this.f11478b = SystemClock.elapsedRealtime() + this.f11480d;
        Handler handler = this.f11482f;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }

    public final synchronized ai c() {
        this.f11479c = false;
        long elapsedRealtime = this.f11478b - SystemClock.elapsedRealtime();
        this.f11481e = elapsedRealtime;
        if (elapsedRealtime <= 0) {
            return this;
        }
        this.f11482f.removeMessages(1);
        Handler handler = this.f11482f;
        handler.sendMessageAtFrontOfQueue(handler.obtainMessage(2));
        return this;
    }

    public final synchronized ai d() {
        this.f11479c = false;
        if (this.f11481e <= 0) {
            return this;
        }
        this.f11482f.removeMessages(2);
        this.f11478b = this.f11481e + SystemClock.elapsedRealtime();
        Handler handler = this.f11482f;
        handler.sendMessageAtFrontOfQueue(handler.obtainMessage(1));
        return this;
    }

    public abstract void e();
}
