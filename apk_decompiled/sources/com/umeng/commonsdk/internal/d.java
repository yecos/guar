package com.umeng.commonsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.a;
import com.umeng.commonsdk.internal.utils.d;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class d {
    public static void a(Context context) {
        try {
            ULog.i("walle", "[internal] workEvent send envelope");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bt.aT, a.f10887e);
            JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, d(context), UMServerURL.PATH_ANALYTICS, bt.aI, a.f10887e);
            if (buildEnvelopeWithExtHeader == null || buildEnvelopeWithExtHeader.has("exception")) {
                return;
            }
            ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
        } catch (Exception e10) {
            UMCrashManager.reportCrash(context, e10);
        }
    }

    public static void b(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context != null) {
            i(context);
        }
    }

    public static void c(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context == null || !UMEnvelopeBuild.getTransmissionSendFlag()) {
            return;
        }
        i(context);
    }

    public static JSONObject d(Context context) {
        JSONObject b10;
        JSONArray g10;
        JSONObject a10;
        JSONArray k10;
        JSONArray j10;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.L) && (j10 = j(applicationContext)) != null && j10.length() > 0) {
                    jSONObject2.put("rs", j10);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(applicationContext, e10);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.aq) && (k10 = k(applicationContext)) != null && k10.length() > 0) {
                    jSONObject2.put("by", k10);
                }
            } catch (Exception e11) {
                UMCrashManager.reportCrash(applicationContext, e11);
            }
            try {
                a(applicationContext, jSONObject2);
            } catch (Exception e12) {
                UMCrashManager.reportCrash(applicationContext, e12);
            }
            try {
                b(applicationContext, jSONObject2);
            } catch (Exception e13) {
                UMCrashManager.reportCrash(applicationContext, e13);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.ar) && (a10 = a()) != null && a10.length() > 0) {
                    jSONObject2.put("build", a10);
                }
            } catch (Exception e14) {
                UMCrashManager.reportCrash(applicationContext, e14);
            }
            try {
                JSONObject e15 = e(applicationContext);
                if (e15 != null && e15.length() > 0) {
                    jSONObject2.put("scr", e15);
                }
            } catch (Exception e16) {
                UMCrashManager.reportCrash(applicationContext, e16);
            }
            try {
                JSONObject f10 = f(applicationContext);
                if (f10 != null && f10.length() > 0) {
                    jSONObject2.put("sinfo", f10);
                }
            } catch (Exception e17) {
                UMCrashManager.reportCrash(applicationContext, e17);
            }
            try {
                if (UMConfigure.shouldCollectApl()) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "shouldCollectApl switch is on.");
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.ai) && (g10 = g(applicationContext)) != null && g10.length() > 0) {
                        jSONObject2.put("appls", g10);
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "shouldCollectApl switch is off.");
                }
            } catch (Exception e18) {
                UMCrashManager.reportCrash(applicationContext, e18);
            }
            try {
                JSONObject h10 = h(applicationContext);
                if (h10 != null && h10.length() > 0) {
                    jSONObject2.put("mem", h10);
                }
            } catch (Exception e19) {
                UMCrashManager.reportCrash(applicationContext, e19);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.as) && (b10 = b()) != null && b10.length() > 0) {
                    jSONObject2.put(bt.f10062w, b10);
                }
            } catch (Exception unused) {
            }
            try {
                jSONObject.put(bt.aA, jSONObject2);
            } catch (JSONException e20) {
                UMCrashManager.reportCrash(applicationContext, e20);
            }
        }
        return jSONObject;
    }

    public static JSONObject e(Context context) {
        DisplayMetrics displayMetrics;
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", com.umeng.commonsdk.internal.utils.a.c(context));
                jSONObject.put("a_nav_h", com.umeng.commonsdk.internal.utils.a.d(context));
                if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
                    jSONObject.put("a_den", displayMetrics.density);
                    jSONObject.put("a_dpi", displayMetrics.densityDpi);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(context, e10);
            }
        }
        return jSONObject;
    }

    public static JSONObject f(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            String packageName = applicationContext.getPackageName();
            try {
                jSONObject.put("a_fit", com.umeng.commonsdk.internal.utils.a.a(applicationContext, packageName));
                jSONObject.put("a_alut", com.umeng.commonsdk.internal.utils.a.b(applicationContext, packageName));
                jSONObject.put("a_c", com.umeng.commonsdk.internal.utils.a.c(applicationContext, packageName));
                jSONObject.put("a_uid", com.umeng.commonsdk.internal.utils.a.d(applicationContext, packageName));
                if (com.umeng.commonsdk.internal.utils.a.a()) {
                    jSONObject.put("a_root", 1);
                } else {
                    jSONObject.put("a_root", 0);
                }
                jSONObject.put("tf", com.umeng.commonsdk.internal.utils.a.b());
                jSONObject.put("s_fs", com.umeng.commonsdk.internal.utils.a.a(applicationContext));
                jSONObject.put("a_meid", DeviceConfig.getMeid(applicationContext));
                jSONObject.put("a_imsi", DeviceConfig.getImsi(applicationContext));
                jSONObject.put("st", com.umeng.commonsdk.internal.utils.a.c());
                String simICCID = DeviceConfig.getSimICCID(applicationContext);
                if (!TextUtils.isEmpty(simICCID)) {
                    try {
                        jSONObject.put("a_iccid", simICCID);
                    } catch (Exception unused) {
                    }
                }
                String secondSimIMEi = DeviceConfig.getSecondSimIMEi(applicationContext);
                if (!TextUtils.isEmpty(secondSimIMEi)) {
                    try {
                        jSONObject.put("a_simei", secondSimIMEi);
                    } catch (Exception unused2) {
                    }
                }
                jSONObject.put("hn", com.umeng.commonsdk.internal.utils.a.d());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e10) {
                UMCrashManager.reportCrash(applicationContext, e10);
            }
        }
        return jSONObject;
    }

    public static JSONArray g(Context context) {
        Context applicationContext;
        List<a.C0178a> f10;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (f10 = com.umeng.commonsdk.internal.utils.a.f((applicationContext = context.getApplicationContext()))) != null && !f10.isEmpty()) {
            for (a.C0178a c0178a : f10) {
                if (c0178a != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a_pn", c0178a.f10933a);
                        jSONObject.put("a_la", c0178a.f10934b);
                        jSONObject.put("ts", System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                    } catch (Exception e10) {
                        UMCrashManager.reportCrash(applicationContext, e10);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject h(Context context) {
        Context applicationContext;
        ActivityManager.MemoryInfo g10;
        JSONObject jSONObject = new JSONObject();
        if (context != null && (g10 = com.umeng.commonsdk.internal.utils.a.g((applicationContext = context.getApplicationContext()))) != null) {
            try {
                jSONObject.put("t", g10.totalMem);
                jSONObject.put(m7.f.f16828a, g10.availMem);
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e10) {
                UMCrashManager.reportCrash(applicationContext, e10);
            }
        }
        return jSONObject;
    }

    private static void i(Context context) {
        try {
            if (UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                UMWorkDispatch.sendEvent(context, 32769, b.a(context).a(), null, 5000L);
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 冷启动：5秒后触发2号数据仓遗留信封检查动作。");
            UMWorkDispatch.sendEvent(context, a.f10904v, b.a(context).a(), null, 5000L);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    private static JSONArray j(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        JSONArray jSONArray = null;
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
            if (activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null || runningServices.isEmpty()) {
                return null;
            }
            for (int i10 = 0; i10 < runningServices.size(); i10++) {
                if (runningServices.get(i10) != null && runningServices.get(i10).service != null && runningServices.get(i10).service.getClassName() != null && runningServices.get(i10).service.getPackageName() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("sn", runningServices.get(i10).service.getClassName().toString());
                        jSONObject.put("pn", runningServices.get(i10).service.getPackageName().toString());
                        if (jSONArray == null) {
                            jSONArray = new JSONArray();
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
            }
            if (jSONArray == null) {
                return jSONArray;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject2.put("ls", jSONArray);
            } catch (JSONException unused2) {
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("sers", jSONObject2);
            } catch (JSONException unused3) {
            }
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONArray2.put(jSONObject3);
                return jSONArray2;
            } catch (Throwable th) {
                th = th;
                jSONArray = jSONArray2;
                UMCrashManager.reportCrash(context, th);
                return jSONArray;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static JSONArray k(Context context) {
        JSONArray jSONArray = new JSONArray();
        String a10 = com.umeng.commonsdk.internal.utils.j.a(context);
        if (!TextUtils.isEmpty(a10)) {
            try {
                jSONArray.put(new JSONObject(a10));
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    private static JSONObject b() {
        try {
            d.a a10 = com.umeng.commonsdk.internal.utils.d.a();
            if (a10 == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pro", a10.f10947a);
                jSONObject.put("pla", a10.f10948b);
                jSONObject.put("cpus", a10.f10949c);
                jSONObject.put("fea", a10.f10950d);
                jSONObject.put(bd.f9976c, a10.f10951e);
                jSONObject.put("arc", a10.f10952f);
                jSONObject.put("var", a10.f10953g);
                jSONObject.put("par", a10.f10954h);
                jSONObject.put("rev", a10.f10955i);
                jSONObject.put("har", a10.f10956j);
                jSONObject.put("rev", a10.f10957k);
                jSONObject.put("ser", a10.f10958l);
                jSONObject.put("cur_cpu", com.umeng.commonsdk.internal.utils.d.d());
                jSONObject.put("max_cpu", com.umeng.commonsdk.internal.utils.d.b());
                jSONObject.put("min_cpu", com.umeng.commonsdk.internal.utils.d.c());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getApplicationContext().getPackageManager()) == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        a(jSONObject, "gp", packageManager.hasSystemFeature("android.hardware.location.gps"));
        a(jSONObject, "to", packageManager.hasSystemFeature("android.hardware.touchscreen"));
        a(jSONObject, "mo", packageManager.hasSystemFeature("android.hardware.telephony"));
        a(jSONObject, "ca", packageManager.hasSystemFeature("android.hardware.camera"));
        a(jSONObject, "fl", packageManager.hasSystemFeature("android.hardware.camera.flash"));
    }

    private static void a(JSONObject jSONObject, String str, boolean z10) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (z10) {
                jSONObject.put(str, 1);
            } else {
                jSONObject.put(str, 0);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:17:0x006b */
    /* JADX WARN: Incorrect condition in loop: B:27:0x0092 */
    /* JADX WARN: Incorrect condition in loop: B:7:0x0043 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject a() {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.d.a():org.json.JSONObject");
    }

    private static void b(Context context, JSONObject jSONObject) {
        if (context != null) {
            String a10 = k.a(context);
            if (TextUtils.isEmpty(a10)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(a10);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                if (jSONObject2.has(k.f10970d)) {
                    jSONObject.put(k.f10970d, jSONObject2.opt(k.f10970d));
                }
                if (jSONObject2.has(k.f10969c)) {
                    jSONObject.put(k.f10969c, jSONObject2.opt(k.f10969c));
                }
                if (jSONObject2.has(k.f10968b)) {
                    jSONObject.put(k.f10968b, jSONObject2.opt(k.f10968b));
                }
            } catch (Exception unused) {
            }
        }
    }
}
