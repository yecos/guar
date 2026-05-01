package d1;

import a1.k;
import android.content.Context;
import b1.e;
import j1.p;

/* loaded from: classes.dex */
public class b implements e {

    /* renamed from: b, reason: collision with root package name */
    public static final String f12465b = k.f("SystemAlarmScheduler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f12466a;

    public b(Context context) {
        this.f12466a = context.getApplicationContext();
    }

    @Override // b1.e
    public boolean a() {
        return true;
    }

    public final void b(p pVar) {
        k.c().a(f12465b, String.format("Scheduling work with workSpecId %s", pVar.f14583a), new Throwable[0]);
        this.f12466a.startService(androidx.work.impl.background.systemalarm.a.f(this.f12466a, pVar.f14583a));
    }

    @Override // b1.e
    public void cancel(String str) {
        this.f12466a.startService(androidx.work.impl.background.systemalarm.a.g(this.f12466a, str));
    }

    @Override // b1.e
    public void e(p... pVarArr) {
        for (p pVar : pVarArr) {
            b(pVar);
        }
    }
}
