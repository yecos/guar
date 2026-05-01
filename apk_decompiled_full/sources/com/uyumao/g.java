package com.uyumao;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static HandlerThread f12408a;

    /* renamed from: b, reason: collision with root package name */
    public static Handler f12409b;

    /* renamed from: c, reason: collision with root package name */
    public static HashMap<Integer, a> f12410c;

    public interface a {
        void a(Object obj, int i10);
    }

    public static void a(Context context, int i10, int i11, a aVar, Object obj, long j10) {
        if (context == null || aVar == null) {
            return;
        }
        if (f12410c == null) {
            f12410c = new HashMap<>();
        }
        Integer valueOf = Integer.valueOf(i11 / 100);
        if (!f12410c.containsKey(valueOf)) {
            f12410c.put(valueOf, aVar);
        }
        if (f12408a == null || f12409b == null) {
            synchronized (g.class) {
                try {
                    if (f12408a == null) {
                        HandlerThread handlerThread = new HandlerThread("yumao_ccg");
                        f12408a = handlerThread;
                        handlerThread.start();
                        if (f12409b == null) {
                            f12409b = new f(f12408a.getLooper());
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        try {
            Handler handler = f12409b;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = i10;
                obtainMessage.arg1 = i11;
                obtainMessage.obj = obj;
                f12409b.sendMessageDelayed(obtainMessage, j10);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void a(Context context, int i10, a aVar, Object obj) {
        a(context, 256, i10, aVar, obj, 0L);
    }
}
