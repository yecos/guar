package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetProgramResult {
    private GetProgramData data;
    private String errorMessage;
    private String returnCode;

    public GetProgramResult(String str, String str2, GetProgramData getProgramData) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = getProgramData;
    }

    public static /* synthetic */ GetProgramResult copy$default(GetProgramResult getProgramResult, String str, String str2, GetProgramData getProgramData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getProgramResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getProgramResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            getProgramData = getProgramResult.data;
        }
        return getProgramResult.copy(str, str2, getProgramData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final GetProgramData component3() {
        return this.data;
    }

    public final GetProgramResult copy(String str, String str2, GetProgramData getProgramData) {
        return new GetProgramResult(str, str2, getProgramData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetProgramResult)) {
            return false;
        }
        GetProgramResult getProgramResult = (GetProgramResult) obj;
        return i.b(this.returnCode, getProgramResult.returnCode) && i.b(this.errorMessage, getProgramResult.errorMessage) && i.b(this.data, getProgramResult.data);
    }

    public final GetProgramData getData() {
        return this.data;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        String str = this.returnCode;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.errorMessage;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        GetProgramData getProgramData = this.data;
        return hashCode2 + (getProgramData != null ? getProgramData.hashCode() : 0);
    }

    public final void setData(GetProgramData getProgramData) {
        this.data = getProgramData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "GetProgramResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
