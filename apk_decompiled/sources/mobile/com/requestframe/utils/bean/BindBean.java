package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class BindBean {
    private String accountType;
    private String portalCode;
    private String thirdpartToken;
    private String userId;
    private String userToken;

    public BindBean(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str3, "portalCode");
        i.g(str4, "accountType");
        i.g(str5, "thirdpartToken");
        this.userId = str;
        this.userToken = str2;
        this.portalCode = str3;
        this.accountType = str4;
        this.thirdpartToken = str5;
    }

    public static /* synthetic */ BindBean copy$default(BindBean bindBean, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = bindBean.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = bindBean.userToken;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = bindBean.portalCode;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = bindBean.accountType;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = bindBean.thirdpartToken;
        }
        return bindBean.copy(str, str6, str7, str8, str5);
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
        return this.accountType;
    }

    public final String component5() {
        return this.thirdpartToken;
    }

    public final BindBean copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str3, "portalCode");
        i.g(str4, "accountType");
        i.g(str5, "thirdpartToken");
        return new BindBean(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BindBean)) {
            return false;
        }
        BindBean bindBean = (BindBean) obj;
        return i.b(this.userId, bindBean.userId) && i.b(this.userToken, bindBean.userToken) && i.b(this.portalCode, bindBean.portalCode) && i.b(this.accountType, bindBean.accountType) && i.b(this.thirdpartToken, bindBean.thirdpartToken);
    }

    public final String getAccountType() {
        return this.accountType;
    }

    public final String getPortalCode() {
        return this.portalCode;
    }

    public final String getThirdpartToken() {
        return this.thirdpartToken;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((((((this.userId.hashCode() * 31) + this.userToken.hashCode()) * 31) + this.portalCode.hashCode()) * 31) + this.accountType.hashCode()) * 31) + this.thirdpartToken.hashCode();
    }

    public final void setAccountType(String str) {
        i.g(str, "<set-?>");
        this.accountType = str;
    }

    public final void setPortalCode(String str) {
        i.g(str, "<set-?>");
        this.portalCode = str;
    }

    public final void setThirdpartToken(String str) {
        i.g(str, "<set-?>");
        this.thirdpartToken = str;
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
        return "BindBean(userId=" + this.userId + ", userToken=" + this.userToken + ", portalCode=" + this.portalCode + ", accountType=" + this.accountType + ", thirdpartToken=" + this.thirdpartToken + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
