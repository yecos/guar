package com.alibaba.sdk.android.utils;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback;
import com.alibaba.sdk.android.utils.crashdefend.c;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class AlicloudTrackerManager {

    /* renamed from: a, reason: collision with root package name */
    private static AlicloudTrackerManager f5979a;

    /* renamed from: a, reason: collision with other field name */
    private a f42a = new a();

    /* renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.utils.crashdefend.b f43a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, AlicloudTracker> f5980b;

    private AlicloudTrackerManager(Application application) {
        this.f43a = null;
        HashMap hashMap = new HashMap(4);
        hashMap.put("kVersion", "2.0.0");
        hashMap.put(Constants.KEY_PACKAGE_NAME, application.getPackageName());
        this.f42a.a(application, hashMap);
        this.f5980b = new HashMap();
        this.f43a = com.alibaba.sdk.android.utils.crashdefend.b.a(application, this.f42a);
    }

    public static synchronized AlicloudTrackerManager getInstance(Application application) {
        synchronized (AlicloudTrackerManager.class) {
            if (application == null) {
                return null;
            }
            if (f5979a == null) {
                f5979a = new AlicloudTrackerManager(application);
            }
            return f5979a;
        }
    }

    public AlicloudTracker getTracker(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e("AlicloudTrackerManager", "sdkId or sdkVersion is null");
            return null;
        }
        String str3 = str + str2;
        if (this.f5980b.containsKey(str3)) {
            return this.f5980b.get(str3);
        }
        AlicloudTracker alicloudTracker = new AlicloudTracker(this.f42a, str, str2);
        this.f5980b.put(str3, alicloudTracker);
        return alicloudTracker;
    }

    public boolean registerCrashDefend(String str, String str2, int i10, int i11, SDKMessageCallback sDKMessageCallback) {
        if (this.f43a == null) {
            return false;
        }
        c cVar = new c();
        cVar.f52a = str;
        cVar.f54b = str2;
        cVar.f5992a = i10;
        cVar.f5993b = i11;
        return this.f43a.m25a(cVar, sDKMessageCallback);
    }

    public void unregisterCrashDefend(String str, String str2) {
        this.f43a.b(str, str2);
    }
}
