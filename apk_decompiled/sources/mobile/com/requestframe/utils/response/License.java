package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class License {
    private String license;
    private String tag;

    public License(String str, String str2) {
        i.g(str, "tag");
        i.g(str2, "license");
        this.tag = str;
        this.license = str2;
    }

    public static /* synthetic */ License copy$default(License license, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = license.tag;
        }
        if ((i10 & 2) != 0) {
            str2 = license.license;
        }
        return license.copy(str, str2);
    }

    public final String component1() {
        return this.tag;
    }

    public final String component2() {
        return this.license;
    }

    public final License copy(String str, String str2) {
        i.g(str, "tag");
        i.g(str2, "license");
        return new License(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof License)) {
            return false;
        }
        License license = (License) obj;
        return i.b(this.tag, license.tag) && i.b(this.license, license.license);
    }

    public final String getLicense() {
        return this.license;
    }

    public final String getTag() {
        return this.tag;
    }

    public int hashCode() {
        return (this.tag.hashCode() * 31) + this.license.hashCode();
    }

    public final void setLicense(String str) {
        i.g(str, "<set-?>");
        this.license = str;
    }

    public final void setTag(String str) {
        i.g(str, "<set-?>");
        this.tag = str;
    }

    public String toString() {
        return "License(tag=" + this.tag + ", license=" + this.license + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
