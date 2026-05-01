package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class ShelveChannel implements Serializable {
    private String alias;
    private String channelCode;
    private String channelNumber;
    private String contentEn;
    private String contentZh;
    private String keyWords;
    private List<ShelveAddress> liveAddressList;
    private String name;
    private List<ShelvePoster> posterList;
    private String restricted;
    private String supportBusiness;
    private String tags;

    public ShelveChannel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List<ShelvePoster> list, List<ShelveAddress> list2) {
        this.channelCode = str;
        this.name = str2;
        this.alias = str3;
        this.supportBusiness = str4;
        this.channelNumber = str5;
        this.tags = str6;
        this.contentEn = str7;
        this.contentZh = str8;
        this.keyWords = str9;
        this.restricted = str10;
        this.posterList = list;
        this.liveAddressList = list2;
    }

    public final String component1() {
        return this.channelCode;
    }

    public final String component10() {
        return this.restricted;
    }

    public final List<ShelvePoster> component11() {
        return this.posterList;
    }

    public final List<ShelveAddress> component12() {
        return this.liveAddressList;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.alias;
    }

    public final String component4() {
        return this.supportBusiness;
    }

    public final String component5() {
        return this.channelNumber;
    }

    public final String component6() {
        return this.tags;
    }

    public final String component7() {
        return this.contentEn;
    }

    public final String component8() {
        return this.contentZh;
    }

    public final String component9() {
        return this.keyWords;
    }

    public final ShelveChannel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List<ShelvePoster> list, List<ShelveAddress> list2) {
        return new ShelveChannel(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShelveChannel)) {
            return false;
        }
        ShelveChannel shelveChannel = (ShelveChannel) obj;
        return i.b(this.channelCode, shelveChannel.channelCode) && i.b(this.name, shelveChannel.name) && i.b(this.alias, shelveChannel.alias) && i.b(this.supportBusiness, shelveChannel.supportBusiness) && i.b(this.channelNumber, shelveChannel.channelNumber) && i.b(this.tags, shelveChannel.tags) && i.b(this.contentEn, shelveChannel.contentEn) && i.b(this.contentZh, shelveChannel.contentZh) && i.b(this.keyWords, shelveChannel.keyWords) && i.b(this.restricted, shelveChannel.restricted) && i.b(this.posterList, shelveChannel.posterList) && i.b(this.liveAddressList, shelveChannel.liveAddressList);
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final String getChannelNumber() {
        return this.channelNumber;
    }

    public final String getContentEn() {
        return this.contentEn;
    }

    public final String getContentZh() {
        return this.contentZh;
    }

    public final String getKeyWords() {
        return this.keyWords;
    }

    public final List<ShelveAddress> getLiveAddressList() {
        return this.liveAddressList;
    }

    public final String getName() {
        return this.name;
    }

    public List<ShelvePoster> getPoster() {
        return this.posterList;
    }

    public final List<ShelvePoster> getPosterList() {
        return this.posterList;
    }

    public final String getRestricted() {
        return this.restricted;
    }

    public final String getSupportBusiness() {
        return this.supportBusiness;
    }

    public final String getTags() {
        return this.tags;
    }

    public int hashCode() {
        String str = this.channelCode;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.alias;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.supportBusiness;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.channelNumber;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.tags;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.contentEn;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.contentZh;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.keyWords;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.restricted;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        List<ShelvePoster> list = this.posterList;
        int hashCode11 = (hashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        List<ShelveAddress> list2 = this.liveAddressList;
        return hashCode11 + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setAlias(String str) {
        this.alias = str;
    }

    public final void setChannelCode(String str) {
        this.channelCode = str;
    }

    public final void setChannelNumber(String str) {
        this.channelNumber = str;
    }

    public final void setContentEn(String str) {
        this.contentEn = str;
    }

    public final void setContentZh(String str) {
        this.contentZh = str;
    }

    public final void setKeyWords(String str) {
        this.keyWords = str;
    }

    public final void setLiveAddressList(List<ShelveAddress> list) {
        this.liveAddressList = list;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPosterList(List<ShelvePoster> list) {
        this.posterList = list;
    }

    public final void setRestricted(String str) {
        this.restricted = str;
    }

    public final void setSupportBusiness(String str) {
        this.supportBusiness = str;
    }

    public final void setTags(String str) {
        this.tags = str;
    }

    public String toString() {
        return "ShelveChannel(channelCode=" + this.channelCode + ", name=" + this.name + ", alias=" + this.alias + ", supportBusiness=" + this.supportBusiness + ", channelNumber=" + this.channelNumber + ", tags=" + this.tags + ", contentEn=" + this.contentEn + ", contentZh=" + this.contentZh + ", keyWords=" + this.keyWords + ", restricted=" + this.restricted + ", posterList=" + this.posterList + ", liveAddressList=" + this.liveAddressList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
