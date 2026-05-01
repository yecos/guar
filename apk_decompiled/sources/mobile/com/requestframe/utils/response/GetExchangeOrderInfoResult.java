package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class GetExchangeOrderInfoResult {
    private List<GetExchangeOrderData> data;
    private String errorMessage;
    private String returnCode;

    public GetExchangeOrderInfoResult(String str, String str2, List<GetExchangeOrderData> list) {
        i.g(list, "data");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetExchangeOrderInfoResult copy$default(GetExchangeOrderInfoResult getExchangeOrderInfoResult, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getExchangeOrderInfoResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getExchangeOrderInfoResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            list = getExchangeOrderInfoResult.data;
        }
        return getExchangeOrderInfoResult.copy(str, str2, list);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final List<GetExchangeOrderData> component3() {
        return this.data;
    }

    public final GetExchangeOrderInfoResult copy(String str, String str2, List<GetExchangeOrderData> list) {
        i.g(list, "data");
        return new GetExchangeOrderInfoResult(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetExchangeOrderInfoResult)) {
            return false;
        }
        GetExchangeOrderInfoResult getExchangeOrderInfoResult = (GetExchangeOrderInfoResult) obj;
        return i.b(this.returnCode, getExchangeOrderInfoResult.returnCode) && i.b(this.errorMessage, getExchangeOrderInfoResult.errorMessage) && i.b(this.data, getExchangeOrderInfoResult.data);
    }

    public final List<GetExchangeOrderData> getData() {
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
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.data.hashCode();
    }

    public final void setData(List<GetExchangeOrderData> list) {
        i.g(list, "<set-?>");
        this.data = list;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "GetExchangeOrderInfoResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
