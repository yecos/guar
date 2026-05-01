package com.umeng.message.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.message.UTrack;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.ad;
import com.umeng.message.proguard.az;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.v;
import com.umeng.message.proguard.x;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class UmengNotificationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        b.c(new Runnable() { // from class: com.umeng.message.component.UmengNotificationReceiver.1
            @Override // java.lang.Runnable
            public final void run() {
                String stringExtra;
                try {
                    Intent intent2 = intent;
                    if (intent2 == null || (stringExtra = intent2.getStringExtra("MSG")) == null) {
                        return;
                    }
                    int intExtra = intent.getIntExtra("ACTION", -1);
                    UPLog.i("NotificationProxy", String.format(Locale.getDefault(), "onReceive[msg=%s, action=%d]", stringExtra, Integer.valueOf(intExtra)));
                    UMessage uMessage = new UMessage(new JSONObject(stringExtra));
                    if (intExtra == 11) {
                        UPLog.i("NotificationProxy", "notification ignored!");
                        if (!TextUtils.isEmpty(uMessage.getMsgId())) {
                            UTrack.getInstance().trackMsgDismissed(uMessage);
                        }
                        uMessage.dismiss = true;
                        UPushMessageHandler notificationClickHandler = v.a().getNotificationClickHandler();
                        if (notificationClickHandler != null) {
                            notificationClickHandler.handleMessage(context, uMessage);
                        }
                    }
                    x a10 = x.a();
                    ad a11 = a10.a(uMessage.getMsgId());
                    if (a11 != null) {
                        a10.b(a11);
                        az.a(a11);
                    }
                } catch (Throwable th) {
                    UPLog.e("NotificationProxy", th);
                }
            }
        });
    }
}
