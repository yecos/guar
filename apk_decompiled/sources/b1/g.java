package b1;

import a1.n;
import a1.r;
import a1.u;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class g extends r {

    /* renamed from: j, reason: collision with root package name */
    public static final String f4402j = a1.k.f("WorkContinuationImpl");

    /* renamed from: a, reason: collision with root package name */
    public final j f4403a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4404b;

    /* renamed from: c, reason: collision with root package name */
    public final a1.d f4405c;

    /* renamed from: d, reason: collision with root package name */
    public final List f4406d;

    /* renamed from: e, reason: collision with root package name */
    public final List f4407e;

    /* renamed from: f, reason: collision with root package name */
    public final List f4408f;

    /* renamed from: g, reason: collision with root package name */
    public final List f4409g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4410h;

    /* renamed from: i, reason: collision with root package name */
    public n f4411i;

    public g(j jVar, List list) {
        this(jVar, null, a1.d.KEEP, list, null);
    }

    public static boolean i(g gVar, Set set) {
        set.addAll(gVar.c());
        Set l10 = l(gVar);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (l10.contains((String) it.next())) {
                return true;
            }
        }
        List e10 = gVar.e();
        if (e10 != null && !e10.isEmpty()) {
            Iterator it2 = e10.iterator();
            while (it2.hasNext()) {
                if (i((g) it2.next(), set)) {
                    return true;
                }
            }
        }
        set.removeAll(gVar.c());
        return false;
    }

    public static Set l(g gVar) {
        HashSet hashSet = new HashSet();
        List e10 = gVar.e();
        if (e10 != null && !e10.isEmpty()) {
            Iterator it = e10.iterator();
            while (it.hasNext()) {
                hashSet.addAll(((g) it.next()).c());
            }
        }
        return hashSet;
    }

    public n a() {
        if (this.f4410h) {
            a1.k.c().h(f4402j, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f4407e)), new Throwable[0]);
        } else {
            k1.b bVar = new k1.b(this);
            this.f4403a.o().b(bVar);
            this.f4411i = bVar.d();
        }
        return this.f4411i;
    }

    public a1.d b() {
        return this.f4405c;
    }

    public List c() {
        return this.f4407e;
    }

    public String d() {
        return this.f4404b;
    }

    public List e() {
        return this.f4409g;
    }

    public List f() {
        return this.f4406d;
    }

    public j g() {
        return this.f4403a;
    }

    public boolean h() {
        return i(this, new HashSet());
    }

    public boolean j() {
        return this.f4410h;
    }

    public void k() {
        this.f4410h = true;
    }

    public g(j jVar, String str, a1.d dVar, List list, List list2) {
        this.f4403a = jVar;
        this.f4404b = str;
        this.f4405c = dVar;
        this.f4406d = list;
        this.f4409g = list2;
        this.f4407e = new ArrayList(list.size());
        this.f4408f = new ArrayList();
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                this.f4408f.addAll(((g) it.next()).f4408f);
            }
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            String a10 = ((u) list.get(i10)).a();
            this.f4407e.add(a10);
            this.f4408f.add(a10);
        }
    }
}
