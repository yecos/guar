package x;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class n implements i {

    /* renamed from: a, reason: collision with root package name */
    public final LocaleList f19283a;

    public n(LocaleList localeList) {
        this.f19283a = localeList;
    }

    @Override // x.i
    public Object a() {
        return this.f19283a;
    }

    public boolean equals(Object obj) {
        boolean equals;
        equals = this.f19283a.equals(((i) obj).a());
        return equals;
    }

    @Override // x.i
    public Locale get(int i10) {
        Locale locale;
        locale = this.f19283a.get(i10);
        return locale;
    }

    public int hashCode() {
        int hashCode;
        hashCode = this.f19283a.hashCode();
        return hashCode;
    }

    public String toString() {
        String localeList;
        localeList = this.f19283a.toString();
        return localeList;
    }
}
