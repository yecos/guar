package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.component.protocol.push.IPushHandler;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import t9.i;

/* loaded from: classes3.dex */
public final class GetOrderInfoData {
    private int authorizedDays;
    private String createTime;
    private int id;
    private String invalidDate;
    private int isProcessing;
    private String orderId;
    private String packagePlanName;
    private int packageType;
    private String paymentAmount;
    private String paymentCurrency;
    private String paymentInfo;
    private String paymentPlatform;
    private String paymentTime;
    private String paymentType;
    private String redirectUrl;
    private int specialType;
    private String state;
    private String uploadUrl;

    public GetOrderInfoData(int i10, String str, int i11, String str2, int i12, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i13, int i14) {
        i.g(str, "orderId");
        i.g(str2, "packagePlanName");
        i.g(str3, "paymentAmount");
        i.g(str4, "paymentCurrency");
        i.g(str5, "paymentTime");
        i.g(str6, IPushHandler.STATE);
        i.g(str7, "paymentPlatform");
        i.g(str8, "paymentType");
        i.g(str9, BrowserInfo.KEY_CREATE_TIME);
        i.g(str11, "invalidDate");
        this.id = i10;
        this.orderId = str;
        this.packageType = i11;
        this.packagePlanName = str2;
        this.authorizedDays = i12;
        this.paymentAmount = str3;
        this.paymentCurrency = str4;
        this.paymentTime = str5;
        this.state = str6;
        this.paymentPlatform = str7;
        this.paymentType = str8;
        this.createTime = str9;
        this.redirectUrl = str10;
        this.invalidDate = str11;
        this.uploadUrl = str12;
        this.paymentInfo = str13;
        this.isProcessing = i13;
        this.specialType = i14;
    }

    public final int component1() {
        return this.id;
    }

    public final String component10() {
        return this.paymentPlatform;
    }

    public final String component11() {
        return this.paymentType;
    }

    public final String component12() {
        return this.createTime;
    }

    public final String component13() {
        return this.redirectUrl;
    }

    public final String component14() {
        return this.invalidDate;
    }

    public final String component15() {
        return this.uploadUrl;
    }

    public final String component16() {
        return this.paymentInfo;
    }

    public final int component17() {
        return this.isProcessing;
    }

    public final int component18() {
        return this.specialType;
    }

    public final String component2() {
        return this.orderId;
    }

    public final int component3() {
        return this.packageType;
    }

    public final String component4() {
        return this.packagePlanName;
    }

    public final int component5() {
        return this.authorizedDays;
    }

    public final String component6() {
        return this.paymentAmount;
    }

    public final String component7() {
        return this.paymentCurrency;
    }

    public final String component8() {
        return this.paymentTime;
    }

    public final String component9() {
        return this.state;
    }

