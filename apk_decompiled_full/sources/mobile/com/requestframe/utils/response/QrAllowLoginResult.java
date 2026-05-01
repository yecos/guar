package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class QrAllowLoginResult {
    private String errorMessage;
    private String returnCode;

    public QrAllowLoginResult(String str, String str2) {
        this.returnCode = str;
        this.errorMessage = str2;
    }

    public static /* synthetic */ QrAllowLoginResult copy$default(QrAllowLoginResult qrAllowLoginResult, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = qrAllowLoginResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = qrAllowLoginResult.errorMessage;
        }
        return qrAllowLoginResult.copy(str, str2);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final QrAllowLoginResult copy(String str, String str2) {
        return new QrAllowLoginResult(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QrAllowLoginResult)) {
            return false;
        }
        QrAllowLoginResult qrAllowLoginResult = (QrAllowLoginResult) obj;
        return i.b(this.returnCode, qrAllowLoginResult.returnCode) && i.b(this.errorMessage, qrAllowLoginResult.errorMessage);
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
        return "QrAllowLoginResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
