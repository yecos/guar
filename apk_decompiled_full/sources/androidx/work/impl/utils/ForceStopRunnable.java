package androidx.work.impl.utils;

import a1.k;
import a1.s;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import b1.f;
import b1.h;
import b1.j;
import e1.f0;
import j1.n;
import j1.p;
import j1.q;
import java.util.List;
import java.util.concurrent.TimeUnit;
import k1.d;
import x.a;

/* loaded from: classes.dex */
public class ForceStopRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    public static final String f3745d = k.f("ForceStopRunnable");

    /* renamed from: e, reason: collision with root package name */
    public static final long f3746e = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: a, reason: collision with root package name */
    public final Context f3747a;

    /* renamed from: b, reason: collision with root package name */
    public final j f3748b;

    /* renamed from: c, reason: collision with root package name */
    public int f3749c = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public static final String f3750a = k.f("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                return;
            }
            k.c().g(f3750a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
            ForceStopRunnable.g(context);
        }
    }

    public ForceStopRunnable(Context context, j jVar) {
        this.f3747a = context.getApplicationContext();
        this.f3748b = jVar;
    }

    public static Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    public static PendingIntent d(Context context, int i10) {
        return PendingIntent.getBroadcast(context, -1, c(context), i10);
    }

    public static void g(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent d10 = d(context, a.c() ? 167772160 : 134217728);
        long currentTimeMillis = System.currentTimeMillis() + f3746e;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, d10);
        }
    }

    public boolean a() {
        boolean h10 = Build.VERSION.SDK_INT >= 23 ? f0.h(this.f3747a, this.f3748b) : false;
        WorkDatabase n10 = this.f3748b.n();
        q B = n10.B();
        n A = n10.A();
        n10.c();
        try {
            List<p> p10 = B.p();
            boolean z10 = (p10 == null || p10.isEmpty()) ? false : true;
            if (z10) {
                for (p pVar : p10) {
                    B.d(s.ENQUEUED, pVar.f14583a);
                    B.l(pVar.f14583a, -1L);
                }
            }
            A.b();
            n10.r();
            return z10 || h10;
        } finally {
            n10.g();
        }
    }

    public void b() {
        boolean a10 = a();
        if (h()) {
            k.c().a(f3745d, "Rescheduling Workers.", new Throwable[0]);
            this.f3748b.r();
            this.f3748b.k().c(false);
        } else if (e()) {
            k.c().a(f3745d, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.f3748b.r();
        } else if (a10) {
            k.c().a(f3745d, "Found unfinished work, scheduling it.", new Throwable[0]);
            f.b(this.f3748b.h(), this.f3748b.n(), this.f3748b.m());
        }
    }

    public boolean e() {
        List historicalProcessExitReasons;
        int reason;
        try {
            PendingIntent d10 = d(this.f3747a, a.c() ? 570425344 : 536870912);
            if (Build.VERSION.SDK_INT >= 30) {
                if (d10 != null) {
                    d10.cancel();
                }
                historicalProcessExitReasons = ((ActivityManager) this.f3747a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    for (int i10 = 0; i10 < historicalProcessExitReasons.size(); i10++) {
                        reason = d.a(historicalProcessExitReasons.get(i10)).getReason();
                        if (reason == 10) {
                            return true;
                        }
                    }
                }
            } else if (d10 == null) {
                g(this.f3747a);
                return true;
            }
            return false;
        } catch (IllegalArgumentException | SecurityException e10) {
            k.c().h(f3745d, "Ignoring exception", e10);
            return true;
        }
    }

    public boolean f() {
        androidx.work.a h10 = this.f3748b.h();
        if (TextUtils.isEmpty(h10.c())) {
            k.c().a(f3745d, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean b10 = k1.j.b(this.f3747a, h10);
        k.c().a(f3745d, String.format("Is default app process = %s", Boolean.valueOf(b10)), new Throwable[0]);
        return b10;
    }

    public boolean h() {
        return this.f3748b.k().a();
    }

    public void i(long j10) {
        try {
            Thread.sleep(j10);
        } catch (InterruptedException unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i10;
        try {
            if (!f()) {
                return;
            }
            while (true) {
                h.e(this.f3747a);
                k.c().a(f3745d, "Performing cleanup operations.", new Throwable[0]);
                try {
                    b();
                    return;
                } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e10) {
                    i10 = this.f3749c + 1;
                    this.f3749c = i10;
                    if (i10 >= 3) {
                        k.c().b(f3745d, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e10);
                        IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e10);
                        this.f3748b.h().d();
                        throw illegalStateException;
                    }
                    k.c().a(f3745d, String.format("Retrying after %s", Long.valueOf(i10 * 300)), e10);
                    i(this.f3749c * 300);
                }
                k.c().a(f3745d, String.format("Retrying after %s", Long.valueOf(i10 * 300)), e10);
                i(this.f3749c * 300);
            }
        } finally {
            this.f3748b.q();
        }
    }
}
