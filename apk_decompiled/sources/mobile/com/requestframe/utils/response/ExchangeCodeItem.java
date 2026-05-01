package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.common.global.Constant;
import t9.i;

/* loaded from: classes3.dex */
public final class ExchangeCodeItem {
    private int authDay;
    private String batchDesc;
    private String effectTime;
    private String exchangeCode;
    private String invalidTime;
    private String recordDate;
    private String status;
    private String type;

    public ExchangeCodeItem(String str, String str2, String str3, String str4, String str5, int i10, String str6, String str7) {
        i.g(str, "exchangeCode");
        i.g(str3, "recordDate");
        i.g(str5, "type");
        i.g(str6, Constant.KEY_STATUS);
        this.exchangeCode = str;
        this.effectTime = str2;
        this.recordDate = str3;
        this.invalidTime = str4;
        this.type = str5;
        this.authDay = i10;
        this.status = str6;
        this.batchDesc = str7;
    }

    public final String component1() {
        return this.exchangeCode;
    }

    public final String component2() {
        return this.effectTime;
    }

    public final String component3() {
        return this.recordDate;
    }

    public final String component4() {
        return this.invalidTime;
    }

    public final String component5() {
        return this.type;
    }

    public final int component6() {
        return this.authDay;
    }

    public final String component7() {
        return this.status;
    }

    public final String component8() {
        return this.batchDesc;
    }

    public final ExchangeCodeItem copy(String str, String str2, String str3, String str4, String str5, int i10, String str6, String str7) {
        i.g(str, "exchangeCode");
        i.g(str3, "recordDate");
        i.g(str5, "type");
        i.g(str6, Constant.KEY_STATUS);
        return new ExchangeCodeItem(str, str2, str3, str4, str5, i10, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExchangeCodeItem)) {
            return false;
        }
        ExchangeCodeItem exchangeCodeItem = (ExchangeCodeItem) obj;
        return i.b(this.exchangeCode, exchangeCodeItem.exchangeCode) && i.b(this.effectTime, exchangeCodeItem.effectTime) && i.b(this.recordDate, exchangeCodeItem.recordDate) && i.b(this.invalidTime, exchangeCodeItem.invalidTime) && i.b(this.type, exchangeCodeItem.type) && this.authDay == exchangeCodeItem.authDay && i.b(this.status, exchangeCodeItem.status) && i.b(this.batchDesc, exchangeCodeItem.batchDesc);
    }

    public final int getAuthDay() {
        return this.authDay;
    }

    public final String getBatchDesc() {
        return this.batchDesc;
    }

    public final String getEffectTime() {
        return this.effectTime;
    }

    public final String getExchangeCode() {
        return this.exchangeCode;
    }

    public final String getInvalidTime() {
        return this.invalidTime;
    }

    public final String getRecordDate() {
        return this.recordDate;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.exchangeCode.hashCode() * 31;
        String str = this.effectTime;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.recordDate.hashCode()) * 31;
        String str2 = this.invalidTime;
        int hashCode3 = (((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.type.hashCode()) * 31) + this.authDay) * 31) + this.status.hashCode()) * 31;
        String str3 = this.batchDesc;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setAuthDay(int i10) {
        this.authDay = i10;
    }

    public final void setBatchDesc(String str) {
        this.batchDesc = str;
    }

    public final void setEffectTime(String str) {
        this.effectTime = str;
    }

    public final void setExchangeCode(String str) {
        i.g(str, "<set-?>");
        this.exchangeCode = str;
    }

    public final void setInvalidTime(String str) {
        this.invalidTime = str;
    }

    public final void setRecordDate(String str) {
        i.g(str, "<set-?>");
        this.recordDate = str;
    }

    public final void setStatus(String str) {
        i.g(str, "<set-?>");
        this.status = str;
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
    }

    public String toString() {
        return "ExchangeCodeItem(exchangeCode=" + this.exchangeCode + ", effectTime=" + this.effectTime + ", recordDate=" + this.recordDate + ", invalidTime=" + this.invalidTime + ", type=" + this.type + ", authDay=" + this.authDay + ", status=" + this.status + ", batchDesc=" + this.batchDesc + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
