package o3;

import b3.k0;
import b3.o0;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    public final k0.a f17591a;

    /* renamed from: b, reason: collision with root package name */
    public LinkedList f17592b;

    public z(k0.a aVar) {
        this.f17591a = aVar;
    }

    public void a(a aVar) {
        if (this.f17592b == null) {
            this.f17592b = new LinkedList();
        }
        this.f17592b.add(aVar);
    }

    public void b(Object obj) {
        throw null;
    }

    public k0.a c() {
        return this.f17591a;
    }

    public boolean d() {
        LinkedList linkedList = this.f17592b;
        return (linkedList == null || linkedList.isEmpty()) ? false : true;
    }

    public Iterator e() {
        LinkedList linkedList = this.f17592b;
        return linkedList == null ? Collections.emptyList().iterator() : linkedList.iterator();
    }

    public Object f() {
        throw null;
    }

    public void g(o0 o0Var) {
    }

    public boolean h(k3.g gVar) {
        return false;
    }

    public String toString() {
        return String.valueOf(this.f17591a);
    }

    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final n3.u f17593a;

        /* renamed from: b, reason: collision with root package name */
        public final Class f17594b;

        public a(n3.u uVar, Class cls) {
            this.f17593a = uVar;
            this.f17594b = cls;
        }

        public Class a() {
            return this.f17594b;
        }

        public c3.i b() {
            return this.f17593a.a();
        }

        public a(n3.u uVar, k3.j jVar) {
            this.f17593a = uVar;
            this.f17594b = jVar.q();
        }
    }
}
