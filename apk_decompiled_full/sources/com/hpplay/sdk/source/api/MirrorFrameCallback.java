package com.hpplay.sdk.source.api;

/* loaded from: classes3.dex */
public interface MirrorFrameCallback {
    void onVideoFrameCallback(String str, byte[] bArr, int i10, int i11, int i12, int i13, long j10);

    void onVideoFrameCallbackGLES(String str, int i10, int i11, float[] fArr, int i12, int i13, long j10);

    void onVideoFrameMixed(byte[] bArr, int i10, int i11, int i12, int i13, long j10);

    void onVideoFrameMixedGLES(int i10, int i11, float[] fArr, int i12, int i13, long j10);

    int onVideoRenderFilterCallback(int i10, int i11, int i12, int i13, int i14);
}
