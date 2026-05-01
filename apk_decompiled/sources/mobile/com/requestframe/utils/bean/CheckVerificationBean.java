package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class CheckVerificationBean {
    private String areaCode;
    private String password;
    private String phone;
    private String type;
    private String userId;
    private String userToken;
    private String verificationCode;

    public CheckVerificationBean(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        i.g(str, "phone");
        i.g(str2, "areaCode");
        i.g(str3, "verificationCode");
        i.g(str4, "type");
        this.phone = str;
        this.areaCode = str2;
        this.verificationCode = str3;
        this.type = str4;
        this.userId = str5;
        this.userToken = str6;
        this.password = str7;
    }

    public static /* synthetic */ CheckVerificationBean copy$default(CheckVerificationBean checkVerificationBean, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = checkVerificationBean.phone;
        }
        if ((i10 & 2) != 0) {
            str2 = checkVerificationBean.areaCode;
        }
        String str8 = str2;
        if ((i10 & 4) != 0) {
            str3 = checkVerificationBean.verificationCode;
        }
        String str9 = str3;
        if ((i10 & 8) != 0) {
            str4 = checkVerificationBean.type;
        }
        String str10 = str4;
        if ((i10 & 16) != 0) {
            str5 = checkVerificationBean.userId;
        }
        String str11 = str5;
        if ((i10 & 32) != 0) {
            str6 = checkVerificationBean.userToken;
        }
        String str12 = str6;
        if ((i10 & 64) != 0) {
            str7 = checkVerificationBean.password;
        }
        return checkVerificationBean.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.phone;
    }

    public final String component2() {
        return this.areaCode;
    }

    public final String component3() {
        return this.verificationCode;
    }

    public final String component4() {
        return this.type;
    }

    public final String component5() {
        return this.userId;
    }

    public final String component6() {
        return this.userToken;
    }

    public final String component7() {
        return this.password;
    }

    public final CheckVerificationBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        i.g(str, "phone");
        i.g(str2, "areaCode");
        i.g(str3, "verificationCode");
        i.g(str4, "type");
        return new CheckVerificationBean(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckVerificationBean)) {
            return false;
        }
        CheckVerificationBean checkVerificationBean = (CheckVerificationBean) obj;
        return i.b(this.phone, checkVerificationBean.phone) && i.b(this.areaCode, checkVerificationBean.areaCode) && i.b(this.verificationCode, checkVerificationBean.verificationCode) && i.b(this.type, checkVerificationBean.type) && i.b(this.userId, checkVerificationBean.userId) && i.b(this.userToken, checkVerificationBean.userToken) && i.b(this.password, checkVerificationBean.password);
    }

    public final String getAreaCode() {
        return this.areaCode;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getPhone() {
        return this.phone;
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

    public final String getVerificationCode() {
        return this.verificationCode;
    }

    public int hashCode() {
        int hashCode = ((((((this.phone.hashCode() * 31) + this.areaCode.hashCode()) * 31) + this.verificationCode.hashCode()) * 31) + this.type.hashCode()) * 31;
        String str = this.userId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.userToken;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.password;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setAreaCode(String str) {
        i.g(str, "<set-?>");
        this.areaCode = str;
    }

    public final void setPassword(String str) {
        this.password = str;
    }

    public final void setPhone(String str) {
        i.g(str, "<set-?>");
        this.phone = str;
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

    public final void setVerificationCode(String str) {
        i.g(str, "<set-?>");
        this.verificationCode = str;
    }

    public String toString() {
        return "CheckVerificationBean(phone=" + this.phone + ", areaCode=" + this.areaCode + ", verificationCode=" + this.verificationCode + ", type=" + this.type + ", userId=" + this.userId + ", userToken=" + this.userToken + ", password=" + this.password + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
