package b1;

import a1.k;
import a1.n;
import a1.t;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.R$bool;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.ForceStopRunnable;
import e1.f0;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import k1.l;
import k1.m;

/* loaded from: classes.dex */
public class j extends t {

    /* renamed from: j, reason: collision with root package name */
    public static final String f4414j = a1.k.f("WorkManagerImpl");

    /* renamed from: k, reason: collision with root package name */
    public static j f4415k = null;

    /* renamed from: l, reason: collision with root package name */
    public static j f4416l = null;

    /* renamed from: m, reason: collision with root package name */
    public static final Object f4417m = new Object();

    /* renamed from: a, reason: collision with root package name */
    public Context f4418a;

    /* renamed from: b, reason: collision with root package name */
    public androidx.work.a f4419b;

    /* renamed from: c, reason: collision with root package name */
    public WorkDatabase f4420c;

    /* renamed from: d, reason: collision with root package name */
    public m1.a f4421d;

    /* renamed from: e, reason: collision with root package name */
    public List f4422e;

    /* renamed from: f, reason: collision with root package name */
    public d f4423f;

    /* renamed from: g, reason: collision with root package name */
    public k1.h f4424g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4425h;

    /* renamed from: i, reason: collision with root package name */
    public BroadcastReceiver.PendingResult f4426i;

    public j(Context context, androidx.work.a aVar, m1.a aVar2) {
        this(context, aVar, aVar2, context.getResources().getBoolean(R$bool.workmanager_test_configuration));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0016, code lost:
    
        r4 = r4.getApplicationContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:
    
        if (b1.j.f4416l != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:
    
        b1.j.f4416l = new b1.j(r4, r5, new m1.b(r5.l()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        b1.j.f4415k = b1.j.f4416l;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(Context context, androidx.work.a aVar) {
        synchronized (f4417m) {
            j jVar = f4415k;
            if (jVar != null && f4416l != null) {
                throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
            }
        }
    }

    public static j i() {
        synchronized (f4417m) {
            j jVar = f4415k;
            if (jVar != null) {
                return jVar;
            }
            return f4416l;
        }
    }

    public static j j(Context context) {
        j i10;
        synchronized (f4417m) {
            i10 = i();
            if (i10 == null) {
                context.getApplicationContext();
                throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
            }
        }
        return i10;
    }

    @Override // a1.t
    public n b(List list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        return new g(this, list).a();
    }

    public n e(UUID uuid) {
        k1.a b10 = k1.a.b(uuid, this);
        this.f4421d.b(b10);
        return b10.d();
    }

    public List f(Context context, androidx.work.a aVar, m1.a aVar2) {
        return Arrays.asList(f.a(context, this), new c1.b(context, aVar, aVar2, this));
    }

    public Context g() {
        return this.f4418a;
    }

    public androidx.work.a h() {
        return this.f4419b;
    }

    public k1.h k() {
        return this.f4424g;
    }

    public d l() {
        return this.f4423f;
    }

    public List m() {
        return this.f4422e;
    }

    public WorkDatabase n() {
        return this.f4420c;
    }

    public m1.a o() {
        return this.f4421d;
    }

    public final void p(Context context, androidx.work.a aVar, m1.a aVar2, WorkDatabase workDatabase, List list, d dVar) {
        boolean isDeviceProtectedStorage;
        Context applicationContext = context.getApplicationContext();
        this.f4418a = applicationContext;
        this.f4419b = aVar;
        this.f4421d = aVar2;
        this.f4420c = workDatabase;
        this.f4422e = list;
        this.f4423f = dVar;
        this.f4424g = new k1.h(workDatabase);
        this.f4425h = false;
        if (Build.VERSION.SDK_INT >= 24) {
            isDeviceProtectedStorage = applicationContext.isDeviceProtectedStorage();
            if (isDeviceProtectedStorage) {
                throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
            }
        }
        this.f4421d.b(new ForceStopRunnable(applicationContext, this));
    }

    public void q() {
        synchronized (f4417m) {
            this.f4425h = true;
            BroadcastReceiver.PendingResult pendingResult = this.f4426i;
            if (pendingResult != null) {
                pendingResult.finish();
                this.f4426i = null;
            }
        }
    }

    public void r() {
        if (Build.VERSION.SDK_INT >= 23) {
            f0.b(g());
        }
        n().B().k();
        f.b(h(), n(), m());
    }

    public void s(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (f4417m) {
            this.f4426i = pendingResult;
            if (this.f4425h) {
                pendingResult.finish();
                this.f4426i = null;
            }
        }
    }

    public void t(String str) {
        u(str, null);
    }

    public void u(String str, WorkerParameters.a aVar) {
        this.f4421d.b(new l(this, str, aVar));
    }

    public void v(String str) {
        this.f4421d.b(new m(this, str, true));
    }

    public void w(String str) {
        this.f4421d.b(new m(this, str, false));
    }

    public j(Context context, androidx.work.a aVar, m1.a aVar2, boolean z10) {
        this(context, aVar, aVar2, WorkDatabase.s(context.getApplicationContext(), aVar2.c(), z10));
    }

    public j(Context context, androidx.work.a aVar, m1.a aVar2, WorkDatabase workDatabase) {
        Context applicationContext = context.getApplicationContext();
        a1.k.e(new k.a(aVar.j()));
        List f10 = f(applicationContext, aVar, aVar2);
        p(context, aVar, aVar2, workDatabase, f10, new d(context, aVar, aVar2, workDatabase, f10));
    }
}
