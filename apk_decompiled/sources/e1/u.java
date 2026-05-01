package e1;

import a1.c;
import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.Iterator;

/* loaded from: classes.dex */
public class u {

    /* renamed from: b, reason: collision with root package name */
    public static final String f12850b = a1.k.f("SystemJobInfoConverter");

    /* renamed from: a, reason: collision with root package name */
    public final ComponentName f12851a;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12852a;

        static {
            int[] iArr = new int[a1.l.values().length];
            f12852a = iArr;
            try {
                iArr[a1.l.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12852a[a1.l.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12852a[a1.l.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12852a[a1.l.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12852a[a1.l.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public u(Context context) {
        this.f12851a = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }

    public static JobInfo.TriggerContentUri b(c.a aVar) {
        return new JobInfo.TriggerContentUri(aVar.a(), aVar.b() ? 1 : 0);
    }

    public static int c(a1.l lVar) {
        int i10 = a.f12852a[lVar.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 != 4) {
            if (i10 == 5 && Build.VERSION.SDK_INT >= 26) {
                return 4;
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            return 3;
        }
        a1.k.c().a(f12850b, String.format("API version too low. Cannot convert network type value %s", lVar), new Throwable[0]);
        return 1;
    }

    public static void d(JobInfo.Builder builder, a1.l lVar) {
        NetworkRequest.Builder addCapability;
        NetworkRequest build;
        if (Build.VERSION.SDK_INT < 30 || lVar != a1.l.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetworkType(c(lVar));
            return;
        }
        addCapability = new NetworkRequest.Builder().addCapability(25);
        build = addCapability.build();
        builder.setRequiredNetwork(build);
    }

    public JobInfo a(j1.p pVar, int i10) {
        JobInfo.Builder requiresCharging;
        JobInfo.Builder requiresDeviceIdle;
        JobInfo.Builder extras;
        JobInfo build;
        a1.b bVar = pVar.f14592j;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", pVar.f14583a);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", pVar.d());
        requiresCharging = new JobInfo.Builder(i10, this.f12851a).setRequiresCharging(bVar.g());
        requiresDeviceIdle = requiresCharging.setRequiresDeviceIdle(bVar.h());
        extras = requiresDeviceIdle.setExtras(persistableBundle);
        d(extras, bVar.b());
        if (!bVar.h()) {
            extras.setBackoffCriteria(pVar.f14595m, pVar.f14594l == a1.a.LINEAR ? 0 : 1);
        }
        long max = Math.max(pVar.a() - System.currentTimeMillis(), 0L);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 <= 28) {
            extras.setMinimumLatency(max);
        } else if (max > 0) {
            extras.setMinimumLatency(max);
        } else if (!pVar.f14599q) {
            extras.setImportantWhileForeground(true);
        }
        if (i11 >= 24 && bVar.e()) {
            Iterator it = bVar.a().b().iterator();
            while (it.hasNext()) {
                extras.addTriggerContentUri(b((c.a) it.next()));
            }
            extras.setTriggerContentUpdateDelay(bVar.c());
            extras.setTriggerContentMaxDelay(bVar.d());
        }
        extras.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            extras.setRequiresBatteryNotLow(bVar.f());
            extras.setRequiresStorageNotLow(bVar.i());
        }
        boolean z10 = pVar.f14593k > 0;
        if (x.a.c() && pVar.f14599q && !z10) {
            extras.setExpedited(true);
        }
        build = extras.build();
        return build;
    }
}
