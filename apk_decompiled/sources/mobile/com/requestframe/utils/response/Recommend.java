package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class Recommend implements Serializable {
    private List<RecommendContentList> contentList;
    private String recommendCode;
    private String scheduleName;

    public Recommend(String str, String str2, List<RecommendContentList> list) {
        i.g(list, "contentList");
        this.recommendCode = str;
        this.scheduleName = str2;
        this.contentList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Recommend copy$default(Recommend recommend, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = recommend.recommendCode;
        }
        if ((i10 & 2) != 0) {
            str2 = recommend.scheduleName;
        }
        if ((i10 & 4) != 0) {
            list = recommend.contentList;
        }
        return recommend.copy(str, str2, list);
    }

    public final String component1() {
        return this.recommendCode;
    }

    public final String component2() {
        return this.scheduleName;
    }

    public final List<RecommendContentList> component3() {
        return this.contentList;
    }

    public final Recommend copy(String str, String str2, List<RecommendContentList> list) {
        i.g(list, "contentList");
        return new Recommend(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Recommend)) {
            return false;
        }
        Recommend recommend = (Recommend) obj;
        return i.b(this.recommendCode, recommend.recommendCode) && i.b(this.scheduleName, recommend.scheduleName) && i.b(this.contentList, recommend.contentList);
    }

    public final List<RecommendContentList> getContentList() {
        return this.contentList;
    }

    public final String getRecommendCode() {
        return this.recommendCode;
    }

    public final String getScheduleName() {
        return this.scheduleName;
    }

    public int hashCode() {
        String str = this.recommendCode;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.scheduleName;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.contentList.hashCode();
    }

    public final void setContentList(List<RecommendContentList> list) {
        i.g(list, "<set-?>");
        this.contentList = list;
    }

    public final void setRecommendCode(String str) {
        this.recommendCode = str;
    }

    public final void setScheduleName(String str) {
        this.scheduleName = str;
    }

    public String toString() {
        return "Recommend(recommendCode=" + this.recommendCode + ", scheduleName=" + this.scheduleName + ", contentList=" + this.contentList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
