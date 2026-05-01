package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class RecommendContentList implements Serializable {
    private String contentId;
    private String description;
    private String name;
    private List<? extends PosterList> posterList;
    private String programType;
    private String releaseTime;
    private String remark;
    private String tags;
    private String type;
    private String updateCount;
    private String url;
    private String viewPoint;

    public RecommendContentList(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List<? extends PosterList> list) {
        this.contentId = str;
        this.name = str2;
        this.viewPoint = str3;
        this.type = str4;
        this.url = str5;
        this.description = str6;
        this.remark = str7;
        this.updateCount = str8;
        this.programType = str9;
        this.releaseTime = str10;
        this.tags = str11;
        this.posterList = list;
    }

    public final String component1() {
        return this.contentId;
    }

    public final String component10() {
        return this.releaseTime;
    }

    public final String component11() {
        return this.tags;
    }

    public final List<PosterList> component12() {
        return this.posterList;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.viewPoint;
    }

    public final String component4() {
        return this.type;
    }

    public final String component5() {
        return this.url;
    }

    public final String component6() {
        return this.description;
    }

    public final String component7() {
        return this.remark;
    }

    public final String component8() {
        return this.updateCount;
    }

    public final String component9() {
        return this.programType;
    }

    public final RecommendContentList copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List<? extends PosterList> list) {
        return new RecommendContentList(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecommendContentList)) {
            return false;
        }
        RecommendContentList recommendContentList = (RecommendContentList) obj;
        return i.b(this.contentId, recommendContentList.contentId) && i.b(this.name, recommendContentList.name) && i.b(this.viewPoint, recommendContentList.viewPoint) && i.b(this.type, recommendContentList.type) && i.b(this.url, recommendContentList.url) && i.b(this.description, recommendContentList.description) && i.b(this.remark, recommendContentList.remark) && i.b(this.updateCount, recommendContentList.updateCount) && i.b(this.programType, recommendContentList.programType) && i.b(this.releaseTime, recommendContentList.releaseTime) && i.b(this.tags, recommendContentList.tags) && i.b(this.posterList, recommendContentList.posterList);
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final List<PosterList> getPosterList() {
        return this.posterList;
    }

    public final String getProgramType() {
        return this.programType;
    }

    public final String getReleaseTime() {
        return this.releaseTime;
    }

    public final String getRemark() {
        return this.remark;
    }

    public final String getTags() {
        return this.tags;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUpdateCount() {
        return this.updateCount;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getViewPoint() {
        return this.viewPoint;
    }

    public int hashCode() {
        String str = this.contentId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.viewPoint;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.type;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.url;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.description;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.remark;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.updateCount;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.programType;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.releaseTime;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.tags;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        List<? extends PosterList> list = this.posterList;
        return hashCode11 + (list != null ? list.hashCode() : 0);
    }

    public final void setContentId(String str) {
        this.contentId = str;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPosterList(List<? extends PosterList> list) {
        this.posterList = list;
    }

    public final void setProgramType(String str) {
        this.programType = str;
    }

    public final void setReleaseTime(String str) {
        this.releaseTime = str;
    }

    public final void setRemark(String str) {
        this.remark = str;
    }

    public final void setTags(String str) {
        this.tags = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setUpdateCount(String str) {
        this.updateCount = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setViewPoint(String str) {
        this.viewPoint = str;
    }

    public String toString() {
        return "RecommendContentList(contentId=" + this.contentId + ", name=" + this.name + ", viewPoint=" + this.viewPoint + ", type=" + this.type + ", url=" + this.url + ", description=" + this.description + ", remark=" + this.remark + ", updateCount=" + this.updateCount + ", programType=" + this.programType + ", releaseTime=" + this.releaseTime + ", tags=" + this.tags + ", posterList=" + this.posterList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
