package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import t9.i;

/* loaded from: classes3.dex */
public final class GetNextColumnData {
    private ArrayList<HomeRecommend> recommendList;
    private final Integer totalSize;
    private String version;

    public GetNextColumnData(ArrayList<HomeRecommend> arrayList, String str, Integer num) {
        i.g(str, "version");
        this.recommendList = arrayList;
        this.version = str;
        this.totalSize = num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetNextColumnData copy$default(GetNextColumnData getNextColumnData, ArrayList arrayList, String str, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            arrayList = getNextColumnData.recommendList;
        }
        if ((i10 & 2) != 0) {
            str = getNextColumnData.version;
        }
        if ((i10 & 4) != 0) {
            num = getNextColumnData.totalSize;
        }
        return getNextColumnData.copy(arrayList, str, num);
    }

    public final ArrayList<HomeRecommend> component1() {
        return this.recommendList;
    }

    public final String component2() {
        return this.version;
    }

    public final Integer component3() {
        return this.totalSize;
    }

    public final GetNextColumnData copy(ArrayList<HomeRecommend> arrayList, String str, Integer num) {
        i.g(str, "version");
        return new GetNextColumnData(arrayList, str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetNextColumnData)) {
            return false;
        }
        GetNextColumnData getNextColumnData = (GetNextColumnData) obj;
        return i.b(this.recommendList, getNextColumnData.recommendList) && i.b(this.version, getNextColumnData.version) && i.b(this.totalSize, getNextColumnData.totalSize);
    }

    public final ArrayList<HomeRecommend> getRecommendList() {
        return this.recommendList;
    }

    public final Integer getTotalSize() {
        return this.totalSize;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        ArrayList<HomeRecommend> arrayList = this.recommendList;
        int hashCode = (((arrayList == null ? 0 : arrayList.hashCode()) * 31) + this.version.hashCode()) * 31;
        Integer num = this.totalSize;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public final void setRecommendList(ArrayList<HomeRecommend> arrayList) {
        this.recommendList = arrayList;
    }

    public final void setVersion(String str) {
        i.g(str, "<set-?>");
        this.version = str;
    }

    public String toString() {
        return "GetNextColumnData(recommendList=" + this.recommendList + ", version=" + this.version + ", totalSize=" + this.totalSize + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
