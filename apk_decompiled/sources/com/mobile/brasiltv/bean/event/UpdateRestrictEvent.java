package com.mobile.brasiltv.bean.event;

import com.hpplay.sdk.source.common.global.Constant;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class UpdateRestrictEvent {
    private boolean isSwitchOpen;
    private String status;

    public UpdateRestrictEvent(String str, boolean z10) {
        i.g(str, Constant.KEY_STATUS);
        this.status = str;
        this.isSwitchOpen = z10;
    }

    public final String getStatus() {
        return this.status;
    }

    public final boolean isSwitchOpen() {
        return this.isSwitchOpen;
    }

    public final void setStatus(String str) {
        i.g(str, "<set-?>");
        this.status = str;
    }

    public final void setSwitchOpen(boolean z10) {
        this.isSwitchOpen = z10;
    }

    public /* synthetic */ UpdateRestrictEvent(String str, boolean z10, int i10, g gVar) {
        this(str, (i10 & 2) != 0 ? false : z10);
    }
}
