package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.q;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10566a = "fs_lc_tl_uapp";

    /* renamed from: f, reason: collision with root package name */
    private static final String f10567f = "-1";

    /* renamed from: g, reason: collision with root package name */
    private static Context f10568g;

    /* renamed from: b, reason: collision with root package name */
    private final int f10569b;

    /* renamed from: c, reason: collision with root package name */
    private final int f10570c;

    /* renamed from: d, reason: collision with root package name */
    private final int f10571d;

    /* renamed from: e, reason: collision with root package name */
    private final int f10572e;

    /* renamed from: h, reason: collision with root package name */
    private JSONObject f10573h;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final u f10574a = new u();

        private a() {
        }
    }

    public static u a(Context context) {
        if (f10568g == null && context != null) {
            f10568g = context.getApplicationContext();
        }
        return a.f10574a;
    }

    private void b(Context context) {
        try {
            String string = PreferenceWrapper.getDefault(context).getString(f10566a, null);
            if (!TextUtils.isEmpty(string)) {
                this.f10573h = new JSONObject(string);
            }
            a();
        } catch (Exception unused) {
        }
    }

    private void c(Context context) {
        try {
            if (this.f10573h != null) {
                PreferenceWrapper.getDefault(f10568g).edit().putString(f10566a, this.f10573h.toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private u() {
        this.f10569b = 128;
        this.f10570c = 256;
        this.f10571d = 1024;
        this.f10572e = 10;
        this.f10573h = null;
        try {
            b(f10568g);
        } catch (Throwable unused) {
        }
    }

    private boolean c(String str) {
        if (str == null) {
            return true;
        }
        try {
            return str.trim().getBytes().length <= 1024;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(String str, String str2, long j10, int i10, String str3) {
        String a10;
        try {
            if (a(str) && b(str2)) {
                if (Arrays.asList(f.aM).contains(str)) {
                    MLog.e("key is " + str + ", please check key, illegal");
                    UMLog.aq(l.f10454m, 0, "\\|");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", currentTimeMillis);
                if (j10 > 0) {
                    jSONObject.put(f.ac, j10);
                }
                jSONObject.put("__t", k.f10420a);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(str, str2);
                }
                if (UMUtils.isMainProgress(f10568g)) {
                    a10 = aa.a().d(UMGlobalContext.getAppContext(f10568g));
                } else {
                    a10 = aa.a().a(UMGlobalContext.getAppContext(f10568g), currentTimeMillis);
                }
                if (TextUtils.isEmpty(a10)) {
                    a10 = f10567f;
                }
                jSONObject.put("__i", a10);
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(f.aA, jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f10568g).getProcessName(f10568g));
                a();
                JSONObject jSONObject3 = this.f10573h;
                if (jSONObject3 != null && jSONObject3.has(str) && !((Boolean) this.f10573h.get(str)).booleanValue()) {
                    jSONObject.put(f.ae, 1);
                    this.f10573h.put(str, true);
                    c(f10568g);
                }
                Context context = f10568g;
                UMWorkDispatch.sendEvent(context, q.a.f10521a, CoreProtocol.getInstance(context), jSONObject);
                return;
            }
            UMLog.aq(l.f10453l, 0, "\\|");
        } catch (Throwable unused2) {
        }
    }

    private boolean b(String str) {
        if (str == null) {
            return true;
        }
        try {
            if (str.trim().getBytes().length <= 256) {
                return true;
            }
        } catch (Exception unused) {
        }
        MLog.e("value is " + str + ", please check value, illegal");
        return false;
    }

    private boolean b(Map<String, Object> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        if (!a(entry.getKey())) {
                            UMLog.aq(l.f10449h, 0, "\\|");
                            return false;
                        }
                        if (entry.getValue() == null) {
                            UMLog.aq(l.f10450i, 0, "\\|");
                            return false;
                        }
                        if (entry.getValue() instanceof String) {
                            if (f.aK.equals(entry.getKey())) {
                                if (!c(entry.getValue().toString())) {
                                    UMLog.aq(l.P, 0, "\\|");
                                    return false;
                                }
                            } else if ("_$!url".equals(entry.getKey())) {
                                if (!c(entry.getValue().toString())) {
                                    UMLog.aq("url参数长度超过限制。|参数url长度不能超过1024字符。", 0, "\\|");
                                    return false;
                                }
                            } else if (!b(entry.getValue().toString())) {
                                UMLog.aq(l.f10451j, 0, "\\|");
                                return false;
                            }
                        }
                    }
                    return true;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        UMLog.aq(l.f10448g, 0, "\\|");
        return false;
    }

    public void a(String str, Map<String, Object> map, long j10, String str2, boolean z10) {
        String a10;
        try {
            if (!a(str)) {
                UMLog.aq(l.f10447f, 0, "\\|");
                return;
            }
            if (b(map)) {
                if (map.size() > 100) {
                    MLog.e("map size is " + map.size() + ", please check");
                    return;
                }
                if (Arrays.asList(f.aM).contains(str)) {
                    MLog.e("key is " + str + ", please check key, illegal");
                    UMLog.aq(l.f10443b, 0, "\\|");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", System.currentTimeMillis());
                if (j10 > 0) {
                    jSONObject.put(f.ac, j10);
                }
                jSONObject.put("__t", k.f10420a);
                ULog.i("befort ekv map, event is " + jSONObject.toString());
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (!Arrays.asList(f.aM).contains(entry.getKey())) {
                        Object value = entry.getValue();
                        if (!(value instanceof String) && !(value instanceof Integer) && !(value instanceof Long) && !(value instanceof Short) && !(value instanceof Float) && !(value instanceof Double)) {
                            if (value.getClass().isArray()) {
                                if (value instanceof int[]) {
                                    int[] iArr = (int[]) value;
                                    if (iArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray = new JSONArray();
                                    for (int i10 : iArr) {
                                        jSONArray.put(i10);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray);
                                } else if (value instanceof double[]) {
                                    double[] dArr = (double[]) value;
                                    if (dArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray2 = new JSONArray();
                                    for (double d10 : dArr) {
                                        jSONArray2.put(d10);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray2);
                                } else if (value instanceof long[]) {
                                    long[] jArr = (long[]) value;
                                    if (jArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray3 = new JSONArray();
                                    for (long j11 : jArr) {
                                        jSONArray3.put(j11);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray3);
                                } else if (value instanceof float[]) {
                                    float[] fArr = (float[]) value;
                                    if (fArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray4 = new JSONArray();
                                    for (float f10 : fArr) {
                                        jSONArray4.put(f10);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray4);
                                } else if (value instanceof short[]) {
                                    short[] sArr = (short[]) value;
                                    if (sArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray5 = new JSONArray();
                                    for (short s10 : sArr) {
                                        jSONArray5.put((int) s10);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray5);
                                } else if (value instanceof String[]) {
                                    String[] strArr = (String[]) value;
                                    if (strArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray6 = new JSONArray();
                                    for (int i11 = 0; i11 < strArr.length; i11++) {
                                        String str3 = strArr[i11];
                                        if (str3 == null) {
                                            MLog.e("please check array, null item!");
                                            return;
                                        } else {
                                            if (!b(str3)) {
                                                return;
                                            }
                                            jSONArray6.put(strArr[i11]);
                                        }
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray6);
                                } else {
                                    MLog.e("please check key or value, illegal type!");
                                    return;
                                }
                            } else {
                                MLog.e("please check key or value, illegal type!");
                                return;
                            }
                        }
                        jSONObject.put(entry.getKey(), value);
                    } else {
                        UMLog.aq(l.f10446e, 0, "\\|");
                        return;
                    }
                }
                if (UMUtils.isMainProgress(f10568g)) {
                    a10 = aa.a().d(UMGlobalContext.getAppContext(f10568g));
                } else {
                    a10 = aa.a().a(UMGlobalContext.getAppContext(f10568g), jSONObject.getLong("ts"));
                }
                if (TextUtils.isEmpty(a10)) {
                    a10 = f10567f;
                }
                jSONObject.put("__i", a10);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(f.aA, jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f10568g).getProcessName(f10568g));
                a();
                JSONObject jSONObject3 = this.f10573h;
                if (jSONObject3 != null && jSONObject3.has(str) && !((Boolean) this.f10573h.get(str)).booleanValue()) {
                    jSONObject.put(f.ae, 1);
                    this.f10573h.put(str, true);
                    c(f10568g);
                }
                ULog.i("----->>>>>ekv event json is " + jSONObject.toString());
                if (!z10) {
                    Context context = f10568g;
                    UMWorkDispatch.sendEvent(context, q.a.f10521a, CoreProtocol.getInstance(context), jSONObject);
                } else {
                    Context context2 = f10568g;
                    UMWorkDispatch.sendEvent(context2, q.a.f10534n, CoreProtocol.getInstance(context2), jSONObject);
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public void a(String str, Map<String, Object> map, String str2) {
        try {
            if (a(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(f.ac, 0);
                jSONObject.put("__t", k.f10421b);
                ULog.i("befort gkv map, event is " + jSONObject.toString());
                Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
                for (int i10 = 0; i10 < 10 && it.hasNext(); i10++) {
                    Map.Entry<String, Object> next = it.next();
                    if (!f.ae.equals(next.getKey()) && !f.ac.equals(next.getKey()) && !"id".equals(next.getKey()) && !"ts".equals(next.getKey())) {
                        Object value = next.getValue();
                        if ((value instanceof String) || (value instanceof Integer) || (value instanceof Long)) {
                            jSONObject.put(next.getKey(), value);
                        }
                    }
                }
                String d10 = aa.a().d(UMGlobalContext.getAppContext(f10568g));
                if (TextUtils.isEmpty(d10)) {
                    d10 = f10567f;
                }
                jSONObject.put("__i", d10);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(f.aA, jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f10568g).getProcessName(f10568g));
                ULog.i("----->>>>>gkv event json is " + jSONObject.toString());
                Context context = f10568g;
                UMWorkDispatch.sendEvent(context, q.a.f10522b, CoreProtocol.getInstance(context), jSONObject);
            }
        } catch (Throwable unused2) {
        }
    }

    private void a() {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f10568g, "track_list", "");
            if (TextUtils.isEmpty(imprintProperty)) {
                return;
            }
            String[] split = imprintProperty.split("!");
            JSONObject jSONObject = new JSONObject();
            int i10 = 0;
            if (this.f10573h != null) {
                for (String str : split) {
                    String subStr = HelperUtils.subStr(str, 128);
                    if (this.f10573h.has(subStr)) {
                        jSONObject.put(subStr, this.f10573h.get(subStr));
                    }
                }
            }
            this.f10573h = new JSONObject();
            if (split.length >= 10) {
                while (i10 < 10) {
                    a(split[i10], jSONObject);
                    i10++;
                }
            } else {
                while (i10 < split.length) {
                    a(split[i10], jSONObject);
                    i10++;
                }
            }
            c(f10568g);
        } catch (Exception unused) {
        }
    }

    private void a(String str, JSONObject jSONObject) {
        String subStr = HelperUtils.subStr(str, 128);
        if (jSONObject.has(subStr)) {
            a(subStr, ((Boolean) jSONObject.get(subStr)).booleanValue());
        } else {
            a(subStr, false);
        }
    }

    private void a(String str, boolean z10) {
        try {
            if (f.ae.equals(str) || f.ac.equals(str) || "id".equals(str) || "ts".equals(str) || this.f10573h.has(str)) {
                return;
            }
            this.f10573h.put(str, z10);
        } catch (Exception unused) {
        }
    }

    public void a(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    a();
                    JSONObject jSONObject = this.f10573h;
                    if (jSONObject == null) {
                        this.f10573h = new JSONObject();
                        int size = list.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            JSONObject jSONObject2 = this.f10573h;
                            if (jSONObject2 == null) {
                                this.f10573h = new JSONObject();
                            } else if (jSONObject2.length() >= 5) {
                                break;
                            }
                            String str = list.get(i10);
                            if (!TextUtils.isEmpty(str)) {
                                a(HelperUtils.subStr(str, 128), false);
                            }
                        }
                        c(f10568g);
                        return;
                    }
                    if (jSONObject.length() >= 5) {
                        MLog.d("already setFistLaunchEvent, igone.");
                        return;
                    }
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (this.f10573h.length() >= 5) {
                            MLog.d(" add setFistLaunchEvent over.");
                            return;
                        }
                        a(HelperUtils.subStr(list.get(i11), 128), false);
                    }
                    c(f10568g);
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        UMLog.aq(l.ak, 0, "\\|");
    }

    private JSONObject a(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    String key = entry.getKey();
                    if (key != null) {
                        String subStr = HelperUtils.subStr(key, 128);
                        Object value = entry.getValue();
                        if (value != null) {
                            int i10 = 0;
                            if (value.getClass().isArray()) {
                                if (value instanceof int[]) {
                                    int[] iArr = (int[]) value;
                                    JSONArray jSONArray = new JSONArray();
                                    while (i10 < iArr.length) {
                                        jSONArray.put(iArr[i10]);
                                        i10++;
                                    }
                                    jSONObject.put(subStr, jSONArray);
                                } else if (value instanceof double[]) {
                                    double[] dArr = (double[]) value;
                                    JSONArray jSONArray2 = new JSONArray();
                                    while (i10 < dArr.length) {
                                        jSONArray2.put(dArr[i10]);
                                        i10++;
                                    }
                                    jSONObject.put(subStr, jSONArray2);
                                } else if (value instanceof long[]) {
                                    long[] jArr = (long[]) value;
                                    JSONArray jSONArray3 = new JSONArray();
                                    while (i10 < jArr.length) {
                                        jSONArray3.put(jArr[i10]);
                                        i10++;
                                    }
                                    jSONObject.put(subStr, jSONArray3);
                                } else if (value instanceof float[]) {
                                    float[] fArr = (float[]) value;
                                    JSONArray jSONArray4 = new JSONArray();
                                    while (i10 < fArr.length) {
                                        jSONArray4.put(fArr[i10]);
                                        i10++;
                                    }
                                    jSONObject.put(subStr, jSONArray4);
                                } else if (value instanceof short[]) {
                                    short[] sArr = (short[]) value;
                                    JSONArray jSONArray5 = new JSONArray();
                                    while (i10 < sArr.length) {
                                        jSONArray5.put((int) sArr[i10]);
                                        i10++;
                                    }
                                    jSONObject.put(subStr, jSONArray5);
                                }
                            } else if (value instanceof List) {
                                List list = (List) value;
                                JSONArray jSONArray6 = new JSONArray();
                                while (i10 < list.size()) {
                                    Object obj = list.get(i10);
                                    if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                                        jSONArray6.put(list.get(i10));
                                    }
                                    i10++;
                                }
                                if (jSONArray6.length() > 0) {
                                    jSONObject.put(subStr, jSONArray6);
                                }
                            } else if (value instanceof String) {
                                jSONObject.put(subStr, HelperUtils.subStr(value.toString(), 256));
                            } else {
                                if (!(value instanceof Long) && !(value instanceof Integer) && !(value instanceof Float) && !(value instanceof Double) && !(value instanceof Short)) {
                                    MLog.e("The param has not support type. please check !");
                                }
                                jSONObject.put(subStr, value);
                            }
                        }
                    }
                } catch (Exception e10) {
                    MLog.e(e10);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private boolean a(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length <= 128) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        MLog.e("key is " + str + ", please check key, illegal");
        return false;
    }
}
