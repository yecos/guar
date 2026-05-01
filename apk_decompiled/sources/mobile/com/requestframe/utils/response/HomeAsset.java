package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class HomeAsset implements Serializable {
    private String alias;
    private String contentId;
    private String contentType;
    private String duration;
    private String name;
    private List<ShelvePoster> posterList;
    private String programType;
    private String type;
    private Integer updateCount;
    private Integer volumnCount;

    public HomeAsset(String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6, String str7, List<ShelvePoster> list) {
        i.g(str, "contentId");
        i.g(str2, "name");
        i.g(str3, "type");
        i.g(str4, "duration");
        i.g(str5, "programType");
        this.contentId = str;
        this.name = str2;
        this.type = str3;
        this.duration = str4;
        this.programType = str5;
        this.volumnCount = num;
        this.updateCount = num2;
        this.alias = str6;
        this.contentType = str7;
        this.posterList = list;
    }

    public final String component1() {
        return this.contentId;
    }

    public final List<ShelvePoster> component10() {
        return this.posterList;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.duration;
    }

    public final String component5() {
        return this.programType;
    }

    public final Integer component6() {
        return this.volumnCount;
    }

    public final Integer component7() {
        return this.updateCount;
    }

    public final String component8() {
        return this.alias;
    }

    public final String component9() {
        return this.contentType;
    }

    public final HomeAsset copy(String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6, String str7, List<ShelvePoster> list) {
        i.g(str, "contentId");
        i.g(str2, "name");
        i.g(str3, "type");
        i.g(str4, "duration");
        i.g(str5, "programType");
        return new HomeAsset(str, str2, str3, str4, str5, num, num2, str6, str7, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeAsset)) {
            return false;
        }
        HomeAsset homeAsset = (HomeAsset) obj;
        return i.b(this.contentId, homeAsset.contentId) && i.b(this.name, homeAsset.name) && i.b(this.type, homeAsset.type) && i.b(this.duration, homeAsset.duration) && i.b(this.programType, homeAsset.programType) && i.b(this.volumnCount, homeAsset.volumnCount) && i.b(this.updateCount, homeAsset.updateCount) && i.b(this.alias, homeAsset.alias) && i.b(this.contentType, homeAsset.contentType) && i.b(this.posterList, homeAsset.posterList);
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getName() {
        return this.name;
    }

    public final List<ShelvePoster> getPosterList() {
        return this.posterList;
    }

    public final String getProgramType() {
        return this.programType;
    }

    public final String getType() {
        return this.type;
    }

    public final Integer getUpdateCount() {
        return this.updateCount;
    }

    public final Integer getVolumnCount() {
        return this.volumnCount;
    }

    public int hashCode() {
        int hashCode = ((((((((this.contentId.hashCode() * 31) + this.name.hashCode()) * 31) + this.type.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.programType.hashCode()) * 31;
        Integer num = this.volumnCount;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.updateCount;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.alias;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.contentType;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<ShelvePoster> list = this.posterList;
        return hashCode5 + (list != null ? list.hashCode() : 0);
    }

    public final void setAlias(String str) {
        this.alias = str;
    }

    public final void setContentId(String str) {
        i.g(str, "<set-?>");
        this.contentId = str;
    }

    public final void setContentType(String str) {
        this.contentType = str;
    }

    public final void setDuration(String str) {
        i.g(str, "<set-?>");
        this.duration = str;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public final void setPosterList(List<ShelvePoster> list) {
        this.posterList = list;
    }

    public final void setProgramType(String str) {
        i.g(str, "<set-?>");
        this.programType = str;
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
    }

    public final void setUpdateCount(Integer num) {
        this.updateCount = num;
    }

    public final void setVolumnCount(Integer num) {
        this.volumnCount = num;
    }

    public String toString() {
        return "HomeAsset(contentId=" + this.contentId + ", name=" + this.name + ", type=" + this.type + ", duration=" + this.duration + ", programType=" + this.programType + ", volumnCount=" + this.volumnCount + ", updateCount=" + this.updateCount + ", alias=" + this.alias + ", contentType=" + this.contentType + ", posterList=" + this.posterList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