    public final GetOrderInfoData copy(int i10, String str, int i11, String str2, int i12, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i13, int i14) {
        i.g(str, "orderId");
        i.g(str2, "packagePlanName");
        i.g(str3, "paymentAmount");
        i.g(str4, "paymentCurrency");
        i.g(str5, "paymentTime");
        i.g(str6, IPushHandler.STATE);
        i.g(str7, "paymentPlatform");
        i.g(str8, "paymentType");
        i.g(str9, BrowserInfo.KEY_CREATE_TIME);
        i.g(str11, "invalidDate");
        return new GetOrderInfoData(i10, str, i11, str2, i12, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, i13, i14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetOrderInfoData)) {
            return false;
        }
        GetOrderInfoData getOrderInfoData = (GetOrderInfoData) obj;
        return this.id == getOrderInfoData.id && i.b(this.orderId, getOrderInfoData.orderId) && this.packageType == getOrderInfoData.packageType && i.b(this.packagePlanName, getOrderInfoData.packagePlanName) && this.authorizedDays == getOrderInfoData.authorizedDays && i.b(this.paymentAmount, getOrderInfoData.paymentAmount) && i.b(this.paymentCurrency, getOrderInfoData.paymentCurrency) && i.b(this.paymentTime, getOrderInfoData.paymentTime) && i.b(this.state, getOrderInfoData.state) && i.b(this.paymentPlatform, getOrderInfoData.paymentPlatform) && i.b(this.paymentType, getOrderInfoData.paymentType) && i.b(this.createTime, getOrderInfoData.createTime) && i.b(this.redirectUrl, getOrderInfoData.redirectUrl) && i.b(this.invalidDate, getOrderInfoData.invalidDate) && i.b(this.uploadUrl, getOrderInfoData.uploadUrl) && i.b(this.paymentInfo, getOrderInfoData.paymentInfo) && this.isProcessing == getOrderInfoData.isProcessing && this.specialType == getOrderInfoData.specialType;
    }

    public final int getAuthorizedDays() {
        return this.authorizedDays;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final int getId() {
        return this.id;
    }

    public final String getInvalidDate() {
        return this.invalidDate;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPackagePlanName() {
        return this.packagePlanName;
    }

    public final int getPackageType() {
        return this.packageType;
    }

    public final String getPaymentAmount() {
        return this.paymentAmount;
    }

    public final String getPaymentCurrency() {
        return this.paymentCurrency;
    }

    public final String getPaymentInfo() {
        return this.paymentInfo;
    }

    public final String getPaymentPlatform() {
        return this.paymentPlatform;
    }

    public final String getPaymentTime() {
        return this.paymentTime;
    }

    public final String getPaymentType() {
        return this.paymentType;
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final int getSpecialType() {
        return this.specialType;
    }

    public final String getState() {
        return this.state;
    }

    public final String getUploadUrl() {
        return this.uploadUrl;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((this.id * 31) + this.orderId.hashCode()) * 31) + this.packageType) * 31) + this.packagePlanName.hashCode()) * 31) + this.authorizedDays) * 31) + this.paymentAmount.hashCode()) * 31) + this.paymentCurrency.hashCode()) * 31) + this.paymentTime.hashCode()) * 31) + this.state.hashCode()) * 31) + this.paymentPlatform.hashCode()) * 31) + this.paymentType.hashCode()) * 31) + this.createTime.hashCode()) * 31;
        String str = this.redirectUrl;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.invalidDate.hashCode()) * 31;
        String str2 = this.uploadUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.paymentInfo;
        return ((((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.isProcessing) * 31) + this.specialType;
    }

    public final int isProcessing() {
        return this.isProcessing;
    }

    public final void setAuthorizedDays(int i10) {
        this.authorizedDays = i10;
    }

    public final void setCreateTime(String str) {
        i.g(str, "<set-?>");
        this.createTime = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setInvalidDate(String str) {
        i.g(str, "<set-?>");
        this.invalidDate = str;
    }

    public final void setOrderId(String str) {
        i.g(str, "<set-?>");
        this.orderId = str;
    }

    public final void setPackagePlanName(String str) {
        i.g(str, "<set-?>");
        this.packagePlanName = str;
    }

    public final void setPackageType(int i10) {
        this.packageType = i10;
    }

    public final void setPaymentAmount(String str) {
        i.g(str, "<set-?>");
        this.paymentAmount = str;
    }

    public final void setPaymentCurrency(String str) {
        i.g(str, "<set-?>");
        this.paymentCurrency = str;
    }

    public final void setPaymentInfo(String str) {
        this.paymentInfo = str;
    }

    public final void setPaymentPlatform(String str) {
        i.g(str, "<set-?>");
        this.paymentPlatform = str;
    }

    public final void setPaymentTime(String str) {
        i.g(str, "<set-?>");
        this.paymentTime = str;
    }

    public final void setPaymentType(String str) {
        i.g(str, "<set-?>");
        this.paymentType = str;
    }

    public final void setProcessing(int i10) {
        this.isProcessing = i10;
    }

    public final void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    public final void setSpecialType(int i10) {
        this.specialType = i10;
    }

    public final void setState(String str) {
        i.g(str, "<set-?>");
        this.state = str;
    }

    public final void setUploadUrl(String str) {
        this.uploadUrl = str;
    }

    public String toString() {
        return "GetOrderInfoData(id=" + this.id + ", orderId=" + this.orderId + ", packageType=" + this.packageType + ", packagePlanName=" + this.packagePlanName + ", authorizedDays=" + this.authorizedDays + ", paymentAmount=" + this.paymentAmount + ", paymentCurrency=" + this.paymentCurrency + ", paymentTime=" + this.paymentTime + ", state=" + this.state + ", paymentPlatform=" + this.paymentPlatform + ", paymentType=" + this.paymentType + ", createTime=" + this.createTime + ", redirectUrl=" + this.redirectUrl + ", invalidDate=" + this.invalidDate + ", uploadUrl=" + this.uploadUrl + ", paymentInfo=" + this.paymentInfo + ", isProcessing=" + this.isProcessing + ", specialType=" + this.specialType + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
