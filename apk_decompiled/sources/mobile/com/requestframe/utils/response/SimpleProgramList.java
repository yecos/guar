package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class SimpleProgramList implements Serializable {
    private String contentId;
    private String duration;
    private float fraction;
    private String hasPositive;
    private String hasTidbits;
    private String hasTrailer;
    private boolean isDownloaded;
    private boolean isDownloading;
    private boolean isPlayed;
    private boolean isSelected;
    private String name;
    private List<? extends PosterList> posterList;
    private String quality;
    private int seriesNumber;

    public SimpleProgramList(String str, String str2, String str3, String str4, String str5, String str6, int i10, boolean z10, String str7, List<? extends PosterList> list, float f10, boolean z11, boolean z12, boolean z13) {
        i.g(str, "contentId");
        i.g(str2, "name");
        i.g(str3, "duration");
        i.g(str4, "hasPositive");
        i.g(str5, "hasTidbits");
        i.g(str6, "hasTrailer");
        this.contentId = str;
        this.name = str2;
        this.duration = str3;
        this.hasPositive = str4;
        this.hasTidbits = str5;
        this.hasTrailer = str6;
        this.seriesNumber = i10;
        this.isPlayed = z10;
        this.quality = str7;
        this.posterList = list;
        this.fraction = f10;
        this.isDownloading = z11;
        this.isDownloaded = z12;
        this.isSelected = z13;
    }

    public final String component1() {
        return this.contentId;
    }

    public final List<PosterList> component10() {
        return this.posterList;
    }

    public final float component11() {
        return this.fraction;
    }

    public final boolean component12() {
        return this.isDownloading;
    }

    public final boolean component13() {
        return this.isDownloaded;
    }

    public final boolean component14() {
        return this.isSelected;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.duration;
    }

    public final String component4() {
        return this.hasPositive;
    }

    public final String component5() {
        return this.hasTidbits;
    }

    public final String component6() {
        return this.hasTrailer;
    }

    public final int component7() {
        return this.seriesNumber;
    }

    public final boolean component8() {
        return this.isPlayed;
    }

    public final String component9() {
        return this.quality;
    }

    public final SimpleProgramList copy(String str, String str2, String str3, String str4, String str5, String str6, int i10, boolean z10, String str7, List<? extends PosterList> list, float f10, boolean z11, boolean z12, boolean z13) {
        i.g(str, "contentId");
        i.g(str2, "name");
        i.g(str3, "duration");
        i.g(str4, "hasPositive");
        i.g(str5, "hasTidbits");
        i.g(str6, "hasTrailer");
        return new SimpleProgramList(str, str2, str3, str4, str5, str6, i10, z10, str7, list, f10, z11, z12, z13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleProgramList)) {
            return false;
        }
        SimpleProgramList simpleProgramList = (SimpleProgramList) obj;
        return i.b(this.contentId, simpleProgramList.contentId) && i.b(this.name, simpleProgramList.name) && i.b(this.duration, simpleProgramList.duration) && i.b(this.hasPositive, simpleProgramList.hasPositive) && i.b(this.hasTidbits, simpleProgramList.hasTidbits) && i.b(this.hasTrailer, simpleProgramList.hasTrailer) && this.seriesNumber == simpleProgramList.seriesNumber && this.isPlayed == simpleProgramList.isPlayed && i.b(this.quality, simpleProgramList.quality) && i.b(this.posterList, simpleProgramList.posterList) && Float.compare(this.fraction, simpleProgramList.fraction) == 0 && this.isDownloading == simpleProgramList.isDownloading && this.isDownloaded == simpleProgramList.isDownloaded && this.isSelected == simpleProgramList.isSelected;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final String getHasPositive() {
        return this.hasPositive;
    }

    public final String getHasTidbits() {
        return this.hasTidbits;
    }

    public final String getHasTrailer() {
        return this.hasTrailer;
    }

    public final String getName() {
        return this.name;
    }

    public final List<PosterList> getPosterList() {
        return this.posterList;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final int getSeriesNumber() {
        return this.seriesNumber;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((this.contentId.hashCode() * 31) + this.name.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.hasPositive.hashCode()) * 31) + this.hasTidbits.hashCode()) * 31) + this.hasTrailer.hashCode()) * 31) + this.seriesNumber) * 31;
        boolean z10 = this.isPlayed;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        String str = this.quality;
        int hashCode2 = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        List<? extends PosterList> list = this.posterList;
        int hashCode3 = (((hashCode2 + (list != null ? list.hashCode() : 0)) * 31) + Float.floatToIntBits(this.fraction)) * 31;
        boolean z11 = this.isDownloading;
        int i12 = z11;
        if (z11 != 0) {
            i12 = 1;
        }
        int i13 = (hashCode3 + i12) * 31;
        boolean z12 = this.isDownloaded;
        int i14 = z12;
        if (z12 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        boolean z13 = this.isSelected;
        return i15 + (z13 ? 1 : z13 ? 1 : 0);
    }

    public final boolean isDownloaded() {
        return this.isDownloaded;
    }

    public final boolean isDownloading() {
        return this.isDownloading;
    }

    public final boolean isPlayed() {
        return this.isPlayed;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setContentId(String str) {
        i.g(str, "<set-?>");
        this.contentId = str;
    }

    public final void setDownloaded(boolean z10) {
        this.isDownloaded = z10;
    }

    public final void setDownloading(boolean z10) {
        this.isDownloading = z10;
    }

    public final void setDuration(String str) {
        i.g(str, "<set-?>");
        this.duration = str;
    }

    public final void setFraction(float f10) {
        this.fraction = f10;
    }

    public final void setHasPositive(String str) {
        i.g(str, "<set-?>");
        this.hasPositive = str;
    }

    public final void setHasTidbits(String str) {
        i.g(str, "<set-?>");
        this.hasTidbits = str;
    }

    public final void setHasTrailer(String str) {
        i.g(str, "<set-?>");
        this.hasTrailer = str;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public final void setPlayed(boolean z10) {
        this.isPlayed = z10;
    }

    public final void setPosterList(List<? extends PosterList> list) {
        this.posterList = list;
    }

    public final void setQuality(String str) {
        this.quality = str;
    }

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    public final void setSeriesNumber(int i10) {
        this.seriesNumber = i10;
    }

    public String toString() {
        return "SimpleProgramList(contentId=" + this.contentId + ", name=" + this.name + ", duration=" + this.duration + ", hasPositive=" + this.hasPositive + ", hasTidbits=" + this.hasTidbits + ", hasTrailer=" + this.hasTrailer + ", seriesNumber=" + this.seriesNumber + ", isPlayed=" + this.isPlayed + ", quality=" + this.quality + ", posterList=" + this.posterList + ", fraction=" + this.fraction + ", isDownloading=" + this.isDownloading + ", isDownloaded=" + this.isDownloaded + ", isSelected=" + this.isSelected + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public /* synthetic */ SimpleProgramList(String str, String str2, String str3, String str4, String str5, String str6, int i10, boolean z10, String str7, List list, float f10, boolean z11, boolean z12, boolean z13, int i11, g gVar) {
        this(str, str2, str3, str4, str5, str6, i10, (i11 & 128) != 0 ? false : z10, str7, list, f10, (i11 & 2048) != 0 ? false : z11, (i11 & 4096) != 0 ? false : z12, (i11 & 8192) != 0 ? false : z13);
    }
}
