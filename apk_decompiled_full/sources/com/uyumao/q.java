package com.uyumao;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.uyumao.o;
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
public final class q implements Runnable {

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f12440a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12441b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f12442c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f12443d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f12444e;

        public a(q qVar, Context context, int i10, int i11, String str, long j10) {
            this.f12440a = context;
            this.f12441b = i10;
            this.f12442c = i11;
            this.f12443d = str;
            this.f12444e = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                TreeSet treeSet = new TreeSet();
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    byte[] bArr = {Ascii.DC2, -119, Ascii.US, Ascii.SYN, 8, 45, 8, Ascii.SUB, 5, 10, 98, 78, -51, 47, -125, 34, 17, 108, -112, -104, 95, 34, 120, 61, -52, -77, 8, 107, -4, 56, 82, -49, -119, -18, -111, -20, 110, -108, -32, -28, 88, -5, 69, -26, 120, -36, 5, -77, -46, Ascii.GS, Ascii.CAN, -115, -118, -9, -108, -86, -17, 34, 115, -123, 93, 53, 118, SignedBytes.MAX_POWER_OF_TWO, 48, -101, -83, -59, -99, 36, 69, -104, 51, -126, 8, -18, 79, -115, -16, 84, -49, 72, 66, 49, 93, -22, -127, -47, -59, -86, 14, -12, -100, -12, 53, 85, 37, -75, -30, Ascii.US, 44, -83, 99, -108, -92, -127, -32, 87, -61, -83, -90, 123, -98, -32, -60, 77, 113, -60, 101, 81, 57, -72, -86, Ascii.FS, -74, 88, 35, -118, -22, -74, -29, -103, -86, -25, 19, -78, 62, Ascii.FS, -100, -68, 1, 35, -68, 58, -100, Ascii.GS, 5, -10, -95, Ascii.DC4, 98, 124, -40, 99, -100, 8, -126, -10, 79, -31, -42, -114, 12, Ascii.ESC, -102, 114, -107, -35, 82, Ascii.NAK, 97, -9, 39, -20, 123, -37, -68, -78, -89, 13, 3, Ascii.NAK, Ascii.NAK, 12, 40, 14, Ascii.GS};
                    byte[] copyOfRange = Arrays.copyOfRange(bArr, 179, 187);
                    byte[] copyOf = Arrays.copyOf(bArr, 179);
                    e.a(copyOf, copyOfRange);
                    e.a(copyOf, byteArrayOutputStream2);
                    JSONObject jSONObject = new JSONObject(byteArrayOutputStream2.toString());
                    Object a10 = t.a(jSONObject.optString(bt.aL), jSONObject.optString(bt.aD), null, this.f12440a, null);
                    String str = "v";
                    try {
                        if (1 == this.f12441b) {
                            Object a11 = t.a(jSONObject.optString("m"), jSONObject.optString("q"), new Class[]{t.a(jSONObject.optString(bt.aI)), Integer.TYPE}, a10, new Object[]{t.a(jSONObject.optString(bt.aI), (Class<?>[]) new Class[]{String.class}, new Object[]{jSONObject.optString("a")}), 0});
                            if (a11 instanceof List) {
                                Field a12 = t.a(jSONObject.optString("r"), jSONObject.optString("s"));
                                Field a13 = t.a(jSONObject.optString("t"), jSONObject.optString("n"));
                                Iterator it = ((List) a11).iterator();
                                while (it.hasNext()) {
                                    Object a14 = t.a(a13, t.a(a12, it.next()));
                                    if (a14 != null) {
                                        treeSet.add((String) a14);
                                    }
                                }
                            }
                        } else {
                            Object a15 = t.a(jSONObject.optString("m"), jSONObject.optString("u"), new Class[]{Integer.TYPE}, a10, new Object[]{0});
                            if (a15 instanceof List) {
                                Field a16 = t.a(jSONObject.optString("v"), jSONObject.optString("n"));
                                Iterator it2 = ((List) a15).iterator();
                                while (it2.hasNext()) {
                                    Object a17 = t.a(a16, it2.next());
                                    if (a17 != null) {
                                        treeSet.add((String) a17);
                                    }
                                }
                            }
                        }
                        if (treeSet.isEmpty()) {
                            n.a(byteArrayOutputStream2);
                            return;
                        }
                        if (a10 == null) {
                            n.a(byteArrayOutputStream2);
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        JSONArray jSONArray = new JSONArray();
                        Iterator it3 = treeSet.iterator();
                        int i10 = 0;
                        while (it3.hasNext()) {
                            Object a18 = n.a(a10, (String) it3.next(), 0);
                            if (a18 != null) {
                                p pVar = new p(a10, a18);
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("a", pVar.f12435b);
                                jSONObject2.put(bt.aD, pVar.f12434a);
                                jSONObject2.put(str, pVar.f12436c);
                                jSONObject2.put("t", pVar.f12439f);
                                String str2 = str;
                                jSONObject2.put(bt.aI, pVar.f12437d);
                                jSONObject2.put("u", pVar.f12438e);
                                jSONArray.put(jSONObject2);
                                i10++;
                                try {
                                    if (jSONArray.length() == this.f12442c) {
                                        arrayList.add(jSONArray);
                                        jSONArray = new JSONArray();
                                    }
                                    str = str2;
                                } catch (Throwable th) {
                                    th = th;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    try {
                                        th.getMessage();
                                        return;
                                    } finally {
                                        n.a(byteArrayOutputStream);
                                    }
                                }
                            }
                        }
                        String str3 = str;
                        if (jSONArray.length() > 0) {
                            arrayList.add(jSONArray);
                        }
                        if (arrayList.isEmpty()) {
                            n.a(byteArrayOutputStream2);
                            return;
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(bt.al, UMUtils.getZid(this.f12440a));
                        jSONObject3.put("appkey", this.f12443d);
                        jSONObject3.put(bt.f10046g, UMUtils.getUMId(this.f12440a));
                        jSONObject3.put(str3, "2.0");
                        jSONObject3.put("sdk_v", "1.1.4");
                        jSONObject3.put("os_v", Build.VERSION.RELEASE);
                        jSONObject3.put(Constants.KEY_BRAND, n.b());
                        jSONObject3.put(Constants.KEY_MODEL, n.c());
                        jSONObject3.put("smart_id", this.f12444e);
                        jSONObject3.put("src", "risk");
                        jSONObject3.put("imei", DeviceConfig.getImeiNew(this.f12440a));
                        try {
                            jSONObject3.put("oaid", DeviceConfig.getOaid(this.f12440a));
                        } catch (Throwable unused) {
                        }
                        try {
                            jSONObject3.put("idfa", DeviceConfig.getIdfa(this.f12440a));
                        } catch (Throwable unused2) {
                        }
                        jSONObject3.put("android_id", DeviceConfig.getAndroidId(this.f12440a));
                        jSONObject3.put("pkg", this.f12440a.getPackageName());
                        jSONObject3.put("app_v", UMUtils.getAppVersionName(this.f12440a));
                        jSONObject3.put("board", n.a());
                        try {
                            Locale locale = UMUtils.getLocale(this.f12440a);
                            if (locale != null) {
                                jSONObject3.put("os_lang", locale.getLanguage());
                            }
                        } catch (Throwable unused3) {
                        }
                        jSONObject3.put("c_ts", System.currentTimeMillis());
                        jSONObject3.put("total", i10);
                        try {
                            jSONObject3.put("os_i", Build.VERSION.SDK_INT);
                            jSONObject3.put("os_t", this.f12440a.getApplicationInfo().targetSdkVersion);
                            jSONObject3.put("grant", n.a(this.f12440a) ? 1 : 0);
                        } catch (Throwable unused4) {
                        }
                        Iterator it4 = arrayList.iterator();
                        int i11 = 0;
                        while (it4.hasNext()) {
                            JSONArray jSONArray2 = (JSONArray) it4.next();
                            i11++;
                            jSONObject3.put(com.umeng.ccg.a.f10662v, i11);
                            jSONObject3.put("data", jSONArray2);
                            try {
                                e.a(jSONObject3, "https://sss.umeng.com/api/v2/al", this.f12443d);
                            } catch (Exception e10) {
                                throw e10;
                            }
                        }
                        n.a(byteArrayOutputStream2);
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
    }

    @Override // java.lang.Runnable
    public void run() {
        int i10;
        JSONObject jSONObject;
        Context context = e.f12405a;
        if (o.f12430a == null) {
            synchronized (o.class) {
                if (o.f12430a == null) {
                    o.f12430a = new o(context);
                }
            }
        }
        o oVar = o.f12430a;
        if (n.c(oVar.f12431b)) {
            oVar.f12432c.b("smart_lc", oVar.a() + 1);
        }
        String str = oVar.f12432c.f12433a + "smart_lt";
        String valueOf = String.valueOf(0);
        try {
            if (n.c(e.f12405a)) {
                valueOf = m.a().f12425b.getString(str, valueOf);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            i10 = Integer.parseInt(valueOf);
        } catch (Exception unused) {
            i10 = 0;
        }
        if (oVar.a() >= i10 && oVar.a("smart_")) {
            try {
                Context context2 = e.f12405a;
                String appkey = UMUtils.getAppkey(context2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(bt.al, UMUtils.getZid(context2));
                try {
                    jSONObject2.put("imei", DeviceConfig.getImeiNew(context2));
                    jSONObject2.put("oaid", DeviceConfig.getOaid(context2));
                } catch (Throwable unused2) {
                }
                try {
                    jSONObject2.put("idfa", DeviceConfig.getIdfa(context2));
                } catch (Throwable unused3) {
                }
                jSONObject2.put(bt.f10046g, UMUtils.getUMId(context2));
                jSONObject2.put("android_id", DeviceConfig.getAndroidId(context2));
                jSONObject2.put("sdk_v", "1.1.4");
                jSONObject2.put("os_v", Build.VERSION.RELEASE);
                jSONObject2.put("lvl", Build.VERSION.SDK_INT);
                String[] networkAccessMode = UMUtils.getNetworkAccessMode(context2);
                if (TextUtils.isEmpty(networkAccessMode[0])) {
                    networkAccessMode[0] = "Unknown";
                }
                jSONObject2.put("net", networkAccessMode[0]);
                jSONObject2.put(Constants.KEY_BRAND, n.b());
                long a10 = oVar.f12432c.a("smart_ts", 0L);
                if (a10 > 0) {
                    jSONObject2.put("last", a10);
                }
                try {
                    jSONObject = e.a(jSONObject2, "https://ccs.umeng.com/ra", appkey, false);
                } catch (Exception unused4) {
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    oVar.a(7200L);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    oVar.a(7200L);
                    return;
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("aa");
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                }
                int optInt = optJSONObject2.optInt("launch", 5);
                o.a aVar = oVar.f12432c;
                aVar.a(aVar.f12433a + "smart_lt", String.valueOf(optInt));
                if (oVar.a() < optInt) {
                    return;
                }
                oVar.a(optJSONObject.optLong("ttl", 86400L));
                long optLong = optJSONObject.optLong("id", -1L);
                if (optLong <= 0) {
                    return;
                }
                int max = Math.max(optJSONObject2.optInt(com.umeng.ccg.a.f10662v, 300), 100);
                int optInt2 = optJSONObject2.optInt("action", 1);
                int optInt3 = optJSONObject2.optInt("delay");
                if (optInt2 == 1 || optInt2 == 2) {
                    s.a(new a(this, context2, optInt2, max, appkey, optLong), optInt3, TimeUnit.SECONDS);
                }
            } catch (Throwable unused5) {
            }
        }
    }
}
