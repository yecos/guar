package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class cc implements cb {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10163a = "cache_domain";

    /* renamed from: b, reason: collision with root package name */
    private static volatile String f10164b = "";

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final cc f10165a = new cc();

        private a() {
        }
    }

    public static cc b() {
        return a.f10165a;
    }

    private void d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(UMGlobalContext.getAppContext());
        if (sharedPreferences != null) {
            f10164b = sharedPreferences.getString(f10163a, "");
        }
    }

    private void e() {
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(UMGlobalContext.getAppContext());
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(f10163a, f10164b).commit();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.cb
    public void a() {
    }

    public String c() {
        return f10164b;
    }

    private cc() {
        d();
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(Throwable th) {
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("Status") && jSONObject.getInt("Status") == 0 && jSONObject.has("Answer")) {
                String optString = jSONObject.optString("Answer");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                String optString2 = jSONObject.has("ip") ? jSONObject.optString("ip") : "";
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> domain下发结果：" + optString);
                if (!TextUtils.isEmpty(optString2)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 对应domain下发请求ip：" + optString2);
                }
                f10164b = optString;
                e();
            }
        } catch (Throwable unused) {
        }
    }
}
