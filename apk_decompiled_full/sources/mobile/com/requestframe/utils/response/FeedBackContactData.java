package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class FeedBackContactData {
    private String logo;
    private String name;
    private List<WorkInfoBean> workInfoList;

    public FeedBackContactData(String str, List<WorkInfoBean> list, String str2) {
        i.g(str, "name");
        i.g(list, "workInfoList");
        this.name = str;
        this.workInfoList = list;
        this.logo = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedBackContactData copy$default(FeedBackContactData feedBackContactData, String str, List list, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = feedBackContactData.name;
        }
        if ((i10 & 2) != 0) {
            list = feedBackContactData.workInfoList;
        }
        if ((i10 & 4) != 0) {
            str2 = feedBackContactData.logo;
        }
        return feedBackContactData.copy(str, list, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final List<WorkInfoBean> component2() {
        return this.workInfoList;
    }

    public final String component3() {
        return this.logo;
    }

    public final FeedBackContactData copy(String str, List<WorkInfoBean> list, String str2) {
        i.g(str, "name");
        i.g(list, "workInfoList");
        return new FeedBackContactData(str, list, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedBackContactData)) {
            return false;
        }
        FeedBackContactData feedBackContactData = (FeedBackContactData) obj;
        return i.b(this.name, feedBackContactData.name) && i.b(this.workInfoList, feedBackContactData.workInfoList) && i.b(this.logo, feedBackContactData.logo);
    }

    public final String getLogo() {
        return this.logo;
    }

    public final String getName() {
        return this.name;
    }

    public final List<WorkInfoBean> getWorkInfoList() {
        return this.workInfoList;
    }

    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + this.workInfoList.hashCode()) * 31;
        String str = this.logo;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setLogo(String str) {
        this.logo = str;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public final void setWorkInfoList(List<WorkInfoBean> list) {
        i.g(list, "<set-?>");
        this.workInfoList = list;
    }

    public String toString() {
        return "FeedBackContactData(name=" + this.name + ", workInfoList=" + this.workInfoList + ", logo=" + this.logo + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
