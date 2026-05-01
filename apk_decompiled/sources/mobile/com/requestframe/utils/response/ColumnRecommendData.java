package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class ColumnRecommendData implements Serializable {
    private List<ShelveAsset> assetList;
    private List<ShelveChannel> channelList;

    public ColumnRecommendData(List<ShelveAsset> list, List<ShelveChannel> list2) {
        this.assetList = list;
        this.channelList = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ColumnRecommendData copy$default(ColumnRecommendData columnRecommendData, List list, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = columnRecommendData.assetList;
        }
        if ((i10 & 2) != 0) {
            list2 = columnRecommendData.channelList;
        }
        return columnRecommendData.copy(list, list2);
    }

    public final List<ShelveAsset> component1() {
        return this.assetList;
    }

    public final List<ShelveChannel> component2() {
        return this.channelList;
    }

    public final ColumnRecommendData copy(List<ShelveAsset> list, List<ShelveChannel> list2) {
        return new ColumnRecommendData(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColumnRecommendData)) {
            return false;
        }
        ColumnRecommendData columnRecommendData = (ColumnRecommendData) obj;
        return i.b(this.assetList, columnRecommendData.assetList) && i.b(this.channelList, columnRecommendData.channelList);
    }

    public final List<ShelveAsset> getAssetList() {
        return this.assetList;
    }

    public final List<ShelveChannel> getChannelList() {
        return this.channelList;
    }

    public int hashCode() {
        List<ShelveAsset> list = this.assetList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<ShelveChannel> list2 = this.channelList;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setAssetList(List<ShelveAsset> list) {
        this.assetList = list;
    }

    public final void setChannelList(List<ShelveChannel> list) {
        this.channelList = list;
    }

    public String toString() {
        return "ColumnRecommendData(assetList=" + this.assetList + ", channelList=" + this.channelList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
