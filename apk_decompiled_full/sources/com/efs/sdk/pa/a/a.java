package com.efs.sdk.pa.a;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.efs.sdk.pa.PAANRListener;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    volatile boolean f6442a;

    /* renamed from: b, reason: collision with root package name */
    final Handler f6443b;

    /* renamed from: c, reason: collision with root package name */
    final Thread f6444c;

    /* renamed from: d, reason: collision with root package name */
    long f6445d;

    /* renamed from: e, reason: collision with root package name */
    long f6446e;

    /* renamed from: f, reason: collision with root package name */
    boolean f6447f;

    /* renamed from: g, reason: collision with root package name */
    Handler f6448g;

    /* renamed from: h, reason: collision with root package name */
    PAANRListener f6449h;

    /* renamed from: i, reason: collision with root package name */
    long f6450i;

    /* renamed from: j, reason: collision with root package name */
    long f6451j;

    /* renamed from: k, reason: collision with root package name */
    final long f6452k;

    /* renamed from: l, reason: collision with root package name */
    boolean f6453l;

    /* renamed from: m, reason: collision with root package name */
    final Runnable f6454m;

    /* renamed from: n, reason: collision with root package name */
    final Runnable f6455n;

    /* renamed from: o, reason: collision with root package name */
    private HandlerThread f6456o;

    /* renamed from: p, reason: collision with root package name */
    private Application f6457p;

    public a(Application application, long j10) {
        this(application, j10, true);
    }

    public static boolean a(StringBuilder sb) {
        Set<Map.Entry<Thread, StackTraceElement[]>> entrySet = Thread.getAllStackTraces().entrySet();
        if (entrySet.size() == 0) {
            return false;
        }
        boolean z10 = false;
        for (Map.Entry<Thread, StackTraceElement[]> entry : entrySet) {
            Thread key = entry.getKey();
            StackTraceElement[] value = entry.getValue();
            if (key.getId() == Looper.getMainLooper().getThread().getId()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(key.getName());
                sb2.append(" ");
                sb2.append(key.getPriority());
                sb2.append(" ");
                sb2.append(key.getState());
                sb2.append("\n");
                for (StackTraceElement stackTraceElement : value) {
                    String stackTraceElement2 = stackTraceElement.toString();
                    sb2.append("  at  ");
                    sb2.append(stackTraceElement2);
                    sb2.append('\n');
                }
                sb2.append("\n");
                sb.insert(0, (CharSequence) sb2);
                z10 = true;
            } else {
                sb.append(key.getName());
                sb.append(" ");
                sb.append(key.getPriority());
                sb.append(" ");
                sb.append(key.getState());
                sb.append("\n");
                for (StackTraceElement stackTraceElement3 : value) {
                    String stackTraceElement4 = stackTraceElement3.toString();
                    sb.append("  at  ");
                    sb.append(stackTraceElement4);
                    sb.append('\n');
                }
                sb.append("\n");
            }
        }
        if (!z10) {
            sb.insert(0, a(Looper.getMainLooper().getThread()));
        }
        return true;
    }

    public a(Application application, long j10, boolean z10) {
        this.f6442a = true;
        this.f6446e = 4L;
        this.f6447f = true;
        this.f6450i = 0L;
        this.f6454m = new Runnable() { // from class: com.efs.sdk.pa.a.a.1
            /* JADX WARN: Code restructure failed: missing block: B:30:0x006c, code lost:
            
                if (com.efs.sdk.pa.a.a.a(r1) != false) goto L24;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                PAANRListener pAANRListener;
                if (a.this.f6447f) {
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                a aVar = a.this;
                long j11 = uptimeMillis - aVar.f6451j;
                if (j11 > aVar.f6452k && (pAANRListener = aVar.f6449h) != null) {
                    pAANRListener.unexcept(Long.valueOf(j11));
                }
                if (a.this.f6442a) {
                    a aVar2 = a.this;
                    aVar2.f6450i = 0L;
                    aVar2.f6442a = false;
                    a aVar3 = a.this;
                    aVar3.f6443b.postAtFrontOfQueue(aVar3.f6455n);
                } else {
                    a aVar4 = a.this;
                    aVar4.f6450i++;
                    if (!aVar4.f6442a) {
                        a aVar5 = a.this;
                        long j12 = aVar5.f6450i;
                        long j13 = aVar5.f6446e;
                        if (j12 >= j13 && j12 == j13) {
                            StringBuilder sb = new StringBuilder();
                            if (aVar5.f6453l) {
                                sb.append(a.a(aVar5.f6444c));
                            }
                            if (aVar5.f6449h != null && sb.length() > 0) {
                                aVar5.f6449h.anrStack(sb.toString());
                            }
                        }
                    }
                }
                a.this.f6451j = SystemClock.uptimeMillis();
                a aVar6 = a.this;
                aVar6.f6448g.postDelayed(aVar6.f6454m, aVar6.f6445d);
            }
        };
        this.f6455n = new Runnable() { // from class: com.efs.sdk.pa.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.this.f6442a = true;
            }
        };
        this.f6452k = j10;
        this.f6457p = application;
        this.f6453l = z10;
        long j11 = ((long) (j10 * 0.8f)) / this.f6446e;
        this.f6445d = j11;
        if (j11 < 100) {
            this.f6445d = 100L;
            this.f6446e = j10 / 100;
        }
        StringBuilder sb = new StringBuilder("anrTrace, final mAnrBeatTime:");
        sb.append(this.f6445d);
        sb.append(", mAnrBeatRate:");
        sb.append(this.f6445d);
        this.f6444c = Looper.getMainLooper().getThread();
        this.f6443b = new Handler(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("ANR HANDLER THREAD");
        this.f6456o = handlerThread;
        handlerThread.start();
        this.f6448g = new Handler(this.f6456o.getLooper());
    }

    public static String a(Thread thread) {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = thread.getStackTrace();
        sb.append(thread.getName());
        sb.append(" ");
        sb.append(thread.getPriority());
        sb.append(" ");
        sb.append(thread.getState());
        sb.append("\n");
        for (StackTraceElement stackTraceElement : stackTrace) {
            String stackTraceElement2 = stackTraceElement.toString();
            sb.append("  at  ");
            sb.append(stackTraceElement2);
            sb.append('\n');
        }
        sb.append("\n");
        return sb.toString();
    }
}
