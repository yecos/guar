package f1;

import a1.k;
import android.content.Context;
import g1.c;
import g1.e;
import g1.f;
import g1.g;
import g1.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class d implements c.a {

    /* renamed from: d, reason: collision with root package name */
    public static final String f13018d = k.f("WorkConstraintsTracker");

    /* renamed from: a, reason: collision with root package name */
    public final c f13019a;

    /* renamed from: b, reason: collision with root package name */
    public final g1.c[] f13020b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f13021c;

    public d(Context context, m1.a aVar, c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.f13019a = cVar;
        this.f13020b = new g1.c[]{new g1.a(applicationContext, aVar), new g1.b(applicationContext, aVar), new h(applicationContext, aVar), new g1.d(applicationContext, aVar), new g(applicationContext, aVar), new f(applicationContext, aVar), new e(applicationContext, aVar)};
        this.f13021c = new Object();
    }

    @Override // g1.c.a
    public void a(List list) {
        synchronized (this.f13021c) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (c(str)) {
                    k.c().a(f13018d, String.format("Constraints met for %s", str), new Throwable[0]);
                    arrayList.add(str);
                }
            }
            c cVar = this.f13019a;
            if (cVar != null) {
                cVar.d(arrayList);
            }
        }
    }

    @Override // g1.c.a
    public void b(List list) {
        synchronized (this.f13021c) {
            c cVar = this.f13019a;
            if (cVar != null) {
                cVar.b(list);
            }
        }
    }

    public boolean c(String str) {
        synchronized (this.f13021c) {
            for (g1.c cVar : this.f13020b) {
                if (cVar.d(str)) {
                    k.c().a(f13018d, String.format("Work %s constrained by %s", str, cVar.getClass().getSimpleName()), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void d(Iterable iterable) {
        synchronized (this.f13021c) {
            for (g1.c cVar : this.f13020b) {
                cVar.g(null);
            }
            for (g1.c cVar2 : this.f13020b) {
                cVar2.e(iterable);
            }
            for (g1.c cVar3 : this.f13020b) {
                cVar3.g(this);
            }
        }
    }

    public void e() {
        synchronized (this.f13021c) {
            for (g1.c cVar : this.f13020b) {
                cVar.f();
            }
        }
    }
}
