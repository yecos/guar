package com.efs.sdk.base.core.config.remote;

import android.content.SharedPreferences;
import com.efs.sdk.base.core.b.h;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import java.io.File;
import java.util.Map;

/* loaded from: classes.dex */
public final class d implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a, reason: collision with root package name */
    volatile SharedPreferences f6164a;

    public static void b() {
        File a10 = com.efs.sdk.base.core.util.a.a(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (a10.exists()) {
            a10.delete();
        }
    }

    private void d() {
        if (this.f6164a == null) {
            synchronized (com.efs.sdk.base.core.b.c.class) {
                if (this.f6164a == null) {
                    this.f6164a = SharedPreferencesUtils.getSharedPreferences(ControllerCenter.getGlobalEnvStruct().mAppContext, EncodeUtil.base64EncodeToStr(("config_" + ControllerCenter.getGlobalEnvStruct().getAppid().toLowerCase()).getBytes()));
                    this.f6164a.registerOnSharedPreferenceChangeListener(this);
                }
            }
        }
    }

    public final boolean a(RemoteConfig remoteConfig) {
        c();
        if (this.f6164a == null) {
            return false;
        }
        SharedPreferences.Editor edit = this.f6164a.edit();
        edit.clear();
        edit.putInt("cver", remoteConfig.mConfigVersion);
        edit.putLong("last_refresh_time", System.currentTimeMillis());
        for (Map.Entry<String, String> entry : remoteConfig.mSDKConfigMap.entrySet()) {
            edit.putString(entry.getKey(), entry.getValue());
        }
        edit.putString("sign", remoteConfig.f6142a);
        edit.apply();
        return true;
    }

    public final void c() {
        try {
            d();
        } catch (Throwable th) {
            Log.e("efs.config", "init sharedpreferences error", th);
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        h hVar;
        hVar = h.a.f6096a;
        if (hVar.a()) {
            return;
        }
        b.a().b();
    }

    public static boolean a() {
        GlobalEnvStruct globalEnvStruct = ControllerCenter.getGlobalEnvStruct();
        File b10 = com.efs.sdk.base.core.util.a.b(globalEnvStruct.mAppContext, globalEnvStruct.getAppid());
        if (!b10.exists()) {
            return false;
        }
        FileUtil.delete(b10);
        return true;
    }
}
