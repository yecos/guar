package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetAddrDcsBean {
    private String data;
    private int len;

    public GetAddrDcsBean(String str, int i10) {
        i.g(str, "data");
        this.data = str;
        this.len = i10;
    }

    public static /* synthetic */ GetAddrDcsBean copy$default(GetAddrDcsBean getAddrDcsBean, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = getAddrDcsBean.data;
        }
        if ((i11 & 2) != 0) {
            i10 = getAddrDcsBean.len;
        }
        return getAddrDcsBean.copy(str, i10);
    }

    public final String component1() {
        return this.data;
    }

    public final int component2() {
        return this.len;
    }

    public final GetAddrDcsBean copy(String str, int i10) {
        i.g(str, "data");
        return new GetAddrDcsBean(str, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAddrDcsBean)) {
            return false;
        }
        GetAddrDcsBean getAddrDcsBean = (GetAddrDcsBean) obj;
        return i.b(this.data, getAddrDcsBean.data) && this.len == getAddrDcsBean.len;
    }

    public final String getData() {
        return this.data;
    }

    public final int getLen() {
        return this.len;
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + this.len;
    }

    public final void setData(String str) {
        i.g(str, "<set-?>");
        this.data = str;
    }

    public final void setLen(int i10) {
        this.len = i10;
    }

    public String toString() {
        return "GetAddrDcsBean(data=" + this.data + ", len=" + this.len + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
