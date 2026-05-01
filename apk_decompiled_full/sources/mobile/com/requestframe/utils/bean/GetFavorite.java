package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetFavorite {
    private String blFlag;
    private String portalCode;
    private String queryType;
    private String userId;
    private String userToken;

    public GetFavorite(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str4, "queryType");
        i.g(str5, "blFlag");
        this.userToken = str;
        this.userId = str2;
        this.portalCode = str3;
        this.queryType = str4;
        this.blFlag = str5;
    }

    public static /* synthetic */ GetFavorite copy$default(GetFavorite getFavorite, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getFavorite.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = getFavorite.userId;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = getFavorite.portalCode;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = getFavorite.queryType;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = getFavorite.blFlag;
        }
        return getFavorite.copy(str, str6, str7, str8, str5);
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
        return this.queryType;
    }

    public final String component5() {
        return this.blFlag;
    }

    public final GetFavorite copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str4, "queryType");
        i.g(str5, "blFlag");
        return new GetFavorite(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetFavorite)) {
            return false;
        }
        GetFavorite getFavorite = (GetFavorite) obj;
        return i.b(this.userToken, getFavorite.userToken) && i.b(this.userId, getFavorite.userId) && i.b(this.portalCode, getFavorite.portalCode) && i.b(this.queryType, getFavorite.queryType) && i.b(this.blFlag, getFavorite.blFlag);
    }

    public final String getBlFlag() {
        return this.blFlag;
    }

    public final String getPortalCode() {
        return this.portalCode;
    }

    public final String getQueryType() {
        return this.queryType;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode()) * 31) + this.queryType.hashCode()) * 31) + this.blFlag.hashCode();
    }

    public final void setBlFlag(String str) {
        i.g(str, "<set-?>");
        this.blFlag = str;
    }

    public final void setPortalCode(String str) {
        i.g(str, "<set-?>");
        this.portalCode = str;
    }

    public final void setQueryType(String str) {
        i.g(str, "<set-?>");
        this.queryType = str;
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
        return "GetFavorite(userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ", queryType=" + this.queryType + ", blFlag=" + this.blFlag + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
