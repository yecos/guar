package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class Channel implements Serializable {
    private String alias;
    private String channelCode;
    private int channelNumber;
    private List<LiveAddress> liveAddressList;
    private String name;
    private List<? extends PosterList> posterList;
    private String posterUrl;
    private String quality;
    private String restricted;
    private String supportBusiness;
    private String supportVideoType;

    public Channel(String str, String str2, String str3, int i10, String str4, String str5, String str6, String str7, String str8, List<? extends PosterList> list, List<LiveAddress> list2) {
        i.g(str, "channelCode");
        i.g(str2, "name");
        this.channelCode = str;
        this.name = str2;
        this.alias = str3;
        this.channelNumber = i10;
        this.posterUrl = str4;
        this.supportVideoType = str5;
        this.restricted = str6;
        this.supportBusiness = str7;
        this.quality = str8;
        this.posterList = list;
        this.liveAddressList = list2;
    }

    public final String component1() {
        return this.channelCode;
    }

    public final List<PosterList> component10() {
        return this.posterList;
    }

    public final List<LiveAddress> component11() {
        return this.liveAddressList;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.alias;
    }

    public final int component4() {
        return this.channelNumber;
    }

    public final String component5() {
        return this.posterUrl;
    }

    public final String component6() {
        return this.supportVideoType;
    }

    public final String component7() {
        return this.restricted;
    }

    public final String component8() {
        return this.supportBusiness;
    }

    public final String component9() {
        return this.quality;
    }

    public final Channel copy(String str, String str2, String str3, int i10, String str4, String str5, String str6, String str7, String str8, List<? extends PosterList> list, List<LiveAddress> list2) {
        i.g(str, "channelCode");
        i.g(str2, "name");
        return new Channel(str, str2, str3, i10, str4, str5, str6, str7, str8, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Channel)) {
            return false;
        }
        Channel channel = (Channel) obj;
        return i.b(this.channelCode, channel.channelCode) && i.b(this.name, channel.name) && i.b(this.alias, channel.alias) && this.channelNumber == channel.channelNumber && i.b(this.posterUrl, channel.posterUrl) && i.b(this.supportVideoType, channel.supportVideoType) && i.b(this.restricted, channel.restricted) && i.b(this.supportBusiness, channel.supportBusiness) && i.b(this.quality, channel.quality) && i.b(this.posterList, channel.posterList) && i.b(this.liveAddressList, channel.liveAddressList);
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final int getChannelNumber() {
        return this.channelNumber;
    }

    public final List<LiveAddress> getLiveAddressList() {
        return this.liveAddressList;
    }

    public final String getName() {
        return this.name;
    }

    public final List<PosterList> getPosterList() {
        return this.posterList;
    }

    public final String getPosterUrl() {
        return this.posterUrl;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final String getRestricted() {
        return this.restricted;
    }

    public final String getSupportBusiness() {
        return this.supportBusiness;
    }

    public final String getSupportVideoType() {
        return this.supportVideoType;
    }

    public int hashCode() {
        int hashCode = ((this.channelCode.hashCode() * 31) + this.name.hashCode()) * 31;
        String str = this.alias;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.channelNumber) * 31;
        String str2 = this.posterUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.supportVideoType;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.restricted;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.supportBusiness;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.quality;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<? extends PosterList> list = this.posterList;
        int hashCode8 = (hashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        List<LiveAddress> list2 = this.liveAddressList;
        return hashCode8 + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setAlias(String str) {
        this.alias = str;
    }

    public final void setChannelCode(String str) {
        i.g(str, "<set-?>");
        this.channelCode = str;
    }

    public final void setChannelNumber(int i10) {
        this.channelNumber = i10;
    }

    public final void setLiveAddressList(List<LiveAddress> list) {
        this.liveAddressList = list;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public final void setPosterList(List<? extends PosterList> list) {
        this.posterList = list;
    }

    public final void setPosterUrl(String str) {
        this.posterUrl = str;
    }

    public final void setQuality(String str) {
        this.quality = str;
    }

    public final void setRestricted(String str) {
        this.restricted = str;
    }

    public final void setSupportBusiness(String str) {
        this.supportBusiness = str;
    }

    public final void setSupportVideoType(String str) {
        this.supportVideoType = str;
    }

    public String toString() {
        return "Channel(channelCode=" + this.channelCode + ", name=" + this.name + ", alias=" + this.alias + ", channelNumber=" + this.channelNumber + ", posterUrl=" + this.posterUrl + ", supportVideoType=" + this.supportVideoType + ", restricted=" + this.restricted + ", supportBusiness=" + this.supportBusiness + ", quality=" + this.quality + ", posterList=" + this.posterList + ", liveAddressList=" + this.liveAddressList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
