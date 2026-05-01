package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import t9.i;

/* loaded from: classes3.dex */
public final class ThirdPartResult {
    private ArrayList<String> data;
    private String errorMessage;
    private String returnCode;

    public ThirdPartResult(String str, String str2, ArrayList<String> arrayList) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ThirdPartResult copy$default(ThirdPartResult thirdPartResult, String str, String str2, ArrayList arrayList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = thirdPartResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = thirdPartResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            arrayList = thirdPartResult.data;
        }
        return thirdPartResult.copy(str, str2, arrayList);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final ArrayList<String> component3() {
        return this.data;
    }

    public final ThirdPartResult copy(String str, String str2, ArrayList<String> arrayList) {
        return new ThirdPartResult(str, str2, arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThirdPartResult)) {
            return false;
        }
        ThirdPartResult thirdPartResult = (ThirdPartResult) obj;
        return i.b(this.returnCode, thirdPartResult.returnCode) && i.b(this.errorMessage, thirdPartResult.errorMessage) && i.b(this.data, thirdPartResult.data);
    }

    public final ArrayList<String> getData() {
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
        ArrayList<String> arrayList = this.data;
        return hashCode2 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void setData(ArrayList<String> arrayList) {
        this.data = arrayList;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "ThirdPartResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
