package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class SnTokenResult {
    private SnTokenData data;
    private String errorMessage;
    private String returnCode;

    public SnTokenResult(String str, String str2, SnTokenData snTokenData) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = snTokenData;
    }

    public static /* synthetic */ SnTokenResult copy$default(SnTokenResult snTokenResult, String str, String str2, SnTokenData snTokenData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = snTokenResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = snTokenResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            snTokenData = snTokenResult.data;
        }
        return snTokenResult.copy(str, str2, snTokenData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final SnTokenData component3() {
        return this.data;
    }

    public final SnTokenResult copy(String str, String str2, SnTokenData snTokenData) {
        return new SnTokenResult(str, str2, snTokenData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SnTokenResult)) {
            return false;
        }
        SnTokenResult snTokenResult = (SnTokenResult) obj;
        return i.b(this.returnCode, snTokenResult.returnCode) && i.b(this.errorMessage, snTokenResult.errorMessage) && i.b(this.data, snTokenResult.data);
    }

    public final SnTokenData getData() {
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
        SnTokenData snTokenData = this.data;
        return hashCode2 + (snTokenData != null ? snTokenData.hashCode() : 0);
    }

    public final void setData(SnTokenData snTokenData) {
        this.data = snTokenData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "SnTokenResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
