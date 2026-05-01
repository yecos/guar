package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import t9.i;

/* loaded from: classes3.dex */
public final class LineupTeam {
    private LineupPlayer goalkeeper;
    private ArrayList<ArrayList<LineupPlayer>> playerList;
    private String squad;
    private int teamId;

    public LineupTeam(int i10, String str, LineupPlayer lineupPlayer, ArrayList<ArrayList<LineupPlayer>> arrayList) {
        i.g(str, "squad");
        i.g(lineupPlayer, "goalkeeper");
        i.g(arrayList, "playerList");
        this.teamId = i10;
        this.squad = str;
        this.goalkeeper = lineupPlayer;
        this.playerList = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LineupTeam copy$default(LineupTeam lineupTeam, int i10, String str, LineupPlayer lineupPlayer, ArrayList arrayList, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = lineupTeam.teamId;
        }
        if ((i11 & 2) != 0) {
            str = lineupTeam.squad;
        }
        if ((i11 & 4) != 0) {
            lineupPlayer = lineupTeam.goalkeeper;
        }
        if ((i11 & 8) != 0) {
            arrayList = lineupTeam.playerList;
        }
        return lineupTeam.copy(i10, str, lineupPlayer, arrayList);
    }

    public final int component1() {
        return this.teamId;
    }

    public final String component2() {
        return this.squad;
    }

    public final LineupPlayer component3() {
        return this.goalkeeper;
    }

    public final ArrayList<ArrayList<LineupPlayer>> component4() {
        return this.playerList;
    }

    public final LineupTeam copy(int i10, String str, LineupPlayer lineupPlayer, ArrayList<ArrayList<LineupPlayer>> arrayList) {
        i.g(str, "squad");
        i.g(lineupPlayer, "goalkeeper");
        i.g(arrayList, "playerList");
        return new LineupTeam(i10, str, lineupPlayer, arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineupTeam)) {
            return false;
        }
        LineupTeam lineupTeam = (LineupTeam) obj;
        return this.teamId == lineupTeam.teamId && i.b(this.squad, lineupTeam.squad) && i.b(this.goalkeeper, lineupTeam.goalkeeper) && i.b(this.playerList, lineupTeam.playerList);
    }

    public final LineupPlayer getGoalkeeper() {
        return this.goalkeeper;
    }

    public final ArrayList<ArrayList<LineupPlayer>> getPlayerList() {
        return this.playerList;
    }

    public final String getSquad() {
        return this.squad;
    }

    public final int getTeamId() {
        return this.teamId;
    }

    public int hashCode() {
        return (((((this.teamId * 31) + this.squad.hashCode()) * 31) + this.goalkeeper.hashCode()) * 31) + this.playerList.hashCode();
    }

    public final void setGoalkeeper(LineupPlayer lineupPlayer) {
        i.g(lineupPlayer, "<set-?>");
        this.goalkeeper = lineupPlayer;
    }

    public final void setPlayerList(ArrayList<ArrayList<LineupPlayer>> arrayList) {
        i.g(arrayList, "<set-?>");
        this.playerList = arrayList;
    }

    public final void setSquad(String str) {
        i.g(str, "<set-?>");
        this.squad = str;
    }

    public final void setTeamId(int i10) {
        this.teamId = i10;
    }

    public String toString() {
        return "LineupTeam(teamId=" + this.teamId + ", squad=" + this.squad + ", goalkeeper=" + this.goalkeeper + ", playerList=" + this.playerList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
