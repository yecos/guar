package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetEmailBean {
    private String sn;

    public GetEmailBean(String str) {
        i.g(str, "sn");
        this.sn = str;
    }

    public static /* synthetic */ GetEmailBean copy$default(GetEmailBean getEmailBean, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getEmailBean.sn;
        }
        return getEmailBean.copy(str);
    }

    public final String component1() {
        return this.sn;
    }

    public final GetEmailBean copy(String str) {
        i.g(str, "sn");
        return new GetEmailBean(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetEmailBean) && i.b(this.sn, ((GetEmailBean) obj).sn);
    }

    public final String getSn() {
        return this.sn;
    }

    public int hashCode() {
        return this.sn.hashCode();
    }

    public final void setSn(String str) {
        i.g(str, "<set-?>");
        this.sn = str;
    }

    public String toString() {
        return "GetEmailBean(sn=" + this.sn + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
