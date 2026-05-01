package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class ShortMovie {
    private String audioInfo;
    private String audioType;
    private String bitRateType;
    private String contentId;
    private String encodeFormat;
    private List<License> licenseList;
    private String quality;
    private String screenFormat;
    private String type;
    private String videoFormat;
    private String videoType;

    public ShortMovie(String str, String str2, List<License> list, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        i.g(list, "licenseList");
        this.contentId = str;
        this.type = str2;
        this.licenseList = list;
        this.audioType = str3;
        this.videoType = str4;
        this.screenFormat = str5;
        this.encodeFormat = str6;
        this.videoFormat = str7;
        this.quality = str8;
        this.bitRateType = str9;
        this.audioInfo = str10;
    }

    public final String component1() {
        return this.contentId;
    }

    public final String component10() {
        return this.bitRateType;
    }

    public final String component11() {
        return this.audioInfo;
    }

    public final String component2() {
        return this.type;
    }

    public final List<License> component3() {
        return this.licenseList;
    }

    public final String component4() {
        return this.audioType;
    }

    public final String component5() {
        return this.videoType;
    }

    public final String component6() {
        return this.screenFormat;
    }

    public final String component7() {
        return this.encodeFormat;
    }

    public final String component8() {
        return this.videoFormat;
    }

    public final String component9() {
        return this.quality;
    }

    public final ShortMovie copy(String str, String str2, List<License> list, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        i.g(list, "licenseList");
        return new ShortMovie(str, str2, list, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShortMovie)) {
            return false;
        }
        ShortMovie shortMovie = (ShortMovie) obj;
        return i.b(this.contentId, shortMovie.contentId) && i.b(this.type, shortMovie.type) && i.b(this.licenseList, shortMovie.licenseList) && i.b(this.audioType, shortMovie.audioType) && i.b(this.videoType, shortMovie.videoType) && i.b(this.screenFormat, shortMovie.screenFormat) && i.b(this.encodeFormat, shortMovie.encodeFormat) && i.b(this.videoFormat, shortMovie.videoFormat) && i.b(this.quality, shortMovie.quality) && i.b(this.bitRateType, shortMovie.bitRateType) && i.b(this.audioInfo, shortMovie.audioInfo);
    }

    public final String getAudioInfo() {
        return this.audioInfo;
    }

    public final String getAudioType() {
        return this.audioType;
    }

    public final String getBitRateType() {
        return this.bitRateType;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getEncodeFormat() {
        return this.encodeFormat;
    }

    public final List<License> getLicenseList() {
        return this.licenseList;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final String getScreenFormat() {
        return this.screenFormat;
    }

    public final String getType() {
        return this.type;
    }

    public final String getVideoFormat() {
        return this.videoFormat;
    }

    public final String getVideoType() {
        return this.videoType;
    }

    public int hashCode() {
        String str = this.contentId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.licenseList.hashCode()) * 31;
        String str3 = this.audioType;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.videoType;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.screenFormat;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.encodeFormat;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.videoFormat;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.quality;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.bitRateType;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.audioInfo;
        return hashCode9 + (str10 != null ? str10.hashCode() : 0);
    }

    public final void setAudioInfo(String str) {
        this.audioInfo = str;
    }

    public final void setAudioType(String str) {
        this.audioType = str;
    }

    public final void setBitRateType(String str) {
        this.bitRateType = str;
    }

    public final void setContentId(String str) {
        this.contentId = str;
    }

    public final void setEncodeFormat(String str) {
        this.encodeFormat = str;
    }

    public final void setLicenseList(List<License> list) {
        i.g(list, "<set-?>");
        this.licenseList = list;
    }

    public final void setQuality(String str) {
        this.quality = str;
    }

    public final void setScreenFormat(String str) {
        this.screenFormat = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setVideoFormat(String str) {
        this.videoFormat = str;
    }

    public final void setVideoType(String str) {
        this.videoType = str;
    }

    public String toString() {
        return "ShortMovie(contentId=" + this.contentId + ", type=" + this.type + ", licenseList=" + this.licenseList + ", audioType=" + this.audioType + ", videoType=" + this.videoType + ", screenFormat=" + this.screenFormat + ", encodeFormat=" + this.encodeFormat + ", videoFormat=" + this.videoFormat + ", quality=" + this.quality + ", bitRateType=" + this.bitRateType + ", audioInfo=" + this.audioInfo + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
