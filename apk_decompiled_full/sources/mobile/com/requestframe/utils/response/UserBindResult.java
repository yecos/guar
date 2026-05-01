package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class UserBindResult {
    private UserBindData data;
    private String errorMessage;
    private String returnCode;

    public UserBindResult(String str, String str2, UserBindData userBindData) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = userBindData;
    }

    public static /* synthetic */ UserBindResult copy$default(UserBindResult userBindResult, String str, String str2, UserBindData userBindData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = userBindResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = userBindResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            userBindData = userBindResult.data;
        }
        return userBindResult.copy(str, str2, userBindData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final UserBindData component3() {
        return this.data;
    }

    public final UserBindResult copy(String str, String str2, UserBindData userBindData) {
        return new UserBindResult(str, str2, userBindData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserBindResult)) {
            return false;
        }
        UserBindResult userBindResult = (UserBindResult) obj;
        return i.b(this.returnCode, userBindResult.returnCode) && i.b(this.errorMessage, userBindResult.errorMessage) && i.b(this.data, userBindResult.data);
    }

    public final UserBindData getData() {
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
        UserBindData userBindData = this.data;
        return hashCode2 + (userBindData != null ? userBindData.hashCode() : 0);
    }

    public final void setData(UserBindData userBindData) {
        this.data = userBindData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "UserBindResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
