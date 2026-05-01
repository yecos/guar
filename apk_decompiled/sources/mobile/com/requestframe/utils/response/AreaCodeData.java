package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class AreaCodeData {
    private String areaCode;

    public AreaCodeData(String str) {
        i.g(str, "areaCode");
        this.areaCode = str;
    }

    public static /* synthetic */ AreaCodeData copy$default(AreaCodeData areaCodeData, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = areaCodeData.areaCode;
        }
        return areaCodeData.copy(str);
    }

    public final String component1() {
        return this.areaCode;
    }

    public final AreaCodeData copy(String str) {
        i.g(str, "areaCode");
        return new AreaCodeData(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AreaCodeData) && i.b(this.areaCode, ((AreaCodeData) obj).areaCode);
    }

    public final String getAreaCode() {
        return this.areaCode;
    }

    public int hashCode() {
        return this.areaCode.hashCode();
    }

    public final void setAreaCode(String str) {
        i.g(str, "<set-?>");
        this.areaCode = str;
    }

    public String toString() {
        return "AreaCodeData(areaCode=" + this.areaCode + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
