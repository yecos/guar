package com.hpplay.sdk.source.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hpplay.common.utils.FieldUtil;
import com.hpplay.common.utils.ScreenUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.IMirrorController;
import com.hpplay.component.common.protocol.IMirrorStateListener;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.api.IDebugAVListener;
import com.hpplay.sdk.source.api.LelinkSourceSDK;
import com.hpplay.sdk.source.api.PlayerListenerConstant;
import com.hpplay.sdk.source.bean.AudioFrameBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.StopInfo;
import com.hpplay.sdk.source.bean.VideoFrameBean;
import com.hpplay.sdk.source.browse.api.OptionCentral;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.PassSender;
import com.hpplay.sdk.source.pass.bean.BaseBean;
import com.hpplay.sdk.source.pass.bean.MirrorStateBean;
import com.hpplay.sdk.source.pass.bean.SinkKeyEventRegisterBean;
import com.hpplay.sdk.source.pass.sinktouch.SinkTouchEventMonitor;
import com.hpplay.sdk.source.player.listener.OnErrorListener;
import com.hpplay.sdk.source.player.listener.OnInfoListener;
import com.hpplay.sdk.source.player.listener.OnLoadingListener;
import com.hpplay.sdk.source.player.listener.OnPreparedListener;
import com.hpplay.sdk.source.player.listener.OnStateChangeListener;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import com.hpplay.sdk.source.protocol.connect.AbsConnectBridge;
import com.hpplay.sdk.source.utils.CastUtil;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class LelinkMirrorBridge extends AbsBridge {
    private static final String TAG = "LelinkMirrorBridge";
    private static final int WHAT_CAPTURE = 1;
    private boolean hasRegisterSinkTouchEvent;
    private boolean isCallError;
    private boolean isCallPrepared;
    private boolean isCallStop;
    private boolean isFrozen;
    private final IDebugAVListener mAppAVListener;
    private final Handler mHandler;
    private IMirrorController mMirrorController;
    private IMirrorStateListener mMirrorListener;
    private int mMirrorSendTimeout;
    private ModuleLinker mModuleLinker;
    private CaptureBridge mScreenCapture;
    private final OptionCentral.OnExternalAudioStateChangedListener onExternalAudioStateChangedListener;
    private final OptionCentral.OnPCMUpdateListener onPCMUpdateListener;
    private final AbsConnectBridge.OnPassReceivedListener onPassReceivedListener;
    private final OptionCentral.OnVideoUpdateListener onVideoUpdateListener;

    public static class CaptureBean {
        public int bitrate;
        public String encodeType;
        public int sinkFrameRate;
        public int sinkHeight;
        public int sinkWidth;

        private CaptureBean() {
        }
    }

    public LelinkMirrorBridge(Context context, OutParameter outParameter) {
        super(context, outParameter);
        this.isCallPrepared = false;
        this.isCallError = false;
        this.isCallStop = false;
        this.hasRegisterSinkTouchEvent = false;
        this.isFrozen = false;
        this.mMirrorSendTimeout = 20;
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.hpplay.sdk.source.protocol.LelinkMirrorBridge.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what != 1) {
                    return false;
                }
                try {
                    if (LelinkMirrorBridge.this.mScreenCapture != null) {
                        CaptureBean captureBean = (CaptureBean) message.obj;
                        LelinkMirrorBridge.this.callLoading();
                        if (!LelinkMirrorBridge.this.mPlayInfo.isGroup || OptionCentral.isExternalVideo()) {
                            LelinkMirrorBridge.this.setExternalMirrorData();
                        }
                        LelinkMirrorBridge.this.mScreenCapture.onSinkPrepared(1, LelinkMirrorBridge.this, captureBean.sinkWidth, captureBean.sinkHeight, captureBean.sinkFrameRate, captureBean.bitrate, captureBean.encodeType);
                    }
                    LelinkMirrorBridge.this.registerSinkKeyEvent();
                    LelinkMirrorBridge.this.registerSinkTouchEvent();
                    return false;
                } catch (Exception e10) {
                    SourceLog.w(LelinkMirrorBridge.TAG, e10);
                    return false;
                }
            }
        });
        this.onExternalAudioStateChangedListener = new OptionCentral.OnExternalAudioStateChangedListener() { // from class: com.hpplay.sdk.source.protocol.LelinkMirrorBridge.2
            @Override // com.hpplay.sdk.source.browse.api.OptionCentral.OnExternalAudioStateChangedListener
            public void onStateChanged(boolean z10) {
                if (LelinkMirrorBridge.this.isFrozen) {
                    return;
                }
                SourceLog.i(LelinkMirrorBridge.TAG, "onStateChanged: isEnable: " + z10);
                int audioCaptureType = z10 ? 1 : CaptureBridge.getInstance().getAudioCaptureType(LelinkMirrorBridge.this.mPlayInfo);
                if (LelinkMirrorBridge.this.mScreenCapture != null) {
                    LelinkMirrorBridge.this.mScreenCapture.setAudioSwitch(audioCaptureType, 1, LelinkMirrorBridge.this.mPlayInfo.requestAudioFocus, true);
                }
            }
        };
        this.onVideoUpdateListener = new OptionCentral.OnVideoUpdateListener() { // from class: com.hpplay.sdk.source.protocol.LelinkMirrorBridge.3
            @Override // com.hpplay.sdk.source.browse.api.OptionCentral.OnVideoUpdateListener
            public void onVideoUpdate(byte[] bArr, VideoFrameBean videoFrameBean) {
                if (LelinkMirrorBridge.this.isFrozen) {
                    SourceLog.w(LelinkMirrorBridge.TAG, "updateVideoData onVideoUpdate ignore " + bArr.length);
                    return;
                }
                int i10 = videoFrameBean.type;
                if (i10 != 1) {
                    if (i10 != 2) {
                        return;
                    }
                    SourceLog.w(LelinkMirrorBridge.TAG, "onVideoUpdate rgb data not support now");
                    return;
                }
                SourceLog.w(LelinkMirrorBridge.TAG, "updateVideoData onVideoUpdate " + bArr.length);
                if (LelinkMirrorBridge.this.mMirrorController == null || LelinkMirrorBridge.this.mScreenCapture == null) {
                    return;
                }
                LelinkMirrorBridge.this.mScreenCapture.updateH264Data(bArr, 0, bArr.length);
            }
        };
        this.onPassReceivedListener = new AbsConnectBridge.OnPassReceivedListener() { // from class: com.hpplay.sdk.source.protocol.LelinkMirrorBridge.4
            @Override // com.hpplay.sdk.source.protocol.connect.AbsConnectBridge.OnPassReceivedListener
            public void onPassReversed(int i10, BaseBean baseBean) {
                if (!LelinkMirrorBridge.this.isFrozen && i10 == 26) {
                    if (((MirrorStateBean) baseBean).action == 0) {
                        LelinkMirrorBridge lelinkMirrorBridge = LelinkMirrorBridge.this;
                        lelinkMirrorBridge.pause(lelinkMirrorBridge.mPlayInfo.getKey());
                    } else {
                        LelinkMirrorBridge lelinkMirrorBridge2 = LelinkMirrorBridge.this;
                        lelinkMirrorBridge2.resume(lelinkMirrorBridge2.mPlayInfo.getKey());
                    }
                }
            }
        };
        this.onPCMUpdateListener = new OptionCentral.OnPCMUpdateListener() { // from class: com.hpplay.sdk.source.protocol.LelinkMirrorBridge.5
            @Override // com.hpplay.sdk.source.browse.api.OptionCentral.OnPCMUpdateListener
            public void onAudioUpdate(byte[] bArr, AudioFrameBean audioFrameBean) {
                if (LelinkMirrorBridge.this.isFrozen || LelinkMirrorBridge.this.mScreenCapture == null) {
                    return;
                }
                LelinkMirrorBridge.this.mScreenCapture.updatePCMData(audioFrameBean.sampleRate, audioFrameBean.channel, audioFrameBean.audioFormat, bArr, audioFrameBean.offset, audioFrameBean.length);
            }
        };
        this.mMirrorListener = new IMirrorStateListener() { // from class: com.hpplay.sdk.source.protocol.LelinkMirrorBridge.6
            @Override // com.hpplay.component.common.protocol.IMirrorStateListener
            public void onBitrateCallback(int i10) {
                if (LelinkMirrorBridge.this.isFrozen) {
                    return;
                }
                SourceLog.i(LelinkMirrorBridge.TAG, "Mirror onBitrateCallback " + i10);
                if (LelinkMirrorBridge.this.mScreenCapture != null) {
                    LelinkMirrorBridge.this.mScreenCapture.setBitRate(1, i10);
                }
            }

            @Override // com.hpplay.component.common.protocol.IMirrorStateListener
            public void onBroken() {
                SourceLog.i(LelinkMirrorBridge.TAG, "Mirror onBroken isFrozen :" + LelinkMirrorBridge.this.mPlayInfo.isGroup);
                LelinkMirrorBridge lelinkMirrorBridge = LelinkMirrorBridge.this;
                if (!lelinkMirrorBridge.mPlayInfo.isGroup) {
                    lelinkMirrorBridge.stopMirror();
                } else if (lelinkMirrorBridge.mScreenCapture != null) {
                    LelinkMirrorBridge.this.mScreenCapture.onBroken(1);
                }
            }

            @Override // com.hpplay.component.common.protocol.IMirrorStateListener
            public void onError(int i10, String str) {
                if (LelinkMirrorBridge.this.isFrozen || LelinkMirrorBridge.this.mScreenCapture.isGroupMirror()) {
                    return;
                }
                SourceLog.w(LelinkMirrorBridge.TAG, "Mirror onError " + i10 + "  " + str);
                if (211026 == i10) {
                    OnErrorListener onErrorListener = LelinkMirrorBridge.this.mErrorListener;
                    if (onErrorListener != null) {
                        onErrorListener.onError(null, 211010, 211026, null);
                        return;
                    }
                    return;
                }
                LelinkMirrorBridge lelinkMirrorBridge = LelinkMirrorBridge.this;
                if (lelinkMirrorBridge.mErrorListener != null) {
                    lelinkMirrorBridge.isCallError = true;
                    LelinkMirrorBridge.this.mErrorListener.onError(null, 211010, PlayerListenerConstant.EXTRA_ERROR_MIRROR_IO, str);
                }
                LelinkMirrorBridge.this.stopMirror();
            }

            @Override // com.hpplay.component.common.protocol.IMirrorStateListener
            public void onFrameCallback(int i10) {
                if (LelinkMirrorBridge.this.isFrozen) {
                    return;
                }
                SourceLog.i(LelinkMirrorBridge.TAG, "Mirror onFrameCallback " + i10);
                if (LelinkMirrorBridge.this.mScreenCapture != null) {
                    LelinkMirrorBridge.this.mScreenCapture.setFrameRate(1, i10);
                }
            }

            @Override // com.hpplay.component.common.protocol.IMirrorStateListener
            public void onMirrorModeCallback(String str) {
                if (LelinkMirrorBridge.this.isFrozen || LelinkMirrorBridge.this.mScreenCapture == null) {
                    return;
                }
                LelinkMirrorBridge.this.mScreenCapture.setMirrorMode(str);
            }

            @Override // com.hpplay.component.common.protocol.IMirrorStateListener
            public void onNetStateChange(int i10) {
                SourceLog.i(LelinkMirrorBridge.TAG, "Mirror onNetStateChange " + i10);
            }

            @Override // com.hpplay.component.common.protocol.IMirrorStateListener
            public boolean onNetworkPoor() {
                if (LelinkMirrorBridge.this.isFrozen || LelinkMirrorBridge.this.mScreenCapture == null) {
                    return false;
                }
                return LelinkMirrorBridge.this.mScreenCapture.onNetworkPoor();
            }

            @Override // com.hpplay.component.common.protocol.IMirrorStateListener
            public void onPauseEncode() {
                if (LelinkMirrorBridge.this.isFrozen) {
                    return;
                }
                SourceLog.i(LelinkMirrorBridge.TAG, "Mirror onPauseEncode ");
                if (LelinkMirrorBridge.this.mScreenCapture != null) {
                    LelinkMirrorBridge.this.mScreenCapture.pauseEncode(false);
                }
                OnInfoListener onInfoListener = LelinkMirrorBridge.this.mInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(null, PlayerListenerConstant.MIRROR_INFO_CODE, LelinkSourceSDK.EXTERNAL_ENCODE_RESUME);
                }
            }

            @Override // com.hpplay.component.common.protocol.IMirrorStateListener
            public void onResolutionCallback(int i10, int i11) {
                if (LelinkMirrorBridge.this.isFrozen) {
                    return;
                }
                SourceLog.i(LelinkMirrorBridge.TAG, "Mirror onResolutionCallback " + i10 + Operator.Operation.DIVISION + i11);
                if (LelinkMirrorBridge.this.mScreenCapture != null) {
                    LelinkMirrorBridge.this.mScreenCapture.setResolution(1, i10, i11);
                }
            }

            @Override // com.hpplay.component.common.protocol.IMirrorStateListener
            public void onResumeEncode() {
                if (LelinkMirrorBridge.this.isFrozen) {
                    return;
                }
                SourceLog.i(LelinkMirrorBridge.TAG, "Mirror onResumeEncode ");
                if (LelinkMirrorBridge.this.mScreenCapture != null) {
                    LelinkMirrorBridge.this.mScreenCapture.resumeEncode();
                }
                OnInfoListener onInfoListener = LelinkMirrorBridge.this.mInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(null, PlayerListenerConstant.MIRROR_INFO_CODE, LelinkSourceSDK.EXTERNAL_ENCODE_PAUSE);
                }
            }

            @Override // com.hpplay.component.common.protocol.IMirrorStateListener
            public void onSinkPrepared(int i10, int i11, int i12, int i13, String str) {
                if (LelinkMirrorBridge.this.isFrozen) {
                    return;
                }
                SourceLog.i(LelinkMirrorBridge.TAG, "Mirror sinkWidth " + i10 + "  sinkWidth " + i11 + "  sinkFrameRate" + i12 + " " + LelinkMirrorBridge.this);
                CaptureBean captureBean = new CaptureBean();
                captureBean.sinkWidth = i10;
                captureBean.sinkHeight = i11;
                captureBean.sinkFrameRate = i12;
                captureBean.encodeType = str;
                captureBean.bitrate = i13;
                LelinkMirrorBridge.this.mHandler.obtainMessage(1, captureBean).sendToTarget();
                if (OptionCentral.getResolution()[0] <= 0 || OptionCentral.getResolution()[1] <= 0) {
                    return;
                }
                try {
                    LelinkMirrorBridge.this.mMirrorController.setAdjustResolution(false);
                } catch (Exception e10) {
                    SourceLog.w(LelinkMirrorBridge.TAG, e10);
                }
            }

            @Override // com.hpplay.component.common.protocol.IMirrorStateListener
            public void onSinkStop(String str, int i10) {
                LelinkMirrorBridge.this.isFrozen = false;
                SourceLog.i(LelinkMirrorBridge.TAG, "Mirror onSinkStop " + str + Operator.Operation.DIVISION + i10);
                LelinkMirrorBridge lelinkMirrorBridge = LelinkMirrorBridge.this;
                lelinkMirrorBridge.stop(lelinkMirrorBridge.mPlayInfo.getKey());
            }

            @Override // com.hpplay.component.common.protocol.IMirrorStateListener
            public void resetEncoder() {
                if (LelinkMirrorBridge.this.mScreenCapture != null) {
                    LelinkMirrorBridge.this.mScreenCapture.resetEncoder();
                }
            }
        };
        SourceLog.i(TAG, " create new  LelinkMirrorBridge");
        this.mPlayInfo = outParameter;
        try {
            ModuleLinker newInstance = ModuleLinker.getNewInstance();
            this.mModuleLinker = newInstance;
            this.mMirrorController = (IMirrorController) newInstance.loadModule(ModuleIds.CLAZZ_ID1068_MIRRORCONTROLLERIMP);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        CaptureBridge captureBridge = CaptureBridge.getInstance();
        this.mScreenCapture = captureBridge;
        captureBridge.init();
        this.mScreenCapture.setPlayInfo(outParameter);
        this.mAppAVListener = Session.getInstance().getDebugAVListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callLoading() {
        OnLoadingListener onLoadingListener = this.mLoadingListener;
        if (onLoadingListener != null) {
            onLoadingListener.onLoading(null, null);
        }
    }

    private void callPause() {
        OnStateChangeListener onStateChangeListener = this.mStateChangeListener;
        if (onStateChangeListener != null) {
            onStateChangeListener.onStateChanged(null, 4);
        }
    }

    private void callPlaying() {
        OnStateChangeListener onStateChangeListener = this.mStateChangeListener;
        if (onStateChangeListener != null) {
            onStateChangeListener.onStateChanged(null, 3);
        }
    }

    private void callStart() {
        OnPreparedListener onPreparedListener;
        if (this.isCallPrepared || (onPreparedListener = this.mPreparedListener) == null) {
            return;
        }
        this.isCallPrepared = true;
        onPreparedListener.onPrepared(null);
    }

    private void callStop() {
        SourceLog.i(TAG, "callStop   " + this.isCallStop);
        if (this.isCallStop || this.isFrozen) {
            return;
        }
        try {
            if (this.mStopListener != null) {
                this.isCallStop = true;
                StopInfo stopInfo = new StopInfo();
                stopInfo.type = this.isCallError ? 2 : 1;
                this.mStopListener.onStop(null, stopInfo);
                CaptureBridge captureBridge = this.mScreenCapture;
                if (captureBridge != null) {
                    captureBridge.release(hashCode());
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRegisterSinkTouchEvent() {
        SourceLog.i(TAG, "doRegisterSinkTouchEvent: hasRegisterSinkTouchEvent： " + this.hasRegisterSinkTouchEvent);
        if (this.hasRegisterSinkTouchEvent) {
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.hpplay.sdk.source.protocol.LelinkMirrorBridge.9
            @Override // java.lang.Runnable
            public void run() {
                SinkTouchEventMonitor sinkTouchEventMonitor = SinkTouchEventMonitor.getInstance();
                LelinkMirrorBridge lelinkMirrorBridge = LelinkMirrorBridge.this;
                sinkTouchEventMonitor.startMonitor(lelinkMirrorBridge.mContext, lelinkMirrorBridge.mPlayInfo.session, false);
            }
        }, 1000L);
        this.hasRegisterSinkTouchEvent = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUnregisterSinkTouchEvent() {
        SourceLog.i(TAG, "doUnregisterSinkTouchEvent: ");
        this.hasRegisterSinkTouchEvent = false;
        SinkTouchEventMonitor.getInstance().stopMonitor();
    }

    private void initExternalAudioSource() {
        OptionCentral.setOnPCMUpdateListener(this.onPCMUpdateListener);
    }

    private void initExternalVideo() {
        OptionCentral.setOnVideoUpdateListener(this.onVideoUpdateListener);
    }

    private void monitorExternalAudio() {
        OptionCentral.setOnExternalAudioStateChangedListener(this.onExternalAudioStateChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerSinkKeyEvent() {
        if (OptionCentral.isRegisterSinkKeyEvent()) {
            PassSender.getInstance().sendSinkKeyRegister(SinkKeyEventRegisterBean.createRegisterBean().toJson(), this.mPlayInfo.session);
        }
        OptionCentral.setOnSinkKeyEventRegisterListener(new OptionCentral.OnSinkKeyEventRegisterListener() { // from class: com.hpplay.sdk.source.protocol.LelinkMirrorBridge.7
            @Override // com.hpplay.sdk.source.browse.api.OptionCentral.OnSinkKeyEventRegisterListener
            public void onRegister() {
                PassSender.getInstance().sendSinkKeyRegister(SinkKeyEventRegisterBean.createRegisterBean().toJson(), LelinkMirrorBridge.this.mPlayInfo.session);
            }

            @Override // com.hpplay.sdk.source.browse.api.OptionCentral.OnSinkKeyEventRegisterListener
            public void onUnregister() {
                PassSender.getInstance().sendSinkKeyRegister(SinkKeyEventRegisterBean.createUnregisterBean().toJson(), LelinkMirrorBridge.this.mPlayInfo.session);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerSinkTouchEvent() {
        if (OptionCentral.isRegistSinkTouchEvent()) {
            doRegisterSinkTouchEvent();
        }
        OptionCentral.setOnSinkTouchEventRegisterListener(new OptionCentral.OnSinkTouchEventRegisterListener() { // from class: com.hpplay.sdk.source.protocol.LelinkMirrorBridge.8
            @Override // com.hpplay.sdk.source.browse.api.OptionCentral.OnSinkTouchEventRegisterListener
            public void onRegister() {
                SourceLog.i(LelinkMirrorBridge.TAG, "onRegister: ");
                LelinkMirrorBridge.this.doRegisterSinkTouchEvent();
            }

            @Override // com.hpplay.sdk.source.browse.api.OptionCentral.OnSinkTouchEventRegisterListener
            public void onUnregister() {
                LelinkMirrorBridge.this.doUnregisterSinkTouchEvent();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopMirror() {
        CaptureBridge captureBridge;
        SourceLog.i(TAG, "stopMirror");
        if (!this.isFrozen && (captureBridge = this.mScreenCapture) != null) {
            captureBridge.stopCapture(1);
        }
        IMirrorController iMirrorController = this.mMirrorController;
        if (iMirrorController != null) {
            iMirrorController.stopMirror();
        }
        callStop();
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void frozen(boolean z10) {
        super.frozen(z10);
        SourceLog.i(TAG, "======== set frozen " + z10);
        this.isFrozen = z10;
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void onCaptureStart(int i10) {
        if (this.isFrozen) {
            SourceLog.w(TAG, "onCaptureStart ignore");
            return;
        }
        SourceLog.i(TAG, "Capture onStart " + i10);
        callStart();
        callPlaying();
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void onCaptureStop(int i10) {
        SourceLog.i(TAG, "Capture onStop " + i10);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void onInfo(int i10, String str) {
        if (i10 == 10 || i10 == 120105112) {
            super.onInfo(i10, str);
            return;
        }
        SourceLog.i(TAG, "on info callback : " + i10 + "  extra: " + str);
        boolean z10 = LelinkSdkManager.getInstance().getRetryMirrorOnce().get();
        SourceLog.i(TAG, "Capture onInfo " + i10 + Operator.Operation.DIVISION + str);
        if (z10) {
            LelinkSdkManager.getInstance().getRetryMirrorOnce().set(false);
            SourceLog.i(TAG, "Capture onInfo retried.");
            return;
        }
        LelinkSdkManager.getInstance().getRetryMirrorOnce().set(true);
        if (this.mErrorListener == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.isCallError = true;
        this.mErrorListener.onError(null, 211010, PlayerListenerConstant.EXTRA_ERROR_MIRROR_IO, str);
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void pause(String str) {
        if (this.mScreenCapture == null || this.mMirrorController == null) {
            SourceLog.w(TAG, "pause ignore");
            return;
        }
        SourceLog.i(TAG, "pause");
        PassSender.getInstance().sendMirrorState(MirrorStateBean.createPauseBean(this.mPlayInfo.urlID).toJson(), this.mPlayInfo.session);
        this.mScreenCapture.pauseEncode(true);
        callPause();
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void play(String str) {
        if (this.mScreenCapture == null || this.mMirrorController == null) {
            SourceLog.w(TAG, "play mirror ignore");
            return;
        }
        BrowserInfo browserInfo = CastUtil.getBrowserInfo(this.mPlayInfo.serviceInfo, 1);
        if (browserInfo == null) {
            SourceLog.w(TAG, "play mirror ignore 2");
            return;
        }
        SourceLog.debug(TAG, "play mirror " + this.mPlayInfo);
        if (ConnectManager.getInstance().getLastConnectBridge() != null) {
            ConnectManager.getInstance().getLastConnectBridge().addOnPassReceivedListener(this, this.onPassReceivedListener);
        } else {
            SourceLog.w(TAG, "Not connect to " + this.mPlayInfo.serviceInfo.getName() + Operator.Operation.DIVISION + this.mPlayInfo.serviceInfo.getIp());
        }
        ParamsMap create = ParamsMap.create();
        create.putParam(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
        create.putParam(ParamsMap.DeviceParams.KEY_HID, Session.getInstance().getHID());
        String string = FieldUtil.getString(FieldUtil.f7332m);
        Session.getInstance();
        create.putParam(string, Session.DEFAULT_M);
        create.putParam("imei", "");
        create.putParam(ParamsMap.DeviceParams.KEY_SESSION_ID, this.mPlayInfo.session);
        create.putParam(ParamsMap.DeviceParams.KEY_CONNECT_SESSION_ID, this.mPlayInfo.connectSession);
        create.putParam("uri", this.mPlayInfo.urlID);
        create.putParam("ip", browserInfo.getIp());
        create.putParam(ParamsMap.MirrorParams.KEY_EXTERNAL_VIDEO, String.valueOf(OptionCentral.isExternalVideo()));
        create.putParam(ParamsMap.DeviceParams.KEY_CONNECT_SESSION_ID, this.mPlayInfo.connectSession);
        if (!TextUtils.isEmpty(this.mPlayInfo.password)) {
            create.putParam("screencode", this.mPlayInfo.password);
        }
        boolean isSupportLelinkV2 = CastUtil.isSupportLelinkV2(browserInfo);
        try {
            create.putParam(ParamsMap.DeviceParams.KEY_RAOP_PORT, browserInfo.getExtras().get("raop"));
            String str2 = browserInfo.getExtras().get("mirror");
            if (!TextUtils.isEmpty(str2) && TextUtils.isDigitsOnly(str2)) {
                create.putParam(ParamsMap.DeviceParams.KEY_MIRROR_PORT, str2);
            }
            if (isSupportLelinkV2) {
                create.putParam("vv", "2");
                create.putParam(ParamsMap.DeviceParams.KEY_LELINK_PORT, browserInfo.getExtras().get("lelinkport"));
            } else {
                create.putParam(ParamsMap.DeviceParams.KEY_LELINK_PORT, browserInfo.getExtras().get("airplay"));
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        int i10 = this.mPlayInfo.mirrorResLevel;
        if (i10 == 1) {
            create.putParam(ParamsMap.MirrorParams.KEY_PHONE_WIDTH, "1080");
            create.putParam(ParamsMap.MirrorParams.KEY_PHONE_HEIGHT, "1920");
        } else if (i10 != 2) {
            int[] relScreenSize = ScreenUtil.getRelScreenSize(this.mContext);
            create.putParam(ParamsMap.MirrorParams.KEY_PHONE_WIDTH, relScreenSize[0] + "");
            create.putParam(ParamsMap.MirrorParams.KEY_PHONE_HEIGHT, relScreenSize[1] + "");
        } else {
            create.putParam(ParamsMap.MirrorParams.KEY_PHONE_WIDTH, "720");
            create.putParam(ParamsMap.MirrorParams.KEY_PHONE_HEIGHT, "1280");
        }
        create.putParam(ParamsMap.MirrorParams.KEY_AUTO_BITRATE, String.valueOf(this.mPlayInfo.isAutoBitrate));
        create.putParam(ParamsMap.PushParams.KEY_PROTOCOL_TYPE, this.mPlayInfo.protocol + "");
        create.putParam(ParamsMap.MirrorParams.KEY_MIRROR_AUDIO, Boolean.TRUE);
        create.putParam(ParamsMap.MirrorParams.KEY_EXTERNAL_VIDEO, String.valueOf(OptionCentral.isExternalVideo()));
        SourceLog.i(TAG, "play map: " + create.toString() + " mirrorSendTimeout :" + this.mPlayInfo.mirrorSendTimeout + " isSupportV2 " + isSupportLelinkV2);
        this.mMirrorController.setMirrorProtocolInfos(create);
        IMirrorController iMirrorController = this.mMirrorController;
        int i11 = this.mPlayInfo.mirrorSendTimeout;
        if (i11 <= 0) {
            i11 = this.mMirrorSendTimeout;
        }
        iMirrorController.setSendDataTimeout(i11);
        this.mMirrorController.startGetSinkInfos(this.mMirrorListener);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void release() {
        SourceLog.i(TAG, "release");
        CaptureBridge captureBridge = this.mScreenCapture;
        if (captureBridge != null) {
            captureBridge.removeAbsBridge(1);
            this.mScreenCapture.release(hashCode());
        }
        ModuleLinker moduleLinker = this.mModuleLinker;
        if (moduleLinker != null) {
            moduleLinker.removeObjOfMemory(ModuleIds.CLAZZ_ID1068_MIRRORCONTROLLERIMP);
            this.mModuleLinker = null;
        }
        if (this.mMirrorController == null) {
            return;
        }
        this.mMirrorListener = null;
        this.mLoadingListener = null;
        this.mPreparedListener = null;
        this.mStateChangeListener = null;
        this.mInfoListener = null;
        this.mErrorListener = null;
        this.mCompletionListener = null;
        this.mStopListener = null;
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void resume(String str) {
        if (this.mScreenCapture == null || this.mMirrorController == null) {
            SourceLog.w(TAG, "resume ignore");
            return;
        }
        SourceLog.i(TAG, "resume");
        PassSender.getInstance().sendMirrorState(MirrorStateBean.createResumeBean(this.mPlayInfo.getPlayUrl()).toJson(), this.mPlayInfo.session);
        this.mScreenCapture.resumeEncode();
        this.mScreenCapture.resetEncoder();
        callPlaying();
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void screenshot(int i10) {
        SourceLog.i(TAG, "Capture onScreenshot " + i10);
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void seekTo(int i10) {
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void sendAudioData(byte[] bArr, int i10, int i11) {
        if (this.isFrozen) {
            return;
        }
        super.sendAudioData(bArr, i10, i11);
        this.mMirrorController.sendAudioData(bArr, i10, i11);
        if (this.mAppAVListener != null) {
            try {
                byte[] bArr2 = new byte[i11];
                System.arraycopy(bArr, i10, bArr2, 0, i11);
                this.mAppAVListener.onAudioCallback(-1L, -1, -1, i11, bArr2);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void sendVideoData(ByteBuffer byteBuffer, int i10, int i11, int i12, long j10) {
        if (this.isFrozen) {
            SourceLog.w(TAG, "sendVideoData ignore");
        } else {
            this.mMirrorController.sendVideoData(byteBuffer, i12, j10);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void setExternalMirrorData() {
        SourceLog.i(TAG, "setExternalMirrorData");
        initExternalVideo();
        initExternalAudioSource();
        monitorExternalAudio();
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void setMirrorScreenSecret(boolean z10) {
        SourceLog.i(TAG, "setMirrorScreenSecret status:" + z10);
        CaptureBridge captureBridge = this.mScreenCapture;
        if (captureBridge == null || this.mMirrorController == null) {
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
        if (this.mScreenCapture == null || this.mMirrorController == null) {
            SourceLog.w(TAG, "setWatermarkVisible ignore");
        } else {
            SourceLog.i(TAG, "setWatermarkVisible");
            this.mScreenCapture.setWatermarkVisible(z10);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void stop(String str) {
        SourceLog.i(TAG, "stop " + str + " " + this.isFrozen);
        stopMirror();
        if (ConnectManager.getInstance().getLastConnectBridge() != null) {
            ConnectManager.getInstance().getLastConnectBridge().removeOnPassReceivedListener(this);
        }
        OptionCentral.setOnPCMUpdateListener(null);
        OptionCentral.setOnSinkKeyEventRegisterListener(null);
        OptionCentral.setOnSinkTouchEventRegisterListener(null);
        OptionCentral.setOnExternalAudioStateChangedListener(null);
        OptionCentral.setOnVideoUpdateListener(null);
        doUnregisterSinkTouchEvent();
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public boolean switchExpansionScreen(boolean z10) {
        CaptureBridge captureBridge = this.mScreenCapture;
        if (captureBridge == null) {
            return false;
        }
        OutParameter outParameter = this.mPlayInfo;
        outParameter.isExpandMirror = z10;
        captureBridge.setExpansionScreenInfo(outParameter.expandActivity, outParameter.expandView);
        this.mScreenCapture.switchExpansionScreen(z10);
        return true;
    }
}
