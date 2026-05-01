package com.mobile.brasiltv.bean.event;

import com.hpplay.component.protocol.push.IPushHandler;
import t9.i;

/* loaded from: classes3.dex */
public final class StopPlayEvent {
    private Reason reason;

    public enum Reason {
        SCREEN_OFF,
        PRESS_HOME
    }

    public StopPlayEvent(Reason reason) {
        i.g(reason, IPushHandler.REASON);
        this.reason = reason;
    }

    public final Reason getReason() {
        return this.reason;
    }

    public final void setReason(Reason reason) {
        i.g(reason, "<set-?>");
        this.reason = reason;
    }
}
