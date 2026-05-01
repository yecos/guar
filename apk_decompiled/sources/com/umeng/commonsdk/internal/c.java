package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.q;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.UMInnerManager;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import com.umeng.umzid.ZIDManager;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c implements UMLogDataProtocol {

    /* renamed from: b, reason: collision with root package name */
    public static final String f10913b = "preInitInvokedFlag";

    /* renamed from: c, reason: collision with root package name */
    public static final String f10914c = "policyGrantInvokedFlag";

    /* renamed from: d, reason: collision with root package name */
    public static final String f10915d = "policyGrantResult";

    /* renamed from: f, reason: collision with root package name */
    private static int f10916f = 1;

    /* renamed from: e, reason: collision with root package name */
    private Context f10924e;

    /* renamed from: a, reason: collision with root package name */
    public static final String f10912a = bd.b().b(bd.f9990q);

    /* renamed from: g, reason: collision with root package name */
    private static Class<?> f10917g = null;

    /* renamed from: h, reason: collision with root package name */
    private static Method f10918h = null;

    /* renamed from: i, reason: collision with root package name */
    private static Method f10919i = null;

    /* renamed from: j, reason: collision with root package name */
    private static Method f10920j = null;

    /* renamed from: k, reason: collision with root package name */
    private static volatile String f10921k = "";

    /* renamed from: l, reason: collision with root package name */
    private static volatile String f10922l = "";

    /* renamed from: m, reason: collision with root package name */
    private static boolean f10923m = false;

    static {
        c();
    }

    public c(Context context) {
        if (context != null) {
            this.f10924e = context.getApplicationContext();
        }
    }

    public static String b() {
        Method method;
        if (!TextUtils.isEmpty(f10922l)) {
            return f10922l;
        }
        Class<?> cls = f10917g;
        if (cls == null || (method = f10918h) == null || f10920j == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            if (invoke == null) {
                return "";
            }
            String str = (String) f10920j.invoke(invoke, new Object[0]);
            try {
                f10922l = str;
            } catch (Throwable unused) {
            }
            return str;
        } catch (Throwable unused2) {
            return "";
        }
    }

    private static void c() {
        try {
            f10917g = ZIDManager.class;
            Method declaredMethod = ZIDManager.class.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod != null) {
                f10918h = declaredMethod;
            }
            Method declaredMethod2 = f10917g.getDeclaredMethod("getZID", Context.class);
            if (declaredMethod2 != null) {
                f10919i = declaredMethod2;
            }
            Method declaredMethod3 = f10917g.getDeclaredMethod("getSDKVersion", new Class[0]);
            if (declaredMethod3 != null) {
                f10920j = declaredMethod3;
            }
        } catch (Throwable unused) {
        }
    }

    private void d() {
        bv a10 = bv.a(this.f10924e);
        bw a11 = a10.a(bx.f10120c);
        if (a11 != null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = a11.f10112a;
                String str2 = a11.f10113b;
                JSONObject a12 = new com.umeng.commonsdk.statistics.b().a(this.f10924e.getApplicationContext(), new JSONObject(a11.f10114c), new JSONObject(a11.f10115d), a11.f10116e, str2, a11.f10117f);
                if (a12 == null || !a12.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                }
                a10.a(bx.f10120c, str);
                a10.b();
            } catch (Throwable unused) {
            }
        }
    }

    private void e() {
        if (f10923m) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                return;
            }
            f10923m = false;
        } else if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            f10923m = true;
            a(this.f10924e, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.4
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
                    if (TextUtils.isEmpty(str)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = c.this.f10924e.getSharedPreferences(com.umeng.commonsdk.statistics.idtracking.i.f11098a, 0);
                        if (sharedPreferences != null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString(com.umeng.commonsdk.statistics.idtracking.i.f11099b, str);
                            edit.commit();
                        }
                    } catch (Throwable unused) {
                    }
                    UMWorkDispatch.sendEvent(c.this.f10924e, a.f10905w, b.a(c.this.f10924e).a(), null);
                }
            });
        }
    }

    private void f() {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            f10923m = true;
            UMConfigureImpl.registerInterruptFlag();
            UMConfigureImpl.init(this.f10924e);
            f10916f++;
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 要读取 oaid，需等待读取结果.");
            UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.internal.c.5
                @Override // com.umeng.commonsdk.utils.onMessageSendListener
                public void onMessageSend() {
                    if (c.this.f10924e != null) {
                        UMWorkDispatch.sendEvent(c.this.f10924e, a.f10906x, b.a(c.this.f10924e).a(), null);
                    }
                    UMConfigureImpl.removeMessageSendListener(this);
                }
            });
            a(this.f10924e, true);
        }
    }

    private void g() {
        if (f10916f <= 0) {
            h();
            e(this.f10924e);
        }
    }

    private void h() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        if (UMUtils.isMainProgress(this.f10924e)) {
            f(this.f10924e);
            UMInnerManager.sendInnerPackage(this.f10924e);
            if (!FieldManager.allow(com.umeng.commonsdk.utils.d.at) && SdkVersion.SDK_TYPE == 0 && UMUtils.isMainProgress(this.f10924e)) {
                Context context = this.f10924e;
                UMWorkDispatch.sendEvent(context, a.G, b.a(context).a(), null, 5000L);
            }
            Context context2 = this.f10924e;
            UMWorkDispatch.sendEvent(context2, q.a.f10546z, CoreProtocol.getInstance(context2), null);
            Context context3 = this.f10924e;
            UMWorkDispatch.sendEvent(context3, a.f10902t, b.a(context3).a(), null);
        }
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j10) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x02be A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:22:0x008d, B:24:0x0095, B:26:0x00a4, B:27:0x00a7, B:28:0x00b2, B:49:0x0114, B:53:0x0146, B:60:0x015e, B:62:0x017a, B:64:0x0180, B:65:0x0190, B:67:0x01bb, B:73:0x01c5, B:75:0x01c9, B:77:0x01dd, B:102:0x027a, B:104:0x0291, B:106:0x029c, B:109:0x02a3, B:111:0x02a9, B:113:0x02b4, B:117:0x02be, B:119:0x02c4, B:121:0x02d0, B:123:0x02d7), top: B:19:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02d7 A[Catch: all -> 0x0432, TRY_LEAVE, TryCatch #0 {all -> 0x0432, blocks: (B:22:0x008d, B:24:0x0095, B:26:0x00a4, B:27:0x00a7, B:28:0x00b2, B:49:0x0114, B:53:0x0146, B:60:0x015e, B:62:0x017a, B:64:0x0180, B:65:0x0190, B:67:0x01bb, B:73:0x01c5, B:75:0x01c9, B:77:0x01dd, B:102:0x027a, B:104:0x0291, B:106:0x029c, B:109:0x02a3, B:111:0x02a9, B:113:0x02b4, B:117:0x02be, B:119:0x02c4, B:121:0x02d0, B:123:0x02d7), top: B:19:0x007b }] */
    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void workEvent(java.lang.Object r13, int r14) {
        /*
            Method dump skipped, instructions count: 1154
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.workEvent(java.lang.Object, int):void");
    }

    public String a() {
        Method method;
        if (!TextUtils.isEmpty(f10921k)) {
            return f10921k;
        }
        Class<?> cls = f10917g;
        if (cls == null || (method = f10918h) == null || f10919i == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            if (invoke == null) {
                return "";
            }
            String str = (String) f10919i.invoke(invoke, this.f10924e);
            try {
                f10921k = str;
            } catch (Throwable unused) {
            }
            return str;
        } catch (Throwable unused2) {
            return "";
        }
    }

    private void b(Context context) {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(context, bt.f10046g, "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(bt.f10046g), imprintProperty);
            JSONObject buildSilentEnvelopeWithExtHeader = UMEnvelopeBuild.buildSilentEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.SILENT_HEART_BEAT);
            if (buildSilentEnvelopeWithExtHeader != null && buildSilentEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文失败.");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文 成功!!!");
            }
        } catch (Throwable unused) {
        }
    }

    private void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("os"), "Android");
            JSONObject buildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (buildZeroEnvelopeWithExtHeader != null && buildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
            }
        } catch (Throwable unused) {
        }
    }

    private void e(Context context) {
        Object invoke;
        Method declaredMethod;
        Context applicationContext = context.getApplicationContext();
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> a10 = a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = a10.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(a10, new Object[0])) == null || (declaredMethod = a10.getDeclaredMethod("init", Context.class, String.class, a("com.umeng.umzid.IZIDCompletionCallback"))) == null) {
                return;
            }
            declaredMethod.invoke(invoke, applicationContext, appkey, null);
        } catch (Throwable unused) {
        }
    }

    private static void c(final Context context) {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            a(context, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.3
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = context.getSharedPreferences(com.umeng.commonsdk.statistics.idtracking.i.f11098a, 0);
                        if (sharedPreferences == null || sharedPreferences.getString(com.umeng.commonsdk.statistics.idtracking.i.f11099b, "").equalsIgnoreCase(str)) {
                            return;
                        }
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(com.umeng.commonsdk.statistics.idtracking.i.f11099b, str);
                        edit.commit();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private static void f(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + bx.f10129l);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    public static void a(final Context context, final boolean z10) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(com.umeng.commonsdk.statistics.idtracking.i.f11098a, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    String a10 = bf.a(context);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(a10) && sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(com.umeng.commonsdk.statistics.idtracking.i.f11100c, (currentTimeMillis2 - currentTimeMillis) + "");
                        edit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.putString(com.umeng.commonsdk.statistics.idtracking.i.f11099b, a10);
                        edit2.commit();
                    }
                    if (DeviceConfig.isHonorDevice() && sharedPreferences != null) {
                        SharedPreferences.Editor edit3 = sharedPreferences.edit();
                        edit3.putString(com.umeng.commonsdk.statistics.idtracking.c.f11075b, a10);
                        edit3.commit();
                    }
                    if (z10) {
                        UMConfigureImpl.removeInterruptFlag();
                    }
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d(android.content.Context r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L3
            return
        L3:
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            java.lang.String r1 = "debugkey"
            java.lang.String r2 = com.umeng.common.b.a(r11, r0, r1)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L92
            java.lang.String r3 = "startTime"
            java.lang.String r3 = com.umeng.common.b.a(r11, r0, r3)
            java.lang.String r4 = "period"
            java.lang.String r0 = com.umeng.common.b.a(r11, r0, r4)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 0
            if (r4 != 0) goto L2f
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L2e
            long r3 = r3.longValue()     // Catch: java.lang.Throwable -> L2e
            goto L30
        L2e:
        L2f:
            r3 = r5
        L30:
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 != 0) goto L40
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> L3f
            long r7 = r0.longValue()     // Catch: java.lang.Throwable -> L3f
            goto L41
        L3f:
        L40:
            r7 = r5
        L41:
            java.lang.String r0 = "MobclickRT"
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 == 0) goto L88
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 != 0) goto L4c
            goto L88
        L4c:
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r3
            r3 = 60
            long r7 = r7 * r3
            r3 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r3
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 <= 0) goto L71
            java.lang.String r1 = "--->>> [RTD]本地缓存dk值已经超时，清除缓存数据。"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.b.a(r11, r0)
            boolean r11 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r11 == 0) goto L92
            com.umeng.analytics.AnalyticsConfig.turnOffRealTimeDebug()
            goto L92
        L71:
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            r11.put(r1, r2)
            boolean r1 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r1 != 0) goto L92
            java.lang.String r1 = "--->>> [RTD]本地缓存dk值在有效期内，切换到埋点验证模式。"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            com.umeng.analytics.AnalyticsConfig.turnOnRealTimeDebug(r11)
            goto L92
        L88:
            java.lang.String r1 = "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.b.a(r11, r0)
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.d(android.content.Context):void");
    }

    private static void a(Context context, final OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.2
            @Override // java.lang.Runnable
            public void run() {
                String a10 = bf.a(applicationContext);
                OnGetOaidListener onGetOaidListener2 = onGetOaidListener;
                if (onGetOaidListener2 != null) {
                    onGetOaidListener2.onGetOaid(a10);
                }
            }
        }).start();
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
