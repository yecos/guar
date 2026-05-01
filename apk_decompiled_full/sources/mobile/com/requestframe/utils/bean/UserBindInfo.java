package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class UserBindInfo {
    private String userId;
    private String userToken;

    public UserBindInfo(String str, String str2) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        this.userId = str;
        this.userToken = str2;
    }

    public static /* synthetic */ UserBindInfo copy$default(UserBindInfo userBindInfo, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = userBindInfo.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = userBindInfo.userToken;
        }
        return userBindInfo.copy(str, str2);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userToken;
    }

    public final UserBindInfo copy(String str, String str2) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        return new UserBindInfo(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserBindInfo)) {
            return false;
        }
        UserBindInfo userBindInfo = (UserBindInfo) obj;
        return i.b(this.userId, userBindInfo.userId) && i.b(this.userToken, userBindInfo.userToken);
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (this.userId.hashCode() * 31) + this.userToken.hashCode();
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
        return "UserBindInfo(userId=" + this.userId + ", userToken=" + this.userToken + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
