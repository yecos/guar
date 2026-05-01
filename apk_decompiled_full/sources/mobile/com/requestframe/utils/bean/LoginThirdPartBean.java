package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class LoginThirdPartBean {
    private String accountType;
    private String createType;
    private String password;
    private String thirdpartToken;
    private String tokenSource;

    public LoginThirdPartBean(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "accountType");
        i.g(str2, "thirdpartToken");
        i.g(str3, "createType");
        i.g(str4, "tokenSource");
        this.accountType = str;
        this.thirdpartToken = str2;
        this.createType = str3;
        this.tokenSource = str4;
        this.password = str5;
    }

    public static /* synthetic */ LoginThirdPartBean copy$default(LoginThirdPartBean loginThirdPartBean, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = loginThirdPartBean.accountType;
        }
        if ((i10 & 2) != 0) {
            str2 = loginThirdPartBean.thirdpartToken;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = loginThirdPartBean.createType;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = loginThirdPartBean.tokenSource;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = loginThirdPartBean.password;
        }
        return loginThirdPartBean.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.accountType;
    }

    public final String component2() {
        return this.thirdpartToken;
    }

    public final String component3() {
        return this.createType;
    }

    public final String component4() {
        return this.tokenSource;
    }

    public final String component5() {
        return this.password;
    }

    public final LoginThirdPartBean copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "accountType");
        i.g(str2, "thirdpartToken");
        i.g(str3, "createType");
        i.g(str4, "tokenSource");
        return new LoginThirdPartBean(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoginThirdPartBean)) {
            return false;
        }
        LoginThirdPartBean loginThirdPartBean = (LoginThirdPartBean) obj;
        return i.b(this.accountType, loginThirdPartBean.accountType) && i.b(this.thirdpartToken, loginThirdPartBean.thirdpartToken) && i.b(this.createType, loginThirdPartBean.createType) && i.b(this.tokenSource, loginThirdPartBean.tokenSource) && i.b(this.password, loginThirdPartBean.password);
    }

    public final String getAccountType() {
        return this.accountType;
    }

    public final String getCreateType() {
        return this.createType;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getThirdpartToken() {
        return this.thirdpartToken;
    }

    public final String getTokenSource() {
        return this.tokenSource;
    }

    public int hashCode() {
        int hashCode = ((((((this.accountType.hashCode() * 31) + this.thirdpartToken.hashCode()) * 31) + this.createType.hashCode()) * 31) + this.tokenSource.hashCode()) * 31;
        String str = this.password;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setAccountType(String str) {
        i.g(str, "<set-?>");
        this.accountType = str;
    }

    public final void setCreateType(String str) {
        i.g(str, "<set-?>");
        this.createType = str;
    }

    public final void setPassword(String str) {
        this.password = str;
    }

    public final void setThirdpartToken(String str) {
        i.g(str, "<set-?>");
        this.thirdpartToken = str;
    }

    public final void setTokenSource(String str) {
        i.g(str, "<set-?>");
        this.tokenSource = str;
    }

    public String toString() {
        return "LoginThirdPartBean(accountType=" + this.accountType + ", thirdpartToken=" + this.thirdpartToken + ", createType=" + this.createType + ", tokenSource=" + this.tokenSource + ", password=" + this.password + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public /* synthetic */ LoginThirdPartBean(String str, String str2, String str3, String str4, String str5, int i10, g gVar) {
        this(str, str2, str3, str4, (i10 & 16) != 0 ? null : str5);
    }
}
