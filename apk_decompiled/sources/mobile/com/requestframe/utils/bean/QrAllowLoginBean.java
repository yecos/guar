package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class QrAllowLoginBean implements Serializable {
    private String isAllow;
    private String qrtoken;
    private String type;
    private String userId;
    private String userToken;

    public QrAllowLoginBean(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "type");
        i.g(str2, "userToken");
        i.g(str3, "userId");
        i.g(str4, "qrtoken");
        i.g(str5, "isAllow");
        this.type = str;
        this.userToken = str2;
        this.userId = str3;
        this.qrtoken = str4;
        this.isAllow = str5;
    }

    public static /* synthetic */ QrAllowLoginBean copy$default(QrAllowLoginBean qrAllowLoginBean, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = qrAllowLoginBean.type;
        }
        if ((i10 & 2) != 0) {
            str2 = qrAllowLoginBean.userToken;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = qrAllowLoginBean.userId;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = qrAllowLoginBean.qrtoken;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = qrAllowLoginBean.isAllow;
        }
        return qrAllowLoginBean.copy(str, str6, str7, str8, str5);
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

    public final String component4() {
        return this.qrtoken;
    }

    public final String component5() {
        return this.isAllow;
    }

    public final QrAllowLoginBean copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "type");
        i.g(str2, "userToken");
        i.g(str3, "userId");
        i.g(str4, "qrtoken");
        i.g(str5, "isAllow");
        return new QrAllowLoginBean(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QrAllowLoginBean)) {
            return false;
        }
        QrAllowLoginBean qrAllowLoginBean = (QrAllowLoginBean) obj;
        return i.b(this.type, qrAllowLoginBean.type) && i.b(this.userToken, qrAllowLoginBean.userToken) && i.b(this.userId, qrAllowLoginBean.userId) && i.b(this.qrtoken, qrAllowLoginBean.qrtoken) && i.b(this.isAllow, qrAllowLoginBean.isAllow);
    }

    public final String getQrtoken() {
        return this.qrtoken;
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
        return (((((((this.type.hashCode() * 31) + this.userToken.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.qrtoken.hashCode()) * 31) + this.isAllow.hashCode();
    }

    public final String isAllow() {
        return this.isAllow;
    }

    public final void setAllow(String str) {
        i.g(str, "<set-?>");
        this.isAllow = str;
    }

    public final void setQrtoken(String str) {
        i.g(str, "<set-?>");
        this.qrtoken = str;
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
        return "QrAllowLoginBean(type=" + this.type + ", userToken=" + this.userToken + ", userId=" + this.userId + ", qrtoken=" + this.qrtoken + ", isAllow=" + this.isAllow + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
