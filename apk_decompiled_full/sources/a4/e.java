package a4;

import java.util.Collections;
import java.util.List;
import k3.a0;

/* loaded from: classes.dex */
public class e {

    /* renamed from: i, reason: collision with root package name */
    public static final c[] f201i = new c[0];

    /* renamed from: a, reason: collision with root package name */
    public final k3.c f202a;

    /* renamed from: b, reason: collision with root package name */
    public a0 f203b;

    /* renamed from: c, reason: collision with root package name */
    public List f204c = Collections.emptyList();

    /* renamed from: d, reason: collision with root package name */
    public c[] f205d;

    /* renamed from: e, reason: collision with root package name */
    public a f206e;

    /* renamed from: f, reason: collision with root package name */
    public Object f207f;

    /* renamed from: g, reason: collision with root package name */
    public r3.i f208g;

    /* renamed from: h, reason: collision with root package name */
    public b4.i f209h;

    public e(k3.c cVar) {
        this.f202a = cVar;
    }

    public k3.o a() {
        c[] cVarArr;
        if (this.f208g != null && this.f203b.D(k3.q.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            this.f208g.i(this.f203b.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        a aVar = this.f206e;
        if (aVar != null) {
            aVar.a(this.f203b);
        }
        List list = this.f204c;
        if (list == null || list.isEmpty()) {
            if (this.f206e == null && this.f209h == null) {
                return null;
            }
            cVarArr = f201i;
        } else {
            List list2 = this.f204c;
            cVarArr = (c[]) list2.toArray(new c[list2.size()]);
            if (this.f203b.D(k3.q.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                for (c cVar : cVarArr) {
                    cVar.o(this.f203b);
                }
            }
        }
        c[] cVarArr2 = this.f205d;
        if (cVarArr2 == null || cVarArr2.length == this.f204c.size()) {
            return new d(this.f202a.z(), this, cVarArr, this.f205d);
        }
        throw new IllegalStateException(String.format("Mismatch between `properties` size (%d), `filteredProperties` (%s): should have as many (or `null` for latter)", Integer.valueOf(this.f204c.size()), Integer.valueOf(this.f205d.length)));
    }

    public d b() {
        return d.p(this.f202a.z(), this);
    }

    public a c() {
        return this.f206e;
    }

    public k3.c d() {
        return this.f202a;
    }

    public Object e() {
        return this.f207f;
    }

    public b4.i f() {
        return this.f209h;
    }

    public List g() {
        return this.f204c;
    }

    public r3.i h() {
        return this.f208g;
    }

    public void i(a aVar) {
        this.f206e = aVar;
    }

    public void j(a0 a0Var) {
        this.f203b = a0Var;
    }

    public void k(Object obj) {
        this.f207f = obj;
    }

    public void l(c[] cVarArr) {
        if (cVarArr != null && cVarArr.length != this.f204c.size()) {
            throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", Integer.valueOf(cVarArr.length), Integer.valueOf(this.f204c.size())));
        }
        this.f205d = cVarArr;
    }

    public void m(b4.i iVar) {
        this.f209h = iVar;
    }

    public void n(List list) {
        this.f204c = list;
    }

    public void o(r3.i iVar) {
        if (this.f208g == null) {
            this.f208g = iVar;
            return;
        }
        throw new IllegalArgumentException("Multiple type ids specified with " + this.f208g + " and " + iVar);
    }
}
