package n0;

import android.content.Context;
import java.lang.ref.WeakReference;
import n0.l1;

/* loaded from: classes.dex */
public abstract class u1 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f17112a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f17113b;

    /* renamed from: c, reason: collision with root package name */
    public c f17114c;

    public static class a extends u1 {

        /* renamed from: d, reason: collision with root package name */
        public final Object f17115d;

        /* renamed from: e, reason: collision with root package name */
        public final Object f17116e;

        /* renamed from: f, reason: collision with root package name */
        public final Object f17117f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f17118g;

        /* renamed from: n0.u1$a$a, reason: collision with other inner class name */
        public static final class C0293a implements l1.e {

            /* renamed from: a, reason: collision with root package name */
            public final WeakReference f17119a;

            public C0293a(a aVar) {
                this.f17119a = new WeakReference(aVar);
            }

            @Override // n0.l1.e
            public void a(Object obj, int i10) {
                c cVar;
                a aVar = (a) this.f17119a.get();
                if (aVar == null || (cVar = aVar.f17114c) == null) {
                    return;
                }
                cVar.b(i10);
            }

            @Override // n0.l1.e
            public void d(Object obj, int i10) {
                c cVar;
                a aVar = (a) this.f17119a.get();
                if (aVar == null || (cVar = aVar.f17114c) == null) {
                    return;
                }
                cVar.a(i10);
            }
        }

        public a(Context context, Object obj) {
            super(context, obj);
            Object e10 = l1.e(context);
            this.f17115d = e10;
            Object b10 = l1.b(e10, "", false);
            this.f17116e = b10;
            this.f17117f = l1.c(e10, b10);
        }

        @Override // n0.u1
        public void c(b bVar) {
            l1.d.e(this.f17117f, bVar.f17120a);
            l1.d.h(this.f17117f, bVar.f17121b);
            l1.d.g(this.f17117f, bVar.f17122c);
            l1.d.b(this.f17117f, bVar.f17123d);
            l1.d.c(this.f17117f, bVar.f17124e);
            if (this.f17118g) {
                return;
            }
            this.f17118g = true;
            l1.d.f(this.f17117f, l1.d(new C0293a(this)));
            l1.d.d(this.f17117f, this.f17113b);
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f17120a;

        /* renamed from: b, reason: collision with root package name */
        public int f17121b;

        /* renamed from: c, reason: collision with root package name */
        public int f17122c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f17123d = 3;

        /* renamed from: e, reason: collision with root package name */
        public int f17124e = 1;

        /* renamed from: f, reason: collision with root package name */
        public String f17125f;
    }

    public interface c {
        void a(int i10);

        void b(int i10);
    }

    public u1(Context context, Object obj) {
        this.f17112a = context;
        this.f17113b = obj;
    }

    public static u1 b(Context context, Object obj) {
        return new a(context, obj);
    }

    public Object a() {
        return this.f17113b;
    }

    public abstract void c(b bVar);

    public void d(c cVar) {
        this.f17114c = cVar;
    }
}
