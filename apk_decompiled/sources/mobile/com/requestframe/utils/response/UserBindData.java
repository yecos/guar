package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class UserBindData {
    private String areaCode;
    private String bindMail;
    private String bindMobile;
    private String email;

    /* renamed from: mobile, reason: collision with root package name */
    private String f16874mobile;

    public UserBindData(String str, String str2, String str3, String str4, String str5) {
        i.g(str4, "bindMobile");
        i.g(str5, "areaCode");
        this.email = str;
        this.bindMail = str2;
        this.f16874mobile = str3;
        this.bindMobile = str4;
        this.areaCode = str5;
    }

    public static /* synthetic */ UserBindData copy$default(UserBindData userBindData, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = userBindData.email;
        }
        if ((i10 & 2) != 0) {
            str2 = userBindData.bindMail;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = userBindData.f16874mobile;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = userBindData.bindMobile;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = userBindData.areaCode;
        }
        return userBindData.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.bindMail;
    }

    public final String component3() {
        return this.f16874mobile;
    }

    public final String component4() {
        return this.bindMobile;
    }

    public final String component5() {
        return this.areaCode;
    }

    public final UserBindData copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str4, "bindMobile");
        i.g(str5, "areaCode");
        return new UserBindData(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserBindData)) {
            return false;
        }
        UserBindData userBindData = (UserBindData) obj;
        return i.b(this.email, userBindData.email) && i.b(this.bindMail, userBindData.bindMail) && i.b(this.f16874mobile, userBindData.f16874mobile) && i.b(this.bindMobile, userBindData.bindMobile) && i.b(this.areaCode, userBindData.areaCode);
    }

    public final String getAreaCode() {
        return this.areaCode;
    }

    public final String getBindMail() {
        return this.bindMail;
    }

    public final String getBindMobile() {
        return this.bindMobile;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getMobile() {
        return this.f16874mobile;
    }

    public int hashCode() {
        String str = this.email;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.bindMail;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f16874mobile;
        return ((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.bindMobile.hashCode()) * 31) + this.areaCode.hashCode();
    }

    public final void setAreaCode(String str) {
        i.g(str, "<set-?>");
        this.areaCode = str;
    }

    public final void setBindMail(String str) {
        this.bindMail = str;
    }

    public final void setBindMobile(String str) {
        i.g(str, "<set-?>");
        this.bindMobile = str;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final void setMobile(String str) {
        this.f16874mobile = str;
    }

    public String toString() {
        return "UserBindData(email=" + this.email + ", bindMail=" + this.bindMail + ", mobile=" + this.f16874mobile + ", bindMobile=" + this.bindMobile + ", areaCode=" + this.areaCode + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
