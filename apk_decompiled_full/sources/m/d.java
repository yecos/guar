package m;

import java.util.ArrayList;
import m.f;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public f f16464a;

    /* renamed from: b, reason: collision with root package name */
    public f f16465b;

    /* renamed from: c, reason: collision with root package name */
    public f f16466c;

    /* renamed from: d, reason: collision with root package name */
    public f f16467d;

    /* renamed from: e, reason: collision with root package name */
    public f f16468e;

    /* renamed from: f, reason: collision with root package name */
    public f f16469f;

    /* renamed from: g, reason: collision with root package name */
    public f f16470g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f16471h;

    /* renamed from: i, reason: collision with root package name */
    public int f16472i;

    /* renamed from: j, reason: collision with root package name */
    public int f16473j;

    /* renamed from: k, reason: collision with root package name */
    public float f16474k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    public int f16475l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f16476m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f16477n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f16478o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f16479p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f16480q;

    public d(f fVar, int i10, boolean z10) {
        this.f16464a = fVar;
        this.f16475l = i10;
        this.f16476m = z10;
    }

    public static boolean c(f fVar, int i10) {
        int i11;
        return fVar.C() != 8 && fVar.E[i10] == f.b.MATCH_CONSTRAINT && ((i11 = fVar.f16522g[i10]) == 0 || i11 == 3);
    }

    public void a() {
        if (!this.f16480q) {
            b();
        }
        this.f16480q = true;
    }

    public final void b() {
        int i10;
        int i11 = this.f16475l * 2;
        f fVar = this.f16464a;
        boolean z10 = false;
        f fVar2 = fVar;
        boolean z11 = false;
        while (!z11) {
            this.f16472i++;
            f[] fVarArr = fVar.f16545r0;
            int i12 = this.f16475l;
            f fVar3 = null;
            fVarArr[i12] = null;
            fVar.f16543q0[i12] = null;
            if (fVar.C() != 8) {
                if (this.f16465b == null) {
                    this.f16465b = fVar;
                }
                this.f16467d = fVar;
                f.b[] bVarArr = fVar.E;
                int i13 = this.f16475l;
                if (bVarArr[i13] == f.b.MATCH_CONSTRAINT && ((i10 = fVar.f16522g[i13]) == 0 || i10 == 3 || i10 == 2)) {
                    this.f16473j++;
                    float f10 = fVar.f16541p0[i13];
                    if (f10 > 0.0f) {
                        this.f16474k += f10;
                    }
                    if (c(fVar, i13)) {
                        if (f10 < 0.0f) {
                            this.f16477n = true;
                        } else {
                            this.f16478o = true;
                        }
                        if (this.f16471h == null) {
                            this.f16471h = new ArrayList();
                        }
                        this.f16471h.add(fVar);
                    }
                    if (this.f16469f == null) {
                        this.f16469f = fVar;
                    }
                    f fVar4 = this.f16470g;
                    if (fVar4 != null) {
                        fVar4.f16543q0[this.f16475l] = fVar;
                    }
                    this.f16470g = fVar;
                }
            }
            if (fVar2 != fVar) {
                fVar2.f16545r0[this.f16475l] = fVar;
            }
            e eVar = fVar.C[i11 + 1].f16484d;
            if (eVar != null) {
                f fVar5 = eVar.f16482b;
                e eVar2 = fVar5.C[i11].f16484d;
                if (eVar2 != null && eVar2.f16482b == fVar) {
                    fVar3 = fVar5;
                }
            }
            if (fVar3 == null) {
                fVar3 = fVar;
                z11 = true;
            }
            fVar2 = fVar;
            fVar = fVar3;
        }
        this.f16466c = fVar;
        if (this.f16475l == 0 && this.f16476m) {
            this.f16468e = fVar;
        } else {
            this.f16468e = this.f16464a;
        }
        if (this.f16478o && this.f16477n) {
            z10 = true;
        }
        this.f16479p = z10;
    }
}
