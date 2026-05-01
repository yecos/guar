package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class UpdateRestrictResult {
    private String errorMessage;
    private String returnCode;

    public UpdateRestrictResult(String str, String str2) {
        this.returnCode = str;
        this.errorMessage = str2;
    }

    public static /* synthetic */ UpdateRestrictResult copy$default(UpdateRestrictResult updateRestrictResult, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = updateRestrictResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = updateRestrictResult.errorMessage;
        }
        return updateRestrictResult.copy(str, str2);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final UpdateRestrictResult copy(String str, String str2) {
        return new UpdateRestrictResult(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateRestrictResult)) {
            return false;
        }
        UpdateRestrictResult updateRestrictResult = (UpdateRestrictResult) obj;
        return i.b(this.returnCode, updateRestrictResult.returnCode) && i.b(this.errorMessage, updateRestrictResult.errorMessage);
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
        return "UpdateRestrictResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
