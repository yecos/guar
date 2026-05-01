package com.hpplay.component.common.screencupture;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public interface IScreenCaptureCallbackListener {
    public static final int EXPANSION_SCREEN = 1;
    public static final int EXTERNAL_SCREEN = 2;
    public static final int MAIN_SCREEN = 0;

    void onAudioDataCallback(byte[] bArr, int i10, int i11, int i12);

    void onInfo(int i10, String str);

    void onScreenshot(int i10);

    void onStart(int i10);

    void onStop(int i10);

    void onVideoDataCallback(ByteBuffer byteBuffer, int i10, int i11, int i12, long j10);
}
