package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class GetHomeResult implements Serializable {
    private GetHomeData data;
    private String errorMessage;
    private String returnCode;

    public GetHomeResult(String str, String str2, GetHomeData getHomeData) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = getHomeData;
    }

    public static /* synthetic */ GetHomeResult copy$default(GetHomeResult getHomeResult, String str, String str2, GetHomeData getHomeData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getHomeResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getHomeResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            getHomeData = getHomeResult.data;
        }
        return getHomeResult.copy(str, str2, getHomeData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final GetHomeData component3() {
        return this.data;
    }

    public final GetHomeResult copy(String str, String str2, GetHomeData getHomeData) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        return new GetHomeResult(str, str2, getHomeData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetHomeResult)) {
            return false;
        }
        GetHomeResult getHomeResult = (GetHomeResult) obj;
        return i.b(this.returnCode, getHomeResult.returnCode) && i.b(this.errorMessage, getHomeResult.errorMessage) && i.b(this.data, getHomeResult.data);
    }

    public final GetHomeData getData() {
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
        GetHomeData getHomeData = this.data;
        return hashCode + (getHomeData == null ? 0 : getHomeData.hashCode());
    }

    public final void setData(GetHomeData getHomeData) {
        this.data = getHomeData;
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
        return "GetHomeResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
