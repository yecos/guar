package com.mobile.brasiltv.bean.event;

import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.db.UmengMessage;
import t9.i;

/* loaded from: classes3.dex */
public final class CheckHeartEvent {
    private UmengMessage msg;

    public CheckHeartEvent(UmengMessage umengMessage) {
        i.g(umengMessage, Constant.KEY_MSG);
        this.msg = umengMessage;
    }

    public final UmengMessage getMsg() {
        return this.msg;
    }

    public final void setMsg(UmengMessage umengMessage) {
        i.g(umengMessage, "<set-?>");
        this.msg = umengMessage;
    }
}
