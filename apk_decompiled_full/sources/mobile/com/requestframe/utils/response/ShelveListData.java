package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class ShelveListData {
    private List<ShelveAsset> assetList;
    private int assetListTotalSize;
    private List<ShelveChannel> channelList;
    private int channelListTotalSize;
    private int favoriteId;
    private int freshTime;
    private String hasFavorite;
    private SlbInfo slbInfo;
    private String version;

    public ShelveListData(String str, int i10, int i11, List<ShelveChannel> list, List<ShelveAsset> list2, int i12, SlbInfo slbInfo, String str2, int i13) {
        i.g(slbInfo, "slbInfo");
        i.g(str2, "hasFavorite");
        this.version = str;
        this.channelListTotalSize = i10;
        this.assetListTotalSize = i11;
        this.channelList = list;
        this.assetList = list2;
        this.freshTime = i12;
        this.slbInfo = slbInfo;
        this.hasFavorite = str2;
        this.favoriteId = i13;
    }

    public final String component1() {
        return this.version;
    }

    public final int component2() {
        return this.channelListTotalSize;
    }

    public final int component3() {
        return this.assetListTotalSize;
    }

    public final List<ShelveChannel> component4() {
        return this.channelList;
    }

    public final List<ShelveAsset> component5() {
        return this.assetList;
    }

    public final int component6() {
        return this.freshTime;
    }

    public final SlbInfo component7() {
        return this.slbInfo;
    }

    public final String component8() {
        return this.hasFavorite;
    }

    public final int component9() {
        return this.favoriteId;
    }

    public final ShelveListData copy(String str, int i10, int i11, List<ShelveChannel> list, List<ShelveAsset> list2, int i12, SlbInfo slbInfo, String str2, int i13) {
        i.g(slbInfo, "slbInfo");
        i.g(str2, "hasFavorite");
        return new ShelveListData(str, i10, i11, list, list2, i12, slbInfo, str2, i13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShelveListData)) {
            return false;
        }
        ShelveListData shelveListData = (ShelveListData) obj;
        return i.b(this.version, shelveListData.version) && this.channelListTotalSize == shelveListData.channelListTotalSize && this.assetListTotalSize == shelveListData.assetListTotalSize && i.b(this.channelList, shelveListData.channelList) && i.b(this.assetList, shelveListData.assetList) && this.freshTime == shelveListData.freshTime && i.b(this.slbInfo, shelveListData.slbInfo) && i.b(this.hasFavorite, shelveListData.hasFavorite) && this.favoriteId == shelveListData.favoriteId;
    }

    public final List<ShelveAsset> getAssetList() {
        return this.assetList;
    }

    public final int getAssetListTotalSize() {
        return this.assetListTotalSize;
    }

    public final List<ShelveChannel> getChannelList() {
        return this.channelList;
    }

    public final int getChannelListTotalSize() {
        return this.channelListTotalSize;
    }

    public final int getFavoriteId() {
        return this.favoriteId;
    }

    public final int getFreshTime() {
        return this.freshTime;
    }

    public final String getHasFavorite() {
        return this.hasFavorite;
    }

    public final SlbInfo getSlbInfo() {
        return this.slbInfo;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.version;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.channelListTotalSize) * 31) + this.assetListTotalSize) * 31;
        List<ShelveChannel> list = this.channelList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<ShelveAsset> list2 = this.assetList;
        return ((((((((hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.freshTime) * 31) + this.slbInfo.hashCode()) * 31) + this.hasFavorite.hashCode()) * 31) + this.favoriteId;
    }

    public final void setAssetList(List<ShelveAsset> list) {
        this.assetList = list;
    }

    public final void setAssetListTotalSize(int i10) {
        this.assetListTotalSize = i10;
    }

    public final void setChannelList(List<ShelveChannel> list) {
        this.channelList = list;
    }

    public final void setChannelListTotalSize(int i10) {
        this.channelListTotalSize = i10;
    }

    public final void setFavoriteId(int i10) {
        this.favoriteId = i10;
    }

    public final void setFreshTime(int i10) {
        this.freshTime = i10;
    }

    public final void setHasFavorite(String str) {
        i.g(str, "<set-?>");
        this.hasFavorite = str;
    }

    public final void setSlbInfo(SlbInfo slbInfo) {
        i.g(slbInfo, "<set-?>");
        this.slbInfo = slbInfo;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "ShelveListData(version=" + this.version + ", channelListTotalSize=" + this.channelListTotalSize + ", assetListTotalSize=" + this.assetListTotalSize + ", channelList=" + this.channelList + ", assetList=" + this.assetList + ", freshTime=" + this.freshTime + ", slbInfo=" + this.slbInfo + ", hasFavorite=" + this.hasFavorite + ", favoriteId=" + this.favoriteId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
