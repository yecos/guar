package mobile.com.requestframe.utils.bean;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetDevicesBean {
    private final String token;
    private final String userId;

    public GetDevicesBean(String str, String str2) {
        i.g(str, ParamsMap.DeviceParams.KEY_AUTH_TOKEN);
        i.g(str2, "userId");
        this.token = str;
        this.userId = str2;
    }

    public static /* synthetic */ GetDevicesBean copy$default(GetDevicesBean getDevicesBean, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getDevicesBean.token;
        }
        if ((i10 & 2) != 0) {
            str2 = getDevicesBean.userId;
        }
        return getDevicesBean.copy(str, str2);
    }

    public final String component1() {
        return this.token;
    }

    public final String component2() {
        return this.userId;
    }

    public final GetDevicesBean copy(String str, String str2) {
        i.g(str, ParamsMap.DeviceParams.KEY_AUTH_TOKEN);
        i.g(str2, "userId");
        return new GetDevicesBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetDevicesBean)) {
            return false;
        }
        GetDevicesBean getDevicesBean = (GetDevicesBean) obj;
        return i.b(this.token, getDevicesBean.token) && i.b(this.userId, getDevicesBean.userId);
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (this.token.hashCode() * 31) + this.userId.hashCode();
    }

    public String toString() {
        return "GetDevicesBean(token=" + this.token + ", userId=" + this.userId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
