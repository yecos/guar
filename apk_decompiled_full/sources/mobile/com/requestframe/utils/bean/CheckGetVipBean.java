package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class CheckGetVipBean {
    private String macAddr;
    private String portalCode;
    private String userId;
    private String userToken;

    public CheckGetVipBean(String str, String str2, String str3, String str4) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str3, "portalCode");
        i.g(str4, "macAddr");
        this.userId = str;
        this.userToken = str2;
        this.portalCode = str3;
        this.macAddr = str4;
    }

    public static /* synthetic */ CheckGetVipBean copy$default(CheckGetVipBean checkGetVipBean, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = checkGetVipBean.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = checkGetVipBean.userToken;
        }
        if ((i10 & 4) != 0) {
            str3 = checkGetVipBean.portalCode;
        }
        if ((i10 & 8) != 0) {
            str4 = checkGetVipBean.macAddr;
        }
        return checkGetVipBean.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userToken;
    }

    public final String component3() {
        return this.portalCode;
    }

    public final String component4() {
        return this.macAddr;
    }

    public final CheckGetVipBean copy(String str, String str2, String str3, String str4) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str3, "portalCode");
        i.g(str4, "macAddr");
        return new CheckGetVipBean(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckGetVipBean)) {
            return false;
        }
        CheckGetVipBean checkGetVipBean = (CheckGetVipBean) obj;
        return i.b(this.userId, checkGetVipBean.userId) && i.b(this.userToken, checkGetVipBean.userToken) && i.b(this.portalCode, checkGetVipBean.portalCode) && i.b(this.macAddr, checkGetVipBean.macAddr);
    }

    public final String getMacAddr() {
        return this.macAddr;
    }

    public final String getPortalCode() {
        return this.portalCode;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((((this.userId.hashCode() * 31) + this.userToken.hashCode()) * 31) + this.portalCode.hashCode()) * 31) + this.macAddr.hashCode();
    }

    public final void setMacAddr(String str) {
        i.g(str, "<set-?>");
        this.macAddr = str;
    }

    public final void setPortalCode(String str) {
        i.g(str, "<set-?>");
        this.portalCode = str;
    }

    public final void setUserId(String str) {
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public final void setUserToken(String str) {
        i.g(str, "<set-?>");
        this.userToken = str;
    }

    public String toString() {
        return "CheckGetVipBean(userId=" + this.userId + ", userToken=" + this.userToken + ", portalCode=" + this.portalCode + ", macAddr=" + this.macAddr + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
