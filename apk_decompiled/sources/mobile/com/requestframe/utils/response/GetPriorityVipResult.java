package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetPriorityVipResult {
    private ResultFlag data;
    private String errorMessage;
    private String returnCode;

    public GetPriorityVipResult(String str, String str2, ResultFlag resultFlag) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = resultFlag;
    }

    public static /* synthetic */ GetPriorityVipResult copy$default(GetPriorityVipResult getPriorityVipResult, String str, String str2, ResultFlag resultFlag, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getPriorityVipResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getPriorityVipResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            resultFlag = getPriorityVipResult.data;
        }
        return getPriorityVipResult.copy(str, str2, resultFlag);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final ResultFlag component3() {
        return this.data;
    }

    public final GetPriorityVipResult copy(String str, String str2, ResultFlag resultFlag) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        return new GetPriorityVipResult(str, str2, resultFlag);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetPriorityVipResult)) {
            return false;
        }
        GetPriorityVipResult getPriorityVipResult = (GetPriorityVipResult) obj;
        return i.b(this.returnCode, getPriorityVipResult.returnCode) && i.b(this.errorMessage, getPriorityVipResult.errorMessage) && i.b(this.data, getPriorityVipResult.data);
    }

    public final ResultFlag getData() {
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
        ResultFlag resultFlag = this.data;
        return hashCode + (resultFlag == null ? 0 : resultFlag.hashCode());
    }

    public final void setData(ResultFlag resultFlag) {
        this.data = resultFlag;
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
        return "GetPriorityVipResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
