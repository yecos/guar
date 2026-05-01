package mobile.com.requestframe.util;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class RemoteLoginAndMsgEvent {
    private final String loginCity;
    private final String loginCountry;
    private final String loginIp;
    private final String loginTime;

    public RemoteLoginAndMsgEvent(String str, String str2, String str3, String str4) {
        this.loginIp = str;
        this.loginTime = str2;
        this.loginCountry = str3;
        this.loginCity = str4;
    }

    public static /* synthetic */ RemoteLoginAndMsgEvent copy$default(RemoteLoginAndMsgEvent remoteLoginAndMsgEvent, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = remoteLoginAndMsgEvent.loginIp;
        }
        if ((i10 & 2) != 0) {
            str2 = remoteLoginAndMsgEvent.loginTime;
        }
        if ((i10 & 4) != 0) {
            str3 = remoteLoginAndMsgEvent.loginCountry;
        }
        if ((i10 & 8) != 0) {
            str4 = remoteLoginAndMsgEvent.loginCity;
        }
        return remoteLoginAndMsgEvent.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.loginIp;
    }

    public final String component2() {
        return this.loginTime;
    }

    public final String component3() {
        return this.loginCountry;
    }

    public final String component4() {
        return this.loginCity;
    }

    public final RemoteLoginAndMsgEvent copy(String str, String str2, String str3, String str4) {
        return new RemoteLoginAndMsgEvent(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteLoginAndMsgEvent)) {
            return false;
        }
        RemoteLoginAndMsgEvent remoteLoginAndMsgEvent = (RemoteLoginAndMsgEvent) obj;
        return i.b(this.loginIp, remoteLoginAndMsgEvent.loginIp) && i.b(this.loginTime, remoteLoginAndMsgEvent.loginTime) && i.b(this.loginCountry, remoteLoginAndMsgEvent.loginCountry) && i.b(this.loginCity, remoteLoginAndMsgEvent.loginCity);
    }

    public final String getLoginCity() {
        return this.loginCity;
    }

    public final String getLoginCountry() {
        return this.loginCountry;
    }

    public final String getLoginIp() {
        return this.loginIp;
    }

    public final String getLoginTime() {
        return this.loginTime;
    }

    public int hashCode() {
        String str = this.loginIp;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.loginTime;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.loginCountry;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.loginCity;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "RemoteLoginAndMsgEvent(loginIp=" + this.loginIp + ", loginTime=" + this.loginTime + ", loginCountry=" + this.loginCountry + ", loginCity=" + this.loginCity + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
