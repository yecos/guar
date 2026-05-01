package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.CallBack;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;
import org.android.agoo.message.MessageService;

/* loaded from: classes3.dex */
public final class TaobaoRegister {
    private static final int EVENT_ID = 66001;
    static final String PREFERENCES = "Agoo_AppStore";
    static final String PROPERTY_APP_NOTIFICATION_CUSTOM_SOUND = "app_notification_custom_sound";
    static final String PROPERTY_APP_NOTIFICATION_ICON = "app_notification_icon";
    static final String PROPERTY_APP_NOTIFICATION_SOUND = "app_notification_sound";
    static final String PROPERTY_APP_NOTIFICATION_VIBRATE = "app_notification_vibrate";
    private static final String SERVICEID = "agooSend";
    protected static final String TAG = "TaobaoRegister";
    private static boolean isRegisterSuccess;
    private static com.taobao.agoo.a.b mRequestListener;

    private TaobaoRegister() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static void bindAgoo(Context context, String str, String str2, CallBack callBack) {
        bindAgoo(context, null);
    }

    public static void clickMessage(Context context, String str, String str2) {
        clickMessage(context, str, str2, 0, 0L);
    }

    public static void dismissMessage(Context context, String str, String str2) {
        NotifManager notifManager = new NotifManager();
        MsgDO msgDO = null;
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i(TAG, "dismissMessage", "msgid", str, AgooConstants.MESSAGE_EXT, str2);
            }
            if (TextUtils.isEmpty(str)) {
                ALog.d(TAG, "messageId == null", new Object[0]);
                return;
            }
            notifManager.init(context);
            MsgDO msgDO2 = new MsgDO();
            try {
                msgDO2.msgIds = str;
                msgDO2.extData = str2;
                msgDO2.messageSource = "accs";
                msgDO2.msgStatus = MessageService.MSG_ACCS_NOTIFY_DISMISS;
                AgooFactory agooFactory = new AgooFactory();
                agooFactory.init(context, notifManager, null);
                agooFactory.updateMsgStatus(str, MessageService.MSG_ACCS_NOTIFY_DISMISS);
                notifManager.reportNotifyMessage(msgDO2);
            } catch (Throwable th) {
                th = th;
                msgDO = msgDO2;
                try {
                    ALog.e(TAG, "dismissMessage,error=" + th, new Object[0]);
                } finally {
                    if (msgDO != null) {
                        notifManager.reportNotifyMessage(msgDO);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void exposureMessage(Context context, String str, String str2) {
        NotifManager notifManager = new NotifManager();
        MsgDO msgDO = null;
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i(TAG, "exposureMessage", "msgid", str, AgooConstants.MESSAGE_EXT, str2);
            }
            if (TextUtils.isEmpty(str)) {
                ALog.d(TAG, "messageId == null", new Object[0]);
                return;
            }
            notifManager.init(context);
            MsgDO msgDO2 = new MsgDO();
            try {
                msgDO2.msgIds = str;
                msgDO2.extData = str2;
                msgDO2.messageSource = "accs";
                msgDO2.msgStatus = AgooConstants.ACK_REMOVE_PACKAGE;
                new AgooFactory().init(context, notifManager, null);
                notifManager.reportNotifyMessage(msgDO2);
            } catch (Throwable th) {
                th = th;
                msgDO = msgDO2;
                try {
                    ALog.e(TAG, "exposureMessage,error=" + th, new Object[0]);
                } finally {
                    if (msgDO != null) {
                        notifManager.reportNotifyMessage(msgDO);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isRegisterSuccess() {
        return isRegisterSuccess;
    }

    public static void pingApp(Context context, String str, String str2, String str3, int i10) {
        NotifManager notifManager = new NotifManager();
        notifManager.init(context);
        notifManager.pingApp(str, str2, str3, i10);
    }

    @Deprecated
    public static synchronized void register(Context context, String str, String str2, String str3, IRegister iRegister) {
        synchronized (TaobaoRegister.class) {
            register(context, AccsClientConfig.DEFAULT_CONFIGTAG, str, str2, str3, iRegister);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
    
        r10.onFailure("504.1", "input params null!!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void removeAlias(Context context, String str, ICallback iCallback) {
        String g10;
        String a10;
        synchronized (TaobaoRegister.class) {
            ALog.i(TAG, com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, new Object[0]);
            try {
                g10 = Config.g(context);
                a10 = Config.a(context);
            } catch (Throwable th) {
                ALog.e(TAG, com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, th, new Object[0]);
            }
            if (!TextUtils.isEmpty(a10) && !TextUtils.isEmpty(g10) && context != null && !TextUtils.isEmpty(str)) {
                com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, a10, Config.c(context));
                if (mRequestListener == null) {
                    mRequestListener = new com.taobao.agoo.a.b(context.getApplicationContext());
                }
                GlobalClientInfo.getInstance(context).registerListener("AgooDeviceCmd", mRequestListener);
                String b10 = accsInstance.b(context, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", com.taobao.agoo.a.a.a.c(a10, g10, str), null));
                if (TextUtils.isEmpty(b10)) {
                    if (iCallback != null) {
                        iCallback.onFailure("504.1", "accs channel disabled!");
                    }
                } else if (iCallback != null) {
                    mRequestListener.f9418a.put(b10, iCallback);
                }
                return;
            }
            ALog.e(TAG, "setAlias param null", "appkey", a10, "deviceId", g10, "alias", str, com.umeng.analytics.pro.f.X, context);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
    
        r11.onFailure("504.1", "input params null!!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void removeAllAlias(Context context, ICallback iCallback) {
        ALog.i(TAG, "removeAllAlias", new Object[0]);
        try {
            String g10 = Config.g(context);
            String a10 = Config.a(context);
            if (!TextUtils.isEmpty(a10) && !TextUtils.isEmpty(g10) && context != null) {
                com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, a10, Config.c(context));
                if (mRequestListener == null) {
                    mRequestListener = new com.taobao.agoo.a.b(context.getApplicationContext());
                }
                GlobalClientInfo.getInstance(context).registerListener("AgooDeviceCmd", mRequestListener);
                String b10 = accsInstance.b(context, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", com.taobao.agoo.a.a.a.a(a10, g10), null));
                if (TextUtils.isEmpty(b10)) {
                    if (iCallback != null) {
                        iCallback.onFailure("504.1", "accs channel disabled!");
                        return;
                    }
                    return;
                } else {
                    if (iCallback != null) {
                        mRequestListener.f9418a.put(b10, iCallback);
                        return;
                    }
                    return;
                }
            }
            ALog.e(TAG, "setAlias param null", "appkey", a10, "deviceId", g10, com.umeng.analytics.pro.f.X, context);
        } catch (Throwable th) {
            ALog.e(TAG, "removeAllAlias", th, new Object[0]);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0073, code lost:
    
        r10.onFailure("503.3", "input params null!!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized void sendSwitch(Context context, ICallback iCallback, boolean z10) {
        String g10;
        String a10;
        String j10;
        synchronized (TaobaoRegister.class) {
            try {
                g10 = Config.g(context);
                a10 = Config.a(context);
                j10 = UtilityImpl.j(context);
            } catch (Throwable th) {
                ALog.e(TAG, "sendSwitch", th, new Object[0]);
            }
            if (!TextUtils.isEmpty(a10) && context != null && (!TextUtils.isEmpty(g10) || !TextUtils.isEmpty(j10))) {
                com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, a10, Config.c(context));
                if (mRequestListener == null) {
                    mRequestListener = new com.taobao.agoo.a.b(context.getApplicationContext());
                }
                GlobalClientInfo.getInstance(context).registerListener("AgooDeviceCmd", mRequestListener);
                String b10 = accsInstance.b(context, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", com.taobao.agoo.a.a.d.a(a10, g10, j10, z10), null));
                if (TextUtils.isEmpty(b10)) {
                    if (iCallback != null) {
                        iCallback.onFailure("503.2", "accs channel disabled!");
                    }
                } else if (iCallback != null) {
                    mRequestListener.f9418a.put(b10, iCallback);
                }
                return;
            }
            ALog.e(TAG, "sendSwitch param null", "appkey", a10, "deviceId", g10, com.umeng.analytics.pro.f.X, context, com.taobao.agoo.a.a.d.JSON_CMD_ENABLEPUSH, Boolean.valueOf(z10));
        }
    }

    @Deprecated
    public static synchronized void setAccsConfigTag(Context context, String str) {
        synchronized (TaobaoRegister.class) {
        }
    }

    public static void setAgooMsgReceiveService(String str) {
        com.taobao.accs.client.a.f9045a = str;
    }

    public static synchronized void setAlias(Context context, String str, ICallback iCallback) {
        synchronized (TaobaoRegister.class) {
            ALog.i(TAG, com.taobao.agoo.a.a.a.JSON_CMD_SETALIAS, "alias", str);
            String g10 = Config.g(context);
            String a10 = Config.a(context);
            if (TextUtils.isEmpty(a10) || TextUtils.isEmpty(g10) || context == null || TextUtils.isEmpty(str)) {
                if (iCallback != null) {
                    iCallback.onFailure("504.1", "input params null!!");
                }
                ALog.e(TAG, "setAlias param null", "appkey", a10, "deviceId", g10, "alias", str, com.umeng.analytics.pro.f.X, context);
                return;
            }
            try {
                if (mRequestListener == null) {
                    mRequestListener = new com.taobao.agoo.a.b(context.getApplicationContext());
                }
            } catch (Throwable th) {
                ALog.e(TAG, com.taobao.agoo.a.a.a.JSON_CMD_SETALIAS, th, new Object[0]);
            }
            if (com.taobao.agoo.a.b.f9417b.d(str)) {
                ALog.i(TAG, "setAlias already set", "alias", str);
                if (iCallback != null) {
                    iCallback.onSuccess();
                }
                return;
            }
            com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, a10, Config.c(context));
            if (com.taobao.agoo.a.b.f9417b.b(context.getPackageName())) {
                GlobalClientInfo.getInstance(context).registerListener("AgooDeviceCmd", mRequestListener);
                String b10 = accsInstance.b(context, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", com.taobao.agoo.a.a.a.a(a10, g10, str), null));
                if (TextUtils.isEmpty(b10)) {
                    if (iCallback != null) {
                        iCallback.onFailure("504.1", "accs channel disabled!");
                    }
                } else if (iCallback != null) {
                    iCallback.extra = str;
                    mRequestListener.f9418a.put(b10, iCallback);
                }
            } else if (iCallback != null) {
                iCallback.onFailure("504.1", "bindApp first!!");
            }
        }
    }

    @Deprecated
    public static void setBuilderSound(Context context, String str) {
    }

    public static void setEnv(Context context, @AccsClientConfig.ENV int i10) {
        ACCSClient.setEnvironment(context, i10);
    }

    public static void setIsRegisterSuccess(boolean z10) {
        isRegisterSuccess = z10;
    }

    @Deprecated
    public static void setNotificationIcon(Context context, int i10) {
    }

    @Deprecated
    public static void setNotificationSound(Context context, boolean z10) {
    }

    @Deprecated
    public static void setNotificationVibrate(Context context, boolean z10) {
    }

    @Deprecated
    public static void unBindAgoo(Context context, String str, String str2, CallBack callBack) {
        unbindAgoo(context, null);
    }

    public static void unbindAgoo(Context context, ICallback iCallback) {
        sendSwitch(context, iCallback, false);
        UTMini.getInstance().commitEvent(EVENT_ID, "unregister", UtilityImpl.j(context));
    }

    @Deprecated
    public static void unregister(Context context, CallBack callBack) {
        unbindAgoo(context, null);
    }

    public static void bindAgoo(Context context, ICallback iCallback) {
        sendSwitch(context, iCallback, true);
        UTMini.getInstance().commitEvent(EVENT_ID, "bindAgoo", UtilityImpl.j(context));
    }

    public static void clickMessage(Context context, String str, String str2, int i10, long j10) {
        MsgDO msgDO;
        NotifManager notifManager = new NotifManager();
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i(TAG, "clickMessage", "msgid", str, AgooConstants.MESSAGE_EXT, str2);
            }
            if (TextUtils.isEmpty(str)) {
                ALog.d(TAG, "messageId == null", new Object[0]);
                return;
            }
            notifManager.init(context);
            MsgDO msgDO2 = new MsgDO();
            try {
                msgDO2.evokeAppStatus = 1;
                boolean z10 = (i10 & 1) == 1;
                boolean z11 = (i10 & 2) == 2;
                boolean z12 = (i10 & 4) == 4;
                boolean z13 = (i10 & 8) == 8;
                boolean z14 = z10 ^ z11;
                msgDO2.isGlobalClick = z14;
                if (z14) {
                    ALog.e(TAG, "clickMessage", "isLaunchByAgoo", Boolean.valueOf(z11), "isEvokeByAgoo", Boolean.valueOf(z10), "isComeFromBg", Boolean.valueOf(z12), "isSameDay", Boolean.valueOf(z13), "lastActiveTime", Long.valueOf(j10));
                    msgDO2.lastActiveTime = j10;
                    if ((z10 && z12) || z11) {
                        if (z13) {
                            msgDO2.evokeAppStatus = z11 ? 2 : 3;
                        } else {
                            msgDO2.evokeAppStatus = 4;
                        }
                    }
                }
                msgDO2.msgIds = str;
                msgDO2.extData = str2;
                msgDO2.messageSource = "accs";
                msgDO2.msgStatus = MessageService.MSG_ACCS_NOTIFY_CLICK;
                AgooFactory agooFactory = new AgooFactory();
                agooFactory.init(context, notifManager, null);
                agooFactory.updateMsgStatus(str, MessageService.MSG_ACCS_NOTIFY_CLICK);
                notifManager.reportNotifyMessage(msgDO2);
            } catch (Throwable th) {
                th = th;
                msgDO = msgDO2;
                try {
                    ALog.e(TAG, "clickMessage,error=" + th, new Object[0]);
                } finally {
                    if (msgDO != null) {
                        notifManager.reportNotifyMessage(msgDO);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            msgDO = null;
        }
    }

    public static synchronized void register(Context context, String str, String str2, String str3, String str4, IRegister iRegister) {
        synchronized (TaobaoRegister.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    ALog.i(TAG, com.taobao.agoo.a.a.c.JSON_CMD_REGISTER, Constants.KEY_APP_KEY, str2, Constants.KEY_CONFIG_TAG, str);
                    Context applicationContext = context.getApplicationContext();
                    Config.f17821a = str;
                    Config.setAgooAppKey(context, str2);
                    Config.a(context, str3);
                    AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
                    if (configByTag == null) {
                        new AccsClientConfig.Builder().setAppKey(str2).setAppSecret(str3).setTag(str).build();
                    } else {
                        com.taobao.accs.client.a.f9046b = configByTag.getAuthCode();
                    }
                    com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, str2, str);
                    if (accsInstance != null) {
                        accsInstance.a(applicationContext, str2, str3, str4, new g(applicationContext, context, iRegister, str2, str4, accsInstance));
                        return;
                    } else {
                        if (iRegister != null) {
                            iRegister.onFailure("503.2", "ACCSManager null");
                        }
                        return;
                    }
                }
            }
            ALog.e(TAG, "register params null", "appkey", str2, Constants.KEY_CONFIG_TAG, str);
            if (iRegister != null) {
                iRegister.onFailure("503.2", "params null");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
    
        r10.onFailure("504.1", "input params null!!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void removeAlias(Context context, ICallback iCallback) {
        String g10;
        String h10;
        String a10;
        synchronized (TaobaoRegister.class) {
            ALog.i(TAG, com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, new Object[0]);
            try {
                g10 = Config.g(context);
                h10 = Config.h(context);
                a10 = Config.a(context);
            } catch (Throwable th) {
                ALog.e(TAG, com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, th, new Object[0]);
            }
            if (!TextUtils.isEmpty(a10) && !TextUtils.isEmpty(g10) && context != null && !TextUtils.isEmpty(h10)) {
                com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, a10, Config.c(context));
                if (mRequestListener == null) {
                    mRequestListener = new com.taobao.agoo.a.b(context.getApplicationContext());
                }
                GlobalClientInfo.getInstance(context).registerListener("AgooDeviceCmd", mRequestListener);
                String b10 = accsInstance.b(context, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", com.taobao.agoo.a.a.a.b(a10, g10, h10), null));
                if (TextUtils.isEmpty(b10)) {
                    if (iCallback != null) {
                        iCallback.onFailure("504.1", "accs channel disabled!");
                    }
                } else if (iCallback != null) {
                    mRequestListener.f9418a.put(b10, iCallback);
                }
                return;
            }
            ALog.e(TAG, "setAlias param null", "appkey", a10, "deviceId", g10, com.taobao.agoo.a.a.a.JSON_PUSH_USER_TOKEN, h10, com.umeng.analytics.pro.f.X, context);
        }
    }
}
