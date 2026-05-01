package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class AddFavoriteDate implements Serializable {
    private List<AddFavorite> favoriteList;

    public AddFavoriteDate(List<AddFavorite> list) {
        this.favoriteList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AddFavoriteDate copy$default(AddFavoriteDate addFavoriteDate, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = addFavoriteDate.favoriteList;
        }
        return addFavoriteDate.copy(list);
    }

    public final List<AddFavorite> component1() {
        return this.favoriteList;
    }

    public final AddFavoriteDate copy(List<AddFavorite> list) {
        return new AddFavoriteDate(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AddFavoriteDate) && i.b(this.favoriteList, ((AddFavoriteDate) obj).favoriteList);
    }

    public final List<AddFavorite> getFavoriteList() {
        return this.favoriteList;
    }

    public int hashCode() {
        List<AddFavorite> list = this.favoriteList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setFavoriteList(List<AddFavorite> list) {
        this.favoriteList = list;
    }

    public String toString() {
        return "AddFavoriteDate(favoriteList=" + this.favoriteList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
