package okhttp3.internal.tls;

import javax.security.auth.x500.X500Principal;

/* loaded from: classes3.dex */
final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length;
    private int pos;

    public DistinguishedNameParser(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.dn = name;
        this.length = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x009b, code lost:
    
        return new java.lang.String(r1, r2, r8.cur - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String escapedAV() {
        char[] cArr;
        int i10;
        int i11;
        char c10;
        int i12 = this.pos;
        this.beg = i12;
        this.end = i12;
        while (true) {
            int i13 = this.pos;
            if (i13 >= this.length) {
                char[] cArr2 = this.chars;
                int i14 = this.beg;
                return new String(cArr2, i14, this.end - i14);
            }
            cArr = this.chars;
            char c11 = cArr[i13];
            if (c11 == ' ') {
                int i15 = this.end;
                this.cur = i15;
                this.pos = i13 + 1;
                this.end = i15 + 1;
                cArr[i15] = ' ';
                while (true) {
                    i10 = this.pos;
                    i11 = this.length;
                    if (i10 >= i11) {
                        break;
                    }
                    char[] cArr3 = this.chars;
                    if (cArr3[i10] != ' ') {
                        break;
                    }
                    int i16 = this.end;
                    this.end = i16 + 1;
                    cArr3[i16] = ' ';
                    this.pos = i10 + 1;
                }
                if (i10 == i11 || (c10 = this.chars[i10]) == ',' || c10 == '+' || c10 == ';') {
                    break;
                }
            } else {
                if (c11 == ';') {
                    break;
                }
                if (c11 == '\\') {
                    int i17 = this.end;
                    this.end = i17 + 1;
                    cArr[i17] = getEscaped();
                    this.pos++;
                } else {
                    if (c11 == '+' || c11 == ',') {
                        break;
                    }
                    int i18 = this.end;
                    this.end = i18 + 1;
                    cArr[i18] = c11;
                    this.pos = i13 + 1;
                }
            }
        }
        int i19 = this.beg;
        return new String(cArr, i19, this.end - i19);
    }

    private int getByte(int i10) {
        int i11;
        int i12;
        int i13 = i10 + 1;
        if (i13 >= this.length) {
            throw new IllegalStateException("Malformed DN: " + this.dn);
        }
        char[] cArr = this.chars;
        char c10 = cArr[i10];
        if (c10 >= '0' && c10 <= '9') {
            i11 = c10 - '0';
        } else if (c10 >= 'a' && c10 <= 'f') {
            i11 = c10 - 'W';
        } else {
            if (c10 < 'A' || c10 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
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
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
            i12 = c11 - '7';
        }
        return (i11 << 4) + i12;
    }

    private char getEscaped() {
        int i10 = this.pos + 1;
        this.pos = i10;
        if (i10 == this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        char c10 = this.chars[i10];
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
                        return getUTF8();
                }
        }
    }

    private char getUTF8() {
        int i10;
        int i11;
        int i12 = getByte(this.pos);
        this.pos++;
        if (i12 < 128) {
            return (char) i12;
        }
        if (i12 < 192 || i12 > 247) {
            return '?';
        }
        if (i12 <= 223) {
            i10 = i12 & 31;
            i11 = 1;
        } else if (i12 <= 239) {
            i10 = i12 & 15;
            i11 = 2;
        } else {
            i10 = i12 & 7;
            i11 = 3;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = this.pos + 1;
            this.pos = i14;
            if (i14 == this.length || this.chars[i14] != '\\') {
                return '?';
            }
            int i15 = i14 + 1;
            this.pos = i15;
            int i16 = getByte(i15);
            this.pos++;
            if ((i16 & 192) != 128) {
                return '?';
            }
            i10 = (i10 << 6) + (i16 & 63);
        }
        return (char) i10;
    }

    private String hexAV() {
        int i10;
        char[] cArr;
        char c10;
        int i11 = this.pos;
        if (i11 + 4 >= this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        this.beg = i11;
        this.pos = i11 + 1;
        while (true) {
            i10 = this.pos;
            if (i10 == this.length || (c10 = (cArr = this.chars)[i10]) == '+' || c10 == ',' || c10 == ';') {
                break;
            }
            if (c10 == ' ') {
                this.end = i10;
                this.pos = i10 + 1;
                while (true) {
                    int i12 = this.pos;
                    if (i12 >= this.length || this.chars[i12] != ' ') {
                        break;
                    }
                    this.pos = i12 + 1;
                }
            } else {
                if (c10 >= 'A' && c10 <= 'F') {
                    cArr[i10] = (char) (c10 + ' ');
                }
                this.pos = i10 + 1;
            }
        }
        this.end = i10;
        int i13 = this.end;
        int i14 = this.beg;
        int i15 = i13 - i14;
        if (i15 < 5 || (i15 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        int i16 = i15 / 2;
        byte[] bArr = new byte[i16];
        int i17 = i14 + 1;
        for (int i18 = 0; i18 < i16; i18++) {
            bArr[i18] = (byte) getByte(i17);
            i17 += 2;
        }
        return new String(this.chars, this.beg, i15);
    }

    private String nextAT() {
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
            i10 = this.pos;
            i11 = this.length;
            if (i10 >= i11 || this.chars[i10] != ' ') {
                break;
            }
            this.pos = i10 + 1;
        }
        if (i10 == i11) {
            return null;
        }
        this.beg = i10;
        this.pos = i10 + 1;
        while (true) {
            i12 = this.pos;
            i13 = this.length;
            if (i12 >= i13 || (c12 = this.chars[i12]) == '=' || c12 == ' ') {
                break;
            }
            this.pos = i12 + 1;
        }
        if (i12 >= i13) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        this.end = i12;
        if (this.chars[i12] == ' ') {
            while (true) {
                i14 = this.pos;
                i15 = this.length;
                if (i14 >= i15 || (c11 = this.chars[i14]) == '=' || c11 != ' ') {
                    break;
                }
                this.pos = i14 + 1;
            }
            if (this.chars[i14] != '=' || i14 == i15) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
        }
        this.pos++;
        while (true) {
            int i16 = this.pos;
            if (i16 >= this.length || this.chars[i16] != ' ') {
                break;
            }
            this.pos = i16 + 1;
        }
        int i17 = this.end;
        int i18 = this.beg;
        if (i17 - i18 > 4) {
            char[] cArr = this.chars;
            if (cArr[i18 + 3] == '.' && (((c10 = cArr[i18]) == 'O' || c10 == 'o') && ((cArr[i18 + 1] == 'I' || cArr[i18 + 1] == 'i') && (cArr[i18 + 2] == 'D' || cArr[i18 + 2] == 'd')))) {
                this.beg = i18 + 4;
            }
        }
        char[] cArr2 = this.chars;
        int i19 = this.beg;
        return new String(cArr2, i19, i17 - i19);
    }

    private String quotedAV() {
        int i10 = this.pos + 1;
        this.pos = i10;
        this.beg = i10;
        this.end = i10;
        while (true) {
            int i11 = this.pos;
            if (i11 == this.length) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
            char[] cArr = this.chars;
            char c10 = cArr[i11];
            if (c10 == '\"') {
                this.pos = i11 + 1;
                while (true) {
                    int i12 = this.pos;
                    if (i12 >= this.length || this.chars[i12] != ' ') {
                        break;
                    }
                    this.pos = i12 + 1;
                }
                char[] cArr2 = this.chars;
                int i13 = this.beg;
                return new String(cArr2, i13, this.end - i13);
            }
            if (c10 == '\\') {
                cArr[this.end] = getEscaped();
            } else {
                cArr[this.end] = c10;
            }
            this.pos++;
            this.end++;
        }
    }

    public String findMostSpecific(String str) {
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String nextAT = nextAT();
        if (nextAT == null) {
            return null;
        }
        do {
            int i10 = this.pos;
            if (i10 == this.length) {
                return null;
            }
            char c10 = this.chars[i10];
            String escapedAV = c10 != '\"' ? c10 != '#' ? (c10 == '+' || c10 == ',' || c10 == ';') ? "" : escapedAV() : hexAV() : quotedAV();
            if (str.equalsIgnoreCase(nextAT)) {
                return escapedAV;
            }
            int i11 = this.pos;
            if (i11 >= this.length) {
                return null;
            }
            char c11 = this.chars[i11];
            if (c11 != ',' && c11 != ';' && c11 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
            this.pos = i11 + 1;
            nextAT = nextAT();
        } while (nextAT != null);
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }
}
