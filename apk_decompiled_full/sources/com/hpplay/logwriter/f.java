package com.hpplay.logwriter;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final int f7395a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f7396b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f7397c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f7398d = 100;

    /* renamed from: e, reason: collision with root package name */
    public static final long f7399e = 102400;

    /* renamed from: f, reason: collision with root package name */
    public static final long f7400f = 204800;

    /* renamed from: g, reason: collision with root package name */
    private static final String f7401g = "hpplay-java:LW";

    /* renamed from: h, reason: collision with root package name */
    private static final int f7402h = 1;

    /* renamed from: i, reason: collision with root package name */
    private static final int f7403i = 11;

    /* renamed from: j, reason: collision with root package name */
    private static volatile f f7404j;

    /* renamed from: k, reason: collision with root package name */
    private String f7405k;

    /* renamed from: o, reason: collision with root package name */
    private ILogcatCollect f7409o;

    /* renamed from: r, reason: collision with root package name */
    private HandlerThread f7412r;

    /* renamed from: s, reason: collision with root package name */
    private Handler f7413s;

    /* renamed from: t, reason: collision with root package name */
    private b f7414t;

    /* renamed from: u, reason: collision with root package name */
    private Context f7415u;

    /* renamed from: l, reason: collision with root package name */
    private boolean f7406l = false;

    /* renamed from: m, reason: collision with root package name */
    private volatile ConcurrentLinkedQueue<String> f7407m = new ConcurrentLinkedQueue<>();

    /* renamed from: n, reason: collision with root package name */
    private volatile long f7408n = 0;

    /* renamed from: p, reason: collision with root package name */
    private volatile ConcurrentLinkedQueue<String> f7410p = new ConcurrentLinkedQueue<>();

    /* renamed from: q, reason: collision with root package name */
    private volatile long f7411q = 0;

    /* renamed from: v, reason: collision with root package name */
    private int f7416v = 100;

    private f() {
        HandlerThread handlerThread = new HandlerThread("log write thread");
        this.f7412r = handlerThread;
        handlerThread.start();
        this.f7413s = new Handler(this.f7412r.getLooper()) { // from class: com.hpplay.logwriter.f.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                try {
                    int i10 = message.what;
                    if (i10 == 1) {
                        f.this.d(message.obj.toString());
                    } else if (i10 == 11) {
                        f.this.e(message.obj.toString());
                    }
                } catch (Exception e10) {
                    g.a(f.f7401g, e10);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        try {
            long length = str.getBytes().length;
            if (this.f7408n + length >= f7399e) {
                f();
                this.f7408n = 0L;
            }
            this.f7407m.add(str);
            this.f7408n += length;
        } catch (Exception e10) {
            g.a(f7401g, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        try {
            long length = str.getBytes().length;
            if (this.f7411q + length >= f7399e) {
                g();
                this.f7411q = 0L;
            }
            this.f7410p.add(str);
            this.f7411q += length;
        } catch (Exception e10) {
            g.a(f7401g, e10);
        }
    }

    private void f() {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.f7407m.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\n");
                try {
                    it.remove();
                } catch (Exception e10) {
                    g.a(f7401g, e10);
                }
                if (sb.length() > f7400f) {
                    break;
                }
            }
            if (this.f7414t == null) {
                b bVar = new b();
                this.f7414t = bVar;
                bVar.a(this.f7405k);
            }
            byte[] bytes = sb.toString().getBytes();
            if (bytes.length < f7400f) {
                this.f7414t.a(bytes);
            }
        } catch (Exception e11) {
            g.a(f7401g, e11);
        }
    }

    private void g() {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.f7410p.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\n");
                try {
                    it.remove();
                } catch (Exception e10) {
                    g.a(f7401g, e10);
                }
                if (sb.length() > f7400f) {
                    break;
                }
            }
            if (this.f7414t == null) {
                b bVar = new b();
                this.f7414t = bVar;
                bVar.a(this.f7405k);
            }
            byte[] bytes = sb.toString().getBytes();
            if (bytes.length < f7400f) {
                this.f7414t.b(bytes);
            }
        } catch (Exception e11) {
            g.a(f7401g, e11);
        }
    }

    public void c(String str) {
        f();
        g();
        e.b(this.f7405k, str);
    }

    public static f a() {
        if (f7404j == null) {
            synchronized (f.class) {
                if (f7404j == null) {
                    f7404j = new f();
                }
            }
        }
        return f7404j;
    }

    public void b() {
        int i10 = this.f7416v;
        if (i10 == 1) {
            f();
            return;
        }
        if (i10 == 2) {
            g();
        } else {
            if (i10 != 100) {
                return;
            }
            f();
            g();
        }
    }

    public void c() {
        this.f7406l = false;
        ILogcatCollect iLogcatCollect = this.f7409o;
        if (iLogcatCollect != null) {
            iLogcatCollect.stop();
        }
        a(true);
        b bVar = this.f7414t;
        if (bVar != null) {
            bVar.a();
            this.f7414t = null;
        }
    }

    public void b(String str) {
        try {
            Handler handler = this.f7413s;
            handler.sendMessage(handler.obtainMessage(11, str));
        } catch (Exception e10) {
            g.a(f7401g, e10);
        }
    }

    public void a(ILogcatCollect iLogcatCollect) {
        this.f7409o = iLogcatCollect;
    }

    public String d() {
        return this.f7405k;
    }

    public boolean e() {
        return this.f7406l;
    }

    public void a(Context context, String str) {
        a(context, str, 100);
    }

    public void a(Context context, String str, int i10) {
        ILogcatCollect iLogcatCollect;
        if (this.f7406l || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f7415u = context;
        this.f7405k = str;
        a(false);
        this.f7406l = true;
        if ((i10 == 2 || i10 == 100) && (iLogcatCollect = this.f7409o) != null) {
            iLogcatCollect.start();
        }
    }

    public synchronized void a(String str) {
        try {
            Handler handler = this.f7413s;
            handler.sendMessage(handler.obtainMessage(1, str));
        } catch (Exception e10) {
            g.a(f7401g, e10);
        }
    }

    private void a(boolean z10) {
        if (z10) {
            try {
                f();
                g();
            } catch (Exception e10) {
                g.a(f7401g, e10);
                return;
            }
        }
        this.f7407m.clear();
        this.f7408n = 0L;
        this.f7410p.clear();
        this.f7411q = 0L;
    }
}
