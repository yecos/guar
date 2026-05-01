package com.hpplay.component.common.protocol;

/* loaded from: classes2.dex */
public interface IMirrorStateListener {
    void onBitrateCallback(int i10);

    void onBroken();

    void onError(int i10, String str);

    void onFrameCallback(int i10);

    void onMirrorModeCallback(String str);

    void onNetStateChange(int i10);

    boolean onNetworkPoor();

    void onPauseEncode();

    void onResolutionCallback(int i10, int i11);

    void onResumeEncode();

    void onSinkPrepared(int i10, int i11, int i12, int i13, String str);

    void onSinkStop(String str, int i10);

    void resetEncoder();
}
