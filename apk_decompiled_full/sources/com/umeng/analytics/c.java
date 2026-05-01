package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.ax;
import com.umeng.analytics.pro.f;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.MLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int f9805a = 20;

    /* renamed from: b, reason: collision with root package name */
    private static final String f9806b = "umeng_pcp";

    /* renamed from: c, reason: collision with root package name */
    private static final String f9807c = "mob";

    /* renamed from: d, reason: collision with root package name */
    private static final String f9808d = "em";

    /* renamed from: e, reason: collision with root package name */
    private static final String f9809e = "cp";

    /* renamed from: f, reason: collision with root package name */
    private static final String f9810f = "pk";

    /* renamed from: g, reason: collision with root package name */
    private static final String f9811g = "pv";

    /* renamed from: h, reason: collision with root package name */
    private static String[] f9812h = new String[2];

    /* renamed from: i, reason: collision with root package name */
    private static Object f9813i = new Object();

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, Object> f9814j = new HashMap();

    public static void a(Context context, String str, String str2) {
        String[] strArr = f9812h;
        strArr[0] = str;
        strArr[1] = str2;
        if (context != null) {
            com.umeng.common.b.a(context).a(str, str2);
        }
    }

    public static void b(Context context) {
        String[] strArr = f9812h;
        strArr[0] = null;
        strArr[1] = null;
        if (context != null) {
            com.umeng.common.b.a(context).b();
        }
    }

    public static Map<String, Object> c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f9806b, 0);
        String string = sharedPreferences.getString(f9809e, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            String str = new String(ax.a(Base64.decode(string, 0), UMConfigure.sAppkey.getBytes()));
            if (str.length() <= 0) {
                return null;
            }
            HashMap hashMap = new HashMap();
            try {
                JSONArray jSONArray = (JSONArray) new JSONTokener(str).nextValue();
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    hashMap.put(jSONObject.getString("pk"), jSONObject.get("pv"));
                }
                sharedPreferences.edit().putString(f9809e, "").apply();
                return hashMap;
            } catch (Throwable unused) {
                return hashMap;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static String[] a(Context context) {
        String[] a10;
        if (!TextUtils.isEmpty(f9812h[0]) && !TextUtils.isEmpty(f9812h[1])) {
            return f9812h;
        }
        if (context == null || (a10 = com.umeng.common.b.a(context).a()) == null) {
            return null;
        }
        String[] strArr = f9812h;
        strArr[0] = a10[0];
        strArr[1] = a10[1];
        return strArr;
    }

    public static void b(String str) {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences(f9806b, 0);
                byte[] a10 = ax.a(str.getBytes(), UMConfigure.sAppkey.getBytes());
                sharedPreferences.edit().putString(f9808d, a10.length == 0 ? f.Q : Base64.encodeToString(a10, 0)).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences(f9806b, 0);
                byte[] a10 = ax.a(str.getBytes(), UMConfigure.sAppkey.getBytes());
                sharedPreferences.edit().putString(f9807c, a10.length == 0 ? f.Q : Base64.encodeToString(a10, 0)).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public static String b() {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext == null) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = appContext.getSharedPreferences(f9806b, 0);
            String string = sharedPreferences.getString(f9808d, "");
            if (f.Q.equals(string)) {
                sharedPreferences.edit().putString(f9808d, "").apply();
                return "";
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            sharedPreferences.edit().putString(f9808d, "").apply();
            return new String(ax.a(Base64.decode(string, 0), UMConfigure.sAppkey.getBytes()));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a() {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext == null) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = appContext.getSharedPreferences(f9806b, 0);
            String string = sharedPreferences.getString(f9807c, "");
            if (f.Q.equals(string)) {
                sharedPreferences.edit().putString(f9807c, "").apply();
                return "";
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            sharedPreferences.edit().putString(f9807c, "").apply();
            return new String(ax.a(Base64.decode(string, 0), UMConfigure.sAppkey.getBytes()));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Context context, Map<String, Object> map) {
        if (map != null) {
            JSONStringer jSONStringer = new JSONStringer();
            try {
                synchronized (f9813i) {
                    jSONStringer.array();
                    for (String str : map.keySet()) {
                        jSONStringer.object();
                        jSONStringer.key("pk");
                        jSONStringer.value(str);
                        jSONStringer.key("pv");
                        jSONStringer.value(map.get(str));
                        jSONStringer.endObject();
                    }
                    jSONStringer.endArray();
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences(f9806b, 0);
                sharedPreferences.edit().putString(f9809e, Base64.encodeToString(ax.a(jSONStringer.toString().getBytes(), UMConfigure.sAppkey.getBytes()), 0)).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, Object obj) {
        synchronized (f9813i) {
            if (f9814j.containsKey(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "更新账号自定义KV: key=" + str + "; val=" + obj);
                f9814j.put(str, obj);
                a(UMGlobalContext.getAppContext(), f9814j);
            } else {
                if (f9814j.size() >= 20) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "设置账号自定义KV: 已经设置20个KV键值对，忽略设置请求。");
                    MLog.e("userProfile: Only 20 user-defined key-value pairs can be configured, please check!");
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "设置账号自定义KV: key=" + str + "; val=" + obj);
                f9814j.put(str, obj);
                a(UMGlobalContext.getAppContext(), f9814j);
            }
        }
    }
}
