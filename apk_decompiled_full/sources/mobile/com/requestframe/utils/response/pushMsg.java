package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class pushMsg {
    private String avaliableCoin;
    private String messageType;
    private String minCoin;
    private String orderId;
    private String text;
    private String title;
    private String type;
    private String url;
    private String userId;

    public pushMsg(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.messageType = str;
        this.type = str2;
        this.userId = str3;
        this.title = str4;
        this.text = str5;
        this.orderId = str6;
        this.url = str7;
        this.avaliableCoin = str8;
        this.minCoin = str9;
    }

    public final String component1() {
        return this.messageType;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.userId;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.text;
    }

    public final String component6() {
        return this.orderId;
    }

    public final String component7() {
        return this.url;
    }

    public final String component8() {
        return this.avaliableCoin;
    }

    public final String component9() {
        return this.minCoin;
    }

    public final pushMsg copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        return new pushMsg(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pushMsg)) {
            return false;
        }
        pushMsg pushmsg = (pushMsg) obj;
        return i.b(this.messageType, pushmsg.messageType) && i.b(this.type, pushmsg.type) && i.b(this.userId, pushmsg.userId) && i.b(this.title, pushmsg.title) && i.b(this.text, pushmsg.text) && i.b(this.orderId, pushmsg.orderId) && i.b(this.url, pushmsg.url) && i.b(this.avaliableCoin, pushmsg.avaliableCoin) && i.b(this.minCoin, pushmsg.minCoin);
    }

    public final String getAvaliableCoin() {
        return this.avaliableCoin;
    }

    public final String getMessageType() {
        return this.messageType;
    }

    public final String getMinCoin() {
        return this.minCoin;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.messageType;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.title;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.text;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.orderId;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.url;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.avaliableCoin;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.minCoin;
        return hashCode8 + (str9 != null ? str9.hashCode() : 0);
    }

    public final void setAvaliableCoin(String str) {
        this.avaliableCoin = str;
    }

    public final void setMessageType(String str) {
        this.messageType = str;
    }

    public final void setMinCoin(String str) {
        this.minCoin = str;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "pushMsg(messageType=" + this.messageType + ", type=" + this.type + ", userId=" + this.userId + ", title=" + this.title + ", text=" + this.text + ", orderId=" + this.orderId + ", url=" + this.url + ", avaliableCoin=" + this.avaliableCoin + ", minCoin=" + this.minCoin + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
