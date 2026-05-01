package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.IAppReceiverV1;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.t;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.Config;

/* loaded from: classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static Set<String> f9122a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile g f9123b;

    public static g a() {
        if (f9123b == null) {
            synchronized (g.class) {
                if (f9123b == null) {
                    f9123b = new g();
                }
            }
        }
        return f9123b;
    }

    public String b() {
        return com.taobao.accs.utl.j.msgService;
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x0209, code lost:
    
        if (com.taobao.accs.utl.t.e() != false) goto L118;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0110 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0111 A[Catch: all -> 0x02c3, TRY_LEAVE, TryCatch #2 {all -> 0x02c3, blocks: (B:20:0x0096, B:22:0x00ca, B:30:0x0104, B:33:0x0111, B:43:0x013e, B:46:0x014f, B:106:0x00f4), top: B:19:0x0096 }] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [com.taobao.accs.IAppReceiver] */
    /* JADX WARN: Type inference failed for: r44v0, types: [com.taobao.accs.data.g] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Context context, Intent intent) {
        NetPerformanceMonitor a10;
        Object obj;
        String str;
        String str2;
        int i10;
        char c10;
        String str3;
        int i11;
        String str4;
        int i12;
        ?? r10;
        String str5;
        String str6;
        long currentTimeMillis;
        long currentTimeMillis2 = System.currentTimeMillis();
        String stringExtra = intent.getStringExtra(Constants.KEY_DATA_ID);
        String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
        String action = intent.getAction();
        ALog.Level level = ALog.Level.D;
        IAppReceiver iAppReceiver = null;
        if (ALog.isPrintLog(level) || ("accs-impaas".equals(stringExtra2) && t.e())) {
            ALog.e("MsgDistribute", "distribute ready", "action", action, Constants.KEY_DATA_ID, stringExtra, Constants.KEY_SERVICE_ID, stringExtra2);
            a10 = com.taobao.accs.utl.a.a(intent);
        } else {
            a10 = null;
        }
        if (a10 != null) {
            a10.thread_schedule_time = System.currentTimeMillis() - currentTimeMillis2;
        }
        if (TextUtils.isEmpty(action)) {
            ALog.e("MsgDistribute", "action null", new Object[0]);
            UTMini.getInstance().commitEvent(66001, "MsgToBuss9", "action null", Integer.valueOf(Constants.SDK_VERSION_CODE));
            return;
        }
        try {
            if (!TextUtils.equals(action, Constants.ACTION_RECEIVE)) {
                obj = Constants.KEY_SERVICE_ID;
                str = stringExtra;
                str2 = "accs";
                i10 = 4;
                c10 = 2;
                str3 = "MsgDistribute";
                try {
                    ALog.e(str3, "distribMessage action error", new Object[0]);
                    UTMini.getInstance().commitEvent(66001, "MsgToBuss10", action, Integer.valueOf(Constants.SDK_VERSION_CODE));
                    return;
                } catch (Throwable th) {
                    th = th;
                    i11 = 0;
                    str4 = str3;
                    Object[] objArr = new Object[i10];
                    objArr[0] = Constants.KEY_DATA_ID;
                    objArr[1] = str;
                    objArr[c10] = obj;
                    objArr[3] = stringExtra2;
                    ALog.e(str4, "distribMessage", th, objArr);
                    com.taobao.accs.utl.k.a(str2, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, "1", "distribute error " + i11 + UtilityImpl.a(th));
                    return;
                }
            }
            int intExtra = intent.getIntExtra("command", -1);
            try {
                String stringExtra3 = intent.getStringExtra(Constants.KEY_USER_ID);
                int intExtra2 = intent.getIntExtra("errorCode", 0);
                String stringExtra4 = intent.getStringExtra(Constants.KEY_APP_KEY);
                String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
                if (intent.getPackage() == null) {
                    try {
                        intent.setPackage(context.getPackageName());
                    } catch (Throwable th2) {
                        th = th2;
                        i11 = intExtra;
                        obj = Constants.KEY_SERVICE_ID;
                        str = stringExtra;
                        str2 = "accs";
                        i10 = 4;
                        c10 = 2;
                        str4 = "MsgDistribute";
                        Object[] objArr2 = new Object[i10];
                        objArr2[0] = Constants.KEY_DATA_ID;
                        objArr2[1] = str;
                        objArr2[c10] = obj;
                        objArr2[3] = stringExtra2;
                        ALog.e(str4, "distribMessage", th, objArr2);
                        com.taobao.accs.utl.k.a(str2, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, "1", "distribute error " + i11 + UtilityImpl.a(th));
                        return;
                    }
                }
                if (!"accs".equals(stringExtra2) && !"accs-impaas".equals(stringExtra2)) {
                    str5 = "accs-impaas";
                    ALog.d("MsgDistribute", "distribute start", "appkey", stringExtra4, "config", stringExtra5);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    if (!a(context, intent, stringExtra, stringExtra2)) {
                        return;
                    }
                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                    long currentTimeMillis5 = System.currentTimeMillis();
                    if (intExtra < 0) {
                        ALog.e("MsgDistribute", "command error:" + intExtra, Constants.KEY_SERVICE_ID, stringExtra2);
                        return;
                    }
                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
                    long currentTimeMillis7 = System.currentTimeMillis();
                    if (a(intExtra, stringExtra2)) {
                        return;
                    }
                    long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis7;
                    long currentTimeMillis9 = System.currentTimeMillis();
                    c10 = 2;
                    try {
                        if (a(context, intent, stringExtra, stringExtra2, stringExtra5)) {
                            return;
                        }
                        long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis9;
                        long currentTimeMillis11 = System.currentTimeMillis();
                        Map<String, IAppReceiver> appReceiver = GlobalClientInfo.getInstance(context).getAppReceiver();
                        if (TextUtils.isEmpty(stringExtra5) || appReceiver == null) {
                            str6 = stringExtra5;
                        } else {
                            str6 = stringExtra5;
                            try {
                                iAppReceiver = appReceiver.get(str6);
                            } catch (Throwable th3) {
                                th = th3;
                                i11 = intExtra;
                                obj = Constants.KEY_SERVICE_ID;
                                str = stringExtra;
                                str2 = "accs";
                                str4 = "MsgDistribute";
                                i10 = 4;
                                Object[] objArr22 = new Object[i10];
                                objArr22[0] = Constants.KEY_DATA_ID;
                                objArr22[1] = str;
                                objArr22[c10] = obj;
                                objArr22[3] = stringExtra2;
                                ALog.e(str4, "distribMessage", th, objArr22);
                                com.taobao.accs.utl.k.a(str2, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, "1", "distribute error " + i11 + UtilityImpl.a(th));
                                return;
                            }
                        }
                        String str7 = str6;
                        if (a(context, stringExtra2, stringExtra, intent, iAppReceiver)) {
                            return;
                        }
                        long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis11;
                        long currentTimeMillis13 = System.currentTimeMillis();
                        str2 = "accs";
                        String str8 = str5;
                        i10 = 4;
                        i12 = intExtra;
                        stringExtra2 = stringExtra;
                        obj = Constants.KEY_SERVICE_ID;
                        r10 = iAppReceiver;
                        str = stringExtra;
                        try {
                            a(context, intent, str7, stringExtra4, intExtra, stringExtra3, stringExtra2, stringExtra2, r10, intExtra2);
                            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis13;
                        } catch (Throwable th4) {
                            th = th4;
                            stringExtra2 = stringExtra2;
                        }
                        try {
                            if (TextUtils.isEmpty(stringExtra2)) {
                                a(context, appReceiver, intent, i12, intExtra2);
                                return;
                            }
                            stringExtra2 = stringExtra2;
                            try {
                                if (!ALog.isPrintLog(level)) {
                                    try {
                                        if (str8.equals(stringExtra2)) {
                                        }
                                        a(context, iAppReceiver, intent, stringExtra2, str, i12, intExtra2);
                                        return;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        i11 = i12;
                                        str4 = "MsgDistribute";
                                        Object[] objArr222 = new Object[i10];
                                        objArr222[0] = Constants.KEY_DATA_ID;
                                        objArr222[1] = str;
                                        objArr222[c10] = obj;
                                        objArr222[3] = stringExtra2;
                                        ALog.e(str4, "distribMessage", th, objArr222);
                                        com.taobao.accs.utl.k.a(str2, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, "1", "distribute error " + i11 + UtilityImpl.a(th));
                                        return;
                                    }
                                }
                                ALog.e("MsgDistribute", "handleBusinessMsg start", Constants.KEY_DATA_ID, str, obj, stringExtra2, "command", Integer.valueOf(i12), "t1", Long.valueOf(currentTimeMillis4), "t2", Long.valueOf(currentTimeMillis6), "t3", Long.valueOf(currentTimeMillis8), "t4", Long.valueOf(currentTimeMillis10), "t5", Long.valueOf(currentTimeMillis12), "t6", Long.valueOf(currentTimeMillis));
                                a(context, iAppReceiver, intent, stringExtra2, str, i12, intExtra2);
                                return;
                            } catch (Throwable th6) {
                                th = th6;
                                r10 = "MsgDistribute";
                                i11 = i12;
                                str4 = r10;
                                Object[] objArr2222 = new Object[i10];
                                objArr2222[0] = Constants.KEY_DATA_ID;
                                objArr2222[1] = str;
                                objArr2222[c10] = obj;
                                objArr2222[3] = stringExtra2;
                                ALog.e(str4, "distribMessage", th, objArr2222);
                                com.taobao.accs.utl.k.a(str2, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, "1", "distribute error " + i11 + UtilityImpl.a(th));
                                return;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            i11 = i12;
                            str4 = r10;
                            Object[] objArr22222 = new Object[i10];
                            objArr22222[0] = Constants.KEY_DATA_ID;
                            objArr22222[1] = str;
                            objArr22222[c10] = obj;
                            objArr22222[3] = stringExtra2;
                            ALog.e(str4, "distribMessage", th, objArr22222);
                            com.taobao.accs.utl.k.a(str2, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, "1", "distribute error " + i11 + UtilityImpl.a(th));
                            return;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        i12 = intExtra;
                        obj = Constants.KEY_SERVICE_ID;
                        str = stringExtra;
                        str2 = "accs";
                        r10 = "MsgDistribute";
                        i10 = 4;
                    }
                }
                str5 = "accs-impaas";
                ALog.e("MsgDistribute", "distribute start", "appkey", stringExtra4, "config", stringExtra5);
                long currentTimeMillis32 = System.currentTimeMillis();
                if (!a(context, intent, stringExtra, stringExtra2)) {
                }
            } catch (Throwable th9) {
                th = th9;
                i12 = intExtra;
                obj = Constants.KEY_SERVICE_ID;
                str = stringExtra;
                str2 = "accs";
                i10 = 4;
                c10 = 2;
                r10 = "MsgDistribute";
            }
        } catch (Throwable th10) {
            th = th10;
            obj = Constants.KEY_SERVICE_ID;
            str = stringExtra;
            str2 = "accs";
            i10 = 4;
            c10 = 2;
            str3 = "MsgDistribute";
        }
    }

    public static void a(Context context, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_DATA_ID);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
            if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(stringExtra2)) {
                ALog.e("MsgDistribute", "distribMessage", Constants.KEY_DATA_ID, stringExtra);
            }
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new h(context, intent));
        } catch (Throwable th) {
            ALog.e("MsgDistribute", "distribMessage", th, new Object[0]);
            UTMini.getInstance().commitEvent(66001, "MsgToBuss8", "distribMessage" + th.toString(), Integer.valueOf(Constants.SDK_VERSION_CODE));
        }
    }

    public boolean a(int i10, String str) {
        if (i10 == 100 || GlobalClientInfo.AGOO_SERVICE_ID.equals(str)) {
            return false;
        }
        long e10 = UtilityImpl.e();
        if (e10 == -1 || e10 > com.hpplay.logwriter.b.f7378a) {
            return false;
        }
        com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", "space low");
        ALog.e("MsgDistribute", "user space low, don't distribute", "size", Long.valueOf(e10), Constants.KEY_SERVICE_ID, str);
        return true;
    }

    public boolean a(Context context, String str, String str2, Intent intent, IAppReceiver iAppReceiver) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String service = GlobalClientInfo.getInstance(context).getService(intent.getStringExtra(Constants.KEY_CONFIG_TAG), str);
            if (TextUtils.isEmpty(service) && iAppReceiver != null) {
                service = iAppReceiver.getService(str);
            }
            if (TextUtils.isEmpty(service)) {
                service = GlobalClientInfo.getInstance(context).getService(str);
            }
            if (!TextUtils.isEmpty(service) || UtilityImpl.isMainProcess(context)) {
                return false;
            }
            if ("accs".equals(str)) {
                ALog.e("MsgDistribute", "start MsgDistributeService", Constants.KEY_DATA_ID, str2);
            } else {
                ALog.i("MsgDistribute", "start MsgDistributeService", Constants.KEY_DATA_ID, str2);
            }
            intent.setClassName(intent.getPackage(), b());
            com.taobao.accs.a.a.a(context, intent);
            return true;
        } catch (Throwable th) {
            ALog.e("MsgDistribute", "handleMsgInChannelProcess", th, new Object[0]);
            return false;
        }
    }

    private void a(Context context, Intent intent, String str, String str2, int i10, String str3, String str4, String str5, IAppReceiver iAppReceiver, int i11) {
        if (ALog.isPrintLog(ALog.Level.D)) {
            Object[] objArr = new Object[12];
            objArr[0] = Constants.KEY_CONFIG_TAG;
            objArr[1] = str;
            objArr[2] = Constants.KEY_DATA_ID;
            objArr[3] = str5;
            objArr[4] = Constants.KEY_SERVICE_ID;
            objArr[5] = str4;
            objArr[6] = "command";
            objArr[7] = Integer.valueOf(i10);
            objArr[8] = "errorCode";
            objArr[9] = Integer.valueOf(i11);
            objArr[10] = "appReceiver";
            objArr[11] = iAppReceiver == null ? null : iAppReceiver.getClass().getName();
            ALog.d("MsgDistribute", "handleControlMsg", objArr);
        }
        if (iAppReceiver != null) {
            if (i10 != 1) {
                if (i10 == 2) {
                    if (i11 == 200) {
                        UtilityImpl.disableService(context);
                    }
                    iAppReceiver.onUnbindApp(i11);
                } else if (i10 == 3) {
                    iAppReceiver.onBindUser(str3, i11);
                } else if (i10 == 4) {
                    iAppReceiver.onUnbindUser(i11);
                } else if (i10 != 100) {
                    if (i10 == 101 && TextUtils.isEmpty(str4)) {
                        ALog.d("MsgDistribute", "handleControlMsg serviceId isEmpty", new Object[0]);
                        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
                        if (byteArrayExtra != null) {
                            iAppReceiver.onData(str3, str5, byteArrayExtra);
                        }
                    }
                } else if (TextUtils.isEmpty(str4)) {
                    iAppReceiver.onSendData(str5, i11);
                }
            } else if (iAppReceiver instanceof IAppReceiverV1) {
                ((IAppReceiverV1) iAppReceiver).onBindApp(i11, null);
            } else {
                iAppReceiver.onBindApp(i11);
            }
        }
        if (i10 == 1 && GlobalClientInfo.f9032b != null && str2 != null && str2.equals(Config.a(context))) {
            ALog.d("MsgDistribute", "handleControlMsg agoo receiver onBindApp", new Object[0]);
            GlobalClientInfo.f9032b.onBindApp(i11, null);
            return;
        }
        if (iAppReceiver != null || i10 == 100 || i10 == 104 || i10 == 103) {
            return;
        }
        com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str4, "1", "appReceiver null return");
        UTMini.getInstance().commitEvent(66001, "MsgToBuss7", "commandId=" + i10, "serviceId=" + str4 + " errorCode=" + i11 + " dataId=" + str5, Integer.valueOf(Constants.SDK_VERSION_CODE));
    }

    public void a(Context context, IAppReceiver iAppReceiver, Intent intent, String str, String str2, int i10, int i11) {
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level) || "accs-impaas".equals(str)) {
            ALog.e("MsgDistribute", "handleBusinessMsg start", Constants.KEY_DATA_ID, str2, Constants.KEY_SERVICE_ID, str, "command", Integer.valueOf(i10));
        }
        String service = GlobalClientInfo.getInstance(context).getService(intent.getStringExtra(Constants.KEY_CONFIG_TAG), str);
        if (TextUtils.isEmpty(service) && iAppReceiver != null) {
            service = iAppReceiver.getService(str);
        }
        if (TextUtils.isEmpty(service)) {
            service = GlobalClientInfo.getInstance(context).getService(str);
        }
        if (!TextUtils.isEmpty(service)) {
            if (ALog.isPrintLog(level) || "accs-impaas".equals(str)) {
                ALog.e("MsgDistribute", "handleBusinessMsg to start service", "className", service);
            }
            NetPerformanceMonitor a10 = com.taobao.accs.utl.a.a(intent);
            if (a10 != null) {
                a10.start_service = System.currentTimeMillis();
            }
            intent.setClassName(context, service);
            com.taobao.accs.a.a.a(context, intent);
        } else {
            AccsDataListener listener = GlobalClientInfo.getInstance(context).getListener(str);
            if (listener != null) {
                if (ALog.isPrintLog(level) || "accs-impaas".equals(str)) {
                    ALog.e("MsgDistribute", "handleBusinessMsg getListener not null", new Object[0]);
                }
                com.taobao.accs.utl.a.a(context, intent, listener);
            } else {
                ALog.e("MsgDistribute", "handleBusinessMsg getListener also null", new Object[0]);
                com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", "service is null");
            }
        }
        UTMini.getInstance().commitEvent(66001, "MsgToBuss", "commandId=" + i10, "serviceId=" + str + " errorCode=" + i11 + " dataId=" + str2, Integer.valueOf(Constants.SDK_VERSION_CODE));
        StringBuilder sb = new StringBuilder();
        sb.append("2commandId=");
        sb.append(i10);
        sb.append("serviceId=");
        sb.append(str);
        com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_TO_BUSS, sb.toString(), 0.0d);
    }

    public void a(Context context, Map<String, IAppReceiver> map, Intent intent, int i10, int i11) {
        TaoBaseService.ConnectInfo connectInfo;
        ALog.e("MsgDistribute", "handBroadCastMsg", "command", Integer.valueOf(i10));
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (Map.Entry<String, IAppReceiver> entry : map.entrySet()) {
                Map<String, String> allService = GlobalClientInfo.getInstance(context).getAllService(entry.getKey());
                if (allService == null) {
                    allService = entry.getValue().getAllServices();
                }
                if (allService != null) {
                    hashMap.putAll(allService);
                }
            }
        }
        if (i10 != 103) {
            if (i10 == 104) {
                for (String str : hashMap.keySet()) {
                    String str2 = (String) hashMap.get(str);
                    if (TextUtils.isEmpty(str2)) {
                        str2 = GlobalClientInfo.getInstance(context).getService(str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        intent.setClassName(context, str2);
                        com.taobao.accs.a.a.a(context, intent);
                    }
                }
                return;
            }
            ALog.w("MsgDistribute", "handBroadCastMsg not handled command", new Object[0]);
            return;
        }
        for (String str3 : hashMap.keySet()) {
            if ("accs".equals(str3) || "windvane".equals(str3) || "motu-remote".equals(str3)) {
                String str4 = (String) hashMap.get(str3);
                if (TextUtils.isEmpty(str4)) {
                    str4 = GlobalClientInfo.getInstance(context).getService(str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    intent.setClassName(context, str4);
                    com.taobao.accs.a.a.a(context, intent);
                }
            }
        }
        boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
        String stringExtra = intent.getStringExtra(Constants.KEY_HOST);
        String stringExtra2 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
        boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
        boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
        if (TextUtils.isEmpty(stringExtra)) {
            connectInfo = null;
        } else {
            if (booleanExtra) {
                connectInfo = new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3);
            } else {
                connectInfo = new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3, i11, stringExtra2);
            }
            connectInfo.connected = booleanExtra;
        }
        if (connectInfo != null) {
            ALog.d("MsgDistribute", "handBroadCastMsg ACTION_CONNECT_INFO", connectInfo);
            Intent intent2 = new Intent(Constants.ACTION_CONNECT_INFO);
            intent2.setPackage(context.getPackageName());
            intent2.putExtra(Constants.KEY_CONNECT_INFO, connectInfo);
            context.sendBroadcast(intent2);
            return;
        }
        ALog.e("MsgDistribute", "handBroadCastMsg connect info null, host empty", new Object[0]);
    }

    private boolean a(Context context, Intent intent, String str, String str2) {
        boolean z10;
        boolean booleanExtra = intent.getBooleanExtra("routingAck", false);
        boolean booleanExtra2 = intent.getBooleanExtra("routingMsg", false);
        if (booleanExtra) {
            ALog.e("MsgDistribute", "recieve routiong ack", Constants.KEY_DATA_ID, str, Constants.KEY_SERVICE_ID, str2);
            Set<String> set = f9122a;
            if (set != null) {
                set.remove(str);
            }
            com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "");
            z10 = true;
        } else {
            z10 = false;
        }
        if (booleanExtra2) {
            try {
                String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
                ALog.e("MsgDistribute", "send routiong ack", Constants.KEY_DATA_ID, str, "to pkg", stringExtra, Constants.KEY_SERVICE_ID, str2);
                Intent intent2 = new Intent(Constants.ACTION_COMMAND);
                intent2.putExtra("command", 106);
                intent2.setClassName(stringExtra, com.taobao.accs.utl.j.channelService);
                intent2.putExtra("routingAck", true);
                intent2.putExtra(Constants.KEY_PACKAGE_NAME, stringExtra);
                intent2.putExtra(Constants.KEY_DATA_ID, str);
                com.taobao.accs.a.a.a(context, intent2);
            } catch (Throwable th) {
                ALog.e("MsgDistribute", "send routing ack", th, Constants.KEY_SERVICE_ID, str2);
            }
        }
        return z10;
    }

    private boolean a(Context context, Intent intent, String str, String str2, String str3) {
        AccsClientConfig configByTag = !TextUtils.isEmpty(str3) ? AccsClientConfig.getConfigByTag(str3) : null;
        if (context.getPackageName().equals(intent.getPackage())) {
            return false;
        }
        if (configByTag != null && !configByTag.isPullUpEnable()) {
            return false;
        }
        try {
            ALog.e("MsgDistribute", "start MsgDistributeService", "receive pkg", context.getPackageName(), "target pkg", intent.getPackage(), Constants.KEY_SERVICE_ID, str2);
            intent.setClassName(intent.getPackage(), com.taobao.accs.utl.j.msgService);
            intent.putExtra("routingMsg", true);
            intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
            com.taobao.accs.a.a.a(context, intent);
            if (f9122a == null) {
                f9122a = new HashSet();
            }
            f9122a.add(str);
            ThreadPoolExecutorFactory.schedule(new i(this, str, str2, intent), 10L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "", "exception", th.toString());
            ALog.e("MsgDistribute", "routing msg error, try election", th, Constants.KEY_SERVICE_ID, str2, Constants.KEY_DATA_ID, str);
        }
        return true;
    }
}
