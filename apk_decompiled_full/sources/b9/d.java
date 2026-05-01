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
    */
    public final String a() {
        char[] cArr;
        int i10;
        int i11;
        char c10;
        int i12 = this.f5158c;
        this.f5159d = i12;
        this.f5160e = i12;
        while (true) {
            int i13 = this.f5158c;
            if (i13 >= this.f5157b) {
                char[] cArr2 = this.f5162g;
                int i14 = this.f5159d;
                return new String(cArr2, i14, this.f5160e - i14);
            }
            cArr = this.f5162g;
            char c11 = cArr[i13];
            if (c11 == ' ') {
                int i15 = this.f5160e;
                this.f5161f = i15;
                this.f5158c = i13 + 1;
                this.f5160e = i15 + 1;
                cArr[i15] = ' ';
                while (true) {
                    i10 = this.f5158c;
                    i11 = this.f5157b;
                    if (i10 >= i11) {
                        break;
                    }
                    char[] cArr3 = this.f5162g;
                    if (cArr3[i10] != ' ') {
                        break;
                    }
                    int i16 = this.f5160e;
                    this.f5160e = i16 + 1;
                    cArr3[i16] = ' ';
                    this.f5158c = i10 + 1;
                }
                if (i10 == i11 || (c10 = this.f5162g[i10]) == ',' || c10 == '+' || c10 == ';') {
                    break;
                }
            } else {
                if (c11 == ';') {
                    break;
                }
                if (c11 == '\\') {
                    int i17 = this.f5160e;
                    this.f5160e = i17 + 1;
                    cArr[i17] = d();
                    this.f5158c++;
                } else {
                    if (c11 == '+' || c11 == ',') {
                        break;
                    }
                    int i18 = this.f5160e;
                    this.f5160e = i18 + 1;
                    cArr[i18] = c11;
                    this.f5158c = i13 + 1;
                }
            }
        }
        int i19 = this.f5159d;
        return new String(cArr, i19, this.f5160e - i19);
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
