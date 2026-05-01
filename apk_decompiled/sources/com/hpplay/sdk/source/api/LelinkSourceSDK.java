package com.hpplay.sdk.source.api;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.hpplay.sdk.source.bean.AudioFrameBean;
import com.hpplay.sdk.source.bean.BrowserConfigBean;
import com.hpplay.sdk.source.bean.DanmakuBean;
import com.hpplay.sdk.source.bean.DanmakuPropertyBean;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.HistoryConfigBean;
import com.hpplay.sdk.source.bean.ReceiverPropertyBean;
import com.hpplay.sdk.source.bean.ShortMediaBean;
import com.hpplay.sdk.source.bean.SinkParameterBean;
import com.hpplay.sdk.source.bean.SinkTouchEventArea;
import com.hpplay.sdk.source.bean.VideoFrameBean;
import com.hpplay.sdk.source.bean.WatermarkBean;
import com.hpplay.sdk.source.browse.api.DeprecatedParceResultListenerWrapper;
import com.hpplay.sdk.source.browse.api.IAPI;
import com.hpplay.sdk.source.browse.api.IAPICallbackListener;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.ICreatePinCodeListener;
import com.hpplay.sdk.source.browse.api.ICreateShortUrlListener;
import com.hpplay.sdk.source.browse.api.IParceResultListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoListParseListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.api.ReceiverPropertyAction;
import com.hpplay.sdk.source.browse.api.ReceiverPropertyValue;
import com.hpplay.sdk.source.config.LelinkConfig;
import com.hpplay.sdk.source.easycast.BrowserManager;
import com.hpplay.sdk.source.easycast.IEasyCastListener;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.proxy.ModuleLoader;
import com.hpplay.sdk.source.transceiver.SourceTransceiver;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LelinkSourceSDK {
    public static final int ALL_DEVICE = 0;
    public static final int AUDIO_CHANNEL_IN_MONO = 1;
    public static final int AUDIO_CHANNEL_IN_STEREO = 2;
    public static final int AUDIO_SAMPLERATE_16K = 16000;
    public static final int AUDIO_SAMPLERATE_44K = 44100;
    public static final int AUDIO_SAMPLERATE_48K = 48000;
    public static final int BITRATE_HIGH = 4;
    public static final int BITRATE_LOW = 6;
    public static final int BITRATE_MIDDLE = 5;
    public static final int CREATE_TYPE_LOCAL_CACHE = 7;
    public static final int EXTERNAL_AUDIO_PCM = 1;
    public static final String EXTERNAL_ENCODE_PAUSE = "encode_pause";
    public static final String EXTERNAL_ENCODE_RESUME = "encode_resume";
    public static final int EXTERNAL_VIDEO_H264 = 1;
    public static final int EXTERNAL_VIDEO_RGB = 2;
    public static final String FEEDBACK_CONNECT_FAILED = "4001";
    public static final String FEEDBACK_MIRROR_AV_ASYNC = "2005";
    public static final String FEEDBACK_MIRROR_BLACK = "2001";
    public static final String FEEDBACK_MIRROR_BLURRED = "2003";
    public static final String FEEDBACK_MIRROR_FLASH_BACK = "2002";
    public static final String FEEDBACK_MIRROR_NOT_CHANGE_ORIENTATION = "2007";
    public static final String FEEDBACK_MIRROR_OTHER = "2008";
    public static final String FEEDBACK_MIRROR_PLAY_FAILED = "2009";
    public static final String FEEDBACK_MIRROR_SCALE = "2006";
    public static final String FEEDBACK_MIRROR_UNSMOOTH = "2004";
    public static final String FEEDBACK_PUSH_AV_ASYNC = "1007";
    public static final String FEEDBACK_PUSH_BLACK = "1002";
    public static final String FEEDBACK_PUSH_CONTROL_ERROR = "1009";
    public static final String FEEDBACK_PUSH_FLASH_BACK = "1004";
    public static final String FEEDBACK_PUSH_LOAD_FAILED = "1006";
    public static final String FEEDBACK_PUSH_OTHER = "1008";
    public static final String FEEDBACK_PUSH_PLAY_FAILED = "1003";
    public static final String FEEDBACK_PUSH_SCALE = "1005";
    public static final String FEEDBACK_PUSH_UNSMOOTH = "1001";
    public static final int KEY_GET_HID = 2;
    public static final int KEY_GET_UID = 1;
    public static final int LOCAL_DEVICE = 3;
    public static final int MEDIA_TYPE_AUDIO = 101;
    public static final int MEDIA_TYPE_IMAGE = 103;
    public static final int MEDIA_TYPE_MICRO_APP = 105;
    public static final int MEDIA_TYPE_VIDEO = 102;
    public static final int MIRROR_LOADING = 1;
    public static final int MIRROR_PAUSE = 11;
    public static final int MIRROR_PLAYING = 5;
    public static final int MUSIC_LOADING = 3;
    public static final int MUSIC_PAUSE = 10;
    public static final int MUSIC_PLAYING = 7;
    public static final int OFFLINE_DEVICE = 2;
    public static final int ONLINE_DEVICE = 1;
    public static final int PICTURE_LOADING = 4;
    public static final int PICTURE_PLAYING = 8;
    public static final float PLAYBACK_SPEED1 = 0.5f;
    public static final float PLAYBACK_SPEED2 = 0.75f;
    public static final float PLAYBACK_SPEED3 = 1.0f;
    public static final float PLAYBACK_SPEED4 = 1.25f;
    public static final float PLAYBACK_SPEED5 = 1.5f;
    public static final float PLAYBACK_SPEED6 = 2.0f;

    @Deprecated
    public static final int PLAY_STOPED = 0;
    public static final int PLAY_STOPPED = 0;
    private static final String PROCESS_NAME = "lelinkps";
    public static String PROTOCOL_ANDLINK = "Andlink";
    public static final int REMOVE_HISTORY_ALL = 1;
    public static final int REMOVE_HISTORY_PART = 0;
    public static final int RESOLUTION_AUTO = 3;
    public static final int RESOLUTION_HIGH = 1;
    public static final int RESOLUTION_MIDDLE = 2;
    private static final String TAG = "LelinkSourceSDK";
    public static final int VIDEO_LOADING = 2;
    public static final int VIDEO_PAUSE = 9;
    public static final int VIDEO_PLAYING = 6;
    private static LelinkSourceSDK mLelinkSDKController;
    private IBindSdkListener mAppBindSdkListener;
    private String mAppSecret;
    private String mAppVersion;
    private String mAppid;
    private IBleBrowseStateListener mBleBrowseStateListener;
    private IConnectListener mConnectListener;
    private Context mContext;
    private IDaPlayerListener mDaPlayerListener;
    private IDebugAVListener mDebugAVListener;
    private IBrowseListener mIBrowseListener;
    private ILelinkSourceSDK mILelinkSourceSdk;
    private ILogCallback mLogCallback;
    private INewPlayerListener mNewPlayerListener;
    private String mOaid;
    private ISendPassCallback mPassCallback;
    private ILelinkPlayerListener mPlayerListener;
    private ISinkKeyEventListener mSinkKeyEventListener;
    private SourceTransceiver mTransceiver;
    private String mUserId;
    private boolean isBindSuccess = false;
    private IBindSdkListener mBindSdkListener = new IBindSdkListener() { // from class: com.hpplay.sdk.source.api.LelinkSourceSDK.1
        @Override // com.hpplay.sdk.source.api.IBindSdkListener
        public void onBindCallback(boolean z10) {
            LelinkSourceSDK.this.isBindSuccess = z10;
            if (LelinkSourceSDK.this.mAppBindSdkListener != null) {
                LelinkSourceSDK.this.mAppBindSdkListener.onBindCallback(z10);
            }
            if (LelinkSourceSDK.this.mCallBrowseType == 1) {
                LelinkSourceSDK lelinkSourceSDK = LelinkSourceSDK.this;
                lelinkSourceSDK.startBrowse(lelinkSourceSDK.useLelink, LelinkSourceSDK.this.useDlna);
            } else {
                if (LelinkSourceSDK.this.mCallBrowseType != 2 || LelinkSourceSDK.this.mBrowseConfigBean == null) {
                    return;
                }
                LelinkSourceSDK lelinkSourceSDK2 = LelinkSourceSDK.this;
                lelinkSourceSDK2.startBrowse(lelinkSourceSDK2.mBrowseConfigBean);
            }
        }
    };
    private boolean isChildProcessBind = false;
    private int mCallBrowseType = -1;
    private boolean useLelink = true;
    private boolean useDlna = true;
    private BrowserConfigBean mBrowseConfigBean = null;
    private CommonDispatcher mListenerDispatcher = new CommonDispatcher();

    private LelinkSourceSDK() {
    }

    private boolean checkForOption(int i10, LelinkServiceInfo lelinkServiceInfo) {
        ILelinkSourceSDK iLelinkSourceSDK;
        if (lelinkServiceInfo != null && (iLelinkSourceSDK = this.mILelinkSourceSdk) != null) {
            Object option = iLelinkSourceSDK.getOption(i10, lelinkServiceInfo);
            if (option instanceof Boolean) {
                return ((Boolean) option).booleanValue();
            }
        }
        return false;
    }

    public static LelinkSourceSDK getInstance() {
        LelinkSourceSDK lelinkSourceSDK;
        synchronized (LelinkSourceSDK.class) {
            if (mLelinkSDKController == null) {
                mLelinkSDKController = new LelinkSourceSDK();
            }
            lelinkSourceSDK = mLelinkSDKController;
        }
        return lelinkSourceSDK;
    }

    public void addFavoriteDevice(LelinkServiceInfo lelinkServiceInfo) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.addFavoriteDevice(lelinkServiceInfo);
        }
    }

    @Deprecated
    public void addNfcTagToLelinkServiceInfo(Intent intent, IParceResultListener iParceResultListener) {
    }

    public void addPinCodeToLelinkServiceInfo(String str, IServiceInfoParseListener iServiceInfoParseListener) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.addPinCodeToLelinkServiceInfo(str, iServiceInfoParseListener);
        }
    }

    public void addQRCodeToLelinkServiceInfo(String str, IServiceInfoParseListener iServiceInfoParseListener) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.addQRCodeToLelinkServiceInfo(str, iServiceInfoParseListener);
        }
    }

    public void addVolume() {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.addVolume();
        }
    }

    public void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.appendPlayList(dramaInfoBeanArr, i10, i11, i12);
        }
    }

    public void bindOfChildProcess() {
        this.isChildProcessBind = true;
        bindSdk();
    }

    public void bindSdk() {
        bindSdk(this.mContext, this.mAppid, this.mAppSecret, this.mUserId, this.mAppVersion, this.mOaid, this.mAppBindSdkListener);
    }

    public boolean canPlayLocalMedia(LelinkServiceInfo lelinkServiceInfo) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            return iLelinkSourceSDK.canPlayLocalMedia(lelinkServiceInfo);
        }
        return false;
    }

    public boolean canPlayScreen(LelinkServiceInfo lelinkServiceInfo) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            return iLelinkSourceSDK.canPlayScreen(lelinkServiceInfo);
        }
        return false;
    }

    public void clearPlayList() {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.clearPlayList();
        }
    }

    public void connect(LelinkServiceInfo lelinkServiceInfo) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.connect(lelinkServiceInfo);
        }
    }

    public void createLelinkSeviceInfo(SinkParameterBean sinkParameterBean, IServiceInfoParseListener iServiceInfoParseListener) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.createLelinkServiceInfo(sinkParameterBean, iServiceInfoParseListener);
        }
    }

    public void createLelinkSeviceInfoList(List<SinkParameterBean> list, IServiceInfoListParseListener iServiceInfoListParseListener) {
        ILelinkSourceSDK iLelinkSourceSDK;
        if (list == null || list.size() > 10 || (iLelinkSourceSDK = this.mILelinkSourceSdk) == null) {
            return;
        }
        iLelinkSourceSDK.createLelinkServiceInfoList(list, iServiceInfoListParseListener);
    }

    public void createPinCode(ICreatePinCodeListener iCreatePinCodeListener) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.createPinCode(iCreatePinCodeListener);
        }
    }

    public void createShortUrl(ICreateShortUrlListener iCreateShortUrlListener) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.createShortUrl(iCreateShortUrlListener);
        }
    }

    @Deprecated
    public boolean disConnect(LelinkServiceInfo lelinkServiceInfo) {
        return disconnect(lelinkServiceInfo);
    }

    public void disableCloudCast(boolean z10) {
        setOption(IAPI.OPTION_DISABLE_CLOUD_CAST, Boolean.valueOf(z10));
    }

    public LelinkSourceSDK disableExternalAudio() {
        if (this.mILelinkSourceSdk != null) {
            setOption(IAPI.OPTION_EXTERNAL_AUDIO, Boolean.FALSE);
        }
        return this;
    }

    public LelinkSourceSDK disableExternalVideo() {
        if (this.mILelinkSourceSdk != null) {
            setOption(IAPI.OPTION_EXTERNAL_VIDEO, Boolean.FALSE);
        }
        return this;
    }

    public boolean disconnect(LelinkServiceInfo lelinkServiceInfo) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            return iLelinkSourceSDK.disconnect(lelinkServiceInfo);
        }
        return false;
    }

    public int dismissBrowserUI() {
        if (!LelinkConfig.isSupportDeviceList()) {
            return -1;
        }
        BrowserManager.getInstance().destroyView();
        return 0;
    }

    public int easyMirror(ViewGroup viewGroup) {
        if (!LelinkConfig.isSupportDeviceList()) {
            return -1;
        }
        BrowserManager.getInstance().startBrowse(true, true, viewGroup, false);
        return 0;
    }

    public int easyPush(ViewGroup viewGroup) {
        if (!LelinkConfig.isSupportDeviceList()) {
            return -1;
        }
        BrowserManager.getInstance().startBrowse(true, true, viewGroup, true);
        return 0;
    }

    public void enableCloudMultiCast(int i10) {
        setOption(IAPI.OPTION_CLOUD_MULTI_CAST, Integer.valueOf(i10));
    }

    public LelinkSourceSDK enableExternalAudio() {
        if (this.mILelinkSourceSdk != null) {
            setOption(IAPI.OPTION_EXTERNAL_AUDIO, Boolean.TRUE);
        }
        return this;
    }

    public LelinkSourceSDK enableExternalVideo() {
        if (this.mILelinkSourceSdk != null) {
            setOption(IAPI.OPTION_EXTERNAL_VIDEO, Boolean.TRUE);
        }
        return this;
    }

    public void enableHistoryDevice(boolean z10) {
        setOption(IAPI.OPTION_ENABLE_HISTORY_DEV, Boolean.valueOf(z10));
    }

    public void enableLogCache(boolean z10) {
        setOption(IAPI.OPTION_49, Boolean.valueOf(z10));
    }

    public void enableMirrorNotification(boolean z10) {
        setOption(IAPI.OPTION_MIRROR_NOTIFICATION, Boolean.valueOf(z10));
    }

    public void enableMultiChannel(boolean z10) {
        Object[] objArr = new Object[1];
        objArr[0] = z10 ? "1" : "0";
        setOption(IAPI.OPTION_MULTI_CHANNEL, objArr);
    }

    public void enableTempRestrict(boolean z10) {
        setOption(IAPI.OPTION_TEMP_RESTRICT, Boolean.valueOf(z10));
    }

    public String getAppID() {
        return this.mAppid;
    }

    public String getAppSecret() {
        return this.mAppSecret;
    }

    public List<LelinkServiceInfo> getConnectInfos() {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            return iLelinkSourceSDK.getConnectInfos();
        }
        return null;
    }

    public void getFavoriteDeviceList(int i10, int i11) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.getFavoriteDeviceList(i10, i11);
        }
    }

    public void getHistoryDeviceList(int i10, int i11) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.getHistoryDeviceList(i10, i11);
        }
    }

    public CommonDispatcher getListenerDispatcher() {
        return this.mListenerDispatcher;
    }

    public String getLogDir() {
        Object option = getInstance().getOption(IAPI.OPTION_GET_LOG_DIR, new Object[0]);
        if (option == null) {
            return null;
        }
        return option.toString();
    }

    public Object getOption(int i10, Object... objArr) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK == null) {
            return null;
        }
        Object option = iLelinkSourceSDK.getOption(i10, objArr);
        if (i10 == 1048626 && option == null) {
            return 0;
        }
        return option;
    }

    public void getReceiverProperties(IReceiverPropertiesCallback iReceiverPropertiesCallback) {
        if (iReceiverPropertiesCallback != null) {
            setOption(IAPI.OPTION_GET_RECEIVER_PROPERTIES, iReceiverPropertiesCallback);
        } else {
            SourceLog.i(TAG, "callback is null...");
        }
    }

    public String getSDKInfos(int i10) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        return iLelinkSourceSDK != null ? iLelinkSourceSDK.getSDKInfos(i10) : "";
    }

    public synchronized SourceTransceiver getTransceiver() {
        if (this.mTransceiver == null) {
            this.mTransceiver = new SourceTransceiver();
        }
        return this.mTransceiver;
    }

    public VirtualDisplay getVirtualDisplay() {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            return iLelinkSourceSDK.getVirtualDisplay();
        }
        return null;
    }

    public boolean isAccessibilityServiceStart(Context context) {
        return LelinkAccessibilityService.isServiceStart(context);
    }

    public boolean isBindSuccess() {
        return this.isBindSuccess;
    }

    public boolean isBrowseShowing() {
        if (LelinkConfig.isSupportDeviceList()) {
            return BrowserManager.getInstance().isShowing();
        }
        return false;
    }

    public boolean isMirroring() {
        Object option = getOption(IAPI.OPTION_IS_MIRRORING, new Object[0]);
        if (option != null && !TextUtils.isEmpty(option.toString())) {
            try {
                return Boolean.parseBoolean(option.toString());
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
        return false;
    }

    public boolean isSupportDanmaku(LelinkServiceInfo lelinkServiceInfo) {
        return checkForOption(IAPI.OPTION_63, lelinkServiceInfo);
    }

    public boolean isSupportGetReceiverProperties(LelinkServiceInfo lelinkServiceInfo) {
        return checkForOption(IAPI.OPTION_GET_RECEIVER_PROPERTIES, lelinkServiceInfo);
    }

    public boolean isSupportMultiChannel(LelinkServiceInfo lelinkServiceInfo) {
        Object option = getOption(IAPI.OPTION_QUERY_SUPPORT_MULTI_CHANNEL, lelinkServiceInfo);
        if (option != null && !TextUtils.isEmpty(option.toString())) {
            try {
                return Boolean.parseBoolean(option.toString());
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
        return false;
    }

    public boolean isSupportPlayList(LelinkServiceInfo lelinkServiceInfo) {
        Object option = getOption(IAPI.OPTION_QUERY_SUPPORT_URL_LIST, lelinkServiceInfo);
        if (option != null && !TextUtils.isEmpty(option.toString())) {
            try {
                return Boolean.parseBoolean(option.toString());
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
        return false;
    }

    public boolean isSupportQueryRate(LelinkServiceInfo lelinkServiceInfo) {
        return checkForOption(IAPI.OPTION_37, lelinkServiceInfo);
    }

    public boolean isSupportRate(LelinkServiceInfo lelinkServiceInfo) {
        return checkForOption(IAPI.OPTION_35, lelinkServiceInfo);
    }

    public boolean isSupportReverseControl(LelinkServiceInfo lelinkServiceInfo) {
        Object option = getOption(IAPI.OPTION_QUERY_SUPPORT_REVERSE_CONTROL, lelinkServiceInfo);
        if (option != null && !TextUtils.isEmpty(option.toString())) {
            try {
                return Boolean.parseBoolean(option.toString());
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
        return false;
    }

    public boolean isSupportSetReceiverProperties(LelinkServiceInfo lelinkServiceInfo) {
        return checkForOption(IAPI.OPTION_SET_RECEIVER_PROPERTY, lelinkServiceInfo);
    }

    public boolean isSupportTempRestrict(LelinkServiceInfo lelinkServiceInfo) {
        return checkForOption(IAPI.OPTION_TEMP_RESTRICT, lelinkServiceInfo);
    }

    public boolean isSupportTrack(LelinkServiceInfo lelinkServiceInfo) {
        Object option = getOption(IAPI.OPTION_QUERY_SUPPORT_TRACK, lelinkServiceInfo);
        if (option != null && !TextUtils.isEmpty(option.toString())) {
            try {
                return Boolean.parseBoolean(option.toString());
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
        return false;
    }

    public void pause() {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.pause();
        }
    }

    public void playDrama(String str) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setOption(IAPI.OPTION_SET_DRAMA_ID, str);
        }
    }

    public void playNextDrama() {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setOption(IAPI.OPTION_PLAY_NEXT_DRAMA, new Object[0]);
        }
    }

    public void playPreDrama() {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setOption(IAPI.OPTION_PLAY_PRE_DRAMA, new Object[0]);
        }
    }

    public void queryRate() {
        setOption(IAPI.OPTION_37, new Object[0]);
    }

    public void registerSinkKeyEvent() {
        if (this.mILelinkSourceSdk != null) {
            setOption(IAPI.OPTION_REGISTER_SINK_KEY_EVENT, Boolean.TRUE);
        }
    }

    public void registerSinkTouchEvent() {
        if (this.mILelinkSourceSdk != null) {
            setOption(IAPI.OPTION_REGISTER_SINK_TOUCH_EVENT, Boolean.TRUE);
        }
    }

    public void removeFavoriteDevice(List<LelinkServiceInfo> list) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.removeFavoriteDevice(list);
        }
    }

    public void removeHistoryDevice(List<LelinkServiceInfo> list, int i10) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.removeHistoryDevice(list, i10);
        }
    }

    public void resume() {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.resume();
        }
    }

    public void seekTo(int i10) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.seekTo(i10);
        }
    }

    public void selectTrack(int i10) {
        setOption(IAPI.OPTION_SELECT_TRACK, "" + i10);
    }

    public void sendDanmaku(DanmakuBean danmakuBean) {
        ILelinkSourceSDK iLelinkSourceSDK;
        if (danmakuBean == null || (iLelinkSourceSDK = this.mILelinkSourceSdk) == null) {
            return;
        }
        iLelinkSourceSDK.setOption(IAPI.OPTION_63, danmakuBean);
    }

    public void sendDanmakuProperty(DanmakuPropertyBean danmakuPropertyBean) {
        ILelinkSourceSDK iLelinkSourceSDK;
        if (danmakuPropertyBean == null || (iLelinkSourceSDK = this.mILelinkSourceSdk) == null) {
            return;
        }
        iLelinkSourceSDK.setOption(IAPI.OPTION_64, danmakuPropertyBean);
    }

    public LelinkSourceSDK setBindSdkListener(IBindSdkListener iBindSdkListener) {
        this.mAppBindSdkListener = iBindSdkListener;
        return this;
    }

    public void setBleBrowseStateListener(IBleBrowseStateListener iBleBrowseStateListener) {
        this.mBleBrowseStateListener = iBleBrowseStateListener;
    }

    public LelinkSourceSDK setBrowseResultListener(IBrowseListener iBrowseListener) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setBrowseResultListener(iBrowseListener);
        } else {
            this.mIBrowseListener = iBrowseListener;
        }
        return this;
    }

    public void setCacheList(List<ShortMediaBean> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<ShortMediaBean> it = list.iterator();
        while (it.hasNext()) {
            JSONObject json = ShortMediaBean.toJSON(it.next());
            if (json != null) {
                jSONArray.put(json);
            }
        }
        setOption(IAPI.OPTION_CACHE_LIST, jSONArray.toString());
    }

    public void setConnectDeviceReport(boolean z10) {
        HistoryConfigBean historyConfigBean = new HistoryConfigBean();
        historyConfigBean.isReport = z10;
        setConnectDeviceReport(historyConfigBean);
    }

    public LelinkSourceSDK setConnectListener(IConnectListener iConnectListener) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setConnectListener(iConnectListener);
        } else {
            this.mConnectListener = iConnectListener;
        }
        return this;
    }

    public LelinkSourceSDK setDaPlayListener(IDaPlayerListener iDaPlayerListener) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setDaPlayListener(iDaPlayerListener);
        } else {
            this.mDaPlayerListener = iDaPlayerListener;
        }
        return this;
    }

    public LelinkSourceSDK setDebugAVListener(IDebugAVListener iDebugAVListener) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setDebugAVListener(iDebugAVListener);
        } else {
            this.mDebugAVListener = iDebugAVListener;
        }
        return this;
    }

    public LelinkSourceSDK setDebugMode(boolean z10) {
        try {
            SourceLog.i(TAG, "setDebugMode," + z10);
            this.mILelinkSourceSdk.setDebugMode(z10);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        return this;
    }

    public LelinkSourceSDK setDebugTimestamp(boolean z10) {
        try {
            this.mILelinkSourceSdk.setDebugTimestamp(z10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return this;
    }

    public int setEasyCastListener(IEasyCastListener iEasyCastListener) {
        if (!LelinkConfig.isSupportDeviceList()) {
            return -1;
        }
        BrowserManager.getInstance().setEasyCastListener(iEasyCastListener);
        return 0;
    }

    public void setFavoriteDeviceAlias(LelinkServiceInfo lelinkServiceInfo, String str) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setFavoriteDeviceAlias(lelinkServiceInfo, str);
        }
    }

    public void setFavoriteDeviceListener(IFavoriteDeviceListener iFavoriteDeviceListener) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setFavoriteDeviceListener(iFavoriteDeviceListener);
        }
    }

    public void setHistoryDeviceListener(IHistoryDeviceListener iHistoryDeviceListener) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setHistoryDeviceListener(iHistoryDeviceListener);
        }
    }

    public LelinkSourceSDK setLogCallback(ILogCallback iLogCallback) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setLogCallback(iLogCallback);
        }
        return this;
    }

    public void setMirrorChangeListener(IMirrorChangeListener iMirrorChangeListener) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setMirrorChangeListener(iMirrorChangeListener);
        }
    }

    public void setMirrorNotificationType(int i10) {
        setOption(IAPI.OPTION_MIRROR_NOTIFY_TYPE, Integer.valueOf(i10));
    }

    public void setMirrorRotation(int i10, boolean z10) {
        setOption(IAPI.OPTION_MIRROR_ROTATION, Integer.valueOf(i10), Boolean.valueOf(z10));
    }

    public void setMirrorScreenSecret(boolean z10) {
        setOption(IAPI.OPTION_MIRROR_SCREEN_SECRET, Boolean.valueOf(z10));
    }

    public LelinkSourceSDK setNewPlayListener(INewPlayerListener iNewPlayerListener) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setNewPlayListener(iNewPlayerListener);
        } else {
            this.mNewPlayerListener = iNewPlayerListener;
        }
        return this;
    }

    public void setOnSinkPreparedListener(ISinkPreparedListener iSinkPreparedListener) {
        getListenerDispatcher().setOnSinkPreparedListener(iSinkPreparedListener);
    }

    public void setOption(int i10, Object... objArr) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setOption(i10, objArr);
        }
    }

    public void setOverlayPermission(int i10) {
        setOption(IAPI.OPTION_OVERLAY_PERMISSION, "" + i10);
    }

    public void setPassThroughListener(IRelevantInfoListener iRelevantInfoListener) {
        setOption(IAPI.SET_PASSTHROUGH_LISTENER, iRelevantInfoListener);
    }

    public void setPermissionMode(int i10, String str) {
        setOption(IAPI.OPTION_PERMISSION_MODE, Integer.valueOf(i10), str);
    }

    public LelinkSourceSDK setPlayListener(ILelinkPlayerListener iLelinkPlayerListener) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setPlayListener(iLelinkPlayerListener);
        } else {
            this.mPlayerListener = iLelinkPlayerListener;
        }
        return this;
    }

    public void setRate(float f10) {
        if (f10 == 0.5f || f10 == 0.75f || f10 == 1.0f || f10 == 1.25f || f10 == 1.5f || f10 == 2.0f) {
            setOption(IAPI.OPTION_35, Float.valueOf(f10));
        } else {
            SourceLog.i(TAG, "Invalid rate value");
        }
    }

    public void setReceiverProperty(ReceiverPropertyAction receiverPropertyAction, ReceiverPropertyValue receiverPropertyValue) {
        if (receiverPropertyAction == null || receiverPropertyValue == null) {
            SourceLog.i(TAG, "value is null...");
            return;
        }
        setOption(IAPI.OPTION_SET_RECEIVER_PROPERTY, new ReceiverPropertyBean(receiverPropertyAction.getValue(), new String[]{receiverPropertyValue.getValue() + ""}));
    }

    public LelinkSourceSDK setSdkInitInfo(Context context, String str, String str2) {
        this.mContext = context;
        this.mAppid = str;
        this.mAppSecret = str2;
        return this;
    }

    public void setSearchBannerDataCallback(ISearchBannerDataCallback iSearchBannerDataCallback) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setSearchBannerDataCallback(iSearchBannerDataCallback);
        }
    }

    public void setSendPassCallback(ISendPassCallback iSendPassCallback) {
        this.mPassCallback = iSendPassCallback;
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setSendPassCallback(iSendPassCallback);
        }
    }

    public void setSinkKeyEventListener(ISinkKeyEventListener iSinkKeyEventListener) {
        this.mSinkKeyEventListener = iSinkKeyEventListener;
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setSinkKeyEventListener(iSinkKeyEventListener);
        }
    }

    public void setSinkTouchEventListener(SinkTouchEventArea sinkTouchEventArea, float f10, ISinkTouchEventListener iSinkTouchEventListener) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setSinkTouchEventListener(sinkTouchEventArea, f10, iSinkTouchEventListener);
        }
    }

    public void setSourceID(String str) {
        setOption(IAPI.OPTION_SOURCE_ID, str);
    }

    @Deprecated
    public void setVolume(int i10) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setVolume(i10);
        }
    }

    public void setWatermarkInfo(WatermarkBean watermarkBean) {
        if (this.mILelinkSourceSdk != null) {
            setOption(IAPI.OPTION_MIRROR_WATERMARK_INFO, watermarkBean.toJson());
        }
    }

    public void setWatermarkVisible(boolean z10) {
        setOption(IAPI.OPTION_MIRROR_WATERMARK_SWITCH, Boolean.valueOf(z10));
    }

    public void startBrowse() {
        startBrowse(true, true);
    }

    public void startBrowseHistory(BrowserConfigBean browserConfigBean) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setOption(IAPI.OPTION_BROWSER_HISTORY, browserConfigBean.toJSON());
        }
    }

    @Deprecated
    public void startMirror(LelinkServiceInfo lelinkServiceInfo, boolean z10, boolean z11) {
        LelinkPlayerInfo lelinkPlayerInfo = new LelinkPlayerInfo();
        lelinkPlayerInfo.setMirrorAudioEnable(z10);
        lelinkPlayerInfo.setAutoBitrate(z11);
        lelinkPlayerInfo.setLelinkServiceInfo(lelinkServiceInfo);
        startMirror(lelinkPlayerInfo);
    }

    public void startOnlineCheck(IAPICallbackListener iAPICallbackListener, List<LelinkServiceInfo> list) {
        if (iAPICallbackListener == null || list == null || list.isEmpty()) {
            SourceLog.w(TAG, "startOnlineCheck ignore, invalid input");
        } else {
            setOption(IAPI.OPTION_3, iAPICallbackListener, list);
        }
    }

    public void startPlayMedia(String str, int i10, boolean z10) {
        SourceLog.i(TAG, "startPlayMedia path:" + str);
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.startPlayMedia(str, i10, z10);
        }
    }

    public void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, String str, int i10, boolean z10) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.startPlayMediaImmed(lelinkServiceInfo, str, i10, z10);
        }
    }

    public void stopBrowse() {
        this.mCallBrowseType = -1;
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.stopBrowse();
        }
    }

    public void stopPlay() {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.stopPlay();
        }
    }

    public void subVolume() {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.subVolume();
        }
    }

    public void switchMirror(int i10) {
        setOption(IAPI.OPTION_CHANGE_MIRROR, Integer.valueOf(i10));
    }

    public void unBindSdk() {
        SourceLog.w(TAG, "unBindSdk");
        try {
            this.mILelinkSourceSdk.unBindSdk();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        this.isBindSuccess = false;
        this.mCallBrowseType = -1;
    }

    public void unregisterSinkKeyEvent() {
        if (this.mILelinkSourceSdk != null) {
            setOption(IAPI.OPTION_REGISTER_SINK_KEY_EVENT, Boolean.FALSE);
        }
    }

    public void unregisterSinkTouchEvent() {
        if (this.mILelinkSourceSdk != null) {
            setOption(IAPI.OPTION_REGISTER_SINK_TOUCH_EVENT, Boolean.FALSE);
        }
    }

    public LelinkSourceSDK updateAudioData(byte[] bArr, AudioFrameBean audioFrameBean) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null && audioFrameBean != null) {
            iLelinkSourceSDK.updateAudioData(bArr, audioFrameBean);
        }
        return this;
    }

    public LelinkSourceSDK updatePCMData(int i10, int i11, int i12, byte[] bArr, int i13, int i14) {
        if (this.mILelinkSourceSdk != null) {
            AudioFrameBean audioFrameBean = new AudioFrameBean();
            audioFrameBean.sampleRate = i10;
            audioFrameBean.channel = i11;
            audioFrameBean.audioFormat = i12;
            audioFrameBean.offset = i13;
            audioFrameBean.length = i14;
            this.mILelinkSourceSdk.updateAudioData(bArr, audioFrameBean);
        }
        return this;
    }

    public LelinkSourceSDK updateVideoData(byte[] bArr, VideoFrameBean videoFrameBean) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null && videoFrameBean != null) {
            iLelinkSourceSDK.updateVideoData(bArr, videoFrameBean);
        }
        return this;
    }

    public void uploadLog(String str, String str2) {
        setOption(IAPI.OPTION_53, str, str2);
    }

    @Deprecated
    public boolean writeDeviceDataToNfcCard(Intent intent, String str) {
        return false;
    }

    @Deprecated
    public void addNfcTagToLelinkServiceInfo(Intent intent, IServiceInfoParseListener iServiceInfoParseListener) {
    }

    public void bindSdk(Context context, String str, String str2, IBindSdkListener iBindSdkListener) {
        bindSdk(context, str, str2, null, null, null, iBindSdkListener);
    }

    public void startBrowse(boolean z10, boolean z11) {
        if (!this.isBindSuccess) {
            SourceLog.w(TAG, "startBrowse ignore,waiting bind callback");
            this.mCallBrowseType = 1;
            this.useLelink = z10;
            this.useDlna = z11;
            return;
        }
        this.mCallBrowseType = -1;
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.startBrowse(z10, z11);
        }
    }

    @Deprecated
    public void addPinCodeToLelinkServiceInfo(String str, IParceResultListener iParceResultListener) {
        addPinCodeToLelinkServiceInfo(str, new DeprecatedParceResultListenerWrapper(iParceResultListener));
    }

    @Deprecated
    public void addQRCodeToLelinkServiceInfo(String str, IParceResultListener iParceResultListener) {
        addQRCodeToLelinkServiceInfo(str, new DeprecatedParceResultListenerWrapper(iParceResultListener));
    }

    public void bindSdk(Context context, String str, String str2, String str3, IBindSdkListener iBindSdkListener) {
        bindSdk(context, str, str2, null, null, str3, iBindSdkListener);
    }

    public void setSinkTouchEventListener(ISinkTouchEventListener iSinkTouchEventListener) {
        setSinkTouchEventListener(null, 0.0f, iSinkTouchEventListener);
    }

    public void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, Uri uri, int i10) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.startPlayMediaImmed(lelinkServiceInfo, uri, i10);
        }
    }

    public void bindSdk(Context context, String str, String str2, String str3, String str4, String str5, IBindSdkListener iBindSdkListener) {
        this.mAppBindSdkListener = iBindSdkListener;
        if (this.isBindSuccess) {
            SourceLog.i(TAG, "bindSdk ignore, already binded");
            IBindSdkListener iBindSdkListener2 = this.mAppBindSdkListener;
            if (iBindSdkListener2 != null) {
                iBindSdkListener2.onBindCallback(this.isBindSuccess);
                return;
            }
            return;
        }
        try {
            SourceLog.i(TAG, "start bind sdk");
            ILelinkSourceSDK loadSourceSDKImpl = ModuleLoader.loadSourceSDKImpl();
            this.mILelinkSourceSdk = loadSourceSDKImpl;
            loadSourceSDKImpl.bindSdk(context, str, str2, str3, str4, str5, this.mBindSdkListener);
            IBrowseListener iBrowseListener = this.mIBrowseListener;
            if (iBrowseListener != null) {
                this.mILelinkSourceSdk.setBrowseResultListener(iBrowseListener);
            }
            IConnectListener iConnectListener = this.mConnectListener;
            if (iConnectListener != null) {
                this.mILelinkSourceSdk.setConnectListener(iConnectListener);
            }
            ILelinkPlayerListener iLelinkPlayerListener = this.mPlayerListener;
            if (iLelinkPlayerListener != null) {
                this.mILelinkSourceSdk.setPlayListener(iLelinkPlayerListener);
            }
            INewPlayerListener iNewPlayerListener = this.mNewPlayerListener;
            if (iNewPlayerListener != null) {
                this.mILelinkSourceSdk.setNewPlayListener(iNewPlayerListener);
            }
            IDaPlayerListener iDaPlayerListener = this.mDaPlayerListener;
            if (iDaPlayerListener != null) {
                this.mILelinkSourceSdk.setDaPlayListener(iDaPlayerListener);
            }
            IDebugAVListener iDebugAVListener = this.mDebugAVListener;
            if (iDebugAVListener != null) {
                this.mILelinkSourceSdk.setDebugAVListener(iDebugAVListener);
            }
            ISinkKeyEventListener iSinkKeyEventListener = this.mSinkKeyEventListener;
            if (iSinkKeyEventListener != null) {
                this.mILelinkSourceSdk.setSinkKeyEventListener(iSinkKeyEventListener);
            }
            ISendPassCallback iSendPassCallback = this.mPassCallback;
            if (iSendPassCallback != null) {
                this.mILelinkSourceSdk.setSendPassCallback(iSendPassCallback);
            }
            this.mILelinkSourceSdk.setCommonListener(this.mListenerDispatcher);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void setConnectDeviceReport(HistoryConfigBean historyConfigBean) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.setOption(IAPI.OPTION_SET_CONNECT_DEVICE, historyConfigBean.toJSON());
        }
    }

    public LelinkSourceSDK setSdkInitInfo(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mAppid = str;
        this.mAppSecret = str2;
        this.mOaid = str3;
        return this;
    }

    public void setSinkTouchEventListener(SinkTouchEventArea sinkTouchEventArea, ISinkTouchEventListener iSinkTouchEventListener) {
        setSinkTouchEventListener(sinkTouchEventArea, 0.0f, iSinkTouchEventListener);
    }

    public void startPlayMedia(LelinkPlayerInfo lelinkPlayerInfo) {
        SourceLog.i(TAG, "startPlayMedia path:" + lelinkPlayerInfo.getUrl());
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.startPlayMedia(lelinkPlayerInfo);
        }
    }

    public void setSinkTouchEventListener(float f10, ISinkTouchEventListener iSinkTouchEventListener) {
        setSinkTouchEventListener(null, f10, iSinkTouchEventListener);
    }

    public void startMirror(LelinkPlayerInfo lelinkPlayerInfo) {
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null) {
            iLelinkSourceSDK.startMirror(lelinkPlayerInfo);
        } else {
            SourceLog.w(TAG, "startMirror ignore");
        }
    }

    public LelinkSourceSDK setSdkInitInfo(Context context, String str, String str2, String str3, String str4, String str5) {
        this.mContext = context;
        this.mAppid = str;
        this.mAppSecret = str2;
        this.mUserId = str3;
        this.mAppVersion = str4;
        this.mOaid = str5;
        return this;
    }

    public void startBrowse(BrowserConfigBean browserConfigBean) {
        BluetoothAdapter defaultAdapter;
        SourceLog.i(TAG, "startBrowse start");
        if (this.mBleBrowseStateListener != null && browserConfigBean.useBLE && ((defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null || !defaultAdapter.isEnabled())) {
            this.mBleBrowseStateListener.onBrowseResult(BleState.BLE_ADVERTISE_BT_TURNED_OFF);
        }
        if (!this.isBindSuccess) {
            SourceLog.w(TAG, "startBrowse ignore,waiting bind callback");
            this.mCallBrowseType = 2;
            this.mBrowseConfigBean = browserConfigBean;
            return;
        }
        ILelinkSourceSDK iLelinkSourceSDK = this.mILelinkSourceSdk;
        if (iLelinkSourceSDK != null && browserConfigBean != null) {
            this.mCallBrowseType = -1;
            iLelinkSourceSDK.setOption(IAPI.OPTION_BROWSER, browserConfigBean.toJSON());
        } else {
            SourceLog.w(TAG, "startBrowse ignore,waiting bind callback11");
        }
    }
}
