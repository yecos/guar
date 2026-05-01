package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class QrLoginAuthResult implements Serializable {
    private QrLoginAuthResultData data;
    private String errorMessage;
    private String returnCode;

    public QrLoginAuthResult(String str, String str2, QrLoginAuthResultData qrLoginAuthResultData) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = qrLoginAuthResultData;
    }

    public static /* synthetic */ QrLoginAuthResult copy$default(QrLoginAuthResult qrLoginAuthResult, String str, String str2, QrLoginAuthResultData qrLoginAuthResultData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = qrLoginAuthResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = qrLoginAuthResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            qrLoginAuthResultData = qrLoginAuthResult.data;
        }
        return qrLoginAuthResult.copy(str, str2, qrLoginAuthResultData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final QrLoginAuthResultData component3() {
        return this.data;
    }

    public final QrLoginAuthResult copy(String str, String str2, QrLoginAuthResultData qrLoginAuthResultData) {
        return new QrLoginAuthResult(str, str2, qrLoginAuthResultData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QrLoginAuthResult)) {
            return false;
        }
        QrLoginAuthResult qrLoginAuthResult = (QrLoginAuthResult) obj;
        return i.b(this.returnCode, qrLoginAuthResult.returnCode) && i.b(this.errorMessage, qrLoginAuthResult.errorMessage) && i.b(this.data, qrLoginAuthResult.data);
    }

    public final QrLoginAuthResultData getData() {
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
        QrLoginAuthResultData qrLoginAuthResultData = this.data;
        return hashCode2 + (qrLoginAuthResultData != null ? qrLoginAuthResultData.hashCode() : 0);
    }

    public final void setData(QrLoginAuthResultData qrLoginAuthResultData) {
        this.data = qrLoginAuthResultData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "QrLoginAuthResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
