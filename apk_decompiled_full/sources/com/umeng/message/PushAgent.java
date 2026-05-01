package com.umeng.message;

import android.content.Context;
import com.taobao.accs.utl.ALog;
import com.umeng.message.api.UPushAliasCallback;
import com.umeng.message.api.UPushConnectStateListener;
import com.umeng.message.api.UPushInAppMessageCallback;
import com.umeng.message.api.UPushInAppMessageHandler;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.api.UPushMessageNotifyApi;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.message.api.UPushSettingCallback;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.bj;
import com.umeng.message.proguard.d;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.i;
import com.umeng.message.proguard.q;
import com.umeng.message.proguard.v;
import com.umeng.message.proguard.y;
import com.umeng.message.tag.TagManager;
import org.android.spdy.SpdyAgent;

/* loaded from: classes.dex */
public class PushAgent {
    private static final String TAG = "PushAgent";

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f11346a = 0;
    private static boolean sCommonInit;
    private static volatile boolean sPushInit;
    public boolean isZyb;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final PushAgent f11347a = new PushAgent();
    }

    static {
        try {
            q a10 = q.a();
            ALog.setLog(a10);
            anet.channel.util.ALog.setLog(a10);
        } catch (Throwable th) {
            UPLog.e(TAG, th);
        }
        sCommonInit = false;
        sPushInit = false;
    }

    public static PushAgent getInstance(Context context) {
        PushAgent pushAgent = a.f11347a;
        if (sPushInit) {
            return pushAgent;
        }
        if (context == null) {
            try {
                context = y.a();
            } catch (Throwable th) {
                UPLog.e(TAG, th);
            }
        }
        y.a(context);
        sPushInit = true;
        return pushAgent;
    }

    private static void init(Context context) {
        if (sCommonInit) {
            return;
        }
        f.c();
        sCommonInit = true;
    }

    @Deprecated
    public static void setup(Context context, String str, String str2) {
        UPLog.i("Core", "setup appkey:", str, "appSecret:", str2);
        y.a(context);
    }

    public void addAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        v.a().addAlias(str, str2, uPushAliasCallback);
    }

    public void changeBadgeNum(int i10) {
        bj.b(y.a(), i10);
    }

    public void deleteAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        v.a().deleteAlias(str, str2, uPushAliasCallback);
    }

    public void disable(UPushSettingCallback uPushSettingCallback) {
        v.a().disable(uPushSettingCallback);
    }

    public void enable(UPushSettingCallback uPushSettingCallback) {
        v.a().enable(uPushSettingCallback);
    }

    public UPushSettingCallback getCallback() {
        return v.a().getSettingCallback();
    }

    public String getDeviceToken() {
        return getRegistrationId();
    }

    public int getDisplayNotificationNumber() {
        return v.a().getDisplayNotificationNumber();
    }

    public String getMessageAppkey() {
        return v.a().getMessageAppkey();
    }

    public String getMessageChannel() {
        return v.a().getMessageChannel();
    }

    public UPushMessageHandler getMessageHandler() {
        return v.a().getMessageHandler();
    }

    public UPushMessageNotifyApi getMessageNotifyApi() {
        return v.a().getMessageNotifyApi();
    }

    public String getMessageSecret() {
        return v.a().getMessageSecret();
    }

    public int getMuteDurationSeconds() {
        return v.a().getMuteDurationSeconds();
    }

    public int getNoDisturbEndHour() {
        return v.a().getNoDisturbEndHour();
    }

    public int getNoDisturbEndMinute() {
        return v.a().getNoDisturbEndMinute();
    }

    public int getNoDisturbStartHour() {
        return v.a().getNoDisturbStartHour();
    }

    public int getNoDisturbStartMinute() {
        return v.a().getNoDisturbStartMinute();
    }

    public String getNotificationChannelName() {
        return v.a().getNotificationChannelName();
    }

    public UPushMessageHandler getNotificationClickHandler() {
        return v.a().getNotificationClickHandler();
    }

    public boolean getNotificationOnForeground() {
        return v.a().getNotificationOnForeground();
    }

    public int getNotificationPlayLights() {
        return v.a().getNotificationPlayLights();
    }

    public int getNotificationPlaySound() {
        return v.a().getNotificationPlaySound();
    }

    public int getNotificationPlayVibrate() {
        return v.a().getNotificationPlayVibrate();
    }

    public String getNotificationSilenceChannelName() {
        return v.a().getNotificationSilenceChannelName();
    }

    public String getPushIntentServiceClass() {
        return v.a().getPushIntentServiceClass();
    }

    public UPushRegisterCallback getRegisterCallback() {
        return v.a().getRegisterCallback();
    }

    public String getRegistrationId() {
        return v.a().getRegistrationId();
    }

    public String getResourcePackageName() {
        return v.a().getResourcePackageName();
    }

    public TagManager getTagManager() {
        return v.a().getTagManager();
    }

    public boolean isConnected() {
        return v.a().isConnected();
    }

    public boolean isNotificationEnabled() {
        return d.q(y.a()) == 1;
    }

    public boolean isPushCheck() {
        return v.a().isPushCheck();
    }

    public void keepLowPowerMode(boolean z10) {
        v.a().keepLowPowerMode(z10);
    }

    public void onAppStart() {
        v.a().onAppStart();
    }

    public boolean openNotificationSettings() {
        return d.r(y.a());
    }

    public void register(UPushRegisterCallback uPushRegisterCallback) {
        v.a().register(uPushRegisterCallback);
    }

    public void setAccsHeartbeatEnable(boolean z10) {
        v.a().setAccsHeartbeatEnable(z10);
    }

    public void setAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        v.a().setAlias(str, str2, uPushAliasCallback);
    }

    public void setBadgeNum(int i10) {
        bj.a(y.a(), i10);
    }

    public void setCallback(UPushSettingCallback uPushSettingCallback) {
        v.a().setSettingCallback(uPushSettingCallback);
    }

    public void setConnectStateListener(UPushConnectStateListener uPushConnectStateListener) {
        v.a().setConnectStateListener(uPushConnectStateListener);
    }

    public void setDebugMode(boolean z10) {
        UPLog.setEnable(z10);
        try {
            SpdyAgent.enableDebug = z10;
        } catch (Throwable th) {
            UPLog.e(TAG, th);
        }
    }

    public void setDisplayNotificationNumber(int i10) {
        v.a().setDisplayNotificationNumber(i10);
    }

    public void setEnableAlarmHeartbeat(boolean z10) {
        v.a().setEnableAlarmHeartbeat(z10);
    }

    public void setEnableForeground(Context context, boolean z10) {
        v.a().setEnableForeground(z10);
    }

    public void setEnableJobHeartbeat(boolean z10) {
        v.a().setEnableJobHeartbeat(z10);
    }

    public void setInAppMessageCallback(UPushInAppMessageCallback uPushInAppMessageCallback) {
        v.a().setInAppMessageCallback(uPushInAppMessageCallback);
    }

    public void setInAppMessageHandler(UPushInAppMessageHandler uPushInAppMessageHandler) {
        v.a().setInAppMessageHandler(uPushInAppMessageHandler);
    }

    public void setLogUploadEnable(boolean z10) {
        f.f12084b = z10;
    }

    public void setMessageHandler(UPushMessageHandler uPushMessageHandler) {
        v.a().setMessageHandler(uPushMessageHandler);
    }

    public void setMuteDurationSeconds(int i10) {
        v.a().setMuteDurationSeconds(i10);
    }

    public void setNoDisturbMode(int i10, int i11, int i12, int i13) {
        v.a().setNoDisturbMode(i10, i11, i12, i13);
    }

    public void setNotificationChannelName(String str) {
        v.a().setNotificationChannelName(str);
    }

    public void setNotificationClickHandler(UPushMessageHandler uPushMessageHandler) {
        v.a().setNotificationClickHandler(uPushMessageHandler);
    }

    public void setNotificationOnForeground(boolean z10) {
        v.a().setNotificationOnForeground(z10);
    }

    public void setNotificationPlayLights(int i10) {
        v.a().setNotificationPlayLights(i10);
    }

    public void setNotificationPlaySound(int i10) {
        v.a().setNotificationPlaySound(i10);
    }

    public void setNotificationPlayVibrate(int i10) {
        v.a().setNotificationPlayVibrate(i10);
    }

    public void setNotificationSilenceChannelName(String str) {
        v.a().setNotificationSilenceChannelName(str);
    }

    public void setPackageListenerEnable(boolean z10) {
        i.a(z10);
    }

    public void setPullUpEnable(boolean z10) {
        v.a().setPullUpEnable(z10);
    }

    public void setPushCheck(boolean z10) {
        v.a().setPushCheck(z10);
    }

    public <U extends UmengMessageService> void setPushIntentServiceClass(Class<U> cls) {
        v.a().setPushIntentServiceClass(cls);
    }

    public void setRegisterCallback(UPushRegisterCallback uPushRegisterCallback) {
        v.a().setRegisterCallback(uPushRegisterCallback);
    }

    public void setReportThirdTokenDelay(int i10) {
        v.a().setReportThirdTokenDelay(i10);
    }

    public void setResourcePackageName(String str) {
        v.a().setResourcePackageName(str);
    }

    public void setSmartEnable(boolean z10) {
        f.a(z10);
    }

    public void setThirdTokenCallback(UPushThirdTokenCallback uPushThirdTokenCallback) {
        v.a().setThirdTokenCallback(uPushThirdTokenCallback);
    }

    private PushAgent() {
        this.isZyb = true;
    }
}
