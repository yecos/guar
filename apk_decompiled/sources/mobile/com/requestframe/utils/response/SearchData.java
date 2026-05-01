package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class SearchData {
    private List<SearchItem> searchItemList;
    private int totalSize;

    public SearchData(int i10, List<SearchItem> list) {
        i.g(list, "searchItemList");
        this.totalSize = i10;
        this.searchItemList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchData copy$default(SearchData searchData, int i10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = searchData.totalSize;
        }
        if ((i11 & 2) != 0) {
            list = searchData.searchItemList;
        }
        return searchData.copy(i10, list);
    }

    public final int component1() {
        return this.totalSize;
    }

    public final List<SearchItem> component2() {
        return this.searchItemList;
    }

    public final SearchData copy(int i10, List<SearchItem> list) {
        i.g(list, "searchItemList");
        return new SearchData(i10, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchData)) {
            return false;
        }
        SearchData searchData = (SearchData) obj;
        return this.totalSize == searchData.totalSize && i.b(this.searchItemList, searchData.searchItemList);
    }

    public final List<SearchItem> getSearchItemList() {
        return this.searchItemList;
    }

    public final int getTotalSize() {
        return this.totalSize;
    }

    public int hashCode() {
        return (this.totalSize * 31) + this.searchItemList.hashCode();
    }

    public final void setSearchItemList(List<SearchItem> list) {
        i.g(list, "<set-?>");
        this.searchItemList = list;
    }

    public final void setTotalSize(int i10) {
        this.totalSize = i10;
    }

    public String toString() {
        return "SearchData(totalSize=" + this.totalSize + ", searchItemList=" + this.searchItemList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
