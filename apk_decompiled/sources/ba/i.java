package ba;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class i implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final a f5239b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Pattern f5240a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }
    }

    public i(Pattern pattern) {
        t9.i.g(pattern, "nativePattern");
        this.f5240a = pattern;
    }

    public static /* synthetic */ g b(i iVar, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return iVar.a(charSequence, i10);
    }

    public final g a(CharSequence charSequence, int i10) {
        g d10;
        t9.i.g(charSequence, "input");
        Matcher matcher = this.f5240a.matcher(charSequence);
        t9.i.f(matcher, "nativePattern.matcher(input)");
        d10 = j.d(matcher, i10, charSequence);
        return d10;
    }

    public final String c(CharSequence charSequence, String str) {
        t9.i.g(charSequence, "input");
        t9.i.g(str, "replacement");
        String replaceAll = this.f5240a.matcher(charSequence).replaceAll(str);
        t9.i.f(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final String d(CharSequence charSequence, s9.l lVar) {
        t9.i.g(charSequence, "input");
        t9.i.g(lVar, "transform");
        int i10 = 0;
        g b10 = b(this, charSequence, 0, 2, null);
        if (b10 == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(charSequence, i10, b10.getRange().h().intValue());
            sb.append((CharSequence) lVar.invoke(b10));
            i10 = b10.getRange().g().intValue() + 1;
            b10 = b10.next();
            if (i10 >= length) {
                break;
            }
        } while (b10 != null);
        if (i10 < length) {
            sb.append(charSequence, i10, length);
        }
        String sb2 = sb.toString();
        t9.i.f(sb2, "sb.toString()");
        return sb2;
    }

    public final List e(CharSequence charSequence, int i10) {
        t9.i.g(charSequence, "input");
        t.J(i10);
        Matcher matcher = this.f5240a.matcher(charSequence);
        if (i10 == 1 || !matcher.find()) {
            return i9.i.b(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(i10 > 0 ? y9.e.b(i10, 10) : 10);
        int i11 = i10 - 1;
        int i12 = 0;
        do {
            arrayList.add(charSequence.subSequence(i12, matcher.start()).toString());
            i12 = matcher.end();
            if (i11 >= 0 && arrayList.size() == i11) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(i12, charSequence.length()).toString());
        return arrayList;
    }

    public String toString() {
        String pattern = this.f5240a.toString();
        t9.i.f(pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public i(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            t9.i.g(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(pattern)"
            t9.i.f(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ba.i.<init>(java.lang.String):void");
    }
}
