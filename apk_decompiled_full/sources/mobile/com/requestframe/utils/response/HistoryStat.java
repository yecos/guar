package mobile.com.requestframe.utils.response;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class HistoryStat {
    private String gameTime;
    private String league;
    private String score;
    private String team_a_name;
    private String team_b_name;

    public HistoryStat(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "team_a_name");
        i.g(str2, "team_b_name");
        i.g(str3, "gameTime");
        i.g(str4, "league");
        i.g(str5, FirebaseAnalytics.Param.SCORE);
        this.team_a_name = str;
        this.team_b_name = str2;
        this.gameTime = str3;
        this.league = str4;
        this.score = str5;
    }

    public static /* synthetic */ HistoryStat copy$default(HistoryStat historyStat, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = historyStat.team_a_name;
        }
        if ((i10 & 2) != 0) {
            str2 = historyStat.team_b_name;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = historyStat.gameTime;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = historyStat.league;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = historyStat.score;
        }
        return historyStat.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.team_a_name;
    }

    public final String component2() {
        return this.team_b_name;
    }

    public final String component3() {
        return this.gameTime;
    }

    public final String component4() {
        return this.league;
    }

    public final String component5() {
        return this.score;
    }

    public final HistoryStat copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "team_a_name");
        i.g(str2, "team_b_name");
        i.g(str3, "gameTime");
        i.g(str4, "league");
        i.g(str5, FirebaseAnalytics.Param.SCORE);
        return new HistoryStat(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HistoryStat)) {
            return false;
        }
        HistoryStat historyStat = (HistoryStat) obj;
        return i.b(this.team_a_name, historyStat.team_a_name) && i.b(this.team_b_name, historyStat.team_b_name) && i.b(this.gameTime, historyStat.gameTime) && i.b(this.league, historyStat.league) && i.b(this.score, historyStat.score);
    }

    public final String getGameTime() {
        return this.gameTime;
    }

    public final String getLeague() {
        return this.league;
    }

    public final String getScore() {
        return this.score;
    }

    public final String getTeam_a_name() {
        return this.team_a_name;
    }

    public final String getTeam_b_name() {
        return this.team_b_name;
    }

    public int hashCode() {
        return (((((((this.team_a_name.hashCode() * 31) + this.team_b_name.hashCode()) * 31) + this.gameTime.hashCode()) * 31) + this.league.hashCode()) * 31) + this.score.hashCode();
    }

    public final void setGameTime(String str) {
        i.g(str, "<set-?>");
        this.gameTime = str;
    }

    public final void setLeague(String str) {
        i.g(str, "<set-?>");
        this.league = str;
    }

    public final void setScore(String str) {
        i.g(str, "<set-?>");
        this.score = str;
    }

    public final void setTeam_a_name(String str) {
        i.g(str, "<set-?>");
        this.team_a_name = str;
    }

    public final void setTeam_b_name(String str) {
        i.g(str, "<set-?>");
        this.team_b_name = str;
    }

    public String toString() {
        return "HistoryStat(team_a_name=" + this.team_a_name + ", team_b_name=" + this.team_b_name + ", gameTime=" + this.gameTime + ", league=" + this.league + ", score=" + this.score + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
