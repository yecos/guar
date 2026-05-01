package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class Msg {
    private String appId;
    private pushMsg content;
    private String createTime;
    private String messageId;
    private String messageType;
    private Integer status;
    private String type;
    private String updateTime;
    private String userId;

    public Msg(String str, String str2, String str3, String str4, String str5, pushMsg pushmsg, Integer num, String str6, String str7) {
        this.userId = str;
        this.messageId = str2;
        this.messageType = str3;
        this.type = str4;
        this.appId = str5;
        this.content = pushmsg;
        this.status = num;
        this.createTime = str6;
        this.updateTime = str7;
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
        return this.type;
    }

    public final String component5() {
        return this.appId;
    }

    public final pushMsg component6() {
        return this.content;
    }

    public final Integer component7() {
        return this.status;
    }

    public final String component8() {
        return this.createTime;
    }

    public final String component9() {
        return this.updateTime;
    }

    public final Msg copy(String str, String str2, String str3, String str4, String str5, pushMsg pushmsg, Integer num, String str6, String str7) {
        return new Msg(str, str2, str3, str4, str5, pushmsg, num, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Msg)) {
            return false;
        }
        Msg msg = (Msg) obj;
        return i.b(this.userId, msg.userId) && i.b(this.messageId, msg.messageId) && i.b(this.messageType, msg.messageType) && i.b(this.type, msg.type) && i.b(this.appId, msg.appId) && i.b(this.content, msg.content) && i.b(this.status, msg.status) && i.b(this.createTime, msg.createTime) && i.b(this.updateTime, msg.updateTime);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final pushMsg getContent() {
        return this.content;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getMessageType() {
        return this.messageType;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.userId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.messageId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.messageType;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.type;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.appId;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        pushMsg pushmsg = this.content;
        int hashCode6 = (hashCode5 + (pushmsg == null ? 0 : pushmsg.hashCode())) * 31;
        Integer num = this.status;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str6 = this.createTime;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.updateTime;
        return hashCode8 + (str7 != null ? str7.hashCode() : 0);
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final void setContent(pushMsg pushmsg) {
        this.content = pushmsg;
    }

    public final void setCreateTime(String str) {
        this.createTime = str;
    }

    public final void setMessageId(String str) {
        this.messageId = str;
    }

    public final void setMessageType(String str) {
        this.messageType = str;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "Msg(userId=" + this.userId + ", messageId=" + this.messageId + ", messageType=" + this.messageType + ", type=" + this.type + ", appId=" + this.appId + ", content=" + this.content + ", status=" + this.status + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
