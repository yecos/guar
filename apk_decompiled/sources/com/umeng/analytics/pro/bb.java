package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class bb {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f9954a = {"um_plus_game_level", "um_plus_game_pay", "um_plus_game_buy", "um_plus_game_use", "um_plus_game_bonus"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f9955b = {"id", "ts", f.ac, "__ct__", "pn", "ds"};

    /* renamed from: c, reason: collision with root package name */
    public static final String f9956c = "^(?!\\d)[a-zA-Z0-9_\\-\\+\\.]{1,}$";

    /* renamed from: d, reason: collision with root package name */
    public static final int f9957d = 128;

    /* renamed from: e, reason: collision with root package name */
    public static final int f9958e = 256;

    /* renamed from: f, reason: collision with root package name */
    public static final int f9959f = 100;

    /* renamed from: h, reason: collision with root package name */
    private a f9961h;

    /* renamed from: i, reason: collision with root package name */
    private String f9962i;

    /* renamed from: j, reason: collision with root package name */
    private String f9963j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f9964k;

    /* renamed from: l, reason: collision with root package name */
    private Map<String, String> f9965l = null;

    /* renamed from: m, reason: collision with root package name */
    private Map<String, Object> f9966m = null;

    /* renamed from: g, reason: collision with root package name */
    JSONObject f9960g = null;

    /* renamed from: com.umeng.analytics.pro.bb$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9967a;

        static {
            int[] iArr = new int[a.values().length];
            f9967a = iArr;
            try {
                iArr[a.ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9967a[a.LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9967a[a.STRING_MAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9967a[a.OBJECT_MAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum a {
        ID,
        LABEL,
        STRING_MAP,
        OBJECT_MAP
    }

    private void h() {
        String str;
        try {
            JSONArray jSONArray = new JSONArray();
            String str2 = this.f9962i;
            String str3 = "";
            if (str2 == null) {
                jSONArray.put(ay.f9926a);
            } else if (TextUtils.isEmpty(str2.trim())) {
                jSONArray.put(ay.f9927b);
            } else {
                boolean z10 = this.f9962i.trim().getBytes().length > 128;
                if (Arrays.asList(f9954a).contains(this.f9962i)) {
                    jSONArray.put(ay.f9928c);
                    str = this.f9962i;
                } else {
                    str = null;
                }
                if (!Pattern.matches(f9956c, this.f9962i)) {
                    jSONArray.put(ay.f9930e);
                    str = this.f9962i;
                }
                if (z10) {
                    jSONArray.put(ay.f9929d);
                    str3 = this.f9962i.length() > 128 ? this.f9962i.substring(0, 128) : this.f9962i;
                } else {
                    str3 = str;
                }
            }
            if (str3 != null) {
                this.f9960g.put("eID", str3);
                if (jSONArray.length() > 0) {
                    this.f9960g.put(Constants.KEY_HTTP_CODE, jSONArray);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void i() {
        try {
            h();
            JSONObject a10 = a(this.f9962i, this.f9963j, true);
            if (a10.length() > 0) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(a10);
                if (this.f9960g == null) {
                    this.f9960g = new JSONObject();
                }
                if (!this.f9960g.has("eID")) {
                    this.f9960g.put("eID", this.f9962i);
                }
                this.f9960g.put("epps", jSONArray);
            }
        } catch (Throwable unused) {
        }
    }

    private void j() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            h();
            if (this.f9965l == null) {
                this.f9966m = null;
            } else {
                this.f9966m = new HashMap(this.f9965l);
            }
            a(this.f9966m, jSONObject, jSONArray);
            a(jSONObject, jSONArray);
        } catch (Throwable unused) {
        }
    }

    private void k() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            h();
            a(this.f9966m, jSONObject, jSONArray);
            a(jSONObject, jSONArray);
        } catch (Throwable unused) {
        }
    }

    public a a() {
        return this.f9961h;
    }

    public String b() {
        return this.f9962i;
    }

    public String c() {
        return this.f9963j;
    }

    public boolean d() {
        return this.f9964k;
    }

    public Map<String, String> e() {
        return this.f9965l;
    }

    public Map<String, Object> f() {
        return this.f9966m;
    }

    public JSONObject g() {
        this.f9960g = new JSONObject();
        int i10 = AnonymousClass1.f9967a[this.f9961h.ordinal()];
        if (i10 == 1) {
            h();
            JSONObject jSONObject = this.f9960g;
            if (jSONObject == null || jSONObject.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.f9960g);
            }
        } else if (i10 == 2) {
            i();
            JSONObject jSONObject2 = this.f9960g;
            if (jSONObject2 == null || jSONObject2.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.f9960g);
            }
        } else if (i10 == 3) {
            j();
            JSONObject jSONObject3 = this.f9960g;
            if (jSONObject3 == null || jSONObject3.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.f9960g);
            }
        } else if (i10 != 4) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "unknown CkItem type!");
        } else {
            k();
            JSONObject jSONObject4 = this.f9960g;
            if (jSONObject4 == null || jSONObject4.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.f9960g);
            }
        }
        return this.f9960g;
    }

    private JSONObject c(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (obj instanceof String) {
                jSONObject = a(str, (String) obj, false);
            } else if (!(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof Float) && !(obj instanceof Double)) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(ay.f9942q);
                jSONObject.put(Constants.KEY_HTTP_CODE, jSONArray);
                jSONObject.put("pid", obj.getClass().getName());
                jSONObject.put(Constant.KEY_MSG, str);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public bb a(a aVar) {
        this.f9961h = aVar;
        return this;
    }

    public bb b(String str) {
        this.f9963j = str;
        return this;
    }

    public bb a(String str) {
        this.f9962i = str;
        return this;
    }

    public bb b(Map<String, Object> map) {
        this.f9966m = map;
        return this;
    }

    private void b(Map<String, Object> map, JSONObject jSONObject, JSONArray jSONArray) {
        try {
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                JSONArray a10 = a(str, obj);
                if (a10 != null && a10.length() > 0) {
                    for (int i10 = 0; i10 < a10.length(); i10++) {
                        jSONArray.put(a10.get(i10));
                    }
                } else {
                    jSONObject.put(str, obj);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public bb a(boolean z10) {
        this.f9964k = z10;
        return this;
    }

    public bb a(Map<String, String> map) {
        this.f9965l = map;
        return this;
    }

    private void a(JSONObject jSONObject, JSONArray jSONArray) {
        if (this.f9960g == null) {
            this.f9960g = new JSONObject();
        }
        if (jSONArray.length() > 0) {
            this.f9960g.put("epps", jSONArray);
            if (jSONObject.length() > 0) {
                this.f9960g.put("pps", jSONObject);
            }
        }
        if (!this.f9960g.has("epps") || this.f9960g.has(Constants.KEY_HTTP_CODE)) {
            return;
        }
        this.f9960g.put("eID", this.f9962i);
    }

    private JSONObject b(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (str == null) {
                jSONArray.put(ay.f9940o);
                jSONObject.put("pid", "");
            } else if (TextUtils.isEmpty(str.trim())) {
                jSONArray.put(ay.f9937l);
                jSONObject.put("pid", "");
            } else {
                boolean z10 = str.trim().getBytes().length > 128;
                if (Arrays.asList(f9955b).contains(str)) {
                    jSONArray.put(ay.f9932g);
                    jSONObject.put("pid", str);
                }
                if (!Pattern.matches(f9956c, str)) {
                    jSONArray.put(ay.f9941p);
                    jSONObject.put("pid", str);
                }
                if (z10) {
                    jSONArray.put(ay.f9933h);
                    if (str.length() > 128) {
                        str = str.substring(0, 128);
                    }
                    jSONObject.put("pid", str);
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put(Constants.KEY_HTTP_CODE, jSONArray);
                jSONObject.put(Constant.KEY_MSG, obj);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private void a(Map<String, Object> map, JSONObject jSONObject, JSONArray jSONArray) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            if (map == null) {
                jSONArray2.put(ay.f9939n);
            } else if (map.isEmpty()) {
                jSONArray2.put(ay.f9936k);
            } else if (map.size() > 100) {
                jSONArray2.put(ay.f9931f);
            }
            if (jSONArray2.length() > 0) {
                jSONObject2.put(Constants.KEY_HTTP_CODE, jSONArray2);
                jSONArray.put(jSONObject2);
            } else {
                b(map, jSONObject, jSONArray);
            }
        } catch (Throwable unused) {
        }
    }

    private JSONArray a(String str, Object obj) {
        JSONArray jSONArray = null;
        try {
            JSONObject b10 = b(str, obj);
            if (b10.length() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                try {
                    jSONArray2.put(b10);
                    jSONArray = jSONArray2;
                } catch (Throwable unused) {
                    return jSONArray2;
                }
            }
            JSONObject c10 = c(str, obj);
            if (c10.length() <= 0) {
                return jSONArray;
            }
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            jSONArray.put(c10);
            return jSONArray;
        } catch (Throwable unused2) {
            return jSONArray;
        }
    }

    private JSONObject a(String str, String str2, boolean z10) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (str2 == null) {
                jSONArray.put(ay.f9934i);
                jSONObject.put(Constants.KEY_HTTP_CODE, jSONArray);
                jSONObject.put("pid", "");
                jSONObject.put(Constant.KEY_MSG, str);
            } else if (str2.getBytes().length > 256) {
                if (z10) {
                    jSONArray.put(ay.f9938m);
                } else {
                    jSONArray.put(ay.f9935j);
                }
                jSONObject.put(Constants.KEY_HTTP_CODE, jSONArray);
                if (str2.length() > 256) {
                    str2 = str2.substring(0, 256);
                }
                jSONObject.put("pid", str2);
                jSONObject.put(Constant.KEY_MSG, str);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
