package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.common.global.Constant;
import t9.i;

/* loaded from: classes3.dex */
public final class UpdateRestrictBean {
    private String password;
    private String status;
    private String userId;
    private String userToken;

    public UpdateRestrictBean(String str, String str2, String str3, String str4) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str4, Constant.KEY_STATUS);
        this.userToken = str;
        this.userId = str2;
        this.password = str3;
        this.status = str4;
    }

    public static /* synthetic */ UpdateRestrictBean copy$default(UpdateRestrictBean updateRestrictBean, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = updateRestrictBean.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = updateRestrictBean.userId;
        }
        if ((i10 & 4) != 0) {
            str3 = updateRestrictBean.password;
        }
        if ((i10 & 8) != 0) {
            str4 = updateRestrictBean.status;
        }
        return updateRestrictBean.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.userToken;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.password;
    }

    public final String component4() {
        return this.status;
    }

    public final UpdateRestrictBean copy(String str, String str2, String str3, String str4) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str4, Constant.KEY_STATUS);
        return new UpdateRestrictBean(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateRestrictBean)) {
            return false;
        }
        UpdateRestrictBean updateRestrictBean = (UpdateRestrictBean) obj;
        return i.b(this.userToken, updateRestrictBean.userToken) && i.b(this.userId, updateRestrictBean.userId) && i.b(this.password, updateRestrictBean.password) && i.b(this.status, updateRestrictBean.status);
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        int hashCode = ((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31;
        String str = this.password;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.status.hashCode();
    }

    public final void setPassword(String str) {
        this.password = str;
    }

    public final void setStatus(String str) {
        i.g(str, "<set-?>");
        this.status = str;
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
        return "UpdateRestrictBean(userToken=" + this.userToken + ", userId=" + this.userId + ", password=" + this.password + ", status=" + this.status + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
