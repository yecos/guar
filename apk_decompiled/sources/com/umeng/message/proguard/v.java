package com.umeng.message.proguard;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.common.Constants;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.TaobaoRegister;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.UTrack;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.UmengMessageService;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.api.UPushAliasCallback;
import com.umeng.message.api.UPushApi;
import com.umeng.message.api.UPushConnectStateListener;
import com.umeng.message.api.UPushInAppMessageCallback;
import com.umeng.message.api.UPushInAppMessageHandler;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.api.UPushMessageNotifyApi;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.message.api.UPushSettingCallback;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.UPushNotificationChannel;
import com.umeng.message.component.UmengMessageHandlerService;
import com.umeng.message.tag.TagManager;

/* loaded from: classes3.dex */
public final class v implements UPushApi {

    /* renamed from: a, reason: collision with root package name */
    private boolean f12186a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f12187b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f12188c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f12189d;

    /* renamed from: e, reason: collision with root package name */
    private volatile UPushRegisterCallback f12190e;

    /* renamed from: f, reason: collision with root package name */
    private volatile UPushThirdTokenCallback f12191f;

    /* renamed from: g, reason: collision with root package name */
    private volatile UPushSettingCallback f12192g;

    /* renamed from: h, reason: collision with root package name */
    private volatile UPushMessageHandler f12193h;

    /* renamed from: i, reason: collision with root package name */
    private volatile UPushMessageHandler f12194i;

    /* renamed from: j, reason: collision with root package name */
    private volatile UPushInAppMessageCallback f12195j;

    /* renamed from: k, reason: collision with root package name */
    private volatile UPushInAppMessageHandler f12196k;

    /* renamed from: l, reason: collision with root package name */
    private volatile UPushConnectStateListener f12197l;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f12198m;

