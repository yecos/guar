package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class PropertiesInfoResult {
    private PropertiesInfoData data;
    private String errorMessage;
    private String returnCode;

    public PropertiesInfoResult(String str, String str2, PropertiesInfoData propertiesInfoData) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = propertiesInfoData;
    }

    public static /* synthetic */ PropertiesInfoResult copy$default(PropertiesInfoResult propertiesInfoResult, String str, String str2, PropertiesInfoData propertiesInfoData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = propertiesInfoResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = propertiesInfoResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            propertiesInfoData = propertiesInfoResult.data;
        }
        return propertiesInfoResult.copy(str, str2, propertiesInfoData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final PropertiesInfoData component3() {
        return this.data;
    }

    public final PropertiesInfoResult copy(String str, String str2, PropertiesInfoData propertiesInfoData) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        return new PropertiesInfoResult(str, str2, propertiesInfoData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PropertiesInfoResult)) {
            return false;
        }
        PropertiesInfoResult propertiesInfoResult = (PropertiesInfoResult) obj;
        return i.b(this.returnCode, propertiesInfoResult.returnCode) && i.b(this.errorMessage, propertiesInfoResult.errorMessage) && i.b(this.data, propertiesInfoResult.data);
    }

    public final PropertiesInfoData getData() {
        return this.data;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        int hashCode = ((this.returnCode.hashCode() * 31) + this.errorMessage.hashCode()) * 31;
        PropertiesInfoData propertiesInfoData = this.data;
        return hashCode + (propertiesInfoData == null ? 0 : propertiesInfoData.hashCode());
    }

    public final void setData(PropertiesInfoData propertiesInfoData) {
        this.data = propertiesInfoData;
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
        return "PropertiesInfoResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
