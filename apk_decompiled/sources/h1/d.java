package h1;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: f, reason: collision with root package name */
    public static final String f14096f = a1.k.f("ConstraintTracker");

    /* renamed from: a, reason: collision with root package name */
    public final m1.a f14097a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f14098b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14099c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final Set f14100d = new LinkedHashSet();

    /* renamed from: e, reason: collision with root package name */
    public Object f14101e;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f14102a;

        public a(List list) {
            this.f14102a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f14102a.iterator();
            while (it.hasNext()) {
                ((f1.a) it.next()).a(d.this.f14101e);
            }
        }
    }

    public d(Context context, m1.a aVar) {
        this.f14098b = context.getApplicationContext();
        this.f14097a = aVar;
    }

    public void a(f1.a aVar) {
        synchronized (this.f14099c) {
            if (this.f14100d.add(aVar)) {
                if (this.f14100d.size() == 1) {
                    this.f14101e = b();
                    a1.k.c().a(f14096f, String.format("%s: initial state = %s", getClass().getSimpleName(), this.f14101e), new Throwable[0]);
                    e();
                }
                aVar.a(this.f14101e);
            }
        }
    }

    public abstract Object b();

    public void c(f1.a aVar) {
        synchronized (this.f14099c) {
            if (this.f14100d.remove(aVar) && this.f14100d.isEmpty()) {
                f();
            }
        }
    }

    public void d(Object obj) {
        synchronized (this.f14099c) {
            Object obj2 = this.f14101e;
            if (obj2 != obj && (obj2 == null || !obj2.equals(obj))) {
                this.f14101e = obj;
                this.f14097a.a().execute(new a(new ArrayList(this.f14100d)));
            }
        }
    }

    public abstract void e();

    public abstract void f();
}
