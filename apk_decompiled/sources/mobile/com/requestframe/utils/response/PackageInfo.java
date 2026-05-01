package mobile.com.requestframe.utils.response;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.common.Constants;
import pa.a;
import t9.i;

/* loaded from: classes3.dex */
public final class PackageInfo {
    private String appId;
    private String area;
    private int authorizedDays;
    private String currency;
    private double currentPrice;
    private Double firstPeriodPrice;
    private int id;
    private int isRecommend;
    private String labelCode;
    private String labelDescription;
    private String labelRemark;
    private int labelSequence;
    private String labelTitle;
    private double originalPrice;
    private String packageCode;
    private String packageLanguage;
    private String packageName;
    private String packagePlanName;
    private int packageType;
    private String portalId;
    private String sort;
    private String status;

    public PackageInfo(int i10, String str, String str2, String str3, String str4, String str5, int i11, String str6, int i12, int i13, String str7, String str8, String str9, String str10, double d10, double d11, Double d12, String str11, String str12, int i14, String str13, String str14) {
        i.g(str, Constants.KEY_PACKAGE_NAME);
        i.g(str2, "packageCode");
        i.g(str3, "sort");
        i.g(str4, "portalId");
        i.g(str5, Constant.KEY_STATUS);
        i.g(str6, "appId");
        i.g(str7, "packageLanguage");
        i.g(str8, "packagePlanName");
        i.g(str9, "area");
        i.g(str10, FirebaseAnalytics.Param.CURRENCY);
        i.g(str11, "labelCode");
        i.g(str12, "labelTitle");
        i.g(str13, "labelDescription");
        this.id = i10;
        this.packageName = str;
        this.packageCode = str2;
        this.sort = str3;
        this.portalId = str4;
        this.status = str5;
        this.authorizedDays = i11;
        this.appId = str6;
        this.isRecommend = i12;
        this.packageType = i13;
        this.packageLanguage = str7;
        this.packagePlanName = str8;
        this.area = str9;
        this.currency = str10;
        this.originalPrice = d10;
        this.currentPrice = d11;
        this.firstPeriodPrice = d12;
        this.labelCode = str11;
        this.labelTitle = str12;
        this.labelSequence = i14;
        this.labelDescription = str13;
        this.labelRemark = str14;
    }

    public final int component1() {
        return this.id;
    }

    public final int component10() {
        return this.packageType;
    }

    public final String component11() {
        return this.packageLanguage;
    }

    public final String component12() {
        return this.packagePlanName;
    }

    public final String component13() {
        return this.area;
    }

    public final String component14() {
        return this.currency;
    }

    public final double component15() {
        return this.originalPrice;
    }

    public final double component16() {
        return this.currentPrice;
    }

    public final Double component17() {
        return this.firstPeriodPrice;
    }

    public final String component18() {
        return this.labelCode;
    }

    public final String component19() {
        return this.labelTitle;
    }

    public final String component2() {
        return this.packageName;
    }

    public final int component20() {
        return this.labelSequence;
    }

    public final String component21() {
        return this.labelDescription;
    }

    public final String component22() {
        return this.labelRemark;
    }

    public final String component3() {
        return this.packageCode;
    }

    public final String component4() {
        return this.sort;
    }

    public final String component5() {
        return this.portalId;
    }

    public final String component6() {
        return this.status;
    }

    public final int component7() {
        return this.authorizedDays;
    }

    public final String component8() {
        return this.appId;
    }

    public final int component9() {
        return this.isRecommend;
    }

    public final PackageInfo copy(int i10, String str, String str2, String str3, String str4, String str5, int i11, String str6, int i12, int i13, String str7, String str8, String str9, String str10, double d10, double d11, Double d12, String str11, String str12, int i14, String str13, String str14) {
        i.g(str, Constants.KEY_PACKAGE_NAME);
        i.g(str2, "packageCode");
        i.g(str3, "sort");
        i.g(str4, "portalId");
        i.g(str5, Constant.KEY_STATUS);
        i.g(str6, "appId");
        i.g(str7, "packageLanguage");
        i.g(str8, "packagePlanName");
        i.g(str9, "area");
        i.g(str10, FirebaseAnalytics.Param.CURRENCY);
        i.g(str11, "labelCode");
        i.g(str12, "labelTitle");
        i.g(str13, "labelDescription");
        return new PackageInfo(i10, str, str2, str3, str4, str5, i11, str6, i12, i13, str7, str8, str9, str10, d10, d11, d12, str11, str12, i14, str13, str14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PackageInfo)) {
            return false;
        }
        PackageInfo packageInfo = (PackageInfo) obj;
        return this.id == packageInfo.id && i.b(this.packageName, packageInfo.packageName) && i.b(this.packageCode, packageInfo.packageCode) && i.b(this.sort, packageInfo.sort) && i.b(this.portalId, packageInfo.portalId) && i.b(this.status, packageInfo.status) && this.authorizedDays == packageInfo.authorizedDays && i.b(this.appId, packageInfo.appId) && this.isRecommend == packageInfo.isRecommend && this.packageType == packageInfo.packageType && i.b(this.packageLanguage, packageInfo.packageLanguage) && i.b(this.packagePlanName, packageInfo.packagePlanName) && i.b(this.area, packageInfo.area) && i.b(this.currency, packageInfo.currency) && Double.compare(this.originalPrice, packageInfo.originalPrice) == 0 && Double.compare(this.currentPrice, packageInfo.currentPrice) == 0 && i.b(this.firstPeriodPrice, packageInfo.firstPeriodPrice) && i.b(this.labelCode, packageInfo.labelCode) && i.b(this.labelTitle, packageInfo.labelTitle) && this.labelSequence == packageInfo.labelSequence && i.b(this.labelDescription, packageInfo.labelDescription) && i.b(this.labelRemark, packageInfo.labelRemark);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getArea() {
        return this.area;
    }

