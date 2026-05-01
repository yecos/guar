package mobile.com.requestframe.utils.bean;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class QueryMsgNumParams {
    private String token;
    private String userId;

    public QueryMsgNumParams(String str, String str2) {
        i.g(str, "userId");
        i.g(str2, ParamsMap.DeviceParams.KEY_AUTH_TOKEN);
        this.userId = str;
        this.token = str2;
    }

    public static /* synthetic */ QueryMsgNumParams copy$default(QueryMsgNumParams queryMsgNumParams, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = queryMsgNumParams.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = queryMsgNumParams.token;
        }
        return queryMsgNumParams.copy(str, str2);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.token;
    }

    public final QueryMsgNumParams copy(String str, String str2) {
        i.g(str, "userId");
        i.g(str2, ParamsMap.DeviceParams.KEY_AUTH_TOKEN);
        return new QueryMsgNumParams(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryMsgNumParams)) {
            return false;
        }
        QueryMsgNumParams queryMsgNumParams = (QueryMsgNumParams) obj;
        return i.b(this.userId, queryMsgNumParams.userId) && i.b(this.token, queryMsgNumParams.token);
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (this.userId.hashCode() * 31) + this.token.hashCode();
    }

    public final void setToken(String str) {
        i.g(str, "<set-?>");
        this.token = str;
    }

    public final void setUserId(String str) {
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public String toString() {
        return "QueryMsgNumParams(userId=" + this.userId + ", token=" + this.token + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
