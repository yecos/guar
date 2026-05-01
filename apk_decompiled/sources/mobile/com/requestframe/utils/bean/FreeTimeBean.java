package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class FreeTimeBean {
    private String portalCode;
    private String userId;
    private String userToken;

    public FreeTimeBean(String str, String str2, String str3) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        this.userToken = str;
        this.userId = str2;
        this.portalCode = str3;
    }

    public static /* synthetic */ FreeTimeBean copy$default(FreeTimeBean freeTimeBean, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = freeTimeBean.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = freeTimeBean.userId;
        }
        if ((i10 & 4) != 0) {
            str3 = freeTimeBean.portalCode;
        }
        return freeTimeBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.userToken;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.portalCode;
    }

    public final FreeTimeBean copy(String str, String str2, String str3) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        return new FreeTimeBean(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FreeTimeBean)) {
            return false;
        }
        FreeTimeBean freeTimeBean = (FreeTimeBean) obj;
        return i.b(this.userToken, freeTimeBean.userToken) && i.b(this.userId, freeTimeBean.userId) && i.b(this.portalCode, freeTimeBean.portalCode);
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
        return (((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode();
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
        return "FreeTimeBean(userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
