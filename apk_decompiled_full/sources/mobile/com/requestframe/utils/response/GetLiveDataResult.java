package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class GetLiveDataResult implements Serializable {
    private GetLiveData data;
    private String errorMessage;
    private String returnCode;

    public GetLiveDataResult(String str, String str2, GetLiveData getLiveData) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = getLiveData;
    }

    public static /* synthetic */ GetLiveDataResult copy$default(GetLiveDataResult getLiveDataResult, String str, String str2, GetLiveData getLiveData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getLiveDataResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getLiveDataResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            getLiveData = getLiveDataResult.data;
        }
        return getLiveDataResult.copy(str, str2, getLiveData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final GetLiveData component3() {
        return this.data;
    }

    public final GetLiveDataResult copy(String str, String str2, GetLiveData getLiveData) {
        return new GetLiveDataResult(str, str2, getLiveData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetLiveDataResult)) {
            return false;
        }
        GetLiveDataResult getLiveDataResult = (GetLiveDataResult) obj;
        return i.b(this.returnCode, getLiveDataResult.returnCode) && i.b(this.errorMessage, getLiveDataResult.errorMessage) && i.b(this.data, getLiveDataResult.data);
    }

    public final GetLiveData getData() {
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
        GetLiveData getLiveData = this.data;
        return hashCode2 + (getLiveData != null ? getLiveData.hashCode() : 0);
    }

    public final void setData(GetLiveData getLiveData) {
        this.data = getLiveData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "GetLiveDataResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
