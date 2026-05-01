package com.umeng.message.proguard;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.UPLog;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final JSONObject f12119a;

    public n(JSONObject jSONObject) {
        this.f12119a = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (f.f12083a && this.f12119a != null) {
            try {
                final Application a10 = y.a();
                final String appkey = UMUtils.getAppkey(a10);
                final int max = Math.max(this.f12119a.optInt(com.umeng.ccg.a.f10662v, 300), 100);
                final int optInt = this.f12119a.optInt("action", 1);
                if (optInt == 1 || optInt == 2) {
                    b.c(new Runnable() { // from class: com.umeng.message.proguard.n.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            String str;
                            ByteArrayOutputStream byteArrayOutputStream = null;
                            try {
                                TreeSet treeSet = new TreeSet();
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = {Ascii.DC2, -119, Ascii.US, Ascii.SYN, 8, 45, 8, Ascii.SUB, 5, 10, 98, 78, -51, 47, -125, 34, 17, 108, -112, -104, 95, 34, 120, 61, -52, -77, 8, 107, -4, 56, 82, -49, -119, -18, -111, -20, 110, -108, -32, -28, 88, -5, 69, -26, 120, -36, 5, -77, -46, Ascii.GS, Ascii.CAN, -115, -118, -9, -108, -86, -17, 34, 115, -123, 93, 53, 118, SignedBytes.MAX_POWER_OF_TWO, 48, -101, -83, -59, -99, 36, 69, -104, 51, -126, 8, -18, 79, -115, -16, 84, -49, 72, 66, 49, 93, -22, -127, -47, -59, -86, 14, -12, -100, -12, 53, 85, 37, -75, -30, Ascii.US, 44, -83, 99, -108, -92, -127, -32, 87, -61, -83, -90, 123, -98, -32, -60, 77, 113, -60, 101, 81, 57, -72, -86, Ascii.FS, -74, 88, 35, -118, -22, -74, -29, -103, -86, -25, 19, -78, 62, Ascii.FS, -100, -68, 1, 35, -68, 58, -100, Ascii.GS, 5, -10, -95, Ascii.DC4, 98, 124, -40, 99, -100, 8, -126, -10, 79, -31, -42, -114, 12, Ascii.ESC, -102, 114, -107, -35, 82, Ascii.NAK, 97, -9, 39, -20, 123, -37, -68, -78, -89, 13, 3, Ascii.NAK, Ascii.NAK, 12, 40, 14, Ascii.GS};
                                    byte[] copyOfRange = Arrays.copyOfRange(bArr, 179, 187);
                                    byte[] copyOf = Arrays.copyOf(bArr, 179);
                                    bl.a(copyOf, copyOfRange);
                                    bq.b(copyOf, byteArrayOutputStream2);
                                    JSONObject jSONObject = new JSONObject(byteArrayOutputStream2.toString());
                                    Object a11 = bn.a(jSONObject.optString(com.umeng.analytics.pro.bt.aL), jSONObject.optString(com.umeng.analytics.pro.bt.aD), null, a10, null);
                                    try {
                                        if (1 == optInt) {
                                            str = "2G/3G";
                                            Object a12 = bn.a(jSONObject.optString("m"), jSONObject.optString("q"), new Class[]{bn.a(jSONObject.optString(com.umeng.analytics.pro.bt.aI)), Integer.TYPE}, a11, new Object[]{bn.a(jSONObject.optString(com.umeng.analytics.pro.bt.aI), (Class<?>[]) new Class[]{String.class}, new Object[]{jSONObject.optString("a")}), 0});
                                            if (a12 instanceof List) {
                                                Field a13 = bn.a(jSONObject.optString("r"), jSONObject.optString("s"));
                                                Field a14 = bn.a(jSONObject.optString("t"), jSONObject.optString("n"));
                                                Iterator it = ((List) a12).iterator();
                                                while (it.hasNext()) {
                                                    Object a15 = bn.a(a14, bn.a(a13, it.next()));
                                                    if (a15 != null) {
                                                        treeSet.add((String) a15);
                                                    }
                                                }
                                            }
                                        } else {
                                            str = "2G/3G";
                                            Object a16 = bn.a(jSONObject.optString("m"), jSONObject.optString("u"), new Class[]{Integer.TYPE}, a11, new Object[]{0});
                                            if (a16 instanceof List) {
                                                Field a17 = bn.a(jSONObject.optString("v"), jSONObject.optString("n"));
                                                Iterator it2 = ((List) a16).iterator();
                                                while (it2.hasNext()) {
                                                    Object a18 = bn.a(a17, it2.next());
                                                    if (a18 != null) {
                                                        treeSet.add((String) a18);
                                                    }
                                                }
                                            }
                                        }
                                        if (treeSet.isEmpty()) {
                                            f.a(byteArrayOutputStream2);
                                            return;
                                        }
                                        if (a11 == null) {
                                            f.a(byteArrayOutputStream2);
                                            return;
                                        }
                                        ArrayList arrayList = new ArrayList();
                                        JSONArray jSONArray = new JSONArray();
                                        Iterator it3 = treeSet.iterator();
                                        int i10 = 0;
                                        while (it3.hasNext()) {
                                            Object a19 = f.a(a11, (String) it3.next());
                                            if (a19 != null) {
                                                l lVar = new l(a11, a19);
                                                JSONObject jSONObject2 = new JSONObject();
                                                jSONObject2.put("a", lVar.f12109b);
                                                jSONObject2.put(com.umeng.analytics.pro.bt.aD, lVar.f12108a);
                                                jSONObject2.put("v", lVar.f12110c);
                                                jSONObject2.put("t", lVar.f12112e);
                                                jSONObject2.put("u", lVar.f12111d);
                                                jSONArray.put(jSONObject2);
                                                i10++;
                                                try {
                                                    if (jSONArray.length() == max) {
                                                        arrayList.add(jSONArray);
                                                        jSONArray = new JSONArray();
                                                    }
                                                } catch (Throwable th) {
                                                    th = th;
                                                    byteArrayOutputStream = byteArrayOutputStream2;
                                                    try {
                                                        UPLog.e("App2", th.getMessage());
                                                        return;
                                                    } finally {
                                                        f.a(byteArrayOutputStream);
                                                    }
                                                }
                                            }
                                        }
                                        if (jSONArray.length() > 0) {
                                            arrayList.add(jSONArray);
                                        }
                                        if (arrayList.isEmpty()) {
                                            f.a(byteArrayOutputStream2);
                                            return;
                                        }
                                        JSONObject jSONObject3 = new JSONObject();
                                        jSONObject3.put(com.umeng.analytics.pro.bt.al, UMUtils.getZid(a10));
                                        jSONObject3.put("appkey", appkey);
                                        jSONObject3.put(com.umeng.analytics.pro.bt.f10046g, UMUtils.getUMId(a10));
                                        jSONObject3.put("v", "3.1");
                                        jSONObject3.put("sdk_v", MsgConstant.SDK_VERSION);
                                        jSONObject3.put("os_v", Build.VERSION.RELEASE);
                                        jSONObject3.put(Constants.KEY_BRAND, d.f());
                                        jSONObject3.put(Constants.KEY_MODEL, d.d());
                                        String uuid = UUID.randomUUID().toString();
                                        jSONObject3.put("uuid", uuid);
                                        jSONObject3.put("smart_id", uuid);
                                        jSONObject3.put("src", "push");
                                        jSONObject3.put("imei", DeviceConfig.getImeiNew(a10));
                                        try {
                                            jSONObject3.put("oaid", DeviceConfig.getOaid(a10));
                                        } catch (Throwable unused) {
                                        }
                                        try {
                                            jSONObject3.put("idfa", DeviceConfig.getIdfa(a10));
                                        } catch (Throwable unused2) {
                                        }
                                        jSONObject3.put("android_id", DeviceConfig.getAndroidId(a10));
                                        jSONObject3.put("pkg", a10.getPackageName());
                                        jSONObject3.put("app_v", UMUtils.getAppVersionName(a10));
                                        jSONObject3.put("board", d.e());
                                        try {
                                            Locale locale = UMUtils.getLocale(a10);
                                            if (locale != null) {
                                                jSONObject3.put("os_lang", locale.getLanguage());
                                            }
                                        } catch (Throwable unused3) {
                                        }
                                        jSONObject3.put("c_ts", System.currentTimeMillis());
                                        jSONObject3.put("total", i10);
                                        try {
                                            jSONObject3.put("os_i", Build.VERSION.SDK_INT);
                                            jSONObject3.put("os_t", a10.getApplicationInfo().targetSdkVersion);
                                            jSONObject3.put("grant", f.f(a10) ? 1 : 0);
                                        } catch (Throwable unused4) {
                                        }
                                        try {
                                            jSONObject3.put("os", "Android");
                                            String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(a10);
                                            if ("Wi-Fi".equals(networkAccessMode[0])) {
                                                jSONObject3.put(com.umeng.analytics.pro.bt.Q, "wifi");
                                            } else {
                                                String str2 = str;
                                                if (str2.equals(networkAccessMode[0])) {
                                                    jSONObject3.put(com.umeng.analytics.pro.bt.Q, str2);
                                                } else {
                                                    jSONObject3.put(com.umeng.analytics.pro.bt.Q, "unknown");
                                                }
                                            }
                                            if (!"".equals(networkAccessMode[1])) {
                                                jSONObject3.put("sub_access", networkAccessMode[1]);
                                            }
                                            jSONObject3.put(com.umeng.analytics.pro.bt.f10058s, DeviceConfig.getAppName(a10));
                                        } catch (Throwable unused5) {
                                        }
                                        try {
                                            String[] split = n.this.f12119a.optString(com.umeng.ccg.a.f10661u).split(",");
                                            JSONArray jSONArray2 = new JSONArray();
                                            for (String str3 : split) {
                                                jSONArray2.put(str3);
                                            }
                                            jSONObject3.put(com.umeng.ccg.a.f10661u, jSONArray2);
                                            jSONObject3.put(com.umeng.ccg.a.f10658r, n.this.f12119a.optString(com.umeng.ccg.a.f10658r));
                                            jSONObject3.put(com.umeng.ccg.a.f10659s, n.this.f12119a.optString(com.umeng.ccg.a.f10659s));
                                            String optString = n.this.f12119a.optString("actionName");
                                            String optString2 = n.this.f12119a.optString(com.umeng.ccg.a.f10660t);
                                            if (!TextUtils.isEmpty(optString2)) {
                                                JSONArray jSONArray3 = new JSONArray(optString2);
                                                JSONObject jSONObject4 = new JSONObject();
                                                jSONObject4.put(optString, jSONArray3);
                                                jSONObject3.put(com.umeng.ccg.a.f10660t, jSONObject4);
                                            }
                                        } catch (Throwable unused6) {
                                        }
                                        Iterator it4 = arrayList.iterator();
                                        int i11 = 0;
                                        while (it4.hasNext()) {
                                            JSONArray jSONArray4 = (JSONArray) it4.next();
                                            i11++;
                                            jSONObject3.put(com.umeng.ccg.a.f10662v, i11);
                                            jSONObject3.put("apl", jSONArray4);
                                            try {
                                                g.b(jSONObject3, "https://yumao.puata.info/cc_info", appkey);
                                            } catch (Exception e10) {
                                                throw e10;
                                            }
                                        }
                                        f.a(byteArrayOutputStream2);
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }
}
