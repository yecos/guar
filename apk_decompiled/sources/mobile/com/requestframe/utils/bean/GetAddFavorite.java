package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class GetAddFavorite {
    private String blFlag;
    private List<String> contentIdList;
    private String type;
    private String userId;
    private String userToken;

    public GetAddFavorite(String str, String str2, String str3, List<String> list, String str4) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "type");
        i.g(list, "contentIdList");
        i.g(str4, "blFlag");
        this.userToken = str;
        this.userId = str2;
        this.type = str3;
        this.contentIdList = list;
        this.blFlag = str4;
    }

    public static /* synthetic */ GetAddFavorite copy$default(GetAddFavorite getAddFavorite, String str, String str2, String str3, List list, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = getAddFavorite.userToken;
        }
        if ((i10 & 2) != 0) {
            str2 = getAddFavorite.userId;
        }
        String str5 = str2;
        if ((i10 & 4) != 0) {
            str3 = getAddFavorite.type;
        }
        String str6 = str3;
        if ((i10 & 8) != 0) {
            list = getAddFavorite.contentIdList;
        }
        List list2 = list;
        if ((i10 & 16) != 0) {
            str4 = getAddFavorite.blFlag;
        }
        return getAddFavorite.copy(str, str5, str6, list2, str4);
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

    public final List<String> component4() {
        return this.contentIdList;
    }

    public final String component5() {
        return this.blFlag;
    }

    public final GetAddFavorite copy(String str, String str2, String str3, List<String> list, String str4) {
        i.g(str, "userToken");
        i.g(str2, "userId");
        i.g(str3, "type");
        i.g(list, "contentIdList");
        i.g(str4, "blFlag");
        return new GetAddFavorite(str, str2, str3, list, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAddFavorite)) {
            return false;
        }
        GetAddFavorite getAddFavorite = (GetAddFavorite) obj;
        return i.b(this.userToken, getAddFavorite.userToken) && i.b(this.userId, getAddFavorite.userId) && i.b(this.type, getAddFavorite.type) && i.b(this.contentIdList, getAddFavorite.contentIdList) && i.b(this.blFlag, getAddFavorite.blFlag);
    }

    public final String getBlFlag() {
        return this.blFlag;
    }

    public final List<String> getContentIdList() {
        return this.contentIdList;
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
        return (((((((this.userToken.hashCode() * 31) + this.userId.hashCode()) * 31) + this.type.hashCode()) * 31) + this.contentIdList.hashCode()) * 31) + this.blFlag.hashCode();
    }

    public final void setBlFlag(String str) {
        i.g(str, "<set-?>");
        this.blFlag = str;
    }

    public final void setContentIdList(List<String> list) {
        i.g(list, "<set-?>");
        this.contentIdList = list;
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
        return "GetAddFavorite(userToken=" + this.userToken + ", userId=" + this.userId + ", type=" + this.type + ", contentIdList=" + this.contentIdList + ", blFlag=" + this.blFlag + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
