package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class Favorite implements Serializable {
    private String alias;
    private String contentId;
    private String contentType;
    private Integer id;
    private boolean isSelect;
    private Integer moreAudio;
    private Integer moreSubtitle;
    private String name;
    private List<ShelvePoster> posterList;
    private String posterUrl;
    private Float score;
    private String type;
    private Integer updateCount;

    public Favorite(Integer num, String str, String str2, String str3, Integer num2, String str4, Float f10, Integer num3, Integer num4, String str5, List<ShelvePoster> list, String str6, boolean z10) {
        this.id = num;
        this.contentId = str;
        this.name = str2;
        this.type = str3;
        this.updateCount = num2;
        this.alias = str4;
        this.score = f10;
        this.moreAudio = num3;
        this.moreSubtitle = num4;
        this.contentType = str5;
        this.posterList = list;
        this.posterUrl = str6;
        this.isSelect = z10;
    }

    public final Integer component1() {
        return this.id;
    }

    public final String component10() {
        return this.contentType;
    }

    public final List<ShelvePoster> component11() {
        return this.posterList;
    }

    public final String component12() {
        return this.posterUrl;
    }

    public final boolean component13() {
        return this.isSelect;
    }

    public final String component2() {
        return this.contentId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.type;
    }

    public final Integer component5() {
        return this.updateCount;
    }

    public final String component6() {
        return this.alias;
    }

    public final Float component7() {
        return this.score;
    }

    public final Integer component8() {
        return this.moreAudio;
    }

    public final Integer component9() {
        return this.moreSubtitle;
    }

    public final Favorite copy(Integer num, String str, String str2, String str3, Integer num2, String str4, Float f10, Integer num3, Integer num4, String str5, List<ShelvePoster> list, String str6, boolean z10) {
        return new Favorite(num, str, str2, str3, num2, str4, f10, num3, num4, str5, list, str6, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Favorite)) {
            return false;
        }
        Favorite favorite = (Favorite) obj;
        return i.b(this.id, favorite.id) && i.b(this.contentId, favorite.contentId) && i.b(this.name, favorite.name) && i.b(this.type, favorite.type) && i.b(this.updateCount, favorite.updateCount) && i.b(this.alias, favorite.alias) && i.b(this.score, favorite.score) && i.b(this.moreAudio, favorite.moreAudio) && i.b(this.moreSubtitle, favorite.moreSubtitle) && i.b(this.contentType, favorite.contentType) && i.b(this.posterList, favorite.posterList) && i.b(this.posterUrl, favorite.posterUrl) && this.isSelect == favorite.isSelect;
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final Integer getId() {
        return this.id;
    }

    public final Integer getMoreAudio() {
        return this.moreAudio;
    }

    public final Integer getMoreSubtitle() {
        return this.moreSubtitle;
    }

    public final String getName() {
        return this.name;
    }

    public final List<ShelvePoster> getPosterList() {
        return this.posterList;
    }

    public final String getPosterUrl() {
        return this.posterUrl;
    }

    public final Float getScore() {
        return this.score;
    }

    public final String getType() {
        return this.type;
    }

    public final Integer getUpdateCount() {
        return this.updateCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.contentId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.type;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.updateCount;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.alias;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Float f10 = this.score;
        int hashCode7 = (hashCode6 + (f10 == null ? 0 : f10.hashCode())) * 31;
        Integer num3 = this.moreAudio;
        int hashCode8 = (hashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.moreSubtitle;
        int hashCode9 = (hashCode8 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str5 = this.contentType;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<ShelvePoster> list = this.posterList;
        int hashCode11 = (hashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        String str6 = this.posterUrl;
        int hashCode12 = (hashCode11 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z10 = this.isSelect;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode12 + i10;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setAlias(String str) {
        this.alias = str;
    }

    public final void setContentId(String str) {
        this.contentId = str;
    }

    public final void setContentType(String str) {
        this.contentType = str;
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    public final void setMoreAudio(Integer num) {
        this.moreAudio = num;
    }

    public final void setMoreSubtitle(Integer num) {
        this.moreSubtitle = num;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPosterList(List<ShelvePoster> list) {
        this.posterList = list;
    }

    public final void setPosterUrl(String str) {
        this.posterUrl = str;
    }

    public final void setScore(Float f10) {
        this.score = f10;
    }

    public final void setSelect(boolean z10) {
        this.isSelect = z10;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setUpdateCount(Integer num) {
        this.updateCount = num;
    }

    public String toString() {
        return "Favorite(id=" + this.id + ", contentId=" + this.contentId + ", name=" + this.name + ", type=" + this.type + ", updateCount=" + this.updateCount + ", alias=" + this.alias + ", score=" + this.score + ", moreAudio=" + this.moreAudio + ", moreSubtitle=" + this.moreSubtitle + ", contentType=" + this.contentType + ", posterList=" + this.posterList + ", posterUrl=" + this.posterUrl + ", isSelect=" + this.isSelect + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public /* synthetic */ Favorite(Integer num, String str, String str2, String str3, Integer num2, String str4, Float f10, Integer num3, Integer num4, String str5, List list, String str6, boolean z10, int i10, g gVar) {
        this(num, str, str2, str3, num2, str4, f10, num3, num4, str5, list, str6, (i10 & 4096) != 0 ? false : z10);
    }
}
