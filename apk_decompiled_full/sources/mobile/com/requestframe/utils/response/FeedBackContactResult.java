package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class FeedBackContactResult {
    private List<FeedBackContactData> data;
    private String errorMessage;
    private String returnCode;

    public FeedBackContactResult(String str, String str2, List<FeedBackContactData> list) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedBackContactResult copy$default(FeedBackContactResult feedBackContactResult, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = feedBackContactResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = feedBackContactResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            list = feedBackContactResult.data;
        }
        return feedBackContactResult.copy(str, str2, list);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final List<FeedBackContactData> component3() {
        return this.data;
    }

    public final FeedBackContactResult copy(String str, String str2, List<FeedBackContactData> list) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        return new FeedBackContactResult(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedBackContactResult)) {
            return false;
        }
        FeedBackContactResult feedBackContactResult = (FeedBackContactResult) obj;
        return i.b(this.returnCode, feedBackContactResult.returnCode) && i.b(this.errorMessage, feedBackContactResult.errorMessage) && i.b(this.data, feedBackContactResult.data);
    }

    public final List<FeedBackContactData> getData() {
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
        List<FeedBackContactData> list = this.data;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public final void setData(List<FeedBackContactData> list) {
        this.data = list;
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
        return "FeedBackContactResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
