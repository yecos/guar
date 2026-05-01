package b9;

import javax.security.auth.x500.X500Principal;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f5156a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5157b;

    /* renamed from: c, reason: collision with root package name */
    public int f5158c;

    /* renamed from: d, reason: collision with root package name */
    public int f5159d;

    /* renamed from: e, reason: collision with root package name */
    public int f5160e;

    /* renamed from: f, reason: collision with root package name */
    public int f5161f;

    /* renamed from: g, reason: collision with root package name */
    public char[] f5162g;

    public d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f5156a = name;
        this.f5157b = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x009b, code lost:
    
        return new java.lang.String(r1, r2, r8.f5161f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.f5158c
            r8.f5159d = r0
            r8.f5160e = r0
        L6:
            int r0 = r8.f5158c
            int r1 = r8.f5157b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f5162g
            int r2 = r8.f5159d
            int r3 = r8.f5160e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f5162g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L5c
            if (r2 == r5) goto L51
            r5 = 92
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L51
            if (r2 == r3) goto L51
            int r3 = r8.f5160e
            int r4 = r3 + 1
            r8.f5160e = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.f5158c = r0
            goto L6
        L3e:
            int r0 = r8.f5160e
            int r2 = r0 + 1
            r8.f5160e = r2
            char r2 = r8.d()
            r1[r0] = r2
            int r0 = r8.f5158c
            int r0 = r0 + 1
            r8.f5158c = r0
            goto L6
        L51:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f5159d
            int r3 = r8.f5160e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5c:
            int r2 = r8.f5160e
            r8.f5161f = r2
            int r0 = r0 + 1
            r8.f5158c = r0
            int r0 = r2 + 1
            r8.f5160e = r0
            r1[r2] = r6
        L6a:
            int r0 = r8.f5158c
            int r1 = r8.f5157b
            if (r0 >= r1) goto L83
            char[] r2 = r8.f5162g
            char r7 = r2[r0]
            if (r7 != r6) goto L83
            int r1 = r8.f5160e
            int r7 = r1 + 1
            r8.f5160e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f5158c = r0
            goto L6a
        L83:
            if (r0 == r1) goto L8f
            char[] r1 = r8.f5162g
            char r0 = r1[r0]
            if (r0 == r3) goto L8f
            if (r0 == r4) goto L8f
            if (r0 != r5) goto L6
        L8f:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f5162g
            int r2 = r8.f5159d
            int r3 = r8.f5161f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b9.d.a():java.lang.String");
    }

    public String b(String str) {
        this.f5158c = 0;
        this.f5159d = 0;
        this.f5160e = 0;
        this.f5161f = 0;
        this.f5162g = this.f5156a.toCharArray();
        String g10 = g();
        if (g10 == null) {
            return null;
        }
        do {
            int i10 = this.f5158c;
            if (i10 == this.f5157b) {
                return null;
            }
            char c10 = this.f5162g[i10];
            String a10 = c10 != '\"' ? c10 != '#' ? (c10 == '+' || c10 == ',' || c10 == ';') ? "" : a() : f() : h();
            if (str.equalsIgnoreCase(g10)) {
                return a10;
            }
            int i11 = this.f5158c;
            if (i11 >= this.f5157b) {
                return null;
            }
            char c11 = this.f5162g[i11];
            if (c11 != ',' && c11 != ';' && c11 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f5156a);
            }
            this.f5158c = i11 + 1;
            g10 = g();
        } while (g10 != null);
        throw new IllegalStateException("Malformed DN: " + this.f5156a);
    }

    public final int c(int i10) {
        int i11;
        int i12;
        int i13 = i10 + 1;
        if (i13 >= this.f5157b) {
            throw new IllegalStateException("Malformed DN: " + this.f5156a);
        }
        char[] cArr = this.f5162g;
        char c10 = cArr[i10];
        if (c10 >= '0' && c10 <= '9') {
            i11 = c10 - '0';
        } else if (c10 >= 'a' && c10 <= 'f') {
            i11 = c10 - 'W';
        } else {
            if (c10 < 'A' || c10 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f5156a);
            }
            i11 = c10 - '7';
        }
        char c11 = cArr[i13];
        if (c11 >= '0' && c11 <= '9') {
            i12 = c11 - '0';
        } else if (c11 >= 'a' && c11 <= 'f') {
            i12 = c11 - 'W';
        } else {
            if (c11 < 'A' || c11 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f5156a);
            }
            i12 = c11 - '7';
        }
        return (i11 << 4) + i12;
    }

    public final char d() {
        int i10 = this.f5158c + 1;
        this.f5158c = i10;
        if (i10 == this.f5157b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f5156a);
        }
        char c10 = this.f5162g[i10];
        if (c10 == ' ' || c10 == '%' || c10 == '\\' || c10 == '_' || c10 == '\"' || c10 == '#') {
            return c10;
        }
        switch (c10) {
            case '*':
            case '+':
            case ',':
                return c10;
            default:
                switch (c10) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c10;
                    default:
                        return e();
                }
        }
    }

    public final char e() {
        int i10;
        int i11;
        int c10 = c(this.f5158c);
        this.f5158c++;
        if (c10 < 128) {
            return (char) c10;
        }
        if (c10 < 192 || c10 > 247) {
            return '?';
        }
        if (c10 <= 223) {
            i10 = c10 & 31;
            i11 = 1;
        } else if (c10 <= 239) {
            i10 = c10 & 15;
            i11 = 2;
        } else {
            i10 = c10 & 7;
            i11 = 3;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = this.f5158c + 1;
            this.f5158c = i13;
            if (i13 == this.f5157b || this.f5162g[i13] != '\\') {
                return '?';
            }
            int i14 = i13 + 1;
            this.f5158c = i14;
            int c11 = c(i14);
            this.f5158c++;
            if ((c11 & 192) != 128) {
                return '?';
            }
            i10 = (i10 << 6) + (c11 & 63);
        }
        return (char) i10;
    }

    public final String f() {
        int i10;
        char[] cArr;
        char c10;
        int i11 = this.f5158c;
        if (i11 + 4 >= this.f5157b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f5156a);
        }
        this.f5159d = i11;
        this.f5158c = i11 + 1;
        while (true) {
            i10 = this.f5158c;
            if (i10 == this.f5157b || (c10 = (cArr = this.f5162g)[i10]) == '+' || c10 == ',' || c10 == ';') {
                break;
            }
            if (c10 == ' ') {
                this.f5160e = i10;
                this.f5158c = i10 + 1;
                while (true) {
                    int i12 = this.f5158c;
                    if (i12 >= this.f5157b || this.f5162g[i12] != ' ') {
                        break;
                    }
                    this.f5158c = i12 + 1;
                }
            } else {
                if (c10 >= 'A' && c10 <= 'F') {
                    cArr[i10] = (char) (c10 + ' ');
                }
                this.f5158c = i10 + 1;
            }
        }
        this.f5160e = i10;
        int i13 = this.f5160e;
        int i14 = this.f5159d;
        int i15 = i13 - i14;
        if (i15 < 5 || (i15 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f5156a);
        }
        int i16 = i15 / 2;
        byte[] bArr = new byte[i16];
        int i17 = i14 + 1;
        for (int i18 = 0; i18 < i16; i18++) {
            bArr[i18] = (byte) c(i17);
            i17 += 2;
        }
        return new String(this.f5162g, this.f5159d, i15);
    }

    public final String g() {
        int i10;
        int i11;
        int i12;
        int i13;
        char c10;
        int i14;
        int i15;
        char c11;
        char c12;
        while (true) {
            i10 = this.f5158c;
            i11 = this.f5157b;
            if (i10 >= i11 || this.f5162g[i10] != ' ') {
                break;
            }
            this.f5158c = i10 + 1;
        }
        if (i10 == i11) {
            return null;
        }
        this.f5159d = i10;
        this.f5158c = i10 + 1;
        while (true) {
            i12 = this.f5158c;
            i13 = this.f5157b;
            if (i12 >= i13 || (c12 = this.f5162g[i12]) == '=' || c12 == ' ') {
                break;
            }
            this.f5158c = i12 + 1;
        }
        if (i12 >= i13) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f5156a);
        }
        this.f5160e = i12;
        if (this.f5162g[i12] == ' ') {
            while (true) {
                i14 = this.f5158c;
                i15 = this.f5157b;
                if (i14 >= i15 || (c11 = this.f5162g[i14]) == '=' || c11 != ' ') {
                    break;
                }
                this.f5158c = i14 + 1;
            }
            if (this.f5162g[i14] != '=' || i14 == i15) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f5156a);
            }
        }
        this.f5158c++;
        while (true) {
            int i16 = this.f5158c;
            if (i16 >= this.f5157b || this.f5162g[i16] != ' ') {
                break;
            }
            this.f5158c = i16 + 1;
        }
        int i17 = this.f5160e;
        int i18 = this.f5159d;
        if (i17 - i18 > 4) {
            char[] cArr = this.f5162g;
            if (cArr[i18 + 3] == '.' && (((c10 = cArr[i18]) == 'O' || c10 == 'o') && ((cArr[i18 + 1] == 'I' || cArr[i18 + 1] == 'i') && (cArr[i18 + 2] == 'D' || cArr[i18 + 2] == 'd')))) {
                this.f5159d = i18 + 4;
            }
        }
        char[] cArr2 = this.f5162g;
        int i19 = this.f5159d;
        return new String(cArr2, i19, i17 - i19);
    }

    public final String h() {
        int i10 = this.f5158c + 1;
        this.f5158c = i10;
        this.f5159d = i10;
        this.f5160e = i10;
        while (true) {
            int i11 = this.f5158c;
            if (i11 == this.f5157b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f5156a);
            }
            char[] cArr = this.f5162g;
            char c10 = cArr[i11];
            if (c10 == '\"') {
                this.f5158c = i11 + 1;
                while (true) {
                    int i12 = this.f5158c;
                    if (i12 >= this.f5157b || this.f5162g[i12] != ' ') {
                        break;
                    }
                    this.f5158c = i12 + 1;
                }
                char[] cArr2 = this.f5162g;
                int i13 = this.f5159d;
                return new String(cArr2, i13, this.f5160e - i13);
            }
            if (c10 == '\\') {
                cArr[this.f5160e] = d();
            } else {
                cArr[this.f5160e] = c10;
            }
            this.f5158c++;
            this.f5160e++;
        }
    }
}
