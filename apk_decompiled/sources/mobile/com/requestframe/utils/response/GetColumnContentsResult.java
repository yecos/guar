package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class GetColumnContentsResult implements Serializable {
    private ColumnContentsBean data;
    private String errorMessage;
    private String returnCode;

    public GetColumnContentsResult(String str, String str2, ColumnContentsBean columnContentsBean) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = columnContentsBean;
    }

    public static /* synthetic */ GetColumnContentsResult copy$default(GetColumnContentsResult getColumnContentsResult, String str, String str2, ColumnContentsBean columnContentsBean, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getColumnContentsResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getColumnContentsResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            columnContentsBean = getColumnContentsResult.data;
        }
        return getColumnContentsResult.copy(str, str2, columnContentsBean);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final ColumnContentsBean component3() {
        return this.data;
    }

    public final GetColumnContentsResult copy(String str, String str2, ColumnContentsBean columnContentsBean) {
        return new GetColumnContentsResult(str, str2, columnContentsBean);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetColumnContentsResult)) {
            return false;
        }
        GetColumnContentsResult getColumnContentsResult = (GetColumnContentsResult) obj;
        return i.b(this.returnCode, getColumnContentsResult.returnCode) && i.b(this.errorMessage, getColumnContentsResult.errorMessage) && i.b(this.data, getColumnContentsResult.data);
    }

    public final ColumnContentsBean getData() {
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
        ColumnContentsBean columnContentsBean = this.data;
        return hashCode2 + (columnContentsBean != null ? columnContentsBean.hashCode() : 0);
    }

    public final void setData(ColumnContentsBean columnContentsBean) {
        this.data = columnContentsBean;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "GetColumnContentsResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
