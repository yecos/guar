package com.mobile.brasiltv.bean.event;

import t9.i;

/* loaded from: classes3.dex */
public final class NetworkEvent {
    private NetState mState;

    public enum NetState {
        NO_NET,
        WIFI,
        MOBILE
    }

    public NetworkEvent(NetState netState) {
        i.g(netState, "mState");
        this.mState = netState;
    }

    public final NetState getMState() {
        return this.mState;
    }

    public final void setMState(NetState netState) {
        i.g(netState, "<set-?>");
        this.mState = netState;
    }
}
