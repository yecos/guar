package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetSubscriptionRecordBean {
    private String appId;
    private String userId;
    private String userToken;

    public GetSubscriptionRecordBean(String str, String str2, String str3) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str3, "appId");
        this.userId = str;
        this.userToken = str2;
        this.appId = str3;
    }

    public static /* synthetic */ GetSubscriptionRecordBean copy$default(GetSubscriptionRecordBean getSubscriptionRecordBean, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getSubscriptionRecordBean.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = getSubscriptionRecordBean.userToken;
        }
        if ((i10 & 4) != 0) {
            str3 = getSubscriptionRecordBean.appId;
        }
        return getSubscriptionRecordBean.copy(str, str2, str3);
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

    public final GetSubscriptionRecordBean copy(String str, String str2, String str3) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str3, "appId");
        return new GetSubscriptionRecordBean(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetSubscriptionRecordBean)) {
            return false;
        }
        GetSubscriptionRecordBean getSubscriptionRecordBean = (GetSubscriptionRecordBean) obj;
        return i.b(this.userId, getSubscriptionRecordBean.userId) && i.b(this.userToken, getSubscriptionRecordBean.userToken) && i.b(this.appId, getSubscriptionRecordBean.appId);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((this.userId.hashCode() * 31) + this.userToken.hashCode()) * 31) + this.appId.hashCode();
    }

    public final void setAppId(String str) {
        i.g(str, "<set-?>");
        this.appId = str;
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
        return "GetSubscriptionRecordBean(userId=" + this.userId + ", userToken=" + this.userToken + ", appId=" + this.appId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
