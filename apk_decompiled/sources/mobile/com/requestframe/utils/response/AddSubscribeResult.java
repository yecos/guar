package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class AddSubscribeResult implements Serializable {
    private AddSubscribe data;
    private String errorMessage;
    private String returnCode;

    public AddSubscribeResult(String str, String str2, AddSubscribe addSubscribe) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        i.g(addSubscribe, "data");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = addSubscribe;
    }

    public static /* synthetic */ AddSubscribeResult copy$default(AddSubscribeResult addSubscribeResult, String str, String str2, AddSubscribe addSubscribe, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = addSubscribeResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = addSubscribeResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            addSubscribe = addSubscribeResult.data;
        }
        return addSubscribeResult.copy(str, str2, addSubscribe);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final AddSubscribe component3() {
        return this.data;
    }

    public final AddSubscribeResult copy(String str, String str2, AddSubscribe addSubscribe) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        i.g(addSubscribe, "data");
        return new AddSubscribeResult(str, str2, addSubscribe);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddSubscribeResult)) {
            return false;
        }
        AddSubscribeResult addSubscribeResult = (AddSubscribeResult) obj;
        return i.b(this.returnCode, addSubscribeResult.returnCode) && i.b(this.errorMessage, addSubscribeResult.errorMessage) && i.b(this.data, addSubscribeResult.data);
    }

    public final AddSubscribe getData() {
        return this.data;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        return (((this.returnCode.hashCode() * 31) + this.errorMessage.hashCode()) * 31) + this.data.hashCode();
    }

    public final void setData(AddSubscribe addSubscribe) {
        i.g(addSubscribe, "<set-?>");
        this.data = addSubscribe;
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
        return "AddSubscribeResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
