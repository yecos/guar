package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class GetAddrBean {
    private String authCode;
    private String authVersion;
    private String reserve1;
    private String sn;
    private int type;

    public GetAddrBean(String str, int i10, String str2, String str3, String str4) {
        i.g(str, "sn");
        i.g(str2, "authCode");
        i.g(str3, "authVersion");
        i.g(str4, "reserve1");
        this.sn = str;
        this.type = i10;
        this.authCode = str2;
        this.authVersion = str3;
        this.reserve1 = str4;
    }

    public static /* synthetic */ GetAddrBean copy$default(GetAddrBean getAddrBean, String str, int i10, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = getAddrBean.sn;
        }
        if ((i11 & 2) != 0) {
            i10 = getAddrBean.type;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            str2 = getAddrBean.authCode;
        }
        String str5 = str2;
        if ((i11 & 8) != 0) {
            str3 = getAddrBean.authVersion;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            str4 = getAddrBean.reserve1;
        }
        return getAddrBean.copy(str, i12, str5, str6, str4);
    }

    public final String component1() {
        return this.sn;
    }

    public final int component2() {
        return this.type;
    }

    public final String component3() {
        return this.authCode;
    }

    public final String component4() {
        return this.authVersion;
    }

    public final String component5() {
        return this.reserve1;
    }

    public final GetAddrBean copy(String str, int i10, String str2, String str3, String str4) {
        i.g(str, "sn");
        i.g(str2, "authCode");
        i.g(str3, "authVersion");
        i.g(str4, "reserve1");
        return new GetAddrBean(str, i10, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAddrBean)) {
            return false;
        }
        GetAddrBean getAddrBean = (GetAddrBean) obj;
        return i.b(this.sn, getAddrBean.sn) && this.type == getAddrBean.type && i.b(this.authCode, getAddrBean.authCode) && i.b(this.authVersion, getAddrBean.authVersion) && i.b(this.reserve1, getAddrBean.reserve1);
    }

    public final String getAuthCode() {
        return this.authCode;
    }

    public final String getAuthVersion() {
        return this.authVersion;
    }

    public final String getReserve1() {
        return this.reserve1;
    }

    public final String getSn() {
        return this.sn;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((this.sn.hashCode() * 31) + this.type) * 31) + this.authCode.hashCode()) * 31) + this.authVersion.hashCode()) * 31) + this.reserve1.hashCode();
    }

    public final void setAuthCode(String str) {
        i.g(str, "<set-?>");
        this.authCode = str;
    }

    public final void setAuthVersion(String str) {
        i.g(str, "<set-?>");
        this.authVersion = str;
    }

    public final void setReserve1(String str) {
        i.g(str, "<set-?>");
        this.reserve1 = str;
    }

    public final void setSn(String str) {
        i.g(str, "<set-?>");
        this.sn = str;
    }

    public final void setType(int i10) {
        this.type = i10;
    }

    public String toString() {
        return "GetAddrBean(sn=" + this.sn + ", type=" + this.type + ", authCode=" + this.authCode + ", authVersion=" + this.authVersion + ", reserve1=" + this.reserve1 + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public /* synthetic */ GetAddrBean(String str, int i10, String str2, String str3, String str4, int i11, g gVar) {
        this(str, i10, (i11 & 4) != 0 ? "" : str2, (i11 & 8) != 0 ? "" : str3, str4);
    }
}
