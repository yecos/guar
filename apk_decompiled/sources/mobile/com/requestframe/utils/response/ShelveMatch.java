package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ShelveMatch {
    private String isLocal;
    private boolean isSelected;
    private String logo;
    private String matchAliasName;
    private String matchId;
    private String matchName;

    public ShelveMatch(String str, String str2, String str3, String str4, String str5) {
        i.g(str2, "matchId");
        this.matchName = str;
        this.matchId = str2;
        this.logo = str3;
        this.matchAliasName = str4;
        this.isLocal = str5;
    }

    public static /* synthetic */ ShelveMatch copy$default(ShelveMatch shelveMatch, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = shelveMatch.matchName;
        }
        if ((i10 & 2) != 0) {
            str2 = shelveMatch.matchId;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = shelveMatch.logo;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = shelveMatch.matchAliasName;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = shelveMatch.isLocal;
        }
        return shelveMatch.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.matchName;
    }

    public final String component2() {
        return this.matchId;
    }

    public final String component3() {
        return this.logo;
    }

    public final String component4() {
        return this.matchAliasName;
    }

    public final String component5() {
        return this.isLocal;
    }

    public final ShelveMatch copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str2, "matchId");
        return new ShelveMatch(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShelveMatch)) {
            return false;
        }
        ShelveMatch shelveMatch = (ShelveMatch) obj;
        return i.b(this.matchName, shelveMatch.matchName) && i.b(this.matchId, shelveMatch.matchId) && i.b(this.logo, shelveMatch.logo) && i.b(this.matchAliasName, shelveMatch.matchAliasName) && i.b(this.isLocal, shelveMatch.isLocal);
    }

    public final String getLogo() {
        return this.logo;
    }

    public final String getMatchAliasName() {
        return this.matchAliasName;
    }

    public final String getMatchId() {
        return this.matchId;
    }

    public final String getMatchName() {
        return this.matchName;
    }

    public int hashCode() {
        String str = this.matchName;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.matchId.hashCode()) * 31;
        String str2 = this.logo;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.matchAliasName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.isLocal;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String isLocal() {
        return this.isLocal;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setLocal(String str) {
        this.isLocal = str;
    }

    public final void setLogo(String str) {
        this.logo = str;
    }

    public final void setMatchAliasName(String str) {
        this.matchAliasName = str;
    }

    public final void setMatchId(String str) {
        i.g(str, "<set-?>");
        this.matchId = str;
    }

    public final void setMatchName(String str) {
        this.matchName = str;
    }

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    public String toString() {
        return "ShelveMatch(matchName=" + this.matchName + ", matchId=" + this.matchId + ", logo=" + this.logo + ", matchAliasName=" + this.matchAliasName + ", isLocal=" + this.isLocal + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
