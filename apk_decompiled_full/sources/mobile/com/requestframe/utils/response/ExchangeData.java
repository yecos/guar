package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class ExchangeData {
    private String assAuthDays;
    private List<AuthInfo> authInfoList;
    private Integer authTime;
    private String codeInvalidTime;
    private String exchangeDate;
    private String offserviceDate;
    private String userName;

    public ExchangeData(String str, String str2, String str3, String str4, Integer num, String str5, List<AuthInfo> list) {
        this.assAuthDays = str;
        this.codeInvalidTime = str2;
        this.exchangeDate = str3;
        this.offserviceDate = str4;
        this.authTime = num;
        this.userName = str5;
        this.authInfoList = list;
    }

    public static /* synthetic */ ExchangeData copy$default(ExchangeData exchangeData, String str, String str2, String str3, String str4, Integer num, String str5, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = exchangeData.assAuthDays;
        }
        if ((i10 & 2) != 0) {
            str2 = exchangeData.codeInvalidTime;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = exchangeData.exchangeDate;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = exchangeData.offserviceDate;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            num = exchangeData.authTime;
        }
        Integer num2 = num;
        if ((i10 & 32) != 0) {
            str5 = exchangeData.userName;
        }
        String str9 = str5;
        if ((i10 & 64) != 0) {
            list = exchangeData.authInfoList;
        }
        return exchangeData.copy(str, str6, str7, str8, num2, str9, list);
    }

    public final String component1() {
        return this.assAuthDays;
    }

    public final String component2() {
        return this.codeInvalidTime;
    }

    public final String component3() {
        return this.exchangeDate;
    }

    public final String component4() {
        return this.offserviceDate;
    }

    public final Integer component5() {
        return this.authTime;
    }

    public final String component6() {
        return this.userName;
    }

    public final List<AuthInfo> component7() {
        return this.authInfoList;
    }

    public final ExchangeData copy(String str, String str2, String str3, String str4, Integer num, String str5, List<AuthInfo> list) {
        return new ExchangeData(str, str2, str3, str4, num, str5, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExchangeData)) {
            return false;
        }
        ExchangeData exchangeData = (ExchangeData) obj;
        return i.b(this.assAuthDays, exchangeData.assAuthDays) && i.b(this.codeInvalidTime, exchangeData.codeInvalidTime) && i.b(this.exchangeDate, exchangeData.exchangeDate) && i.b(this.offserviceDate, exchangeData.offserviceDate) && i.b(this.authTime, exchangeData.authTime) && i.b(this.userName, exchangeData.userName) && i.b(this.authInfoList, exchangeData.authInfoList);
    }

    public final String getAssAuthDays() {
        return this.assAuthDays;
    }

    public final List<AuthInfo> getAuthInfoList() {
        return this.authInfoList;
    }

    public final Integer getAuthTime() {
        return this.authTime;
    }

    public final String getCodeInvalidTime() {
        return this.codeInvalidTime;
    }

    public final String getExchangeDate() {
        return this.exchangeDate;
    }

    public final String getOffserviceDate() {
        return this.offserviceDate;
    }

    public final String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        String str = this.assAuthDays;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.codeInvalidTime;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.exchangeDate;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.offserviceDate;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.authTime;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.userName;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<AuthInfo> list = this.authInfoList;
        return hashCode6 + (list != null ? list.hashCode() : 0);
    }

    public final void setAssAuthDays(String str) {
        this.assAuthDays = str;
    }

    public final void setAuthInfoList(List<AuthInfo> list) {
        this.authInfoList = list;
    }

    public final void setAuthTime(Integer num) {
        this.authTime = num;
    }

    public final void setCodeInvalidTime(String str) {
        this.codeInvalidTime = str;
    }

    public final void setExchangeDate(String str) {
        this.exchangeDate = str;
    }

    public final void setOffserviceDate(String str) {
        this.offserviceDate = str;
    }

    public final void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        return "ExchangeData(assAuthDays=" + this.assAuthDays + ", codeInvalidTime=" + this.codeInvalidTime + ", exchangeDate=" + this.exchangeDate + ", offserviceDate=" + this.offserviceDate + ", authTime=" + this.authTime + ", userName=" + this.userName + ", authInfoList=" + this.authInfoList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
