package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GiftDaysBean {
    private String userId;
    private String userToken;

    public GiftDaysBean(String str, String str2) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        this.userToken = str;
        this.userId = str2;
    }

    public static /* synthetic */ GiftDaysBean copy$default(GiftDaysBean giftDaysBean, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = giftDaysBean.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = giftDaysBean.userId;
        }
        return giftDaysBean.copy(str, str2);
    }

    public final String component1() {
        return this.userToken;
    }

    public final String component2() {
        return this.userId;
    }

    public final GiftDaysBean copy(String str, String str2) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        return new GiftDaysBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiftDaysBean)) {
            return false;
        }
        GiftDaysBean giftDaysBean = (GiftDaysBean) obj;
        return i.b(this.userToken, giftDaysBean.userToken) && i.b(this.userId, giftDaysBean.userId);
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (this.userToken.hashCode() * 31) + this.userId.hashCode();
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
        return "GiftDaysBean(userToken=" + this.userToken + ", userId=" + this.userId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
