package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetEmailSuffixResult {
    private GetEmailSuffix data;
    private String errorMessage;
    private String returnCode;

    public GetEmailSuffixResult(String str, String str2, GetEmailSuffix getEmailSuffix) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = getEmailSuffix;
    }

    public static /* synthetic */ GetEmailSuffixResult copy$default(GetEmailSuffixResult getEmailSuffixResult, String str, String str2, GetEmailSuffix getEmailSuffix, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getEmailSuffixResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getEmailSuffixResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            getEmailSuffix = getEmailSuffixResult.data;
        }
        return getEmailSuffixResult.copy(str, str2, getEmailSuffix);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final GetEmailSuffix component3() {
        return this.data;
    }

    public final GetEmailSuffixResult copy(String str, String str2, GetEmailSuffix getEmailSuffix) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        return new GetEmailSuffixResult(str, str2, getEmailSuffix);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetEmailSuffixResult)) {
            return false;
        }
        GetEmailSuffixResult getEmailSuffixResult = (GetEmailSuffixResult) obj;
        return i.b(this.returnCode, getEmailSuffixResult.returnCode) && i.b(this.errorMessage, getEmailSuffixResult.errorMessage) && i.b(this.data, getEmailSuffixResult.data);
    }

    public final GetEmailSuffix getData() {
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
        GetEmailSuffix getEmailSuffix = this.data;
        return hashCode + (getEmailSuffix == null ? 0 : getEmailSuffix.hashCode());
    }

    public final void setData(GetEmailSuffix getEmailSuffix) {
        this.data = getEmailSuffix;
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
        return "GetEmailSuffixResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
