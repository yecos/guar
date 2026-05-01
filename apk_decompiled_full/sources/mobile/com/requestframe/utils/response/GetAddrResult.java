package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetAddrResult {
    private String data;
    private Integer len;
    private String timestamp;

    public GetAddrResult(String str, Integer num, String str2) {
        this.data = str;
        this.len = num;
        this.timestamp = str2;
    }

    public static /* synthetic */ GetAddrResult copy$default(GetAddrResult getAddrResult, String str, Integer num, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getAddrResult.data;
        }
        if ((i10 & 2) != 0) {
            num = getAddrResult.len;
        }
        if ((i10 & 4) != 0) {
            str2 = getAddrResult.timestamp;
        }
        return getAddrResult.copy(str, num, str2);
    }

    public final String component1() {
        return this.data;
    }

    public final Integer component2() {
        return this.len;
    }

    public final String component3() {
        return this.timestamp;
    }

    public final GetAddrResult copy(String str, Integer num, String str2) {
        return new GetAddrResult(str, num, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAddrResult)) {
            return false;
        }
        GetAddrResult getAddrResult = (GetAddrResult) obj;
        return i.b(this.data, getAddrResult.data) && i.b(this.len, getAddrResult.len) && i.b(this.timestamp, getAddrResult.timestamp);
    }

    public final String getData() {
        return this.data;
    }

    public final Integer getLen() {
        return this.len;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        String str = this.data;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.len;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.timestamp;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setData(String str) {
        this.data = str;
    }

    public final void setLen(Integer num) {
        this.len = num;
    }

    public final void setTimestamp(String str) {
        this.timestamp = str;
    }

    public String toString() {
        return "GetAddrResult(data=" + this.data + ", len=" + this.len + ", timestamp=" + this.timestamp + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
