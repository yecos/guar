package h3;

import c3.f;
import j3.g;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final c f14143a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f14144b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14145c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14146d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f14147e;

    /* renamed from: f, reason: collision with root package name */
    public String[] f14148f;

    /* renamed from: g, reason: collision with root package name */
    public a[] f14149g;

    /* renamed from: h, reason: collision with root package name */
    public int f14150h;

    /* renamed from: i, reason: collision with root package name */
    public int f14151i;

    /* renamed from: j, reason: collision with root package name */
    public int f14152j;

    /* renamed from: k, reason: collision with root package name */
    public int f14153k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f14154l;

    /* renamed from: m, reason: collision with root package name */
    public BitSet f14155m;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f14156a;

        /* renamed from: b, reason: collision with root package name */
        public final a f14157b;

        /* renamed from: c, reason: collision with root package name */
        public final int f14158c;

        public a(String str, a aVar) {
            this.f14156a = str;
            this.f14157b = aVar;
            this.f14158c = aVar != null ? 1 + aVar.f14158c : 1;
        }

        public String a(char[] cArr, int i10, int i11) {
            if (this.f14156a.length() != i11) {
                return null;
            }
            int i12 = 0;
            while (this.f14156a.charAt(i12) == cArr[i10 + i12]) {
                i12++;
                if (i12 >= i11) {
                    return this.f14156a;
                }
            }
            return null;
        }
    }

    public c(int i10) {
        this.f14143a = null;
        this.f14145c = i10;
        this.f14147e = true;
        this.f14146d = -1;
        this.f14154l = false;
        this.f14153k = 0;
        this.f14144b = new AtomicReference(b.a(64));
    }

    public static int e(int i10) {
        return i10 - (i10 >> 2);
    }

    public static c i() {
        long currentTimeMillis = System.currentTimeMillis();
        return j((((int) currentTimeMillis) + ((int) (currentTimeMillis >>> 32))) | 1);
    }

    public static c j(int i10) {
        return new c(i10);
    }

    public final String a(char[] cArr, int i10, int i11, int i12, int i13) {
        if (this.f14154l) {
            h();
            this.f14154l = false;
        } else if (this.f14150h >= this.f14151i) {
            p();
            i13 = d(g(cArr, i10, i11));
        }
        String str = new String(cArr, i10, i11);
        if (f.a.INTERN_FIELD_NAMES.d(this.f14146d)) {
            str = g.f14658b.a(str);
        }
        this.f14150h++;
        String[] strArr = this.f14148f;
        if (strArr[i13] == null) {
            strArr[i13] = str;
        } else {
            int i14 = i13 >> 1;
            a aVar = new a(str, this.f14149g[i14]);
            int i15 = aVar.f14158c;
            if (i15 > 100) {
                c(i14, aVar, i13);
            } else {
                this.f14149g[i14] = aVar;
                this.f14153k = Math.max(i15, this.f14153k);
            }
        }
        return str;
    }

    public final String b(char[] cArr, int i10, int i11, a aVar) {
        while (aVar != null) {
            String a10 = aVar.a(cArr, i10, i11);
            if (a10 != null) {
                return a10;
            }
            aVar = aVar.f14157b;
        }
        return null;
    }

    public final void c(int i10, a aVar, int i11) {
        BitSet bitSet = this.f14155m;
        if (bitSet == null) {
            BitSet bitSet2 = new BitSet();
            this.f14155m = bitSet2;
            bitSet2.set(i10);
        } else if (bitSet.get(i10)) {
            if (f.a.FAIL_ON_SYMBOL_HASH_OVERFLOW.d(this.f14146d)) {
                r(100);
            }
            this.f14147e = false;
        } else {
            this.f14155m.set(i10);
        }
        this.f14148f[i11] = aVar.f14156a;
        this.f14149g[i10] = null;
        this.f14150h -= aVar.f14158c;
        this.f14153k = -1;
    }

    public int d(int i10) {
        int i11 = i10 + (i10 >>> 15);
        int i12 = i11 ^ (i11 << 7);
        return (i12 + (i12 >>> 3)) & this.f14152j;
    }

    public int f(String str) {
        int length = str.length();
        int i10 = this.f14145c;
        for (int i11 = 0; i11 < length; i11++) {
            i10 = (i10 * 33) + str.charAt(i11);
        }
        if (i10 == 0) {
            return 1;
        }
        return i10;
    }

    public int g(char[] cArr, int i10, int i11) {
        int i12 = this.f14145c;
        int i13 = i11 + i10;
        while (i10 < i13) {
            i12 = (i12 * 33) + cArr[i10];
            i10++;
        }
        if (i12 == 0) {
            return 1;
        }
        return i12;
    }

    public final void h() {
        String[] strArr = this.f14148f;
        this.f14148f = (String[]) Arrays.copyOf(strArr, strArr.length);
        a[] aVarArr = this.f14149g;
        this.f14149g = (a[]) Arrays.copyOf(aVarArr, aVarArr.length);
    }

    public String k(char[] cArr, int i10, int i11, int i12) {
        if (i11 < 1) {
            return "";
        }
        if (!this.f14147e) {
            return new String(cArr, i10, i11);
        }
        int d10 = d(i12);
        String str = this.f14148f[d10];
        if (str != null) {
            if (str.length() == i11) {
                int i13 = 0;
                while (str.charAt(i13) == cArr[i10 + i13]) {
                    i13++;
                    if (i13 == i11) {
                        return str;
                    }
                }
            }
            a aVar = this.f14149g[d10 >> 1];
            if (aVar != null) {
                String a10 = aVar.a(cArr, i10, i11);
                if (a10 != null) {
                    return a10;
                }
                String b10 = b(cArr, i10, i11, aVar.f14157b);
                if (b10 != null) {
                    return b10;
                }
            }
        }
        return a(cArr, i10, i11, i12, d10);
    }

    public int l() {
        return this.f14145c;
    }

    public c m(int i10) {
        return new c(this, i10, this.f14145c, (b) this.f14144b.get());
    }

    public boolean n() {
        return !this.f14154l;
    }

    public final void o(b bVar) {
        int i10 = bVar.f14159a;
        b bVar2 = (b) this.f14144b.get();
        if (i10 == bVar2.f14159a) {
            return;
        }
        if (i10 > 12000) {
            bVar = b.a(64);
        }
        h3.b.a(this.f14144b, bVar2, bVar);
    }

    public final void p() {
        String[] strArr = this.f14148f;
        int length = strArr.length;
        int i10 = length + length;
        if (i10 > 65536) {
            this.f14150h = 0;
            this.f14147e = false;
            this.f14148f = new String[64];
            this.f14149g = new a[32];
            this.f14152j = 63;
            this.f14154l = false;
            return;
        }
        a[] aVarArr = this.f14149g;
        this.f14148f = new String[i10];
        this.f14149g = new a[i10 >> 1];
        this.f14152j = i10 - 1;
        this.f14151i = e(i10);
        int i11 = 0;
        int i12 = 0;
        for (String str : strArr) {
            if (str != null) {
                i11++;
                int d10 = d(f(str));
                String[] strArr2 = this.f14148f;
                if (strArr2[d10] == null) {
                    strArr2[d10] = str;
                } else {
                    int i13 = d10 >> 1;
                    a aVar = new a(str, this.f14149g[i13]);
                    this.f14149g[i13] = aVar;
                    i12 = Math.max(i12, aVar.f14158c);
                }
            }
        }
        int i14 = length >> 1;
        for (int i15 = 0; i15 < i14; i15++) {
            for (a aVar2 = aVarArr[i15]; aVar2 != null; aVar2 = aVar2.f14157b) {
                i11++;
                String str2 = aVar2.f14156a;
                int d11 = d(f(str2));
                String[] strArr3 = this.f14148f;
                if (strArr3[d11] == null) {
                    strArr3[d11] = str2;
                } else {
                    int i16 = d11 >> 1;
                    a aVar3 = new a(str2, this.f14149g[i16]);
                    this.f14149g[i16] = aVar3;
                    i12 = Math.max(i12, aVar3.f14158c);
                }
            }
        }
        this.f14153k = i12;
        this.f14155m = null;
        if (i11 != this.f14150h) {
            throw new IllegalStateException(String.format("Internal error on SymbolTable.rehash(): had %d entries; now have %d", Integer.valueOf(this.f14150h), Integer.valueOf(i11)));
        }
    }

    public void q() {
        c cVar;
        if (n() && (cVar = this.f14143a) != null && this.f14147e) {
            cVar.o(new b(this));
            this.f14154l = true;
        }
    }

    public void r(int i10) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.f14150h + ") now exceeds maximum, " + i10 + " -- suspect a DoS attack based on hash collisions");
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f14159a;

        /* renamed from: b, reason: collision with root package name */
        public final int f14160b;

        /* renamed from: c, reason: collision with root package name */
        public final String[] f14161c;

        /* renamed from: d, reason: collision with root package name */
        public final a[] f14162d;

        public b(int i10, int i11, String[] strArr, a[] aVarArr) {
            this.f14159a = i10;
            this.f14160b = i11;
            this.f14161c = strArr;
            this.f14162d = aVarArr;
        }

        public static b a(int i10) {
            return new b(0, 0, new String[i10], new a[i10 >> 1]);
        }

        public b(c cVar) {
            this.f14159a = cVar.f14150h;
            this.f14160b = cVar.f14153k;
            this.f14161c = cVar.f14148f;
            this.f14162d = cVar.f14149g;
        }
    }

    public c(c cVar, int i10, int i11, b bVar) {
        this.f14143a = cVar;
        this.f14145c = i11;
        this.f14144b = null;
        this.f14146d = i10;
        this.f14147e = f.a.CANONICALIZE_FIELD_NAMES.d(i10);
        String[] strArr = bVar.f14161c;
        this.f14148f = strArr;
        this.f14149g = bVar.f14162d;
        this.f14150h = bVar.f14159a;
        this.f14153k = bVar.f14160b;
        int length = strArr.length;
        this.f14151i = e(length);
        this.f14152j = length - 1;
        this.f14154l = true;
    }
}