    public final int getAuthorizedDays() {
        return this.authorizedDays;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final double getCurrentPrice() {
        return this.currentPrice;
    }

    public final Double getFirstPeriodPrice() {
        return this.firstPeriodPrice;
    }

    public final int getId() {
        return this.id;
    }

    public final String getLabelCode() {
        return this.labelCode;
    }

    public final String getLabelDescription() {
        return this.labelDescription;
    }

    public final String getLabelRemark() {
        return this.labelRemark;
    }

    public final int getLabelSequence() {
        return this.labelSequence;
    }

    public final String getLabelTitle() {
        return this.labelTitle;
    }

    public final double getOriginalPrice() {
        return this.originalPrice;
    }

    public final String getPackageCode() {
        return this.packageCode;
    }

    public final String getPackageLanguage() {
        return this.packageLanguage;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPackagePlanName() {
        return this.packagePlanName;
    }

    public final int getPackageType() {
        return this.packageType;
    }

    public final String getPortalId() {
        return this.portalId;
    }

    public final String getSort() {
        return this.sort;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((this.id * 31) + this.packageName.hashCode()) * 31) + this.packageCode.hashCode()) * 31) + this.sort.hashCode()) * 31) + this.portalId.hashCode()) * 31) + this.status.hashCode()) * 31) + this.authorizedDays) * 31) + this.appId.hashCode()) * 31) + this.isRecommend) * 31) + this.packageType) * 31) + this.packageLanguage.hashCode()) * 31) + this.packagePlanName.hashCode()) * 31) + this.area.hashCode()) * 31) + this.currency.hashCode()) * 31) + a.a(this.originalPrice)) * 31) + a.a(this.currentPrice)) * 31;
        Double d10 = this.firstPeriodPrice;
        int hashCode2 = (((((((((hashCode + (d10 == null ? 0 : d10.hashCode())) * 31) + this.labelCode.hashCode()) * 31) + this.labelTitle.hashCode()) * 31) + this.labelSequence) * 31) + this.labelDescription.hashCode()) * 31;
        String str = this.labelRemark;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final int isRecommend() {
        return this.isRecommend;
    }

    public final void setAppId(String str) {
        i.g(str, "<set-?>");
        this.appId = str;
    }

    public final void setArea(String str) {
        i.g(str, "<set-?>");
        this.area = str;
    }

    public final void setAuthorizedDays(int i10) {
        this.authorizedDays = i10;
    }

    public final void setCurrency(String str) {
        i.g(str, "<set-?>");
        this.currency = str;
    }

    public final void setCurrentPrice(double d10) {
        this.currentPrice = d10;
    }

    public final void setFirstPeriodPrice(Double d10) {
        this.firstPeriodPrice = d10;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setLabelCode(String str) {
        i.g(str, "<set-?>");
        this.labelCode = str;
    }

    public final void setLabelDescription(String str) {
        i.g(str, "<set-?>");
        this.labelDescription = str;
    }

    public final void setLabelRemark(String str) {
        this.labelRemark = str;
    }

    public final void setLabelSequence(int i10) {
        this.labelSequence = i10;
    }

    public final void setLabelTitle(String str) {
        i.g(str, "<set-?>");
        this.labelTitle = str;
    }

    public final void setOriginalPrice(double d10) {
        this.originalPrice = d10;
    }

    public final void setPackageCode(String str) {
        i.g(str, "<set-?>");
        this.packageCode = str;
    }

    public final void setPackageLanguage(String str) {
        i.g(str, "<set-?>");
        this.packageLanguage = str;
    }

    public final void setPackageName(String str) {
        i.g(str, "<set-?>");
        this.packageName = str;
    }

    public final void setPackagePlanName(String str) {
        i.g(str, "<set-?>");
        this.packagePlanName = str;
    }

    public final void setPackageType(int i10) {
        this.packageType = i10;
    }

    public final void setPortalId(String str) {
        i.g(str, "<set-?>");
        this.portalId = str;
    }

    public final void setRecommend(int i10) {
        this.isRecommend = i10;
    }

    public final void setSort(String str) {
        i.g(str, "<set-?>");
        this.sort = str;
    }

    public final void setStatus(String str) {
        i.g(str, "<set-?>");
        this.status = str;
    }

    public String toString() {
        return "PackageInfo(id=" + this.id + ", packageName=" + this.packageName + ", packageCode=" + this.packageCode + ", sort=" + this.sort + ", portalId=" + this.portalId + ", status=" + this.status + ", authorizedDays=" + this.authorizedDays + ", appId=" + this.appId + ", isRecommend=" + this.isRecommend + ", packageType=" + this.packageType + ", packageLanguage=" + this.packageLanguage + ", packagePlanName=" + this.packagePlanName + ", area=" + this.area + ", currency=" + this.currency + ", originalPrice=" + this.originalPrice + ", currentPrice=" + this.currentPrice + ", firstPeriodPrice=" + this.firstPeriodPrice + ", labelCode=" + this.labelCode + ", labelTitle=" + this.labelTitle + ", labelSequence=" + this.labelSequence + ", labelDescription=" + this.labelDescription + ", labelRemark=" + this.labelRemark + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
