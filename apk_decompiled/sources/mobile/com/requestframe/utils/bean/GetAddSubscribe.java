package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class GetAddSubscribe {
    private String contentId;
    private String name;
    private String type;
    private String userId;
    private String userToken;

    public GetAddSubscribe(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "type");
        i.g(str4, "name");
        i.g(str5, "contentId");
        this.userToken = str;
        this.userId = str2;
        this.type = str3;
        this.name = str4;
        this.contentId = str5;
    }

    public static /* synthetic */ GetAddSubscribe copy$default(GetAddSubscribe getAddSubscribe, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getAddSubscribe.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = getAddSubscribe.userId;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = getAddSubscribe.type;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = getAddSubscribe.name;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = getAddSubscribe.contentId;
        }
        return getAddSubscribe.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.userToken;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.contentId;
    }

    public final GetAddSubscribe copy(String str, String str2, String str3, String str4, String str5) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "type");
        i.g(str4, "name");
        i.g(str5, "contentId");
        return new GetAddSubscribe(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAddSubscribe)) {
            return false;
        }
        GetAddSubscribe getAddSubscribe = (GetAddSubscribe) obj;
        return i.b(this.userToken, getAddSubscribe.userToken) && i.b(this.userId, getAddSubscribe.userId) && i.b(this.type, getAddSubscribe.type) && i.b(this.name, getAddSubscribe.name) && i.b(this.contentId, getAddSubscribe.contentId);
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public int hashCode() {
        return (((((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.type.hashCode()) * 31) + this.name.hashCode()) * 31) + this.contentId.hashCode();
    }

    public final void setContentId(String str) {
        i.g(str, "<set-?>");
        this.contentId = str;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
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
        return "GetAddSubscribe(userToken=" + this.userToken + ", userId=" + this.userId + ", type=" + this.type + ", name=" + this.name + ", contentId=" + this.contentId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
