package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import t9.i;

/* loaded from: classes3.dex */
public final class MatchEventTeam {
    private ArrayList<TeamEvent> teamEvent;

    public MatchEventTeam(ArrayList<TeamEvent> arrayList) {
        i.g(arrayList, "teamEvent");
        this.teamEvent = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MatchEventTeam copy$default(MatchEventTeam matchEventTeam, ArrayList arrayList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            arrayList = matchEventTeam.teamEvent;
        }
        return matchEventTeam.copy(arrayList);
    }

    public final ArrayList<TeamEvent> component1() {
        return this.teamEvent;
    }

    public final MatchEventTeam copy(ArrayList<TeamEvent> arrayList) {
        i.g(arrayList, "teamEvent");
        return new MatchEventTeam(arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MatchEventTeam) && i.b(this.teamEvent, ((MatchEventTeam) obj).teamEvent);
    }

    public final ArrayList<TeamEvent> getTeamEvent() {
        return this.teamEvent;
    }

    public int hashCode() {
        return this.teamEvent.hashCode();
    }

    public final void setTeamEvent(ArrayList<TeamEvent> arrayList) {
        i.g(arrayList, "<set-?>");
        this.teamEvent = arrayList;
    }

    public String toString() {
        return "MatchEventTeam(teamEvent=" + this.teamEvent + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
