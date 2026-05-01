package com.mobile.brasiltv.bean.event;

import t9.g;

/* loaded from: classes3.dex */
public final class CastExperienceModelToPlayEvent {
    private boolean isDLNA;

    public CastExperienceModelToPlayEvent() {
        this(false, 1, null);
    }

    public final boolean isDLNA() {
        return this.isDLNA;
    }

    public final void setDLNA(boolean z10) {
        this.isDLNA = z10;
    }

    public CastExperienceModelToPlayEvent(boolean z10) {
        this.isDLNA = z10;
    }

    public /* synthetic */ CastExperienceModelToPlayEvent(boolean z10, int i10, g gVar) {
        this((i10 & 1) != 0 ? true : z10);
    }
}
