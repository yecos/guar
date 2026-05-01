package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class MsgNumResult {
    private MsgNumData data;
    private String errorMessage;
    private String returnCode;

    public MsgNumResult(String str, String str2, MsgNumData msgNumData) {
        i.g(str, "errorMessage");
        i.g(str2, "returnCode");
        this.errorMessage = str;
        this.returnCode = str2;
        this.data = msgNumData;
    }

    public static /* synthetic */ MsgNumResult copy$default(MsgNumResult msgNumResult, String str, String str2, MsgNumData msgNumData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = msgNumResult.errorMessage;
        }
        if ((i10 & 2) != 0) {
            str2 = msgNumResult.returnCode;
        }
        if ((i10 & 4) != 0) {
            msgNumData = msgNumResult.data;
        }
        return msgNumResult.copy(str, str2, msgNumData);
    }

    public final String component1() {
        return this.errorMessage;
    }

    public final String component2() {
        return this.returnCode;
    }

    public final MsgNumData component3() {
        return this.data;
    }

    public final MsgNumResult copy(String str, String str2, MsgNumData msgNumData) {
        i.g(str, "errorMessage");
        i.g(str2, "returnCode");
        return new MsgNumResult(str, str2, msgNumData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MsgNumResult)) {
            return false;
        }
        MsgNumResult msgNumResult = (MsgNumResult) obj;
        return i.b(this.errorMessage, msgNumResult.errorMessage) && i.b(this.returnCode, msgNumResult.returnCode) && i.b(this.data, msgNumResult.data);
    }

    public final MsgNumData getData() {
        return this.data;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        int hashCode = ((this.errorMessage.hashCode() * 31) + this.returnCode.hashCode()) * 31;
        MsgNumData msgNumData = this.data;
        return hashCode + (msgNumData == null ? 0 : msgNumData.hashCode());
    }

    public final void setData(MsgNumData msgNumData) {
        this.data = msgNumData;
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
        return "MsgNumResult(errorMessage=" + this.errorMessage + ", returnCode=" + this.returnCode + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
