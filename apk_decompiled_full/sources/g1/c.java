package g1;

import j1.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c implements f1.a {

    /* renamed from: a, reason: collision with root package name */
    public final List f13551a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public Object f13552b;

    /* renamed from: c, reason: collision with root package name */
    public h1.d f13553c;

    /* renamed from: d, reason: collision with root package name */
    public a f13554d;

    public interface a {
        void a(List list);

        void b(List list);
    }

    public c(h1.d dVar) {
        this.f13553c = dVar;
    }

    @Override // f1.a
    public void a(Object obj) {
        this.f13552b = obj;
        h(this.f13554d, obj);
    }

    public abstract boolean b(p pVar);

    public abstract boolean c(Object obj);

    public boolean d(String str) {
        Object obj = this.f13552b;
        return obj != null && c(obj) && this.f13551a.contains(str);
    }

    public void e(Iterable iterable) {
        this.f13551a.clear();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            if (b(pVar)) {
                this.f13551a.add(pVar.f14583a);
            }
        }
        if (this.f13551a.isEmpty()) {
            this.f13553c.c(this);
        } else {
            this.f13553c.a(this);
        }
        h(this.f13554d, this.f13552b);
    }

    public void f() {
        if (this.f13551a.isEmpty()) {
            return;
        }
        this.f13551a.clear();
        this.f13553c.c(this);
    }

    public void g(a aVar) {
        if (this.f13554d != aVar) {
            this.f13554d = aVar;
            h(aVar, this.f13552b);
        }
    }

    public final void h(a aVar, Object obj) {
        if (this.f13551a.isEmpty() || aVar == null) {
            return;
        }
        if (obj == null || c(obj)) {
            aVar.b(this.f13551a);
        } else {
            aVar.a(this.f13551a);
        }
    }
}
