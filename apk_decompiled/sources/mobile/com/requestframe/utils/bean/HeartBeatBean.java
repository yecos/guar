package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class HeartBeatBean {
    private String macAddr;
    private String userId;
    private String userToken;

    public HeartBeatBean(String str, String str2, String str3) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "macAddr");
        this.userToken = str;
        this.userId = str2;
        this.macAddr = str3;
    }

    public static /* synthetic */ HeartBeatBean copy$default(HeartBeatBean heartBeatBean, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = heartBeatBean.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = heartBeatBean.userId;
        }
        if ((i10 & 4) != 0) {
            str3 = heartBeatBean.macAddr;
        }
        return heartBeatBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.userToken;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.macAddr;
    }

    public final HeartBeatBean copy(String str, String str2, String str3) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "macAddr");
        return new HeartBeatBean(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeartBeatBean)) {
            return false;
        }
        HeartBeatBean heartBeatBean = (HeartBeatBean) obj;
        return i.b(this.userToken, heartBeatBean.userToken) && i.b(this.userId, heartBeatBean.userId) && i.b(this.macAddr, heartBeatBean.macAddr);
    }

    public final String getMacAddr() {
        return this.macAddr;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.macAddr.hashCode();
    }

    public final void setMacAddr(String str) {
        i.g(str, "<set-?>");
        this.macAddr = str;
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
        return "HeartBeatBean(userToken=" + this.userToken + ", userId=" + this.userId + ", macAddr=" + this.macAddr + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
