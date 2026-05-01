package y3;

import c3.w;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import k3.k;
import k3.o;
import k3.s;

/* loaded from: classes.dex */
public class b extends s implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final String f19730a;

    /* renamed from: b, reason: collision with root package name */
    public final w f19731b;

    /* renamed from: c, reason: collision with root package name */
    public c f19732c;

    /* renamed from: d, reason: collision with root package name */
    public a f19733d;

    /* renamed from: e, reason: collision with root package name */
    public c f19734e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f19735f;

    /* renamed from: g, reason: collision with root package name */
    public LinkedHashSet f19736g;

    public b() {
        String name;
        this.f19732c = null;
        this.f19733d = null;
        this.f19734e = null;
        this.f19735f = null;
        this.f19736g = null;
        if (getClass() == b.class) {
            name = "SimpleModule-" + System.identityHashCode(this);
        } else {
            name = getClass().getName();
        }
        this.f19730a = name;
        this.f19731b = w.c();
    }

    @Override // k3.s
    public String b() {
        return this.f19730a;
    }

    @Override // k3.s
    public Object c() {
        if (getClass() == b.class) {
            return null;
        }
        return super.c();
    }

    @Override // k3.s
    public void d(s.a aVar) {
        c cVar = this.f19732c;
        if (cVar != null) {
            aVar.d(cVar);
        }
        a aVar2 = this.f19733d;
        if (aVar2 != null) {
            aVar.b(aVar2);
        }
        c cVar2 = this.f19734e;
        if (cVar2 != null) {
            aVar.e(cVar2);
        }
        LinkedHashSet linkedHashSet = this.f19736g;
        if (linkedHashSet != null && linkedHashSet.size() > 0) {
            LinkedHashSet linkedHashSet2 = this.f19736g;
            aVar.a((w3.b[]) linkedHashSet2.toArray(new w3.b[linkedHashSet2.size()]));
        }
        HashMap hashMap = this.f19735f;
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                aVar.c((Class) entry.getKey(), (Class) entry.getValue());
            }
        }
    }

    @Override // k3.s
    public w e() {
        return this.f19731b;
    }

    public void f(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("Cannot pass `null` as %s", str));
        }
    }

    public b g(Class cls, k kVar) {
        f(cls, "type to register deserializer for");
        f(kVar, "deserializer");
        if (this.f19733d == null) {
            this.f19733d = new a();
        }
        this.f19733d.k(cls, kVar);
        return this;
    }

    public b h(o oVar) {
        f(oVar, "serializer");
        if (this.f19732c == null) {
            this.f19732c = new c();
        }
        this.f19732c.j(oVar);
        return this;
    }

    public b(String str) {
        this(str, w.c());
    }

    public b(String str, w wVar) {
        this.f19732c = null;
        this.f19733d = null;
        this.f19734e = null;
        this.f19735f = null;
        this.f19736g = null;
        this.f19730a = str;
        this.f19731b = wVar;
    }
}
