package com.umeng.message.component;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.LruCache;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.f;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.message.api.UPushSettingCallback;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.h;
import com.umeng.message.proguard.j;
import com.umeng.message.proguard.o;
import com.umeng.message.proguard.r;
import com.umeng.message.proguard.v;
import com.umeng.message.proguard.w;
import com.umeng.message.proguard.y;
import com.umeng.message.proguard.z;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class UmengMessageHandlerService extends r {

    /* renamed from: a, reason: collision with root package name */
    private static final LruCache<String, String> f11354a = new LruCache<>(3);

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f11355b = 0;

    @Override // com.umeng.message.proguard.r
    public final void onHandleWork(Intent intent) {
        UPushMessageHandler messageHandler;
        final Application a10 = y.a();
        if (a10 == null) {
            UPLog.i("MsgHandlerService", "context null!");
        }
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra("um_command");
        UPLog.i("MsgHandlerService", "action:", action, stringExtra);
        if (TextUtils.equals("com.umeng.message.action", action)) {
            if (stringExtra == null || stringExtra.length() == 0) {
                return;
            }
            switch (stringExtra) {
                case "enable":
                    try {
                        boolean booleanExtra = intent.getBooleanExtra(Constant.KEY_STATUS, false);
                        UPushSettingCallback settingCallback = v.a().getSettingCallback();
                        UPLog.i("MsgHandlerService", "push open status:".concat(String.valueOf(booleanExtra)));
                        if (!booleanExtra) {
                            if (settingCallback != null) {
                                settingCallback.onFailure(intent.getStringExtra(Constants.KEY_HTTP_CODE), intent.getStringExtra("desc"));
                                break;
                            }
                        } else if (settingCallback != null) {
                            settingCallback.onSuccess();
                            break;
                        }
                    } catch (Throwable th) {
                        UPLog.e("MsgHandlerService", th);
                        return;
                    }
                    break;
                case "handle":
                    try {
                        String stringExtra2 = intent.getStringExtra("body");
                        if (stringExtra2 != null) {
                            UMessage uMessage = new UMessage(new JSONObject(stringExtra2));
                            if ((!"notification".equals(uMessage.getDisplayType()) || !uMessage.hasResourceFromInternet() || !j.a().a(intent)) && (messageHandler = v.a().getMessageHandler()) != null) {
                                messageHandler.handleMessage(a10, uMessage);
                                break;
                            }
                        }
                    } catch (Throwable th2) {
                        UPLog.e("MsgHandlerService", th2);
                        return;
                    }
                    break;
                case "register":
                    try {
                        final String stringExtra3 = intent.getStringExtra("registration_id");
                        boolean booleanExtra2 = intent.getBooleanExtra(Constant.KEY_STATUS, false);
                        UPLog.i("MsgHandlerService", "deviceToken:", stringExtra3, "status:", Boolean.valueOf(booleanExtra2));
                        final UPushRegisterCallback registerCallback = v.a().getRegisterCallback();
                        try {
                            if (!booleanExtra2) {
                                if (registerCallback != null) {
                                    registerCallback.onFailure(intent.getStringExtra(Constants.KEY_HTTP_CODE), intent.getStringExtra("desc"));
                                    break;
                                }
                            } else {
                                b.c(new Runnable() { // from class: com.umeng.message.component.UmengMessageHandlerService.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        final String str = "";
                                        try {
                                            MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a10);
                                            str = messageSharedPrefs.l();
                                            String str2 = stringExtra3;
                                            if (str2 != null && str != null && !str2.equals(str)) {
                                                String str3 = stringExtra3;
                                                if (str3 == null) {
                                                    messageSharedPrefs.f11344b.a("device_token");
                                                } else {
                                                    messageSharedPrefs.f11344b.a("device_token", str3);
                                                }
                                                Context context = a10;
                                                messageSharedPrefs.f11344b.a("has_register");
                                                messageSharedPrefs.f11344b.a(f.f10334p);
                                                messageSharedPrefs.f11344b.a("re_pop_times");
                                                messageSharedPrefs.f11344b.a("re_pop_cfg");
                                                messageSharedPrefs.f11344b.a("tags");
                                                messageSharedPrefs.f11344b.a("tag_remain");
                                                messageSharedPrefs.b("tag_add_");
                                                messageSharedPrefs.b("tag_del_");
                                                messageSharedPrefs.b("tag_get_");
                                                messageSharedPrefs.b("alias_del_");
                                                messageSharedPrefs.b("alias_set_");
                                                messageSharedPrefs.b("alias_add_");
                                                try {
                                                    context.getContentResolver().delete(h.b(context), null, null);
                                                } catch (Throwable th3) {
                                                    UPLog.e("Prefs", th3);
                                                }
                                            }
                                        } catch (Throwable th4) {
                                            UPLog.e("MsgHandlerService", th4);
                                        }
                                        try {
                                            UPushRegisterCallback uPushRegisterCallback = registerCallback;
                                            if (uPushRegisterCallback != null) {
                                                uPushRegisterCallback.onSuccess(stringExtra3);
                                            }
                                        } catch (Throwable th5) {
                                            UPLog.e("MsgHandlerService", th5);
                                        }
                                        final z a11 = z.a();
                                        if (!z.c()) {
                                            final MessageSharedPrefs messageSharedPrefs2 = MessageSharedPrefs.getInstance(y.a());
                                            if (!messageSharedPrefs2.f11344b.b("has_register", false) && !z.f12220a) {
                                                z.f12220a = true;
                                                b.c(new Runnable() { // from class: com.umeng.message.proguard.z.3

                                                    /* renamed from: a */
                                                    final /* synthetic */ String f12230a;

                                                    /* renamed from: b */
                                                    final /* synthetic */ MessageSharedPrefs f12231b;

                                                    public AnonymousClass3(final String str4, final MessageSharedPrefs messageSharedPrefs22) {
                                                        r2 = str4;
                                                        r3 = messageSharedPrefs22;
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        try {
                                                            z.this.f12223c.a(r2);
                                                            UPLog.i("Track", "trackRegister deviceToken:", r3.l());
                                                        } catch (Throwable th6) {
                                                            try {
                                                                UPLog.e("Track", th6);
                                                            } finally {
                                                                z.e();
                                                            }
                                                        }
                                                    }
                                                });
                                            }
                                        }
                                        v.a().onAppStart();
                                        o.a();
                                    }
                                });
                                break;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            UPLog.e("MsgHandlerService", th);
                            return;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                    break;
                case "send":
                    try {
                        String stringExtra4 = intent.getStringExtra("send_message");
                        if (stringExtra4 != null) {
                            String stringExtra5 = intent.getStringExtra("um_px_path");
                            JSONObject jSONObject = new JSONObject(stringExtra4);
                            jSONObject.put("um_px_path", stringExtra5);
                            UMWorkDispatch.sendEvent(a10, 16388, w.a(), jSONObject.toString());
                            break;
                        }
                    } catch (Throwable th5) {
                        UPLog.e("MsgHandlerService", th5);
                        return;
                    }
                    break;
                case "third_token":
                    try {
                        String stringExtra6 = intent.getStringExtra("third_token");
                        String a11 = com.umeng.message.proguard.f.a(intent.getStringExtra("type"));
                        if (!TextUtils.isEmpty(a11) && !TextUtils.isEmpty(stringExtra6)) {
                            LruCache<String, String> lruCache = f11354a;
                            if (!TextUtils.equals(lruCache.get(a11), stringExtra6)) {
                                UPLog.i("MsgHandlerService", "third push type:", a11, "token:", stringExtra6);
                                UPushThirdTokenCallback thirdTokenCallback = v.a().getThirdTokenCallback();
                                if (thirdTokenCallback != null) {
                                    thirdTokenCallback.onToken(a11, stringExtra6);
                                } else {
                                    String pushIntentServiceClass = v.a().getPushIntentServiceClass();
                                    if (!TextUtils.isEmpty(pushIntentServiceClass)) {
                                        Class<?> cls = Class.forName(pushIntentServiceClass);
                                        Intent intent2 = new Intent();
                                        intent2.setPackage(a10.getPackageName());
                                        intent2.putExtra("um_command", "third_token");
                                        intent2.putExtra("third_token", stringExtra6);
                                        intent2.putExtra("type", a11);
                                        intent2.setClass(a10, cls);
                                        r.enqueueWork(a10, cls, intent2);
                                    }
                                }
                                lruCache.put(a11, stringExtra6);
                                break;
                            } else {
                                UPLog.i("MsgHandlerService", "third push callback skipped! already called.");
                                break;
                            }
                        }
                        UPLog.i("MsgHandlerService", "third push skipped! type:", a11, "token:", stringExtra6);
                    } catch (Throwable th6) {
                        UPLog.e("MsgHandlerService", th6);
                        return;
                    }
                    break;
                case "disable":
                    try {
                        boolean booleanExtra3 = intent.getBooleanExtra(Constant.KEY_STATUS, false);
                        UPushSettingCallback settingCallback2 = v.a().getSettingCallback();
                        UPLog.i("MsgHandlerService", "push close status:".concat(String.valueOf(booleanExtra3)));
                        if (!booleanExtra3) {
                            if (settingCallback2 != null) {
                                settingCallback2.onFailure(intent.getStringExtra(Constants.KEY_HTTP_CODE), intent.getStringExtra("desc"));
                                break;
                            }
                        } else if (settingCallback2 != null) {
                            settingCallback2.onSuccess();
                            break;
                        }
                    } catch (Throwable th7) {
                        UPLog.e("MsgHandlerService", th7);
                        return;
                    }
                    break;
            }
        }
    }
}
