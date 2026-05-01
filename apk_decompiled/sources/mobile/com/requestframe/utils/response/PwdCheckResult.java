package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class PwdCheckResult {
    private String errorMessage;
    private String returnCode;

    public PwdCheckResult(String str, String str2) {
        this.returnCode = str;
        this.errorMessage = str2;
    }

    public static /* synthetic */ PwdCheckResult copy$default(PwdCheckResult pwdCheckResult, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = pwdCheckResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = pwdCheckResult.errorMessage;
        }
        return pwdCheckResult.copy(str, str2);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final PwdCheckResult copy(String str, String str2) {
        return new PwdCheckResult(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PwdCheckResult)) {
            return false;
        }
        PwdCheckResult pwdCheckResult = (PwdCheckResult) obj;
        return i.b(this.returnCode, pwdCheckResult.returnCode) && i.b(this.errorMessage, pwdCheckResult.errorMessage);
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
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "PwdCheckResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
