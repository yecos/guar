package q8;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference f18239a;

    /* renamed from: b, reason: collision with root package name */
    public int f18240b;

    /* renamed from: c, reason: collision with root package name */
    public int f18241c;

    /* renamed from: d, reason: collision with root package name */
    public int f18242d;

    /* renamed from: e, reason: collision with root package name */
    public int f18243e;

    /* renamed from: f, reason: collision with root package name */
    public int f18244f;

    /* renamed from: g, reason: collision with root package name */
    public int f18245g;

    /* renamed from: h, reason: collision with root package name */
    public int f18246h;

    /* renamed from: i, reason: collision with root package name */
    public int f18247i = 0;

    public b(View view) {
        this.f18239a = new WeakReference(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a6, code lost:
    
        if (r4 != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ab, code lost:
    
        r12 = (int) (r0 / r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00af, code lost:
    
        r11 = (int) (r3 * r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a9, code lost:
    
        if (r4 != false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i10, int i11) {
        int i12;
        float f10;
        int i13;
        int i14 = this.f18244f;
        if (i14 == 90 || i14 == 270) {
            i11 = i10;
            i10 = i11;
        }
        int defaultSize = View.getDefaultSize(this.f18240b, i10);
        int defaultSize2 = View.getDefaultSize(this.f18241c, i11);
        if (this.f18247i != 3) {
            if (this.f18240b <= 0 || this.f18241c <= 0) {
                i10 = defaultSize;
                i11 = defaultSize2;
            } else {
                int mode = View.MeasureSpec.getMode(i10);
                i10 = View.MeasureSpec.getSize(i10);
                int mode2 = View.MeasureSpec.getMode(i11);
                i11 = View.MeasureSpec.getSize(i11);
                if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
                    float f11 = i10;
                    float f12 = i11;
                    float f13 = f11 / f12;
                    int i15 = this.f18247i;
                    if (i15 == 4) {
                        int i16 = this.f18244f;
                        f10 = (i16 == 90 || i16 == 270) ? 0.5625f : 1.7777778f;
                    } else if (i15 != 5) {
                        f10 = this.f18240b / this.f18241c;
                        int i17 = this.f18242d;
                        if (i17 > 0 && (i13 = this.f18243e) > 0) {
                            f10 = (f10 * i17) / i13;
                        }
                    } else {
                        int i18 = this.f18244f;
                        f10 = (i18 == 90 || i18 == 270) ? 0.75f : 1.3333334f;
                    }
                    boolean z10 = f10 > f13;
                    if (i15 != 0) {
                        if (i15 != 1) {
                            if (i15 != 4 && i15 != 5) {
                                if (z10) {
                                    i10 = Math.min(this.f18240b, i10);
                                    i11 = (int) (i10 / f10);
                                } else {
                                    int min = Math.min(this.f18241c, i11);
                                    i11 = min;
                                    i10 = (int) (min * f10);
                                }
                            }
                        }
                    }
                } else if (mode == 1073741824 && mode2 == 1073741824) {
                    int i19 = this.f18240b;
                    int i20 = i19 * i11;
                    int i21 = this.f18241c;
                    if (i20 < i10 * i21) {
                        i10 = (i19 * i11) / i21;
                    } else if (i19 * i11 > i10 * i21) {
                        i11 = (i21 * i10) / i19;
                    }
                } else if (mode == 1073741824) {
                    int i22 = (this.f18241c * i10) / this.f18240b;
                    if (mode2 != Integer.MIN_VALUE || i22 <= i11) {
                        i11 = i22;
                    }
                } else if (mode2 == 1073741824) {
                    int i23 = (this.f18240b * i11) / this.f18241c;
                    if (mode != Integer.MIN_VALUE || i23 <= i10) {
                        i10 = i23;
                    }
                } else {
                    int i24 = this.f18240b;
                    int i25 = this.f18241c;
                    if (mode2 != Integer.MIN_VALUE || i25 <= i11) {
                        i12 = i24;
                        i11 = i25;
                    } else {
                        i12 = (i11 * i24) / i25;
                    }
                    if (mode != Integer.MIN_VALUE || i12 <= i10) {
                        i10 = i12;
                    } else {
                        i11 = (i25 * i10) / i24;
                    }
                }
            }
        }
        this.f18245g = i10;
        this.f18246h = i11;
    }

    public int b() {
        return this.f18246h;
    }

    public int c() {
        return this.f18245g;
    }

    public void d(int i10) {
        this.f18247i = i10;
    }

    public void e(int i10) {
        this.f18244f = i10;
    }

    public void f(int i10, int i11) {
        this.f18240b = i10;
        this.f18241c = i11;
    }
}
