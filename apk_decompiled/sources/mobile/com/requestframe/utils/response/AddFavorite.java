package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class AddFavorite implements Serializable {
    private String contentId;
    private Integer favoriteId;

    public AddFavorite(String str, Integer num) {
        i.g(str, "contentId");
        this.contentId = str;
        this.favoriteId = num;
    }

    public static /* synthetic */ AddFavorite copy$default(AddFavorite addFavorite, String str, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = addFavorite.contentId;
        }
        if ((i10 & 2) != 0) {
            num = addFavorite.favoriteId;
        }
        return addFavorite.copy(str, num);
    }

    public final String component1() {
        return this.contentId;
    }

    public final Integer component2() {
        return this.favoriteId;
    }

    public final AddFavorite copy(String str, Integer num) {
        i.g(str, "contentId");
        return new AddFavorite(str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddFavorite)) {
            return false;
        }
        AddFavorite addFavorite = (AddFavorite) obj;
        return i.b(this.contentId, addFavorite.contentId) && i.b(this.favoriteId, addFavorite.favoriteId);
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final Integer getFavoriteId() {
        return this.favoriteId;
    }

    public int hashCode() {
        int hashCode = this.contentId.hashCode() * 31;
        Integer num = this.favoriteId;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public final void setContentId(String str) {
        i.g(str, "<set-?>");
        this.contentId = str;
    }

    public final void setFavoriteId(Integer num) {
        this.favoriteId = num;
    }

    public String toString() {
        return "AddFavorite(contentId=" + this.contentId + ", favoriteId=" + this.favoriteId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
