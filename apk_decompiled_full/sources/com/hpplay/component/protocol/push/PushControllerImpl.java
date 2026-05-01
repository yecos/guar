package com.hpplay.component.protocol.push;

import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.IConnector;
import com.hpplay.component.common.protocol.IPushController;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.LelinkReverseChannel;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.component.protocol.ProtocolSender;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class PushControllerImpl extends IPushController {
    private static final String TAG = "PushControllerImpl";
    private static final int TYPE_PLAY_LIST = 2;
    private static final int TYPE_PLAY_SINGLE = 1;
    private IConnector mConnector;
    protected ParamsMap mParams;
    private int mPlayType;
    private ProtocolListener mProtocolListener;
    private ProtocolSender mProtocolSender;
    private IPushHandler mPushBuilder;
    private LelinkReverseChannel mReverseChannel;
    protected String mUrl;
    protected int retryCount;
    private int mType = 0;
    private AtomicBoolean mConnection = new AtomicBoolean(true);
    private String mLocation = "";
    private final ProtocolListener mConnectProtocolListener = new ProtocolListener() { // from class: com.hpplay.component.protocol.push.PushControllerImpl.1
        @Override // com.hpplay.component.common.protocol.ProtocolListener
        public void onResult(int i10, String... strArr) {
            if (!PushControllerImpl.this.getConnectionState()) {
                CLog.i(PushControllerImpl.TAG, " the push connection is disconnect  ");
                return;
            }
            CLog.i(PushControllerImpl.TAG, "==============> " + i10 + "  ");
            try {
                if (PushControllerImpl.this.mType == 3) {
                    if (i10 == 11 && !strArr[0].contains("successful")) {
                        PushControllerImpl.this.retryPush(strArr);
                    }
                } else if (strArr[0].contains("successful") && PushControllerImpl.this.mConnection.get()) {
                    CLog.i(PushControllerImpl.TAG, "the main connection is connected ");
                    if (PushControllerImpl.this.mReverseChannel != null) {
                        PushControllerImpl.this.mReverseChannel.stopReceive();
                        LelinkReverseChannel lelinkReverseChannel = PushControllerImpl.this.mReverseChannel;
                        PushControllerImpl pushControllerImpl = PushControllerImpl.this;
                        lelinkReverseChannel.setRecevelistenerAndProtocol(pushControllerImpl.mReverseProtocolListener, pushControllerImpl.mPushBuilder.getReverseData().getBytes());
                        PushControllerImpl.this.mReverseChannel.startReceive();
                    }
                } else if (strArr[0].contains(ProtocolBuilder.LELINK_AUTH_ERROR)) {
                    PushControllerImpl.this.eventCallback(1, ProtocolBuilder.LELINK_AUTH_ERROR);
                } else if (strArr[0].contains(ProtocolBuilder.LELINK_UNSUPPORT_PREEMPT)) {
                    PushControllerImpl.this.eventCallback(1, ProtocolBuilder.LELINK_UNSUPPORT_PREEMPT);
                } else if (PushControllerImpl.this.mConnection.get()) {
                    PushControllerImpl.this.retryPush(strArr);
                }
            } catch (Exception e10) {
                CLog.w(PushControllerImpl.TAG, e10);
            }
        }
    };
    ProtocolListener mSenderProtocolListener = new ProtocolListener() { // from class: com.hpplay.component.protocol.push.PushControllerImpl.2
        @Override // com.hpplay.component.common.protocol.ProtocolListener
        public void onResult(int i10, String... strArr) {
            if (PushControllerImpl.this.mProtocolListener != null) {
                PushControllerImpl.this.mProtocolListener.onResult(i10, strArr);
            }
        }
    };
    ProtocolListener mReverseProtocolListener = new ProtocolListener() { // from class: com.hpplay.component.protocol.push.PushControllerImpl.3
        @Override // com.hpplay.component.common.protocol.ProtocolListener
        public void onResult(int i10, String... strArr) {
            if (PushControllerImpl.this.mPushBuilder != null) {
                PushControllerImpl.this.mPushBuilder.parseReversePlist(PushControllerImpl.this, strArr);
            }
        }
    };

    private void pushPlay() {
        if (getConnectionState()) {
            if (this.mPlayType == 1) {
                sendProtocol(this.mPushBuilder.buildPush(this.mUrl, this.mParams), this.mPushBuilder.getProtocolListener(1, this.mSenderProtocolListener));
            } else {
                sendProtocol(this.mPushBuilder.buildSetPlayList(this.mParams), this.mPushBuilder.getProtocolListener(1, this.mSenderProtocolListener));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryPush(String... strArr) {
        CLog.i(TAG, " start push failed ");
        eventCallback(1, strArr);
    }

    private void sendProtocol(String str, ProtocolListener protocolListener) {
        ProtocolSender protocolSender = this.mProtocolSender;
        if (protocolSender == null || str == null) {
            return;
        }
        protocolSender.protocolEnqueue(protocolListener, str.getBytes());
    }

    private void setConnectionState(boolean z10) {
        try {
            if (this.mConnection == null) {
                this.mConnection = new AtomicBoolean();
            }
            this.mConnection.set(z10);
        } catch (Exception e10) {
            this.mConnection = new AtomicBoolean();
            CLog.w(TAG, e10);
        }
    }

    private void stopReverse() {
        LelinkReverseChannel lelinkReverseChannel = this.mReverseChannel;
        if (lelinkReverseChannel != null) {
            lelinkReverseChannel.stopReceive();
            this.mReverseChannel = null;
        }
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void DLNARetryHttp(boolean z10) {
        if (checkPushBuilderIsNull()) {
            return;
        }
        IPushHandler iPushHandler = this.mPushBuilder;
        if (iPushHandler instanceof DLNAPushHandler) {
            ((DLNAPushHandler) iPushHandler).retryHttp(z10);
        }
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void addPlayList(ParamsMap paramsMap) {
        if (checkPushBuilderIsNull()) {
            return;
        }
        try {
            sendProtocol(this.mPushBuilder.buildAddPlayList(paramsMap), this.mPushBuilder.getProtocolListener(21, this.mSenderProtocolListener));
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    public boolean checkPushBuilderIsNull() {
        if (this.mPushBuilder != null && getConnectionState()) {
            return false;
        }
        CLog.i(TAG, "you must be start push");
        return true;
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void clearPlayList() {
        if (checkPushBuilderIsNull()) {
            return;
        }
        try {
            sendProtocol(this.mPushBuilder.buildClearList(), this.mPushBuilder.getProtocolListener(24, this.mSenderProtocolListener));
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void decreaseVolume() {
        if (checkPushBuilderIsNull()) {
            return;
        }
        sendProtocol(this.mPushBuilder.buildDecreaseVolume(), this.mPushBuilder.getProtocolListener(6, this.mSenderProtocolListener));
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void disConnect() {
        CLog.i(TAG, "disConnect");
        setConnectionState(false);
        ProtocolSender protocolSender = this.mProtocolSender;
        if (protocolSender != null) {
            protocolSender.release();
            this.mProtocolSender = null;
        }
        this.mPushBuilder = null;
        this.mConnector = null;
        stopReverse();
    }

    public void eventCallback(int i10, String... strArr) {
        ProtocolListener protocolListener = this.mProtocolListener;
        if (protocolListener != null) {
            protocolListener.onResult(i10, strArr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void genPushConnection(String str, ParamsMap paramsMap) {
        this.mUrl = str;
        this.mParams = paramsMap;
        if (this.mProtocolSender == null) {
            this.mConnectProtocolListener.cmdType = 11;
            this.mProtocolSender = new ProtocolSender();
        }
        String stringParam = paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_SESSION_ID);
        String str2 = (String) paramsMap.get("ip");
        int parseInt = (paramsMap.get(ParamsMap.DeviceParams.KEY_LELINK_PORT) == 0 || paramsMap.get(ParamsMap.DeviceParams.KEY_LELINK_PORT).toString().length() <= 0) ? 0 : Integer.parseInt(paramsMap.get(ParamsMap.DeviceParams.KEY_LELINK_PORT).toString());
        this.mType = Integer.parseInt(paramsMap.get(ParamsMap.PushParams.KEY_PROTOCOL_TYPE).toString());
        stopReverse();
        int i10 = this.mType;
        if (i10 == 1) {
            this.mPushBuilder = new LelinkPushHandler(paramsMap);
            this.mReverseChannel = new LelinkReverseChannel(str2, parseInt);
            this.mProtocolSender.setConnectInfo(str2, parseInt);
            this.mProtocolSender.startConnect(null, null, this.mType, this.mConnectProtocolListener);
        } else if (i10 == 3) {
            String str3 = (String) paramsMap.get(ParamsMap.PushParams.KEY_LOCATION_URI);
            this.mPushBuilder = new DLNAPushHandler(paramsMap);
            if (!this.mProtocolSender.isConnect() || !TextUtils.equals(this.mLocation, str3)) {
                this.mLocation = str3;
                this.mProtocolSender.startConnect(str3, this.mPushBuilder.mUid, this.mType, this.mConnectProtocolListener);
            }
        } else if (i10 == 5) {
            this.mPushBuilder = new LelinkV2PushHandler(paramsMap);
            this.mReverseChannel = new LelinkReverseChannel(str2, parseInt, stringParam);
            this.mProtocolSender.setConnectInfo(str2, parseInt);
            this.mProtocolSender.startConnect(stringParam, paramsMap.getStringParam("screencode"), this.mType, this.mConnectProtocolListener);
        }
        pushPlay();
    }

    public boolean getConnectionState() {
        try {
            if (this.mConnection == null) {
                AtomicBoolean atomicBoolean = new AtomicBoolean();
                this.mConnection = atomicBoolean;
                atomicBoolean.set(false);
            }
            return this.mConnection.get();
        } catch (Exception e10) {
            this.mConnection = new AtomicBoolean();
            CLog.w(TAG, e10);
            return false;
        }
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void getPlayInfo() {
        if (checkPushBuilderIsNull()) {
            return;
        }
        try {
            sendProtocol(this.mPushBuilder.buildGetPlayInfo(), this.mPushBuilder.getProtocolListener(8, this.mSenderProtocolListener));
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void getStateInfo() {
        if (checkPushBuilderIsNull()) {
            return;
        }
        try {
            sendProtocol(this.mPushBuilder.buildGetStateInfo(), this.mPushBuilder.getProtocolListener(9, this.mSenderProtocolListener));
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void increaseVolume() {
        if (checkPushBuilderIsNull()) {
            return;
        }
        sendProtocol(this.mPushBuilder.buildIncreaseVolume(), this.mPushBuilder.getProtocolListener(5, this.mSenderProtocolListener));
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void onAppPause() {
        IConnector iConnector = this.mConnector;
        if (iConnector != null) {
            iConnector.onAppPause();
        }
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void onAppResume() {
        IConnector iConnector = this.mConnector;
        if (iConnector != null) {
            iConnector.onAppResume();
        }
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void pause() {
        if (checkPushBuilderIsNull()) {
            return;
        }
        try {
            sendProtocol(this.mPushBuilder.buildPause(), this.mPushBuilder.getProtocolListener(2, this.mSenderProtocolListener));
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void playNext() {
        if (checkPushBuilderIsNull()) {
            return;
        }
        try {
            sendProtocol(this.mPushBuilder.buildPlayNext(), this.mPushBuilder.getProtocolListener(22, this.mSenderProtocolListener));
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void playPrevious() {
        if (checkPushBuilderIsNull()) {
            return;
        }
        try {
            sendProtocol(this.mPushBuilder.buildPlayPre(), this.mPushBuilder.getProtocolListener(23, this.mSenderProtocolListener));
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void push(String str, ParamsMap paramsMap) {
        this.retryCount = 0;
        this.mPlayType = 1;
        setConnectionState(true);
        genPushConnection(str, paramsMap);
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void resume() {
        if (checkPushBuilderIsNull()) {
            return;
        }
        try {
            sendProtocol(this.mPushBuilder.buildResume(), this.mPushBuilder.getProtocolListener(3, this.mSenderProtocolListener));
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void seekTo(int i10) {
        if (checkPushBuilderIsNull()) {
            return;
        }
        try {
            sendProtocol(this.mPushBuilder.buildSeekTo(i10), this.mPushBuilder.getProtocolListener(4, this.mSenderProtocolListener));
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void selectAudiotrack(int i10) {
        if (checkPushBuilderIsNull()) {
            return;
        }
        sendProtocol(this.mPushBuilder.buildAudiotrack(i10), this.mPushBuilder.getProtocolListener(27, this.mSenderProtocolListener));
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void selectPlay(ParamsMap paramsMap) {
        if (checkPushBuilderIsNull()) {
            return;
        }
        try {
            sendProtocol(this.mPushBuilder.buildSelectPlay(paramsMap), this.mPushBuilder.getProtocolListener(25, this.mSenderProtocolListener));
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void setConnector(IConnector iConnector) {
        this.mConnector = iConnector;
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void setPlayList(ParamsMap paramsMap) {
        this.retryCount = 0;
        setConnectionState(true);
        this.mPlayType = 2;
        genPushConnection(null, paramsMap);
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void setProtocolListener(ProtocolListener protocolListener) {
        this.mProtocolListener = protocolListener;
    }

    @Override // com.hpplay.component.common.protocol.IPushController
    public void stopPlay() {
        if (checkPushBuilderIsNull()) {
            return;
        }
        try {
            sendProtocol(this.mPushBuilder.buildStopPlay(), this.mPushBuilder.getProtocolListener(7, this.mSenderProtocolListener));
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }
}
