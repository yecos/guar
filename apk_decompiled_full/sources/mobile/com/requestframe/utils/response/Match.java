package mobile.com.requestframe.utils.response;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.ArrayList;
import na.b;
import t9.i;

/* loaded from: classes3.dex */
public final class Match implements Serializable {
    private String channelCode;
    private ArrayList<MatchChannel> channelInfoList;
    private String channelName;
    private String gameId;
    private String gameStatus;
    private String gameTime;
    private boolean isInTenMinutes;
    private boolean isSubscribed;
    private String matchAlias;
    private String matchId;
    private String matchLogo;
    private String matchName;
    private String playBackType;
    private String playBackUrl;
    private String score;
    private Team team_a;
    private Team team_b;

    public Match(String str, Team team, Team team2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, ArrayList<MatchChannel> arrayList) {
        i.g(str, "gameId");
        i.g(team, "team_a");
        i.g(team2, "team_b");
        i.g(str2, "matchId");
        i.g(str3, "matchName");
        i.g(str4, "matchAlias");
        i.g(str6, "channelName");
        i.g(str7, "channelCode");
        i.g(str10, "gameTime");
        i.g(str11, FirebaseAnalytics.Param.SCORE);
        i.g(str12, "gameStatus");
        this.gameId = str;
        this.team_a = team;
        this.team_b = team2;
        this.matchId = str2;
        this.matchName = str3;
        this.matchAlias = str4;
        this.matchLogo = str5;
        this.channelName = str6;
        this.channelCode = str7;
        this.playBackType = str8;
        this.playBackUrl = str9;
        this.gameTime = str10;
        this.score = str11;
        this.gameStatus = str12;
        this.channelInfoList = arrayList;
    }

    public final boolean calcInFifteenMinutes() {
        return b.a("yyyy-MM-dd HH:mm").compareTo(this.gameTime) < 0 && b.b("yyyy-MM-dd HH:mm", 900000L).compareTo(this.gameTime) >= 0;
    }

    public final boolean calcInTenMinutes() {
        return b.a("yyyy-MM-dd HH:mm").compareTo(this.gameTime) < 0 && b.b("yyyy-MM-dd HH:mm", 600000L).compareTo(this.gameTime) >= 0;
    }

    public final boolean calcOutFifteenMinutes() {
        return b.a("yyyy-MM-dd HH:mm").compareTo(this.gameTime) < 0 && b.b("yyyy-MM-dd HH:mm", 900000L).compareTo(this.gameTime) < 0;
    }

    public final boolean compareToGameTime() {
        return b.a("yyyy-MM-dd HH:mm").compareTo(this.gameTime) < 0;
    }

    public final String component1() {
        return this.gameId;
    }

    public final String component10() {
        return this.playBackType;
    }

    public final String component11() {
        return this.playBackUrl;
    }

    public final String component12() {
        return this.gameTime;
    }

    public final String component13() {
        return this.score;
    }

    public final String component14() {
        return this.gameStatus;
    }

    public final ArrayList<MatchChannel> component15() {
        return this.channelInfoList;
    }

    public final Team component2() {
        return this.team_a;
    }

    public final Team component3() {
        return this.team_b;
    }

    public final String component4() {
        return this.matchId;
    }

    public final String component5() {
        return this.matchName;
    }

    public final String component6() {
        return this.matchAlias;
    }

    public final String component7() {
        return this.matchLogo;
    }

    public final String component8() {
        return this.channelName;
    }

    public final String component9() {
        return this.channelCode;
    }

