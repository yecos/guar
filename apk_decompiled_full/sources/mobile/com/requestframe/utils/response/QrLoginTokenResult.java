package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class QrLoginTokenResult implements Serializable {
    private QrTokenData data;
    private String errorMessage;
    private String returnCode;

    public QrLoginTokenResult(String str, String str2, QrTokenData qrTokenData) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = qrTokenData;
    }

    public static /* synthetic */ QrLoginTokenResult copy$default(QrLoginTokenResult qrLoginTokenResult, String str, String str2, QrTokenData qrTokenData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = qrLoginTokenResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = qrLoginTokenResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            qrTokenData = qrLoginTokenResult.data;
        }
        return qrLoginTokenResult.copy(str, str2, qrTokenData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final QrTokenData component3() {
        return this.data;
    }

    public final QrLoginTokenResult copy(String str, String str2, QrTokenData qrTokenData) {
        return new QrLoginTokenResult(str, str2, qrTokenData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QrLoginTokenResult)) {
            return false;
        }
        QrLoginTokenResult qrLoginTokenResult = (QrLoginTokenResult) obj;
        return i.b(this.returnCode, qrLoginTokenResult.returnCode) && i.b(this.errorMessage, qrLoginTokenResult.errorMessage) && i.b(this.data, qrLoginTokenResult.data);
    }

    public final QrTokenData getData() {
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
        QrTokenData qrTokenData = this.data;
        return hashCode2 + (qrTokenData != null ? qrTokenData.hashCode() : 0);
    }

    public final void setData(QrTokenData qrTokenData) {
        this.data = qrTokenData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "QrLoginTokenResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
