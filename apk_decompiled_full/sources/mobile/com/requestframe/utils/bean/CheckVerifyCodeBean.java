package mobile.com.requestframe.utils.bean;

import com.google.android.gms.common.Scopes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class CheckVerifyCodeBean {
    private String email;
    private String type;
    private String userId;
    private String userToken;
    private String verifyCode;

    public CheckVerifyCodeBean(String str, String str2, String str3, String str4, String str5) {
        i.g(str, Scopes.EMAIL);
        i.g(str2, "type");
        i.g(str3, "verifyCode");
        this.email = str;
        this.type = str2;
        this.verifyCode = str3;
        this.userToken = str4;
        this.userId = str5;
    }

    public static /* synthetic */ CheckVerifyCodeBean copy$default(CheckVerifyCodeBean checkVerifyCodeBean, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = checkVerifyCodeBean.email;
        }
        if ((i10 & 2) != 0) {
            str2 = checkVerifyCodeBean.type;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = checkVerifyCodeBean.verifyCode;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = checkVerifyCodeBean.userToken;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = checkVerifyCodeBean.userId;
        }
        return checkVerifyCodeBean.copy(str, str6, str7, str8, str5);
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

    public final CheckVerifyCodeBean copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str, Scopes.EMAIL);
        i.g(str2, "type");
        i.g(str3, "verifyCode");
        return new CheckVerifyCodeBean(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckVerifyCodeBean)) {
            return false;
        }
        CheckVerifyCodeBean checkVerifyCodeBean = (CheckVerifyCodeBean) obj;
        return i.b(this.email, checkVerifyCodeBean.email) && i.b(this.type, checkVerifyCodeBean.type) && i.b(this.verifyCode, checkVerifyCodeBean.verifyCode) && i.b(this.userToken, checkVerifyCodeBean.userToken) && i.b(this.userId, checkVerifyCodeBean.userId);
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
        int hashCode = ((((this.email.hashCode() * 31) + this.type.hashCode()) * 31) + this.verifyCode.hashCode()) * 31;
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

    public final void setVerifyCode(String str) {
        i.g(str, "<set-?>");
        this.verifyCode = str;
    }

    public String toString() {
        return "CheckVerifyCodeBean(email=" + this.email + ", type=" + this.type + ", verifyCode=" + this.verifyCode + ", userToken=" + this.userToken + ", userId=" + this.userId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
