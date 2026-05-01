package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetProgramBean {
    private String channelCode;
    private int columnId;
    private String portalCode;
    private String type;
    private String userId;
    private String userToken;

    public GetProgramBean(String str, String str2, int i10, String str3, String str4, String str5) {
        i.g(str, "portalCode");
        i.g(str2, "channelCode");
        i.g(str3, "type");
        i.g(str4, "userId");
        i.g(str5, "userToken");
        this.portalCode = str;
        this.channelCode = str2;
        this.columnId = i10;
        this.type = str3;
        this.userId = str4;
        this.userToken = str5;
    }

    public static /* synthetic */ GetProgramBean copy$default(GetProgramBean getProgramBean, String str, String str2, int i10, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = getProgramBean.portalCode;
        }
        if ((i11 & 2) != 0) {
            str2 = getProgramBean.channelCode;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            i10 = getProgramBean.columnId;
        }
        int i12 = i10;
        if ((i11 & 8) != 0) {
            str3 = getProgramBean.type;
        }
        String str7 = str3;
        if ((i11 & 16) != 0) {
            str4 = getProgramBean.userId;
        }
        String str8 = str4;
        if ((i11 & 32) != 0) {
            str5 = getProgramBean.userToken;
        }
        return getProgramBean.copy(str, str6, i12, str7, str8, str5);
    }

    public final String component1() {
        return this.portalCode;
    }

    public final String component2() {
        return this.channelCode;
    }

    public final int component3() {
        return this.columnId;
    }

    public final String component4() {
        return this.type;
    }

    public final String component5() {
        return this.userId;
    }

    public final String component6() {
        return this.userToken;
    }

    public final GetProgramBean copy(String str, String str2, int i10, String str3, String str4, String str5) {
        i.g(str, "portalCode");
        i.g(str2, "channelCode");
        i.g(str3, "type");
        i.g(str4, "userId");
        i.g(str5, "userToken");
        return new GetProgramBean(str, str2, i10, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetProgramBean)) {
            return false;
        }
        GetProgramBean getProgramBean = (GetProgramBean) obj;
        return i.b(this.portalCode, getProgramBean.portalCode) && i.b(this.channelCode, getProgramBean.channelCode) && this.columnId == getProgramBean.columnId && i.b(this.type, getProgramBean.type) && i.b(this.userId, getProgramBean.userId) && i.b(this.userToken, getProgramBean.userToken);
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final int getColumnId() {
        return this.columnId;
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
        return (((((((((this.portalCode.hashCode() * 31) + this.channelCode.hashCode()) * 31) + this.columnId) * 31) + this.type.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.userToken.hashCode();
    }

    public final void setChannelCode(String str) {
        i.g(str, "<set-?>");
        this.channelCode = str;
    }

    public final void setColumnId(int i10) {
        this.columnId = i10;
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
        return "GetProgramBean(portalCode=" + this.portalCode + ", channelCode=" + this.channelCode + ", columnId=" + this.columnId + ", type=" + this.type + ", userId=" + this.userId + ", userToken=" + this.userToken + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
