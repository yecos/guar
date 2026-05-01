package androidx.work.impl.foreground;

import a1.e;
import a1.k;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import b1.j;
import f1.c;
import f1.d;
import j1.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public class a implements c, b1.b {

    /* renamed from: k, reason: collision with root package name */
    public static final String f3731k = k.f("SystemFgDispatcher");

    /* renamed from: a, reason: collision with root package name */
    public Context f3732a;

    /* renamed from: b, reason: collision with root package name */
    public j f3733b;

    /* renamed from: c, reason: collision with root package name */
    public final m1.a f3734c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f3735d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public String f3736e;

    /* renamed from: f, reason: collision with root package name */
    public final Map f3737f;

    /* renamed from: g, reason: collision with root package name */
    public final Map f3738g;

    /* renamed from: h, reason: collision with root package name */
    public final Set f3739h;

    /* renamed from: i, reason: collision with root package name */
    public final d f3740i;

    /* renamed from: j, reason: collision with root package name */
    public b f3741j;

    /* renamed from: androidx.work.impl.foreground.a$a, reason: collision with other inner class name */
    public class RunnableC0062a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WorkDatabase f3742a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f3743b;

        public RunnableC0062a(WorkDatabase workDatabase, String str) {
            this.f3742a = workDatabase;
            this.f3743b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            p h10 = this.f3742a.B().h(this.f3743b);
            if (h10 == null || !h10.b()) {
                return;
            }
            synchronized (a.this.f3735d) {
                a.this.f3738g.put(this.f3743b, h10);
                a.this.f3739h.add(h10);
                a aVar = a.this;
                aVar.f3740i.d(aVar.f3739h);
            }
        }
    }

    public interface b {
        void a(int i10, Notification notification);

        void c(int i10, int i11, Notification notification);

        void d(int i10);

        void stop();
    }

    public a(Context context) {
        this.f3732a = context;
        j j10 = j.j(context);
        this.f3733b = j10;
        m1.a o10 = j10.o();
        this.f3734c = o10;
        this.f3736e = null;
        this.f3737f = new LinkedHashMap();
        this.f3739h = new HashSet();
        this.f3738g = new HashMap();
        this.f3740i = new d(this.f3732a, o10, this);
        this.f3733b.l().d(this);
    }

    public static Intent a(Context context, String str, e eVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", eVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", eVar.a());
        intent.putExtra("KEY_NOTIFICATION", eVar.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent e(Context context, String str, e eVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", eVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", eVar.a());
        intent.putExtra("KEY_NOTIFICATION", eVar.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent f(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    @Override // f1.c
    public void b(List list) {
        if (list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            k.c().a(f3731k, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
            this.f3733b.v(str);
        }
    }

    @Override // b1.b
    public void c(String str, boolean z10) {
        Map.Entry entry;
        synchronized (this.f3735d) {
            p pVar = (p) this.f3738g.remove(str);
            if (pVar != null ? this.f3739h.remove(pVar) : false) {
                this.f3740i.d(this.f3739h);
            }
        }
        e eVar = (e) this.f3737f.remove(str);
        if (str.equals(this.f3736e) && this.f3737f.size() > 0) {
            Iterator it = this.f3737f.entrySet().iterator();
            Object next = it.next();
            while (true) {
                entry = (Map.Entry) next;
                if (!it.hasNext()) {
                    break;
                } else {
                    next = it.next();
                }
            }
            this.f3736e = (String) entry.getKey();
            if (this.f3741j != null) {
                e eVar2 = (e) entry.getValue();
                this.f3741j.c(eVar2.c(), eVar2.a(), eVar2.b());
                this.f3741j.d(eVar2.c());
            }
        }
        b bVar = this.f3741j;
        if (eVar == null || bVar == null) {
            return;
        }
        k.c().a(f3731k, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(eVar.c()), str, Integer.valueOf(eVar.a())), new Throwable[0]);
        bVar.d(eVar.c());
    }

    @Override // f1.c
    public void d(List list) {
    }

    public final void g(Intent intent) {
        k.c().d(f3731k, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.f3733b.e(UUID.fromString(stringExtra));
    }

    public final void h(Intent intent) {
        int i10 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        k.c().a(f3731k, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (notification == null || this.f3741j == null) {
            return;
        }
        this.f3737f.put(stringExtra, new e(intExtra, notification, intExtra2));
        if (TextUtils.isEmpty(this.f3736e)) {
            this.f3736e = stringExtra;
            this.f3741j.c(intExtra, intExtra2, notification);
            return;
        }
        this.f3741j.a(intExtra, notification);
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator it = this.f3737f.entrySet().iterator();
        while (it.hasNext()) {
            i10 |= ((e) ((Map.Entry) it.next()).getValue()).a();
        }
        e eVar = (e) this.f3737f.get(this.f3736e);
        if (eVar != null) {
            this.f3741j.c(eVar.c(), i10, eVar.b());
        }
    }

    public final void i(Intent intent) {
        k.c().d(f3731k, String.format("Started foreground service %s", intent), new Throwable[0]);
        this.f3734c.b(new RunnableC0062a(this.f3733b.n(), intent.getStringExtra("KEY_WORKSPEC_ID")));
    }

    public void j(Intent intent) {
        k.c().d(f3731k, "Stopping foreground service", new Throwable[0]);
        b bVar = this.f3741j;
        if (bVar != null) {
            bVar.stop();
        }
    }

    public void k() {
        this.f3741j = null;
        synchronized (this.f3735d) {
            this.f3740i.e();
        }
        this.f3733b.l().i(this);
    }

    public void l(Intent intent) {
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            i(intent);
            h(intent);
        } else if ("ACTION_NOTIFY".equals(action)) {
            h(intent);
        } else if ("ACTION_CANCEL_WORK".equals(action)) {
            g(intent);
        } else if ("ACTION_STOP_FOREGROUND".equals(action)) {
            j(intent);
        }
    }

    public void m(b bVar) {
        if (this.f3741j != null) {
            k.c().b(f3731k, "A callback already exists.", new Throwable[0]);
        } else {
            this.f3741j = bVar;
        }
    }
}
