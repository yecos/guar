package com.hpplay.sdk.source.player;

import com.hpplay.sdk.source.player.listener.OnCompletionListener;
import com.hpplay.sdk.source.player.listener.OnErrorListener;
import com.hpplay.sdk.source.player.listener.OnInfoListener;
import com.hpplay.sdk.source.player.listener.OnLoadingListener;
import com.hpplay.sdk.source.player.listener.OnPreparedListener;
import com.hpplay.sdk.source.player.listener.OnStateChangeListener;
import com.hpplay.sdk.source.player.listener.OnStopListener;

/* loaded from: classes3.dex */
public interface ICastPlayer extends IPlayer {
    void onAppPause();

    void onAppResume();

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnLoadingListener(OnLoadingListener onLoadingListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnStateChangeListener(OnStateChangeListener onStateChangeListener);

    void setOnStopListener(OnStopListener onStopListener);
}
