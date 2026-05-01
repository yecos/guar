package com.mobile.brasiltv.bean.event;

import t9.i;

/* loaded from: classes3.dex */
public final class UpdateFavStatusEvent {
    private String channelCode;
    private boolean isFav;

    public UpdateFavStatusEvent(String str, boolean z10) {
        i.g(str, "channelCode");
        this.channelCode = str;
        this.isFav = z10;
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final boolean isFav() {
        return this.isFav;
    }

    public final void setChannelCode(String str) {
        i.g(str, "<set-?>");
        this.channelCode = str;
    }

    public final void setFav(boolean z10) {
        this.isFav = z10;
    }
}
