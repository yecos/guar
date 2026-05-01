package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class TotalMovieList implements Serializable {
    private String cdnType;
    private List<Movie> movieList;
    private String quality;
    private String url;

    public TotalMovieList(List<Movie> list, String str, String str2, String str3) {
        i.g(str, "url");
        i.g(str2, "cdnType");
        i.g(str3, "quality");
        this.movieList = list;
        this.url = str;
        this.cdnType = str2;
        this.quality = str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TotalMovieList copy$default(TotalMovieList totalMovieList, List list, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = totalMovieList.movieList;
        }
        if ((i10 & 2) != 0) {
            str = totalMovieList.url;
        }
        if ((i10 & 4) != 0) {
            str2 = totalMovieList.cdnType;
        }
        if ((i10 & 8) != 0) {
            str3 = totalMovieList.quality;
        }
        return totalMovieList.copy(list, str, str2, str3);
    }

    public final List<Movie> component1() {
        return this.movieList;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.cdnType;
    }

    public final String component4() {
        return this.quality;
    }

    public final TotalMovieList copy(List<Movie> list, String str, String str2, String str3) {
        i.g(str, "url");
        i.g(str2, "cdnType");
        i.g(str3, "quality");
        return new TotalMovieList(list, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TotalMovieList)) {
            return false;
        }
        TotalMovieList totalMovieList = (TotalMovieList) obj;
        return i.b(this.movieList, totalMovieList.movieList) && i.b(this.url, totalMovieList.url) && i.b(this.cdnType, totalMovieList.cdnType) && i.b(this.quality, totalMovieList.quality);
    }

    public final String getCdnType() {
        return this.cdnType;
    }

    public final List<Movie> getMovieList() {
        return this.movieList;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        List<Movie> list = this.movieList;
        return ((((((list == null ? 0 : list.hashCode()) * 31) + this.url.hashCode()) * 31) + this.cdnType.hashCode()) * 31) + this.quality.hashCode();
    }

    public final void setCdnType(String str) {
        i.g(str, "<set-?>");
        this.cdnType = str;
    }

    public final void setMovieList(List<Movie> list) {
        this.movieList = list;
    }

    public final void setQuality(String str) {
        i.g(str, "<set-?>");
        this.quality = str;
    }

    public final void setUrl(String str) {
        i.g(str, "<set-?>");
        this.url = str;
    }

    public String toString() {
        return "TotalMovieList(movieList=" + this.movieList + ", url=" + this.url + ", cdnType=" + this.cdnType + ", quality=" + this.quality + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
