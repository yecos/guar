package com.umeng.message.proguard;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.proguard.bx;
import com.umeng.umzid.IZIDCompletionCallback;
import com.umeng.umzid.Spy;
import com.umeng.umzid.ZIDManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* loaded from: classes3.dex */
final class cj extends ch {

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f11733c = new AtomicInteger(0);

    /* renamed from: a, reason: collision with root package name */
    private final bx.c f11734a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f11735b = false;

    public cj(bx.c cVar) {
        this.f11734a = cVar;
    }

    private JSONObject b(cz czVar) {
        int b10;
        String str;
        if (this.f11735b) {
            ce.a("Load", "ad load too frequency");
            return null;
        }
        this.f11735b = true;
        try {
            if (dy.b()) {
                ce.d("Load", "silent mode skipped!");
                this.f11735b = false;
                return null;
            }
            if (czVar != null && !TextUtils.isEmpty(czVar.f11850a.f11679a)) {
                Context a10 = de.a();
                String appkey = UMUtils.getAppkey(a10);
                if (TextUtils.isEmpty(appkey)) {
                    ce.d("Load", "appkey empty! please call UMConfigure.init(...)");
                    this.f11735b = false;
                    return null;
                }
                String zid = UMUtils.getZid(a10);
                if (TextUtils.isEmpty(zid)) {
                    zid = a(a10, appkey);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("slot_id", czVar.f11850a.f11679a);
                jSONObject.put("v", "6.0");
                jSONObject.put("ts", System.currentTimeMillis());
                String[] networkAccessMode = UMUtils.getNetworkAccessMode(a10);
                if (TextUtils.isEmpty(networkAccessMode[0])) {
                    networkAccessMode[0] = "Unknown";
                }
                jSONObject.put(com.umeng.analytics.pro.bt.Q, networkAccessMode[0]);
                jSONObject.put(Constants.KEY_MODEL, ca.b());
                jSONObject.put(Constants.KEY_BRAND, ca.c());
                jSONObject.put("osv", Build.VERSION.RELEASE);
                jSONObject.put("os", "android");
                Point a11 = ed.a(a10);
                jSONObject.put(BrowserInfo.KEY_WIDTH, a11.x);
                jSONObject.put("h", a11.y);
                jSONObject.put("s", ed.a(a11));
                jSONObject.put("app_ver", UMUtils.getAppVersionName(a10));
                jSONObject.put("pkg_name", a10.getPackageName());
                jSONObject.put("app_name", UMUtils.getAppName(a10));
                jSONObject.put("app_key", appkey);
                jSONObject.put("sdk_ver", "2.0.0");
                jSONObject.put(com.umeng.analytics.pro.bd.f9977d, a(a10));
                boolean z10 = czVar.f11852c;
                jSONObject.put("render", 0);
                if (!TextUtils.isEmpty(ca.a())) {
                    jSONObject.put("ui_ver", ca.a());
                }
                dt a12 = dt.a();
                if ((a12.f12016a.b("as") == 1) && (b10 = a12.f12016a.b("an")) > 0) {
                    AtomicInteger atomicInteger = f11733c;
                    if (atomicInteger.getAndIncrement() % b10 == 0) {
                        atomicInteger.set(1);
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        try {
                            str = Spy.getTag(a10);
                        } catch (Throwable unused) {
                            str = null;
                        }
                        String str2 = str == null ? "" : str;
                        ce.a("Load", "get tag consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                        jSONObject.put(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_AT, str2);
                    }
                }
                String b11 = a12.f12016a.b("et", "");
                if (!TextUtils.isEmpty(b11)) {
                    jSONObject.put("et", b11);
                }
                jSONObject.put(com.umeng.analytics.pro.bt.f10046g, ca.d(a10));
                try {
                    jSONObject.put("oaid", ca.c(a10));
                    jSONObject.put("idfa", ca.a(a10));
                } catch (Throwable unused2) {
                }
                jSONObject.put("u2", ca.f(a10));
                jSONObject.put("imei", ca.e(a10));
                jSONObject.put("android_id", ca.b(a10));
                if (zid == null) {
                    zid = "";
                }
                jSONObject.put(com.umeng.analytics.pro.bt.al, zid);
                jSONObject.put("b_mark", a());
                jSONObject.put("u_mark", b());
                JSONObject a13 = cc.a(jSONObject, bu.f11675a, appkey);
                try {
                    a13.put("slot_id", czVar.f11850a.f11679a);
                } catch (Exception unused3) {
                }
                if (a13.optInt(Constants.KEY_HTTP_CODE, -1) == 0) {
                    String optString = a13.optString("et");
                    if (optString.length() > 2048) {
                        a12.a("");
                    } else if (!TextUtils.equals(optString, b11)) {
                        a12.a(optString);
                    }
                }
                if (z10) {
                    int optInt = a13.optInt("cfg_interval", -1);
                    if (optInt != -1) {
                        long j10 = optInt;
                        if (j10 > 0) {
                            a12.f12016a.a(com.umeng.analytics.pro.bt.f10040ba, j10);
                        }
                    }
                    int optInt2 = a13.optInt("cfg_start", -1);
                    if (optInt2 != -1) {
                        long j11 = optInt2;
                        if (j11 > 0) {
                            a12.f12016a.a("delay", j11);
                        }
                    }
                }
                int optInt3 = a13.optInt("as");
                int optInt4 = a13.optInt("an");
                a12.f12016a.a("as", optInt3);
                a12.f12016a.a("an", optInt4);
                return a13;
            }
            ce.d("Load", "config error! please setSlotId");
            this.f11735b = false;
            return null;
        } finally {
        }
    }

    @Override // com.umeng.message.proguard.ch
    public final ck a(cz czVar) {
        try {
            try {
                JSONObject b10 = b(czVar);
                if (b10 == null) {
                    return new ck(this.f11734a, "request ad failure.");
                }
                int optInt = b10.optInt(Constants.KEY_HTTP_CODE, -1);
                if (optInt != 0) {
                    ce.b("Load", "sid:", b10.optString("sid", ""), " code:", Integer.valueOf(optInt), " msg:", b10.optString(Constant.KEY_MSG, ""));
                    return new ck(this.f11734a, "no ad, code:".concat(String.valueOf(optInt)));
                }
                int optInt2 = b10.optInt("after_clk");
                if (optInt2 > 0 && optInt2 <= 6 && optInt2 != 5) {
                    ck ckVar = new ck(b10);
                    if (!cr.a().b(ckVar)) {
                        ce.b("Load", "pre check false");
                        cr.a().b(ckVar, 2300);
                        return null;
                    }
                    bx.c cVar = ckVar.f11739a;
                    if (cVar == null) {
                        ce.b("Load", "ad type = null. error");
                        return null;
                    }
                    if (this.f11734a == cVar) {
                        ckVar.f11747i = System.currentTimeMillis();
                        return ckVar;
                    }
                    ce.b("Load", "ad type not match req:" + this.f11734a + " resp:" + cVar);
                    return null;
                }
                ce.b("Load", "after_clk error:", Integer.valueOf(optInt2));
                return null;
            } catch (Throwable th) {
                ce.d("Load", "load fail:", th.getMessage());
                return null;
            }
        } catch (Throwable th2) {
            ce.d("Load", "load ad ", th2.getMessage());
            return null;
        }
    }

    private String a(Context context, String str) {
        final AtomicReference atomicReference = new AtomicReference();
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ZIDManager.getInstance().init(context, str, new IZIDCompletionCallback() { // from class: com.umeng.message.proguard.cj.1
                @Override // com.umeng.umzid.IZIDCompletionCallback
                public final void onFailure(String str2, String str3) {
                    try {
                        countDownLatch.countDown();
                    } catch (Throwable unused) {
                    }
                }

                @Override // com.umeng.umzid.IZIDCompletionCallback
                public final void onSuccess(String str2) {
                    try {
                        atomicReference.set(str2);
                        countDownLatch.countDown();
                    } catch (Throwable unused) {
                    }
                }
            });
            countDownLatch.await(5L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
        }
        return (String) atomicReference.get();
    }

    private static String a(Context context) {
        if (dy.a(context)) {
            return dy.a();
        }
        String str = null;
        try {
            Cursor query = context.getContentResolver().query(cy.b(context), null, null, null, null);
            if (query != null && query.moveToFirst()) {
                str = query.getString(query.getColumnIndex(com.umeng.analytics.pro.bd.f9977d));
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable unused) {
        }
        return str == null ? "" : str;
    }

    private static String a() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/sys/kernel/random/boot_id"));
            String readLine = bufferedReader.readLine();
            r0 = readLine != null ? readLine : null;
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return r0;
    }

    private static Date a(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String b() {
        String str = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %x /data/data").getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\.");
                int i10 = 0;
                String str2 = (a(split[0]).getTime() / 1000) + ".";
                String str3 = split[1];
                String str4 = str3 != null ? str3.split(" ")[0] : "";
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        i10 = Integer.parseInt(str4);
                    } catch (Throwable unused) {
                    }
                    str = str2 + i10;
                } else {
                    str = str2 + 0;
                }
            }
            bufferedReader.close();
        } catch (Throwable unused2) {
        }
        return str;
    }
}
