package com.hpplay.sdk.source.process;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.VirtualDisplay;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import anet.channel.util.HttpConstant;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.common.utils.EncryptUtil;
import com.hpplay.common.utils.FileUtil;
import com.hpplay.common.utils.NetworkUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.api.ICloudMirrorPlayListener;
import com.hpplay.sdk.source.api.ICommonListener;
import com.hpplay.sdk.source.api.IConnectListener;
import com.hpplay.sdk.source.api.IDaPlayerListener;
import com.hpplay.sdk.source.api.IDebugAVListener;
import com.hpplay.sdk.source.api.IFavoriteDeviceListener;
import com.hpplay.sdk.source.api.IHistoryDeviceListener;
import com.hpplay.sdk.source.api.ILelinkPlayerListener;
import com.hpplay.sdk.source.api.ILogCallback;
import com.hpplay.sdk.source.api.IMirrorChangeListener;
import com.hpplay.sdk.source.api.INewPlayerListener;
import com.hpplay.sdk.source.api.IReceiverPropertiesCallback;
import com.hpplay.sdk.source.api.IRelevantInfoListener;
import com.hpplay.sdk.source.api.ISearchBannerDataCallback;
import com.hpplay.sdk.source.api.ISendPassCallback;
import com.hpplay.sdk.source.api.ISinkKeyEventListener;
import com.hpplay.sdk.source.api.ISinkTouchEventListener;
import com.hpplay.sdk.source.api.IUploadLogQueryListener;
import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.api.PlayerListenerConstant;
import com.hpplay.sdk.source.bean.AudioFrameBean;
import com.hpplay.sdk.source.bean.BrowserConfigBean;
import com.hpplay.sdk.source.bean.DanmakuBean;
import com.hpplay.sdk.source.bean.DanmakuPropertyBean;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.HeicBean;
import com.hpplay.sdk.source.bean.HistoryConfigBean;
import com.hpplay.sdk.source.bean.MediaAssetBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.ReceiverPropertyBean;
import com.hpplay.sdk.source.bean.ServiceInfoParseBean;
import com.hpplay.sdk.source.bean.SinkParameterBean;
import com.hpplay.sdk.source.bean.SinkTouchEventArea;
import com.hpplay.sdk.source.bean.VideoFrameBean;
import com.hpplay.sdk.source.bean.VipAuthSetting;
import com.hpplay.sdk.source.browse.api.AuthListener;
import com.hpplay.sdk.source.browse.api.IAPI;
import com.hpplay.sdk.source.browse.api.IAPICallbackListener;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.ICreatePinCodeListener;
import com.hpplay.sdk.source.browse.api.ICreateShortUrlListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoListParseListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.api.OptionCentral;
import com.hpplay.sdk.source.business.BusinessEntity;
import com.hpplay.sdk.source.business.PlayController;
import com.hpplay.sdk.source.business.PublicCastClient;
import com.hpplay.sdk.source.business.cloud.AuthSDK;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.business.cloud.FavoriteDeviceManager;
import com.hpplay.sdk.source.business.cloud.HistoryDeviceManager;
import com.hpplay.sdk.source.business.cloud.LicenseManager;
import com.hpplay.sdk.source.business.cloud.RightsManager;
import com.hpplay.sdk.source.business.cloud.SDKConfig;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.config.LelinkConfig;
import com.hpplay.sdk.source.da.e;
import com.hpplay.sdk.source.device.Device;
import com.hpplay.sdk.source.device.DeviceCodeResolver;
import com.hpplay.sdk.source.device.ServiceUpdater;
import com.hpplay.sdk.source.localserver.LelinkServerInstance;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.mirror.yim.YimMirror;
import com.hpplay.sdk.source.mirror.yim.render.MirrorPlayerActivity;
import com.hpplay.sdk.source.pass.HarassCode;
import com.hpplay.sdk.source.pass.PassSender;
import com.hpplay.sdk.source.pass.sinkkey.SinkKeyEventDispatcher;
import com.hpplay.sdk.source.pass.sinktouch.SinkTouchEventDispatcher;
import com.hpplay.sdk.source.pass.sinktouch.SinkTouchEventMonitor;
import com.hpplay.sdk.source.permission.ContextCompat;
import com.hpplay.sdk.source.permission.OnRequestPermissionListener;
import com.hpplay.sdk.source.permission.PermissionBridgeActivity;
import com.hpplay.sdk.source.process.DevicePreChecker;
import com.hpplay.sdk.source.process.OnlineManager;
import com.hpplay.sdk.source.process.PushFailedRetryManager;
import com.hpplay.sdk.source.protocol.CaptureBridge;
import com.hpplay.sdk.source.protocol.browser.BrowserBridge;
import com.hpplay.sdk.source.protocol.browser.BrowserHistory;
import com.hpplay.sdk.source.protocol.browser.ble.BleProxy;
import com.hpplay.sdk.source.protocol.browser.sonic.SonicProxy;
import com.hpplay.sdk.source.protocol.connect.ConnectBridge;
import com.hpplay.sdk.source.transceiver.bean.NotifyMirrorBean;
import com.hpplay.sdk.source.utils.AppContextUtils;
import com.hpplay.sdk.source.utils.BrowseResultOnlineCheck;
import com.hpplay.sdk.source.utils.BrowserResolver;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.CrashHandler;
import com.hpplay.sdk.source.utils.CreateUtil;
import com.hpplay.sdk.source.utils.Feature;
import com.hpplay.sdk.source.utils.LeboUtil;
import com.hpplay.sdk.source.utils.LogUpload;
import com.hpplay.sdk.source.utils.UploadLogCallback;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LelinkSdkManager {
    private static final int DELAY_DELETE_HEIC_IMG = 60000;
    private static final int DELAY_NOTIFY_LIST = 500;
    private static final int DELAY_PUSH_FAILED_RESEARCH_DELAY_TIME = 5000;
    private static final int MAX_PLAY_LIST_SIZE = 100;
    private static final int PARSER_TYPE_CREATE_LELINK_SERVICE = 3;
    private static final int PARSER_TYPE_PINCODE = 2;
    private static final int PARSER_TYPE_QR = 1;
    private static final String TAG = "LelinkSdkManager";
    private static final int WHAT_DELAY_CAST = 3;
    private static final int WHAT_DELAY_DEVICE_OFFLINE = 4;
    private static final int WHAT_DELAY_NOTIFY_LIST = 1;
    private static final int WHAT_DELETE_HEIC_IMG = 2;
    private static boolean mIsFirstBrowser = true;
    private static LelinkSdkManager sInstance;
    private BrowserConfigBean mBrowserConfig;
    private BrowserThread mBrowserThread;
    private Context mContext;
    private DevicePreChecker mDevicePreChecker;
    private LelinkPlayerInfo mMirrorPlayInfo;
    private OnlineCheckThread mOnlineCheckThread;
    public ICloudMirrorPlayListener mOuterCloudMirrorPlayListener;
    public IMirrorChangeListener mOuterMirrorChangeListener;
    private IServiceInfoListParseListener mOuterParseListListener;
    private IServiceInfoParseListener mOuterParseListener;
    public IRelevantInfoListener mOuterRelevantInfoListener;
    public ISendPassCallback mPassCallback;
    public IReceiverPropertiesCallback mReceiverPropertiesCallback;
    public ISearchBannerDataCallback mSearchBannerDataCallback;
    private final AtomicBoolean mRetryMirrorOnce = new AtomicBoolean(false);
    private Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                LelinkSdkManager.this.notifyBrowseList();
            } else if (i10 == 2) {
                SourceLog.i(LelinkSdkManager.TAG, "msg, delete heic img");
                final String str = (String) message.obj;
                AsyncManager.getInstance().exeRunnable(new Runnable() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }, null);
            } else if (i10 == 3) {
                SourceLog.i(LelinkSdkManager.TAG, "msg, heic img delay cast");
                HeicBean heicBean = (HeicBean) message.obj;
                if (heicBean == null) {
                    SourceLog.w(LelinkSdkManager.TAG, "value is invalid");
                    return false;
                }
                LelinkSdkManager.this.dispatchPlayMedia(heicBean.lelinkServiceInfo, heicBean.lelinkPlayerInfo, heicBean.path, heicBean.type);
            } else if (i10 == 4 && BusinessEntity.getInstance().getListenerDispatcher() != null) {
                OutParameter outParameter = new OutParameter();
                Object obj = message.obj;
                if (obj != null) {
                    outParameter = (OutParameter) obj;
                }
                BusinessEntity.getInstance().getListenerDispatcher().onError(outParameter, 210010, 210004, " pre check offline ");
            }
            return false;
        }
    });
    public long mAuthSuccessTime = -1;
    public int mExpireTime = 0;
    private long mPreBrowserTime = 0;
    private long mBrowserTimeStamp = -1;
    private Activity mExpandActivity = null;
    private View mExpandView = null;
    private SecondMirrorView mSecondMirrorView = null;
    private IServiceInfoParseListener mOwnerParseListener = new IServiceInfoParseListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.2
        @Override // com.hpplay.sdk.source.browse.api.IServiceInfoParseListener
        public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
            if (LelinkSdkManager.this.mOuterParseListener != null) {
                LelinkSdkManager.this.mOuterParseListener.onParseResult(i10, BrowserResolver.updateServiceList(lelinkServiceInfo));
            }
        }
    };
    private IServiceInfoListParseListener mOwnerParseListListener = new IServiceInfoListParseListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.3
        @Override // com.hpplay.sdk.source.browse.api.IServiceInfoListParseListener
        public void onParseResult(List<ServiceInfoParseBean> list) {
            if (LelinkSdkManager.this.mOuterParseListListener != null) {
                BrowserResolver.updateParseServiceList(list);
                LelinkSdkManager.this.mOuterParseListListener.onParseResult(list);
            }
        }
    };
    private IServiceInfoParseListener mOwnerSonicPinParseListener = new IServiceInfoParseListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.4
        @Override // com.hpplay.sdk.source.browse.api.IServiceInfoParseListener
        public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
            BrowserResolver.updateServiceList(lelinkServiceInfo);
        }
    };
    private IServiceInfoParseListener mOwnerBlueToothListener = new IServiceInfoParseListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.5
        @Override // com.hpplay.sdk.source.browse.api.IServiceInfoParseListener
        public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
            BrowserResolver.updateServiceList(lelinkServiceInfo);
        }
    };
    private IServiceInfoParseListener mOwnerHistoryListener = new IServiceInfoParseListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.6
        @Override // com.hpplay.sdk.source.browse.api.IServiceInfoParseListener
        public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
            BrowserResolver.updateServiceList(lelinkServiceInfo);
        }
    };
    private NetworkReceiver mNetworkChangeReceiver = null;
    private TimeTickReceiver mTimeTickReceiver = null;
    public OnRequestPermissionListener mPermissionListener = null;
    private AuthListener mOuterAuthListener = null;
    private AuthListener mOwnerAuthListener = new AuthListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.7
        @Override // com.hpplay.sdk.source.browse.api.AuthListener
        public void onAuthFailed(int i10) {
            Session.getInstance().isFirstBoot = false;
            if (LelinkSdkManager.this.mOuterAuthListener != null) {
                LelinkSdkManager.this.mOuterAuthListener.onAuthFailed(i10);
            }
        }

        @Override // com.hpplay.sdk.source.browse.api.AuthListener
        public void onAuthSuccess(String str, String str2) {
            Session.getInstance().isFirstBoot = false;
            if (LelinkSdkManager.this.mOuterAuthListener != null) {
                LelinkSdkManager.this.mOuterAuthListener.onAuthSuccess(str, str2);
            }
            LelinkSdkManager.this.mAuthSuccessTime = System.currentTimeMillis();
            try {
                LelinkSdkManager.this.mExpireTime = new JSONObject(str2).getJSONObject("data").getInt("expire_time");
                SourceLog.i(LelinkSdkManager.TAG, "onAuthSuccess: expireTime =" + LelinkSdkManager.this.mExpireTime);
            } catch (Exception e10) {
                SourceLog.w(LelinkSdkManager.TAG, e10);
            }
        }
    };
    private BrowserDispatcher mBrowserDispatcher = new BrowserDispatcher();

    public static class CheckConnectListener implements IConnectListener {
        private final ConnectCallback callback;
        private final boolean isGroup;
        private final LelinkServiceInfo mServiceInfo;

        public CheckConnectListener(LelinkServiceInfo lelinkServiceInfo, ConnectCallback connectCallback, boolean z10) {
            this.mServiceInfo = lelinkServiceInfo;
            this.callback = connectCallback;
            this.isGroup = z10;
        }

        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onConnect(LelinkServiceInfo lelinkServiceInfo, int i10) {
            LelinkServiceInfo lelinkServiceInfo2 = this.mServiceInfo;
            if (lelinkServiceInfo2 == null || lelinkServiceInfo == null || !lelinkServiceInfo.equals(lelinkServiceInfo2)) {
                SourceLog.i(LelinkSdkManager.TAG, "CheckConnectListener  onConnect, ignore ");
                return;
            }
            SourceLog.i(LelinkSdkManager.TAG, "CheckConnectListener  onConnect");
            this.callback.onConnect(i10, this.isGroup);
            ConnectManager.getInstance().removeConnectCheckListener(this);
        }

        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
            SourceLog.i(LelinkSdkManager.TAG, "onDisconnect");
        }
    }

    public interface ConnectCallback {
        void onConnect(int i10, boolean z10);
    }

    public class DevicePreCheckCallback implements DevicePreChecker.OnDevicePreCheckResultCallback {
        private LelinkPlayerInfo lelinkPlayerInfo;

        public DevicePreCheckCallback(LelinkPlayerInfo lelinkPlayerInfo) {
            this.lelinkPlayerInfo = lelinkPlayerInfo;
        }

        @Override // com.hpplay.sdk.source.process.DevicePreChecker.OnDevicePreCheckResultCallback
        public void onResult(LelinkServiceInfo lelinkServiceInfo, int i10) {
            try {
                SourceLog.i(LelinkSdkManager.TAG, "DevicePreCheckCallback : " + i10);
                if (i10 == 0 || i10 == 2) {
                    ConnectManager.getInstance().disconnect(lelinkServiceInfo);
                }
                LelinkSdkManager lelinkSdkManager = LelinkSdkManager.this;
                LelinkPlayerInfo lelinkPlayerInfo = this.lelinkPlayerInfo;
                OutParameter outParameter = lelinkSdkManager.getOutParameter(lelinkServiceInfo, lelinkPlayerInfo, lelinkPlayerInfo.getUrl(), this.lelinkPlayerInfo.getType());
                if (i10 != 0) {
                    this.lelinkPlayerInfo.setLelinkServiceInfo(lelinkServiceInfo);
                    LelinkSdkManager.this.startPlay(this.lelinkPlayerInfo);
                } else if (!NetworkUtil.isWifiConnected(LelinkSdkManager.this.mContext)) {
                    LelinkSdkManager.this.mHandler.sendMessageDelayed(Message.obtain(null, 4, outParameter), 5000L);
                } else {
                    PushFailedRetryManager.getInstance().connectFailedRetry(lelinkServiceInfo, new PushFailedRetryManager.ConnectRetryListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.DevicePreCheckCallback.1
                        @Override // com.hpplay.sdk.source.process.PushFailedRetryManager.ConnectRetryListener
                        public void onLelinkServiceInfoCallback(LelinkServiceInfo lelinkServiceInfo2) {
                            LelinkSdkManager.this.mHandler.removeMessages(4);
                            DevicePreCheckCallback.this.lelinkPlayerInfo.setLelinkServiceInfo(lelinkServiceInfo2);
                            DevicePreCheckCallback devicePreCheckCallback = DevicePreCheckCallback.this;
                            LelinkSdkManager.this.startPlay(devicePreCheckCallback.lelinkPlayerInfo);
                            PushFailedRetryManager.getInstance().stopRetry();
                        }
                    });
                    LelinkSdkManager.this.mHandler.sendMessageDelayed(Message.obtain(null, 4, outParameter), 5000L);
                }
            } catch (Exception e10) {
                SourceLog.w(LelinkSdkManager.TAG, e10);
            }
        }
    }

    private LelinkSdkManager() {
    }

    private void bleBrowse() {
        if (1 == LelinkConfig.isBrowserBlueToothEnable(this.mContext)) {
            SourceLog.i(TAG, "bleBrowse");
            BleProxy.setServiceInfoParseListener(this.mOwnerBlueToothListener);
            if (BleProxy.startBrowse(this.mContext)) {
                BrowserHistory.getInstance().startBLEBrowser();
            }
        } else {
            SourceLog.i(TAG, "bleBrowse ignore");
        }
        if (1 != LelinkConfig.isPublishBlueToothEnable(this.mContext)) {
            SourceDataReport.getInstance().onBlePublish(0, null);
            return;
        }
        if (PublicCastClient.getInstance().isConnectedServer()) {
            SourceLog.i(TAG, "bleBrowse startPublish");
            BleProxy.startPublish(this.mContext, Preference.getInstance().get(Preference.KEY_DEVICE_ID));
        } else {
            PublicCastClient.getInstance().connectServer(CloudAPI.sImServer, a.a(), null);
        }
        ServiceUpdater.getInstance().updateServiceInfo(this.mContext);
    }

    private boolean canDisableDLNA() {
        return Feature.isMUIChannel() || Feature.isKangka() || Feature.isOPPOChannel() || Feature.isVivoChannel() || Feature.isSmartis() || Feature.isNubiaChannel() || Feature.isYoulexueChannel() || Feature.isLeboApp() || Feature.isHweiChannel() || Feature.isHappyTest();
    }

    private boolean canReverseControl() {
        if (Feature.isLeboApp()) {
            return true;
        }
        SourceLog.i(TAG, "canReverseControl " + LelinkConfig.isReverseControlEnable());
        return LelinkConfig.isReverseControlEnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkConnect(LelinkServiceInfo lelinkServiceInfo, ConnectCallback connectCallback, boolean z10) {
        if (lelinkServiceInfo == null) {
            SourceLog.w(TAG, "checkConnect ignore, serviceInfo is null");
            return;
        }
        SourceLog.w(TAG, "checkConnect " + z10);
        if (ConnectManager.getInstance().getConnectSession(lelinkServiceInfo, z10) != null) {
            SourceLog.i(TAG, "checkConnect: connect inner " + lelinkServiceInfo.getName() + Operator.Operation.DIVISION + lelinkServiceInfo.getIp());
            ConnectManager.getInstance().resetLastConnectBridge(lelinkServiceInfo);
            int connectProtocol = ConnectManager.getInstance().getConnectProtocol(lelinkServiceInfo);
            SourceLog.i(TAG, "connectProtocol : " + connectProtocol);
            if (connectProtocol != -1) {
                SourceLog.i(TAG, " do onConnect callback : " + connectProtocol);
                connectCallback.onConnect(connectProtocol, z10);
                return;
            }
            SourceLog.i(TAG, "checkConnect: has no valid protocol " + lelinkServiceInfo.getName() + Operator.Operation.DIVISION + lelinkServiceInfo.getIp());
            ConnectManager.getInstance().removeBridge(lelinkServiceInfo);
            SourceLog.i(TAG, "checkConnect: connect inner " + lelinkServiceInfo.getName() + Operator.Operation.DIVISION + lelinkServiceInfo.getIp());
        }
        ConnectManager.getInstance().setConnectCheckListener(new CheckConnectListener(lelinkServiceInfo, connectCallback, z10));
        ConnectManager.getInstance().connect(this.mContext, lelinkServiceInfo, z10);
    }

    private void checkDevice(LelinkServiceInfo lelinkServiceInfo, final ConnectCallback connectCallback, final boolean z10) {
        LelinkServiceInfo findSameServiceInfo = findSameServiceInfo(lelinkServiceInfo);
        if (!z10 ? ConnectManager.getInstance().checkOnline(findSameServiceInfo, new OnlineManager.OnlineListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.14
            @Override // com.hpplay.sdk.source.process.OnlineManager.OnlineListener
            public void OnLineCheckResult(LelinkServiceInfo lelinkServiceInfo2, boolean z11) {
                if (z11) {
                    LelinkSdkManager.this.checkConnect(lelinkServiceInfo2, connectCallback, z10);
                } else {
                    ConnectManager.getInstance().notifyInvalid(lelinkServiceInfo2);
                }
            }
        }) : false) {
            return;
        }
        checkConnect(findSameServiceInfo, connectCallback, z10);
    }

    private void checkLicense(final LicenseManager.ILicenseCheckListener iLicenseCheckListener) {
        if (LelinkConfig.isSdkFree()) {
            iLicenseCheckListener.checkLicense(true);
        } else if (LelinkConfig.isLicenseMode()) {
            LicenseManager.getInstance().checkLicense(new LicenseManager.ILicenseCheckListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.9
                @Override // com.hpplay.sdk.source.business.cloud.LicenseManager.ILicenseCheckListener
                public void checkLicense(boolean z10) {
                    iLicenseCheckListener.checkLicense(z10);
                }
            });
        } else {
            SourceLog.e(TAG, "checkLicense ignore, sdk is not free, do you forget to set permission mode?");
        }
    }

    private void createListBySinkServer(List<SinkParameterBean> list) {
        final ArrayList arrayList = new ArrayList();
        for (final SinkParameterBean sinkParameterBean : list) {
            Device.createBySinkServer(sinkParameterBean.ip, sinkParameterBean.port, new IServiceInfoParseListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.17
                @Override // com.hpplay.sdk.source.browse.api.IServiceInfoParseListener
                public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
                    String str = sinkParameterBean.uid;
                    if (str == null) {
                        str = null;
                    }
                    arrayList.add(new ServiceInfoParseBean(i10, str, lelinkServiceInfo));
                    LelinkSdkManager.this.mOwnerParseListListener.onParseResult(arrayList);
                }
            });
        }
    }

    private void deleteHeicFileDir() {
        SourceLog.i(TAG, "deleteHeicFileDir");
        AsyncManager.getInstance().exeRunnable(new Runnable() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.22
            @Override // java.lang.Runnable
            public void run() {
                String heicDirPath = LelinkServerInstance.getInstance().getHeicDirPath();
                if (TextUtils.isEmpty(heicDirPath)) {
                    return;
                }
                FileUtil.deleteFile(heicDirPath);
            }
        }, null);
    }

    private void dispatchMirror(Intent intent, LelinkPlayerInfo lelinkPlayerInfo, boolean z10, boolean z11) {
        View view;
        SourceLog.w(TAG, "dispatchMirror ,mirrorIntent:" + intent);
        if (lelinkPlayerInfo == null) {
            SourceLog.w(TAG, "dispatchMirror ignore,invalid playerInfo");
            if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                BusinessEntity.getInstance().getListenerDispatcher().onError(null, 211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_INVALID_INPUT);
                return;
            }
            return;
        }
        OutParameter outParameter = new OutParameter();
        outParameter.castType = 2;
        outParameter.mimeType = 102;
        outParameter.mirrorIntent = intent;
        outParameter.originPlayerInfo = lelinkPlayerInfo;
        outParameter.isMultiCast = z11;
        if (lelinkPlayerInfo.getLelinkServiceInfo() == null) {
            outParameter.serviceInfo = ConnectManager.getInstance().getLastServiceInfo();
        } else {
            LelinkServiceInfo findSameServiceInfo = findSameServiceInfo(lelinkPlayerInfo.getLelinkServiceInfo());
            lelinkPlayerInfo.setLelinkServiceInfo(findSameServiceInfo);
            outParameter.serviceInfo = findSameServiceInfo;
        }
        if (outParameter.serviceInfo == null) {
            SourceLog.w(TAG, "dispatchMirror ignore,invalid service info");
            if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                BusinessEntity.getInstance().getListenerDispatcher().onError(null, 211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_INVALID_INPUT);
                return;
            }
            return;
        }
        SourceLog.i(TAG, "dispatchMirror " + outParameter.serviceInfo.getName() + " / " + lelinkPlayerInfo.getMirrorSendTimeout());
        outParameter.mirrorResLevel = lelinkPlayerInfo.getResolutionLevel();
        outParameter.mirrorBitRateLevel = lelinkPlayerInfo.getBitRateLevel();
        outParameter.mirrorAudioType = lelinkPlayerInfo.getMirrorAudioType();
        outParameter.requestAudioFocus = lelinkPlayerInfo.isRequestAudioFocus();
        outParameter.fullScreenType = lelinkPlayerInfo.getFullScreen();
        outParameter.isAutoBitrate = lelinkPlayerInfo.isAutoBitrate();
        outParameter.session = getSessionId(outParameter.serviceInfo);
        outParameter.urlID = CreateUtil.createMirrorUri();
        outParameter.mirrorSendTimeout = lelinkPlayerInfo.getMirrorSendTimeout();
        outParameter.isExpandMirror = z10;
        if (z10) {
            Activity activity = this.mExpandActivity;
            if (activity == null || (view = this.mExpandView) == null) {
                SourceLog.w(TAG, "dispatchMirror ExpansionScreen ignore");
                if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                    BusinessEntity.getInstance().getListenerDispatcher().onError(null, 211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_INVALID_INPUT);
                    return;
                }
                return;
            }
            outParameter.expandActivity = activity;
            outParameter.expandView = view;
            outParameter.secondMirrorView = this.mSecondMirrorView;
        }
        outParameter.isGroup = CastUtil.isSupportMultiChannel(outParameter.serviceInfo);
        outParameter.password = lelinkPlayerInfo.getCastPwd();
        checkDevice(outParameter.serviceInfo, new MirrorConnectCallback(this.mContext, outParameter, lelinkPlayerInfo), outParameter.isGroup);
        CastUtil.printSDKInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPlayMedia(LelinkServiceInfo lelinkServiceInfo, LelinkPlayerInfo lelinkPlayerInfo, String str, int i10) {
        OutParameter outParameter = getOutParameter(lelinkServiceInfo, lelinkPlayerInfo, str, i10);
        if (outParameter == null) {
            return;
        }
        checkDevice(outParameter.serviceInfo, new PushConnectCallback(this.mContext, outParameter, lelinkPlayerInfo, lelinkServiceInfo), false);
        CastUtil.printSDKInfo();
        SourceLog.i(TAG, "startPlayMedia " + outParameter.getPlayUrl());
    }

    private void enableLog(boolean z10) {
        SourceLog.i(TAG, "enableLog," + z10);
        if (this.mContext == null) {
            SourceLog.i(TAG, "enableLog,value is invalid");
            return;
        }
        if (z10) {
            if (Feature.isLeboApp() || Feature.isHappyTest()) {
                SourceLog.enableLogWriter(this.mContext.getApplicationContext(), 100);
            } else {
                SourceLog.enableLogWriter(this.mContext.getApplicationContext(), 1);
            }
        } else if (Feature.isLeboApp() || Feature.isHappyTest()) {
            SourceLog.disableLog(this.mContext.getApplicationContext(), 100);
        } else {
            SourceLog.disableLog(this.mContext.getApplicationContext(), 1);
        }
        CLog.enableTrace(z10);
    }

    private LelinkServiceInfo findSameServiceInfo(LelinkServiceInfo lelinkServiceInfo) {
        if (lelinkServiceInfo == null || this.mBrowserDispatcher.getBrowserList() == null) {
            SourceLog.i(TAG, "findSameServiceInfo ignore " + lelinkServiceInfo + "\n" + this.mBrowserDispatcher.getBrowserList());
            return lelinkServiceInfo;
        }
        try {
            for (LelinkServiceInfo lelinkServiceInfo2 : this.mBrowserDispatcher.getBrowserList()) {
                if (lelinkServiceInfo2.equals(lelinkServiceInfo)) {
                    return lelinkServiceInfo2;
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        SourceLog.w(TAG, "not findSameServiceInfo, use outside info " + lelinkServiceInfo);
        return lelinkServiceInfo;
    }

    public static synchronized LelinkSdkManager getInstance() {
        LelinkSdkManager lelinkSdkManager;
        synchronized (LelinkSdkManager.class) {
            synchronized (LelinkSdkManager.class) {
                if (sInstance == null) {
                    sInstance = new LelinkSdkManager();
                }
                lelinkSdkManager = sInstance;
            }
            return lelinkSdkManager;
        }
        return lelinkSdkManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OutParameter getOutParameter(LelinkServiceInfo lelinkServiceInfo, LelinkPlayerInfo lelinkPlayerInfo, String str, int i10) {
        OutParameter outParameter = new OutParameter();
        outParameter.setUrl(str);
        if (lelinkPlayerInfo != null) {
            outParameter.urls = lelinkPlayerInfo.getUrlList();
            outParameter.period = lelinkPlayerInfo.getPeriod();
            outParameter.headLength = lelinkPlayerInfo.getHeadDuration();
            outParameter.tailLength = lelinkPlayerInfo.getTailDuration();
            String dramaID = lelinkPlayerInfo.getDramaID();
            outParameter.dramaID = dramaID;
            DramaInfoBean[] dramaInfoBeanArr = outParameter.urls;
            if (dramaInfoBeanArr != null && dramaInfoBeanArr.length > 0 && (TextUtils.isEmpty(dramaID) || outParameter.urls.length > 100)) {
                if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                    BusinessEntity.getInstance().getListenerDispatcher().onError(null, 210000, 100000);
                }
                return null;
            }
        }
        SourceLog.i(TAG, "startPlayMedia " + outParameter.getPlayUrl());
        outParameter.mimeType = i10;
        outParameter.castType = 1;
        outParameter.originPlayerInfo = lelinkPlayerInfo;
        outParameter.serviceInfo = lelinkServiceInfo;
        if (lelinkPlayerInfo != null) {
            outParameter.playerInfoBean = lelinkPlayerInfo.getPlayInfoBean();
            outParameter.mediaAssetBean = lelinkPlayerInfo.getMediaAsset();
            outParameter.microAppInfoBean = lelinkPlayerInfo.getMicroAppInfoBean();
            outParameter.startPosition = lelinkPlayerInfo.getStartPosition();
            MediaAssetBean mediaAssetBean = outParameter.mediaAssetBean;
            if (mediaAssetBean != null) {
                outParameter.duration = (int) mediaAssetBean.getDuration();
            }
            outParameter.password = lelinkPlayerInfo.getCastPwd();
            outParameter.retryDLNAHttp = lelinkPlayerInfo.isRetryDLNAHttp();
        }
        outParameter.urlID = CreateUtil.createPushUri(outParameter.getPlayUrl());
        outParameter.session = getSessionId(lelinkServiceInfo);
        return outParameter;
    }

    private LelinkServiceInfo getPlayServiceInfo(LelinkPlayerInfo lelinkPlayerInfo) {
        LelinkServiceInfo lelinkServiceInfo = lelinkPlayerInfo.getLelinkServiceInfo();
        if (lelinkServiceInfo != null || CastUtil.isSupportCloudMultiCast()) {
            LelinkServiceInfo findSameServiceInfo = findSameServiceInfo(lelinkServiceInfo);
            lelinkPlayerInfo.setLelinkServiceInfo(findSameServiceInfo);
            return findSameServiceInfo;
        }
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        if (lastServiceInfo == null) {
            SourceLog.w(TAG, "startPlayMedia ignore ,there has no valid service info");
            return null;
        }
        SourceLog.w(TAG, "startPlayMedia has no service info, use last connect service info " + lastServiceInfo.getName() + Operator.Operation.DIVISION + lastServiceInfo.getIp());
        lelinkPlayerInfo.setLelinkServiceInfo(lastServiceInfo);
        return lastServiceInfo;
    }

    private String getSessionId(LelinkServiceInfo lelinkServiceInfo) {
        ConnectBridge connectBridge;
        return (lelinkServiceInfo == null || TextUtils.isEmpty(lelinkServiceInfo.getUid()) || (connectBridge = ConnectManager.getInstance().getConnectBridge(lelinkServiceInfo.getUid())) == null || TextUtils.isEmpty(connectBridge.getConnectSession())) ? CreateUtil.createSessionId() : connectBridge.getConnectSession();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String heicChangeToJpeg(String str, String str2) {
        String heicToJpegPath = LelinkServerInstance.getInstance().getHeicToJpegPath(str);
        if (!TextUtils.isEmpty(heicToJpegPath)) {
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = heicToJpegPath;
            this.mHandler.sendMessageDelayed(obtainMessage, 60000L);
            str = heicToJpegPath;
        }
        return LelinkServerInstance.getInstance().getFileDownloadUrl(str, str2);
    }

    private boolean isControllerMirroring(PlayController playController) {
        OutParameter playInfo;
        if (playController == null || (playInfo = playController.getPlayInfo()) == null) {
            return false;
        }
        int currentPlayState = playController.getCurrentPlayState();
        if (playInfo.castType == 2) {
            return currentPlayState == 1 || currentPlayState == 5 || currentPlayState == 11;
        }
        return false;
    }

    private boolean isControllerPusing(PlayController playController) {
        if (playController == null) {
            return false;
        }
        return playController.isInPlaybackState();
    }

    private boolean isMirroring() {
        Iterator<PlayController> it = BusinessEntity.getInstance().getControllers().iterator();
        while (it.hasNext()) {
            if (isControllerMirroring(it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean isPushing() {
        Iterator<PlayController> it = BusinessEntity.getInstance().getControllers().iterator();
        while (it.hasNext()) {
            if (isControllerPusing(it.next())) {
                return true;
            }
        }
        return false;
    }

    private void registerReceiver() {
        if (this.mNetworkChangeReceiver == null) {
            this.mNetworkChangeReceiver = new NetworkReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            this.mContext.registerReceiver(this.mNetworkChangeReceiver, intentFilter);
        }
        if (this.mTimeTickReceiver == null) {
            this.mTimeTickReceiver = new TimeTickReceiver();
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.TIME_TICK");
            this.mContext.registerReceiver(this.mTimeTickReceiver, intentFilter2);
        }
    }

    private void setConferenceBrowseListener(Object[] objArr) {
        SourceLog.i(TAG, "LEBO_OPTION_23 value: " + objArr[0]);
    }

    private void setConferenceServerUrl(Object[] objArr) {
        if (objArr.length < 1) {
            SourceLog.i(TAG, "setConferenceServerUrl need more parameter");
            return;
        }
        SourceLog.i(TAG, "setConferenceServerUrl: " + objArr[0]);
        Object obj = objArr[0];
        if (!(obj instanceof String)) {
            SourceLog.w(TAG, "setConferenceServerUrl values is Invalid");
            return;
        }
        String obj2 = obj.toString();
        if (obj2.startsWith(HttpConstant.HTTP)) {
            if (obj2.endsWith(Operator.Operation.DIVISION)) {
                CloudAPI.sConferenceRoot = obj2.substring(0, obj2.lastIndexOf(Operator.Operation.DIVISION));
            } else {
                CloudAPI.sConferenceRoot = obj2;
            }
            CloudAPI.updateDynamicUrls();
        }
    }

    private void setStaffInfo(Object[] objArr) {
        if (objArr.length < 2) {
            SourceLog.i(TAG, "setStaffInfo need more parameter");
            return;
        }
        Object obj = objArr[0];
        Object obj2 = objArr[1];
        SourceLog.i(TAG, "setStaffInfo value0:" + obj + " value1:" + obj2);
        if ((obj instanceof String) && (obj2 instanceof String)) {
            Session.getInstance().department = (String) obj;
            Session.getInstance().jobNumber = (String) obj2;
        }
    }

    private void sonicBrowse() {
        if (!SonicProxy.canStartSonicBrowse(this.mContext)) {
            SourceLog.w(TAG, "browse has no permission to use sonic");
            return;
        }
        SonicProxy.setServiceInfoParseListener(this.mOwnerSonicPinParseListener);
        if (SonicProxy.startBrowse(this.mContext)) {
            BrowserHistory.getInstance().startSonicBrowser();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBrowseInValidLicense(BrowserConfigBean browserConfigBean) {
        if (System.currentTimeMillis() - this.mPreBrowserTime < 200) {
            SourceLog.w(TAG, "startBrowseThread ignore, space less than 200ms");
            return;
        }
        if (browserConfigBean == null) {
            SourceLog.w(TAG, "startBrowseThread ignore, invalid input");
            return;
        }
        BrowserThread browserThread = this.mBrowserThread;
        if (browserThread == null || !browserThread.isAlive()) {
            BrowserThread browserThread2 = new BrowserThread(browserConfigBean);
            this.mBrowserThread = browserThread2;
            browserThread2.start();
        } else {
            this.mBrowserThread.setConfigBean(browserConfigBean);
        }
        SourceLog.i(TAG, "startBrowseThread " + this.mBrowserThread.isAlive());
        this.mBrowserThread.startBrowse();
        this.mPreBrowserTime = System.currentTimeMillis();
    }

    private void startGetSDCardPermission(Context context) {
        Intent intent = new Intent(context, (Class<?>) PermissionBridgeActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(PermissionBridgeActivity.KEY_PERMISSION_TYPE, 2);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startMirrorAfterCheck(Intent intent, LelinkPlayerInfo lelinkPlayerInfo, boolean z10) {
        if (lelinkPlayerInfo.getSubMirrorInfos() == null || lelinkPlayerInfo.getSubMirrorInfos().size() <= 0) {
            BusinessEntity.getInstance().enableMultiCast(false);
            dispatchMirror(intent, lelinkPlayerInfo, z10, false);
            return;
        }
        BusinessEntity.getInstance().release();
        if (Feature.hasCloudMirror()) {
            YimMirror.getInstance().resetMultiCast();
        }
        BusinessEntity.getInstance().enableMultiCast(true);
        Iterator<LelinkServiceInfo> it = lelinkPlayerInfo.getSubMirrorInfos().iterator();
        while (it.hasNext()) {
            LelinkServiceInfo next = it.next();
            LelinkPlayerInfo cloneNoSubDevice = lelinkPlayerInfo.cloneNoSubDevice();
            cloneNoSubDevice.setLelinkServiceInfo(next);
            dispatchMirror(intent, cloneNoSubDevice, z10, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay(LelinkPlayerInfo lelinkPlayerInfo) {
        LelinkServiceInfo playServiceInfo = getPlayServiceInfo(lelinkPlayerInfo);
        if (playServiceInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(lelinkPlayerInfo.getLocalPath())) {
            startPlayMedia(playServiceInfo, lelinkPlayerInfo, lelinkPlayerInfo.getLocalPath(), lelinkPlayerInfo.getType(), true);
        } else if (lelinkPlayerInfo.getLocalUri() != null) {
            startPlayMedia(playServiceInfo, lelinkPlayerInfo, lelinkPlayerInfo.getLocalUri().toString(), lelinkPlayerInfo.getType(), true);
        } else {
            startPlayMedia(playServiceInfo, lelinkPlayerInfo, lelinkPlayerInfo.getUrl(), lelinkPlayerInfo.getType(), false);
        }
    }

    private void startPlayMediaAfterCheck(LelinkServiceInfo lelinkServiceInfo, LelinkPlayerInfo lelinkPlayerInfo, String str, int i10) {
        if (lelinkPlayerInfo.getSubMirrorInfos() == null || lelinkPlayerInfo.getSubMirrorInfos().size() <= 0) {
            BusinessEntity.getInstance().enableMultiCast(false);
            dispatchPlayMedia(lelinkServiceInfo, lelinkPlayerInfo, str, i10);
            return;
        }
        BusinessEntity.getInstance().enableMultiCast(true);
        Iterator<LelinkServiceInfo> it = lelinkPlayerInfo.getSubMirrorInfos().iterator();
        while (it.hasNext()) {
            LelinkServiceInfo next = it.next();
            lelinkPlayerInfo.cloneNoSubDevice().setLelinkServiceInfo(next);
            dispatchPlayMedia(next, lelinkPlayerInfo, str, i10);
        }
    }

    private void unregisterReceiver() {
        NetworkReceiver networkReceiver = this.mNetworkChangeReceiver;
        if (networkReceiver != null) {
            try {
                this.mContext.unregisterReceiver(networkReceiver);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
            this.mNetworkChangeReceiver = null;
        }
        TimeTickReceiver timeTickReceiver = this.mTimeTickReceiver;
        if (timeTickReceiver != null) {
            try {
                this.mContext.unregisterReceiver(timeTickReceiver);
            } catch (Exception e11) {
                SourceLog.w(TAG, e11);
            }
        }
    }

    private void uploadLogQuery() {
        SourceLog.w(TAG, "uploadLogQuery");
        LogUpload.uploadLogFileQuery(this.mContext, new IUploadLogQueryListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.19
            @Override // com.hpplay.sdk.source.api.IUploadLogQueryListener
            public void onError() {
                SourceLog.w(LelinkSdkManager.TAG, "uploadLogQuery error");
            }

            @Override // com.hpplay.sdk.source.api.IUploadLogQueryListener
            public void onQueryResult(String str) {
                try {
                    SourceLog.w(LelinkSdkManager.TAG, "log query result = " + str);
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(Constants.KEY_HTTP_CODE);
                    jSONObject.optString(Constant.KEY_MSG);
                    int optInt2 = jSONObject.optInt("report_err");
                    int optInt3 = jSONObject.optInt("eid");
                    if (optInt != 200 || optInt2 == 0) {
                        return;
                    }
                    LogUpload.uploadLogFile(LelinkSdkManager.this.mContext, optInt3 + "", null, "", "", null);
                } catch (Exception e10) {
                    SourceLog.w(LelinkSdkManager.TAG, e10);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadLogStatus(int i10) {
        int i11;
        if (i10 != 200) {
            i11 = -1;
            if (i10 != 202) {
                if (i10 == 400) {
                    i11 = 2;
                } else if (i10 == 405) {
                    i11 = 4;
                } else if (i10 == 406) {
                    i11 = 3;
                }
            }
        } else {
            i11 = 1;
        }
        IRelevantInfoListener iRelevantInfoListener = this.mOuterRelevantInfoListener;
        if (iRelevantInfoListener != null) {
            iRelevantInfoListener.onReverseInfoResult(IAPI.OPTION_UPLOAD_LOG, i11 + "");
        }
    }

    public void addFavoriteDevice(LelinkServiceInfo lelinkServiceInfo) {
        FavoriteDeviceManager.getInstance().addFavoriteDevice(lelinkServiceInfo);
    }

    public void addPinCodeToLelinkServiceInfo(final String str) {
        SourceLog.i(TAG, "addPinCodeToLelinkServiceInfo " + str);
        checkLicense(new LicenseManager.ILicenseCheckListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.16
            @Override // com.hpplay.sdk.source.business.cloud.LicenseManager.ILicenseCheckListener
            public void checkLicense(boolean z10) {
                if (!z10) {
                    SourceLog.w(LelinkSdkManager.TAG, "addPinCodeToLelinkServiceInfo ignore, invalid license");
                } else {
                    BrowserHistory.getInstance().startPinCodeBrowser();
                    Device.addPinCodeServiceInfo(LelinkSdkManager.this.mContext, str, LelinkSdkManager.this.mOwnerParseListener);
                }
            }
        });
    }

    public void addQRCodeToLelinkServiceInfo(final String str) {
        SourceLog.i(TAG, "addQRCodeToLelinkServiceInfo " + str);
        checkLicense(new LicenseManager.ILicenseCheckListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.15
            @Override // com.hpplay.sdk.source.business.cloud.LicenseManager.ILicenseCheckListener
            public void checkLicense(boolean z10) {
                if (!z10) {
                    SourceLog.w(LelinkSdkManager.TAG, "addQRCodeToLelinkServiceInfo ignore, invalid license");
                } else {
                    BrowserHistory.getInstance().startQRBrowser();
                    Device.addQRLelinkServiceInfo(str, LelinkSdkManager.this.mOwnerParseListener);
                }
            }
        });
    }

    public void addVolume() {
        BusinessEntity.getInstance().addVolume();
    }

    public void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        if (dramaInfoBeanArr == null || dramaInfoBeanArr.length > 100) {
            SourceLog.w(TAG, "appendPlayList values ignore");
        } else {
            BusinessEntity.getInstance().appendPlayList(dramaInfoBeanArr, i10, i11, i12);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void browse(BrowserConfigBean browserConfigBean) {
        if (browserConfigBean == null) {
            SourceLog.w(TAG, "browse ignore");
            return;
        }
        this.mBrowserConfig = browserConfigBean;
        int i10 = 1;
        if (!canDisableDLNA()) {
            browserConfigBean.useDlna = true;
        }
        SourceLog.i(TAG, "browse " + browserConfigBean.useLelink + Operator.Operation.DIVISION + browserConfigBean.useDlna + Operator.Operation.DIVISION + browserConfigBean.useHistory);
        boolean z10 = browserConfigBean.useLelink;
        if (!z10 || !browserConfigBean.useDlna) {
            if (!z10) {
                if (browserConfigBean.useDlna) {
                    i10 = 2;
                }
            }
            clearBrowserList();
            BrowserBridge.getInstance().setBrowserListener(this.mBrowserDispatcher);
            BrowserBridge.getInstance().startBrowse(this.mContext, i10);
            BrowserHistory.getInstance().startLocalBrowser(i10);
            if (browserConfigBean.useSonic) {
                sonicBrowse();
            }
            if (browserConfigBean.useBLE) {
                bleBrowse();
            }
            if (browserConfigBean.useHistory) {
                historyBrowse(browserConfigBean);
            }
            this.mBrowserDispatcher.browser();
            this.mBrowserTimeStamp = System.currentTimeMillis();
            RelationReportTask relationReportTask = RelationReportTask.getInstance();
            Context context = this.mContext;
            long j10 = this.mBrowserTimeStamp;
            relationReportTask.report(context, j10, j10 + NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS, SDKConfig.getInstance().getSearchOutTime() * 1000);
            CastUtil.printSDKInfo();
        }
        i10 = 3;
        clearBrowserList();
        BrowserBridge.getInstance().setBrowserListener(this.mBrowserDispatcher);
        BrowserBridge.getInstance().startBrowse(this.mContext, i10);
        BrowserHistory.getInstance().startLocalBrowser(i10);
        if (browserConfigBean.useSonic) {
        }
        if (browserConfigBean.useBLE) {
        }
        if (browserConfigBean.useHistory) {
        }
        this.mBrowserDispatcher.browser();
        this.mBrowserTimeStamp = System.currentTimeMillis();
        RelationReportTask relationReportTask2 = RelationReportTask.getInstance();
        Context context2 = this.mContext;
        long j102 = this.mBrowserTimeStamp;
        relationReportTask2.report(context2, j102, j102 + NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS, SDKConfig.getInstance().getSearchOutTime() * 1000);
        CastUtil.printSDKInfo();
    }

    public boolean canPlayLocalMedia(LelinkServiceInfo lelinkServiceInfo) {
        Integer[] protocols;
        LelinkServiceInfo findSameServiceInfo = findSameServiceInfo(lelinkServiceInfo);
        if (findSameServiceInfo != null && (protocols = findSameServiceInfo.getProtocols()) != null && protocols.length > 0) {
            for (Integer num : protocols) {
                if (num.intValue() == 1 || num.intValue() == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canPlayScreen(LelinkServiceInfo lelinkServiceInfo) {
        Integer[] protocols;
        LelinkServiceInfo findSameServiceInfo = findSameServiceInfo(lelinkServiceInfo);
        if (findSameServiceInfo != null && (protocols = findSameServiceInfo.getProtocols()) != null && protocols.length > 0) {
            for (Integer num : protocols) {
                if (num.intValue() == 1 || (num.intValue() == 4 && Feature.hasCloudMirror())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clearBrowserList() {
        this.mBrowserDispatcher.clearBrowserList();
        DeviceCodeResolver.getInstance().clear();
        BrowserHistory.getInstance().clearHistory();
        RelationReportTask.getInstance().clear();
    }

    public void clearPermissionIntentAndRetryMirror() {
        startMirror(this.mMirrorPlayInfo, false);
    }

    public void clearPlayList() {
        BusinessEntity.getInstance().clearPlayList();
    }

    public void connect(LelinkServiceInfo lelinkServiceInfo) {
        SourceLog.i(TAG, "connect info:" + lelinkServiceInfo.getName());
        final LelinkServiceInfo findSameServiceInfo = findSameServiceInfo(lelinkServiceInfo);
        if (findSameServiceInfo == null) {
            return;
        }
        if (!CastUtil.isSupportMultiChannel(lelinkServiceInfo) ? ConnectManager.getInstance().checkOnline(findSameServiceInfo, new OnlineManager.OnlineListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.10
            @Override // com.hpplay.sdk.source.process.OnlineManager.OnlineListener
            public void OnLineCheckResult(LelinkServiceInfo lelinkServiceInfo2, boolean z10) {
                if (!z10) {
                    ConnectManager.getInstance().notifyInvalid(lelinkServiceInfo2);
                    return;
                }
                ConnectManager connectManager = ConnectManager.getInstance();
                Context context = LelinkSdkManager.this.mContext;
                LelinkServiceInfo lelinkServiceInfo3 = findSameServiceInfo;
                connectManager.connect(context, lelinkServiceInfo3, CastUtil.isSupportMultiChannel(lelinkServiceInfo3));
            }
        }) : false) {
            return;
        }
        ConnectManager.getInstance().connect(this.mContext, findSameServiceInfo, CastUtil.isSupportMultiChannel(findSameServiceInfo));
    }

    public void createLelinkServiceInfo(SinkParameterBean sinkParameterBean) {
        SourceLog.i(TAG, "createLelinkServiceInfo " + sinkParameterBean);
        if (sinkParameterBean == null) {
            return;
        }
        if (sinkParameterBean.createType == SinkParameterBean.CREATE_BY_SINK_SERVER) {
            Device.createBySinkServer(sinkParameterBean.ip, sinkParameterBean.port, this.mOwnerParseListener);
        } else {
            Device.createLelinkServiceInfo(sinkParameterBean, this.mOwnerParseListener);
        }
    }

    public void createLelinkServiceInfoList(List<SinkParameterBean> list) {
        SourceLog.i(TAG, "createLelinkServiceInfoList " + list);
        if (list == null || list.size() <= 0) {
            return;
        }
        if (list.get(0).createType == SinkParameterBean.CREATE_BY_SINK_SERVER) {
            createListBySinkServer(list);
        } else {
            Device.createLelinkServiceInfoList(list, this.mOwnerParseListListener);
        }
    }

    public void createPinCode(ICreatePinCodeListener iCreatePinCodeListener) {
        Device.createPinCode(iCreatePinCodeListener);
    }

    public void createPreChecker() {
        DevicePreChecker devicePreChecker = this.mDevicePreChecker;
        if (devicePreChecker != null && !devicePreChecker.isRunning()) {
            this.mDevicePreChecker.release();
            this.mDevicePreChecker = null;
        }
        if (this.mDevicePreChecker == null) {
            DevicePreChecker devicePreChecker2 = new DevicePreChecker(this.mContext);
            this.mDevicePreChecker = devicePreChecker2;
            devicePreChecker2.start();
        }
    }

    public void createShortUrl(ICreateShortUrlListener iCreateShortUrlListener) {
        Device.createShortUrl(iCreateShortUrlListener);
    }

    public boolean disconnect(LelinkServiceInfo lelinkServiceInfo) {
        LelinkServiceInfo findSameServiceInfo = findSameServiceInfo(lelinkServiceInfo);
        SourceLog.i(TAG, "disconnect " + findSameServiceInfo);
        BusinessEntity.getInstance().stop(Constant.STOP_USER_DISCONNECT);
        BusinessEntity.getInstance().release();
        ConnectManager.getInstance().disconnect(findSameServiceInfo);
        return true;
    }

    public BrowserConfigBean getBrowserConfig() {
        return this.mBrowserConfig;
    }

    public List<LelinkServiceInfo> getBrowserList() {
        return this.mBrowserDispatcher.getBrowserList();
    }

    public List<LelinkServiceInfo> getConnectInfos() {
        return ConnectManager.getInstance().getConnections();
    }

    public Context getContext() {
        return this.mContext;
    }

    public void getFavoriteDeviceList(int i10, int i11) {
        FavoriteDeviceManager.getInstance().getFavoriteDeviceList(i10, i11);
    }

    public void getHistoryDeviceList(int i10, int i11) {
        HistoryDeviceManager.getInstance().getHistoryDeviceList(i10, i11);
    }

    public Object getOption(int i10, Object... objArr) {
        ConnectBridge lastConnectBridge = ConnectManager.getInstance().getLastConnectBridge();
        int i11 = 0;
        switch (i10) {
            case IAPI.OPTION_32 /* 1048626 */:
                return Integer.valueOf(getPlayState());
            case IAPI.OPTION_35 /* 1048629 */:
                SourceLog.i(TAG, "OPTION_35");
                return (lastConnectBridge == null || !lastConnectBridge.isSupportPassMsg(12)) ? -1 : 0;
            case IAPI.OPTION_37 /* 1048631 */:
                SourceLog.i(TAG, "OPTION_37");
                return (lastConnectBridge == null || !lastConnectBridge.isSupportPassMsg(15)) ? -1 : 0;
            case IAPI.OPTION_63 /* 1048675 */:
                SourceLog.i(TAG, "OPTION_63");
                return (lastConnectBridge == null || !lastConnectBridge.isSupportPassMsg(6)) ? -1 : 0;
            case IAPI.OPTION_GET_LOG_DIR /* 2097155 */:
                SourceLog.flushLogWriter();
                return SourceLog.getLogDir();
            case IAPI.OPTION_QUERY_SUPPORT_MULTI_CHANNEL /* 2097159 */:
                try {
                    LelinkServiceInfo lelinkServiceInfo = (LelinkServiceInfo) objArr[0];
                    if (lelinkServiceInfo == null) {
                        return -1;
                    }
                    if (!CastUtil.isSupportMultiChannel(lelinkServiceInfo)) {
                        i11 = -1;
                    }
                    return Integer.valueOf(i11);
                } catch (Exception e10) {
                    SourceLog.w(TAG, e10);
                    return -1;
                }
            case IAPI.OPTION_QUERY_SUPPORT_URL_LIST /* 2097160 */:
                return (lastConnectBridge == null || !lastConnectBridge.isSupportUrlList()) ? -1 : 0;
            case IAPI.OPTION_QUERY_SUPPORT_REVERSE_CONTROL /* 2097173 */:
                try {
                    if (((LelinkServiceInfo) objArr[0]) != null && lastConnectBridge != null) {
                        if (lastConnectBridge.isSupportPassMsg(31)) {
                            return 0;
                        }
                    }
                } catch (Exception e11) {
                    SourceLog.w(TAG, e11);
                }
                return -1;
            case IAPI.OPTION_TEMP_RESTRICT /* 2097175 */:
                return (lastConnectBridge == null || !lastConnectBridge.isSupportPassMsg(36)) ? -1 : 0;
            case IAPI.OPTION_QUERY_SUPPORT_TRACK /* 2097177 */:
                return (lastConnectBridge == null || !lastConnectBridge.isSupportTrack()) ? -1 : 0;
            case IAPI.OPTION_IS_MIRRORING /* 2097201 */:
                return String.valueOf(isMirroring());
            case IAPI.OPTION_SET_RECEIVER_PROPERTY /* 2097234 */:
                return (lastConnectBridge == null || !lastConnectBridge.isSupportPassMsg(49)) ? -1 : 0;
            case IAPI.OPTION_GET_RECEIVER_PROPERTIES /* 2097235 */:
                return (lastConnectBridge == null || !lastConnectBridge.isSupportPassMsg(50)) ? -1 : 0;
            default:
                return -1;
        }
    }

    public int getPlayState() {
        return BusinessEntity.getInstance().getLastPlayState();
    }

    public AtomicBoolean getRetryMirrorOnce() {
        return this.mRetryMirrorOnce;
    }

    public String getSDKInfos(int i10) {
        return i10 == 1 ? Session.getInstance().getUID() : i10 == 2 ? Session.getInstance().getHID() : "";
    }

    public VirtualDisplay getVirtualDisplay() {
        return CaptureBridge.getInstance().getVirtualDisplay();
    }

    public void historyBrowse(BrowserConfigBean browserConfigBean) {
        if (TextUtils.isEmpty(browserConfigBean.encryptNumberId)) {
            if (TextUtils.isEmpty(browserConfigBean.numberId)) {
                return;
            } else {
                browserConfigBean.encryptNumberId = LeboUtil.anonymizeBySHA256For60Bits(browserConfigBean.numberId);
            }
        }
        BrowserBridge.getInstance().setServiceInfoParseListener(this.mOwnerHistoryListener);
        if (BrowserBridge.getInstance().startBrowseHistory(this.mContext, browserConfigBean.encryptNumberId)) {
            BrowserHistory.getInstance().startHistoryBrowser();
        }
    }

    public void initSDK(Context context, String str, String str2, String str3, String str4, String str5) {
        this.mContext = context;
        if (!Feature.isLeboApp() && !Feature.isDisableCrs(str)) {
            CrashHandler.getInstance().init(this.mContext.getApplicationContext());
        }
        ModuleLinker.getInstance().init(this.mContext, new String[0]);
        AppContextUtils.getInstance().setAppContext(this.mContext);
        SourceLog.i(TAG, "initSDK " + str + Operator.Operation.DIVISION + str5);
        Preference.initPreference(this.mContext);
        Session.initSession(this.mContext);
        Session.getInstance().initManufacture();
        Session.getInstance().appKey = str;
        Session.getInstance().appSecret = str2;
        Session.getInstance().appVersion = str5;
        Session.getInstance().userID = str3;
        Session.getInstance().oaID = str4;
        DeviceUtil.setOAID(str4);
        PublicCastClient.init(this.mContext.getApplicationContext());
        SourceDataReport.initDataReport(this.mContext.getApplicationContext());
        LelinkServerInstance.getInstance().init(this.mContext.getApplicationContext());
        BrowseResultOnlineCheck.getInstance().setContext(this.mContext.getApplicationContext());
        if (!LelinkConfig.isSdkFree() && LelinkConfig.isLicenseMode()) {
            LicenseManager.getInstance().readCachedLicense();
        }
        if (Feature.isVivoChannel()) {
            NetworkUtil.setSSIDStatus(false);
            NetworkUtil.setBSSIDStatus(false);
        }
        AuthSDK.getInstance().init(this.mContext.getApplicationContext());
        AuthSDK.getInstance().addAuthListener(this.mOwnerAuthListener);
        AuthSDK.getInstance().authSDK();
        if (LelinkConfig.isSupportDA()) {
            e.d().a(this.mContext);
        }
        registerReceiver();
        enableLog(Preference.getInstance().get(Preference.KEY_ENABLE_LOG, true));
    }

    public void isDebug(boolean z10) {
        SourceLog.i(TAG, "isDebug," + z10);
        Preference.getInstance().put(Preference.KEY_ENABLE_LOG, z10);
        enableLog(z10);
    }

    public void isDebugTimestamp(boolean z10) {
        Session.getInstance().setDebugTimestamp(z10);
    }

    public void multiMirrorControl(boolean z10, List<LelinkServiceInfo> list) {
        LelinkPlayerInfo lelinkPlayerInfo;
        SourceLog.w(TAG, "multiMirrorControl " + z10 + " " + list.size());
        if (!isMirroring()) {
            SourceLog.w(TAG, "multiMirrorControl ignore");
            return;
        }
        OutParameter lastPlayInfo = BusinessEntity.getInstance().getLastPlayInfo();
        if (lastPlayInfo == null || (lelinkPlayerInfo = lastPlayInfo.originPlayerInfo) == null || list.size() <= 0) {
            return;
        }
        if (!z10) {
            for (LelinkServiceInfo lelinkServiceInfo : list) {
                BusinessEntity businessEntity = BusinessEntity.getInstance();
                if (businessEntity != null) {
                    businessEntity.stop(1000, lelinkServiceInfo);
                }
            }
            return;
        }
        BusinessEntity.getInstance().enableMultiCast(true);
        for (LelinkServiceInfo lelinkServiceInfo2 : list) {
            LelinkPlayerInfo cloneNoSubDevice = lelinkPlayerInfo.cloneNoSubDevice();
            cloneNoSubDevice.setLelinkServiceInfo(lelinkServiceInfo2);
            dispatchMirror(lastPlayInfo.mirrorIntent, cloneNoSubDevice, lastPlayInfo.isExpandMirror, true);
        }
    }

    public void multiPushControl(boolean z10, List<LelinkServiceInfo> list, String str, int i10) {
        LelinkPlayerInfo lelinkPlayerInfo;
        SourceLog.w(TAG, "multiPushControl " + z10 + " " + list.size());
        if (!isPushing()) {
            SourceLog.w(TAG, "multiPushControl ignore");
            return;
        }
        OutParameter lastPlayInfo = BusinessEntity.getInstance().getLastPlayInfo();
        if (lastPlayInfo == null || (lelinkPlayerInfo = lastPlayInfo.originPlayerInfo) == null || list.size() <= 0) {
            return;
        }
        if (z10) {
            BusinessEntity.getInstance().enableMultiCast(true);
            for (LelinkServiceInfo lelinkServiceInfo : list) {
                lelinkPlayerInfo.cloneNoSubDevice().setLelinkServiceInfo(lelinkServiceInfo);
                dispatchPlayMedia(lelinkServiceInfo, lelinkPlayerInfo, str, i10);
            }
            return;
        }
        for (LelinkServiceInfo lelinkServiceInfo2 : list) {
            BusinessEntity businessEntity = BusinessEntity.getInstance();
            if (businessEntity != null) {
                businessEntity.stop(1000, lelinkServiceInfo2);
            }
        }
    }

    public void notifyBrowseList() {
        this.mBrowserDispatcher.notifyBrowserSuccess();
        try {
            Iterator<LelinkServiceInfo> it = getBrowserList().iterator();
            while (it.hasNext()) {
                ConnectManager.getInstance().notifyBrowseResult(it.next());
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void notifyBrowserListIfNeeded(boolean z10) {
        if (z10) {
            notifyBrowseList();
        } else {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public void pause() {
        BusinessEntity.getInstance().pause();
    }

    public void release() {
        SourceLog.i(TAG, "release");
        deleteHeicFileDir();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        BrowserBridge.release();
        SonicProxy.release();
        unregisterReceiver();
        SourceDataReport.getInstance().logout();
        this.mBrowserDispatcher.clearBrowserList();
        OnlineCheckThread onlineCheckThread = this.mOnlineCheckThread;
        if (onlineCheckThread != null) {
            onlineCheckThread.release();
        }
        RelationReportTask.unInit();
        SourceLog.flushLogWriter();
        SourceLog.disableLogWriter();
        e.d().c();
        CommonListenerWrapper.getInstance().release();
    }

    public void removeFavoriteDevice(List<LelinkServiceInfo> list) {
        FavoriteDeviceManager.getInstance().removeFavoriteDevice(list);
    }

    public void removeHistoryDevice(List<LelinkServiceInfo> list, int i10) {
        HistoryDeviceManager.getInstance().removeHistoryDevice(list, i10);
    }

    public void resume() {
        BusinessEntity.getInstance().resume();
    }

    public void seekTo(int i10) {
        BusinessEntity.getInstance().seekTo(i10);
    }

    public void selectAudiotrack(int i10) {
        BusinessEntity.getInstance().selectAudioTrack(i10);
    }

    public void setAuthListener(AuthListener authListener) {
        this.mOuterAuthListener = authListener;
    }

    public void setBrowseListener(IBrowseListener iBrowseListener) {
        this.mBrowserDispatcher.setBrowseListener(iBrowseListener);
    }

    public void setCloudMirrorPlayListener(ICloudMirrorPlayListener iCloudMirrorPlayListener) {
        this.mOuterCloudMirrorPlayListener = iCloudMirrorPlayListener;
    }

    public void setCommonListener(ICommonListener iCommonListener) {
        CommonListenerWrapper.getInstance().setCommonListener(iCommonListener);
    }

    public void setConnectListener(IConnectListener iConnectListener) {
        ConnectManager.getInstance().setConnectListener(iConnectListener);
    }

    public void setDaPlayListener(IDaPlayerListener iDaPlayerListener) {
        BusinessEntity.getInstance().setDaPlayListener(iDaPlayerListener);
    }

    public void setDebugAVListener(IDebugAVListener iDebugAVListener) {
        Session.getInstance().setDebugAVListener(iDebugAVListener);
    }

    public void setExpansionScreenInfo(Activity activity, View view) {
        SourceLog.i(TAG, "setExpansionScreenInfo " + activity + " / " + view);
        this.mExpandActivity = activity;
        this.mExpandView = view;
    }

    public void setFavoriteDeviceAlias(LelinkServiceInfo lelinkServiceInfo, String str) {
        FavoriteDeviceManager.getInstance().setFavoriteDeviceAlias(lelinkServiceInfo, str);
    }

    public void setFavoriteDeviceListener(IFavoriteDeviceListener iFavoriteDeviceListener) {
        FavoriteDeviceManager.getInstance().setFavoriteDeviceListener(iFavoriteDeviceListener);
    }

    public void setHistoryDeviceListener(IHistoryDeviceListener iHistoryDeviceListener) {
        HistoryDeviceManager.getInstance().setHistoryDeviceListener(iHistoryDeviceListener);
    }

    public void setLogCallback(ILogCallback iLogCallback) {
        Session.getInstance().setLogCallback(iLogCallback);
    }

    public void setMirrorChangeListener(IMirrorChangeListener iMirrorChangeListener) {
        this.mOuterMirrorChangeListener = iMirrorChangeListener;
    }

    public void setMirrorScreenSecret(boolean z10) {
        SourceLog.i(TAG, "setMirrorScreenSecret status:" + z10);
        Preference.getInstance().put(Preference.KEY_MIRROR_SECRET_SWITCH, z10);
        BusinessEntity.getInstance().setMirrorScreenSecret(z10);
    }

    public void setNewPlayerListener(INewPlayerListener iNewPlayerListener) {
        BusinessEntity.getInstance().setNewPlayerListener(iNewPlayerListener);
    }

    public void setOption(int i10, Object... objArr) {
        int i11;
        String str;
        Object obj;
        String str2 = "";
        int i12 = 0;
        switch (i10) {
            case 22:
                PassSender.getInstance().sendVIPQuery(objArr[0].toString());
                break;
            case 100:
            case 10000:
                Object obj2 = objArr[0];
                if (obj2 != null && (obj2 instanceof String) && (obj = objArr[1]) != null && (obj instanceof String) && objArr[2] != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("data", objArr[0]);
                        jSONObject.put("manifestVer", 1);
                        jSONObject.put("appID", objArr[1]);
                    } catch (Exception e10) {
                        SourceLog.w(TAG, e10);
                    }
                    PassSender.getInstance().sendPass(i10, jSONObject.toString(), Boolean.parseBoolean(String.valueOf(objArr[2])));
                    break;
                }
                break;
            case IAPI.OPTION_5 /* 65541 */:
                Object obj3 = objArr[0];
                if (obj3 instanceof Boolean) {
                    Session.getInstance().isFilter501Version = ((Boolean) obj3).booleanValue();
                    break;
                }
                break;
            case IAPI.OPTION_7 /* 65543 */:
                release();
                break;
            case IAPI.OPTION_11 /* 1048593 */:
                setConferenceServerUrl(objArr);
                break;
            case IAPI.OPTION_12 /* 1048594 */:
                setStaffInfo(objArr);
                break;
            case IAPI.OPTION_23 /* 1048611 */:
                setConferenceBrowseListener(objArr);
                break;
            case IAPI.OPTION_35 /* 1048629 */:
                JSONObject jSONObject2 = new JSONObject();
                try {
                    float parseFloat = Float.parseFloat(objArr[0] + "");
                    jSONObject2.put("manifestVer", 1);
                    jSONObject2.put("rate", (double) parseFloat);
                    PassSender.getInstance().playRate(jSONObject2.toString());
                    break;
                } catch (Exception e11) {
                    SourceLog.w(TAG, e11);
                    return;
                }
            case IAPI.OPTION_37 /* 1048631 */:
                PassSender.getInstance().queryRate();
                break;
            case IAPI.OPTION_41 /* 1048641 */:
                String str3 = (String) objArr[0];
                String str4 = (String) objArr[1];
                Preference.getInstance().put(Constant.KEY_VUUID, str3);
                Preference.getInstance().put(Constant.KEY_VSESSION, str4);
                SourceLog.i(TAG, "vip info " + str3 + "  " + str4);
                if (!TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str3)) {
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                        VipAuthSetting vipAuthSetting = new VipAuthSetting();
                        vipAuthSetting.uuid = str3;
                        vipAuthSetting.ssid = str4;
                        RightsManager.getInstance().loginVipAuth(vipAuthSetting);
                        break;
                    }
                } else {
                    RightsManager.getInstance().logout();
                    break;
                }
                break;
            case IAPI.OPTION_44 /* 1048644 */:
                try {
                    int parseInt = Integer.parseInt((String) objArr[0]);
                    int parseInt2 = Integer.parseInt((String) objArr[1]);
                    int parseInt3 = Integer.parseInt((String) objArr[2]);
                    Preference.getInstance().put(Constant.KEY_CLOUD_MIRROR_MAX_BITRATE, parseInt);
                    Preference.getInstance().put(Constant.KEY_CLOUD_MIRROR_MIN_BITRATE, parseInt2);
                    Preference.getInstance().put(Constant.KEY_CLOUD_MIRROR_FRAME_BITRATE, parseInt3);
                    if (objArr.length > 3) {
                        int parseInt4 = Integer.parseInt(objArr[3].toString());
                        int parseInt5 = Integer.parseInt(objArr[4].toString());
                        Preference.getInstance().put(Constant.KEY_CLOUD_MIRROR_WIDTH, parseInt4);
                        Preference.getInstance().put(Constant.KEY_CLOUD_MIRROR_HEIGHT, parseInt5);
                        break;
                    }
                } catch (Exception e12) {
                    SourceLog.w(TAG, e12);
                    return;
                }
                break;
            case IAPI.OPTION_48 /* 1048648 */:
                Preference.getInstance().put(Constant.KEY_USERNAME, (String) objArr[0]);
                break;
            case IAPI.OPTION_49 /* 1048649 */:
                boolean parseBoolean = Boolean.parseBoolean(objArr[0].toString());
                if (parseBoolean) {
                    uploadLogQuery();
                }
                enableLog(parseBoolean);
                break;
            case IAPI.OPTION_51 /* 1048657 */:
                AuthSDK.getInstance().authSDK();
                break;
            case IAPI.OPTION_53 /* 1048659 */:
                try {
                    str = (String) objArr[0];
                } catch (Exception e13) {
                    e = e13;
                    str = "";
                }
                try {
                    str2 = (String) objArr[1];
                } catch (Exception e14) {
                    e = e14;
                    SourceLog.w(TAG, e);
                    uploadLog(str, str2);
                    return;
                }
                uploadLog(str, str2);
            case IAPI.OPTION_EXTERNAL_AUDIO /* 1048673 */:
                OptionCentral.changeExternalAudioState(Boolean.parseBoolean((String) objArr[0]));
                break;
            case IAPI.OPTION_63 /* 1048675 */:
                if (objArr != null && objArr[0] != null) {
                    try {
                        OutParameter lastPlayInfo = BusinessEntity.getInstance().getLastPlayInfo();
                        if (lastPlayInfo != null) {
                            Object obj4 = objArr[0];
                            if (obj4 instanceof String) {
                                JSONObject jSONObject3 = new JSONObject((String) objArr[0]);
                                jSONObject3.put("manifestVer", 1);
                                jSONObject3.put("uri", lastPlayInfo.urlID);
                                r3 = jSONObject3.toString();
                            } else if (obj4 instanceof DanmakuBean) {
                                r3 = ((DanmakuBean) obj4).toJson(lastPlayInfo.urlID, 1);
                            }
                            SourceLog.i(TAG, "danmaku json body :" + r3);
                            PassSender.getInstance().sendDanmu(r3);
                            break;
                        } else {
                            SourceLog.i(TAG, "danmaku ignore");
                            break;
                        }
                    } catch (Exception e15) {
                        SourceLog.w(TAG, e15);
                        return;
                    }
                }
                break;
            case IAPI.OPTION_64 /* 1048676 */:
                if (objArr != null && objArr.length > 0) {
                    Object obj5 = objArr[0];
                    if (obj5 instanceof DanmakuPropertyBean) {
                        PassSender.getInstance().setDanmuProperty(((DanmakuPropertyBean) obj5).toString());
                        break;
                    }
                }
                break;
            case IAPI.OPTION_REGISTER_SINK_KEY_EVENT /* 1048678 */:
                if (canReverseControl()) {
                    OptionCentral.registerOrUnregisterSinkKeyEvent(Boolean.parseBoolean((String) objArr[0]));
                    break;
                }
                break;
            case IAPI.OPTION_REGISTER_SINK_TOUCH_EVENT /* 1048679 */:
                if (canReverseControl()) {
                    OptionCentral.registerOrUnregisterSinkTouchEvent(Boolean.parseBoolean((String) objArr[0]));
                    break;
                }
                break;
            case IAPI.OPTION_CACHE_LIST /* 1048680 */:
                PassSender.getInstance().sendShortVideoList(objArr[0].toString());
                break;
            case IAPI.START_PLAY_CLOUDMIRROR /* 1179652 */:
                if (objArr != null && objArr.length > 3) {
                    Object obj6 = objArr[0];
                    if (obj6 instanceof String) {
                        Object obj7 = objArr[1];
                        if (obj7 instanceof String) {
                            Object obj8 = objArr[2];
                            if (obj8 instanceof String) {
                                Object obj9 = objArr[3];
                                if (obj9 instanceof String) {
                                    startRenderCloudMirror((String) obj6, (String) obj7, (String) obj8, (String) obj9);
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            case 1179654:
                String str5 = (String) objArr[0];
                SourceLog.i(TAG, "OPTION_SUPER_DEVICE_ID " + str5);
                Preference.getInstance().put(Constant.KEY_SUPER_DEVICE_ID, str5);
                RightsManager.getInstance().vipAuth();
                break;
            case IAPI.OPTION_SET_EXPANSITION_INFOS /* 1179656 */:
                setExpansionScreenInfo((Activity) objArr[0], (View) objArr[1]);
                break;
            case IAPI.OPTION_APP_PAUSE /* 1179657 */:
                BusinessEntity.getInstance().onAppPause();
                break;
            case IAPI.OPTION_APP_RESUME /* 1179664 */:
                BusinessEntity.getInstance().onAppResume();
                break;
            case IAPI.OPTION_EXTERNAL_VIDEO /* 2097153 */:
                OptionCentral.setExternalVideo(Boolean.parseBoolean(objArr[0].toString()));
                break;
            case IAPI.OPTION_BROWSER /* 2097154 */:
                try {
                    BrowserConfigBean formJSON = BrowserConfigBean.formJSON(objArr[0].toString());
                    SourceLog.i(TAG, "OPTION_BROWSER " + formJSON);
                    if (formJSON != null) {
                        startBrowseThread(formJSON);
                        break;
                    }
                } catch (Exception e16) {
                    SourceLog.w(TAG, e16);
                    return;
                }
                break;
            case IAPI.OPTION_MULTI_CHANNEL /* 2097156 */:
                Preference.getInstance().put(Preference.KEY_MULTI_CHANNEL, objArr[0].toString());
                break;
            case IAPI.OPTION_CHANGE_MIRROR /* 2097157 */:
                try {
                    int parseInt6 = Integer.parseInt(objArr[0].toString());
                    if (parseInt6 == 4) {
                        BusinessEntity.getInstance().switchYim();
                    } else if (parseInt6 == 1) {
                        BusinessEntity.getInstance().switchLelink();
                    } else {
                        SourceLog.w(TAG, "OPTION_CHANGE_MIRROR invalid protocol:" + parseInt6);
                    }
                    break;
                } catch (Exception e17) {
                    SourceLog.w(TAG, e17);
                    return;
                }
            case IAPI.OPTION_CREATE_LELINK_SERVICE /* 2097158 */:
                try {
                    createLelinkServiceInfo(SinkParameterBean.formJson(objArr[0].toString()));
                    break;
                } catch (Exception e18) {
                    SourceLog.w(TAG, e18);
                    return;
                }
            case IAPI.OPTION_SET_DRAMA_ID /* 2097161 */:
                BusinessEntity.getInstance().playDrama(objArr[0].toString());
                break;
            case IAPI.OPTION_OVERLAY_PERMISSION /* 2097170 */:
                try {
                    i11 = Integer.parseInt(objArr[0].toString());
                } catch (Exception e19) {
                    SourceLog.w(TAG, e19);
                    i11 = 1;
                }
                SourceLog.i(TAG, "OPTION_OVERLAY_PERMISSION enable:" + i11);
                Preference.getInstance().put(Constant.KEY_REQUEST_SYSTEM_WINDOW_PERMISS, i11 != 0);
                break;
            case IAPI.OPTION_MICRO_PASS /* 2097171 */:
                PassSender.getInstance().sendMicroPass(objArr[0].toString(), "", Integer.parseInt(objArr[1].toString()));
                break;
            case IAPI.OPTION_STOP_MICRO /* 2097172 */:
                PassSender.getInstance().sendStopMicro("", Integer.parseInt(objArr[0].toString()));
                break;
            case IAPI.OPTION_SELECT_TRACK /* 2097174 */:
                if (BusinessEntity.getInstance().getLastPlayInfo() == null) {
                    SourceLog.i(TAG, "danmaku ignore");
                    break;
                } else {
                    try {
                        selectAudiotrack(Integer.parseInt(objArr[0].toString()));
                        break;
                    } catch (Exception e20) {
                        SourceLog.w(TAG, e20);
                        return;
                    }
                }
            case IAPI.OPTION_TEMP_RESTRICT /* 2097175 */:
                try {
                    if (!isMirroring() && !isPushing()) {
                        SourceLog.i(TAG, "sendTempRestrict ignore, try again when casting");
                        break;
                    }
                    PassSender.getInstance().sendTempRestrict("", Boolean.parseBoolean(objArr[0].toString()));
                } catch (Exception e21) {
                    SourceLog.w(TAG, e21);
                    return;
                }
                break;
            case IAPI.OPTION_MIRROR_NOTIFICATION /* 2097176 */:
                try {
                    r7 = Boolean.parseBoolean(objArr[0].toString());
                } catch (Exception e22) {
                    SourceLog.w(TAG, e22);
                }
                SourceLog.i(TAG, "OPTION_MIRROR_NOTIFICATION enable:" + r7);
                Preference.getInstance().put(Constant.KEY_MIRROR_NOTIFICATION, r7);
                break;
            case IAPI.OPTION_DISABLE_CLOUD_CAST /* 2097184 */:
                Session.getInstance().disableIM(Boolean.parseBoolean(objArr[0].toString()));
                break;
            case IAPI.OPTION_MIRROR_WATERMARK_INFO /* 2097185 */:
                Object obj10 = objArr[0];
                setWatermarkInfo(obj10 instanceof String ? (String) obj10 : null);
                break;
            case IAPI.OPTION_MIRROR_WATERMARK_SWITCH /* 2097186 */:
                getInstance().setWatermarkVisible(Boolean.parseBoolean(objArr[0].toString()));
                break;
            case IAPI.OPTION_REGISTER_LISTENER_BY_COMMON /* 2097187 */:
                CommonListenerWrapper.getInstance().registerListener(objArr);
                break;
            case IAPI.OPTION_UNREGISTER_LISTENER_BY_COMMON /* 2097188 */:
                CommonListenerWrapper.getInstance().unRegisterListener(objArr);
                break;
            case IAPI.OPTION_NOTIFY_SINK_MIRROR /* 2097189 */:
                PassSender.getInstance().sendNotifyMirrorMsg(NotifyMirrorBean.formJSON(objArr[0].toString()));
                break;
            case IAPI.OPTION_NOTIFY_REMOTE_SERVER /* 2097190 */:
                PassSender.getInstance().sendNotifyRemoteMsg(objArr[0].toString(), Integer.parseInt(objArr[1].toString()), Integer.parseInt(objArr[2].toString()));
                break;
            case IAPI.OPTION_PERMISSION_MODE /* 2097191 */:
                if (LelinkConfig.isSdkFree()) {
                    SourceLog.w(TAG, "OPTION_PERMISSION_MODE ignore, sdk is free");
                    break;
                } else {
                    try {
                        int parseInt7 = Integer.parseInt(objArr[0].toString());
                        SourceLog.i(TAG, "OPTION_PERMISSION_MODE mode:" + parseInt7);
                        Preference.getInstance().put(Preference.KEY_PERMISSION_MODE, parseInt7);
                        if (parseInt7 == 1) {
                            if (objArr.length > 1) {
                                Preference.getInstance().put(Preference.KEY_LICENSE_TSN, objArr[1].toString());
                            }
                            LicenseManager.getInstance().requestLicense(this.mContext);
                            break;
                        }
                    } catch (Exception e23) {
                        SourceLog.w(TAG, "OPTION_PERMISSION_MODE :" + e23);
                        return;
                    }
                }
                break;
            case IAPI.OPTION_MIRROR_SCREEN_SECRET /* 2097192 */:
                getInstance().setMirrorScreenSecret(Boolean.parseBoolean(objArr[0].toString()));
                break;
            case IAPI.OPTION_CHANGE_SINK_HOST_SETTING /* 2097193 */:
                PassSender.getInstance().sendSinkHostSettingMsg(objArr[0].toString());
                break;
            case IAPI.OPTION_CHANGE_SINK_PAINT /* 2097200 */:
                PassSender.getInstance().sendChangeSinkPaint(objArr[0].toString());
                break;
            case IAPI.OPTION_MIRROR_ROTATION /* 2097202 */:
                if (objArr.length > 1) {
                    CaptureBridge.getInstance().setRotation(Integer.parseInt(objArr[0].toString()), Boolean.parseBoolean(objArr[1].toString()));
                    break;
                }
                break;
            case IAPI.OPTION_SET_CONNECT_DEVICE /* 2097203 */:
                try {
                    HistoryConfigBean formJSON2 = HistoryConfigBean.formJSON(objArr[0].toString());
                    if (formJSON2 != null) {
                        ConnectManager.getInstance().setConnectDeviceReport(formJSON2);
                        break;
                    }
                } catch (Exception e24) {
                    SourceLog.w(TAG, e24);
                    return;
                }
                break;
            case IAPI.OPTION_MIRROR_NOTIFY_TYPE /* 2097204 */:
                try {
                    i12 = Integer.parseInt(objArr[0].toString());
                } catch (Exception e25) {
                    SourceLog.w(TAG, e25);
                }
                SourceLog.i(TAG, "OPTION_MIRROR_NOTIFY_TYPE :" + i12);
                Preference.getInstance().put(Constant.KEY_MIRROR_NOTIFY_TYPE, i12);
                break;
            case IAPI.OPTION_SEND_HARASS_CODE /* 2097205 */:
                String obj11 = objArr[0].toString();
                int canSend = HarassCode.getInstance().canSend(obj11);
                if (canSend != 0) {
                    if (canSend == 1 && BusinessEntity.getInstance().getListenerDispatcher() != null) {
                        BusinessEntity.getInstance().getListenerDispatcher().onInfo((OutParameter) null, 47, "");
                        break;
                    }
                } else {
                    PassSender.getInstance().sendHarassCode(obj11);
                    break;
                }
                break;
            case IAPI.OPTION_CLOUD_MULTI_CAST /* 2097206 */:
                try {
                    i12 = Integer.parseInt(objArr[0].toString());
                } catch (Exception e26) {
                    SourceLog.w(TAG, e26);
                }
                SourceLog.i(TAG, "OPTION_CLOUD_MULTI_CAST :" + i12);
                Preference.getInstance().put(Constant.KEY_CLOUD_MULTI_CAST, i12);
                break;
            case IAPI.OPTION_SET_FRAME_RATE /* 2097209 */:
                try {
                    SourceLog.i(TAG, "========OPTION_SET_FRAME_RATE=========" + objArr[0]);
                    Preference.getInstance().put(Preference.KEY_MIRROR_FPS, Integer.parseInt(objArr[0].toString()));
                    CaptureBridge.getInstance().setFrameRate(0, Integer.parseInt(objArr[0].toString()));
                    break;
                } catch (Exception e27) {
                    SourceLog.w(TAG, e27);
                    return;
                }
            case IAPI.OPTION_BROWSER_HISTORY /* 2097216 */:
                try {
                    BrowserConfigBean formJSON3 = BrowserConfigBean.formJSON(objArr[0].toString());
                    if (formJSON3 != null) {
                        startBrowseHisThread(formJSON3);
                        break;
                    }
                } catch (Exception e28) {
                    SourceLog.w(TAG, e28);
                    return;
                }
                break;
            case IAPI.OPTION_MIRROR_REUSE_DISPLAY /* 2097217 */:
                try {
                    CaptureBridge.getInstance().setDisplayReuse(Boolean.parseBoolean(objArr[0].toString()));
                    break;
                } catch (Exception e29) {
                    SourceLog.w(TAG, e29);
                    return;
                }
            case IAPI.OPTION_RESIZE_MIRROR_SCREEN /* 2097218 */:
                try {
                    CaptureBridge.getInstance().resize(Integer.parseInt(objArr[0].toString()));
                    break;
                } catch (Exception e30) {
                    SourceLog.w(TAG, e30);
                    return;
                }
            case IAPI.OPTION_SOURCE_ID /* 2097219 */:
                try {
                    String obj12 = objArr[0].toString();
                    String md5EncryData = EncryptUtil.md5EncryData(obj12);
                    SourceLog.i(TAG, "OPTION_SOURCE_ID: " + obj12 + " / " + md5EncryData);
                    Session.getInstance().setSourceID(md5EncryData);
                    break;
                } catch (Exception e31) {
                    SourceLog.w(TAG, e31);
                    return;
                }
            case IAPI.OPTION_ENABLE_HISTORY_DEV /* 2097220 */:
                try {
                    boolean parseBoolean2 = Boolean.parseBoolean(objArr[0].toString());
                    Preference.getInstance().put(Constant.KEY_ENABLE_HISTORY_DEV, parseBoolean2);
                    SourceLog.i(TAG, "OPTION_ENABLE_HISTORY_DEV: " + parseBoolean2);
                    break;
                } catch (Exception e32) {
                    SourceLog.w(TAG, e32);
                    return;
                }
            case IAPI.OPTION_CREATE_LELINK_SERVICE_LIST /* 2097221 */:
                SourceLog.i(TAG, "createLelinkServiceInfoList OPTION_CREATE_LELINK_SERVICE_LIST ");
                try {
                    JSONArray jSONArray = new JSONArray(objArr[0].toString());
                    ArrayList arrayList = new ArrayList();
                    while (i12 < jSONArray.length()) {
                        String str6 = (String) jSONArray.get(i12);
                        SourceLog.i(TAG, "createLelinkServiceInfoList OPTION_CREATE_LELINK_SERVICE_LIST :" + str6);
                        arrayList.add(SinkParameterBean.formJson(str6));
                        i12++;
                    }
                    createLelinkServiceInfoList(arrayList);
                    break;
                } catch (Exception e33) {
                    SourceLog.w(TAG, e33);
                    return;
                }
            case IAPI.OPTION_ENCODE_ERROR_EXIT_MIRROR /* 2097222 */:
                if (objArr.length > 0) {
                    Preference.getInstance().put(Preference.KEY_ENCODE_ERROR_EXIT_MIRROR, objArr[0].toString().equals("true"));
                    break;
                }
                break;
            case IAPI.OPTION_SET_RESOLUTION /* 2097223 */:
                try {
                    OptionCentral.setResolution(Integer.parseInt(objArr[0].toString()), Integer.parseInt(objArr[1].toString()));
                    break;
                } catch (Exception e34) {
                    SourceLog.w(TAG, e34);
                    return;
                }
            case IAPI.OPTION_SET_NOTIFICATION_PID /* 2097224 */:
                try {
                    OptionCentral.NOTIFICATION_PID = Integer.parseInt(objArr[0].toString());
                    break;
                } catch (Exception e35) {
                    SourceLog.w(TAG, e35);
                    return;
                }
            case IAPI.OPTION_SET_RC_EVENT_NO_FILTER /* 2097225 */:
                try {
                    OptionCentral.RC_CONTROL_NO_FILTER = Boolean.parseBoolean(objArr[0].toString());
                    SourceLog.i(TAG, "RC_CONTROL_NO_FILTER " + OptionCentral.RC_CONTROL_NO_FILTER);
                    break;
                } catch (Exception e36) {
                    SourceLog.w(TAG, e36);
                    return;
                }
            case IAPI.OPTION_SET_MIRROR_VIRTUAL_DISPLAY_NAME /* 2097232 */:
                try {
                    OptionCentral.disPlayName = objArr[0].toString();
                    SourceLog.i(TAG, "OPTION_SET_MIRROR_VIRTUAL_DISPLAY_NAME " + OptionCentral.disPlayName);
                    break;
                } catch (Exception e37) {
                    SourceLog.w(TAG, e37);
                    return;
                }
            case IAPI.OPTION_SET_QCOM_OPT_BITRATE /* 2097233 */:
                try {
                    OptionCentral.isOptBitrate = Boolean.parseBoolean(objArr[0].toString());
                    SourceLog.i(TAG, "OPTION_SET_QCOM_OPT_BITRATE " + OptionCentral.isOptBitrate);
                    break;
                } catch (Exception e38) {
                    SourceLog.w(TAG, e38);
                    return;
                }
            case IAPI.OPTION_SET_RECEIVER_PROPERTY /* 2097234 */:
                try {
                    SourceLog.i(TAG, "OPTION_SET_RECEIVER_PROPERTY" + objArr[0]);
                    PassSender.getInstance().sendReceiverProperty(ReceiverPropertyBean.fromString(objArr[0].toString()).toJson());
                    break;
                } catch (Exception e39) {
                    SourceLog.w(TAG, e39);
                    return;
                }
            case IAPI.OPTION_GET_RECEIVER_PROPERTIES /* 2097235 */:
                try {
                    SourceLog.i(TAG, "OPTION_GET_RECEIVER_PROPERTIES");
                    PassSender.getInstance().sendReceiverPropertiesSync();
                    break;
                } catch (Exception e40) {
                    SourceLog.w(TAG, e40);
                    return;
                }
            case IAPI.OPTION_SET_DLNA_CUSTOM_IDS /* 2097236 */:
                try {
                    OptionCentral.SET_DLNA_CUSTOM_IDS = Boolean.parseBoolean(objArr[0].toString());
                    SourceLog.i(TAG, "OPTION_SET_DLNA_CUSTOM_IDS " + OptionCentral.SET_DLNA_CUSTOM_IDS);
                    break;
                } catch (Exception e41) {
                    SourceLog.w(TAG, e41);
                    return;
                }
            case IAPI.OPTION_SET_OPTIONAL_CAPTURE /* 2097237 */:
                try {
                    SourceLog.i(TAG, "OPTION_SET_OPTIONAL_CAPTURE,value: " + objArr[0]);
                    OptionCentral.isOptionalCapture = Boolean.parseBoolean(objArr[0].toString());
                    break;
                } catch (Exception e42) {
                    SourceLog.w(TAG, e42);
                    return;
                }
            case IAPI.OPTION_PLAY_NEXT_DRAMA /* 33554448 */:
                BusinessEntity.getInstance().playNextDrama();
                break;
            case IAPI.OPTION_PLAY_PRE_DRAMA /* 33554449 */:
                BusinessEntity.getInstance().playPreDrama();
                break;
        }
    }

    public void setPassCallback(ISendPassCallback iSendPassCallback) {
        this.mPassCallback = iSendPassCallback;
    }

    public void setPlayerListener(ILelinkPlayerListener iLelinkPlayerListener) {
        BusinessEntity.getInstance().setPlayerListener(iLelinkPlayerListener);
    }

    public void setReceiverPropertiesCallback(IReceiverPropertiesCallback iReceiverPropertiesCallback) {
        this.mReceiverPropertiesCallback = iReceiverPropertiesCallback;
    }

    public void setRelevantInfoListener(IRelevantInfoListener iRelevantInfoListener) {
        this.mOuterRelevantInfoListener = iRelevantInfoListener;
    }

    public void setRetryBrowseListener(IBrowseListener iBrowseListener) {
        BrowserDispatcher browserDispatcher = this.mBrowserDispatcher;
        if (browserDispatcher != null) {
            browserDispatcher.setRetryBrowseListener(iBrowseListener);
        }
    }

    public void setSearchBannerDataCallback(ISearchBannerDataCallback iSearchBannerDataCallback) {
        this.mSearchBannerDataCallback = iSearchBannerDataCallback;
    }

    public void setSecondMirrorView(SecondMirrorView secondMirrorView) {
        this.mSecondMirrorView = secondMirrorView;
        PlayController lastPlayController = BusinessEntity.getInstance().getLastPlayController();
        if (lastPlayController == null) {
            SourceLog.w(TAG, "setSecondMirrorView ignore 2 ");
            return;
        }
        SourceLog.i(TAG, "setSecondMirrorView " + secondMirrorView);
        lastPlayController.getPlayInfo().secondMirrorView = this.mSecondMirrorView;
        lastPlayController.setSecondMirrorView(secondMirrorView);
    }

    public void setServiceInfoListParseListener(IServiceInfoListParseListener iServiceInfoListParseListener) {
        this.mOuterParseListListener = iServiceInfoListParseListener;
    }

    public void setServiceInfoParseListener(IServiceInfoParseListener iServiceInfoParseListener) {
        this.mOuterParseListener = iServiceInfoParseListener;
    }

    public void setSinkKeyEventListener(final ISinkKeyEventListener iSinkKeyEventListener) {
        if (iSinkKeyEventListener == null) {
            return;
        }
        if (!canReverseControl()) {
            SourceLog.w(TAG, "setSinkKeyEventListener ignore, this channel not support this feature");
            return;
        }
        SourceLog.i(TAG, "setSinkKeyEventListener " + iSinkKeyEventListener);
        SinkKeyEventDispatcher.getInstance().setSinkKeyEventListener(new ISinkKeyEventListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.20
            @Override // com.hpplay.sdk.source.api.ISinkKeyEventListener
            public void onKeyEvent(final KeyEvent keyEvent) {
                LelinkSdkManager.this.mHandler.post(new Runnable() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.20.1
                    @Override // java.lang.Runnable
                    public void run() {
                        iSinkKeyEventListener.onKeyEvent(keyEvent);
                    }
                });
            }
        });
    }

    public void setSinkTouchEventListener(SinkTouchEventArea sinkTouchEventArea, float f10, final ISinkTouchEventListener iSinkTouchEventListener) {
        if (iSinkTouchEventListener == null) {
            return;
        }
        if (!canReverseControl()) {
            SourceLog.w(TAG, "setSinkTouchEventListener ignore, this channel not support this feature");
            return;
        }
        SourceLog.i(TAG, "setSinkTouchEventListener " + iSinkTouchEventListener);
        SinkTouchEventMonitor.getInstance().setTouchEventArea(sinkTouchEventArea);
        SinkTouchEventMonitor.getInstance().setTouchScaleModulus(f10);
        SinkTouchEventDispatcher.getInstance().setSinkTouchEventListener(new ISinkTouchEventListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.21
            @Override // com.hpplay.sdk.source.api.ISinkTouchEventListener
            public void onTouchEvent(final MotionEvent motionEvent) {
                LelinkSdkManager.this.mHandler.post(new Runnable() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        iSinkTouchEventListener.onTouchEvent(motionEvent);
                    }
                });
            }
        });
    }

    public void setSystemApp(boolean z10) {
        Preference.getInstance().put(Constant.KEY_IS_SYSTEM_APP, z10);
    }

    public void setVolume(int i10) {
        BusinessEntity.getInstance().setVolume(i10);
    }

    public void setWatermarkInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.w(TAG, "setWatermarkInfo values ignore");
        } else {
            Preference.getInstance().put(Preference.KEY_MIRROR_WATERMARK_OBJ_JSON_STR, str);
        }
    }

    public void setWatermarkVisible(boolean z10) {
        SourceLog.i(TAG, "setWatermarkVisible isVisible:" + z10);
        Preference.getInstance().put(Preference.KEY_MIRROR_WATERMARK_SWITCH, z10);
        BusinessEntity.getInstance().setWatermarkVisible(z10);
    }

    public void startBrowseHisThread(BrowserConfigBean browserConfigBean) {
        stopBrowseThread();
        clearBrowserList();
        historyBrowse(browserConfigBean);
    }

    public void startBrowseThread() {
        startBrowseThread(this.mBrowserConfig);
    }

    public void startExpandMirror(LelinkPlayerInfo lelinkPlayerInfo) {
        LelinkServiceInfo lelinkServiceInfo;
        if (lelinkPlayerInfo == null) {
            SourceLog.w(TAG, "startExpandMirror ignore,LelinkPlayerInfo is null");
            return;
        }
        if (isMirroring()) {
            OutParameter lastPlayInfo = BusinessEntity.getInstance().getLastPlayInfo();
            if (lelinkPlayerInfo.getLelinkServiceInfo() != null && lastPlayInfo != null && (lelinkServiceInfo = lastPlayInfo.serviceInfo) != null && lelinkServiceInfo.equals(lelinkPlayerInfo.getLelinkServiceInfo())) {
                SourceLog.i(TAG, "startExpandMirror is mirroring now, use switchExpansionScreen");
                switchExpansionScreen(true);
                return;
            }
        }
        this.mRetryMirrorOnce.set(true);
        startMirror(lelinkPlayerInfo, true);
    }

    public void startMirror(LelinkPlayerInfo lelinkPlayerInfo) {
        this.mRetryMirrorOnce.set(false);
        startMirror(lelinkPlayerInfo, false);
    }

    public void startOnlineCheck(IAPICallbackListener iAPICallbackListener, List<LelinkServiceInfo> list) {
        if (iAPICallbackListener != null && list != null) {
            try {
                OnlineCheckThread onlineCheckThread = this.mOnlineCheckThread;
                if (onlineCheckThread == null || onlineCheckThread.isCompletion()) {
                    OnlineCheckThread onlineCheckThread2 = new OnlineCheckThread(iAPICallbackListener, list);
                    this.mOnlineCheckThread = onlineCheckThread2;
                    onlineCheckThread2.start();
                    return;
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
        SourceLog.w(TAG, "setInteractListener values is Invalid");
    }

    public void startPlayCheck(LelinkPlayerInfo lelinkPlayerInfo) {
        if (lelinkPlayerInfo == null) {
            SourceLog.w(TAG, "startPlayMedia ignore, invalid player info");
            return;
        }
        if (TextUtils.isEmpty(lelinkPlayerInfo.getUrl()) && TextUtils.isEmpty(lelinkPlayerInfo.getLocalPath()) && lelinkPlayerInfo.getLoaclUri() == null) {
            SourceLog.e(TAG, "startPlayMedia ignore, invalid url");
            return;
        }
        createPreChecker();
        if (lelinkPlayerInfo.getLelinkServiceInfo() != null) {
            SourceLog.i(TAG, " new device start check ");
            lelinkPlayerInfo.setLelinkServiceInfo(lelinkPlayerInfo.getLelinkServiceInfo());
            this.mDevicePreChecker.setOnDevicePreCheckResult(lelinkPlayerInfo.getLelinkServiceInfo(), new DevicePreCheckCallback(lelinkPlayerInfo));
        } else if (ConnectManager.getInstance().getLastServiceInfo() == null) {
            startPlay(lelinkPlayerInfo);
        } else {
            SourceLog.i(TAG, " connected device start check ");
            this.mDevicePreChecker.setOnDevicePreCheckResult(ConnectManager.getInstance().getLastServiceInfo(), new DevicePreCheckCallback(lelinkPlayerInfo));
        }
    }

    public void startPlayMedia(LelinkServiceInfo lelinkServiceInfo, String str, int i10, boolean z10) {
        startPlayMedia(lelinkServiceInfo, null, str, i10, z10);
    }

    public void startRenderCloudMirror(String str, String str2, String str3, String str4) {
        if (!LelinkConfig.isSupportYimMirror()) {
            SourceLog.w(TAG, "startRenderCloudMirror ignore, cloud mirror not support");
            return;
        }
        Intent intent = new Intent(this.mContext, (Class<?>) MirrorPlayerActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("session", str3);
        intent.putExtra("uri", str4);
        intent.putExtra(MirrorPlayerActivity.f7705c, str);
        intent.putExtra(MirrorPlayerActivity.f7706d, str2);
        this.mContext.startActivity(intent);
    }

    public void stopBrowse() {
        SourceLog.i(TAG, "stopBrowse");
        RelationReportTask.getInstance().stopBrowser();
        BrowserBridge.getInstance().stopBrowse();
        if (SonicProxy.canStartSonicBrowse(this.mContext)) {
            SonicProxy.stopBrowse(this.mContext);
        }
        if (LelinkConfig.isPublishBlueToothEnable(this.mContext) == 1) {
            BleProxy.stopPublish(this.mContext);
        }
        if (LelinkConfig.isBrowserBlueToothEnable(this.mContext) == 1) {
            BleProxy.stopBrowse(this.mContext);
        }
        this.mBrowserDispatcher.stopBrowser();
        ServiceUpdater.getInstance().updateServiceInfo(this.mContext);
    }

    public void stopBrowseThread() {
        stopBrowseThread(true);
    }

    public void stopExpandMirror() {
        stopPlay();
        SourceLog.flushLogWriter();
    }

    public void stopPlay() {
        BusinessEntity businessEntity = BusinessEntity.getInstance();
        if (businessEntity != null) {
            businessEntity.stop(1000);
        }
        SourceLog.flushLogWriter();
    }

    public void stopPlayWithCallback(int i10) {
        BusinessEntity businessEntity = BusinessEntity.getInstance();
        if (businessEntity != null) {
            businessEntity.stopWithCallback(i10);
        }
        SourceLog.flushLogWriter();
    }

    public void subVolume() {
        BusinessEntity.getInstance().subVolume();
    }

    public void switchExpansionScreen(boolean z10) {
        if ((this.mExpandActivity == null || this.mExpandView == null) && z10) {
            SourceLog.w(TAG, "switchExpansionScreen ignore");
            return;
        }
        PlayController lastPlayController = BusinessEntity.getInstance().getLastPlayController();
        if (lastPlayController == null) {
            SourceLog.w(TAG, "switchExpansionScreen ignore 2 " + z10);
            return;
        }
        SourceLog.i(TAG, "switchExpansionScreen " + z10);
        lastPlayController.getPlayInfo().expandActivity = this.mExpandActivity;
        lastPlayController.getPlayInfo().expandView = this.mExpandView;
        lastPlayController.switchExpansionScreen(z10);
    }

    public void updateAudioData(byte[] bArr, AudioFrameBean audioFrameBean) {
        OptionCentral.updateAudioData(bArr, audioFrameBean);
    }

    public void updateVideoData(byte[] bArr, VideoFrameBean videoFrameBean) {
        OptionCentral.updateVideoData(bArr, videoFrameBean);
    }

    public void uploadLog(String str, String str2) {
        String createEid = CreateUtil.createEid();
        LogUpload.uploadLogFile(this.mContext, null, createEid, str, str2, new UploadLogCallback() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.18
            @Override // com.hpplay.sdk.source.utils.UploadLogCallback
            public void uploadStatus(int i10) {
                SourceLog.i(LelinkSdkManager.TAG, "uploadStatus i =" + i10);
                LelinkSdkManager.this.uploadLogStatus(i10);
            }
        });
        LelinkServiceInfo lastServiceInfo = ConnectManager.getInstance().getLastServiceInfo();
        if (lastServiceInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ParamsMap.DeviceParams.KEY_UID, lastServiceInfo.getUid());
            jSONObject.put("manifestVer", 1);
            jSONObject.put("euqid", createEid);
            jSONObject.put("et", str);
            PassSender.getInstance().syncLogReport(lastServiceInfo, jSONObject.toString());
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void startBrowseThread(boolean z10, boolean z11) {
        BrowserConfigBean browserConfigBean = new BrowserConfigBean();
        browserConfigBean.useLelink = z10;
        browserConfigBean.useDlna = z11;
        startBrowseThread(browserConfigBean);
    }

    public void startPlayMedia(LelinkServiceInfo lelinkServiceInfo, final LelinkPlayerInfo lelinkPlayerInfo, final String str, final int i10, final boolean z10) {
        if (lelinkServiceInfo == null && !CastUtil.isSupportCloudMultiCast()) {
            SourceLog.w(TAG, "startPlayMedia ignore, invalid service info");
            return;
        }
        final LelinkServiceInfo findSameServiceInfo = findSameServiceInfo(lelinkServiceInfo);
        if (z10 && ContextCompat.checkSelfPermission(this.mContext, "android.permission.READ_EXTERNAL_STORAGE") == -1) {
            SourceLog.i(TAG, " not permission ");
            this.mPermissionListener = new OnRequestPermissionListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.12
                @Override // com.hpplay.sdk.source.permission.OnRequestPermissionListener
                public void onNotifyCast(Intent intent) {
                    LelinkSdkManager lelinkSdkManager = LelinkSdkManager.this;
                    lelinkSdkManager.mPermissionListener = null;
                    lelinkSdkManager.startPlayMedia(findSameServiceInfo, lelinkPlayerInfo, str, i10, z10);
                }
            };
            startGetSDCardPermission(this.mContext);
            return;
        }
        if (z10) {
            if (i10 == 103 && Build.VERSION.SDK_INT >= 28 && !TextUtils.isEmpty(str) && (str.endsWith(".heic") || str.endsWith(".HEIC"))) {
                SourceLog.i(TAG, "startPlayMedia,is heic local photo");
                AsyncManager.getInstance().exeRunnable(new Runnable() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.13
                    @Override // java.lang.Runnable
                    public void run() {
                        HeicBean heicBean = new HeicBean();
                        heicBean.lelinkServiceInfo = findSameServiceInfo;
                        LelinkPlayerInfo lelinkPlayerInfo2 = lelinkPlayerInfo;
                        heicBean.lelinkPlayerInfo = lelinkPlayerInfo2;
                        heicBean.path = LelinkSdkManager.this.heicChangeToJpeg(str, lelinkPlayerInfo2.getParams());
                        heicBean.type = i10;
                        Message obtainMessage = LelinkSdkManager.this.mHandler.obtainMessage();
                        obtainMessage.what = 3;
                        obtainMessage.obj = heicBean;
                        LelinkSdkManager.this.mHandler.sendMessage(obtainMessage);
                    }
                }, null);
                return;
            }
            str = LelinkServerInstance.getInstance().getFileDownloadUrl(str, lelinkPlayerInfo.getParams());
        }
        startPlayMediaAfterCheck(findSameServiceInfo, lelinkPlayerInfo, str, i10);
    }

    public void stopBrowseThread(boolean z10) {
        if (this.mBrowserThread != null && System.currentTimeMillis() - this.mPreBrowserTime > 200) {
            this.mBrowserThread.stopBrowser();
        }
        if (z10) {
            this.mBrowserDispatcher.notifyBrowserStop();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009a, code lost:
    
        if (r6.isUseSystemMirrorCapture() == false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void startMirror(final LelinkPlayerInfo lelinkPlayerInfo, final boolean z10) {
        boolean z11;
        if (!LelinkConfig.isSystemSupportMirror()) {
            SourceLog.w(TAG, "startMirror ignore,system not support");
            if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                BusinessEntity.getInstance().getListenerDispatcher().onError(null, 211000, 211004);
                return;
            }
            return;
        }
        if (!LelinkConfig.isSupportMirror()) {
            SourceLog.w(TAG, "startMirror ignore,mirror not support");
            if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                BusinessEntity.getInstance().getListenerDispatcher().onError(null, 211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_UNSUPPORTED);
                return;
            }
            return;
        }
        LelinkServiceInfo findSameServiceInfo = findSameServiceInfo(lelinkPlayerInfo.getLelinkServiceInfo());
        if (findSameServiceInfo != null) {
            lelinkPlayerInfo.setLelinkServiceInfo(findSameServiceInfo);
        }
        if (findSameServiceInfo != null && !CastUtil.isSinkSupportMirror(findSameServiceInfo)) {
            SourceLog.w(TAG, "startMirror ignore,mirror not support 2");
            if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                BusinessEntity.getInstance().getListenerDispatcher().onError(null, 211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_SINK_UNSUPPORTED);
                return;
            }
            return;
        }
        this.mMirrorPlayInfo = lelinkPlayerInfo;
        if (!OptionCentral.isExternalVideo()) {
            z11 = false;
            if (!Preference.getInstance().get(Constant.KEY_IS_SYSTEM_APP, false)) {
            }
        }
        z11 = true;
        if (z11) {
            startMirrorAfterCheck(null, lelinkPlayerInfo, z10);
            return;
        }
        try {
            this.mPermissionListener = new OnRequestPermissionListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.11
                @Override // com.hpplay.sdk.source.permission.OnRequestPermissionListener
                public void onNotifyCast(Intent intent) {
                    LelinkSdkManager lelinkSdkManager = LelinkSdkManager.this;
                    lelinkSdkManager.mPermissionListener = null;
                    lelinkSdkManager.startMirrorAfterCheck(intent, lelinkPlayerInfo, z10);
                }
            };
            Intent intent = new Intent(this.mContext, (Class<?>) PermissionBridgeActivity.class);
            if (lelinkPlayerInfo.isClearActivityTaskWhenStartMirror()) {
                intent.setFlags(268468224);
            } else {
                intent.setFlags(268435456);
            }
            intent.putExtra(PermissionBridgeActivity.KEY_PERMISSION_TYPE, 3);
            this.mContext.startActivity(intent);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void startBrowseThread(boolean z10, boolean z11, String str) {
        BrowserConfigBean browserConfigBean = new BrowserConfigBean();
        browserConfigBean.useLelink = z10;
        browserConfigBean.useDlna = z11;
        browserConfigBean.encryptNumberId = str;
        startBrowseThread(browserConfigBean);
    }

    public void startBrowseThread(final BrowserConfigBean browserConfigBean) {
        if (mIsFirstBrowser) {
            mIsFirstBrowser = false;
            e.d().a();
        }
        checkLicense(new LicenseManager.ILicenseCheckListener() { // from class: com.hpplay.sdk.source.process.LelinkSdkManager.8
            @Override // com.hpplay.sdk.source.business.cloud.LicenseManager.ILicenseCheckListener
            public void checkLicense(boolean z10) {
                if (z10) {
                    LelinkSdkManager.this.startBrowseInValidLicense(browserConfigBean);
                } else {
                    SourceLog.w(LelinkSdkManager.TAG, "startBrowseThread ignore, invalid license");
                }
            }
        });
    }
}
