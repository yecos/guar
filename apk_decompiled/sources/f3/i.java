package f3;

import c3.q;
import java.io.Serializable;

/* loaded from: classes.dex */
public class i implements q, Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final e f13079e = e.h();

    /* renamed from: a, reason: collision with root package name */
    public final String f13080a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f13081b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f13082c;

    /* renamed from: d, reason: collision with root package name */
    public char[] f13083d;

    public i(String str) {
        if (str == null) {
            throw new IllegalStateException("Null String illegal for SerializedString");
        }
        this.f13080a = str;
    }

    @Override // c3.q
    public int a(char[] cArr, int i10) {
        char[] cArr2 = this.f13083d;
        if (cArr2 == null) {
            cArr2 = f13079e.i(this.f13080a);
            this.f13083d = cArr2;
        }
        int length = cArr2.length;
        if (i10 + length > cArr.length) {
            return -1;
        }
        System.arraycopy(cArr2, 0, cArr, i10, length);
        return length;
    }

    @Override // c3.q
    public final char[] b() {
        char[] cArr = this.f13083d;
        if (cArr != null) {
            return cArr;
        }
        char[] i10 = f13079e.i(this.f13080a);
        this.f13083d = i10;
        return i10;
    }

    @Override // c3.q
    public final byte[] c() {
        byte[] bArr = this.f13081b;
        if (bArr != null) {
            return bArr;
        }
        byte[] j10 = f13079e.j(this.f13080a);
        this.f13081b = j10;
        return j10;
    }

    @Override // c3.q
    public int d(byte[] bArr, int i10) {
        byte[] bArr2 = this.f13081b;
        if (bArr2 == null) {
            bArr2 = f13079e.j(this.f13080a);
            this.f13081b = bArr2;
        }
        int length = bArr2.length;
        if (i10 + length > bArr.length) {
            return -1;
        }
        System.arraycopy(bArr2, 0, bArr, i10, length);
        return length;
    }

    @Override // c3.q
    public int e(char[] cArr, int i10) {
        String str = this.f13080a;
        int length = str.length();
        if (i10 + length > cArr.length) {
            return -1;
        }
        str.getChars(0, length, cArr, i10);
        return length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this.f13080a.equals(((i) obj).f13080a);
    }

    @Override // c3.q
    public int f(byte[] bArr, int i10) {
        byte[] bArr2 = this.f13082c;
        if (bArr2 == null) {
            bArr2 = f13079e.g(this.f13080a);
            this.f13082c = bArr2;
        }
        int length = bArr2.length;
        if (i10 + length > bArr.length) {
            return -1;
        }
        System.arraycopy(bArr2, 0, bArr, i10, length);
        return length;
    }

    @Override // c3.q
    public final byte[] g() {
        byte[] bArr = this.f13082c;
        if (bArr != null) {
            return bArr;
        }
        byte[] g10 = f13079e.g(this.f13080a);
        this.f13082c = g10;
        return g10;
    }

    @Override // c3.q
    public final String getValue() {
        return this.f13080a;
    }

    public final int hashCode() {
        return this.f13080a.hashCode();
    }

    public final String toString() {
        return this.f13080a;
    }
}
