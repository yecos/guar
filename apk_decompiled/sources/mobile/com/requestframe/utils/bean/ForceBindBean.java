package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ForceBindBean {
    private String appId;
    private String sn;
    private String userId;
    private String userToken;

    public ForceBindBean(String str, String str2, String str3, String str4) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str3, "appId");
        i.g(str4, "sn");
        this.userId = str;
        this.userToken = str2;
        this.appId = str3;
        this.sn = str4;
    }

    public static /* synthetic */ ForceBindBean copy$default(ForceBindBean forceBindBean, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = forceBindBean.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = forceBindBean.userToken;
        }
        if ((i10 & 4) != 0) {
            str3 = forceBindBean.appId;
        }
        if ((i10 & 8) != 0) {
            str4 = forceBindBean.sn;
        }
        return forceBindBean.copy(str, str2, str3, str4);
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
        return this.sn;
    }

    public final ForceBindBean copy(String str, String str2, String str3, String str4) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        i.g(str3, "appId");
        i.g(str4, "sn");
        return new ForceBindBean(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ForceBindBean)) {
            return false;
        }
        ForceBindBean forceBindBean = (ForceBindBean) obj;
        return i.b(this.userId, forceBindBean.userId) && i.b(this.userToken, forceBindBean.userToken) && i.b(this.appId, forceBindBean.appId) && i.b(this.sn, forceBindBean.sn);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getSn() {
        return this.sn;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((((this.userId.hashCode() * 31) + this.userToken.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.sn.hashCode();
    }

    public final void setAppId(String str) {
        i.g(str, "<set-?>");
        this.appId = str;
    }

    public final void setSn(String str) {
        i.g(str, "<set-?>");
        this.sn = str;
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
        return "ForceBindBean(userId=" + this.userId + ", userToken=" + this.userToken + ", appId=" + this.appId + ", sn=" + this.sn + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
