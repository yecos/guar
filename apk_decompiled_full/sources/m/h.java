package m;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import m.e;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public List f16567a;

    /* renamed from: b, reason: collision with root package name */
    public int f16568b;

    /* renamed from: c, reason: collision with root package name */
    public int f16569c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16570d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f16571e;

    /* renamed from: f, reason: collision with root package name */
    public List f16572f;

    /* renamed from: g, reason: collision with root package name */
    public List f16573g;

    /* renamed from: h, reason: collision with root package name */
    public HashSet f16574h;

    /* renamed from: i, reason: collision with root package name */
    public HashSet f16575i;

    /* renamed from: j, reason: collision with root package name */
    public List f16576j;

    /* renamed from: k, reason: collision with root package name */
    public List f16577k;

    public h(List list) {
        this.f16568b = -1;
        this.f16569c = -1;
        this.f16570d = false;
        this.f16571e = new int[]{-1, -1};
        this.f16572f = new ArrayList();
        this.f16573g = new ArrayList();
        this.f16574h = new HashSet();
        this.f16575i = new HashSet();
        this.f16576j = new ArrayList();
        this.f16577k = new ArrayList();
        this.f16567a = list;
    }

    public void a(f fVar, int i10) {
        if (i10 == 0) {
            this.f16574h.add(fVar);
        } else if (i10 == 1) {
            this.f16575i.add(fVar);
        }
    }

    public List b(int i10) {
        if (i10 == 0) {
            return this.f16572f;
        }
        if (i10 == 1) {
            return this.f16573g;
        }
        return null;
    }

    public Set c(int i10) {
        if (i10 == 0) {
            return this.f16574h;
        }
        if (i10 == 1) {
            return this.f16575i;
        }
        return null;
    }

    public List d() {
        if (!this.f16576j.isEmpty()) {
            return this.f16576j;
        }
        int size = this.f16567a.size();
        for (int i10 = 0; i10 < size; i10++) {
            f fVar = (f) this.f16567a.get(i10);
            if (!fVar.f16527i0) {
                e((ArrayList) this.f16576j, fVar);
            }
        }
        this.f16577k.clear();
        this.f16577k.addAll(this.f16567a);
        this.f16577k.removeAll(this.f16576j);
        return this.f16576j;
    }

    public final void e(ArrayList arrayList, f fVar) {
        f fVar2;
        if (fVar.f16531k0) {
            return;
        }
        arrayList.add(fVar);
        fVar.f16531k0 = true;
        if (fVar.L()) {
            return;
        }
        if (fVar instanceof j) {
            j jVar = (j) fVar;
            int i10 = jVar.f16585w0;
            for (int i11 = 0; i11 < i10; i11++) {
                e(arrayList, jVar.f16584v0[i11]);
            }
        }
        int length = fVar.C.length;
        for (int i12 = 0; i12 < length; i12++) {
            e eVar = fVar.C[i12].f16484d;
            if (eVar != null && (fVar2 = eVar.f16482b) != fVar.u()) {
                e(arrayList, fVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(f fVar) {
        int i10;
        e eVar;
        if (!fVar.f16527i0 || fVar.L()) {
            return;
        }
        e eVar2 = fVar.f16552w.f16484d;
        boolean z10 = eVar2 != null;
        if (!z10) {
            eVar2 = fVar.f16550u.f16484d;
        }
        if (eVar2 != null) {
            f fVar2 = eVar2.f16482b;
            if (!fVar2.f16529j0) {
                f(fVar2);
            }
            e.d dVar = eVar2.f16483c;
            if (dVar == e.d.RIGHT) {
                f fVar3 = eVar2.f16482b;
                i10 = fVar3.K + fVar3.D();
            } else if (dVar == e.d.LEFT) {
                i10 = eVar2.f16482b.K;
            }
            int d10 = !z10 ? i10 - fVar.f16552w.d() : i10 + fVar.f16550u.d() + fVar.D();
            fVar.f0(d10 - fVar.D(), d10);
            eVar = fVar.f16554y.f16484d;
            if (eVar == null) {
                f fVar4 = eVar.f16482b;
                if (!fVar4.f16529j0) {
                    f(fVar4);
                }
                f fVar5 = eVar.f16482b;
                int i11 = (fVar5.L + fVar5.U) - fVar.U;
                fVar.t0(i11, fVar.H + i11);
                fVar.f16529j0 = true;
                return;
            }
            e eVar3 = fVar.f16553x.f16484d;
            boolean z11 = eVar3 != null;
            if (!z11) {
                eVar3 = fVar.f16551v.f16484d;
            }
            if (eVar3 != null) {
                f fVar6 = eVar3.f16482b;
                if (!fVar6.f16529j0) {
                    f(fVar6);
                }
                e.d dVar2 = eVar3.f16483c;
                if (dVar2 == e.d.BOTTOM) {
                    f fVar7 = eVar3.f16482b;
                    d10 = fVar7.L + fVar7.r();
                } else if (dVar2 == e.d.TOP) {
                    d10 = eVar3.f16482b.L;
                }
            }
            int d11 = z11 ? d10 - fVar.f16553x.d() : d10 + fVar.f16551v.d() + fVar.r();
            fVar.t0(d11 - fVar.r(), d11);
            fVar.f16529j0 = true;
            return;
        }
        i10 = 0;
        if (!z10) {
        }
        fVar.f0(d10 - fVar.D(), d10);
        eVar = fVar.f16554y.f16484d;
        if (eVar == null) {
        }
    }

    public void g() {
        int size = this.f16577k.size();
        for (int i10 = 0; i10 < size; i10++) {
            f((f) this.f16577k.get(i10));
        }
    }

    public h(List list, boolean z10) {
        this.f16568b = -1;
        this.f16569c = -1;
        this.f16570d = false;
        this.f16571e = new int[]{-1, -1};
        this.f16572f = new ArrayList();
        this.f16573g = new ArrayList();
        this.f16574h = new HashSet();
        this.f16575i = new HashSet();
        this.f16576j = new ArrayList();
        this.f16577k = new ArrayList();
        this.f16567a = list;
        this.f16570d = z10;
    }
}
