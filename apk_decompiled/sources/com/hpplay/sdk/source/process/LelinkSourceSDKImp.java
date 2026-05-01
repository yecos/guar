package com.hpplay.sdk.source.process;

import android.content.Context;
import android.hardware.display.VirtualDisplay;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.sdk.source.a.a;
import com.hpplay.sdk.source.api.IBindSdkListener;
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
import com.hpplay.sdk.source.api.ISearchBannerDataCallback;
import com.hpplay.sdk.source.api.ISendPassCallback;
import com.hpplay.sdk.source.api.ISinkKeyEventListener;
import com.hpplay.sdk.source.api.ISinkTouchEventListener;
import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.bean.AudioFrameBean;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.SinkParameterBean;
import com.hpplay.sdk.source.bean.SinkTouchEventArea;
import com.hpplay.sdk.source.bean.VideoFrameBean;
import com.hpplay.sdk.source.browse.api.IAPI;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.ICreatePinCodeListener;
import com.hpplay.sdk.source.browse.api.ICreateShortUrlListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoListParseListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.config.LelinkConfig;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.process.LelinkServiceConnection;
import com.hpplay.sdk.source.z;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.List;

/* loaded from: classes3.dex */
public class LelinkSourceSDKImp implements ILelinkSourceSDK {
    private static final String TAG = "LelinkSourceSDKImp";
    private static LelinkSourceSDKImp sInstance;
    private a mAppLifecycleListen;
    private Context mContext;
    private LelinkServiceConnection mServiceConnection;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private LelinkServiceConnection.OnBindStatusListener mBindStatusListener = new LelinkServiceConnection.OnBindStatusListener() { // from class: com.hpplay.sdk.source.process.LelinkSourceSDKImp.1
        @Override // com.hpplay.sdk.source.process.LelinkServiceConnection.OnBindStatusListener
        public void onServiceConnected(z zVar) {
            if (LelinkSourceSDKImp.this.mImplProxy == null) {
                SourceLog.w(LelinkSourceSDKImp.TAG, "onServiceConnected ignore");
            } else {
                SourceLog.i(LelinkSourceSDKImp.TAG, "sdk bind successful");
                LelinkSourceSDKImp.this.mImplProxy.setMultiManager(zVar, LelinkSourceSDKImp.this.mServiceConnection);
            }
        }

        @Override // com.hpplay.sdk.source.process.LelinkServiceConnection.OnBindStatusListener
        public void onServiceDisconnected() {
            if (LelinkSourceSDKImp.this.mImplProxy == null) {
                SourceLog.w(LelinkSourceSDKImp.TAG, "onServiceDisconnected ignore");
            } else {
                SourceLog.i(LelinkSourceSDKImp.TAG, "sdk bind failed ");
                LelinkSourceSDKImp.this.mImplProxy.retryBind();
            }
        }
    };
    private a.InterfaceC0124a appLifecycleCallback = new a.InterfaceC0124a() { // from class: com.hpplay.sdk.source.process.LelinkSourceSDKImp.2
        @Override // com.hpplay.sdk.source.a.a.InterfaceC0124a
        public void onAppPause() {
            if (LelinkSourceSDKImp.this.mImplProxy == null) {
                SourceLog.w(LelinkSourceSDKImp.TAG, "onAppPause ignore");
            } else {
                SourceLog.i(LelinkSourceSDKImp.TAG, "===> app in background ");
                LelinkSourceSDKImp.this.mImplProxy.setOption(IAPI.OPTION_APP_PAUSE, new Object[0]);
            }
        }

        @Override // com.hpplay.sdk.source.a.a.InterfaceC0124a
        public void onAppResume() {
            if (LelinkSourceSDKImp.this.mImplProxy == null) {
                SourceLog.w(LelinkSourceSDKImp.TAG, "onAppResume ignore");
            } else {
                SourceLog.i(LelinkSourceSDKImp.TAG, "=====> app in Foreground ");
                LelinkSourceSDKImp.this.mImplProxy.setOption(IAPI.OPTION_APP_RESUME, new Object[0]);
            }
        }
    };
    private LelinkSourceSDKImpProxy mImplProxy = LelinkSourceSDKImpProxy.getInstance();

    private LelinkSourceSDKImp() {
    }

    private void currentProcessBind(String str, String str2, String str3, String str4, String str5) {
        if (this.mImplProxy == null) {
            SourceLog.w(TAG, "currentProcessBind ignore");
            return;
        }
        LelinkSdkManager lelinkSdkManager = LelinkSdkManager.getInstance();
        lelinkSdkManager.initSDK(this.mContext, str, str2, str3, str4, str5);
        this.mImplProxy.setSingleManager(lelinkSdkManager);
    }

