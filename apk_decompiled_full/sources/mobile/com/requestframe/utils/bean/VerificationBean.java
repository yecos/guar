package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class VerificationBean {
    private String areaCode;
    private String phone;
    private String type;
    private String userId;
    private String userToken;

    public VerificationBean(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "phone");
        i.g(str2, "areaCode");
        i.g(str3, "type");
        i.g(str4, "userToken");
        i.g(str5, "userId");
        this.phone = str;
        this.areaCode = str2;
        this.type = str3;
        this.userToken = str4;
        this.userId = str5;
    }

    public static /* synthetic */ VerificationBean copy$default(VerificationBean verificationBean, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = verificationBean.phone;
        }
        if ((i10 & 2) != 0) {
            str2 = verificationBean.areaCode;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = verificationBean.type;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = verificationBean.userToken;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = verificationBean.userId;
        }
        return verificationBean.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.phone;
    }

    public final String component2() {
        return this.areaCode;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.userToken;
    }

    public final String component5() {
        return this.userId;
    }

    public final VerificationBean copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "phone");
        i.g(str2, "areaCode");
        i.g(str3, "type");
        i.g(str4, "userToken");
        i.g(str5, "userId");
        return new VerificationBean(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerificationBean)) {
            return false;
        }
        VerificationBean verificationBean = (VerificationBean) obj;
        return i.b(this.phone, verificationBean.phone) && i.b(this.areaCode, verificationBean.areaCode) && i.b(this.type, verificationBean.type) && i.b(this.userToken, verificationBean.userToken) && i.b(this.userId, verificationBean.userId);
    }

    public final String getAreaCode() {
        return this.areaCode;
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

    public int hashCode() {
        return (((((((this.phone.hashCode() * 31) + this.areaCode.hashCode()) * 31) + this.type.hashCode()) * 31) + this.userToken.hashCode()) * 31) + this.userId.hashCode();
    }

    public final void setAreaCode(String str) {
        i.g(str, "<set-?>");
        this.areaCode = str;
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
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public final void setUserToken(String str) {
        i.g(str, "<set-?>");
        this.userToken = str;
    }

    public String toString() {
        return "VerificationBean(phone=" + this.phone + ", areaCode=" + this.areaCode + ", type=" + this.type + ", userToken=" + this.userToken + ", userId=" + this.userId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
