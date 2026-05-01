package l;

import java.util.Arrays;
import l.i;

/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public final b f15834b;

    /* renamed from: c, reason: collision with root package name */
    public final c f15835c;

    /* renamed from: a, reason: collision with root package name */
    public int f15833a = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f15836d = 8;

    /* renamed from: e, reason: collision with root package name */
    public i f15837e = null;

    /* renamed from: f, reason: collision with root package name */
    public int[] f15838f = new int[8];

    /* renamed from: g, reason: collision with root package name */
    public int[] f15839g = new int[8];

    /* renamed from: h, reason: collision with root package name */
    public float[] f15840h = new float[8];

    /* renamed from: i, reason: collision with root package name */
    public int f15841i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f15842j = -1;

    /* renamed from: k, reason: collision with root package name */
    public boolean f15843k = false;

    public a(b bVar, c cVar) {
        this.f15834b = bVar;
        this.f15835c = cVar;
    }

    public final void a(i iVar, float f10, boolean z10) {
        if (f10 == 0.0f) {
            return;
        }
        int i10 = this.f15841i;
        if (i10 == -1) {
            this.f15841i = 0;
            this.f15840h[0] = f10;
            this.f15838f[0] = iVar.f15873b;
            this.f15839g[0] = -1;
            iVar.f15881j++;
            iVar.a(this.f15834b);
            this.f15833a++;
            if (this.f15843k) {
                return;
            }
            int i11 = this.f15842j + 1;
            this.f15842j = i11;
            int[] iArr = this.f15838f;
            if (i11 >= iArr.length) {
                this.f15843k = true;
                this.f15842j = iArr.length - 1;
                return;
            }
            return;
        }
        int i12 = -1;
        for (int i13 = 0; i10 != -1 && i13 < this.f15833a; i13++) {
            int i14 = this.f15838f[i10];
            int i15 = iVar.f15873b;
            if (i14 == i15) {
                float[] fArr = this.f15840h;
                float f11 = fArr[i10] + f10;
                fArr[i10] = f11;
                if (f11 == 0.0f) {
                    if (i10 == this.f15841i) {
                        this.f15841i = this.f15839g[i10];
                    } else {
                        int[] iArr2 = this.f15839g;
                        iArr2[i12] = iArr2[i10];
                    }
                    if (z10) {
                        iVar.c(this.f15834b);
                    }
                    if (this.f15843k) {
                        this.f15842j = i10;
                    }
                    iVar.f15881j--;
                    this.f15833a--;
                    return;
                }
                return;
            }
            if (i14 < i15) {
                i12 = i10;
            }
            i10 = this.f15839g[i10];
        }
        int i16 = this.f15842j;
        int i17 = i16 + 1;
        if (this.f15843k) {
            int[] iArr3 = this.f15838f;
            if (iArr3[i16] != -1) {
                i16 = iArr3.length;
            }
        } else {
            i16 = i17;
        }
        int[] iArr4 = this.f15838f;
        if (i16 >= iArr4.length && this.f15833a < iArr4.length) {
            int i18 = 0;
            while (true) {
                int[] iArr5 = this.f15838f;
                if (i18 >= iArr5.length) {
                    break;
                }
                if (iArr5[i18] == -1) {
                    i16 = i18;
                    break;
                }
                i18++;
            }
        }
        int[] iArr6 = this.f15838f;
        if (i16 >= iArr6.length) {
            i16 = iArr6.length;
            int i19 = this.f15836d * 2;
            this.f15836d = i19;
            this.f15843k = false;
            this.f15842j = i16 - 1;
            this.f15840h = Arrays.copyOf(this.f15840h, i19);
            this.f15838f = Arrays.copyOf(this.f15838f, this.f15836d);
            this.f15839g = Arrays.copyOf(this.f15839g, this.f15836d);
        }
        this.f15838f[i16] = iVar.f15873b;
        this.f15840h[i16] = f10;
        if (i12 != -1) {
            int[] iArr7 = this.f15839g;
            iArr7[i16] = iArr7[i12];
            iArr7[i12] = i16;
        } else {
            this.f15839g[i16] = this.f15841i;
            this.f15841i = i16;
        }
        iVar.f15881j++;
        iVar.a(this.f15834b);
        this.f15833a++;
        if (!this.f15843k) {
            this.f15842j++;
        }
        int i20 = this.f15842j;
        int[] iArr8 = this.f15838f;
        if (i20 >= iArr8.length) {
            this.f15843k = true;
            this.f15842j = iArr8.length - 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0090 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i b(e eVar) {
        boolean k10;
        boolean k11;
        int i10 = this.f15841i;
        i iVar = null;
        i iVar2 = null;
        boolean z10 = false;
        boolean z11 = false;
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (int i11 = 0; i10 != -1 && i11 < this.f15833a; i11++) {
            float[] fArr = this.f15840h;
            float f12 = fArr[i10];
            i iVar3 = this.f15835c.f15851c[this.f15838f[i10]];
            if (f12 < 0.0f) {
                if (f12 > -0.001f) {
                    fArr[i10] = 0.0f;
                    iVar3.c(this.f15834b);
                    f12 = 0.0f;
                }
                if (f12 != 0.0f) {
                    if (iVar3.f15878g == i.a.UNRESTRICTED) {
                        if (iVar2 == null) {
                            k11 = k(iVar3, eVar);
                        } else if (f10 > f12) {
                            k11 = k(iVar3, eVar);
                        } else if (!z10 && k(iVar3, eVar)) {
                            f10 = f12;
                            iVar2 = iVar3;
                            z10 = true;
                        }
                        z10 = k11;
                        f10 = f12;
                        iVar2 = iVar3;
                    } else if (iVar2 == null && f12 < 0.0f) {
                        if (iVar == null) {
                            k10 = k(iVar3, eVar);
                        } else if (f11 > f12) {
                            k10 = k(iVar3, eVar);
                        } else if (!z11 && k(iVar3, eVar)) {
                            f11 = f12;
                            iVar = iVar3;
                            z11 = true;
                        }
                        z11 = k10;
                        f11 = f12;
                        iVar = iVar3;
                    }
                }
                i10 = this.f15839g[i10];
            } else {
                if (f12 < 0.001f) {
                    fArr[i10] = 0.0f;
                    iVar3.c(this.f15834b);
                    f12 = 0.0f;
                }
                if (f12 != 0.0f) {
                }
                i10 = this.f15839g[i10];
            }
        }
        return iVar2 != null ? iVar2 : iVar;
    }

    public final void c() {
        int i10 = this.f15841i;
        for (int i11 = 0; i10 != -1 && i11 < this.f15833a; i11++) {
            i iVar = this.f15835c.f15851c[this.f15838f[i10]];
            if (iVar != null) {
                iVar.c(this.f15834b);
            }
            i10 = this.f15839g[i10];
        }
        this.f15841i = -1;
        this.f15842j = -1;
        this.f15843k = false;
        this.f15833a = 0;
    }

    public final boolean d(i iVar) {
        int i10 = this.f15841i;
        if (i10 == -1) {
            return false;
        }
        for (int i11 = 0; i10 != -1 && i11 < this.f15833a; i11++) {
            if (this.f15838f[i10] == iVar.f15873b) {
                return true;
            }
            i10 = this.f15839g[i10];
        }
        return false;
    }

    public void e(float f10) {
        int i10 = this.f15841i;
        for (int i11 = 0; i10 != -1 && i11 < this.f15833a; i11++) {
            float[] fArr = this.f15840h;
            fArr[i10] = fArr[i10] / f10;
            i10 = this.f15839g[i10];
        }
    }

    public final float f(i iVar) {
        int i10 = this.f15841i;
        for (int i11 = 0; i10 != -1 && i11 < this.f15833a; i11++) {
            if (this.f15838f[i10] == iVar.f15873b) {
                return this.f15840h[i10];
            }
            i10 = this.f15839g[i10];
        }
        return 0.0f;
    }

    public i g(boolean[] zArr, i iVar) {
        i.a aVar;
        int i10 = this.f15841i;
        i iVar2 = null;
        float f10 = 0.0f;
        for (int i11 = 0; i10 != -1 && i11 < this.f15833a; i11++) {
            float f11 = this.f15840h[i10];
            if (f11 < 0.0f) {
                i iVar3 = this.f15835c.f15851c[this.f15838f[i10]];
                if ((zArr == null || !zArr[iVar3.f15873b]) && iVar3 != iVar && (((aVar = iVar3.f15878g) == i.a.SLACK || aVar == i.a.ERROR) && f11 < f10)) {
                    f10 = f11;
                    iVar2 = iVar3;
                }
            }
            i10 = this.f15839g[i10];
        }
        return iVar2;
    }

    public final i h(int i10) {
        int i11 = this.f15841i;
        for (int i12 = 0; i11 != -1 && i12 < this.f15833a; i12++) {
            if (i12 == i10) {
                return this.f15835c.f15851c[this.f15838f[i11]];
            }
            i11 = this.f15839g[i11];
        }
        return null;
    }

    public final float i(int i10) {
        int i11 = this.f15841i;
        for (int i12 = 0; i11 != -1 && i12 < this.f15833a; i12++) {
            if (i12 == i10) {
                return this.f15840h[i11];
            }
            i11 = this.f15839g[i11];
        }
        return 0.0f;
    }

    public void j() {
        int i10 = this.f15841i;
        for (int i11 = 0; i10 != -1 && i11 < this.f15833a; i11++) {
            float[] fArr = this.f15840h;
            fArr[i10] = fArr[i10] * (-1.0f);
            i10 = this.f15839g[i10];
        }
    }

    public final boolean k(i iVar, e eVar) {
        return iVar.f15881j <= 1;
    }

    public final void l(i iVar, float f10) {
        if (f10 == 0.0f) {
            m(iVar, true);
            return;
        }
        int i10 = this.f15841i;
        if (i10 == -1) {
            this.f15841i = 0;
            this.f15840h[0] = f10;
            this.f15838f[0] = iVar.f15873b;
            this.f15839g[0] = -1;
            iVar.f15881j++;
            iVar.a(this.f15834b);
            this.f15833a++;
            if (this.f15843k) {
                return;
            }
            int i11 = this.f15842j + 1;
            this.f15842j = i11;
            int[] iArr = this.f15838f;
            if (i11 >= iArr.length) {
                this.f15843k = true;
                this.f15842j = iArr.length - 1;
                return;
            }
            return;
        }
        int i12 = -1;
        for (int i13 = 0; i10 != -1 && i13 < this.f15833a; i13++) {
            int i14 = this.f15838f[i10];
            int i15 = iVar.f15873b;
            if (i14 == i15) {
                this.f15840h[i10] = f10;
                return;
            }
            if (i14 < i15) {
                i12 = i10;
            }
            i10 = this.f15839g[i10];
        }
        int i16 = this.f15842j;
        int i17 = i16 + 1;
        if (this.f15843k) {
            int[] iArr2 = this.f15838f;
            if (iArr2[i16] != -1) {
                i16 = iArr2.length;
            }
        } else {
            i16 = i17;
        }
        int[] iArr3 = this.f15838f;
        if (i16 >= iArr3.length && this.f15833a < iArr3.length) {
            int i18 = 0;
            while (true) {
                int[] iArr4 = this.f15838f;
                if (i18 >= iArr4.length) {
                    break;
                }
                if (iArr4[i18] == -1) {
                    i16 = i18;
                    break;
                }
                i18++;
            }
        }
        int[] iArr5 = this.f15838f;
        if (i16 >= iArr5.length) {
            i16 = iArr5.length;
            int i19 = this.f15836d * 2;
            this.f15836d = i19;
            this.f15843k = false;
            this.f15842j = i16 - 1;
            this.f15840h = Arrays.copyOf(this.f15840h, i19);
            this.f15838f = Arrays.copyOf(this.f15838f, this.f15836d);
            this.f15839g = Arrays.copyOf(this.f15839g, this.f15836d);
        }
        this.f15838f[i16] = iVar.f15873b;
        this.f15840h[i16] = f10;
        if (i12 != -1) {
            int[] iArr6 = this.f15839g;
            iArr6[i16] = iArr6[i12];
            iArr6[i12] = i16;
        } else {
            this.f15839g[i16] = this.f15841i;
            this.f15841i = i16;
        }
        iVar.f15881j++;
        iVar.a(this.f15834b);
        int i20 = this.f15833a + 1;
        this.f15833a = i20;
        if (!this.f15843k) {
            this.f15842j++;
        }
        int[] iArr7 = this.f15838f;
        if (i20 >= iArr7.length) {
            this.f15843k = true;
        }
        if (this.f15842j >= iArr7.length) {
            this.f15843k = true;
            this.f15842j = iArr7.length - 1;
        }
    }

    public final float m(i iVar, boolean z10) {
        if (this.f15837e == iVar) {
            this.f15837e = null;
        }
        int i10 = this.f15841i;
        if (i10 == -1) {
            return 0.0f;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.f15833a) {
            if (this.f15838f[i10] == iVar.f15873b) {
                if (i10 == this.f15841i) {
                    this.f15841i = this.f15839g[i10];
                } else {
                    int[] iArr = this.f15839g;
                    iArr[i12] = iArr[i10];
                }
                if (z10) {
                    iVar.c(this.f15834b);
                }
                iVar.f15881j--;
                this.f15833a--;
                this.f15838f[i10] = -1;
                if (this.f15843k) {
                    this.f15842j = i10;
                }
                return this.f15840h[i10];
            }
            i11++;
            i12 = i10;
            i10 = this.f15839g[i10];
        }
        return 0.0f;
    }

    public final void n(b bVar, b bVar2, boolean z10) {
        int i10 = this.f15841i;
        while (true) {
            for (int i11 = 0; i10 != -1 && i11 < this.f15833a; i11++) {
                int i12 = this.f15838f[i10];
                i iVar = bVar2.f15844a;
                if (i12 == iVar.f15873b) {
                    float f10 = this.f15840h[i10];
                    m(iVar, z10);
                    a aVar = bVar2.f15847d;
                    int i13 = aVar.f15841i;
                    for (int i14 = 0; i13 != -1 && i14 < aVar.f15833a; i14++) {
                        a(this.f15835c.f15851c[aVar.f15838f[i13]], aVar.f15840h[i13] * f10, z10);
                        i13 = aVar.f15839g[i13];
                    }
                    bVar.f15845b += bVar2.f15845b * f10;
                    if (z10) {
                        bVar2.f15844a.c(bVar);
                    }
                    i10 = this.f15841i;
                } else {
                    i10 = this.f15839g[i10];
                }
            }
            return;
        }
    }

    public void o(b bVar, b[] bVarArr) {
        int i10 = this.f15841i;
        while (true) {
            for (int i11 = 0; i10 != -1 && i11 < this.f15833a; i11++) {
                i iVar = this.f15835c.f15851c[this.f15838f[i10]];
                if (iVar.f15874c != -1) {
                    float f10 = this.f15840h[i10];
                    m(iVar, true);
                    b bVar2 = bVarArr[iVar.f15874c];
                    if (!bVar2.f15848e) {
                        a aVar = bVar2.f15847d;
                        int i12 = aVar.f15841i;
                        for (int i13 = 0; i12 != -1 && i13 < aVar.f15833a; i13++) {
                            a(this.f15835c.f15851c[aVar.f15838f[i12]], aVar.f15840h[i12] * f10, true);
                            i12 = aVar.f15839g[i12];
                        }
                    }
                    bVar.f15845b += bVar2.f15845b * f10;
                    bVar2.f15844a.c(bVar);
                    i10 = this.f15841i;
                } else {
                    i10 = this.f15839g[i10];
                }
            }
            return;
        }
    }

    public String toString() {
        int i10 = this.f15841i;
        String str = "";
        for (int i11 = 0; i10 != -1 && i11 < this.f15833a; i11++) {
            str = ((str + " -> ") + this.f15840h[i10] + " : ") + this.f15835c.f15851c[this.f15838f[i10]];
            i10 = this.f15839g[i10];
        }
        return str;
    }
}
