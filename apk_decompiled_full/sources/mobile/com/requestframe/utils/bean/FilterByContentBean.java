package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class FilterByContentBean {
    private String audio;
    private Integer columnId;
    private String language;
    private String originalCountry;
    private int pageNum;
    private int pageSize;
    private String portalCode;
    private String tags;
    private String userId;
    private String userToken;
    private String year;

    public FilterByContentBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, String str8, int i10, int i11) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        this.userToken = str;
        this.userId = str2;
        this.portalCode = str3;
        this.originalCountry = str4;
        this.tags = str5;
        this.year = str6;
        this.audio = str7;
        this.columnId = num;
        this.language = str8;
        this.pageSize = i10;
        this.pageNum = i11;
    }

    public final String component1() {
        return this.userToken;
    }

    public final int component10() {
        return this.pageSize;
    }

    public final int component11() {
        return this.pageNum;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.portalCode;
    }

    public final String component4() {
        return this.originalCountry;
    }

    public final String component5() {
        return this.tags;
    }

    public final String component6() {
        return this.year;
    }

    public final String component7() {
        return this.audio;
    }

    public final Integer component8() {
        return this.columnId;
    }

    public final String component9() {
        return this.language;
    }

    public final FilterByContentBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, String str8, int i10, int i11) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        return new FilterByContentBean(str, str2, str3, str4, str5, str6, str7, num, str8, i10, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterByContentBean)) {
            return false;
        }
        FilterByContentBean filterByContentBean = (FilterByContentBean) obj;
        return i.b(this.userToken, filterByContentBean.userToken) && i.b(this.userId, filterByContentBean.userId) && i.b(this.portalCode, filterByContentBean.portalCode) && i.b(this.originalCountry, filterByContentBean.originalCountry) && i.b(this.tags, filterByContentBean.tags) && i.b(this.year, filterByContentBean.year) && i.b(this.audio, filterByContentBean.audio) && i.b(this.columnId, filterByContentBean.columnId) && i.b(this.language, filterByContentBean.language) && this.pageSize == filterByContentBean.pageSize && this.pageNum == filterByContentBean.pageNum;
    }

    public final String getAudio() {
        return this.audio;
    }

    public final Integer getColumnId() {
        return this.columnId;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getOriginalCountry() {
        return this.originalCountry;
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

    public final String getTags() {
        return this.tags;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public final String getYear() {
        return this.year;
    }

    public int hashCode() {
        int hashCode = ((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode()) * 31;
        String str = this.originalCountry;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.tags;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.year;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.audio;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.columnId;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.language;
        return ((((hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.pageSize) * 31) + this.pageNum;
    }

    public final void setAudio(String str) {
        this.audio = str;
    }

    public final void setColumnId(Integer num) {
        this.columnId = num;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final void setOriginalCountry(String str) {
        this.originalCountry = str;
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

    public final void setTags(String str) {
        this.tags = str;
    }

    public final void setUserId(String str) {
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public final void setUserToken(String str) {
        i.g(str, "<set-?>");
        this.userToken = str;
    }

    public final void setYear(String str) {
        this.year = str;
    }

    public String toString() {
        return "FilterByContentBean(userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ", originalCountry=" + this.originalCountry + ", tags=" + this.tags + ", year=" + this.year + ", audio=" + this.audio + ", columnId=" + this.columnId + ", language=" + this.language + ", pageSize=" + this.pageSize + ", pageNum=" + this.pageNum + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
