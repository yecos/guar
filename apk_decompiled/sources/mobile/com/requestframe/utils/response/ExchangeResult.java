package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ExchangeResult {
    private ExchangeData data;
    private String errorMessage;
    private String returnCode;

    public ExchangeResult(String str, String str2, ExchangeData exchangeData) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = exchangeData;
    }

    public static /* synthetic */ ExchangeResult copy$default(ExchangeResult exchangeResult, String str, String str2, ExchangeData exchangeData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = exchangeResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = exchangeResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            exchangeData = exchangeResult.data;
        }
        return exchangeResult.copy(str, str2, exchangeData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final ExchangeData component3() {
        return this.data;
    }

    public final ExchangeResult copy(String str, String str2, ExchangeData exchangeData) {
        return new ExchangeResult(str, str2, exchangeData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExchangeResult)) {
            return false;
        }
        ExchangeResult exchangeResult = (ExchangeResult) obj;
        return i.b(this.returnCode, exchangeResult.returnCode) && i.b(this.errorMessage, exchangeResult.errorMessage) && i.b(this.data, exchangeResult.data);
    }

    public final ExchangeData getData() {
        return this.data;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        String str = this.returnCode;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.errorMessage;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ExchangeData exchangeData = this.data;
        return hashCode2 + (exchangeData != null ? exchangeData.hashCode() : 0);
    }

    public final void setData(ExchangeData exchangeData) {
        this.data = exchangeData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "ExchangeResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
