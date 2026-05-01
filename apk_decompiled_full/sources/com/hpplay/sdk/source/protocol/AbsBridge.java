package com.hpplay.sdk.source.protocol;

import android.content.Context;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.api.PlayerListenerConstant;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.common.store.Preference;
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
public abstract class AbsBridge implements IBridge {
    public static final int INFO_CODE_RESOLUTION_CHANGED = 10;
    protected boolean isAppResume = true;
    protected OnCompletionListener mCompletionListener;
    protected Context mContext;
    protected OnErrorListener mErrorListener;
    protected OnInfoListener mInfoListener;
    protected OnLoadingListener mLoadingListener;
    protected OutParameter mPlayInfo;
    protected OnPreparedListener mPreparedListener;
    protected OnStateChangeListener mStateChangeListener;
    protected OnStopListener mStopListener;

    public AbsBridge(Context context, OutParameter outParameter) {
        this.mContext = context;
        this.mPlayInfo = outParameter;
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void addVolume() {
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void appendPlayList(String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void clearPlayList(String str) {
    }

    public void frozen(boolean z10) {
    }

    public void onAppPause() {
        this.isAppResume = false;
    }

    public void onAppResume() {
        this.isAppResume = true;
    }

    public void onCaptureStart(int i10) {
    }

    public void onCaptureStop(int i10) {
    }

    public void onInfo(int i10, String str) {
        OnInfoListener onInfoListener;
        if (i10 == 120105112) {
            OnErrorListener onErrorListener = this.mErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(null, PlayerListenerConstant.MIRROR_ERROR_CODEC, i10, str);
            }
            if (Preference.getInstance().get(Preference.KEY_ENCODE_ERROR_EXIT_MIRROR, true)) {
                try {
                    SourceLog.i("absBridge", " mirror encode error call stop");
                    stop(this.mPlayInfo.getKey());
                } catch (Exception e10) {
                    SourceLog.w("absBridge", e10);
                }
            }
        }
        if (i10 != 10 || (onInfoListener = this.mInfoListener) == null) {
            return;
        }
        onInfoListener.onInfo(null, PlayerListenerConstant.MIRROR_INFO_CODE, str);
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void playDrama(String str, String str2) {
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void playNextDrama(String str) {
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void playPreDrama(String str) {
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public abstract void release();

    public void screenshot(int i10) {
    }

    public void selectAudiotrack(int i10) {
    }

    public void sendAudioData(byte[] bArr, int i10, int i11) {
    }

    public void sendVideoData(ByteBuffer byteBuffer, int i10, int i11, int i12, long j10) {
    }

    public void setDataSource(OutParameter outParameter) {
        this.mPlayInfo = outParameter;
    }

    public void setExternalMirrorData() {
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void setMirrorScreenSecret(boolean z10) {
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.mCompletionListener = onCompletionListener;
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mErrorListener = onErrorListener;
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mInfoListener = onInfoListener;
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void setOnLoadingListener(OnLoadingListener onLoadingListener) {
        this.mLoadingListener = onLoadingListener;
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.mPreparedListener = onPreparedListener;
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.mStateChangeListener = onStateChangeListener;
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void setOnStopListener(OnStopListener onStopListener) {
        this.mStopListener = onStopListener;
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void setSecondMirrorView(SecondMirrorView secondMirrorView) {
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void setVolume(int i10) {
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void setWatermarkVisible(boolean z10) {
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void subVolume() {
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public boolean switchExpansionScreen(boolean z10) {
        return false;
    }
}
