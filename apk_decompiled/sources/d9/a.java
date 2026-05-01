package d9;

import anet.channel.util.HttpConstant;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.taobao.accs.common.Constants;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import okio.Buffer;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final char[] f12739e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', ASCIIPropertyListParser.DATA_GSBOOL_BEGIN_TOKEN, 'C', ASCIIPropertyListParser.DATA_GSDATE_BEGIN_TOKEN, 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    public final String f12740a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12741b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12742c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12743d;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public String f12744a;

        /* renamed from: b, reason: collision with root package name */
        public String f12745b;

        /* renamed from: c, reason: collision with root package name */
        public int f12746c = -1;

        public static String b(String str, int i10, int i11) {
            String d10 = a.d(str, i10, i11, false);
            if (!d10.startsWith("[") || !d10.endsWith("]")) {
                return f(d10);
            }
            InetAddress e10 = e(d10, 1, d10.length() - 1);
            if (e10 == null) {
                return null;
            }
            byte[] address = e10.getAddress();
            if (address.length == 16) {
                return i(address);
            }
            throw new AssertionError();
        }

        public static boolean c(String str) {
            for (int i10 = 0; i10 < str.length(); i10++) {
                char charAt = str.charAt(i10);
                if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                    return true;
                }
            }
            return false;
        }

        public static boolean d(String str, int i10, int i11, byte[] bArr, int i12) {
            int i13 = i12;
            while (i10 < i11) {
                if (i13 == bArr.length) {
                    return false;
                }
                if (i13 != i12) {
                    if (str.charAt(i10) != '.') {
                        return false;
                    }
                    i10++;
                }
                int i14 = i10;
                int i15 = 0;
                while (i14 < i11) {
                    char charAt = str.charAt(i14);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    if ((i15 == 0 && i10 != i14) || (i15 = ((i15 * 10) + charAt) - 48) > 255) {
                        return false;
                    }
                    i14++;
                }
                if (i14 - i10 == 0) {
                    return false;
                }
                bArr[i13] = (byte) i15;
                i13++;
                i10 = i14;
            }
            return i13 == i12 + 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
        
            return null;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.net.InetAddress e(java.lang.String r11, int r12, int r13) {
            /*
                r0 = 16
                byte[] r1 = new byte[r0]
                r2 = 0
                r3 = -1
                r4 = 0
                r5 = -1
                r6 = -1
            L9:
                r7 = 0
                if (r12 >= r13) goto L7a
                if (r4 != r0) goto Lf
                return r7
            Lf:
                int r8 = r12 + 2
                if (r8 > r13) goto L27
                java.lang.String r9 = "::"
                r10 = 2
                boolean r9 = r11.regionMatches(r12, r9, r2, r10)
                if (r9 == 0) goto L27
                if (r5 == r3) goto L1f
                return r7
            L1f:
                int r4 = r4 + 2
                r5 = r4
                if (r8 != r13) goto L25
                goto L7a
            L25:
                r6 = r8
                goto L4b
            L27:
                if (r4 == 0) goto L4a
                java.lang.String r8 = ":"
                r9 = 1
                boolean r8 = r11.regionMatches(r12, r8, r2, r9)
                if (r8 == 0) goto L35
                int r12 = r12 + 1
                goto L4a
            L35:
                java.lang.String r8 = "."
                boolean r12 = r11.regionMatches(r12, r8, r2, r9)
                if (r12 == 0) goto L49
                int r12 = r4 + (-2)
                boolean r11 = d(r11, r6, r13, r1, r12)
                if (r11 != 0) goto L46
                return r7
            L46:
                int r4 = r4 + 2
                goto L7a
            L49:
                return r7
            L4a:
                r6 = r12
            L4b:
                r12 = r6
                r8 = 0
            L4d:
                if (r12 >= r13) goto L60
                char r9 = r11.charAt(r12)
                int r9 = d9.a.a(r9)
                if (r9 != r3) goto L5a
                goto L60
            L5a:
                int r8 = r8 << 4
                int r8 = r8 + r9
                int r12 = r12 + 1
                goto L4d
            L60:
                int r9 = r12 - r6
                if (r9 == 0) goto L79
                r10 = 4
                if (r9 <= r10) goto L68
                goto L79
            L68:
                int r7 = r4 + 1
                int r9 = r8 >>> 8
                r9 = r9 & 255(0xff, float:3.57E-43)
                byte r9 = (byte) r9
                r1[r4] = r9
                int r4 = r7 + 1
                r8 = r8 & 255(0xff, float:3.57E-43)
                byte r8 = (byte) r8
                r1[r7] = r8
                goto L9
            L79:
                return r7
            L7a:
                if (r4 == r0) goto L8b
                if (r5 != r3) goto L7f
                return r7
            L7f:
                int r11 = r4 - r5
                int r12 = 16 - r11
                java.lang.System.arraycopy(r1, r5, r1, r12, r11)
                int r0 = r0 - r4
                int r0 = r0 + r5
                java.util.Arrays.fill(r1, r5, r0, r2)
            L8b:
                java.net.InetAddress r11 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L90
                return r11
            L90:
                java.lang.AssertionError r11 = new java.lang.AssertionError
                r11.<init>()
                goto L97
            L96:
                throw r11
            L97:
                goto L96
            */
            throw new UnsupportedOperationException("Method not decompiled: d9.a.b.e(java.lang.String, int, int):java.net.InetAddress");
        }

        public static String f(String str) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (c(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public static String i(byte[] bArr) {
            int i10 = -1;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i12 < bArr.length) {
                int i14 = i12;
                while (i14 < 16 && bArr[i14] == 0 && bArr[i14 + 1] == 0) {
                    i14 += 2;
                }
                int i15 = i14 - i12;
                if (i15 > i13) {
                    i10 = i12;
                    i13 = i15;
                }
                i12 = i14 + 2;
            }
            Buffer buffer = new Buffer();
            while (i11 < bArr.length) {
                if (i11 == i10) {
                    buffer.writeByte(58);
                    i11 += i13;
                    if (i11 == 16) {
                        buffer.writeByte(58);
                    }
                } else {
                    if (i11 > 0) {
                        buffer.writeByte(58);
                    }
                    buffer.writeHexadecimalUnsignedLong(((bArr[i11] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[i11 + 1] & UnsignedBytes.MAX_VALUE));
                    i11 += 2;
                }
            }
            return buffer.readUtf8();
        }

        public a a() {
            if (this.f12744a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f12745b != null) {
                return new a(this);
            }
            throw new IllegalStateException("host == null");
        }

        public int g() {
            int i10 = this.f12746c;
            return i10 != -1 ? i10 : a.b(this.f12744a);
        }

        public b h(String str) {
            if (str == null) {
                throw new IllegalArgumentException("host == null");
            }
            String b10 = b(str, 0, str.length());
            if (b10 != null) {
                this.f12745b = b10;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public b j(int i10) {
            if (i10 > 0 && i10 <= 65535) {
                this.f12746c = i10;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i10);
        }

        public b k(String str) {
            if (str == null) {
                throw new IllegalArgumentException("scheme == null");
            }
            if (str.equalsIgnoreCase(HttpConstant.HTTP)) {
                this.f12744a = HttpConstant.HTTP;
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.f12744a = "https";
            }
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f12744a);
            sb.append(HttpConstant.SCHEME_SPLIT);
            if (this.f12745b.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f12745b);
                sb.append(']');
            } else {
                sb.append(this.f12745b);
            }
            int g10 = g();
            if (g10 != a.b(this.f12744a)) {
                sb.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
                sb.append(g10);
            }
            return sb.toString();
        }
    }

    public static int a(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return c10 - '0';
        }
        char c11 = 'a';
        if (c10 < 'a' || c10 > 'f') {
            c11 = 'A';
            if (c10 < 'A' || c10 > 'F') {
                return -1;
            }
        }
        return (c10 - c11) + 10;
    }

    public static int b(String str) {
        if (str.equals(HttpConstant.HTTP)) {
            return 80;
        }
        if (str.equals("https")) {
            return Constants.PORT;
        }
        return -1;
    }

    public static String d(String str, int i10, int i11, boolean z10) {
        for (int i12 = i10; i12 < i11; i12++) {
            char charAt = str.charAt(i12);
            if (charAt == '%' || (charAt == '+' && z10)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i10, i12);
                e(buffer, str, i12, i11, z10);
                return buffer.readUtf8();
            }
        }
        return str.substring(i10, i11);
    }

    public static void e(Buffer buffer, String str, int i10, int i11, boolean z10) {
        int i12;
        while (i10 < i11) {
            int codePointAt = str.codePointAt(i10);
            if (codePointAt != 37 || (i12 = i10 + 2) >= i11) {
                if (codePointAt == 43 && z10) {
                    buffer.writeByte(32);
                }
                buffer.writeUtf8CodePoint(codePointAt);
            } else {
                int a10 = a(str.charAt(i10 + 1));
                int a11 = a(str.charAt(i12));
                if (a10 != -1 && a11 != -1) {
                    buffer.writeByte((a10 << 4) + a11);
                    i10 = i12;
                }
                buffer.writeUtf8CodePoint(codePointAt);
            }
            i10 += Character.charCount(codePointAt);
        }
    }

    public String c() {
        return this.f12741b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).f12743d.equals(this.f12743d);
    }

    public int f() {
        return this.f12742c;
    }

    public int hashCode() {
        return this.f12743d.hashCode();
    }

    public String toString() {
        return this.f12743d;
    }

    public a(b bVar) {
        this.f12740a = bVar.f12744a;
        this.f12741b = bVar.f12745b;
        this.f12742c = bVar.g();
        this.f12743d = bVar.toString();
    }
}
