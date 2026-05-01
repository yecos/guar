package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class CancelSubscriptionBean {
    private String appId;
    private String subscriptionNo;
    private String userId;
    private String userToken;

    public CancelSubscriptionBean(String str, String str2, String str3, String str4) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str3, "appId");
        i.g(str4, "subscriptionNo");
        this.userId = str;
        this.userToken = str2;
        this.appId = str3;
        this.subscriptionNo = str4;
    }

    public static /* synthetic */ CancelSubscriptionBean copy$default(CancelSubscriptionBean cancelSubscriptionBean, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = cancelSubscriptionBean.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = cancelSubscriptionBean.userToken;
        }
        if ((i10 & 4) != 0) {
            str3 = cancelSubscriptionBean.appId;
        }
        if ((i10 & 8) != 0) {
            str4 = cancelSubscriptionBean.subscriptionNo;
        }
        return cancelSubscriptionBean.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userToken;
    }

    public final String component3() {
        return this.appId;
    }

    public final String component4() {
        return this.subscriptionNo;
    }

    public final CancelSubscriptionBean copy(String str, String str2, String str3, String str4) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str3, "appId");
        i.g(str4, "subscriptionNo");
        return new CancelSubscriptionBean(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CancelSubscriptionBean)) {
            return false;
        }
        CancelSubscriptionBean cancelSubscriptionBean = (CancelSubscriptionBean) obj;
        return i.b(this.userId, cancelSubscriptionBean.userId) && i.b(this.userToken, cancelSubscriptionBean.userToken) && i.b(this.appId, cancelSubscriptionBean.appId) && i.b(this.subscriptionNo, cancelSubscriptionBean.subscriptionNo);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getSubscriptionNo() {
        return this.subscriptionNo;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((((this.userId.hashCode() * 31) + this.userToken.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.subscriptionNo.hashCode();
    }

    public final void setAppId(String str) {
        i.g(str, "<set-?>");
        this.appId = str;
    }

    public final void setSubscriptionNo(String str) {
        i.g(str, "<set-?>");
        this.subscriptionNo = str;
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
        return "CancelSubscriptionBean(userId=" + this.userId + ", userToken=" + this.userToken + ", appId=" + this.appId + ", subscriptionNo=" + this.subscriptionNo + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
