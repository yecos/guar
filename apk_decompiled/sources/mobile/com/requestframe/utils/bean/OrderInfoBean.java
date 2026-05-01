package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class OrderInfoBean {
    private String orderId;
    private String userId;
    private String userToken;

    public OrderInfoBean(String str, String str2, String str3) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str3, "orderId");
        this.userId = str;
        this.userToken = str2;
        this.orderId = str3;
    }

    public static /* synthetic */ OrderInfoBean copy$default(OrderInfoBean orderInfoBean, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = orderInfoBean.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = orderInfoBean.userToken;
        }
        if ((i10 & 4) != 0) {
            str3 = orderInfoBean.orderId;
        }
        return orderInfoBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userToken;
    }

    public final String component3() {
        return this.orderId;
    }

    public final OrderInfoBean copy(String str, String str2, String str3) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str3, "orderId");
        return new OrderInfoBean(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderInfoBean)) {
            return false;
        }
        OrderInfoBean orderInfoBean = (OrderInfoBean) obj;
        return i.b(this.userId, orderInfoBean.userId) && i.b(this.userToken, orderInfoBean.userToken) && i.b(this.orderId, orderInfoBean.orderId);
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((this.userId.hashCode() * 31) + this.userToken.hashCode()) * 31) + this.orderId.hashCode();
    }

    public final void setOrderId(String str) {
        i.g(str, "<set-?>");
        this.orderId = str;
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
        return "OrderInfoBean(userId=" + this.userId + ", userToken=" + this.userToken + ", orderId=" + this.orderId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
