package o3;

import b3.b;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final k3.b f17497a;

    /* renamed from: b, reason: collision with root package name */
    public final r3.n f17498b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17499c;

    /* renamed from: d, reason: collision with root package name */
    public final a[] f17500d;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final r3.m f17501a;

        /* renamed from: b, reason: collision with root package name */
        public final r3.s f17502b;

        /* renamed from: c, reason: collision with root package name */
        public final b.a f17503c;

        public a(r3.m mVar, r3.s sVar, b.a aVar) {
            this.f17501a = mVar;
            this.f17502b = sVar;
            this.f17503c = aVar;
        }
    }

    public d(k3.b bVar, r3.n nVar, a[] aVarArr, int i10) {
        this.f17497a = bVar;
        this.f17498b = nVar;
        this.f17500d = aVarArr;
        this.f17499c = i10;
    }

    public static d a(k3.b bVar, r3.n nVar, r3.s[] sVarArr) {
        int v10 = nVar.v();
        a[] aVarArr = new a[v10];
        for (int i10 = 0; i10 < v10; i10++) {
            r3.m t10 = nVar.t(i10);
            aVarArr[i10] = new a(t10, sVarArr == null ? null : sVarArr[i10], bVar.s(t10));
        }
        return new d(bVar, nVar, aVarArr, v10);
    }

    public r3.n b() {
        return this.f17498b;
    }

    public k3.x c(int i10) {
        r3.s sVar = this.f17500d[i10].f17502b;
        if (sVar == null || !sVar.C()) {
            return null;
        }
        return sVar.c();
    }

    public k3.x d(int i10) {
        String r10 = this.f17497a.r(this.f17500d[i10].f17501a);
        if (r10 == null || r10.isEmpty()) {
            return null;
        }
        return k3.x.a(r10);
    }

    public int e() {
        int i10 = -1;
        for (int i11 = 0; i11 < this.f17499c; i11++) {
            if (this.f17500d[i11].f17503c == null) {
                if (i10 >= 0) {
                    return -1;
                }
                i10 = i11;
            }
        }
        return i10;
    }

    public b.a f(int i10) {
        return this.f17500d[i10].f17503c;
    }

    public int g() {
        return this.f17499c;
    }

    public k3.x h(int i10) {
        r3.s sVar = this.f17500d[i10].f17502b;
        if (sVar != null) {
            return sVar.c();
        }
        return null;
    }

    public r3.m i(int i10) {
        return this.f17500d[i10].f17501a;
    }

    public r3.s j(int i10) {
        return this.f17500d[i10].f17502b;
    }

    public String toString() {
        return this.f17498b.toString();
    }
}
