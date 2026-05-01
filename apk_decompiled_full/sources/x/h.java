package x;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.xml.XML;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: classes.dex */
public final class h implements i {

    /* renamed from: c, reason: collision with root package name */
    public static final Locale[] f19277c = new Locale[0];

    /* renamed from: d, reason: collision with root package name */
    public static final Locale f19278d = new Locale(XML.DEFAULT_CONTENT_LANGUAGE, "XA");

    /* renamed from: e, reason: collision with root package name */
    public static final Locale f19279e = new Locale("ar", "XB");

    /* renamed from: f, reason: collision with root package name */
    public static final Locale f19280f = g.b("en-Latn");

    /* renamed from: a, reason: collision with root package name */
    public final Locale[] f19281a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19282b;

    public h(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f19281a = f19277c;
            this.f19282b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < localeArr.length; i10++) {
            Locale locale = localeArr[i10];
            if (locale == null) {
                throw new NullPointerException("list[" + i10 + "] is null");
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                b(sb, locale2);
                if (i10 < localeArr.length - 1) {
                    sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
                }
                hashSet.add(locale2);
            }
        }
        this.f19281a = (Locale[]) arrayList.toArray(new Locale[arrayList.size()]);
        this.f19282b = sb.toString();
    }

    public static void b(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
        sb.append(locale.getCountry());
    }

    @Override // x.i
    public Object a() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        Locale[] localeArr = ((h) obj).f19281a;
        if (this.f19281a.length != localeArr.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            Locale[] localeArr2 = this.f19281a;
            if (i10 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i10].equals(localeArr[i10])) {
                return false;
            }
            i10++;
        }
    }

    @Override // x.i
    public Locale get(int i10) {
        if (i10 >= 0) {
            Locale[] localeArr = this.f19281a;
            if (i10 < localeArr.length) {
                return localeArr[i10];
            }
        }
        return null;
    }

    public int hashCode() {
        int i10 = 1;
        int i11 = 0;
        while (true) {
            Locale[] localeArr = this.f19281a;
            if (i11 >= localeArr.length) {
                return i10;
            }
            i10 = (i10 * 31) + localeArr[i11].hashCode();
            i11++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i10 = 0;
        while (true) {
            Locale[] localeArr = this.f19281a;
            if (i10 >= localeArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(localeArr[i10]);
            if (i10 < this.f19281a.length - 1) {
                sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
            }
            i10++;
        }
    }
}
