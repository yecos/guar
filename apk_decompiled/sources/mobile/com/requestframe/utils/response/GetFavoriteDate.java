package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class GetFavoriteDate implements Serializable {
    private List<Favorite> favoriteList;
    private Integer favoriteListTotalSize;

    public GetFavoriteDate(Integer num, List<Favorite> list) {
        this.favoriteListTotalSize = num;
        this.favoriteList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetFavoriteDate copy$default(GetFavoriteDate getFavoriteDate, Integer num, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = getFavoriteDate.favoriteListTotalSize;
        }
        if ((i10 & 2) != 0) {
            list = getFavoriteDate.favoriteList;
        }
        return getFavoriteDate.copy(num, list);
    }

    public final Integer component1() {
        return this.favoriteListTotalSize;
    }

    public final List<Favorite> component2() {
        return this.favoriteList;
    }

    public final GetFavoriteDate copy(Integer num, List<Favorite> list) {
        return new GetFavoriteDate(num, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetFavoriteDate)) {
            return false;
        }
        GetFavoriteDate getFavoriteDate = (GetFavoriteDate) obj;
        return i.b(this.favoriteListTotalSize, getFavoriteDate.favoriteListTotalSize) && i.b(this.favoriteList, getFavoriteDate.favoriteList);
    }

    public final List<Favorite> getFavoriteList() {
        return this.favoriteList;
    }

    public final Integer getFavoriteListTotalSize() {
        return this.favoriteListTotalSize;
    }

    public int hashCode() {
        Integer num = this.favoriteListTotalSize;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<Favorite> list = this.favoriteList;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public final void setFavoriteList(List<Favorite> list) {
        this.favoriteList = list;
    }

    public final void setFavoriteListTotalSize(Integer num) {
        this.favoriteListTotalSize = num;
    }

    public String toString() {
        return "GetFavoriteDate(favoriteListTotalSize=" + this.favoriteListTotalSize + ", favoriteList=" + this.favoriteList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
