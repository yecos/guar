package mobile.com.requestframe.utils.bean;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class MsgBoxParams {
    private String messageType;
    private int pageNum;
    private int pageSize;
    private String token;
    private String userId;

    public MsgBoxParams(String str, int i10, int i11, String str2, String str3) {
        i.g(str, "userId");
        i.g(str2, "messageType");
        i.g(str3, ParamsMap.DeviceParams.KEY_AUTH_TOKEN);
        this.userId = str;
        this.pageSize = i10;
        this.pageNum = i11;
        this.messageType = str2;
        this.token = str3;
    }

    public static /* synthetic */ MsgBoxParams copy$default(MsgBoxParams msgBoxParams, String str, int i10, int i11, String str2, String str3, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = msgBoxParams.userId;
        }
        if ((i12 & 2) != 0) {
            i10 = msgBoxParams.pageSize;
        }
        int i13 = i10;
        if ((i12 & 4) != 0) {
            i11 = msgBoxParams.pageNum;
        }
        int i14 = i11;
        if ((i12 & 8) != 0) {
            str2 = msgBoxParams.messageType;
        }
        String str4 = str2;
        if ((i12 & 16) != 0) {
            str3 = msgBoxParams.token;
        }
        return msgBoxParams.copy(str, i13, i14, str4, str3);
    }

    public final String component1() {
        return this.userId;
    }

    public final int component2() {
        return this.pageSize;
    }

    public final int component3() {
        return this.pageNum;
    }

    public final String component4() {
        return this.messageType;
    }

    public final String component5() {
        return this.token;
    }

    public final MsgBoxParams copy(String str, int i10, int i11, String str2, String str3) {
        i.g(str, "userId");
        i.g(str2, "messageType");
        i.g(str3, ParamsMap.DeviceParams.KEY_AUTH_TOKEN);
        return new MsgBoxParams(str, i10, i11, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MsgBoxParams)) {
            return false;
        }
        MsgBoxParams msgBoxParams = (MsgBoxParams) obj;
        return i.b(this.userId, msgBoxParams.userId) && this.pageSize == msgBoxParams.pageSize && this.pageNum == msgBoxParams.pageNum && i.b(this.messageType, msgBoxParams.messageType) && i.b(this.token, msgBoxParams.token);
    }

    public final String getMessageType() {
        return this.messageType;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (((((((this.userId.hashCode() * 31) + this.pageSize) * 31) + this.pageNum) * 31) + this.messageType.hashCode()) * 31) + this.token.hashCode();
    }

    public final void setMessageType(String str) {
        i.g(str, "<set-?>");
        this.messageType = str;
    }

    public final void setPageNum(int i10) {
        this.pageNum = i10;
    }

    public final void setPageSize(int i10) {
        this.pageSize = i10;
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
        return "MsgBoxParams(userId=" + this.userId + ", pageSize=" + this.pageSize + ", pageNum=" + this.pageNum + ", messageType=" + this.messageType + ", token=" + this.token + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
