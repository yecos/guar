package h9;

import anet.channel.strategy.dispatch.DispatchConstants;

/* loaded from: classes3.dex */
public final class e implements Comparable {

    /* renamed from: e, reason: collision with root package name */
    public static final a f14217e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final e f14218f = f.a();

    /* renamed from: a, reason: collision with root package name */
    public final int f14219a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14220b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14221c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14222d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }
    }

    public e(int i10, int i11, int i12) {
        this.f14219a = i10;
        this.f14220b = i11;
        this.f14221c = i12;
        this.f14222d = b(i10, i11, i12);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        t9.i.g(eVar, DispatchConstants.OTHER);
        return this.f14222d - eVar.f14222d;
    }

    public final int b(int i10, int i11, int i12) {
        boolean z10 = false;
        if (new y9.c(0, 255).f(i10) && new y9.c(0, 255).f(i11) && new y9.c(0, 255).f(i12)) {
            z10 = true;
        }
        if (z10) {
            return (i10 << 16) + (i11 << 8) + i12;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i10 + '.' + i11 + '.' + i12).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        e eVar = obj instanceof e ? (e) obj : null;
        return eVar != null && this.f14222d == eVar.f14222d;
    }

    public int hashCode() {
        return this.f14222d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14219a);
        sb.append('.');
        sb.append(this.f14220b);
        sb.append('.');
        sb.append(this.f14221c);
        return sb.toString();
    }
}
