package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class GetSubscriptionRecordData {
    private int authorizedDays;
    private String createTime;
    private String nextTriggerTime;
    private String packagePlanName;
    private int packageType;
    private String paymentCurrency;
    private int state;
    private String subscriptionNo;
    private String unitAmount;

    public GetSubscriptionRecordData(int i10, String str, String str2, String str3, int i11, String str4, int i12, String str5, String str6) {
        this.authorizedDays = i10;
        this.createTime = str;
        this.nextTriggerTime = str2;
        this.packagePlanName = str3;
        this.packageType = i11;
        this.paymentCurrency = str4;
        this.state = i12;
        this.subscriptionNo = str5;
        this.unitAmount = str6;
    }

    public final int component1() {
        return this.authorizedDays;
    }

    public final String component2() {
        return this.createTime;
    }

    public final String component3() {
        return this.nextTriggerTime;
    }

    public final String component4() {
        return this.packagePlanName;
    }

    public final int component5() {
        return this.packageType;
    }

    public final String component6() {
        return this.paymentCurrency;
    }

    public final int component7() {
        return this.state;
    }

    public final String component8() {
        return this.subscriptionNo;
    }

    public final String component9() {
        return this.unitAmount;
    }

    public final GetSubscriptionRecordData copy(int i10, String str, String str2, String str3, int i11, String str4, int i12, String str5, String str6) {
        return new GetSubscriptionRecordData(i10, str, str2, str3, i11, str4, i12, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetSubscriptionRecordData)) {
            return false;
        }
        GetSubscriptionRecordData getSubscriptionRecordData = (GetSubscriptionRecordData) obj;
        return this.authorizedDays == getSubscriptionRecordData.authorizedDays && i.b(this.createTime, getSubscriptionRecordData.createTime) && i.b(this.nextTriggerTime, getSubscriptionRecordData.nextTriggerTime) && i.b(this.packagePlanName, getSubscriptionRecordData.packagePlanName) && this.packageType == getSubscriptionRecordData.packageType && i.b(this.paymentCurrency, getSubscriptionRecordData.paymentCurrency) && this.state == getSubscriptionRecordData.state && i.b(this.subscriptionNo, getSubscriptionRecordData.subscriptionNo) && i.b(this.unitAmount, getSubscriptionRecordData.unitAmount);
    }

    public final int getAuthorizedDays() {
        return this.authorizedDays;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final String getNextTriggerTime() {
        return this.nextTriggerTime;
    }

    public final String getPackagePlanName() {
        return this.packagePlanName;
    }

    public final int getPackageType() {
        return this.packageType;
    }

    public final String getPaymentCurrency() {
        return this.paymentCurrency;
    }

    public final int getState() {
        return this.state;
    }

    public final String getSubscriptionNo() {
        return this.subscriptionNo;
    }

    public final String getUnitAmount() {
        return this.unitAmount;
    }

    public int hashCode() {
        int i10 = this.authorizedDays * 31;
        String str = this.createTime;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.nextTriggerTime;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.packagePlanName;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.packageType) * 31;
        String str4 = this.paymentCurrency;
        int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.state) * 31;
        String str5 = this.subscriptionNo;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.unitAmount;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setAuthorizedDays(int i10) {
        this.authorizedDays = i10;
    }

    public final void setCreateTime(String str) {
        this.createTime = str;
    }

    public final void setNextTriggerTime(String str) {
        this.nextTriggerTime = str;
    }

    public final void setPackagePlanName(String str) {
        this.packagePlanName = str;
    }

    public final void setPackageType(int i10) {
        this.packageType = i10;
    }

    public final void setPaymentCurrency(String str) {
        this.paymentCurrency = str;
    }

    public final void setState(int i10) {
        this.state = i10;
    }

    public final void setSubscriptionNo(String str) {
        this.subscriptionNo = str;
    }

    public final void setUnitAmount(String str) {
        this.unitAmount = str;
    }

    public String toString() {
        return "GetSubscriptionRecordData(authorizedDays=" + this.authorizedDays + ", createTime=" + this.createTime + ", nextTriggerTime=" + this.nextTriggerTime + ", packagePlanName=" + this.packagePlanName + ", packageType=" + this.packageType + ", paymentCurrency=" + this.paymentCurrency + ", state=" + this.state + ", subscriptionNo=" + this.subscriptionNo + ", unitAmount=" + this.unitAmount + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public /* synthetic */ GetSubscriptionRecordData(int i10, String str, String str2, String str3, int i11, String str4, int i12, String str5, String str6, int i13, g gVar) {
        this((i13 & 1) != 0 ? 0 : i10, str, str2, str3, i11, str4, i12, str5, str6);
    }
}
