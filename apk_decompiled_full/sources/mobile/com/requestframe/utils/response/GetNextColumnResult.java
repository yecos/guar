package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class GetNextColumnResult implements Serializable {
    private GetNextColumnData data;
    private String errorMessage;
    private String returnCode;

    public GetNextColumnResult(String str, String str2, GetNextColumnData getNextColumnData) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = getNextColumnData;
    }

    public static /* synthetic */ GetNextColumnResult copy$default(GetNextColumnResult getNextColumnResult, String str, String str2, GetNextColumnData getNextColumnData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getNextColumnResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getNextColumnResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            getNextColumnData = getNextColumnResult.data;
        }
        return getNextColumnResult.copy(str, str2, getNextColumnData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final GetNextColumnData component3() {
        return this.data;
    }

    public final GetNextColumnResult copy(String str, String str2, GetNextColumnData getNextColumnData) {
        return new GetNextColumnResult(str, str2, getNextColumnData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetNextColumnResult)) {
            return false;
        }
        GetNextColumnResult getNextColumnResult = (GetNextColumnResult) obj;
        return i.b(this.returnCode, getNextColumnResult.returnCode) && i.b(this.errorMessage, getNextColumnResult.errorMessage) && i.b(this.data, getNextColumnResult.data);
    }

    public final GetNextColumnData getData() {
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
        GetNextColumnData getNextColumnData = this.data;
        return hashCode2 + (getNextColumnData != null ? getNextColumnData.hashCode() : 0);
    }

    public final void setData(GetNextColumnData getNextColumnData) {
        this.data = getNextColumnData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "GetNextColumnResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
