package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class FreeProduct {
    private String preAuthDays;
    private String productCode;
    private String productName;

    public FreeProduct(String str, String str2, String str3) {
        i.g(str, "productCode");
        i.g(str2, "preAuthDays");
        i.g(str3, "productName");
        this.productCode = str;
        this.preAuthDays = str2;
        this.productName = str3;
    }

    public static /* synthetic */ FreeProduct copy$default(FreeProduct freeProduct, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = freeProduct.productCode;
        }
        if ((i10 & 2) != 0) {
            str2 = freeProduct.preAuthDays;
        }
        if ((i10 & 4) != 0) {
            str3 = freeProduct.productName;
        }
        return freeProduct.copy(str, str2, str3);
    }

    public final String component1() {
        return this.productCode;
    }

    public final String component2() {
        return this.preAuthDays;
    }

    public final String component3() {
        return this.productName;
    }

    public final FreeProduct copy(String str, String str2, String str3) {
        i.g(str, "productCode");
        i.g(str2, "preAuthDays");
        i.g(str3, "productName");
        return new FreeProduct(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FreeProduct)) {
            return false;
        }
        FreeProduct freeProduct = (FreeProduct) obj;
        return i.b(this.productCode, freeProduct.productCode) && i.b(this.preAuthDays, freeProduct.preAuthDays) && i.b(this.productName, freeProduct.productName);
    }

    public final String getPreAuthDays() {
        return this.preAuthDays;
    }

    public final String getProductCode() {
        return this.productCode;
    }

    public final String getProductName() {
        return this.productName;
    }

    public int hashCode() {
        return (((this.productCode.hashCode() * 31) + this.preAuthDays.hashCode()) * 31) + this.productName.hashCode();
    }

    public final void setPreAuthDays(String str) {
        i.g(str, "<set-?>");
        this.preAuthDays = str;
    }

    public final void setProductCode(String str) {
        i.g(str, "<set-?>");
        this.productCode = str;
    }

    public final void setProductName(String str) {
        i.g(str, "<set-?>");
        this.productName = str;
    }

    public String toString() {
        return "FreeProduct(productCode=" + this.productCode + ", preAuthDays=" + this.preAuthDays + ", productName=" + this.productName + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
