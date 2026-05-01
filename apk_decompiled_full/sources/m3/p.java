package m3;

import a4.r;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class p implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final r[] f16708d = new r[0];

    /* renamed from: e, reason: collision with root package name */
    public static final a4.g[] f16709e = new a4.g[0];

    /* renamed from: a, reason: collision with root package name */
    public final r[] f16710a;

    /* renamed from: b, reason: collision with root package name */
    public final r[] f16711b;

    /* renamed from: c, reason: collision with root package name */
    public final a4.g[] f16712c;

    public p() {
        this(null, null, null);
    }

    public boolean a() {
        return this.f16711b.length > 0;
    }

    public boolean b() {
        return this.f16712c.length > 0;
    }

    public Iterable c() {
        return new d4.d(this.f16711b);
    }

    public Iterable d() {
        return new d4.d(this.f16712c);
    }

    public Iterable e() {
        return new d4.d(this.f16710a);
    }

    public p f(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("Cannot pass null Serializers");
        }
        return new p(this.f16710a, (r[]) d4.c.i(this.f16711b, rVar), this.f16712c);
    }

    public p g(r rVar) {
        if (rVar != null) {
            return new p((r[]) d4.c.i(this.f16710a, rVar), this.f16711b, this.f16712c);
        }
        throw new IllegalArgumentException("Cannot pass null Serializers");
    }

    public p(r[] rVarArr, r[] rVarArr2, a4.g[] gVarArr) {
        this.f16710a = rVarArr == null ? f16708d : rVarArr;
        this.f16711b = rVarArr2 == null ? f16708d : rVarArr2;
        this.f16712c = gVarArr == null ? f16709e : gVarArr;
    }
}
