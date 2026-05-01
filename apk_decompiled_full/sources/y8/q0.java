package y8;

import com.google.common.base.Preconditions;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.j1;

/* loaded from: classes3.dex */
public final class q0 {

    /* renamed from: d, reason: collision with root package name */
    public static q0 f19997d;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f19999a = new LinkedHashSet();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f20000b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f19996c = Logger.getLogger(q0.class.getName());

    /* renamed from: e, reason: collision with root package name */
    public static final Iterable f19998e = c();

    public static final class a implements j1.b {
        @Override // y8.j1.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(p0 p0Var) {
            return p0Var.c();
        }

        @Override // y8.j1.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(p0 p0Var) {
            return p0Var.d();
        }
    }

    public static synchronized q0 b() {
        q0 q0Var;
        synchronized (q0.class) {
            if (f19997d == null) {
                List<p0> e10 = j1.e(p0.class, f19998e, p0.class.getClassLoader(), new a());
                f19997d = new q0();
                for (p0 p0Var : e10) {
                    f19996c.fine("Service loader found " + p0Var);
                    f19997d.a(p0Var);
                }
                f19997d.e();
            }
            q0Var = f19997d;
        }
        return q0Var;
    }

    public static List c() {
        ArrayList arrayList = new ArrayList();
        try {
            int i10 = z8.q1.f20876b;
            arrayList.add(z8.q1.class);
        } catch (ClassNotFoundException e10) {
            f19996c.log(Level.WARNING, "Unable to find pick-first LoadBalancer", (Throwable) e10);
        }
        try {
            int i11 = f9.i.f13417b;
            arrayList.add(f9.i.class);
        } catch (ClassNotFoundException e11) {
            f19996c.log(Level.FINE, "Unable to find round-robin LoadBalancer", (Throwable) e11);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(p0 p0Var) {
        Preconditions.checkArgument(p0Var.d(), "isAvailable() returned false");
        this.f19999a.add(p0Var);
    }

    public synchronized p0 d(String str) {
        return (p0) this.f20000b.get(Preconditions.checkNotNull(str, bt.by));
    }

    public final synchronized void e() {
        this.f20000b.clear();
        Iterator it = this.f19999a.iterator();
        while (it.hasNext()) {
            p0 p0Var = (p0) it.next();
            String b10 = p0Var.b();
            p0 p0Var2 = (p0) this.f20000b.get(b10);
            if (p0Var2 == null || p0Var2.c() < p0Var.c()) {
                this.f20000b.put(b10, p0Var);
            }
        }
    }
}
