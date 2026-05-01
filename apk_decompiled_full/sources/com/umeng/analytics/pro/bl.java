package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.meizu.flyme.openidsdk.OpenIdHelper;

/* loaded from: classes3.dex */
class bl implements be {
    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean a10 = OpenIdHelper.a();
        bs.a("getOAID", "isSupported", Boolean.valueOf(a10));
        if (a10) {
            return OpenIdHelper.b(context);
        }
        return null;
    }
}
