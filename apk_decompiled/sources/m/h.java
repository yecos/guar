package m;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(m.f r7) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.h.f(m.f):void");
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
