package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.miui.deviceid.IdentifierManager;

/* loaded from: classes3.dex */
class bq implements be {
    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean a10 = IdentifierManager.a();
        bs.a("getOAID", "isSupported", Boolean.valueOf(a10));
        if (a10) {
            return IdentifierManager.b(context);
        }
        return null;
    }
}
