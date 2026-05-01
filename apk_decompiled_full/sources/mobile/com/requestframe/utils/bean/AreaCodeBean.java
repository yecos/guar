package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class AreaCodeBean {
    private String userId;
    private String userToken;

    public AreaCodeBean(String str, String str2) {
        i.g(str, "userToken");
        this.userToken = str;
        this.userId = str2;
    }

    public static /* synthetic */ AreaCodeBean copy$default(AreaCodeBean areaCodeBean, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = areaCodeBean.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = areaCodeBean.userId;
        }
        return areaCodeBean.copy(str, str2);
    }

    public final String component1() {
        return this.userToken;
    }

    public final String component2() {
        return this.userId;
    }

    public final AreaCodeBean copy(String str, String str2) {
        i.g(str, "userToken");
        return new AreaCodeBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AreaCodeBean)) {
            return false;
        }
        AreaCodeBean areaCodeBean = (AreaCodeBean) obj;
        return i.b(this.userToken, areaCodeBean.userToken) && i.b(this.userId, areaCodeBean.userId);
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        int hashCode = this.userToken.hashCode() * 31;
        String str = this.userId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final void setUserToken(String str) {
        i.g(str, "<set-?>");
        this.userToken = str;
    }

    public String toString() {
        return "AreaCodeBean(userToken=" + this.userToken + ", userId=" + this.userId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
