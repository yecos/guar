package com.efs.sdk.base.core.config.remote;

import android.text.TextUtils;
import com.efs.sdk.base.IConfigRefreshAction;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.http.HttpResponse;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class a implements IConfigRefreshAction {

    /* renamed from: com.efs.sdk.base.core.config.remote.a$a, reason: collision with other inner class name */
    public static class C0093a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f6147a = new a();
    }

    public static a a() {
        return C0093a.f6147a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b2, code lost:
    
        com.efs.sdk.base.core.util.Log.i("efs.config", "config request succ, config is:\n ".concat(java.lang.String.valueOf(r2)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bf, code lost:
    
        return r2;
     */
    @Override // com.efs.sdk.base.IConfigRefreshAction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String refresh() {
        String str = "";
        if (!NetworkUtil.isConnected(ControllerCenter.getGlobalEnvStruct().mAppContext)) {
            Log.i("efs.config", "Config refresh fail, network is disconnected.");
            return "";
        }
        String a10 = b.a().a(true);
        com.efs.sdk.base.core.a.c a11 = com.efs.sdk.base.core.a.c.a();
        int i10 = 0;
        while (true) {
            if (i10 >= 3) {
                break;
            }
            com.efs.sdk.base.core.a.a a12 = com.efs.sdk.base.core.a.a.a();
            String b10 = a11.b();
            if (a12.f6047a) {
                Log.i("efs.px.api", "get config from server, wpkHeader is ".concat(String.valueOf(b10)));
            }
            String str2 = a10 + "/apm_cc";
            if (a12.f6047a) {
                Log.i("efs.px.api", "get config from server, url is ".concat(String.valueOf(str2)));
            }
            HashMap hashMap = new HashMap(1);
            hashMap.put("wpk-header", b10);
            com.efs.sdk.base.core.util.a.c a13 = new com.efs.sdk.base.core.util.a.d(str2).a(hashMap).a(com.efs.sdk.base.core.a.b.a()).a();
            a13.f6234a.f6231e = "get";
            HttpResponse a14 = a13.a();
            if (a14.succ) {
                str = a14.data;
                break;
            }
            if (TextUtils.isEmpty(a14.getBizCode()) || !"1000".equals(a14.getBizCode())) {
                break;
            }
            i10++;
        }
        return "";
    }
}
