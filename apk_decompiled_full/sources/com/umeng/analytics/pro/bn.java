package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.heytap.openid.sdk.OpenIDSDK;

/* loaded from: classes3.dex */
public class bn implements be {

    /* renamed from: a, reason: collision with root package name */
    private boolean f10029a = false;

    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f10029a) {
            OpenIDSDK.a(context);
            this.f10029a = true;
        }
        boolean a10 = OpenIDSDK.a();
        bs.a("getOAID", "isSupported", Boolean.valueOf(a10));
        if (a10) {
            return OpenIDSDK.c(context);
        }
        return null;
    }
}
