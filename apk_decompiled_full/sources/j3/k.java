package j3;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class k extends j {

    /* renamed from: d, reason: collision with root package name */
    public final c3.k[] f14662d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f14663e;

    /* renamed from: f, reason: collision with root package name */
    public int f14664f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14665g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(boolean z10, c3.k[] kVarArr) {
        super(kVarArr[0]);
        boolean z11 = false;
        this.f14663e = z10;
        if (z10 && this.f14661c.h0()) {
            z11 = true;
        }
        this.f14665g = z11;
        this.f14662d = kVarArr;
        this.f14664f = 1;
    }

    public static k F0(boolean z10, c3.k kVar, c3.k kVar2) {
        boolean z11 = kVar instanceof k;
        if (!z11 && !(kVar2 instanceof k)) {
            return new k(z10, new c3.k[]{kVar, kVar2});
        }
        ArrayList arrayList = new ArrayList();
        if (z11) {
            ((k) kVar).E0(arrayList);
        } else {
            arrayList.add(kVar);
        }
        if (kVar2 instanceof k) {
            ((k) kVar2).E0(arrayList);
        } else {
            arrayList.add(kVar2);
        }
        return new k(z10, (c3.k[]) arrayList.toArray(new c3.k[arrayList.size()]));
    }

    @Override // c3.k
    public c3.k D0() {
        if (this.f14661c.n() != c3.n.START_OBJECT && this.f14661c.n() != c3.n.START_ARRAY) {
            return this;
        }
        int i10 = 1;
        while (true) {
            c3.n s02 = s0();
            if (s02 == null) {
                return this;
            }
            if (s02.g()) {
                i10++;
            } else if (s02.f() && i10 - 1 == 0) {
                return this;
            }
        }
    }

    public void E0(List list) {
        int length = this.f14662d.length;
        for (int i10 = this.f14664f - 1; i10 < length; i10++) {
            c3.k kVar = this.f14662d[i10];
            if (kVar instanceof k) {
                ((k) kVar).E0(list);
            } else {
                list.add(kVar);
            }
        }
    }

    public c3.n G0() {
        c3.n s02;
        do {
            int i10 = this.f14664f;
            c3.k[] kVarArr = this.f14662d;
            if (i10 >= kVarArr.length) {
                return null;
            }
            this.f14664f = i10 + 1;
            c3.k kVar = kVarArr[i10];
            this.f14661c = kVar;
            if (this.f14663e && kVar.h0()) {
                return this.f14661c.I();
            }
            s02 = this.f14661c.s0();
        } while (s02 == null);
        return s02;
    }

    public boolean H0() {
        int i10 = this.f14664f;
        c3.k[] kVarArr = this.f14662d;
        if (i10 >= kVarArr.length) {
            return false;
        }
        this.f14664f = i10 + 1;
        this.f14661c = kVarArr[i10];
        return true;
    }

    @Override // c3.k, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        do {
            this.f14661c.close();
        } while (H0());
    }

    @Override // c3.k
    public c3.n s0() {
        c3.k kVar = this.f14661c;
        if (kVar == null) {
            return null;
        }
        if (this.f14665g) {
            this.f14665g = false;
            return kVar.n();
        }
        c3.n s02 = kVar.s0();
        return s02 == null ? G0() : s02;
    }
}
