package com.umeng.message.proguard;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.api.UPushAliasCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.component.UmengMessageHandlerService;
import java.util.Iterator;
import java.util.List;
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
    */
    public final void a(String str, int i10, String str2) {
        Object obj;
        List notificationChannels;
        String id;
        Object id2;
        CharSequence name;
        int importance;
        String id3;
        CharSequence name2;
        int importance2;
        Application a10 = y.a();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("header", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("ts", System.currentTimeMillis());
        Object obj2 = "";
        jSONObject3.put("pa", "");
        jSONObject3.put("msg_id", str);
        jSONObject3.put("action_type", i10);
        JSONArray jSONArray = new JSONArray();
        int i11 = -1;
        if (Build.VERSION.SDK_INT < 26 || TextUtils.isEmpty(str2) || (r8 = (NotificationManager) a10.getSystemService("notification")) == null || notificationChannels == null) {
            obj = "";
        } else {
            Iterator it = notificationChannels.iterator();
            obj = "";
            while (it.hasNext()) {
                NotificationChannel a11 = b0.a(it.next());
                id = a11.getId();
                Object obj3 = obj2;
                if (TextUtils.equals(str2, id)) {
                    id2 = a11.getId();
                    name = a11.getName();
                    Object valueOf = String.valueOf(name);
                    importance = a11.getImportance();
                    obj2 = id2;
                    obj = valueOf;
                    i11 = importance;
                } else {
                    JSONObject jSONObject4 = new JSONObject();
                    id3 = a11.getId();
                    jSONObject4.put("chan_id", id3);
                    name2 = a11.getName();
                    jSONObject4.put("chan_name", String.valueOf(name2));
                    importance2 = a11.getImportance();
                    jSONObject4.put("chan_imp", importance2);
                    jSONArray.put(jSONObject4);
                    obj2 = obj3;
                }
            }
        }
        jSONObject3.put("chan_id", obj2);
        jSONObject3.put("chan_name", obj);
        jSONObject3.put("chan_imp", i11);
        jSONObject3.put("ext_chan_stat", jSONArray);
        jSONObject3.put("fg_stat", u.c() ? 1 : 0);
        jSONObject3.put("device_token", MessageSharedPrefs.getInstance(a10).l());
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject3);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("push", jSONArray2);
        jSONObject.put("content", jSONObject5);
        if (f.b(a10)) {
            jSONObject2.put(com.umeng.analytics.pro.bt.aR, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", d.c(a10));
            jSONObject2.put("push_switch", d.p(a10));
            UMWorkDispatch.sendEvent(a10, 16391, w.a(), jSONObject.toString());
        } else {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("jsonHeader", jSONObject2);
            jSONObject6.put("jsonBody", jSONObject5);
            jSONObject6.put("msgId", str);
            jSONObject6.put("actionType", i10);
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(a10.getPackageName());
            intent.setClass(a10, UmengMessageHandlerService.class);
            intent.putExtra("um_command", "send");
            intent.putExtra("um_px_path", "umpx_push_logs");
            intent.putExtra("send_message", jSONObject6.toString());
            r.enqueueWork(a10, UmengMessageHandlerService.class, intent);
        }
        UPLog.i("Track", "sendMsgShow:", jSONObject);
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
    */
    public final void a(String str, String str2, int i10) {
        Object obj;
        List notificationChannels;
        String id;
        String id2;
        CharSequence name;
        int importance;
        CharSequence name2;
        Application a10 = y.a();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("header", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("ts", System.currentTimeMillis());
        Object obj2 = "";
        jSONObject3.put("pa", "");
        jSONObject3.put("msg_id", str);
        jSONObject3.put("action_type", 9);
        jSONObject3.put("repop_count", i10);
        JSONArray jSONArray = new JSONArray();
        int i11 = -1;
        if (Build.VERSION.SDK_INT < 26 || TextUtils.isEmpty(str2) || (r8 = (NotificationManager) a10.getSystemService("notification")) == null || notificationChannels == null) {
            obj = "";
        } else {
            Iterator it = notificationChannels.iterator();
            obj = "";
            while (it.hasNext()) {
                NotificationChannel a11 = b0.a(it.next());
                id = a11.getId();
                if (TextUtils.equals(str2, id)) {
                    obj2 = a11.getId();
                    name2 = a11.getName();
                    obj = String.valueOf(name2);
                    i11 = a11.getImportance();
                } else {
                    JSONObject jSONObject4 = new JSONObject();
                    Object obj3 = obj2;
                    id2 = a11.getId();
                    jSONObject4.put("chan_id", id2);
                    name = a11.getName();
                    jSONObject4.put("chan_name", String.valueOf(name));
                    importance = a11.getImportance();
                    jSONObject4.put("chan_imp", importance);
                    jSONArray.put(jSONObject4);
                    obj2 = obj3;
                }
            }
        }
        jSONObject3.put("chan_id", obj2);
        jSONObject3.put("chan_name", obj);
        jSONObject3.put("chan_imp", i11);
        jSONObject3.put("ext_chan_stat", jSONArray);
        jSONObject3.put("fg_stat", u.c() ? 1 : 0);
        jSONObject3.put("device_token", MessageSharedPrefs.getInstance(a10).l());
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject3);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("push", jSONArray2);
        jSONObject.put("content", jSONObject5);
        if (f.b(a10)) {
            jSONObject2.put(com.umeng.analytics.pro.bt.aR, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", d.c(a10));
            jSONObject2.put("push_switch", d.p(a10));
            UMWorkDispatch.sendEvent(a10, 16392, w.a(), jSONObject.toString());
        } else {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("jsonHeader", jSONObject2);
            jSONObject6.put("jsonBody", jSONObject5);
            jSONObject6.put("msgId", str);
            jSONObject6.put("actionType", 9);
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(a10.getPackageName());
            intent.setClass(a10, UmengMessageHandlerService.class);
            intent.putExtra("um_command", "send");
            intent.putExtra("um_px_path", "umpx_push_logs");
            intent.putExtra("send_message", jSONObject6.toString());
            r.enqueueWork(a10, UmengMessageHandlerService.class, intent);
        }
        UPLog.i("Track", "sendMsgRepost:", jSONObject);
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
