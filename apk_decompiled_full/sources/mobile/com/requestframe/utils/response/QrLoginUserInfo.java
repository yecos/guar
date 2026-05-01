package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class QrLoginUserInfo implements Serializable {
    private String userId;
    private String userIdentity;
    private String userToken;

    public QrLoginUserInfo(String str, String str2, String str3) {
        i.g(str, "userId");
        i.g(str2, "userIdentity");
        i.g(str3, "userToken");
        this.userId = str;
        this.userIdentity = str2;
        this.userToken = str3;
    }

    public static /* synthetic */ QrLoginUserInfo copy$default(QrLoginUserInfo qrLoginUserInfo, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = qrLoginUserInfo.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = qrLoginUserInfo.userIdentity;
        }
        if ((i10 & 4) != 0) {
            str3 = qrLoginUserInfo.userToken;
        }
        return qrLoginUserInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userIdentity;
    }

    public final String component3() {
        return this.userToken;
    }

    public final QrLoginUserInfo copy(String str, String str2, String str3) {
        i.g(str, "userId");
        i.g(str2, "userIdentity");
        i.g(str3, "userToken");
        return new QrLoginUserInfo(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QrLoginUserInfo)) {
            return false;
        }
        QrLoginUserInfo qrLoginUserInfo = (QrLoginUserInfo) obj;
        return i.b(this.userId, qrLoginUserInfo.userId) && i.b(this.userIdentity, qrLoginUserInfo.userIdentity) && i.b(this.userToken, qrLoginUserInfo.userToken);
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserIdentity() {
        return this.userIdentity;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((this.userId.hashCode() * 31) + this.userIdentity.hashCode()) * 31) + this.userToken.hashCode();
    }

    public final void setUserId(String str) {
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public final void setUserIdentity(String str) {
        i.g(str, "<set-?>");
        this.userIdentity = str;
    }

    public final void setUserToken(String str) {
        i.g(str, "<set-?>");
        this.userToken = str;
    }

    public String toString() {
        return "QrLoginUserInfo(userId=" + this.userId + ", userIdentity=" + this.userIdentity + ", userToken=" + this.userToken + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
