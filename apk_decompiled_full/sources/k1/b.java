package k1;

import a1.n;
import a1.s;
import a1.u;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.b;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import j1.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public static final String f14745c = a1.k.f("EnqueueRunnable");

    /* renamed from: a, reason: collision with root package name */
    public final b1.g f14746a;

    /* renamed from: b, reason: collision with root package name */
    public final b1.c f14747b = new b1.c();

    public b(b1.g gVar) {
        this.f14746a = gVar;
    }

    public static boolean b(b1.g gVar) {
        boolean c10 = c(gVar.g(), gVar.f(), (String[]) b1.g.l(gVar).toArray(new String[0]), gVar.d(), gVar.b());
        gVar.k();
        return c10;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e1 A[LOOP:5: B:86:0x01db->B:88:0x01e1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x020a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(b1.j jVar, List list, String[] strArr, String str, a1.d dVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        Iterator it;
        long j10;
        int i10;
        Iterator it2;
        boolean z14;
        j1.b bVar;
        b1.j jVar2 = jVar;
        String[] strArr2 = strArr;
        long currentTimeMillis = System.currentTimeMillis();
        WorkDatabase n10 = jVar.n();
        boolean z15 = strArr2 != null && strArr2.length > 0;
        if (z15) {
            z10 = true;
            z11 = false;
            z12 = false;
            for (String str2 : strArr2) {
                j1.p h10 = n10.B().h(str2);
                if (h10 == null) {
                    a1.k.c().b(f14745c, String.format("Prerequisite %s doesn't exist; not enqueuing", str2), new Throwable[0]);
                    return false;
                }
                s sVar = h10.f14584b;
                z10 &= sVar == s.SUCCEEDED;
                if (sVar == s.FAILED) {
                    z12 = true;
                } else if (sVar == s.CANCELLED) {
                    z11 = true;
                }
            }
        } else {
            z10 = true;
            z11 = false;
            z12 = false;
        }
        boolean z16 = !TextUtils.isEmpty(str);
        if (z16 && !z15) {
            List<p.b> m10 = n10.B().m(str);
            if (!m10.isEmpty()) {
                if (dVar != a1.d.APPEND && dVar != a1.d.APPEND_OR_REPLACE) {
                    if (dVar == a1.d.KEEP) {
                        Iterator it3 = m10.iterator();
                        while (it3.hasNext()) {
                            s sVar2 = ((p.b) it3.next()).f14602b;
                            if (sVar2 == s.ENQUEUED || sVar2 == s.RUNNING) {
                                return false;
                            }
                        }
                    }
                    a.c(str, jVar2, false).run();
                    j1.q B = n10.B();
                    Iterator it4 = m10.iterator();
                    while (it4.hasNext()) {
                        B.a(((p.b) it4.next()).f14601a);
                    }
                    z13 = true;
                    it = list.iterator();
                    while (it.hasNext()) {
                        u uVar = (u) it.next();
                        j1.p c10 = uVar.c();
                        if (!z15 || z10) {
                            if (c10.d()) {
                                j10 = currentTimeMillis;
                                c10.f14596n = 0L;
                                i10 = Build.VERSION.SDK_INT;
                                if (i10 < 23 && i10 <= 25) {
                                    g(c10);
                                } else if (i10 <= 22 && h(jVar2, "androidx.work.impl.background.gcm.GcmScheduler")) {
                                    g(c10);
                                }
                                if (c10.f14584b == s.ENQUEUED) {
                                    z13 = true;
                                }
                                n10.B().e(c10);
                                if (z15) {
                                    for (String str3 : strArr2) {
                                        n10.t().c(new j1.a(uVar.a(), str3));
                                    }
                                }
                                it2 = uVar.b().iterator();
                                while (it2.hasNext()) {
                                    n10.C().b(new j1.s((String) it2.next(), uVar.a()));
                                }
                                if (!z16) {
                                    n10.z().a(new j1.j(str, uVar.a()));
                                }
                                jVar2 = jVar;
                                currentTimeMillis = j10;
                            } else {
                                c10.f14596n = currentTimeMillis;
                            }
                        } else if (z12) {
                            c10.f14584b = s.FAILED;
                        } else if (z11) {
                            c10.f14584b = s.CANCELLED;
                        } else {
                            c10.f14584b = s.BLOCKED;
                        }
                        j10 = currentTimeMillis;
                        i10 = Build.VERSION.SDK_INT;
                        if (i10 < 23) {
                        }
                        if (i10 <= 22) {
                            g(c10);
                        }
                        if (c10.f14584b == s.ENQUEUED) {
                        }
                        n10.B().e(c10);
                        if (z15) {
                        }
                        it2 = uVar.b().iterator();
                        while (it2.hasNext()) {
                        }
                        if (!z16) {
                        }
                        jVar2 = jVar;
                        currentTimeMillis = j10;
                    }
                    return z13;
                }
                j1.b t10 = n10.t();
                List arrayList = new ArrayList();
                for (p.b bVar2 : m10) {
                    if (t10.d(bVar2.f14601a)) {
                        bVar = t10;
                    } else {
                        s sVar3 = bVar2.f14602b;
                        bVar = t10;
                        boolean z17 = (sVar3 == s.SUCCEEDED) & z10;
                        if (sVar3 == s.FAILED) {
                            z12 = true;
                        } else if (sVar3 == s.CANCELLED) {
                            z11 = true;
                        }
                        arrayList.add(bVar2.f14601a);
                        z10 = z17;
                    }
                    t10 = bVar;
                }
                if (dVar == a1.d.APPEND_OR_REPLACE && (z11 || z12)) {
                    j1.q B2 = n10.B();
                    Iterator it5 = B2.m(str).iterator();
                    while (it5.hasNext()) {
                        B2.a(((p.b) it5.next()).f14601a);
                    }
                    arrayList = Collections.emptyList();
                    z14 = false;
                    z11 = false;
                } else {
                    z14 = z12;
                }
                strArr2 = (String[]) arrayList.toArray(strArr2);
                z15 = strArr2.length > 0;
                z12 = z14;
            }
        }
        z13 = false;
        it = list.iterator();
        while (it.hasNext()) {
        }
        return z13;
    }

    public static boolean e(b1.g gVar) {
        List<b1.g> e10 = gVar.e();
        boolean z10 = false;
        if (e10 != null) {
            boolean z11 = false;
            for (b1.g gVar2 : e10) {
                if (gVar2.j()) {
                    a1.k.c().h(f14745c, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", gVar2.c())), new Throwable[0]);
                } else {
                    z11 |= e(gVar2);
                }
            }
            z10 = z11;
        }
        return b(gVar) | z10;
    }

    public static void g(j1.p pVar) {
        a1.b bVar = pVar.f14592j;
        String str = pVar.f14585c;
        if (str.equals(ConstraintTrackingWorker.class.getName())) {
            return;
        }
        if (bVar.f() || bVar.i()) {
            b.a aVar = new b.a();
            aVar.c(pVar.f14587e).e("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            pVar.f14585c = ConstraintTrackingWorker.class.getName();
            pVar.f14587e = aVar.a();
        }
    }

    public static boolean h(b1.j jVar, String str) {
        try {
            Class<?> cls = Class.forName(str);
            Iterator it = jVar.m().iterator();
            while (it.hasNext()) {
                if (cls.isAssignableFrom(((b1.e) it.next()).getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    public boolean a() {
        WorkDatabase n10 = this.f14746a.g().n();
        n10.c();
        try {
            boolean e10 = e(this.f14746a);
            n10.r();
            return e10;
        } finally {
            n10.g();
        }
    }

    public a1.n d() {
        return this.f14747b;
    }

    public void f() {
        b1.j g10 = this.f14746a.g();
        b1.f.b(g10.h(), g10.n(), g10.m());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f14746a.h()) {
                throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.f14746a));
            }
            if (a()) {
                g.a(this.f14746a.g().g(), RescheduleReceiver.class, true);
                f();
            }
            this.f14747b.a(a1.n.f124a);
        } catch (Throwable th) {
            this.f14747b.a(new n.b.a(th));
        }
    }
}
