package com.mobile.brasiltv.bean.event;

import mobile.com.requestframe.utils.response.UserData;
import t9.g;

/* loaded from: classes3.dex */
public final class RequestAuthAndSlbEvent {
    private boolean isNeedGetAuthInfo;
    private UserData userData;

    /* JADX WARN: Multi-variable type inference failed */
    public RequestAuthAndSlbEvent() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public final UserData getUserData() {
        return this.userData;
    }

    public final boolean isNeedGetAuthInfo() {
        return this.isNeedGetAuthInfo;
    }

    public final void setNeedGetAuthInfo(boolean z10) {
        this.isNeedGetAuthInfo = z10;
    }

    public final void setUserData(UserData userData) {
        this.userData = userData;
    }

    public RequestAuthAndSlbEvent(boolean z10, UserData userData) {
        this.isNeedGetAuthInfo = z10;
        this.userData = userData;
    }

    public /* synthetic */ RequestAuthAndSlbEvent(boolean z10, UserData userData, int i10, g gVar) {
        this((i10 & 1) != 0 ? true : z10, (i10 & 2) != 0 ? null : userData);
    }
}
