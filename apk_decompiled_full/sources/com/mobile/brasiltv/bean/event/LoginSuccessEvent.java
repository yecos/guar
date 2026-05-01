package com.mobile.brasiltv.bean.event;

import t9.g;

/* loaded from: classes.dex */
public final class LoginSuccessEvent {
    private String heartBeatTime;

    /* JADX WARN: Multi-variable type inference failed */
    public LoginSuccessEvent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String getHeartBeatTime() {
        return this.heartBeatTime;
    }

    public final void setHeartBeatTime(String str) {
        this.heartBeatTime = str;
    }

    public LoginSuccessEvent(String str) {
        this.heartBeatTime = str;
    }

    public /* synthetic */ LoginSuccessEvent(String str, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : str);
    }
}
