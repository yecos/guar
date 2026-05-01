package com.hpplay.sdk.source.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.utils.ByteUtils;

/* loaded from: classes3.dex */
public class SinkTouchPointerInfo {
    private static final int BYTE_LEN = 11;
    public final int actionType;
    public final int activePointerId;
    public final int pointerId;
    public final float ratioX;
    public final float ratioY;

    public SinkTouchPointerInfo(float f10, float f11, int i10, int i11, int i12) {
        this.ratioX = f10;
        this.ratioY = f11;
        this.actionType = i10;
        this.activePointerId = i11;
        this.pointerId = i12;
    }

    private static SinkTouchPointerInfo parseOne(byte[] bArr, int i10) {
        return new SinkTouchPointerInfo(ByteUtils.bytesToFloat(bArr, i10), ByteUtils.bytesToFloat(bArr, i10 + 4), bArr[i10 + 8], bArr[i10 + 9], bArr[i10 + 10]);
    }

    public static SinkTouchPointerInfo[] parseProtocolData(byte[] bArr) {
        int length = (bArr.length - 4) / 11;
        SinkTouchPointerInfo[] sinkTouchPointerInfoArr = new SinkTouchPointerInfo[length];
        for (int i10 = 0; i10 < length; i10++) {
            sinkTouchPointerInfoArr[i10] = parseOne(bArr, (i10 * 11) + 4);
        }
        return sinkTouchPointerInfoArr;
    }

    public String toString() {
        return "SinkTouchPointerInfo{ratioX=" + this.ratioX + ", ratioY=" + this.ratioY + ", actionType=" + this.actionType + ", activePointerId=" + this.activePointerId + ", pointerId=" + this.pointerId + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
