package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class SearchByContent {
    private List<ShelveAsset> assetList;

    public SearchByContent(List<ShelveAsset> list) {
        this.assetList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchByContent copy$default(SearchByContent searchByContent, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = searchByContent.assetList;
        }
        return searchByContent.copy(list);
    }

    public final List<ShelveAsset> component1() {
        return this.assetList;
    }

    public final SearchByContent copy(List<ShelveAsset> list) {
        return new SearchByContent(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SearchByContent) && i.b(this.assetList, ((SearchByContent) obj).assetList);
    }

    public final List<ShelveAsset> getAssetList() {
        return this.assetList;
    }

    public int hashCode() {
        List<ShelveAsset> list = this.assetList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setAssetList(List<ShelveAsset> list) {
        this.assetList = list;
    }

    public String toString() {
        return "SearchByContent(assetList=" + this.assetList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
