package com.hpplay.component.protocol.mirror;

import android.text.TextUtils;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.IMirrorStateListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.mirror.rtsp.LelinkRtspClient;
import com.hpplay.component.protocol.mirror.rtsp.LelinkV2RtspClient;
import com.hpplay.component.protocol.mirror.rtsp.RtspClient;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MirrorProtocolTask extends Thread implements IMirrorStateListener {
    private static final int CHECK_TIMEOUT_VALUE = 1000;
    private static final int KEEP_ALIVE_VALUE = 5000;
    private static final int RECONNECT_INTERVAL = 2000;
    private static final int RECONNECT_TIMEOUT = 42000;
    private static final String TAG = "MirrorProtocolTask";
    private boolean isAutoBitrate;
    private boolean isChangeMode;
    private boolean isNetworkBroken;
    private boolean isOpen;
    private boolean isSwitchChannel;
    private AudioDataSender mAudioDataSender;
    private long mAudioSendTime;
    private int mEventPort;
    private IMirrorStateListener mListener;
    private ParamsMap mMaramsMap;
    private int mMaxReconnect;
    private String mMirrorType;
    private long mOptionSendTime;
    private int mProtocalType;
    private RtspClient mRtspClient;
    private int mTimeoutStopValue;
    private VideoDataSendStrategy mVideoDataSender;
    private long mVideoSendTime;
    private final Object mLock = new Object();
    private boolean isRunning = false;
    private LelinkRtpPacker mRtpPacker = new LelinkRtpPacker();
    private int mReconnCount = 0;
    private final AtomicBoolean isLocked = new AtomicBoolean(false);
    private int mOpionErrorCount = 0;
    private int mChannelType = 2;

    public MirrorProtocolTask(ParamsMap paramsMap) {
        this.isAutoBitrate = false;
        setName(TAG);
        this.mMaramsMap = paramsMap;
        Boolean bool = Boolean.FALSE;
        this.isOpen = Boolean.parseBoolean(paramsMap.getParam(ParamsMap.MirrorParams.KEY_MIRROR_AUDIO, bool).toString());
        this.isAutoBitrate = Boolean.parseBoolean(paramsMap.getParam(ParamsMap.MirrorParams.KEY_AUTO_BITRATE, bool).toString());
        this.mMaxReconnect = ((Integer) paramsMap.getParam(ParamsMap.MirrorParams.KEY_MIRROR_RECONNECT_COUNT, 0)).intValue();
        CLog.i(TAG, "==========> " + this.mMaxReconnect + " ==== " + this.isOpen + "  == " + this.isAutoBitrate);
        if (TextUtils.isEmpty(paramsMap.getVV()) || !TextUtils.equals(paramsMap.getVV(), "2")) {
            this.mRtspClient = new LelinkRtspClient(paramsMap);
            this.mProtocalType = 1;
        } else {
            this.mRtspClient = new LelinkV2RtspClient(paramsMap);
            this.mProtocalType = 5;
        }
    }

    private void changeMode() {
        if (this.isChangeMode) {
            CLog.i(TAG, " change mirror mode  ");
            this.isChangeMode = false;
            this.mRtspClient.setMirrorMode(this.mMirrorType);
        }
    }

    private void changeWLANChannel() {
        RtspClient rtspClient;
        if (!this.isSwitchChannel || (rtspClient = this.mRtspClient) == null) {
            return;
        }
        this.isSwitchChannel = false;
        try {
            CLog.i(TAG, " change wlan channel ret :" + rtspClient.sendRequestVideoSetup(this.mEventPort, this.mChannelType));
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        IMirrorStateListener iMirrorStateListener = this.mListener;
        if (iMirrorStateListener != null) {
            iMirrorStateListener.resetEncoder();
        }
    }

    private void checkSendDataTimeout() {
        VideoDataSendStrategy videoDataSendStrategy = this.mVideoDataSender;
        if (videoDataSendStrategy == null || this.mTimeoutStopValue <= 0 || videoDataSendStrategy.getWritTimeout() < this.mTimeoutStopValue) {
            return;
        }
        CLog.i(TAG, "checkSendDataTimeout,SendData Timeout, getWritTimeout: " + this.mVideoDataSender.getWritTimeout() + " mTimeoutStopValue: " + this.mTimeoutStopValue);
        onBroken();
    }

    private boolean isNeedReconnect() {
        VideoDataSendStrategy videoDataSendStrategy;
        if (this.mMaxReconnect <= 0 || this.mProtocalType != 5 || (videoDataSendStrategy = this.mVideoDataSender) == null || !(videoDataSendStrategy.isWriteTimeout() || this.isNetworkBroken)) {
            return false;
        }
        this.isNetworkBroken = false;
        return true;
    }

    private synchronized void onSuccessful(boolean z10) {
        this.mRtpPacker.setEncodeType(this.mRtspClient.getEncodeType());
        VideoDataSendStrategy videoDataSendStrategy = new VideoDataSendStrategy(this.mRtspClient.getVideoDataSender(), this, (int) this.mRtspClient.getRefreshRate());
        this.mVideoDataSender = videoDataSendStrategy;
        videoDataSendStrategy.setAutoBitrate(this.isAutoBitrate);
        this.mVideoDataSender.start();
        startAudioEncoder();
        if (!z10) {
            onSinkPrepared(this.mRtspClient.getSinkWidth(), this.mRtspClient.getSinkHeight(), (int) this.mRtspClient.getRefreshRate(), this.mRtspClient.getBitRate(), this.mRtspClient.getEncodeType());
        }
    }

    private boolean sendHeartbeat() {
        if (this.mVideoSendTime > 0 && System.currentTimeMillis() - this.mVideoSendTime >= 5000 && this.mVideoDataSender != null) {
            CLog.i(TAG, "send video  heartbeat data ..  ");
            this.mVideoSendTime = System.currentTimeMillis();
            this.mVideoDataSender.putVideoData(this.mRtpPacker.getHeartbeatData());
        }
        if (this.mAudioSendTime > 0 && System.currentTimeMillis() - this.mAudioSendTime >= NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS && this.mAudioDataSender != null) {
            CLog.i(TAG, "send audio  heartbeat data ..  ");
            this.mAudioSendTime = System.currentTimeMillis();
            this.mAudioDataSender.putAudioData(new byte[0], 0, 0);
        }
        if (System.currentTimeMillis() - this.mOptionSendTime < 5000) {
            return false;
        }
        CLog.i(TAG, "send mirror main connection heartbeat ... ");
        this.mOptionSendTime = System.currentTimeMillis();
        if (this.mRtspClient.sendRequestSetOptions()) {
            this.mOpionErrorCount = 0;
        } else {
            CLog.i(TAG, " send option error  ..  ");
            int i10 = this.mOpionErrorCount;
            if (i10 > 2) {
                CLog.i(TAG, " mirror exit  ");
                onError(ParamsMap.MirrorParams.MIRROR_ERROR_NETWORK_BROKEN, null);
                return true;
            }
            this.mOpionErrorCount = i10 + 1;
        }
        return false;
    }

    private synchronized void startAudioEncoder() {
        if (this.isOpen) {
            CLog.i(TAG, "  startAudioEncoder ");
            AudioDataSender audioDataSender = new AudioDataSender(this.mRtspClient.getAudioChannelType(), this.mRtspClient.getAudioServerIp(), this.mRtspClient.getAudioPort());
            this.mAudioDataSender = audioDataSender;
            audioDataSender.start();
        }
    }

    private boolean startReconnect() {
        RtspClient rtspClient;
        if (this.mReconnCount > this.mMaxReconnect) {
            return false;
        }
        onPauseEncode();
        RtspClient rtspClient2 = this.mRtspClient;
        if (rtspClient2 != null) {
            rtspClient2.release();
        }
        AudioDataSender audioDataSender = this.mAudioDataSender;
        if (audioDataSender != null) {
            audioDataSender.stopTask();
        }
        VideoDataSendStrategy videoDataSendStrategy = this.mVideoDataSender;
        if (videoDataSendStrategy == null) {
            return false;
        }
        videoDataSendStrategy.stopTask();
        this.mVideoDataSender = null;
        CLog.i(TAG, "start reconnect mirror ...");
        this.mReconnCount++;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z10 = false;
        while (System.currentTimeMillis() - currentTimeMillis < 42000 && (rtspClient = this.mRtspClient) != null) {
            try {
                z10 = rtspClient.exeLelinkRtsp(this.isOpen, String.valueOf(this.mEventPort), this.mMirrorType, String.valueOf(this.mChannelType)) == 1;
                CLog.i(TAG, "reconnect mirror " + z10);
                if (z10 || isInterrupted()) {
                    break;
                }
                Thread.sleep(2000L);
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
        }
        onSuccessful(true);
        try {
            resetEncoder();
            return z10;
        } catch (Exception e11) {
            CLog.w(TAG, e11);
            return false;
        }
    }

    private synchronized void stopAll() {
        CLog.i(TAG, " stop  mirror protocol");
        this.isRunning = false;
        interrupt();
        VideoDataSendStrategy videoDataSendStrategy = this.mVideoDataSender;
        if (videoDataSendStrategy != null) {
            videoDataSendStrategy.stopTask();
            this.mVideoDataSender = null;
        }
        AudioDataSender audioDataSender = this.mAudioDataSender;
        if (audioDataSender != null) {
            audioDataSender.stopTask();
            this.mAudioDataSender = null;
        }
    }

    private void wakeup() {
        if (this.isRunning && this.isLocked.get()) {
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
        }
    }

    public void finalize() {
        super.finalize();
    }

    @Override // com.hpplay.component.common.protocol.IMirrorStateListener
    public void onBitrateCallback(int i10) {
        IMirrorStateListener iMirrorStateListener = this.mListener;
        if (iMirrorStateListener != null) {
            iMirrorStateListener.onBitrateCallback(i10);
        }
    }

    @Override // com.hpplay.component.common.protocol.IMirrorStateListener
    public void onBroken() {
        stopMirror();
        this.isNetworkBroken = true;
        IMirrorStateListener iMirrorStateListener = this.mListener;
        if (iMirrorStateListener != null) {
            iMirrorStateListener.onBroken();
        }
    }

    @Override // com.hpplay.component.common.protocol.IMirrorStateListener
    public void onError(int i10, String str) {
        if (this.mListener != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i10);
                jSONObject.put("errMsg", str);
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
            this.mListener.onError(i10, jSONObject.toString());
        }
    }

    @Override // com.hpplay.component.common.protocol.IMirrorStateListener
    public void onFrameCallback(int i10) {
        IMirrorStateListener iMirrorStateListener = this.mListener;
        if (iMirrorStateListener != null) {
            iMirrorStateListener.onFrameCallback(i10);
        }
    }

    @Override // com.hpplay.component.common.protocol.IMirrorStateListener
    public void onMirrorModeCallback(String str) {
        IMirrorStateListener iMirrorStateListener = this.mListener;
        if (iMirrorStateListener != null) {
            iMirrorStateListener.onMirrorModeCallback(str);
        }
    }

    @Override // com.hpplay.component.common.protocol.IMirrorStateListener
    public void onNetStateChange(int i10) {
        IMirrorStateListener iMirrorStateListener = this.mListener;
        if (iMirrorStateListener != null) {
            iMirrorStateListener.onNetStateChange(i10);
        }
    }

    @Override // com.hpplay.component.common.protocol.IMirrorStateListener
    public boolean onNetworkPoor() {
        IMirrorStateListener iMirrorStateListener = this.mListener;
        if (iMirrorStateListener != null) {
            return iMirrorStateListener.onNetworkPoor();
        }
        return false;
    }

    @Override // com.hpplay.component.common.protocol.IMirrorStateListener
    public void onPauseEncode() {
        IMirrorStateListener iMirrorStateListener = this.mListener;
        if (iMirrorStateListener != null) {
            iMirrorStateListener.onPauseEncode();
        }
    }

    @Override // com.hpplay.component.common.protocol.IMirrorStateListener
    public void onResolutionCallback(int i10, int i11) {
        IMirrorStateListener iMirrorStateListener = this.mListener;
        if (iMirrorStateListener != null) {
            iMirrorStateListener.onResolutionCallback(i10, i11);
        }
    }

    @Override // com.hpplay.component.common.protocol.IMirrorStateListener
    public void onResumeEncode() {
        IMirrorStateListener iMirrorStateListener = this.mListener;
        if (iMirrorStateListener != null) {
            iMirrorStateListener.onResumeEncode();
        }
    }

    @Override // com.hpplay.component.common.protocol.IMirrorStateListener
    public void onSinkPrepared(int i10, int i11, int i12, int i13, String str) {
        IMirrorStateListener iMirrorStateListener = this.mListener;
        if (iMirrorStateListener != null) {
            iMirrorStateListener.onSinkPrepared(i10, i11, i12, i13, str);
        }
    }

    @Override // com.hpplay.component.common.protocol.IMirrorStateListener
    public void onSinkStop(String str, int i10) {
        IMirrorStateListener iMirrorStateListener = this.mListener;
        if (iMirrorStateListener != null) {
            iMirrorStateListener.onSinkStop(str, i10);
        }
    }

    @Override // com.hpplay.component.common.protocol.IMirrorStateListener
    public void resetEncoder() {
        IMirrorStateListener iMirrorStateListener = this.mListener;
        if (iMirrorStateListener != null) {
            iMirrorStateListener.resetEncoder();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        int exeLelinkRtsp = this.mRtspClient.exeLelinkRtsp(this.isOpen, String.valueOf(this.mEventPort), this.mMirrorType, String.valueOf(this.mChannelType));
        if (exeLelinkRtsp != 1) {
            onError(exeLelinkRtsp, this.mRtspClient.getErrorMsg());
            return;
        }
        this.isRunning = true;
        onSuccessful(false);
        try {
            if (this.mProtocalType == 1) {
                this.mVideoDataSender.putVideoData(this.mRtpPacker.packetOldLelinkFrameInfoData(this.mMaramsMap.getMac()));
            }
        } catch (IOException e10) {
            CLog.w(TAG, e10);
        }
        CLog.i(TAG, "mirror run ");
        while (true) {
            try {
                if (!this.isRunning) {
                    break;
                }
                synchronized (this.mLock) {
                    if (isNeedReconnect()) {
                        if (startReconnect()) {
                            CLog.i(TAG, " reconnect successful ...  ");
                        } else {
                            CLog.i(TAG, " reconnect failed ...  ");
                        }
                    }
                    if (sendHeartbeat()) {
                        CLog.i(TAG, "   sendHeartbeat FAILED ");
                    } else {
                        changeMode();
                        changeWLANChannel();
                        checkSendDataTimeout();
                        if (this.isRunning && !this.isNetworkBroken) {
                            this.isLocked.set(true);
                            this.mLock.wait(1000L);
                            this.isLocked.set(false);
                        }
                    }
                }
                break;
            } catch (Exception e11) {
                CLog.w(TAG, e11);
            }
        }
        RtspClient rtspClient = this.mRtspClient;
        if (rtspClient != null && !this.isNetworkBroken && rtspClient.sendRequestSetTeardown()) {
            CLog.i(TAG, "send tear down success ...");
        }
        CLog.i(TAG, " mirror thread exit ..." + this.isRunning);
        stopAll();
    }

    public void sendAudioData(byte[] bArr, int i10, int i11) {
        if (this.mAudioDataSender != null) {
            this.mAudioSendTime = System.currentTimeMillis();
            this.mAudioDataSender.putAudioData(bArr, i10, i11);
        }
    }

    public void sendVideoData(ByteBuffer byteBuffer, int i10, long j10) {
        VideoDataSendStrategy videoDataSendStrategy = this.mVideoDataSender;
        if (videoDataSendStrategy != null) {
            if (videoDataSendStrategy.isQuit()) {
                onError(ParamsMap.MirrorParams.MIRROR_ERROR_NETWORK_BROKEN, null);
                stopAll();
                return;
            }
            if (100 == i10) {
                i10 = (byte) (byteBuffer.get(4) & 15);
                byteBuffer.rewind();
            }
            this.mVideoSendTime = System.currentTimeMillis();
            this.mVideoDataSender.putVideoData(this.mRtpPacker.videoDataPacked(byteBuffer, this.mRtspClient.mMirrorFrameEcrypto, i10, j10));
        }
    }

    public void setAdjustResolution(boolean z10) {
        this.mRtpPacker.setAdjustResolution(z10);
    }

    public void setAutoBitrate(boolean z10) {
        this.isAutoBitrate = z10;
    }

    public void setMirrorEventPort(int i10) {
        this.mEventPort = i10;
    }

    public void setMirrorMode(String str) {
        this.mMirrorType = str;
        this.isChangeMode = true;
        wakeup();
    }

    public void setRtspListener(IMirrorStateListener iMirrorStateListener) {
        this.mListener = iMirrorStateListener;
    }

    public void setSendDataTimeout(int i10) {
        CLog.i(TAG, "-----------setSendDataTimeout -----" + i10);
        this.mTimeoutStopValue = i10 * 1000;
    }

    public synchronized void stopMirror() {
        CLog.i(TAG, " stop mirror ...  ");
        this.isRunning = false;
        interrupt();
        stopAll();
    }

    public void switchWLANChannel(int i10) {
        this.mChannelType = i10;
        IMirrorStateListener iMirrorStateListener = this.mListener;
        if (iMirrorStateListener != null) {
            iMirrorStateListener.onPauseEncode();
        }
        this.isSwitchChannel = true;
        wakeup();
    }
}
