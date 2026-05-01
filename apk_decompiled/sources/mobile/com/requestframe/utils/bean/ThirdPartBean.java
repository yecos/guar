package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ThirdPartBean {
    private String portalCode;

    public ThirdPartBean(String str) {
        i.g(str, "portalCode");
        this.portalCode = str;
    }

    public static /* synthetic */ ThirdPartBean copy$default(ThirdPartBean thirdPartBean, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = thirdPartBean.portalCode;
        }
        return thirdPartBean.copy(str);
    }

    public final String component1() {
        return this.portalCode;
    }

    public final ThirdPartBean copy(String str) {
        i.g(str, "portalCode");
        return new ThirdPartBean(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ThirdPartBean) && i.b(this.portalCode, ((ThirdPartBean) obj).portalCode);
    }

    public final String getPortalCode() {
        return this.portalCode;
    }

    public int hashCode() {
        return this.portalCode.hashCode();
    }

    public final void setPortalCode(String str) {
        i.g(str, "<set-?>");
        this.portalCode = str;
    }

    public String toString() {
        return "ThirdPartBean(portalCode=" + this.portalCode + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
