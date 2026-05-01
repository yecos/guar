package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class Team implements Serializable {
    private String teamAlias;
    private String teamId;
    private String teamLogo;
    private String teamName;

    public Team(String str, String str2, String str3, String str4) {
        i.g(str, "teamId");
        i.g(str2, "teamName");
        i.g(str3, "teamAlias");
        this.teamId = str;
        this.teamName = str2;
        this.teamAlias = str3;
        this.teamLogo = str4;
    }

    public static /* synthetic */ Team copy$default(Team team, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = team.teamId;
        }
        if ((i10 & 2) != 0) {
            str2 = team.teamName;
        }
        if ((i10 & 4) != 0) {
            str3 = team.teamAlias;
        }
        if ((i10 & 8) != 0) {
            str4 = team.teamLogo;
        }
        return team.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.teamId;
    }

    public final String component2() {
        return this.teamName;
    }

    public final String component3() {
        return this.teamAlias;
    }

    public final String component4() {
        return this.teamLogo;
    }

    public final Team copy(String str, String str2, String str3, String str4) {
        i.g(str, "teamId");
        i.g(str2, "teamName");
        i.g(str3, "teamAlias");
        return new Team(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Team)) {
            return false;
        }
        Team team = (Team) obj;
        return i.b(this.teamId, team.teamId) && i.b(this.teamName, team.teamName) && i.b(this.teamAlias, team.teamAlias) && i.b(this.teamLogo, team.teamLogo);
    }

    public final String getTeamAlias() {
        return this.teamAlias;
    }

    public final String getTeamId() {
        return this.teamId;
    }

    public final String getTeamLogo() {
        return this.teamLogo;
    }

    public final String getTeamName() {
        return this.teamName;
    }

    public int hashCode() {
        int hashCode = ((((this.teamId.hashCode() * 31) + this.teamName.hashCode()) * 31) + this.teamAlias.hashCode()) * 31;
        String str = this.teamLogo;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setTeamAlias(String str) {
        i.g(str, "<set-?>");
        this.teamAlias = str;
    }

    public final void setTeamId(String str) {
        i.g(str, "<set-?>");
        this.teamId = str;
    }

    public final void setTeamLogo(String str) {
        this.teamLogo = str;
    }

    public final void setTeamName(String str) {
        i.g(str, "<set-?>");
        this.teamName = str;
    }

    public String toString() {
        return "Team(teamId=" + this.teamId + ", teamName=" + this.teamName + ", teamAlias=" + this.teamAlias + ", teamLogo=" + this.teamLogo + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
