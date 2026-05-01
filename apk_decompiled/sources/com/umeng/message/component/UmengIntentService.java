package com.umeng.message.component;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.taobao.agoo.TaobaoBaseIntentService;
import com.umeng.message.common.UPLog;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMessage(android.content.Context r11, android.content.Intent r12) {
        /*
            r10 = this;
            java.lang.String r0 = "id"
            java.lang.String r1 = "body"
            java.lang.String r2 = "IntentService"
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r5 = "onMessage"
            r6 = 0
            r4[r6] = r5     // Catch: java.lang.Throwable -> Ld5
            com.umeng.message.common.UPLog.i(r2, r4)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = r12.getStringExtra(r1)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r5 = r12.getStringExtra(r0)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r7 = "task_id"
            java.lang.String r12 = r12.getStringExtra(r7)     // Catch: java.lang.Throwable -> Ld5
            if (r4 != 0) goto L22
            return
        L22:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Ld5
            r7.<init>(r4)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = "agoo_msg_id"
            r7.put(r4, r5)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = "agoo_task_id"
            r7.put(r4, r12)     // Catch: java.lang.Throwable -> Ld5
            com.umeng.message.entity.UMessage r12 = new com.umeng.message.entity.UMessage     // Catch: java.lang.Throwable -> Ld5
            r12.<init>(r7)     // Catch: java.lang.Throwable -> Ld5
            com.umeng.message.proguard.bb r4 = com.umeng.message.proguard.bb.a(r11)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r5 = r12.getMsgId()     // Catch: java.lang.Throwable -> Ld5
            long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Ld5
            r4.a(r5, r6, r8)     // Catch: java.lang.Throwable -> Ld5
            com.umeng.message.UTrack r4 = com.umeng.message.UTrack.getInstance()     // Catch: java.lang.Throwable -> Ld5
            r4.trackMsgArrival(r12)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = "ad"
            java.lang.String r5 = r12.getDisplayType()     // Catch: java.lang.Throwable -> Ld5
            boolean r4 = android.text.TextUtils.equals(r4, r5)     // Catch: java.lang.Throwable -> Ld5
            if (r4 == 0) goto L86
            java.lang.String r12 = r12.getCustom()     // Catch: java.lang.Throwable -> L81
            if (r12 == 0) goto L80
            int r1 = r12.length()     // Catch: java.lang.Throwable -> L81
            if (r1 <= 0) goto L80
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L81
            r1.<init>(r12)     // Catch: java.lang.Throwable -> L81
            java.lang.String r12 = "id_res"
            org.json.JSONObject r12 = r1.optJSONObject(r12)     // Catch: java.lang.Throwable -> L81
            if (r12 == 0) goto L80
            java.lang.String r0 = r12.optString(r0)     // Catch: java.lang.Throwable -> L81
            java.lang.String r1 = "d_ts"
            r3 = 0
            long r3 = r12.optLong(r1, r3)     // Catch: java.lang.Throwable -> L81
            com.umeng.message.proguard.f.a(r11, r0, r3)     // Catch: java.lang.Throwable -> L81
        L80:
            return
        L81:
            r11 = move-exception
            com.umeng.message.common.UPLog.e(r2, r11)     // Catch: java.lang.Throwable -> Ld5
            return
        L86:
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = "message:"
            r0[r6] = r4     // Catch: java.lang.Throwable -> Ld5
            r0[r3] = r7     // Catch: java.lang.Throwable -> Ld5
            com.umeng.message.common.UPLog.i(r2, r0)     // Catch: java.lang.Throwable -> Ld5
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = "com.umeng.message.action"
            r0.<init>(r3)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = r11.getPackageName()     // Catch: java.lang.Throwable -> Ld5
            r0.setPackage(r3)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = "um_command"
            java.lang.String r4 = "handle"
            r0.putExtra(r3, r4)     // Catch: java.lang.Throwable -> Ld5
            org.json.JSONObject r12 = r12.getRaw()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> Ld5
            r0.putExtra(r1, r12)     // Catch: java.lang.Throwable -> Ld5
            com.umeng.message.api.UPushApi r12 = com.umeng.message.proguard.v.a()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r12 = r12.getPushIntentServiceClass()     // Catch: java.lang.Throwable -> Ld5
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> Ld5
            if (r1 != 0) goto Lc9
            java.lang.Class r12 = java.lang.Class.forName(r12)     // Catch: java.lang.Throwable -> Lc5
            goto Lca
        Lc5:
            r12 = move-exception
            com.umeng.message.common.UPLog.e(r2, r12)     // Catch: java.lang.Throwable -> Ld5
        Lc9:
            r12 = 0
        Lca:
            if (r12 != 0) goto Lce
            java.lang.Class<com.umeng.message.component.UmengMessageHandlerService> r12 = com.umeng.message.component.UmengMessageHandlerService.class
        Lce:
            r0.setClass(r11, r12)     // Catch: java.lang.Throwable -> Ld5
            com.umeng.message.proguard.r.enqueueWork(r11, r12, r0)     // Catch: java.lang.Throwable -> Ld5
            return
        Ld5:
            r11 = move-exception
            com.umeng.message.common.UPLog.e(r2, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.component.UmengIntentService.onMessage(android.content.Context, android.content.Intent):void");
    }

    @Override // com.taobao.agoo.TaobaoBaseIntentService, org.android.agoo.control.BaseIntentService
    public final void onRegistered(Context context, String str) {
    }

    @Override // com.taobao.agoo.TaobaoBaseIntentService
    public final void onUnregistered(Context context, String str) {
    }
}
