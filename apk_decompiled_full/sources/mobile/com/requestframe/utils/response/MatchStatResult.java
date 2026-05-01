package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class MatchStatResult {
    private MatchStatData data;
    private String errorMessage;
    private String returnCode;

    public MatchStatResult(String str, String str2, MatchStatData matchStatData) {
        i.g(str, "returnCode");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = matchStatData;
    }

    public static /* synthetic */ MatchStatResult copy$default(MatchStatResult matchStatResult, String str, String str2, MatchStatData matchStatData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = matchStatResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = matchStatResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            matchStatData = matchStatResult.data;
        }
        return matchStatResult.copy(str, str2, matchStatData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final MatchStatData component3() {
        return this.data;
    }

    public final MatchStatResult copy(String str, String str2, MatchStatData matchStatData) {
        i.g(str, "returnCode");
        return new MatchStatResult(str, str2, matchStatData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchStatResult)) {
            return false;
        }
        MatchStatResult matchStatResult = (MatchStatResult) obj;
        return i.b(this.returnCode, matchStatResult.returnCode) && i.b(this.errorMessage, matchStatResult.errorMessage) && i.b(this.data, matchStatResult.data);
    }

    public final MatchStatData getData() {
        return this.data;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        int hashCode = this.returnCode.hashCode() * 31;
        String str = this.errorMessage;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        MatchStatData matchStatData = this.data;
        return hashCode2 + (matchStatData != null ? matchStatData.hashCode() : 0);
    }

    public final void setData(MatchStatData matchStatData) {
        this.data = matchStatData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        i.g(str, "<set-?>");
        this.returnCode = str;
    }

    public String toString() {
        return "MatchStatResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
