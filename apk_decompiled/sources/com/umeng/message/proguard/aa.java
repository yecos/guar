package com.umeng.message.proguard;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.api.UPushAliasCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.component.UmengMessageHandlerService;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
final class aa extends ab {
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0058, code lost:
    
        r8 = r8.getNotificationChannels();
     */
    @Override // com.umeng.message.proguard.ab
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r18, int r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.aa.a(java.lang.String, int, java.lang.String):void");
    }

    @Override // com.umeng.message.proguard.ab
    public final void b(String str, int i10) {
        Application a10 = y.a();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("header", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("ts", System.currentTimeMillis());
        jSONObject3.put("pa", "");
        jSONObject3.put("msg_id", str);
        jSONObject3.put("action_type", 21);
        if (i10 >= 0) {
            jSONObject3.put("chan_name", i10);
        }
        jSONObject3.put("device_token", MessageSharedPrefs.getInstance(a10).l());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("push", jSONArray);
        jSONObject.put("content", jSONObject4);
        if (f.b(a10)) {
            jSONObject2.put(com.umeng.analytics.pro.bt.aR, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", d.c(a10));
            jSONObject2.put("push_switch", d.p(a10));
            UMWorkDispatch.sendEvent(a10, 16385, w.a(), jSONObject.toString());
        } else {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("jsonHeader", jSONObject2);
            jSONObject5.put("jsonBody", jSONObject4);
            jSONObject5.put("msgId", str);
            jSONObject5.put("actionType", 21);
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(a10.getPackageName());
            intent.setClass(a10, UmengMessageHandlerService.class);
            intent.putExtra("um_command", "send");
            intent.putExtra("um_px_path", "umpx_push_logs");
            intent.putExtra("send_message", jSONObject5.toString());
            r.enqueueWork(a10, UmengMessageHandlerService.class, intent);
        }
        UPLog.i("Track", "sendMfrMsgClick:", jSONObject);
    }

    @Override // com.umeng.message.proguard.ab
    public final void c(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) {
        Application a10 = y.a();
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a10);
        JSONObject a11 = g.a(jSONObject, "https://msg.umengcloud.com/v3/alias/delete", UMUtils.getAppkey(a10));
        if (a11 == null || !TextUtils.equals(a11.getString("success"), ITagManager.SUCCESS)) {
            uPushAliasCallback.onMessage(true, "alias:" + str + ", type:" + str2 + " delete failed.");
            return;
        }
        try {
            messageSharedPrefs.f11343a.getContentResolver().delete(h.a(messageSharedPrefs.f11343a), "type=? and alias=?", new String[]{str2, str});
        } catch (Exception e10) {
            UPLog.e("Prefs", e10);
        }
        messageSharedPrefs.a("alias_del_", a11.optLong(com.umeng.analytics.pro.bt.f10040ba));
        uPushAliasCallback.onMessage(true, "alias:" + str + ", type:" + str2 + " delete success.");
    }

    @Override // com.umeng.message.proguard.ab
    public final void b(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) {
        Application a10 = y.a();
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a10);
        String optString = jSONObject.optString(ITagManager.FAIL, "");
        String optString2 = jSONObject.optString("success", "");
        if (!TextUtils.isEmpty(optString)) {
            uPushAliasCallback.onMessage(false, "alias:" + str + " add failed.");
            return;
        }
        if (!TextUtils.isEmpty(optString2)) {
            uPushAliasCallback.onMessage(true, "alias:" + str + " already exist.");
            return;
        }
        JSONObject a11 = g.a(jSONObject, "https://msg.umengcloud.com/v3/alias/set", UMUtils.getAppkey(a10));
        if (a11 != null && TextUtils.equals(a11.optString("success", ""), ITagManager.SUCCESS)) {
            messageSharedPrefs.a(str, str2, 1, a11.optLong("ttl", 3600L));
            messageSharedPrefs.a("alias_set_", a11.optLong(com.umeng.analytics.pro.bt.f10040ba));
            uPushAliasCallback.onMessage(true, "alias:" + str + " add success.");
            return;
        }
        uPushAliasCallback.onMessage(false, "alias:" + str + " add failed.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x005f, code lost:
    
        r8 = r8.getNotificationChannels();
     */
    @Override // com.umeng.message.proguard.ab
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r17, java.lang.String r18, int r19) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.aa.a(java.lang.String, java.lang.String, int):void");
    }

    @Override // com.umeng.message.proguard.ab
    public final void a(String str, int i10) {
        Application a10 = y.a();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("header", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("ts", System.currentTimeMillis());
        jSONObject3.put("pa", "");
        jSONObject3.put("msg_id", str);
        jSONObject3.put("action_type", i10);
        jSONObject3.put("device_token", MessageSharedPrefs.getInstance(a10).l());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("push", jSONArray);
        jSONObject.put("content", jSONObject4);
        if (f.b(a10)) {
            jSONObject2.put(com.umeng.analytics.pro.bt.aR, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", d.c(a10));
            jSONObject2.put("push_switch", d.p(a10));
            UMWorkDispatch.sendEvent(a10, 16385, w.a(), jSONObject.toString());
        } else {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("jsonHeader", jSONObject2);
            jSONObject5.put("jsonBody", jSONObject4);
            jSONObject5.put("msgId", str);
            jSONObject5.put("actionType", i10);
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(a10.getPackageName());
            intent.setClass(a10, UmengMessageHandlerService.class);
            intent.putExtra("um_command", "send");
            intent.putExtra("um_px_path", "umpx_push_logs");
            intent.putExtra("send_message", jSONObject5.toString());
            r.enqueueWork(a10, UmengMessageHandlerService.class, intent);
        }
        UPLog.i("Track", "sendMsgLog:", jSONObject);
    }

    @Override // com.umeng.message.proguard.ab
    public final void a() {
        Application a10 = y.a();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("header", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("device_token", MessageSharedPrefs.getInstance(a10).l());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("push", jSONArray);
        jSONObject.put("content", jSONObject4);
        if (f.b(a10)) {
            jSONObject2.put(com.umeng.analytics.pro.bt.aR, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", d.c(a10));
            jSONObject2.put("push_switch", d.p(a10));
            UMWorkDispatch.sendEvent(a10, 16386, w.a(), jSONObject.toString());
        } else {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("jsonHeader", jSONObject2);
            jSONObject5.put("jsonBody", jSONObject4);
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(a10.getPackageName());
            intent.setClass(a10, UmengMessageHandlerService.class);
            intent.putExtra("um_command", "send");
            intent.putExtra("um_px_path", "umpx_push_launch");
            intent.putExtra("send_message", jSONObject5.toString());
            r.enqueueWork(a10, UmengMessageHandlerService.class, intent);
        }
        UPLog.i("Track", "sendLaunch:", jSONObject);
    }

    @Override // com.umeng.message.proguard.ab
    public final void a(String str) {
        Application a10 = y.a();
        if (f.b(a10)) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("din", d.c(a10));
            jSONObject2.put(com.umeng.analytics.pro.bt.aR, MsgConstant.SDK_VERSION);
            jSONObject2.put("push_switch", d.p(a10));
            jSONObject.put("header", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("device_token", MessageSharedPrefs.getInstance(a10).l());
            jSONObject3.put("old_device_token", str);
            try {
                if (f.c(a10)) {
                    jSONObject3.put("utdid_gen", 1);
                    String d10 = f.d(a10);
                    if (!TextUtils.isEmpty(d10)) {
                        jSONObject3.put("utdid_rst_id", d10);
                    }
                    f.e(a10);
                }
            } catch (Throwable unused) {
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("push", jSONArray);
            jSONObject.put("content", jSONObject4);
            UMWorkDispatch.sendEvent(a10, 16387, w.a(), jSONObject.toString());
            UPLog.i("Track", "sendRegister:", jSONObject);
        }
    }

    @Override // com.umeng.message.proguard.ab
    public final void a(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) {
        Application a10 = y.a();
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a10);
        String optString = jSONObject.optString(ITagManager.FAIL, "");
        String optString2 = jSONObject.optString("success", "");
        if (!TextUtils.isEmpty(optString)) {
            uPushAliasCallback.onMessage(false, "alias:" + str + " add failed.");
            return;
        }
        if (!TextUtils.isEmpty(optString2)) {
            uPushAliasCallback.onMessage(true, "alias:" + str + " already exist.");
            return;
        }
        JSONObject a11 = g.a(jSONObject, "https://msg.umengcloud.com/v3/alias", UMUtils.getAppkey(a10));
        if (a11 != null && TextUtils.equals(a11.optString("success", ""), ITagManager.SUCCESS)) {
            messageSharedPrefs.a(str, str2, 0, a11.optLong("ttl", 3600L));
            messageSharedPrefs.a("alias_add_", a11.optLong(com.umeng.analytics.pro.bt.f10040ba));
            uPushAliasCallback.onMessage(true, "alias:" + str + " add success.");
            return;
        }
        uPushAliasCallback.onMessage(false, "alias:" + str + " add failed.");
    }
}
