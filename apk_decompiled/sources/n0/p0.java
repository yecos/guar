package n0;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class p0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f16927a;

    /* renamed from: b, reason: collision with root package name */
    public final d f16928b;

    /* renamed from: c, reason: collision with root package name */
    public final c f16929c;

    /* renamed from: d, reason: collision with root package name */
    public a f16930d;

    /* renamed from: e, reason: collision with root package name */
    public o0 f16931e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16932f;

    /* renamed from: g, reason: collision with root package name */
    public q0 f16933g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f16934h;

    public static abstract class a {
        public abstract void a(p0 p0Var, q0 q0Var);
    }

    public static abstract class b extends e {

        /* renamed from: a, reason: collision with root package name */
        public final Object f16935a = new Object();

        /* renamed from: b, reason: collision with root package name */
        public Executor f16936b;

        /* renamed from: c, reason: collision with root package name */
        public d f16937c;

        /* renamed from: d, reason: collision with root package name */
        public n0 f16938d;

        /* renamed from: e, reason: collision with root package name */
        public Collection f16939e;

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f16940a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ n0 f16941b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Collection f16942c;

            public a(d dVar, n0 n0Var, Collection collection) {
                this.f16940a = dVar;
                this.f16941b = n0Var;
                this.f16942c = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f16940a.a(b.this, this.f16941b, this.f16942c);
            }
        }

        /* renamed from: n0.p0$b$b, reason: collision with other inner class name */
        public class RunnableC0289b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f16944a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ n0 f16945b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Collection f16946c;

            public RunnableC0289b(d dVar, n0 n0Var, Collection collection) {
                this.f16944a = dVar;
                this.f16945b = n0Var;
                this.f16946c = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f16944a.a(b.this, this.f16945b, this.f16946c);
            }
        }

        public static final class c {

            /* renamed from: a, reason: collision with root package name */
            public final n0 f16948a;

            /* renamed from: b, reason: collision with root package name */
            public final int f16949b;

            /* renamed from: c, reason: collision with root package name */
            public final boolean f16950c;

            /* renamed from: d, reason: collision with root package name */
            public final boolean f16951d;

            /* renamed from: e, reason: collision with root package name */
            public final boolean f16952e;

            public static final class a {

                /* renamed from: a, reason: collision with root package name */
                public final n0 f16953a;

                /* renamed from: b, reason: collision with root package name */
                public int f16954b = 1;

                /* renamed from: c, reason: collision with root package name */
                public boolean f16955c = false;

                /* renamed from: d, reason: collision with root package name */
                public boolean f16956d = false;

                /* renamed from: e, reason: collision with root package name */
                public boolean f16957e = false;

                public a(n0 n0Var) {
                    this.f16953a = n0Var;
                }

                public c a() {
                    return new c(this.f16953a, this.f16954b, this.f16955c, this.f16956d, this.f16957e);
                }

                public a b(boolean z10) {
                    this.f16956d = z10;
                    return this;
                }

                public a c(boolean z10) {
                    this.f16957e = z10;
                    return this;
                }

                public a d(boolean z10) {
                    this.f16955c = z10;
                    return this;
                }

                public a e(int i10) {
                    this.f16954b = i10;
                    return this;
                }
            }

            public c(n0 n0Var, int i10, boolean z10, boolean z11, boolean z12) {
                this.f16948a = n0Var;
                this.f16949b = i10;
                this.f16950c = z10;
                this.f16951d = z11;
                this.f16952e = z12;
            }

            public static c a(Bundle bundle) {
                if (bundle == null) {
                    return null;
                }
                return new c(n0.d(bundle.getBundle("mrDescriptor")), bundle.getInt("selectionState", 1), bundle.getBoolean("isUnselectable", false), bundle.getBoolean("isGroupable", false), bundle.getBoolean("isTransferable", false));
            }

            public n0 b() {
                return this.f16948a;
            }

            public int c() {
                return this.f16949b;
            }

            public boolean d() {
                return this.f16951d;
            }

            public boolean e() {
                return this.f16952e;
            }

            public boolean f() {
                return this.f16950c;
            }
        }

        public interface d {
            void a(b bVar, n0 n0Var, Collection collection);
        }

        public String j() {
            return null;
        }

        public String k() {
            return null;
        }

        public final void l(n0 n0Var, Collection collection) {
            if (n0Var == null) {
                throw new NullPointerException("groupRoute must not be null");
            }
            if (collection == null) {
                throw new NullPointerException("dynamicRoutes must not be null");
            }
            synchronized (this.f16935a) {
                Executor executor = this.f16936b;
                if (executor != null) {
                    executor.execute(new RunnableC0289b(this.f16937c, n0Var, collection));
                } else {
                    this.f16938d = n0Var;
                    this.f16939e = new ArrayList(collection);
                }
            }
        }

        public abstract void m(String str);

        public abstract void n(String str);

        public abstract void o(List list);

        public void p(Executor executor, d dVar) {
            synchronized (this.f16935a) {
                if (executor == null) {
                    throw new NullPointerException("Executor shouldn't be null");
                }
                if (dVar == null) {
                    throw new NullPointerException("Listener shouldn't be null");
                }
                this.f16936b = executor;
                this.f16937c = dVar;
                Collection collection = this.f16939e;
                if (collection != null && !collection.isEmpty()) {
                    n0 n0Var = this.f16938d;
                    Collection collection2 = this.f16939e;
                    this.f16938d = null;
                    this.f16939e = null;
                    this.f16936b.execute(new a(dVar, n0Var, collection2));
                }
            }
        }
    }

    public final class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                p0.this.l();
            } else {
                if (i10 != 2) {
                    return;
                }
                p0.this.m();
            }
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final ComponentName f16959a;

        public d(ComponentName componentName) {
            if (componentName == null) {
                throw new IllegalArgumentException("componentName must not be null");
            }
            this.f16959a = componentName;
        }

        public ComponentName a() {
            return this.f16959a;
        }

        public String b() {
            return this.f16959a.getPackageName();
        }

        public String toString() {
            return "ProviderMetadata{ componentName=" + this.f16959a.flattenToShortString() + " }";
        }
    }

    public static abstract class e {
        public void d() {
        }

        public void e() {
        }

        public abstract void f(int i10);

        public void g() {
        }

        public void h(int i10) {
            g();
        }

        public abstract void i(int i10);
    }

    public p0(Context context) {
        this(context, null);
    }

    public void l() {
        this.f16934h = false;
        a aVar = this.f16930d;
        if (aVar != null) {
            aVar.a(this, this.f16933g);
        }
    }

    public void m() {
        this.f16932f = false;
        u(this.f16931e);
    }

    public final Context n() {
        return this.f16927a;
    }

    public final q0 o() {
        return this.f16933g;
    }

    public final o0 p() {
        return this.f16931e;
    }

    public final d q() {
        return this.f16928b;
    }

    public b r(String str) {
        if (str != null) {
            return null;
        }
        throw new IllegalArgumentException("initialMemberRouteId cannot be null.");
    }

    public abstract e s(String str);

    public e t(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        }
        if (str2 != null) {
            return s(str);
        }
        throw new IllegalArgumentException("routeGroupId cannot be null");
    }

    public abstract void u(o0 o0Var);

    public final void v(a aVar) {
        t0.d();
        this.f16930d = aVar;
    }

    public final void w(q0 q0Var) {
        t0.d();
        if (this.f16933g != q0Var) {
            this.f16933g = q0Var;
            if (this.f16934h) {
                return;
            }
            this.f16934h = true;
            this.f16929c.sendEmptyMessage(1);
        }
    }

    public final void x(o0 o0Var) {
        t0.d();
        if (a0.c.a(this.f16931e, o0Var)) {
            return;
        }
        y(o0Var);
    }

    public final void y(o0 o0Var) {
        this.f16931e = o0Var;
        if (this.f16932f) {
            return;
        }
        this.f16932f = true;
        this.f16929c.sendEmptyMessage(2);
    }

    public p0(Context context, d dVar) {
        this.f16929c = new c();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        this.f16927a = context;
        if (dVar == null) {
            this.f16928b = new d(new ComponentName(context, getClass()));
        } else {
            this.f16928b = dVar;
        }
    }
}
