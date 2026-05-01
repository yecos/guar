package m;

import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public HashSet f16601a = new HashSet(2);

    /* renamed from: b, reason: collision with root package name */
    public int f16602b = 0;

    public void a(o oVar) {
        this.f16601a.add(oVar);
    }

    public void b() {
        this.f16602b = 1;
        Iterator it = this.f16601a.iterator();
        while (it.hasNext()) {
            ((o) it.next()).f();
        }
    }

    public void c() {
        this.f16602b = 0;
        Iterator it = this.f16601a.iterator();
        while (it.hasNext()) {
            ((o) it.next()).c();
        }
    }

    public boolean d() {
        return this.f16602b == 1;
    }

    public void e() {
        this.f16602b = 0;
        this.f16601a.clear();
    }

    public void f() {
    }
}
