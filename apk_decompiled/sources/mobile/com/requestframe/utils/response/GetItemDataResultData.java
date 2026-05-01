package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class GetItemDataResultData implements Serializable {
    private AssetData assetData;

    public GetItemDataResultData(AssetData assetData) {
        i.g(assetData, "assetData");
        this.assetData = assetData;
    }

    public static /* synthetic */ GetItemDataResultData copy$default(GetItemDataResultData getItemDataResultData, AssetData assetData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            assetData = getItemDataResultData.assetData;
        }
        return getItemDataResultData.copy(assetData);
    }

    public final AssetData component1() {
        return this.assetData;
    }

    public final GetItemDataResultData copy(AssetData assetData) {
        i.g(assetData, "assetData");
        return new GetItemDataResultData(assetData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetItemDataResultData) && i.b(this.assetData, ((GetItemDataResultData) obj).assetData);
    }

    public final AssetData getAssetData() {
        return this.assetData;
    }

    public int hashCode() {
        return this.assetData.hashCode();
    }

    public final void setAssetData(AssetData assetData) {
        i.g(assetData, "<set-?>");
        this.assetData = assetData;
    }

    public String toString() {
        return "GetItemDataResultData(assetData=" + this.assetData + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
