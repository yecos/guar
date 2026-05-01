package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetColumnContentsBean {
    private Integer columnId;
    private Integer numDisplay;
    private int pageNum;
    private Integer pageSize;
    private String portalCode;
    private String specialFlag;
    private String userId;
    private String userToken;

    public GetColumnContentsBean(String str, String str2, String str3, Integer num, String str4, int i10, Integer num2, Integer num3) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        this.userToken = str;
        this.userId = str2;
        this.portalCode = str3;
        this.columnId = num;
        this.specialFlag = str4;
        this.pageNum = i10;
        this.pageSize = num2;
        this.numDisplay = num3;
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

    public final Integer component4() {
        return this.columnId;
    }

    public final String component5() {
        return this.specialFlag;
    }

    public final int component6() {
        return this.pageNum;
    }

    public final Integer component7() {
        return this.pageSize;
    }

    public final Integer component8() {
        return this.numDisplay;
    }

    public final GetColumnContentsBean copy(String str, String str2, String str3, Integer num, String str4, int i10, Integer num2, Integer num3) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        return new GetColumnContentsBean(str, str2, str3, num, str4, i10, num2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetColumnContentsBean)) {
            return false;
        }
        GetColumnContentsBean getColumnContentsBean = (GetColumnContentsBean) obj;
        return i.b(this.userToken, getColumnContentsBean.userToken) && i.b(this.userId, getColumnContentsBean.userId) && i.b(this.portalCode, getColumnContentsBean.portalCode) && i.b(this.columnId, getColumnContentsBean.columnId) && i.b(this.specialFlag, getColumnContentsBean.specialFlag) && this.pageNum == getColumnContentsBean.pageNum && i.b(this.pageSize, getColumnContentsBean.pageSize) && i.b(this.numDisplay, getColumnContentsBean.numDisplay);
    }

    public final Integer getColumnId() {
        return this.columnId;
    }

    public final Integer getNumDisplay() {
        return this.numDisplay;
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

    public final String getSpecialFlag() {
        return this.specialFlag;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        int hashCode = ((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode()) * 31;
        Integer num = this.columnId;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.specialFlag;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.pageNum) * 31;
        Integer num2 = this.pageSize;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.numDisplay;
        return hashCode4 + (num3 != null ? num3.hashCode() : 0);
    }

    public final void setColumnId(Integer num) {
        this.columnId = num;
    }

    public final void setNumDisplay(Integer num) {
        this.numDisplay = num;
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

    public final void setSpecialFlag(String str) {
        this.specialFlag = str;
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
        return "GetColumnContentsBean(userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ", columnId=" + this.columnId + ", specialFlag=" + this.specialFlag + ", pageNum=" + this.pageNum + ", pageSize=" + this.pageSize + ", numDisplay=" + this.numDisplay + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
