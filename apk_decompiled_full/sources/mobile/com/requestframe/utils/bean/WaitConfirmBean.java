package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class WaitConfirmBean {
    private String qrtoken;

    public WaitConfirmBean(String str) {
        i.g(str, "qrtoken");
        this.qrtoken = str;
    }

    public static /* synthetic */ WaitConfirmBean copy$default(WaitConfirmBean waitConfirmBean, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = waitConfirmBean.qrtoken;
        }
        return waitConfirmBean.copy(str);
    }

    public final String component1() {
        return this.qrtoken;
    }

    public final WaitConfirmBean copy(String str) {
        i.g(str, "qrtoken");
        return new WaitConfirmBean(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WaitConfirmBean) && i.b(this.qrtoken, ((WaitConfirmBean) obj).qrtoken);
    }

    public final String getQrtoken() {
        return this.qrtoken;
    }

    public int hashCode() {
        return this.qrtoken.hashCode();
    }

    public final void setQrtoken(String str) {
        i.g(str, "<set-?>");
        this.qrtoken = str;
    }

    public String toString() {
        return "WaitConfirmBean(qrtoken=" + this.qrtoken + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
