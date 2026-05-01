package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.cq;
import com.umeng.analytics.pro.f;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f11009a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f11010b = "";

    /* renamed from: c, reason: collision with root package name */
    private static final String f11011c = "EnvelopeManager";

    /* renamed from: d, reason: collision with root package name */
    private static final String f11012d = "debug.umeng.umTaskId";

    /* renamed from: e, reason: collision with root package name */
    private static final String f11013e = "debug.umeng.umCaseId";

    /* renamed from: f, reason: collision with root package name */
    private static final String f11014f = "empty";

    /* renamed from: g, reason: collision with root package name */
    private static String f11015g = "";

    /* renamed from: h, reason: collision with root package name */
    private static String f11016h = "";

    /* renamed from: i, reason: collision with root package name */
    private static String f11017i;

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, String> f11018j;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f11019l;

    /* renamed from: k, reason: collision with root package name */
    private int f11020k = 0;

    static {
        HashMap hashMap = new HashMap();
        f11018j = hashMap;
        hashMap.put("header", "#h");
        f11018j.put(bt.f10060u, "#sdt");
        f11018j.put(bt.Q, "#ac");
        f11018j.put("device_model", "#dm");
        f11018j.put(bt.f10046g, "#umid");
        f11018j.put("os", "os");
        f11018j.put("language", "#lang");
        f11018j.put(bt.ai, "#dt");
        f11018j.put(bt.f10065z, "#rl");
        f11018j.put(bt.H, "#dmf");
        f11018j.put(bt.J, "#dn");
        f11018j.put("platform_version", "#pv");
        f11018j.put("font_size_setting", "#fss");
        f11018j.put(bt.f10064y, "#ov");
        f11018j.put(bt.I, "#did");
        f11018j.put("platform_sdk_version", "#psv");
        f11018j.put(bt.F, "#db");
        f11018j.put("appkey", "#ak");
        f11018j.put(bt.Y, "#itr");
        f11018j.put("id_type", "#it");
        f11018j.put("uuid", "#ud");
        f11018j.put("device_id", "#dd");
        f11018j.put(bt.X, "#imp");
        f11018j.put("sdk_version", "#sv");
        f11018j.put("st", "#st");
        f11018j.put("analytics", "#a");
        f11018j.put(bt.f10054o, "#pkg");
        f11018j.put(bt.f10055p, "#sig");
        f11018j.put(bt.f10056q, "#sis1");
        f11018j.put(bt.f10057r, "#sis");
        f11018j.put("app_version", "#av");
        f11018j.put("version_code", "#vc");
        f11018j.put(bt.f10061v, "#imd");
        f11018j.put(bt.B, "#mnc");
        f11018j.put(bt.E, "#boa");
        f11018j.put(bt.G, "#mant");
        f11018j.put(bt.M, "#tz");
        f11018j.put(bt.O, "#ct");
        f11018j.put("carrier", "#car");
        f11018j.put(bt.f10058s, "#disn");
        f11018j.put(bt.T, "#nt");
        f11018j.put(bt.f10039b, "#cv");
        f11018j.put(bt.f10043d, "#mv");
        f11018j.put(bt.f10042c, "#cot");
        f11018j.put(bt.f10044e, "#mod");
        f11018j.put(bt.aj, "#al");
        f11018j.put("session_id", "#sid");
        f11018j.put(bt.S, "#ip");
        f11018j.put(bt.U, "#sre");
        f11018j.put(bt.V, "#fre");
        f11018j.put(bt.W, "#ret");
        f11018j.put("channel", "#chn");
        f11018j.put("wrapper_type", "#wt");
        f11018j.put("wrapper_version", "#wv");
        f11018j.put(bt.f10041bb, "#tsv");
        f11018j.put(bt.bc, "#rps");
        f11018j.put(bt.bh, "#mov");
        f11018j.put(f.f10327i, "#vt");
        f11018j.put("secret", "#sec");
        f11018j.put(f.an, "#prv");
        f11018j.put(f.f10330l, "#$prv");
        f11018j.put(f.f10331m, "#uda");
        f11018j.put(bt.f10036a, "#tok");
        f11018j.put(bt.aT, "#iv");
        f11018j.put(bt.R, "#ast");
        f11018j.put("backstate", "#bst");
        f11018j.put("zdata_ver", "#zv");
        f11018j.put("zdata_req_ts", "#zrt");
        f11018j.put("app_b_v", "#bv");
        f11018j.put("zdata", "#zta");
        f11018j.put(bt.ap, "#mt");
        f11018j.put(bt.am, "#zsv");
        f11018j.put("others_OS", "#oos");
    }

    public static String a(String str) {
        return f11018j.containsKey(str) ? f11018j.get(str) : str;
    }

    private static boolean b() {
        f11015g = UMUtils.getSystemProperty(f11012d, "");
        f11016h = UMUtils.getSystemProperty(f11013e, "");
        return (!TextUtils.isEmpty(f11015g) && !f11014f.equals(f11015g)) && (!TextUtils.isEmpty(f11016h) && !f11014f.equals(f11016h));
    }

    public static void a() {
        if (f11017i != null) {
            f11017i = null;
            com.umeng.commonsdk.statistics.idtracking.f.a();
        }
    }

    public JSONObject b(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Envelope envelope;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", f11015g);
                    jSONObject.put("umCaseId", f11016h);
                }
            } catch (Throwable unused) {
            }
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String)) {
                        String str2 = next;
                        if (jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject3.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused2) {
                            }
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            if (jSONObject3 != null) {
                envelope = a(context, jSONObject3.toString().getBytes());
                if (envelope == null) {
                    return a(111, jSONObject3);
                }
            } else {
                envelope = null;
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize(envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int a10 = a(context, envelope2, "z==1.2.0", DeviceConfig.getAppVersionName(context), str);
            if (a10 != 0) {
                return a(a10, jSONObject3);
            }
            if (ULog.DEBUG) {
                StringBuilder sb = new StringBuilder();
                sb.append("constructHeader size is ");
                sb.append(jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    public static long a(Context context) {
        long j10 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            StringBuilder sb = new StringBuilder();
            sb.append("free size is ");
            sb.append(j10);
        }
        return j10;
    }

    private JSONObject a(int i10, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i10);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i10);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        String str4;
        boolean z10;
        String str5;
        Envelope envelope;
        JSONObject optJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("headerJSONObject size is ");
            sb.append(jSONObject.toString().getBytes().length);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("bodyJSONObject size is ");
            sb2.append(jSONObject2.toString().getBytes().length);
        }
        JSONObject jSONObject4 = null;
        if (context != null && jSONObject2 != null) {
            try {
                if (jSONObject2.has("analytics") && (optJSONObject = jSONObject2.optJSONObject("analytics")) != null && optJSONObject.has(f.f10332n)) {
                    str4 = str2;
                    z10 = true;
                } else {
                    str4 = str2;
                    z10 = false;
                }
                JSONObject a10 = a(context, str4, z10);
                if (a10 != null && jSONObject != null) {
                    a10 = a(a10, jSONObject);
                }
                JSONObject jSONObject5 = a10;
                if (jSONObject5 != null) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next != null && (next instanceof String)) {
                            String str6 = next;
                            if (jSONObject2.opt(str6) != null) {
                                try {
                                    jSONObject5.put(a(str6), jSONObject2.opt(str6));
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    str4 = "u";
                }
                String str7 = TextUtils.isEmpty(str3) ? "1.0.0" : str3;
                if (jSONObject5 != null) {
                    String str8 = str4 + "==" + str7 + "&=";
                    if (TextUtils.isEmpty(str8)) {
                        return a(101, jSONObject5);
                    }
                    if (str8.endsWith("&=")) {
                        str8 = str8.substring(0, str8.length() - 2);
                    }
                    str5 = str8;
                } else {
                    str5 = null;
                }
                if (jSONObject5 != null) {
                    try {
                        com.umeng.commonsdk.statistics.idtracking.f a11 = com.umeng.commonsdk.statistics.idtracking.f.a(context);
                        if (a11 != null) {
                            a11.b();
                            String encodeToString = Base64.encodeToString(new cq().a(a11.c()), 0);
                            if (!TextUtils.isEmpty(encodeToString)) {
                                JSONObject jSONObject6 = jSONObject5.getJSONObject(a("header"));
                                jSONObject6.put(a(bt.Y), encodeToString);
                                jSONObject5.put(a("header"), jSONObject6);
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (jSONObject5 != null && DataHelper.largeThanMaxSize(jSONObject5.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                    SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                    }
                    return a(113, jSONObject5);
                }
                if (jSONObject5 != null) {
                    Envelope a12 = a(context, jSONObject5.toString().getBytes());
                    if (a12 == null) {
                        return a(111, jSONObject5);
                    }
                    envelope = a12;
                } else {
                    envelope = null;
                }
                if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                    return a(114, jSONObject5);
                }
                int a13 = a(context, envelope, str5, jSONObject5 != null ? jSONObject5.optJSONObject(a("header")).optString(a("app_version")) : null, str);
                if (a13 != 0) {
                    return a(a13, jSONObject5);
                }
                if (ULog.DEBUG) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("constructHeader size is ");
                    sb3.append(jSONObject5.toString().getBytes().length);
                }
                if (!str5.startsWith(bt.aJ) && !str5.startsWith(bt.aI) && !str5.startsWith("t") && !str5.startsWith("a") && !com.umeng.commonsdk.stateless.b.a()) {
                    new com.umeng.commonsdk.stateless.b(context);
                    com.umeng.commonsdk.stateless.b.b();
                }
                return jSONObject5;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
                if (jSONObject != null) {
                    try {
                        jSONObject3 = new JSONObject();
                    } catch (Exception e10) {
                        e = e10;
                    }
                    try {
                        jSONObject3.put("header", jSONObject);
                    } catch (JSONException unused3) {
                    } catch (Exception e11) {
                        e = e11;
                        jSONObject4 = jSONObject3;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject4);
                    }
                    jSONObject4 = jSONObject3;
                }
                if (jSONObject4 == null) {
                    jSONObject4 = new JSONObject();
                }
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (next2 != null && (next2 instanceof String)) {
                        String str9 = next2;
                        if (jSONObject2.opt(str9) != null) {
                            try {
                                jSONObject4.put(str9, jSONObject2.opt(str9));
                            } catch (Exception unused4) {
                            }
                        }
                    }
                }
                return a(110, jSONObject4);
            }
        }
        return a(110, (JSONObject) null);
    }

    private static int[] b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(com.umeng.commonsdk.internal.c.f10912a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.f10913b, 0);
                iArr[1] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.f10914c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Envelope envelope;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null && (next instanceof String)) {
                        String str2 = next;
                        if (jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject3.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            if (jSONObject3 != null) {
                envelope = a(context, jSONObject3.toString().getBytes());
                if (envelope == null) {
                    return a(111, jSONObject3);
                }
            } else {
                envelope = null;
            }
            Envelope envelope2 = envelope;
            if (envelope2 != null && DataHelper.largeThanMaxSize(envelope2.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int a10 = a(context, envelope2, "h==1.2.0", "", str);
            if (a10 != 0) {
                return a(a10, jSONObject3);
            }
            if (ULog.DEBUG) {
                StringBuilder sb = new StringBuilder();
                sb.append("constructHeader size is ");
                sb.append(jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    private static JSONObject a(Context context, String str, boolean z10) {
        SharedPreferences sharedPreferences;
        JSONObject jSONObject;
        try {
            SharedPreferences sharedPreferences2 = PreferenceWrapper.getDefault(context);
            if (!TextUtils.isEmpty(f11017i)) {
                try {
                    jSONObject = new JSONObject(f11017i);
                    sharedPreferences = sharedPreferences2;
                } catch (Exception unused) {
                    sharedPreferences = sharedPreferences2;
                    jSONObject = null;
                }
            } else {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(a(bt.f10055p), DeviceConfig.getAppMD5Signature(context));
                jSONObject2.put(a(bt.f10056q), DeviceConfig.getAppSHA1Key(context));
                jSONObject2.put(a(bt.f10057r), DeviceConfig.getAppHashKey(context));
                jSONObject2.put(a("app_version"), DeviceConfig.getAppVersionName(context));
                jSONObject2.put(a("version_code"), Integer.parseInt(DeviceConfig.getAppVersionCode(context)));
                jSONObject2.put(a(bt.f10061v), DeviceConfig.getDeviceIdUmengMD5(context));
                jSONObject2.put(a(bt.f10062w), DeviceConfig.getCPU());
                String mccmnc = DeviceConfig.getMCCMNC(context);
                if (!TextUtils.isEmpty(mccmnc)) {
                    jSONObject2.put(a(bt.B), mccmnc);
                    f11010b = mccmnc;
                } else {
                    jSONObject2.put(a(bt.B), "");
                }
                if (FieldManager.allow(d.I)) {
                    String subOSName = DeviceConfig.getSubOSName(context);
                    if (!TextUtils.isEmpty(subOSName)) {
                        jSONObject2.put(a(bt.K), subOSName);
                    }
                    String subOSVersion = DeviceConfig.getSubOSVersion(context);
                    if (!TextUtils.isEmpty(subOSVersion)) {
                        jSONObject2.put(a(bt.L), subOSVersion);
                    }
                }
                String deviceType = DeviceConfig.getDeviceType(context);
                if (!TextUtils.isEmpty(deviceType)) {
                    jSONObject2.put(a(bt.ai), deviceType);
                }
                jSONObject2.put(a(bt.f10054o), DeviceConfig.getPackageName(context));
                jSONObject2.put(a(bt.f10060u), "Android");
                jSONObject2.put(a("device_id"), DeviceConfig.getDeviceId(context));
                jSONObject2.put(a("device_model"), Build.MODEL);
                jSONObject2.put(a(bt.E), Build.BOARD);
                jSONObject2.put(a(bt.F), Build.BRAND);
                sharedPreferences = sharedPreferences2;
                jSONObject2.put(a(bt.G), Build.TIME);
                jSONObject2.put(a(bt.H), Build.MANUFACTURER);
                jSONObject2.put(a(bt.I), Build.ID);
                jSONObject2.put(a(bt.J), Build.DEVICE);
                jSONObject2.put(a(bt.f10064y), Build.VERSION.RELEASE);
                jSONObject2.put(a("os"), "Android");
                int[] resolutionArray = DeviceConfig.getResolutionArray(context);
                if (resolutionArray != null) {
                    jSONObject2.put(a(bt.f10065z), resolutionArray[1] + Operator.Operation.MULTIPLY + resolutionArray[0]);
                }
                jSONObject2.put(a(bt.A), DeviceConfig.getMac(context));
                jSONObject2.put(a(bt.M), DeviceConfig.getTimeZone(context));
                String[] localeInfo = DeviceConfig.getLocaleInfo(context);
                jSONObject2.put(a(bt.O), localeInfo[0]);
                jSONObject2.put(a("language"), localeInfo[1]);
                jSONObject2.put(a("carrier"), DeviceConfig.getNetworkOperatorName(context));
                jSONObject2.put(a(bt.f10058s), DeviceConfig.getAppName(context));
                String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    jSONObject2.put(a(bt.Q), "wifi");
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    jSONObject2.put(a(bt.Q), "2G/3G");
                } else {
                    jSONObject2.put(a(bt.Q), "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    jSONObject2.put(a(bt.R), networkAccessMode[1]);
                }
                if (DeviceConfig.isHarmony(context)) {
                    jSONObject2.put(a("others_OS"), "harmony");
                } else {
                    jSONObject2.put(a("others_OS"), "Android");
                }
                jSONObject2.put(a(bt.T), DeviceConfig.getNetworkType(context));
                jSONObject2.put(a(bt.f10039b), "9.7.9");
                jSONObject2.put(a(bt.f10042c), SdkVersion.SDK_TYPE);
                jSONObject2.put(a(bt.f10043d), "1");
                if (!TextUtils.isEmpty(f11009a)) {
                    jSONObject2.put(a(bt.f10044e), f11009a);
                }
                jSONObject2.put(a(bt.aj), Build.VERSION.SDK_INT);
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject2.put(a(bt.af), UMUtils.VALUE_REC_VERSION_NAME);
                }
                try {
                    String uUIDForZid = UMUtils.getUUIDForZid(context);
                    if (TextUtils.isEmpty(uUIDForZid)) {
                        UMUtils.setUUIDForZid(context);
                        uUIDForZid = UMUtils.getUUIDForZid(context);
                    }
                    jSONObject2.put(a("session_id"), uUIDForZid);
                } catch (Throwable unused2) {
                }
                try {
                    if (DeviceConfig.hasRequestPermission(context, "android.permission.PACKAGE_USAGE_STATS")) {
                        jSONObject2.put(bt.ar, "1");
                        if (DeviceConfig.hasOpsPermission(context.getApplicationContext())) {
                            jSONObject2.put(bt.as, "1");
                        }
                    }
                    if (DeviceConfig.isSystemApp(context)) {
                        jSONObject2.put(bt.aq, "1");
                    }
                } catch (Throwable unused3) {
                }
                if (DeviceConfig.isHonorDevice()) {
                    try {
                        if (br.c()) {
                            jSONObject2.put(bt.at, 2);
                        }
                        if (br.b()) {
                            jSONObject2.put(bt.at, 3);
                        }
                    } catch (Throwable unused4) {
                    }
                }
                try {
                    jSONObject2.put(bt.au, DeviceConfig.getNotificationStatus(context));
                } catch (Throwable unused5) {
                }
                try {
                    jSONObject2.put(bt.av, DeviceConfig.getRingerMode(context));
                } catch (Throwable unused6) {
                }
                f11017i = jSONObject2.toString();
                jSONObject = jSONObject2;
            }
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.put(a(bt.ak), UMUtils.getOaidRequiredTime(context));
            } catch (Exception unused7) {
            }
            try {
                SharedPreferences sharedPreferences3 = sharedPreferences;
                jSONObject.put(a(bt.U), sharedPreferences3.getInt("successful_request", 0));
                jSONObject.put(a(bt.V), sharedPreferences3.getInt(bt.V, 0));
                jSONObject.put(a(bt.W), sharedPreferences3.getInt("last_request_spent_ms", 0));
                String zid = UMUtils.getZid(context);
                if (!TextUtils.isEmpty(zid)) {
                    jSONObject.put(a(bt.al), zid);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                    jSONObject.put(a(bt.am), UMUtils.VALUE_ASMS_VERSION);
                }
            } catch (Exception unused8) {
            }
            jSONObject.put(a("channel"), UMUtils.getChannel(context));
            jSONObject.put(a("appkey"), UMUtils.getAppkey(context));
            try {
                String deviceToken = UMUtils.getDeviceToken(context);
                if (!TextUtils.isEmpty(deviceToken)) {
                    jSONObject.put(a(bt.f10036a), deviceToken);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(context, e10);
            }
            try {
                String imprintProperty = UMEnvelopeBuild.imprintProperty(context, bt.f10046g, null);
                if (!TextUtils.isEmpty(imprintProperty)) {
                    jSONObject.put(a(bt.f10046g), imprintProperty);
                }
            } catch (Exception e11) {
                UMCrashManager.reportCrash(context, e11);
            }
            try {
                jSONObject.put(a("wrapper_type"), a.f11006a);
                jSONObject.put(a("wrapper_version"), a.f11007b);
            } catch (Exception unused9) {
            }
            try {
                int targetSdkVersion = UMUtils.getTargetSdkVersion(context);
                boolean checkPermission = UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE");
                jSONObject.put(a(bt.f10041bb), targetSdkVersion);
                if (checkPermission) {
                    jSONObject.put(a(bt.bc), "yes");
                } else {
                    jSONObject.put(a(bt.bc), "no");
                }
            } catch (Throwable unused10) {
            }
            try {
                if (b()) {
                    jSONObject.put("umTaskId", f11015g);
                    jSONObject.put("umCaseId", f11016h);
                }
            } catch (Throwable unused11) {
            }
            if (("t".equals(str) || "a".equals(str)) && z10) {
                try {
                    int[] b10 = b(context);
                    jSONObject.put(a(bt.by), String.valueOf(b10[0]) + String.valueOf(b10[1]) + String.valueOf(b10[2]));
                } catch (Throwable unused12) {
                }
            }
            try {
                Map<String, String> moduleTags = TagHelper.getModuleTags();
                if (moduleTags != null && moduleTags.size() > 0) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (Map.Entry<String, String> entry : moduleTags.entrySet()) {
                        jSONObject3.put(entry.getKey(), entry.getValue());
                    }
                    jSONObject.put(a(bt.ap), jSONObject3);
                }
            } catch (Throwable unused13) {
            }
            try {
                String realTimeDebugKey = AnalyticsConfig.getRealTimeDebugKey();
                if (!TextUtils.isEmpty(realTimeDebugKey)) {
                    jSONObject.put(a(bt.bx), realTimeDebugKey);
                }
            } catch (Throwable unused14) {
            }
            try {
                JSONObject moduleVer = UMUtils.getModuleVer();
                if (moduleVer.length() > 0) {
                    jSONObject.put(a(bt.bh), moduleVer);
                }
            } catch (Throwable unused15) {
            }
            try {
                String apmFlag = UMUtils.getApmFlag();
                if (!TextUtils.isEmpty(apmFlag)) {
                    jSONObject.put(a(bt.bw), apmFlag);
                }
            } catch (Throwable unused16) {
            }
            try {
                String str2 = Build.BRAND;
                String a10 = at.a(str2);
                String b11 = at.b(str2);
                jSONObject.put(bt.bf, a10);
                jSONObject.put(bt.bg, b11);
            } catch (Throwable unused17) {
            }
            byte[] a11 = ImprintHandler.getImprintService(context).a();
            if (a11 != null && a11.length > 0) {
                try {
                    jSONObject.put(a(bt.X), Base64.encodeToString(a11, 0));
                } catch (JSONException e12) {
                    UMCrashManager.reportCrash(context, e12);
                }
            }
            if (jSONObject.length() > 0) {
                return new JSONObject().put(a("header"), jSONObject);
            }
            return null;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt(a("header")) != null && (jSONObject.opt(a("header")) instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt(a("header"));
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && (next instanceof String)) {
                    String str = next;
                    if (jSONObject2.opt(str) != null) {
                        try {
                            jSONObject3.put(str, jSONObject2.opt(str));
                            if (str.equals(a(f.f10327i)) && (jSONObject2.opt(str) instanceof Integer)) {
                                this.f11020k = ((Integer) jSONObject2.opt(str)).intValue();
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    private Envelope a(Context context, byte[] bArr) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int i10 = -1;
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i10 = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e10) {
            UMCrashManager.reportCrash(context, e10);
        }
        if (i10 == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (i10 == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (f11019l) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private int a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        String b10 = com.umeng.commonsdk.stateless.d.b(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("&&");
        sb.append(str2);
        sb.append("_");
        sb.append(System.currentTimeMillis());
        sb.append("_");
        sb.append(b10);
        sb.append(".log");
        byte[] binary = envelope.toBinary();
        if (com.umeng.commonsdk.utils.c.a()) {
            if (str.startsWith("h")) {
                return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
            }
            return 122;
        }
        if (str.startsWith("h")) {
            return 122;
        }
        if (!str.startsWith(bt.aJ) && !str.startsWith(bt.aI) && !str.startsWith("a") && !str.startsWith("t")) {
            return com.umeng.commonsdk.stateless.d.a(context, com.umeng.commonsdk.stateless.a.f10982f, sb.toString(), binary);
        }
        return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
    }

    public static void a(boolean z10) {
        f11019l = z10;
    }
}
