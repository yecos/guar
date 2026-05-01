package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class LoginBean {
    private String accountType;
    private String areaCode;
    private String macAddr;
    private String password;
    private String type;
    private String userName;
    private String userToken;
    private String verificationCode;
    private String verificationToken;

    public LoginBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        i.g(str, "accountType");
        i.g(str3, "userName");
        i.g(str4, "password");
        i.g(str6, "macAddr");
        this.accountType = str;
        this.areaCode = str2;
        this.userName = str3;
        this.password = str4;
        this.type = str5;
        this.macAddr = str6;
        this.verificationCode = str7;
        this.verificationToken = str8;
        this.userToken = str9;
    }

    public final String component1() {
        return this.accountType;
    }

    public final String component2() {
        return this.areaCode;
    }

    public final String component3() {
        return this.userName;
    }

    public final String component4() {
        return this.password;
    }

    public final String component5() {
        return this.type;
    }

    public final String component6() {
        return this.macAddr;
    }

    public final String component7() {
        return this.verificationCode;
    }

    public final String component8() {
        return this.verificationToken;
    }

    public final String component9() {
        return this.userToken;
    }

    public final LoginBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        i.g(str, "accountType");
        i.g(str3, "userName");
        i.g(str4, "password");
        i.g(str6, "macAddr");
        return new LoginBean(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoginBean)) {
            return false;
        }
        LoginBean loginBean = (LoginBean) obj;
        return i.b(this.accountType, loginBean.accountType) && i.b(this.areaCode, loginBean.areaCode) && i.b(this.userName, loginBean.userName) && i.b(this.password, loginBean.password) && i.b(this.type, loginBean.type) && i.b(this.macAddr, loginBean.macAddr) && i.b(this.verificationCode, loginBean.verificationCode) && i.b(this.verificationToken, loginBean.verificationToken) && i.b(this.userToken, loginBean.userToken);
    }

    public final String getAccountType() {
        return this.accountType;
    }

    public final String getAreaCode() {
        return this.areaCode;
    }

    public final String getMacAddr() {
        return this.macAddr;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public final String getVerificationCode() {
        return this.verificationCode;
    }

    public final String getVerificationToken() {
        return this.verificationToken;
    }

    public int hashCode() {
        int hashCode = this.accountType.hashCode() * 31;
        String str = this.areaCode;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.userName.hashCode()) * 31) + this.password.hashCode()) * 31;
        String str2 = this.type;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.macAddr.hashCode()) * 31;
        String str3 = this.verificationCode;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.verificationToken;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.userToken;
        return hashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setAccountType(String str) {
        i.g(str, "<set-?>");
        this.accountType = str;
    }

    public final void setAreaCode(String str) {
        this.areaCode = str;
    }

    public final void setMacAddr(String str) {
        i.g(str, "<set-?>");
        this.macAddr = str;
    }

    public final void setPassword(String str) {
        i.g(str, "<set-?>");
        this.password = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setUserName(String str) {
        i.g(str, "<set-?>");
        this.userName = str;
    }

    public final void setUserToken(String str) {
        this.userToken = str;
    }

    public final void setVerificationCode(String str) {
        this.verificationCode = str;
    }

    public final void setVerificationToken(String str) {
        this.verificationToken = str;
    }

    public String toString() {
        return "LoginBean(accountType=" + this.accountType + ", areaCode=" + this.areaCode + ", userName=" + this.userName + ", password=" + this.password + ", type=" + this.type + ", macAddr=" + this.macAddr + ", verificationCode=" + this.verificationCode + ", verificationToken=" + this.verificationToken + ", userToken=" + this.userToken + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
