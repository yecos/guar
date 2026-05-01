package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class GetPackageResult {
    private List<PackageInfo> data;
    private String errorMessage;
    private String returnCode;

    public GetPackageResult(String str, String str2, List<PackageInfo> list) {
        i.g(str, "returnCode");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetPackageResult copy$default(GetPackageResult getPackageResult, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getPackageResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = getPackageResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            list = getPackageResult.data;
        }
        return getPackageResult.copy(str, str2, list);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final List<PackageInfo> component3() {
        return this.data;
    }

    public final GetPackageResult copy(String str, String str2, List<PackageInfo> list) {
        i.g(str, "returnCode");
        return new GetPackageResult(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetPackageResult)) {
            return false;
        }
        GetPackageResult getPackageResult = (GetPackageResult) obj;
        return i.b(this.returnCode, getPackageResult.returnCode) && i.b(this.errorMessage, getPackageResult.errorMessage) && i.b(this.data, getPackageResult.data);
    }

    public final List<PackageInfo> getData() {
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
        List<PackageInfo> list = this.data;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final void setData(List<PackageInfo> list) {
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
        return "GetPackageResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
