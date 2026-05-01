package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class FreeResult {
    private FreeDataBean data;
    private String errorMessage;
    private String returnCode;

    public FreeResult(String str, String str2, FreeDataBean freeDataBean) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = freeDataBean;
    }

    public static /* synthetic */ FreeResult copy$default(FreeResult freeResult, String str, String str2, FreeDataBean freeDataBean, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = freeResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = freeResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            freeDataBean = freeResult.data;
        }
        return freeResult.copy(str, str2, freeDataBean);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final FreeDataBean component3() {
        return this.data;
    }

    public final FreeResult copy(String str, String str2, FreeDataBean freeDataBean) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        return new FreeResult(str, str2, freeDataBean);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FreeResult)) {
            return false;
        }
        FreeResult freeResult = (FreeResult) obj;
        return i.b(this.returnCode, freeResult.returnCode) && i.b(this.errorMessage, freeResult.errorMessage) && i.b(this.data, freeResult.data);
    }

    public final FreeDataBean getData() {
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
        FreeDataBean freeDataBean = this.data;
        return hashCode + (freeDataBean == null ? 0 : freeDataBean.hashCode());
    }

    public final void setData(FreeDataBean freeDataBean) {
        this.data = freeDataBean;
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
        return "FreeResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
