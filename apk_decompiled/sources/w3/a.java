package w3;

import java.io.Closeable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import k3.j;
import m3.m;
import w3.c;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: w3.a$a, reason: collision with other inner class name */
    public static final class C0329a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0329a f19148b = new C0329a();

        /* renamed from: a, reason: collision with root package name */
        public final Set f19149a;

        public C0329a() {
            HashSet hashSet = new HashSet();
            this.f19149a = hashSet;
            hashSet.add(Object.class.getName());
            hashSet.add(Closeable.class.getName());
            hashSet.add(Serializable.class.getName());
            hashSet.add(AutoCloseable.class.getName());
            hashSet.add(Cloneable.class.getName());
            hashSet.add("java.util.logging.Handler");
            hashSet.add("javax.naming.Referenceable");
            hashSet.add("javax.sql.DataSource");
        }

        public boolean a(Class cls) {
            return this.f19149a.contains(cls.getName());
        }
    }

    @Override // w3.c
    public c.b a(m mVar, j jVar) {
        return e(mVar, jVar) ? c.b.DENIED : c.b.INDETERMINATE;
    }

    @Override // w3.c
    public c.b b(m mVar, j jVar, String str) {
        return c.b.INDETERMINATE;
    }

    @Override // w3.c
    public c.b c(m mVar, j jVar, j jVar2) {
        return d(mVar, jVar, jVar2) ? c.b.ALLOWED : c.b.DENIED;
    }

    public boolean d(m mVar, j jVar, j jVar2) {
        return true;
    }

    public boolean e(m mVar, j jVar) {
        return C0329a.f19148b.a(jVar.q());
    }
}
