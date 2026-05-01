package androidx.work.impl;

import android.content.Context;
import androidx.work.impl.a;
import b1.h;
import j1.k;
import j1.n;
import j1.q;
import j1.t;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import q0.e;
import t0.c;
import u0.d;

/* loaded from: classes.dex */
public abstract class WorkDatabase extends e {

    /* renamed from: l, reason: collision with root package name */
    public static final long f3648l = TimeUnit.DAYS.toMillis(1);

    public class a implements c.InterfaceC0321c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f3649a;

        public a(Context context) {
            this.f3649a = context;
        }

        @Override // t0.c.InterfaceC0321c
        public c a(c.b bVar) {
            c.b.a a10 = c.b.a(this.f3649a);
            a10.c(bVar.f18791b).b(bVar.f18792c).d(true);
            return new d().a(a10.a());
        }
    }

    public class b extends e.b {
        @Override // q0.e.b
        public void c(t0.b bVar) {
            super.c(bVar);
            bVar.beginTransaction();
            try {
                bVar.execSQL(WorkDatabase.w());
                bVar.setTransactionSuccessful();
            } finally {
                bVar.endTransaction();
            }
        }
    }

    public static WorkDatabase s(Context context, Executor executor, boolean z10) {
        e.a a10;
        if (z10) {
            a10 = q0.d.c(context, WorkDatabase.class).c();
        } else {
            a10 = q0.d.a(context, WorkDatabase.class, h.d());
            a10.f(new a(context));
        }
        return (WorkDatabase) a10.g(executor).a(u()).b(androidx.work.impl.a.f3658a).b(new a.h(context, 2, 3)).b(androidx.work.impl.a.f3659b).b(androidx.work.impl.a.f3660c).b(new a.h(context, 5, 6)).b(androidx.work.impl.a.f3661d).b(androidx.work.impl.a.f3662e).b(androidx.work.impl.a.f3663f).b(new a.i(context)).b(new a.h(context, 10, 11)).b(androidx.work.impl.a.f3664g).e().d();
    }

    public static e.b u() {
        return new b();
    }

    public static long v() {
        return System.currentTimeMillis() - f3648l;
    }

    public static String w() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + v() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }

    public abstract n A();

    public abstract q B();

    public abstract t C();

    public abstract j1.b t();

    public abstract j1.e x();

    public abstract j1.h y();

    public abstract k z();
}
