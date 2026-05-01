package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class SnTokenData {
    private String isNew;
    private String sn;
    private String snToken;
    private String userId;

    public SnTokenData(String str, String str2, String str3, String str4) {
        i.g(str2, "isNew");
        this.snToken = str;
        this.isNew = str2;
        this.userId = str3;
        this.sn = str4;
    }

    public static /* synthetic */ SnTokenData copy$default(SnTokenData snTokenData, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = snTokenData.snToken;
        }
        if ((i10 & 2) != 0) {
            str2 = snTokenData.isNew;
        }
        if ((i10 & 4) != 0) {
            str3 = snTokenData.userId;
        }
        if ((i10 & 8) != 0) {
            str4 = snTokenData.sn;
        }
        return snTokenData.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.snToken;
    }

    public final String component2() {
        return this.isNew;
    }

    public final String component3() {
        return this.userId;
    }

    public final String component4() {
        return this.sn;
    }

    public final SnTokenData copy(String str, String str2, String str3, String str4) {
        i.g(str2, "isNew");
        return new SnTokenData(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SnTokenData)) {
            return false;
        }
        SnTokenData snTokenData = (SnTokenData) obj;
        return i.b(this.snToken, snTokenData.snToken) && i.b(this.isNew, snTokenData.isNew) && i.b(this.userId, snTokenData.userId) && i.b(this.sn, snTokenData.sn);
    }

    public final String getSn() {
        return this.sn;
    }

    public final String getSnToken() {
        return this.snToken;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.snToken;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.isNew.hashCode()) * 31;
        String str2 = this.userId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sn;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String isNew() {
        return this.isNew;
    }

    public final void setNew(String str) {
        i.g(str, "<set-?>");
        this.isNew = str;
    }

    public final void setSn(String str) {
        this.sn = str;
    }

    public final void setSnToken(String str) {
        this.snToken = str;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "SnTokenData(snToken=" + this.snToken + ", isNew=" + this.isNew + ", userId=" + this.userId + ", sn=" + this.sn + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
