package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class LineupPlayer {
    private String icon;
    private String name;
    private String number;
    private int playerId;

    public LineupPlayer(int i10, String str, String str2, String str3) {
        i.g(str, "name");
        i.g(str3, "number");
        this.playerId = i10;
        this.name = str;
        this.icon = str2;
        this.number = str3;
    }

    public static /* synthetic */ LineupPlayer copy$default(LineupPlayer lineupPlayer, int i10, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = lineupPlayer.playerId;
        }
        if ((i11 & 2) != 0) {
            str = lineupPlayer.name;
        }
        if ((i11 & 4) != 0) {
            str2 = lineupPlayer.icon;
        }
        if ((i11 & 8) != 0) {
            str3 = lineupPlayer.number;
        }
        return lineupPlayer.copy(i10, str, str2, str3);
    }

    public final int component1() {
        return this.playerId;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.number;
    }

    public final LineupPlayer copy(int i10, String str, String str2, String str3) {
        i.g(str, "name");
        i.g(str3, "number");
        return new LineupPlayer(i10, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineupPlayer)) {
            return false;
        }
        LineupPlayer lineupPlayer = (LineupPlayer) obj;
        return this.playerId == lineupPlayer.playerId && i.b(this.name, lineupPlayer.name) && i.b(this.icon, lineupPlayer.icon) && i.b(this.number, lineupPlayer.number);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNumber() {
        return this.number;
    }

    public final int getPlayerId() {
        return this.playerId;
    }

    public int hashCode() {
        int hashCode = ((this.playerId * 31) + this.name.hashCode()) * 31;
        String str = this.icon;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.number.hashCode();
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public final void setNumber(String str) {
        i.g(str, "<set-?>");
        this.number = str;
    }

    public final void setPlayerId(int i10) {
        this.playerId = i10;
    }

    public String toString() {
        return "LineupPlayer(playerId=" + this.playerId + ", name=" + this.name + ", icon=" + this.icon + ", number=" + this.number + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
