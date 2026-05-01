package ba;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.firebase.dynamiclinks.DynamicLink;
import i9.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class t extends s {

    public static final class a extends t9.j implements s9.p {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f5241a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f5242b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List list, boolean z10) {
            super(2);
            this.f5241a = list;
            this.f5242b = z10;
        }

        public final h9.k b(CharSequence charSequence, int i10) {
            t9.i.g(charSequence, "$this$$receiver");
            h9.k r10 = t.r(charSequence, this.f5241a, i10, this.f5242b, false);
            if (r10 != null) {
                return h9.p.a(r10.c(), Integer.valueOf(((String) r10.d()).length()));
            }
            return null;
        }

        @Override // s9.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return b((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    public static final int A(CharSequence charSequence, char c10, int i10, boolean z10) {
        t9.i.g(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? E(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).lastIndexOf(c10, i10);
    }

    public static final int B(CharSequence charSequence, String str, int i10, boolean z10) {
        t9.i.g(charSequence, "<this>");
        t9.i.g(str, "string");
        return (z10 || !(charSequence instanceof String)) ? v(charSequence, str, i10, 0, z10, true) : ((String) charSequence).lastIndexOf(str, i10);
    }

    public static /* synthetic */ int C(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = s(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return A(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int D(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = s(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return B(charSequence, str, i10, z10);
    }

    public static final int E(CharSequence charSequence, char[] cArr, int i10, boolean z10) {
        t9.i.g(charSequence, "<this>");
        t9.i.g(cArr, "chars");
        if (!z10 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(i9.g.g(cArr), i10);
        }
        for (int b10 = y9.e.b(i10, s(charSequence)); -1 < b10; b10--) {
            char charAt = charSequence.charAt(b10);
            int length = cArr.length;
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (b.d(cArr[i11], charAt, z10)) {
                    z11 = true;
                    break;
                }
                i11++;
            }
            if (z11) {
                return b10;
            }
        }
        return -1;
    }

    public static final aa.b F(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11) {
        J(i11);
        return new d(charSequence, i10, i11, new a(i9.f.a(strArr), z10));
    }

    public static /* synthetic */ aa.b G(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return F(charSequence, strArr, i10, z10, i11);
    }

    public static final boolean H(CharSequence charSequence, int i10, CharSequence charSequence2, int i11, int i12, boolean z10) {
        t9.i.g(charSequence, "<this>");
        t9.i.g(charSequence2, DispatchConstants.OTHER);
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > charSequence2.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!b.d(charSequence.charAt(i10 + i13), charSequence2.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    public static final CharSequence I(CharSequence charSequence, int i10, int i11, CharSequence charSequence2) {
        t9.i.g(charSequence, "<this>");
        t9.i.g(charSequence2, "replacement");
        if (i11 >= i10) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i10);
            t9.i.f(sb, "this.append(value, startIndex, endIndex)");
            sb.append(charSequence2);
            sb.append(charSequence, i11, charSequence.length());
            t9.i.f(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i11 + ") is less than start index (" + i10 + ").");
    }

    public static final void J(int i10) {
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i10).toString());
    }

    public static final List K(CharSequence charSequence, String[] strArr, boolean z10, int i10) {
        t9.i.g(charSequence, "<this>");
        t9.i.g(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return L(charSequence, str, z10, i10);
            }
        }
        Iterable c10 = aa.g.c(G(charSequence, strArr, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(i9.k.k(c10, 10));
        Iterator it = c10.iterator();
        while (it.hasNext()) {
            arrayList.add(N(charSequence, (y9.c) it.next()));
        }
        return arrayList;
    }

    public static final List L(CharSequence charSequence, String str, boolean z10, int i10) {
        J(i10);
        int i11 = 0;
        int u10 = u(charSequence, str, 0, z10);
        if (u10 == -1 || i10 == 1) {
            return i9.i.b(charSequence.toString());
        }
        boolean z11 = i10 > 0;
        ArrayList arrayList = new ArrayList(z11 ? y9.e.b(i10, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(i11, u10).toString());
            i11 = str.length() + u10;
            if (z11 && arrayList.size() == i10 - 1) {
                break;
            }
            u10 = u(charSequence, str, i11, z10);
        } while (u10 != -1);
        arrayList.add(charSequence.subSequence(i11, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List M(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return K(charSequence, strArr, z10, i10);
    }

    public static final String N(CharSequence charSequence, y9.c cVar) {
        t9.i.g(charSequence, "<this>");
        t9.i.g(cVar, "range");
        return charSequence.subSequence(cVar.h().intValue(), cVar.g().intValue() + 1).toString();
    }

    public static final String O(String str, String str2, String str3) {
        t9.i.g(str, "<this>");
        t9.i.g(str2, "delimiter");
        t9.i.g(str3, "missingDelimiterValue");
        int y10 = y(str, str2, 0, false, 6, null);
        if (y10 == -1) {
            return str3;
        }
        String substring = str.substring(y10 + str2.length(), str.length());
        t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String P(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return O(str, str2, str3);
    }

    public static final String Q(String str, char c10, String str2) {
        t9.i.g(str, "<this>");
        t9.i.g(str2, "missingDelimiterValue");
        int C = C(str, c10, 0, false, 6, null);
        if (C == -1) {
            return str2;
        }
        String substring = str.substring(C + 1, str.length());
        t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String R(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return Q(str, c10, str2);
    }

    public static final String S(String str, char c10, String str2) {
        t9.i.g(str, "<this>");
        t9.i.g(str2, "missingDelimiterValue");
        int x10 = x(str, c10, 0, false, 6, null);
        if (x10 == -1) {
            return str2;
        }
        String substring = str.substring(0, x10);
        t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String T(String str, String str2, String str3) {
        t9.i.g(str, "<this>");
        t9.i.g(str2, "delimiter");
        t9.i.g(str3, "missingDelimiterValue");
        int y10 = y(str, str2, 0, false, 6, null);
        if (y10 == -1) {
            return str3;
        }
        String substring = str.substring(0, y10);
        t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String U(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return S(str, c10, str2);
    }

    public static /* synthetic */ String V(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return T(str, str2, str3);
    }

    public static final CharSequence W(CharSequence charSequence) {
        t9.i.g(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean c10 = ba.a.c(charSequence.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!c10) {
                    break;
                }
                length--;
            } else if (c10) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static final boolean n(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        t9.i.g(charSequence, "<this>");
        t9.i.g(charSequence2, DispatchConstants.OTHER);
        if (charSequence2 instanceof String) {
            if (y(charSequence, (String) charSequence2, 0, z10, 2, null) >= 0) {
                return true;
            }
        } else if (w(charSequence, charSequence2, 0, charSequence.length(), z10, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean o(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return n(charSequence, charSequence2, z10);
    }

    public static final boolean p(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        t9.i.g(charSequence, "<this>");
        t9.i.g(charSequence2, DynamicLink.Builder.KEY_SUFFIX);
        return (!z10 && (charSequence instanceof String) && (charSequence2 instanceof String)) ? s.e((String) charSequence, (String) charSequence2, false, 2, null) : H(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z10);
    }

    public static /* synthetic */ boolean q(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return p(charSequence, charSequence2, z10);
    }

    public static final h9.k r(CharSequence charSequence, Collection collection, int i10, boolean z10, boolean z11) {
        Object obj;
        Object obj2;
        if (!z10 && collection.size() == 1) {
            String str = (String) i9.r.A(collection);
            int y10 = !z11 ? y(charSequence, str, i10, false, 4, null) : D(charSequence, str, i10, false, 4, null);
            if (y10 < 0) {
                return null;
            }
            return h9.p.a(Integer.valueOf(y10), str);
        }
        y9.a cVar = !z11 ? new y9.c(y9.e.a(i10, 0), charSequence.length()) : y9.e.e(y9.e.b(i10, s(charSequence)), 0);
        if (charSequence instanceof String) {
            int a10 = cVar.a();
            int b10 = cVar.b();
            int c10 = cVar.c();
            if ((c10 > 0 && a10 <= b10) || (c10 < 0 && b10 <= a10)) {
                while (true) {
                    Iterator it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        if (s.h(str2, 0, (String) charSequence, a10, str2.length(), z10)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (a10 == b10) {
                            break;
                        }
                        a10 += c10;
                    } else {
                        return h9.p.a(Integer.valueOf(a10), str3);
                    }
                }
            }
        } else {
            int a11 = cVar.a();
            int b11 = cVar.b();
            int c11 = cVar.c();
            if ((c11 > 0 && a11 <= b11) || (c11 < 0 && b11 <= a11)) {
                while (true) {
                    Iterator it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (H(str4, 0, charSequence, a11, str4.length(), z10)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (a11 == b11) {
                            break;
                        }
                        a11 += c11;
                    } else {
                        return h9.p.a(Integer.valueOf(a11), str5);
                    }
                }
            }
        }
        return null;
    }

    public static final int s(CharSequence charSequence) {
        t9.i.g(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int t(CharSequence charSequence, char c10, int i10, boolean z10) {
        t9.i.g(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? z(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).indexOf(c10, i10);
    }

    public static final int u(CharSequence charSequence, String str, int i10, boolean z10) {
        t9.i.g(charSequence, "<this>");
        t9.i.g(str, "string");
        return (z10 || !(charSequence instanceof String)) ? w(charSequence, str, i10, charSequence.length(), z10, false, 16, null) : ((String) charSequence).indexOf(str, i10);
    }

    public static final int v(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        y9.a cVar = !z11 ? new y9.c(y9.e.a(i10, 0), y9.e.b(i11, charSequence.length())) : y9.e.e(y9.e.b(i10, s(charSequence)), y9.e.a(i11, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int a10 = cVar.a();
            int b10 = cVar.b();
            int c10 = cVar.c();
            if ((c10 <= 0 || a10 > b10) && (c10 >= 0 || b10 > a10)) {
                return -1;
            }
            while (!s.h((String) charSequence2, 0, (String) charSequence, a10, charSequence2.length(), z10)) {
                if (a10 == b10) {
                    return -1;
                }
                a10 += c10;
            }
            return a10;
        }
        int a11 = cVar.a();
        int b11 = cVar.b();
        int c11 = cVar.c();
        if ((c11 <= 0 || a11 > b11) && (c11 >= 0 || b11 > a11)) {
            return -1;
        }
        while (!H(charSequence2, 0, charSequence, a11, charSequence2.length(), z10)) {
            if (a11 == b11) {
                return -1;
            }
            a11 += c11;
        }
        return a11;
    }

    public static /* synthetic */ int w(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        return v(charSequence, charSequence2, i10, i11, z10, (i12 & 16) != 0 ? false : z11);
    }

    public static /* synthetic */ int x(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return t(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int y(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return u(charSequence, str, i10, z10);
    }

    public static final int z(CharSequence charSequence, char[] cArr, int i10, boolean z10) {
        boolean z11;
        t9.i.g(charSequence, "<this>");
        t9.i.g(cArr, "chars");
        if (!z10 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(i9.g.g(cArr), i10);
        }
        w it = new y9.c(y9.e.a(i10, 0), s(charSequence)).iterator();
        while (it.hasNext()) {
            int a10 = it.a();
            char charAt = charSequence.charAt(a10);
            int length = cArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    z11 = false;
                    break;
                }
                if (b.d(cArr[i11], charAt, z10)) {
                    z11 = true;
                    break;
                }
                i11++;
            }
            if (z11) {
                return a10;
            }
        }
        return -1;
    }
}
