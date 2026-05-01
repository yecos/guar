package c1;

import a1.k;
import a1.s;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import b1.e;
import b1.j;
import f1.c;
import f1.d;
import j1.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class b implements e, c, b1.b {

    /* renamed from: i, reason: collision with root package name */
    public static final String f5298i = k.f("GreedyScheduler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f5299a;

    /* renamed from: b, reason: collision with root package name */
    public final j f5300b;

    /* renamed from: c, reason: collision with root package name */
    public final d f5301c;

    /* renamed from: e, reason: collision with root package name */
    public a f5303e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5304f;

    /* renamed from: h, reason: collision with root package name */
    public Boolean f5306h;

    /* renamed from: d, reason: collision with root package name */
    public final Set f5302d = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    public final Object f5305g = new Object();

    public b(Context context, androidx.work.a aVar, m1.a aVar2, j jVar) {
        this.f5299a = context;
        this.f5300b = jVar;
        this.f5301c = new d(context, aVar2, this);
        this.f5303e = new a(this, aVar.k());
    }

    @Override // b1.e
    public boolean a() {
        return false;
    }

    @Override // f1.c
    public void b(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            k.c().a(f5298i, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.f5300b.w(str);
        }
    }

    @Override // b1.b
    public void c(String str, boolean z10) {
        h(str);
    }

    @Override // b1.e
    public void cancel(String str) {
        if (this.f5306h == null) {
            f();
        }
        if (!this.f5306h.booleanValue()) {
            k.c().d(f5298i, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        g();
        k.c().a(f5298i, String.format("Cancelling work ID %s", str), new Throwable[0]);
        a aVar = this.f5303e;
        if (aVar != null) {
            aVar.b(str);
        }
        this.f5300b.w(str);
    }

    @Override // f1.c
    public void d(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            k.c().a(f5298i, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            this.f5300b.t(str);
        }
    }

    @Override // b1.e
    public void e(p... pVarArr) {
        if (this.f5306h == null) {
            f();
        }
        if (!this.f5306h.booleanValue()) {
            k.c().d(f5298i, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        g();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (p pVar : pVarArr) {
            long a10 = pVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (pVar.f14584b == s.ENQUEUED) {
                if (currentTimeMillis < a10) {
                    a aVar = this.f5303e;
                    if (aVar != null) {
                        aVar.a(pVar);
                    }
                } else if (pVar.b()) {
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 23 && pVar.f14592j.h()) {
                        k.c().a(f5298i, String.format("Ignoring WorkSpec %s, Requires device idle.", pVar), new Throwable[0]);
                    } else if (i10 < 24 || !pVar.f14592j.e()) {
                        hashSet.add(pVar);
                        hashSet2.add(pVar.f14583a);
                    } else {
                        k.c().a(f5298i, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", pVar), new Throwable[0]);
                    }
                } else {
                    k.c().a(f5298i, String.format("Starting work for %s", pVar.f14583a), new Throwable[0]);
                    this.f5300b.t(pVar.f14583a);
                }
            }
        }
        synchronized (this.f5305g) {
            if (!hashSet.isEmpty()) {
                k.c().a(f5298i, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                this.f5302d.addAll(hashSet);
                this.f5301c.d(this.f5302d);
            }
        }
    }

    public final void f() {
        this.f5306h = Boolean.valueOf(k1.j.b(this.f5299a, this.f5300b.h()));
    }

    public final void g() {
        if (this.f5304f) {
            return;
        }
        this.f5300b.l().d(this);
        this.f5304f = true;
    }

    public final void h(String str) {
        synchronized (this.f5305g) {
            Iterator it = this.f5302d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p pVar = (p) it.next();
                if (pVar.f14583a.equals(str)) {
                    k.c().a(f5298i, String.format("Stopping tracking for %s", str), new Throwable[0]);
                    this.f5302d.remove(pVar);
                    this.f5301c.d(this.f5302d);
                    break;
                }
            }
        }
    }
}
