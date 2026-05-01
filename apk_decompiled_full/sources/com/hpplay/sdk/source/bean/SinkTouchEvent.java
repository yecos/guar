package com.hpplay.sdk.source.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class SinkTouchEvent {
    public static final int HEAD_BYTE_LEN = 4;
    public static final int INDEX_POINTER_DATA_LEN = 3;
    public final SinkTouchPointerInfo[] pointerInfos;

    public SinkTouchEvent(SinkTouchPointerInfo[] sinkTouchPointerInfoArr) {
        this.pointerInfos = sinkTouchPointerInfoArr;
    }

    public static SinkTouchEvent parseProtocolData(byte[] bArr) {
        return new SinkTouchEvent(SinkTouchPointerInfo.parseProtocolData(bArr));
    }

    public String toString() {
        return "SinkTouchEvent{pointerInfos=" + Arrays.toString(this.pointerInfos) + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
