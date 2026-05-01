package mobile.com.requestframe.utils.bean;

import com.google.android.gms.common.Scopes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ResetPwdEmailBean {
    private String email;
    private String password;
    private String type;
    private String verifyCode;

    public ResetPwdEmailBean(String str, String str2, String str3, String str4) {
        i.g(str, Scopes.EMAIL);
        i.g(str2, "password");
        i.g(str3, "type");
        i.g(str4, "verifyCode");
        this.email = str;
        this.password = str2;
        this.type = str3;
        this.verifyCode = str4;
    }

    public static /* synthetic */ ResetPwdEmailBean copy$default(ResetPwdEmailBean resetPwdEmailBean, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = resetPwdEmailBean.email;
        }
        if ((i10 & 2) != 0) {
            str2 = resetPwdEmailBean.password;
        }
        if ((i10 & 4) != 0) {
            str3 = resetPwdEmailBean.type;
        }
        if ((i10 & 8) != 0) {
            str4 = resetPwdEmailBean.verifyCode;
        }
        return resetPwdEmailBean.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.password;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.verifyCode;
    }

    public final ResetPwdEmailBean copy(String str, String str2, String str3, String str4) {
        i.g(str, Scopes.EMAIL);
        i.g(str2, "password");
        i.g(str3, "type");
        i.g(str4, "verifyCode");
        return new ResetPwdEmailBean(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResetPwdEmailBean)) {
            return false;
        }
        ResetPwdEmailBean resetPwdEmailBean = (ResetPwdEmailBean) obj;
        return i.b(this.email, resetPwdEmailBean.email) && i.b(this.password, resetPwdEmailBean.password) && i.b(this.type, resetPwdEmailBean.type) && i.b(this.verifyCode, resetPwdEmailBean.verifyCode);
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getType() {
        return this.type;
    }

    public final String getVerifyCode() {
        return this.verifyCode;
    }

    public int hashCode() {
        return (((((this.email.hashCode() * 31) + this.password.hashCode()) * 31) + this.type.hashCode()) * 31) + this.verifyCode.hashCode();
    }

    public final void setEmail(String str) {
        i.g(str, "<set-?>");
        this.email = str;
    }

    public final void setPassword(String str) {
        i.g(str, "<set-?>");
        this.password = str;
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
    }

    public final void setVerifyCode(String str) {
        i.g(str, "<set-?>");
        this.verifyCode = str;
    }

    public String toString() {
        return "ResetPwdEmailBean(email=" + this.email + ", password=" + this.password + ", type=" + this.type + ", verifyCode=" + this.verifyCode + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
