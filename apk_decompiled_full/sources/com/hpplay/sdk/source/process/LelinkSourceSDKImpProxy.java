package com.hpplay.sdk.source.process;

import android.content.Context;
import android.hardware.display.VirtualDisplay;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hpplay.sdk.source.api.IBindSdkListener;
import com.hpplay.sdk.source.api.ICloudMirrorPlayListener;
import com.hpplay.sdk.source.api.ICommonListener;
import com.hpplay.sdk.source.api.IConnectListener;
import com.hpplay.sdk.source.api.IDaPlayerListener;
import com.hpplay.sdk.source.api.IDebugAVListener;
import com.hpplay.sdk.source.api.IFavoriteDeviceListener;
import com.hpplay.sdk.source.api.IHistoryDeviceListener;
import com.hpplay.sdk.source.api.ILelinkPlayerListener;
import com.hpplay.sdk.source.api.ILelinkSourceSDK;
import com.hpplay.sdk.source.api.ILogCallback;
import com.hpplay.sdk.source.api.IMirrorChangeListener;
import com.hpplay.sdk.source.api.INewPlayerListener;
import com.hpplay.sdk.source.api.IReceiverPropertiesCallback;
import com.hpplay.sdk.source.api.IRelevantInfoListener;
import com.hpplay.sdk.source.api.ISearchBannerDataCallback;
import com.hpplay.sdk.source.api.ISendPassCallback;
import com.hpplay.sdk.source.api.ISinkKeyEventListener;
import com.hpplay.sdk.source.api.ISinkTouchEventListener;
import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.bean.AudioFrameBean;
import com.hpplay.sdk.source.bean.DanmakuBean;
import com.hpplay.sdk.source.bean.DanmakuPropertyBean;
import com.hpplay.sdk.source.bean.DebugTimestampBean;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.ReceiverProperties;
import com.hpplay.sdk.source.bean.ReceiverPropertyBean;
import com.hpplay.sdk.source.bean.SinkParameterBean;
import com.hpplay.sdk.source.bean.SinkTouchEventArea;
import com.hpplay.sdk.source.bean.VideoFrameBean;
import com.hpplay.sdk.source.browse.api.AuthListener;
import com.hpplay.sdk.source.browse.api.IAPI;
import com.hpplay.sdk.source.browse.api.IAPICallbackListener;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.ICreatePinCodeListener;
import com.hpplay.sdk.source.browse.api.ICreateShortUrlListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoListParseListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.c;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.config.LelinkConfig;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.q;
import com.hpplay.sdk.source.r;
import com.hpplay.sdk.source.utils.HpplayUtil;
import com.hpplay.sdk.source.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class LelinkSourceSDKImpProxy implements ILelinkSourceSDK {
    private static final int MAX_TRYBIND = 3;
    private static final String TAG = "LelinkSourceSdkImpProxy";
    private static LelinkSourceSDKImpProxy sInstance = new LelinkSourceSDKImpProxy();
    private AuthListener mAppAuthListener;
    private IBrowseListener mAppBrowseListener;
    private ICloudMirrorPlayListener mAppCloudMirrorPlayListener;
    private IConnectListener mAppConnectListener;
    private IDaPlayerListener mAppDaPlayerListener;
    private IDebugAVListener mAppDebugAVListener;
    private ILelinkPlayerListener mAppLelinkPlayerListener;
    private INewPlayerListener mAppNewPlayerListener;
    private IReceiverPropertiesCallback mAppReceiverPropertiesCallback;
    private IRelevantInfoListener mAppRelevantInfoListener;
    private ICommonListener mCommonListener;
    private DebugTSThread mDebugTSThread;
    private LelinkServiceConnection mMultiConnection;
    private z mMultiManager;
    private LelinkSdkManager mSingleManager;
    private boolean isMultiProcessBind = false;
    private boolean isDebug = true;
    private boolean isDebugTimestamp = false;
    private long startDebugTime = 0;
    private int mBindCount = 0;
    private boolean isSetDebugModeWork = false;
    private Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.hpplay.sdk.source.process.LelinkSourceSDKImpProxy.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            return false;
        }
    });
    private r mRelevantInfoListener = new r.a() { // from class: com.hpplay.sdk.source.process.LelinkSourceSDKImpProxy.2
        @Override // com.hpplay.sdk.source.r
        public void onReverseInfoResult(int i10, String str) {
            if (LelinkSourceSDKImpProxy.this.mAppRelevantInfoListener != null) {
                LelinkSourceSDKImpProxy.this.mAppRelevantInfoListener.onReverseInfoResult(i10, str);
            }
        }

        @Override // com.hpplay.sdk.source.r
        public void onSendRelevantInfoResult(int i10, String str) {
            if (LelinkSourceSDKImpProxy.this.mAppRelevantInfoListener != null) {
                LelinkSourceSDKImpProxy.this.mAppRelevantInfoListener.onSendRelevantInfoResult(i10, str);
            }
        }
    };
    private c mCloudMirrorPlayListener = new c.a() { // from class: com.hpplay.sdk.source.process.LelinkSourceSDKImpProxy.3
        @Override // com.hpplay.sdk.source.c
        public void onCloudMessage(long j10, String str) {
            if (LelinkSourceSDKImpProxy.this.mAppCloudMirrorPlayListener != null) {
                LelinkSourceSDKImpProxy.this.mAppCloudMirrorPlayListener.onCloudMessage(j10, str);
            }
        }

        @Override // com.hpplay.sdk.source.c
        public void onCloudMirrorStart(boolean z10, String str, String str2, String str3, String str4, String str5) {
            if (LelinkSourceSDKImpProxy.this.mAppCloudMirrorPlayListener != null) {
                LelinkSourceSDKImpProxy.this.mAppCloudMirrorPlayListener.onCloudMirrorStart(z10, str, str2, str3, str4, str5);
            }
        }

        @Override // com.hpplay.sdk.source.c
        public void onCloudMirrorStop() {
            if (LelinkSourceSDKImpProxy.this.mAppCloudMirrorPlayListener != null) {
                LelinkSourceSDKImpProxy.this.mAppCloudMirrorPlayListener.onCloudMirrorStop();
            }
        }
    };
    private q mReceiverPropertiesCallback = new q.a() { // from class: com.hpplay.sdk.source.process.LelinkSourceSDKImpProxy.4
        @Override // com.hpplay.sdk.source.q
        public void callback(ReceiverProperties receiverProperties) {
            if (LelinkSourceSDKImpProxy.this.mAppReceiverPropertiesCallback != null) {
                LelinkSourceSDKImpProxy.this.mAppReceiverPropertiesCallback.callback(receiverProperties);
            }
        }
    };

    private LelinkSourceSDKImpProxy() {
    }

    public static /* synthetic */ int access$404(LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy) {
        int i10 = lelinkSourceSDKImpProxy.mBindCount + 1;
        lelinkSourceSDKImpProxy.mBindCount = i10;
        return i10;
    }

    public static synchronized LelinkSourceSDKImpProxy getInstance() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy;
        synchronized (LelinkSourceSDKImpProxy.class) {
            lelinkSourceSDKImpProxy = sInstance;
        }
        return lelinkSourceSDKImpProxy;
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void addFavoriteDevice(LelinkServiceInfo lelinkServiceInfo) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.addFavoriteDevice(lelinkServiceInfo);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.addFavoriteDevice(lelinkServiceInfo);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void addPinCodeToLelinkServiceInfo(String str, IServiceInfoParseListener iServiceInfoParseListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setServiceInfoParseListener(iServiceInfoParseListener);
                this.mMultiManager.addPinCodeToLelinkServiceInfo(str);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.setServiceInfoParseListener(iServiceInfoParseListener);
            this.mSingleManager.addPinCodeToLelinkServiceInfo(str);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void addQRCodeToLelinkServiceInfo(String str, IServiceInfoParseListener iServiceInfoParseListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setServiceInfoParseListener(iServiceInfoParseListener);
                this.mMultiManager.addQRCodeToLelinkServiceInfo(str);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.setServiceInfoParseListener(iServiceInfoParseListener);
            this.mSingleManager.addQRCodeToLelinkServiceInfo(str);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void addVolume() {
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.addVolume();
                return;
            }
            return;
        }
        try {
            this.mMultiManager.addVolume();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            retryBind();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.appendPlayList(dramaInfoBeanArr, i10, i11, i12);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.appendPlayList(dramaInfoBeanArr, i10, i11, i12);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void bindSdk(Context context, String str, String str2, IBindSdkListener iBindSdkListener) {
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public boolean canPlayLocalMedia(LelinkServiceInfo lelinkServiceInfo) {
        if (this.isMultiProcessBind) {
            try {
                return this.mMultiManager.canPlayLocalMedia(lelinkServiceInfo);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return false;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            return lelinkSdkManager.canPlayLocalMedia(lelinkServiceInfo);
        }
        return false;
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public boolean canPlayScreen(LelinkServiceInfo lelinkServiceInfo) {
        if (this.isMultiProcessBind) {
            try {
                return this.mMultiManager.canPlayScreen(lelinkServiceInfo);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return false;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            return lelinkSdkManager.canPlayScreen(lelinkServiceInfo);
        }
        return false;
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void clearPlayList() {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.clearPlayList();
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.clearPlayList();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void connect(LelinkServiceInfo lelinkServiceInfo) {
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.connect(lelinkServiceInfo);
                return;
            }
            return;
        }
        try {
            this.mMultiManager.connect(lelinkServiceInfo);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            retryBind();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void createLelinkServiceInfo(SinkParameterBean sinkParameterBean, IServiceInfoParseListener iServiceInfoParseListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setServiceInfoParseListener(iServiceInfoParseListener);
                this.mMultiManager.setOption(IAPI.OPTION_CREATE_LELINK_SERVICE, new String[]{sinkParameterBean.toJson()});
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.setServiceInfoParseListener(iServiceInfoParseListener);
            this.mSingleManager.createLelinkServiceInfo(sinkParameterBean);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void createLelinkServiceInfoList(List<SinkParameterBean> list, IServiceInfoListParseListener iServiceInfoListParseListener) {
        SourceLog.i(TAG, "createLelinkServiceInfoList isMultiProcessBind：" + this.isMultiProcessBind);
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setServiceInfoListParseListener(iServiceInfoListParseListener);
                this.mSingleManager.createLelinkServiceInfoList(list);
                return;
            }
            return;
        }
        try {
            this.mMultiConnection.setServiceInfoListParseListener(iServiceInfoListParseListener);
            JSONArray jSONArray = new JSONArray();
            Iterator<SinkParameterBean> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
            this.mMultiManager.setOption(IAPI.OPTION_CREATE_LELINK_SERVICE_LIST, new String[]{jSONArray.toString()});
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void createPinCode(ICreatePinCodeListener iCreatePinCodeListener) {
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.createPinCode(iCreatePinCodeListener);
                return;
            }
            return;
        }
        try {
            this.mMultiConnection.setAICreatePinCodeListener(iCreatePinCodeListener);
            this.mMultiManager.createPinCode();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void createShortUrl(ICreateShortUrlListener iCreateShortUrlListener) {
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.createShortUrl(iCreateShortUrlListener);
                return;
            }
            return;
        }
        try {
            this.mMultiConnection.setAICreateShortUrlListener(iCreateShortUrlListener);
            this.mMultiManager.createShortUrl();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public boolean disconnect(LelinkServiceInfo lelinkServiceInfo) {
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                return lelinkSdkManager.disconnect(lelinkServiceInfo);
            }
            return true;
        }
        try {
            return this.mMultiManager.disconnect(lelinkServiceInfo);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            retryBind();
            return true;
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public List<LelinkServiceInfo> getConnectInfos() {
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                return lelinkSdkManager.getConnectInfos();
            }
            return null;
        }
        try {
            return this.mMultiManager.getConnectInfos();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            retryBind();
            return null;
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void getFavoriteDeviceList(int i10, int i11) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.getFavoriteDeviceList(i10, i11);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.getFavoriteDeviceList(i10, i11);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void getHistoryDeviceList(int i10, int i11) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.getHistoryDeviceList(i10, i11);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.getHistoryDeviceList(i10, i11);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public Object getOption(int i10, Object... objArr) {
        SourceLog.i(TAG, "getOption " + i10);
        switch (i10) {
            case IAPI.OPTION_35 /* 1048629 */:
            case IAPI.OPTION_37 /* 1048631 */:
            case IAPI.OPTION_63 /* 1048675 */:
            case IAPI.OPTION_QUERY_SUPPORT_MULTI_CHANNEL /* 2097159 */:
            case IAPI.OPTION_QUERY_SUPPORT_URL_LIST /* 2097160 */:
            case IAPI.OPTION_QUERY_SUPPORT_REVERSE_CONTROL /* 2097173 */:
            case IAPI.OPTION_TEMP_RESTRICT /* 2097175 */:
            case IAPI.OPTION_QUERY_SUPPORT_TRACK /* 2097177 */:
            case IAPI.OPTION_SET_RECEIVER_PROPERTY /* 2097234 */:
            case IAPI.OPTION_GET_RECEIVER_PROPERTIES /* 2097235 */:
                if (objArr != null && objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof LelinkServiceInfo) {
                        LelinkServiceInfo lelinkServiceInfo = (LelinkServiceInfo) obj;
                        if (this.isMultiProcessBind) {
                            try {
                                return Boolean.valueOf(this.mMultiManager.setLelinkServiceInfoOption(i10, lelinkServiceInfo));
                            } catch (Exception e10) {
                                SourceLog.w(TAG, e10);
                            }
                        } else {
                            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
                            if (lelinkSdkManager != null) {
                                Object option = lelinkSdkManager.getOption(i10, lelinkServiceInfo);
                                return (option == null || TextUtils.isEmpty(option.toString()) || !HpplayUtil.isDigitsOnly(option.toString()) || Integer.parseInt(option.toString()) != 0) ? Boolean.FALSE : Boolean.TRUE;
                            }
                        }
                    }
                }
                return Boolean.FALSE;
            default:
                if (this.isMultiProcessBind) {
                    try {
                        String option2 = this.mMultiManager.getOption(i10);
                        return (TextUtils.isEmpty(option2) || !HpplayUtil.isDigitsOnly(option2)) ? option2 : Integer.valueOf(Integer.parseInt(option2));
                    } catch (Exception e11) {
                        SourceLog.w(TAG, e11);
                    }
                } else {
                    LelinkSdkManager lelinkSdkManager2 = this.mSingleManager;
                    if (lelinkSdkManager2 != null) {
                        return lelinkSdkManager2.getOption(i10, objArr);
                    }
                }
                return -1;
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public String getSDKInfos(int i10) {
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            return lelinkSdkManager != null ? lelinkSdkManager.getSDKInfos(i10) : "";
        }
        try {
            return this.mMultiManager.getSDKInfos(i10);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return "";
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public VirtualDisplay getVirtualDisplay() {
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            return lelinkSdkManager.getVirtualDisplay();
        }
        return null;
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void pause() {
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.pause();
                return;
            }
            return;
        }
        try {
            this.mMultiManager.pause();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            retryBind();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void removeFavoriteDevice(List<LelinkServiceInfo> list) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.removeFavoriteDevice(list);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.removeFavoriteDevice(list);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void removeHistoryDevice(List<LelinkServiceInfo> list, int i10) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.removeHistoryDevice(list, i10);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.removeHistoryDevice(list, i10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void resume() {
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.resume();
                return;
            }
            return;
        }
        try {
            this.mMultiManager.resume();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            retryBind();
        }
    }

    public void retryBind() {
        Handler handler = this.mHandler;
        if (handler == null || this.mBindCount >= 3) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        this.mHandler.postDelayed(new Runnable() { // from class: com.hpplay.sdk.source.process.LelinkSourceSDKImpProxy.5
            @Override // java.lang.Runnable
            public void run() {
                if (LelinkSourceSDKImpProxy.this.mMultiConnection != null) {
                    LelinkSourceSDKImpProxy.this.mMultiConnection.startBind();
                }
                LelinkSourceSDKImpProxy.access$404(LelinkSourceSDKImpProxy.this);
                LelinkSourceSDKImpProxy.this.isMultiProcessBind = false;
            }
        }, 500L);
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void seekTo(int i10) {
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.seekTo(i10);
                return;
            }
            return;
        }
        try {
            this.mMultiManager.seekTo(i10);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            retryBind();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setBrowseResultListener(IBrowseListener iBrowseListener) {
        this.mAppBrowseListener = iBrowseListener;
        SourceLog.i(TAG, "LelinkSourceSdkImp setBrowseResultListener " + this.isMultiProcessBind);
        try {
            if (this.isMultiProcessBind) {
                this.mMultiConnection.setBrowseResultListener(iBrowseListener);
            } else {
                LelinkSdkManager lelinkSdkManager = this.mSingleManager;
                if (lelinkSdkManager != null) {
                    lelinkSdkManager.setBrowseListener(iBrowseListener);
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setCommonListener(ICommonListener iCommonListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setCommonListener(iCommonListener);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.setCommonListener(iCommonListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setConnectListener(IConnectListener iConnectListener) {
        this.mAppConnectListener = iConnectListener;
        try {
            SourceLog.i(TAG, "LelinkSourceSdkImp setConnectListener " + this.isMultiProcessBind);
            if (this.isMultiProcessBind) {
                this.mMultiConnection.setConnectListener(iConnectListener);
            } else {
                LelinkSdkManager lelinkSdkManager = this.mSingleManager;
                if (lelinkSdkManager != null) {
                    lelinkSdkManager.setConnectListener(iConnectListener);
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setDaPlayListener(IDaPlayerListener iDaPlayerListener) {
        this.mAppDaPlayerListener = iDaPlayerListener;
        SourceLog.i(TAG, "setDaPlayListener " + this.isMultiProcessBind);
        try {
            if (this.isMultiProcessBind) {
                this.mMultiConnection.setDaPlayListener(iDaPlayerListener);
            } else {
                LelinkSdkManager lelinkSdkManager = this.mSingleManager;
                if (lelinkSdkManager != null) {
                    lelinkSdkManager.setDaPlayListener(iDaPlayerListener);
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setDebugAVListener(IDebugAVListener iDebugAVListener) {
        this.mAppDebugAVListener = iDebugAVListener;
        SourceLog.i(TAG, "LelinkSourceSdkImp setDebugAVListener " + this.isMultiProcessBind);
        try {
            if (this.isMultiProcessBind) {
                this.mMultiConnection.setDebugAVListener(iDebugAVListener);
            } else {
                LelinkSdkManager lelinkSdkManager = this.mSingleManager;
                if (lelinkSdkManager != null) {
                    lelinkSdkManager.setDebugAVListener(iDebugAVListener);
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setDebugMode(boolean z10) {
        this.isDebug = z10;
        if (LelinkConfig.isMultiProgress() && !this.isMultiProcessBind) {
            SourceLog.w(TAG, "service is binding");
            this.isSetDebugModeWork = false;
            return;
        }
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.isDebug(z10);
                return;
            }
            return;
        }
        try {
            this.mMultiConnection.setDebugMode(z10);
            this.isSetDebugModeWork = true;
            SourceLog.i(TAG, "setDebugMode," + z10);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setDebugTimestamp(boolean z10) {
        this.isDebugTimestamp = z10;
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setDebugTimestamp(z10);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.isDebugTimestamp(z10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setFavoriteDeviceAlias(LelinkServiceInfo lelinkServiceInfo, String str) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.setFavoriteDeviceAlias(lelinkServiceInfo, str);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.setFavoriteDeviceAlias(lelinkServiceInfo, str);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setFavoriteDeviceListener(IFavoriteDeviceListener iFavoriteDeviceListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setFavoriteDeviceListener(iFavoriteDeviceListener);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.setFavoriteDeviceListener(iFavoriteDeviceListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setHistoryDeviceListener(IHistoryDeviceListener iHistoryDeviceListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setHistoryDeviceListener(iHistoryDeviceListener);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.setHistoryDeviceListener(iHistoryDeviceListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setLogCallback(ILogCallback iLogCallback) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setLogCallback(iLogCallback);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.setLogCallback(iLogCallback);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setMirrorChangeListener(IMirrorChangeListener iMirrorChangeListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setMirrorChangeListener(iMirrorChangeListener);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.setMirrorChangeListener(iMirrorChangeListener);
        }
    }

    public void setMultiManager(z zVar, LelinkServiceConnection lelinkServiceConnection) {
        this.isMultiProcessBind = true;
        this.mMultiManager = zVar;
        this.mMultiConnection = lelinkServiceConnection;
        lelinkServiceConnection.setDebugAVListener(this.mAppDebugAVListener);
        this.mMultiConnection.setBrowseResultListener(this.mAppBrowseListener);
        this.mMultiConnection.setConnectListener(this.mAppConnectListener);
        this.mMultiConnection.setPlayListener(this.mAppLelinkPlayerListener);
        this.mMultiConnection.setNewPlayListener(this.mAppNewPlayerListener);
        this.mMultiConnection.setDaPlayListener(this.mAppDaPlayerListener);
        this.mMultiConnection.setAuthListener(this.mAppAuthListener);
        if (!this.isSetDebugModeWork) {
            this.mMultiConnection.setDebugMode(this.isDebug);
        }
        this.mMultiConnection.setCommonListener(this.mCommonListener);
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setNewPlayListener(INewPlayerListener iNewPlayerListener) {
        this.mAppNewPlayerListener = iNewPlayerListener;
        SourceLog.i(TAG, "setNewPlayListener " + this.isMultiProcessBind);
        try {
            if (this.isMultiProcessBind) {
                this.mMultiConnection.setNewPlayListener(iNewPlayerListener);
            } else {
                LelinkSdkManager lelinkSdkManager = this.mSingleManager;
                if (lelinkSdkManager != null) {
                    lelinkSdkManager.setNewPlayerListener(iNewPlayerListener);
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x02de A[Catch: Exception -> 0x02e6, TryCatch #2 {Exception -> 0x02e6, blocks: (B:20:0x000a, B:22:0x02a4, B:24:0x02a9, B:6:0x02b6, B:8:0x02d6, B:10:0x02da, B:14:0x02de, B:16:0x02e2, B:5:0x02b4), top: B:19:0x000a, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x02d6 A[Catch: Exception -> 0x02e6, TryCatch #2 {Exception -> 0x02e6, blocks: (B:20:0x000a, B:22:0x02a4, B:24:0x02a9, B:6:0x02b6, B:8:0x02d6, B:10:0x02da, B:14:0x02de, B:16:0x02e2, B:5:0x02b4), top: B:19:0x000a, outer: #0 }] */
    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setOption(int i10, Object... objArr) {
        String[] strArr;
        boolean z10 = true;
        try {
            switch (i10) {
                case IAPI.OPTION_3 /* 65539 */:
                    IAPICallbackListener iAPICallbackListener = (IAPICallbackListener) objArr[0];
                    List<LelinkServiceInfo> list = (List) objArr[1];
                    if (iAPICallbackListener != null && list != null) {
                        if (!this.isMultiProcessBind) {
                            this.mSingleManager.startOnlineCheck(iAPICallbackListener, list);
                            return;
                        } else {
                            this.mMultiConnection.setOnlineCheckListener(iAPICallbackListener);
                            this.mMultiManager.startOnlineCheck(this.mMultiConnection.mOnlineCheckListener, list);
                            return;
                        }
                    }
                    return;
                case IAPI.OPTION_4 /* 65540 */:
                    AuthListener authListener = (AuthListener) objArr[0];
                    if (this.isMultiProcessBind) {
                        try {
                            this.mMultiConnection.setAuthListener(authListener);
                        } catch (Exception e10) {
                            SourceLog.w(TAG, e10);
                        }
                    } else {
                        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
                        if (lelinkSdkManager != null) {
                            lelinkSdkManager.setAuthListener(authListener);
                        }
                    }
                    this.mAppAuthListener = authListener;
                    return;
                case IAPI.OPTION_27 /* 1048615 */:
                    if (objArr.length > 0) {
                        Object obj = objArr[0];
                        if (obj instanceof ILogCallback) {
                            setLogCallback((ILogCallback) obj);
                            return;
                        }
                        return;
                    }
                    return;
                case IAPI.OPTION_29 /* 1048617 */:
                    Object obj2 = objArr[0];
                    if (obj2 instanceof Boolean) {
                        if (this.isMultiProcessBind) {
                            this.mMultiManager.setSystemApp(((Boolean) obj2).booleanValue());
                            return;
                        }
                        LelinkSdkManager lelinkSdkManager2 = this.mSingleManager;
                        if (lelinkSdkManager2 != null) {
                            lelinkSdkManager2.setSystemApp(((Boolean) obj2).booleanValue());
                            return;
                        }
                        return;
                    }
                    return;
                case IAPI.OPTION_63 /* 1048675 */:
                    if (objArr == null || objArr.length <= 0) {
                        return;
                    }
                    Object obj3 = objArr[0];
                    if (obj3 instanceof DanmakuBean) {
                        DanmakuBean danmakuBean = (DanmakuBean) obj3;
                        if (this.isMultiProcessBind) {
                            this.mMultiManager.setOption(i10, new String[]{danmakuBean.toJson(null, 0)});
                            return;
                        }
                        LelinkSdkManager lelinkSdkManager3 = this.mSingleManager;
                        if (lelinkSdkManager3 != null) {
                            lelinkSdkManager3.setOption(i10, danmakuBean.toJson(null, 0));
                            return;
                        }
                        return;
                    }
                    return;
                case IAPI.OPTION_64 /* 1048676 */:
                    if (objArr == null || objArr.length <= 0) {
                        return;
                    }
                    Object obj4 = objArr[0];
                    if (obj4 instanceof DanmakuPropertyBean) {
                        DanmakuPropertyBean danmakuPropertyBean = (DanmakuPropertyBean) obj4;
                        if (this.isMultiProcessBind) {
                            this.mMultiManager.setOption(i10, new String[]{danmakuPropertyBean.toJson(0)});
                            return;
                        }
                        LelinkSdkManager lelinkSdkManager4 = this.mSingleManager;
                        if (lelinkSdkManager4 != null) {
                            lelinkSdkManager4.setOption(i10, danmakuPropertyBean.toJson(0));
                            return;
                        }
                        return;
                    }
                    return;
                case IAPI.MULTIMIRROR_ADDED_DEVES /* 1179648 */:
                case IAPI.MULTIMIRROR_DELETE_DEVES /* 1179649 */:
                    if (objArr == null || objArr.length <= 0) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Object obj5 : objArr) {
                        arrayList.add((LelinkServiceInfo) obj5);
                    }
                    if (this.isMultiProcessBind) {
                        z zVar = this.mMultiManager;
                        if (1179648 != i10) {
                            z10 = false;
                        }
                        zVar.multiMirrorControl(z10, arrayList);
                        return;
                    }
                    LelinkSdkManager lelinkSdkManager5 = this.mSingleManager;
                    if (1179648 != i10) {
                        z10 = false;
                    }
                    lelinkSdkManager5.multiMirrorControl(z10, arrayList);
                    return;
                case IAPI.SET_PASSTHROUGH_LISTENER /* 1179650 */:
                    if (objArr == null || objArr.length <= 0) {
                        return;
                    }
                    Object obj6 = objArr[0];
                    if (obj6 instanceof IRelevantInfoListener) {
                        IRelevantInfoListener iRelevantInfoListener = (IRelevantInfoListener) obj6;
                        this.mAppRelevantInfoListener = iRelevantInfoListener;
                        if (this.isMultiProcessBind) {
                            this.mMultiManager.setRelevantInfoListener(this.mRelevantInfoListener);
                            return;
                        }
                        LelinkSdkManager lelinkSdkManager6 = this.mSingleManager;
                        if (lelinkSdkManager6 != null) {
                            lelinkSdkManager6.setRelevantInfoListener(iRelevantInfoListener);
                            return;
                        }
                        return;
                    }
                    return;
                case IAPI.SET_CLOUDMIRROR_PLAY_LISTENER /* 1179651 */:
                    if (objArr == null || objArr.length <= 0) {
                        return;
                    }
                    Object obj7 = objArr[0];
                    if (obj7 instanceof ICloudMirrorPlayListener) {
                        ICloudMirrorPlayListener iCloudMirrorPlayListener = (ICloudMirrorPlayListener) obj7;
                        this.mAppCloudMirrorPlayListener = iCloudMirrorPlayListener;
                        if (this.isMultiProcessBind) {
                            this.mMultiManager.setCloudMirrorPlayListener(this.mCloudMirrorPlayListener);
                            return;
                        }
                        LelinkSdkManager lelinkSdkManager7 = this.mSingleManager;
                        if (lelinkSdkManager7 != null) {
                            lelinkSdkManager7.setCloudMirrorPlayListener(iCloudMirrorPlayListener);
                            return;
                        }
                        return;
                    }
                    return;
                case IAPI.MULTIPUSH_ADDED_DEVES /* 2097207 */:
                    SourceLog.i(TAG, "MULTIPUSH_ADDED_DEVES values:" + Arrays.toString(objArr));
                    if (objArr == null || objArr.length <= 2) {
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Object[] objArr2 = (Object[]) objArr[2];
                    for (int i11 = 0; i11 < objArr2.length; i11++) {
                        SourceLog.i(TAG, "MULTIPUSH_ADDED_DEVES values :" + i11 + ", " + objArr2[i11]);
                        arrayList2.add((LelinkServiceInfo) objArr2[i11]);
                    }
                    if (this.isMultiProcessBind) {
                        this.mMultiManager.multiPushControl(true, arrayList2, (String) objArr[0], ((Integer) objArr[1]).intValue());
                        return;
                    } else {
                        this.mSingleManager.multiPushControl(true, arrayList2, (String) objArr[0], ((Integer) objArr[1]).intValue());
                        return;
                    }
                case IAPI.MULTIPUSH_DELETE_DEVES /* 2097208 */:
                    if (objArr == null || objArr.length <= 0) {
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj8 : objArr) {
                        arrayList3.add((LelinkServiceInfo) obj8);
                    }
                    if (this.isMultiProcessBind) {
                        this.mMultiManager.multiPushControl(false, arrayList3, null, 0);
                        return;
                    } else {
                        this.mSingleManager.multiPushControl(false, arrayList3, null, 0);
                        return;
                    }
                case IAPI.OPTION_SET_RECEIVER_PROPERTY /* 2097234 */:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof ReceiverPropertyBean)) {
                        return;
                    }
                    SourceLog.i(TAG, "OPTION_SET_RECEIVER_PROPERTY" + objArr[0]);
                    ReceiverPropertyBean receiverPropertyBean = (ReceiverPropertyBean) objArr[0];
                    if (this.isMultiProcessBind) {
                        this.mMultiManager.setOption(i10, new String[]{receiverPropertyBean.toJson()});
                        return;
                    }
                    LelinkSdkManager lelinkSdkManager8 = this.mSingleManager;
                    if (lelinkSdkManager8 != null) {
                        lelinkSdkManager8.setOption(i10, receiverPropertyBean.toJson());
                        return;
                    }
                    return;
                case IAPI.OPTION_GET_RECEIVER_PROPERTIES /* 2097235 */:
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof IReceiverPropertiesCallback)) {
                        return;
                    }
                    SourceLog.i(TAG, "OPTION_GET_RECEIVER_PROPERTIES: " + objArr[0]);
                    IReceiverPropertiesCallback iReceiverPropertiesCallback = (IReceiverPropertiesCallback) objArr[0];
                    this.mAppReceiverPropertiesCallback = iReceiverPropertiesCallback;
                    if (this.isMultiProcessBind) {
                        this.mMultiManager.setReceiverPropertiesCallback(this.mReceiverPropertiesCallback);
                        this.mMultiManager.setOption(i10, null);
                        return;
                    }
                    LelinkSdkManager lelinkSdkManager9 = this.mSingleManager;
                    if (lelinkSdkManager9 != null) {
                        lelinkSdkManager9.setReceiverPropertiesCallback(iReceiverPropertiesCallback);
                        this.mSingleManager.setOption(i10, null);
                        return;
                    }
                    return;
                default:
                    if (objArr != null) {
                        try {
                            if (objArr.length > 0) {
                                int length = objArr.length;
                                strArr = new String[length];
                                for (int i12 = 0; i12 < length; i12++) {
                                    strArr[i12] = String.valueOf(objArr[i12]);
                                }
                                SourceLog.i(TAG, "isMultiProcessBind " + i10 + " / " + strArr);
                                if (this.isMultiProcessBind) {
                                    LelinkSdkManager lelinkSdkManager10 = this.mSingleManager;
                                    if (lelinkSdkManager10 != null) {
                                        lelinkSdkManager10.setOption(i10, strArr);
                                        return;
                                    }
                                    return;
                                }
                                z zVar2 = this.mMultiManager;
                                if (zVar2 != null) {
                                    zVar2.setOption(i10, strArr);
                                    return;
                                }
                                return;
                            }
                        } catch (Exception e11) {
                            SourceLog.w(TAG, e11);
                            return;
                        }
                    }
                    strArr = new String[1];
                    SourceLog.i(TAG, "isMultiProcessBind " + i10 + " / " + strArr);
                    if (this.isMultiProcessBind) {
                    }
            }
        } catch (Exception e12) {
            SourceLog.w(TAG, "setOption: process may be closed " + i10 + " , " + e12);
        }
        SourceLog.w(TAG, "setOption: process may be closed " + i10 + " , " + e12);
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setPlayListener(ILelinkPlayerListener iLelinkPlayerListener) {
        this.mAppLelinkPlayerListener = iLelinkPlayerListener;
        SourceLog.i(TAG, "setPlayListener " + this.isMultiProcessBind);
        try {
            if (this.isMultiProcessBind) {
                this.mMultiConnection.setPlayListener(iLelinkPlayerListener);
            } else {
                LelinkSdkManager lelinkSdkManager = this.mSingleManager;
                if (lelinkSdkManager != null) {
                    lelinkSdkManager.setPlayerListener(iLelinkPlayerListener);
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setSearchBannerDataCallback(ISearchBannerDataCallback iSearchBannerDataCallback) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setSearchBannerDataCallback(iSearchBannerDataCallback);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.setSearchBannerDataCallback(iSearchBannerDataCallback);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setSendPassCallback(ISendPassCallback iSendPassCallback) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setPassCallback(iSendPassCallback);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.setPassCallback(iSendPassCallback);
        }
    }

    public void setSingleManager(LelinkSdkManager lelinkSdkManager) {
        this.mSingleManager = lelinkSdkManager;
        lelinkSdkManager.setDebugAVListener(this.mAppDebugAVListener);
        this.mSingleManager.setBrowseListener(this.mAppBrowseListener);
        this.mSingleManager.setConnectListener(this.mAppConnectListener);
        this.mSingleManager.setPlayerListener(this.mAppLelinkPlayerListener);
        this.mSingleManager.setNewPlayerListener(this.mAppNewPlayerListener);
        this.mSingleManager.setDaPlayListener(this.mAppDaPlayerListener);
        this.mSingleManager.setAuthListener(this.mAppAuthListener);
        this.mSingleManager.setCommonListener(this.mCommonListener);
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setSinkKeyEventListener(ISinkKeyEventListener iSinkKeyEventListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setSinkKeyEventListener(iSinkKeyEventListener);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.setSinkKeyEventListener(iSinkKeyEventListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setSinkTouchEventListener(SinkTouchEventArea sinkTouchEventArea, float f10, ISinkTouchEventListener iSinkTouchEventListener) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiConnection.setSinkTouchEventListener(sinkTouchEventArea, f10, iSinkTouchEventListener);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.setSinkTouchEventListener(sinkTouchEventArea, f10, iSinkTouchEventListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setVolume(int i10) {
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.setVolume(i10);
                return;
            }
            return;
        }
        try {
            this.mMultiManager.setVolume(i10);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            retryBind();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void startBrowse(boolean z10, boolean z11) {
        SourceLog.i(TAG, "startBrowse " + this.isMultiProcessBind);
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.startBrowseThread(z10, z11);
                return;
            }
            return;
        }
        try {
            this.mMultiManager.browse(z10, z11);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            retryBind();
        }
    }

    public void startDebugThread() {
        if (Session.getInstance().getDebugTimestamp() && System.currentTimeMillis() - this.startDebugTime >= 200) {
            DebugTSThread debugTSThread = this.mDebugTSThread;
            if (debugTSThread == null || !debugTSThread.isAlive()) {
                DebugTimestampBean debugTimestampBean = new DebugTimestampBean();
                Session.getInstance().setDebugTimestampBean(debugTimestampBean);
                DebugTSThread debugTSThread2 = new DebugTSThread(debugTimestampBean);
                this.mDebugTSThread = debugTSThread2;
                debugTSThread2.start();
            }
            this.mDebugTSThread.startThread();
            this.startDebugTime = System.currentTimeMillis();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void startMirror(LelinkPlayerInfo lelinkPlayerInfo) {
        SourceLog.i(TAG, "startMirror " + this.isMultiProcessBind);
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.startMirrorForPlayerInfo(lelinkPlayerInfo);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                retryBind();
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.startMirror(lelinkPlayerInfo);
            startDebugThread();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void startPlayMedia(String str, int i10, boolean z10) {
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.startPlayMedia(null, str, i10, z10);
                return;
            }
            return;
        }
        try {
            this.mMultiManager.startPlayMedia(str, i10, z10);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            retryBind();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, String str, int i10, boolean z10) {
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.startPlayMedia(lelinkServiceInfo, str, i10, z10);
                return;
            }
            return;
        }
        try {
            this.mMultiManager.startPlayMediaImmed(lelinkServiceInfo, str, i10, z10);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            retryBind();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void stopBrowse() {
        SourceLog.i(TAG, "LelinkSourceSdkImp stopBrowse " + this.isMultiProcessBind);
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.stopBrowseThread();
                return;
            }
            return;
        }
        try {
            this.mMultiManager.stopBrowse();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            retryBind();
        }
    }

    public void stopDebugThread() {
        if (this.mDebugTSThread == null || System.currentTimeMillis() - this.startDebugTime <= 200) {
            return;
        }
        this.mDebugTSThread.stopThread();
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void stopPlay() {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.stopPlay();
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                retryBind();
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.stopPlay();
            stopDebugThread();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void subVolume() {
        if (!this.isMultiProcessBind) {
            LelinkSdkManager lelinkSdkManager = this.mSingleManager;
            if (lelinkSdkManager != null) {
                lelinkSdkManager.subVolume();
                return;
            }
            return;
        }
        try {
            this.mMultiManager.subVolume();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            retryBind();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void unBindSdk() {
        try {
            if (this.isMultiProcessBind) {
                this.mMultiConnection.unBind();
            } else {
                LelinkSdkManager lelinkSdkManager = this.mSingleManager;
                if (lelinkSdkManager != null) {
                    lelinkSdkManager.release();
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void updateAudioData(byte[] bArr, AudioFrameBean audioFrameBean) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.updateAudioData(bArr, audioFrameBean);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.updateAudioData(bArr, audioFrameBean);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void updateVideoData(byte[] bArr, VideoFrameBean videoFrameBean) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.updateVideoData(bArr, videoFrameBean);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.updateVideoData(bArr, videoFrameBean);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void bindSdk(Context context, String str, String str2, String str3, IBindSdkListener iBindSdkListener) {
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void bindSdk(Context context, String str, String str2, String str3, String str4, String str5, IBindSdkListener iBindSdkListener) {
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void startPlayMedia(LelinkPlayerInfo lelinkPlayerInfo) {
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.startPlayMediaForPlayerInfo(lelinkPlayerInfo);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                retryBind();
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.startPlayCheck(lelinkPlayerInfo);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, Uri uri, int i10) {
        LelinkPlayerInfo lelinkPlayerInfo = new LelinkPlayerInfo();
        lelinkPlayerInfo.setLelinkServiceInfo(lelinkServiceInfo);
        lelinkPlayerInfo.setLocalUri(uri);
        lelinkPlayerInfo.setType(i10);
        if (this.isMultiProcessBind) {
            try {
                this.mMultiManager.startPlayMediaForPlayerInfo(lelinkPlayerInfo);
                return;
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
                retryBind();
                return;
            }
        }
        LelinkSdkManager lelinkSdkManager = this.mSingleManager;
        if (lelinkSdkManager != null) {
            lelinkSdkManager.startPlayCheck(lelinkPlayerInfo);
        }
    }
}
