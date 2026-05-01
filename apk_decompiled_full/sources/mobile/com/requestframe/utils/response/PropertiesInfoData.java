package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class PropertiesInfoData {
    private String customerEmail;
    private String downloadNumber;
    private String downloadSpeed;
    private String shareLinkUrl;
    private String tipFlag;
    private String tipUrl;

    public PropertiesInfoData(String str, String str2, String str3, String str4, String str5, String str6) {
        this.customerEmail = str;
        this.shareLinkUrl = str2;
        this.downloadNumber = str3;
        this.downloadSpeed = str4;
        this.tipFlag = str5;
        this.tipUrl = str6;
    }

    public static /* synthetic */ PropertiesInfoData copy$default(PropertiesInfoData propertiesInfoData, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = propertiesInfoData.customerEmail;
        }
        if ((i10 & 2) != 0) {
            str2 = propertiesInfoData.shareLinkUrl;
        }
        String str7 = str2;
        if ((i10 & 4) != 0) {
            str3 = propertiesInfoData.downloadNumber;
        }
        String str8 = str3;
        if ((i10 & 8) != 0) {
            str4 = propertiesInfoData.downloadSpeed;
        }
        String str9 = str4;
        if ((i10 & 16) != 0) {
            str5 = propertiesInfoData.tipFlag;
        }
        String str10 = str5;
        if ((i10 & 32) != 0) {
            str6 = propertiesInfoData.tipUrl;
        }
        return propertiesInfoData.copy(str, str7, str8, str9, str10, str6);
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
        return this.tipFlag;
    }

    public final String component6() {
        return this.tipUrl;
    }

    public final PropertiesInfoData copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new PropertiesInfoData(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PropertiesInfoData)) {
            return false;
        }
        PropertiesInfoData propertiesInfoData = (PropertiesInfoData) obj;
        return i.b(this.customerEmail, propertiesInfoData.customerEmail) && i.b(this.shareLinkUrl, propertiesInfoData.shareLinkUrl) && i.b(this.downloadNumber, propertiesInfoData.downloadNumber) && i.b(this.downloadSpeed, propertiesInfoData.downloadSpeed) && i.b(this.tipFlag, propertiesInfoData.tipFlag) && i.b(this.tipUrl, propertiesInfoData.tipUrl);
    }

    public final String getCustomerEmail() {
        return this.customerEmail;
    }

    public final String getDownloadNumber() {
        return this.downloadNumber;
    }

    public final String getDownloadSpeed() {
        return this.downloadSpeed;
    }

    public final String getShareLinkUrl() {
        return this.shareLinkUrl;
    }

    public final String getTipFlag() {
        return this.tipFlag;
    }

    public final String getTipUrl() {
        return this.tipUrl;
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
        String str5 = this.tipFlag;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.tipUrl;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setCustomerEmail(String str) {
        this.customerEmail = str;
    }

    public final void setDownloadNumber(String str) {
        this.downloadNumber = str;
    }

    public final void setDownloadSpeed(String str) {
        this.downloadSpeed = str;
    }

    public final void setShareLinkUrl(String str) {
        this.shareLinkUrl = str;
    }

    public final void setTipFlag(String str) {
        this.tipFlag = str;
    }

    public final void setTipUrl(String str) {
        this.tipUrl = str;
    }

    public String toString() {
        return "PropertiesInfoData(customerEmail=" + this.customerEmail + ", shareLinkUrl=" + this.shareLinkUrl + ", downloadNumber=" + this.downloadNumber + ", downloadSpeed=" + this.downloadSpeed + ", tipFlag=" + this.tipFlag + ", tipUrl=" + this.tipUrl + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
