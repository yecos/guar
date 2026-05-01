package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetAddrResultData {
    private String dcsClientUrl;
    private String dcsClientUrlAlias;
    private String errorMessage;
    private String returnCode;

    public GetAddrResultData(String str, String str2, String str3, String str4) {
        i.g(str2, "returnCode");
        i.g(str3, "errorMessage");
        this.dcsClientUrl = str;
        this.returnCode = str2;
        this.errorMessage = str3;
        this.dcsClientUrlAlias = str4;
    }

    public static /* synthetic */ GetAddrResultData copy$default(GetAddrResultData getAddrResultData, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getAddrResultData.dcsClientUrl;
        }
        if ((i10 & 2) != 0) {
            str2 = getAddrResultData.returnCode;
        }
        if ((i10 & 4) != 0) {
            str3 = getAddrResultData.errorMessage;
        }
        if ((i10 & 8) != 0) {
            str4 = getAddrResultData.dcsClientUrlAlias;
        }
        return getAddrResultData.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.dcsClientUrl;
    }

    public final String component2() {
        return this.returnCode;
    }

    public final String component3() {
        return this.errorMessage;
    }

    public final String component4() {
        return this.dcsClientUrlAlias;
    }

    public final GetAddrResultData copy(String str, String str2, String str3, String str4) {
        i.g(str2, "returnCode");
        i.g(str3, "errorMessage");
        return new GetAddrResultData(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAddrResultData)) {
            return false;
        }
        GetAddrResultData getAddrResultData = (GetAddrResultData) obj;
        return i.b(this.dcsClientUrl, getAddrResultData.dcsClientUrl) && i.b(this.returnCode, getAddrResultData.returnCode) && i.b(this.errorMessage, getAddrResultData.errorMessage) && i.b(this.dcsClientUrlAlias, getAddrResultData.dcsClientUrlAlias);
    }

    public final String getDcsClientUrl() {
        return this.dcsClientUrl;
    }

    public final String getDcsClientUrlAlias() {
        return this.dcsClientUrlAlias;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        String str = this.dcsClientUrl;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.returnCode.hashCode()) * 31) + this.errorMessage.hashCode()) * 31;
        String str2 = this.dcsClientUrlAlias;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setDcsClientUrl(String str) {
        this.dcsClientUrl = str;
    }

    public final void setDcsClientUrlAlias(String str) {
        this.dcsClientUrlAlias = str;
    }

    public final void setErrorMessage(String str) {
        i.g(str, "<set-?>");
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        i.g(str, "<set-?>");
        this.returnCode = str;
    }

    public String toString() {
        return "GetAddrResultData(dcsClientUrl=" + this.dcsClientUrl + ", returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", dcsClientUrlAlias=" + this.dcsClientUrlAlias + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
