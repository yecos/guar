package com.hpplay.sdk.source.player.listener;

import com.hpplay.sdk.source.player.ICastPlayer;

/* loaded from: classes3.dex */
public interface OnInfoListener {
    public static final int INFO_POSITION_UPDATE = 100;

    void onInfo(ICastPlayer iCastPlayer, int i10, int i11, int i12);

    void onInfo(ICastPlayer iCastPlayer, int i10, String str);
}
