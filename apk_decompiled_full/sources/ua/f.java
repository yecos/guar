package ua;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class f {

    /* renamed from: h, reason: collision with root package name */
    public static final HashMap f19084h = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public String f19085a;

    /* renamed from: b, reason: collision with root package name */
    public String f19086b;

    /* renamed from: c, reason: collision with root package name */
    public a f19087c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f19088d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f19089e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f19090f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public boolean f19091g;

    public static f a(Class cls) {
        if (cls == null) {
            throw new va.b("table info get error,because the clazz is null");
        }
        f fVar = (f) f19084h.get(cls.getName());
        if (fVar == null) {
            fVar = new f();
            fVar.h(wa.a.f(cls));
            fVar.f(cls.getName());
            Field c10 = wa.a.c(cls);
            if (c10 == null) {
                throw new va.b("the class[" + cls + "]'s idField is null , \n you can define _id,id property or use annotation @id to solution this exception");
            }
            a aVar = new a();
            aVar.e(wa.b.c(c10));
            aVar.i(c10.getName());
            aVar.k(wa.b.f(cls, c10));
            aVar.j(wa.b.e(cls, c10));
            aVar.f(c10.getType());
            fVar.g(aVar);
            List<e> e10 = wa.a.e(cls);
            if (e10 != null) {
                for (e eVar : e10) {
                    if (eVar != null) {
                        fVar.f19088d.put(eVar.a(), eVar);
                    }
                }
            }
            List<c> a10 = wa.a.a(cls);
            if (a10 != null) {
                for (c cVar : a10) {
                    if (cVar != null) {
                        fVar.f19090f.put(cVar.a(), cVar);
                    }
                }
            }
            List<d> b10 = wa.a.b(cls);
            if (b10 != null) {
                for (d dVar : b10) {
                    if (dVar != null) {
                        fVar.f19089e.put(dVar.a(), dVar);
                    }
                }
            }
            f19084h.put(cls.getName(), fVar);
        }
        return fVar;
    }

    public a b() {
        return this.f19087c;
    }

    public String c() {
        return this.f19086b;
    }

    public boolean d() {
        return this.f19091g;
    }

    public void e(boolean z10) {
        this.f19091g = z10;
    }

    public void f(String str) {
        this.f19085a = str;
    }

    public void g(a aVar) {
        this.f19087c = aVar;
    }

    public void h(String str) {
        this.f19086b = str;
    }
}
