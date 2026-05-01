package x;

import android.os.Build;
import android.os.LocaleList;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.Locale;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final g f19275b = a(new Locale[0]);

    /* renamed from: a, reason: collision with root package name */
    public i f19276a;

    public g(i iVar) {
        this.f19276a = iVar;
    }

    public static g a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? d(new LocaleList(localeArr)) : new g(new h(localeArr));
    }

    public static Locale b(String str) {
        if (str.contains(Operator.Operation.MINUS)) {
            String[] split = str.split(Operator.Operation.MINUS, -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else {
            if (!str.contains("_")) {
                return new Locale(str);
            }
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public static g d(LocaleList localeList) {
        return new g(new n(localeList));
    }

    public Locale c(int i10) {
        return this.f19276a.get(i10);
    }

    public boolean equals(Object obj) {
        return (obj instanceof g) && this.f19276a.equals(((g) obj).f19276a);
    }

    public int hashCode() {
        return this.f19276a.hashCode();
    }

    public String toString() {
        return this.f19276a.toString();
    }
}
