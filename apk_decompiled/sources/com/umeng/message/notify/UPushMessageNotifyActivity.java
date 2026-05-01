package com.umeng.message.notify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.umeng.message.proguard.aw;

/* loaded from: classes3.dex */
public final class UPushMessageNotifyActivity extends Activity {
    private void a(Intent intent) {
        try {
            aw a10 = aw.a();
            a10.b();
            a10.a(this, intent);
        } catch (Throwable unused) {
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(getIntent());
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }
}
