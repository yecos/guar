package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class EpgResultData {
    private String date;
    private String start;
    private String stop;
    private String title;

    public EpgResultData(String str, String str2, String str3, String str4) {
        i.g(str, "date");
        i.g(str2, "start");
        i.g(str3, "stop");
        i.g(str4, "title");
        this.date = str;
        this.start = str2;
        this.stop = str3;
        this.title = str4;
    }

    public static /* synthetic */ EpgResultData copy$default(EpgResultData epgResultData, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = epgResultData.date;
        }
        if ((i10 & 2) != 0) {
            str2 = epgResultData.start;
        }
        if ((i10 & 4) != 0) {
            str3 = epgResultData.stop;
        }
        if ((i10 & 8) != 0) {
            str4 = epgResultData.title;
        }
        return epgResultData.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.date;
    }

    public final String component2() {
        return this.start;
    }

    public final String component3() {
        return this.stop;
    }

    public final String component4() {
        return this.title;
    }

    public final EpgResultData copy(String str, String str2, String str3, String str4) {
        i.g(str, "date");
        i.g(str2, "start");
        i.g(str3, "stop");
        i.g(str4, "title");
        return new EpgResultData(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EpgResultData)) {
            return false;
        }
        EpgResultData epgResultData = (EpgResultData) obj;
        return i.b(this.date, epgResultData.date) && i.b(this.start, epgResultData.start) && i.b(this.stop, epgResultData.stop) && i.b(this.title, epgResultData.title);
    }

    public final String getDate() {
        return this.date;
    }

    public final String getStart() {
        return this.start;
    }

    public final String getStop() {
        return this.stop;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.date.hashCode() * 31) + this.start.hashCode()) * 31) + this.stop.hashCode()) * 31) + this.title.hashCode();
    }

    public final void setDate(String str) {
        i.g(str, "<set-?>");
        this.date = str;
    }

    public final void setStart(String str) {
        i.g(str, "<set-?>");
        this.start = str;
    }

    public final void setStop(String str) {
        i.g(str, "<set-?>");
        this.stop = str;
    }

    public final void setTitle(String str) {
        i.g(str, "<set-?>");
        this.title = str;
    }

    public String toString() {
        return "EpgResultData(date=" + this.date + ", start=" + this.start + ", stop=" + this.stop + ", title=" + this.title + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
