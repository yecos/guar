package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class MatchStat {
    private TeamStat team_a;
    private TeamStat team_b;

    public MatchStat(TeamStat teamStat, TeamStat teamStat2) {
        i.g(teamStat, "team_a");
        i.g(teamStat2, "team_b");
        this.team_a = teamStat;
        this.team_b = teamStat2;
    }

    public static /* synthetic */ MatchStat copy$default(MatchStat matchStat, TeamStat teamStat, TeamStat teamStat2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            teamStat = matchStat.team_a;
        }
        if ((i10 & 2) != 0) {
            teamStat2 = matchStat.team_b;
        }
        return matchStat.copy(teamStat, teamStat2);
    }

    public final TeamStat component1() {
        return this.team_a;
    }

    public final TeamStat component2() {
        return this.team_b;
    }

    public final MatchStat copy(TeamStat teamStat, TeamStat teamStat2) {
        i.g(teamStat, "team_a");
        i.g(teamStat2, "team_b");
        return new MatchStat(teamStat, teamStat2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchStat)) {
            return false;
        }
        MatchStat matchStat = (MatchStat) obj;
        return i.b(this.team_a, matchStat.team_a) && i.b(this.team_b, matchStat.team_b);
    }

    public final TeamStat getTeam_a() {
        return this.team_a;
    }

    public final TeamStat getTeam_b() {
        return this.team_b;
    }

    public int hashCode() {
        return (this.team_a.hashCode() * 31) + this.team_b.hashCode();
    }

    public final void setTeam_a(TeamStat teamStat) {
        i.g(teamStat, "<set-?>");
        this.team_a = teamStat;
    }

    public final void setTeam_b(TeamStat teamStat) {
        i.g(teamStat, "<set-?>");
        this.team_b = teamStat;
    }

    public String toString() {
        return "MatchStat(team_a=" + this.team_a + ", team_b=" + this.team_b + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
