package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.analytics.pro.az;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ba implements az.a {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final ba f9953a = new ba();

        private a() {
        }
    }

    public static ba a() {
        return a.f9953a;
    }

    @Override // com.umeng.analytics.pro.az.a
    public void a(Object obj, int i10) {
        JSONObject a10;
        if (i10 != 101) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "[CkHandler]: unknown event type!");
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "[CkHandler]:recv CkDispatch.CHECK event!");
        Context appContext = UMGlobalContext.getAppContext();
        if (!UMConfigure.getInitStatus() || appContext == null || UMConfigure.needSendZcfgEnv(appContext) || com.umeng.commonsdk.utils.c.a() || FieldManager.allow(com.umeng.commonsdk.utils.d.aw) || SdkVersion.SDK_TYPE == 1 || !(obj instanceof bb)) {
            return;
        }
        try {
            JSONObject g10 = ((bb) obj).g();
            if (!g10.has("eID") || (a10 = bc.a(appContext)) == null) {
                return;
            }
            bc.a(a10, g10);
            av.a(new aq(aq.f9894c, a10, "appkey"), 0L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
        }
    }
}
