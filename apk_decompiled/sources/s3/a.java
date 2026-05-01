package s3;

import b3.h;
import d4.h;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import k3.f;
import k3.g;
import r3.e;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: s3.a$a, reason: collision with other inner class name */
    public static class C0319a {

        /* renamed from: a, reason: collision with root package name */
        public final k3.c f18738a;

        /* renamed from: b, reason: collision with root package name */
        public final f f18739b;

        /* renamed from: c, reason: collision with root package name */
        public final k3.b f18740c;

        /* renamed from: d, reason: collision with root package name */
        public final List f18741d;

        /* renamed from: e, reason: collision with root package name */
        public final e f18742e;

        /* renamed from: f, reason: collision with root package name */
        public final b[] f18743f;

        public C0319a(g gVar, k3.c cVar) {
            e eVar;
            this.f18738a = cVar;
            this.f18740c = gVar.K();
            this.f18739b = gVar.k();
            b[] b10 = c.c().b(cVar.s());
            this.f18743f = b10;
            int length = b10.length;
            if (length != 0) {
                List v10 = cVar.v();
                this.f18741d = v10;
                Iterator it = v10.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        eVar = null;
                        break;
                    }
                    e eVar2 = (e) it.next();
                    if (eVar2.v() == length) {
                        for (int i10 = 0; i10 < length; i10++) {
                            if (!eVar2.x(i10).equals(this.f18743f[i10].f18744a)) {
                                break;
                            }
                        }
                        eVar = eVar2;
                        break loop0;
                    }
                }
            } else {
                eVar = cVar.d();
                this.f18741d = Collections.singletonList(eVar);
            }
            if (eVar != null) {
                this.f18742e = eVar;
                return;
            }
            throw new IllegalArgumentException("Failed to find the canonical Record constructor of type " + h.G(this.f18738a.z()));
        }

        public e a(List list) {
            for (e eVar : this.f18741d) {
                h.a h10 = this.f18740c.h(this.f18739b, eVar);
                if (h10 != null && h.a.DISABLED != h10 && (h.a.DELEGATING == h10 || eVar != this.f18742e)) {
                    return null;
                }
            }
            for (b bVar : this.f18743f) {
                list.add(bVar.f18745b);
            }
            return this.f18742e;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Class f18744a;

        /* renamed from: b, reason: collision with root package name */
        public final String f18745b;

        public b(Class cls, String str) {
            this.f18744a = cls;
            this.f18745b = str;
        }
    }

    public static class c {

        /* renamed from: d, reason: collision with root package name */
        public static final c f18746d;

        /* renamed from: e, reason: collision with root package name */
        public static final RuntimeException f18747e;

        /* renamed from: a, reason: collision with root package name */
        public final Method f18748a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f18749b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f18750c;

        static {
            c cVar = null;
            try {
                e = null;
                cVar = new c();
            } catch (RuntimeException e10) {
                e = e10;
            }
            f18746d = cVar;
            f18747e = e;
        }

        public c() {
            try {
                this.f18748a = Class.class.getMethod("getRecordComponents", new Class[0]);
                Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
                this.f18749b = cls.getMethod("getName", new Class[0]);
                this.f18750c = cls.getMethod("getType", new Class[0]);
            } catch (Exception e10) {
                throw new RuntimeException(String.format("Failed to access Methods needed to support `java.lang.Record`: (%s) %s", e10.getClass().getName(), e10.getMessage()), e10);
            }
        }

        public static c c() {
            RuntimeException runtimeException = f18747e;
            if (runtimeException == null) {
                return f18746d;
            }
            throw runtimeException;
        }

        public String[] a(Class cls) {
            Object[] d10 = d(cls);
            String[] strArr = new String[d10.length];
            for (int i10 = 0; i10 < d10.length; i10++) {
                try {
                    strArr[i10] = (String) this.f18749b.invoke(d10[i10], new Object[0]);
                } catch (Exception e10) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i10), Integer.valueOf(d10.length), d4.h.X(cls)), e10);
                }
            }
            return strArr;
        }

        public b[] b(Class cls) {
            Object[] d10 = d(cls);
            b[] bVarArr = new b[d10.length];
            for (int i10 = 0; i10 < d10.length; i10++) {
                try {
                    try {
                        bVarArr[i10] = new b((Class) this.f18750c.invoke(d10[i10], new Object[0]), (String) this.f18749b.invoke(d10[i10], new Object[0]));
                    } catch (Exception e10) {
                        throw new IllegalArgumentException(String.format("Failed to access type of field #%d (of %d) of Record type %s", Integer.valueOf(i10), Integer.valueOf(d10.length), d4.h.X(cls)), e10);
                    }
                } catch (Exception e11) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i10), Integer.valueOf(d10.length), d4.h.X(cls)), e11);
                }
            }
            return bVarArr;
        }

        public Object[] d(Class cls) {
            try {
                return (Object[]) this.f18748a.invoke(cls, new Object[0]);
            } catch (Exception unused) {
                throw new IllegalArgumentException("Failed to access RecordComponents of type " + d4.h.X(cls));
            }
        }
    }

    public static e a(g gVar, k3.c cVar, List list) {
        return new C0319a(gVar, cVar).a(list);
    }

    public static String[] b(Class cls) {
        return c.c().a(cls);
    }
}
