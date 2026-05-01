package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ApkReceiveCouponResult {
    private String data;
    private String errorMessage;
    private String returnCode;

    public ApkReceiveCouponResult(String str, String str2, String str3) {
        i.g(str, "returnCode");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = str3;
    }

    public static /* synthetic */ ApkReceiveCouponResult copy$default(ApkReceiveCouponResult apkReceiveCouponResult, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = apkReceiveCouponResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = apkReceiveCouponResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            str3 = apkReceiveCouponResult.data;
        }
        return apkReceiveCouponResult.copy(str, str2, str3);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final String component3() {
        return this.data;
    }

    public final ApkReceiveCouponResult copy(String str, String str2, String str3) {
        i.g(str, "returnCode");
        return new ApkReceiveCouponResult(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApkReceiveCouponResult)) {
            return false;
        }
        ApkReceiveCouponResult apkReceiveCouponResult = (ApkReceiveCouponResult) obj;
        return i.b(this.returnCode, apkReceiveCouponResult.returnCode) && i.b(this.errorMessage, apkReceiveCouponResult.errorMessage) && i.b(this.data, apkReceiveCouponResult.data);
    }

    public final String getData() {
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
        String str2 = this.data;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setData(String str) {
        this.data = str;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        i.g(str, "<set-?>");
        this.returnCode = str;
    }

    public String toString() {
        return "ApkReceiveCouponResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
