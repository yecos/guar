package kotlinx.coroutines.internal;

import ca.v1;

/* loaded from: classes3.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final k9.f f15742a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f15743b;

    /* renamed from: c, reason: collision with root package name */
    public final v1[] f15744c;

    /* renamed from: d, reason: collision with root package name */
    public int f15745d;

    public f0(k9.f fVar, int i10) {
        this.f15742a = fVar;
        this.f15743b = new Object[i10];
        this.f15744c = new v1[i10];
    }

    public final void a(v1 v1Var, Object obj) {
        Object[] objArr = this.f15743b;
        int i10 = this.f15745d;
        objArr[i10] = obj;
        v1[] v1VarArr = this.f15744c;
        this.f15745d = i10 + 1;
        v1VarArr[i10] = v1Var;
    }

    public final void b(k9.f fVar) {
        int length = this.f15744c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i10 = length - 1;
            v1 v1Var = this.f15744c[length];
            t9.i.d(v1Var);
            v1Var.I(fVar, this.f15743b[length]);
            if (i10 < 0) {
                return;
            } else {
                length = i10;
            }
        }
    }
}
