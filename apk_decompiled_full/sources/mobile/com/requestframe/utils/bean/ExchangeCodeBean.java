package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class ExchangeCodeBean {
    private String loginType;
    private String userId;
    private String userToken;

    public ExchangeCodeBean(String str, String str2, String str3) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str3, "loginType");
        this.userId = str;
        this.userToken = str2;
        this.loginType = str3;
    }

    public static /* synthetic */ ExchangeCodeBean copy$default(ExchangeCodeBean exchangeCodeBean, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = exchangeCodeBean.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = exchangeCodeBean.userToken;
        }
        if ((i10 & 4) != 0) {
            str3 = exchangeCodeBean.loginType;
        }
        return exchangeCodeBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userToken;
    }

    public final String component3() {
        return this.loginType;
    }

    public final ExchangeCodeBean copy(String str, String str2, String str3) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str3, "loginType");
        return new ExchangeCodeBean(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExchangeCodeBean)) {
            return false;
        }
        ExchangeCodeBean exchangeCodeBean = (ExchangeCodeBean) obj;
        return i.b(this.userId, exchangeCodeBean.userId) && i.b(this.userToken, exchangeCodeBean.userToken) && i.b(this.loginType, exchangeCodeBean.loginType);
    }

    public final String getLoginType() {
        return this.loginType;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((this.userId.hashCode() * 31) + this.userToken.hashCode()) * 31) + this.loginType.hashCode();
    }

    public final void setLoginType(String str) {
        i.g(str, "<set-?>");
        this.loginType = str;
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
        return "ExchangeCodeBean(userId=" + this.userId + ", userToken=" + this.userToken + ", loginType=" + this.loginType + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public /* synthetic */ ExchangeCodeBean(String str, String str2, String str3, int i10, g gVar) {
        this(str, str2, (i10 & 4) != 0 ? "3" : str3);
    }
}
