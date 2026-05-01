package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class TopUserResult {
    private List<TopUserData> data;
    private String errorMessage;
    private String returnCode;

    public TopUserResult(String str, String str2, List<TopUserData> list) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TopUserResult copy$default(TopUserResult topUserResult, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = topUserResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = topUserResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            list = topUserResult.data;
        }
        return topUserResult.copy(str, str2, list);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final List<TopUserData> component3() {
        return this.data;
    }

    public final TopUserResult copy(String str, String str2, List<TopUserData> list) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        return new TopUserResult(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TopUserResult)) {
            return false;
        }
        TopUserResult topUserResult = (TopUserResult) obj;
        return i.b(this.returnCode, topUserResult.returnCode) && i.b(this.errorMessage, topUserResult.errorMessage) && i.b(this.data, topUserResult.data);
    }

    public final List<TopUserData> getData() {
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
        List<TopUserData> list = this.data;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public final void setData(List<TopUserData> list) {
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
        return "TopUserResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
