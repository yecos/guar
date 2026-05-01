package com.hpplay.sdk.source.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.hpplay.common.log.LeLog;
import com.hpplay.common.utils.FieldUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.IPushController;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.component.protocol.push.IPushHandler;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.MediaAssetBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.PassBean;
import com.hpplay.sdk.source.bean.PlayerInfoBean;
import com.hpplay.sdk.source.bean.StopInfo;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.BusinessEntity;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.PassSender;
import com.hpplay.sdk.source.player.listener.OnCompletionListener;
import com.hpplay.sdk.source.player.listener.OnErrorListener;
import com.hpplay.sdk.source.player.listener.OnInfoListener;
import com.hpplay.sdk.source.player.listener.OnPreparedListener;
import com.hpplay.sdk.source.player.listener.OnStateChangeListener;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.protocol.connect.AbsConnectBridge;
import com.hpplay.sdk.source.utils.CastUtil;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LelinkPushBridge extends AbsBridge {
    private static final int ARG_PUSH_ERROR = 0;
    private static final int ARG_PUSH_SHOW_CAST_CODE = 2;
    private static final int ARG_PUSH_SUCCESS = 1;
    private static final int DELAY_COMPLETE = 4000;
    private static final int DELAY_PLAY = 3000;
    private static int DELAY_STOPPED = 2000;
    private static final int DELAY_UPDATE_POSITION = 1000;
    private static final int DELAY_UPDATE_STATE = 2000;
    private static final int DELAY_WHEN_BACKGROUND_UPDATE_POSITION = 10000;
    private static final String DLNA_STATE_PAUSE = "paused";
    private static final String DLNA_STATE_PLAYING = "playing";
    private static final String DLNA_STATE_STOPPED = "stopped";
    private static final int MSG_DELAY_PLAY = 200;
    protected static String TAG = "LelinkPushBridge";
    protected boolean isCallPrepared;
    protected boolean isJGTP;
    private boolean isReleased;
    private boolean isUpdatePosition;
    private long mDlnaGetPlayStateTime;
    private String mDlnaPreState;
    private final Runnable mDlnaStateRunnable;
    private String mDlnaUUID;
    protected int mDuration;
    private final Handler mHandler;
    private long mLastPlayDuration;
    private long mLastPlayPosition;
    private ModuleLinker mModuleLinker;
    private LelinkProtocolListener mPlayerListener;
    private int mPosition;
    private int mPositionCount;
    private final Runnable mPositionRunnable;
    private String mPreDLNAStopUrl;
    protected IPushController mPushController;
    private String mReportPrepareDramaId;
    AbsConnectBridge.OnPassSendCompleteListener onPassReceivedListener;

    public LelinkPushBridge(Context context, OutParameter outParameter) {
        super(context, outParameter);
        this.isCallPrepared = false;
        this.mPositionCount = -1;
        this.mDlnaUUID = null;
        this.isReleased = false;
        this.mLastPlayPosition = 0L;
        this.mLastPlayDuration = 0L;
        this.isJGTP = false;
        this.mPreDLNAStopUrl = null;
        this.mReportPrepareDramaId = null;
        this.isUpdatePosition = false;
        this.mDlnaGetPlayStateTime = 0L;
        this.mPlayerListener = new LelinkProtocolListener() { // from class: com.hpplay.sdk.source.protocol.LelinkPushBridge.1
            @Override // com.hpplay.component.common.protocol.ProtocolListener
            public void onResult(int i10, String... strArr) {
                if (LelinkPushBridge.this.isReleased) {
                    return;
                }
                LelinkPushBridge.this.resolveProtocolInfo(i10, strArr);
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.hpplay.sdk.source.protocol.LelinkPushBridge.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    if (message.what == 200) {
                        LelinkPushBridge.this.startPush();
                        return true;
                    }
                    LelinkPushBridge.this.handleMsg(message);
                    return false;
                } catch (Exception e10) {
                    SourceLog.w(LelinkPushBridge.TAG, e10);
                    return false;
                }
            }
        });
        this.mPositionRunnable = new Runnable() { // from class: com.hpplay.sdk.source.protocol.LelinkPushBridge.3
            @Override // java.lang.Runnable
            public void run() {
                IPushController iPushController = LelinkPushBridge.this.mPushController;
                if (iPushController == null) {
                    return;
                }
                iPushController.getPlayInfo();
                LelinkPushBridge lelinkPushBridge = LelinkPushBridge.this;
                if (lelinkPushBridge.isAppResume) {
                    lelinkPushBridge.mHandler.postDelayed(this, 1000L);
                } else if (lelinkPushBridge.getRemainProgress() > 60) {
                    LelinkPushBridge.this.mHandler.postDelayed(this, NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
                } else {
                    LelinkPushBridge.this.mHandler.postDelayed(this, 1000L);
                }
            }
        };
        this.mDlnaPreState = "";
        this.mDlnaStateRunnable = new Runnable() { // from class: com.hpplay.sdk.source.protocol.LelinkPushBridge.4
            @Override // java.lang.Runnable
            public void run() {
                IPushController iPushController = LelinkPushBridge.this.mPushController;
                if (iPushController == null) {
                    return;
                }
                iPushController.getStateInfo();
                LelinkPushBridge.this.mHandler.postDelayed(this, 2000L);
            }
        };
        this.onPassReceivedListener = new AbsConnectBridge.OnPassSendCompleteListener() { // from class: com.hpplay.sdk.source.protocol.LelinkPushBridge.5
            @Override // com.hpplay.sdk.source.protocol.connect.AbsConnectBridge.OnPassSendCompleteListener
            public void onPassReversed(PassBean passBean) {
                LeLog.i(LelinkPushBridge.TAG, " >>>> " + passBean.cmd + " passBean  " + passBean.result);
                if (passBean.cmd == 2) {
                    LelinkPushBridge.this.mHandler.removeMessages(200);
                    LelinkPushBridge.this.startPush();
                }
            }
        };
        this.mPlayInfo = outParameter;
        try {
            if (this.mPushController == null) {
                ModuleLinker newInstance = ModuleLinker.getNewInstance();
                this.mModuleLinker = newInstance;
                IPushController iPushController = (IPushController) newInstance.loadModule(ModuleIds.CLAZZ_ID1088_PUSHCONTROLLERIMPL);
                this.mPushController = iPushController;
                iPushController.setProtocolListener(this.mPlayerListener);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    private void callbackDlnaStateChanged(String str) {
        SourceLog.i(TAG, "CMD_GET_STATEINFO callbackDlnaStateChanged " + str);
        if ("playing".equals(str)) {
            callbackStart();
            return;
        }
        if ("paused".equals(str)) {
            OnStateChangeListener onStateChangeListener = this.mStateChangeListener;
            if (onStateChangeListener != null) {
                onStateChangeListener.onStateChanged(null, 4);
                return;
            }
            return;
        }
        if ("stopped".equals(str)) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(" callbackDlnaStateChanged delayStop   ");
            sb.append(System.currentTimeMillis() - this.mDlnaGetPlayStateTime < 2000);
            sb.append(this.mDlnaGetPlayStateTime);
            SourceLog.i(str2, sb.toString());
            if (System.currentTimeMillis() - this.mDlnaGetPlayStateTime < 4000) {
                DELAY_STOPPED = 10000;
            }
            notifyStopped(1);
        }
    }

    private void callbackStart() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter == null || outParameter.urls == null) {
            if (this.isCallPrepared) {
                OnStateChangeListener onStateChangeListener = this.mStateChangeListener;
                if (onStateChangeListener != null) {
                    onStateChangeListener.onStateChanged(null, 3);
                    return;
                }
                return;
            }
            this.isCallPrepared = true;
            OnPreparedListener onPreparedListener = this.mPreparedListener;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared(null);
                return;
            }
            return;
        }
        String str = this.mReportPrepareDramaId;
        if (str != null && str.equals(outParameter.dramaID)) {
            OnStateChangeListener onStateChangeListener2 = this.mStateChangeListener;
            if (onStateChangeListener2 != null) {
                onStateChangeListener2.onStateChanged(null, 3);
                return;
            }
            return;
        }
        this.mReportPrepareDramaId = this.mPlayInfo.dramaID;
        OnPreparedListener onPreparedListener2 = this.mPreparedListener;
        if (onPreparedListener2 != null) {
            onPreparedListener2.onPrepared(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRemainProgress() {
        int i10 = this.mDuration - this.mPosition;
        SourceLog.i(TAG, "remain progress " + i10);
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMsg(Message message) {
        SourceLog.i(TAG, "handleMsg " + message.what);
        int i10 = message.what;
        if (i10 == 1) {
            int i11 = message.arg1;
            if (i11 == 2) {
                OnErrorListener onErrorListener = this.mErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(null, 210010, 211026, null);
                    return;
                }
                return;
            }
            if (i11 != 1) {
                if (this.mErrorListener != null) {
                    Object obj = message.obj;
                    this.mErrorListener.onError(null, 210010, 210011, obj != null ? obj.toString() : "");
                    return;
                }
                return;
            }
            if (this.mLoadingListener != null) {
                Object obj2 = message.obj;
                this.mLoadingListener.onLoading(null, obj2 != null ? obj2.toString() : "");
            }
            if (this.mPlayInfo.protocol == 3) {
                this.mDlnaGetPlayStateTime = System.currentTimeMillis();
                this.mHandler.postDelayed(this.mDlnaStateRunnable, 2000L);
                return;
            }
            return;
        }
        if (i10 != 26 && i10 != 12) {
            if (i10 == 13) {
                callbackStart();
                if (this.mPlayInfo.protocol == 3) {
                    SourceLog.i(TAG, "CMD_ON_START_PLAY ");
                    this.mHandler.removeCallbacks(this.mDlnaStateRunnable);
                    this.mHandler.post(this.mDlnaStateRunnable);
                    return;
                }
                return;
            }
            if (i10 == 15) {
                OnStateChangeListener onStateChangeListener = this.mStateChangeListener;
                if (onStateChangeListener != null) {
                    onStateChangeListener.onStateChanged(null, 4);
                    return;
                }
                return;
            }
            if (i10 != 16) {
                return;
            }
        }
        if (System.currentTimeMillis() - this.mDlnaGetPlayStateTime < 4000) {
            return;
        }
        cancelPositionUpdate();
        cancelStateUpdate();
        this.isCallPrepared = false;
        if (message.what != 26) {
            release();
        }
        if (message.what == 12) {
            OnCompletionListener onCompletionListener = this.mCompletionListener;
            if (onCompletionListener != null) {
                onCompletionListener.onComplete(null);
                return;
            }
            return;
        }
        if (this instanceof DLNABridge) {
            long j10 = this.mLastPlayDuration;
            long j11 = this.mLastPlayPosition;
            if (j10 - j11 <= 5 && j10 - j11 >= 0 && j10 > 0) {
                OnCompletionListener onCompletionListener2 = this.mCompletionListener;
                if (onCompletionListener2 != null) {
                    onCompletionListener2.onComplete(null);
                    return;
                }
                return;
            }
        }
        if (this.mStopListener != null) {
            StopInfo stopInfo = new StopInfo();
            if (message.what == 26) {
                stopInfo.type = 3;
            } else {
                stopInfo.type = message.arg1;
            }
            this.mStopListener.onStop(null, stopInfo);
        }
    }

    private boolean isSameDlna(String... strArr) {
        String str;
        String str2;
        try {
            str = strArr.length > 0 ? strArr[0] : null;
            str2 = strArr.length > 1 ? strArr[1] : null;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(this.mDlnaUUID) && !TextUtils.equals(str2, this.mDlnaUUID)) {
            SourceLog.w(TAG, "isSameDlna unEqual uri, " + str2 + " / " + this.mDlnaUUID);
            return false;
        }
        if (!TextUtils.isEmpty(str) && !isSameUrl(str, this.mPlayInfo.getPlayUrl())) {
            SourceLog.w(TAG, "isSameDlna unEqual url, " + str + " / " + this.mPlayInfo.getPlayUrl());
            this.mPreDLNAStopUrl = str;
            return false;
        }
        return true;
    }

    private boolean isSameLelink(String... strArr) {
        try {
            String str = strArr.length > 0 ? strArr[0] : null;
            if (TextUtils.isEmpty(str) || isSameUrl(str, this.mPlayInfo.urlID)) {
                return true;
            }
            SourceLog.w(TAG, "isSameLelink unEqual uri, " + str + Operator.Operation.DIVISION + this.mPlayInfo.urlID);
            return false;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return true;
        }
    }

    private boolean isSameUrl(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (TextUtils.equals(str, str2)) {
                return true;
            }
            try {
                if (TextUtils.equals(URLDecoder.decode(str), str2)) {
                    return true;
                }
                if (TextUtils.equals(URLDecoder.decode(str2), str)) {
                    return true;
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
        return false;
    }

    private void notifyPosition(String... strArr) {
        try {
            if (strArr.length >= 2 && !strArr[0].contains(IPushHandler.READY_PLAY)) {
                int ceil = (int) Math.ceil(Float.parseFloat(strArr[0]));
                int ceil2 = (int) Math.ceil(Float.parseFloat(strArr[1]));
                if (this instanceof DLNABridge) {
                    try {
                        String str = strArr[2];
                    } catch (Exception e10) {
                        SourceLog.w(TAG, e10);
                    }
                }
                if (ceil > 0) {
                    this.mDuration = ceil;
                }
                if (ceil2 >= 0) {
                    this.mPosition = ceil2;
                }
                int i10 = this.mPositionCount + 1;
                this.mPositionCount = i10;
                if (i10 % 30 == 0) {
                    printResult("notifyPosition ", "mDuration := " + this.mDuration + " mPosition := " + this.mPosition, "mInfoListener := " + this.mInfoListener);
                }
                int i11 = this.mPosition;
                if (i11 > 0) {
                    this.mLastPlayPosition = i11;
                }
                int i12 = this.mDuration;
                if (i12 > 0) {
                    this.mLastPlayDuration = i12;
                }
                OnInfoListener onInfoListener = this.mInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(null, 100, i12, i11);
                }
                if (this.isJGTP) {
                    long j10 = this.mLastPlayDuration;
                    long j11 = this.mLastPlayPosition;
                    if (j10 - j11 >= 2 || j10 - j11 < 0 || j10 <= 3 || this.mDuration <= 0 || this.mPosition <= 0 || this.mHandler.hasMessages(12)) {
                        return;
                    }
                    SourceLog.i(TAG, "notifyPosition send CMD_ON_COMPLETION delay 4000");
                    this.mHandler.removeMessages(12);
                    this.mHandler.sendEmptyMessageDelayed(12, 4000L);
                }
            }
        } catch (Exception e11) {
            SourceLog.w(TAG, e11);
        }
    }

    private void notifyStopped(int i10) {
        if (this.mHandler.hasMessages(16)) {
            SourceLog.w(TAG, "notifyStopped ignore");
            return;
        }
        SourceLog.i(TAG, "notifyStopped delay " + DELAY_STOPPED + " / stopType:" + i10);
        Message obtain = Message.obtain();
        obtain.what = 16;
        obtain.arg1 = i10;
        this.mHandler.sendMessageDelayed(obtain, (long) DELAY_STOPPED);
    }

    private void printResult(String str, String... strArr) {
        String str2 = "";
        for (String str3 : strArr) {
            str2 = str2 + str3 + "  ";
        }
        SourceLog.i(TAG, "cmd: " + str + "   result:" + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void resolveProtocolInfo(int r10, java.lang.String... r11) {
        /*
            Method dump skipped, instructions count: 590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.protocol.LelinkPushBridge.resolveProtocolInfo(int, java.lang.String[]):void");
    }

    private void setPlayListParams(ParamsMap paramsMap, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        DramaInfoBean.UrlBean[] urlBeanArr;
        DramaInfoBean.UrlBean[] urlBeanArr2;
        String str;
        DramaInfoBean[] dramaInfoBeanArr2 = dramaInfoBeanArr;
        try {
            paramsMap.putParam("period", Integer.valueOf(i10));
            paramsMap.putParam("curplayid", this.mPlayInfo.dramaID);
            paramsMap.putParam(ParamsMap.PushParams.KEY_HEAD_DURATION, Integer.valueOf(i11));
            paramsMap.putParam(ParamsMap.PushParams.KEY_TAIL_DURATION, Integer.valueOf(i12));
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            int i13 = 0;
            int i14 = 0;
            while (i13 < dramaInfoBeanArr2.length) {
                DramaInfoBean dramaInfoBean = dramaInfoBeanArr2[i13];
                if (dramaInfoBean != null && (urlBeanArr = dramaInfoBean.urls) != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    boolean isEmpty = TextUtils.isEmpty(dramaInfoBean.name);
                    String str2 = XML.CHARSET_UTF8;
                    if (!isEmpty) {
                        try {
                            dramaInfoBean.name = URLEncoder.encode(dramaInfoBean.name, XML.CHARSET_UTF8);
                        } catch (Exception e10) {
                            SourceLog.w(TAG, "setPlayListParams :" + e10);
                        }
                    }
                    jSONObject2.put("name", dramaInfoBean.name);
                    JSONArray jSONArray2 = new JSONArray();
                    int i15 = 0;
                    int i16 = 0;
                    while (i15 < urlBeanArr.length) {
                        DramaInfoBean.UrlBean urlBean = urlBeanArr[i15];
                        if (urlBean == null) {
                            urlBeanArr2 = urlBeanArr;
                            str = str2;
                        } else {
                            JSONObject jSONObject3 = new JSONObject();
                            urlBeanArr2 = urlBeanArr;
                            jSONObject3.put("height", urlBean.height);
                            jSONObject3.put("width", urlBean.width);
                            jSONObject3.put("playid", urlBean.id);
                            if (!TextUtils.isEmpty(urlBean.url)) {
                                try {
                                    urlBean.url = URLEncoder.encode(urlBean.url, str2);
                                } catch (Exception e11) {
                                    str = str2;
                                    SourceLog.w(TAG, "setPlayListParams :" + e11);
                                }
                            }
                            str = str2;
                            jSONObject3.put("url", urlBean.url);
                            jSONObject3.put("category", urlBean.category);
                            jSONArray2.put(i16, jSONObject3);
                            i16++;
                        }
                        i15++;
                        urlBeanArr = urlBeanArr2;
                        str2 = str;
                    }
                    jSONObject2.put("urls", jSONArray2);
                    jSONArray.put(i14, jSONObject2);
                    i14++;
                }
                i13++;
                dramaInfoBeanArr2 = dramaInfoBeanArr;
            }
            jSONObject.put(ParamsMap.PushParams.KEY_PLAY_LIST_JSON, jSONArray);
            paramsMap.putParam(ParamsMap.PushParams.KEY_PLAY_LIST_JSON, jSONObject);
        } catch (Exception e12) {
            SourceLog.w(TAG, "getPlayListParams error:" + e12.getMessage());
        }
    }

    private void updateDramaIdOnCallback(int i10, String... strArr) {
        String str;
        OutParameter lastPlayInfo;
        if (i10 == 8) {
            if (strArr != null && strArr.length >= 4) {
                str = strArr[3];
            }
            str = "";
        } else {
            if (strArr != null && strArr.length >= 2) {
                str = strArr[1];
            }
            str = "";
        }
        if (TextUtils.isEmpty(str) || (lastPlayInfo = BusinessEntity.getInstance().getLastPlayInfo()) == null) {
            return;
        }
        lastPlayInfo.dramaID = str;
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void addVolume() {
        super.addVolume();
        if (this.mPushController == null) {
            SourceLog.w(TAG, "addVolume ignore");
        } else {
            SourceLog.i(TAG, "addVolume");
            this.mPushController.increaseVolume();
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void appendPlayList(String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        SourceLog.i(TAG, "appendPlayList");
        if (this.mPushController == null) {
            SourceLog.w(TAG, "appendPlayList ignore");
            return;
        }
        if (dramaInfoBeanArr == null || dramaInfoBeanArr.length <= 0) {
            SourceLog.w(TAG, "appendPlayList ignore list invalid");
            return;
        }
        try {
            ParamsMap paramsMap = new ParamsMap();
            setPlayListParams(paramsMap, dramaInfoBeanArr, i10, i11, i12);
            this.mPushController.addPlayList(paramsMap);
        } catch (Exception e10) {
            SourceLog.w(TAG, "appendPlayList error:" + e10.getMessage());
        }
    }

    public void cancelPositionUpdate() {
        this.isUpdatePosition = false;
        this.mHandler.removeCallbacks(this.mPositionRunnable);
    }

    public void cancelStateUpdate() {
        SourceLog.i(TAG, "cancelStateUpdate... ");
        this.mHandler.removeCallbacks(this.mDlnaStateRunnable);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void clearPlayList(String str) {
        SourceLog.i(TAG, "clearPlayList");
        IPushController iPushController = this.mPushController;
        if (iPushController == null) {
            SourceLog.w(TAG, "clearPlayList ignore");
        } else {
            iPushController.clearPlayList();
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void onAppPause() {
        super.onAppPause();
        IPushController iPushController = this.mPushController;
        if (iPushController != null) {
            iPushController.onAppPause();
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void onAppResume() {
        super.onAppResume();
        IPushController iPushController = this.mPushController;
        if (iPushController != null) {
            iPushController.onAppResume();
        }
        if (this.isUpdatePosition) {
            updatePosition();
        }
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void pause(String str) {
        IPushController iPushController = this.mPushController;
        if (iPushController == null) {
            SourceLog.w(TAG, "pause ignore");
        } else {
            iPushController.pause();
        }
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void play(String str) {
        if (this.mPushController == null) {
            SourceLog.w(TAG, "play ignore");
            return;
        }
        if (ConnectManager.getInstance().getLastConnectBridge() != null) {
            this.mPushController.setConnector(ConnectManager.getInstance().getLastConnectBridge().getConnector());
            ConnectManager.getInstance().getLastConnectBridge().addOnPassSendCompleteListener(this, this.onPassReceivedListener);
        }
        if (CastUtil.isSupportLelinkV2(this.mPlayInfo.serviceInfo)) {
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
                this.mHandler.sendEmptyMessageDelayed(200, 3000L);
                PassSender passSender2 = PassSender.getInstance();
                OutParameter outParameter4 = this.mPlayInfo;
                passSender2.sendMediaAssets(outParameter4.mediaAssetBean, outParameter4.session);
                return;
            }
        }
        startPush();
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void playDrama(String str, String str2) {
        SourceLog.i(TAG, "playDrama :" + str2);
        if (this.mPushController == null) {
            SourceLog.w(TAG, "playDrama ignore");
            return;
        }
        ParamsMap paramsMap = new ParamsMap();
        paramsMap.putParam("curplayid", str2);
        paramsMap.putParam("width", 0);
        paramsMap.putParam("height", 0);
        this.mPushController.selectPlay(paramsMap);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void playNextDrama(String str) {
        SourceLog.i(TAG, "playNextDrama");
        IPushController iPushController = this.mPushController;
        if (iPushController == null) {
            SourceLog.w(TAG, "playNextDrama ignore");
        } else {
            iPushController.playNext();
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void playPreDrama(String str) {
        SourceLog.i(TAG, "playPreDrama");
        IPushController iPushController = this.mPushController;
        if (iPushController == null) {
            SourceLog.w(TAG, "playPreDrama ignore");
        } else {
            iPushController.playPrevious();
        }
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public synchronized void release() {
        if (this.mPushController == null) {
            return;
        }
        if (this.isReleased) {
            SourceLog.w(TAG, "release ignore");
            return;
        }
        SourceLog.i(TAG, "release " + this);
        this.isReleased = true;
        this.mPushController.setProtocolListener(null);
        this.mPushController.disConnect();
        this.mHandler.removeMessages(16);
        this.mHandler.removeMessages(12);
        ConnectManager.getInstance().getLastConnectBridge().removeOnPassSendCompleteListener(this);
        ModuleLinker moduleLinker = this.mModuleLinker;
        if (moduleLinker != null) {
            moduleLinker.removeObjOfMemory(ModuleIds.CLAZZ_ID1088_PUSHCONTROLLERIMPL);
            this.mModuleLinker = null;
        }
        this.mPushController = null;
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void resume(String str) {
        IPushController iPushController = this.mPushController;
        if (iPushController == null) {
            SourceLog.w(TAG, "resume ignore");
        } else {
            iPushController.resume();
        }
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void seekTo(int i10) {
        if (this.mPushController == null) {
            SourceLog.w(TAG, "seekTo ignore");
            return;
        }
        SourceLog.i(TAG, "seekTo: second := " + i10);
        this.mPushController.seekTo(i10);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge
    public void selectAudiotrack(int i10) {
        if (this.mPushController == null) {
            SourceLog.w(TAG, "selectAudiotrack ignore");
            return;
        }
        SourceLog.i(TAG, "selectAudiotrack index = " + i10);
        this.mPushController.selectAudiotrack(i10);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void setVolume(int i10) {
        super.setVolume(i10);
    }

    public void startPush() {
        OutParameter outParameter = this.mPlayInfo;
        BrowserInfo browserInfo = outParameter.currentBrowserInfo;
        if (browserInfo == null) {
            SourceLog.w(TAG, "play ignore, invalid browser info");
            return;
        }
        this.isCallPrepared = false;
        this.mDuration = outParameter.duration;
        LelinkServiceInfo lelinkServiceInfo = outParameter.serviceInfo;
        String name = lelinkServiceInfo != null ? lelinkServiceInfo.getName() : "";
        SourceLog.i(TAG, "play " + this.mPlayInfo.getPlayUrl() + " to " + name + Operator.Operation.DIVISION + this);
        ParamsMap create = ParamsMap.create();
        create.putParam(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
        create.putParam(ParamsMap.DeviceParams.KEY_HID, Session.getInstance().getHID());
        Object string = FieldUtil.getString(FieldUtil.f7332m);
        Session.getInstance();
        create.putParam(string, Session.DEFAULT_M);
        create.putParam("imei", "");
        create.putParam(ParamsMap.DeviceParams.KEY_SINK_NAME, name);
        create.putParam(ParamsMap.DeviceParams.KEY_SESSION_ID, this.mPlayInfo.session);
        create.putParam(ParamsMap.DeviceParams.KEY_CONNECT_SESSION_ID, this.mPlayInfo.connectSession);
        create.putParam(ParamsMap.PushParams.KEY_START_POSITION, Integer.valueOf(this.mPlayInfo.startPosition));
        create.putParam("uri", this.mPlayInfo.urlID);
        create.putParam(ParamsMap.PushParams.KEY_MEDIA_TYPE, this.mPlayInfo.mimeType + "");
        create.putParam(ParamsMap.PushParams.KEY_PROTOCOL_TYPE, Integer.valueOf(this.mPlayInfo.protocol));
        create.putParam(ParamsMap.DeviceParams.KEY_CONNECT_SESSION_ID, this.mPlayInfo.connectSession);
        create.putParam(ParamsMap.DeviceParams.KEY_APPID, Session.getInstance().appKey);
        create.putParam(ParamsMap.DeviceParams.KEY_RECEIVER_UID, browserInfo.getUid());
        if (!TextUtils.isEmpty(this.mPlayInfo.password)) {
            create.putParam("screencode", this.mPlayInfo.password);
        }
        try {
            if (CastUtil.isSupportLelinkV2(browserInfo)) {
                create.putParam(ParamsMap.PushParams.KEY_PROTOCOL_TYPE, 5);
                create.putParam("vv", "2");
                create.putParam(ParamsMap.DeviceParams.KEY_LELINK_PORT, browserInfo.getExtras().get("lelinkport") + "");
            } else {
                create.putParam(ParamsMap.DeviceParams.KEY_LELINK_PORT, browserInfo.getExtras().get("airplay") + "");
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        create.putParam("ip", browserInfo.getIp());
        SourceLog.debug(TAG, "play " + create.toString());
        try {
            DramaInfoBean[] dramaInfoBeanArr = this.mPlayInfo.urls;
            if (dramaInfoBeanArr == null || dramaInfoBeanArr.length <= 0) {
                SourceLog.debug(TAG, "play ");
                this.mPushController.push(this.mPlayInfo.getPlayUrl(), create);
            } else {
                SourceLog.i(TAG, "setPlayList");
                OutParameter outParameter2 = this.mPlayInfo;
                setPlayListParams(create, outParameter2.urls, outParameter2.period, outParameter2.headLength, outParameter2.tailLength);
                this.mPushController.setPlayList(create);
            }
        } catch (Exception e11) {
            SourceLog.w(TAG, e11);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.IBridge
    public void stop(String str) {
        IPushController iPushController = this.mPushController;
        if (iPushController == null) {
            SourceLog.w(TAG, "stop ignore");
            return;
        }
        iPushController.setConnector(null);
        this.mPushController.stopPlay();
        cancelPositionUpdate();
        cancelStateUpdate();
        this.mLastPlayPosition = 0L;
        this.mLastPlayDuration = 0L;
        ConnectManager.getInstance().getLastConnectBridge().removeOnPassSendCompleteListener(this);
    }

    @Override // com.hpplay.sdk.source.protocol.AbsBridge, com.hpplay.sdk.source.protocol.IBridge
    public void subVolume() {
        super.subVolume();
        if (this.mPushController == null) {
            SourceLog.w(TAG, "subVolume ignore");
        } else {
            SourceLog.i(TAG, "subVolume");
            this.mPushController.decreaseVolume();
        }
    }

    public void updatePosition() {
        if (this.mPlayInfo.mimeType == 103) {
            return;
        }
        this.isUpdatePosition = true;
        this.mHandler.removeCallbacks(this.mPositionRunnable);
        this.mHandler.post(this.mPositionRunnable);
    }
}
