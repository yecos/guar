package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.ArrayList;
import t9.i;

/* loaded from: classes3.dex */
public final class GetHomeData implements Serializable {
    private String freeVersion;
    private ArrayList<HomeRecommend> recommendList;
    private String version;

    public GetHomeData(ArrayList<HomeRecommend> arrayList, String str, String str2) {
        i.g(str, "version");
        i.g(str2, "freeVersion");
        this.recommendList = arrayList;
        this.version = str;
        this.freeVersion = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetHomeData copy$default(GetHomeData getHomeData, ArrayList arrayList, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            arrayList = getHomeData.recommendList;
        }
        if ((i10 & 2) != 0) {
            str = getHomeData.version;
        }
        if ((i10 & 4) != 0) {
            str2 = getHomeData.freeVersion;
        }
        return getHomeData.copy(arrayList, str, str2);
    }

    public final ArrayList<HomeRecommend> component1() {
        return this.recommendList;
    }

    public final String component2() {
        return this.version;
    }

    public final String component3() {
        return this.freeVersion;
    }

    public final GetHomeData copy(ArrayList<HomeRecommend> arrayList, String str, String str2) {
        i.g(str, "version");
        i.g(str2, "freeVersion");
        return new GetHomeData(arrayList, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetHomeData)) {
            return false;
        }
        GetHomeData getHomeData = (GetHomeData) obj;
        return i.b(this.recommendList, getHomeData.recommendList) && i.b(this.version, getHomeData.version) && i.b(this.freeVersion, getHomeData.freeVersion);
    }

    public final String getFreeVersion() {
        return this.freeVersion;
    }

    public final ArrayList<HomeRecommend> getRecommendList() {
        return this.recommendList;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        ArrayList<HomeRecommend> arrayList = this.recommendList;
        return ((((arrayList == null ? 0 : arrayList.hashCode()) * 31) + this.version.hashCode()) * 31) + this.freeVersion.hashCode();
    }

    public final void setFreeVersion(String str) {
        i.g(str, "<set-?>");
        this.freeVersion = str;
    }

    public final void setRecommendList(ArrayList<HomeRecommend> arrayList) {
        this.recommendList = arrayList;
    }

    public final void setVersion(String str) {
        i.g(str, "<set-?>");
        this.version = str;
    }

    public String toString() {
        return "GetHomeData(recommendList=" + this.recommendList + ", version=" + this.version + ", freeVersion=" + this.freeVersion + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
