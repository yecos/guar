package m;

import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class j extends f {

    /* renamed from: v0, reason: collision with root package name */
    public f[] f16584v0 = new f[4];

    /* renamed from: w0, reason: collision with root package name */
    public int f16585w0 = 0;

    public void I0(f fVar) {
        int i10 = this.f16585w0 + 1;
        f[] fVarArr = this.f16584v0;
        if (i10 > fVarArr.length) {
            this.f16584v0 = (f[]) Arrays.copyOf(fVarArr, fVarArr.length * 2);
        }
        f[] fVarArr2 = this.f16584v0;
        int i11 = this.f16585w0;
        fVarArr2[i11] = fVar;
        this.f16585w0 = i11 + 1;
    }

    public void J0() {
        this.f16585w0 = 0;
    }
}
