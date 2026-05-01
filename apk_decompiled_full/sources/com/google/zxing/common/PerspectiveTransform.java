package com.google.zxing.common;

/* loaded from: classes2.dex */
public final class PerspectiveTransform {
    private final float a11;
    private final float a12;
    private final float a13;
    private final float a21;
    private final float a22;
    private final float a23;
    private final float a31;
    private final float a32;
    private final float a33;

    private PerspectiveTransform(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.a11 = f10;
        this.a12 = f13;
        this.a13 = f16;
        this.a21 = f11;
        this.a22 = f14;
        this.a23 = f17;
        this.a31 = f12;
        this.a32 = f15;
        this.a33 = f18;
    }

    public static PerspectiveTransform quadrilateralToQuadrilateral(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25) {
        return squareToQuadrilateral(f18, f19, f20, f21, f22, f23, f24, f25).times(quadrilateralToSquare(f10, f11, f12, f13, f14, f15, f16, f17));
    }

    public static PerspectiveTransform quadrilateralToSquare(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return squareToQuadrilateral(f10, f11, f12, f13, f14, f15, f16, f17).buildAdjoint();
    }

    public static PerspectiveTransform squareToQuadrilateral(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        float f18 = ((f10 - f12) + f14) - f16;
        float f19 = ((f11 - f13) + f15) - f17;
        if (f18 == 0.0f && f19 == 0.0f) {
            return new PerspectiveTransform(f12 - f10, f14 - f12, f10, f13 - f11, f15 - f13, f11, 0.0f, 0.0f, 1.0f);
        }
        float f20 = f12 - f14;
        float f21 = f16 - f14;
        float f22 = f13 - f15;
        float f23 = f17 - f15;
        float f24 = (f20 * f23) - (f21 * f22);
        float f25 = ((f23 * f18) - (f21 * f19)) / f24;
        float f26 = ((f20 * f19) - (f18 * f22)) / f24;
        return new PerspectiveTransform((f25 * f12) + (f12 - f10), (f26 * f16) + (f16 - f10), f10, (f13 - f11) + (f25 * f13), (f17 - f11) + (f26 * f17), f11, f25, f26, 1.0f);
    }

    public PerspectiveTransform buildAdjoint() {
        float f10 = this.a22;
        float f11 = this.a33;
        float f12 = this.a23;
        float f13 = this.a32;
        float f14 = (f10 * f11) - (f12 * f13);
        float f15 = this.a31;
        float f16 = this.a21;
        float f17 = (f12 * f15) - (f16 * f11);
        float f18 = (f16 * f13) - (f10 * f15);
        float f19 = this.a13;
        float f20 = this.a12;
        float f21 = (f19 * f13) - (f20 * f11);
        float f22 = this.a11;
        return new PerspectiveTransform(f14, f17, f18, f21, (f11 * f22) - (f19 * f15), (f15 * f20) - (f13 * f22), (f20 * f12) - (f19 * f10), (f19 * f16) - (f12 * f22), (f22 * f10) - (f20 * f16));
    }

    public PerspectiveTransform times(PerspectiveTransform perspectiveTransform) {
        float f10 = this.a11;
        float f11 = perspectiveTransform.a11;
        float f12 = this.a21;
        float f13 = perspectiveTransform.a12;
        float f14 = this.a31;
        float f15 = perspectiveTransform.a13;
        float f16 = (f10 * f11) + (f12 * f13) + (f14 * f15);
        float f17 = perspectiveTransform.a21;
        float f18 = perspectiveTransform.a22;
        float f19 = perspectiveTransform.a23;
        float f20 = (f10 * f17) + (f12 * f18) + (f14 * f19);
        float f21 = perspectiveTransform.a31;
        float f22 = perspectiveTransform.a32;
        float f23 = perspectiveTransform.a33;
        float f24 = (f10 * f21) + (f12 * f22) + (f14 * f23);
        float f25 = this.a12;
        float f26 = this.a22;
        float f27 = this.a32;
        float f28 = (f25 * f11) + (f26 * f13) + (f27 * f15);
        float f29 = (f25 * f17) + (f26 * f18) + (f27 * f19);
        float f30 = (f27 * f23) + (f25 * f21) + (f26 * f22);
        float f31 = this.a13;
        float f32 = this.a23;
        float f33 = (f11 * f31) + (f13 * f32);
        float f34 = this.a33;
        return new PerspectiveTransform(f16, f20, f24, f28, f29, f30, (f15 * f34) + f33, (f17 * f31) + (f18 * f32) + (f19 * f34), (f31 * f21) + (f32 * f22) + (f34 * f23));
    }

    public void transformPoints(float[] fArr) {
        int length = fArr.length;
        float f10 = this.a11;
        float f11 = this.a12;
        float f12 = this.a13;
        float f13 = this.a21;
        float f14 = this.a22;
        float f15 = this.a23;
        float f16 = this.a31;
        float f17 = this.a32;
        float f18 = this.a33;
        for (int i10 = 0; i10 < length; i10 += 2) {
            float f19 = fArr[i10];
            int i11 = i10 + 1;
            float f20 = fArr[i11];
            float f21 = (f12 * f19) + (f15 * f20) + f18;
            fArr[i10] = (((f10 * f19) + (f13 * f20)) + f16) / f21;
            fArr[i11] = (((f19 * f11) + (f20 * f14)) + f17) / f21;
        }
    }

    public void transformPoints(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            float f10 = fArr[i10];
            float f11 = fArr2[i10];
            float f12 = (this.a13 * f10) + (this.a23 * f11) + this.a33;
            fArr[i10] = (((this.a11 * f10) + (this.a21 * f11)) + this.a31) / f12;
            fArr2[i10] = (((this.a12 * f10) + (this.a22 * f11)) + this.a32) / f12;
        }
    }
}
