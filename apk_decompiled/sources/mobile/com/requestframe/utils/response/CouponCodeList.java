package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.common.Constants;
import java.util.Map;
import t9.i;

/* loaded from: classes3.dex */
public final class CouponCodeList {
    private Map<String, Float> couponAmount;
    private String couponCode;
    private String couponCurrency;
    private String couponEffectType;
    private String couponTitle;
    private String effectTime;
    private String id;
    private String invalidTime;
    private String packageCode;
    private String packageLabel;
    private String packageName;
    private String status;

    public CouponCodeList(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Map<String, Float> map, String str10, String str11) {
        i.g(str, "couponEffectType");
        i.g(str2, "couponCode");
        i.g(str3, "packageCode");
        i.g(str4, Constant.KEY_STATUS);
        i.g(str5, "couponTitle");
        i.g(str7, "invalidTime");
        i.g(str8, "couponCurrency");
        i.g(str9, "id");
        i.g(map, "couponAmount");
        i.g(str10, Constants.KEY_PACKAGE_NAME);
        i.g(str11, "packageLabel");
        this.couponEffectType = str;
        this.couponCode = str2;
        this.packageCode = str3;
        this.status = str4;
        this.couponTitle = str5;
        this.effectTime = str6;
        this.invalidTime = str7;
        this.couponCurrency = str8;
        this.id = str9;
        this.couponAmount = map;
        this.packageName = str10;
        this.packageLabel = str11;
    }

    public final String component1() {
        return this.couponEffectType;
    }

    public final Map<String, Float> component10() {
        return this.couponAmount;
    }

    public final String component11() {
        return this.packageName;
    }

    public final String component12() {
        return this.packageLabel;
    }

    public final String component2() {
        return this.couponCode;
    }

    public final String component3() {
        return this.packageCode;
    }

    public final String component4() {
        return this.status;
    }

    public final String component5() {
        return this.couponTitle;
    }

    public final String component6() {
        return this.effectTime;
    }

    public final String component7() {
        return this.invalidTime;
    }

    public final String component8() {
        return this.couponCurrency;
    }

    public final String component9() {
        return this.id;
    }

    public final CouponCodeList copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Map<String, Float> map, String str10, String str11) {
        i.g(str, "couponEffectType");
        i.g(str2, "couponCode");
        i.g(str3, "packageCode");
        i.g(str4, Constant.KEY_STATUS);
        i.g(str5, "couponTitle");
        i.g(str7, "invalidTime");
        i.g(str8, "couponCurrency");
        i.g(str9, "id");
        i.g(map, "couponAmount");
        i.g(str10, Constants.KEY_PACKAGE_NAME);
        i.g(str11, "packageLabel");
        return new CouponCodeList(str, str2, str3, str4, str5, str6, str7, str8, str9, map, str10, str11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CouponCodeList)) {
            return false;
        }
        CouponCodeList couponCodeList = (CouponCodeList) obj;
        return i.b(this.couponEffectType, couponCodeList.couponEffectType) && i.b(this.couponCode, couponCodeList.couponCode) && i.b(this.packageCode, couponCodeList.packageCode) && i.b(this.status, couponCodeList.status) && i.b(this.couponTitle, couponCodeList.couponTitle) && i.b(this.effectTime, couponCodeList.effectTime) && i.b(this.invalidTime, couponCodeList.invalidTime) && i.b(this.couponCurrency, couponCodeList.couponCurrency) && i.b(this.id, couponCodeList.id) && i.b(this.couponAmount, couponCodeList.couponAmount) && i.b(this.packageName, couponCodeList.packageName) && i.b(this.packageLabel, couponCodeList.packageLabel);
    }

    public final Map<String, Float> getCouponAmount() {
        return this.couponAmount;
    }

    public final String getCouponCode() {
        return this.couponCode;
    }

    public final String getCouponCurrency() {
        return this.couponCurrency;
    }

    public final String getCouponEffectType() {
        return this.couponEffectType;
    }

    public final String getCouponTitle() {
        return this.couponTitle;
    }

    public final String getEffectTime() {
        return this.effectTime;
    }

    public final String getId() {
        return this.id;
    }

    public final String getInvalidTime() {
        return this.invalidTime;
    }

    public final String getPackageCode() {
        return this.packageCode;
    }

    public final String getPackageLabel() {
        return this.packageLabel;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        int hashCode = ((((((((this.couponEffectType.hashCode() * 31) + this.couponCode.hashCode()) * 31) + this.packageCode.hashCode()) * 31) + this.status.hashCode()) * 31) + this.couponTitle.hashCode()) * 31;
        String str = this.effectTime;
        return ((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.invalidTime.hashCode()) * 31) + this.couponCurrency.hashCode()) * 31) + this.id.hashCode()) * 31) + this.couponAmount.hashCode()) * 31) + this.packageName.hashCode()) * 31) + this.packageLabel.hashCode();
    }

    public final void setCouponAmount(Map<String, Float> map) {
        i.g(map, "<set-?>");
        this.couponAmount = map;
    }

    public final void setCouponCode(String str) {
        i.g(str, "<set-?>");
        this.couponCode = str;
    }

    public final void setCouponCurrency(String str) {
        i.g(str, "<set-?>");
        this.couponCurrency = str;
    }

    public final void setCouponEffectType(String str) {
        i.g(str, "<set-?>");
        this.couponEffectType = str;
    }

    public final void setCouponTitle(String str) {
        i.g(str, "<set-?>");
        this.couponTitle = str;
    }

    public final void setEffectTime(String str) {
        this.effectTime = str;
    }

    public final void setId(String str) {
        i.g(str, "<set-?>");
        this.id = str;
    }

    public final void setInvalidTime(String str) {
        i.g(str, "<set-?>");
        this.invalidTime = str;
    }

    public final void setPackageCode(String str) {
        i.g(str, "<set-?>");
        this.packageCode = str;
    }

    public final void setPackageLabel(String str) {
        i.g(str, "<set-?>");
        this.packageLabel = str;
    }

    public final void setPackageName(String str) {
        i.g(str, "<set-?>");
        this.packageName = str;
    }

    public final void setStatus(String str) {
        i.g(str, "<set-?>");
        this.status = str;
    }

    public String toString() {
        return "CouponCodeList(couponEffectType=" + this.couponEffectType + ", couponCode=" + this.couponCode + ", packageCode=" + this.packageCode + ", status=" + this.status + ", couponTitle=" + this.couponTitle + ", effectTime=" + this.effectTime + ", invalidTime=" + this.invalidTime + ", couponCurrency=" + this.couponCurrency + ", id=" + this.id + ", couponAmount=" + this.couponAmount + ", packageName=" + this.packageName + ", packageLabel=" + this.packageLabel + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
