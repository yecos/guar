package com.hpplay.sdk.source.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.api.PlayerListenerConstant;
import com.hpplay.sdk.source.bean.AudioFrameBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.StopInfo;
import com.hpplay.sdk.source.bean.VideoFrameBean;
import com.hpplay.sdk.source.browse.api.OptionCentral;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.PublicCastClient;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.cloud.mirror.youme.OnCloudMirrorListener;
import com.hpplay.sdk.source.cloud.mirror.youme.YimConfigBean;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.mirror.yim.YimMirror;
import com.hpplay.sdk.source.pass.PassSender;
import com.hpplay.sdk.source.pass.bean.BaseBean;
import com.hpplay.sdk.source.pass.bean.MirrorStateBean;
import com.hpplay.sdk.source.pass.bean.SinkKeyEventRegisterBean;
import com.hpplay.sdk.source.pass.bean.SinkTouchEventRegisterBean;
import com.hpplay.sdk.source.pass.sinktouch.SinkTouchEventMonitor;
import com.hpplay.sdk.source.player.listener.OnCompletionListener;
import com.hpplay.sdk.source.player.listener.OnErrorListener;
import com.hpplay.sdk.source.player.listener.OnInfoListener;
import com.hpplay.sdk.source.player.listener.OnLoadingListener;
import com.hpplay.sdk.source.player.listener.OnPreparedListener;
import com.hpplay.sdk.source.player.listener.OnStateChangeListener;
import com.hpplay.sdk.source.player.listener.OnStopListener;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import com.hpplay.sdk.source.protocol.connect.AbsConnectBridge;
import com.hpplay.sdk.source.protocol.connect.OnPlayStateListener;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.CreateUtil;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes3.dex */
public class YimBridge extends AbsBridge {
    private static final int AUDIO_SAMPLE_RATE = 48000;
    private static final int CLOUD_MIRROR_DEFAULT_BITRATE = 1500000;
    public static final int CLOUD_MIRROR_SINK_START = 1;
    public static final int CLOUD_MIRROR_SINK_WAIT = 0;
    private static final int LOW_BITRATE_EXP_FRAME = 17;
    private static final String TAG = "YimBridge";
    private static final int WHAT_CAPTURE = 1;
    private static final int WHAT_REQUEST_FIR = 2;
    private int captureHeight;
    private int captureWidth;
    private boolean hasRegisterSinkTouchEvent;
    private boolean isCallPrepared;
    private boolean isChangeExpandView;
    private boolean isFrozen;
    private YimConfigBean mBean;
    private final AsyncHttpRequestListener mChangeListenerHttpParameter;
    private DelayNotifySinkTask mDelayNotifySinkTask;
    private int mFrameCount;
    private Handler mHandler;
    private BrowserInfo mIMInfo;
    private String mLocalConnectionIP;
    private int mLocalConnectionPort;
    private int mNotifyCount;
    private long mPrintFrameTime;
    private final com.hpplay.sdk.source.mirror.yim.a mPushMirrorListener;
    private long mRequestFirMark;
    private CaptureBridge mScreenCapture;
    private IOnSinkChangeListener mSinkChangeListener;
    private final OnPlayStateListener mStateListener;
    private Timer mTimer;
    private OnCloudMirrorListener mYimListener;
    private final AbsConnectBridge.OnPassReceivedListener onPassReceivedListener;

