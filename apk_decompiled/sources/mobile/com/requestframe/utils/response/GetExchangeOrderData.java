package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import t9.i;

/* loaded from: classes3.dex */
public final class GetExchangeOrderData {
    private String createTime;
    private String exchangeCode;
    private int id;
    private String productName;
    private String updateTime;
    private String userId;
    private String usingTime;

    public GetExchangeOrderData(int i10, String str, String str2, String str3, String str4, String str5, String str6) {
        i.g(str, "exchangeCode");
        i.g(str2, "productName");
        i.g(str3, "userId");
        i.g(str4, "usingTime");
        i.g(str5, BrowserInfo.KEY_CREATE_TIME);
        i.g(str6, "updateTime");
        this.id = i10;
        this.exchangeCode = str;
        this.productName = str2;
        this.userId = str3;
        this.usingTime = str4;
        this.createTime = str5;
        this.updateTime = str6;
    }

    public static /* synthetic */ GetExchangeOrderData copy$default(GetExchangeOrderData getExchangeOrderData, int i10, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = getExchangeOrderData.id;
        }
        if ((i11 & 2) != 0) {
            str = getExchangeOrderData.exchangeCode;
        }
        String str7 = str;
        if ((i11 & 4) != 0) {
            str2 = getExchangeOrderData.productName;
        }
        String str8 = str2;
        if ((i11 & 8) != 0) {
            str3 = getExchangeOrderData.userId;
        }
        String str9 = str3;
        if ((i11 & 16) != 0) {
            str4 = getExchangeOrderData.usingTime;
        }
        String str10 = str4;
        if ((i11 & 32) != 0) {
            str5 = getExchangeOrderData.createTime;
        }
        String str11 = str5;
        if ((i11 & 64) != 0) {
            str6 = getExchangeOrderData.updateTime;
        }
        return getExchangeOrderData.copy(i10, str7, str8, str9, str10, str11, str6);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.exchangeCode;
    }

    public final String component3() {
        return this.productName;
    }

    public final String component4() {
        return this.userId;
    }

    public final String component5() {
        return this.usingTime;
    }

    public final String component6() {
        return this.createTime;
    }

    public final String component7() {
        return this.updateTime;
    }

    public final GetExchangeOrderData copy(int i10, String str, String str2, String str3, String str4, String str5, String str6) {
        i.g(str, "exchangeCode");
        i.g(str2, "productName");
        i.g(str3, "userId");
        i.g(str4, "usingTime");
        i.g(str5, BrowserInfo.KEY_CREATE_TIME);
        i.g(str6, "updateTime");
        return new GetExchangeOrderData(i10, str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetExchangeOrderData)) {
            return false;
        }
        GetExchangeOrderData getExchangeOrderData = (GetExchangeOrderData) obj;
        return this.id == getExchangeOrderData.id && i.b(this.exchangeCode, getExchangeOrderData.exchangeCode) && i.b(this.productName, getExchangeOrderData.productName) && i.b(this.userId, getExchangeOrderData.userId) && i.b(this.usingTime, getExchangeOrderData.usingTime) && i.b(this.createTime, getExchangeOrderData.createTime) && i.b(this.updateTime, getExchangeOrderData.updateTime);
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final String getExchangeCode() {
        return this.exchangeCode;
    }

    public final int getId() {
        return this.id;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUsingTime() {
        return this.usingTime;
    }

    public int hashCode() {
        return (((((((((((this.id * 31) + this.exchangeCode.hashCode()) * 31) + this.productName.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.usingTime.hashCode()) * 31) + this.createTime.hashCode()) * 31) + this.updateTime.hashCode();
    }

    public final void setCreateTime(String str) {
        i.g(str, "<set-?>");
        this.createTime = str;
    }

    public final void setExchangeCode(String str) {
        i.g(str, "<set-?>");
        this.exchangeCode = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setProductName(String str) {
        i.g(str, "<set-?>");
        this.productName = str;
    }

    public final void setUpdateTime(String str) {
        i.g(str, "<set-?>");
        this.updateTime = str;
    }

    public final void setUserId(String str) {
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public final void setUsingTime(String str) {
        i.g(str, "<set-?>");
        this.usingTime = str;
    }

    public String toString() {
        return "GetExchangeOrderData(id=" + this.id + ", exchangeCode=" + this.exchangeCode + ", productName=" + this.productName + ", userId=" + this.userId + ", usingTime=" + this.usingTime + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
