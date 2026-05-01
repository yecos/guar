package r4;

import android.content.Context;
import com.ixuea.android.downloader.db.DefaultDownloadDBController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import s4.c;
import u4.c;

/* loaded from: classes3.dex */
public final class a implements c, c.a {

    /* renamed from: g, reason: collision with root package name */
    public static a f18508g;

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f18509a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f18510b;

    /* renamed from: c, reason: collision with root package name */
    public final List f18511c;

    /* renamed from: d, reason: collision with root package name */
    public final u4.a f18512d;

    /* renamed from: e, reason: collision with root package name */
    public final x4.b f18513e;

    /* renamed from: f, reason: collision with root package name */
    public final t4.a f18514f;

    public a(Context context, t4.a aVar) {
        if (aVar == null) {
            this.f18514f = new t4.a();
        } else {
            this.f18514f = aVar;
        }
        if (this.f18514f.d() == null) {
            this.f18513e = new DefaultDownloadDBController(context, this.f18514f);
        } else {
            this.f18513e = this.f18514f.d();
        }
        if (this.f18513e.b() == null) {
            this.f18511c = new ArrayList();
        } else {
            this.f18511c = this.f18513e.b();
        }
        this.f18510b = new ConcurrentHashMap();
        this.f18513e.g();
        this.f18509a = Executors.newFixedThreadPool(this.f18514f.e());
        this.f18512d = new u4.b(this.f18513e);
    }

    public static s4.c f(Context context, t4.a aVar) {
        synchronized (a.class) {
            if (f18508g == null) {
                f18508g = new a(context, aVar);
            }
        }
        return f18508g;
    }

    @Override // u4.c.a
    public void a(y4.a aVar) {
        this.f18510b.remove(aVar.g());
        this.f18511c.remove(aVar);
        List e10 = aVar.e();
        if (e10 != null && e10.size() > 0) {
            Iterator it = e10.iterator();
            while (it.hasNext()) {
                this.f18513e.d((y4.b) it.next());
            }
        }
        h();
    }

    @Override // s4.c
    public void b(y4.a aVar) {
        if (!e(aVar)) {
            this.f18511c.add(aVar);
            g(aVar);
        } else if (aVar.k() == 6) {
            this.f18511c.add(aVar);
            g(aVar);
        }
    }

    @Override // s4.c
    public void c(y4.a aVar) {
        aVar.C(7);
        this.f18510b.remove(aVar.g());
        this.f18511c.remove(aVar);
        this.f18513e.a(aVar);
        this.f18512d.a(aVar);
    }

    @Override // s4.c
    public y4.a d(String str) {
        y4.a aVar;
        Iterator it = this.f18511c.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = (y4.a) it.next();
            if (aVar.g().equals(str)) {
                break;
            }
        }
        return aVar == null ? this.f18513e.c(str) : aVar;
    }

    public final boolean e(y4.a aVar) {
        return !aVar.n() && this.f18510b.containsKey(aVar.g());
    }

    public final void g(y4.a aVar) {
        if (this.f18510b.size() >= this.f18514f.e()) {
            aVar.C(3);
            this.f18512d.a(aVar);
            return;
        }
        u4.c cVar = new u4.c(this.f18509a, this.f18512d, aVar, this.f18514f, this);
        this.f18510b.put(aVar.g(), cVar);
        aVar.s(aVar.b() + 1);
        aVar.C(1);
        this.f18512d.a(aVar);
        cVar.g();
    }

    public final void h() {
        for (y4.a aVar : this.f18511c) {
            if (aVar.k() == 3) {
                g(aVar);
                return;
            }
        }
    }
}