    /* renamed from: n, reason: collision with root package name */
    private volatile ACCSClient f12199n;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final v f12214a = new v(0);
    }

    public /* synthetic */ v(byte b10) {
        this();
    }

    public static /* synthetic */ boolean c(v vVar) {
        vVar.f12198m = true;
        return true;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void addAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        UTrack.getInstance().addAlias(str, str2, uPushAliasCallback);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void deleteAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        UTrack.getInstance().deleteAlias(str, str2, uPushAliasCallback);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void disable(UPushSettingCallback uPushSettingCallback) {
        setSettingCallback(uPushSettingCallback);
        try {
            final Application a10 = y.a();
            TaobaoRegister.unbindAgoo(a10, new ICallback() { // from class: com.umeng.message.proguard.v.6
                @Override // com.taobao.agoo.ICallback
                public final void onFailure(String str, String str2) {
                    UPLog.e("Mgr", "push disable failed. code:", str, "desc:", str2);
                    Intent intent = new Intent("com.umeng.message.action");
                    intent.setPackage(a10.getPackageName());
                    intent.setClass(a10, UmengMessageHandlerService.class);
                    intent.putExtra("um_command", "disable");
                    intent.putExtra(Constant.KEY_STATUS, false);
                    intent.putExtra(Constants.KEY_HTTP_CODE, str);
                    intent.putExtra("desc", str2);
                    r.enqueueWork(a10, UmengMessageHandlerService.class, intent);
                }

                @Override // com.taobao.agoo.ICallback
                public final void onSuccess() {
                    UPLog.i("Mgr", "push disable success.");
                    Intent intent = new Intent("com.umeng.message.action");
                    intent.setPackage(a10.getPackageName());
                    intent.setClass(a10, UmengMessageHandlerService.class);
                    intent.putExtra("um_command", "disable");
                    intent.putExtra(Constant.KEY_STATUS, true);
                    r.enqueueWork(a10, UmengMessageHandlerService.class, intent);
                }
            });
        } catch (Exception e10) {
            UPLog.e("Mgr", e10);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void enable(UPushSettingCallback uPushSettingCallback) {
        setSettingCallback(uPushSettingCallback);
        try {
            final Application a10 = y.a();
            TaobaoRegister.bindAgoo(a10, new ICallback() { // from class: com.umeng.message.proguard.v.5
                @Override // com.taobao.agoo.ICallback
                public final void onFailure(String str, String str2) {
                    UPLog.i("Mgr", "push enable failed. code:", str, "desc:", str2);
                    Intent intent = new Intent("com.umeng.message.action");
                    intent.setPackage(a10.getPackageName());
                    intent.setClass(a10, UmengMessageHandlerService.class);
                    intent.putExtra("um_command", "enable");
                    intent.putExtra(Constant.KEY_STATUS, false);
                    intent.putExtra(Constants.KEY_HTTP_CODE, str);
                    intent.putExtra("desc", str2);
                    r.enqueueWork(a10, UmengMessageHandlerService.class, intent);
                }

                @Override // com.taobao.agoo.ICallback
                public final void onSuccess() {
                    UPLog.i("Mgr", "push enable success.");
                    Intent intent = new Intent("com.umeng.message.action");
                    intent.setPackage(a10.getPackageName());
                    intent.setClass(a10, UmengMessageHandlerService.class);
                    intent.putExtra("um_command", "enable");
                    intent.putExtra(Constant.KEY_STATUS, true);
                    r.enqueueWork(a10, UmengMessageHandlerService.class, intent);
                }
            });
        } catch (Exception e10) {
            UPLog.e("Mgr", e10);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushConnectStateListener getConnectStateListener() {
        return this.f12197l;
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getDisplayNotificationNumber() {
        return MessageSharedPrefs.getInstance(y.a()).b();
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushInAppMessageCallback getInAppMessageCallback() {
        return this.f12195j;
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushInAppMessageHandler getInAppMessageHandler() {
        return this.f12196k;
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getMessageAppkey() {
        Application a10 = y.a();
        String appkey = UMUtils.getAppkey(a10);
        if (!TextUtils.isEmpty(appkey)) {
            return appkey;
        }
        String c10 = MessageSharedPrefs.getInstance(a10).c();
        return !TextUtils.isEmpty(c10) ? c10 : d.a((Context) a10, "UMENG_APPKEY");
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getMessageChannel() {
        Application a10 = y.a();
        String channel = UMUtils.getChannel(a10);
        if (!TextUtils.isEmpty(channel)) {
            return channel;
        }
        String b10 = MessageSharedPrefs.getInstance(a10).f11344b.b("channel", "");
        return !TextUtils.isEmpty(b10) ? b10 : d.n(a10);
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushMessageHandler getMessageHandler() {
        if (this.f12193h == null) {
            this.f12193h = new UmengMessageHandler();
        }
        return this.f12193h;
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushMessageNotifyApi getMessageNotifyApi() {
        return aw.a();
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getMessageSecret() {
        Application a10 = y.a();
        String b10 = MessageSharedPrefs.getInstance(a10).f11344b.b("message_secret", "");
        return !TextUtils.isEmpty(b10) ? b10 : d.a((Context) a10, "UMENG_MESSAGE_SECRET");
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getMuteDurationSeconds() {
        return MessageSharedPrefs.getInstance(y.a()).g();
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNoDisturbEndHour() {
        return MessageSharedPrefs.getInstance(y.a()).f11344b.b("end_hour", 7);
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNoDisturbEndMinute() {
        return MessageSharedPrefs.getInstance(y.a()).f11344b.b("end_minute", 0);
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNoDisturbStartHour() {
        return MessageSharedPrefs.getInstance(y.a()).f11344b.b("start_hour", 23);
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNoDisturbStartMinute() {
        return MessageSharedPrefs.getInstance(y.a()).f11344b.b("start_minute", 0);
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getNotificationChannelName() {
        String b10 = MessageSharedPrefs.getInstance(y.a()).f11344b.b("notification_channel_default", "");
        return TextUtils.isEmpty(b10) ? UPushNotificationChannel.DEFAULT_NOTIFICATION_CHANNEL_NAME : b10;
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushMessageHandler getNotificationClickHandler() {
        if (this.f12194i == null) {
            this.f12194i = new UmengNotificationClickHandler();
        }
        return this.f12194i;
    }

    @Override // com.umeng.message.api.UPushApi
    public final boolean getNotificationOnForeground() {
        return MessageSharedPrefs.getInstance(y.a()).f11344b.b("notification_foreground_show", true);
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNotificationPlayLights() {
        return MessageSharedPrefs.getInstance(y.a()).j();
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNotificationPlaySound() {
        return MessageSharedPrefs.getInstance(y.a()).k();
    }

    @Override // com.umeng.message.api.UPushApi
    public final int getNotificationPlayVibrate() {
        return MessageSharedPrefs.getInstance(y.a()).i();
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getNotificationSilenceChannelName() {
        String b10 = MessageSharedPrefs.getInstance(y.a()).f11344b.b("notification_channel_silence", "");
        return TextUtils.isEmpty(b10) ? UPushNotificationChannel.DEFAULT_NOTIFICATION_SILENCE_CHANNEL_NAME : b10;
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getPushIntentServiceClass() {
        return MessageSharedPrefs.getInstance(y.a()).e();
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushRegisterCallback getRegisterCallback() {
        return this.f12190e;
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getRegistrationId() {
        return MessageSharedPrefs.getInstance(y.a()).l();
    }

    @Override // com.umeng.message.api.UPushApi
    public final String getResourcePackageName() {
        return MessageSharedPrefs.getInstance(y.a()).h();
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushSettingCallback getSettingCallback() {
        return this.f12192g;
    }

    @Override // com.umeng.message.api.UPushApi
    public final TagManager getTagManager() {
        return TagManager.getInstance();
    }

    @Override // com.umeng.message.api.UPushApi
    public final UPushThirdTokenCallback getThirdTokenCallback() {
        return this.f12191f;
    }

    @Override // com.umeng.message.api.UPushApi
    public final boolean isConnected() {
        try {
            ACCSClient aCCSClient = this.f12199n;
            if (aCCSClient != null) {
                return aCCSClient.isAccsConnected();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final boolean isPushCheck() {
        return this.f12189d;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void keepLowPowerMode(boolean z10) {
        this.f12186a = z10;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void onAppStart() {
        b.b(new Runnable() { // from class: com.umeng.message.proguard.v.2
            @Override // java.lang.Runnable
            public final void run() {
                z.a().b();
            }
        });
    }

    @Override // com.umeng.message.api.UPushApi
    public final void register(UPushRegisterCallback uPushRegisterCallback) {
        if (uPushRegisterCallback != null && uPushRegisterCallback != this.f12190e) {
            this.f12190e = uPushRegisterCallback;
        }
        Runnable runnable = new Runnable() { // from class: com.umeng.message.proguard.v.1
            @Override // java.lang.Runnable
            public final void run() {
                v.a(v.this);
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b.c(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setAccsHeartbeatEnable(boolean z10) {
        this.f12188c = z10;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        UTrack.getInstance().setAlias(str, str2, uPushAliasCallback);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setConnectStateListener(UPushConnectStateListener uPushConnectStateListener) {
        this.f12197l = uPushConnectStateListener;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setDisplayNotificationNumber(int i10) {
        if (i10 < 0 || i10 > 10) {
            return;
        }
        MessageSharedPrefs.getInstance(y.a()).f11344b.a("notification_number", i10);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setEnableAlarmHeartbeat(boolean z10) {
        try {
            GlobalConfig.setAlarmHeartbeatEnable(z10);
        } catch (Throwable th) {
            UPLog.e("Mgr", th);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setEnableForeground(boolean z10) {
        try {
            GlobalConfig.setEnableForeground(y.a(), z10);
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setEnableJobHeartbeat(boolean z10) {
        try {
            GlobalConfig.setJobHeartbeatEnable(z10);
        } catch (Throwable th) {
            UPLog.e("Mgr", th);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setInAppMessageCallback(UPushInAppMessageCallback uPushInAppMessageCallback) {
        this.f12195j = uPushInAppMessageCallback;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setInAppMessageHandler(UPushInAppMessageHandler uPushInAppMessageHandler) {
        this.f12196k = uPushInAppMessageHandler;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setMessageHandler(UPushMessageHandler uPushMessageHandler) {
        this.f12193h = uPushMessageHandler;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setMuteDurationSeconds(int i10) {
        MessageSharedPrefs.getInstance(y.a()).f11344b.a("mute_duration", i10);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNoDisturbMode(int i10, int i11, int i12, int i13) {
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(y.a());
        messageSharedPrefs.f11344b.a("start_hour", i10);
        messageSharedPrefs.f11344b.a("start_minute", i11);
        messageSharedPrefs.f11344b.a("end_hour", i12);
        messageSharedPrefs.f11344b.a("end_minute", i13);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationChannelName(String str) {
        MessageSharedPrefs.getInstance(y.a()).f11344b.a("notification_channel_default", str);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationClickHandler(UPushMessageHandler uPushMessageHandler) {
        this.f12194i = uPushMessageHandler;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationOnForeground(boolean z10) {
        MessageSharedPrefs.getInstance(y.a()).f11344b.a("notification_foreground_show", z10);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationPlayLights(int i10) {
        MessageSharedPrefs.getInstance(y.a()).f11344b.a("notification_light", i10);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationPlaySound(int i10) {
        MessageSharedPrefs.getInstance(y.a()).f11344b.a("notification_sound", i10);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationPlayVibrate(int i10) {
        MessageSharedPrefs.getInstance(y.a()).f11344b.a("notification_vibrate", i10);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setNotificationSilenceChannelName(String str) {
        MessageSharedPrefs.getInstance(y.a()).f11344b.a("notification_channel_silence", str);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setPullUpEnable(boolean z10) {
        this.f12187b = z10;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setPushCheck(boolean z10) {
        this.f12189d = z10;
    }

    @Override // com.umeng.message.api.UPushApi
    public final <U extends UmengMessageService> void setPushIntentServiceClass(Class<U> cls) {
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(y.a());
        if (cls == null) {
            messageSharedPrefs.f11344b.a("service_class");
        } else {
            messageSharedPrefs.f11344b.a("service_class", cls.getName());
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setRegisterCallback(UPushRegisterCallback uPushRegisterCallback) {
        this.f12190e = uPushRegisterCallback;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setReportThirdTokenDelay(int i10) {
        try {
            GlobalConfig.setReportThirdTokenDelay(i10);
        } catch (Throwable th) {
            UPLog.e("Mgr", th);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setResourcePackageName(String str) {
        MessageSharedPrefs.getInstance(y.a()).f11344b.a("res_pkg", str);
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setSettingCallback(UPushSettingCallback uPushSettingCallback) {
        this.f12192g = uPushSettingCallback;
    }

    @Override // com.umeng.message.api.UPushApi
    public final void setThirdTokenCallback(UPushThirdTokenCallback uPushThirdTokenCallback) {
        this.f12191f = uPushThirdTokenCallback;
    }

    private v() {
        this.f12187b = true;
    }

    public static UPushApi a() {
        return a.f12214a;
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x0231 A[Catch: all -> 0x0280, TryCatch #0 {all -> 0x0280, blocks: (B:71:0x01d3, B:74:0x01ea, B:76:0x01f0, B:78:0x01fa, B:79:0x0211, B:81:0x0221, B:83:0x0227, B:85:0x0231, B:86:0x0246, B:88:0x0256, B:90:0x025c, B:92:0x0266), top: B:70:0x01d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0266 A[Catch: all -> 0x0280, TRY_LEAVE, TryCatch #0 {all -> 0x0280, blocks: (B:71:0x01d3, B:74:0x01ea, B:76:0x01f0, B:78:0x01fa, B:79:0x0211, B:81:0x0221, B:83:0x0227, B:85:0x0231, B:86:0x0246, B:88:0x0256, B:90:0x025c, B:92:0x0266), top: B:70:0x01d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x027d A[Catch: all -> 0x02a7, TRY_ENTER, TryCatch #6 {all -> 0x02a7, blocks: (B:3:0x0010, B:5:0x0016, B:18:0x0035, B:20:0x003f, B:22:0x0045, B:34:0x0064, B:36:0x0072, B:39:0x007a, B:51:0x008b, B:54:0x0093, B:56:0x015a, B:63:0x0191, B:65:0x0197, B:66:0x019c, B:68:0x01b9, B:69:0x01ca, B:96:0x027d, B:100:0x0186, B:101:0x0280, B:112:0x0288, B:58:0x0167, B:60:0x017a), top: B:2:0x0010, inners: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(com.umeng.message.proguard.v r17) {
        /*
            Method dump skipped, instructions count: 729
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.v.a(com.umeng.message.proguard.v):void");
    }
}
