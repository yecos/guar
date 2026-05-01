package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class FilterInfo {
    private String key;
    private String value;

    public FilterInfo(String str, String str2) {
        i.g(str, "key");
        i.g(str2, "value");
        this.key = str;
        this.value = str2;
    }

    public static /* synthetic */ FilterInfo copy$default(FilterInfo filterInfo, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = filterInfo.key;
        }
        if ((i10 & 2) != 0) {
            str2 = filterInfo.value;
        }
        return filterInfo.copy(str, str2);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.value;
    }

    public final FilterInfo copy(String str, String str2) {
        i.g(str, "key");
        i.g(str2, "value");
        return new FilterInfo(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterInfo)) {
            return false;
        }
        FilterInfo filterInfo = (FilterInfo) obj;
        return i.b(this.key, filterInfo.key) && i.b(this.value, filterInfo.value);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + this.value.hashCode();
    }

    public final void setKey(String str) {
        i.g(str, "<set-?>");
        this.key = str;
    }

    public final void setValue(String str) {
        i.g(str, "<set-?>");
        this.value = str;
    }

    public String toString() {
        return "FilterInfo(key=" + this.key + ", value=" + this.value + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
