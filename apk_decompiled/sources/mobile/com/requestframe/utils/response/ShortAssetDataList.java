package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class ShortAssetDataList {
    private List<ShortAssetData> assetDataList;

    public ShortAssetDataList(List<ShortAssetData> list) {
        i.g(list, "assetDataList");
        this.assetDataList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShortAssetDataList copy$default(ShortAssetDataList shortAssetDataList, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = shortAssetDataList.assetDataList;
        }
        return shortAssetDataList.copy(list);
    }

    public final List<ShortAssetData> component1() {
        return this.assetDataList;
    }

    public final ShortAssetDataList copy(List<ShortAssetData> list) {
        i.g(list, "assetDataList");
        return new ShortAssetDataList(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShortAssetDataList) && i.b(this.assetDataList, ((ShortAssetDataList) obj).assetDataList);
    }

    public final List<ShortAssetData> getAssetDataList() {
        return this.assetDataList;
    }

    public int hashCode() {
        return this.assetDataList.hashCode();
    }

    public final void setAssetDataList(List<ShortAssetData> list) {
        i.g(list, "<set-?>");
        this.assetDataList = list;
    }

    public String toString() {
        return "ShortAssetDataList(assetDataList=" + this.assetDataList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
