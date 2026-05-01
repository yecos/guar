package k1;

import a1.n;
import a1.s;
import androidx.work.impl.WorkDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final b1.c f14739a = new b1.c();

    /* renamed from: k1.a$a, reason: collision with other inner class name */
    public class C0243a extends a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b1.j f14740b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UUID f14741c;

        public C0243a(b1.j jVar, UUID uuid) {
            this.f14740b = jVar;
            this.f14741c = uuid;
        }

        @Override // k1.a
        public void g() {
            WorkDatabase n10 = this.f14740b.n();
            n10.c();
            try {
                a(this.f14740b, this.f14741c.toString());
                n10.r();
                n10.g();
                f(this.f14740b);
            } catch (Throwable th) {
                n10.g();
                throw th;
            }
        }
    }

    public class b extends a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b1.j f14742b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f14743c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f14744d;

        public b(b1.j jVar, String str, boolean z10) {
            this.f14742b = jVar;
            this.f14743c = str;
            this.f14744d = z10;
        }

        @Override // k1.a
        public void g() {
            WorkDatabase n10 = this.f14742b.n();
            n10.c();
            try {
                Iterator it = n10.B().f(this.f14743c).iterator();
                while (it.hasNext()) {
                    a(this.f14742b, (String) it.next());
                }
                n10.r();
                n10.g();
                if (this.f14744d) {
                    f(this.f14742b);
                }
            } catch (Throwable th) {
                n10.g();
                throw th;
            }
        }
    }

    public static a b(UUID uuid, b1.j jVar) {
        return new C0243a(jVar, uuid);
    }

    public static a c(String str, b1.j jVar, boolean z10) {
        return new b(jVar, str, z10);
    }

    public void a(b1.j jVar, String str) {
        e(jVar.n(), str);
        jVar.l().l(str);
        Iterator it = jVar.m().iterator();
        while (it.hasNext()) {
            ((b1.e) it.next()).cancel(str);
        }
    }

    public a1.n d() {
        return this.f14739a;
    }

    public final void e(WorkDatabase workDatabase, String str) {
        j1.q B = workDatabase.B();
        j1.b t10 = workDatabase.t();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            s g10 = B.g(str2);
            if (g10 != s.SUCCEEDED && g10 != s.FAILED) {
                B.d(s.CANCELLED, str2);
            }
            linkedList.addAll(t10.a(str2));
        }
    }

    public void f(b1.j jVar) {
        b1.f.b(jVar.h(), jVar.n(), jVar.m());
    }

    public abstract void g();

    @Override // java.lang.Runnable
    public void run() {
        try {
            g();
            this.f14739a.a(a1.n.f124a);
        } catch (Throwable th) {
            this.f14739a.a(new n.b.a(th));
        }
    }
}
