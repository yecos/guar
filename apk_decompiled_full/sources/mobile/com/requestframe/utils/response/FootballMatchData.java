package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class FootballMatchData {
    private List<Match> teamList;

    public FootballMatchData(List<Match> list) {
        i.g(list, "teamList");
        this.teamList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FootballMatchData copy$default(FootballMatchData footballMatchData, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = footballMatchData.teamList;
        }
        return footballMatchData.copy(list);
    }

    public final List<Match> component1() {
        return this.teamList;
    }

    public final FootballMatchData copy(List<Match> list) {
        i.g(list, "teamList");
        return new FootballMatchData(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FootballMatchData) && i.b(this.teamList, ((FootballMatchData) obj).teamList);
    }

    public final List<Match> getTeamList() {
        return this.teamList;
    }

    public int hashCode() {
        return this.teamList.hashCode();
    }

    public final void setTeamList(List<Match> list) {
        i.g(list, "<set-?>");
        this.teamList = list;
    }

    public String toString() {
        return "FootballMatchData(teamList=" + this.teamList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
