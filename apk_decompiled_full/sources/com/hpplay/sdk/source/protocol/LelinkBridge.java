package com.hpplay.sdk.source.protocol;

import android.content.Context;
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
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class LelinkBridge extends AbsBridge {
    private static final String TAG = "LelinkBridge";
    private AbsBridge mLelinkBridge;
    private OutParameter mPlayInfo;

    public LelinkBridge(Context context, OutParameter outParameter) {
        super(context, outParameter);
        this.mPlayInfo = outParameter;
        if (outParameter.castType == 1) {
            this.mLelinkBridge = new LelinkPushBridge(this.mContext, outParameter);
        } else {
            this.mLelinkBridge = new LelinkMirrorBridge(this.mContext, outParameter);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void addVolume() {
        super.addVolume();
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "addVolume ignore");
        } else {
            absBridge.addVolume();
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void appendPlayList(String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "appendPlayList ignore");
        } else {
            absBridge.appendPlayList(str, dramaInfoBeanArr, i10, i11, i12);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void clearPlayList(String str) {
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "clearPlayList ignore");
        } else {
            absBridge.clearPlayList(str);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void frozen(boolean z10) {
        super.frozen(z10);
        this.mLelinkBridge.frozen(z10);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void onAppPause() {
        super.onAppPause();
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "onAppPause ignore 2");
        } else {
            absBridge.onAppPause();
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void onAppResume() {
        super.onAppResume();
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "onAppResume ignore 2");
        } else {
            absBridge.onAppResume();
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void onCaptureStart(int i10) {
        super.onCaptureStart(i10);
        this.mLelinkBridge.onCaptureStart(i10);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void onCaptureStop(int i10) {
        super.onCaptureStop(i10);
        this.mLelinkBridge.onCaptureStop(i10);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void onInfo(int i10, String str) {
        super.onInfo(i10, str);
        this.mLelinkBridge.onInfo(i10, str);
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void pause(String str) {
        if (this.mPlayInfo == null) {
            SourceLog.w(TAG, "pause ignore");
            return;
        }
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "pause ignore 2");
        } else {
            absBridge.pause(str);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void play(String str) {
        if (this.mPlayInfo == null) {
            SourceLog.w(TAG, "play ignore");
        } else {
            SourceLog.i(TAG, "play");
            this.mLelinkBridge.play(str);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void playDrama(String str, String str2) {
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "playDrama ignore");
        } else {
            absBridge.playDrama(str, str2);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void playNextDrama(String str) {
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "playNextDrama ignore");
        } else {
            absBridge.playNextDrama(str);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void playPreDrama(String str) {
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "playPreDrama ignore");
        } else {
            absBridge.playPreDrama(str);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void release() {
        this.mLelinkBridge.release();
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void resume(String str) {
        if (this.mPlayInfo == null) {
            SourceLog.w(TAG, "resume ignore");
            return;
        }
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "resume ignore 2");
        } else {
            absBridge.resume(str);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void screenshot(int i10) {
        super.screenshot(i10);
        this.mLelinkBridge.screenshot(i10);
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void seekTo(int i10) {
        if (this.mPlayInfo == null) {
            SourceLog.w(TAG, "seekTo ignore");
            return;
        }
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "seekTo ignore 2");
        } else {
            absBridge.seekTo(i10);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void selectAudiotrack(int i10) {
        super.selectAudiotrack(i10);
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "selectAudiotrack ignore");
        } else {
            absBridge.selectAudiotrack(i10);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void sendAudioData(byte[] bArr, int i10, int i11) {
        super.sendAudioData(bArr, i10, i11);
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "sendAudioData ignore");
        } else {
            absBridge.sendAudioData(bArr, i10, i11);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void sendVideoData(ByteBuffer byteBuffer, int i10, int i11, int i12, long j10) {
        super.sendVideoData(byteBuffer, i10, i11, i12, j10);
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "sendVideoData ignore");
        } else {
            absBridge.sendVideoData(byteBuffer, i10, i11, i12, j10);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void setDataSource(OutParameter outParameter) {
        super.setDataSource(outParameter);
        this.mLelinkBridge.setDataSource(outParameter);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void setExternalMirrorData() {
        super.setExternalMirrorData();
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "setExternalMirrorData ignore");
        } else {
            absBridge.setExternalMirrorData();
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void setMirrorScreenSecret(boolean z10) {
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "setMirrorScreenSecret ignore");
        } else {
            absBridge.setMirrorScreenSecret(z10);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        super.setOnCompletionListener(onCompletionListener);
        this.mLelinkBridge.setOnCompletionListener(onCompletionListener);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void setOnErrorListener(OnErrorListener onErrorListener) {
        super.setOnErrorListener(onErrorListener);
        this.mLelinkBridge.setOnErrorListener(onErrorListener);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void setOnInfoListener(OnInfoListener onInfoListener) {
        super.setOnInfoListener(onInfoListener);
        this.mLelinkBridge.setOnInfoListener(onInfoListener);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void setOnLoadingListener(OnLoadingListener onLoadingListener) {
        super.setOnLoadingListener(onLoadingListener);
        this.mLelinkBridge.setOnLoadingListener(onLoadingListener);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        super.setOnPreparedListener(onPreparedListener);
        this.mLelinkBridge.setOnPreparedListener(onPreparedListener);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        super.setOnStateChangeListener(onStateChangeListener);
        this.mLelinkBridge.setOnStateChangeListener(onStateChangeListener);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void setOnStopListener(OnStopListener onStopListener) {
        super.setOnStopListener(onStopListener);
        this.mLelinkBridge.setOnStopListener(onStopListener);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void setSecondMirrorView(SecondMirrorView secondMirrorView) {
        super.setSecondMirrorView(secondMirrorView);
        this.mLelinkBridge.setSecondMirrorView(secondMirrorView);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void setVolume(int i10) {
        super.setVolume(i10);
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "setVolume ignore");
        } else {
            absBridge.setVolume(i10);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void setWatermarkVisible(boolean z10) {
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "setWatermarkInfo ignore");
        } else {
            absBridge.setWatermarkVisible(z10);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void stop(String str) {
        if (this.mPlayInfo == null) {
            SourceLog.w(TAG, "stop ignore");
        } else if (this.mLelinkBridge == null) {
            SourceLog.w(TAG, "stop ignore 2");
        } else {
            SourceLog.w(TAG, "Lelinkbrideg stop ");
            this.mLelinkBridge.stop(str);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void subVolume() {
        super.subVolume();
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "subVolume ignore");
        } else {
            absBridge.subVolume();
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public boolean switchExpansionScreen(boolean z10) {
        if (this.mPlayInfo == null) {
            SourceLog.w(TAG, "switchExpansionScreen ignore");
            return false;
        }
        SourceLog.i(TAG, "switchExpansionScreen");
        return this.mLelinkBridge.switchExpansionScreen(z10);
    }
}
