package com.taobao.accs.utl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.accs.AgooService;

/* loaded from: classes3.dex */
public class a {
    public static final String TAG = "a";

    /* renamed from: a, reason: collision with root package name */
    private static Handler f9317a = new Handler(Looper.getMainLooper());

    /* JADX WARN: Removed duplicated region for block: B:16:0x008b A[Catch: Exception -> 0x02c3, all -> 0x02c5, TRY_ENTER, TRY_LEAVE, TryCatch #3 {, blocks: (B:7:0x0020, B:99:0x0044, B:16:0x008b, B:18:0x00e2, B:32:0x00fd, B:35:0x0107, B:37:0x0131, B:40:0x0159, B:42:0x0163, B:45:0x0173, B:47:0x0180, B:49:0x0188, B:51:0x01af, B:53:0x01b5, B:55:0x01d3, B:57:0x01ee, B:59:0x01f5, B:61:0x0208, B:64:0x01fe, B:65:0x018e, B:66:0x0232, B:68:0x0242, B:70:0x0247, B:72:0x0251, B:74:0x025b, B:76:0x0263, B:77:0x026a, B:79:0x0278, B:81:0x028e, B:88:0x02a5, B:90:0x02ae, B:93:0x02b7, B:12:0x0055), top: B:6:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02b7 A[Catch: Exception -> 0x02c1, all -> 0x02c5, TRY_LEAVE, TryCatch #3 {, blocks: (B:7:0x0020, B:99:0x0044, B:16:0x008b, B:18:0x00e2, B:32:0x00fd, B:35:0x0107, B:37:0x0131, B:40:0x0159, B:42:0x0163, B:45:0x0173, B:47:0x0180, B:49:0x0188, B:51:0x01af, B:53:0x01b5, B:55:0x01d3, B:57:0x01ee, B:59:0x01f5, B:61:0x0208, B:64:0x01fe, B:65:0x018e, B:66:0x0232, B:68:0x0242, B:70:0x0247, B:72:0x0251, B:74:0x025b, B:76:0x0263, B:77:0x026a, B:79:0x0278, B:81:0x028e, B:88:0x02a5, B:90:0x02ae, B:93:0x02b7, B:12:0x0055), top: B:6:0x0020 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, Intent intent, AccsDataListener accsDataListener) {
        String str;
        String str2;
        int intExtra;
        int intExtra2;
        String stringExtra;
        String stringExtra2;
        String stringExtra3;
        String str3;
        String str4 = BaseMonitor.ALARM_POINT_REQ_ERROR;
        if (accsDataListener == null || context == null) {
            ALog.e(TAG, "onReceiveData listener or context null", new Object[0]);
            return 2;
        }
        if (intent == null) {
            return 2;
        }
        try {
            intExtra = intent.getIntExtra("command", -1);
            intExtra2 = intent.getIntExtra("errorCode", 0);
            stringExtra = intent.getStringExtra(Constants.KEY_USER_ID);
            stringExtra2 = intent.getStringExtra(Constants.KEY_DATA_ID);
            stringExtra3 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
            str = "1";
        } catch (Exception e10) {
            e = e10;
            str = "1";
        }
        try {
            try {
                if (!ALog.isPrintLog(ALog.Level.I)) {
                    try {
                        if (!"accs-impaas".equals(stringExtra3)) {
                            str2 = BaseMonitor.ALARM_POINT_REQ_ERROR;
                            str3 = stringExtra;
                            if (intExtra > 0) {
                                ALog.w(TAG, "onReceiveData command not handled", new Object[0]);
                                return 2;
                            }
                            UTMini.getInstance().commitEvent(66001, "MsgToBuss5", "commandId=" + intExtra, "serviceId=" + stringExtra3 + " dataId=" + stringExtra2, Integer.valueOf(Constants.SDK_VERSION_CODE));
                            str4 = "onReceiveData";
                            k.a("accs", BaseMonitor.COUNT_POINT_TO_BUSS, "3commandId=" + intExtra + "serviceId=" + stringExtra3, 0.0d);
                            if (intExtra == 5) {
                                a(stringExtra3, new b(accsDataListener, stringExtra3, intExtra2, intent));
                                return 2;
                            }
                            if (intExtra == 6) {
                                a(stringExtra3, new c(accsDataListener, stringExtra3, intExtra2, intent));
                                return 2;
                            }
                            try {
                                if (intExtra == 100) {
                                    NetPerformanceMonitor a10 = a(intent);
                                    if (a10 != null) {
                                        long currentTimeMillis = System.currentTimeMillis();
                                        a10.service_recv = currentTimeMillis;
                                        if (a10.start_service == 0) {
                                            a10.start_service = currentTimeMillis;
                                        }
                                    }
                                    if (TextUtils.equals(Constants.SEND_TYPE_RES, intent.getStringExtra(Constants.KEY_SEND_TYPE))) {
                                        a(stringExtra3, new e(a10, stringExtra3, stringExtra2, accsDataListener, intExtra2, intent.getByteArrayExtra("data"), intent));
                                        return 2;
                                    }
                                    a(stringExtra3, new f(a10, stringExtra3, stringExtra2, accsDataListener, intExtra2, intent));
                                    return 2;
                                }
                                if (intExtra != 101) {
                                    if (intExtra != 103) {
                                        if (intExtra != 104) {
                                            ALog.w(TAG, "onReceiveData command not handled", new Object[0]);
                                            return 2;
                                        }
                                        boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_ANTI_BRUSH_RET, false);
                                        ALog.e(TAG, "onReceiveData anti brush result:" + booleanExtra, new Object[0]);
                                        a(stringExtra3, new g(accsDataListener, booleanExtra));
                                        return 2;
                                    }
                                    boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
                                    String stringExtra4 = intent.getStringExtra(Constants.KEY_HOST);
                                    String stringExtra5 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
                                    boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
                                    boolean booleanExtra4 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
                                    if (TextUtils.isEmpty(stringExtra4)) {
                                        return 2;
                                    }
                                    if (booleanExtra2) {
                                        a(stringExtra3, new h(accsDataListener, stringExtra4, booleanExtra3, booleanExtra4));
                                        return 2;
                                    }
                                    a(stringExtra3, new i(accsDataListener, stringExtra4, booleanExtra3, booleanExtra4, intExtra2, stringExtra5));
                                    return 2;
                                }
                                byte[] byteArrayExtra = intent.getByteArrayExtra("data");
                                boolean booleanExtra5 = intent.getBooleanExtra(Constants.KEY_NEED_BUSINESS_ACK, false);
                                if (byteArrayExtra == null) {
                                    ALog.e(TAG, "onReceiveData COMMAND_RECEIVE_DATA msg null", new Object[0]);
                                    k.a("accs", str2, stringExtra3, str, "COMMAND_RECEIVE_DATA msg null");
                                    return 2;
                                }
                                if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(stringExtra3)) {
                                    ALog.e(TAG, "onReceiveData COMMAND_RECEIVE_DATA onData dataId:" + stringExtra2 + " serviceId:" + stringExtra3, new Object[0]);
                                }
                                TaoBaseService.ExtraInfo c10 = c(intent);
                                if (booleanExtra5) {
                                    ALog.i(TAG, "onReceiveData try to send biz ack dataId " + stringExtra2, new Object[0]);
                                    a(context, intent, stringExtra2, c10.oriExtHeader);
                                }
                                try {
                                    intent.getExtras().setClassLoader(NetPerformanceMonitor.class.getClassLoader());
                                    NetPerformanceMonitor netPerformanceMonitor = (NetPerformanceMonitor) intent.getExtras().getSerializable(Constants.KEY_MONIROT);
                                    if (netPerformanceMonitor != null) {
                                        netPerformanceMonitor.onToAccsTime();
                                        if (!(context instanceof AgooService)) {
                                            AppMonitor.getInstance().commitStat(netPerformanceMonitor);
                                        }
                                    }
                                } catch (Exception e11) {
                                    ALog.e(TAG, "get NetPerformanceMonitor Error:", e11, new Object[0]);
                                }
                                k.a("accs", BaseMonitor.COUNT_POINT_TO_BUSS_SUCCESS, "1commandId=101serviceId=" + stringExtra3, 0.0d);
                                a(stringExtra3, new d(stringExtra3, stringExtra2, intExtra, accsDataListener, str3, byteArrayExtra, c10));
                                return 2;
                            } catch (Exception e12) {
                                e = e12;
                                str2 = null;
                                str = "accs-impaas";
                                k.a("accs", str2, "", str, "callback error" + e.toString());
                                ALog.e(TAG, str4, e, new Object[0]);
                                return 2;
                            }
                        }
                    } catch (Exception e13) {
                        e = e13;
                        str2 = BaseMonitor.ALARM_POINT_REQ_ERROR;
                        str4 = "onReceiveData";
                        k.a("accs", str2, "", str, "callback error" + e.toString());
                        ALog.e(TAG, str4, e, new Object[0]);
                        return 2;
                    }
                }
                if (intExtra > 0) {
                }
            } catch (Exception e14) {
                e = e14;
            }
            str4 = TAG;
            str3 = stringExtra;
            ALog.e(str4, "onReceiveData", Constants.KEY_DATA_ID, stringExtra2, Constants.KEY_SERVICE_ID, stringExtra3, "command", Integer.valueOf(intExtra), "className", accsDataListener.getClass().getName());
        } catch (Exception e15) {
            e = e15;
            str4 = "onReceiveData";
            k.a("accs", str2, "", str, "callback error" + e.toString());
            ALog.e(TAG, str4, e, new Object[0]);
            return 2;
        }
        str2 = BaseMonitor.ALARM_POINT_REQ_ERROR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TaoBaseService.ExtraInfo c(Intent intent) {
        TaoBaseService.ExtraInfo extraInfo = new TaoBaseService.ExtraInfo();
        try {
            HashMap hashMap = (HashMap) intent.getSerializableExtra(TaoBaseService.ExtraInfo.EXT_HEADER);
            Map<TaoBaseService.ExtHeaderType, String> a10 = a(hashMap);
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_HOST);
            extraInfo.connType = intent.getIntExtra(Constants.KEY_CONN_TYPE, 0);
            extraInfo.extHeader = a10;
            extraInfo.oriExtHeader = hashMap;
            extraInfo.fromPackage = stringExtra;
            extraInfo.fromHost = stringExtra2;
        } catch (Throwable th) {
            ALog.e(TAG, "getExtraInfo", th, new Object[0]);
        }
        return extraInfo;
    }

    private static void a(String str, Runnable runnable) {
        if ("accs-impaas".equals(str) && t.e()) {
            ThreadPoolExecutorFactory.executeCallback(runnable);
        } else {
            f9317a.post(runnable);
        }
    }

    public static NetPerformanceMonitor a(Intent intent) {
        try {
            intent.getExtras().setClassLoader(NetPerformanceMonitor.class.getClassLoader());
            return (NetPerformanceMonitor) intent.getExtras().getSerializable(Constants.KEY_MONIROT);
        } catch (Exception e10) {
            ALog.e(TAG, "get NetPerformanceMonitor Error:", e10, new Object[0]);
            return null;
        }
    }

    private static Map<TaoBaseService.ExtHeaderType, String> a(Map<Integer, String> map) {
        HashMap hashMap = null;
        if (map == null) {
            return null;
        }
        try {
            HashMap hashMap2 = new HashMap();
            try {
                for (TaoBaseService.ExtHeaderType extHeaderType : TaoBaseService.ExtHeaderType.values()) {
                    String str = map.get(Integer.valueOf(extHeaderType.ordinal()));
                    if (!TextUtils.isEmpty(str)) {
                        hashMap2.put(extHeaderType, str);
                    }
                }
                return hashMap2;
            } catch (Exception e10) {
                e = e10;
                hashMap = hashMap2;
                ALog.e(TAG, "getExtHeader", e, new Object[0]);
                return hashMap;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    private static void a(Context context, Intent intent, String str, Map<Integer, String> map) {
        try {
            ALog.i(TAG, "sendBusinessAck", Constants.KEY_DATA_ID, str);
            if (intent != null) {
                String stringExtra = intent.getStringExtra(Constants.KEY_HOST);
                String stringExtra2 = intent.getStringExtra("source");
                String stringExtra3 = intent.getStringExtra("target");
                String stringExtra4 = intent.getStringExtra(Constants.KEY_APP_KEY);
                String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
                short shortExtra = intent.getShortExtra(Constants.KEY_FLAGS, (short) 0);
                com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, stringExtra4, stringExtra5);
                if (accsInstance != null) {
                    accsInstance.a(stringExtra3, stringExtra2, str, shortExtra, stringExtra, map);
                    k.a("accs", BaseMonitor.COUNT_BUSINESS_ACK_SUCC, "", 0.0d);
                } else {
                    k.a("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, "no acsmgr", 0.0d);
                }
            }
        } catch (Throwable th) {
            ALog.e(TAG, "sendBusinessAck", th, new Object[0]);
            k.a("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, th.toString(), 0.0d);
        }
    }
}
