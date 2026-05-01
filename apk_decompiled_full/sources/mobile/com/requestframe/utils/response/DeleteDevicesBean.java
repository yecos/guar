package mobile.com.requestframe.utils.response;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class DeleteDevicesBean {
    private final List<String> delList;
    private final String token;
    private final String userId;

    public DeleteDevicesBean(List<String> list, String str, String str2) {
        i.g(list, "delList");
        i.g(str, ParamsMap.DeviceParams.KEY_AUTH_TOKEN);
        i.g(str2, "userId");
        this.delList = list;
        this.token = str;
        this.userId = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeleteDevicesBean copy$default(DeleteDevicesBean deleteDevicesBean, List list, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = deleteDevicesBean.delList;
        }
        if ((i10 & 2) != 0) {
            str = deleteDevicesBean.token;
        }
        if ((i10 & 4) != 0) {
            str2 = deleteDevicesBean.userId;
        }
        return deleteDevicesBean.copy(list, str, str2);
    }

    public final List<String> component1() {
        return this.delList;
    }

    public final String component2() {
        return this.token;
    }

    public final String component3() {
        return this.userId;
    }

    public final DeleteDevicesBean copy(List<String> list, String str, String str2) {
        i.g(list, "delList");
        i.g(str, ParamsMap.DeviceParams.KEY_AUTH_TOKEN);
        i.g(str2, "userId");
        return new DeleteDevicesBean(list, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteDevicesBean)) {
            return false;
        }
        DeleteDevicesBean deleteDevicesBean = (DeleteDevicesBean) obj;
        return i.b(this.delList, deleteDevicesBean.delList) && i.b(this.token, deleteDevicesBean.token) && i.b(this.userId, deleteDevicesBean.userId);
    }

    public final List<String> getDelList() {
        return this.delList;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (((this.delList.hashCode() * 31) + this.token.hashCode()) * 31) + this.userId.hashCode();
    }

    public String toString() {
        return "DeleteDevicesBean(delList=" + this.delList + ", token=" + this.token + ", userId=" + this.userId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
