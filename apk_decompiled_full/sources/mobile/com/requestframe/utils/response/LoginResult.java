package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class LoginResult implements Serializable {
    private UserData data;
    private String errorMessage;
    private String returnCode;

    public LoginResult(String str, String str2, UserData userData) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = userData;
    }

    public static /* synthetic */ LoginResult copy$default(LoginResult loginResult, String str, String str2, UserData userData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = loginResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = loginResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            userData = loginResult.data;
        }
        return loginResult.copy(str, str2, userData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final UserData component3() {
        return this.data;
    }

    public final LoginResult copy(String str, String str2, UserData userData) {
        return new LoginResult(str, str2, userData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoginResult)) {
            return false;
        }
        LoginResult loginResult = (LoginResult) obj;
        return i.b(this.returnCode, loginResult.returnCode) && i.b(this.errorMessage, loginResult.errorMessage) && i.b(this.data, loginResult.data);
    }

    public final UserData getData() {
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
        UserData userData = this.data;
        return hashCode2 + (userData != null ? userData.hashCode() : 0);
    }

    public final void setData(UserData userData) {
        this.data = userData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "LoginResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
