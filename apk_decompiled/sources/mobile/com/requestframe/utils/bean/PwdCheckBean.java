package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class PwdCheckBean implements Serializable {
    private String password;
    private String userId;
    private String userToken;

    public PwdCheckBean(String str, String str2, String str3) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "password");
        this.userToken = str;
        this.userId = str2;
        this.password = str3;
    }

    public static /* synthetic */ PwdCheckBean copy$default(PwdCheckBean pwdCheckBean, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = pwdCheckBean.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = pwdCheckBean.userId;
        }
        if ((i10 & 4) != 0) {
            str3 = pwdCheckBean.password;
        }
        return pwdCheckBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.userToken;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.password;
    }

    public final PwdCheckBean copy(String str, String str2, String str3) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "password");
        return new PwdCheckBean(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PwdCheckBean)) {
            return false;
        }
        PwdCheckBean pwdCheckBean = (PwdCheckBean) obj;
        return i.b(this.userToken, pwdCheckBean.userToken) && i.b(this.userId, pwdCheckBean.userId) && i.b(this.password, pwdCheckBean.password);
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.password.hashCode();
    }

    public final void setPassword(String str) {
        i.g(str, "<set-?>");
        this.password = str;
    }

    public final void setUserId(String str) {
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public final void setUserToken(String str) {
        i.g(str, "<set-?>");
        this.userToken = str;
    }

    public String toString() {
        return "PwdCheckBean(userToken=" + this.userToken + ", userId=" + this.userId + ", password=" + this.password + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
