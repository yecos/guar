package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class MsgBoxResult {
    private MsgData data;
    private String errorMessage;
    private String returnCode;

    public MsgBoxResult(String str, String str2, MsgData msgData) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = msgData;
    }

    public static /* synthetic */ MsgBoxResult copy$default(MsgBoxResult msgBoxResult, String str, String str2, MsgData msgData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = msgBoxResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = msgBoxResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            msgData = msgBoxResult.data;
        }
        return msgBoxResult.copy(str, str2, msgData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final MsgData component3() {
        return this.data;
    }

    public final MsgBoxResult copy(String str, String str2, MsgData msgData) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        return new MsgBoxResult(str, str2, msgData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MsgBoxResult)) {
            return false;
        }
        MsgBoxResult msgBoxResult = (MsgBoxResult) obj;
        return i.b(this.returnCode, msgBoxResult.returnCode) && i.b(this.errorMessage, msgBoxResult.errorMessage) && i.b(this.data, msgBoxResult.data);
    }

    public final MsgData getData() {
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
        MsgData msgData = this.data;
        return hashCode + (msgData == null ? 0 : msgData.hashCode());
    }

    public final void setData(MsgData msgData) {
        this.data = msgData;
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
        return "MsgBoxResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
