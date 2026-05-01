package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetBlSearchByContentBean {
    private String contentId;
    private String portalCode;
    private String rows;
    private String userId;
    private String userToken;

    public GetBlSearchByContentBean(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str4, "contentId");
        i.g(str5, "rows");
        this.userToken = str;
        this.userId = str2;
        this.portalCode = str3;
        this.contentId = str4;
        this.rows = str5;
    }

    public static /* synthetic */ GetBlSearchByContentBean copy$default(GetBlSearchByContentBean getBlSearchByContentBean, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getBlSearchByContentBean.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = getBlSearchByContentBean.userId;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = getBlSearchByContentBean.portalCode;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = getBlSearchByContentBean.contentId;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = getBlSearchByContentBean.rows;
        }
        return getBlSearchByContentBean.copy(str, str6, str7, str8, str5);
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
        return this.rows;
    }

    public final GetBlSearchByContentBean copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str4, "contentId");
        i.g(str5, "rows");
        return new GetBlSearchByContentBean(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetBlSearchByContentBean)) {
            return false;
        }
        GetBlSearchByContentBean getBlSearchByContentBean = (GetBlSearchByContentBean) obj;
        return i.b(this.userToken, getBlSearchByContentBean.userToken) && i.b(this.userId, getBlSearchByContentBean.userId) && i.b(this.portalCode, getBlSearchByContentBean.portalCode) && i.b(this.contentId, getBlSearchByContentBean.contentId) && i.b(this.rows, getBlSearchByContentBean.rows);
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getPortalCode() {
        return this.portalCode;
    }

    public final String getRows() {
        return this.rows;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode()) * 31) + this.contentId.hashCode()) * 31) + this.rows.hashCode();
    }

    public final void setContentId(String str) {
        i.g(str, "<set-?>");
        this.contentId = str;
    }

    public final void setPortalCode(String str) {
        i.g(str, "<set-?>");
        this.portalCode = str;
    }

    public final void setRows(String str) {
        i.g(str, "<set-?>");
        this.rows = str;
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
        return "GetBlSearchByContentBean(userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ", contentId=" + this.contentId + ", rows=" + this.rows + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
