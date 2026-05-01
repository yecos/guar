package com.umeng.message.component;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.taobao.agoo.TaobaoBaseIntentService;
import com.umeng.message.UTrack;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.bb;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.r;
import com.umeng.message.proguard.v;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class UmengIntentService extends TaobaoBaseIntentService {
    @Override // org.android.agoo.control.BaseIntentService, android.app.Service
    public final IBinder onBind(Intent intent) {
        try {
            return super.onBind(intent);
        } catch (Throwable th) {
            UPLog.e("IntentService", th);
            return null;
        }
    }

    @Override // com.taobao.agoo.TaobaoBaseIntentService, org.android.agoo.control.BaseIntentService
    public final void onError(Context context, String str) {
        UPLog.e("IntentService", "onError msg:", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00cc  */
    @Override // com.taobao.agoo.TaobaoBaseIntentService, org.android.agoo.control.BaseIntentService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMessage(Context context, Intent intent) {
        String stringExtra;
        String stringExtra2;
        String stringExtra3;
        JSONObject optJSONObject;
        Class<?> cls;
        try {
            UPLog.i("IntentService", "onMessage");
            stringExtra = intent.getStringExtra("body");
            stringExtra2 = intent.getStringExtra("id");
            stringExtra3 = intent.getStringExtra(AgooConstants.MESSAGE_TASK_ID);
        } catch (Throwable th) {
            UPLog.e("IntentService", th);
        }
        if (stringExtra == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(stringExtra);
        jSONObject.put("agoo_msg_id", stringExtra2);
        jSONObject.put("agoo_task_id", stringExtra3);
        UMessage uMessage = new UMessage(jSONObject);
        bb.a(context).a(uMessage.getMsgId(), 0, System.currentTimeMillis());
        UTrack.getInstance().trackMsgArrival(uMessage);
        if (TextUtils.equals("ad", uMessage.getDisplayType())) {
            try {
                String custom = uMessage.getCustom();
                if (custom == null || custom.length() <= 0 || (optJSONObject = new JSONObject(custom).optJSONObject("id_res")) == null) {
                    return;
                }
                f.a(context, optJSONObject.optString("id"), optJSONObject.optLong("d_ts", 0L));
                return;
            } catch (Throwable th2) {
                UPLog.e("IntentService", th2);
                return;
            }
        }
        UPLog.i("IntentService", "message:", jSONObject);
        Intent intent2 = new Intent("com.umeng.message.action");
        intent2.setPackage(context.getPackageName());
        intent2.putExtra("um_command", "handle");
        intent2.putExtra("body", uMessage.getRaw().toString());
        String pushIntentServiceClass = v.a().getPushIntentServiceClass();
        if (!TextUtils.isEmpty(pushIntentServiceClass)) {
            try {
                cls = Class.forName(pushIntentServiceClass);
            } catch (Throwable th3) {
                UPLog.e("IntentService", th3);
            }
            if (cls == null) {
                cls = UmengMessageHandlerService.class;
            }
            intent2.setClass(context, cls);
            r.enqueueWork(context, cls, intent2);
            return;
        }
        cls = null;
        if (cls == null) {
        }
        intent2.setClass(context, cls);
        r.enqueueWork(context, cls, intent2);
        return;
        UPLog.e("IntentService", th);
    }

    @Override // com.taobao.agoo.TaobaoBaseIntentService, org.android.agoo.control.BaseIntentService
    public final void onRegistered(Context context, String str) {
    }

    @Override // com.taobao.agoo.TaobaoBaseIntentService
    public final void onUnregistered(Context context, String str) {
    }
}
