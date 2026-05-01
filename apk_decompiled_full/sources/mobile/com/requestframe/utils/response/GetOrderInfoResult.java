package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class GetOrderInfoResult {
    private List<GetOrderInfoData> data;
    private String errorMessage;
    private String returnCode;
    private Integer totalSize;

    public GetOrderInfoResult(String str, String str2, List<GetOrderInfoData> list, Integer num) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = list;
        this.totalSize = num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetOrderInfoResult copy$default(GetOrderInfoResult getOrderInfoResult, String str, String str2, List list, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getOrderInfoResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getOrderInfoResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            list = getOrderInfoResult.data;
        }
        if ((i10 & 8) != 0) {
            num = getOrderInfoResult.totalSize;
        }
        return getOrderInfoResult.copy(str, str2, list, num);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final List<GetOrderInfoData> component3() {
        return this.data;
    }

    public final Integer component4() {
        return this.totalSize;
    }

    public final GetOrderInfoResult copy(String str, String str2, List<GetOrderInfoData> list, Integer num) {
        return new GetOrderInfoResult(str, str2, list, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetOrderInfoResult)) {
            return false;
        }
        GetOrderInfoResult getOrderInfoResult = (GetOrderInfoResult) obj;
        return i.b(this.returnCode, getOrderInfoResult.returnCode) && i.b(this.errorMessage, getOrderInfoResult.errorMessage) && i.b(this.data, getOrderInfoResult.data) && i.b(this.totalSize, getOrderInfoResult.totalSize);
    }

    public final List<GetOrderInfoData> getData() {
        return this.data;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public final Integer getTotalSize() {
        return this.totalSize;
    }

    public int hashCode() {
        String str = this.returnCode;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.errorMessage;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<GetOrderInfoData> list = this.data;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.totalSize;
        return hashCode3 + (num != null ? num.hashCode() : 0);
    }

    public final void setData(List<GetOrderInfoData> list) {
        this.data = list;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public final void setTotalSize(Integer num) {
        this.totalSize = num;
    }

    public String toString() {
        return "GetOrderInfoResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ", totalSize=" + this.totalSize + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
