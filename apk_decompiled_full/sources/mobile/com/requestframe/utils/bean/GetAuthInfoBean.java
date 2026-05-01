package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetAuthInfoBean {
    private String lang;
    private String portalCode;
    private String type;
    private String userId;
    private String userToken;

    public GetAuthInfoBean(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "type");
        i.g(str4, "portalCode");
        i.g(str5, "lang");
        this.userToken = str;
        this.userId = str2;
        this.type = str3;
        this.portalCode = str4;
        this.lang = str5;
    }

    public static /* synthetic */ GetAuthInfoBean copy$default(GetAuthInfoBean getAuthInfoBean, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getAuthInfoBean.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = getAuthInfoBean.userId;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = getAuthInfoBean.type;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = getAuthInfoBean.portalCode;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = getAuthInfoBean.lang;
        }
        return getAuthInfoBean.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.userToken;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.portalCode;
    }

    public final String component5() {
        return this.lang;
    }

    public final GetAuthInfoBean copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "type");
        i.g(str4, "portalCode");
        i.g(str5, "lang");
        return new GetAuthInfoBean(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAuthInfoBean)) {
            return false;
        }
        GetAuthInfoBean getAuthInfoBean = (GetAuthInfoBean) obj;
        return i.b(this.userToken, getAuthInfoBean.userToken) && i.b(this.userId, getAuthInfoBean.userId) && i.b(this.type, getAuthInfoBean.type) && i.b(this.portalCode, getAuthInfoBean.portalCode) && i.b(this.lang, getAuthInfoBean.lang);
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getPortalCode() {
        return this.portalCode;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.type.hashCode()) * 31) + this.portalCode.hashCode()) * 31) + this.lang.hashCode();
    }

    public final void setLang(String str) {
        i.g(str, "<set-?>");
        this.lang = str;
    }

    public final void setPortalCode(String str) {
        i.g(str, "<set-?>");
        this.portalCode = str;
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
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
        return "GetAuthInfoBean(userToken=" + this.userToken + ", userId=" + this.userId + ", type=" + this.type + ", portalCode=" + this.portalCode + ", lang=" + this.lang + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
