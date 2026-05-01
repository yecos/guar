package com.umeng.message;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.agoo.BaseNotifyClick;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.bj;
import com.umeng.message.proguard.y;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class UmengNotifyClick extends BaseNotifyClick {
    private static final String TAG = "NotifyClickActivity";

    public void onChangeBadgeNumber(UMessage uMessage) {
        Application a10 = y.a();
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a10);
        if (TextUtils.equals(uMessage.getMsgId(), messageSharedPrefs.f())) {
            return;
        }
        messageSharedPrefs.c(uMessage.getMsgId());
        bj.b(a10, -1);
    }

    @Override // com.taobao.agoo.BaseNotifyClick
    public final void onMessage(Intent intent) {
        UMessage uMessage = null;
        try {
            String stringExtra = intent.getStringExtra("body");
            UPLog.i(TAG, "msg:", stringExtra, "source:", intent.getStringExtra(AgooConstants.MESSAGE_SOURCE));
            onMessageReceived(intent);
            if (stringExtra != null && stringExtra.length() != 0) {
                String stringExtra2 = intent.getStringExtra("id");
                String stringExtra3 = intent.getStringExtra(AgooConstants.MESSAGE_TASK_ID);
                int intExtra = intent.getIntExtra("channel", -1);
                JSONObject jSONObject = new JSONObject(stringExtra);
                jSONObject.put("agoo_msg_id", stringExtra2);
                jSONObject.put("agoo_task_id", stringExtra3);
                UMessage uMessage2 = new UMessage(jSONObject);
                try {
                    UTrack.getInstance().trackMfrPushMsgClick(uMessage2, intExtra);
                    onChangeBadgeNumber(uMessage2);
                    try {
                        onMessage(uMessage2);
                        return;
                    } catch (Throwable th) {
                        UPLog.e(TAG, th);
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    uMessage = uMessage2;
                    try {
                        UPLog.e(TAG, th);
                        if (uMessage == null) {
                            try {
                            } catch (Throwable th3) {
                                return;
                            }
                        }
                        return;
                    } finally {
                        if (uMessage == null) {
                            try {
                                uMessage = new UMessage(new JSONObject());
                            } catch (Throwable th32) {
                                UPLog.e(TAG, th32);
                            }
                        }
                        onMessage(uMessage);
                    }
                }
            }
            try {
                onMessage(new UMessage(new JSONObject()));
            } catch (Throwable th4) {
                UPLog.e(TAG, th4);
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public abstract void onMessage(UMessage uMessage);

    public void onMessageReceived(Intent intent) {
    }
}
