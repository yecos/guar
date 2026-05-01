package com.hpplay.sdk.source.bean;

import com.hpplay.sdk.source.utils.ByteUtils;

/* loaded from: classes3.dex */
public class EventInfo {
    public static final int EVENT_INFO_LEN = 9;
    public static final int EVENT_TYPE_DOUBLE_TAP = 1;
    public static final int EVENT_TYPE_LONG_PRESS = 2;
    public static final int EVENT_TYPE_SINGLE_TAP = 0;
    public static final byte FLAG_EVENT_INFO = 1;
    public static final byte FLAG_PATH_INFO = 3;
    public static final byte FLAG_POINTER_INFO = 0;
    public static final byte FLAG_SCALE_INFO = 2;
    public static final int HEAD_LENGTH = 4;
    public static final int INDEX_FLAG = 2;
    public static final int INDEX_LEN = 3;
    public static final int PATH_INFO_LEN = 20;
    public static final int POINTER_INFO_LEN = 11;
    public static final int SCALE_INFO_LEN = 12;
    private final int eventType;
    private final float ratioX;
    private final float ratioY;

    public EventInfo(float f10, float f11, int i10) {
        this.ratioX = f10;
        this.ratioY = f11;
        this.eventType = i10;
    }

    public byte[] getData() {
        byte[] bArr = new byte[9];
        System.arraycopy(ByteUtils.float2byte(this.ratioX), 0, bArr, 0, 4);
        System.arraycopy(ByteUtils.float2byte(this.ratioY), 0, bArr, 4, 4);
        bArr[8] = (byte) this.eventType;
        return bArr;
    }
}
