package l;

import java.util.Arrays;

/* loaded from: classes.dex */
public class i {

    /* renamed from: k, reason: collision with root package name */
    public static int f15871k = 1;

    /* renamed from: a, reason: collision with root package name */
    public String f15872a;

    /* renamed from: e, reason: collision with root package name */
    public float f15876e;

    /* renamed from: g, reason: collision with root package name */
    public a f15878g;

    /* renamed from: b, reason: collision with root package name */
    public int f15873b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f15874c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f15875d = 0;

    /* renamed from: f, reason: collision with root package name */
    public float[] f15877f = new float[7];

    /* renamed from: h, reason: collision with root package name */
    public b[] f15879h = new b[8];

    /* renamed from: i, reason: collision with root package name */
    public int f15880i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f15881j = 0;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f15878g = aVar;
    }

    public static void b() {
        f15871k++;
    }

    public final void a(b bVar) {
        int i10 = 0;
        while (true) {
            int i11 = this.f15880i;
            if (i10 >= i11) {
                b[] bVarArr = this.f15879h;
                if (i11 >= bVarArr.length) {
                    this.f15879h = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f15879h;
                int i12 = this.f15880i;
                bVarArr2[i12] = bVar;
                this.f15880i = i12 + 1;
                return;
            }
            if (this.f15879h[i10] == bVar) {
                return;
            } else {
                i10++;
            }
        }
    }

    public final void c(b bVar) {
        int i10 = this.f15880i;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f15879h[i11] == bVar) {
                for (int i12 = 0; i12 < (i10 - i11) - 1; i12++) {
                    b[] bVarArr = this.f15879h;
                    int i13 = i11 + i12;
                    bVarArr[i13] = bVarArr[i13 + 1];
                }
                this.f15880i--;
                return;
            }
        }
    }

    public void d() {
        this.f15872a = null;
        this.f15878g = a.UNKNOWN;
        this.f15875d = 0;
        this.f15873b = -1;
        this.f15874c = -1;
        this.f15876e = 0.0f;
        this.f15880i = 0;
        this.f15881j = 0;
    }

    public void e(a aVar, String str) {
        this.f15878g = aVar;
    }

    public final void f(b bVar) {
        int i10 = this.f15880i;
        for (int i11 = 0; i11 < i10; i11++) {
            b bVar2 = this.f15879h[i11];
            bVar2.f15847d.n(bVar2, bVar, false);
        }
        this.f15880i = 0;
    }

    public String toString() {
        return "" + this.f15872a;
    }
}
