package com.umeng.commonsdk.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.umeng.analytics.pro.by;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.android.agoo.common.AgooConstants;

/* loaded from: classes3.dex */
public class a implements UMImprintChangeCallback {

    /* renamed from: a, reason: collision with root package name */
    private static HandlerThread f10857a = null;

    /* renamed from: b, reason: collision with root package name */
    private static Handler f10858b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Handler f10859c = null;

    /* renamed from: d, reason: collision with root package name */
    private static final int f10860d = 200;

    /* renamed from: e, reason: collision with root package name */
    private static final int f10861e = 273;

    /* renamed from: f, reason: collision with root package name */
    private static final int f10862f = 274;

    /* renamed from: g, reason: collision with root package name */
    private static final int f10863g = 512;

    /* renamed from: h, reason: collision with root package name */
    private static final int f10864h = 769;

    /* renamed from: i, reason: collision with root package name */
    private static FileObserverC0177a f10865i = null;

    /* renamed from: j, reason: collision with root package name */
    private static ConnectivityManager f10866j = null;

    /* renamed from: k, reason: collision with root package name */
    private static IntentFilter f10867k = null;

    /* renamed from: l, reason: collision with root package name */
    private static volatile boolean f10868l = false;

    /* renamed from: m, reason: collision with root package name */
    private static ArrayList<UMSenderStateNotify> f10869m = null;

    /* renamed from: p, reason: collision with root package name */
    private static final String f10872p = "report_policy";

    /* renamed from: q, reason: collision with root package name */
    private static final String f10873q = "report_interval";

    /* renamed from: s, reason: collision with root package name */
    private static final int f10875s = 15;

    /* renamed from: t, reason: collision with root package name */
    private static final int f10876t = 3;

    /* renamed from: u, reason: collision with root package name */
    private static final int f10877u = 90;

    /* renamed from: x, reason: collision with root package name */
    private static BroadcastReceiver f10880x;

    /* renamed from: n, reason: collision with root package name */
    private static Object f10870n = new Object();

    /* renamed from: o, reason: collision with root package name */
    private static ReentrantLock f10871o = new ReentrantLock();

    /* renamed from: r, reason: collision with root package name */
    private static boolean f10874r = false;

    /* renamed from: v, reason: collision with root package name */
    private static int f10878v = 15;

    /* renamed from: w, reason: collision with root package name */
    private static Object f10879w = new Object();

