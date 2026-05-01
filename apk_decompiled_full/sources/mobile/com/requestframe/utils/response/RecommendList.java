package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class RecommendList implements Serializable {
    private List<Recommend> recommendList;

    public RecommendList(List<Recommend> list) {
        this.recommendList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecommendList copy$default(RecommendList recommendList, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = recommendList.recommendList;
        }
        return recommendList.copy(list);
    }

    public final List<Recommend> component1() {
        return this.recommendList;
    }

    public final RecommendList copy(List<Recommend> list) {
        return new RecommendList(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RecommendList) && i.b(this.recommendList, ((RecommendList) obj).recommendList);
    }

    public final List<Recommend> getRecommendList() {
        return this.recommendList;
    }

    public int hashCode() {
        List<Recommend> list = this.recommendList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setRecommendList(List<Recommend> list) {
        this.recommendList = list;
    }

    public String toString() {
        return "RecommendList(recommendList=" + this.recommendList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
