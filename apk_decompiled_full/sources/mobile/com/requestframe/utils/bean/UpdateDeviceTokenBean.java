package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class UpdateDeviceTokenBean {
    private String createTime;
    private Integer id;
    private Integer state;
    private String updateTime;
    private String userId;
    private String userToken;

    public UpdateDeviceTokenBean(Integer num, String str, String str2, Integer num2, String str3, String str4) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        this.id = num;
        this.userId = str;
        this.userToken = str2;
        this.state = num2;
        this.createTime = str3;
        this.updateTime = str4;
    }

    public static /* synthetic */ UpdateDeviceTokenBean copy$default(UpdateDeviceTokenBean updateDeviceTokenBean, Integer num, String str, String str2, Integer num2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = updateDeviceTokenBean.id;
        }
        if ((i10 & 2) != 0) {
            str = updateDeviceTokenBean.userId;
        }
        String str5 = str;
        if ((i10 & 4) != 0) {
            str2 = updateDeviceTokenBean.userToken;
        }
        String str6 = str2;
        if ((i10 & 8) != 0) {
            num2 = updateDeviceTokenBean.state;
        }
        Integer num3 = num2;
        if ((i10 & 16) != 0) {
            str3 = updateDeviceTokenBean.createTime;
        }
        String str7 = str3;
        if ((i10 & 32) != 0) {
            str4 = updateDeviceTokenBean.updateTime;
        }
        return updateDeviceTokenBean.copy(num, str5, str6, num3, str7, str4);
    }

    public final Integer component1() {
        return this.id;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.userToken;
    }

    public final Integer component4() {
        return this.state;
    }

    public final String component5() {
        return this.createTime;
    }

    public final String component6() {
        return this.updateTime;
    }

    public final UpdateDeviceTokenBean copy(Integer num, String str, String str2, Integer num2, String str3, String str4) {
        i.g(str, "userId");
        i.g(str2, "userToken");
        return new UpdateDeviceTokenBean(num, str, str2, num2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateDeviceTokenBean)) {
            return false;
        }
        UpdateDeviceTokenBean updateDeviceTokenBean = (UpdateDeviceTokenBean) obj;
        return i.b(this.id, updateDeviceTokenBean.id) && i.b(this.userId, updateDeviceTokenBean.userId) && i.b(this.userToken, updateDeviceTokenBean.userToken) && i.b(this.state, updateDeviceTokenBean.state) && i.b(this.createTime, updateDeviceTokenBean.createTime) && i.b(this.updateTime, updateDeviceTokenBean.updateTime);
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final Integer getId() {
        return this.id;
    }

    public final Integer getState() {
        return this.state;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (((((num == null ? 0 : num.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.userToken.hashCode()) * 31;
        Integer num2 = this.state;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.createTime;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.updateTime;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setCreateTime(String str) {
        this.createTime = str;
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    public final void setState(Integer num) {
        this.state = num;
    }

    public final void setUpdateTime(String str) {
        this.updateTime = str;
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
        return "UpdateDeviceTokenBean(id=" + this.id + ", userId=" + this.userId + ", userToken=" + this.userToken + ", state=" + this.state + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public /* synthetic */ UpdateDeviceTokenBean(Integer num, String str, String str2, Integer num2, String str3, String str4, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : num, str, str2, (i10 & 8) != 0 ? null : num2, (i10 & 16) != 0 ? null : str3, (i10 & 32) != 0 ? null : str4);
    }
}
