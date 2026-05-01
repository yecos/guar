package c3;

import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final transient int[] f5386a;

    /* renamed from: b, reason: collision with root package name */
    public final transient char[] f5387b;

    /* renamed from: c, reason: collision with root package name */
    public final transient byte[] f5388c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5389d;

    /* renamed from: e, reason: collision with root package name */
    public final char f5390e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5391f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f5392g;

    /* renamed from: h, reason: collision with root package name */
    public final EnumC0080a f5393h;

    /* renamed from: c3.a$a, reason: collision with other inner class name */
    public enum EnumC0080a {
        PADDING_FORBIDDEN,
        PADDING_REQUIRED,
        PADDING_ALLOWED
    }

    public a(String str, String str2, boolean z10, char c10, int i10) {
        int[] iArr = new int[128];
        this.f5386a = iArr;
        char[] cArr = new char[64];
        this.f5387b = cArr;
        this.f5388c = new byte[64];
        this.f5389d = str;
        this.f5392g = z10;
        this.f5390e = c10;
        this.f5391f = i10;
        int length = str2.length();
        if (length != 64) {
            throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + length + ")");
        }
        str2.getChars(0, length, cArr, 0);
        Arrays.fill(iArr, -1);
        for (int i11 = 0; i11 < length; i11++) {
            char c11 = this.f5387b[i11];
            this.f5388c[i11] = (byte) c11;
            this.f5386a[c11] = i11;
        }
        if (z10) {
            this.f5386a[c10] = -2;
        }
        this.f5393h = z10 ? EnumC0080a.PADDING_REQUIRED : EnumC0080a.PADDING_FORBIDDEN;
    }

    public void a() {
        throw new IllegalArgumentException(s());
    }

    public void b() {
        throw new IllegalArgumentException(u());
    }

    public void c(char c10, int i10, String str) {
        String str2;
        if (c10 <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c10) + ") as character #" + (i10 + 1) + " of 4-char base64 unit: can only used between units";
        } else if (w(c10)) {
            str2 = "Unexpected padding character ('" + r() + "') as character #" + (i10 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c10) || Character.isISOControl(c10)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(c10) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + c10 + "' (code 0x" + Integer.toHexString(c10) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw new IllegalArgumentException(str2);
    }

    public boolean d() {
        return this.f5393h != EnumC0080a.PADDING_FORBIDDEN;
    }

    public void e(String str, j3.c cVar) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            char charAt = str.charAt(i10);
            if (charAt > ' ') {
                int g10 = g(charAt);
                if (g10 < 0) {
                    c(charAt, 0, null);
                }
                if (i11 >= length) {
                    a();
                }
                int i12 = i11 + 1;
                char charAt2 = str.charAt(i11);
                int g11 = g(charAt2);
                if (g11 < 0) {
                    c(charAt2, 1, null);
                }
                int i13 = (g10 << 6) | g11;
                if (i12 >= length) {
                    if (!t()) {
                        cVar.b(i13 >> 4);
                        return;
                    }
                    a();
                }
                int i14 = i12 + 1;
                char charAt3 = str.charAt(i12);
                int g12 = g(charAt3);
                if (g12 < 0) {
                    if (g12 != -2) {
                        c(charAt3, 2, null);
                    }
                    if (!d()) {
                        b();
                    }
                    if (i14 >= length) {
                        a();
                    }
                    i10 = i14 + 1;
                    char charAt4 = str.charAt(i14);
                    if (!w(charAt4)) {
                        c(charAt4, 3, "expected padding character '" + r() + "'");
                    }
                    cVar.b(i13 >> 4);
                } else {
                    int i15 = (i13 << 6) | g12;
                    if (i14 >= length) {
                        if (!t()) {
                            cVar.e(i15 >> 2);
                            return;
                        }
                        a();
                    }
                    i11 = i14 + 1;
                    char charAt5 = str.charAt(i14);
                    int g13 = g(charAt5);
                    if (g13 < 0) {
                        if (g13 != -2) {
                            c(charAt5, 3, null);
                        }
                        if (!d()) {
                            b();
                        }
                        cVar.e(i15 >> 2);
                    } else {
                        cVar.c((i15 << 6) | g13);
                    }
                }
            }
            i10 = i11;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != a.class) {
            return false;
        }
        a aVar = (a) obj;
        return aVar.f5390e == this.f5390e && aVar.f5391f == this.f5391f && aVar.f5392g == this.f5392g && aVar.f5393h == this.f5393h && this.f5389d.equals(aVar.f5389d);
    }

    public byte[] f(String str) {
        j3.c cVar = new j3.c();
        e(str, cVar);
        return cVar.v();
    }

    public int g(char c10) {
        if (c10 <= 127) {
            return this.f5386a[c10];
        }
        return -1;
    }

    public String h(byte[] bArr) {
        return i(bArr, false);
    }

    public int hashCode() {
        return this.f5389d.hashCode();
    }

    public String i(byte[] bArr, boolean z10) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z10) {
            sb.append('\"');
        }
        int p10 = p() >> 2;
        int i10 = length - 3;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = i11 + 1;
            int i13 = i12 + 1;
            int i14 = ((bArr[i11] << 8) | (bArr[i12] & UnsignedBytes.MAX_VALUE)) << 8;
            int i15 = i13 + 1;
            l(sb, i14 | (bArr[i13] & UnsignedBytes.MAX_VALUE));
            p10--;
            if (p10 <= 0) {
                sb.append(ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN);
                sb.append('n');
                p10 = p() >> 2;
            }
            i11 = i15;
        }
        int i16 = length - i11;
        if (i16 > 0) {
            int i17 = i11 + 1;
            int i18 = bArr[i11] << 16;
            if (i16 == 2) {
                i18 |= (bArr[i17] & UnsignedBytes.MAX_VALUE) << 8;
            }
            o(sb, i18, i16);
        }
        if (z10) {
            sb.append('\"');
        }
        return sb.toString();
    }

    public int j(int i10, byte[] bArr, int i11) {
        int i12 = i11 + 1;
        byte[] bArr2 = this.f5388c;
        bArr[i11] = bArr2[(i10 >> 18) & 63];
        int i13 = i12 + 1;
        bArr[i12] = bArr2[(i10 >> 12) & 63];
        int i14 = i13 + 1;
        bArr[i13] = bArr2[(i10 >> 6) & 63];
        int i15 = i14 + 1;
        bArr[i14] = bArr2[i10 & 63];
        return i15;
    }

    public int k(int i10, char[] cArr, int i11) {
        int i12 = i11 + 1;
        char[] cArr2 = this.f5387b;
        cArr[i11] = cArr2[(i10 >> 18) & 63];
        int i13 = i12 + 1;
        cArr[i12] = cArr2[(i10 >> 12) & 63];
        int i14 = i13 + 1;
        cArr[i13] = cArr2[(i10 >> 6) & 63];
        int i15 = i14 + 1;
        cArr[i14] = cArr2[i10 & 63];
        return i15;
    }

    public void l(StringBuilder sb, int i10) {
        sb.append(this.f5387b[(i10 >> 18) & 63]);
        sb.append(this.f5387b[(i10 >> 12) & 63]);
        sb.append(this.f5387b[(i10 >> 6) & 63]);
        sb.append(this.f5387b[i10 & 63]);
    }

    public int m(int i10, int i11, byte[] bArr, int i12) {
        int i13 = i12 + 1;
        byte[] bArr2 = this.f5388c;
        bArr[i12] = bArr2[(i10 >> 18) & 63];
        int i14 = i13 + 1;
        bArr[i13] = bArr2[(i10 >> 12) & 63];
        if (!v()) {
            if (i11 != 2) {
                return i14;
            }
            int i15 = i14 + 1;
            bArr[i14] = this.f5388c[(i10 >> 6) & 63];
            return i15;
        }
        byte b10 = (byte) this.f5390e;
        int i16 = i14 + 1;
        bArr[i14] = i11 == 2 ? this.f5388c[(i10 >> 6) & 63] : b10;
        int i17 = i16 + 1;
        bArr[i16] = b10;
        return i17;
    }

    public int n(int i10, int i11, char[] cArr, int i12) {
        int i13 = i12 + 1;
        char[] cArr2 = this.f5387b;
        cArr[i12] = cArr2[(i10 >> 18) & 63];
        int i14 = i13 + 1;
        cArr[i13] = cArr2[(i10 >> 12) & 63];
        if (v()) {
            int i15 = i14 + 1;
            cArr[i14] = i11 == 2 ? this.f5387b[(i10 >> 6) & 63] : this.f5390e;
            int i16 = i15 + 1;
            cArr[i15] = this.f5390e;
            return i16;
        }
        if (i11 != 2) {
            return i14;
        }
        int i17 = i14 + 1;
        cArr[i14] = this.f5387b[(i10 >> 6) & 63];
        return i17;
    }

    public void o(StringBuilder sb, int i10, int i11) {
        sb.append(this.f5387b[(i10 >> 18) & 63]);
        sb.append(this.f5387b[(i10 >> 12) & 63]);
        if (v()) {
            sb.append(i11 == 2 ? this.f5387b[(i10 >> 6) & 63] : this.f5390e);
            sb.append(this.f5390e);
        } else if (i11 == 2) {
            sb.append(this.f5387b[(i10 >> 6) & 63]);
        }
    }

    public int p() {
        return this.f5391f;
    }

    public String q() {
        return this.f5389d;
    }

    public char r() {
        return this.f5390e;
    }

    public String s() {
        return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects padding (one or more '%c' characters) at the end. This Base64Variant might have been incorrectly configured", q(), Character.valueOf(r()));
    }

    public boolean t() {
        return this.f5393h == EnumC0080a.PADDING_REQUIRED;
    }

    public String toString() {
        return this.f5389d;
    }

    public String u() {
        return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects no padding at the end while decoding. This Base64Variant might have been incorrectly configured", q());
    }

    public boolean v() {
        return this.f5392g;
    }

    public boolean w(char c10) {
        return c10 == this.f5390e;
    }

    public boolean x(int i10) {
        return i10 == this.f5390e;
    }

    public a(a aVar, String str, int i10) {
        this(aVar, str, aVar.f5392g, aVar.f5390e, i10);
    }

    public a(a aVar, String str, boolean z10, char c10, int i10) {
        this(aVar, str, z10, c10, aVar.f5393h, i10);
    }

    public a(a aVar, String str, boolean z10, char c10, EnumC0080a enumC0080a, int i10) {
        int[] iArr = new int[128];
        this.f5386a = iArr;
        char[] cArr = new char[64];
        this.f5387b = cArr;
        byte[] bArr = new byte[64];
        this.f5388c = bArr;
        this.f5389d = str;
        byte[] bArr2 = aVar.f5388c;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = aVar.f5387b;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = aVar.f5386a;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.f5392g = z10;
        this.f5390e = c10;
        this.f5391f = i10;
        this.f5393h = enumC0080a;
    }
}
