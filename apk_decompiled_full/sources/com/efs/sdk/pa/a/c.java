package com.efs.sdk.pa.a;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.pa.PA;
import com.efs.sdk.pa.PAANRListener;
import com.efs.sdk.pa.PAMsgListener;
import com.efs.sdk.pa.a.b;
import com.efs.sdk.pa.a.g;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/* loaded from: classes.dex */
public final class c implements PA {

    /* renamed from: a, reason: collision with root package name */
    private boolean f6467a;

    /* renamed from: c, reason: collision with root package name */
    private e f6469c;

    /* renamed from: d, reason: collision with root package name */
    private f f6470d;

    /* renamed from: e, reason: collision with root package name */
    private a f6471e;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6474h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f6475i;

    /* renamed from: b, reason: collision with root package name */
    private Looper f6468b = Looper.myLooper();

    /* renamed from: f, reason: collision with root package name */
    private b f6472f = new b();

    /* renamed from: g, reason: collision with root package name */
    private g f6473g = new g();

    public c(boolean z10) {
        this.f6475i = z10;
    }

    @Override // com.efs.sdk.pa.PA
    public final void enableDumpToFile(String str) {
        FileOutputStream fileOutputStream;
        f fVar = this.f6470d;
        if (fVar == null || str == null || str.trim().length() == 0) {
            return;
        }
        fVar.f6484c = str;
        if (fVar.f6485d == null) {
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Exception unused) {
                fileOutputStream = null;
            }
            try {
                fVar.f6485d = new BufferedOutputStream(fileOutputStream);
            } catch (Exception unused2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused3) {
                    }
                }
            }
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void enableLog(boolean z10) {
        this.f6467a = z10;
        this.f6472f.f6461b = z10;
        this.f6473g.f6487b = z10;
        f fVar = this.f6470d;
        if (fVar != null) {
            fVar.f6483b = z10;
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final int endCalFPS(String str) {
        if (!this.f6474h) {
            return -1;
        }
        b bVar = this.f6472f;
        if (str != null && str.trim().length() != 0) {
            b.a aVar = bVar.f6460a.get(str);
            if (aVar == null) {
                return 0;
            }
            View view = aVar.f6465d;
            if (view != null && aVar.f6464c != null) {
                view.getViewTreeObserver().removeOnPreDrawListener(aVar.f6464c);
            }
            bVar.f6460a.remove(str);
            int currentTimeMillis = (int) (aVar.f6463b / ((System.currentTimeMillis() - aVar.f6462a) / 1000.0f));
            r1 = currentTimeMillis > 0 ? currentTimeMillis : 0;
            if (bVar.f6461b) {
                Log.e("PerformanceAnalyze", "key=" + str + ",fps=" + r1);
            }
        }
        return r1;
    }

    @Override // com.efs.sdk.pa.PA
    public final long endCalTime(String str) {
        if (!this.f6474h) {
            return -1L;
        }
        g gVar = this.f6473g;
        long j10 = 0;
        if (str != null && str.trim().length() != 0) {
            g.a aVar = gVar.f6486a.get(str);
            if (aVar == null) {
                return 0L;
            }
            gVar.f6486a.remove(str);
            j10 = System.currentTimeMillis() - aVar.f6488a;
            if (gVar.f6487b) {
                Log.e("PerformanceAnalyze", "key=" + str + ",consumeTime=" + j10);
            }
        }
        return j10;
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener) {
        registerPAANRListener(context, pAANRListener, 2000L);
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAMsgListener(PAMsgListener pAMsgListener) {
        if (this.f6469c == null) {
            this.f6469c = new e();
        }
        this.f6468b.setMessageLogging(this.f6469c);
        if (this.f6470d == null) {
            this.f6470d = new f();
        }
        f fVar = this.f6470d;
        fVar.f6483b = this.f6467a;
        fVar.f6482a = pAMsgListener;
        this.f6469c.f6476a.add(fVar);
    }

    @Override // com.efs.sdk.pa.PA
    public final void start() {
        if (this.f6475i || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            this.f6474h = true;
            e eVar = this.f6469c;
            if (eVar != null) {
                this.f6468b.setMessageLogging(eVar);
            }
            a aVar = this.f6471e;
            if (aVar == null || !aVar.f6447f) {
                return;
            }
            aVar.f6447f = false;
            aVar.f6448g.post(aVar.f6454m);
            aVar.f6451j = SystemClock.uptimeMillis();
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void startCalFPS(String str, View view) {
        if (this.f6474h) {
            b bVar = this.f6472f;
            if (str == null || str.trim().length() == 0 || view == null || bVar.f6460a.get(str) != null) {
                return;
            }
            b.a aVar = new b.a((byte) 0);
            aVar.f6465d = view;
            b.a.AnonymousClass1 anonymousClass1 = new ViewTreeObserver.OnPreDrawListener() { // from class: com.efs.sdk.pa.a.b.a.1
                public AnonymousClass1() {
                }

                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    a.this.f6463b++;
                    return true;
                }
            };
            aVar.f6464c = anonymousClass1;
            aVar.f6465d.getViewTreeObserver().addOnPreDrawListener(anonymousClass1);
            aVar.f6462a = System.currentTimeMillis();
            bVar.f6460a.put(str, aVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void startCalTime(String str) {
        if (this.f6474h) {
            g gVar = this.f6473g;
            if (str == null || str.trim().length() == 0 || gVar.f6486a.get(str) != null) {
                return;
            }
            g.a aVar = new g.a((byte) 0);
            aVar.f6488a = System.currentTimeMillis();
            gVar.f6486a.put(str, aVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void stop() {
        this.f6474h = false;
        this.f6468b.setMessageLogging(null);
        a aVar = this.f6471e;
        if (aVar != null) {
            aVar.f6447f = true;
            aVar.f6448g.removeCallbacksAndMessages(null);
            aVar.f6442a = true;
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void unRegisterPAMsgListener() {
        f fVar = this.f6470d;
        if (fVar != null) {
            fVar.f6482a = null;
        }
        e eVar = this.f6469c;
        if (eVar != null) {
            eVar.f6476a.remove(fVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void unregisterPAANRListener() {
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener, long j10) {
        registerPAANRListener(context, pAANRListener, j10, Looper.getMainLooper().getThread());
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener, long j10, Thread thread) {
        if (this.f6471e == null) {
            if (thread != null) {
                this.f6471e = new a((Application) context.getApplicationContext(), j10);
            } else {
                this.f6471e = new a((Application) context.getApplicationContext(), j10, false);
            }
        }
        this.f6471e.f6449h = pAANRListener;
    }
}
