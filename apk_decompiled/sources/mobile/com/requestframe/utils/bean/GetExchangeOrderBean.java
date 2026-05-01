package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetExchangeOrderBean {
    private String userId;
    private String userToken;

    public GetExchangeOrderBean(String str, String str2) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        this.userId = str;
        this.userToken = str2;
    }

    public static /* synthetic */ GetExchangeOrderBean copy$default(GetExchangeOrderBean getExchangeOrderBean, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getExchangeOrderBean.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = getExchangeOrderBean.userToken;
        }
        return getExchangeOrderBean.copy(str, str2);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userToken;
    }

    public final GetExchangeOrderBean copy(String str, String str2) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        return new GetExchangeOrderBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetExchangeOrderBean)) {
            return false;
        }
        GetExchangeOrderBean getExchangeOrderBean = (GetExchangeOrderBean) obj;
        return i.b(this.userId, getExchangeOrderBean.userId) && i.b(this.userToken, getExchangeOrderBean.userToken);
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
        return "GetExchangeOrderBean(userId=" + this.userId + ", userToken=" + this.userToken + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
