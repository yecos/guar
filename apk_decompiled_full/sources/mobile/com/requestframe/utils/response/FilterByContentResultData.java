package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class FilterByContentResultData {
    private List<ShelveAsset> assetList;
    private Integer totalSize;

    public FilterByContentResultData(List<ShelveAsset> list, Integer num) {
        this.assetList = list;
        this.totalSize = num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilterByContentResultData copy$default(FilterByContentResultData filterByContentResultData, List list, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = filterByContentResultData.assetList;
        }
        if ((i10 & 2) != 0) {
            num = filterByContentResultData.totalSize;
        }
        return filterByContentResultData.copy(list, num);
    }

    public final List<ShelveAsset> component1() {
        return this.assetList;
    }

    public final Integer component2() {
        return this.totalSize;
    }

    public final FilterByContentResultData copy(List<ShelveAsset> list, Integer num) {
        return new FilterByContentResultData(list, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterByContentResultData)) {
            return false;
        }
        FilterByContentResultData filterByContentResultData = (FilterByContentResultData) obj;
        return i.b(this.assetList, filterByContentResultData.assetList) && i.b(this.totalSize, filterByContentResultData.totalSize);
    }

    public final List<ShelveAsset> getAssetList() {
        return this.assetList;
    }

    public final Integer getTotalSize() {
        return this.totalSize;
    }

    public int hashCode() {
        List<ShelveAsset> list = this.assetList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.totalSize;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public final void setAssetList(List<ShelveAsset> list) {
        this.assetList = list;
    }

    public final void setTotalSize(Integer num) {
        this.totalSize = num;
    }

    public String toString() {
        return "FilterByContentResultData(assetList=" + this.assetList + ", totalSize=" + this.totalSize + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
