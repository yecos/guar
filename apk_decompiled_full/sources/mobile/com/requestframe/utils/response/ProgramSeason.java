package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class ProgramSeason implements Serializable {
    private String contentId;
    private int seasonNumber;

    public ProgramSeason(String str, int i10) {
        i.g(str, "contentId");
        this.contentId = str;
        this.seasonNumber = i10;
    }

    public static /* synthetic */ ProgramSeason copy$default(ProgramSeason programSeason, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = programSeason.contentId;
        }
        if ((i11 & 2) != 0) {
            i10 = programSeason.seasonNumber;
        }
        return programSeason.copy(str, i10);
    }

    public final String component1() {
        return this.contentId;
    }

    public final int component2() {
        return this.seasonNumber;
    }

    public final ProgramSeason copy(String str, int i10) {
        i.g(str, "contentId");
        return new ProgramSeason(str, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgramSeason)) {
            return false;
        }
        ProgramSeason programSeason = (ProgramSeason) obj;
        return i.b(this.contentId, programSeason.contentId) && this.seasonNumber == programSeason.seasonNumber;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final int getSeasonNumber() {
        return this.seasonNumber;
    }

    public int hashCode() {
        return (this.contentId.hashCode() * 31) + this.seasonNumber;
    }

    public final void setContentId(String str) {
        i.g(str, "<set-?>");
        this.contentId = str;
    }

    public final void setSeasonNumber(int i10) {
        this.seasonNumber = i10;
    }

    public String toString() {
        return "ProgramSeason(contentId=" + this.contentId + ", seasonNumber=" + this.seasonNumber + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
