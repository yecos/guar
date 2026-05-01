package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class GiftDaysData {
    private List<FreeProduct> freeProductList;
    private String productCode;

    public GiftDaysData(String str, List<FreeProduct> list) {
        i.g(str, "productCode");
        i.g(list, "freeProductList");
        this.productCode = str;
        this.freeProductList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GiftDaysData copy$default(GiftDaysData giftDaysData, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = giftDaysData.productCode;
        }
        if ((i10 & 2) != 0) {
            list = giftDaysData.freeProductList;
        }
        return giftDaysData.copy(str, list);
    }

    public final String component1() {
        return this.productCode;
    }

    public final List<FreeProduct> component2() {
        return this.freeProductList;
    }

    public final GiftDaysData copy(String str, List<FreeProduct> list) {
        i.g(str, "productCode");
        i.g(list, "freeProductList");
        return new GiftDaysData(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiftDaysData)) {
            return false;
        }
        GiftDaysData giftDaysData = (GiftDaysData) obj;
        return i.b(this.productCode, giftDaysData.productCode) && i.b(this.freeProductList, giftDaysData.freeProductList);
    }

    public final List<FreeProduct> getFreeProductList() {
        return this.freeProductList;
    }

    public final String getProductCode() {
        return this.productCode;
    }

    public int hashCode() {
        return (this.productCode.hashCode() * 31) + this.freeProductList.hashCode();
    }

    public final void setFreeProductList(List<FreeProduct> list) {
        i.g(list, "<set-?>");
        this.freeProductList = list;
    }

    public final void setProductCode(String str) {
        i.g(str, "<set-?>");
        this.productCode = str;
    }

    public String toString() {
        return "GiftDaysData(productCode=" + this.productCode + ", freeProductList=" + this.freeProductList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
