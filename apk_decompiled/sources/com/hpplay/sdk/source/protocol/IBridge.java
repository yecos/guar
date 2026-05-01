package com.hpplay.sdk.source.protocol;

import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.player.listener.OnCompletionListener;
import com.hpplay.sdk.source.player.listener.OnErrorListener;
import com.hpplay.sdk.source.player.listener.OnInfoListener;
import com.hpplay.sdk.source.player.listener.OnLoadingListener;
import com.hpplay.sdk.source.player.listener.OnPreparedListener;
import com.hpplay.sdk.source.player.listener.OnStateChangeListener;
import com.hpplay.sdk.source.player.listener.OnStopListener;

/* loaded from: classes3.dex */
public interface IBridge {
    void addVolume();

    void appendPlayList(String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12);

    void clearPlayList(String str);

    void pause(String str);

    void play(String str);

    void playDrama(String str, String str2);

    void playNextDrama(String str);

    void playPreDrama(String str);

    void release();

    void resume(String str);

    void seekTo(int i10);

    void setMirrorScreenSecret(boolean z10);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnLoadingListener(OnLoadingListener onLoadingListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnStateChangeListener(OnStateChangeListener onStateChangeListener);

    void setOnStopListener(OnStopListener onStopListener);

    void setSecondMirrorView(SecondMirrorView secondMirrorView);

    void setVolume(int i10);

    void setWatermarkVisible(boolean z10);

    void stop(String str);

    void subVolume();

    boolean switchExpansionScreen(boolean z10);
}
