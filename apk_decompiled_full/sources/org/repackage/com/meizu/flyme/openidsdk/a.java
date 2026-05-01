package org.repackage.com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class a extends BroadcastReceiver {
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0043, code lost:
    
        if (r0 == 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
    
        if (android.text.TextUtils.equals(r6.getStringExtra("openIdPackage"), r5.getPackageName()) != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002d, code lost:
    
        r1 = true;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        boolean z10 = false;
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        b.a("shouldUpdateId, notifyFlag : ".concat(String.valueOf(intExtra)));
        if (intExtra != 1) {
            if (intExtra == 2) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
                if (stringArrayListExtra != null) {
                    z10 = stringArrayListExtra.contains(context.getPackageName());
                }
            }
            if (z10) {
                String stringExtra = intent.getStringExtra("openIdType");
                b a10 = b.a();
                OpenId openId = "oaid".equals(stringExtra) ? a10.f17896b : "vaid".equals(stringExtra) ? a10.f17898d : "aaid".equals(stringExtra) ? a10.f17897c : "udid".equals(stringExtra) ? a10.f17895a : null;
                if (openId == null) {
                    return;
                }
                openId.b();
            }
        }
    }
}
