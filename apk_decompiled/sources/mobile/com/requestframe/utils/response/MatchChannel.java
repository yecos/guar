package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class MatchChannel implements Serializable {
    private String channelCode;
    private String channelName;
    private String country;
    private String epgName;
    private String teamNameA;
    private String teamNameB;

    public MatchChannel(String str, String str2, String str3, String str4) {
        i.g(str2, "channelName");
        this.channelCode = str;
        this.channelName = str2;
        this.epgName = str3;
        this.country = str4;
        this.teamNameA = "";
        this.teamNameB = "";
    }

    public static /* synthetic */ MatchChannel copy$default(MatchChannel matchChannel, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = matchChannel.channelCode;
        }
        if ((i10 & 2) != 0) {
            str2 = matchChannel.channelName;
        }
        if ((i10 & 4) != 0) {
            str3 = matchChannel.epgName;
        }
        if ((i10 & 8) != 0) {
            str4 = matchChannel.country;
        }
        return matchChannel.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.channelCode;
    }

    public final String component2() {
        return this.channelName;
    }

    public final String component3() {
        return this.epgName;
    }

    public final String component4() {
        return this.country;
    }

    public final MatchChannel copy(String str, String str2, String str3, String str4) {
        i.g(str2, "channelName");
        return new MatchChannel(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchChannel)) {
            return false;
        }
        MatchChannel matchChannel = (MatchChannel) obj;
        return i.b(this.channelCode, matchChannel.channelCode) && i.b(this.channelName, matchChannel.channelName) && i.b(this.epgName, matchChannel.epgName) && i.b(this.country, matchChannel.country);
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getEpgName() {
        return this.epgName;
    }

    public final String getTeamNameA() {
        return this.teamNameA;
    }

    public final String getTeamNameB() {
        return this.teamNameB;
    }

    public int hashCode() {
        String str = this.channelCode;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.channelName.hashCode()) * 31;
        String str2 = this.epgName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.country;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setChannelCode(String str) {
        this.channelCode = str;
    }

    public final void setChannelName(String str) {
        i.g(str, "<set-?>");
        this.channelName = str;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final void setEpgName(String str) {
        this.epgName = str;
    }

    public final void setTeamNameA(String str) {
        i.g(str, "<set-?>");
        this.teamNameA = str;
    }

    public final void setTeamNameB(String str) {
        i.g(str, "<set-?>");
        this.teamNameB = str;
    }

    public String toString() {
        return "MatchChannel(channelCode=" + this.channelCode + ", channelName=" + this.channelName + ", epgName=" + this.epgName + ", country=" + this.country + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
