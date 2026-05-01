package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class SearchShelveItem implements Serializable {
    private String actorDisplay;
    private String alias;
    private String contentId;
    private String contentType;
    private String director;
    private int moreSubtitle;
    private String name;
    private String originalCountry;
    private List<ShelvePoster> posterList;
    private String programType;
    private String releaseTime;
    private float score;
    private String tags;
    private String type;
    private int updateCount;
    private int volumnCount;

    public SearchShelveItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List<ShelvePoster> list, String str11, int i10, float f10, int i11, int i12) {
        this.type = str;
        this.contentId = str2;
        this.name = str3;
        this.alias = str4;
        this.director = str5;
        this.actorDisplay = str6;
        this.originalCountry = str7;
        this.releaseTime = str8;
        this.tags = str9;
        this.programType = str10;
        this.posterList = list;
        this.contentType = str11;
        this.moreSubtitle = i10;
        this.score = f10;
        this.updateCount = i11;
        this.volumnCount = i12;
    }

    public final String component1() {
        return this.type;
    }

    public final String component10() {
        return this.programType;
    }

    public final List<ShelvePoster> component11() {
        return this.posterList;
    }

    public final String component12() {
        return this.contentType;
    }

    public final int component13() {
        return this.moreSubtitle;
    }

    public final float component14() {
        return this.score;
    }

    public final int component15() {
        return this.updateCount;
    }

    public final int component16() {
        return this.volumnCount;
    }

    public final String component2() {
        return this.contentId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.alias;
    }

    public final String component5() {
        return this.director;
    }

    public final String component6() {
        return this.actorDisplay;
    }

    public final String component7() {
        return this.originalCountry;
    }

    public final String component8() {
        return this.releaseTime;
    }

    public final String component9() {
        return this.tags;
    }

    public final SearchShelveItem copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List<ShelvePoster> list, String str11, int i10, float f10, int i11, int i12) {
        return new SearchShelveItem(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, list, str11, i10, f10, i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchShelveItem)) {
            return false;
        }
        SearchShelveItem searchShelveItem = (SearchShelveItem) obj;
        return i.b(this.type, searchShelveItem.type) && i.b(this.contentId, searchShelveItem.contentId) && i.b(this.name, searchShelveItem.name) && i.b(this.alias, searchShelveItem.alias) && i.b(this.director, searchShelveItem.director) && i.b(this.actorDisplay, searchShelveItem.actorDisplay) && i.b(this.originalCountry, searchShelveItem.originalCountry) && i.b(this.releaseTime, searchShelveItem.releaseTime) && i.b(this.tags, searchShelveItem.tags) && i.b(this.programType, searchShelveItem.programType) && i.b(this.posterList, searchShelveItem.posterList) && i.b(this.contentType, searchShelveItem.contentType) && this.moreSubtitle == searchShelveItem.moreSubtitle && Float.compare(this.score, searchShelveItem.score) == 0 && this.updateCount == searchShelveItem.updateCount && this.volumnCount == searchShelveItem.volumnCount;
    }

    public final String getActorDisplay() {
        return this.actorDisplay;
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

    public final String getDirector() {
        return this.director;
    }

    public final int getMoreSubtitle() {
        return this.moreSubtitle;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOriginalCountry() {
        return this.originalCountry;
    }

    public final List<ShelvePoster> getPosterList() {
        return this.posterList;
    }

    public final String getProgramType() {
        return this.programType;
    }

    public final String getReleaseTime() {
        return this.releaseTime;
    }

    public final float getScore() {
        return this.score;
    }

    public final String getTags() {
        return this.tags;
    }

    public final String getType() {
        return this.type;
    }

    public final int getUpdateCount() {
        return this.updateCount;
    }

    public final int getVolumnCount() {
        return this.volumnCount;
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.contentId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.alias;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.director;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.actorDisplay;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.originalCountry;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.releaseTime;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.tags;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.programType;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        List<ShelvePoster> list = this.posterList;
        int hashCode11 = (hashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        String str11 = this.contentType;
        return ((((((((hashCode11 + (str11 != null ? str11.hashCode() : 0)) * 31) + this.moreSubtitle) * 31) + Float.floatToIntBits(this.score)) * 31) + this.updateCount) * 31) + this.volumnCount;
    }

    public final void setActorDisplay(String str) {
        this.actorDisplay = str;
    }

    public final void setAlias(String str) {
        this.alias = str;
    }

    public final void setContentId(String str) {
        this.contentId = str;
    }

    public final void setContentType(String str) {
        this.contentType = str;
    }

    public final void setDirector(String str) {
        this.director = str;
    }

    public final void setMoreSubtitle(int i10) {
        this.moreSubtitle = i10;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOriginalCountry(String str) {
        this.originalCountry = str;
    }

    public final void setPosterList(List<ShelvePoster> list) {
        this.posterList = list;
    }

    public final void setProgramType(String str) {
        this.programType = str;
    }

    public final void setReleaseTime(String str) {
        this.releaseTime = str;
    }

    public final void setScore(float f10) {
        this.score = f10;
    }

    public final void setTags(String str) {
        this.tags = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setUpdateCount(int i10) {
        this.updateCount = i10;
    }

    public final void setVolumnCount(int i10) {
        this.volumnCount = i10;
    }

    public String toString() {
        return "SearchShelveItem(type=" + this.type + ", contentId=" + this.contentId + ", name=" + this.name + ", alias=" + this.alias + ", director=" + this.director + ", actorDisplay=" + this.actorDisplay + ", originalCountry=" + this.originalCountry + ", releaseTime=" + this.releaseTime + ", tags=" + this.tags + ", programType=" + this.programType + ", posterList=" + this.posterList + ", contentType=" + this.contentType + ", moreSubtitle=" + this.moreSubtitle + ", score=" + this.score + ", updateCount=" + this.updateCount + ", volumnCount=" + this.volumnCount + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
