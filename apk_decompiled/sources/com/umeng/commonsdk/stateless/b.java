package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.content.IntentFilter;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int f10987a = 273;

    /* renamed from: b, reason: collision with root package name */
    private static Context f10988b = null;

    /* renamed from: c, reason: collision with root package name */
    private static HandlerThread f10989c = null;

    /* renamed from: d, reason: collision with root package name */
    private static Handler f10990d = null;

    /* renamed from: f, reason: collision with root package name */
    private static final int f10992f = 274;

    /* renamed from: g, reason: collision with root package name */
    private static final int f10993g = 275;

    /* renamed from: h, reason: collision with root package name */
    private static final int f10994h = 512;

    /* renamed from: i, reason: collision with root package name */
    private static a f10995i = null;

    /* renamed from: j, reason: collision with root package name */
    private static IntentFilter f10996j = null;

    /* renamed from: k, reason: collision with root package name */
    private static volatile boolean f10997k = false;

    /* renamed from: e, reason: collision with root package name */
    private static Object f10991e = new Object();

    /* renamed from: l, reason: collision with root package name */
    private static LinkedList<String> f10998l = new LinkedList<>();

    public static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i10, String str) {
            if ((i10 & 8) != 8) {
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            b.a(b.f10992f);
        }
    }

    public b(Context context) {
        synchronized (f10991e) {
            if (context != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    f10988b = applicationContext;
                    if (applicationContext != null && f10989c == null) {
                        HandlerThread handlerThread = new HandlerThread("SL-NetWorkSender");
                        f10989c = handlerThread;
                        handlerThread.start();
                        if (f10995i == null) {
                            String str = f10988b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f10982f;
                            File file = new File(str);
                            if (!file.exists()) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓目录不存在，创建之。");
                                file.mkdir();
                            }
                            a aVar = new a(str);
                            f10995i = aVar;
                            aVar.startWatching();
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓File Monitor启动.");
                        }
                        if (f10990d == null) {
                            f10990d = new Handler(f10989c.getLooper()) { // from class: com.umeng.commonsdk.stateless.b.1
                                @Override // android.os.Handler
                                public void handleMessage(Message message) {
                                    int i10 = message.what;
                                    if (i10 != 512) {
                                        switch (i10) {
                                            case 273:
                                                b.l();
                                                return;
                                            case b.f10992f /* 274 */:
                                                b.n();
                                                return;
                                            case b.f10993g /* 275 */:
                                                b.p();
                                                break;
                                            default:
                                                return;
                                        }
                                    }
                                    b.q();
                                }
                            };
                        }
                    }
                } finally {
                }
            }
        }
    }

    public static void a(boolean z10) {
        f10997k = z10;
        if (!z10) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
            b(f10992f);
        }
    }

    public static void b(int i10) {
        Handler handler;
        try {
            if (!f10997k || (handler = f10990d) == null || handler.hasMessages(i10)) {
                return;
            }
            Message obtainMessage = f10990d.obtainMessage();
            obtainMessage.what = i10;
            f10990d.sendMessage(obtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f10988b, th);
        }
    }

    public static void c() {
        b(f10993g);
    }

    public static void d() {
        b(512);
    }

    private static void i() {
        File[] c10 = d.c(f10988b);
        if (c10 != null) {
            if (f10998l.size() > 0) {
                f10998l.clear();
            }
            for (File file : c10) {
                f10998l.add(file.getAbsolutePath());
            }
        }
    }

    private static String j() {
        String str = null;
        try {
            String peek = f10998l.peek();
            if (peek == null) {
                return peek;
            }
            try {
                f10998l.removeFirst();
                return peek;
            } catch (Throwable unused) {
                str = peek;
                return str;
            }
        } catch (Throwable unused2) {
        }
    }

    private static void k() {
        String pollFirst;
        byte[] bArr;
        if (f10998l.size() <= 0) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            pollFirst = f10998l.pollFirst();
            if (!TextUtils.isEmpty(pollFirst)) {
                File file = new File(pollFirst);
                if (file.exists()) {
                    c cVar = new c(f10988b);
                    try {
                        bArr = d.a(pollFirst);
                    } catch (Exception unused) {
                        bArr = null;
                    }
                    String name = file.getName();
                    String substring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : "u";
                    String c10 = d.c(d.d(name));
                    if (SdkVersion.SDK_TYPE == 0) {
                        cVar.a();
                    } else {
                        com.umeng.commonsdk.stateless.a.f10983g = com.umeng.commonsdk.stateless.a.f10986j;
                        cVar.b();
                    }
                    if (cVar.a(bArr, c10, com.umeng.commonsdk.vchannel.a.f11281c.equalsIgnoreCase(c10) ? com.umeng.commonsdk.vchannel.a.f11279a : com.umeng.commonsdk.stateless.a.f10984h, substring) && !file.delete()) {
                        file.delete();
                    }
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                }
            }
        } while (pollFirst != null);
        f10998l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        File a10;
        byte[] bArr;
        if (!f10997k || f10988b == null) {
            return;
        }
        do {
            try {
                a10 = d.a(f10988b);
                if (a10 != null && a10.getParentFile() != null && !TextUtils.isEmpty(a10.getParentFile().getName())) {
                    c cVar = new c(f10988b);
                    String str = new String(Base64.decode(a10.getParentFile().getName(), 0));
                    if (!com.umeng.commonsdk.internal.a.f10883a.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.f10884b.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.H.equalsIgnoreCase(str)) {
                        ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                        try {
                            bArr = d.a(a10.getAbsolutePath());
                        } catch (Exception unused) {
                            bArr = null;
                        }
                        String str2 = UMServerURL.PATH_SHARE.equalsIgnoreCase(str) ? "s" : "u";
                        if (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) {
                            str2 = bt.aD;
                        }
                        if (SdkVersion.SDK_TYPE == 0) {
                            cVar.a();
                        } else {
                            com.umeng.commonsdk.stateless.a.f10983g = com.umeng.commonsdk.stateless.a.f10986j;
                            cVar.b();
                        }
                        if (!cVar.a(bArr, str, com.umeng.commonsdk.vchannel.a.f11281c.equalsIgnoreCase(str) ? com.umeng.commonsdk.vchannel.a.f11279a : com.umeng.commonsdk.stateless.a.f10984h, str2)) {
                            ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        ULog.i("walle", "[stateless] Send envelope file success, delete it.");
                        File file = new File(a10.getAbsolutePath());
                        if (!file.delete()) {
                            ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                            file.delete();
                        }
                    }
                    new File(a10.getAbsolutePath()).delete();
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f10988b, th);
            }
        } while (a10 != null);
        m();
    }

    private static void m() {
        try {
            File file = new File(f10988b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f10981e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                d.a(file);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        if (!f10997k || f10988b == null) {
            return;
        }
        i();
        k();
        c();
    }

    private static void o() {
        try {
            File file = new File(f10988b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f10981e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                b(273);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p() {
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
    }

    public static boolean a() {
        synchronized (f10991e) {
            return f10995i != null;
        }
    }

    public static void b() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        b(f10992f);
    }

    public static void a(int i10) {
        Handler handler;
        if (!f10997k || (handler = f10990d) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i10;
        f10990d.sendMessage(obtainMessage);
    }
}
