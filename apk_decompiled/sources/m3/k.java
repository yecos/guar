package m3;

import com.fasterxml.jackson.databind.deser.std.d0;
import java.io.Serializable;
import n3.x;

/* loaded from: classes.dex */
public class k implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public static final n3.o[] f16684f = new n3.o[0];

    /* renamed from: g, reason: collision with root package name */
    public static final n3.g[] f16685g = new n3.g[0];

    /* renamed from: h, reason: collision with root package name */
    public static final k3.a[] f16686h = new k3.a[0];

    /* renamed from: i, reason: collision with root package name */
    public static final x[] f16687i = new x[0];

    /* renamed from: j, reason: collision with root package name */
    public static final n3.p[] f16688j = {new d0()};

    /* renamed from: a, reason: collision with root package name */
    public final n3.o[] f16689a;

    /* renamed from: b, reason: collision with root package name */
    public final n3.p[] f16690b;

    /* renamed from: c, reason: collision with root package name */
    public final n3.g[] f16691c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.a[] f16692d;

    /* renamed from: e, reason: collision with root package name */
    public final x[] f16693e;

    public k() {
        this(null, null, null, null, null);
    }

    public Iterable a() {
        return new d4.d(this.f16692d);
    }

    public Iterable b() {
        return new d4.d(this.f16691c);
    }

    public Iterable c() {
        return new d4.d(this.f16689a);
    }

    public boolean d() {
        return this.f16692d.length > 0;
    }

    public boolean e() {
        return this.f16691c.length > 0;
    }

    public boolean f() {
        return this.f16690b.length > 0;
    }

    public boolean g() {
        return this.f16693e.length > 0;
    }

    public Iterable h() {
        return new d4.d(this.f16690b);
    }

    public Iterable i() {
        return new d4.d(this.f16693e);
    }

    public k j(n3.o oVar) {
        if (oVar != null) {
            return new k((n3.o[]) d4.c.i(this.f16689a, oVar), this.f16690b, this.f16691c, this.f16692d, this.f16693e);
        }
        throw new IllegalArgumentException("Cannot pass null Deserializers");
    }

    public k(n3.o[] oVarArr, n3.p[] pVarArr, n3.g[] gVarArr, k3.a[] aVarArr, x[] xVarArr) {
        this.f16689a = oVarArr == null ? f16684f : oVarArr;
        this.f16690b = pVarArr == null ? f16688j : pVarArr;
        this.f16691c = gVarArr == null ? f16685g : gVarArr;
        this.f16692d = aVarArr == null ? f16686h : aVarArr;
        this.f16693e = xVarArr == null ? f16687i : xVarArr;
    }
}
