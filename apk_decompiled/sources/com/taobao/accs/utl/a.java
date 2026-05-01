package com.taobao.accs.utl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class a {
    public static final String TAG = "a";

    /* renamed from: a, reason: collision with root package name */
    private static Handler f9317a = new Handler(Looper.getMainLooper());

    /* JADX WARN: Removed duplicated region for block: B:16:0x008b A[Catch: Exception -> 0x02c3, all -> 0x02c5, TRY_ENTER, TRY_LEAVE, TryCatch #3 {, blocks: (B:7:0x0020, B:99:0x0044, B:16:0x008b, B:18:0x00e2, B:32:0x00fd, B:35:0x0107, B:37:0x0131, B:40:0x0159, B:42:0x0163, B:45:0x0173, B:47:0x0180, B:49:0x0188, B:51:0x01af, B:53:0x01b5, B:55:0x01d3, B:57:0x01ee, B:59:0x01f5, B:61:0x0208, B:64:0x01fe, B:65:0x018e, B:66:0x0232, B:68:0x0242, B:70:0x0247, B:72:0x0251, B:74:0x025b, B:76:0x0263, B:77:0x026a, B:79:0x0278, B:81:0x028e, B:88:0x02a5, B:90:0x02ae, B:93:0x02b7, B:12:0x0055), top: B:6:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02b7 A[Catch: Exception -> 0x02c1, all -> 0x02c5, TRY_LEAVE, TryCatch #3 {, blocks: (B:7:0x0020, B:99:0x0044, B:16:0x008b, B:18:0x00e2, B:32:0x00fd, B:35:0x0107, B:37:0x0131, B:40:0x0159, B:42:0x0163, B:45:0x0173, B:47:0x0180, B:49:0x0188, B:51:0x01af, B:53:0x01b5, B:55:0x01d3, B:57:0x01ee, B:59:0x01f5, B:61:0x0208, B:64:0x01fe, B:65:0x018e, B:66:0x0232, B:68:0x0242, B:70:0x0247, B:72:0x0251, B:74:0x025b, B:76:0x0263, B:77:0x026a, B:79:0x0278, B:81:0x028e, B:88:0x02a5, B:90:0x02ae, B:93:0x02b7, B:12:0x0055), top: B:6:0x0020 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(android.content.Context r28, android.content.Intent r29, com.taobao.accs.base.AccsDataListener r30) {
        /*
            Method dump skipped, instructions count: 769
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.a.a(android.content.Context, android.content.Intent, com.taobao.accs.base.AccsDataListener):int");
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
