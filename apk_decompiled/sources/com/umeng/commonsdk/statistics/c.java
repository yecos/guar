package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cz;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.f;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import io.jsonwebtoken.Claims;
import java.io.File;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static final int f11021b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f11022c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final int f11023d = 3;

    /* renamed from: o, reason: collision with root package name */
    private static final String f11024o = "thtstart";

    /* renamed from: p, reason: collision with root package name */
    private static final String f11025p = "gkvc";

    /* renamed from: q, reason: collision with root package name */
    private static final String f11026q = "ekvc";

    /* renamed from: a, reason: collision with root package name */
    String f11027a;

    /* renamed from: f, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.c f11029f;

    /* renamed from: g, reason: collision with root package name */
    private ImprintHandler f11030g;

    /* renamed from: h, reason: collision with root package name */
    private f f11031h;

    /* renamed from: i, reason: collision with root package name */
    private ImprintHandler.a f11032i;

    /* renamed from: k, reason: collision with root package name */
    private Defcon f11034k;

    /* renamed from: l, reason: collision with root package name */
    private long f11035l;

    /* renamed from: m, reason: collision with root package name */
    private int f11036m;

    /* renamed from: n, reason: collision with root package name */
    private int f11037n;

    /* renamed from: r, reason: collision with root package name */
    private Context f11038r;

    /* renamed from: e, reason: collision with root package name */
    private final int f11028e = 1;

    /* renamed from: j, reason: collision with root package name */
    private ABTest f11033j = null;

    public c(Context context) {
        this.f11031h = null;
        this.f11032i = null;
        this.f11034k = null;
        this.f11035l = 0L;
        this.f11036m = 0;
        this.f11037n = 0;
        this.f11027a = null;
        this.f11038r = context;
        this.f11032i = ImprintHandler.getImprintService(context).c();
        this.f11034k = Defcon.getService(this.f11038r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.f11038r);
        this.f11035l = sharedPreferences.getLong(f11024o, 0L);
        this.f11036m = sharedPreferences.getInt(f11025p, 0);
        this.f11037n = sharedPreferences.getInt(f11026q, 0);
        this.f11027a = UMEnvelopeBuild.imprintProperty(this.f11038r, "track_list", null);
        ImprintHandler imprintService = ImprintHandler.getImprintService(this.f11038r);
        this.f11030g = imprintService;
        imprintService.a(new d() { // from class: com.umeng.commonsdk.statistics.c.1
            @Override // com.umeng.commonsdk.statistics.internal.d
            public void onImprintChanged(ImprintHandler.a aVar) {
                c.this.f11034k.onImprintChanged(aVar);
                c cVar = c.this;
                cVar.f11027a = UMEnvelopeBuild.imprintProperty(cVar.f11038r, "track_list", null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.f11038r)) {
            this.f11031h = f.a(this.f11038r);
        }
        com.umeng.commonsdk.statistics.internal.c cVar = new com.umeng.commonsdk.statistics.internal.c(this.f11038r);
        this.f11029f = cVar;
        cVar.a(StatTracer.getInstance(this.f11038r));
    }

    public boolean a(File file) {
        if (file == null) {
            return false;
        }
        try {
            byte[] byteArray = UMFrUtils.toByteArray(file.getPath());
            if (byteArray == null) {
                return false;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            com.umeng.commonsdk.statistics.internal.a a10 = com.umeng.commonsdk.statistics.internal.a.a(this.f11038r);
            a10.e(name);
            boolean a11 = a10.a(name);
            boolean b10 = a10.b(name);
            boolean c10 = a10.c(name);
            boolean d10 = a10.d(name);
            String d11 = com.umeng.commonsdk.stateless.d.d(name);
            byte[] a12 = this.f11029f.a(byteArray, a11, c10, !TextUtils.isEmpty(d11) ? com.umeng.commonsdk.stateless.d.c(d11) : d10 ? UMServerURL.SILENT_HEART_BEAT : c10 ? UMServerURL.ZCFG_PATH : UMServerURL.PATH_ANALYTICS);
            int a13 = a12 == null ? 1 : a(a12);
            if (UMConfigure.isDebugLog()) {
                if (d10 && a13 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "heart beat req: succeed.");
                } else if (c10 && a13 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Zero req: succeed.");
                } else if (b10 && a13 == 2) {
                    MLog.d("本次启动数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send instant data: succeed.");
                } else if (a11 && a13 == 2) {
                    MLog.d("普通统计数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send analytics data: succeed.");
                } else if (a13 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Inner req: succeed.");
                }
            }
            if (a13 == 2) {
                f fVar = this.f11031h;
                if (fVar != null) {
                    fVar.e();
                }
                StatTracer.getInstance(this.f11038r).saveSate();
                if (d10) {
                    String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f11038r, Claims.ISSUER, "");
                    if (!TextUtils.isEmpty(imprintProperty)) {
                        if ("1".equalsIgnoreCase(imprintProperty)) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新静默心跳最后一次成功请求时间.");
                            com.umeng.commonsdk.utils.c.a(this.f11038r, System.currentTimeMillis());
                        } else if ("0".equalsIgnoreCase(imprintProperty)) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 静默模式 -> 正常模式。重置 last req time");
                            com.umeng.commonsdk.utils.c.a(this.f11038r, 0L);
                            com.umeng.commonsdk.utils.c.d(this.f11038r);
                        }
                    }
                }
            } else if (a13 == 3) {
                StatTracer.getInstance(this.f11038r).saveSate();
                if (c10) {
                    FieldManager.a().a(this.f11038r);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文应答内容报错!!! ，特殊处理!，继续正常流程。");
                    Context context = this.f11038r;
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f10901s, com.umeng.commonsdk.internal.b.a(context).a(), null);
                    return true;
                }
            }
            return a13 == 2;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f11038r, th);
            return false;
        }
    }

    private int a(byte[] bArr) {
        Response response = new Response();
        try {
            new ck(new cz.a()).a(response, bArr);
            if (response.resp_code == 1) {
                this.f11030g.b(response.getImprint());
                this.f11030g.d();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f11038r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }
}
