package com.hpplay.sdk.source.api;

import com.hpplay.sdk.source.bean.CastBean;

/* loaded from: classes3.dex */
public interface INewPlayerListener extends PlayerListenerConstant {
    void onCompletion(CastBean castBean, int i10);

    void onError(CastBean castBean, int i10, int i11);

    void onInfo(CastBean castBean, int i10, int i11);

    void onInfo(CastBean castBean, int i10, String str);

    void onLoading(CastBean castBean);

    void onPause(CastBean castBean);

    void onPositionUpdate(CastBean castBean, long j10, long j11);

    void onSeekComplete(CastBean castBean, int i10);

    void onStart(CastBean castBean);

    void onStop(CastBean castBean);

    void onVolumeChanged(CastBean castBean, float f10);
}
