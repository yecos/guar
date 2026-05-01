package org.android.agoo.control;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.t;
import com.taobao.accs.utl.v;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.android.agoo.intent.IntentUtil;
import org.android.agoo.message.MessageService;

/* loaded from: classes.dex */
public abstract class BaseIntentService extends Service {
    private static final String TAG = "BaseIntentService";
    private static boolean isBinded = false;
    private static final String msgStatus = "4";
    private AgooFactory agooFactory;
    private MessageService messageService;
    private NotifManager notifyManager;
    private Context mContext = null;
    private Messenger messenger = new Messenger(new g(this));

    private final String getTrace(Context context, long j10) {
        String str = TextUtils.isEmpty(null) ? "unknow" : null;
        String str2 = TextUtils.isEmpty(null) ? "unknow" : null;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appkey");
        stringBuffer.append("|");
        stringBuffer.append(j10);
        stringBuffer.append("|");
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append("|");
        stringBuffer.append(str);
        stringBuffer.append("|");
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x0175 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cf A[Catch: all -> 0x0370, TryCatch #6 {all -> 0x0370, blocks: (B:26:0x00c1, B:28:0x00cf, B:29:0x010e, B:31:0x0137, B:33:0x0141, B:35:0x0153, B:38:0x015d, B:45:0x016f, B:47:0x0187, B:130:0x017e, B:137:0x00a2), top: B:136:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0137 A[Catch: all -> 0x0370, TryCatch #6 {all -> 0x0370, blocks: (B:26:0x00c1, B:28:0x00cf, B:29:0x010e, B:31:0x0137, B:33:0x0141, B:35:0x0153, B:38:0x015d, B:45:0x016f, B:47:0x0187, B:130:0x017e, B:137:0x00a2), top: B:136:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0187 A[Catch: all -> 0x0370, TRY_LEAVE, TryCatch #6 {all -> 0x0370, blocks: (B:26:0x00c1, B:28:0x00cf, B:29:0x010e, B:31:0x0137, B:33:0x0141, B:35:0x0153, B:38:0x015d, B:45:0x016f, B:47:0x0187, B:130:0x017e, B:137:0x00a2), top: B:136:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0206 A[Catch: all -> 0x036e, TryCatch #3 {all -> 0x036e, blocks: (B:56:0x01fe, B:58:0x0206, B:60:0x020e, B:61:0x0231, B:63:0x0239, B:65:0x0241, B:93:0x02f4, B:95:0x033b, B:97:0x0356, B:99:0x036a, B:102:0x0362, B:111:0x0295, B:113:0x029d, B:121:0x01e3), top: B:120:0x01e3, inners: #18 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0239 A[Catch: all -> 0x036e, TryCatch #3 {all -> 0x036e, blocks: (B:56:0x01fe, B:58:0x0206, B:60:0x020e, B:61:0x0231, B:63:0x0239, B:65:0x0241, B:93:0x02f4, B:95:0x033b, B:97:0x0356, B:99:0x036a, B:102:0x0362, B:111:0x0295, B:113:0x029d, B:121:0x01e3), top: B:120:0x01e3, inners: #18 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0356 A[Catch: Exception -> 0x0361, all -> 0x036e, TRY_LEAVE, TryCatch #18 {Exception -> 0x0361, blocks: (B:95:0x033b, B:97:0x0356), top: B:94:0x033b, outer: #3 }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleRemoteMessage(Context context, Intent intent) {
        String str;
        String str2;
        String str3;
        TaoBaseService.ExtraInfo extraInfo;
        String str4;
        String str5;
        String str6;
        String str7;
        CharSequence charSequence;
        int i10;
        String str8;
        NetPerformanceMonitor netPerformanceMonitor;
        try {
            String stringExtra = intent.getStringExtra("id");
            String stringExtra2 = intent.getStringExtra("body");
            String stringExtra3 = intent.getStringExtra("type");
            String stringExtra4 = intent.getStringExtra(AgooConstants.MESSAGE_SOURCE);
            String stringExtra5 = intent.getStringExtra(AgooConstants.MESSAGE_REPORT);
            String stringExtra6 = intent.getStringExtra(AgooConstants.MESSAGE_ENCRYPTED);
            String stringExtra7 = intent.getStringExtra(AgooConstants.MESSAGE_EXT);
            try {
                String stringExtra8 = intent.getStringExtra(AgooConstants.MESSAGE_ORI);
                try {
                    str3 = "messageId=";
                    try {
                        getTrace(context, Long.valueOf(intent.getLongExtra(AgooConstants.MESSAGE_TRACE, -1L)).longValue());
                        Bundle bundleExtra = intent.getBundleExtra(AgooConstants.MESSAGE_AGOO_BUNDLE);
                        extraInfo = bundleExtra != null ? (TaoBaseService.ExtraInfo) bundleExtra.getSerializable(AgooConstants.MESSAGE_ACCS_EXTRA) : null;
                        try {
                            str4 = intent.getStringExtra("source");
                            try {
                                if (TextUtils.isEmpty(str4)) {
                                    str4 = "oldsdk";
                                }
                                str6 = intent.getStringExtra(AgooConstants.MESSAGE_FROM_APPKEY);
                                str5 = TAG;
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    str5 = TAG;
                                    ALog.e(str5, "_trace,t=" + th, new Object[0]);
                                    str6 = null;
                                    extraInfo = extraInfo;
                                    if (ALog.isPrintLog(ALog.Level.I)) {
                                    }
                                    MsgDO msgDO = new MsgDO();
                                    msgDO.msgIds = stringExtra;
                                    msgDO.extData = stringExtra7;
                                    msgDO.messageSource = stringExtra4;
                                    msgDO.msgStatus = "4";
                                    msgDO.reportStr = stringExtra5;
                                    msgDO.fromPkg = str4;
                                    msgDO.fromAppkey = str6;
                                    msgDO.isStartProc = com.taobao.accs.client.a.c();
                                    msgDO.notifyEnable = com.taobao.accs.utl.j.c(this.mContext);
                                    if (!TextUtils.isEmpty(stringExtra2)) {
                                    }
                                    if (TextUtils.isEmpty(stringExtra2)) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    str = BaseMonitor.COUNT_AGOO_ARRIVE;
                                    str2 = "accs";
                                    com.taobao.accs.utl.k.a(str2, str, "arrive_exception" + th.toString(), 0.0d);
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            str4 = null;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        extraInfo = null;
                        str4 = null;
                        str5 = TAG;
                        ALog.e(str5, "_trace,t=" + th, new Object[0]);
                        str6 = null;
                        extraInfo = extraInfo;
                        if (ALog.isPrintLog(ALog.Level.I)) {
                        }
                        MsgDO msgDO2 = new MsgDO();
                        msgDO2.msgIds = stringExtra;
                        msgDO2.extData = stringExtra7;
                        msgDO2.messageSource = stringExtra4;
                        msgDO2.msgStatus = "4";
                        msgDO2.reportStr = stringExtra5;
                        msgDO2.fromPkg = str4;
                        msgDO2.fromAppkey = str6;
                        msgDO2.isStartProc = com.taobao.accs.client.a.c();
                        msgDO2.notifyEnable = com.taobao.accs.utl.j.c(this.mContext);
                        if (!TextUtils.isEmpty(stringExtra2)) {
                        }
                        if (TextUtils.isEmpty(stringExtra2)) {
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    str3 = "messageId=";
                }
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i(str5, "handleRemoteMessage", Constants.SHARED_MESSAGE_ID_FILE, stringExtra2, "source", stringExtra4, "msgId", stringExtra, "utdid", com.taobao.accs.utl.j.b(context), "fromPkg", str4, AgooConstants.MESSAGE_FROM_APPKEY, str6);
                }
                MsgDO msgDO22 = new MsgDO();
                msgDO22.msgIds = stringExtra;
                msgDO22.extData = stringExtra7;
                msgDO22.messageSource = stringExtra4;
                msgDO22.msgStatus = "4";
                msgDO22.reportStr = stringExtra5;
                msgDO22.fromPkg = str4;
                msgDO22.fromAppkey = str6;
                msgDO22.isStartProc = com.taobao.accs.client.a.c();
                msgDO22.notifyEnable = com.taobao.accs.utl.j.c(this.mContext);
                if (!TextUtils.isEmpty(stringExtra2)) {
                    if (!Integer.toString(4).equals(stringExtra6)) {
                        ALog.e(str5, "msg encrypted flag not exist~~", new Object[0]);
                        try {
                            msgDO22.errorCode = AgooConstants.REPORT_NOT_ENCRYPT;
                            this.notifyManager.report(msgDO22, extraInfo);
                            return;
                        } catch (Throwable unused) {
                            return;
                        }
                    }
                    ALog.i(str5, "message is encrypted, attemp to decrypt msg", new Object[0]);
                    stringExtra2 = AgooFactory.parseEncryptedMsg(stringExtra2);
                    if (TextUtils.isEmpty(stringExtra2)) {
                        msgDO22.errorCode = AgooConstants.REPORT_ENCRYPT_FAIL;
                        this.notifyManager.handlerACKMessage(msgDO22, extraInfo);
                        return;
                    }
                }
                if (TextUtils.isEmpty(stringExtra2)) {
                    try {
                        msgDO22.errorCode = AgooConstants.REPORT_MESSAGE_NULL;
                        this.notifyManager.report(msgDO22, extraInfo);
                    } catch (Throwable unused2) {
                    }
                    ALog.e(str5, "handleMessage--->[null]", new Object[0]);
                    return;
                }
                intent.putExtra("body", stringExtra2);
                try {
                    this.notifyManager.report(msgDO22, extraInfo);
                    this.messageService.a(stringExtra, stringExtra8, "0");
                    UTMini uTMini = UTMini.getInstance();
                    String[] strArr = new String[2];
                    strArr[0] = null;
                    StringBuilder sb = new StringBuilder();
                    str7 = str3;
                    try {
                        sb.append(str7);
                        sb.append(msgDO22.msgIds);
                        strArr[1] = sb.toString();
                        uTMini.commitEvent(UTMini.EVENTID_AGOO, UTMini.PAGE_AGOO, BaseMonitor.COUNT_AGOO_ARRIVE_ID, (Object) null, (Object) null, strArr);
                        str = BaseMonitor.COUNT_AGOO_ARRIVE;
                        str2 = "accs";
                        try {
                            com.taobao.accs.utl.k.a(str2, str, "arrive", 0.0d);
                        } catch (Throwable th6) {
                            th = th6;
                            try {
                                ALog.e(str5, "report message Throwable--->t=" + th.toString(), new Object[0]);
                                if (!this.messageService.a(stringExtra)) {
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                com.taobao.accs.utl.k.a(str2, str, "arrive_exception" + th.toString(), 0.0d);
                                return;
                            }
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        str = BaseMonitor.COUNT_AGOO_ARRIVE;
                        str2 = "accs";
                    }
                } catch (Throwable th9) {
                    th = th9;
                    str = BaseMonitor.COUNT_AGOO_ARRIVE;
                    str2 = "accs";
                    str7 = str3;
                }
                if (!this.messageService.a(stringExtra)) {
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i(str5, "handleRemoteMessage hasMessageDuplicate,messageId=" + stringExtra + ",utdid=" + com.taobao.accs.utl.j.b(context), new Object[0]);
                    }
                    com.taobao.accs.utl.k.a(str2, str, "arrive_dup", 0.0d);
                    return;
                }
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i(str5, "handleMessage--->[" + stringExtra2 + "],[" + stringExtra4 + "]", new Object[0]);
                }
                try {
                    String stringExtra9 = intent.getStringExtra(AgooConstants.MESSAGE_DUPLICATE);
                    if (TextUtils.isEmpty(stringExtra9)) {
                        charSequence = "1";
                    } else {
                        charSequence = "1";
                        try {
                            if (TextUtils.equals(stringExtra9, charSequence) && this.messageService.a(stringExtra, stringExtra2.hashCode())) {
                                com.taobao.accs.utl.k.a(str2, str, "arrive_dupbody", 0.0d);
                                return;
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            if (ALog.isPrintLog(ALog.Level.E)) {
                                ALog.e(str5, "hasMessageDuplicate message,e=" + th.toString(), new Object[0]);
                            }
                            i10 = Integer.parseInt(intent.getStringExtra(AgooConstants.MESSAGE_NOTIFICATION));
                            String str9 = "";
                            str8 = intent.getStringExtra(AgooConstants.MESSAGE_HAS_TEST);
                            if (TextUtils.isEmpty(str8)) {
                            }
                            str8 = stringExtra3;
                            str9 = getClass().getName();
                            this.messageService.a(stringExtra, stringExtra2, str8, i10);
                            UTMini.getInstance().commitEvent(UTMini.EVENTID_AGOO, UTMini.PAGE_AGOO, BaseMonitor.COUNT_AGOO_ARRIVE_REAL_ID, (Object) null, (Object) null, null, str7 + msgDO22.msgIds);
                            com.taobao.accs.utl.k.a(str2, str, "arrive_real_" + str9, 0.0d);
                            try {
                                intent.getExtras().setClassLoader(NetPerformanceMonitor.class.getClassLoader());
                                netPerformanceMonitor = (NetPerformanceMonitor) intent.getExtras().getSerializable(Constants.KEY_MONIROT);
                                if (netPerformanceMonitor != null) {
                                }
                            } catch (Exception e10) {
                                ALog.e(str5, "get NetPerformanceMonitor Error:", e10, new Object[0]);
                            }
                            onMessage(context, intent);
                        }
                    }
                } catch (Throwable th11) {
                    th = th11;
                    charSequence = "1";
                }
                try {
                    i10 = Integer.parseInt(intent.getStringExtra(AgooConstants.MESSAGE_NOTIFICATION));
                } catch (Throwable unused3) {
                    i10 = -1;
                }
                String str92 = "";
                try {
                    str8 = intent.getStringExtra(AgooConstants.MESSAGE_HAS_TEST);
                } catch (Throwable unused4) {
                    str8 = stringExtra3;
                }
                if (TextUtils.isEmpty(str8) && TextUtils.equals(str8, charSequence)) {
                    this.messageService.a(stringExtra, stringExtra2, stringExtra3, i10);
                    com.taobao.accs.utl.k.a(str2, str, "arrive_test", 0.0d);
                    return;
                }
                str8 = stringExtra3;
                str92 = getClass().getName();
                this.messageService.a(stringExtra, stringExtra2, str8, i10);
                UTMini.getInstance().commitEvent(UTMini.EVENTID_AGOO, UTMini.PAGE_AGOO, BaseMonitor.COUNT_AGOO_ARRIVE_REAL_ID, (Object) null, (Object) null, null, str7 + msgDO22.msgIds);
                com.taobao.accs.utl.k.a(str2, str, "arrive_real_" + str92, 0.0d);
                intent.getExtras().setClassLoader(NetPerformanceMonitor.class.getClassLoader());
                netPerformanceMonitor = (NetPerformanceMonitor) intent.getExtras().getSerializable(Constants.KEY_MONIROT);
                if (netPerformanceMonitor != null) {
                    netPerformanceMonitor.onToAgooTime();
                    AppMonitor.getInstance().commitStat(netPerformanceMonitor);
                }
                onMessage(context, intent);
            } catch (Throwable th12) {
                th = th12;
                str2 = "accs";
                str = BaseMonitor.COUNT_AGOO_ARRIVE;
            }
        } catch (Throwable th13) {
            th = th13;
            str = BaseMonitor.COUNT_AGOO_ARRIVE;
            str2 = "accs";
        }
    }

    private final void handleRemovePackage(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        Uri data = intent.getData();
        String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : null;
        if (TextUtils.isEmpty(schemeSpecificPart)) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(TAG, "handleRemovePackage---->[replacing:" + booleanExtra + "],uninstallPack=" + schemeSpecificPart, new Object[0]);
        }
        if (booleanExtra) {
            return;
        }
        this.notifyManager.doUninstall(schemeSpecificPart, booleanExtra);
    }

    public static void runIntentInService(Context context, Intent intent, String str) {
        try {
            intent.setClassName(context, str);
            context.startService(intent);
        } catch (Throwable th) {
            ALog.w(TAG, "runIntentInService", th, new Object[0]);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        getApplication();
        if (t.b() && v.a(this) && !isBinded) {
            isBinded = true;
            getApplicationContext().bindService(new Intent(getApplication(), getClass()), new i(this), 1);
        }
        return this.messenger.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ThreadPoolExecutorFactory.execute(new j(this));
    }

    public abstract void onError(Context context, String str);

    public void onHandleIntent(Intent intent) {
        this.mContext = getApplicationContext();
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        String agooCommand = IntentUtil.getAgooCommand(this.mContext);
        String thirdPushCommand = IntentUtil.getThirdPushCommand(this.mContext);
        ALog.i(TAG, "onHandleIntent,action=" + action + ",agooCommand=" + agooCommand + ",mipushCommand=" + thirdPushCommand, new Object[0]);
        try {
            if (TextUtils.equals(action, agooCommand)) {
                String stringExtra = intent.getStringExtra("command");
                ALog.d(TAG, "actionCommand --->[" + stringExtra + "]", new Object[0]);
                if (TextUtils.equals(stringExtra, AgooConstants.AGOO_COMMAND_MESSAGE_READED) || TextUtils.equals(stringExtra, AgooConstants.AGOO_COMMAND_MESSAGE_DELETED)) {
                    onUserCommand(this.mContext, intent);
                }
            } else if (TextUtils.equals(action, thirdPushCommand)) {
                String stringExtra2 = intent.getStringExtra("command");
                String stringExtra3 = intent.getStringExtra(AgooConstants.THIRD_PUSH_ID);
                if (TextUtils.equals(stringExtra2, AgooConstants.AGOO_COMMAND_MIPUSHID_REPORT)) {
                    this.notifyManager.reportThirdPushToken(stringExtra3, "MI_TOKEN", false);
                } else if (TextUtils.equals(stringExtra2, AgooConstants.AGOO_COMMAND_HUAWEIPUSHID_REPORT)) {
                    ALog.d(TAG, "HW_TOKEN report begin..regid=" + stringExtra3, new Object[0]);
                    this.notifyManager.reportThirdPushToken(stringExtra3, "HW_TOKEN", false);
                } else if (TextUtils.equals(stringExtra2, AgooConstants.AGOO_COMMAND_GCMIPUSHID_REPORT)) {
                    ALog.i(TAG, "GCM_TOKEN report begin..regid=" + stringExtra3, new Object[0]);
                    this.notifyManager.reportThirdPushToken(stringExtra3, "gcm", false);
                }
            } else if (action.equals(AgooConstants.INTENT_FROM_AGOO_MESSAGE)) {
                handleRemoteMessage(this.mContext, intent);
            } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                handleRemovePackage(this.mContext, intent);
            } else if (TextUtils.equals(action, AgooConstants.INTENT_FROM_AGOO_REPORT) || TextUtils.equals(action, "android.net.conn.CONNECTIVITY_CHANGE") || TextUtils.equals(action, "android.intent.action.BOOT_COMPLETED") || TextUtils.equals(action, "android.intent.action.PACKAGE_ADDED") || TextUtils.equals(action, "android.intent.action.PACKAGE_REPLACED") || TextUtils.equals(action, "android.intent.action.USER_PRESENT") || TextUtils.equals(action, "android.intent.action.ACTION_POWER_CONNECTED") || TextUtils.equals(action, "android.intent.action.ACTION_POWER_DISCONNECTED")) {
                try {
                    ALog.i(TAG, "is report cache msg,Config.isReportCacheMsg(mContext)=" + Config.d(this.mContext), new Object[0]);
                    if (Config.d(this.mContext) && UtilityImpl.i(this.mContext)) {
                        Config.e(this.mContext);
                        this.agooFactory.reportCacheMsg();
                        this.messageService.a();
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i(TAG, "is clear all msg=" + Config.b(this.mContext, currentTimeMillis), new Object[0]);
                    }
                    if (Config.b(this.mContext, currentTimeMillis)) {
                        Config.a(this.mContext, currentTimeMillis);
                        this.messageService.a();
                    }
                } catch (Throwable th) {
                    ALog.e(TAG, "reportCacheMsg", th, new Object[0]);
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public abstract void onMessage(Context context, Intent intent);

    public abstract void onRegistered(Context context, String str);

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        ThreadPoolExecutorFactory.execute(new k(this, intent));
        return 2;
    }

    public void onUserCommand(Context context, Intent intent) {
    }
}
