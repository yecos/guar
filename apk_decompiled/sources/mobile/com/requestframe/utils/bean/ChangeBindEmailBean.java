package mobile.com.requestframe.utils.bean;

import com.google.android.gms.common.Scopes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ChangeBindEmailBean {
    private String email;
    private String type;
    private String userId;
    private String userToken;
    private String verifyCode;

    public ChangeBindEmailBean(String str, String str2, String str3, String str4, String str5) {
        i.g(str, Scopes.EMAIL);
        i.g(str2, "type");
        i.g(str3, "verifyCode");
        i.g(str4, "userToken");
        i.g(str5, "userId");
        this.email = str;
        this.type = str2;
        this.verifyCode = str3;
        this.userToken = str4;
        this.userId = str5;
    }

    public static /* synthetic */ ChangeBindEmailBean copy$default(ChangeBindEmailBean changeBindEmailBean, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = changeBindEmailBean.email;
        }
        if ((i10 & 2) != 0) {
            str2 = changeBindEmailBean.type;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = changeBindEmailBean.verifyCode;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = changeBindEmailBean.userToken;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = changeBindEmailBean.userId;
        }
        return changeBindEmailBean.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.verifyCode;
    }

    public final String component4() {
        return this.userToken;
    }

    public final String component5() {
        return this.userId;
    }

    public final ChangeBindEmailBean copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str, Scopes.EMAIL);
        i.g(str2, "type");
        i.g(str3, "verifyCode");
        i.g(str4, "userToken");
        i.g(str5, "userId");
        return new ChangeBindEmailBean(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangeBindEmailBean)) {
            return false;
        }
        ChangeBindEmailBean changeBindEmailBean = (ChangeBindEmailBean) obj;
        return i.b(this.email, changeBindEmailBean.email) && i.b(this.type, changeBindEmailBean.type) && i.b(this.verifyCode, changeBindEmailBean.verifyCode) && i.b(this.userToken, changeBindEmailBean.userToken) && i.b(this.userId, changeBindEmailBean.userId);
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

    public final String getVerifyCode() {
        return this.verifyCode;
    }

    public int hashCode() {
        return (((((((this.email.hashCode() * 31) + this.type.hashCode()) * 31) + this.verifyCode.hashCode()) * 31) + this.userToken.hashCode()) * 31) + this.userId.hashCode();
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
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public final void setUserToken(String str) {
        i.g(str, "<set-?>");
        this.userToken = str;
    }

    public final void setVerifyCode(String str) {
        i.g(str, "<set-?>");
        this.verifyCode = str;
    }

    public String toString() {
        return "ChangeBindEmailBean(email=" + this.email + ", type=" + this.type + ", verifyCode=" + this.verifyCode + ", userToken=" + this.userToken + ", userId=" + this.userId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
