package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class GetSlbInfoBeanResult implements Serializable {
    private GetSlbInfoBeanResultData data;
    private String errorMessage;
    private String returnCode;

    public GetSlbInfoBeanResult(String str, String str2, GetSlbInfoBeanResultData getSlbInfoBeanResultData) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = getSlbInfoBeanResultData;
    }

    public static /* synthetic */ GetSlbInfoBeanResult copy$default(GetSlbInfoBeanResult getSlbInfoBeanResult, String str, String str2, GetSlbInfoBeanResultData getSlbInfoBeanResultData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getSlbInfoBeanResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getSlbInfoBeanResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            getSlbInfoBeanResultData = getSlbInfoBeanResult.data;
        }
        return getSlbInfoBeanResult.copy(str, str2, getSlbInfoBeanResultData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final GetSlbInfoBeanResultData component3() {
        return this.data;
    }

    public final GetSlbInfoBeanResult copy(String str, String str2, GetSlbInfoBeanResultData getSlbInfoBeanResultData) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        return new GetSlbInfoBeanResult(str, str2, getSlbInfoBeanResultData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetSlbInfoBeanResult)) {
            return false;
        }
        GetSlbInfoBeanResult getSlbInfoBeanResult = (GetSlbInfoBeanResult) obj;
        return i.b(this.returnCode, getSlbInfoBeanResult.returnCode) && i.b(this.errorMessage, getSlbInfoBeanResult.errorMessage) && i.b(this.data, getSlbInfoBeanResult.data);
    }

    public final GetSlbInfoBeanResultData getData() {
        return this.data;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        int hashCode = ((this.returnCode.hashCode() * 31) + this.errorMessage.hashCode()) * 31;
        GetSlbInfoBeanResultData getSlbInfoBeanResultData = this.data;
        return hashCode + (getSlbInfoBeanResultData == null ? 0 : getSlbInfoBeanResultData.hashCode());
    }

    public final void setData(GetSlbInfoBeanResultData getSlbInfoBeanResultData) {
        this.data = getSlbInfoBeanResultData;
    }

    public final void setErrorMessage(String str) {
        i.g(str, "<set-?>");
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        i.g(str, "<set-?>");
        this.returnCode = str;
    }

    public String toString() {
        return "GetSlbInfoBeanResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
