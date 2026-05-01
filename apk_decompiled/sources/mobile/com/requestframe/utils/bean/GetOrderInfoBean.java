package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetOrderInfoBean {
    private String userId;
    private String userToken;

    public GetOrderInfoBean(String str, String str2) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        this.userId = str;
        this.userToken = str2;
    }

    public static /* synthetic */ GetOrderInfoBean copy$default(GetOrderInfoBean getOrderInfoBean, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getOrderInfoBean.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = getOrderInfoBean.userToken;
        }
        return getOrderInfoBean.copy(str, str2);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userToken;
    }

    public final GetOrderInfoBean copy(String str, String str2) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        return new GetOrderInfoBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetOrderInfoBean)) {
            return false;
        }
        GetOrderInfoBean getOrderInfoBean = (GetOrderInfoBean) obj;
        return i.b(this.userId, getOrderInfoBean.userId) && i.b(this.userToken, getOrderInfoBean.userToken);
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
        return "GetOrderInfoBean(userId=" + this.userId + ", userToken=" + this.userToken + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
