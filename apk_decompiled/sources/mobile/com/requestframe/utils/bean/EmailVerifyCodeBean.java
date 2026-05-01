package mobile.com.requestframe.utils.bean;

import com.google.android.gms.common.Scopes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class EmailVerifyCodeBean {
    private String email;
    private String type;
    private String userId;
    private String userToken;

    public EmailVerifyCodeBean(String str, String str2, String str3, String str4) {
        i.g(str, Scopes.EMAIL);
        i.g(str2, "type");
        this.email = str;
        this.type = str2;
        this.userToken = str3;
        this.userId = str4;
    }

    public static /* synthetic */ EmailVerifyCodeBean copy$default(EmailVerifyCodeBean emailVerifyCodeBean, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = emailVerifyCodeBean.email;
        }
        if ((i10 & 2) != 0) {
            str2 = emailVerifyCodeBean.type;
        }
        if ((i10 & 4) != 0) {
            str3 = emailVerifyCodeBean.userToken;
        }
        if ((i10 & 8) != 0) {
            str4 = emailVerifyCodeBean.userId;
        }
        return emailVerifyCodeBean.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.userToken;
    }

    public final String component4() {
        return this.userId;
    }

    public final EmailVerifyCodeBean copy(String str, String str2, String str3, String str4) {
        i.g(str, Scopes.EMAIL);
        i.g(str2, "type");
        return new EmailVerifyCodeBean(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmailVerifyCodeBean)) {
            return false;
        }
        EmailVerifyCodeBean emailVerifyCodeBean = (EmailVerifyCodeBean) obj;
        return i.b(this.email, emailVerifyCodeBean.email) && i.b(this.type, emailVerifyCodeBean.type) && i.b(this.userToken, emailVerifyCodeBean.userToken) && i.b(this.userId, emailVerifyCodeBean.userId);
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        int hashCode = ((this.email.hashCode() * 31) + this.type.hashCode()) * 31;
        String str = this.userToken;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.userId;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setEmail(String str) {
        i.g(str, "<set-?>");
        this.email = str;
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final void setUserToken(String str) {
        this.userToken = str;
    }

    public String toString() {
        return "EmailVerifyCodeBean(email=" + this.email + ", type=" + this.type + ", userToken=" + this.userToken + ", userId=" + this.userId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
