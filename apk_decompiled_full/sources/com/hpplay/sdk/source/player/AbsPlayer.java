package com.hpplay.sdk.source.player;

import android.content.Context;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.StopInfo;
import com.hpplay.sdk.source.player.listener.OnCompletionListener;
import com.hpplay.sdk.source.player.listener.OnErrorListener;
import com.hpplay.sdk.source.player.listener.OnInfoListener;
import com.hpplay.sdk.source.player.listener.OnLoadingListener;
import com.hpplay.sdk.source.player.listener.OnPreparedListener;
import com.hpplay.sdk.source.player.listener.OnStateChangeListener;
import com.hpplay.sdk.source.player.listener.OnStopListener;
import com.hpplay.sdk.source.protocol.AbsBridge;

/* loaded from: classes3.dex */
public abstract class AbsPlayer implements ICastPlayer {
    protected AbsBridge mBridge;
    protected OnCompletionListener mCompletionListener;
    protected Context mContext;
    protected int mCurrentState = 0;
    protected OnErrorListener mErrorListener;
    protected OnInfoListener mInfoListener;
    protected OnLoadingListener mLoadingListener;
    protected OutParameter mPlayInfo;
    protected OnPreparedListener mPreparedListener;
    protected OnStateChangeListener mStateChangeListener;
    protected OnStopListener mStopListener;

    public AbsPlayer(Context context) {
        this.mContext = context;
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void addVolume() {
        this.mBridge.addVolume();
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean appendPlayList(String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        return false;
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean clearPlayList(String str) {
        return false;
    }

    public AbsBridge getBridge() {
        return this.mBridge;
    }

    public void initListener() {
        this.mBridge.setOnLoadingListener(new OnLoadingListener() { // from class: com.hpplay.sdk.source.player.AbsPlayer.1
            @Override // com.hpplay.sdk.source.player.listener.OnLoadingListener
            public void onLoading(ICastPlayer iCastPlayer, String str) {
                AbsPlayer absPlayer = AbsPlayer.this;
                absPlayer.mCurrentState = 1;
                OnLoadingListener onLoadingListener = absPlayer.mLoadingListener;
                if (onLoadingListener != null) {
                    onLoadingListener.onLoading(iCastPlayer, str);
                }
            }
        });
        this.mBridge.setOnPreparedListener(new OnPreparedListener() { // from class: com.hpplay.sdk.source.player.AbsPlayer.2
            @Override // com.hpplay.sdk.source.player.listener.OnPreparedListener
            public void onPrepared(ICastPlayer iCastPlayer) {
                AbsPlayer absPlayer = AbsPlayer.this;
                absPlayer.mCurrentState = 2;
                OnPreparedListener onPreparedListener = absPlayer.mPreparedListener;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(absPlayer);
                }
            }
        });
        this.mBridge.setOnStateChangeListener(new OnStateChangeListener() { // from class: com.hpplay.sdk.source.player.AbsPlayer.3
            @Override // com.hpplay.sdk.source.player.listener.OnStateChangeListener
            public void onStateChanged(ICastPlayer iCastPlayer, int i10) {
                AbsPlayer absPlayer = AbsPlayer.this;
                absPlayer.mCurrentState = i10;
                OnStateChangeListener onStateChangeListener = absPlayer.mStateChangeListener;
                if (onStateChangeListener != null) {
                    onStateChangeListener.onStateChanged(absPlayer, i10);
                }
            }
        });
        this.mBridge.setOnInfoListener(new OnInfoListener() { // from class: com.hpplay.sdk.source.player.AbsPlayer.4
            @Override // com.hpplay.sdk.source.player.listener.OnInfoListener
            public void onInfo(ICastPlayer iCastPlayer, int i10, int i11, int i12) {
                OnInfoListener onInfoListener = AbsPlayer.this.mInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(iCastPlayer, i10, i11, i12);
                }
            }

            @Override // com.hpplay.sdk.source.player.listener.OnInfoListener
            public void onInfo(ICastPlayer iCastPlayer, int i10, String str) {
                OnInfoListener onInfoListener = AbsPlayer.this.mInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(iCastPlayer, i10, str);
                }
            }
        });
        this.mBridge.setOnErrorListener(new OnErrorListener() { // from class: com.hpplay.sdk.source.player.AbsPlayer.5
            @Override // com.hpplay.sdk.source.player.listener.OnErrorListener
            public void onError(ICastPlayer iCastPlayer, int i10, int i11, String str) {
                AbsPlayer absPlayer = AbsPlayer.this;
                absPlayer.mCurrentState = -1;
                OnErrorListener onErrorListener = absPlayer.mErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(absPlayer, i10, i11, str);
                }
            }
        });
        this.mBridge.setOnCompletionListener(new OnCompletionListener() { // from class: com.hpplay.sdk.source.player.AbsPlayer.6
            @Override // com.hpplay.sdk.source.player.listener.OnCompletionListener
            public void onComplete(ICastPlayer iCastPlayer) {
                AbsPlayer absPlayer = AbsPlayer.this;
                absPlayer.mCurrentState = 5;
                OnCompletionListener onCompletionListener = absPlayer.mCompletionListener;
                if (onCompletionListener != null) {
                    onCompletionListener.onComplete(absPlayer);
                }
            }
        });
        this.mBridge.setOnStopListener(new OnStopListener() { // from class: com.hpplay.sdk.source.player.AbsPlayer.7
            @Override // com.hpplay.sdk.source.player.listener.OnStopListener
            public void onStop(ICastPlayer iCastPlayer, StopInfo stopInfo) {
                AbsPlayer absPlayer = AbsPlayer.this;
                absPlayer.mCurrentState = 6;
                OnStopListener onStopListener = absPlayer.mStopListener;
                if (onStopListener != null) {
                    onStopListener.onStop(absPlayer, stopInfo);
                }
            }
        });
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void onAppPause() {
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void onAppResume() {
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean pause(String str) {
        return false;
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean playDrama(String str, String str2) {
        return false;
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean playNextDrama(String str) {
        return false;
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean playPreDrama(String str) {
        return false;
    }

    public void removeListener() {
        this.mBridge.setOnLoadingListener(null);
        this.mBridge.setOnPreparedListener(null);
        this.mBridge.setOnStateChangeListener(null);
        this.mBridge.setOnInfoListener(null);
        this.mBridge.setOnErrorListener(null);
        this.mBridge.setOnCompletionListener(null);
        this.mBridge.setOnStopListener(null);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean seekTo(String str, int i10) {
        return false;
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void selectAudiotrack(int i10) {
        this.mBridge.selectAudiotrack(i10);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void setDataSource(OutParameter outParameter) {
        this.mPlayInfo = outParameter;
        this.mBridge.setDataSource(outParameter);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void setMirrorScreenSecret(boolean z10) {
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.mCompletionListener = onCompletionListener;
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mErrorListener = onErrorListener;
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mInfoListener = onInfoListener;
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void setOnLoadingListener(OnLoadingListener onLoadingListener) {
        this.mLoadingListener = onLoadingListener;
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.mPreparedListener = onPreparedListener;
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.mStateChangeListener = onStateChangeListener;
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void setOnStopListener(OnStopListener onStopListener) {
        this.mStopListener = onStopListener;
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void setSecondMirrorView(SecondMirrorView secondMirrorView) {
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void setVolume(int i10) {
        this.mBridge.setVolume(i10);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void setWatermarkVisible(boolean z10) {
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean start(String str) {
        return false;
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void stop(String str) {
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void subVolume() {
        this.mBridge.subVolume();
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean switchExpansionScreen(boolean z10) {
        return false;
    }
}
