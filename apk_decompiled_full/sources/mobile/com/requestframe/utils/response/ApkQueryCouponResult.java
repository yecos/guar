package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ApkQueryCouponResult {
    private QueryCouponData data;
    private String errorMessage;
    private String returnCode;

    public ApkQueryCouponResult(String str, String str2, QueryCouponData queryCouponData) {
        i.g(str, "returnCode");
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = queryCouponData;
    }

    public static /* synthetic */ ApkQueryCouponResult copy$default(ApkQueryCouponResult apkQueryCouponResult, String str, String str2, QueryCouponData queryCouponData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = apkQueryCouponResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = apkQueryCouponResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            queryCouponData = apkQueryCouponResult.data;
        }
        return apkQueryCouponResult.copy(str, str2, queryCouponData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final QueryCouponData component3() {
        return this.data;
    }

    public final ApkQueryCouponResult copy(String str, String str2, QueryCouponData queryCouponData) {
        i.g(str, "returnCode");
        return new ApkQueryCouponResult(str, str2, queryCouponData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApkQueryCouponResult)) {
            return false;
        }
        ApkQueryCouponResult apkQueryCouponResult = (ApkQueryCouponResult) obj;
        return i.b(this.returnCode, apkQueryCouponResult.returnCode) && i.b(this.errorMessage, apkQueryCouponResult.errorMessage) && i.b(this.data, apkQueryCouponResult.data);
    }

    public final QueryCouponData getData() {
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
        QueryCouponData queryCouponData = this.data;
        return hashCode2 + (queryCouponData != null ? queryCouponData.hashCode() : 0);
    }

    public final void setData(QueryCouponData queryCouponData) {
        this.data = queryCouponData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        i.g(str, "<set-?>");
        this.returnCode = str;
    }

    public String toString() {
        return "ApkQueryCouponResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
