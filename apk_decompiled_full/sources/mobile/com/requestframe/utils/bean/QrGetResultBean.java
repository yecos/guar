package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class QrGetResultBean implements Serializable {
    private String qrtoken;
    private String type;

    public QrGetResultBean(String str, String str2) {
        i.g(str, "type");
        i.g(str2, "qrtoken");
        this.type = str;
        this.qrtoken = str2;
    }

    public static /* synthetic */ QrGetResultBean copy$default(QrGetResultBean qrGetResultBean, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = qrGetResultBean.type;
        }
        if ((i10 & 2) != 0) {
            str2 = qrGetResultBean.qrtoken;
        }
        return qrGetResultBean.copy(str, str2);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.qrtoken;
    }

    public final QrGetResultBean copy(String str, String str2) {
        i.g(str, "type");
        i.g(str2, "qrtoken");
        return new QrGetResultBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QrGetResultBean)) {
            return false;
        }
        QrGetResultBean qrGetResultBean = (QrGetResultBean) obj;
        return i.b(this.type, qrGetResultBean.type) && i.b(this.qrtoken, qrGetResultBean.qrtoken);
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
        return "QrGetResultBean(type=" + this.type + ", qrtoken=" + this.qrtoken + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
