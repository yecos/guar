package e1;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class f0 implements b1.e {

    /* renamed from: e, reason: collision with root package name */
    public static final String f12845e = a1.k.f("SystemJobScheduler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f12846a;

    /* renamed from: b, reason: collision with root package name */
    public final JobScheduler f12847b;

    /* renamed from: c, reason: collision with root package name */
    public final b1.j f12848c;

    /* renamed from: d, reason: collision with root package name */
    public final u f12849d;

    public f0(Context context, b1.j jVar) {
        this(context, jVar, v.a(context.getSystemService("jobscheduler")), new u(context));
    }

    public static void b(Context context) {
        List f10;
        int id;
        JobScheduler a10 = v.a(context.getSystemService("jobscheduler"));
        if (a10 == null || (f10 = f(context, a10)) == null || f10.isEmpty()) {
            return;
        }
        Iterator it = f10.iterator();
        while (it.hasNext()) {
            id = w.a(it.next()).getId();
            c(a10, id);
        }
    }

    public static void c(JobScheduler jobScheduler, int i10) {
        try {
            jobScheduler.cancel(i10);
        } catch (Throwable th) {
            a1.k.c().b(f12845e, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i10)), th);
        }
    }

    public static List d(Context context, JobScheduler jobScheduler, String str) {
        int id;
        List f10 = f(context, jobScheduler);
        if (f10 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        Iterator it = f10.iterator();
        while (it.hasNext()) {
            JobInfo a10 = w.a(it.next());
            if (str.equals(g(a10))) {
                id = a10.getId();
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    public static List f(Context context, JobScheduler jobScheduler) {
        List list;
        ComponentName service;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            a1.k.c().b(f12845e, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            JobInfo a10 = w.a(it.next());
            service = a10.getService();
            if (componentName.equals(service)) {
                arrayList.add(a10);
            }
        }
        return arrayList;
    }

    public static String g(JobInfo jobInfo) {
        PersistableBundle extras;
        boolean containsKey;
        String string;
        extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            containsKey = extras.containsKey("EXTRA_WORK_SPEC_ID");
            if (!containsKey) {
                return null;
            }
            string = extras.getString("EXTRA_WORK_SPEC_ID");
            return string;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean h(Context context, b1.j jVar) {
        int id;
        JobScheduler a10 = v.a(context.getSystemService("jobscheduler"));
        List f10 = f(context, a10);
        List c10 = jVar.n().y().c();
        boolean z10 = false;
        HashSet hashSet = new HashSet(f10 != null ? f10.size() : 0);
        if (f10 != null && !f10.isEmpty()) {
            Iterator it = f10.iterator();
            while (it.hasNext()) {
                JobInfo a11 = w.a(it.next());
                String g10 = g(a11);
                if (TextUtils.isEmpty(g10)) {
                    id = a11.getId();
                    c(a10, id);
                } else {
                    hashSet.add(g10);
                }
            }
        }
        Iterator it2 = c10.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            if (!hashSet.contains((String) it2.next())) {
                a1.k.c().a(f12845e, "Reconciling jobs", new Throwable[0]);
                z10 = true;
                break;
            }
        }
        if (z10) {
            WorkDatabase n10 = jVar.n();
            n10.c();
            try {
                j1.q B = n10.B();
                Iterator it3 = c10.iterator();
                while (it3.hasNext()) {
                    B.l((String) it3.next(), -1L);
                }
                n10.r();
            } finally {
                n10.g();
            }
        }
        return z10;
    }

    @Override // b1.e
    public boolean a() {
        return true;
    }

    @Override // b1.e
    public void cancel(String str) {
        List d10 = d(this.f12846a, this.f12847b, str);
        if (d10 == null || d10.isEmpty()) {
            return;
        }
        Iterator it = d10.iterator();
        while (it.hasNext()) {
            c(this.f12847b, ((Integer) it.next()).intValue());
        }
        this.f12848c.n().y().d(str);
    }

    @Override // b1.e
    public void e(j1.p... pVarArr) {
        List d10;
        WorkDatabase n10 = this.f12848c.n();
        k1.f fVar = new k1.f(n10);
        for (j1.p pVar : pVarArr) {
            n10.c();
            try {
                j1.p h10 = n10.B().h(pVar.f14583a);
                if (h10 == null) {
                    a1.k.c().h(f12845e, "Skipping scheduling " + pVar.f14583a + " because it's no longer in the DB", new Throwable[0]);
                    n10.r();
                } else if (h10.f14584b != a1.s.ENQUEUED) {
                    a1.k.c().h(f12845e, "Skipping scheduling " + pVar.f14583a + " because it is no longer enqueued", new Throwable[0]);
                    n10.r();
                } else {
                    j1.g b10 = n10.y().b(pVar.f14583a);
                    int d11 = b10 != null ? b10.f14563b : fVar.d(this.f12848c.h().i(), this.f12848c.h().g());
                    if (b10 == null) {
                        this.f12848c.n().y().a(new j1.g(pVar.f14583a, d11));
                    }
                    i(pVar, d11);
                    if (Build.VERSION.SDK_INT == 23 && (d10 = d(this.f12846a, this.f12847b, pVar.f14583a)) != null) {
                        int indexOf = d10.indexOf(Integer.valueOf(d11));
                        if (indexOf >= 0) {
                            d10.remove(indexOf);
                        }
                        i(pVar, !d10.isEmpty() ? ((Integer) d10.get(0)).intValue() : fVar.d(this.f12848c.h().i(), this.f12848c.h().g()));
                    }
                    n10.r();
                }
                n10.g();
            } catch (Throwable th) {
                n10.g();
                throw th;
            }
        }
    }

    public void i(j1.p pVar, int i10) {
        int schedule;
        JobInfo a10 = this.f12849d.a(pVar, i10);
        a1.k c10 = a1.k.c();
        String str = f12845e;
        c10.a(str, String.format("Scheduling work ID %s Job ID %s", pVar.f14583a, Integer.valueOf(i10)), new Throwable[0]);
        try {
            schedule = this.f12847b.schedule(a10);
            if (schedule == 0) {
                a1.k.c().h(str, String.format("Unable to schedule work ID %s", pVar.f14583a), new Throwable[0]);
                if (pVar.f14599q && pVar.f14600r == a1.o.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    pVar.f14599q = false;
                    a1.k.c().a(str, String.format("Scheduling a non-expedited job (work ID %s)", pVar.f14583a), new Throwable[0]);
                    i(pVar, i10);
                }
            }
        } catch (IllegalStateException e10) {
            List f10 = f(this.f12846a, this.f12847b);
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(f10 != null ? f10.size() : 0), Integer.valueOf(this.f12848c.n().B().c().size()), Integer.valueOf(this.f12848c.h().h()));
            a1.k.c().b(f12845e, format, new Throwable[0]);
            throw new IllegalStateException(format, e10);
        } catch (Throwable th) {
            a1.k.c().b(f12845e, String.format("Unable to schedule %s", pVar), th);
        }
    }

    public f0(Context context, b1.j jVar, JobScheduler jobScheduler, u uVar) {
        this.f12846a = context;
        this.f12848c = jVar;
        this.f12847b = jobScheduler;
        this.f12849d = uVar;
    }
}
