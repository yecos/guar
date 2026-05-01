package com.hpplay.sdk.source.player;

import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.OutParameter;

/* loaded from: classes3.dex */
public interface IPlayer {
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYBACK_COMPLETED = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_PREPARING = 1;
    public static final int STATE_STOPPED = 6;

    void addVolume();

    boolean appendPlayList(String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12);

    boolean clearPlayList(String str);

    boolean pause(String str);

    boolean playDrama(String str, String str2);

    boolean playNextDrama(String str);

    boolean playPreDrama(String str);

    void release(String str);

    boolean resume(String str);

    boolean seekTo(String str, int i10);

    void selectAudiotrack(int i10);

    void setDataSource(OutParameter outParameter);

    void setMirrorScreenSecret(boolean z10);

    void setSecondMirrorView(SecondMirrorView secondMirrorView);

    void setVolume(int i10);

    void setWatermarkVisible(boolean z10);

    boolean start(String str);

    void stop(String str);

    void subVolume();

    boolean switchExpansionScreen(boolean z10);
}
