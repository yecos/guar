package com.hpplay.sdk.source.protocol;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.MediaAssetBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.PlayerInfoBean;
import com.hpplay.sdk.source.bean.StopInfo;
import com.hpplay.sdk.source.business.IMQueue;
import com.hpplay.sdk.source.business.PublicCastClient;
import com.hpplay.sdk.source.business.cloud.SourceErrorLog;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.PassSender;
import com.hpplay.sdk.source.player.listener.OnCompletionListener;
import com.hpplay.sdk.source.player.listener.OnErrorListener;
import com.hpplay.sdk.source.player.listener.OnInfoListener;
import com.hpplay.sdk.source.player.listener.OnLoadingListener;
import com.hpplay.sdk.source.player.listener.OnPreparedListener;
import com.hpplay.sdk.source.player.listener.OnStateChangeListener;
import com.hpplay.sdk.source.protocol.connect.OnPlayStateListener;
import com.hpplay.sdk.source.utils.ErrorCode;
import com.raizlabs.android.dbflow.sql.language.Operator;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CloudBridge extends AbsBridge {
    private static final String TAG = "CloudBridge";
    private boolean isCallPrepared;
    private String mReportPrepareDramaId;
    private final OnPlayStateListener mStateListener;

    public CloudBridge(Context context, OutParameter outParameter) {
        super(context, outParameter);
        this.mReportPrepareDramaId = null;
        this.mStateListener = new OnPlayStateListener() { // from class: com.hpplay.sdk.source.protocol.CloudBridge.1
            @Override // com.hpplay.sdk.source.protocol.connect.OnPlayStateListener
            public void onError(String str, String str2) {
                if (TextUtils.equals(str, CloudBridge.this.mPlayInfo.urlID)) {
                    OnErrorListener onErrorListener = CloudBridge.this.mErrorListener;
                    if (onErrorListener != null) {
                        onErrorListener.onError(null, 210010, 210011, null);
                        return;
                    }
                    return;
                }
                SourceLog.w(CloudBridge.TAG, "onError ignore, " + str + Operator.Operation.DIVISION + CloudBridge.this.mPlayInfo.urlID);
            }

            @Override // com.hpplay.sdk.source.protocol.connect.OnPlayStateListener
            public void onPause(String str) {
                if (TextUtils.equals(str, CloudBridge.this.mPlayInfo.urlID)) {
                    OnStateChangeListener onStateChangeListener = CloudBridge.this.mStateChangeListener;
                    if (onStateChangeListener != null) {
                        onStateChangeListener.onStateChanged(null, 4);
                        return;
                    }
                    return;
                }
                SourceLog.w(CloudBridge.TAG, "onPause ignore, " + str + Operator.Operation.DIVISION + CloudBridge.this.mPlayInfo.urlID);
            }

            @Override // com.hpplay.sdk.source.protocol.connect.OnPlayStateListener
            public void onPlaying(String str, int i10, int i11) {
                if (TextUtils.equals(str, CloudBridge.this.mPlayInfo.urlID)) {
                    OnInfoListener onInfoListener = CloudBridge.this.mInfoListener;
                    if (onInfoListener != null) {
                        onInfoListener.onInfo(null, 100, i10, i11);
                        return;
                    }
                    return;
                }
                SourceLog.w(CloudBridge.TAG, "onPlaying ignore, " + str + Operator.Operation.DIVISION + CloudBridge.this.mPlayInfo.urlID);
            }

            @Override // com.hpplay.sdk.source.protocol.connect.OnPlayStateListener
            public void onStart(String str) {
                if (!TextUtils.equals(str, CloudBridge.this.mPlayInfo.urlID)) {
                    SourceLog.w(CloudBridge.TAG, "onStart ignore, " + str + Operator.Operation.DIVISION + CloudBridge.this.mPlayInfo.urlID);
                    return;
                }
                CloudBridge cloudBridge = CloudBridge.this;
                OutParameter outParameter2 = cloudBridge.mPlayInfo;
                if (outParameter2 == null || outParameter2.urls == null) {
                    if (cloudBridge.isCallPrepared) {
                        OnStateChangeListener onStateChangeListener = CloudBridge.this.mStateChangeListener;
                        if (onStateChangeListener != null) {
                            onStateChangeListener.onStateChanged(null, 3);
                            return;
                        }
                        return;
                    }
                    CloudBridge.this.isCallPrepared = true;
                    OnPreparedListener onPreparedListener = CloudBridge.this.mPreparedListener;
                    if (onPreparedListener != null) {
                        onPreparedListener.onPrepared(null);
                        return;
                    }
                    return;
                }
                if (cloudBridge.mReportPrepareDramaId != null && CloudBridge.this.mReportPrepareDramaId.equals(CloudBridge.this.mPlayInfo.dramaID)) {
                    OnStateChangeListener onStateChangeListener2 = CloudBridge.this.mStateChangeListener;
                    if (onStateChangeListener2 != null) {
                        onStateChangeListener2.onStateChanged(null, 3);
                        return;
                    }
                    return;
                }
                CloudBridge cloudBridge2 = CloudBridge.this;
                cloudBridge2.mReportPrepareDramaId = cloudBridge2.mPlayInfo.dramaID;
                OnPreparedListener onPreparedListener2 = CloudBridge.this.mPreparedListener;
                if (onPreparedListener2 != null) {
                    onPreparedListener2.onPrepared(null);
                }
            }

            @Override // com.hpplay.sdk.source.protocol.connect.OnPlayStateListener
            public void onStop(String str, int i10) {
                if (!TextUtils.equals(str, CloudBridge.this.mPlayInfo.urlID)) {
                    SourceLog.w(CloudBridge.TAG, "onStop ignore, " + str + Operator.Operation.DIVISION + CloudBridge.this.mPlayInfo.urlID);
                    return;
                }
                CloudBridge.this.isCallPrepared = false;
                if (i10 == 0) {
                    OnCompletionListener onCompletionListener = CloudBridge.this.mCompletionListener;
                    if (onCompletionListener != null) {
                        onCompletionListener.onComplete(null);
                        return;
                    }
                    return;
                }
                if (CloudBridge.this.mStopListener != null) {
                    StopInfo stopInfo = new StopInfo();
                    if (i10 == 2) {
                        stopInfo.type = 3;
                    } else {
                        stopInfo.type = 1;
                    }
                    CloudBridge.this.mStopListener.onStop(null, stopInfo);
                }
            }
        };
        this.isCallPrepared = false;
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void addVolume() {
        SourceLog.i(TAG, "addVolume");
        PublicCastClient.getInstance().addVolume(this.mPlayInfo);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void appendPlayList(String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        SourceLog.i(TAG, "appendPlayList " + str);
        PublicCastClient.getInstance().setPlayList(this.mPlayInfo, DramaInfoBean.APPEND_PLAY_LIST, dramaInfoBeanArr, i10, i11, i12);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void clearPlayList(String str) {
        SourceLog.i(TAG, "clearPlayList " + str);
        PublicCastClient.getInstance().setPlayList(this.mPlayInfo, DramaInfoBean.CLEAR_PLAY_LIST, null, 0, -1, -1);
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void pause(String str) {
        SourceLog.i(TAG, "pause: " + str);
        PublicCastClient.getInstance().pause(this.mPlayInfo);
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void play(String str) {
        SourceLog.i(TAG, "play: " + str);
        IMQueue.getInstance().clearTask();
        PublicCastClient.getInstance().setOnPlayStateListener(this.mStateListener);
        this.isCallPrepared = false;
        PlayerInfoBean playerInfoBean = this.mPlayInfo.playerInfoBean;
        if (playerInfoBean != null && !playerInfoBean.isEmpty()) {
            OutParameter outParameter = this.mPlayInfo;
            outParameter.playerInfoBean.setUri(outParameter.urlID);
            PassSender passSender = PassSender.getInstance();
            OutParameter outParameter2 = this.mPlayInfo;
            passSender.sendPlayerInfo(outParameter2.playerInfoBean, outParameter2.session);
        }
        MediaAssetBean mediaAssetBean = this.mPlayInfo.mediaAssetBean;
        if (mediaAssetBean != null && !mediaAssetBean.isEmpty()) {
            OutParameter outParameter3 = this.mPlayInfo;
            outParameter3.mediaAssetBean.setUri(outParameter3.urlID);
            PassSender passSender2 = PassSender.getInstance();
            OutParameter outParameter4 = this.mPlayInfo;
            passSender2.sendMediaAssets(outParameter4.mediaAssetBean, outParameter4.session);
        }
        PublicCastClient.getInstance().play(this.mPlayInfo, "", new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.protocol.CloudBridge.2
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                AsyncHttpParameter.Out out;
                String str2;
                int optInt;
                AsyncHttpParameter.Out out2;
                if (asyncHttpParameter != null && (out2 = asyncHttpParameter.out) != null && out2.resultType == 2) {
                    SourceLog.w(CloudBridge.TAG, "play onRequestResult cancel ");
                    return;
                }
                if (asyncHttpParameter == null || (out = asyncHttpParameter.out) == null || (str2 = out.result) == null) {
                    SourceLog.w(CloudBridge.TAG, "play onRequestResult failed ");
                    OnErrorListener onErrorListener = CloudBridge.this.mErrorListener;
                    if (onErrorListener != null) {
                        onErrorListener.onError(null, 210000, 210011, SourceErrorLog.getInstance().getErrorReportExtra(ErrorCode.PUSH_ERROR_CLOUD_PUSH_FAILURE, "result is null"));
                        return;
                    }
                    return;
                }
                SourceLog.debug(CloudBridge.TAG, "play onRequestResult " + str2);
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    optInt = jSONObject.optInt(Constant.KEY_STATUS);
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        optJSONObject.optString(Constant.KEY_MSG);
                    }
                } catch (Exception e10) {
                    SourceLog.w(CloudBridge.TAG, e10);
                }
                if (optInt == 403) {
                    OnErrorListener onErrorListener2 = CloudBridge.this.mErrorListener;
                    if (onErrorListener2 != null) {
                        onErrorListener2.onError(null, 210010, 210004, SourceErrorLog.getInstance().getErrorReportExtra(ErrorCode.PUSH_ERROR_CLOUD_PUSH_TV_OFFLINE, str2));
                        return;
                    }
                    return;
                }
                if (optInt == 200) {
                    OnLoadingListener onLoadingListener = CloudBridge.this.mLoadingListener;
                    if (onLoadingListener != null) {
                        onLoadingListener.onLoading(null, null);
                        return;
                    }
                    return;
                }
                OnErrorListener onErrorListener3 = CloudBridge.this.mErrorListener;
                if (onErrorListener3 != null) {
                    onErrorListener3.onError(null, 210010, 210011, SourceErrorLog.getInstance().getErrorReportExtra(ErrorCode.PUSH_ERROR_CLOUD_PUSH_FAILURE, str2));
                }
            }
        });
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void playDrama(String str, String str2) {
        SourceLog.i(TAG, "playDrama " + str + " / " + str2);
        PublicCastClient.getInstance().playDrama(this.mPlayInfo, str2);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void playNextDrama(String str) {
        SourceLog.i(TAG, "playNextDrama " + str);
        PublicCastClient.getInstance().playNextDrama(this.mPlayInfo);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void playPreDrama(String str) {
        SourceLog.i(TAG, "playPreDrama " + str);
        PublicCastClient.getInstance().playPreDrama(this.mPlayInfo);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void release() {
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void resume(String str) {
        SourceLog.i(TAG, "resume: " + str);
        PublicCastClient.getInstance().resume(this.mPlayInfo);
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void seekTo(int i10) {
        SourceLog.i(TAG, "seekTo: second := " + i10);
        PublicCastClient.getInstance().seekTo(this.mPlayInfo, i10);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void selectAudiotrack(int i10) {
        SourceLog.i(TAG, "selectAudiotrack index:" + i10);
        PublicCastClient.getInstance().selectTrack(this.mPlayInfo, i10);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void setVolume(int i10) {
        SourceLog.i(TAG, "setVolume");
        PublicCastClient.getInstance().setVolume(this.mPlayInfo, i10);
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void stop(String str) {
        SourceLog.i(TAG, "stop: " + str);
        PublicCastClient.getInstance().stop(this.mPlayInfo);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void subVolume() {
        SourceLog.i(TAG, "subVolume");
        PublicCastClient.getInstance().subVolume(this.mPlayInfo);
    }
}
