package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class EpisodeList implements Serializable {
    private Integer episodeNumber;
    private String programContentId;
    private List<SubData> subtitleList;
    private List<TotalMovieList> totalMovieList;

    public EpisodeList(List<TotalMovieList> list, Integer num, String str, List<SubData> list2) {
        i.g(list2, "subtitleList");
        this.totalMovieList = list;
        this.episodeNumber = num;
        this.programContentId = str;
        this.subtitleList = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EpisodeList copy$default(EpisodeList episodeList, List list, Integer num, String str, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = episodeList.totalMovieList;
        }
        if ((i10 & 2) != 0) {
            num = episodeList.episodeNumber;
        }
        if ((i10 & 4) != 0) {
            str = episodeList.programContentId;
        }
        if ((i10 & 8) != 0) {
            list2 = episodeList.subtitleList;
        }
        return episodeList.copy(list, num, str, list2);
    }

    public final List<TotalMovieList> component1() {
        return this.totalMovieList;
    }

    public final Integer component2() {
        return this.episodeNumber;
    }

    public final String component3() {
        return this.programContentId;
    }

    public final List<SubData> component4() {
        return this.subtitleList;
    }

    public final EpisodeList copy(List<TotalMovieList> list, Integer num, String str, List<SubData> list2) {
        i.g(list2, "subtitleList");
        return new EpisodeList(list, num, str, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EpisodeList)) {
            return false;
        }
        EpisodeList episodeList = (EpisodeList) obj;
        return i.b(this.totalMovieList, episodeList.totalMovieList) && i.b(this.episodeNumber, episodeList.episodeNumber) && i.b(this.programContentId, episodeList.programContentId) && i.b(this.subtitleList, episodeList.subtitleList);
    }

    public final Integer getEpisodeNumber() {
        return this.episodeNumber;
    }

    public final String getProgramContentId() {
        return this.programContentId;
    }

    public final List<SubData> getSubtitleList() {
        return this.subtitleList;
    }

    public final List<TotalMovieList> getTotalMovieList() {
        return this.totalMovieList;
    }

    public int hashCode() {
        List<TotalMovieList> list = this.totalMovieList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.episodeNumber;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.programContentId;
        return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.subtitleList.hashCode();
    }

    public final void setEpisodeNumber(Integer num) {
        this.episodeNumber = num;
    }

    public final void setProgramContentId(String str) {
        this.programContentId = str;
    }

    public final void setSubtitleList(List<SubData> list) {
        i.g(list, "<set-?>");
        this.subtitleList = list;
    }

    public final void setTotalMovieList(List<TotalMovieList> list) {
        this.totalMovieList = list;
    }

    public String toString() {
        return "EpisodeList(totalMovieList=" + this.totalMovieList + ", episodeNumber=" + this.episodeNumber + ", programContentId=" + this.programContentId + ", subtitleList=" + this.subtitleList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
