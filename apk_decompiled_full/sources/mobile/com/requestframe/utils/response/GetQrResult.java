package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetQrResult {
    private GetQrData data;
    private String errorMessage;
    private String returnCode;

    public GetQrResult(String str, String str2, GetQrData getQrData) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = getQrData;
    }

    public static /* synthetic */ GetQrResult copy$default(GetQrResult getQrResult, String str, String str2, GetQrData getQrData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getQrResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getQrResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            getQrData = getQrResult.data;
        }
        return getQrResult.copy(str, str2, getQrData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final GetQrData component3() {
        return this.data;
    }

    public final GetQrResult copy(String str, String str2, GetQrData getQrData) {
        return new GetQrResult(str, str2, getQrData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetQrResult)) {
            return false;
        }
        GetQrResult getQrResult = (GetQrResult) obj;
        return i.b(this.returnCode, getQrResult.returnCode) && i.b(this.errorMessage, getQrResult.errorMessage) && i.b(this.data, getQrResult.data);
    }

    public final GetQrData getData() {
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
        GetQrData getQrData = this.data;
        return hashCode2 + (getQrData != null ? getQrData.hashCode() : 0);
    }

    public final void setData(GetQrData getQrData) {
        this.data = getQrData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "GetQrResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
