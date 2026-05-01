package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class SearchByNameBean {
    private Integer columnId;
    private String filter;
    private Integer pageNum;
    private Integer pageSize;
    private String portalCode;
    private String type;
    private String userId;
    private String userToken;
    private String value;

    public SearchByNameBean(String str, String str2, String str3, Integer num, String str4, String str5, Integer num2, Integer num3, String str6) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str4, "value");
        i.g(str5, "type");
        this.userToken = str;
        this.userId = str2;
        this.portalCode = str3;
        this.columnId = num;
        this.value = str4;
        this.type = str5;
        this.pageSize = num2;
        this.pageNum = num3;
        this.filter = str6;
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
        return this.value;
    }

    public final String component6() {
        return this.type;
    }

    public final Integer component7() {
        return this.pageSize;
    }

    public final Integer component8() {
        return this.pageNum;
    }

    public final String component9() {
        return this.filter;
    }

    public final SearchByNameBean copy(String str, String str2, String str3, Integer num, String str4, String str5, Integer num2, Integer num3, String str6) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        i.g(str4, "value");
        i.g(str5, "type");
        return new SearchByNameBean(str, str2, str3, num, str4, str5, num2, num3, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchByNameBean)) {
            return false;
        }
        SearchByNameBean searchByNameBean = (SearchByNameBean) obj;
        return i.b(this.userToken, searchByNameBean.userToken) && i.b(this.userId, searchByNameBean.userId) && i.b(this.portalCode, searchByNameBean.portalCode) && i.b(this.columnId, searchByNameBean.columnId) && i.b(this.value, searchByNameBean.value) && i.b(this.type, searchByNameBean.type) && i.b(this.pageSize, searchByNameBean.pageSize) && i.b(this.pageNum, searchByNameBean.pageNum) && i.b(this.filter, searchByNameBean.filter);
    }

    public final Integer getColumnId() {
        return this.columnId;
    }

    public final String getFilter() {
        return this.filter;
    }

    public final Integer getPageNum() {
        return this.pageNum;
    }

    public final Integer getPageSize() {
        return this.pageSize;
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

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = ((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode()) * 31;
        Integer num = this.columnId;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.value.hashCode()) * 31) + this.type.hashCode()) * 31;
        Integer num2 = this.pageSize;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.pageNum;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.filter;
        return hashCode4 + (str != null ? str.hashCode() : 0);
    }

    public final void setColumnId(Integer num) {
        this.columnId = num;
    }

    public final void setFilter(String str) {
        this.filter = str;
    }

    public final void setPageNum(Integer num) {
        this.pageNum = num;
    }

    public final void setPageSize(Integer num) {
        this.pageSize = num;
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

    public final void setValue(String str) {
        i.g(str, "<set-?>");
        this.value = str;
    }

    public String toString() {
        return "SearchByNameBean(userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ", columnId=" + this.columnId + ", value=" + this.value + ", type=" + this.type + ", pageSize=" + this.pageSize + ", pageNum=" + this.pageNum + ", filter=" + this.filter + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
