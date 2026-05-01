package com.efs.sdk.launch;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static long f6287a;

    /* renamed from: b, reason: collision with root package name */
    private static long f6288b;

    /* renamed from: c, reason: collision with root package name */
    private static long f6289c;

    /* renamed from: d, reason: collision with root package name */
    private static long f6290d;

    /* renamed from: e, reason: collision with root package name */
    private static long f6291e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f6292f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f6293g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f6294h;

    /* renamed from: i, reason: collision with root package name */
    private static long f6295i;

    /* renamed from: j, reason: collision with root package name */
    private static long f6296j;

    /* renamed from: k, reason: collision with root package name */
    private static int f6297k;

    /* renamed from: l, reason: collision with root package name */
    private static List<EfsJSONLog> f6298l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private static Map<String, Long[]> f6299m = new HashMap();

    public static void a(Activity activity, String str, boolean z10) {
        long currentTimeMillis;
        Context applicationContext;
        String name;
        int i10;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        if (TextUtils.equals(str, LaunchManager.PAGE_ON_CREATE)) {
            if (z10) {
                boolean z11 = LaunchManager.isDebug;
                f6290d = System.currentTimeMillis();
                return;
            }
            return;
        }
        if (TextUtils.equals(str, LaunchManager.PAGE_ON_RE_START)) {
            if (z10 && f6297k == 0) {
                boolean z12 = LaunchManager.isDebug;
                f6291e = System.currentTimeMillis();
                f6293g = true;
                return;
            }
            return;
        }
        if (TextUtils.equals(str, LaunchManager.PAGE_ON_START)) {
            if (z10) {
                boolean z13 = LaunchManager.isDebug;
                f6297k++;
                f6294h = true;
                return;
            }
            return;
        }
        if (!TextUtils.equals(str, LaunchManager.PAGE_ON_RESUME)) {
            if (TextUtils.equals(str, LaunchManager.PAGE_ON_STOP) && z10) {
                boolean z14 = LaunchManager.isDebug;
                f6297k--;
                return;
            }
            return;
        }
        if (z10) {
            return;
        }
        boolean z15 = LaunchManager.isDebug;
        if (f6292f) {
            f6292f = false;
            long currentTimeMillis2 = System.currentTimeMillis();
            long j19 = currentTimeMillis2 - f6289c;
            if (LaunchManager.isDebug) {
                "loadTime is ".concat(String.valueOf(j19));
            }
            long j20 = currentTimeMillis2 - f6287a;
            if (LaunchManager.isDebug) {
                "======>>>>>> coldTime is ".concat(String.valueOf(j20));
            }
            int i11 = !c.d(activity.getApplicationContext()) ? 1 : 0;
            if (LaunchManager.isDebug) {
                "type is ".concat(String.valueOf(i11));
            }
            a(activity.getApplicationContext(), i11, activity.getClass().getName(), j20, f6287a, f6288b, f6295i, f6289c, f6296j, currentTimeMillis2, j19, 0L, 0L, f6299m);
        } else if (f6297k == 1) {
            if (f6293g) {
                f6293g = false;
                j18 = System.currentTimeMillis() - f6291e;
                if (LaunchManager.isDebug) {
                    "======>>>>>> hotTime is ".concat(String.valueOf(j18));
                }
                applicationContext = activity.getApplicationContext();
                name = activity.getClass().getName();
                i10 = 2;
                j10 = 0;
                j11 = 0;
                j12 = 0;
                j13 = 0;
                j14 = 0;
                j15 = 0;
                j16 = 0;
                j17 = 0;
                currentTimeMillis = 0;
            } else if (f6294h) {
                currentTimeMillis = System.currentTimeMillis() - f6290d;
                if (LaunchManager.isDebug) {
                    "======>>>>>> warmTime is ".concat(String.valueOf(currentTimeMillis));
                }
                applicationContext = activity.getApplicationContext();
                name = activity.getClass().getName();
                i10 = 3;
                j10 = 0;
                j11 = 0;
                j12 = 0;
                j13 = 0;
                j14 = 0;
                j15 = 0;
                j16 = 0;
                j17 = 0;
                j18 = 0;
            }
            a(applicationContext, i10, name, j10, j11, j12, j13, j14, j15, j16, j17, j18, currentTimeMillis, f6299m);
        }
        f6294h = false;
    }

    public static void b(String str, long j10) {
        Map<String, Long[]> map = f6299m;
        if (map == null || !map.containsKey(str)) {
            if (LaunchManager.isDebug) {
                Log.e("LaunchTrace", "--->>> method name non-existent or over quantity !");
            }
        } else {
            Long[] lArr = f6299m.get(str);
            lArr[1] = Long.valueOf(j10);
            f6299m.put(str, lArr);
        }
    }

    private static void a(Context context, int i10, String str, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, Map<String, Long[]> map) {
        String str2;
        String str3;
        int i11;
        List<EfsJSONLog> list;
        StringBuilder sb;
        String generateString;
        JSONArray jSONArray;
        Long valueOf;
        if (!LaunchManager.isInit()) {
            if (i10 == 0) {
                boolean z10 = LaunchManager.isDebug;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("w_type", i10);
                    jSONObject.put("w_url", str);
                    jSONObject.put("l_version", "0.0.7.umeng");
                    jSONObject.put("wl_avgv", j10);
                    jSONObject.put("wd_init", j11);
                    jSONObject.put("wd_inittm", j12);
                    jSONObject.put("wl_init", j13);
                    jSONObject.put("wd_build", j12);
                    jSONObject.put("wd_buildtm", j14);
                    jSONObject.put("wl_build", j15);
                    jSONObject.put("wd_page", j14);
                    jSONObject.put("wd_pagetm", j16);
                    jSONObject.put("wl_page", j17);
                    if (map != null && !map.isEmpty()) {
                        JSONObject jSONObject2 = new JSONObject();
                        for (Map.Entry<String, Long[]> entry : map.entrySet()) {
                            String key = entry.getKey();
                            Long[] value = entry.getValue();
                            if (key != null && value != null) {
                                try {
                                    JSONArray jSONArray2 = new JSONArray();
                                    jSONArray2.put(value[0]);
                                    jSONArray2.put(value[1]);
                                    jSONObject2.put(key, jSONArray2);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        jSONObject.put("userExtra", jSONObject2);
                    }
                    c.a(context, jSONObject.toString());
                    if (LaunchManager.isDebug) {
                        new StringBuilder("no init, cache first launch, content is ").append(jSONObject.toString());
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            if (LaunchManager.isDebug) {
                str2 = "wl_page";
                str3 = "wd_pagetm";
                "no init, cache launch, type is ".concat(String.valueOf(i10));
            } else {
                str2 = "wl_page";
                str3 = "wd_pagetm";
            }
            EfsJSONLog efsJSONLog = new EfsJSONLog(Constants.LOG_TYPE_STARTPERF);
            efsJSONLog.put("w_type", Integer.valueOf(i10));
            efsJSONLog.put("w_url", str);
            efsJSONLog.put("l_version", "0.0.7.umeng");
            if (i10 == 1) {
                efsJSONLog.put("wl_avgv", Long.valueOf(j10));
                efsJSONLog.put("wd_init", Long.valueOf(j11));
                efsJSONLog.put("wd_inittm", Long.valueOf(j12));
                efsJSONLog.put("wl_init", Long.valueOf(j13));
                efsJSONLog.put("wd_build", Long.valueOf(j12));
                efsJSONLog.put("wd_buildtm", Long.valueOf(j14));
                efsJSONLog.put("wl_build", Long.valueOf(j15));
                efsJSONLog.put("wd_page", Long.valueOf(j14));
                efsJSONLog.put(str3, Long.valueOf(j16));
                efsJSONLog.put(str2, Long.valueOf(j17));
                if (map != null && !map.isEmpty()) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (Map.Entry<String, Long[]> entry2 : map.entrySet()) {
                        String key2 = entry2.getKey();
                        Long[] value2 = entry2.getValue();
                        if (key2 != null && value2 != null) {
                            try {
                                jSONArray = new JSONArray();
                            } catch (Throwable unused2) {
                            }
                            try {
                                jSONArray.put(value2[0]);
                            } catch (Throwable unused3) {
                            }
                            try {
                                jSONArray.put(value2[1]);
                                jSONObject3.put(key2, jSONArray);
                            } catch (Throwable unused4) {
                            }
                        }
                    }
                    efsJSONLog.put("userExtra", jSONObject3);
                }
            } else if (i10 == 2) {
                efsJSONLog.put("wl_avgv", Long.valueOf(j18));
            } else {
                i11 = 3;
                if (i10 == 3) {
                    efsJSONLog.put("wl_avgv", Long.valueOf(j19));
                }
                list = f6298l;
                if (list != null || list.size() >= i11) {
                    boolean z11 = LaunchManager.isDebug;
                    return;
                }
                f6298l.add(efsJSONLog);
                if (!LaunchManager.isDebug) {
                    return;
                }
                sb = new StringBuilder("cache launch report --->>> ");
                generateString = efsJSONLog.generateString();
            }
            i11 = 3;
            list = f6298l;
            if (list != null) {
            }
            boolean z112 = LaunchManager.isDebug;
            return;
        }
        LaunchConfigManager launchConfigManager = LaunchManager.getLaunchConfigManager();
        if ((launchConfigManager == null || !launchConfigManager.enableTracer()) && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            boolean z12 = LaunchManager.isDebug;
            return;
        }
        EfsJSONLog efsJSONLog2 = new EfsJSONLog(Constants.LOG_TYPE_STARTPERF);
        efsJSONLog2.put("w_type", Integer.valueOf(i10));
        efsJSONLog2.put("w_url", str);
        efsJSONLog2.put("l_version", "0.0.7.umeng");
        if (i10 == 0 || i10 == 1) {
            efsJSONLog2.put("wl_avgv", Long.valueOf(j10));
            efsJSONLog2.put("wd_init", Long.valueOf(j11));
            efsJSONLog2.put("wd_inittm", Long.valueOf(j12));
            efsJSONLog2.put("wl_init", Long.valueOf(j13));
            efsJSONLog2.put("wd_build", Long.valueOf(j12));
            efsJSONLog2.put("wd_buildtm", Long.valueOf(j14));
            efsJSONLog2.put("wl_build", Long.valueOf(j15));
            efsJSONLog2.put("wd_page", Long.valueOf(j14));
            efsJSONLog2.put("wd_pagetm", Long.valueOf(j16));
            efsJSONLog2.put("wl_page", Long.valueOf(j17));
            if (map != null && !map.isEmpty()) {
                JSONObject jSONObject4 = new JSONObject();
                for (Map.Entry<String, Long[]> entry3 : map.entrySet()) {
                    String key3 = entry3.getKey();
                    Long[] value3 = entry3.getValue();
                    if (key3 != null && value3 != null) {
                        try {
                            JSONArray jSONArray3 = new JSONArray();
                            jSONArray3.put(value3[0]);
                            jSONArray3.put(value3[1]);
                            jSONObject4.put(key3, jSONArray3);
                        } catch (Throwable unused5) {
                        }
                    }
                }
                efsJSONLog2.put("userExtra", jSONObject4);
            }
        } else {
            if (i10 == 2) {
                valueOf = Long.valueOf(j18);
            } else if (i10 == 3) {
                valueOf = Long.valueOf(j19);
            }
            efsJSONLog2.put("wl_avgv", valueOf);
        }
        String a10 = c.a(context);
        if (LaunchManager.isDebug) {
            "umid is ".concat(String.valueOf(a10));
        }
        if (a10 != null && !TextUtils.isEmpty(a10)) {
            if (LaunchManager.isDebug) {
                new StringBuilder("send current launch report --->>> ").append(efsJSONLog2.generateString());
            }
            EfsReporter reporter = LaunchManager.getReporter();
            if (reporter != null) {
                reporter.send(efsJSONLog2);
                return;
            }
            return;
        }
        List<EfsJSONLog> list2 = f6298l;
        if (list2 == null || list2.size() >= 3) {
            boolean z13 = LaunchManager.isDebug;
            return;
        }
        f6298l.add(efsJSONLog2);
        if (!LaunchManager.isDebug) {
            return;
        }
        sb = new StringBuilder("cache launch report --->>> ");
        generateString = efsJSONLog2.generateString();
        sb.append(generateString);
    }

    public static void a(Context context, String str) {
        boolean z10 = LaunchManager.isDebug;
        if (str == null || TextUtils.isEmpty(str)) {
            str = c.a(context);
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(UMCrash.KEY_HEADER_UMID, str);
        if (LaunchManager.getReporter() != null) {
            LaunchManager.getReporter().addPublicParams(hashMap);
        }
        String b10 = c.b(context);
        if (b10 != null && !TextUtils.isEmpty(b10)) {
            try {
                JSONObject jSONObject = new JSONObject(b10);
                jSONObject.put(UMCrash.KEY_HEADER_UMID, str);
                if (a(jSONObject)) {
                    c.c(context);
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        List<EfsJSONLog> list = f6298l;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (EfsJSONLog efsJSONLog : f6298l) {
            if (efsJSONLog != null) {
                if (LaunchManager.isDebug) {
                    new StringBuilder("send cache launch report --->>> ").append(efsJSONLog.generateString());
                }
                EfsReporter reporter = LaunchManager.getReporter();
                if (reporter != null) {
                    reporter.send(efsJSONLog);
                }
            }
        }
        f6298l.clear();
        f6298l = null;
    }

    public static void a(String str, long j10) {
        Map<String, Long[]> map = f6299m;
        if (map == null || map.containsKey(str) || f6299m.size() >= 10) {
            if (LaunchManager.isDebug) {
                Log.e("LaunchTrace", "--->>> method name already exists or over quantity !");
            }
        } else {
            Long[] lArr = new Long[2];
            lArr[0] = Long.valueOf(j10);
            f6299m.put(str, lArr);
        }
    }

    public static void a(String str, boolean z10) {
        if (TextUtils.equals(str, LaunchManager.APP_CONSTRUCT)) {
            return;
        }
        if (!TextUtils.equals(str, LaunchManager.APP_ATTACH_BASE_CONTEXT)) {
            if (!TextUtils.equals(str, LaunchManager.APP_ON_CREATE) || z10) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            f6289c = currentTimeMillis;
            f6296j = currentTimeMillis - f6288b;
            if (LaunchManager.isDebug) {
                new StringBuilder("buildTime is ").append(f6296j);
                return;
            }
            return;
        }
        if (z10) {
            f6287a = System.currentTimeMillis();
            f6292f = true;
            return;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        f6288b = currentTimeMillis2;
        f6295i = currentTimeMillis2 - f6287a;
        if (LaunchManager.isDebug) {
            new StringBuilder("initTime is ").append(f6295i);
        }
    }

    private static boolean a(JSONObject jSONObject) {
        try {
            EfsJSONLog efsJSONLog = new EfsJSONLog(Constants.LOG_TYPE_STARTPERF);
            efsJSONLog.put("w_type", jSONObject.opt("w_type"));
            efsJSONLog.put("w_url", jSONObject.opt("w_url"));
            efsJSONLog.put("l_version", jSONObject.opt("l_version"));
            efsJSONLog.put("wl_avgv", jSONObject.opt("wl_avgv"));
            efsJSONLog.put("wd_init", jSONObject.opt("wd_init"));
            efsJSONLog.put("wd_inittm", jSONObject.opt("wd_inittm"));
            efsJSONLog.put("wl_init", jSONObject.opt("wl_init"));
            efsJSONLog.put("wd_build", jSONObject.opt("wd_build"));
            efsJSONLog.put("wd_buildtm", jSONObject.opt("wd_buildtm"));
            efsJSONLog.put("wl_build", jSONObject.opt("wl_build"));
            efsJSONLog.put("wd_page", jSONObject.opt("wd_page"));
            efsJSONLog.put("wd_pagetm", jSONObject.opt("wd_pagetm"));
            efsJSONLog.put("wl_page", jSONObject.opt("wl_page"));
            efsJSONLog.put("userExtra", jSONObject.opt("userExtra"));
            if (LaunchManager.isDebug) {
                new StringBuilder("send cache cold launch report --->>> ").append(efsJSONLog.generateString());
            }
            EfsReporter reporter = LaunchManager.getReporter();
            if (reporter == null) {
                return false;
            }
            reporter.send(efsJSONLog);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
