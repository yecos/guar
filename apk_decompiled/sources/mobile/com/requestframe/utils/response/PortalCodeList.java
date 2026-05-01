package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class PortalCodeList {
    private String portalCode;
    private String type;

    public PortalCodeList(String str, String str2) {
        i.g(str, "portalCode");
        this.portalCode = str;
        this.type = str2;
    }

    public static /* synthetic */ PortalCodeList copy$default(PortalCodeList portalCodeList, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = portalCodeList.portalCode;
        }
        if ((i10 & 2) != 0) {
            str2 = portalCodeList.type;
        }
        return portalCodeList.copy(str, str2);
    }

    public final String component1() {
        return this.portalCode;
    }

    public final String component2() {
        return this.type;
    }

    public final PortalCodeList copy(String str, String str2) {
        i.g(str, "portalCode");
        return new PortalCodeList(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PortalCodeList)) {
            return false;
        }
        PortalCodeList portalCodeList = (PortalCodeList) obj;
        return i.b(this.portalCode, portalCodeList.portalCode) && i.b(this.type, portalCodeList.type);
    }

    public final String getPortalCode() {
        return this.portalCode;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.portalCode.hashCode() * 31;
        String str = this.type;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setPortalCode(String str) {
        i.g(str, "<set-?>");
        this.portalCode = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "PortalCodeList(portalCode=" + this.portalCode + ", type=" + this.type + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
