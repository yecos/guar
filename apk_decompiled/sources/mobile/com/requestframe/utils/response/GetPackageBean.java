package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetPackageBean {
    private String appVersion;
    private String packageType;
    private String userId;
    private String userToken;

    public GetPackageBean(String str, String str2, String str3, String str4) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "packageType");
        i.g(str4, "appVersion");
        this.userToken = str;
        this.userId = str2;
        this.packageType = str3;
        this.appVersion = str4;
    }

    public static /* synthetic */ GetPackageBean copy$default(GetPackageBean getPackageBean, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getPackageBean.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = getPackageBean.userId;
        }
        if ((i10 & 4) != 0) {
            str3 = getPackageBean.packageType;
        }
        if ((i10 & 8) != 0) {
            str4 = getPackageBean.appVersion;
        }
        return getPackageBean.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.userToken;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.packageType;
    }

    public final String component4() {
        return this.appVersion;
    }

    public final GetPackageBean copy(String str, String str2, String str3, String str4) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "packageType");
        i.g(str4, "appVersion");
        return new GetPackageBean(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetPackageBean)) {
            return false;
        }
        GetPackageBean getPackageBean = (GetPackageBean) obj;
        return i.b(this.userToken, getPackageBean.userToken) && i.b(this.userId, getPackageBean.userId) && i.b(this.packageType, getPackageBean.packageType) && i.b(this.appVersion, getPackageBean.appVersion);
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getPackageType() {
        return this.packageType;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.packageType.hashCode()) * 31) + this.appVersion.hashCode();
    }

    public final void setAppVersion(String str) {
        i.g(str, "<set-?>");
        this.appVersion = str;
    }

    public final void setPackageType(String str) {
        i.g(str, "<set-?>");
        this.packageType = str;
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
        return "GetPackageBean(userToken=" + this.userToken + ", userId=" + this.userId + ", packageType=" + this.packageType + ", appVersion=" + this.appVersion + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
