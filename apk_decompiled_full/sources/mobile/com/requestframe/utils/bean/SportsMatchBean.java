package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class SportsMatchBean {
    private String match;
    private String portalCode;
    private String userId;
    private String userToken;

    public SportsMatchBean(String str, String str2, String str3, String str4) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str4, "match");
        this.userToken = str;
        this.userId = str2;
        this.portalCode = str3;
        this.match = str4;
    }

    public static /* synthetic */ SportsMatchBean copy$default(SportsMatchBean sportsMatchBean, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = sportsMatchBean.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = sportsMatchBean.userId;
        }
        if ((i10 & 4) != 0) {
            str3 = sportsMatchBean.portalCode;
        }
        if ((i10 & 8) != 0) {
            str4 = sportsMatchBean.match;
        }
        return sportsMatchBean.copy(str, str2, str3, str4);
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

    public final String component4() {
        return this.match;
    }

    public final SportsMatchBean copy(String str, String str2, String str3, String str4) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str4, "match");
        return new SportsMatchBean(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SportsMatchBean)) {
            return false;
        }
        SportsMatchBean sportsMatchBean = (SportsMatchBean) obj;
        return i.b(this.userToken, sportsMatchBean.userToken) && i.b(this.userId, sportsMatchBean.userId) && i.b(this.portalCode, sportsMatchBean.portalCode) && i.b(this.match, sportsMatchBean.match);
    }

    public final String getMatch() {
        return this.match;
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
        return (((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode()) * 31) + this.match.hashCode();
    }

    public final void setMatch(String str) {
        i.g(str, "<set-?>");
        this.match = str;
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
        return "SportsMatchBean(userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ", match=" + this.match + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