    public final Match copy(String str, Team team, Team team2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, ArrayList<MatchChannel> arrayList) {
        i.g(str, "gameId");
        i.g(team, "team_a");
        i.g(team2, "team_b");
        i.g(str2, "matchId");
        i.g(str3, "matchName");
        i.g(str4, "matchAlias");
        i.g(str6, "channelName");
        i.g(str7, "channelCode");
        i.g(str10, "gameTime");
        i.g(str11, FirebaseAnalytics.Param.SCORE);
        i.g(str12, "gameStatus");
        return new Match(str, team, team2, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Match)) {
            return false;
        }
        Match match = (Match) obj;
        return i.b(this.gameId, match.gameId) && i.b(this.team_a, match.team_a) && i.b(this.team_b, match.team_b) && i.b(this.matchId, match.matchId) && i.b(this.matchName, match.matchName) && i.b(this.matchAlias, match.matchAlias) && i.b(this.matchLogo, match.matchLogo) && i.b(this.channelName, match.channelName) && i.b(this.channelCode, match.channelCode) && i.b(this.playBackType, match.playBackType) && i.b(this.playBackUrl, match.playBackUrl) && i.b(this.gameTime, match.gameTime) && i.b(this.score, match.score) && i.b(this.gameStatus, match.gameStatus) && i.b(this.channelInfoList, match.channelInfoList);
    }

    public final boolean findFirstChannel() {
        MatchChannel firstChannel = getFirstChannel();
        if (firstChannel == null) {
            return false;
        }
        String channelCode = firstChannel.getChannelCode();
        return !(channelCode == null || channelCode.length() == 0);
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final ArrayList<MatchChannel> getChannelInfoList() {
        return this.channelInfoList;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final MatchChannel getFirstChannel() {
        ArrayList<MatchChannel> arrayList = this.channelInfoList;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList<MatchChannel> arrayList2 = this.channelInfoList;
        i.d(arrayList2);
        return arrayList2.get(0);
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final String getGameStatus() {
        return this.gameStatus;
    }

    public final String getGameTime() {
        return this.gameTime;
    }

    public final String getMatchAlias() {
        return this.matchAlias;
    }

    public final String getMatchId() {
        return this.matchId;
    }

    public final String getMatchLogo() {
        return this.matchLogo;
    }

    public final String getMatchName() {
        return this.matchName;
    }

    public final String getPlayBackType() {
        return this.playBackType;
    }

    public final String getPlayBackUrl() {
        return this.playBackUrl;
    }

    public final String getScore() {
        return this.score;
    }

    public final Team getTeam_a() {
        return this.team_a;
    }

    public final Team getTeam_b() {
        return this.team_b;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.gameId.hashCode() * 31) + this.team_a.hashCode()) * 31) + this.team_b.hashCode()) * 31) + this.matchId.hashCode()) * 31) + this.matchName.hashCode()) * 31) + this.matchAlias.hashCode()) * 31;
        String str = this.matchLogo;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.channelName.hashCode()) * 31) + this.channelCode.hashCode()) * 31;
        String str2 = this.playBackType;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.playBackUrl;
        int hashCode4 = (((((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.gameTime.hashCode()) * 31) + this.score.hashCode()) * 31) + this.gameStatus.hashCode()) * 31;
        ArrayList<MatchChannel> arrayList = this.channelInfoList;
        return hashCode4 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final boolean isGameEnd() {
        return i.b(this.gameStatus, "3");
    }

    public final boolean isGameOnGoing() {
        return (i.b(this.gameStatus, "2") || (i.b(this.gameStatus, "1") && b.a("yyyy-MM-dd HH:mm").compareTo(this.gameTime) >= 0)) && !isGameOut();
    }

    public final boolean isGameOut() {
        String b10 = b.b("yyyy-MM-dd HH:mm", -10800000L);
        String str = this.gameTime;
        i.f(b10, "inThreeHours");
        return str.compareTo(b10) < 0;
    }

    public final boolean isGameReadied() {
        return i.b(this.gameStatus, "1") && calcInFifteenMinutes();
    }

    public final boolean isInTenMinutes() {
        return this.isInTenMinutes;
    }

    public final boolean isNotStarted() {
        return i.b(this.gameStatus, "1") && compareToGameTime();
    }

    public final boolean isSubscribe() {
        return i.b(this.gameStatus, "1") && calcOutFifteenMinutes() && findFirstChannel();
    }

    public final boolean isSubscribeWithoutChannel() {
        return i.b(this.gameStatus, "1") && calcOutFifteenMinutes();
    }

    public final boolean isSubscribed() {
        return this.isSubscribed;
    }

    public final void setChannelCode(String str) {
        i.g(str, "<set-?>");
        this.channelCode = str;
    }

    public final void setChannelInfoList(ArrayList<MatchChannel> arrayList) {
        this.channelInfoList = arrayList;
    }

    public final void setChannelName(String str) {
        i.g(str, "<set-?>");
        this.channelName = str;
    }

    public final void setGameId(String str) {
        i.g(str, "<set-?>");
        this.gameId = str;
    }

    public final void setGameStatus(String str) {
        i.g(str, "<set-?>");
        this.gameStatus = str;
    }

    public final void setGameTime(String str) {
        i.g(str, "<set-?>");
        this.gameTime = str;
    }

    public final void setInTenMinutes(boolean z10) {
        this.isInTenMinutes = z10;
    }

    public final void setMatchAlias(String str) {
        i.g(str, "<set-?>");
        this.matchAlias = str;
    }

    public final void setMatchId(String str) {
        i.g(str, "<set-?>");
        this.matchId = str;
    }

    public final void setMatchLogo(String str) {
        this.matchLogo = str;
    }

    public final void setMatchName(String str) {
        i.g(str, "<set-?>");
        this.matchName = str;
    }

    public final void setPlayBackType(String str) {
        this.playBackType = str;
    }

    public final void setPlayBackUrl(String str) {
        this.playBackUrl = str;
    }

    public final void setScore(String str) {
        i.g(str, "<set-?>");
        this.score = str;
    }

    public final void setSubscribed(boolean z10) {
        this.isSubscribed = z10;
    }

    public final void setTeam_a(Team team) {
        i.g(team, "<set-?>");
        this.team_a = team;
    }

    public final void setTeam_b(Team team) {
        i.g(team, "<set-?>");
        this.team_b = team;
    }

    public String toString() {
        return "Match(gameId=" + this.gameId + ", team_a=" + this.team_a + ", team_b=" + this.team_b + ", matchId=" + this.matchId + ", matchName=" + this.matchName + ", matchAlias=" + this.matchAlias + ", matchLogo=" + this.matchLogo + ", channelName=" + this.channelName + ", channelCode=" + this.channelCode + ", playBackType=" + this.playBackType + ", playBackUrl=" + this.playBackUrl + ", gameTime=" + this.gameTime + ", score=" + this.score + ", gameStatus=" + this.gameStatus + ", channelInfoList=" + this.channelInfoList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Match(Team team) {
        this("", team, team, "", "", "", "", "", "0", "", "", "", "", "", new ArrayList());
        i.g(team, "team");
    }
}
