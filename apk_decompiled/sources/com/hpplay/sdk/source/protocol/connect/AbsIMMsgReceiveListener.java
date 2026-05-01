package com.hpplay.sdk.source.protocol.connect;

/* loaded from: classes3.dex */
public abstract class AbsIMMsgReceiveListener {
    public static final int TYPE_ACTION_MEETING_CLOSE = 4;
    public static final int TYPE_ACTION_MEETING_KICK_OFF = 3;
    public static final int TYPE_SINK_ACCEPT_MEETING = 2;
    public static final int TYPE_SINK_SERVICE = 1;

    public void onMsgReceive(int i10, String str) {
    }
}
