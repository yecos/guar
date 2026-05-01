package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class GetAuthInfoResult implements Serializable {
    private GetAuthInfoData data;
    private String errorMessage;
    private String returnCode;

    public GetAuthInfoResult(String str, String str2, GetAuthInfoData getAuthInfoData) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = getAuthInfoData;
    }

    public static /* synthetic */ GetAuthInfoResult copy$default(GetAuthInfoResult getAuthInfoResult, String str, String str2, GetAuthInfoData getAuthInfoData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getAuthInfoResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getAuthInfoResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            getAuthInfoData = getAuthInfoResult.data;
        }
        return getAuthInfoResult.copy(str, str2, getAuthInfoData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final GetAuthInfoData component3() {
        return this.data;
    }

    public final GetAuthInfoResult copy(String str, String str2, GetAuthInfoData getAuthInfoData) {
        return new GetAuthInfoResult(str, str2, getAuthInfoData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAuthInfoResult)) {
            return false;
        }
        GetAuthInfoResult getAuthInfoResult = (GetAuthInfoResult) obj;
        return i.b(this.returnCode, getAuthInfoResult.returnCode) && i.b(this.errorMessage, getAuthInfoResult.errorMessage) && i.b(this.data, getAuthInfoResult.data);
    }

    public final GetAuthInfoData getData() {
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
        GetAuthInfoData getAuthInfoData = this.data;
        return hashCode2 + (getAuthInfoData != null ? getAuthInfoData.hashCode() : 0);
    }

    public final void setData(GetAuthInfoData getAuthInfoData) {
        this.data = getAuthInfoData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "GetAuthInfoResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
