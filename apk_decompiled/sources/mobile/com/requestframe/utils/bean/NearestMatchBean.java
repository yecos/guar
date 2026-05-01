package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class NearestMatchBean {
    private int pageSize;
    private String portalCode;
    private String userId;
    private String userToken;

    public NearestMatchBean(String str, String str2, String str3, int i10) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        this.userToken = str;
        this.userId = str2;
        this.portalCode = str3;
        this.pageSize = i10;
    }

    public static /* synthetic */ NearestMatchBean copy$default(NearestMatchBean nearestMatchBean, String str, String str2, String str3, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = nearestMatchBean.userToken;
        }
        if ((i11 & 2) != 0) {
            str2 = nearestMatchBean.userId;
        }
        if ((i11 & 4) != 0) {
            str3 = nearestMatchBean.portalCode;
        }
        if ((i11 & 8) != 0) {
            i10 = nearestMatchBean.pageSize;
        }
        return nearestMatchBean.copy(str, str2, str3, i10);
    }

    public final String component1() {
        return this.userToken;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.portalCode;
    }

    public final int component4() {
        return this.pageSize;
    }

    public final NearestMatchBean copy(String str, String str2, String str3, int i10) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "portalCode");
        return new NearestMatchBean(str, str2, str3, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearestMatchBean)) {
            return false;
        }
        NearestMatchBean nearestMatchBean = (NearestMatchBean) obj;
        return i.b(this.userToken, nearestMatchBean.userToken) && i.b(this.userId, nearestMatchBean.userId) && i.b(this.portalCode, nearestMatchBean.portalCode) && this.pageSize == nearestMatchBean.pageSize;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final String getPortalCode() {
        return this.portalCode;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.portalCode.hashCode()) * 31) + this.pageSize;
    }

    public final void setPageSize(int i10) {
        this.pageSize = i10;
    }

    public final void setPortalCode(String str) {
        i.g(str, "<set-?>");
        this.portalCode = str;
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
        return "NearestMatchBean(userToken=" + this.userToken + ", userId=" + this.userId + ", portalCode=" + this.portalCode + ", pageSize=" + this.pageSize + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
