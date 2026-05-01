package b1;

import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import e1.f0;
import j1.p;
import j1.q;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4401a = a1.k.f("Schedulers");

    public static e a(Context context, j jVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            f0 f0Var = new f0(context, jVar);
            k1.g.a(context, SystemJobService.class, true);
            a1.k.c().a(f4401a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            return f0Var;
        }
        e c10 = c(context);
        if (c10 != null) {
            return c10;
        }
        d1.b bVar = new d1.b(context);
        k1.g.a(context, SystemAlarmService.class, true);
        a1.k.c().a(f4401a, "Created SystemAlarmScheduler", new Throwable[0]);
        return bVar;
    }

    public static void b(androidx.work.a aVar, WorkDatabase workDatabase, List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        q B = workDatabase.B();
        workDatabase.c();
        try {
            List n10 = B.n(aVar.h());
            List j10 = B.j(200);
            if (n10 != null && n10.size() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                Iterator it = n10.iterator();
                while (it.hasNext()) {
                    B.l(((p) it.next()).f14583a, currentTimeMillis);
                }
            }
            workDatabase.r();
            if (n10 != null && n10.size() > 0) {
                p[] pVarArr = (p[]) n10.toArray(new p[n10.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    e eVar = (e) it2.next();
                    if (eVar.a()) {
                        eVar.e(pVarArr);
                    }
                }
            }
            if (j10 == null || j10.size() <= 0) {
                return;
            }
            p[] pVarArr2 = (p[]) j10.toArray(new p[j10.size()]);
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                e eVar2 = (e) it3.next();
                if (!eVar2.a()) {
                    eVar2.e(pVarArr2);
                }
            }
        } finally {
            workDatabase.g();
        }
    }

    public static e c(Context context) {
        try {
            e eVar = (e) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class).newInstance(context);
            a1.k.c().a(f4401a, String.format("Created %s", "androidx.work.impl.background.gcm.GcmScheduler"), new Throwable[0]);
            return eVar;
        } catch (Throwable th) {
            a1.k.c().a(f4401a, "Unable to create GCM Scheduler", th);
            return null;
        }
    }
}
