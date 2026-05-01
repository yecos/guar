package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class AuthInfo {
    private String effectTime;
    private String expInvalidTime;
    private String invalidTime;
    private String productCode;
    private String productName;
    private String serviceType;
    private String userName;

    public AuthInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        i.g(str4, "invalidTime");
        this.userName = str;
        this.productCode = str2;
        this.effectTime = str3;
        this.invalidTime = str4;
        this.expInvalidTime = str5;
        this.serviceType = str6;
        this.productName = str7;
    }

    public static /* synthetic */ AuthInfo copy$default(AuthInfo authInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = authInfo.userName;
        }
        if ((i10 & 2) != 0) {
            str2 = authInfo.productCode;
        }
        String str8 = str2;
        if ((i10 & 4) != 0) {
            str3 = authInfo.effectTime;
        }
        String str9 = str3;
        if ((i10 & 8) != 0) {
            str4 = authInfo.invalidTime;
        }
        String str10 = str4;
        if ((i10 & 16) != 0) {
            str5 = authInfo.expInvalidTime;
        }
        String str11 = str5;
        if ((i10 & 32) != 0) {
            str6 = authInfo.serviceType;
        }
        String str12 = str6;
        if ((i10 & 64) != 0) {
            str7 = authInfo.productName;
        }
        return authInfo.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.userName;
    }

    public final String component2() {
        return this.productCode;
    }

    public final String component3() {
        return this.effectTime;
    }

    public final String component4() {
        return this.invalidTime;
    }

    public final String component5() {
        return this.expInvalidTime;
    }

    public final String component6() {
        return this.serviceType;
    }

    public final String component7() {
        return this.productName;
    }

    public final AuthInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        i.g(str4, "invalidTime");
        return new AuthInfo(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthInfo)) {
            return false;
        }
        AuthInfo authInfo = (AuthInfo) obj;
        return i.b(this.userName, authInfo.userName) && i.b(this.productCode, authInfo.productCode) && i.b(this.effectTime, authInfo.effectTime) && i.b(this.invalidTime, authInfo.invalidTime) && i.b(this.expInvalidTime, authInfo.expInvalidTime) && i.b(this.serviceType, authInfo.serviceType) && i.b(this.productName, authInfo.productName);
    }

    public final String getEffectTime() {
        return this.effectTime;
    }

    public final String getExpInvalidTime() {
        return this.expInvalidTime;
    }

    public final String getInvalidTime() {
        return this.invalidTime;
    }

    public final String getProductCode() {
        return this.productCode;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final String getServiceType() {
        return this.serviceType;
    }

    public final String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        String str = this.userName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.productCode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.effectTime;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.invalidTime.hashCode()) * 31;
        String str4 = this.expInvalidTime;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.serviceType;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.productName;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setEffectTime(String str) {
        this.effectTime = str;
    }

    public final void setExpInvalidTime(String str) {
        this.expInvalidTime = str;
    }

    public final void setInvalidTime(String str) {
        i.g(str, "<set-?>");
        this.invalidTime = str;
    }

    public final void setProductCode(String str) {
        this.productCode = str;
    }

    public final void setProductName(String str) {
        this.productName = str;
    }

    public final void setServiceType(String str) {
        this.serviceType = str;
    }

    public final void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        return "AuthInfo(userName=" + this.userName + ", productCode=" + this.productCode + ", effectTime=" + this.effectTime + ", invalidTime=" + this.invalidTime + ", expInvalidTime=" + this.expInvalidTime + ", serviceType=" + this.serviceType + ", productName=" + this.productName + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
