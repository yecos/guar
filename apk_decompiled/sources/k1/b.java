package k1;

import a1.n;
import android.text.TextUtils;
import androidx.work.b;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.workers.ConstraintTrackingWorker;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(b1.j r19, java.util.List r20, java.lang.String[] r21, java.lang.String r22, a1.d r23) {
        /*
            Method dump skipped, instructions count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.b.c(b1.j, java.util.List, java.lang.String[], java.lang.String, a1.d):boolean");
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
