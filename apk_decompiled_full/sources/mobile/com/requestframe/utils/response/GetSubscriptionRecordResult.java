package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class GetSubscriptionRecordResult {
    private List<GetSubscriptionRecordData> data;
    private String errorMessage;
    private String returnCode;

    public GetSubscriptionRecordResult(String str, String str2, List<GetSubscriptionRecordData> list) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetSubscriptionRecordResult copy$default(GetSubscriptionRecordResult getSubscriptionRecordResult, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getSubscriptionRecordResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getSubscriptionRecordResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            list = getSubscriptionRecordResult.data;
        }
        return getSubscriptionRecordResult.copy(str, str2, list);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final List<GetSubscriptionRecordData> component3() {
        return this.data;
    }

    public final GetSubscriptionRecordResult copy(String str, String str2, List<GetSubscriptionRecordData> list) {
        return new GetSubscriptionRecordResult(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetSubscriptionRecordResult)) {
            return false;
        }
        GetSubscriptionRecordResult getSubscriptionRecordResult = (GetSubscriptionRecordResult) obj;
        return i.b(this.returnCode, getSubscriptionRecordResult.returnCode) && i.b(this.errorMessage, getSubscriptionRecordResult.errorMessage) && i.b(this.data, getSubscriptionRecordResult.data);
    }

    public final List<GetSubscriptionRecordData> getData() {
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
        List<GetSubscriptionRecordData> list = this.data;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final void setData(List<GetSubscriptionRecordData> list) {
        this.data = list;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "GetSubscriptionRecordResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
