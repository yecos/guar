package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class az {

    /* renamed from: a, reason: collision with root package name */
    public static Handler f9943a = null;

    /* renamed from: b, reason: collision with root package name */
    public static final int f9944b = 101;

    /* renamed from: c, reason: collision with root package name */
    private static HandlerThread f9945c = null;

    /* renamed from: d, reason: collision with root package name */
    private static HashMap<Integer, a> f9946d = null;

    /* renamed from: e, reason: collision with root package name */
    private static final int f9947e = 256;

    public interface a {
        void a(Object obj, int i10);
    }

    private az() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Message message) {
        int i10 = message.arg1;
        Object obj = message.obj;
        Integer valueOf = Integer.valueOf(i10 / 100);
        HashMap<Integer, a> hashMap = f9946d;
        if (hashMap == null) {
            return;
        }
        a aVar = hashMap.containsKey(valueOf) ? f9946d.get(valueOf) : null;
        if (aVar != null) {
            aVar.a(obj, i10);
        }
    }

    public static void a(Context context, int i10, int i11, a aVar, Object obj, long j10) {
        if (context == null || aVar == null) {
            return;
        }
        if (f9946d == null) {
            f9946d = new HashMap<>();
        }
        Integer valueOf = Integer.valueOf(i11 / 100);
        if (!f9946d.containsKey(valueOf)) {
            f9946d.put(valueOf, aVar);
        }
        if (f9945c == null || f9943a == null) {
            a();
        }
        try {
            Handler handler = f9943a;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = i10;
                obtainMessage.arg1 = i11;
                obtainMessage.obj = obj;
                f9943a.sendMessageDelayed(obtainMessage, j10);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i10, a aVar, Object obj) {
        a(context, 256, i10, aVar, obj, 0L);
    }

    public static void a(Context context, int i10, a aVar, Object obj, long j10) {
        a(context, 256, i10, aVar, obj, j10);
    }

    private static synchronized void a() {
        synchronized (az.class) {
            try {
                if (f9945c == null) {
                    HandlerThread handlerThread = new HandlerThread("ck_dispatch");
                    f9945c = handlerThread;
                    handlerThread.start();
                    if (f9943a == null) {
                        f9943a = new Handler(f9945c.getLooper()) { // from class: com.umeng.analytics.pro.az.1
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                if (message.what != 256) {
                                    return;
                                }
                                az.b(message);
                            }
                        };
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
