package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetNextColumnBean {
    private String columnCode;
    private int pageNum;
    private Integer pageSize;
    private String portalCode;
    private String userId;
    private String userToken;
    private String version;

    public GetNextColumnBean(String str, String str2, String str3, int i10, Integer num, String str4, String str5) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str3, "portalCode");
        i.g(str4, "columnCode");
        i.g(str5, "version");
        this.userId = str;
        this.userToken = str2;
        this.portalCode = str3;
        this.pageNum = i10;
        this.pageSize = num;
        this.columnCode = str4;
        this.version = str5;
    }

    public static /* synthetic */ GetNextColumnBean copy$default(GetNextColumnBean getNextColumnBean, String str, String str2, String str3, int i10, Integer num, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = getNextColumnBean.userId;
        }
        if ((i11 & 2) != 0) {
            str2 = getNextColumnBean.userToken;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = getNextColumnBean.portalCode;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            i10 = getNextColumnBean.pageNum;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            num = getNextColumnBean.pageSize;
        }
        Integer num2 = num;
        if ((i11 & 32) != 0) {
            str4 = getNextColumnBean.columnCode;
        }
        String str8 = str4;
        if ((i11 & 64) != 0) {
            str5 = getNextColumnBean.version;
        }
        return getNextColumnBean.copy(str, str6, str7, i12, num2, str8, str5);
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

    public final int component4() {
        return this.pageNum;
    }

    public final Integer component5() {
        return this.pageSize;
    }

    public final String component6() {
        return this.columnCode;
    }

    public final String component7() {
        return this.version;
    }

    public final GetNextColumnBean copy(String str, String str2, String str3, int i10, Integer num, String str4, String str5) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str3, "portalCode");
        i.g(str4, "columnCode");
        i.g(str5, "version");
        return new GetNextColumnBean(str, str2, str3, i10, num, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetNextColumnBean)) {
            return false;
        }
        GetNextColumnBean getNextColumnBean = (GetNextColumnBean) obj;
        return i.b(this.userId, getNextColumnBean.userId) && i.b(this.userToken, getNextColumnBean.userToken) && i.b(this.portalCode, getNextColumnBean.portalCode) && this.pageNum == getNextColumnBean.pageNum && i.b(this.pageSize, getNextColumnBean.pageSize) && i.b(this.columnCode, getNextColumnBean.columnCode) && i.b(this.version, getNextColumnBean.version);
    }

    public final String getColumnCode() {
        return this.columnCode;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final Integer getPageSize() {
        return this.pageSize;
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
        int hashCode = ((((((this.userId.hashCode() * 31) + this.userToken.hashCode()) * 31) + this.portalCode.hashCode()) * 31) + this.pageNum) * 31;
        Integer num = this.pageSize;
        return ((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.columnCode.hashCode()) * 31) + this.version.hashCode();
    }

    public final void setColumnCode(String str) {
        i.g(str, "<set-?>");
        this.columnCode = str;
    }

    public final void setPageNum(int i10) {
        this.pageNum = i10;
    }

    public final void setPageSize(Integer num) {
        this.pageSize = num;
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
        return "GetNextColumnBean(userId=" + this.userId + ", userToken=" + this.userToken + ", portalCode=" + this.portalCode + ", pageNum=" + this.pageNum + ", pageSize=" + this.pageSize + ", columnCode=" + this.columnCode + ", version=" + this.version + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
