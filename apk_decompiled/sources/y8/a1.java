package y8;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.j1;
import y8.y0;

/* loaded from: classes3.dex */
public final class a1 {

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f19779e = Logger.getLogger(a1.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public static a1 f19780f;

    /* renamed from: a, reason: collision with root package name */
    public final y0.c f19781a = new b();

    /* renamed from: b, reason: collision with root package name */
    public String f19782b = "unknown";

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashSet f19783c = new LinkedHashSet();

    /* renamed from: d, reason: collision with root package name */
    public ImmutableMap f19784d = ImmutableMap.of();

    public final class b extends y0.c {
        public b() {
        }

        @Override // y8.y0.c
        public String a() {
            String str;
            synchronized (a1.this) {
                str = a1.this.f19782b;
            }
            return str;
        }

        @Override // y8.y0.c
        public y0 b(URI uri, y0.a aVar) {
            z0 z0Var = (z0) a1.this.f().get(uri.getScheme());
            if (z0Var == null) {
                return null;
            }
            return z0Var.b(uri, aVar);
        }
    }

    public static final class c implements j1.b {
        public c() {
        }

        @Override // y8.j1.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(z0 z0Var) {
            return z0Var.e();
        }

        @Override // y8.j1.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(z0 z0Var) {
            return z0Var.d();
        }
    }

    public static synchronized a1 d() {
        a1 a1Var;
        synchronized (a1.class) {
            if (f19780f == null) {
                List<z0> e10 = j1.e(z0.class, e(), z0.class.getClassLoader(), new c());
                if (e10.isEmpty()) {
                    f19779e.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                }
                f19780f = new a1();
                for (z0 z0Var : e10) {
                    f19779e.fine("Service loader found " + z0Var);
                    f19780f.b(z0Var);
                }
                f19780f.g();
            }
            a1Var = f19780f;
        }
        return a1Var;
    }

    public static List e() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(z8.d0.class);
        } catch (ClassNotFoundException e10) {
            f19779e.log(Level.FINE, "Unable to find DNS NameResolver", (Throwable) e10);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void b(z0 z0Var) {
        Preconditions.checkArgument(z0Var.d(), "isAvailable() returned false");
        this.f19783c.add(z0Var);
    }

    public y0.c c() {
        return this.f19781a;
    }

    public synchronized Map f() {
        return this.f19784d;
    }

    public final synchronized void g() {
        HashMap hashMap = new HashMap();
        String str = "unknown";
        Iterator it = this.f19783c.iterator();
        int i10 = Integer.MIN_VALUE;
        while (it.hasNext()) {
            z0 z0Var = (z0) it.next();
            String c10 = z0Var.c();
            z0 z0Var2 = (z0) hashMap.get(c10);
            if (z0Var2 == null || z0Var2.e() < z0Var.e()) {
                hashMap.put(c10, z0Var);
            }
            if (i10 < z0Var.e()) {
                i10 = z0Var.e();
                str = z0Var.c();
            }
        }
        this.f19784d = ImmutableMap.copyOf((Map) hashMap);
        this.f19782b = str;
    }
}
