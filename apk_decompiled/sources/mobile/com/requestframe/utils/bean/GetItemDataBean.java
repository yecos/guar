package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class GetItemDataBean implements Serializable {
    private String contentId;
    private String language;
    private String portalCode;
    private String sortType;
    private String type;
    private String userId;
    private String userToken;

    public GetItemDataBean(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str4, "contentId");
        i.g(str5, "type");
        i.g(str6, "sortType");
        i.g(str7, "language");
        this.userToken = str;
        this.userId = str2;
        this.portalCode = str3;
        this.contentId = str4;
        this.type = str5;
        this.sortType = str6;
        this.language = str7;
    }

    public static /* synthetic */ GetItemDataBean copy$default(GetItemDataBean getItemDataBean, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getItemDataBean.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = getItemDataBean.userId;
        }
        String str8 = str2;
        if ((i10 & 4) != 0) {
            str3 = getItemDataBean.portalCode;
        }
        String str9 = str3;
        if ((i10 & 8) != 0) {
            str4 = getItemDataBean.contentId;
        }
        String str10 = str4;
        if ((i10 & 16) != 0) {
            str5 = getItemDataBean.type;
        }
        String str11 = str5;
        if ((i10 & 32) != 0) {
            str6 = getItemDataBean.sortType;
        }
        String str12 = str6;
        if ((i10 & 64) != 0) {
            str7 = getItemDataBean.language;
        }
        return getItemDataBean.copy(str, str8, str9, str10, str11, str12, str7);
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
        return this.contentId;
    }

    public final String component5() {
        return this.type;
    }

    public final String component6() {
        return this.sortType;
    }

    public final String component7() {
        return this.language;
    }

    public final GetItemDataBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str4, "contentId");
        i.g(str5, "type");
        i.g(str6, "sortType");
        i.g(str7, "language");
        return new GetItemDataBean(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetItemDataBean)) {
            return false;
        }
        GetItemDataBean getItemDataBean = (GetItemDataBean) obj;
        return i.b(this.userToken, getItemDataBean.userToken) && i.b(this.userId, getItemDataBean.userId) && i.b(this.portalCode, getItemDataBean.portalCode) && i.b(this.contentId, getItemDataBean.contentId) && i.b(this.type, getItemDataBean.type) && i.b(this.sortType, getItemDataBean.sortType) && i.b(this.language, getItemDataBean.language);
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getPortalCode() {
        return this.portalCode;
    }

    public final String getSortType() {
        return this.sortType;
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
        return (((((((((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode()) * 31) + this.contentId.hashCode()) * 31) + this.type.hashCode()) * 31) + this.sortType.hashCode()) * 31) + this.language.hashCode();
    }

    public final void setContentId(String str) {
        i.g(str, "<set-?>");
        this.contentId = str;
    }

    public final void setLanguage(String str) {
        i.g(str, "<set-?>");
        this.language = str;
    }

    public final void setPortalCode(String str) {
        i.g(str, "<set-?>");
        this.portalCode = str;
    }

    public final void setSortType(String str) {
        i.g(str, "<set-?>");
        this.sortType = str;
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
        return "GetItemDataBean(userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ", contentId=" + this.contentId + ", type=" + this.type + ", sortType=" + this.sortType + ", language=" + this.language + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
