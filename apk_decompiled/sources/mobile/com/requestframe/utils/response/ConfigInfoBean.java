package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ConfigInfoBean {
    private String customerEmail;
    private String downloadApkUrl;
    private String downloadNumber;
    private String downloadSpeed;
    private String officialWebsiteLink;
    private String purchaseUrl;
    private String sellerUrl;
    private String shareLinkUrl;

    public ConfigInfoBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.customerEmail = str;
        this.shareLinkUrl = str2;
        this.downloadNumber = str3;
        this.downloadSpeed = str4;
        this.officialWebsiteLink = str5;
        this.purchaseUrl = str6;
        this.sellerUrl = str7;
        this.downloadApkUrl = str8;
    }

    public final String component1() {
        return this.customerEmail;
    }

    public final String component2() {
        return this.shareLinkUrl;
    }

    public final String component3() {
        return this.downloadNumber;
    }

    public final String component4() {
        return this.downloadSpeed;
    }

    public final String component5() {
        return this.officialWebsiteLink;
    }

    public final String component6() {
        return this.purchaseUrl;
    }

    public final String component7() {
        return this.sellerUrl;
    }

    public final String component8() {
        return this.downloadApkUrl;
    }

    public final ConfigInfoBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return new ConfigInfoBean(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigInfoBean)) {
            return false;
        }
        ConfigInfoBean configInfoBean = (ConfigInfoBean) obj;
        return i.b(this.customerEmail, configInfoBean.customerEmail) && i.b(this.shareLinkUrl, configInfoBean.shareLinkUrl) && i.b(this.downloadNumber, configInfoBean.downloadNumber) && i.b(this.downloadSpeed, configInfoBean.downloadSpeed) && i.b(this.officialWebsiteLink, configInfoBean.officialWebsiteLink) && i.b(this.purchaseUrl, configInfoBean.purchaseUrl) && i.b(this.sellerUrl, configInfoBean.sellerUrl) && i.b(this.downloadApkUrl, configInfoBean.downloadApkUrl);
    }

    public final String getCustomerEmail() {
        return this.customerEmail;
    }

    public final String getDownloadApkUrl() {
        return this.downloadApkUrl;
    }

    public final String getDownloadNumber() {
        return this.downloadNumber;
    }

    public final String getDownloadSpeed() {
        return this.downloadSpeed;
    }

    public final String getOfficialWebsiteLink() {
        return this.officialWebsiteLink;
    }

    public final String getPurchaseUrl() {
        return this.purchaseUrl;
    }

    public final String getSellerUrl() {
        return this.sellerUrl;
    }

    public final String getShareLinkUrl() {
        return this.shareLinkUrl;
    }

    public int hashCode() {
        String str = this.customerEmail;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.shareLinkUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.downloadNumber;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.downloadSpeed;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.officialWebsiteLink;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.purchaseUrl;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.sellerUrl;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.downloadApkUrl;
        return hashCode7 + (str8 != null ? str8.hashCode() : 0);
    }

    public final void setCustomerEmail(String str) {
        this.customerEmail = str;
    }

    public final void setDownloadApkUrl(String str) {
        this.downloadApkUrl = str;
    }

    public final void setDownloadNumber(String str) {
        this.downloadNumber = str;
    }

    public final void setDownloadSpeed(String str) {
        this.downloadSpeed = str;
    }

    public final void setOfficialWebsiteLink(String str) {
        this.officialWebsiteLink = str;
    }

    public final void setPurchaseUrl(String str) {
        this.purchaseUrl = str;
    }

    public final void setSellerUrl(String str) {
        this.sellerUrl = str;
    }

    public final void setShareLinkUrl(String str) {
        this.shareLinkUrl = str;
    }

    public String toString() {
        return "ConfigInfoBean(customerEmail=" + this.customerEmail + ", shareLinkUrl=" + this.shareLinkUrl + ", downloadNumber=" + this.downloadNumber + ", downloadSpeed=" + this.downloadSpeed + ", officialWebsiteLink=" + this.officialWebsiteLink + ", purchaseUrl=" + this.purchaseUrl + ", sellerUrl=" + this.sellerUrl + ", downloadApkUrl=" + this.downloadApkUrl + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
