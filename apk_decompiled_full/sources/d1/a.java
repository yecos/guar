package d1;

import a1.k;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import b1.j;
import j1.g;
import j1.h;
import k1.f;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12464a = k.f("Alarms");

    public static void a(Context context, j jVar, String str) {
        h y10 = jVar.n().y();
        g b10 = y10.b(str);
        if (b10 != null) {
            b(context, str, b10.f14563b);
            k.c().a(f12464a, String.format("Removing SystemIdInfo for workSpecId (%s)", str), new Throwable[0]);
            y10.d(str);
        }
    }

    public static void b(Context context, String str, int i10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i10, androidx.work.impl.background.systemalarm.a.b(context, str), Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912);
        if (service == null || alarmManager == null) {
            return;
        }
        k.c().a(f12464a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", str, Integer.valueOf(i10)), new Throwable[0]);
        alarmManager.cancel(service);
    }

    public static void c(Context context, j jVar, String str, long j10) {
        WorkDatabase n10 = jVar.n();
        h y10 = n10.y();
        g b10 = y10.b(str);
        if (b10 != null) {
            b(context, str, b10.f14563b);
            d(context, str, b10.f14563b, j10);
        } else {
            int b11 = new f(n10).b();
            y10.a(new g(str, b11));
            d(context, str, b11, j10);
        }
    }

    public static void d(Context context, String str, int i10, long j10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i10, androidx.work.impl.background.systemalarm.a.b(context, str), Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728);
        if (alarmManager != null) {
            alarmManager.setExact(0, j10, service);
        }
    }
}
