package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class AddFavoriteResult implements Serializable {
    private AddFavoriteDate data;
    private String errorMessage;
    private String returnCode;

    public AddFavoriteResult(String str, String str2, AddFavoriteDate addFavoriteDate) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        i.g(addFavoriteDate, "data");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = addFavoriteDate;
    }

    public static /* synthetic */ AddFavoriteResult copy$default(AddFavoriteResult addFavoriteResult, String str, String str2, AddFavoriteDate addFavoriteDate, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = addFavoriteResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = addFavoriteResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            addFavoriteDate = addFavoriteResult.data;
        }
        return addFavoriteResult.copy(str, str2, addFavoriteDate);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final AddFavoriteDate component3() {
        return this.data;
    }

    public final AddFavoriteResult copy(String str, String str2, AddFavoriteDate addFavoriteDate) {
        i.g(str, "returnCode");
        i.g(str2, "errorMessage");
        i.g(addFavoriteDate, "data");
        return new AddFavoriteResult(str, str2, addFavoriteDate);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddFavoriteResult)) {
            return false;
        }
        AddFavoriteResult addFavoriteResult = (AddFavoriteResult) obj;
        return i.b(this.returnCode, addFavoriteResult.returnCode) && i.b(this.errorMessage, addFavoriteResult.errorMessage) && i.b(this.data, addFavoriteResult.data);
    }

    public final AddFavoriteDate getData() {
        return this.data;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        return (((this.returnCode.hashCode() * 31) + this.errorMessage.hashCode()) * 31) + this.data.hashCode();
    }

    public final void setData(AddFavoriteDate addFavoriteDate) {
        i.g(addFavoriteDate, "<set-?>");
        this.data = addFavoriteDate;
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
        return "AddFavoriteResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
