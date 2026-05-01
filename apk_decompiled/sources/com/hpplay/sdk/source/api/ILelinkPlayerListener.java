package com.hpplay.sdk.source.api;

/* loaded from: classes3.dex */
public interface ILelinkPlayerListener extends PlayerListenerConstant {
    void onCompletion();

    void onError(int i10, int i11);

    void onInfo(int i10, int i11);

    void onInfo(int i10, String str);

    void onLoading();

    void onPause();

    void onPositionUpdate(long j10, long j11);

    void onSeekComplete(int i10);

    void onStart();

    void onStop();

    void onVolumeChanged(float f10);
}
