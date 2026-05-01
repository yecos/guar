package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ActiveBean {
    private String authCode;
    private String authVersion;
    private String channel;
    private String macAddr;
    private String snToken;

    public ActiveBean(String str, String str2, String str3, String str4, String str5) {
        i.g(str4, "macAddr");
        i.g(str5, "channel");
        this.snToken = str;
        this.authVersion = str2;
        this.authCode = str3;
        this.macAddr = str4;
        this.channel = str5;
    }

    public static /* synthetic */ ActiveBean copy$default(ActiveBean activeBean, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = activeBean.snToken;
        }
        if ((i10 & 2) != 0) {
            str2 = activeBean.authVersion;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = activeBean.authCode;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = activeBean.macAddr;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = activeBean.channel;
        }
        return activeBean.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.snToken;
    }

    public final String component2() {
        return this.authVersion;
    }

    public final String component3() {
        return this.authCode;
    }

    public final String component4() {
        return this.macAddr;
    }

    public final String component5() {
        return this.channel;
    }

    public final ActiveBean copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str4, "macAddr");
        i.g(str5, "channel");
        return new ActiveBean(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveBean)) {
            return false;
        }
        ActiveBean activeBean = (ActiveBean) obj;
        return i.b(this.snToken, activeBean.snToken) && i.b(this.authVersion, activeBean.authVersion) && i.b(this.authCode, activeBean.authCode) && i.b(this.macAddr, activeBean.macAddr) && i.b(this.channel, activeBean.channel);
    }

    public final String getAuthCode() {
        return this.authCode;
    }

    public final String getAuthVersion() {
        return this.authVersion;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getMacAddr() {
        return this.macAddr;
    }

    public final String getSnToken() {
        return this.snToken;
    }

    public int hashCode() {
        String str = this.snToken;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.authVersion;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.authCode;
        return ((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.macAddr.hashCode()) * 31) + this.channel.hashCode();
    }

    public final void setAuthCode(String str) {
        this.authCode = str;
    }

    public final void setAuthVersion(String str) {
        this.authVersion = str;
    }

    public final void setChannel(String str) {
        i.g(str, "<set-?>");
        this.channel = str;
    }

    public final void setMacAddr(String str) {
        i.g(str, "<set-?>");
        this.macAddr = str;
    }

    public final void setSnToken(String str) {
        this.snToken = str;
    }

    public String toString() {
        return "ActiveBean(snToken=" + this.snToken + ", authVersion=" + this.authVersion + ", authCode=" + this.authCode + ", macAddr=" + this.macAddr + ", channel=" + this.channel + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
