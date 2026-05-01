package com.hpplay.sdk.source.da;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.da.a.a;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.ErrorCode;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7640a = "DaProcessor";

    /* renamed from: b, reason: collision with root package name */
    private static final int f7641b = 2000;

    /* renamed from: c, reason: collision with root package name */
    private static f f7642c;

    /* renamed from: g, reason: collision with root package name */
    private Context f7646g;

    /* renamed from: i, reason: collision with root package name */
    private com.hpplay.sdk.source.da.a.b f7648i;

    /* renamed from: j, reason: collision with root package name */
    private a.C0129a f7649j;

    /* renamed from: k, reason: collision with root package name */
    private m f7650k;

    /* renamed from: l, reason: collision with root package name */
    private OutParameter f7651l;

    /* renamed from: m, reason: collision with root package name */
    private OutParameter f7652m;

    /* renamed from: d, reason: collision with root package name */
    private int f7643d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f7644e = 0;

    /* renamed from: n, reason: collision with root package name */
    private Handler f7653n = new Handler(Looper.getMainLooper());

    /* renamed from: o, reason: collision with root package name */
    private Runnable f7654o = new Runnable() { // from class: com.hpplay.sdk.source.da.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f7644e < f.this.f7643d) {
                f.this.f();
                return;
            }
            SourceLog.w(f.f7640a, "request da timeout");
            f.this.e();
            f fVar = f.this;
            fVar.a(fVar.f7651l, "0", 0, false, ErrorCode.DA_REQUEST_TIMEOUT);
            if (f.this.f7650k != null) {
                f.this.f7650k.onDaResult(true, null);
            }
        }
    };

    /* renamed from: h, reason: collision with root package name */
    private i f7647h = new i();

    /* renamed from: f, reason: collision with root package name */
    private int f7645f = 0;

    private f() {
    }

    public static void b() {
        f7642c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f7647h == null) {
            SourceLog.i(f7640a, "toRequestVideoAD,value is valid");
            return;
        }
        SourceLog.i(f7640a, "toRequestVideoAD mCurrentRetryTime=" + this.f7644e);
        if (this.f7644e >= this.f7643d || this.f7648i == null) {
            return;
        }
        this.f7647h.c();
        int i10 = this.f7645f + 1;
        this.f7645f = i10;
        this.f7648i.f7626i = i10;
        SourceLog.i(f7640a, "toRequestVideoAD mRequestID: " + this.f7645f);
        this.f7647h.a(this.f7646g, this.f7648i);
        if (this.f7653n != null) {
            int i11 = Preference.getInstance().get(Preference.KEY_DA_CONNECT_TIMEOUT, 0);
            int i12 = i11 <= 0 ? 2000 : i11;
            SourceLog.i(f7640a, "cacheRetryCount cacheConnectTimeout=" + i11 + " connectTimeout=" + i12);
            this.f7653n.postDelayed(this.f7654o, (long) i12);
        }
        this.f7644e++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SourceLog.i(f7640a, "cancelTimeoutCheck");
        Handler handler = this.f7653n;
        if (handler != null) {
            handler.removeCallbacks(this.f7654o);
        }
    }

    public void c() {
        this.f7647h.a();
    }

    public void d() {
        if (this.f7652m != null) {
            SourceLog.i(f7640a, "interruptRequest report interrupt");
            a(this.f7652m, "0", 0, false, ErrorCode.DA_REQUEST_INTERRUPT);
        }
        e();
    }

    public void e() {
        SourceLog.i(f7640a, "cancelRequest");
        this.f7652m = null;
        this.f7649j = null;
        this.f7645f++;
        g();
        i iVar = this.f7647h;
        if (iVar != null) {
            iVar.b();
        }
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (f7642c == null) {
                f7642c = new f();
            }
            fVar = f7642c;
        }
        return fVar;
    }

    public void a(Context context, OutParameter outParameter, m mVar) {
        this.f7645f = 0;
        this.f7646g = context;
        this.f7644e = 0;
        this.f7650k = mVar;
        this.f7651l = outParameter;
        this.f7652m = outParameter;
        com.hpplay.sdk.source.da.a.b bVar = new com.hpplay.sdk.source.da.a.b();
        bVar.f7618a = String.valueOf(1);
        LelinkServiceInfo lelinkServiceInfo = outParameter.serviceInfo;
        if (lelinkServiceInfo != null) {
            bVar.f7619b = String.valueOf(lelinkServiceInfo.getAppId());
            bVar.f7621d = outParameter.serviceInfo.getUid();
            bVar.f7622e = outParameter.serviceInfo.getUdnUuid();
        }
        bVar.f7623f = outParameter.getPlayUrl();
        bVar.f7624g = outParameter.session;
        bVar.f7625h = outParameter.urlID;
        this.f7648i = bVar;
        int i10 = Preference.getInstance().get(Preference.KEY_DA_RETRY_COUNT, 0);
        this.f7643d = i10 > 0 ? i10 : 1;
        SourceLog.i(f7640a, "requestVideoPatchDA mRetryCount=" + this.f7643d + "  cacheRetryCount=" + i10);
        this.f7647h.a(new l() { // from class: com.hpplay.sdk.source.da.f.2
            @Override // com.hpplay.sdk.source.da.l
            public void a(String str, String str2, com.hpplay.sdk.source.da.a.a aVar) {
                boolean z10;
                a.C0129a c0129a;
                if (!TextUtils.equals(f.this.f7645f + "", str2)) {
                    SourceLog.w(f.f7640a, "requestVideoPatchDA ignore, different requestId," + str2 + Operator.Operation.DIVISION + f.this.f7645f);
                    return;
                }
                String str3 = null;
                f.this.f7652m = null;
                f.this.g();
                if (aVar != null && aVar.f7607a == 200 && (c0129a = aVar.f7608b) != null) {
                    f.this.f7649j = c0129a;
                    Preference.getInstance().put(Preference.KEY_DA_CONNECT_TIMEOUT, aVar.f7610d);
                    Preference.getInstance().put(Preference.KEY_DA_RETRY_COUNT, aVar.f7609c);
                    z10 = true;
                } else {
                    if (f.this.f7644e < f.this.f7643d) {
                        f.this.f();
                        return;
                    }
                    z10 = false;
                }
                if (f.this.f7650k != null) {
                    f.this.f7650k.onDaResult(true, z10 ? aVar.f7608b.f7617g : null);
                }
                if (!z10) {
                    if (aVar == null) {
                        str3 = ErrorCode.DA_REQUEST_FAILED;
                    } else if (aVar.f7607a != 200) {
                        str3 = ErrorCode.DA_REQUEST_RESULT_ERROR;
                    }
                }
                String str4 = str3;
                if (!TextUtils.isEmpty(str4)) {
                    f fVar = f.this;
                    fVar.a(fVar.f7651l, "0", 0, false, str4);
                } else if (aVar == null || aVar.f7608b == null) {
                    f fVar2 = f.this;
                    fVar2.a(fVar2.f7651l, "0", 0, true, "");
                } else {
                    f fVar3 = f.this;
                    OutParameter outParameter2 = fVar3.f7651l;
                    a.C0129a c0129a2 = aVar.f7608b;
                    fVar3.a(outParameter2, c0129a2.f7613c, c0129a2.f7614d, true, "");
                }
            }
        });
        f();
    }

    public a.C0129a a(String str) {
        OutParameter outParameter = this.f7651l;
        if (outParameter != null && str != null && str.equals(outParameter.session)) {
            return this.f7649j;
        }
        SourceLog.i(f7640a, "getDaData fail, session check fail :" + str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(OutParameter outParameter, String str, int i10, boolean z10, String str2) {
        g.a().a(outParameter, str, String.valueOf(1), i10, z10, str2);
    }
}
