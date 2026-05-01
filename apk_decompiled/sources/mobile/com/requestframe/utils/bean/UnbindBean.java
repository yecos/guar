package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class UnbindBean {
    private String password;
    private String thridPartName;
    private String type;
    private String userId;
    private String userToken;

    public UnbindBean(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "password");
        i.g(str2, "type");
        i.g(str3, "thridPartName");
        i.g(str4, "userToken");
        i.g(str5, "userId");
        this.password = str;
        this.type = str2;
        this.thridPartName = str3;
        this.userToken = str4;
        this.userId = str5;
    }

    public static /* synthetic */ UnbindBean copy$default(UnbindBean unbindBean, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = unbindBean.password;
        }
        if ((i10 & 2) != 0) {
            str2 = unbindBean.type;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = unbindBean.thridPartName;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = unbindBean.userToken;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = unbindBean.userId;
        }
        return unbindBean.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.password;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.thridPartName;
    }

    public final String component4() {
        return this.userToken;
    }

    public final String component5() {
        return this.userId;
    }

    public final UnbindBean copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "password");
        i.g(str2, "type");
        i.g(str3, "thridPartName");
        i.g(str4, "userToken");
        i.g(str5, "userId");
        return new UnbindBean(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnbindBean)) {
            return false;
        }
        UnbindBean unbindBean = (UnbindBean) obj;
        return i.b(this.password, unbindBean.password) && i.b(this.type, unbindBean.type) && i.b(this.thridPartName, unbindBean.thridPartName) && i.b(this.userToken, unbindBean.userToken) && i.b(this.userId, unbindBean.userId);
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getThridPartName() {
        return this.thridPartName;
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
        return (((((((this.password.hashCode() * 31) + this.type.hashCode()) * 31) + this.thridPartName.hashCode()) * 31) + this.userToken.hashCode()) * 31) + this.userId.hashCode();
    }

    public final void setPassword(String str) {
        i.g(str, "<set-?>");
        this.password = str;
    }

    public final void setThridPartName(String str) {
        i.g(str, "<set-?>");
        this.thridPartName = str;
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
        return "UnbindBean(password=" + this.password + ", type=" + this.type + ", thridPartName=" + this.thridPartName + ", userToken=" + this.userToken + ", userId=" + this.userId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
