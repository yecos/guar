package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class HomeRecommend implements Serializable {
    private List<HomeRecommend> aggregationList;
    private String alias;
    private List<HomeAsset> assetList;
    private List<Channel> channelList;
    private String code;
    private Integer columnId;
    private String free;
    private String name;
    private List<? extends PosterList> posterList;
    private String style;
    private String type;

    public HomeRecommend(String str, String str2, Integer num, String str3, String str4, String str5, String str6, List<HomeAsset> list, List<? extends PosterList> list2, List<Channel> list3, List<HomeRecommend> list4) {
        this.name = str;
        this.alias = str2;
        this.columnId = num;
        this.code = str3;
        this.type = str4;
        this.free = str5;
        this.style = str6;
        this.assetList = list;
        this.posterList = list2;
        this.channelList = list3;
        this.aggregationList = list4;
    }

    public final String component1() {
        return this.name;
    }

    public final List<Channel> component10() {
        return this.channelList;
    }

    public final List<HomeRecommend> component11() {
        return this.aggregationList;
    }

    public final String component2() {
        return this.alias;
    }

    public final Integer component3() {
        return this.columnId;
    }

    public final String component4() {
        return this.code;
    }

    public final String component5() {
        return this.type;
    }

    public final String component6() {
        return this.free;
    }

    public final String component7() {
        return this.style;
    }

    public final List<HomeAsset> component8() {
        return this.assetList;
    }

    public final List<PosterList> component9() {
        return this.posterList;
    }

    public final HomeRecommend copy(String str, String str2, Integer num, String str3, String str4, String str5, String str6, List<HomeAsset> list, List<? extends PosterList> list2, List<Channel> list3, List<HomeRecommend> list4) {
        return new HomeRecommend(str, str2, num, str3, str4, str5, str6, list, list2, list3, list4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeRecommend)) {
            return false;
        }
        HomeRecommend homeRecommend = (HomeRecommend) obj;
        return i.b(this.name, homeRecommend.name) && i.b(this.alias, homeRecommend.alias) && i.b(this.columnId, homeRecommend.columnId) && i.b(this.code, homeRecommend.code) && i.b(this.type, homeRecommend.type) && i.b(this.free, homeRecommend.free) && i.b(this.style, homeRecommend.style) && i.b(this.assetList, homeRecommend.assetList) && i.b(this.posterList, homeRecommend.posterList) && i.b(this.channelList, homeRecommend.channelList) && i.b(this.aggregationList, homeRecommend.aggregationList);
    }

    public final List<HomeRecommend> getAggregationList() {
        return this.aggregationList;
    }

    public final String getAlias() {
        return this.alias;
    }

    public final List<HomeAsset> getAssetList() {
        return this.assetList;
    }

    public final List<Channel> getChannelList() {
        return this.channelList;
    }

    public final String getCode() {
        return this.code;
    }

    public final Integer getColumnId() {
        return this.columnId;
    }

    public final String getFree() {
        return this.free;
    }

    public final String getName() {
        return this.name;
    }

    public final List<PosterList> getPosterList() {
        return this.posterList;
    }

    public final String getStyle() {
        return this.style;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.alias;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.columnId;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.code;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.type;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.free;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.style;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<HomeAsset> list = this.assetList;
        int hashCode8 = (hashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        List<? extends PosterList> list2 = this.posterList;
        int hashCode9 = (hashCode8 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<Channel> list3 = this.channelList;
        int hashCode10 = (hashCode9 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<HomeRecommend> list4 = this.aggregationList;
        return hashCode10 + (list4 != null ? list4.hashCode() : 0);
    }

    public final void setAggregationList(List<HomeRecommend> list) {
        this.aggregationList = list;
    }

    public final void setAlias(String str) {
        this.alias = str;
    }

    public final void setAssetList(List<HomeAsset> list) {
        this.assetList = list;
    }

    public final void setChannelList(List<Channel> list) {
        this.channelList = list;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final void setColumnId(Integer num) {
        this.columnId = num;
    }

    public final void setFree(String str) {
        this.free = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPosterList(List<? extends PosterList> list) {
        this.posterList = list;
    }

    public final void setStyle(String str) {
        this.style = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "HomeRecommend(name=" + this.name + ", alias=" + this.alias + ", columnId=" + this.columnId + ", code=" + this.code + ", type=" + this.type + ", free=" + this.free + ", style=" + this.style + ", assetList=" + this.assetList + ", posterList=" + this.posterList + ", channelList=" + this.channelList + ", aggregationList=" + this.aggregationList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
