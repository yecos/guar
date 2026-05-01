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
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void removeAlias(android.content.Context r8, java.lang.String r9, com.taobao.agoo.ICallback r10) {
        /*
            java.lang.Class<com.taobao.agoo.TaobaoRegister> r0 = com.taobao.agoo.TaobaoRegister.class
            monitor-enter(r0)
            java.lang.String r1 = "TaobaoRegister"
            java.lang.String r2 = "removeAlias"
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lb7
            com.taobao.accs.utl.ALog.i(r1, r2, r4)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r1 = org.android.agoo.common.Config.g(r8)     // Catch: java.lang.Throwable -> Lab
            java.lang.String r2 = org.android.agoo.common.Config.a(r8)     // Catch: java.lang.Throwable -> Lab
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lab
            if (r4 != 0) goto L76
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lab
            if (r4 != 0) goto L76
            if (r8 == 0) goto L76
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> Lab
            if (r4 == 0) goto L2a
            goto L76
        L2a:
            java.lang.String r4 = org.android.agoo.common.Config.c(r8)     // Catch: java.lang.Throwable -> Lab
            com.taobao.accs.b r4 = com.taobao.accs.ACCSManager.getAccsInstance(r8, r2, r4)     // Catch: java.lang.Throwable -> Lab
            com.taobao.agoo.a.b r5 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Lab
            if (r5 != 0) goto L41
            com.taobao.agoo.a.b r5 = new com.taobao.agoo.a.b     // Catch: java.lang.Throwable -> Lab
            android.content.Context r6 = r8.getApplicationContext()     // Catch: java.lang.Throwable -> Lab
            r5.<init>(r6)     // Catch: java.lang.Throwable -> Lab
            com.taobao.agoo.TaobaoRegister.mRequestListener = r5     // Catch: java.lang.Throwable -> Lab
        L41:
            com.taobao.accs.client.GlobalClientInfo r5 = com.taobao.accs.client.GlobalClientInfo.getInstance(r8)     // Catch: java.lang.Throwable -> Lab
            java.lang.String r6 = "AgooDeviceCmd"
            com.taobao.agoo.a.b r7 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Lab
            r5.registerListener(r6, r7)     // Catch: java.lang.Throwable -> Lab
            byte[] r9 = com.taobao.agoo.a.a.a.c(r2, r1, r9)     // Catch: java.lang.Throwable -> Lab
            com.taobao.accs.ACCSManager$AccsRequest r1 = new com.taobao.accs.ACCSManager$AccsRequest     // Catch: java.lang.Throwable -> Lab
            java.lang.String r2 = "AgooDeviceCmd"
            r5 = 0
            r1.<init>(r5, r2, r9, r5)     // Catch: java.lang.Throwable -> Lab
            java.lang.String r8 = r4.b(r8, r1)     // Catch: java.lang.Throwable -> Lab
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> Lab
            if (r9 == 0) goto L6c
            if (r10 == 0) goto Lb5
            java.lang.String r8 = "504.1"
            java.lang.String r9 = "accs channel disabled!"
            r10.onFailure(r8, r9)     // Catch: java.lang.Throwable -> Lab
            goto Lb5
        L6c:
            if (r10 == 0) goto Lb5
            com.taobao.agoo.a.b r9 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Lab
            java.util.Map<java.lang.String, com.taobao.agoo.ICallback> r9 = r9.f9418a     // Catch: java.lang.Throwable -> Lab
            r9.put(r8, r10)     // Catch: java.lang.Throwable -> Lab
            goto Lb5
        L76:
            if (r10 == 0) goto L7f
            java.lang.String r4 = "504.1"
            java.lang.String r5 = "input params null!!"
            r10.onFailure(r4, r5)     // Catch: java.lang.Throwable -> Lab
        L7f:
            java.lang.String r10 = "TaobaoRegister"
            java.lang.String r4 = "setAlias param null"
            r5 = 8
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> Lab
            java.lang.String r6 = "appkey"
            r5[r3] = r6     // Catch: java.lang.Throwable -> Lab
            r6 = 1
            r5[r6] = r2     // Catch: java.lang.Throwable -> Lab
            java.lang.String r2 = "deviceId"
            r6 = 2
            r5[r6] = r2     // Catch: java.lang.Throwable -> Lab
            r2 = 3
            r5[r2] = r1     // Catch: java.lang.Throwable -> Lab
            java.lang.String r1 = "alias"
            r2 = 4
            r5[r2] = r1     // Catch: java.lang.Throwable -> Lab
            r1 = 5
            r5[r1] = r9     // Catch: java.lang.Throwable -> Lab
            java.lang.String r9 = "context"
            r1 = 6
            r5[r1] = r9     // Catch: java.lang.Throwable -> Lab
            r9 = 7
            r5[r9] = r8     // Catch: java.lang.Throwable -> Lab
            com.taobao.accs.utl.ALog.e(r10, r4, r5)     // Catch: java.lang.Throwable -> Lab
            monitor-exit(r0)
            return
        Lab:
            r8 = move-exception
            java.lang.String r9 = "TaobaoRegister"
            java.lang.String r10 = "removeAlias"
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lb7
            com.taobao.accs.utl.ALog.e(r9, r10, r8, r1)     // Catch: java.lang.Throwable -> Lb7
        Lb5:
            monitor-exit(r0)
            return
        Lb7:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.TaobaoRegister.removeAlias(android.content.Context, java.lang.String, com.taobao.agoo.ICallback):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
    
        r11.onFailure("504.1", "input params null!!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void removeAllAlias(android.content.Context r10, com.taobao.agoo.ICallback r11) {
        /*
            java.lang.String r0 = "AgooDeviceCmd"
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "TaobaoRegister"
            java.lang.String r4 = "removeAllAlias"
            com.taobao.accs.utl.ALog.i(r3, r4, r2)
            java.lang.String r2 = org.android.agoo.common.Config.g(r10)     // Catch: java.lang.Throwable -> L92
            java.lang.String r5 = org.android.agoo.common.Config.a(r10)     // Catch: java.lang.Throwable -> L92
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L92
            java.lang.String r7 = "504.1"
            if (r6 != 0) goto L6b
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L92
            if (r6 != 0) goto L6b
            if (r10 != 0) goto L25
            goto L6b
        L25:
            java.lang.String r6 = org.android.agoo.common.Config.c(r10)     // Catch: java.lang.Throwable -> L92
            com.taobao.accs.b r6 = com.taobao.accs.ACCSManager.getAccsInstance(r10, r5, r6)     // Catch: java.lang.Throwable -> L92
            com.taobao.agoo.a.b r8 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> L92
            if (r8 != 0) goto L3c
            com.taobao.agoo.a.b r8 = new com.taobao.agoo.a.b     // Catch: java.lang.Throwable -> L92
            android.content.Context r9 = r10.getApplicationContext()     // Catch: java.lang.Throwable -> L92
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L92
            com.taobao.agoo.TaobaoRegister.mRequestListener = r8     // Catch: java.lang.Throwable -> L92
        L3c:
            com.taobao.accs.client.GlobalClientInfo r8 = com.taobao.accs.client.GlobalClientInfo.getInstance(r10)     // Catch: java.lang.Throwable -> L92
            com.taobao.agoo.a.b r9 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> L92
            r8.registerListener(r0, r9)     // Catch: java.lang.Throwable -> L92
            byte[] r2 = com.taobao.agoo.a.a.a.a(r5, r2)     // Catch: java.lang.Throwable -> L92
            com.taobao.accs.ACCSManager$AccsRequest r5 = new com.taobao.accs.ACCSManager$AccsRequest     // Catch: java.lang.Throwable -> L92
            r8 = 0
            r5.<init>(r8, r0, r2, r8)     // Catch: java.lang.Throwable -> L92
            java.lang.String r10 = r6.b(r10, r5)     // Catch: java.lang.Throwable -> L92
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L92
            if (r0 == 0) goto L61
            if (r11 == 0) goto L98
            java.lang.String r10 = "accs channel disabled!"
            r11.onFailure(r7, r10)     // Catch: java.lang.Throwable -> L92
            goto L98
        L61:
            if (r11 == 0) goto L98
            com.taobao.agoo.a.b r0 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> L92
            java.util.Map<java.lang.String, com.taobao.agoo.ICallback> r0 = r0.f9418a     // Catch: java.lang.Throwable -> L92
            r0.put(r10, r11)     // Catch: java.lang.Throwable -> L92
            goto L98
        L6b:
            if (r11 == 0) goto L72
            java.lang.String r0 = "input params null!!"
            r11.onFailure(r7, r0)     // Catch: java.lang.Throwable -> L92
        L72:
            java.lang.String r11 = "setAlias param null"
            r0 = 6
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L92
            java.lang.String r6 = "appkey"
            r0[r1] = r6     // Catch: java.lang.Throwable -> L92
            r6 = 1
            r0[r6] = r5     // Catch: java.lang.Throwable -> L92
            java.lang.String r5 = "deviceId"
            r6 = 2
            r0[r6] = r5     // Catch: java.lang.Throwable -> L92
            r5 = 3
            r0[r5] = r2     // Catch: java.lang.Throwable -> L92
            java.lang.String r2 = "context"
            r5 = 4
            r0[r5] = r2     // Catch: java.lang.Throwable -> L92
            r2 = 5
            r0[r2] = r10     // Catch: java.lang.Throwable -> L92
            com.taobao.accs.utl.ALog.e(r3, r11, r0)     // Catch: java.lang.Throwable -> L92
            return
        L92:
            r10 = move-exception
            java.lang.Object[] r11 = new java.lang.Object[r1]
            com.taobao.accs.utl.ALog.e(r3, r4, r10, r11)
        L98:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.TaobaoRegister.removeAllAlias(android.content.Context, com.taobao.agoo.ICallback):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0073, code lost:
    
        r10.onFailure("503.3", "input params null!!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized void sendSwitch(android.content.Context r9, com.taobao.agoo.ICallback r10, boolean r11) {
        /*
            java.lang.Class<com.taobao.agoo.TaobaoRegister> r0 = com.taobao.agoo.TaobaoRegister.class
            monitor-enter(r0)
            r1 = 0
            java.lang.String r2 = org.android.agoo.common.Config.g(r9)     // Catch: java.lang.Throwable -> Laa
            java.lang.String r3 = org.android.agoo.common.Config.a(r9)     // Catch: java.lang.Throwable -> Laa
            java.lang.String r4 = com.taobao.accs.utl.UtilityImpl.j(r9)     // Catch: java.lang.Throwable -> Laa
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> Laa
            if (r5 != 0) goto L71
            if (r9 == 0) goto L71
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Laa
            if (r5 == 0) goto L25
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> Laa
            if (r5 == 0) goto L25
            goto L71
        L25:
            java.lang.String r5 = org.android.agoo.common.Config.c(r9)     // Catch: java.lang.Throwable -> Laa
            com.taobao.accs.b r5 = com.taobao.accs.ACCSManager.getAccsInstance(r9, r3, r5)     // Catch: java.lang.Throwable -> Laa
            com.taobao.agoo.a.b r6 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Laa
            if (r6 != 0) goto L3c
            com.taobao.agoo.a.b r6 = new com.taobao.agoo.a.b     // Catch: java.lang.Throwable -> Laa
            android.content.Context r7 = r9.getApplicationContext()     // Catch: java.lang.Throwable -> Laa
            r6.<init>(r7)     // Catch: java.lang.Throwable -> Laa
            com.taobao.agoo.TaobaoRegister.mRequestListener = r6     // Catch: java.lang.Throwable -> Laa
        L3c:
            com.taobao.accs.client.GlobalClientInfo r6 = com.taobao.accs.client.GlobalClientInfo.getInstance(r9)     // Catch: java.lang.Throwable -> Laa
            java.lang.String r7 = "AgooDeviceCmd"
            com.taobao.agoo.a.b r8 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Laa
            r6.registerListener(r7, r8)     // Catch: java.lang.Throwable -> Laa
            byte[] r11 = com.taobao.agoo.a.a.d.a(r3, r2, r4, r11)     // Catch: java.lang.Throwable -> Laa
            com.taobao.accs.ACCSManager$AccsRequest r2 = new com.taobao.accs.ACCSManager$AccsRequest     // Catch: java.lang.Throwable -> Laa
            java.lang.String r3 = "AgooDeviceCmd"
            r4 = 0
            r2.<init>(r4, r3, r11, r4)     // Catch: java.lang.Throwable -> Laa
            java.lang.String r9 = r5.b(r9, r2)     // Catch: java.lang.Throwable -> Laa
            boolean r11 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> Laa
            if (r11 == 0) goto L67
            if (r10 == 0) goto Lb4
            java.lang.String r9 = "503.2"
            java.lang.String r11 = "accs channel disabled!"
            r10.onFailure(r9, r11)     // Catch: java.lang.Throwable -> Laa
            goto Lb4
        L67:
            if (r10 == 0) goto Lb4
            com.taobao.agoo.a.b r11 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Laa
            java.util.Map<java.lang.String, com.taobao.agoo.ICallback> r11 = r11.f9418a     // Catch: java.lang.Throwable -> Laa
            r11.put(r9, r10)     // Catch: java.lang.Throwable -> Laa
            goto Lb4
        L71:
            if (r10 == 0) goto L7a
            java.lang.String r4 = "503.3"
            java.lang.String r5 = "input params null!!"
            r10.onFailure(r4, r5)     // Catch: java.lang.Throwable -> Laa
        L7a:
            java.lang.String r10 = "TaobaoRegister"
            java.lang.String r4 = "sendSwitch param null"
            r5 = 8
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> Laa
            java.lang.String r6 = "appkey"
            r5[r1] = r6     // Catch: java.lang.Throwable -> Laa
            r6 = 1
            r5[r6] = r3     // Catch: java.lang.Throwable -> Laa
            java.lang.String r3 = "deviceId"
            r6 = 2
            r5[r6] = r3     // Catch: java.lang.Throwable -> Laa
            r3 = 3
            r5[r3] = r2     // Catch: java.lang.Throwable -> Laa
            java.lang.String r2 = "context"
            r3 = 4
            r5[r3] = r2     // Catch: java.lang.Throwable -> Laa
            r2 = 5
            r5[r2] = r9     // Catch: java.lang.Throwable -> Laa
            java.lang.String r9 = "enablePush"
            r2 = 6
            r5[r2] = r9     // Catch: java.lang.Throwable -> Laa
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r11)     // Catch: java.lang.Throwable -> Laa
            r11 = 7
            r5[r11] = r9     // Catch: java.lang.Throwable -> Laa
            com.taobao.accs.utl.ALog.e(r10, r4, r5)     // Catch: java.lang.Throwable -> Laa
            monitor-exit(r0)
            return
        Laa:
            r9 = move-exception
            java.lang.String r10 = "TaobaoRegister"
            java.lang.String r11 = "sendSwitch"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lb6
            com.taobao.accs.utl.ALog.e(r10, r11, r9, r1)     // Catch: java.lang.Throwable -> Lb6
        Lb4:
            monitor-exit(r0)
            return
        Lb6:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.TaobaoRegister.sendSwitch(android.content.Context, com.taobao.agoo.ICallback, boolean):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void removeAlias(android.content.Context r9, com.taobao.agoo.ICallback r10) {
        /*
            java.lang.Class<com.taobao.agoo.TaobaoRegister> r0 = com.taobao.agoo.TaobaoRegister.class
            monitor-enter(r0)
            java.lang.String r1 = "TaobaoRegister"
            java.lang.String r2 = "removeAlias"
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lbb
            com.taobao.accs.utl.ALog.i(r1, r2, r4)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r1 = org.android.agoo.common.Config.g(r9)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r2 = org.android.agoo.common.Config.h(r9)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r4 = org.android.agoo.common.Config.a(r9)     // Catch: java.lang.Throwable -> Laf
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> Laf
            if (r5 != 0) goto L7a
            boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Laf
            if (r5 != 0) goto L7a
            if (r9 == 0) goto L7a
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Laf
            if (r5 == 0) goto L2e
            goto L7a
        L2e:
            java.lang.String r5 = org.android.agoo.common.Config.c(r9)     // Catch: java.lang.Throwable -> Laf
            com.taobao.accs.b r5 = com.taobao.accs.ACCSManager.getAccsInstance(r9, r4, r5)     // Catch: java.lang.Throwable -> Laf
            com.taobao.agoo.a.b r6 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Laf
            if (r6 != 0) goto L45
            com.taobao.agoo.a.b r6 = new com.taobao.agoo.a.b     // Catch: java.lang.Throwable -> Laf
            android.content.Context r7 = r9.getApplicationContext()     // Catch: java.lang.Throwable -> Laf
            r6.<init>(r7)     // Catch: java.lang.Throwable -> Laf
            com.taobao.agoo.TaobaoRegister.mRequestListener = r6     // Catch: java.lang.Throwable -> Laf
        L45:
            com.taobao.accs.client.GlobalClientInfo r6 = com.taobao.accs.client.GlobalClientInfo.getInstance(r9)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r7 = "AgooDeviceCmd"
            com.taobao.agoo.a.b r8 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Laf
            r6.registerListener(r7, r8)     // Catch: java.lang.Throwable -> Laf
            byte[] r1 = com.taobao.agoo.a.a.a.b(r4, r1, r2)     // Catch: java.lang.Throwable -> Laf
            com.taobao.accs.ACCSManager$AccsRequest r2 = new com.taobao.accs.ACCSManager$AccsRequest     // Catch: java.lang.Throwable -> Laf
            java.lang.String r4 = "AgooDeviceCmd"
            r6 = 0
            r2.<init>(r6, r4, r1, r6)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r9 = r5.b(r9, r2)     // Catch: java.lang.Throwable -> Laf
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> Laf
            if (r1 == 0) goto L70
            if (r10 == 0) goto Lb9
            java.lang.String r9 = "504.1"
            java.lang.String r1 = "accs channel disabled!"
            r10.onFailure(r9, r1)     // Catch: java.lang.Throwable -> Laf
            goto Lb9
        L70:
            if (r10 == 0) goto Lb9
            com.taobao.agoo.a.b r1 = com.taobao.agoo.TaobaoRegister.mRequestListener     // Catch: java.lang.Throwable -> Laf
            java.util.Map<java.lang.String, com.taobao.agoo.ICallback> r1 = r1.f9418a     // Catch: java.lang.Throwable -> Laf
            r1.put(r9, r10)     // Catch: java.lang.Throwable -> Laf
            goto Lb9
        L7a:
            if (r10 == 0) goto L83
            java.lang.String r5 = "504.1"
            java.lang.String r6 = "input params null!!"
            r10.onFailure(r5, r6)     // Catch: java.lang.Throwable -> Laf
        L83:
            java.lang.String r10 = "TaobaoRegister"
            java.lang.String r5 = "setAlias param null"
            r6 = 8
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> Laf
            java.lang.String r7 = "appkey"
            r6[r3] = r7     // Catch: java.lang.Throwable -> Laf
            r7 = 1
            r6[r7] = r4     // Catch: java.lang.Throwable -> Laf
            java.lang.String r4 = "deviceId"
            r7 = 2
            r6[r7] = r4     // Catch: java.lang.Throwable -> Laf
            r4 = 3
            r6[r4] = r1     // Catch: java.lang.Throwable -> Laf
            java.lang.String r1 = "pushAliasToken"
            r4 = 4
            r6[r4] = r1     // Catch: java.lang.Throwable -> Laf
            r1 = 5
            r6[r1] = r2     // Catch: java.lang.Throwable -> Laf
            java.lang.String r1 = "context"
            r2 = 6
            r6[r2] = r1     // Catch: java.lang.Throwable -> Laf
            r1 = 7
            r6[r1] = r9     // Catch: java.lang.Throwable -> Laf
            com.taobao.accs.utl.ALog.e(r10, r5, r6)     // Catch: java.lang.Throwable -> Laf
            monitor-exit(r0)
            return
        Laf:
            r9 = move-exception
            java.lang.String r10 = "TaobaoRegister"
            java.lang.String r1 = "removeAlias"
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lbb
            com.taobao.accs.utl.ALog.e(r10, r1, r9, r2)     // Catch: java.lang.Throwable -> Lbb
        Lb9:
            monitor-exit(r0)
            return
        Lbb:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.TaobaoRegister.removeAlias(android.content.Context, com.taobao.agoo.ICallback):void");
    }
}
