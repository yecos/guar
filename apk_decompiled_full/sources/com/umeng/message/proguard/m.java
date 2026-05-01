package com.umeng.message.proguard;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
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
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
final class m implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        JSONObject jSONObject;
        if (f.f12083a && !f.f12085c) {
            MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(y.a());
            if (messageSharedPrefs.f11345c == null) {
                try {
                    if (f.b(messageSharedPrefs.f11343a)) {
                        messageSharedPrefs.f11344b.a("smart_lc", messageSharedPrefs.n() + 1);
                    }
                } finally {
                    messageSharedPrefs.f11345c = Boolean.TRUE;
                }
            }
            if (messageSharedPrefs.n() >= messageSharedPrefs.f11344b.b("smart_lt", 0) && messageSharedPrefs.a("smart_")) {
                try {
                    final Application a10 = y.a();
                    final String appkey = UMUtils.getAppkey(a10);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(com.umeng.analytics.pro.bt.al, UMUtils.getZid(a10));
                    try {
                        jSONObject2.put("imei", DeviceConfig.getImeiNew(a10));
                        jSONObject2.put("oaid", DeviceConfig.getOaid(a10));
                    } catch (Throwable unused) {
                    }
                    try {
                        jSONObject2.put("idfa", DeviceConfig.getIdfa(a10));
                    } catch (Throwable unused2) {
                    }
                    jSONObject2.put(com.umeng.analytics.pro.bt.f10046g, d.k(a10));
                    jSONObject2.put("android_id", d.e(a10));
                    jSONObject2.put("sdk_v", MsgConstant.SDK_VERSION);
                    jSONObject2.put("os_v", Build.VERSION.RELEASE);
                    jSONObject2.put("lvl", Build.VERSION.SDK_INT);
                    String[] networkAccessMode = UMUtils.getNetworkAccessMode(a10);
                    if (TextUtils.isEmpty(networkAccessMode[0])) {
                        networkAccessMode[0] = "Unknown";
                    }
                    jSONObject2.put("net", networkAccessMode[0]);
                    jSONObject2.put(Constants.KEY_BRAND, d.f());
                    long b10 = messageSharedPrefs.f11344b.b("smart_ts", 0L);
                    if (b10 > 0) {
                        jSONObject2.put("last", b10);
                    }
                    try {
                        jSONObject = g.a(jSONObject2, "https://ccs.umeng.com/aa", appkey, false);
                    } catch (Exception unused3) {
                        jSONObject = null;
                    }
                    if (jSONObject == null) {
                        messageSharedPrefs.a(7200L);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        messageSharedPrefs.a(7200L);
                        return;
                    }
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("aa");
                    if (optJSONObject2 == null) {
                        optJSONObject2 = new JSONObject();
                    }
                    int optInt = optJSONObject2.optInt("launch", 5);
                    messageSharedPrefs.f11344b.a("smart_lt", optInt);
                    if (messageSharedPrefs.n() < optInt) {
                        return;
                    }
                    messageSharedPrefs.a(optJSONObject.optLong("ttl", 86400L));
                    final long optLong = optJSONObject.optLong("id", -1L);
                    if (optLong <= 0) {
                        return;
                    }
                    final int max = Math.max(optJSONObject2.optInt(com.umeng.ccg.a.f10662v, 300), 100);
                    final int optInt2 = optJSONObject2.optInt("action", 1);
                    int optInt3 = optJSONObject2.optInt("delay");
                    if (optInt2 == 1 || optInt2 == 2) {
                        b.b(new Runnable() { // from class: com.umeng.message.proguard.m.1
                            @Override // java.lang.Runnable
                            public final void run() {
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
                                        JSONObject jSONObject3 = new JSONObject(byteArrayOutputStream2.toString());
                                        Object a11 = bn.a(jSONObject3.optString(com.umeng.analytics.pro.bt.aL), jSONObject3.optString(com.umeng.analytics.pro.bt.aD), null, a10, null);
                                        try {
                                            if (1 == optInt2) {
                                                Object a12 = bn.a(jSONObject3.optString("m"), jSONObject3.optString("q"), new Class[]{bn.a(jSONObject3.optString(com.umeng.analytics.pro.bt.aI)), Integer.TYPE}, a11, new Object[]{bn.a(jSONObject3.optString(com.umeng.analytics.pro.bt.aI), (Class<?>[]) new Class[]{String.class}, new Object[]{jSONObject3.optString("a")}), 0});
                                                if (a12 instanceof List) {
                                                    Field a13 = bn.a(jSONObject3.optString("r"), jSONObject3.optString("s"));
                                                    Field a14 = bn.a(jSONObject3.optString("t"), jSONObject3.optString("n"));
                                                    Iterator it = ((List) a12).iterator();
                                                    while (it.hasNext()) {
                                                        Object a15 = bn.a(a14, bn.a(a13, it.next()));
                                                        if (a15 != null) {
                                                            treeSet.add((String) a15);
                                                        }
                                                    }
                                                }
                                            } else {
                                                Object a16 = bn.a(jSONObject3.optString("m"), jSONObject3.optString("u"), new Class[]{Integer.TYPE}, a11, new Object[]{0});
                                                if (a16 instanceof List) {
                                                    Field a17 = bn.a(jSONObject3.optString("v"), jSONObject3.optString("n"));
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
                                                    JSONObject jSONObject4 = new JSONObject();
                                                    jSONObject4.put("a", lVar.f12109b);
                                                    jSONObject4.put(com.umeng.analytics.pro.bt.aD, lVar.f12108a);
                                                    jSONObject4.put("v", lVar.f12110c);
                                                    jSONObject4.put("t", lVar.f12112e);
                                                    jSONObject4.put("u", lVar.f12111d);
                                                    jSONArray.put(jSONObject4);
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
                                                            UPLog.e("App", th.getMessage());
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
                                            JSONObject jSONObject5 = new JSONObject();
                                            jSONObject5.put(com.umeng.analytics.pro.bt.al, UMUtils.getZid(a10));
                                            jSONObject5.put("appkey", appkey);
                                            jSONObject5.put(com.umeng.analytics.pro.bt.f10046g, d.k(a10));
                                            jSONObject5.put("v", Constant.DATAREPORT_PROTOCOL_VER);
                                            jSONObject5.put("sdk_v", MsgConstant.SDK_VERSION);
                                            jSONObject5.put("os_v", Build.VERSION.RELEASE);
                                            jSONObject5.put(Constants.KEY_BRAND, d.f());
                                            jSONObject5.put(Constants.KEY_MODEL, d.d());
                                            jSONObject5.put("smart_id", optLong);
                                            jSONObject5.put("src", "push");
                                            jSONObject5.put("imei", DeviceConfig.getImeiNew(a10));
                                            try {
                                                jSONObject5.put("oaid", DeviceConfig.getOaid(a10));
                                            } catch (Throwable unused4) {
                                            }
                                            try {
                                                jSONObject5.put("idfa", DeviceConfig.getIdfa(a10));
                                            } catch (Throwable unused5) {
                                            }
                                            jSONObject5.put("android_id", d.e(a10));
                                            jSONObject5.put("pkg", a10.getPackageName());
                                            jSONObject5.put("app_v", UMUtils.getAppVersionName(a10));
                                            jSONObject5.put("board", d.e());
                                            try {
                                                Locale locale = UMUtils.getLocale(a10);
                                                if (locale != null) {
                                                    jSONObject5.put("os_lang", locale.getLanguage());
                                                }
                                            } catch (Throwable unused6) {
                                            }
                                            jSONObject5.put("c_ts", System.currentTimeMillis());
                                            jSONObject5.put("total", i10);
                                            try {
                                                jSONObject5.put("os_i", Build.VERSION.SDK_INT);
                                                jSONObject5.put("os_t", a10.getApplicationInfo().targetSdkVersion);
                                                jSONObject5.put("grant", f.f(a10) ? 1 : 0);
                                            } catch (Throwable unused7) {
                                            }
                                            Iterator it4 = arrayList.iterator();
                                            int i11 = 0;
                                            while (it4.hasNext()) {
                                                JSONArray jSONArray2 = (JSONArray) it4.next();
                                                i11++;
                                                jSONObject5.put(com.umeng.ccg.a.f10662v, i11);
                                                jSONObject5.put("data", jSONArray2);
                                                try {
                                                    g.b(jSONObject5, "https://sss.umeng.com/api/v2/al", appkey);
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
                        }, optInt3, TimeUnit.SECONDS);
                    }
                } catch (Throwable unused4) {
                }
            }
        }
    }
}
