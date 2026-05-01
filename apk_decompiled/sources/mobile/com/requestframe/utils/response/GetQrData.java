package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.common.global.Constant;
import t9.i;

/* loaded from: classes3.dex */
public final class GetQrData {
    private String qrAuthCodeToken;
    private String status;
    private UserData userInfo;

    public GetQrData(String str, UserData userData, String str2) {
        i.g(str, Constant.KEY_STATUS);
        this.status = str;
        this.userInfo = userData;
        this.qrAuthCodeToken = str2;
    }

    public static /* synthetic */ GetQrData copy$default(GetQrData getQrData, String str, UserData userData, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getQrData.status;
        }
        if ((i10 & 2) != 0) {
            userData = getQrData.userInfo;
        }
        if ((i10 & 4) != 0) {
            str2 = getQrData.qrAuthCodeToken;
        }
        return getQrData.copy(str, userData, str2);
    }

    public final String component1() {
        return this.status;
    }

    public final UserData component2() {
        return this.userInfo;
    }

    public final String component3() {
        return this.qrAuthCodeToken;
    }

    public final GetQrData copy(String str, UserData userData, String str2) {
        i.g(str, Constant.KEY_STATUS);
        return new GetQrData(str, userData, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetQrData)) {
            return false;
        }
        GetQrData getQrData = (GetQrData) obj;
        return i.b(this.status, getQrData.status) && i.b(this.userInfo, getQrData.userInfo) && i.b(this.qrAuthCodeToken, getQrData.qrAuthCodeToken);
    }

    public final String getQrAuthCodeToken() {
        return this.qrAuthCodeToken;
    }

    public final String getStatus() {
        return this.status;
    }

    public final UserData getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        int hashCode = this.status.hashCode() * 31;
        UserData userData = this.userInfo;
        int hashCode2 = (hashCode + (userData == null ? 0 : userData.hashCode())) * 31;
        String str = this.qrAuthCodeToken;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final void setQrAuthCodeToken(String str) {
        this.qrAuthCodeToken = str;
    }

    public final void setStatus(String str) {
        i.g(str, "<set-?>");
        this.status = str;
    }

    public final void setUserInfo(UserData userData) {
        this.userInfo = userData;
    }

    public String toString() {
        return "GetQrData(status=" + this.status + ", userInfo=" + this.userInfo + ", qrAuthCodeToken=" + this.qrAuthCodeToken + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
