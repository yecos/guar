package m;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class q extends f {

    /* renamed from: v0, reason: collision with root package name */
    public ArrayList f16613v0 = new ArrayList();

    @Override // m.f
    public void F0() {
        super.F0();
        ArrayList arrayList = this.f16613v0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            f fVar = (f) this.f16613v0.get(i10);
            fVar.n0(p(), q());
            if (!(fVar instanceof g)) {
                fVar.F0();
            }
        }
    }

    public void I0(f fVar) {
        this.f16613v0.add(fVar);
        if (fVar.u() != null) {
            ((q) fVar.u()).L0(fVar);
        }
        fVar.p0(this);
    }

    public g J0() {
        f u10 = u();
        g gVar = this instanceof g ? (g) this : null;
        while (u10 != null) {
            f u11 = u10.u();
            if (u10 instanceof g) {
                gVar = (g) u10;
            }
            u10 = u11;
        }
        return gVar;
    }

    public abstract void K0();

    public void L0(f fVar) {
        this.f16613v0.remove(fVar);
        fVar.p0(null);
    }

    public void M0() {
        this.f16613v0.clear();
    }

    @Override // m.f
    public void Q() {
        this.f16613v0.clear();
        super.Q();
    }

    @Override // m.f
    public void T(l.c cVar) {
        super.T(cVar);
        int size = this.f16613v0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((f) this.f16613v0.get(i10)).T(cVar);
        }
    }

    @Override // m.f
    public void n0(int i10, int i11) {
        super.n0(i10, i11);
        int size = this.f16613v0.size();
        for (int i12 = 0; i12 < size; i12++) {
            ((f) this.f16613v0.get(i12)).n0(z(), A());
        }
    }
}
