package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.vivo.identifier.IdentifierManager;

/* loaded from: classes3.dex */
public class bp implements be {
    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean a10 = IdentifierManager.a(context);
        bs.a("getOAID", "isSupported", Boolean.valueOf(a10));
        if (a10) {
            return IdentifierManager.b(context);
        }
        return null;
    }
}
