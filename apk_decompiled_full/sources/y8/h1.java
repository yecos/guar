package y8;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class h1 {

    /* renamed from: a, reason: collision with root package name */
    public final i1 f19860a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f19861b;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f19862a;

        /* renamed from: b, reason: collision with root package name */
        public final i1 f19863b;

        /* renamed from: c, reason: collision with root package name */
        public final Map f19864c;

        public b a(w0 w0Var, f1 f1Var) {
            return b(g1.a((w0) Preconditions.checkNotNull(w0Var, "method must not be null"), (f1) Preconditions.checkNotNull(f1Var, "handler must not be null")));
        }

        public b b(g1 g1Var) {
            w0 b10 = g1Var.b();
            Preconditions.checkArgument(this.f19862a.equals(b10.d()), "Method name should be prefixed with service name and separated with '/'. Expected service name: '%s'. Actual fully qualifed method name: '%s'.", this.f19862a, b10.c());
            String c10 = b10.c();
            Preconditions.checkState(!this.f19864c.containsKey(c10), "Method by same name already registered: %s", c10);
            this.f19864c.put(c10, g1Var);
            return this;
        }

        public h1 c() {
            i1 i1Var = this.f19863b;
            if (i1Var == null) {
                ArrayList arrayList = new ArrayList(this.f19864c.size());
                Iterator it = this.f19864c.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(((g1) it.next()).b());
                }
                i1Var = new i1(this.f19862a, arrayList);
            }
            HashMap hashMap = new HashMap(this.f19864c);
            for (w0 w0Var : i1Var.a()) {
                g1 g1Var = (g1) hashMap.remove(w0Var.c());
                if (g1Var == null) {
                    throw new IllegalStateException("No method bound for descriptor entry " + w0Var.c());
                }
                if (g1Var.b() != w0Var) {
                    throw new IllegalStateException("Bound method for " + w0Var.c() + " not same instance as method in service descriptor");
                }
            }
            if (hashMap.size() <= 0) {
                return new h1(i1Var, this.f19864c);
            }
            throw new IllegalStateException("No entry in descriptor matching bound method " + ((g1) hashMap.values().iterator().next()).b().c());
        }

        public b(i1 i1Var) {
            this.f19864c = new HashMap();
            this.f19863b = (i1) Preconditions.checkNotNull(i1Var, "serviceDescriptor");
            this.f19862a = i1Var.b();
        }
    }

    public static b a(i1 i1Var) {
        return new b(i1Var);
    }

    public h1(i1 i1Var, Map map) {
        this.f19860a = (i1) Preconditions.checkNotNull(i1Var, "serviceDescriptor");
        this.f19861b = Collections.unmodifiableMap(new HashMap(map));
    }
}