    /* renamed from: com.umeng.commonsdk.framework.a$a, reason: collision with other inner class name */
    public static class FileObserverC0177a extends FileObserver {
        public FileObserverC0177a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i10, String str) {
            if ((i10 & 8) != 8) {
                return;
            }
            ULog.d("--->>> envelope file created >>> " + str);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            a.c(273);
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f10866j = (ConnectivityManager) appContext.getSystemService("connectivity");
        }
        f10880x = new BroadcastReceiver() { // from class: com.umeng.commonsdk.framework.a.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, com.umeng.commonsdk.internal.b.a(context).a(), null);
                }
            }
        };
    }

    public a(Context context, Handler handler) {
        if (f10866j == null) {
            Context appContext = UMGlobalContext.getAppContext();
            if (f10866j != null) {
                f10866j = (ConnectivityManager) appContext.getSystemService("connectivity");
            }
        }
        f10859c = handler;
        try {
            if (f10857a == null) {
                HandlerThread handlerThread = new HandlerThread("NetWorkSender");
                f10857a = handlerThread;
                handlerThread.start();
                if (f10865i == null) {
                    FileObserverC0177a fileObserverC0177a = new FileObserverC0177a(UMFrUtils.getEnvelopeDirPath(context));
                    f10865i = fileObserverC0177a;
                    fileObserverC0177a.startWatching();
                    ULog.d("--->>> FileMonitor has already started!");
                }
                j();
                if (f10858b == null) {
                    f10858b = new Handler(f10857a.getLooper()) { // from class: com.umeng.commonsdk.framework.a.3
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            int i10 = message.what;
                            if (i10 == 273) {
                                ULog.d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                                try {
                                    a.f10871o.tryLock(1L, TimeUnit.SECONDS);
                                    try {
                                        a.n();
                                    } catch (Throwable unused) {
                                    }
                                    a.f10871o.unlock();
                                    return;
                                } catch (Throwable unused2) {
                                    return;
                                }
                            }
                            if (i10 == a.f10862f) {
                                a.l();
                            } else {
                                if (i10 != 512) {
                                    return;
                                }
                                a.m();
                            }
                        }
                    };
                }
                ImprintHandler.getImprintService(context).registImprintCallback(f10872p, this);
                ImprintHandler.getImprintService(context).registImprintCallback(f10873q, this);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static int b() {
        int i10;
        synchronized (f10879w) {
            i10 = f10878v;
        }
        return i10;
    }

    public static void c() {
    }

    public static void d() {
        if (f10871o.tryLock()) {
            try {
                b(273);
            } finally {
                f10871o.unlock();
            }
        }
    }

    public static void e() {
        a(f10862f, 3000);
    }

    private void j() {
        synchronized (f10879w) {
            if (AgooConstants.ACK_BODY_NULL.equals(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f10872p, ""))) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                f10874r = true;
                f10878v = 15;
                int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f10873q, AgooConstants.ACK_PACK_ERROR)).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3 && intValue <= 90) {
                    f10878v = intValue * 1000;
                }
                f10878v = 15;
            } else {
                f10874r = false;
            }
        }
    }

    private static void k() {
        if (f10857a != null) {
            f10857a = null;
        }
        if (f10858b != null) {
            f10858b = null;
        }
        if (f10859c != null) {
            f10859c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        int size;
        synchronized (f10870n) {
            ArrayList<UMSenderStateNotify> arrayList = f10869m;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                for (int i10 = 0; i10 < size; i10++) {
                    f10869m.get(i10).onSenderIdle();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        ULog.d("--->>> handleProcessNext: Enter...");
        if (f10868l) {
            Context appContext = UMModuleRegister.getAppContext();
            try {
                if (UMFrUtils.envelopeFileNumber(appContext) > 0) {
                    ULog.d("--->>> The envelope file exists.");
                    if (UMFrUtils.envelopeFileNumber(appContext) > 200) {
                        ULog.d("--->>> Number of envelope files is greater than 200, remove old files first.");
                        UMFrUtils.removeRedundantEnvelopeFiles(appContext, 200);
                    }
                    File envelopeFile = UMFrUtils.getEnvelopeFile(appContext);
                    if (envelopeFile != null) {
                        String path = envelopeFile.getPath();
                        ULog.d("--->>> Ready to send envelope file [" + path + "].");
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send envelope file [ " + path + "].");
                        if (!new com.umeng.commonsdk.statistics.c(appContext).a(envelopeFile)) {
                            ULog.d("--->>> Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        ULog.d("--->>> Send envelope file success, delete it.");
                        if (!UMFrUtils.removeEnvelopeFile(envelopeFile)) {
                            ULog.d("--->>> Failed to delete already processed file. We try again after delete failed.");
                            UMFrUtils.removeEnvelopeFile(envelopeFile);
                        }
                        c(273);
                        return;
                    }
                }
                e();
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
            }
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        synchronized (f10879w) {
            if (f10872p.equals(str)) {
                if (AgooConstants.ACK_BODY_NULL.equals(str2)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                    f10874r = true;
                } else {
                    f10874r = false;
                }
            }
            if (f10873q.equals(str)) {
                int intValue = Integer.valueOf(str2).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3 && intValue <= 90) {
                    f10878v = intValue * 1000;
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + f10878v);
                }
                f10878v = by.f10132b;
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + f10878v);
            }
        }
    }

    public static void a(Context context) {
        if (f10866j != null || context == null) {
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        f10866j = connectivityManager;
        if (connectivityManager != null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> createCMIfNeeded:注册网络状态监听器。");
            b(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int i10) {
        Handler handler;
        if (!f10868l || (handler = f10858b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i10;
        f10858b.sendMessage(obtainMessage);
    }

    public static void b(Context context) {
        NetworkRequest.Builder addTransportType;
        NetworkRequest.Builder addTransportType2;
        NetworkRequest build;
        if (context == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> registerNetReceiver: context is null, registerNetReceiver failed.");
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            if (DeviceConfig.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                addTransportType = new NetworkRequest.Builder().addTransportType(0);
                addTransportType2 = addTransportType.addTransportType(1);
                build = addTransportType2.build();
                if (f10866j != null) {
                    final Context applicationContext = context.getApplicationContext();
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器:registerNetworkCallback");
                    f10866j.registerNetworkCallback(build, new ConnectivityManager.NetworkCallback() { // from class: com.umeng.commonsdk.framework.a.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network) {
                            Context context2 = applicationContext;
                            UMWorkDispatch.sendEvent(context2, com.umeng.commonsdk.internal.a.E, com.umeng.commonsdk.internal.b.a(context2).a(), null);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                            super.onCapabilitiesChanged(network, networkCapabilities);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onLost(Network network) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onLost");
                            Context context2 = applicationContext;
                            UMWorkDispatch.sendEvent(context2, com.umeng.commonsdk.internal.a.E, com.umeng.commonsdk.internal.b.a(context2).a(), null, 2000L);
                        }
                    });
                    return;
                }
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> ACCESS_NETWORK_STATE permission access denied.");
            return;
        }
        if (DeviceConfig.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            if (f10866j == null || f10867k != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            f10867k = intentFilter;
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (f10880x != null) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器:registerReceiver");
                context.registerReceiver(f10880x, f10867k);
                return;
            }
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> ACCESS_NETWORK_STATE permission access denied.");
    }

    public static void a(UMSenderStateNotify uMSenderStateNotify) {
        synchronized (f10870n) {
            try {
                if (f10869m == null) {
                    f10869m = new ArrayList<>();
                }
                if (uMSenderStateNotify != null) {
                    for (int i10 = 0; i10 < f10869m.size(); i10++) {
                        if (uMSenderStateNotify == f10869m.get(i10)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> addConnStateObserver: input item has exist.");
                            return;
                        }
                    }
                    f10869m.add(uMSenderStateNotify);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
        }
    }

    public static boolean a() {
        boolean z10;
        synchronized (f10879w) {
            z10 = f10874r;
        }
        return z10;
    }

    public static void a(boolean z10) {
        int size;
        f10868l = z10;
        if (z10) {
            synchronized (f10870n) {
                ArrayList<UMSenderStateNotify> arrayList = f10869m;
                if (arrayList != null && (size = arrayList.size()) > 0) {
                    for (int i10 = 0; i10 < size; i10++) {
                        f10869m.get(i10).onConnectionAvailable();
                    }
                }
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "网络状态通知：尝试发送 MSG_PROCESS_NEXT");
            d();
            return;
        }
        ULog.i("--->>> network disconnected.");
        f10868l = false;
    }

    private static void b(int i10) {
        Handler handler;
        if (!f10868l || (handler = f10858b) == null || handler.hasMessages(i10)) {
            return;
        }
        Message obtainMessage = f10858b.obtainMessage();
        obtainMessage.what = i10;
        f10858b.sendMessage(obtainMessage);
    }

    private static void a(int i10, long j10) {
        Handler handler;
        if (!f10868l || (handler = f10858b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i10;
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> sendMsgDelayed: " + j10);
        f10858b.sendMessageDelayed(obtainMessage, j10);
    }

    private static void a(int i10, int i11) {
        Handler handler;
        if (!f10868l || (handler = f10858b) == null) {
            return;
        }
        handler.removeMessages(i10);
        Message obtainMessage = f10858b.obtainMessage();
        obtainMessage.what = i10;
        f10858b.sendMessageDelayed(obtainMessage, i11);
    }
}
