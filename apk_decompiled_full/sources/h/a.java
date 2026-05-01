package h;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class a extends d {

    /* renamed from: c, reason: collision with root package name */
    public static volatile a f14076c;

    /* renamed from: d, reason: collision with root package name */
    public static final Executor f14077d = new ExecutorC0223a();

    /* renamed from: e, reason: collision with root package name */
    public static final Executor f14078e = new b();

    /* renamed from: a, reason: collision with root package name */
    public d f14079a;

    /* renamed from: b, reason: collision with root package name */
    public d f14080b;

    /* renamed from: h.a$a, reason: collision with other inner class name */
    public static class ExecutorC0223a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.e().c(runnable);
        }
    }

    public static class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.e().a(runnable);
        }
    }

    public a() {
        c cVar = new c();
        this.f14080b = cVar;
        this.f14079a = cVar;
    }

    public static Executor d() {
        return f14078e;
    }

    public static a e() {
        if (f14076c != null) {
            return f14076c;
        }
        synchronized (a.class) {
            if (f14076c == null) {
                f14076c = new a();
            }
        }
        return f14076c;
    }

    @Override // h.d
    public void a(Runnable runnable) {
        this.f14079a.a(runnable);
    }

    @Override // h.d
    public boolean b() {
        return this.f14079a.b();
    }

    @Override // h.d
    public void c(Runnable runnable) {
        this.f14079a.c(runnable);
    }
}
