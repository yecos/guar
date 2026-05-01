package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.pro.q;
import com.umeng.ccg.CcgAgent;
import com.umeng.ccg.ConfigListener;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.UMInnerManager;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.SelfChecker;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.InfoPreferenceAgent;
import com.umeng.commonsdk.internal.utils.UMInternalUtilsAgent;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import com.umeng.commonsdk.vchannel.Sender;
import com.umeng.umzid.ZIDManager;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
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
    */
    public void workEvent(Object obj, int i10) {
        SharedPreferences.Editor edit;
        boolean z10 = true;
        boolean z11 = false;
        ULog.i("walle", "[internal] workEvent");
        if (com.umeng.commonsdk.utils.c.a()) {
            if (32802 == i10) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 静默模式：进入心跳处理逻辑!");
                long currentTimeMillis = System.currentTimeMillis();
                long b10 = com.umeng.commonsdk.utils.c.b(this.f10924e);
                boolean e10 = com.umeng.commonsdk.utils.c.e(this.f10924e);
                if (com.umeng.commonsdk.utils.c.a(b10, currentTimeMillis, com.umeng.commonsdk.utils.c.a(this.f10924e))) {
                    if (UMFrUtils.hasEnvelopeFile(this.f10924e, UMLogDataProtocol.UMBusinessType.U_Silent)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 静默心跳信封文件已存在，尝试发送之!");
                    } else {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建静默心跳信封.");
                        b(this.f10924e);
                    }
                    UMEnvelopeBuild.registerNetReceiver(this.f10924e);
                }
                if (e10) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send REBUILD_DB msg in silent mode.");
                Context context = this.f10924e;
                UMWorkDispatch.sendEvent(context, q.a.f10536p, CoreProtocol.getInstance(context), null, 2000L);
            }
            return;
        }
        try {
            switch (i10) {
                case 32769:
                    ULog.i("walle", "[internal] workEvent send envelope");
                    UMInternalManagerAgent.class.getMethod("sendInternalEnvelopeByStateful2", Context.class).invoke(UMInternalManagerAgent.class, this.f10924e);
                    break;
                case a.f10890h /* 32771 */:
                    if (obj != null && (obj instanceof com.umeng.commonsdk.internal.utils.b)) {
                        JSONObject jSONObject = new JSONObject();
                        com.umeng.commonsdk.internal.utils.b bVar = (com.umeng.commonsdk.internal.utils.b) obj;
                        try {
                            jSONObject.put("le", bVar.f10935a);
                            jSONObject.put("vol", bVar.f10936b);
                            jSONObject.put("temp", bVar.f10937c);
                            jSONObject.put("st", bVar.f10938d);
                            jSONObject.put(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_CT, bVar.f10939e);
                            jSONObject.put("ts", bVar.f10940f);
                        } catch (Throwable unused) {
                        }
                        String jSONObject2 = jSONObject.toString();
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "battery info: " + jSONObject2);
                        UMInternalUtilsAgent.class.getMethod("saveBattery", Context.class, String.class).invoke(UMInternalUtilsAgent.class, this.f10924e, jSONObject2);
                        break;
                    }
                    break;
                case a.f10894l /* 32775 */:
                    InfoPreferenceAgent.class.getMethod("saveUA", Context.class, String.class).invoke(InfoPreferenceAgent.class, this.f10924e, (String) obj);
                    break;
                case a.f10896n /* 32777 */:
                    ULog.i("walle", "[internal] workEvent send envelope");
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(bt.aT, a.f10887e);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(bt.aA, new JSONObject());
                    JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(this.f10924e, jSONObject3, jSONObject4);
                    if (buildEnvelopeWithExtHeader != null && !buildEnvelopeWithExtHeader.has("exception")) {
                        ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
                        break;
                    }
                    break;
                case a.f10897o /* 32779 */:
                    Sender.handleEvent(this.f10924e, (com.umeng.commonsdk.vchannel.b) obj);
                    break;
                case a.f10898p /* 32781 */:
                    if (!UMFrUtils.hasEnvelopeFile(this.f10924e, UMLogDataProtocol.UMBusinessType.U_ZeroEnv)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文");
                        a(this.f10924e);
                        break;
                    } else {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文信封文件已存在，尝试发送之!");
                        break;
                    }
                case a.f10901s /* 32784 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文流程，接收到云控配置加载成功通知(成功收到零号报文应答)。");
                    f();
                    f10916f--;
                    g();
                    UMUtils.saveSDKComponent();
                    break;
                case a.f10902t /* 32785 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]接收到消费二级缓存数据通知.");
                    if (!bv.a(this.f10924e).c()) {
                        d();
                        if (!UMWorkDispatch.eventHasExist(a.f10902t)) {
                            Context context2 = this.f10924e;
                            UMWorkDispatch.sendEvent(context2, a.f10902t, b.a(context2).a(), null);
                            break;
                        }
                    } else {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]已消费完毕,二级缓存数据库为空.");
                        break;
                    }
                    break;
                case a.f10903u /* 32786 */:
                    UMCrashManager.buildEnvelope(this.f10924e, obj);
                    break;
                case a.f10904v /* 32787 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查动作。");
                    String a10 = com.umeng.commonsdk.stateless.d.a(this.f10924e, false);
                    String a11 = com.umeng.commonsdk.stateless.d.a(this.f10924e, true);
                    if (!TextUtils.isEmpty(a10)) {
                        File file = new File(a10);
                        if (file.exists() && file.isDirectory()) {
                            z11 = true;
                        }
                    }
                    if (!TextUtils.isEmpty(a11)) {
                        File file2 = new File(a11);
                        if (file2.exists() && file2.isDirectory()) {
                            if (!z10) {
                                if (!com.umeng.commonsdk.stateless.b.a()) {
                                    new com.umeng.commonsdk.stateless.b(this.f10924e);
                                    com.umeng.commonsdk.stateless.b.b();
                                    break;
                                } else {
                                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查，Sender已创建，不需要处理。");
                                    break;
                                }
                            } else {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查，没有需要处理的目录，不需要处理。");
                                break;
                            }
                        }
                    }
                    z10 = z11;
                    if (!z10) {
                    }
                    break;
                case a.f10905w /* 32788 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新，触发 伪冷启动。");
                    com.umeng.commonsdk.statistics.b.a();
                    e();
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.E) && !UMWorkDispatch.eventHasExist()) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新 前台计数器功能 打开，触发 5秒周期检查机制");
                        Context context3 = this.f10924e;
                        UMWorkDispatch.sendEventEx(context3, q.a.E, CoreProtocol.getInstance(context3), null, 5000L);
                    }
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新 FirstResume功能 打开，触发 trigger");
                        n.a(this.f10924e).b(this.f10924e);
                        break;
                    }
                    break;
                case a.f10906x /* 32790 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 成功接收到(OAID)读取结束通知。");
                    f10916f--;
                    g();
                    break;
                case a.f10907y /* 32791 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 正常冷启动流程，接收到云控配置加载成功通知。");
                    UMInnerManager.sendInnerPackage(this.f10924e);
                    if (!FieldManager.allow(com.umeng.commonsdk.utils.d.at) && SdkVersion.SDK_TYPE == 0 && UMUtils.isMainProgress(this.f10924e)) {
                        Context context4 = this.f10924e;
                        UMWorkDispatch.sendEvent(context4, a.G, b.a(context4).a(), null, 5000L);
                    }
                    e(this.f10924e);
                    UMUtils.saveSDKComponent();
                    break;
                case a.f10908z /* 32792 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 保存隐私授权结果.");
                    if (obj instanceof Integer) {
                        int intValue = ((Integer) obj).intValue();
                        SharedPreferences sharedPreferences = this.f10924e.getApplicationContext().getSharedPreferences(f10912a, 0);
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().putInt("policyGrantResult", intValue).commit();
                            break;
                        }
                    }
                    break;
                case a.A /* 32793 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 保存preInit执行结果及授权API是否调用结果.");
                    if (obj instanceof JSONObject) {
                        JSONObject jSONObject5 = (JSONObject) obj;
                        if (jSONObject5.has(a.J)) {
                            int i11 = jSONObject5.getInt(a.J);
                            int i12 = jSONObject5.getInt(a.K);
                            int i13 = jSONObject5.getInt("policyGrantResult");
                            SharedPreferences sharedPreferences2 = this.f10924e.getApplicationContext().getSharedPreferences(f10912a, 0);
                            if (sharedPreferences2 != null && (edit = sharedPreferences2.edit()) != null) {
                                edit.putInt(f10913b, i11);
                                edit.putInt(f10914c, i12);
                                edit.putInt("policyGrantResult", i13);
                                edit.commit();
                            }
                            File file3 = new File(this.f10924e.getFilesDir().getAbsolutePath() + File.separator + bx.f10130m);
                            if (!file3.exists()) {
                                file3.createNewFile();
                                break;
                            }
                        }
                    }
                    break;
                case a.B /* 32800 */:
                    File file4 = new File(this.f10924e.getFilesDir().getAbsolutePath() + File.separator + bx.f10130m);
                    if (file4.exists()) {
                        file4.delete();
                        break;
                    }
                    break;
                case a.C /* 32801 */:
                    SelfChecker.doCheck(this.f10924e);
                    break;
                case a.E /* 32803 */:
                    ConnectivityManager connectivityManager = (ConnectivityManager) this.f10924e.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> ConnectivityManager is null!");
                        com.umeng.commonsdk.framework.a.a(false);
                        com.umeng.commonsdk.stateless.b.a(false);
                        break;
                    } else {
                        try {
                            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                            if (activeNetworkInfo == null) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> NetworkInfo is null!");
                                com.umeng.commonsdk.framework.a.a(false);
                                com.umeng.commonsdk.stateless.b.a(false);
                            } else if (activeNetworkInfo.isAvailable()) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network state changed: Available");
                                com.umeng.commonsdk.framework.a.a(true);
                                com.umeng.commonsdk.stateless.b.a(true);
                            } else {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network state changed: unAvailable");
                                com.umeng.commonsdk.framework.a.a(false);
                                com.umeng.commonsdk.stateless.b.a(false);
                            }
                            break;
                        } catch (Throwable unused2) {
                            com.umeng.commonsdk.framework.a.a(false);
                            com.umeng.commonsdk.stateless.b.a(false);
                            return;
                        }
                    }
                case a.F /* 32804 */:
                    d(this.f10924e);
                    break;
                case a.G /* 32805 */:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv CLOUD_CONFIG_TRIGGER msg.");
                    CcgAgent.registerConfigListener(new ConfigListener() { // from class: com.umeng.commonsdk.internal.c.6
                        @Override // com.umeng.ccg.ConfigListener
                        public void onConfigReady(JSONObject jSONObject6) {
                            if (jSONObject6 == null) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "onConfigReady: empty config!");
                                return;
                            }
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "onConfigReady:" + jSONObject6.toString());
                            com.umeng.ccg.c.a(c.this.f10924e, 201, com.umeng.ccg.d.a(), jSONObject6);
                        }
                    });
                    SharedPreferences a12 = au.a(this.f10924e);
                    if (a12 != null) {
                        long j10 = a12.getLong(au.f9913a, 0L);
                        if (j10 < Long.MAX_VALUE) {
                            j10++;
                        }
                        a12.edit().putLong(au.f9913a, j10).commit();
                    }
                    CcgAgent.init(this.f10924e);
                    break;
            }
        } catch (Throwable unused3) {
        }
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
    */
    private void d(Context context) {
        long longValue;
        long longValue2;
        if (context == null) {
            return;
        }
        String str = AnalyticsConfig.RTD_SP_FILE;
        String a10 = com.umeng.common.b.a(context, str, "debugkey");
        if (TextUtils.isEmpty(a10)) {
            return;
        }
        String a11 = com.umeng.common.b.a(context, str, AnalyticsConfig.RTD_START_TIME);
        String a12 = com.umeng.common.b.a(context, str, "period");
        if (!TextUtils.isEmpty(a11)) {
            try {
                longValue = Long.valueOf(a11).longValue();
            } catch (Throwable unused) {
            }
            if (!TextUtils.isEmpty(a12)) {
                try {
                    longValue2 = Long.valueOf(a12).longValue();
                } catch (Throwable unused2) {
                }
                if (longValue != 0 || longValue2 == 0) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据");
                    com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE);
                }
                if (System.currentTimeMillis() - longValue > longValue2 * 60 * 1000) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存dk值已经超时，清除缓存数据。");
                    com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE);
                    if (AnalyticsConfig.isRealTimeDebugMode()) {
                        AnalyticsConfig.turnOffRealTimeDebug();
                        return;
                    }
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("debugkey", a10);
                if (AnalyticsConfig.isRealTimeDebugMode()) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存dk值在有效期内，切换到埋点验证模式。");
                AnalyticsConfig.turnOnRealTimeDebug(hashMap);
                return;
            }
            longValue2 = 0;
            if (longValue != 0) {
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据");
            com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE);
        }
        longValue = 0;
        if (!TextUtils.isEmpty(a12)) {
        }
        longValue2 = 0;
        if (longValue != 0) {
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据");
        com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE);
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
