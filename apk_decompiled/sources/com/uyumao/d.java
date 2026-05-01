package com.uyumao;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.hpplay.component.protocol.PlistBuilder;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.uyumao.g;
import com.uyumao.sdk.UYMManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class d implements g.a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f12387a = true;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f12388b = true;

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f12389c = true;

    /* renamed from: d, reason: collision with root package name */
    public static volatile boolean f12390d = true;

    /* renamed from: e, reason: collision with root package name */
    public static volatile boolean f12391e = true;

    /* renamed from: f, reason: collision with root package name */
    public static volatile boolean f12392f = true;

    /* renamed from: g, reason: collision with root package name */
    public static Context f12393g = null;

    /* renamed from: h, reason: collision with root package name */
    public static JSONObject f12394h = null;

    /* renamed from: i, reason: collision with root package name */
    public static JSONObject f12395i = null;

    /* renamed from: j, reason: collision with root package name */
    public static JSONObject f12396j = null;

    /* renamed from: k, reason: collision with root package name */
    public static JSONObject f12397k = null;

    /* renamed from: l, reason: collision with root package name */
    public static volatile boolean f12398l = false;

    /* renamed from: m, reason: collision with root package name */
    public static Map<String, Integer> f12399m;

    /* renamed from: n, reason: collision with root package name */
    public static LocationListener f12400n;

    public static class a implements LocationListener {
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            boolean unused = d.f12398l = true;
            try {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                long time = location.getTime();
                double altitude = location.hasAltitude() ? location.getAltitude() : 0.0d;
                double speed = location.hasSpeed() ? location.getSpeed() : 0.0d;
                JSONObject jSONObject = new JSONObject();
                d.f12396j = jSONObject;
                jSONObject.put("lat", latitude);
                d.f12396j.put("lng", longitude);
                d.f12396j.put("alt", altitude);
                d.f12396j.put("acc", speed);
                d.f12396j.put("lts", time);
                g.a(d.f12393g, 203, e.f12404a, d.f12397k);
            } catch (Throwable unused2) {
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i10, Bundle bundle) {
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12401a;

        public b(d dVar, String str) {
            this.f12401a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.a(d.f12393g, "https://yumao.puata.info/cc_info", this.f12401a);
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12402a;

        public c(d dVar, String str) {
            this.f12402a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.a(d.f12393g, "https://yumao.puata.info/cc_info", this.f12402a);
        }
    }

    /* renamed from: com.uyumao.d$d, reason: collision with other inner class name */
    public class RunnableC0203d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f12403a;

        public RunnableC0203d(d dVar, String str) {
            this.f12403a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.a(d.f12393g, "https://yumao.puata.info/cc_info", this.f12403a);
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public static final d f12404a = new d();
    }

    static {
        HashMap hashMap = new HashMap();
        f12399m = hashMap;
        hashMap.put(com.umeng.ccg.a.f10642b, 101);
        f12399m.put(com.umeng.ccg.a.f10643c, 102);
        f12399m.put(com.umeng.ccg.a.f10644d, 103);
        f12399m.put(com.umeng.ccg.a.f10645e, 104);
        f12400n = new a();
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            Object optString = jSONObject2.optString(com.umeng.ccg.a.f10658r);
            String optString2 = jSONObject2.optString(com.umeng.ccg.a.f10661u);
            jSONObject.put(com.umeng.ccg.a.f10658r, optString);
            String[] split = optString2.split(",");
            JSONArray jSONArray = new JSONArray();
            for (String str : split) {
                jSONArray.put(str);
            }
            jSONObject.put(com.umeng.ccg.a.f10661u, jSONArray);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject a(Context context) {
        JSONObject jSONObject = f12394h;
        if (jSONObject != null && jSONObject.length() > 0) {
            return f12394h;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("os", "Android");
            jSONObject2.put("dm", Build.MODEL);
            jSONObject2.put("av", DeviceConfig.getAppVersionName(context));
            jSONObject2.put(bt.f10046g, UMUtils.getUMId(context));
            jSONObject2.put("ov", Build.VERSION.RELEASE);
            jSONObject2.put("chn", UMUtils.getChannel(context));
            if (UMUtils.getActiveUser(context) != null && UMUtils.getActiveUser(context).length == 2) {
                jSONObject2.put(com.umeng.analytics.pro.f.N, UMUtils.getActiveUser(context)[1]);
            } else {
                jSONObject2.put(com.umeng.analytics.pro.f.N, "");
            }
            jSONObject2.put(bt.al, UMUtils.getZid(context));
            jSONObject2.put("sv", UYMManager.getSdkVersion());
            jSONObject2.put("ak", UMUtils.getAppkey(context));
            jSONObject2.put("idfa", DeviceConfig.getIdfa(context));
            jSONObject2.put("db", Build.BRAND);
            jSONObject2.put("aid", DeviceConfig.getAndroidId(context));
            jSONObject2.put("oaid", DeviceConfig.getOaid(context));
            jSONObject2.put("imei", DeviceConfig.getImeiNew(context));
            jSONObject2.put("boa", Build.BOARD);
            jSONObject2.put("mant", Build.TIME);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            jSONObject2.put(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_CT, localeInfo[0]);
            jSONObject2.put("lang", localeInfo[1]);
            jSONObject2.put("tz", DeviceConfig.getTimeZone(context));
            jSONObject2.put("pkg", DeviceConfig.getPackageName(context));
            jSONObject2.put("disn", DeviceConfig.getAppName(context));
            String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
            if ("Wi-Fi".equals(networkAccessMode[0])) {
                jSONObject2.put("ac", "wifi");
            } else if ("2G/3G".equals(networkAccessMode[0])) {
                jSONObject2.put("ac", "2G/3G");
            } else {
                jSONObject2.put("ac", "unknown");
            }
            if (!"".equals(networkAccessMode[1])) {
                jSONObject2.put(PlistBuilder.KEY_AUDIO_SOCKET_TYPE, networkAccessMode[1]);
            }
            jSONObject2.put("nt", DeviceConfig.getNetworkType(context));
            String deviceToken = UMUtils.getDeviceToken(context);
            if (!TextUtils.isEmpty(deviceToken)) {
                jSONObject2.put("device_token", deviceToken);
            }
            f12394h = jSONObject2;
        } catch (Throwable unused) {
        }
        return f12394h;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ad, code lost:
    
        if (r5.contains("network") != false) goto L52;
     */
    @Override // com.uyumao.g.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.Object r19, int r20) {
        /*
            Method dump skipped, instructions count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.d.a(java.lang.Object, int):void");
    }
}
