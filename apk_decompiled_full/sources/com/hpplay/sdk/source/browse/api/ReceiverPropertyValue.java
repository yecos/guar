package com.hpplay.sdk.source.browse.api;

/* loaded from: classes3.dex */
public enum ReceiverPropertyValue {
    VALUE_AUTO_PLAYER(0),
    VALUE_SYSTEM_PLAYER(1),
    VALUE_SOFT_DECODE_PLAYER(2),
    VALUE_HARDWARE_DECODE_PLAYER(3),
    VALUE_PLAY_MODE_AUTO(0),
    VALUE_PLAY_MODE_STANDARD(1),
    VALUE__PLAY_MODE_COMPATIBLE(2),
    VALUE_ANGLE_DISABLE(0),
    VALUE_ANGLE_ENABLE(1);

    private int value;

    ReceiverPropertyValue(int i10) {
        this.value = i10;
    }

    public int getValue() {
        return this.value;
    }
}
