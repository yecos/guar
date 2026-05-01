package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class BindThirdPartResult {
    private BindThirdPart data;
    private String errorMessage;
    private String returnCode;

    public BindThirdPartResult(String str, String str2, BindThirdPart bindThirdPart) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = bindThirdPart;
    }

    public static /* synthetic */ BindThirdPartResult copy$default(BindThirdPartResult bindThirdPartResult, String str, String str2, BindThirdPart bindThirdPart, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = bindThirdPartResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = bindThirdPartResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            bindThirdPart = bindThirdPartResult.data;
        }
        return bindThirdPartResult.copy(str, str2, bindThirdPart);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final BindThirdPart component3() {
        return this.data;
    }

    public final BindThirdPartResult copy(String str, String str2, BindThirdPart bindThirdPart) {
        return new BindThirdPartResult(str, str2, bindThirdPart);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BindThirdPartResult)) {
            return false;
        }
        BindThirdPartResult bindThirdPartResult = (BindThirdPartResult) obj;
        return i.b(this.returnCode, bindThirdPartResult.returnCode) && i.b(this.errorMessage, bindThirdPartResult.errorMessage) && i.b(this.data, bindThirdPartResult.data);
    }

    public final BindThirdPart getData() {
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
        BindThirdPart bindThirdPart = this.data;
        return hashCode2 + (bindThirdPart != null ? bindThirdPart.hashCode() : 0);
    }

    public final void setData(BindThirdPart bindThirdPart) {
        this.data = bindThirdPart;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "BindThirdPartResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
