package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class LogoutBean {
    private String userId;
    private String userToken;

    public LogoutBean(String str, String str2) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        this.userId = str;
        this.userToken = str2;
    }

    public static /* synthetic */ LogoutBean copy$default(LogoutBean logoutBean, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = logoutBean.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = logoutBean.userToken;
        }
        return logoutBean.copy(str, str2);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userToken;
    }

    public final LogoutBean copy(String str, String str2) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        return new LogoutBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogoutBean)) {
            return false;
        }
        LogoutBean logoutBean = (LogoutBean) obj;
        return i.b(this.userId, logoutBean.userId) && i.b(this.userToken, logoutBean.userToken);
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
        return "LogoutBean(userId=" + this.userId + ", userToken=" + this.userToken + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
