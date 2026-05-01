package mobile.com.requestframe.utils.bean;

import com.google.android.gms.common.Scopes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class BindEmailV2Bean {
    private String email;
    private String pwd;
    private String type;
    private String userId;
    private String userToken;

    public BindEmailV2Bean(String str, String str2, String str3, String str4, String str5) {
        i.g(str, Scopes.EMAIL);
        i.g(str2, "type");
        i.g(str3, "pwd");
        i.g(str4, "userToken");
        i.g(str5, "userId");
        this.email = str;
        this.type = str2;
        this.pwd = str3;
        this.userToken = str4;
        this.userId = str5;
    }

    public static /* synthetic */ BindEmailV2Bean copy$default(BindEmailV2Bean bindEmailV2Bean, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = bindEmailV2Bean.email;
        }
        if ((i10 & 2) != 0) {
            str2 = bindEmailV2Bean.type;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = bindEmailV2Bean.pwd;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = bindEmailV2Bean.userToken;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = bindEmailV2Bean.userId;
        }
        return bindEmailV2Bean.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.pwd;
    }

    public final String component4() {
        return this.userToken;
    }

    public final String component5() {
        return this.userId;
    }

    public final BindEmailV2Bean copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str, Scopes.EMAIL);
        i.g(str2, "type");
        i.g(str3, "pwd");
        i.g(str4, "userToken");
        i.g(str5, "userId");
        return new BindEmailV2Bean(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BindEmailV2Bean)) {
            return false;
        }
        BindEmailV2Bean bindEmailV2Bean = (BindEmailV2Bean) obj;
        return i.b(this.email, bindEmailV2Bean.email) && i.b(this.type, bindEmailV2Bean.type) && i.b(this.pwd, bindEmailV2Bean.pwd) && i.b(this.userToken, bindEmailV2Bean.userToken) && i.b(this.userId, bindEmailV2Bean.userId);
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPwd() {
        return this.pwd;
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
        return (((((((this.email.hashCode() * 31) + this.type.hashCode()) * 31) + this.pwd.hashCode()) * 31) + this.userToken.hashCode()) * 31) + this.userId.hashCode();
    }

    public final void setEmail(String str) {
        i.g(str, "<set-?>");
        this.email = str;
    }

    public final void setPwd(String str) {
        i.g(str, "<set-?>");
        this.pwd = str;
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

    public String toString() {
        return "BindEmailV2Bean(email=" + this.email + ", type=" + this.type + ", pwd=" + this.pwd + ", userToken=" + this.userToken + ", userId=" + this.userId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
