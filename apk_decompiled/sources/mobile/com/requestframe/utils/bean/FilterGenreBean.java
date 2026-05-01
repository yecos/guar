package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class FilterGenreBean {
    private String language;
    private String portalCode;
    private String userId;
    private String userToken;

    public FilterGenreBean(String str, String str2, String str3, String str4) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        this.userToken = str;
        this.userId = str2;
        this.portalCode = str3;
        this.language = str4;
    }

    public static /* synthetic */ FilterGenreBean copy$default(FilterGenreBean filterGenreBean, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = filterGenreBean.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = filterGenreBean.userId;
        }
        if ((i10 & 4) != 0) {
            str3 = filterGenreBean.portalCode;
        }
        if ((i10 & 8) != 0) {
            str4 = filterGenreBean.language;
        }
        return filterGenreBean.copy(str, str2, str3, str4);
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
        return this.language;
    }

    public final FilterGenreBean copy(String str, String str2, String str3, String str4) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        return new FilterGenreBean(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterGenreBean)) {
            return false;
        }
        FilterGenreBean filterGenreBean = (FilterGenreBean) obj;
        return i.b(this.userToken, filterGenreBean.userToken) && i.b(this.userId, filterGenreBean.userId) && i.b(this.portalCode, filterGenreBean.portalCode) && i.b(this.language, filterGenreBean.language);
    }

    public final String getLanguage() {
        return this.language;
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
        int hashCode = ((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode()) * 31;
        String str = this.language;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setLanguage(String str) {
        this.language = str;
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
        return "FilterGenreBean(userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ", language=" + this.language + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
