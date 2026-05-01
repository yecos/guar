package com.umeng.message.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.material.badge.BadgeDrawable;
import com.umeng.message.UTrack;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.ad;
import com.umeng.message.proguard.az;
import com.umeng.message.proguard.v;
import com.umeng.message.proguard.x;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class UmengNotificationClickActivity extends Activity {
    private void a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("MSG");
            if (stringExtra != null && stringExtra.length() != 0) {
                UMessage uMessage = new UMessage(new JSONObject(stringExtra));
                UTrack.getInstance().trackMsgClick(uMessage);
                Context applicationContext = getApplicationContext();
                UPLog.i("NotificationClick", uMessage.getRaw());
                UPushMessageHandler notificationClickHandler = v.a().getNotificationClickHandler();
                if (notificationClickHandler != null) {
                    notificationClickHandler.handleMessage(applicationContext, uMessage);
                } else {
                    UPLog.i("NotificationClick", "handle == null skipped!");
                }
                x a10 = x.a();
                ad a11 = a10.a(uMessage.getMsgId());
                if (a11 != null) {
                    a10.b(a11);
                    az.a(a11);
                }
            }
        } catch (Throwable th) {
            try {
                UPLog.e("NotificationClick", th);
            } finally {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = 1;
            attributes.height = 1;
            attributes.gravity = BadgeDrawable.TOP_START;
            window.setAttributes(attributes);
            a(getIntent());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            a(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
