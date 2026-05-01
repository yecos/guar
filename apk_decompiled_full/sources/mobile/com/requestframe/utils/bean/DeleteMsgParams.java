package mobile.com.requestframe.utils.bean;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class DeleteMsgParams {
    private String messageType;
    private String token;
    private String userId;

    public DeleteMsgParams(String str, String str2, String str3) {
        i.g(str, "userId");
        i.g(str2, "messageType");
        i.g(str3, ParamsMap.DeviceParams.KEY_AUTH_TOKEN);
        this.userId = str;
        this.messageType = str2;
        this.token = str3;
    }

    public static /* synthetic */ DeleteMsgParams copy$default(DeleteMsgParams deleteMsgParams, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = deleteMsgParams.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = deleteMsgParams.messageType;
        }
        if ((i10 & 4) != 0) {
            str3 = deleteMsgParams.token;
        }
        return deleteMsgParams.copy(str, str2, str3);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.messageType;
    }

    public final String component3() {
        return this.token;
    }

    public final DeleteMsgParams copy(String str, String str2, String str3) {
        i.g(str, "userId");
        i.g(str2, "messageType");
        i.g(str3, ParamsMap.DeviceParams.KEY_AUTH_TOKEN);
        return new DeleteMsgParams(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteMsgParams)) {
            return false;
        }
        DeleteMsgParams deleteMsgParams = (DeleteMsgParams) obj;
        return i.b(this.userId, deleteMsgParams.userId) && i.b(this.messageType, deleteMsgParams.messageType) && i.b(this.token, deleteMsgParams.token);
    }

    public final String getMessageType() {
        return this.messageType;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (((this.userId.hashCode() * 31) + this.messageType.hashCode()) * 31) + this.token.hashCode();
    }

    public final void setMessageType(String str) {
        i.g(str, "<set-?>");
        this.messageType = str;
    }

    public final void setToken(String str) {
        i.g(str, "<set-?>");
        this.token = str;
    }

    public final void setUserId(String str) {
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public String toString() {
        return "DeleteMsgParams(userId=" + this.userId + ", messageType=" + this.messageType + ", token=" + this.token + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
