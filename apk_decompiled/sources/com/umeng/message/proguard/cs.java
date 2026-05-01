package com.umeng.message.proguard;

import android.content.Context;
import android.os.Build;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.proguard.cq;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
final class cs extends cp {

    /* renamed from: a, reason: collision with root package name */
    private static final cp f11810a = new cs();

    private cs() {
    }

    public static cp a() {
        return f11810a;
    }

    @Override // com.umeng.message.proguard.cp
    public final synchronized void a(ck ckVar, boolean z10, cq.a aVar) {
        if (!z10) {
            if (aVar != null) {
                aVar.a("click invalid. start app fail!");
                return;
            } else {
                ce.a("Track", "click invalid. start app fail!");
                return;
            }
        }
        if (ckVar.f11740b.optBoolean("exposed_timeout", false)) {
            b(ckVar, 3000);
            ce.a("Track", "click invalid. exposed timeout!");
            return;
        }
        int optInt = ckVar.f11740b.optInt("clk_tp", 0);
        if (optInt == 1 || optInt == 2) {
            if (ckVar.f11740b.optBoolean("click_upload", false)) {
                ce.a("Track", "click has report.");
                return;
            }
            ckVar.f11750l = System.currentTimeMillis();
            JSONArray optJSONArray = ckVar.f11740b.optJSONArray("clk");
            long i10 = ckVar.i();
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                ce.b("Track", "click invalid. clk value empty!");
                return;
            }
            int length = optJSONArray.length();
            boolean z11 = true;
            for (int i11 = 0; i11 < length; i11++) {
                z11 &= cc.a(5, ckVar, optJSONArray.optString(i11).replaceAll("__TP__", String.valueOf(optInt)).replaceAll("__CD__", String.valueOf(i10)));
            }
            try {
                ckVar.f11740b.put("click_upload", z11);
            } catch (Exception unused) {
            }
            if (!z11) {
                if (aVar != null) {
                    aVar.a("click invalid. report fail, please check network!");
                    return;
                }
                ce.b("Track", "click invalid. report fail, please check network!");
            } else if (aVar != null) {
                aVar.a();
            }
        }
    }

    @Override // com.umeng.message.proguard.cp
    public final void a(final ck ckVar, final int i10, final int i11, final String str, final JSONObject jSONObject) {
        cb.b(new Runnable() { // from class: com.umeng.message.proguard.cs.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Context a10 = de.a();
                    String appkey = UMUtils.getAppkey(a10);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("sid", ckVar.c());
                    jSONObject2.put(com.umeng.analytics.pro.bt.al, UMUtils.getZid(a10));
                    jSONObject2.put("app_key", appkey);
                    jSONObject2.put("slot_type", bt.a(ckVar.f11739a));
                    jSONObject2.put("slot_id", ckVar.f11740b.optString("slot_id"));
                    jSONObject2.put("ts", System.currentTimeMillis());
                    jSONObject2.put("e", i10);
                    jSONObject2.put(Constants.KEY_HTTP_CODE, i11);
                    jSONObject2.put(Constant.KEY_MSG, str);
                    jSONObject2.put("imei_md5", ca.f(a10));
                    try {
                        jSONObject2.put("oaid", ca.c(a10));
                        jSONObject2.put("idfa", ca.a(a10));
                    } catch (Throwable unused) {
                    }
                    if (i10 == 2) {
                        jSONObject2.put("imp_dura", ckVar.i());
                    }
                    jSONObject2.put("android_id", ca.b(a10));
                    jSONObject2.put("v", "2.0");
                    jSONObject2.put("sdk_version", "2.0.0");
                    jSONObject2.put("os", "android");
                    jSONObject2.put(com.umeng.analytics.pro.bt.f10064y, Build.VERSION.RELEASE);
                    jSONObject2.put(Constants.KEY_BRAND, ca.c());
                    jSONObject2.put(Constants.KEY_MODEL, ca.b());
                    jSONObject2.put("data", jSONObject);
                    cc.a(jSONObject2, bu.f11676b, appkey);
                } catch (Throwable th) {
                    ce.a("Track", "report event:", Integer.valueOf(i10), " error:", th.getMessage());
                }
            }
        });
    }

    @Override // com.umeng.message.proguard.cp
    public final synchronized void a(ck ckVar, cq.a aVar) {
        if (ckVar.f11740b.optBoolean("expose_upload", false)) {
            return;
        }
        if (ckVar.f11740b.optBoolean("exposed_timeout", false)) {
            String str = "expose invalid. load -> show timeout, interval:" + ckVar.h();
            if (aVar != null) {
                aVar.a(str);
                return;
            } else {
                ce.a("Track", str);
                return;
            }
        }
        ckVar.f11749k = System.currentTimeMillis();
        JSONArray optJSONArray = ckVar.f11740b.optJSONArray("win");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                cc.a(10, ckVar, optJSONArray.optString(i10));
            }
        }
        JSONArray optJSONArray2 = ckVar.f11740b.optJSONArray(com.umeng.analytics.pro.bd.f9976c);
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            int length2 = optJSONArray2.length();
            boolean z10 = true;
            for (int i11 = 0; i11 < length2; i11++) {
                z10 &= cc.a(4, ckVar, optJSONArray2.optString(i11));
            }
            try {
                ckVar.f11740b.put("expose_upload", z10);
            } catch (Exception unused) {
            }
            if (!z10) {
                if (aVar != null) {
                    aVar.a("expose invalid. report fail, please check network!");
                    return;
                }
                ce.b("Track", "expose invalid. report fail, please check network!");
            } else if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        ce.a("Track", "expose invalid. imp value empty.");
    }

    @Override // com.umeng.message.proguard.cp
    public final void a(String str, ck ckVar) {
        JSONArray optJSONArray = ckVar.f11740b.optJSONArray(str);
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return;
        }
        int length = optJSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            String optString = optJSONArray.optString(i10);
            if (optString != null && optString.length() > 0) {
                cc.a(8, ckVar, optString);
            }
        }
    }

    @Override // com.umeng.message.proguard.cp
    public final boolean a(ck ckVar) {
        JSONArray optJSONArray = ckVar.f11740b.optJSONArray("pck");
        boolean z10 = true;
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                String optString = optJSONArray.optString(i10);
                if (optString != null && optString.length() > 0) {
                    z10 = cc.a(optString);
                }
                if (!z10) {
                    break;
                }
            }
        }
        return z10;
    }
}
