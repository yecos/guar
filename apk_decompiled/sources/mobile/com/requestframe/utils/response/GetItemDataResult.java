package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetItemDataResult {
    private GetItemDataResultData data;
    private String errorMessage;
    private String returnCode;

    public GetItemDataResult(String str, String str2, GetItemDataResultData getItemDataResultData) {
        i.g(str, "returnCode");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = getItemDataResultData;
    }

    public static /* synthetic */ GetItemDataResult copy$default(GetItemDataResult getItemDataResult, String str, String str2, GetItemDataResultData getItemDataResultData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getItemDataResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getItemDataResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            getItemDataResultData = getItemDataResult.data;
        }
        return getItemDataResult.copy(str, str2, getItemDataResultData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final GetItemDataResultData component3() {
        return this.data;
    }

    public final GetItemDataResult copy(String str, String str2, GetItemDataResultData getItemDataResultData) {
        i.g(str, "returnCode");
        return new GetItemDataResult(str, str2, getItemDataResultData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetItemDataResult)) {
            return false;
        }
        GetItemDataResult getItemDataResult = (GetItemDataResult) obj;
        return i.b(this.returnCode, getItemDataResult.returnCode) && i.b(this.errorMessage, getItemDataResult.errorMessage) && i.b(this.data, getItemDataResult.data);
    }

    public final GetItemDataResultData getData() {
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
        GetItemDataResultData getItemDataResultData = this.data;
        return hashCode2 + (getItemDataResultData != null ? getItemDataResultData.hashCode() : 0);
    }

    public final void setData(GetItemDataResultData getItemDataResultData) {
        this.data = getItemDataResultData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        i.g(str, "<set-?>");
        this.returnCode = str;
    }

    public String toString() {
        return "GetItemDataResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
