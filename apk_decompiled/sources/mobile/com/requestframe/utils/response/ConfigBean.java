package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class ConfigBean {
    private String apkDownloadUrl;
    private String apkWakeUrl;
    private String appId;
    private String commonUrl;
    private String feedbackUrl;
    private String helpCenterUrl;
    private List<String> iosMobileConfig;
    private List<String> iosProvision;
    private String iosProvisionDate;
    private String logoImage;
    private Integer memberTime;
    private String officialWebsiteUrl;
    private String paymentUrl;
    private List<String> registerMethod;
    private String tvDownloadUrl;
    private String winDownloadUrl;

    public ConfigBean(String str, List<String> list, List<String> list2, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, String str10, List<String> list3, String str11, String str12) {
        this.appId = str;
        this.iosMobileConfig = list;
        this.iosProvision = list2;
        this.iosProvisionDate = str2;
        this.helpCenterUrl = str3;
        this.paymentUrl = str4;
        this.feedbackUrl = str5;
        this.commonUrl = str6;
        this.memberTime = num;
        this.apkDownloadUrl = str7;
        this.winDownloadUrl = str8;
        this.apkWakeUrl = str9;
        this.tvDownloadUrl = str10;
        this.registerMethod = list3;
        this.logoImage = str11;
        this.officialWebsiteUrl = str12;
    }

    public final String component1() {
        return this.appId;
    }

    public final String component10() {
        return this.apkDownloadUrl;
    }

    public final String component11() {
        return this.winDownloadUrl;
    }

    public final String component12() {
        return this.apkWakeUrl;
    }

    public final String component13() {
        return this.tvDownloadUrl;
    }

    public final List<String> component14() {
        return this.registerMethod;
    }

    public final String component15() {
        return this.logoImage;
    }

    public final String component16() {
        return this.officialWebsiteUrl;
    }

    public final List<String> component2() {
        return this.iosMobileConfig;
    }

    public final List<String> component3() {
        return this.iosProvision;
    }

    public final String component4() {
        return this.iosProvisionDate;
    }

    public final String component5() {
        return this.helpCenterUrl;
    }

    public final String component6() {
        return this.paymentUrl;
    }

    public final String component7() {
        return this.feedbackUrl;
    }

    public final String component8() {
        return this.commonUrl;
    }

    public final Integer component9() {
        return this.memberTime;
    }

    public final ConfigBean copy(String str, List<String> list, List<String> list2, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, String str10, List<String> list3, String str11, String str12) {
        return new ConfigBean(str, list, list2, str2, str3, str4, str5, str6, num, str7, str8, str9, str10, list3, str11, str12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigBean)) {
            return false;
        }
        ConfigBean configBean = (ConfigBean) obj;
        return i.b(this.appId, configBean.appId) && i.b(this.iosMobileConfig, configBean.iosMobileConfig) && i.b(this.iosProvision, configBean.iosProvision) && i.b(this.iosProvisionDate, configBean.iosProvisionDate) && i.b(this.helpCenterUrl, configBean.helpCenterUrl) && i.b(this.paymentUrl, configBean.paymentUrl) && i.b(this.feedbackUrl, configBean.feedbackUrl) && i.b(this.commonUrl, configBean.commonUrl) && i.b(this.memberTime, configBean.memberTime) && i.b(this.apkDownloadUrl, configBean.apkDownloadUrl) && i.b(this.winDownloadUrl, configBean.winDownloadUrl) && i.b(this.apkWakeUrl, configBean.apkWakeUrl) && i.b(this.tvDownloadUrl, configBean.tvDownloadUrl) && i.b(this.registerMethod, configBean.registerMethod) && i.b(this.logoImage, configBean.logoImage) && i.b(this.officialWebsiteUrl, configBean.officialWebsiteUrl);
    }

    public final String getApkDownloadUrl() {
        return this.apkDownloadUrl;
    }

    public final String getApkWakeUrl() {
        return this.apkWakeUrl;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getCommonUrl() {
        return this.commonUrl;
    }

    public final String getFeedbackUrl() {
        return this.feedbackUrl;
    }

    public final String getHelpCenterUrl() {
        return this.helpCenterUrl;
    }

    public final List<String> getIosMobileConfig() {
        return this.iosMobileConfig;
    }

    public final List<String> getIosProvision() {
        return this.iosProvision;
    }

    public final String getIosProvisionDate() {
        return this.iosProvisionDate;
    }

    public final String getLogoImage() {
        return this.logoImage;
    }

    public final Integer getMemberTime() {
        return this.memberTime;
    }

    public final String getOfficialWebsiteUrl() {
        return this.officialWebsiteUrl;
    }

    public final String getPaymentUrl() {
        return this.paymentUrl;
    }

    public final List<String> getRegisterMethod() {
        return this.registerMethod;
    }

    public final String getTvDownloadUrl() {
        return this.tvDownloadUrl;
    }

    public final String getWinDownloadUrl() {
        return this.winDownloadUrl;
    }

    public int hashCode() {
        String str = this.appId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.iosMobileConfig;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.iosProvision;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.iosProvisionDate;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.helpCenterUrl;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.paymentUrl;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.feedbackUrl;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.commonUrl;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.memberTime;
        int hashCode9 = (hashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        String str7 = this.apkDownloadUrl;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.winDownloadUrl;
        int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.apkWakeUrl;
        int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.tvDownloadUrl;
        int hashCode13 = (hashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        List<String> list3 = this.registerMethod;
        int hashCode14 = (hashCode13 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str11 = this.logoImage;
        int hashCode15 = (hashCode14 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.officialWebsiteUrl;
        return hashCode15 + (str12 != null ? str12.hashCode() : 0);
    }

    public final void setApkDownloadUrl(String str) {
        this.apkDownloadUrl = str;
    }

    public final void setApkWakeUrl(String str) {
        this.apkWakeUrl = str;
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final void setCommonUrl(String str) {
        this.commonUrl = str;
    }

    public final void setFeedbackUrl(String str) {
        this.feedbackUrl = str;
    }

    public final void setHelpCenterUrl(String str) {
        this.helpCenterUrl = str;
    }

    public final void setIosMobileConfig(List<String> list) {
        this.iosMobileConfig = list;
    }

    public final void setIosProvision(List<String> list) {
        this.iosProvision = list;
    }

    public final void setIosProvisionDate(String str) {
        this.iosProvisionDate = str;
    }

    public final void setLogoImage(String str) {
        this.logoImage = str;
    }

    public final void setMemberTime(Integer num) {
        this.memberTime = num;
    }

    public final void setOfficialWebsiteUrl(String str) {
        this.officialWebsiteUrl = str;
    }

    public final void setPaymentUrl(String str) {
        this.paymentUrl = str;
    }

    public final void setRegisterMethod(List<String> list) {
        this.registerMethod = list;
    }

    public final void setTvDownloadUrl(String str) {
        this.tvDownloadUrl = str;
    }

    public final void setWinDownloadUrl(String str) {
        this.winDownloadUrl = str;
    }

    public String toString() {
        return "ConfigBean(appId=" + this.appId + ", iosMobileConfig=" + this.iosMobileConfig + ", iosProvision=" + this.iosProvision + ", iosProvisionDate=" + this.iosProvisionDate + ", helpCenterUrl=" + this.helpCenterUrl + ", paymentUrl=" + this.paymentUrl + ", feedbackUrl=" + this.feedbackUrl + ", commonUrl=" + this.commonUrl + ", memberTime=" + this.memberTime + ", apkDownloadUrl=" + this.apkDownloadUrl + ", winDownloadUrl=" + this.winDownloadUrl + ", apkWakeUrl=" + this.apkWakeUrl + ", tvDownloadUrl=" + this.tvDownloadUrl + ", registerMethod=" + this.registerMethod + ", logoImage=" + this.logoImage + ", officialWebsiteUrl=" + this.officialWebsiteUrl + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
