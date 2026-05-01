package com.mobile.brasiltv.bean.event;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import mobile.com.requestframe.utils.response.ProgramSeason;
import t9.i;

/* loaded from: classes3.dex */
public final class SelectedSeason {
    private final ProgramSeason programSeason;

    public SelectedSeason(ProgramSeason programSeason) {
        i.g(programSeason, "programSeason");
        this.programSeason = programSeason;
    }

    public static /* synthetic */ SelectedSeason copy$default(SelectedSeason selectedSeason, ProgramSeason programSeason, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            programSeason = selectedSeason.programSeason;
        }
        return selectedSeason.copy(programSeason);
    }

    public final ProgramSeason component1() {
        return this.programSeason;
    }

    public final SelectedSeason copy(ProgramSeason programSeason) {
        i.g(programSeason, "programSeason");
        return new SelectedSeason(programSeason);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SelectedSeason) && i.b(this.programSeason, ((SelectedSeason) obj).programSeason);
    }

    public final ProgramSeason getProgramSeason() {
        return this.programSeason;
    }

    public int hashCode() {
        return this.programSeason.hashCode();
    }

    public String toString() {
        return "SelectedSeason(programSeason=" + this.programSeason + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
