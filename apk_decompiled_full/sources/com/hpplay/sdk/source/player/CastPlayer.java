package com.hpplay.sdk.source.player;

import android.content.Context;
import android.os.Build;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.player.listener.OnCompletionListener;
import com.hpplay.sdk.source.player.listener.OnErrorListener;
import com.hpplay.sdk.source.player.listener.OnInfoListener;
import com.hpplay.sdk.source.player.listener.OnLoadingListener;
import com.hpplay.sdk.source.player.listener.OnPreparedListener;
import com.hpplay.sdk.source.player.listener.OnStateChangeListener;
import com.hpplay.sdk.source.player.listener.OnStopListener;
import com.hpplay.sdk.source.protocol.CaptureBridge;

/* loaded from: classes3.dex */
public class CastPlayer implements ICastPlayer {
    private static final String TAG = "CastPlayer";
    private Context mContext;
    private OutParameter mPlayInfo;
    private ICastPlayer mProtocolPlayer;

    public CastPlayer(Context context, OutParameter outParameter) {
        this.mContext = context;
        this.mPlayInfo = outParameter;
        initPlayer(outParameter);
    }

    private void initPlayer(OutParameter outParameter) {
        int i10;
        if (outParameter.currentBrowserInfo == null || outParameter.connectProtocol == -1) {
            SourceLog.w(TAG, "initPlayer ignore invalid service info");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("initPlayer: protocol: ");
        sb.append(outParameter.protocol);
        sb.append(" group:");
        sb.append(outParameter.isGroup);
        sb.append("  ");
        sb.append(outParameter.connectProtocol);
        if (outParameter.isGroup && (i10 = outParameter.connectProtocol) != 1 && i10 != 5) {
            this.mProtocolPlayer = new GroupPlayer(this.mContext, outParameter);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            CaptureBridge.getInstance().setICaptureDispatcher(null);
        }
        int i11 = outParameter.protocol;
        if (i11 != 1) {
            if (i11 == 3) {
                this.mProtocolPlayer = new DLNAPlayer(this.mContext, outParameter);
                return;
            }
            if (i11 == 4) {
                if (outParameter.castType == 1) {
                    this.mProtocolPlayer = new CloudPlayer(this.mContext, this.mPlayInfo);
                    return;
                } else {
                    this.mProtocolPlayer = new YimPlayer(this.mContext, this.mPlayInfo);
                    return;
                }
            }
            if (i11 != 5) {
                SourceLog.w(TAG, "initPlayer ignore invalid protocol");
                return;
            }
        }
        this.mProtocolPlayer = new LelinkPlayer(this.mContext, outParameter);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void addVolume() {
        this.mProtocolPlayer.addVolume();
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean appendPlayList(String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        return this.mProtocolPlayer.appendPlayList(str, dramaInfoBeanArr, i10, i11, i12);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean clearPlayList(String str) {
        return this.mProtocolPlayer.clearPlayList(str);
    }

    public void doChangeChannel(int i10) {
        ICastPlayer iCastPlayer = this.mProtocolPlayer;
        if (iCastPlayer instanceof GroupPlayer) {
            ((GroupPlayer) iCastPlayer).doChangeChannel(i10);
        }
    }

    public ICastPlayer getMediaPlayer() {
        return this.mProtocolPlayer;
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void onAppPause() {
        this.mProtocolPlayer.onAppPause();
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void onAppResume() {
        this.mProtocolPlayer.onAppResume();
    }

    public void onWifiConnected() {
        ICastPlayer iCastPlayer = this.mProtocolPlayer;
        if (iCastPlayer instanceof GroupPlayer) {
            ((GroupPlayer) iCastPlayer).onWifiConnected();
        }
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean pause(String str) {
        return this.mProtocolPlayer.pause(str);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean playDrama(String str, String str2) {
        return this.mProtocolPlayer.playDrama(str, str2);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean playNextDrama(String str) {
        return this.mProtocolPlayer.playNextDrama(str);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean playPreDrama(String str) {
        return this.mProtocolPlayer.playPreDrama(str);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void release(String str) {
        this.mProtocolPlayer.release(str);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean resume(String str) {
        return this.mProtocolPlayer.resume(str);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean seekTo(String str, int i10) {
        return this.mProtocolPlayer.seekTo(str, i10);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void selectAudiotrack(int i10) {
        this.mProtocolPlayer.selectAudiotrack(i10);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void setDataSource(OutParameter outParameter) {
        this.mPlayInfo = outParameter;
        this.mProtocolPlayer.setDataSource(outParameter);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void setMirrorScreenSecret(boolean z10) {
        this.mProtocolPlayer.setMirrorScreenSecret(z10);
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.mProtocolPlayer.setOnCompletionListener(onCompletionListener);
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mProtocolPlayer.setOnErrorListener(onErrorListener);
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mProtocolPlayer.setOnInfoListener(onInfoListener);
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void setOnLoadingListener(OnLoadingListener onLoadingListener) {
        this.mProtocolPlayer.setOnLoadingListener(onLoadingListener);
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.mProtocolPlayer.setOnPreparedListener(onPreparedListener);
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.mProtocolPlayer.setOnStateChangeListener(onStateChangeListener);
    }

    @Override // com.hpplay.sdk.source.player.ICastPlayer
    public void setOnStopListener(OnStopListener onStopListener) {
        this.mProtocolPlayer.setOnStopListener(onStopListener);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void setSecondMirrorView(SecondMirrorView secondMirrorView) {
        this.mProtocolPlayer.setSecondMirrorView(secondMirrorView);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void setVolume(int i10) {
        this.mProtocolPlayer.setVolume(i10);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void setWatermarkVisible(boolean z10) {
        this.mProtocolPlayer.setWatermarkVisible(z10);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean start(String str) {
        return this.mProtocolPlayer.start(str);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void stop(String str) {
        SourceLog.i(TAG, "cast player stop ");
        this.mProtocolPlayer.stop(str);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void subVolume() {
        this.mProtocolPlayer.subVolume();
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean switchExpansionScreen(boolean z10) {
        return this.mProtocolPlayer.switchExpansionScreen(z10);
    }
}
