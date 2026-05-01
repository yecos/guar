package mobile.com.requestframe.utils.response;

import com.google.android.gms.cast.MediaTrack;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class ShelveAsset implements Serializable {
    private String actorDisplay;
    private String alias;
    private String contentId;
    private String contentType;
    private String description;
    private String director;
    private String duration;
    private int moreAudio;
    private int moreSubtitle;
    private String name;
    private List<ShelvePoster> posterList;
    private String programType;
    private float score;
    private String shelveTime;
    private String tags;
    private String type;
    private int updateCount;
    private String updateTime;
    private String viewPoint;
    private int volumnCount;

    public ShelveAsset(String str, String str2, String str3, String str4, String str5, String str6, int i10, int i11, String str7, String str8, float f10, String str9, String str10, String str11, String str12, String str13, int i12, int i13, String str14, List<ShelvePoster> list) {
        i.g(str, "contentId");
        i.g(str2, "name");
        i.g(str3, "actorDisplay");
        i.g(str4, "type");
        i.g(str5, "duration");
        i.g(str6, "programType");
        i.g(str7, "alias");
        i.g(str8, "director");
        i.g(str9, "viewPoint");
        i.g(str10, "updateTime");
        i.g(str12, "tags");
        i.g(str13, MediaTrack.ROLE_DESCRIPTION);
        i.g(list, "posterList");
        this.contentId = str;
        this.name = str2;
        this.actorDisplay = str3;
        this.type = str4;
        this.duration = str5;
        this.programType = str6;
        this.volumnCount = i10;
        this.updateCount = i11;
        this.alias = str7;
        this.director = str8;
        this.score = f10;
        this.viewPoint = str9;
        this.updateTime = str10;
        this.shelveTime = str11;
        this.tags = str12;
        this.description = str13;
        this.moreAudio = i12;
        this.moreSubtitle = i13;
        this.contentType = str14;
        this.posterList = list;
    }

    public final String component1() {
        return this.contentId;
    }

    public final String component10() {
        return this.director;
    }

    public final float component11() {
        return this.score;
    }

    public final String component12() {
        return this.viewPoint;
    }

    public final String component13() {
        return this.updateTime;
    }

    public final String component14() {
        return this.shelveTime;
    }

    public final String component15() {
        return this.tags;
    }

    public final String component16() {
        return this.description;
    }

    public final int component17() {
        return this.moreAudio;
    }

    public final int component18() {
        return this.moreSubtitle;
    }

    public final String component19() {
        return this.contentType;
    }

    public final String component2() {
        return this.name;
    }

    public final List<ShelvePoster> component20() {
        return this.posterList;
    }

    public final String component3() {
        return this.actorDisplay;
    }

    public final String component4() {
        return this.type;
    }

    public final String component5() {
        return this.duration;
    }

    public final String component6() {
        return this.programType;
    }

    public final int component7() {
        return this.volumnCount;
    }

    public final int component8() {
        return this.updateCount;
    }

    public final String component9() {
        return this.alias;
    }

    public final ShelveAsset copy(String str, String str2, String str3, String str4, String str5, String str6, int i10, int i11, String str7, String str8, float f10, String str9, String str10, String str11, String str12, String str13, int i12, int i13, String str14, List<ShelvePoster> list) {
        i.g(str, "contentId");
        i.g(str2, "name");
        i.g(str3, "actorDisplay");
        i.g(str4, "type");
        i.g(str5, "duration");
        i.g(str6, "programType");
        i.g(str7, "alias");
        i.g(str8, "director");
        i.g(str9, "viewPoint");
        i.g(str10, "updateTime");
        i.g(str12, "tags");
        i.g(str13, MediaTrack.ROLE_DESCRIPTION);
        i.g(list, "posterList");
        return new ShelveAsset(str, str2, str3, str4, str5, str6, i10, i11, str7, str8, f10, str9, str10, str11, str12, str13, i12, i13, str14, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShelveAsset)) {
            return false;
        }
        ShelveAsset shelveAsset = (ShelveAsset) obj;
        return i.b(this.contentId, shelveAsset.contentId) && i.b(this.name, shelveAsset.name) && i.b(this.actorDisplay, shelveAsset.actorDisplay) && i.b(this.type, shelveAsset.type) && i.b(this.duration, shelveAsset.duration) && i.b(this.programType, shelveAsset.programType) && this.volumnCount == shelveAsset.volumnCount && this.updateCount == shelveAsset.updateCount && i.b(this.alias, shelveAsset.alias) && i.b(this.director, shelveAsset.director) && Float.compare(this.score, shelveAsset.score) == 0 && i.b(this.viewPoint, shelveAsset.viewPoint) && i.b(this.updateTime, shelveAsset.updateTime) && i.b(this.shelveTime, shelveAsset.shelveTime) && i.b(this.tags, shelveAsset.tags) && i.b(this.description, shelveAsset.description) && this.moreAudio == shelveAsset.moreAudio && this.moreSubtitle == shelveAsset.moreSubtitle && i.b(this.contentType, shelveAsset.contentType) && i.b(this.posterList, shelveAsset.posterList);
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

    public final String getDescription() {
        return this.description;
    }

    public final String getDirector() {
        return this.director;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final int getMoreAudio() {
        return this.moreAudio;
    }

    public final int getMoreSubtitle() {
        return this.moreSubtitle;
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

    public final float getScore() {
        return this.score;
    }

    public final String getShelveTime() {
        return this.shelveTime;
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

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final String getViewPoint() {
        return this.viewPoint;
    }

    public final int getVolumnCount() {
        return this.volumnCount;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((this.contentId.hashCode() * 31) + this.name.hashCode()) * 31) + this.actorDisplay.hashCode()) * 31) + this.type.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.programType.hashCode()) * 31) + this.volumnCount) * 31) + this.updateCount) * 31) + this.alias.hashCode()) * 31) + this.director.hashCode()) * 31) + Float.floatToIntBits(this.score)) * 31) + this.viewPoint.hashCode()) * 31) + this.updateTime.hashCode()) * 31;
        String str = this.shelveTime;
        int hashCode2 = (((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.tags.hashCode()) * 31) + this.description.hashCode()) * 31) + this.moreAudio) * 31) + this.moreSubtitle) * 31;
        String str2 = this.contentType;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.posterList.hashCode();
    }

    public final void setActorDisplay(String str) {
        i.g(str, "<set-?>");
        this.actorDisplay = str;
    }

    public final void setAlias(String str) {
        i.g(str, "<set-?>");
        this.alias = str;
    }

    public final void setContentId(String str) {
        i.g(str, "<set-?>");
        this.contentId = str;
    }

    public final void setContentType(String str) {
        this.contentType = str;
    }

    public final void setDescription(String str) {
        i.g(str, "<set-?>");
        this.description = str;
    }

    public final void setDirector(String str) {
        i.g(str, "<set-?>");
        this.director = str;
    }

    public final void setDuration(String str) {
        i.g(str, "<set-?>");
        this.duration = str;
    }

    public final void setMoreAudio(int i10) {
        this.moreAudio = i10;
    }

    public final void setMoreSubtitle(int i10) {
        this.moreSubtitle = i10;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public final void setPosterList(List<ShelvePoster> list) {
        i.g(list, "<set-?>");
        this.posterList = list;
    }

    public final void setProgramType(String str) {
        i.g(str, "<set-?>");
        this.programType = str;
    }

    public final void setScore(float f10) {
        this.score = f10;
    }

    public final void setShelveTime(String str) {
        this.shelveTime = str;
    }

    public final void setTags(String str) {
        i.g(str, "<set-?>");
        this.tags = str;
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
    }

    public final void setUpdateCount(int i10) {
        this.updateCount = i10;
    }

    public final void setUpdateTime(String str) {
        i.g(str, "<set-?>");
        this.updateTime = str;
    }

    public final void setViewPoint(String str) {
        i.g(str, "<set-?>");
        this.viewPoint = str;
    }

    public final void setVolumnCount(int i10) {
        this.volumnCount = i10;
    }

    public String toString() {
        return "ShelveAsset(contentId=" + this.contentId + ", name=" + this.name + ", actorDisplay=" + this.actorDisplay + ", type=" + this.type + ", duration=" + this.duration + ", programType=" + this.programType + ", volumnCount=" + this.volumnCount + ", updateCount=" + this.updateCount + ", alias=" + this.alias + ", director=" + this.director + ", score=" + this.score + ", viewPoint=" + this.viewPoint + ", updateTime=" + this.updateTime + ", shelveTime=" + this.shelveTime + ", tags=" + this.tags + ", description=" + this.description + ", moreAudio=" + this.moreAudio + ", moreSubtitle=" + this.moreSubtitle + ", contentType=" + this.contentType + ", posterList=" + this.posterList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
