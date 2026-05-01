package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class ShelveMatchList {
    private List<ShelveMatch> matchList;

    public ShelveMatchList(List<ShelveMatch> list) {
        this.matchList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShelveMatchList copy$default(ShelveMatchList shelveMatchList, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = shelveMatchList.matchList;
        }
        return shelveMatchList.copy(list);
    }

    public final List<ShelveMatch> component1() {
        return this.matchList;
    }

    public final ShelveMatchList copy(List<ShelveMatch> list) {
        return new ShelveMatchList(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShelveMatchList) && i.b(this.matchList, ((ShelveMatchList) obj).matchList);
    }

    public final List<ShelveMatch> getMatchList() {
        return this.matchList;
    }

    public int hashCode() {
        List<ShelveMatch> list = this.matchList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setMatchList(List<ShelveMatch> list) {
        this.matchList = list;
    }

    public String toString() {
        return "ShelveMatchList(matchList=" + this.matchList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
