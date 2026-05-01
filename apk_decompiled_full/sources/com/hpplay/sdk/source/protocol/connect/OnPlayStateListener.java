package com.hpplay.sdk.source.protocol.connect;

/* loaded from: classes3.dex */
public interface OnPlayStateListener {
    void onError(String str, String str2);

    void onPause(String str);

    void onPlaying(String str, int i10, int i11);

    void onStart(String str);

    void onStop(String str, int i10);
}
