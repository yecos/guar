package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetHomeBean {
    private String freeVersion;
    private String freeVodCode;
    private String homePageCode;
    private String portalCode;
    private String userId;
    private String userToken;
    private String version;

    public GetHomeBean(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        i.g(str, "homePageCode");
        i.g(str2, "version");
        i.g(str3, "freeVodCode");
        i.g(str4, "freeVersion");
        i.g(str5, "userId");
        i.g(str6, "userToken");
        i.g(str7, "portalCode");
        this.homePageCode = str;
        this.version = str2;
        this.freeVodCode = str3;
        this.freeVersion = str4;
        this.userId = str5;
        this.userToken = str6;
        this.portalCode = str7;
    }

    public static /* synthetic */ GetHomeBean copy$default(GetHomeBean getHomeBean, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getHomeBean.homePageCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getHomeBean.version;
        }
        String str8 = str2;
        if ((i10 & 4) != 0) {
            str3 = getHomeBean.freeVodCode;
        }
        String str9 = str3;
        if ((i10 & 8) != 0) {
            str4 = getHomeBean.freeVersion;
        }
        String str10 = str4;
        if ((i10 & 16) != 0) {
            str5 = getHomeBean.userId;
        }
        String str11 = str5;
        if ((i10 & 32) != 0) {
            str6 = getHomeBean.userToken;
        }
        String str12 = str6;
        if ((i10 & 64) != 0) {
            str7 = getHomeBean.portalCode;
        }
        return getHomeBean.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.homePageCode;
    }

    public final String component2() {
        return this.version;
    }

    public final String component3() {
        return this.freeVodCode;
    }

    public final String component4() {
        return this.freeVersion;
    }

    public final String component5() {
        return this.userId;
    }

    public final String component6() {
        return this.userToken;
    }

    public final String component7() {
        return this.portalCode;
    }

    public final GetHomeBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        i.g(str, "homePageCode");
        i.g(str2, "version");
        i.g(str3, "freeVodCode");
        i.g(str4, "freeVersion");
        i.g(str5, "userId");
        i.g(str6, "userToken");
        i.g(str7, "portalCode");
        return new GetHomeBean(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetHomeBean)) {
            return false;
        }
        GetHomeBean getHomeBean = (GetHomeBean) obj;
        return i.b(this.homePageCode, getHomeBean.homePageCode) && i.b(this.version, getHomeBean.version) && i.b(this.freeVodCode, getHomeBean.freeVodCode) && i.b(this.freeVersion, getHomeBean.freeVersion) && i.b(this.userId, getHomeBean.userId) && i.b(this.userToken, getHomeBean.userToken) && i.b(this.portalCode, getHomeBean.portalCode);
    }

    public final String getFreeVersion() {
        return this.freeVersion;
    }

    public final String getFreeVodCode() {
        return this.freeVodCode;
    }

    public final String getHomePageCode() {
        return this.homePageCode;
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

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((this.homePageCode.hashCode() * 31) + this.version.hashCode()) * 31) + this.freeVodCode.hashCode()) * 31) + this.freeVersion.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.userToken.hashCode()) * 31) + this.portalCode.hashCode();
    }

    public final void setFreeVersion(String str) {
        i.g(str, "<set-?>");
        this.freeVersion = str;
    }

    public final void setFreeVodCode(String str) {
        i.g(str, "<set-?>");
        this.freeVodCode = str;
    }

    public final void setHomePageCode(String str) {
        i.g(str, "<set-?>");
        this.homePageCode = str;
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

    public final void setVersion(String str) {
        i.g(str, "<set-?>");
        this.version = str;
    }

    public String toString() {
        return "GetHomeBean(homePageCode=" + this.homePageCode + ", version=" + this.version + ", freeVodCode=" + this.freeVodCode + ", freeVersion=" + this.freeVersion + ", userId=" + this.userId + ", userToken=" + this.userToken + ", portalCode=" + this.portalCode + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
