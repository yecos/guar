package mobile.com.requestframe.utils.bean;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.common.global.Constant;
import t9.i;

/* loaded from: classes3.dex */
public final class ReadMsgParams {
    private String messageId;
    private String messageType;
    private String status;
    private String token;
    private String userId;

    public ReadMsgParams(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "userId");
        i.g(str2, "messageId");
        i.g(str3, "messageType");
        i.g(str4, Constant.KEY_STATUS);
        i.g(str5, ParamsMap.DeviceParams.KEY_AUTH_TOKEN);
        this.userId = str;
        this.messageId = str2;
        this.messageType = str3;
        this.status = str4;
        this.token = str5;
    }

    public static /* synthetic */ ReadMsgParams copy$default(ReadMsgParams readMsgParams, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = readMsgParams.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = readMsgParams.messageId;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = readMsgParams.messageType;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = readMsgParams.status;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = readMsgParams.token;
        }
        return readMsgParams.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.messageId;
    }

    public final String component3() {
        return this.messageType;
    }

    public final String component4() {
        return this.status;
    }

    public final String component5() {
        return this.token;
    }

    public final ReadMsgParams copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "userId");
        i.g(str2, "messageId");
        i.g(str3, "messageType");
        i.g(str4, Constant.KEY_STATUS);
        i.g(str5, ParamsMap.DeviceParams.KEY_AUTH_TOKEN);
        return new ReadMsgParams(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReadMsgParams)) {
            return false;
        }
        ReadMsgParams readMsgParams = (ReadMsgParams) obj;
        return i.b(this.userId, readMsgParams.userId) && i.b(this.messageId, readMsgParams.messageId) && i.b(this.messageType, readMsgParams.messageType) && i.b(this.status, readMsgParams.status) && i.b(this.token, readMsgParams.token);
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getMessageType() {
        return this.messageType;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (((((((this.userId.hashCode() * 31) + this.messageId.hashCode()) * 31) + this.messageType.hashCode()) * 31) + this.status.hashCode()) * 31) + this.token.hashCode();
    }

    public final void setMessageId(String str) {
        i.g(str, "<set-?>");
        this.messageId = str;
    }

    public final void setMessageType(String str) {
        i.g(str, "<set-?>");
        this.messageType = str;
    }

    public final void setStatus(String str) {
        i.g(str, "<set-?>");
        this.status = str;
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
        return "ReadMsgParams(userId=" + this.userId + ", messageId=" + this.messageId + ", messageType=" + this.messageType + ", status=" + this.status + ", token=" + this.token + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
