package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class FilterByContentResult {
    private FilterByContentResultData data;
    private String errorMessage;
    private String returnCode;

    public FilterByContentResult(String str, String str2, FilterByContentResultData filterByContentResultData) {
        i.g(str, "returnCode");
        i.g(filterByContentResultData, "data");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = filterByContentResultData;
    }

    public static /* synthetic */ FilterByContentResult copy$default(FilterByContentResult filterByContentResult, String str, String str2, FilterByContentResultData filterByContentResultData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = filterByContentResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = filterByContentResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            filterByContentResultData = filterByContentResult.data;
        }
        return filterByContentResult.copy(str, str2, filterByContentResultData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final FilterByContentResultData component3() {
        return this.data;
    }

    public final FilterByContentResult copy(String str, String str2, FilterByContentResultData filterByContentResultData) {
        i.g(str, "returnCode");
        i.g(filterByContentResultData, "data");
        return new FilterByContentResult(str, str2, filterByContentResultData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterByContentResult)) {
            return false;
        }
        FilterByContentResult filterByContentResult = (FilterByContentResult) obj;
        return i.b(this.returnCode, filterByContentResult.returnCode) && i.b(this.errorMessage, filterByContentResult.errorMessage) && i.b(this.data, filterByContentResult.data);
    }

    public final FilterByContentResultData getData() {
        return this.data;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        int hashCode = this.returnCode.hashCode() * 31;
        String str = this.errorMessage;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.data.hashCode();
    }

    public final void setData(FilterByContentResultData filterByContentResultData) {
        i.g(filterByContentResultData, "<set-?>");
        this.data = filterByContentResultData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        i.g(str, "<set-?>");
        this.returnCode = str;
    }

    public String toString() {
        return "FilterByContentResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
