package com.umeng.ccg;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static Handler f10674a = null;

    /* renamed from: b, reason: collision with root package name */
    public static final int f10675b = 101;

    /* renamed from: c, reason: collision with root package name */
    public static final int f10676c = 102;

    /* renamed from: d, reason: collision with root package name */
    public static final int f10677d = 103;

    /* renamed from: e, reason: collision with root package name */
    public static final int f10678e = 104;

    /* renamed from: f, reason: collision with root package name */
    public static final int f10679f = 105;

    /* renamed from: g, reason: collision with root package name */
    public static final int f10680g = 106;

    /* renamed from: h, reason: collision with root package name */
    public static final int f10681h = 107;

    /* renamed from: i, reason: collision with root package name */
    public static final int f10682i = 0;

    /* renamed from: j, reason: collision with root package name */
    public static final int f10683j = 1;

    /* renamed from: k, reason: collision with root package name */
    public static final int f10684k = 2;

    /* renamed from: l, reason: collision with root package name */
    public static final int f10685l = 201;

    /* renamed from: m, reason: collision with root package name */
    public static final int f10686m = 202;

    /* renamed from: n, reason: collision with root package name */
    public static final int f10687n = 203;

    /* renamed from: o, reason: collision with root package name */
    public static final int f10688o = 301;

    /* renamed from: p, reason: collision with root package name */
    public static final int f10689p = 302;

    /* renamed from: q, reason: collision with root package name */
    public static final int f10690q = 303;

    /* renamed from: r, reason: collision with root package name */
    public static final int f10691r = 304;

    /* renamed from: s, reason: collision with root package name */
    public static final int f10692s = 305;

    /* renamed from: t, reason: collision with root package name */
    private static HandlerThread f10693t = null;

    /* renamed from: u, reason: collision with root package name */
    private static HashMap<Integer, a> f10694u = null;

    /* renamed from: v, reason: collision with root package name */
    private static final int f10695v = 256;

    public interface a {
        void a(Object obj, int i10);
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Message message) {
        int i10 = message.arg1;
        Object obj = message.obj;
        Integer valueOf = Integer.valueOf(i10 / 100);
        HashMap<Integer, a> hashMap = f10694u;
        if (hashMap == null) {
            return;
        }
        a aVar = hashMap.containsKey(valueOf) ? f10694u.get(valueOf) : null;
        if (aVar != null) {
            aVar.a(obj, i10);
        }
    }

    public static void a(Context context, int i10, int i11, a aVar, Object obj, long j10) {
        if (context == null || aVar == null) {
            return;
        }
        if (f10694u == null) {
            f10694u = new HashMap<>();
        }
        Integer valueOf = Integer.valueOf(i11 / 100);
        if (!f10694u.containsKey(valueOf)) {
            f10694u.put(valueOf, aVar);
        }
        if (f10693t == null || f10674a == null) {
            a();
        }
        try {
            Handler handler = f10674a;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = i10;
                obtainMessage.arg1 = i11;
                obtainMessage.obj = obj;
                f10674a.sendMessageDelayed(obtainMessage, j10);
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
        synchronized (c.class) {
            try {
                if (f10693t == null) {
                    HandlerThread handlerThread = new HandlerThread("ccg_dispatch");
                    f10693t = handlerThread;
                    handlerThread.start();
                    if (f10674a == null) {
                        f10674a = new Handler(f10693t.getLooper()) { // from class: com.umeng.ccg.c.1
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                if (message.what != 256) {
                                    return;
                                }
                                c.b(message);
                            }
                        };
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
