package com.umeng.analytics.vshelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.q;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b implements cd {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10639a = "RealTimeDebugSwitch";

    /* renamed from: b, reason: collision with root package name */
    private static volatile int f10640b;

    @Override // com.umeng.analytics.pro.cd
    public void a() {
    }

    @Override // com.umeng.analytics.pro.cd
    public void b() {
    }

    @Override // com.umeng.analytics.pro.cd
    public void c() {
    }

    @Override // com.umeng.analytics.pro.cd
    public void d(Activity activity) {
        f10640b--;
    }

    @Override // com.umeng.analytics.pro.cd
    public void e(Activity activity) {
    }

    public static boolean d() {
        return f10640b > 0;
    }

    @Override // com.umeng.analytics.pro.cd
    public void a(Activity activity) {
    }

    @Override // com.umeng.analytics.pro.cd
    public void b(Activity activity) {
    }

    @Override // com.umeng.analytics.pro.cd
    public void c(Activity activity) {
        f10640b++;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    @Override // com.umeng.analytics.pro.cd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Activity activity, Bundle bundle) {
        long longValue;
        if (f10640b != 0) {
            return;
        }
        Intent intent = activity.getIntent();
        if (intent != null) {
            Uri data = intent.getData();
            if (data != null) {
                String scheme = data.getScheme();
                if (scheme != null && scheme.startsWith("um.")) {
                    String queryParameter = data.getQueryParameter("debugkey");
                    String queryParameter2 = data.getQueryParameter(AnalyticsConfig.DEBUG_MODE_PERIOD);
                    if (TextUtils.isEmpty(queryParameter)) {
                        return;
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        try {
                            longValue = Long.valueOf(queryParameter2).longValue();
                        } catch (Throwable unused) {
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("debugkey", queryParameter);
                        if (longValue >= 0) {
                            if (AnalyticsConfig.isRealTimeDebugMode()) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> call turnOffRealTimeDebug because sendaging < 0");
                                AnalyticsConfig.turnOffRealTimeDebug();
                                Context applicationContext = activity.getApplicationContext();
                                UMWorkDispatch.sendEvent(applicationContext, q.a.G, CoreProtocol.getInstance(applicationContext), null);
                                return;
                            }
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Not currently in RealTimeDebug mode and doing nothing.");
                            return;
                        }
                        if (longValue > 0) {
                            AnalyticsConfig.turnOnRealTimeDebug(hashMap);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(AnalyticsConfig.RTD_START_TIME, System.currentTimeMillis());
                                if (longValue < 60) {
                                    longValue = 60;
                                }
                                if (longValue > 240) {
                                    longValue = 240;
                                }
                                jSONObject.put("period", longValue);
                                jSONObject.put("debugkey", queryParameter);
                            } catch (Throwable unused2) {
                            }
                            Context applicationContext2 = activity.getApplicationContext();
                            UMWorkDispatch.sendEvent(applicationContext2, q.a.F, CoreProtocol.getInstance(applicationContext2), jSONObject);
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> turnOnRealTimeDebug[persistent] dk: " + queryParameter + "; period: " + longValue);
                            return;
                        }
                        AnalyticsConfig.turnOnRealTimeDebug(hashMap);
                        Context applicationContext3 = activity.getApplicationContext();
                        UMWorkDispatch.sendEvent(applicationContext3, q.a.G, CoreProtocol.getInstance(applicationContext3), null);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> turnOnRealTimeDebug[non-persistent] dk: " + queryParameter);
                        return;
                    }
                    longValue = 0;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("debugkey", queryParameter);
                    if (longValue >= 0) {
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> scheme: " + scheme);
                }
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> uri: " + data);
            }
        } else {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> intent: " + intent);
        }
    }

    @Override // com.umeng.analytics.pro.cd
    public void b(Activity activity, Bundle bundle) {
    }
}
