package com.hpplay.component.common.protocol;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.SourceModule;

/* loaded from: classes2.dex */
public abstract class IPushController implements SourceModule {
    public abstract void DLNARetryHttp(boolean z10);

    public abstract void addPlayList(ParamsMap paramsMap);

    public abstract void clearPlayList();

    public abstract void decreaseVolume();

    public abstract void disConnect();

    public abstract void getPlayInfo();

    public abstract void getStateInfo();

    public abstract void increaseVolume();

    public abstract void onAppPause();

    public abstract void onAppResume();

    public abstract void pause();

    public abstract void playNext();

    public abstract void playPrevious();

    public abstract void push(String str, ParamsMap paramsMap);

    public abstract void resume();

    public abstract void seekTo(int i10);

    public abstract void selectAudiotrack(int i10);

    public abstract void selectPlay(ParamsMap paramsMap);

    public abstract void setConnector(IConnector iConnector);

    public abstract void setPlayList(ParamsMap paramsMap);

    public abstract void setProtocolListener(ProtocolListener protocolListener);

    public abstract void stopPlay();
}
