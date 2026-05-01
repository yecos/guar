package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class FilterGenreResultData {
    private List<FilterInfo> audio;
    private List<FilterInfo> fixAudio;
    private List<FilterInfo> fixCountry;
    private List<FilterInfo> fixGenre;
    private List<FilterInfo> fixYear;
    private List<String> originalCountry;
    private List<String> tags;
    private List<ChildColumnList> types;
    private List<String> year;

    public FilterGenreResultData(List<String> list, List<String> list2, List<String> list3, List<FilterInfo> list4, List<ChildColumnList> list5, List<FilterInfo> list6, List<FilterInfo> list7, List<FilterInfo> list8, List<FilterInfo> list9) {
        i.g(list, "originalCountry");
        i.g(list2, "tags");
        i.g(list3, "year");
        i.g(list4, "audio");
        i.g(list5, "types");
        i.g(list6, "fixGenre");
        i.g(list7, "fixYear");
        i.g(list8, "fixCountry");
        i.g(list9, "fixAudio");
        this.originalCountry = list;
        this.tags = list2;
        this.year = list3;
        this.audio = list4;
        this.types = list5;
        this.fixGenre = list6;
        this.fixYear = list7;
        this.fixCountry = list8;
        this.fixAudio = list9;
    }

    public final List<String> component1() {
        return this.originalCountry;
    }

    public final List<String> component2() {
        return this.tags;
    }

    public final List<String> component3() {
        return this.year;
    }

    public final List<FilterInfo> component4() {
        return this.audio;
    }

    public final List<ChildColumnList> component5() {
        return this.types;
    }

    public final List<FilterInfo> component6() {
        return this.fixGenre;
    }

    public final List<FilterInfo> component7() {
        return this.fixYear;
    }

    public final List<FilterInfo> component8() {
        return this.fixCountry;
    }

    public final List<FilterInfo> component9() {
        return this.fixAudio;
    }

    public final FilterGenreResultData copy(List<String> list, List<String> list2, List<String> list3, List<FilterInfo> list4, List<ChildColumnList> list5, List<FilterInfo> list6, List<FilterInfo> list7, List<FilterInfo> list8, List<FilterInfo> list9) {
        i.g(list, "originalCountry");
        i.g(list2, "tags");
        i.g(list3, "year");
        i.g(list4, "audio");
        i.g(list5, "types");
        i.g(list6, "fixGenre");
        i.g(list7, "fixYear");
        i.g(list8, "fixCountry");
        i.g(list9, "fixAudio");
        return new FilterGenreResultData(list, list2, list3, list4, list5, list6, list7, list8, list9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterGenreResultData)) {
            return false;
        }
        FilterGenreResultData filterGenreResultData = (FilterGenreResultData) obj;
        return i.b(this.originalCountry, filterGenreResultData.originalCountry) && i.b(this.tags, filterGenreResultData.tags) && i.b(this.year, filterGenreResultData.year) && i.b(this.audio, filterGenreResultData.audio) && i.b(this.types, filterGenreResultData.types) && i.b(this.fixGenre, filterGenreResultData.fixGenre) && i.b(this.fixYear, filterGenreResultData.fixYear) && i.b(this.fixCountry, filterGenreResultData.fixCountry) && i.b(this.fixAudio, filterGenreResultData.fixAudio);
    }

    public final List<FilterInfo> getAudio() {
        return this.audio;
    }

    public final List<FilterInfo> getFixAudio() {
        return this.fixAudio;
    }

    public final List<FilterInfo> getFixCountry() {
        return this.fixCountry;
    }

    public final List<FilterInfo> getFixGenre() {
        return this.fixGenre;
    }

    public final List<FilterInfo> getFixYear() {
        return this.fixYear;
    }

    public final List<String> getOriginalCountry() {
        return this.originalCountry;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final List<ChildColumnList> getTypes() {
        return this.types;
    }

    public final List<String> getYear() {
        return this.year;
    }

    public int hashCode() {
        return (((((((((((((((this.originalCountry.hashCode() * 31) + this.tags.hashCode()) * 31) + this.year.hashCode()) * 31) + this.audio.hashCode()) * 31) + this.types.hashCode()) * 31) + this.fixGenre.hashCode()) * 31) + this.fixYear.hashCode()) * 31) + this.fixCountry.hashCode()) * 31) + this.fixAudio.hashCode();
    }

    public final void setAudio(List<FilterInfo> list) {
        i.g(list, "<set-?>");
        this.audio = list;
    }

    public final void setFixAudio(List<FilterInfo> list) {
        i.g(list, "<set-?>");
        this.fixAudio = list;
    }

    public final void setFixCountry(List<FilterInfo> list) {
        i.g(list, "<set-?>");
        this.fixCountry = list;
    }

    public final void setFixGenre(List<FilterInfo> list) {
        i.g(list, "<set-?>");
        this.fixGenre = list;
    }

    public final void setFixYear(List<FilterInfo> list) {
        i.g(list, "<set-?>");
        this.fixYear = list;
    }

    public final void setOriginalCountry(List<String> list) {
        i.g(list, "<set-?>");
        this.originalCountry = list;
    }

    public final void setTags(List<String> list) {
        i.g(list, "<set-?>");
        this.tags = list;
    }

    public final void setTypes(List<ChildColumnList> list) {
        i.g(list, "<set-?>");
        this.types = list;
    }

    public final void setYear(List<String> list) {
        i.g(list, "<set-?>");
        this.year = list;
    }

    public String toString() {
        return "FilterGenreResultData(originalCountry=" + this.originalCountry + ", tags=" + this.tags + ", year=" + this.year + ", audio=" + this.audio + ", types=" + this.types + ", fixGenre=" + this.fixGenre + ", fixYear=" + this.fixYear + ", fixCountry=" + this.fixCountry + ", fixAudio=" + this.fixAudio + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
