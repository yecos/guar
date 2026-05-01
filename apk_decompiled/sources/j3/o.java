package j3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: l, reason: collision with root package name */
    public static final char[] f14671l = new char[0];

    /* renamed from: a, reason: collision with root package name */
    public final a f14672a;

    /* renamed from: b, reason: collision with root package name */
    public char[] f14673b;

    /* renamed from: c, reason: collision with root package name */
    public int f14674c;

    /* renamed from: d, reason: collision with root package name */
    public int f14675d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f14676e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14677f;

    /* renamed from: g, reason: collision with root package name */
    public int f14678g;

    /* renamed from: h, reason: collision with root package name */
    public char[] f14679h;

    /* renamed from: i, reason: collision with root package name */
    public int f14680i;

    /* renamed from: j, reason: collision with root package name */
    public String f14681j;

    /* renamed from: k, reason: collision with root package name */
    public char[] f14682k;

    public o(a aVar) {
        this.f14672a = aVar;
    }

    public static o p(char[] cArr) {
        return new o(null, cArr);
    }

    public int A() {
        if (this.f14674c >= 0) {
            return this.f14675d;
        }
        char[] cArr = this.f14682k;
        if (cArr != null) {
            return cArr.length;
        }
        String str = this.f14681j;
        return str != null ? str.length() : this.f14678g + this.f14680i;
    }

    public final void B(int i10) {
        int i11 = this.f14675d;
        this.f14675d = 0;
        char[] cArr = this.f14673b;
        this.f14673b = null;
        int i12 = this.f14674c;
        this.f14674c = -1;
        int i13 = i10 + i11;
        char[] cArr2 = this.f14679h;
        if (cArr2 == null || i13 > cArr2.length) {
            this.f14679h = d(i13);
        }
        if (i11 > 0) {
            System.arraycopy(cArr, i12, this.f14679h, 0, i11);
        }
        this.f14678g = 0;
        this.f14680i = i11;
    }

    public void a(char c10) {
        if (this.f14674c >= 0) {
            B(16);
        }
        this.f14681j = null;
        this.f14682k = null;
        char[] cArr = this.f14679h;
        if (this.f14680i >= cArr.length) {
            n(1);
            cArr = this.f14679h;
        }
        int i10 = this.f14680i;
        this.f14680i = i10 + 1;
        cArr[i10] = c10;
    }

    public void b(String str, int i10, int i11) {
        if (this.f14674c >= 0) {
            B(i11);
        }
        this.f14681j = null;
        this.f14682k = null;
        char[] cArr = this.f14679h;
        int length = cArr.length;
        int i12 = this.f14680i;
        int i13 = length - i12;
        if (i13 >= i11) {
            str.getChars(i10, i10 + i11, cArr, i12);
            this.f14680i += i11;
            return;
        }
        if (i13 > 0) {
            int i14 = i10 + i13;
            str.getChars(i10, i14, cArr, i12);
            i11 -= i13;
            i10 = i14;
        }
        while (true) {
            n(i11);
            int min = Math.min(this.f14679h.length, i11);
            int i15 = i10 + min;
            str.getChars(i10, i15, this.f14679h, 0);
            this.f14680i += min;
            i11 -= min;
            if (i11 <= 0) {
                return;
            } else {
                i10 = i15;
            }
        }
    }

    public void c(char[] cArr, int i10, int i11) {
        if (this.f14674c >= 0) {
            B(i11);
        }
        this.f14681j = null;
        this.f14682k = null;
        char[] cArr2 = this.f14679h;
        int length = cArr2.length;
        int i12 = this.f14680i;
        int i13 = length - i12;
        if (i13 >= i11) {
            System.arraycopy(cArr, i10, cArr2, i12, i11);
            this.f14680i += i11;
            return;
        }
        if (i13 > 0) {
            System.arraycopy(cArr, i10, cArr2, i12, i13);
            i10 += i13;
            i11 -= i13;
        }
        do {
            n(i11);
            int min = Math.min(this.f14679h.length, i11);
            System.arraycopy(cArr, i10, this.f14679h, 0, min);
            this.f14680i += min;
            i10 += min;
            i11 -= min;
        } while (i11 > 0);
    }

    public final char[] d(int i10) {
        a aVar = this.f14672a;
        return aVar != null ? aVar.d(2, i10) : new char[Math.max(i10, 500)];
    }

    public final char[] e(int i10) {
        return new char[i10];
    }

    public final void f() {
        this.f14677f = false;
        this.f14676e.clear();
        this.f14678g = 0;
        this.f14680i = 0;
    }

    public char[] g() {
        char[] cArr = this.f14682k;
        if (cArr != null) {
            return cArr;
        }
        char[] y10 = y();
        this.f14682k = y10;
        return y10;
    }

    public BigDecimal h() {
        char[] cArr;
        char[] cArr2;
        char[] cArr3 = this.f14682k;
        if (cArr3 != null) {
            return f3.f.g(cArr3);
        }
        int i10 = this.f14674c;
        return (i10 < 0 || (cArr2 = this.f14673b) == null) ? (this.f14678g != 0 || (cArr = this.f14679h) == null) ? f3.f.g(g()) : f3.f.h(cArr, 0, this.f14680i) : f3.f.h(cArr2, i10, this.f14675d);
    }

    public double i() {
        return f3.f.i(l());
    }

    public int j(boolean z10) {
        char[] cArr;
        int i10 = this.f14674c;
        return (i10 < 0 || (cArr = this.f14673b) == null) ? z10 ? -f3.f.k(this.f14679h, 1, this.f14680i - 1) : f3.f.k(this.f14679h, 0, this.f14680i) : z10 ? -f3.f.k(cArr, i10 + 1, this.f14675d - 1) : f3.f.k(cArr, i10, this.f14675d);
    }

    public long k(boolean z10) {
        char[] cArr;
        int i10 = this.f14674c;
        return (i10 < 0 || (cArr = this.f14673b) == null) ? z10 ? -f3.f.m(this.f14679h, 1, this.f14680i - 1) : f3.f.m(this.f14679h, 0, this.f14680i) : z10 ? -f3.f.m(cArr, i10 + 1, this.f14675d - 1) : f3.f.m(cArr, i10, this.f14675d);
    }

    public String l() {
        if (this.f14681j == null) {
            char[] cArr = this.f14682k;
            if (cArr != null) {
                this.f14681j = new String(cArr);
            } else {
                int i10 = this.f14674c;
                if (i10 >= 0) {
                    int i11 = this.f14675d;
                    if (i11 < 1) {
                        this.f14681j = "";
                        return "";
                    }
                    this.f14681j = new String(this.f14673b, i10, i11);
                } else {
                    int i12 = this.f14678g;
                    int i13 = this.f14680i;
                    if (i12 == 0) {
                        this.f14681j = i13 != 0 ? new String(this.f14679h, 0, i13) : "";
                    } else {
                        StringBuilder sb = new StringBuilder(i12 + i13);
                        ArrayList arrayList = this.f14676e;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            for (int i14 = 0; i14 < size; i14++) {
                                char[] cArr2 = (char[]) this.f14676e.get(i14);
                                sb.append(cArr2, 0, cArr2.length);
                            }
                        }
                        sb.append(this.f14679h, 0, this.f14680i);
                        this.f14681j = sb.toString();
                    }
                }
            }
        }
        return this.f14681j;
    }

    public char[] m() {
        this.f14674c = -1;
        this.f14680i = 0;
        this.f14675d = 0;
        this.f14673b = null;
        this.f14681j = null;
        this.f14682k = null;
        if (this.f14677f) {
            f();
        }
        char[] cArr = this.f14679h;
        if (cArr != null) {
            return cArr;
        }
        char[] d10 = d(0);
        this.f14679h = d10;
        return d10;
    }

    public final void n(int i10) {
        if (this.f14676e == null) {
            this.f14676e = new ArrayList();
        }
        char[] cArr = this.f14679h;
        this.f14677f = true;
        this.f14676e.add(cArr);
        this.f14678g += cArr.length;
        this.f14680i = 0;
        int length = cArr.length;
        int i11 = length + (length >> 1);
        if (i11 < 500) {
            i11 = 500;
        } else if (i11 > 65536) {
            i11 = 65536;
        }
        this.f14679h = e(i11);
    }

    public char[] o() {
        if (this.f14676e == null) {
            this.f14676e = new ArrayList();
        }
        this.f14677f = true;
        this.f14676e.add(this.f14679h);
        int length = this.f14679h.length;
        this.f14678g += length;
        this.f14680i = 0;
        int i10 = length + (length >> 1);
        if (i10 < 500) {
            i10 = 500;
        } else if (i10 > 65536) {
            i10 = 65536;
        }
        char[] e10 = e(i10);
        this.f14679h = e10;
        return e10;
    }

    public char[] q() {
        if (this.f14674c >= 0) {
            B(1);
        } else {
            char[] cArr = this.f14679h;
            if (cArr == null) {
                this.f14679h = d(0);
            } else if (this.f14680i >= cArr.length) {
                n(1);
            }
        }
        return this.f14679h;
    }

    public int r() {
        return this.f14680i;
    }

    public char[] s() {
        if (this.f14674c >= 0) {
            return this.f14673b;
        }
        char[] cArr = this.f14682k;
        if (cArr != null) {
            return cArr;
        }
        String str = this.f14681j;
        if (str != null) {
            char[] charArray = str.toCharArray();
            this.f14682k = charArray;
            return charArray;
        }
        if (this.f14677f) {
            return g();
        }
        char[] cArr2 = this.f14679h;
        return cArr2 == null ? f14671l : cArr2;
    }

    public int t() {
        int i10 = this.f14674c;
        if (i10 >= 0) {
            return i10;
        }
        return 0;
    }

    public String toString() {
        return l();
    }

    public void u() {
        char[] cArr;
        this.f14674c = -1;
        this.f14680i = 0;
        this.f14675d = 0;
        this.f14673b = null;
        this.f14682k = null;
        if (this.f14677f) {
            f();
        }
        a aVar = this.f14672a;
        if (aVar == null || (cArr = this.f14679h) == null) {
            return;
        }
        this.f14679h = null;
        aVar.j(2, cArr);
    }

    public void v(char[] cArr, int i10, int i11) {
        this.f14673b = null;
        this.f14674c = -1;
        this.f14675d = 0;
        this.f14681j = null;
        this.f14682k = null;
        if (this.f14677f) {
            f();
        } else if (this.f14679h == null) {
            this.f14679h = d(i11);
        }
        this.f14678g = 0;
        this.f14680i = 0;
        c(cArr, i10, i11);
    }

    public void w(char[] cArr, int i10, int i11) {
        this.f14681j = null;
        this.f14682k = null;
        this.f14673b = cArr;
        this.f14674c = i10;
        this.f14675d = i11;
        if (this.f14677f) {
            f();
        }
    }

    public void x(String str) {
        this.f14673b = null;
        this.f14674c = -1;
        this.f14675d = 0;
        this.f14681j = str;
        this.f14682k = null;
        if (this.f14677f) {
            f();
        }
        this.f14680i = 0;
    }

    public final char[] y() {
        int i10;
        String str = this.f14681j;
        if (str != null) {
            return str.toCharArray();
        }
        int i11 = this.f14674c;
        if (i11 >= 0) {
            int i12 = this.f14675d;
            return i12 < 1 ? f14671l : i11 == 0 ? Arrays.copyOf(this.f14673b, i12) : Arrays.copyOfRange(this.f14673b, i11, i12 + i11);
        }
        int A = A();
        if (A < 1) {
            return f14671l;
        }
        char[] e10 = e(A);
        ArrayList arrayList = this.f14676e;
        if (arrayList != null) {
            int size = arrayList.size();
            i10 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                char[] cArr = (char[]) this.f14676e.get(i13);
                int length = cArr.length;
                System.arraycopy(cArr, 0, e10, i10, length);
                i10 += length;
            }
        } else {
            i10 = 0;
        }
        System.arraycopy(this.f14679h, 0, e10, i10, this.f14680i);
        return e10;
    }

    public void z(int i10) {
        this.f14680i = i10;
    }

    public o(a aVar, char[] cArr) {
        this.f14672a = aVar;
        this.f14679h = cArr;
        this.f14680i = cArr.length;
        this.f14674c = -1;
    }
}
