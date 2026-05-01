package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class DelSubscribeResult {
    private String errorMessage;
    private String returnCode;

    public DelSubscribeResult(String str, String str2) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        this.returnCode = str;
        this.errorMessage = str2;
    }

    public static /* synthetic */ DelSubscribeResult copy$default(DelSubscribeResult delSubscribeResult, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = delSubscribeResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = delSubscribeResult.errorMessage;
        }
        return delSubscribeResult.copy(str, str2);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final DelSubscribeResult copy(String str, String str2) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        return new DelSubscribeResult(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DelSubscribeResult)) {
            return false;
        }
        DelSubscribeResult delSubscribeResult = (DelSubscribeResult) obj;
        return i.b(this.returnCode, delSubscribeResult.returnCode) && i.b(this.errorMessage, delSubscribeResult.errorMessage);
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        return (this.returnCode.hashCode() * 31) + this.errorMessage.hashCode();
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
        return "DelSubscribeResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
