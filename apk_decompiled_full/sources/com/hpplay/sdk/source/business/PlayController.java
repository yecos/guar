package com.hpplay.sdk.source.business;

import android.content.Context;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.StopInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.cloud.HistoryDeviceManager;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.da.e;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.player.CastPlayer;
import com.hpplay.sdk.source.player.ICastPlayer;
import com.hpplay.sdk.source.player.IPlayer;
import com.hpplay.sdk.source.player.listener.OnCompletionListener;
import com.hpplay.sdk.source.player.listener.OnErrorListener;
import com.hpplay.sdk.source.player.listener.OnInfoListener;
import com.hpplay.sdk.source.player.listener.OnLoadingListener;
import com.hpplay.sdk.source.player.listener.OnPreparedListener;
import com.hpplay.sdk.source.player.listener.OnStateChangeListener;
import com.hpplay.sdk.source.player.listener.OnStopListener;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.ErrorCode;
import com.hpplay.sdk.source.utils.Feature;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public class PlayController implements IPlayer {
    private static final String TAG = "PlayController";
    private CastPlayer mCastPlayer;
    private Context mContext;
    private LelinkPlayerListenerDispatcher mLelinkPlayerListener;
    private OutParameter mPlayInfo;
    private int mCurrentState = -1;
    private boolean isStopped = false;
    private boolean isReleased = false;
    private boolean isReportStop = false;
    private boolean retry = false;
    private boolean disconnectFromUser = false;
    private String mReportStopDramaId = null;
    private int mStopType = 0;
    private long mPlayedDuration = -1;
    private long mDuration = -1;
    private OnLoadingListener mLoadingListener = new OnLoadingListener() { // from class: com.hpplay.sdk.source.business.PlayController.1
        @Override // com.hpplay.sdk.source.player.listener.OnLoadingListener
        public void onLoading(ICastPlayer iCastPlayer, String str) {
            SourceLog.i(PlayController.TAG, "onLoading " + PlayController.this + " reportExtra:  " + str);
            SourceDataReport.getInstance().onCastSuccess(PlayController.this.mPlayInfo, PlayController.this.retry, str);
            if (PlayController.this.mPlayInfo != null) {
                int i10 = PlayController.this.mPlayInfo.castType;
                if (i10 != 1) {
                    if (i10 == 2) {
                        PlayController.this.mCurrentState = 1;
                    }
                } else if (PlayController.this.mPlayInfo.mimeType == 102) {
                    PlayController.this.mCurrentState = 2;
                } else if (PlayController.this.mPlayInfo.mimeType == 101) {
                    PlayController.this.mCurrentState = 3;
                } else if (PlayController.this.mPlayInfo.mimeType == 103) {
                    PlayController.this.mCurrentState = 4;
                }
                ConnectManager.getInstance().notifyCastSuccess(PlayController.this.mPlayInfo.serviceInfo);
                HistoryDeviceManager.getInstance().addHistoryDevice(PlayController.this.mPlayInfo.serviceInfo);
            }
            if (PlayController.this.mLelinkPlayerListener != null) {
                PlayController.this.mLelinkPlayerListener.onLoading(PlayController.this.mPlayInfo);
            }
        }
    };
    private OnPreparedListener mPreparedListener = new OnPreparedListener() { // from class: com.hpplay.sdk.source.business.PlayController.2
        @Override // com.hpplay.sdk.source.player.listener.OnPreparedListener
        public void onPrepared(ICastPlayer iCastPlayer) {
            SourceLog.i(PlayController.TAG, "onPrepared, " + PlayController.this);
            int i10 = PlayController.this.mPlayInfo.castType;
            if (i10 != 1) {
                if (i10 == 2) {
                    PlayController.this.mCurrentState = 5;
                }
            } else if (PlayController.this.mPlayInfo.mimeType == 102) {
                PlayController.this.mCurrentState = 6;
            } else if (PlayController.this.mPlayInfo.mimeType == 101) {
                PlayController.this.mCurrentState = 7;
            } else if (PlayController.this.mPlayInfo.mimeType == 103) {
                PlayController.this.mCurrentState = 8;
            }
            SourceDataReport.getInstance().onCastRender(PlayController.this.mPlayInfo);
            if (PlayController.this.mLelinkPlayerListener != null) {
                PlayController.this.mLelinkPlayerListener.onStart(PlayController.this.mPlayInfo);
            }
            ConnectManager.getInstance().notifyCastSuccess(PlayController.this.mPlayInfo.serviceInfo);
            if (PlayController.this.mPlayInfo.pushType == 1) {
                e.d().a(PlayController.this.mPlayInfo);
            }
        }
    };
    private OnStateChangeListener mStateChangeListener = new OnStateChangeListener() { // from class: com.hpplay.sdk.source.business.PlayController.3
        @Override // com.hpplay.sdk.source.player.listener.OnStateChangeListener
        public void onStateChanged(ICastPlayer iCastPlayer, int i10) {
            if (PlayController.this.mCurrentState == i10) {
                SourceLog.i(PlayController.TAG, "onStateChanged ignore " + PlayController.this.mCurrentState + Operator.Operation.DIVISION + i10);
                return;
            }
            SourceLog.i(PlayController.TAG, "onStateChanged " + i10 + Operator.Operation.DIVISION + PlayController.this.mCurrentState + ", " + PlayController.this);
            if (PlayController.this.mLelinkPlayerListener != null) {
                if (i10 != 3) {
                    int i11 = PlayController.this.mPlayInfo.castType;
                    if (i11 != 1) {
                        if (i11 == 2) {
                            PlayController.this.mCurrentState = 11;
                        }
                    } else if (PlayController.this.mPlayInfo.mimeType == 102) {
                        PlayController.this.mCurrentState = 9;
                    } else if (PlayController.this.mPlayInfo.mimeType == 101) {
                        PlayController.this.mCurrentState = 10;
                    }
                    PlayController.this.mLelinkPlayerListener.onPause(PlayController.this.mPlayInfo);
                    return;
                }
                if (PlayController.this.disconnectFromUser && !ConnectManager.getInstance().isConnected(PlayController.this.mPlayInfo)) {
                    SourceLog.i(PlayController.TAG, "onStateChanged stop disconnectFromUser");
                    PlayController.this.stop(Constant.STOP_USER_DISCONNECT);
                }
                int i12 = PlayController.this.mPlayInfo.castType;
                if (i12 != 1) {
                    if (i12 == 2) {
                        if (PlayController.this.mCurrentState == 5) {
                            return;
                        } else {
                            PlayController.this.mCurrentState = 5;
                        }
                    }
                } else if (PlayController.this.mPlayInfo.mimeType == 102) {
                    PlayController.this.mCurrentState = 6;
                } else if (PlayController.this.mPlayInfo.mimeType == 101) {
                    PlayController.this.mCurrentState = 7;
                } else if (PlayController.this.mPlayInfo.mimeType == 103) {
                    PlayController.this.mCurrentState = 8;
                }
                PlayController.this.mLelinkPlayerListener.onStart(PlayController.this.mPlayInfo);
            }
        }
    };
    private final OnInfoListener mInfoListener = new OnInfoListener() { // from class: com.hpplay.sdk.source.business.PlayController.4
        @Override // com.hpplay.sdk.source.player.listener.OnInfoListener
        public void onInfo(ICastPlayer iCastPlayer, int i10, int i11, int i12) {
            if (i10 != 100) {
                SourceLog.i(PlayController.TAG, "onInfo " + i11 + Operator.Operation.DIVISION + i12);
                return;
            }
            SourceLog.i(PlayController.TAG, "onPositionUpdate duration:" + i11 + Operator.Operation.DIVISION + i12);
            PlayController playController = PlayController.this;
            long j10 = (long) i12;
            playController.mPlayedDuration = Math.max(playController.mPlayedDuration, j10);
            long j11 = (long) i11;
            PlayController.this.mDuration = j11;
            if (PlayController.this.mLelinkPlayerListener != null) {
                PlayController.this.mLelinkPlayerListener.onPositionUpdate(PlayController.this.mPlayInfo, j11, j10);
            }
            ConnectManager.getInstance().notifyCastStatusValid(PlayController.this.mPlayInfo.serviceInfo);
        }

        @Override // com.hpplay.sdk.source.player.listener.OnInfoListener
        public void onInfo(ICastPlayer iCastPlayer, int i10, String str) {
            if (PlayController.this.mLelinkPlayerListener != null) {
                PlayController.this.mLelinkPlayerListener.onInfo(PlayController.this.mPlayInfo, i10, str);
            }
        }
    };
    private final OnErrorListener mErrorListener = new OnErrorListener() { // from class: com.hpplay.sdk.source.business.PlayController.5
        @Override // com.hpplay.sdk.source.player.listener.OnErrorListener
        public void onError(ICastPlayer iCastPlayer, int i10, int i11, String str) {
            SourceLog.i(PlayController.TAG, "onError " + i10 + Operator.Operation.DIVISION + i11);
            if (PlayController.this.retry(i10, i11)) {
                PlayController.this.retry = true;
                PlayController.this.reopen();
                return;
            }
            if (i11 != 211026) {
                SourceDataReport.getInstance().onCastFailed(PlayController.this.mPlayInfo, "", "", PlayController.this.retry, str);
                ConnectManager.getInstance().notifyCastError(PlayController.this.mPlayInfo.serviceInfo);
            } else if (PlayController.this.mPlayInfo.castType == 1) {
                SourceDataReport.getInstance().onCastFailed(PlayController.this.mPlayInfo, ErrorCode.PUSH_NEED_SCREEN_CODE, "", PlayController.this.retry, str);
            } else {
                SourceDataReport.getInstance().onCastFailed(PlayController.this.mPlayInfo, ErrorCode.MIRROR_NEED_SCREEN_CODE, "", PlayController.this.retry, str);
            }
            if (PlayController.this.mLelinkPlayerListener != null) {
                PlayController.this.mLelinkPlayerListener.onError(PlayController.this.mPlayInfo, i10, i11, str);
            }
            PlayController.this.pushAfterDa();
        }
    };
    private final OnCompletionListener mCompletionListener = new OnCompletionListener() { // from class: com.hpplay.sdk.source.business.PlayController.6
        @Override // com.hpplay.sdk.source.player.listener.OnCompletionListener
        public void onComplete(ICastPlayer iCastPlayer) {
            SourceLog.i(PlayController.TAG, "onComplete current:" + PlayController.this.mCurrentState);
            if (PlayController.this.mLelinkPlayerListener == null || PlayController.this.mCurrentState == 0) {
                PlayController.this.mCurrentState = 0;
                if (PlayController.this.mLelinkPlayerListener != null) {
                    PlayController.this.mLelinkPlayerListener.onStop(PlayController.this.mPlayInfo);
                }
            } else {
                PlayController.this.mCurrentState = 0;
                PlayController.this.mLelinkPlayerListener.onCompletion(PlayController.this.mPlayInfo, 0);
            }
            if (PlayController.this.mStopType <= 0) {
                PlayController.this.mStopType = 1002;
            }
            PlayController.this.reportStop();
            PlayController.this.pushAfterDa();
        }
    };
    private final OnStopListener mStopListener = new OnStopListener() { // from class: com.hpplay.sdk.source.business.PlayController.7
        @Override // com.hpplay.sdk.source.player.listener.OnStopListener
        public void onStop(ICastPlayer iCastPlayer, StopInfo stopInfo) {
            SourceLog.i(PlayController.TAG, "onStop current:" + PlayController.this.mCurrentState);
            if (PlayController.this.mStopType <= 0) {
                PlayController.this.mStopType = Constant.STOP_FROM_SINK;
            }
            if (PlayController.this.mLelinkPlayerListener == null || PlayController.this.mCurrentState == 0) {
                PlayController.this.mCurrentState = 0;
                if (PlayController.this.mLelinkPlayerListener != null) {
                    PlayController.this.mLelinkPlayerListener.onStop(PlayController.this.mPlayInfo);
                }
            } else {
                PlayController.this.mCurrentState = 0;
                if (stopInfo == null || stopInfo.type != 3) {
                    PlayController.this.mLelinkPlayerListener.onStop(PlayController.this.mPlayInfo);
                } else {
                    if (PlayController.this.mStopType <= 0) {
                        PlayController.this.mStopType = 1002;
                    }
                    PlayController.this.mLelinkPlayerListener.onCompletion(PlayController.this.mPlayInfo, 1);
                }
            }
            PlayController.this.reportStop();
            if (PlayController.this.mStopType != 1003 || stopInfo == null || stopInfo.type == 4) {
                return;
            }
            PlayController.this.pushAfterDa();
        }
    };

    public PlayController(Context context, OutParameter outParameter) {
        SourceLog.i(TAG, "init:" + this + "," + outParameter.serviceInfo.getUid());
        this.mContext = context;
        this.mPlayInfo = outParameter;
        initPlayer();
    }

    private void initPlayer() {
        CastPlayer castPlayer = this.mCastPlayer;
        if (castPlayer != null) {
            castPlayer.release(this.mPlayInfo.getKey());
            this.mCastPlayer = null;
        }
        CastPlayer castPlayer2 = new CastPlayer(this.mContext, this.mPlayInfo);
        this.mCastPlayer = castPlayer2;
        castPlayer2.setOnLoadingListener(this.mLoadingListener);
        this.mCastPlayer.setOnPreparedListener(this.mPreparedListener);
        this.mCastPlayer.setOnStateChangeListener(this.mStateChangeListener);
        this.mCastPlayer.setOnInfoListener(this.mInfoListener);
        this.mCastPlayer.setOnErrorListener(this.mErrorListener);
        this.mCastPlayer.setOnCompletionListener(this.mCompletionListener);
        this.mCastPlayer.setOnStopListener(this.mStopListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushAfterDa() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter == null || outParameter.pushType != 1) {
            return;
        }
        e.d().b(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportStop() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter != null && outParameter.urls != null) {
            String str = this.mReportStopDramaId;
            if (str != null && str.equals(outParameter.dramaID)) {
                return;
            } else {
                this.mReportStopDramaId = this.mPlayInfo.dramaID;
            }
        } else if (this.isReportStop) {
            return;
        } else {
            this.isReportStop = true;
        }
        if (this.mPlayInfo != null) {
            SourceDataReport.getInstance().onCastStop(this.mPlayInfo, this.mStopType);
            if (this.mPlayInfo.pushType == 1) {
                long j10 = this.mPlayedDuration;
                if (this.mStopType == 1002) {
                    j10 = Math.max(j10, this.mDuration);
                }
                e.d().a(this.mPlayInfo, j10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean retry(int i10, int i11) {
        if (!this.isStopped && !this.isReleased && i11 != 211026 && i11 != 211001 && i11 != 211002 && i11 != 211055) {
            BrowserInfo browserInfo = CastUtil.getBrowserInfo(this.mPlayInfo.serviceInfo, 3);
            BrowserInfo browserInfo2 = CastUtil.getBrowserInfo(this.mPlayInfo.serviceInfo, 4);
            OutParameter outParameter = this.mPlayInfo;
            if (outParameter.castType == 2) {
                if (outParameter.protocol != 1 || outParameter.connectProtocol != 4 || browserInfo2 == null || (!Feature.isLeboApp() && !Feature.isHappyTest())) {
                    return false;
                }
                OutParameter outParameter2 = this.mPlayInfo;
                outParameter2.protocol = 4;
                outParameter2.currentBrowserInfo = browserInfo2;
                SourceLog.i(TAG, "retry with im");
                return true;
            }
            int i12 = outParameter.protocol;
            if (i12 != 1) {
                if (i12 != 3 || browserInfo2 == null) {
                    return false;
                }
                outParameter.protocol = 4;
                outParameter.currentBrowserInfo = browserInfo2;
                SourceLog.i(TAG, "retry with im");
                return true;
            }
            if (browserInfo != null) {
                outParameter.protocol = 3;
                outParameter.currentBrowserInfo = browserInfo;
                SourceLog.i(TAG, "retry with dlna");
                return true;
            }
            if (browserInfo2 != null) {
                outParameter.protocol = 4;
                outParameter.currentBrowserInfo = browserInfo2;
                SourceLog.i(TAG, "retry with im");
                return true;
            }
        }
        return false;
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void addVolume() {
        if (isInPlaybackState()) {
            this.mCastPlayer.addVolume();
            return;
        }
        SourceLog.w(TAG, "addVolume ignore " + this.mCurrentState);
    }

    public void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter != null) {
            appendPlayList(outParameter.getKey(), dramaInfoBeanArr, i10, i11, i12);
            return;
        }
        SourceLog.w(TAG, "setPlayList ignore " + this.mCurrentState);
    }

    public void clearPlayList() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter != null) {
            clearPlayList(outParameter.getKey());
            return;
        }
        SourceLog.w(TAG, "clearPlayList ignore " + this.mCurrentState);
    }

    public void doChangeChannel(int i10) {
        this.mCastPlayer.doChangeChannel(i10);
    }

    public int getCurrentPlayState() {
        SourceLog.w(TAG, "getCurrentPlayState " + this.mCurrentState);
        return this.mCurrentState;
    }

    public ICastPlayer getMediaPlayer() {
        CastPlayer castPlayer = this.mCastPlayer;
        if (castPlayer == null) {
            return null;
        }
        return castPlayer.getMediaPlayer();
    }

    public OutParameter getPlayInfo() {
        return this.mPlayInfo;
    }

    public boolean isInPlaybackState() {
        return (this.mCastPlayer == null || this.mCurrentState == 0) ? false : true;
    }

    public void onAppPause() {
        CastPlayer castPlayer = this.mCastPlayer;
        if (castPlayer != null) {
            castPlayer.onAppPause();
        }
    }

    public void onAppResume() {
        CastPlayer castPlayer = this.mCastPlayer;
        if (castPlayer != null) {
            castPlayer.onAppResume();
        }
    }

    public void onWifiConnected() {
        this.mCastPlayer.onWifiConnected();
    }

    public void pause() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter == null) {
            SourceLog.w(TAG, "pause ignore " + this.mCurrentState);
            return;
        }
        if (outParameter.pushType == 1) {
            SourceLog.w(TAG, "pause ignore, da cannot seek");
        } else {
            pause(outParameter.getKey());
        }
    }

    public void playDrama(String str) {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter != null) {
            playDrama(outParameter.getKey(), str);
            return;
        }
        SourceLog.w(TAG, "playDrama ignore " + this.mCurrentState);
    }

    public void playNextDrama() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter != null) {
            playNextDrama(outParameter.getKey());
            return;
        }
        SourceLog.w(TAG, "playNextDrama ignore " + this.mCurrentState);
    }

    public void playPreDrama() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter != null) {
            playPreDrama(outParameter.getKey());
            return;
        }
        SourceLog.w(TAG, "playPreDrama ignore " + this.mCurrentState);
    }

    public void release() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter == null) {
            return;
        }
        release(outParameter.getKey());
    }

    public void reopen() {
        SourceLog.i(TAG, "reopen");
        initPlayer();
        setDataSource(this.mPlayInfo);
        start();
    }

    public void resume() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter != null) {
            resume(outParameter.getKey());
            return;
        }
        SourceLog.w(TAG, "pause ignore " + this.mCurrentState);
    }

    public void seekTo(int i10) {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter == null) {
            SourceLog.w(TAG, "seekTo ignore");
            return;
        }
        if (outParameter.pushType == 1) {
            SourceLog.w(TAG, "seekTo ignore, da cannot seek");
            return;
        }
        if (isInPlaybackState()) {
            seekTo(this.mPlayInfo.getKey(), i10);
            return;
        }
        SourceLog.w(TAG, "seekTo ignore 2: " + this.mCurrentState);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void selectAudiotrack(int i10) {
        if (isInPlaybackState()) {
            this.mCastPlayer.selectAudiotrack(i10);
            return;
        }
        SourceLog.w(TAG, "selectAudiotrack ignore " + this.mCurrentState);
    }

    public void setDataSource(OutParameter outParameter, int i10) {
        setDataSource(outParameter);
        SourceLog.i(TAG, " setDataSource    " + outParameter.urlID + "  " + outParameter.session);
        SourceDataReport.getInstance().onCastStart(outParameter, i10);
    }

    public void setLelinkPlayerListener(LelinkPlayerListenerDispatcher lelinkPlayerListenerDispatcher) {
        this.mLelinkPlayerListener = lelinkPlayerListenerDispatcher;
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void setMirrorScreenSecret(boolean z10) {
        this.mCastPlayer.setMirrorScreenSecret(z10);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void setSecondMirrorView(SecondMirrorView secondMirrorView) {
        this.mCastPlayer.setSecondMirrorView(secondMirrorView);
    }

    public void setStopType(int i10) {
        if (this.mStopType <= 0) {
            this.mStopType = i10;
        }
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    @Deprecated
    public void setVolume(int i10) {
        this.mCastPlayer.setVolume(i10);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void setWatermarkVisible(boolean z10) {
        this.mCastPlayer.setWatermarkVisible(z10);
    }

    public void start() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter == null) {
            SourceLog.w(TAG, "start ignore");
        } else {
            this.isReportStop = false;
            start(outParameter.getKey());
        }
    }

    public void stop(int i10) {
        SourceLog.i(TAG, "stop stopType: " + i10);
        if (this.mPlayInfo == null) {
            return;
        }
        if (i10 == 1005) {
            this.disconnectFromUser = true;
        }
        if (isInPlaybackState()) {
            if (this.mStopType <= 0) {
                this.mStopType = i10;
            }
            stop(this.mPlayInfo.getKey());
            reportStop();
            return;
        }
        SourceLog.w(TAG, "stop ignore 2: " + this.mCurrentState + " " + this);
    }

    public void stopWithCallback(int i10) {
        stop(i10);
        LelinkPlayerListenerDispatcher lelinkPlayerListenerDispatcher = this.mLelinkPlayerListener;
        if (lelinkPlayerListenerDispatcher != null) {
            lelinkPlayerListenerDispatcher.onStop(this.mPlayInfo);
        }
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void subVolume() {
        if (isInPlaybackState()) {
            this.mCastPlayer.subVolume();
            return;
        }
        SourceLog.w(TAG, "subVolume ignore " + this.mCurrentState);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean switchExpansionScreen(boolean z10) {
        return this.mCastPlayer.switchExpansionScreen(z10);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void release(String str) {
        SourceLog.w(TAG, "release " + str);
        reportStop();
        this.isReleased = true;
        this.mCastPlayer.release(str);
        e.d().b();
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean appendPlayList(String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        return this.mCastPlayer.appendPlayList(str, dramaInfoBeanArr, i10, i11, i12);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean clearPlayList(String str) {
        return this.mCastPlayer.clearPlayList(str);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean playDrama(String str, String str2) {
        return this.mCastPlayer.playDrama(str, str2);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean playNextDrama(String str) {
        return this.mCastPlayer.playNextDrama(str);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean playPreDrama(String str) {
        return this.mCastPlayer.playPreDrama(str);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean resume(String str) {
        if (!isInPlaybackState()) {
            SourceLog.w(TAG, "pause ignore 2: " + this.mCurrentState);
            return false;
        }
        return this.mCastPlayer.resume(str);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void setDataSource(OutParameter outParameter) {
        this.mPlayInfo = outParameter;
        this.mCastPlayer.setDataSource(outParameter);
        this.mCurrentState = -1;
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean start(String str) {
        if (!isInPlaybackState()) {
            SourceLog.w(TAG, "start ignore 2: " + this.mCurrentState);
            return false;
        }
        return this.mCastPlayer.start(str);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean pause(String str) {
        if (!isInPlaybackState()) {
            SourceLog.w(TAG, "pause ignore 2: " + this.mCurrentState);
            return false;
        }
        return this.mCastPlayer.pause(str);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public boolean seekTo(String str, int i10) {
        return this.mCastPlayer.seekTo(str, i10);
    }

    @Override // com.hpplay.sdk.source.player.IPlayer
    public void stop(String str) {
        SourceLog.i(TAG, "play control stop");
        this.isStopped = true;
        this.mCurrentState = 0;
        this.mCastPlayer.stop(str);
    }
}
