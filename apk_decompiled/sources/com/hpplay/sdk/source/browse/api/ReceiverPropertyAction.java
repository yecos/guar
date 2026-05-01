package com.hpplay.sdk.source.browse.api;

/* loaded from: classes3.dex */
public enum ReceiverPropertyAction {
    ACTION_RECEIVER_PROPERTY_PLAYER(0),
    ACTION_RECEIVER_PROPERTY_PLAY_MODE(1),
    ACTION_RECEIVER_PROPERTY_ANGLE(2);

    private int action;

    ReceiverPropertyAction(int i10) {
        this.action = i10;
    }

    public int getValue() {
        return this.action;
    }
}
