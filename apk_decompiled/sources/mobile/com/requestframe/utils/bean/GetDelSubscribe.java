package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.Arrays;
import t9.i;

/* loaded from: classes3.dex */
public final class GetDelSubscribe {
    private int[] delList;
    private String userId;
    private String userToken;

    public GetDelSubscribe(String str, String str2, int[] iArr) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(iArr, "delList");
        this.userToken = str;
        this.userId = str2;
        this.delList = iArr;
    }

    public static /* synthetic */ GetDelSubscribe copy$default(GetDelSubscribe getDelSubscribe, String str, String str2, int[] iArr, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getDelSubscribe.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = getDelSubscribe.userId;
        }
        if ((i10 & 4) != 0) {
            iArr = getDelSubscribe.delList;
        }
        return getDelSubscribe.copy(str, str2, iArr);
    }

    public final String component1() {
        return this.userToken;
    }

    public final String component2() {
        return this.userId;
    }

    public final int[] component3() {
        return this.delList;
    }

    public final GetDelSubscribe copy(String str, String str2, int[] iArr) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(iArr, "delList");
        return new GetDelSubscribe(str, str2, iArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetDelSubscribe)) {
            return false;
        }
        GetDelSubscribe getDelSubscribe = (GetDelSubscribe) obj;
        return i.b(this.userToken, getDelSubscribe.userToken) && i.b(this.userId, getDelSubscribe.userId) && i.b(this.delList, getDelSubscribe.delList);
    }

    public final int[] getDelList() {
        return this.delList;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + Arrays.hashCode(this.delList);
    }

    public final void setDelList(int[] iArr) {
        i.g(iArr, "<set-?>");
        this.delList = iArr;
    }

    public final void setUserId(String str) {
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public final void setUserToken(String str) {
        i.g(str, "<set-?>");
        this.userToken = str;
    }

    public String toString() {
        return "GetDelSubscribe(userToken=" + this.userToken + ", userId=" + this.userId + ", delList=" + Arrays.toString(this.delList) + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
