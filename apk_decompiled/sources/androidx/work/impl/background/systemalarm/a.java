package androidx.work.impl.background.systemalarm;

import a1.k;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.d;
import j1.p;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a implements b1.b {

    /* renamed from: d, reason: collision with root package name */
    public static final String f3677d = k.f("CommandHandler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f3678a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f3679b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Object f3680c = new Object();

    public a(Context context) {
        this.f3678a = context;
    }

    public static Intent a(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    public static Intent b(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent d(Context context, String str, boolean z10) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z10);
        return intent;
    }

    public static Intent e(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    public static Intent f(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent g(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static boolean n(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    @Override // b1.b
    public void c(String str, boolean z10) {
        synchronized (this.f3680c) {
            b1.b bVar = (b1.b) this.f3679b.remove(str);
            if (bVar != null) {
                bVar.c(str, z10);
            }
        }
    }

    public final void h(Intent intent, int i10, d dVar) {
        k.c().a(f3677d, String.format("Handling constraints changed %s", intent), new Throwable[0]);
        new b(this.f3678a, i10, dVar).a();
    }

    public final void i(Intent intent, int i10, d dVar) {
        Bundle extras = intent.getExtras();
        synchronized (this.f3680c) {
            String string = extras.getString("KEY_WORKSPEC_ID");
            k c10 = k.c();
            String str = f3677d;
            c10.a(str, String.format("Handing delay met for %s", string), new Throwable[0]);
            if (this.f3679b.containsKey(string)) {
                k.c().a(str, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", string), new Throwable[0]);
            } else {
                c cVar = new c(this.f3678a, i10, string, dVar);
                this.f3679b.put(string, cVar);
                cVar.f();
            }
        }
    }

    public final void j(Intent intent, int i10) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z10 = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        k.c().a(f3677d, String.format("Handling onExecutionCompleted %s, %s", intent, Integer.valueOf(i10)), new Throwable[0]);
        c(string, z10);
    }

    public final void k(Intent intent, int i10, d dVar) {
        k.c().a(f3677d, String.format("Handling reschedule %s, %s", intent, Integer.valueOf(i10)), new Throwable[0]);
        dVar.g().r();
    }

    public final void l(Intent intent, int i10, d dVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        k c10 = k.c();
        String str = f3677d;
        c10.a(str, String.format("Handling schedule work for %s", string), new Throwable[0]);
        WorkDatabase n10 = dVar.g().n();
        n10.c();
        try {
            p h10 = n10.B().h(string);
            if (h10 == null) {
                k.c().h(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
                return;
            }
            if (h10.f14584b.a()) {
                k.c().h(str, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                return;
            }
            long a10 = h10.a();
            if (h10.b()) {
                k.c().a(str, String.format("Opportunistically setting an alarm for %s at %s", string, Long.valueOf(a10)), new Throwable[0]);
                d1.a.c(this.f3678a, dVar.g(), string, a10);
                dVar.k(new d.b(dVar, a(this.f3678a), i10));
            } else {
                k.c().a(str, String.format("Setting up Alarms for %s at %s", string, Long.valueOf(a10)), new Throwable[0]);
                d1.a.c(this.f3678a, dVar.g(), string, a10);
            }
            n10.r();
        } finally {
            n10.g();
        }
    }

    public final void m(Intent intent, d dVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        k.c().a(f3677d, String.format("Handing stopWork work for %s", string), new Throwable[0]);
        dVar.g().w(string);
        d1.a.a(this.f3678a, dVar.g(), string);
        dVar.c(string, false);
    }

    public boolean o() {
        boolean z10;
        synchronized (this.f3680c) {
            z10 = !this.f3679b.isEmpty();
        }
        return z10;
    }

    public void p(Intent intent, int i10, d dVar) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            h(intent, i10, dVar);
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            k(intent, i10, dVar);
            return;
        }
        if (!n(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            k.c().b(f3677d, String.format("Invalid request for %s, requires %s.", action, "KEY_WORKSPEC_ID"), new Throwable[0]);
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            l(intent, i10, dVar);
            return;
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            i(intent, i10, dVar);
            return;
        }
        if ("ACTION_STOP_WORK".equals(action)) {
            m(intent, dVar);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            j(intent, i10);
        } else {
            k.c().h(f3677d, String.format("Ignoring intent %s", intent), new Throwable[0]);
        }
    }
}
