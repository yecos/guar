package com.umeng.powersdk;

import android.app.Activity;
import android.os.BatteryManager;
import android.os.Build;
import com.efs.sdk.base.core.config.GlobalInfoManager;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    int f12317a;

    /* renamed from: b, reason: collision with root package name */
    int f12318b;

    /* renamed from: c, reason: collision with root package name */
    int f12319c;

    /* renamed from: d, reason: collision with root package name */
    WeakReference<Activity> f12320d;

    /* renamed from: e, reason: collision with root package name */
    boolean f12321e;

    /* renamed from: f, reason: collision with root package name */
    int f12322f;

    /* renamed from: g, reason: collision with root package name */
    boolean f12323g;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f12333a = new c(0);
    }

    private c() {
        this.f12317a = 1;
        this.f12318b = 0;
        this.f12319c = 0;
        this.f12321e = true;
    }

    public final JSONObject a() {
        BatteryManager batteryManager;
        long longProperty;
        JSONObject jSONObject = new JSONObject();
        try {
            if (Build.VERSION.SDK_INT >= 21 && (batteryManager = (BatteryManager) PowerManager.getApplicationContext().getSystemService("batterymanager")) != null) {
                longProperty = batteryManager.getLongProperty(2);
                float f10 = longProperty;
                if (f10 >= 10000.0f || f10 <= -10000.0f) {
                    f10 /= 1000.0f;
                }
                jSONObject.put("ci", Math.abs(f10));
            }
        } catch (Throwable unused) {
        }
        try {
            com.umeng.powersdk.a a10 = b.a(PowerManager.getApplicationContext()).a();
            jSONObject.put("le", a10.f12309a);
            jSONObject.put("vo", a10.f12310b);
            jSONObject.put("te", a10.f12311c);
            jSONObject.put("st", a10.f12312d);
            jSONObject.put("ch", a10.f12313e);
            jSONObject.put("ts", a10.f12314f);
            try {
                long longValue = ((Long) GlobalInfoManager.getInstance().getGlobalInfo().getGlobalInfoMap().get("stime")).longValue();
                if (longValue > 0) {
                    jSONObject.put("ptime", System.currentTimeMillis() - longValue);
                }
            } catch (Throwable unused2) {
            }
            WeakReference<Activity> weakReference = this.f12320d;
            if (weakReference != null) {
                jSONObject.put("c_act", weakReference.get().getClass().getName());
            }
        } catch (Throwable unused3) {
        }
        return jSONObject;
    }

    public /* synthetic */ c(byte b10) {
        this();
    }
}
