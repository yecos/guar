package com.mobile.brasiltv.bean.event;

import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class CastToCloseOtherPlayEvent {
    private String fromType;
    private boolean stop;

    public CastToCloseOtherPlayEvent(String str, boolean z10) {
        i.g(str, "fromType");
        this.fromType = str;
        this.stop = z10;
    }

    public final String getFromType() {
        return this.fromType;
    }

    public final boolean getStop() {
        return this.stop;
    }

    public final void setFromType(String str) {
        i.g(str, "<set-?>");
        this.fromType = str;
    }

    public final void setStop(boolean z10) {
        this.stop = z10;
    }

    public /* synthetic */ CastToCloseOtherPlayEvent(String str, boolean z10, int i10, g gVar) {
        this(str, (i10 & 2) != 0 ? true : z10);
    }
}
