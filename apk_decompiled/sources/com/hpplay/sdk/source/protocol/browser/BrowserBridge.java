package com.hpplay.sdk.source.protocol.browser;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.asyncmanager.AsyncRunnableJob;
import com.hpplay.common.utils.NetworkUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.browse.IBrowseResultListener;
import com.hpplay.component.common.browse.IBrowser;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.sdk.source.bean.SinkServerDeviceBean;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.cloud.AuthSDK;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.business.cloud.ConnectRelationManager;
import com.hpplay.sdk.source.business.cloud.SDKConfig;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.device.ServiceUpdater;
import com.hpplay.sdk.source.easycast.BrowserDevice;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import com.hpplay.sdk.source.process.RelationReportTask;
import com.hpplay.sdk.source.utils.BrowserResolver;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class BrowserBridge {
    private static final int BROWSER_TIME_OUT = 50000;
    private static final String TAG = "BrowserBridge";
    private static boolean isReportSinkDeviceServer = false;
    private static BrowserBridge sInstance;
    private IBrowseListener mAppListener;
    private IBrowser mBrowser;
    private AsyncRunnableJob mBrowserTask;
    private Context mContext;
    private IServiceInfoParseListener mServiceInfoParseListener;
    private ConcurrentLinkedQueue<LelinkServiceInfo> mServiceQueue = new ConcurrentLinkedQueue<>();
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private boolean isBrowserSuccess = false;
    private Runnable mReportRunnable = new Runnable() { // from class: com.hpplay.sdk.source.protocol.browser.BrowserBridge.1
        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList(BrowserBridge.this.mServiceQueue);
            if (arrayList.size() > 0) {
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    if (((LelinkServiceInfo) arrayList.get(i10)).getTypes().contains("Lelink")) {
                        return;
                    }
                }
            }
            BrowserBridge browserBridge = BrowserBridge.this;
            browserBridge.postBrowserFailed(browserBridge.mContext);
        }
    };
    private Runnable mReportSinkDeviceRunnable = new Runnable() { // from class: com.hpplay.sdk.source.protocol.browser.BrowserBridge.2
        @Override // java.lang.Runnable
        public void run() {
            SourceLog.i(BrowserBridge.TAG, "mReportSinkDeviceRunnable,run");
            ArrayList<LelinkServiceInfo> arrayList = new ArrayList(BrowserBridge.this.mServiceQueue);
            if (arrayList.size() < 1) {
                SourceLog.i(BrowserBridge.TAG, "mReportSinkDeviceRunnable,info is empty");
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (LelinkServiceInfo lelinkServiceInfo : arrayList) {
                if (BrowserDevice.PACKAGE_NAME_SINK_APP.equalsIgnoreCase(lelinkServiceInfo.getPackageName())) {
                    SinkServerDeviceBean sinkServerDeviceBean = new SinkServerDeviceBean();
                    sinkServerDeviceBean.receiver_sdk_channel = "" + lelinkServiceInfo.getAppId();
                    sinkServerDeviceBean.receiver_sdk_user_id = lelinkServiceInfo.getUid();
                    arrayList2.add(sinkServerDeviceBean);
                }
                if (!TextUtils.isEmpty(lelinkServiceInfo.getTypes()) && lelinkServiceInfo.getTypes().contains("DLNA")) {
                    SinkServerDeviceBean sinkServerDeviceBean2 = new SinkServerDeviceBean();
                    sinkServerDeviceBean2.receiver_manufacturer = lelinkServiceInfo.getManufacturer();
                    sinkServerDeviceBean2.dlna_model_name = lelinkServiceInfo.getDLNAModeName();
                    sinkServerDeviceBean2.dlna_model_description = lelinkServiceInfo.getDLNAModeDes();
                    sinkServerDeviceBean2.dlna_uuid = lelinkServiceInfo.getUdnUuid();
                    arrayList3.add(sinkServerDeviceBean2);
                }
            }
            RelationReportTask.getInstance().reportSinkDevice(System.currentTimeMillis(), SinkServerDeviceBean.listToJsonString(arrayList2), SinkServerDeviceBean.listToJsonString(arrayList3));
        }
    };
    private Runnable mAutoStopRunnable = new Runnable() { // from class: com.hpplay.sdk.source.protocol.browser.BrowserBridge.3
        @Override // java.lang.Runnable
        public void run() {
            int i10;
            LelinkSdkManager.getInstance().stopBrowseThread(false);
            List<LelinkServiceInfo> browserList = LelinkSdkManager.getInstance().getBrowserList();
            if (browserList == null || browserList.isEmpty()) {
                SourceLog.w(BrowserBridge.TAG, "browse timeout");
                i10 = 3;
            } else {
                SourceLog.w(BrowserBridge.TAG, "browse auto stop");
                i10 = 2;
            }
            if (BrowserBridge.this.mAppListener != null) {
                BrowserBridge.this.mAppListener.onBrowse(i10, browserList);
            }
            BrowserBridge.this.reportSinkDevice();
        }
    };
    private final IBrowseResultListener mListener = new IBrowseResultListener() { // from class: com.hpplay.sdk.source.protocol.browser.BrowserBridge.4
        @Override // com.hpplay.component.common.browse.IBrowseResultListener
        public void onBrowseResultCallback(int i10, Object obj) {
            BrowserInfo resolveDevice;
            SourceLog.i(BrowserBridge.TAG, "onBrowseResultCallback " + i10);
            if (BrowserBridge.this.mAppListener == null) {
                SourceLog.w(BrowserBridge.TAG, "onBrowseResultCallback invalid app listener");
                return;
            }
            if (obj == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(obj.toString());
                if (i10 == 1) {
                    resolveDevice = BrowserResolver.resolveDevice(jSONObject);
                    BrowserHistory.getInstance().updateBrowserInfo(resolveDevice, 1, 0L);
                } else if (i10 != 2) {
                    resolveDevice = null;
                } else {
                    resolveDevice = BrowserResolver.resolveLelinkInfo(jSONObject);
                    BrowserHistory.getInstance().updateBrowserInfo(resolveDevice, 1, 0L);
                }
                BrowserBridge.this.resolveInfo(resolveDevice);
            } catch (Exception e10) {
                SourceLog.w(BrowserBridge.TAG, e10);
            }
            BrowserBridge.this.mAppListener.onBrowse(1, new ArrayList(BrowserBridge.this.mServiceQueue));
        }
    };

    /* renamed from: com.hpplay.sdk.source.protocol.browser.BrowserBridge$8, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$com$hpplay$common$utils$NetworkUtil$NetworkType;

        static {
            int[] iArr = new int[NetworkUtil.NetworkType.values().length];
            $SwitchMap$com$hpplay$common$utils$NetworkUtil$NetworkType = iArr;
            try {
                iArr[NetworkUtil.NetworkType.NETWORK_WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hpplay$common$utils$NetworkUtil$NetworkType[NetworkUtil.NetworkType.NETWORK_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$hpplay$common$utils$NetworkUtil$NetworkType[NetworkUtil.NetworkType.NETWORK_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$hpplay$common$utils$NetworkUtil$NetworkType[NetworkUtil.NetworkType.NETWORK_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private BrowserBridge() {
    }

    private boolean checkSDKUsable() {
        if (AuthSDK.getInstance().checkSdkUsable()) {
            return true;
        }
        if (this.mAppListener == null) {
            return false;
        }
        this.mAppListener.onBrowse(AuthSDK.getInstance().getAuthCode() == -101 ? -2 : -1, new ArrayList(this.mServiceQueue));
        return false;
    }

    public static synchronized BrowserBridge getInstance() {
        synchronized (BrowserBridge.class) {
            synchronized (BrowserBridge.class) {
                if (sInstance == null) {
                    sInstance = new BrowserBridge();
                }
            }
            return sInstance;
        }
        return sInstance;
    }

    private int getNetTypePost(Context context) {
        int i10 = AnonymousClass8.$SwitchMap$com$hpplay$common$utils$NetworkUtil$NetworkType[NetworkUtil.getNetworkType(context).ordinal()];
        return i10 != 1 ? (i10 == 2 || i10 == 3 || i10 == 4) ? 5 : 0 : NetworkUtil.getWifiType(context) == 0 ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postBrowserFailed(Context context) {
        NetworkUtil.NetworkType networkType = NetworkUtil.getNetworkType(context);
        String wifiBSSIDNoneColon = NetworkUtil.getWifiBSSIDNoneColon(context);
        SourceLog.debug(TAG, "BrowserFailed no Lelink device browsered in 15 s, BSSID: " + wifiBSSIDNoneColon);
        if (networkType != NetworkUtil.NetworkType.NETWORK_WIFI || TextUtils.isEmpty(wifiBSSIDNoneColon)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ParamsMap.DeviceParams.KEY_APPID, Integer.valueOf(Session.getInstance().appKey));
            jSONObject.put(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
            if (!TextUtils.isEmpty(wifiBSSIDNoneColon)) {
                jSONObject.put("bssid", wifiBSSIDNoneColon.toUpperCase());
            }
            jSONObject.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, a.a());
            jSONObject.put("sdkVer", "4.12.14");
            jSONObject.put("net", getNetTypePost(context));
            jSONObject.put(ParamsMap.DeviceParams.KEY_HID, Session.getInstance().getHID());
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sGLSBRoot + "/goapi/v1/bmatch", jSONObject.toString());
        asyncHttpParameter.in.requestMethod = 1;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.protocol.browser.BrowserBridge.6
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                SourceLog.debug(BrowserBridge.TAG, "browser failed post onRequestResult = " + asyncHttpParameter2.out.result);
                AsyncHttpParameter.Out out = asyncHttpParameter2.out;
                if (out.resultType == 0) {
                    String str = out.result;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject(str);
                        int optInt = jSONObject2.optInt(Constant.KEY_STATUS);
                        if (optInt != 200) {
                            SourceLog.i(BrowserBridge.TAG, "BrowserFailed post error! status=" + optInt);
                            return;
                        }
                        JSONArray optJSONArray = jSONObject2.optJSONObject("data").optJSONArray("recList");
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                                JSONObject jSONObject3 = optJSONArray.getJSONObject(i10);
                                String optString = jSONObject3.optString(ParamsMap.DeviceParams.KEY_UID);
                                int optInt2 = jSONObject3.optInt(ParamsMap.DeviceParams.KEY_APPID);
                                String optString2 = jSONObject3.optString("name");
                                String optString3 = jSONObject3.optString("ip");
                                int optInt3 = jSONObject3.optInt("port");
                                SourceLog.i(BrowserBridge.TAG, "BrowserFailed find recDev " + i10 + " : name =" + optString2 + " ,uid =" + optString + " ,appid =" + optInt2 + " ,ip =" + optString3 + " ,port =" + optInt3);
                                BrowserBridge.this.requestLelinkTxtInfo(optString3, optInt3);
                            }
                        }
                    } catch (Exception e11) {
                        SourceLog.w(BrowserBridge.TAG, e11);
                    }
                }
            }
        });
    }

    public static void release() {
        SourceLog.i(TAG, "release");
        isReportSinkDeviceServer = false;
        BrowserBridge browserBridge = sInstance;
        if (browserBridge == null) {
            return;
        }
        browserBridge.mMainHandler.removeCallbacksAndMessages(null);
        sInstance.stopBrowse();
        sInstance = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestLelinkTxtInfo(final String str, int i10) {
        if (TextUtils.isEmpty(str) || i10 <= 0) {
            SourceLog.w(TAG, "requestLelinkTxtInfo ignore," + str + Operator.Operation.DIVISION + i10);
            return;
        }
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.getHttpServerUrl(str, i10 + ""), null);
        asyncHttpParameter.in.readTimeout = (int) TimeUnit.SECONDS.toMillis(5L);
        asyncHttpParameter.in.tryCount = 1;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.protocol.browser.BrowserBridge.7
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                AsyncHttpParameter.Out out = asyncHttpParameter2.out;
                int i11 = out.resultType;
                if (i11 == 2) {
                    SourceLog.i(BrowserBridge.TAG, "requestLelinkTxtInfo cancel");
                    return;
                }
                if (i11 != 0) {
                    SourceLog.i(BrowserBridge.TAG, "requestLelinkTxtInfo failed");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(out.result);
                    String optString = jSONObject.optString("serviceName");
                    JSONObject optJSONObject = jSONObject.optJSONObject("leLinkTxt");
                    if (optJSONObject != null) {
                        HashMap hashMap = new HashMap();
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, optJSONObject.optString(next));
                        }
                        BrowserBridge.this.resolveInfo(BrowserBridge.this.resolveServiceInfo(optString, str, hashMap));
                    }
                } catch (Exception e10) {
                    SourceLog.w(BrowserBridge.TAG, e10);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void resolveInfo(BrowserInfo browserInfo) {
        Iterator<LelinkServiceInfo> it = this.mServiceQueue.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            LelinkServiceInfo next = it.next();
            if (TextUtils.isEmpty(next.getUid()) || TextUtils.isEmpty(browserInfo.getUid())) {
                if (TextUtils.equals(next.getName(), browserInfo.getName()) && TextUtils.equals(next.getIp(), browserInfo.getIp())) {
                    next.updateByBrowseInfo(browserInfo);
                    SourceLog.i(TAG, "resolveInfo update 2 " + browserInfo.getName());
                    z10 = false;
                }
            } else if (TextUtils.equals(next.getUid(), browserInfo.getUid())) {
                next.updateByBrowseInfo(browserInfo);
                SourceLog.i(TAG, "resolveInfo update " + browserInfo.getName());
                z10 = false;
            }
        }
        if (z10) {
            SourceLog.i(TAG, "resolveInfo add " + browserInfo.getName());
            this.mServiceQueue.add(new LelinkServiceInfo(browserInfo.getCreateType(), browserInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BrowserInfo resolveServiceInfo(String str, String str2, Map<String, String> map) {
        String str3 = map.get("vv");
        SourceLog.i(TAG, "resolveServiceInfo vv:" + str3);
        if (TextUtils.isEmpty(str3) || !"2".equals(str3)) {
            return null;
        }
        BrowserInfo browserInfo = new BrowserInfo(1, 1);
        browserInfo.setName(str);
        browserInfo.setIp(str2);
        browserInfo.setLocalWifi(true);
        browserInfo.setOnLine(true);
        String str4 = map.get("u");
        if (!TextUtils.isEmpty(str4)) {
            browserInfo.setUid(str4);
        }
        String str5 = map.get("lelinkport");
        if (!TextUtils.isEmpty(str5)) {
            try {
                browserInfo.setPort(Integer.parseInt(str5));
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
        HashMap hashMap = new HashMap();
        for (String str6 : map.keySet()) {
            if (str6.equalsIgnoreCase("vv")) {
                SourceLog.i(TAG, "filter new lelink field vv");
            } else {
                hashMap.put(str6, map.get(str6));
            }
        }
        browserInfo.setExtras(hashMap);
        return browserInfo;
    }

    public String getBrowseErrorMsg() {
        IBrowser iBrowser = this.mBrowser;
        if (iBrowser == null) {
            return null;
        }
        return iBrowser.getBrowseErrorMsg();
    }

    public void onNetDisconnect(int i10) {
        ConcurrentLinkedQueue<LelinkServiceInfo> concurrentLinkedQueue = this.mServiceQueue;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
            ConnectManager.getInstance().onNetDisconnect();
            IBrowseListener iBrowseListener = this.mAppListener;
            if (iBrowseListener != null) {
                iBrowseListener.onBrowse(i10, new ArrayList(this.mServiceQueue));
            }
        }
    }

    public void reportSinkDevice() {
        if (SDKConfig.getInstance().getSearchEnable() != 1) {
            SourceLog.i(TAG, "reportSinkDevice,ignore");
            return;
        }
        if (isReportSinkDeviceServer) {
            SourceLog.i(TAG, "reportSinkDevice,has reported sink device");
            return;
        }
        SourceLog.i(TAG, "reportSinkDevice");
        isReportSinkDeviceServer = true;
        this.mMainHandler.removeCallbacks(this.mReportSinkDeviceRunnable);
        this.mMainHandler.post(this.mReportSinkDeviceRunnable);
    }

    public void setBrowserListener(IBrowseListener iBrowseListener) {
        this.mAppListener = iBrowseListener;
    }

    public void setServiceInfoParseListener(IServiceInfoParseListener iServiceInfoParseListener) {
        this.mServiceInfoParseListener = iServiceInfoParseListener;
    }

    public void startBrowse(Context context, final int i10) {
        SourceLog.i(TAG, "startBrowse " + i10);
        this.mContext = context;
        ConcurrentLinkedQueue<LelinkServiceInfo> concurrentLinkedQueue = this.mServiceQueue;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
        if (checkSDKUsable()) {
            try {
                this.mBrowser = (IBrowser) ModuleLinker.getInstance().loadModule(ModuleIds.CLAZZ_ID968_BROWSECONTROLLER);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
            AsyncRunnableJob asyncRunnableJob = this.mBrowserTask;
            if (asyncRunnableJob != null) {
                asyncRunnableJob.cancel(true);
            }
            this.mBrowserTask = AsyncManager.getInstance().exeRunnable(new Runnable() { // from class: com.hpplay.sdk.source.protocol.browser.BrowserBridge.5
                @Override // java.lang.Runnable
                public void run() {
                    if (BrowserBridge.this.mBrowser != null) {
                        BrowserBridge.this.mBrowser.startBrowse(i10, BrowserBridge.this.mListener);
                    }
                }
            }, null);
            this.mMainHandler.removeCallbacks(this.mReportRunnable);
            this.mMainHandler.postDelayed(this.mReportRunnable, 50000L);
            int searchOutTime = SDKConfig.getInstance().getSearchOutTime() * 1000;
            SourceLog.i(TAG, "startBrowse,searchOutTime: " + searchOutTime);
            this.mMainHandler.removeCallbacks(this.mAutoStopRunnable);
            this.mMainHandler.postDelayed(this.mAutoStopRunnable, (long) searchOutTime);
        }
    }

    public boolean startBrowseHistory(Context context, String str) {
        SourceLog.i(TAG, "startBrowseHistory: " + str);
        this.mContext = context;
        ConcurrentLinkedQueue<LelinkServiceInfo> concurrentLinkedQueue = this.mServiceQueue;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
        if (!checkSDKUsable()) {
            return false;
        }
        ConnectRelationManager connectRelationManager = new ConnectRelationManager();
        connectRelationManager.setParseResultListener(this.mServiceInfoParseListener);
        this.isBrowserSuccess = true;
        connectRelationManager.findByNumberId(str, 0, 11);
        return this.isBrowserSuccess;
    }

    public void stopBrowse() {
        SourceLog.i(TAG, "stopBrowser");
        IBrowser iBrowser = this.mBrowser;
        if (iBrowser != null) {
            iBrowser.stopBrowse();
            ModuleLinker.getInstance().removeObjOfMemory(ModuleIds.CLAZZ_ID968_BROWSECONTROLLER);
        }
        AsyncRunnableJob asyncRunnableJob = this.mBrowserTask;
        if (asyncRunnableJob != null) {
            asyncRunnableJob.cancel(true);
            this.mBrowserTask = null;
        }
        this.mMainHandler.removeCallbacks(this.mAutoStopRunnable);
        this.mMainHandler.removeCallbacks(this.mReportRunnable);
        this.isBrowserSuccess = false;
        ServiceUpdater.getInstance().updateServiceInfo(this.mContext);
    }
}