    public static synchronized LelinkSourceSDKImp getInstance() {
        synchronized (LelinkSourceSDKImp.class) {
            synchronized (LelinkSourceSDKImp.class) {
                if (sInstance == null) {
                    sInstance = new LelinkSourceSDKImp();
                }
            }
            return sInstance;
        }
        return sInstance;
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void addFavoriteDevice(LelinkServiceInfo lelinkServiceInfo) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "addFavoriteDevice ignore");
        } else {
            lelinkSourceSDKImpProxy.addFavoriteDevice(lelinkServiceInfo);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void addPinCodeToLelinkServiceInfo(String str, IServiceInfoParseListener iServiceInfoParseListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "addPinCodeToLelinkServiceInfo ignore");
        } else {
            lelinkSourceSDKImpProxy.addPinCodeToLelinkServiceInfo(str, iServiceInfoParseListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void addQRCodeToLelinkServiceInfo(String str, IServiceInfoParseListener iServiceInfoParseListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "addQRCodeToLelinkServiceInfo ignore");
        } else {
            lelinkSourceSDKImpProxy.addQRCodeToLelinkServiceInfo(str, iServiceInfoParseListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void addVolume() {
        if (this.mImplProxy == null) {
            SourceLog.w(TAG, "addVolume ignore");
        } else {
            SourceLog.i(TAG, "addVolume");
            this.mImplProxy.addVolume();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "appendList ignore");
        } else {
            lelinkSourceSDKImpProxy.appendPlayList(dramaInfoBeanArr, i10, i11, i12);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void bindSdk(Context context, String str, String str2, IBindSdkListener iBindSdkListener) {
        bindSdk(context, str, str2, null, null, null, iBindSdkListener);
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public boolean canPlayLocalMedia(LelinkServiceInfo lelinkServiceInfo) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy != null) {
            return lelinkSourceSDKImpProxy.canPlayScreen(lelinkServiceInfo);
        }
        SourceLog.w(TAG, "canPlayLocalMedia ignore");
        return false;
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public boolean canPlayScreen(LelinkServiceInfo lelinkServiceInfo) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy != null) {
            return lelinkSourceSDKImpProxy.canPlayScreen(lelinkServiceInfo);
        }
        SourceLog.w(TAG, "canPlayScreen ignore");
        return false;
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void clearPlayList() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "clearList ignore");
        } else {
            lelinkSourceSDKImpProxy.clearPlayList();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void connect(LelinkServiceInfo lelinkServiceInfo) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "connect ignore");
        } else {
            lelinkSourceSDKImpProxy.connect(lelinkServiceInfo);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void createLelinkServiceInfo(SinkParameterBean sinkParameterBean, IServiceInfoParseListener iServiceInfoParseListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null || sinkParameterBean == null) {
            SourceLog.w(TAG, "createLelinkServiceInfo ignore");
        } else {
            lelinkSourceSDKImpProxy.createLelinkServiceInfo(sinkParameterBean, iServiceInfoParseListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void createLelinkServiceInfoList(List<SinkParameterBean> list, IServiceInfoListParseListener iServiceInfoListParseListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null || list == null) {
            SourceLog.w(TAG, "createLelinkServiceInfoList ignore");
        } else {
            lelinkSourceSDKImpProxy.createLelinkServiceInfoList(list, iServiceInfoListParseListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void createPinCode(ICreatePinCodeListener iCreatePinCodeListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "createPinCode ignore");
        } else {
            lelinkSourceSDKImpProxy.createPinCode(iCreatePinCodeListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void createShortUrl(ICreateShortUrlListener iCreateShortUrlListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "createShortUrl ignore");
        } else {
            lelinkSourceSDKImpProxy.createShortUrl(iCreateShortUrlListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public boolean disconnect(LelinkServiceInfo lelinkServiceInfo) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy != null) {
            return lelinkSourceSDKImpProxy.disconnect(lelinkServiceInfo);
        }
        SourceLog.w(TAG, "disconnect ignore");
        return false;
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public List<LelinkServiceInfo> getConnectInfos() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy != null) {
            return lelinkSourceSDKImpProxy.getConnectInfos();
        }
        SourceLog.w(TAG, "getConnectInfos ignore");
        return null;
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void getFavoriteDeviceList(int i10, int i11) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "getFavoriteDeviceList ignore");
        } else {
            lelinkSourceSDKImpProxy.getFavoriteDeviceList(i10, i11);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void getHistoryDeviceList(int i10, int i11) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "getHistoryDeviceList ignore");
        } else {
            lelinkSourceSDKImpProxy.getHistoryDeviceList(i10, i11);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public Object getOption(int i10, Object... objArr) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy != null) {
            return lelinkSourceSDKImpProxy.getOption(i10, objArr);
        }
        SourceLog.w(TAG, "getOption ignore");
        return null;
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public String getSDKInfos(int i10) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy != null) {
            return lelinkSourceSDKImpProxy.getSDKInfos(i10);
        }
        SourceLog.w(TAG, "getSDKInfos ignore");
        return null;
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public VirtualDisplay getVirtualDisplay() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy != null) {
            return lelinkSourceSDKImpProxy.getVirtualDisplay();
        }
        return null;
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void pause() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "pause ignore");
        } else {
            lelinkSourceSDKImpProxy.pause();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void removeFavoriteDevice(List<LelinkServiceInfo> list) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "removeFavoriteDevice ignore");
        } else {
            lelinkSourceSDKImpProxy.removeFavoriteDevice(list);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void removeHistoryDevice(List<LelinkServiceInfo> list, int i10) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "removeHistoryDeviceList ignore");
        } else {
            lelinkSourceSDKImpProxy.removeHistoryDevice(list, i10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void resume() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "resume ignore");
        } else {
            lelinkSourceSDKImpProxy.resume();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void seekTo(int i10) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "seekTo ignore");
        } else {
            lelinkSourceSDKImpProxy.seekTo(i10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setBrowseResultListener(IBrowseListener iBrowseListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setBrowseResultListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setBrowseResultListener(iBrowseListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setCommonListener(ICommonListener iCommonListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setCommonListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setCommonListener(iCommonListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setConnectListener(IConnectListener iConnectListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setConnectListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setConnectListener(iConnectListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setDaPlayListener(IDaPlayerListener iDaPlayerListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setDaPlayListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setDaPlayListener(iDaPlayerListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setDebugAVListener(IDebugAVListener iDebugAVListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setDebugAVListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setDebugAVListener(iDebugAVListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setDebugMode(boolean z10) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setDebugMode ignore");
        } else {
            lelinkSourceSDKImpProxy.setDebugMode(z10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setDebugTimestamp(boolean z10) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setDebugTimestamp ignore");
        } else {
            lelinkSourceSDKImpProxy.setDebugTimestamp(z10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setFavoriteDeviceAlias(LelinkServiceInfo lelinkServiceInfo, String str) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setFavoriteDeviceAlias ignore");
        } else {
            lelinkSourceSDKImpProxy.setFavoriteDeviceAlias(lelinkServiceInfo, str);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setFavoriteDeviceListener(IFavoriteDeviceListener iFavoriteDeviceListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setFavoriteDeviceListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setFavoriteDeviceListener(iFavoriteDeviceListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setHistoryDeviceListener(IHistoryDeviceListener iHistoryDeviceListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setHistoryDeviceListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setHistoryDeviceListener(iHistoryDeviceListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setLogCallback(ILogCallback iLogCallback) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setLogCallback ignore");
        } else {
            lelinkSourceSDKImpProxy.setLogCallback(iLogCallback);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setMirrorChangeListener(IMirrorChangeListener iMirrorChangeListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setMirrorChangeListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setMirrorChangeListener(iMirrorChangeListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setNewPlayListener(INewPlayerListener iNewPlayerListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setNewPlayListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setNewPlayListener(iNewPlayerListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setOption(int i10, Object... objArr) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setOption ignore");
        } else {
            lelinkSourceSDKImpProxy.setOption(i10, objArr);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setPlayListener(ILelinkPlayerListener iLelinkPlayerListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setPlayListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setPlayListener(iLelinkPlayerListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setSearchBannerDataCallback(ISearchBannerDataCallback iSearchBannerDataCallback) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setSearchBannerDataCallback ignore");
        } else {
            lelinkSourceSDKImpProxy.setSearchBannerDataCallback(iSearchBannerDataCallback);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setSendPassCallback(ISendPassCallback iSendPassCallback) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setSendPassCallback ignore");
        } else {
            lelinkSourceSDKImpProxy.setSendPassCallback(iSendPassCallback);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setSinkKeyEventListener(ISinkKeyEventListener iSinkKeyEventListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setSinkKeyEventListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setSinkKeyEventListener(iSinkKeyEventListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setSinkTouchEventListener(SinkTouchEventArea sinkTouchEventArea, float f10, ISinkTouchEventListener iSinkTouchEventListener) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "setSinkTouchEventListener ignore");
        } else {
            lelinkSourceSDKImpProxy.setSinkTouchEventListener(sinkTouchEventArea, f10, iSinkTouchEventListener);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void setVolume(int i10) {
        if (this.mImplProxy == null) {
            SourceLog.w(TAG, "setVolume ignore");
            return;
        }
        SourceLog.i(TAG, "setVolume " + i10);
        this.mImplProxy.setVolume(i10);
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void startBrowse(boolean z10, boolean z11) {
        if (this.mImplProxy == null) {
            SourceLog.w(TAG, "startBrowse ignore");
            return;
        }
        SourceLog.i(TAG, "startBrowse " + z10 + Operator.Operation.DIVISION + z11);
        this.mImplProxy.startBrowse(z10, z11);
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void startMirror(LelinkPlayerInfo lelinkPlayerInfo) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "startMirror ignore");
        } else {
            lelinkSourceSDKImpProxy.startMirror(lelinkPlayerInfo);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void startPlayMedia(String str, int i10, boolean z10) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "startPlayMedia ignore");
        } else {
            lelinkSourceSDKImpProxy.startPlayMedia(str, i10, z10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, String str, int i10, boolean z10) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "startPlayMediaImmed ignore");
        } else {
            lelinkSourceSDKImpProxy.startPlayMediaImmed(lelinkServiceInfo, str, i10, z10);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void stopBrowse() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "stopBrowse ignore");
        } else {
            lelinkSourceSDKImpProxy.stopBrowse();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void stopPlay() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "stopPlay ignore");
        } else {
            lelinkSourceSDKImpProxy.stopPlay();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void subVolume() {
        if (this.mImplProxy == null) {
            SourceLog.w(TAG, "subVolume ignore");
        } else {
            SourceLog.i(TAG, "subVolume");
            this.mImplProxy.subVolume();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void unBindSdk() {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "unBindSdk ignore");
            return;
        }
        lelinkSourceSDKImpProxy.unBindSdk();
        a aVar = this.mAppLifecycleListen;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void updateAudioData(byte[] bArr, AudioFrameBean audioFrameBean) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "updateAudioData ignore");
        } else {
            lelinkSourceSDKImpProxy.updateAudioData(bArr, audioFrameBean);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void updateVideoData(byte[] bArr, VideoFrameBean videoFrameBean) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "updateH264Data ignore");
        } else {
            lelinkSourceSDKImpProxy.updateVideoData(bArr, videoFrameBean);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void bindSdk(Context context, String str, String str2, String str3, IBindSdkListener iBindSdkListener) {
        bindSdk(context, str, str2, null, null, str3, iBindSdkListener);
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void bindSdk(Context context, final String str, final String str2, final String str3, final String str4, final String str5, final IBindSdkListener iBindSdkListener) {
        SourceLog.i(TAG, "bindSdk " + str);
        this.mContext = context.getApplicationContext();
        a aVar = new a();
        this.mAppLifecycleListen = aVar;
        aVar.a(this.appLifecycleCallback);
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.postDelayed(new Runnable() { // from class: com.hpplay.sdk.source.process.LelinkSourceSDKImp.3
            @Override // java.lang.Runnable
            public void run() {
                if (!LelinkConfig.isMultiProgress()) {
                    SourceLog.i(LelinkSourceSDKImp.TAG, "bindSdk app process callback");
                    iBindSdkListener.onBindCallback(true);
                    return;
                }
                SourceLog.i(LelinkSourceSDKImp.TAG, "bindSdk sdk process");
                Session session = Session.getInstance();
                session.appKey = str;
                session.appSecret = str2;
                session.userID = str3;
                String str6 = str5;
                session.oaID = str6;
                session.appVersion = str4;
                DeviceUtil.setOAID(str6);
                LelinkSourceSDKImp lelinkSourceSDKImp = LelinkSourceSDKImp.this;
                lelinkSourceSDKImp.mServiceConnection = new LelinkServiceConnection(lelinkSourceSDKImp.mContext, LelinkSourceSDKImp.this.mBindStatusListener);
                LelinkSourceSDKImp.this.mServiceConnection.setBindListener(iBindSdkListener);
                LelinkSourceSDKImp.this.mServiceConnection.startBind();
            }
        }, 500L);
        if (LelinkConfig.isMultiProgress()) {
            return;
        }
        SourceLog.i(TAG, "bindSdk app process");
        currentProcessBind(str, str2, str3, str5, str4);
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void startPlayMedia(LelinkPlayerInfo lelinkPlayerInfo) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "startPlayMedia ignore");
        } else {
            lelinkSourceSDKImpProxy.startPlayMedia(lelinkPlayerInfo);
        }
    }

    @Override // com.hpplay.sdk.source.api.ILelinkSourceSDK
    public void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, Uri uri, int i10) {
        LelinkSourceSDKImpProxy lelinkSourceSDKImpProxy = this.mImplProxy;
        if (lelinkSourceSDKImpProxy == null) {
            SourceLog.w(TAG, "startPlayMediaImmed ignore");
        } else {
            lelinkSourceSDKImpProxy.startPlayMediaImmed(lelinkServiceInfo, uri, i10);
        }
    }
}
