package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class MatchEventResult {
    private MatchEventData data;
    private String errorMessage;
    private String returnCode;

    public MatchEventResult(String str, String str2, MatchEventData matchEventData) {
        i.g(str, "returnCode");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = matchEventData;
    }

    public static /* synthetic */ MatchEventResult copy$default(MatchEventResult matchEventResult, String str, String str2, MatchEventData matchEventData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = matchEventResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = matchEventResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            matchEventData = matchEventResult.data;
        }
        return matchEventResult.copy(str, str2, matchEventData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final MatchEventData component3() {
        return this.data;
    }

    public final MatchEventResult copy(String str, String str2, MatchEventData matchEventData) {
        i.g(str, "returnCode");
        return new MatchEventResult(str, str2, matchEventData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchEventResult)) {
            return false;
        }
        MatchEventResult matchEventResult = (MatchEventResult) obj;
        return i.b(this.returnCode, matchEventResult.returnCode) && i.b(this.errorMessage, matchEventResult.errorMessage) && i.b(this.data, matchEventResult.data);
    }

    public final MatchEventData getData() {
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
        MatchEventData matchEventData = this.data;
        return hashCode2 + (matchEventData != null ? matchEventData.hashCode() : 0);
    }

    public final void setData(MatchEventData matchEventData) {
        this.data = matchEventData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        i.g(str, "<set-?>");
        this.returnCode = str;
    }

    public String toString() {
        return "MatchEventResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
