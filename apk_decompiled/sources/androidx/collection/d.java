package androidx.collection;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes.dex */
public class d implements Cloneable {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f1807e = new Object();

    /* renamed from: a, reason: collision with root package name */
    public boolean f1808a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f1809b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f1810c;

    /* renamed from: d, reason: collision with root package name */
    public int f1811d;

    public d() {
        this(10);
    }

    public void a(long j10, Object obj) {
        int i10 = this.f1811d;
        if (i10 != 0 && j10 <= this.f1809b[i10 - 1]) {
            j(j10, obj);
            return;
        }
        if (this.f1808a && i10 >= this.f1809b.length) {
            e();
        }
        int i11 = this.f1811d;
        if (i11 >= this.f1809b.length) {
            int f10 = c.f(i11 + 1);
            long[] jArr = new long[f10];
            Object[] objArr = new Object[f10];
            long[] jArr2 = this.f1809b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f1810c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1809b = jArr;
            this.f1810c = objArr;
        }
        this.f1809b[i11] = j10;
        this.f1810c[i11] = obj;
        this.f1811d = i11 + 1;
    }

    public void b() {
        int i10 = this.f1811d;
        Object[] objArr = this.f1810c;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f1811d = 0;
        this.f1808a = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d clone() {
        try {
            d dVar = (d) super.clone();
            dVar.f1809b = (long[]) this.f1809b.clone();
            dVar.f1810c = (Object[]) this.f1810c.clone();
            return dVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public void d(long j10) {
        k(j10);
    }

    public final void e() {
        int i10 = this.f1811d;
        long[] jArr = this.f1809b;
        Object[] objArr = this.f1810c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f1807e) {
                if (i12 != i11) {
                    jArr[i11] = jArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f1808a = false;
        this.f1811d = i11;
    }

    public Object f(long j10) {
        return g(j10, null);
    }

    public Object g(long j10, Object obj) {
        Object obj2;
        int b10 = c.b(this.f1809b, this.f1811d, j10);
        return (b10 < 0 || (obj2 = this.f1810c[b10]) == f1807e) ? obj : obj2;
    }

    public int h(long j10) {
        if (this.f1808a) {
            e();
        }
        return c.b(this.f1809b, this.f1811d, j10);
    }

    public long i(int i10) {
        if (this.f1808a) {
            e();
        }
        return this.f1809b[i10];
    }

    public void j(long j10, Object obj) {
        int b10 = c.b(this.f1809b, this.f1811d, j10);
        if (b10 >= 0) {
            this.f1810c[b10] = obj;
            return;
        }
        int i10 = b10 ^ (-1);
        int i11 = this.f1811d;
        if (i10 < i11) {
            Object[] objArr = this.f1810c;
            if (objArr[i10] == f1807e) {
                this.f1809b[i10] = j10;
                objArr[i10] = obj;
                return;
            }
        }
        if (this.f1808a && i11 >= this.f1809b.length) {
            e();
            i10 = c.b(this.f1809b, this.f1811d, j10) ^ (-1);
        }
        int i12 = this.f1811d;
        if (i12 >= this.f1809b.length) {
            int f10 = c.f(i12 + 1);
            long[] jArr = new long[f10];
            Object[] objArr2 = new Object[f10];
            long[] jArr2 = this.f1809b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1810c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1809b = jArr;
            this.f1810c = objArr2;
        }
        int i13 = this.f1811d;
        if (i13 - i10 != 0) {
            long[] jArr3 = this.f1809b;
            int i14 = i10 + 1;
            System.arraycopy(jArr3, i10, jArr3, i14, i13 - i10);
            Object[] objArr4 = this.f1810c;
            System.arraycopy(objArr4, i10, objArr4, i14, this.f1811d - i10);
        }
        this.f1809b[i10] = j10;
        this.f1810c[i10] = obj;
        this.f1811d++;
    }

    public void k(long j10) {
        int b10 = c.b(this.f1809b, this.f1811d, j10);
        if (b10 >= 0) {
            Object[] objArr = this.f1810c;
            Object obj = objArr[b10];
            Object obj2 = f1807e;
            if (obj != obj2) {
                objArr[b10] = obj2;
                this.f1808a = true;
            }
        }
    }

    public void l(int i10) {
        Object[] objArr = this.f1810c;
        Object obj = objArr[i10];
        Object obj2 = f1807e;
        if (obj != obj2) {
            objArr[i10] = obj2;
            this.f1808a = true;
        }
    }

    public int m() {
        if (this.f1808a) {
            e();
        }
        return this.f1811d;
    }

    public Object n(int i10) {
        if (this.f1808a) {
            e();
        }
        return this.f1810c[i10];
    }

    public String toString() {
        if (m() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1811d * 28);
        sb.append(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
        for (int i10 = 0; i10 < this.f1811d; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            sb.append(i(i10));
            sb.append(ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN);
            Object n10 = n(i10);
            if (n10 != this) {
                sb.append(n10);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
        return sb.toString();
    }

    public d(int i10) {
        this.f1808a = false;
        if (i10 == 0) {
            this.f1809b = c.f1805b;
            this.f1810c = c.f1806c;
        } else {
            int f10 = c.f(i10);
            this.f1809b = new long[f10];
            this.f1810c = new Object[f10];
        }
    }
}
