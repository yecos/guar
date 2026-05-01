package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetQrBean {
    private String qrtoken;
    private String type;

    public GetQrBean(String str, String str2) {
        i.g(str, "type");
        i.g(str2, "qrtoken");
        this.type = str;
        this.qrtoken = str2;
    }

    public static /* synthetic */ GetQrBean copy$default(GetQrBean getQrBean, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getQrBean.type;
        }
        if ((i10 & 2) != 0) {
            str2 = getQrBean.qrtoken;
        }
        return getQrBean.copy(str, str2);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.qrtoken;
    }

    public final GetQrBean copy(String str, String str2) {
        i.g(str, "type");
        i.g(str2, "qrtoken");
        return new GetQrBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetQrBean)) {
            return false;
        }
        GetQrBean getQrBean = (GetQrBean) obj;
        return i.b(this.type, getQrBean.type) && i.b(this.qrtoken, getQrBean.qrtoken);
    }

    public final String getQrtoken() {
        return this.qrtoken;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.qrtoken.hashCode();
    }

    public final void setQrtoken(String str) {
        i.g(str, "<set-?>");
        this.qrtoken = str;
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
    }

    public String toString() {
        return "GetQrBean(type=" + this.type + ", qrtoken=" + this.qrtoken + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
