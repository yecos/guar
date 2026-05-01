package com.hpplay.sdk.source.bean;

import com.google.common.base.Ascii;
import com.hpplay.sdk.source.utils.ByteUtils;

/* loaded from: classes3.dex */
public class PathEventInfo extends EventInfo {
    private float duration;
    private float startRatioX;
    private float startRatioY;
    private float targetRatioX;
    private float targetRatioY;

    public PathEventInfo(float f10, float f11, float f12, float f13, int i10) {
        super(0.0f, 0.0f, 0);
        this.duration = i10;
        this.startRatioX = f10;
        this.startRatioY = f11;
        this.targetRatioX = f12;
        this.targetRatioY = f13;
    }

    public void decodeData(byte[] bArr) {
        this.startRatioX = ByteUtils.bytesToFloat(bArr, 4);
        this.startRatioY = ByteUtils.bytesToFloat(bArr, 8);
        this.targetRatioX = ByteUtils.bytesToFloat(bArr, 12);
        this.targetRatioY = ByteUtils.bytesToFloat(bArr, 16);
        this.duration = ByteUtils.bytesToFloat(bArr, 20);
    }

    @Override // com.hpplay.sdk.source.bean.EventInfo
    public byte[] getData() {
        byte[] bArr = new byte[20];
        System.arraycopy(ByteUtils.float2byte(this.startRatioX), 0, bArr, 0, 4);
        System.arraycopy(ByteUtils.float2byte(this.startRatioY), 0, bArr, 4, 4);
        System.arraycopy(ByteUtils.float2byte(this.targetRatioX), 0, bArr, 8, 4);
        System.arraycopy(ByteUtils.float2byte(this.targetRatioY), 0, bArr, 12, 4);
        System.arraycopy(ByteUtils.float2byte(this.duration), 0, bArr, 16, 4);
        return bArr;
    }

    public byte[] getDataForPath() {
        byte[] bArr = new byte[24];
        bArr[0] = Ascii.DEL;
        bArr[1] = Ascii.DEL;
        bArr[2] = 3;
        bArr[3] = (byte) 20;
        System.arraycopy(getData(), 0, bArr, 4, 20);
        return bArr;
    }

    public float getDuration() {
        return this.duration;
    }

    public float getStartRatioX() {
        return this.startRatioX;
    }

    public float getStartRatioY() {
        return this.startRatioY;
    }

    public float getTargetRatioX() {
        return this.targetRatioX;
    }

    public float getTargetRatioY() {
        return this.targetRatioY;
    }

    public PathEventInfo() {
        super(0.0f, 0.0f, 0);
    }
}