    public class DelayNotifySinkTask extends TimerTask {
        public DelayNotifySinkTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            SourceLog.i(YimBridge.TAG, "start mDelayNotifySinkTask ");
            YimBridge yimBridge = YimBridge.this;
            yimBridge.notifySinkChange(yimBridge.mSinkChangeListener);
        }
    }

    public interface IOnSinkChangeListener {
        public static final int FAILED = 0;
        public static final int SUCCESS = 1;

        void onChange(int i10);
    }

    public YimBridge(Context context, OutParameter outParameter) {
        super(context, outParameter);
        this.captureWidth = 1280;
        this.captureHeight = 720;
        this.mFrameCount = -1;
        this.mBean = new YimConfigBean();
        this.mTimer = new Timer();
        this.isChangeExpandView = false;
        this.hasRegisterSinkTouchEvent = false;
        this.isFrozen = false;
        this.isCallPrepared = false;
        this.mPrintFrameTime = 0L;
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.hpplay.sdk.source.protocol.YimBridge.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i10 = message.what;
                if (i10 != 1) {
                    if (i10 != 2 || YimBridge.this.mScreenCapture == null) {
                        return false;
                    }
                    YimBridge.this.mScreenCapture.requestKeyFrame();
                    return false;
                }
                if (YimBridge.this.mScreenCapture == null) {
                    return false;
                }
                YimBridge yimBridge = YimBridge.this;
                if (!yimBridge.mPlayInfo.isGroup) {
                    yimBridge.setExternalMirrorData();
                }
                CaptureBridge captureBridge = YimBridge.this.mScreenCapture;
                YimBridge yimBridge2 = YimBridge.this;
                captureBridge.onSinkPrepared(4, yimBridge2, yimBridge2.captureWidth, YimBridge.this.captureHeight, 30, YimBridge.CLOUD_MIRROR_DEFAULT_BITRATE, ParamsMap.MirrorParams.ENCODE_TYPE_H264);
                return false;
            }
        });
        this.mStateListener = new OnPlayStateListener() { // from class: com.hpplay.sdk.source.protocol.YimBridge.2
            @Override // com.hpplay.sdk.source.protocol.connect.OnPlayStateListener
            public void onError(String str, String str2) {
                if (TextUtils.isEmpty(str) || TextUtils.equals(str, YimBridge.this.mPlayInfo.urlID)) {
                    OnErrorListener onErrorListener = YimBridge.this.mErrorListener;
                    if (onErrorListener != null) {
                        onErrorListener.onError(null, 210010, 210011, null);
                        return;
                    }
                    return;
                }
                SourceLog.w(YimBridge.TAG, "onError ignore, " + str + Operator.Operation.DIVISION + YimBridge.this.mPlayInfo.urlID);
            }

            @Override // com.hpplay.sdk.source.protocol.connect.OnPlayStateListener
            public void onPause(String str) {
                if (TextUtils.isEmpty(str) || TextUtils.equals(str, YimBridge.this.mPlayInfo.urlID)) {
                    OnStateChangeListener onStateChangeListener = YimBridge.this.mStateChangeListener;
                    if (onStateChangeListener != null) {
                        onStateChangeListener.onStateChanged(null, 4);
                        return;
                    }
                    return;
                }
                SourceLog.w(YimBridge.TAG, "onPause ignore, " + str + Operator.Operation.DIVISION + YimBridge.this.mPlayInfo.urlID);
            }

            @Override // com.hpplay.sdk.source.protocol.connect.OnPlayStateListener
            public void onPlaying(String str, int i10, int i11) {
                if (TextUtils.isEmpty(str) || TextUtils.equals(str, YimBridge.this.mPlayInfo.urlID)) {
                    OnInfoListener onInfoListener = YimBridge.this.mInfoListener;
                    if (onInfoListener != null) {
                        onInfoListener.onInfo(null, 100, i10, i11);
                        return;
                    }
                    return;
                }
                SourceLog.w(YimBridge.TAG, "onPlaying ignore, " + str + Operator.Operation.DIVISION + YimBridge.this.mPlayInfo.urlID);
            }

            @Override // com.hpplay.sdk.source.protocol.connect.OnPlayStateListener
            public void onStart(String str) {
                if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, YimBridge.this.mPlayInfo.urlID)) {
                    SourceLog.w(YimBridge.TAG, "onStart ignore, " + str + Operator.Operation.DIVISION + YimBridge.this.mPlayInfo.urlID);
                    return;
                }
                if (YimBridge.this.isCallPrepared) {
                    OnStateChangeListener onStateChangeListener = YimBridge.this.mStateChangeListener;
                    if (onStateChangeListener != null) {
                        onStateChangeListener.onStateChanged(null, 3);
                        return;
                    }
                    return;
                }
                YimBridge.this.isCallPrepared = true;
                OnPreparedListener onPreparedListener = YimBridge.this.mPreparedListener;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(null);
                }
            }

            @Override // com.hpplay.sdk.source.protocol.connect.OnPlayStateListener
            public void onStop(String str, int i10) {
                if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, YimBridge.this.mPlayInfo.urlID)) {
                    SourceLog.w(YimBridge.TAG, "onStop ignore, " + str + Operator.Operation.DIVISION + YimBridge.this.mPlayInfo.urlID);
                    return;
                }
                if (i10 == 0) {
                    OnCompletionListener onCompletionListener = YimBridge.this.mCompletionListener;
                    if (onCompletionListener != null) {
                        onCompletionListener.onComplete(null);
                        return;
                    }
                    return;
                }
                SourceLog.i(YimBridge.TAG, " STOP_NORMAL stop ");
                YimBridge yimBridge = YimBridge.this;
                if (yimBridge.mPlayInfo == null || yimBridge.isFrozen) {
                    return;
                }
                if (YimBridge.this.mStopListener != null) {
                    StopInfo stopInfo = new StopInfo();
                    stopInfo.type = 1;
                    YimBridge.this.mStopListener.onStop(null, stopInfo);
                }
                YimBridge yimBridge2 = YimBridge.this;
                yimBridge2.stop(yimBridge2.mPlayInfo.getKey());
            }
        };
        this.mYimListener = new OnCloudMirrorListener() { // from class: com.hpplay.sdk.source.protocol.YimBridge.3
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0101 -> B:32:0x01e1). Please report as a decompilation issue!!! */
            public void onEventCallback(int i10, Object... objArr) {
                SourceLog.i(YimBridge.TAG, " onEventCallback " + i10);
                if (i10 == 1) {
                    int parseInt = Integer.parseInt(objArr[0].toString());
                    if (parseInt == -1) {
                        SourceLog.w(YimBridge.TAG, "login failed");
                        YimBridge.this.callbackError(211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_IO, null);
                    }
                    SourceDataReport.getInstance().onYimInit(IMediaPlayer.MEDIA_INFO_BUFFERING_START, YimBridge.this.mPlayInfo, parseInt == 1, null, null);
                    return;
                }
                if (i10 == 2) {
                    int parseInt2 = Integer.parseInt(objArr[0].toString());
                    if (parseInt2 == -1) {
                        SourceLog.w(YimBridge.TAG, "join room failed");
                        YimBridge.this.callbackError(211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_IO, null);
                        return;
                    } else {
                        if (parseInt2 != 1 || YimBridge.this.mHandler == null) {
                            return;
                        }
                        YimBridge.this.mHandler.obtainMessage(1).sendToTarget();
                        return;
                    }
                }
                if (i10 == 3) {
                    int parseInt3 = Integer.parseInt(objArr[0].toString());
                    SourceLog.i(YimBridge.TAG, "EVENT_QUIT: " + parseInt3);
                    if (parseInt3 == 3) {
                        YimBridge.this.stopAll();
                    } else if (parseInt3 != 4) {
                        YimBridge.this.stopAll();
                    } else {
                        if (!YimBridge.this.isCurrentSink(objArr[1].toString())) {
                            return;
                        }
                        YimBridge yimBridge = YimBridge.this;
                        yimBridge.stop(yimBridge.mPlayInfo.getKey());
                        YimMirror.getInstance().removeCloudMirrorListener(YimBridge.this.mYimListener);
                    }
                    StopInfo stopInfo = new StopInfo();
                    if (parseInt3 == 2) {
                        stopInfo.type = 2;
                    } else {
                        stopInfo.type = 1;
                    }
                    OnStopListener onStopListener = YimBridge.this.mStopListener;
                    if (onStopListener != null) {
                        onStopListener.onStop(null, stopInfo);
                        return;
                    }
                    return;
                }
                if (i10 != 500) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(objArr[0].toString());
                    boolean optBoolean = jSONObject.optBoolean("fir");
                    int optInt = jSONObject.optInt(IjkMediaMeta.IJKM_KEY_BITRATE);
                    int optInt2 = jSONObject.optInt("fps");
                    if (YimBridge.this.mScreenCapture != null && !YimBridge.this.isFrozen) {
                        if (optBoolean) {
                            if (System.currentTimeMillis() - YimBridge.this.mRequestFirMark < 1000) {
                                YimBridge.this.mScreenCapture.requestKeyFrame();
                                YimBridge.this.mRequestFirMark = System.currentTimeMillis();
                            } else {
                                SourceLog.i(YimBridge.TAG, "++++++++++++++++++++++++++++===delay request key f");
                                YimBridge.this.mRequestFirMark = System.currentTimeMillis();
                                YimBridge.this.mHandler.removeMessages(2);
                                YimBridge.this.mHandler.sendEmptyMessageDelayed(2, 1000L);
                            }
                        }
                        if (optInt > 0) {
                            YimBridge.this.mScreenCapture.setBitRate(4, optInt * 1024);
                        }
                        if (optInt2 > 0) {
                            if (YimBridge.this.mScreenCapture.getBitrate() / 1024 <= 1000) {
                                YimBridge.this.mScreenCapture.setFrameRate(4, 17);
                            } else {
                                YimBridge.this.mScreenCapture.setFrameRate(4, optInt2);
                            }
                        }
                        try {
                            if (jSONObject.getBoolean("pause_encode")) {
                                SourceLog.i(YimBridge.TAG, "=============pause encoder======");
                                YimBridge.this.mScreenCapture.pauseEncode(false);
                            } else {
                                SourceLog.i(YimBridge.TAG, "=============resume encoder======");
                                YimBridge.this.mScreenCapture.resumeEncode();
                            }
                        } catch (JSONException e10) {
                            SourceLog.w(YimBridge.TAG, e10);
                        }
                    }
                } catch (Exception e11) {
                    SourceLog.w(YimBridge.TAG, "EVENT_VIDEO_ENCODE_PARAM_REPORT :" + e11);
                }
            }
        };
        this.mPushMirrorListener = new com.hpplay.sdk.source.mirror.yim.a() { // from class: com.hpplay.sdk.source.protocol.YimBridge.4
            @Override // com.hpplay.sdk.source.mirror.yim.a
            public void result(int i10, String str, String str2) {
                SourceLog.i(YimBridge.TAG, "IPushMirrorListener, " + i10);
                if (i10 != 200) {
                    if (i10 == -1) {
                        YimBridge.this.callbackError(211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_IO, str2);
                        return;
                    }
                    if (i10 == 410 || i10 == 411) {
                        OnErrorListener onErrorListener = YimBridge.this.mErrorListener;
                        if (onErrorListener != null) {
                            onErrorListener.onError(null, 211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_SINK_CLOUD_UNSUPPORTED, str2);
                        }
                    } else if (i10 == 403) {
                        OnErrorListener onErrorListener2 = YimBridge.this.mErrorListener;
                        if (onErrorListener2 != null) {
                            onErrorListener2.onError(null, 211000, 210004, str2);
                        }
                    } else {
                        SourceLog.w(YimBridge.TAG, "onError " + i10);
                        OnErrorListener onErrorListener3 = YimBridge.this.mErrorListener;
                        if (onErrorListener3 != null) {
                            onErrorListener3.onError(null, 211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_IO, str2);
                        }
                    }
                    SourceDataReport.getInstance().onGetRoomFailed(YimBridge.this.mPlayInfo, null);
                    return;
                }
                YimBridge yimBridge = YimBridge.this;
                yimBridge.mPlayInfo.roomID = str;
                yimBridge.mBean.userID = CreateUtil.createYimUserID();
                YimBridge.this.mBean.roomID = str;
                YimBridge.this.mBean.inputWidth = YimBridge.this.captureWidth;
                YimBridge.this.mBean.inputHeight = YimBridge.this.captureHeight;
                YimBridge.this.mBean.sampleRate = 48000;
                YimBridge.this.mBean.ip = YimBridge.this.mLocalConnectionIP;
                YimBridge.this.mBean.port = YimBridge.this.mLocalConnectionPort;
                YimMirror.getInstance().initSource(YimBridge.this.mContext);
                YimMirror.getInstance().login(YimBridge.this.mBean);
                SourceDataReport.getInstance().onGetRoomSuccess(YimBridge.this.mPlayInfo, str);
                OnLoadingListener onLoadingListener = YimBridge.this.mLoadingListener;
                if (onLoadingListener != null) {
                    onLoadingListener.onLoading(null, null);
                }
            }
        };
        this.onPassReceivedListener = new AbsConnectBridge.OnPassReceivedListener() { // from class: com.hpplay.sdk.source.protocol.YimBridge.5
            @Override // com.hpplay.sdk.source.protocol.connect.AbsConnectBridge.OnPassReceivedListener
            public void onPassReversed(int i10, BaseBean baseBean) {
                if (i10 == 26) {
                    if (((MirrorStateBean) baseBean).action == 0) {
                        YimBridge yimBridge = YimBridge.this;
                        yimBridge.pause(yimBridge.mPlayInfo.getKey());
                    } else {
                        YimBridge yimBridge2 = YimBridge.this;
                        yimBridge2.resume(yimBridge2.mPlayInfo.getKey());
                    }
                }
            }
        };
        this.mChangeListenerHttpParameter = new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.protocol.YimBridge.6
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                YimBridge.access$1408(YimBridge.this);
                if (asyncHttpParameter.out == null) {
                    SourceLog.i(YimBridge.TAG, "notify change  onRequestResult null  mNotifyCount " + YimBridge.this.mNotifyCount);
                    if (YimBridge.this.mNotifyCount < 5) {
                        YimBridge.this.delayNotify(1000L);
                        return;
                    } else {
                        if (YimBridge.this.mSinkChangeListener != null) {
                            YimBridge.this.mSinkChangeListener.onChange(0);
                            return;
                        }
                        return;
                    }
                }
                SourceLog.i(YimBridge.TAG, "notify change  onRequestResult: " + asyncHttpParameter.out.result + "  mNotifyCount " + YimBridge.this.mNotifyCount);
                AsyncHttpParameter.Out out = asyncHttpParameter.out;
                if (out.resultType != 2 && !TextUtils.isEmpty(out.result)) {
                    if (YimBridge.this.mSinkChangeListener != null) {
                        YimBridge.this.mSinkChangeListener.onChange(1);
                    }
                } else if (YimBridge.this.mNotifyCount < 5) {
                    YimBridge.this.delayNotify(1000L);
                } else if (YimBridge.this.mSinkChangeListener != null) {
                    YimBridge.this.mSinkChangeListener.onChange(0);
                }
            }
        };
        BrowserInfo browserInfo = CastUtil.getBrowserInfo(outParameter.serviceInfo, 4);
        if (browserInfo == null) {
            SourceLog.w(TAG, "has no im info, never should be here");
            return;
        }
        this.mIMInfo = browserInfo;
        this.mLocalConnectionIP = browserInfo.getIp();
        BrowserInfo browserInfo2 = outParameter.serviceInfo.getBrowserInfos().get(1);
        String str = browserInfo2 != null ? browserInfo2.getExtras().get("mirror") : null;
        if (TextUtils.isEmpty(str)) {
            this.mLocalConnectionPort = 7100;
        } else {
            this.mLocalConnectionPort = Integer.parseInt(str);
        }
        CaptureBridge captureBridge = CaptureBridge.getInstance();
        this.mScreenCapture = captureBridge;
        captureBridge.init();
        this.mScreenCapture.setPlayInfo(outParameter);
    }

    public static /* synthetic */ int access$1408(YimBridge yimBridge) {
        int i10 = yimBridge.mNotifyCount;
        yimBridge.mNotifyCount = i10 + 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackError(int i10, int i11, String str) {
        OnErrorListener onErrorListener = this.mErrorListener;
        if (onErrorListener != null) {
            onErrorListener.onError(null, i10, i11, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delayNotify(long j10) {
        stopTask();
        DelayNotifySinkTask delayNotifySinkTask = new DelayNotifySinkTask();
        this.mDelayNotifySinkTask = delayNotifySinkTask;
        this.mTimer.schedule(delayNotifySinkTask, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRegisterSinkTouchEvent() {
        SourceLog.i(TAG, "doRegisterSinkTouchEvent: hasRegisterSinkTouchEvent： " + this.hasRegisterSinkTouchEvent);
        if (this.hasRegisterSinkTouchEvent) {
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.hpplay.sdk.source.protocol.YimBridge.12
            @Override // java.lang.Runnable
            public void run() {
                SinkTouchEventMonitor sinkTouchEventMonitor = SinkTouchEventMonitor.getInstance();
                YimBridge yimBridge = YimBridge.this;
                sinkTouchEventMonitor.startMonitor(yimBridge.mContext, yimBridge.mPlayInfo.session, true);
            }
        }, 1000L);
        PassSender.getInstance().sendSinkTouchRegister(SinkTouchEventRegisterBean.createRegisterBean().toJson(), this.mPlayInfo.session);
        this.hasRegisterSinkTouchEvent = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUnregisterSinkTouchEvent() {
        SourceLog.i(TAG, "doUnregisterSinkTouchEvent: ");
        this.hasRegisterSinkTouchEvent = false;
        SinkTouchEventMonitor.getInstance().stopMonitor();
        PassSender.getInstance().sendSinkTouchRegister(SinkTouchEventRegisterBean.createUnregisterBean().toJson(), this.mPlayInfo.session);
    }

    private int getScene() {
        return this.mPlayInfo.connectProtocol == 6 ? 0 : 1;
    }

    private void initExternalAudioSource() {
        OptionCentral.setOnPCMUpdateListener(new OptionCentral.OnPCMUpdateListener() { // from class: com.hpplay.sdk.source.protocol.YimBridge.9
            @Override // com.hpplay.sdk.source.browse.api.OptionCentral.OnPCMUpdateListener
            public void onAudioUpdate(byte[] bArr, AudioFrameBean audioFrameBean) {
                SourceLog.w(YimBridge.TAG, "onAudioUpdate " + bArr.length + "  " + audioFrameBean.channel + "  / " + audioFrameBean.sampleRate);
                YimMirror.getInstance().sendAudio(bArr, bArr.length, System.currentTimeMillis(), audioFrameBean.channel == 16 ? 1 : 2);
            }
        });
    }

    private void initExternalVideo() {
        OptionCentral.setOnVideoUpdateListener(new OptionCentral.OnVideoUpdateListener() { // from class: com.hpplay.sdk.source.protocol.YimBridge.7
            @Override // com.hpplay.sdk.source.browse.api.OptionCentral.OnVideoUpdateListener
            public void onVideoUpdate(byte[] bArr, VideoFrameBean videoFrameBean) {
                int i10 = videoFrameBean.type;
                if (i10 == 1) {
                    YimMirror.getInstance().sendH264Data(ByteBuffer.wrap(bArr), videoFrameBean.width, videoFrameBean.height, videoFrameBean.pts);
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    YimMirror.getInstance().sendRGBData(bArr, videoFrameBean.width, videoFrameBean.height, 0, videoFrameBean.pts / 1000, 1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCurrentSink(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String substring = str.substring(str.lastIndexOf("_") + 1);
            SourceLog.i(TAG, "isCurrentSink, " + substring);
            return TextUtils.equals(substring, this.mPlayInfo.serviceInfo.getUid());
        } catch (Exception unused) {
            return false;
        }
    }

    private void monitorExternalAudio() {
        OptionCentral.setOnExternalAudioStateChangedListener(new OptionCentral.OnExternalAudioStateChangedListener() { // from class: com.hpplay.sdk.source.protocol.YimBridge.8
            @Override // com.hpplay.sdk.source.browse.api.OptionCentral.OnExternalAudioStateChangedListener
            public void onStateChanged(boolean z10) {
                SourceLog.i(YimBridge.TAG, "onStateChanged: isEnable: " + z10);
                int audioCaptureType = z10 ? 1 : CaptureBridge.getInstance().getAudioCaptureType(YimBridge.this.mPlayInfo);
                if (YimBridge.this.mScreenCapture != null) {
                    YimBridge.this.mScreenCapture.setAudioSwitch(audioCaptureType, 0, YimBridge.this.mPlayInfo.requestAudioFocus, true);
                }
            }
        });
    }

    private void registerSinkKeyEvent() {
        SourceLog.i(TAG, "registerSinkKeyEvent isRegister:" + OptionCentral.isRegisterSinkKeyEvent());
        if (OptionCentral.isRegisterSinkKeyEvent()) {
            PassSender.getInstance().sendSinkKeyRegister(SinkKeyEventRegisterBean.createRegisterBean().toJson(), this.mPlayInfo.session);
        }
        OptionCentral.setOnSinkKeyEventRegisterListener(new OptionCentral.OnSinkKeyEventRegisterListener() { // from class: com.hpplay.sdk.source.protocol.YimBridge.10
            @Override // com.hpplay.sdk.source.browse.api.OptionCentral.OnSinkKeyEventRegisterListener
            public void onRegister() {
                PassSender.getInstance().sendSinkKeyRegister(SinkKeyEventRegisterBean.createRegisterBean().toJson(), YimBridge.this.mPlayInfo.session);
            }

            @Override // com.hpplay.sdk.source.browse.api.OptionCentral.OnSinkKeyEventRegisterListener
            public void onUnregister() {
                PassSender.getInstance().sendSinkKeyRegister(SinkKeyEventRegisterBean.createUnregisterBean().toJson(), YimBridge.this.mPlayInfo.session);
            }
        });
    }

    private void registerSinkTouchEvent() {
        if (OptionCentral.isRegistSinkTouchEvent()) {
            doRegisterSinkTouchEvent();
        }
        OptionCentral.setOnSinkTouchEventRegisterListener(new OptionCentral.OnSinkTouchEventRegisterListener() { // from class: com.hpplay.sdk.source.protocol.YimBridge.11
            @Override // com.hpplay.sdk.source.browse.api.OptionCentral.OnSinkTouchEventRegisterListener
            public void onRegister() {
                SourceLog.i(YimBridge.TAG, "onRegister: ");
                YimBridge.this.doRegisterSinkTouchEvent();
            }

            @Override // com.hpplay.sdk.source.browse.api.OptionCentral.OnSinkTouchEventRegisterListener
            public void onUnregister() {
                YimBridge.this.doUnregisterSinkTouchEvent();
            }
        });
    }

    private void sendNoneAudioFrame() {
        if (CaptureBridge.getInstance().getAudioSwitch() == 0) {
            sendAudioData(new byte[2048], 0, 2048);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopAll() {
        SourceLog.i(TAG, "stopAll");
        stop();
        CaptureBridge captureBridge = this.mScreenCapture;
        if (captureBridge != null) {
            captureBridge.release();
        }
        YimMirror.getInstance().stop();
        YimMirror.getInstance().removeCloudMirrorListener(this.mYimListener);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void frozen(boolean z10) {
        super.frozen(z10);
        SourceLog.i(TAG, "+++++++++++++++++++++++ frozen " + z10);
        this.isFrozen = z10;
        YimMirror.getInstance().frozen(z10);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void notifySinkChange(IOnSinkChangeListener iOnSinkChangeListener) {
        if (this.isFrozen) {
            return;
        }
        SinkTouchEventMonitor.getInstance().createIMMonitorChannel();
        SourceLog.i(TAG, " start notify sink Change");
        this.mNotifyCount = 0;
        this.mSinkChangeListener = iOnSinkChangeListener;
        YimMirror.getInstance().requestPushMirror(this.mIMInfo, this.mPlayInfo, 1, this.mChangeListenerHttpParameter, null);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void onCaptureStart(int i10) {
        SourceLog.i(TAG, "onCaptureStart,isCallPrepared " + this.isCallPrepared + ",isFrozen " + this.isFrozen);
        if (this.isFrozen) {
            return;
        }
        if (this.isCallPrepared) {
            OnStateChangeListener onStateChangeListener = this.mStateChangeListener;
            if (onStateChangeListener != null) {
                onStateChangeListener.onStateChanged(null, 3);
            }
        } else {
            this.isCallPrepared = true;
            OnPreparedListener onPreparedListener = this.mPreparedListener;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared(null);
            }
        }
        SinkTouchEventMonitor.getInstance().createIMMonitorChannel();
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void onCaptureStop(int i10) {
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void onInfo(int i10, String str) {
        if (i10 == 10 || i10 == 120105112) {
            super.onInfo(i10, str);
            return;
        }
        SourceLog.i(TAG, "Capture onInfo " + i10 + Operator.Operation.DIVISION + str);
        if (!LelinkSdkManager.getInstance().getRetryMirrorOnce().get()) {
            LelinkSdkManager.getInstance().getRetryMirrorOnce().set(true);
        } else {
            LelinkSdkManager.getInstance().getRetryMirrorOnce().set(false);
            SourceLog.i(TAG, "Capture onInfo retried.");
        }
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void pause(String str) {
        if (this.mScreenCapture == null) {
            return;
        }
        SourceLog.i(TAG, "pause");
        PassSender.getInstance().sendMirrorState(MirrorStateBean.createPauseBean(this.mPlayInfo.urlID).toJson(), this.mPlayInfo.session);
        this.mScreenCapture.pauseEncode(true);
        OnStateChangeListener onStateChangeListener = this.mStateChangeListener;
        if (onStateChangeListener != null) {
            onStateChangeListener.onStateChanged(null, 4);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void play(String str) {
        SourceLog.i(TAG, "play " + str);
        this.isCallPrepared = false;
        PublicCastClient.getInstance().setOnPlayStateListener(this.mStateListener);
        ConnectManager.getInstance().getLastConnectBridge().addOnPassReceivedListener(this, this.onPassReceivedListener);
        int i10 = Preference.getInstance().get(Constant.KEY_CLOUD_MIRROR_WIDTH, 0);
        int i11 = Preference.getInstance().get(Constant.KEY_CLOUD_MIRROR_HEIGHT, 0);
        if ((i11 > 0) & (i10 > 0)) {
            this.captureWidth = i10;
            this.captureHeight = i11;
        }
        ConnectManager.getInstance().getLastConnectBridge().addOnPassReceivedListener(this, this.onPassReceivedListener);
        YimMirror.getInstance().addCloudMirrorListener(this.mYimListener);
        YimMirror.getInstance().play(this.mIMInfo, this.mPlayInfo, getScene(), this.mPushMirrorListener);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void release() {
        SourceLog.i(TAG, "release");
        PublicCastClient.getInstance().setOnPlayStateListener(null);
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void resume(String str) {
        if (this.mScreenCapture == null) {
            return;
        }
        SourceLog.i(TAG, "resume");
        PassSender.getInstance().sendMirrorState(MirrorStateBean.createResumeBean(this.mPlayInfo.urlID).toJson(), this.mPlayInfo.session);
        this.mScreenCapture.resumeEncode();
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void screenshot(int i10) {
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void seekTo(int i10) {
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void sendAudioData(byte[] bArr, int i10, int i11) {
        if (OptionCentral.isEnableExternalAudio()) {
            return;
        }
        YimMirror.getInstance().sendAudio(bArr, i11, System.currentTimeMillis(), 2);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void sendVideoData(ByteBuffer byteBuffer, int i10, int i11, int i12, long j10) {
        this.mFrameCount++;
        if (byteBuffer.remaining() / 1024.0f >= 10.0f && this.mScreenCapture.getBitrate() < 1000000) {
            SourceLog.i(TAG, "  onVideoDataCallback big frame size : " + (byteBuffer.remaining() / 1024.0f));
        }
        if (System.currentTimeMillis() - this.mPrintFrameTime >= 5000) {
            SourceLog.i(TAG, "sendVideoData " + j10 + "/  fps : " + (this.mFrameCount / 5) + " , " + this);
            this.mPrintFrameTime = System.currentTimeMillis();
            this.mFrameCount = 0;
            sendNoneAudioFrame();
        }
        try {
            YimMirror.getInstance().sendH264Data(byteBuffer, i10, i11, System.currentTimeMillis());
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void setExternalMirrorData() {
        SourceLog.i(TAG, "setExternalMirrorData");
        initExternalVideo();
        initExternalAudioSource();
        monitorExternalAudio();
        registerSinkKeyEvent();
        registerSinkTouchEvent();
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void setMirrorScreenSecret(boolean z10) {
        CaptureBridge captureBridge = this.mScreenCapture;
        if (captureBridge == null) {
            SourceLog.w(TAG, "setMirrorScreenSecret ignore");
        } else {
            captureBridge.setMirrorScreenSecret(z10);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void setSecondMirrorView(SecondMirrorView secondMirrorView) {
        super.setSecondMirrorView(secondMirrorView);
        CaptureBridge captureBridge = this.mScreenCapture;
        if (captureBridge == null) {
            return;
        }
        captureBridge.setSecondMirrorView(secondMirrorView);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void setWatermarkVisible(boolean z10) {
        if (this.mScreenCapture == null) {
            SourceLog.w(TAG, "setWatermarkVisible ignore");
        } else {
            SourceLog.i(TAG, "setWatermarkVisible");
            this.mScreenCapture.setWatermarkVisible(z10);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void stop(String str) {
        if (CastUtil.isSupportCloudMultiCast() && this.mPlayInfo.isMultiCast) {
            stop();
        } else {
            stopAll();
        }
    }

    public void stopTask() {
        SourceLog.i(TAG, " stopTask ");
        DelayNotifySinkTask delayNotifySinkTask = this.mDelayNotifySinkTask;
        if (delayNotifySinkTask != null) {
            delayNotifySinkTask.cancel();
            this.mTimer.purge();
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public boolean switchExpansionScreen(boolean z10) {
        CaptureBridge captureBridge = this.mScreenCapture;
        if (captureBridge == null) {
            return false;
        }
        OutParameter outParameter = this.mPlayInfo;
        outParameter.isExpandMirror = z10;
        this.isChangeExpandView = true;
        captureBridge.setExpansionScreenInfo(outParameter.expandActivity, outParameter.expandView);
        this.mScreenCapture.switchExpansionScreen(z10);
        return true;
    }

    private void stop() {
        SourceLog.i(TAG, "stop");
        CaptureBridge captureBridge = this.mScreenCapture;
        if (captureBridge != null) {
            captureBridge.removeAbsBridge(4);
            this.mScreenCapture.release(2);
        }
        PublicCastClient.getInstance().stop(this.mPlayInfo);
        YimMirror.getInstance().stop();
        ConnectManager.getInstance().getLastConnectBridge().removeOnPassReceivedListener(this);
        OptionCentral.setOnSinkKeyEventRegisterListener(null);
        OptionCentral.setOnSinkTouchEventRegisterListener(null);
        doUnregisterSinkTouchEvent();
        PassSender.getInstance().sendSinkKeyRegister(SinkKeyEventRegisterBean.createUnregisterBean().toJson(), this.mPlayInfo.session);
    }
}
