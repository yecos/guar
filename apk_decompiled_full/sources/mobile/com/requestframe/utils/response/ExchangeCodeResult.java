package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class ExchangeCodeResult {
    private List<ExchangeCodeItem> data;
    private String errorMessage;
    private String returnCode;

    public ExchangeCodeResult(String str, String str2, List<ExchangeCodeItem> list) {
        i.g(str, "returnCode");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExchangeCodeResult copy$default(ExchangeCodeResult exchangeCodeResult, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = exchangeCodeResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = exchangeCodeResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            list = exchangeCodeResult.data;
        }
        return exchangeCodeResult.copy(str, str2, list);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final List<ExchangeCodeItem> component3() {
        return this.data;
    }

    public final ExchangeCodeResult copy(String str, String str2, List<ExchangeCodeItem> list) {
        i.g(str, "returnCode");
        return new ExchangeCodeResult(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExchangeCodeResult)) {
            return false;
        }
        ExchangeCodeResult exchangeCodeResult = (ExchangeCodeResult) obj;
        return i.b(this.returnCode, exchangeCodeResult.returnCode) && i.b(this.errorMessage, exchangeCodeResult.errorMessage) && i.b(this.data, exchangeCodeResult.data);
    }

    public final List<ExchangeCodeItem> getData() {
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
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<ExchangeCodeItem> list = this.data;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final void setData(List<ExchangeCodeItem> list) {
        this.data = list;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        i.g(str, "<set-?>");
        this.returnCode = str;
    }

    public String toString() {
        return "ExchangeCodeResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
