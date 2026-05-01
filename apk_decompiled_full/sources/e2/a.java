package e2;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import s2.d;
import t9.g;
import t9.i;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final C0213a f12853b = new C0213a(null);

    /* renamed from: c, reason: collision with root package name */
    public static a f12854c;

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f12855a = d.c();

    /* renamed from: e2.a$a, reason: collision with other inner class name */
    public static final class C0213a {
        public C0213a() {
        }

        public /* synthetic */ C0213a(g gVar) {
            this();
        }

        public final a a() {
            a b10 = b();
            i.d(b10);
            return b10;
        }

        public final a b() {
            if (a.f12854c == null) {
                a.f12854c = new a();
            }
            return a.f12854c;
        }
    }

    public final void c(f2.d dVar) {
        i.g(dVar, "request");
        this.f12855a.execute(new d.e("Big Bee Net", (Runnable) dVar, false));
    }
}
