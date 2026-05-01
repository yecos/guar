package na;

import ba.t;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f17347a = new g();

    public final String a(String str) {
        i.g(str, "str");
        if (str.length() == 0) {
            return "";
        }
        List M = t.M(str, new String[]{"."}, false, 0, 6, null);
        String str2 = (String) M.get(0);
        if (M.size() <= 1) {
            return str2;
        }
        CharSequence charSequence = (CharSequence) M.get(1);
        if (charSequence == null || charSequence.length() == 0) {
            return str2;
        }
        if (((String) M.get(1)).length() < 3) {
            return str2 + '.' + ((String) M.get(1));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append('.');
        String substring = ((String) M.get(1)).substring(0, 3);
        i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(substring);
        return sb.toString();
    }
}
