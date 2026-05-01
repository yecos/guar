package com.mobile.brasiltv.bean.event;

import t9.i;

/* loaded from: classes3.dex */
public final class CastPlaySuccessEvent {
    private String fromType;

    public CastPlaySuccessEvent(String str) {
        i.g(str, "fromType");
        this.fromType = str;
    }

    public final String getFromType() {
        return this.fromType;
    }

    public final void setFromType(String str) {
        i.g(str, "<set-?>");
        this.fromType = str;
    }
}
