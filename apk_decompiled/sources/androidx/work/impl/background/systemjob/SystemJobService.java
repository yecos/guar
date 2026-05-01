package androidx.work.impl.background.systemjob;

import a1.k;
import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.WorkerParameters;
import b1.b;
import b1.j;
import e1.g0;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SystemJobService extends JobService implements b {

    /* renamed from: c, reason: collision with root package name */
    public static final String f3712c = k.f("SystemJobService");

    /* renamed from: a, reason: collision with root package name */
    public j f3713a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f3714b = new HashMap();

    public static String a(JobParameters jobParameters) {
        PersistableBundle extras;
        boolean containsKey;
        String string;
        try {
            extras = jobParameters.getExtras();
            if (extras == null) {
                return null;
            }
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

    @Override // b1.b
    public void c(String str, boolean z10) {
        JobParameters a10;
        k.c().a(f3712c, String.format("%s executed on JobScheduler", str), new Throwable[0]);
        synchronized (this.f3714b) {
            a10 = g0.a(this.f3714b.remove(str));
        }
        if (a10 != null) {
            jobFinished(a10, z10);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        Application application;
        Context applicationContext;
        super.onCreate();
        try {
            applicationContext = getApplicationContext();
            j j10 = j.j(applicationContext);
            this.f3713a = j10;
            j10.l().d(this);
        } catch (IllegalStateException unused) {
            application = getApplication();
            if (!Application.class.equals(application.getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
            }
            k.c().h(f3712c, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        j jVar = this.f3713a;
        if (jVar != null) {
            jVar.l().i(this);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        WorkerParameters.a aVar;
        Uri[] triggeredContentUris;
        String[] triggeredContentAuthorities;
        Network network;
        String[] triggeredContentAuthorities2;
        Uri[] triggeredContentUris2;
        if (this.f3713a == null) {
            k.c().a(f3712c, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(jobParameters, true);
            return false;
        }
        String a10 = a(jobParameters);
        if (TextUtils.isEmpty(a10)) {
            k.c().b(f3712c, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.f3714b) {
            if (this.f3714b.containsKey(a10)) {
                k.c().a(f3712c, String.format("Job is already being executed by SystemJobService: %s", a10), new Throwable[0]);
                return false;
            }
            k.c().a(f3712c, String.format("onStartJob for %s", a10), new Throwable[0]);
            this.f3714b.put(a10, jobParameters);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 24) {
                aVar = new WorkerParameters.a();
                triggeredContentUris = jobParameters.getTriggeredContentUris();
                if (triggeredContentUris != null) {
                    triggeredContentUris2 = jobParameters.getTriggeredContentUris();
                    aVar.f3618b = Arrays.asList(triggeredContentUris2);
                }
                triggeredContentAuthorities = jobParameters.getTriggeredContentAuthorities();
                if (triggeredContentAuthorities != null) {
                    triggeredContentAuthorities2 = jobParameters.getTriggeredContentAuthorities();
                    aVar.f3617a = Arrays.asList(triggeredContentAuthorities2);
                }
                if (i10 >= 28) {
                    network = jobParameters.getNetwork();
                    aVar.f3619c = network;
                }
            } else {
                aVar = null;
            }
            this.f3713a.u(a10, aVar);
            return true;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        if (this.f3713a == null) {
            k.c().a(f3712c, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String a10 = a(jobParameters);
        if (TextUtils.isEmpty(a10)) {
            k.c().b(f3712c, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        k.c().a(f3712c, String.format("onStopJob for %s", a10), new Throwable[0]);
        synchronized (this.f3714b) {
            this.f3714b.remove(a10);
        }
        this.f3713a.w(a10);
        return !this.f3713a.l().f(a10);
    }
}
