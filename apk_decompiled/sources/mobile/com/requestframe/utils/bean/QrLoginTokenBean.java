package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class QrLoginTokenBean implements Serializable {
    private String type;
    private String userId;
    private String userToken;

    public QrLoginTokenBean(String str, String str2, String str3) {
        i.g(str, "type");
        i.g(str2, "userToken");
        i.g(str3, "userId");
        this.type = str;
        this.userToken = str2;
        this.userId = str3;
    }

    public static /* synthetic */ QrLoginTokenBean copy$default(QrLoginTokenBean qrLoginTokenBean, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = qrLoginTokenBean.type;
        }
        if ((i10 & 2) != 0) {
            str2 = qrLoginTokenBean.userToken;
        }
        if ((i10 & 4) != 0) {
            str3 = qrLoginTokenBean.userId;
        }
        return qrLoginTokenBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.userToken;
    }

    public final String component3() {
        return this.userId;
    }

    public final QrLoginTokenBean copy(String str, String str2, String str3) {
        i.g(str, "type");
        i.g(str2, "userToken");
        i.g(str3, "userId");
        return new QrLoginTokenBean(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QrLoginTokenBean)) {
            return false;
        }
        QrLoginTokenBean qrLoginTokenBean = (QrLoginTokenBean) obj;
        return i.b(this.type, qrLoginTokenBean.type) && i.b(this.userToken, qrLoginTokenBean.userToken) && i.b(this.userId, qrLoginTokenBean.userId);
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.userToken.hashCode()) * 31) + this.userId.hashCode();
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
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
        return "QrLoginTokenBean(type=" + this.type + ", userToken=" + this.userToken + ", userId=" + this.userId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
