package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ShelveMatchResult {
    private ShelveMatchList data;
    private String errorMessage;
    private String returnCode;

    public ShelveMatchResult(String str, String str2, ShelveMatchList shelveMatchList) {
        i.g(str, "returnCode");
        i.g(shelveMatchList, "data");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = shelveMatchList;
    }

    public static /* synthetic */ ShelveMatchResult copy$default(ShelveMatchResult shelveMatchResult, String str, String str2, ShelveMatchList shelveMatchList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = shelveMatchResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = shelveMatchResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            shelveMatchList = shelveMatchResult.data;
        }
        return shelveMatchResult.copy(str, str2, shelveMatchList);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final ShelveMatchList component3() {
        return this.data;
    }

    public final ShelveMatchResult copy(String str, String str2, ShelveMatchList shelveMatchList) {
        i.g(str, "returnCode");
        i.g(shelveMatchList, "data");
        return new ShelveMatchResult(str, str2, shelveMatchList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShelveMatchResult)) {
            return false;
        }
        ShelveMatchResult shelveMatchResult = (ShelveMatchResult) obj;
        return i.b(this.returnCode, shelveMatchResult.returnCode) && i.b(this.errorMessage, shelveMatchResult.errorMessage) && i.b(this.data, shelveMatchResult.data);
    }

    public final ShelveMatchList getData() {
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
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.data.hashCode();
    }

    public final void setData(ShelveMatchList shelveMatchList) {
        i.g(shelveMatchList, "<set-?>");
        this.data = shelveMatchList;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        i.g(str, "<set-?>");
        this.returnCode = str;
    }

    public String toString() {
        return "ShelveMatchResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
