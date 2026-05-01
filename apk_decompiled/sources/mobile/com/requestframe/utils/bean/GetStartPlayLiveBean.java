package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetStartPlayLiveBean {
    private String channelCode;
    private Integer columnId;
    private String portalCode;
    private String type;
    private String url;
    private String userId;
    private String userToken;

    public GetStartPlayLiveBean(String str, String str2, String str3, String str4, Integer num, String str5, String str6) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str4, "type");
        i.g(str5, "channelCode");
        i.g(str6, "url");
        this.userToken = str;
        this.userId = str2;
        this.portalCode = str3;
        this.type = str4;
        this.columnId = num;
        this.channelCode = str5;
        this.url = str6;
    }

    public static /* synthetic */ GetStartPlayLiveBean copy$default(GetStartPlayLiveBean getStartPlayLiveBean, String str, String str2, String str3, String str4, Integer num, String str5, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getStartPlayLiveBean.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = getStartPlayLiveBean.userId;
        }
        String str7 = str2;
        if ((i10 & 4) != 0) {
            str3 = getStartPlayLiveBean.portalCode;
        }
        String str8 = str3;
        if ((i10 & 8) != 0) {
            str4 = getStartPlayLiveBean.type;
        }
        String str9 = str4;
        if ((i10 & 16) != 0) {
            num = getStartPlayLiveBean.columnId;
        }
        Integer num2 = num;
        if ((i10 & 32) != 0) {
            str5 = getStartPlayLiveBean.channelCode;
        }
        String str10 = str5;
        if ((i10 & 64) != 0) {
            str6 = getStartPlayLiveBean.url;
        }
        return getStartPlayLiveBean.copy(str, str7, str8, str9, num2, str10, str6);
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
        return this.type;
    }

    public final Integer component5() {
        return this.columnId;
    }

    public final String component6() {
        return this.channelCode;
    }

    public final String component7() {
        return this.url;
    }

    public final GetStartPlayLiveBean copy(String str, String str2, String str3, String str4, Integer num, String str5, String str6) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str4, "type");
        i.g(str5, "channelCode");
        i.g(str6, "url");
        return new GetStartPlayLiveBean(str, str2, str3, str4, num, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetStartPlayLiveBean)) {
            return false;
        }
        GetStartPlayLiveBean getStartPlayLiveBean = (GetStartPlayLiveBean) obj;
        return i.b(this.userToken, getStartPlayLiveBean.userToken) && i.b(this.userId, getStartPlayLiveBean.userId) && i.b(this.portalCode, getStartPlayLiveBean.portalCode) && i.b(this.type, getStartPlayLiveBean.type) && i.b(this.columnId, getStartPlayLiveBean.columnId) && i.b(this.channelCode, getStartPlayLiveBean.channelCode) && i.b(this.url, getStartPlayLiveBean.url);
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final Integer getColumnId() {
        return this.columnId;
    }

    public final String getPortalCode() {
        return this.portalCode;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        int hashCode = ((((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode()) * 31) + this.type.hashCode()) * 31;
        Integer num = this.columnId;
        return ((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.channelCode.hashCode()) * 31) + this.url.hashCode();
    }

    public final void setChannelCode(String str) {
        i.g(str, "<set-?>");
        this.channelCode = str;
    }

    public final void setColumnId(Integer num) {
        this.columnId = num;
    }

    public final void setPortalCode(String str) {
        i.g(str, "<set-?>");
        this.portalCode = str;
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
    }

    public final void setUrl(String str) {
        i.g(str, "<set-?>");
        this.url = str;
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
        return "GetStartPlayLiveBean(userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ", type=" + this.type + ", columnId=" + this.columnId + ", channelCode=" + this.channelCode + ", url=" + this.url + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
