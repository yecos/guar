package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ChangeBindPhoneBean {
    private String areaCode;
    private String phone;
    private String userId;
    private String userToken;
    private String verificationCode;

    public ChangeBindPhoneBean(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "phone");
        i.g(str2, "areaCode");
        i.g(str3, "verificationCode");
        i.g(str4, "userToken");
        i.g(str5, "userId");
        this.phone = str;
        this.areaCode = str2;
        this.verificationCode = str3;
        this.userToken = str4;
        this.userId = str5;
    }

    public static /* synthetic */ ChangeBindPhoneBean copy$default(ChangeBindPhoneBean changeBindPhoneBean, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = changeBindPhoneBean.phone;
        }
        if ((i10 & 2) != 0) {
            str2 = changeBindPhoneBean.areaCode;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = changeBindPhoneBean.verificationCode;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = changeBindPhoneBean.userToken;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = changeBindPhoneBean.userId;
        }
        return changeBindPhoneBean.copy(str, str6, str7, str8, str5);
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
        return this.userToken;
    }

    public final String component5() {
        return this.userId;
    }

    public final ChangeBindPhoneBean copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "phone");
        i.g(str2, "areaCode");
        i.g(str3, "verificationCode");
        i.g(str4, "userToken");
        i.g(str5, "userId");
        return new ChangeBindPhoneBean(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangeBindPhoneBean)) {
            return false;
        }
        ChangeBindPhoneBean changeBindPhoneBean = (ChangeBindPhoneBean) obj;
        return i.b(this.phone, changeBindPhoneBean.phone) && i.b(this.areaCode, changeBindPhoneBean.areaCode) && i.b(this.verificationCode, changeBindPhoneBean.verificationCode) && i.b(this.userToken, changeBindPhoneBean.userToken) && i.b(this.userId, changeBindPhoneBean.userId);
    }

    public final String getAreaCode() {
        return this.areaCode;
    }

    public final String getPhone() {
        return this.phone;
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
        return (((((((this.phone.hashCode() * 31) + this.areaCode.hashCode()) * 31) + this.verificationCode.hashCode()) * 31) + this.userToken.hashCode()) * 31) + this.userId.hashCode();
    }

    public final void setAreaCode(String str) {
        i.g(str, "<set-?>");
        this.areaCode = str;
    }

    public final void setPhone(String str) {
        i.g(str, "<set-?>");
        this.phone = str;
    }

    public final void setUserId(String str) {
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public final void setUserToken(String str) {
        i.g(str, "<set-?>");
        this.userToken = str;
    }

    public final void setVerificationCode(String str) {
        i.g(str, "<set-?>");
        this.verificationCode = str;
    }

    public String toString() {
        return "ChangeBindPhoneBean(phone=" + this.phone + ", areaCode=" + this.areaCode + ", verificationCode=" + this.verificationCode + ", userToken=" + this.userToken + ", userId=" + this.userId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
