package com.umeng.message.proguard;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushMessageNotifyApi;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
final class ax {

    /* renamed from: a, reason: collision with root package name */
    UPushMessageNotifyApi.Callback f11601a;

    /* renamed from: b, reason: collision with root package name */
    final ay f11602b = new ay();

    /* renamed from: c, reason: collision with root package name */
    boolean f11603c;

    public final void a() {
        b.b(new Runnable() { // from class: com.umeng.message.proguard.ax.1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z10 = false;
                if (ax.this.f11602b.f11613a.b("sync", false)) {
                    boolean a10 = ax.this.f11602b.a();
                    try {
                        if (d.h(y.a())) {
                            z10 = ax.a(a10);
                        }
                    } catch (Throwable th) {
                        UPLog.e("Notify", th);
                    }
                    ax.this.f11602b.b(!z10);
                }
            }
        });
    }

    public final void a(Activity activity, final Intent intent) {
        this.f11603c = true;
        if (activity == null || intent == null) {
            return;
        }
        final Context applicationContext = activity.getApplicationContext();
        final String name = activity.getClass().getName();
        b.b(new Runnable() { // from class: com.umeng.message.proguard.ax.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    ax axVar = ax.this;
                    Context context = applicationContext;
                    Intent intent2 = intent;
                    String str = name;
                    axVar.f11602b.a(System.currentTimeMillis());
                    String stringExtra = intent2.getStringExtra("data");
                    String stringExtra2 = intent2.getStringExtra("pkg");
                    intent2.removeExtra("data");
                    intent2.removeExtra("pkg");
                    if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                        String str2 = new String(bf.a("dUxpNC9mNCtQYjM5LlQxOQ=="));
                        byte[] a10 = bf.a("bm1ldWcuZjkvT20rTDgyMw==");
                        String b10 = bk.b(stringExtra2, str2, a10);
                        String b11 = bk.b(stringExtra, str2, a10);
                        if (!TextUtils.isEmpty(b11) && !TextUtils.isEmpty(b10)) {
                            JSONObject jSONObject = new JSONObject(b11);
                            jSONObject.put("activity", str);
                            ay ayVar = axVar.f11602b;
                            String jSONObject2 = jSONObject.toString();
                            String str3 = null;
                            if (jSONObject2 != null) {
                                try {
                                    str3 = bf.a(jSONObject2.getBytes());
                                } catch (Exception unused) {
                                }
                            }
                            ayVar.f11613a.a("info", str3);
                            jSONObject.put("action_type", 71);
                            jSONObject.put("device_token", PushAgent.getInstance(context).getRegistrationId());
                            jSONObject.put("msg_id", "");
                            jSONObject.put("pa", "");
                            jSONObject.put("ts", System.currentTimeMillis());
                            JSONObject jSONObject3 = new JSONObject();
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("din", d.c(context));
                            jSONObject4.put(com.umeng.analytics.pro.bt.aR, MsgConstant.SDK_VERSION);
                            jSONObject4.put("push_switch", d.p(context));
                            jSONObject3.put("header", jSONObject4);
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(jSONObject);
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("push", jSONArray);
                            jSONObject3.put("content", jSONObject5);
                            UMWorkDispatch.sendEvent(context, 16385, w.a(), jSONObject3.toString());
                            try {
                                UPushMessageNotifyApi.Callback callback = axVar.f11601a;
                                if (callback != null) {
                                    callback.onNotified();
                                    axVar.f11603c = false;
                                    return;
                                }
                                return;
                            } catch (Throwable unused2) {
                                return;
                            }
                        }
                        axVar.f11602b.a(0L);
                        return;
                    }
                    axVar.f11602b.a(0L);
                } catch (Throwable th) {
                    UPLog.e("Notify", th);
                }
            }
        });
    }

    public static boolean a(boolean z10) {
        JSONObject jSONObject;
        Application a10 = y.a();
        String zid = UMUtils.getZid(a10);
        if (TextUtils.isEmpty(zid)) {
            UPLog.i("Notify", "zid skip.");
            return false;
        }
        String messageAppkey = PushAgent.getInstance(a10).getMessageAppkey();
        if (TextUtils.isEmpty(messageAppkey)) {
            UPLog.i("Notify", "appkey skip.");
            return false;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(com.umeng.analytics.pro.bt.al, zid);
        jSONObject2.put("ts", System.currentTimeMillis());
        jSONObject2.put("appkey", messageAppkey);
        jSONObject2.put("dps", z10 ? 1 : 0);
        try {
            jSONObject = g.a(jSONObject2, "https://offmsg.umeng.com/v2/offmsg/switch", messageAppkey, false);
        } catch (Exception e10) {
            UPLog.i("Notify", "uploadEnableState error:", e10.getMessage());
            jSONObject = null;
        }
        return jSONObject != null;
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4) {
        try {
            String messageAppkey = PushAgent.getInstance(context).getMessageAppkey();
            ComponentName componentName = new ComponentName(str3, str4);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("trace_id", str2);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appkey", messageAppkey);
            jSONObject2.put("pkg", context.getPackageName());
            jSONObject2.put("activity", str);
            jSONObject2.put(ITagManager.SUCCESS, 1);
            jSONArray.put(jSONObject2);
            jSONObject.put("pusor", jSONArray);
            String jSONObject3 = jSONObject.toString();
            String str5 = new String(bf.a("dUxpNC9mNCtQYjM5LlQxOQ=="));
            byte[] a10 = bf.a("bm1ldWcuZjkvT20rTDgyMw==");
            String a11 = bk.a(context.getPackageName(), str5, a10);
            String a12 = bk.a(jSONObject3, str5, a10);
            Intent intent = new Intent();
            intent.putExtra("data", a12);
            intent.putExtra("pkg", a11);
            intent.setPackage(str3);
            intent.setComponent(componentName);
            intent.setFlags(268468224);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            if (this.f11602b.c()) {
                String d10 = this.f11602b.d();
                if (TextUtils.isEmpty(d10)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(d10);
                jSONObject.put("activity", jSONObject2.optString("activity"));
                jSONObject.put("pusor", jSONObject2.optJSONArray("pusor"));
                jSONObject.put("trace_id", jSONObject2.optString("trace_id"));
            }
        } catch (Throwable th) {
            UPLog.e("Notify", "handle msg arrived error:", th);
        }
    }
}
