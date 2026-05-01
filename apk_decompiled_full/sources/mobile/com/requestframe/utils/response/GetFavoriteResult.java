package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class GetFavoriteResult implements Serializable {
    private GetFavoriteDate data;
    private String errorMessage;
    private String returnCode;

    public GetFavoriteResult(String str, String str2, GetFavoriteDate getFavoriteDate) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = getFavoriteDate;
    }

    public static /* synthetic */ GetFavoriteResult copy$default(GetFavoriteResult getFavoriteResult, String str, String str2, GetFavoriteDate getFavoriteDate, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getFavoriteResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getFavoriteResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            getFavoriteDate = getFavoriteResult.data;
        }
        return getFavoriteResult.copy(str, str2, getFavoriteDate);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final GetFavoriteDate component3() {
        return this.data;
    }

    public final GetFavoriteResult copy(String str, String str2, GetFavoriteDate getFavoriteDate) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        return new GetFavoriteResult(str, str2, getFavoriteDate);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetFavoriteResult)) {
            return false;
        }
        GetFavoriteResult getFavoriteResult = (GetFavoriteResult) obj;
        return i.b(this.returnCode, getFavoriteResult.returnCode) && i.b(this.errorMessage, getFavoriteResult.errorMessage) && i.b(this.data, getFavoriteResult.data);
    }

    public final GetFavoriteDate getData() {
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
        GetFavoriteDate getFavoriteDate = this.data;
        return hashCode + (getFavoriteDate == null ? 0 : getFavoriteDate.hashCode());
    }

    public final void setData(GetFavoriteDate getFavoriteDate) {
        this.data = getFavoriteDate;
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
        return "GetFavoriteResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
