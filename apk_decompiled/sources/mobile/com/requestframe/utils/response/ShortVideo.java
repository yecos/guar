package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class ShortVideo {
    private String cdnType;
    private List<ShortMovie> movieList;
    private String quality;
    private String url;

    public ShortVideo(String str, String str2, String str3, List<ShortMovie> list) {
        i.g(str, "url");
        i.g(str2, "cdnType");
        i.g(str3, "quality");
        i.g(list, "movieList");
        this.url = str;
        this.cdnType = str2;
        this.quality = str3;
        this.movieList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShortVideo copy$default(ShortVideo shortVideo, String str, String str2, String str3, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = shortVideo.url;
        }
        if ((i10 & 2) != 0) {
            str2 = shortVideo.cdnType;
        }
        if ((i10 & 4) != 0) {
            str3 = shortVideo.quality;
        }
        if ((i10 & 8) != 0) {
            list = shortVideo.movieList;
        }
        return shortVideo.copy(str, str2, str3, list);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.cdnType;
    }

    public final String component3() {
        return this.quality;
    }

    public final List<ShortMovie> component4() {
        return this.movieList;
    }

    public final ShortVideo copy(String str, String str2, String str3, List<ShortMovie> list) {
        i.g(str, "url");
        i.g(str2, "cdnType");
        i.g(str3, "quality");
        i.g(list, "movieList");
        return new ShortVideo(str, str2, str3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShortVideo)) {
            return false;
        }
        ShortVideo shortVideo = (ShortVideo) obj;
        return i.b(this.url, shortVideo.url) && i.b(this.cdnType, shortVideo.cdnType) && i.b(this.quality, shortVideo.quality) && i.b(this.movieList, shortVideo.movieList);
    }

    public final String getCdnType() {
        return this.cdnType;
    }

    public final List<ShortMovie> getMovieList() {
        return this.movieList;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((this.url.hashCode() * 31) + this.cdnType.hashCode()) * 31) + this.quality.hashCode()) * 31) + this.movieList.hashCode();
    }

    public final void setCdnType(String str) {
        i.g(str, "<set-?>");
        this.cdnType = str;
    }

    public final void setMovieList(List<ShortMovie> list) {
        i.g(list, "<set-?>");
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
        return "ShortVideo(url=" + this.url + ", cdnType=" + this.cdnType + ", quality=" + this.quality + ", movieList=" + this.movieList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
