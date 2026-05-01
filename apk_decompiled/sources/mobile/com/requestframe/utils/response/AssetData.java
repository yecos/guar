package mobile.com.requestframe.utils.response;

import com.google.android.gms.cast.MediaTrack;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class AssetData implements Serializable {
    private String actorDisplay;
    private String alias;
    private String awardsUrl;
    private String contentId;
    private String contentTag;
    private String contentTagUrl;
    private String description;
    private String director;
    private String duration;
    private int favoriteId;
    private String hasFavorite;
    private String hasPositive;
    private String hasSubscribe;
    private String hasTidbits;
    private String hasTrailer;
    private String keyWords;
    private String language;
    private int moreAudio;
    private int moreSubtitle;
    private String name;
    private String originalCountry;
    private List<? extends PosterList> posterList;
    private String programType;
    private String releaseTime;
    private String restricted;
    private List<ProgramSeason> sameSeasonSeriesList;
    private float score;
    private List<SimpleProgramList> simpleProgramList;
    private int subscribeId;
    private String tags;
    private int updateCount;
    private String viewPoint;
    private int volumnCount;

    public AssetData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i10, int i11, String str9, String str10, String str11, String str12, String str13, float f10, String str14, String str15, String str16, String str17, String str18, int i12, int i13, int i14, int i15, String str19, String str20, String str21, String str22, String str23, List<SimpleProgramList> list, List<? extends PosterList> list2, List<ProgramSeason> list3) {
        i.g(str, "contentId");
        i.g(str2, "name");
        i.g(str3, "duration");
        i.g(str4, "hasPositive");
        i.g(str5, "hasTidbits");
        i.g(str6, "hasTrailer");
        i.g(str7, "restricted");
        i.g(str8, "programType");
        i.g(str9, "alias");
        i.g(str10, "director");
        i.g(str11, "actorDisplay");
        i.g(str12, "language");
        i.g(str13, "originalCountry");
        i.g(str14, "releaseTime");
        i.g(str15, "viewPoint");
        i.g(str16, "keyWords");
        i.g(str17, "tags");
        i.g(str18, MediaTrack.ROLE_DESCRIPTION);
        i.g(str19, "hasSubscribe");
        i.g(str20, "hasFavorite");
        i.g(list, "simpleProgramList");
        i.g(list2, "posterList");
        this.contentId = str;
        this.name = str2;
        this.duration = str3;
        this.hasPositive = str4;
        this.hasTidbits = str5;
        this.hasTrailer = str6;
        this.restricted = str7;
        this.programType = str8;
        this.volumnCount = i10;
        this.updateCount = i11;
        this.alias = str9;
        this.director = str10;
        this.actorDisplay = str11;
        this.language = str12;
        this.originalCountry = str13;
        this.score = f10;
        this.releaseTime = str14;
        this.viewPoint = str15;
        this.keyWords = str16;
        this.tags = str17;
        this.description = str18;
        this.moreAudio = i12;
        this.moreSubtitle = i13;
        this.subscribeId = i14;
        this.favoriteId = i15;
        this.hasSubscribe = str19;
        this.hasFavorite = str20;
        this.contentTag = str21;
        this.contentTagUrl = str22;
        this.awardsUrl = str23;
        this.simpleProgramList = list;
        this.posterList = list2;
        this.sameSeasonSeriesList = list3;
    }

    public final String component1() {
        return this.contentId;
    }

    public final int component10() {
        return this.updateCount;
    }

    public final String component11() {
        return this.alias;
    }

    public final String component12() {
        return this.director;
    }

    public final String component13() {
        return this.actorDisplay;
    }

    public final String component14() {
        return this.language;
    }

    public final String component15() {
        return this.originalCountry;
    }

    public final float component16() {
        return this.score;
    }

    public final String component17() {
        return this.releaseTime;
    }

    public final String component18() {
        return this.viewPoint;
    }

    public final String component19() {
        return this.keyWords;
    }

    public final String component2() {
        return this.name;
    }

    public final String component20() {
        return this.tags;
    }

    public final String component21() {
        return this.description;
    }

    public final int component22() {
        return this.moreAudio;
    }

    public final int component23() {
        return this.moreSubtitle;
    }

    public final int component24() {
        return this.subscribeId;
    }

    public final int component25() {
        return this.favoriteId;
    }

    public final String component26() {
        return this.hasSubscribe;
    }

    public final String component27() {
        return this.hasFavorite;
    }

    public final String component28() {
        return this.contentTag;
    }

    public final String component29() {
        return this.contentTagUrl;
    }

    public final String component3() {
        return this.duration;
    }

    public final String component30() {
        return this.awardsUrl;
    }

    public final List<SimpleProgramList> component31() {
        return this.simpleProgramList;
    }

    public final List<PosterList> component32() {
        return this.posterList;
    }

    public final List<ProgramSeason> component33() {
        return this.sameSeasonSeriesList;
    }

    public final String component4() {
        return this.hasPositive;
    }

    public final String component5() {
        return this.hasTidbits;
    }

    public final String component6() {
        return this.hasTrailer;
    }

    public final String component7() {
        return this.restricted;
    }

    public final String component8() {
        return this.programType;
    }

    public final int component9() {
        return this.volumnCount;
    }

    public final AssetData copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i10, int i11, String str9, String str10, String str11, String str12, String str13, float f10, String str14, String str15, String str16, String str17, String str18, int i12, int i13, int i14, int i15, String str19, String str20, String str21, String str22, String str23, List<SimpleProgramList> list, List<? extends PosterList> list2, List<ProgramSeason> list3) {
        i.g(str, "contentId");
        i.g(str2, "name");
        i.g(str3, "duration");
        i.g(str4, "hasPositive");
        i.g(str5, "hasTidbits");
        i.g(str6, "hasTrailer");
        i.g(str7, "restricted");
        i.g(str8, "programType");
        i.g(str9, "alias");
        i.g(str10, "director");
        i.g(str11, "actorDisplay");
        i.g(str12, "language");
        i.g(str13, "originalCountry");
        i.g(str14, "releaseTime");
        i.g(str15, "viewPoint");
        i.g(str16, "keyWords");
        i.g(str17, "tags");
        i.g(str18, MediaTrack.ROLE_DESCRIPTION);
        i.g(str19, "hasSubscribe");
        i.g(str20, "hasFavorite");
        i.g(list, "simpleProgramList");
        i.g(list2, "posterList");
        return new AssetData(str, str2, str3, str4, str5, str6, str7, str8, i10, i11, str9, str10, str11, str12, str13, f10, str14, str15, str16, str17, str18, i12, i13, i14, i15, str19, str20, str21, str22, str23, list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AssetData)) {
            return false;
        }
        AssetData assetData = (AssetData) obj;
        return i.b(this.contentId, assetData.contentId) && i.b(this.name, assetData.name) && i.b(this.duration, assetData.duration) && i.b(this.hasPositive, assetData.hasPositive) && i.b(this.hasTidbits, assetData.hasTidbits) && i.b(this.hasTrailer, assetData.hasTrailer) && i.b(this.restricted, assetData.restricted) && i.b(this.programType, assetData.programType) && this.volumnCount == assetData.volumnCount && this.updateCount == assetData.updateCount && i.b(this.alias, assetData.alias) && i.b(this.director, assetData.director) && i.b(this.actorDisplay, assetData.actorDisplay) && i.b(this.language, assetData.language) && i.b(this.originalCountry, assetData.originalCountry) && Float.compare(this.score, assetData.score) == 0 && i.b(this.releaseTime, assetData.releaseTime) && i.b(this.viewPoint, assetData.viewPoint) && i.b(this.keyWords, assetData.keyWords) && i.b(this.tags, assetData.tags) && i.b(this.description, assetData.description) && this.moreAudio == assetData.moreAudio && this.moreSubtitle == assetData.moreSubtitle && this.subscribeId == assetData.subscribeId && this.favoriteId == assetData.favoriteId && i.b(this.hasSubscribe, assetData.hasSubscribe) && i.b(this.hasFavorite, assetData.hasFavorite) && i.b(this.contentTag, assetData.contentTag) && i.b(this.contentTagUrl, assetData.contentTagUrl) && i.b(this.awardsUrl, assetData.awardsUrl) && i.b(this.simpleProgramList, assetData.simpleProgramList) && i.b(this.posterList, assetData.posterList) && i.b(this.sameSeasonSeriesList, assetData.sameSeasonSeriesList);
    }

    public final String getActorDisplay() {
        return this.actorDisplay;
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getAwardsUrl() {
        return this.awardsUrl;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getContentTag() {
        return this.contentTag;
    }

    public final String getContentTagUrl() {
        return this.contentTagUrl;
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

    public final int getFavoriteId() {
        return this.favoriteId;
    }

    public final String getHasFavorite() {
        return this.hasFavorite;
    }

    public final String getHasPositive() {
        return this.hasPositive;
    }

    public final String getHasSubscribe() {
        return this.hasSubscribe;
    }

    public final String getHasTidbits() {
        return this.hasTidbits;
    }

    public final String getHasTrailer() {
        return this.hasTrailer;
    }

    public final String getKeyWords() {
        return this.keyWords;
    }

    public final String getLanguage() {
        return this.language;
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

    public final String getOriginalCountry() {
        return this.originalCountry;
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

    public final String getRestricted() {
        return this.restricted;
    }

    public final List<ProgramSeason> getSameSeasonSeriesList() {
        return this.sameSeasonSeriesList;
    }

    public final float getScore() {
        return this.score;
    }

    public final List<SimpleProgramList> getSimpleProgramList() {
        return this.simpleProgramList;
    }

    public final int getSubscribeId() {
        return this.subscribeId;
    }

    public final String getTags() {
        return this.tags;
    }

    public final int getUpdateCount() {
        return this.updateCount;
    }

    public final String getViewPoint() {
        return this.viewPoint;
    }

    public final int getVolumnCount() {
        return this.volumnCount;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((this.contentId.hashCode() * 31) + this.name.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.hasPositive.hashCode()) * 31) + this.hasTidbits.hashCode()) * 31) + this.hasTrailer.hashCode()) * 31) + this.restricted.hashCode()) * 31) + this.programType.hashCode()) * 31) + this.volumnCount) * 31) + this.updateCount) * 31) + this.alias.hashCode()) * 31) + this.director.hashCode()) * 31) + this.actorDisplay.hashCode()) * 31) + this.language.hashCode()) * 31) + this.originalCountry.hashCode()) * 31) + Float.floatToIntBits(this.score)) * 31) + this.releaseTime.hashCode()) * 31) + this.viewPoint.hashCode()) * 31) + this.keyWords.hashCode()) * 31) + this.tags.hashCode()) * 31) + this.description.hashCode()) * 31) + this.moreAudio) * 31) + this.moreSubtitle) * 31) + this.subscribeId) * 31) + this.favoriteId) * 31) + this.hasSubscribe.hashCode()) * 31) + this.hasFavorite.hashCode()) * 31;
        String str = this.contentTag;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.contentTagUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.awardsUrl;
        int hashCode4 = (((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.simpleProgramList.hashCode()) * 31) + this.posterList.hashCode()) * 31;
        List<ProgramSeason> list = this.sameSeasonSeriesList;
        return hashCode4 + (list != null ? list.hashCode() : 0);
    }

    public final void setActorDisplay(String str) {
        i.g(str, "<set-?>");
        this.actorDisplay = str;
    }

    public final void setAlias(String str) {
        i.g(str, "<set-?>");
        this.alias = str;
    }

    public final void setAwardsUrl(String str) {
        this.awardsUrl = str;
    }

    public final void setContentId(String str) {
        i.g(str, "<set-?>");
        this.contentId = str;
    }

    public final void setContentTag(String str) {
        this.contentTag = str;
    }

    public final void setContentTagUrl(String str) {
        this.contentTagUrl = str;
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

    public final void setFavoriteId(int i10) {
        this.favoriteId = i10;
    }

    public final void setHasFavorite(String str) {
        i.g(str, "<set-?>");
        this.hasFavorite = str;
    }

    public final void setHasPositive(String str) {
        i.g(str, "<set-?>");
        this.hasPositive = str;
    }

    public final void setHasSubscribe(String str) {
        i.g(str, "<set-?>");
        this.hasSubscribe = str;
    }

    public final void setHasTidbits(String str) {
        i.g(str, "<set-?>");
        this.hasTidbits = str;
    }

    public final void setHasTrailer(String str) {
        i.g(str, "<set-?>");
        this.hasTrailer = str;
    }

    public final void setKeyWords(String str) {
        i.g(str, "<set-?>");
        this.keyWords = str;
    }

    public final void setLanguage(String str) {
        i.g(str, "<set-?>");
        this.language = str;
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

    public final void setOriginalCountry(String str) {
        i.g(str, "<set-?>");
        this.originalCountry = str;
    }

    public final void setPosterList(List<? extends PosterList> list) {
        i.g(list, "<set-?>");
        this.posterList = list;
    }

    public final void setProgramType(String str) {
        i.g(str, "<set-?>");
        this.programType = str;
    }

    public final void setReleaseTime(String str) {
        i.g(str, "<set-?>");
        this.releaseTime = str;
    }

    public final void setRestricted(String str) {
        i.g(str, "<set-?>");
        this.restricted = str;
    }

    public final void setSameSeasonSeriesList(List<ProgramSeason> list) {
        this.sameSeasonSeriesList = list;
    }

    public final void setScore(float f10) {
        this.score = f10;
    }

    public final void setSimpleProgramList(List<SimpleProgramList> list) {
        i.g(list, "<set-?>");
        this.simpleProgramList = list;
    }

    public final void setSubscribeId(int i10) {
        this.subscribeId = i10;
    }

    public final void setTags(String str) {
        i.g(str, "<set-?>");
        this.tags = str;
    }

    public final void setUpdateCount(int i10) {
        this.updateCount = i10;
    }

    public final void setViewPoint(String str) {
        i.g(str, "<set-?>");
        this.viewPoint = str;
    }

    public final void setVolumnCount(int i10) {
        this.volumnCount = i10;
    }

    public String toString() {
        return "AssetData(contentId=" + this.contentId + ", name=" + this.name + ", duration=" + this.duration + ", hasPositive=" + this.hasPositive + ", hasTidbits=" + this.hasTidbits + ", hasTrailer=" + this.hasTrailer + ", restricted=" + this.restricted + ", programType=" + this.programType + ", volumnCount=" + this.volumnCount + ", updateCount=" + this.updateCount + ", alias=" + this.alias + ", director=" + this.director + ", actorDisplay=" + this.actorDisplay + ", language=" + this.language + ", originalCountry=" + this.originalCountry + ", score=" + this.score + ", releaseTime=" + this.releaseTime + ", viewPoint=" + this.viewPoint + ", keyWords=" + this.keyWords + ", tags=" + this.tags + ", description=" + this.description + ", moreAudio=" + this.moreAudio + ", moreSubtitle=" + this.moreSubtitle + ", subscribeId=" + this.subscribeId + ", favoriteId=" + this.favoriteId + ", hasSubscribe=" + this.hasSubscribe + ", hasFavorite=" + this.hasFavorite + ", contentTag=" + this.contentTag + ", contentTagUrl=" + this.contentTagUrl + ", awardsUrl=" + this.awardsUrl + ", simpleProgramList=" + this.simpleProgramList + ", posterList=" + this.posterList + ", sameSeasonSeriesList=" + this.sameSeasonSeriesList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
