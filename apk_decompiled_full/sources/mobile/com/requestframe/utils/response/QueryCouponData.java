package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class QueryCouponData {
    private List<CouponCodeList> couponCodeList;
    private int dataCacheTime;
    private List<AvailableCouponCodeList> receiveCouponCodeList;
    private String receiveFlag;

    public QueryCouponData(List<CouponCodeList> list, String str, int i10, List<AvailableCouponCodeList> list2) {
        i.g(str, "receiveFlag");
        this.couponCodeList = list;
        this.receiveFlag = str;
        this.dataCacheTime = i10;
        this.receiveCouponCodeList = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QueryCouponData copy$default(QueryCouponData queryCouponData, List list, String str, int i10, List list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = queryCouponData.couponCodeList;
        }
        if ((i11 & 2) != 0) {
            str = queryCouponData.receiveFlag;
        }
        if ((i11 & 4) != 0) {
            i10 = queryCouponData.dataCacheTime;
        }
        if ((i11 & 8) != 0) {
            list2 = queryCouponData.receiveCouponCodeList;
        }
        return queryCouponData.copy(list, str, i10, list2);
    }

    public final List<CouponCodeList> component1() {
        return this.couponCodeList;
    }

    public final String component2() {
        return this.receiveFlag;
    }

    public final int component3() {
        return this.dataCacheTime;
    }

    public final List<AvailableCouponCodeList> component4() {
        return this.receiveCouponCodeList;
    }

    public final QueryCouponData copy(List<CouponCodeList> list, String str, int i10, List<AvailableCouponCodeList> list2) {
        i.g(str, "receiveFlag");
        return new QueryCouponData(list, str, i10, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryCouponData)) {
            return false;
        }
        QueryCouponData queryCouponData = (QueryCouponData) obj;
        return i.b(this.couponCodeList, queryCouponData.couponCodeList) && i.b(this.receiveFlag, queryCouponData.receiveFlag) && this.dataCacheTime == queryCouponData.dataCacheTime && i.b(this.receiveCouponCodeList, queryCouponData.receiveCouponCodeList);
    }

    public final List<CouponCodeList> getCouponCodeList() {
        return this.couponCodeList;
    }

    public final int getDataCacheTime() {
        return this.dataCacheTime;
    }

    public final List<AvailableCouponCodeList> getReceiveCouponCodeList() {
        return this.receiveCouponCodeList;
    }

    public final String getReceiveFlag() {
        return this.receiveFlag;
    }

    public int hashCode() {
        List<CouponCodeList> list = this.couponCodeList;
        int hashCode = (((((list == null ? 0 : list.hashCode()) * 31) + this.receiveFlag.hashCode()) * 31) + this.dataCacheTime) * 31;
        List<AvailableCouponCodeList> list2 = this.receiveCouponCodeList;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setCouponCodeList(List<CouponCodeList> list) {
        this.couponCodeList = list;
    }

    public final void setDataCacheTime(int i10) {
        this.dataCacheTime = i10;
    }

    public final void setReceiveCouponCodeList(List<AvailableCouponCodeList> list) {
        this.receiveCouponCodeList = list;
    }

    public final void setReceiveFlag(String str) {
        i.g(str, "<set-?>");
        this.receiveFlag = str;
    }

    public String toString() {
        return "QueryCouponData(couponCodeList=" + this.couponCodeList + ", receiveFlag=" + this.receiveFlag + ", dataCacheTime=" + this.dataCacheTime + ", receiveCouponCodeList=" + this.receiveCouponCodeList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
