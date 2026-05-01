package com.uyumao;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.hpplay.component.protocol.PlistBuilder;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.uyumao.g;
import com.uyumao.sdk.UYMManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
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
    */
    public void a(Object obj, int i10) {
        LocationManager locationManager;
        JSONArray a10;
        LocationManager locationManager2;
        Future<?> future;
        String str = "network";
        JSONObject jSONObject = null;
        if (i10 == 202) {
            if (f12398l) {
                return;
            }
            Context context = f12393g;
            LocationListener locationListener = f12400n;
            if (context != null && locationListener != null) {
                try {
                    if (com.uyumao.e.a(context, "android.permission.ACCESS_FINE_LOCATION") && com.uyumao.e.a(context, "android.permission.ACCESS_COARSE_LOCATION") && (locationManager = (LocationManager) context.getSystemService("location")) != null) {
                        locationManager.removeUpdates(locationListener);
                    }
                } catch (Throwable unused) {
                }
            }
            f12396j = null;
            g.a(f12393g, 203, e.f12404a, f12397k);
            return;
        }
        try {
            if (i10 != 203) {
                switch (i10) {
                    case 101:
                        if (com.uyumao.e.b().booleanValue() && obj != null && (obj instanceof JSONObject)) {
                            JSONArray e10 = f12389c ? com.uyumao.e.e(f12393g) : null;
                            JSONArray f10 = f12390d ? com.uyumao.e.f(f12393g) : null;
                            if (e10 != null || f10 != null) {
                                JSONObject a11 = a(f12393g);
                                a(a11, (JSONObject) obj);
                                try {
                                    JSONObject jSONObject2 = new JSONObject(a11.toString());
                                    if (e10 != null) {
                                        try {
                                            jSONObject2.put("wifi", e10);
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    if (f10 != null) {
                                        jSONObject2.put("wifi_list", f10);
                                    }
                                    jSONObject = jSONObject2;
                                } catch (Throwable unused3) {
                                }
                                s.a(new b(this, jSONObject.toString()), 0L, TimeUnit.SECONDS);
                                break;
                            }
                        }
                        break;
                    case 102:
                        if (com.uyumao.e.b().booleanValue() && f12391e && obj != null && (obj instanceof JSONObject) && (a10 = com.uyumao.e.a(f12393g)) != null && a10.length() > 0) {
                            JSONObject a12 = a(f12393g);
                            a(a12, (JSONObject) obj);
                            try {
                                JSONObject jSONObject3 = new JSONObject(a12.toString());
                                try {
                                    jSONObject3.put("bs", a10);
                                } catch (Throwable unused4) {
                                }
                                jSONObject = jSONObject3;
                            } catch (Throwable unused5) {
                            }
                            s.a(new c(this, jSONObject.toString()), 0L, TimeUnit.SECONDS);
                            break;
                        }
                        break;
                    case 103:
                        if (com.uyumao.e.b().booleanValue() && obj != null && (obj instanceof JSONObject)) {
                            f12397k = (JSONObject) obj;
                            if (f12388b) {
                                f12395i = com.uyumao.e.b(f12393g);
                            }
                            if (f12387a) {
                                Context context2 = f12393g;
                                LocationListener locationListener2 = f12400n;
                                if (context2 != null && locationListener2 != null) {
                                    try {
                                        if (com.uyumao.e.a(context2, "android.permission.ACCESS_FINE_LOCATION") && com.uyumao.e.a(context2, "android.permission.ACCESS_COARSE_LOCATION") && (locationManager2 = (LocationManager) context2.getSystemService("location")) != null) {
                                            List<String> providers = locationManager2.getProviders(true);
                                            if (!providers.contains("gps")) {
                                                break;
                                            } else {
                                                str = "gps";
                                            }
                                            locationManager2.requestSingleUpdate(str, locationListener2, (Looper) null);
                                        }
                                    } catch (Throwable unused6) {
                                    }
                                }
                                g.a(f12393g, 256, 202, e.f12404a, f12397k, NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS);
                            } else {
                                g.a(f12393g, 203, e.f12404a, f12397k);
                                break;
                            }
                        }
                        break;
                    case 104:
                        if (f12392f && obj != null && (obj instanceof JSONObject)) {
                            JSONObject jSONObject4 = (JSONObject) obj;
                            WeakReference<Future<?>> weakReference = com.uyumao.e.f12407c;
                            if (weakReference != null && (future = weakReference.get()) != null && !future.isDone() && !future.isCancelled()) {
                                break;
                            } else {
                                com.uyumao.e.f12407c = new WeakReference<>(s.a(new r(jSONObject4)));
                                break;
                            }
                        }
                        break;
                }
                return;
            }
            if ((f12395i == null && f12396j == null) || obj == null || !(obj instanceof JSONObject)) {
                return;
            }
            JSONObject a13 = a(f12393g);
            a(a13, f12397k);
            JSONArray a14 = com.uyumao.e.a(f12395i, f12396j);
            try {
                JSONObject jSONObject5 = new JSONObject(a13.toString());
                try {
                    jSONObject5.put("lbs", a14);
                } catch (Throwable unused7) {
                }
                jSONObject = jSONObject5;
            } catch (Throwable unused8) {
            }
            s.a(new RunnableC0203d(this, jSONObject.toString()), 0L, TimeUnit.SECONDS);
        } catch (Throwable unused9) {
        }
    }
}
