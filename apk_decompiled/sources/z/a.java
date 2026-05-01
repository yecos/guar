package z;

import android.text.SpannableStringBuilder;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.Locale;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final p f20107d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f20108e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f20109f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f20110g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f20111h;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f20112a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20113b;

    /* renamed from: c, reason: collision with root package name */
    public final p f20114c;

    /* renamed from: z.a$a, reason: collision with other inner class name */
    public static final class C0348a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f20115a;

        /* renamed from: b, reason: collision with root package name */
        public int f20116b;

        /* renamed from: c, reason: collision with root package name */
        public p f20117c;

        public C0348a() {
            c(a.e(Locale.getDefault()));
        }

        public static a b(boolean z10) {
            return z10 ? a.f20111h : a.f20110g;
        }

        public a a() {
            return (this.f20116b == 2 && this.f20117c == a.f20107d) ? b(this.f20115a) : new a(this.f20115a, this.f20116b, this.f20117c);
        }

        public final void c(boolean z10) {
            this.f20115a = z10;
            this.f20117c = a.f20107d;
            this.f20116b = 2;
        }
    }

    public static class b {

        /* renamed from: f, reason: collision with root package name */
        public static final byte[] f20118f = new byte[1792];

        /* renamed from: a, reason: collision with root package name */
        public final CharSequence f20119a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f20120b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20121c;

        /* renamed from: d, reason: collision with root package name */
        public int f20122d;

        /* renamed from: e, reason: collision with root package name */
        public char f20123e;

        static {
            for (int i10 = 0; i10 < 1792; i10++) {
                f20118f[i10] = Character.getDirectionality(i10);
            }
        }

        public b(CharSequence charSequence, boolean z10) {
            this.f20119a = charSequence;
            this.f20120b = z10;
            this.f20121c = charSequence.length();
        }

        public static byte c(char c10) {
            return c10 < 1792 ? f20118f[c10] : Character.getDirectionality(c10);
        }

        public byte a() {
            char charAt = this.f20119a.charAt(this.f20122d - 1);
            this.f20123e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f20119a, this.f20122d);
                this.f20122d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f20122d--;
            byte c10 = c(this.f20123e);
            if (!this.f20120b) {
                return c10;
            }
            char c11 = this.f20123e;
            return c11 == '>' ? h() : c11 == ';' ? f() : c10;
        }

        public byte b() {
            char charAt = this.f20119a.charAt(this.f20122d);
            this.f20123e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f20119a, this.f20122d);
                this.f20122d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f20122d++;
            byte c10 = c(this.f20123e);
            if (!this.f20120b) {
                return c10;
            }
            char c11 = this.f20123e;
            return c11 == '<' ? i() : c11 == '&' ? g() : c10;
        }

        public int d() {
            this.f20122d = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (this.f20122d < this.f20121c && i10 == 0) {
                byte b10 = b();
                if (b10 != 0) {
                    if (b10 == 1 || b10 == 2) {
                        if (i12 == 0) {
                            return 1;
                        }
                    } else if (b10 != 9) {
                        switch (b10) {
                            case 14:
                            case 15:
                                i12++;
                                i11 = -1;
                                continue;
                            case 16:
                            case 17:
                                i12++;
                                i11 = 1;
                                continue;
                            case 18:
                                i12--;
                                i11 = 0;
                                continue;
                        }
                    }
                } else if (i12 == 0) {
                    return -1;
                }
                i10 = i12;
            }
            if (i10 == 0) {
                return 0;
            }
            if (i11 != 0) {
                return i11;
            }
            while (this.f20122d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i10 == i12) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i10 == i12) {
                            return 1;
                        }
                        break;
                    case 18:
                        i12++;
                        continue;
                }
                i12--;
            }
            return 0;
        }

        public int e() {
            this.f20122d = this.f20121c;
            int i10 = 0;
            int i11 = 0;
            while (this.f20122d > 0) {
                byte a10 = a();
                if (a10 != 0) {
                    if (a10 == 1 || a10 == 2) {
                        if (i10 == 0) {
                            return 1;
                        }
                        if (i11 == 0) {
                            i11 = i10;
                        }
                    } else if (a10 != 9) {
                        switch (a10) {
                            case 14:
                            case 15:
                                if (i11 == i10) {
                                    return -1;
                                }
                                i10--;
                                break;
                            case 16:
                            case 17:
                                if (i11 == i10) {
                                    return 1;
                                }
                                i10--;
                                break;
                            case 18:
                                i10++;
                                break;
                            default:
                                if (i11 != 0) {
                                    break;
                                } else {
                                    i11 = i10;
                                    break;
                                }
                        }
                    } else {
                        continue;
                    }
                } else {
                    if (i10 == 0) {
                        return -1;
                    }
                    if (i11 == 0) {
                        i11 = i10;
                    }
                }
            }
            return 0;
        }

        public final byte f() {
            char charAt;
            int i10 = this.f20122d;
            do {
                int i11 = this.f20122d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f20119a;
                int i12 = i11 - 1;
                this.f20122d = i12;
                charAt = charSequence.charAt(i12);
                this.f20123e = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.f20122d = i10;
            this.f20123e = ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN;
            return (byte) 13;
        }

        public final byte g() {
            char charAt;
            do {
                int i10 = this.f20122d;
                if (i10 >= this.f20121c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f20119a;
                this.f20122d = i10 + 1;
                charAt = charSequence.charAt(i10);
                this.f20123e = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        public final byte h() {
            char charAt;
            int i10 = this.f20122d;
            while (true) {
                int i11 = this.f20122d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f20119a;
                int i12 = i11 - 1;
                this.f20122d = i12;
                char charAt2 = charSequence.charAt(i12);
                this.f20123e = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i13 = this.f20122d;
                        if (i13 > 0) {
                            CharSequence charSequence2 = this.f20119a;
                            int i14 = i13 - 1;
                            this.f20122d = i14;
                            charAt = charSequence2.charAt(i14);
                            this.f20123e = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
            this.f20122d = i10;
            this.f20123e = ASCIIPropertyListParser.DATA_END_TOKEN;
            return (byte) 13;
        }

        public final byte i() {
            char charAt;
            int i10 = this.f20122d;
            while (true) {
                int i11 = this.f20122d;
                if (i11 >= this.f20121c) {
                    this.f20122d = i10;
                    this.f20123e = ASCIIPropertyListParser.DATA_BEGIN_TOKEN;
                    return (byte) 13;
                }
                CharSequence charSequence = this.f20119a;
                this.f20122d = i11 + 1;
                char charAt2 = charSequence.charAt(i11);
                this.f20123e = charAt2;
                if (charAt2 == '>') {
                    return (byte) 12;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i12 = this.f20122d;
                        if (i12 < this.f20121c) {
                            CharSequence charSequence2 = this.f20119a;
                            this.f20122d = i12 + 1;
                            charAt = charSequence2.charAt(i12);
                            this.f20123e = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
        }
    }

    static {
        p pVar = q.f20135c;
        f20107d = pVar;
        f20108e = Character.toString((char) 8206);
        f20109f = Character.toString((char) 8207);
        f20110g = new a(false, 2, pVar);
        f20111h = new a(true, 2, pVar);
    }

    public a(boolean z10, int i10, p pVar) {
        this.f20112a = z10;
        this.f20113b = i10;
        this.f20114c = pVar;
    }

    public static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    public static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0348a().a();
    }

    public static boolean e(Locale locale) {
        return r.a(locale) == 1;
    }

    public boolean d() {
        return (this.f20113b & 2) != 0;
    }

    public final String f(CharSequence charSequence, p pVar) {
        boolean a10 = pVar.a(charSequence, 0, charSequence.length());
        return (this.f20112a || !(a10 || b(charSequence) == 1)) ? this.f20112a ? (!a10 || b(charSequence) == -1) ? f20109f : "" : "" : f20108e;
    }

    public final String g(CharSequence charSequence, p pVar) {
        boolean a10 = pVar.a(charSequence, 0, charSequence.length());
        return (this.f20112a || !(a10 || a(charSequence) == 1)) ? this.f20112a ? (!a10 || a(charSequence) == -1) ? f20109f : "" : "" : f20108e;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f20114c, true);
    }

    public CharSequence i(CharSequence charSequence, p pVar, boolean z10) {
        if (charSequence == null) {
            return null;
        }
        boolean a10 = pVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z10) {
            spannableStringBuilder.append((CharSequence) g(charSequence, a10 ? q.f20134b : q.f20133a));
        }
        if (a10 != this.f20112a) {
            spannableStringBuilder.append(a10 ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z10) {
            spannableStringBuilder.append((CharSequence) f(charSequence, a10 ? q.f20134b : q.f20133a));
        }
        return spannableStringBuilder;
    }
}
