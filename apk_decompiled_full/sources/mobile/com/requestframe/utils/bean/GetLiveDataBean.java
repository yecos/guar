package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetLiveDataBean {
    private int columnId;
    private String dataVersion;
    private String expireTimeStr;
    private int pageNum;
    private int pageSize;
    private String portalCode;
    private String userId;
    private String userToken;

    public GetLiveDataBean(String str, String str2, String str3, int i10, String str4, String str5, int i11, int i12) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        this.userToken = str;
        this.userId = str2;
        this.portalCode = str3;
        this.columnId = i10;
        this.dataVersion = str4;
        this.expireTimeStr = str5;
        this.pageNum = i11;
        this.pageSize = i12;
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

    public final int component4() {
        return this.columnId;
    }

    public final String component5() {
        return this.dataVersion;
    }

    public final String component6() {
        return this.expireTimeStr;
    }

    public final int component7() {
        return this.pageNum;
    }

    public final int component8() {
        return this.pageSize;
    }

    public final GetLiveDataBean copy(String str, String str2, String str3, int i10, String str4, String str5, int i11, int i12) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        return new GetLiveDataBean(str, str2, str3, i10, str4, str5, i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetLiveDataBean)) {
            return false;
        }
        GetLiveDataBean getLiveDataBean = (GetLiveDataBean) obj;
        return i.b(this.userToken, getLiveDataBean.userToken) && i.b(this.userId, getLiveDataBean.userId) && i.b(this.portalCode, getLiveDataBean.portalCode) && this.columnId == getLiveDataBean.columnId && i.b(this.dataVersion, getLiveDataBean.dataVersion) && i.b(this.expireTimeStr, getLiveDataBean.expireTimeStr) && this.pageNum == getLiveDataBean.pageNum && this.pageSize == getLiveDataBean.pageSize;
    }

    public final int getColumnId() {
        return this.columnId;
    }

    public final String getDataVersion() {
        return this.dataVersion;
    }

    public final String getExpireTimeStr() {
        return this.expireTimeStr;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final int getPageSize() {
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

    public int hashCode() {
        int hashCode = ((((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode()) * 31) + this.columnId) * 31;
        String str = this.dataVersion;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.expireTimeStr;
        return ((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.pageNum) * 31) + this.pageSize;
    }

    public final void setColumnId(int i10) {
        this.columnId = i10;
    }

    public final void setDataVersion(String str) {
        this.dataVersion = str;
    }

    public final void setExpireTimeStr(String str) {
        this.expireTimeStr = str;
    }

    public final void setPageNum(int i10) {
        this.pageNum = i10;
    }

    public final void setPageSize(int i10) {
        this.pageSize = i10;
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
        return "GetLiveDataBean(userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ", columnId=" + this.columnId + ", dataVersion=" + this.dataVersion + ", expireTimeStr=" + this.expireTimeStr + ", pageNum=" + this.pageNum + ", pageSize=" + this.pageSize + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
