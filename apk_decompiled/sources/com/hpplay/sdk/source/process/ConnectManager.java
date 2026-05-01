package com.hpplay.sdk.source.process;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.sdk.source.api.IConnectListener;
import com.hpplay.sdk.source.bean.HistoryConfigBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.cloud.ConnectRelationManager;
import com.hpplay.sdk.source.business.cloud.RightsManager;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.process.OnlineManager;
import com.hpplay.sdk.source.protocol.connect.CloudConnectBridge;
import com.hpplay.sdk.source.protocol.connect.ConnectBridge;
import com.hpplay.sdk.source.protocol.connect.GroupConnectBridge;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.Feature;
import com.hpplay.sdk.source.utils.LeboUtil;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes3.dex */
public class ConnectManager {
    public static final int DISCONNECT_BY_NET_DISCONNECT = 3;
    public static final int DISCONNECT_BY_OTHER = 100;
    public static final int DISCONNECT_BY_RECONNECT = 2;
    public static final int DISCONNECT_BY_USER = 1;
    private static final String TAG = "ConnectManager";
    private static ConnectManager sInstance;
    private HistoryConfigBean mHistoryConfigBean;
    private ConnectBridge mLastConnectBridge;
    private OnlineManager mOnlineManager;
    private IConnectListener mOuterListener;
    private String mReportDll;
    private ConcurrentLinkedQueue<IConnectListener> mConnectCheckListeners = new ConcurrentLinkedQueue<>();
    private final Map<String, ConnectBridge> mConnectMap = new ConcurrentHashMap();
    private final IConnectListener mConnectListener = new IConnectListener() { // from class: com.hpplay.sdk.source.process.ConnectManager.1
        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onConnect(LelinkServiceInfo lelinkServiceInfo, int i10) {
            SourceLog.i(ConnectManager.TAG, "onConnect " + lelinkServiceInfo + Operator.Operation.DIVISION + i10);
            if (ConnectManager.this.mOuterListener != null) {
                if (i10 == 5) {
                    ConnectManager.this.mOuterListener.onConnect(lelinkServiceInfo, 1);
                } else {
                    ConnectManager.this.mOuterListener.onConnect(lelinkServiceInfo, i10);
                }
            }
            if (ConnectManager.this.mConnectCheckListeners != null && !ConnectManager.this.mConnectCheckListeners.isEmpty()) {
                Iterator it = ConnectManager.this.mConnectCheckListeners.iterator();
                while (it.hasNext()) {
                    IConnectListener iConnectListener = (IConnectListener) it.next();
                    if (iConnectListener != null) {
                        iConnectListener.onConnect(lelinkServiceInfo, i10);
                    }
                }
            }
            ConnectManager.this.reportLiveConnect(lelinkServiceInfo);
            if (lelinkServiceInfo != null) {
                RightsManager.getInstance().getSinkTempRights(CastUtil.getKey(lelinkServiceInfo), lelinkServiceInfo.getAppId(), i10);
                if (ConnectManager.this.mHistoryConfigBean != null && ConnectManager.this.mHistoryConfigBean.isReport) {
                    new ConnectRelationManager().uploadConnectDeivce(ConnectManager.this.mHistoryConfigBean, lelinkServiceInfo.getAppId(), lelinkServiceInfo.getUid(), 0);
                }
            }
            if (ConnectManager.this.mOnlineManager != null) {
                ConnectManager.this.mOnlineManager.updateOnlineTime(lelinkServiceInfo);
            }
        }

        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
            if (lelinkServiceInfo == null) {
                return;
            }
            SourceLog.i(ConnectManager.TAG, "onDisconnect " + lelinkServiceInfo + " " + i10 + Operator.Operation.DIVISION + i11);
            if (ConnectManager.this.mOuterListener != null) {
                ConnectManager.this.mOuterListener.onDisconnect(lelinkServiceInfo, i10, i11);
            }
            if (i10 == 212012) {
                return;
            }
            if (ConnectManager.this.mOnlineManager != null) {
                ConnectManager.this.mOnlineManager.remove(lelinkServiceInfo);
            }
            ConnectManager.this.removeBridge(lelinkServiceInfo);
            String key = CastUtil.getKey(lelinkServiceInfo);
            if (TextUtils.isEmpty(key)) {
                return;
            }
            RightsManager.getInstance().removeSinkRights(key);
        }
    };

    private ConnectManager() {
        if (enableOnlineCheck()) {
            this.mOnlineManager = new OnlineManager();
        }
    }

    private boolean enableOnlineCheck() {
        return Feature.isLeboApp();
    }

    public static synchronized ConnectManager getInstance() {
        ConnectManager connectManager;
        synchronized (ConnectManager.class) {
            if (sInstance == null) {
                synchronized (ConnectManager.class) {
                    if (sInstance == null) {
                        SourceLog.i(TAG, "getInstance: new ConnectManager");
                        sInstance = new ConnectManager();
                    }
                }
            }
            connectManager = sInstance;
        }
        return connectManager;
    }

    public boolean checkOnline(LelinkServiceInfo lelinkServiceInfo, OnlineManager.OnlineListener onlineListener) {
        OnlineManager onlineManager;
        if (lelinkServiceInfo == null || (onlineManager = this.mOnlineManager) == null) {
            return false;
        }
        return onlineManager.checkOnline(lelinkServiceInfo, onlineListener);
    }

    public void connect(Context context, LelinkServiceInfo lelinkServiceInfo, boolean z10) {
        String key = CastUtil.getKey(lelinkServiceInfo);
        SourceLog.i(TAG, "+++++++++++++++++++++++++++++++++= connect " + lelinkServiceInfo.getIp() + Operator.Operation.DIVISION + lelinkServiceInfo.getName() + Operator.Operation.DIVISION + key);
        ConnectBridge connectBridge = null;
        if (z10) {
            if (this.mConnectMap.containsKey(key) && (this.mConnectMap.get(key) instanceof GroupConnectBridge)) {
                connectBridge = (GroupConnectBridge) this.mConnectMap.get(key);
            }
            if (connectBridge == null) {
                connectBridge = new GroupConnectBridge();
                this.mConnectMap.put(key, connectBridge);
            }
            this.mLastConnectBridge = connectBridge;
            connectBridge.setConnectListener(this.mConnectListener);
            connectBridge.connect(lelinkServiceInfo);
            return;
        }
        if (this.mConnectMap.containsKey(key)) {
            ConnectBridge connectBridge2 = this.mConnectMap.get(key);
            if (connectBridge2 instanceof GroupConnectBridge) {
                connectBridge2.release();
            } else {
                connectBridge = connectBridge2;
            }
        }
        if (connectBridge == null || !connectBridge.checkBridge(lelinkServiceInfo)) {
            connectBridge = new ConnectBridge(context, lelinkServiceInfo);
            this.mConnectMap.put(key, connectBridge);
        }
        this.mLastConnectBridge = connectBridge;
        connectBridge.setConnectListener(this.mConnectListener);
        connectBridge.connect(lelinkServiceInfo);
    }

    public void connectServer(Context context, LelinkServiceInfo lelinkServiceInfo) {
        SourceLog.i(TAG, "connectServer");
        CloudConnectBridge cloudConnectBridge = new CloudConnectBridge(context);
        cloudConnectBridge.setConnectListener(this.mConnectListener);
        cloudConnectBridge.connect(lelinkServiceInfo);
    }

    public void disconnect(LelinkServiceInfo lelinkServiceInfo) {
        String key = CastUtil.getKey(lelinkServiceInfo);
        if (!this.mConnectMap.containsKey(key)) {
            SourceLog.w(TAG, "disconnect ignore");
            return;
        }
        ConnectBridge connectBridge = this.mConnectMap.get(key);
        if (connectBridge == null) {
            SourceLog.w(TAG, "disconnect ignore 2");
            return;
        }
        if (connectBridge instanceof GroupConnectBridge) {
            connectBridge.setConnectListener(null);
        }
        connectBridge.disconnect(1);
        SourceLog.i(TAG, "disconnect");
        removeBridge(lelinkServiceInfo);
        RightsManager.getInstance().removeSinkRights(key);
    }

    public ConnectBridge getConnectBridge(String str) {
        if (TextUtils.isEmpty(str) || this.mConnectMap.isEmpty()) {
            SourceLog.i(TAG, " getConnectBridge uid:" + str);
            return null;
        }
        for (ConnectBridge connectBridge : this.mConnectMap.values()) {
            if (connectBridge != null && connectBridge.getServiceInfo() != null && str.equals(connectBridge.getServiceInfo().getUid())) {
                return connectBridge;
            }
        }
        SourceLog.w(TAG, " getConnectBridge has no uid bridge " + this.mConnectMap.size() + Operator.Operation.DIVISION + str);
        return null;
    }

    public int getConnectProtocol(LelinkServiceInfo lelinkServiceInfo) {
        String key = CastUtil.getKey(lelinkServiceInfo);
        if (!this.mConnectMap.containsKey(key)) {
            SourceLog.w(TAG, "getConnectProtocol ignore, service not connect yet " + key);
            return -1;
        }
        ConnectBridge connectBridge = this.mConnectMap.get(key);
        if (connectBridge != null) {
            return connectBridge.getConnectProtocol();
        }
        SourceLog.w(TAG, "getConnectProtocol ignore, service not connect yet 2," + key);
        return -1;
    }

    public String getConnectSession(LelinkServiceInfo lelinkServiceInfo) {
        String key = CastUtil.getKey(lelinkServiceInfo);
        if (!this.mConnectMap.containsKey(key)) {
            SourceLog.w(TAG, "getConnectSession ignore, service not connect yet " + key);
            return null;
        }
        ConnectBridge connectBridge = this.mConnectMap.get(key);
        if (connectBridge == null) {
            SourceLog.w(TAG, "getConnectSession ignore, service not connect yet 2," + key);
            return null;
        }
        SourceLog.i(TAG, " ++++++++  getConnectSession ++++++++" + connectBridge.getConnectProtocol());
        if (connectBridge.getConnectProtocol() != -1) {
            return connectBridge.getConnectSession();
        }
        SourceLog.i(TAG, "disconnect ......... ");
        disconnect(lelinkServiceInfo);
        return null;
    }

    public List<LelinkServiceInfo> getConnections() {
        ArrayList arrayList = new ArrayList();
        for (ConnectBridge connectBridge : this.mConnectMap.values()) {
            if (connectBridge.isConnected()) {
                arrayList.add(connectBridge.getServiceInfo());
            }
        }
        return arrayList;
    }

    public String getDeviceReportId() {
        HistoryConfigBean historyConfigBean = this.mHistoryConfigBean;
        if (historyConfigBean == null) {
            return null;
        }
        if (!TextUtils.isEmpty(historyConfigBean.encryptNumberId)) {
            return this.mHistoryConfigBean.encryptNumberId;
        }
        if (TextUtils.isEmpty(this.mHistoryConfigBean.numberId)) {
            return null;
        }
        return LeboUtil.anonymizeBySHA256For60Bits(this.mHistoryConfigBean.encryptNumberId);
    }

    public ConnectBridge getLastConnectBridge() {
        return this.mLastConnectBridge;
    }

    public LelinkServiceInfo getLastServiceInfo() {
        ConnectBridge connectBridge = this.mLastConnectBridge;
        if (connectBridge != null) {
            return connectBridge.getServiceInfo();
        }
        SourceLog.w(TAG, "getLastServiceInfo has no valid connect bridge");
        return null;
    }

    public LelinkServiceInfo getLelinkServiceInfo(String str) {
        for (ConnectBridge connectBridge : this.mConnectMap.values()) {
            if (str.equals(connectBridge.getServiceInfo().getUid())) {
                return connectBridge.getServiceInfo();
            }
        }
        return null;
    }

    public void groupReconnect(int i10, LelinkServiceInfo lelinkServiceInfo, IConnectListener iConnectListener) {
        ConnectBridge connectBridge = this.mLastConnectBridge;
        if (connectBridge == null || !(connectBridge instanceof GroupConnectBridge)) {
            return;
        }
        ((GroupConnectBridge) connectBridge).groupReconnect(i10, lelinkServiceInfo, iConnectListener);
    }

    public boolean isConnected(OutParameter outParameter) {
        LelinkServiceInfo lelinkServiceInfo;
        if (outParameter == null || (lelinkServiceInfo = outParameter.serviceInfo) == null) {
            return false;
        }
        return this.mConnectMap.containsKey(CastUtil.getKey(lelinkServiceInfo));
    }

    public void notifyBrowseResult(LelinkServiceInfo lelinkServiceInfo) {
        OnlineManager onlineManager;
        if (lelinkServiceInfo == null || (onlineManager = this.mOnlineManager) == null) {
            return;
        }
        onlineManager.updateOnlineTime(lelinkServiceInfo);
    }

    public void notifyCastError(LelinkServiceInfo lelinkServiceInfo) {
        OnlineManager onlineManager;
        if (lelinkServiceInfo == null || (onlineManager = this.mOnlineManager) == null) {
            return;
        }
        onlineManager.remove(lelinkServiceInfo);
    }

    public void notifyCastStatusValid(LelinkServiceInfo lelinkServiceInfo) {
        OnlineManager onlineManager;
        if (lelinkServiceInfo == null || (onlineManager = this.mOnlineManager) == null) {
            return;
        }
        onlineManager.updateOnlineTime(lelinkServiceInfo);
    }

    public void notifyCastSuccess(LelinkServiceInfo lelinkServiceInfo) {
        OnlineManager onlineManager;
        if (lelinkServiceInfo == null || (onlineManager = this.mOnlineManager) == null) {
            return;
        }
        onlineManager.updateOnlineTime(lelinkServiceInfo);
    }

    public void notifyDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
        SourceLog.w(TAG, "notifyDisconnect " + lelinkServiceInfo + " " + i10 + " / " + i11);
        this.mConnectListener.onDisconnect(lelinkServiceInfo, i10, i11);
    }

    public void notifyInvalid(LelinkServiceInfo lelinkServiceInfo) {
        SourceLog.w(TAG, "notifyInvalid " + lelinkServiceInfo);
        notifyOffline(lelinkServiceInfo, 212010, IConnectListener.EXTRA_CONNECT_INVALID_DEVICE);
    }

    public void notifyOffline(LelinkServiceInfo lelinkServiceInfo) {
        SourceLog.w(TAG, "notifyOffline " + lelinkServiceInfo);
        notifyOffline(lelinkServiceInfo, 212010, 212018);
    }

    public void onNetDisconnect() {
        Iterator<ConnectBridge> it = this.mConnectMap.values().iterator();
        while (it.hasNext()) {
            try {
                ConnectBridge next = it.next();
                if (!(next instanceof GroupConnectBridge)) {
                    if (next.mConnectBridge instanceof CloudConnectBridge) {
                        it.remove();
                    } else {
                        next.disconnect(3);
                        it.remove();
                    }
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
    }

    public void removeBridge(LelinkServiceInfo lelinkServiceInfo) {
        ConnectBridge connectBridge;
        String key = CastUtil.getKey(lelinkServiceInfo);
        if (TextUtils.isEmpty(key) || (connectBridge = this.mConnectMap.get(key)) == null) {
            return;
        }
        connectBridge.release();
        this.mConnectMap.remove(key);
    }

    public void removeConnectCheckListener(IConnectListener iConnectListener) {
        this.mConnectCheckListeners.remove(iConnectListener);
    }

    public void reportLiveConnect(LelinkServiceInfo lelinkServiceInfo) {
        String str;
        List<LelinkServiceInfo> browserList = LelinkSdkManager.getInstance().getBrowserList();
        if (browserList == null || browserList.size() == 0 || lelinkServiceInfo == null) {
            return;
        }
        SourceLog.i(TAG, "reportLiveConnect lelinkServiceInfos = " + browserList.size());
        try {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i10 = 0; i10 < browserList.size(); i10++) {
                LelinkServiceInfo lelinkServiceInfo2 = browserList.get(i10);
                Map<Integer, BrowserInfo> browserInfos = lelinkServiceInfo2.getBrowserInfos();
                if (browserInfos != null && browserInfos.size() > 0) {
                    String str2 = "0";
                    if (TextUtils.isEmpty(lelinkServiceInfo2.getUid())) {
                        str = "";
                    } else {
                        str2 = "1";
                        str = lelinkServiceInfo2.getUid();
                    }
                    Iterator<Map.Entry<Integer, BrowserInfo>> it = browserInfos.entrySet().iterator();
                    String str3 = "";
                    String str4 = str3;
                    String str5 = str4;
                    String str6 = str5;
                    while (it.hasNext()) {
                        BrowserInfo value = it.next().getValue();
                        if (value != null) {
                            String str7 = value.getExtras().get(BrowserInfo.KEY_M);
                            str4 = TextUtils.isEmpty(str7) ? "" : str7;
                            str3 = value.getIp();
                            if (value.getType() == 3) {
                                str5 = value.getExtras().get(BrowserInfo.KEY_MANUFACTURER);
                                if (TextUtils.isEmpty(str5)) {
                                    str5 = "";
                                }
                                str6 = value.getName();
                                if (str6.contains("#")) {
                                    str6 = str6.replace("#", "");
                                }
                            } else {
                                str6 = value.getExtras().get("u");
                            }
                        }
                    }
                    stringBuffer.append(str2);
                    stringBuffer.append("#");
                    stringBuffer.append(str3);
                    stringBuffer.append("#");
                    stringBuffer.append(str4);
                    stringBuffer.append("#");
                    stringBuffer.append(str5);
                    stringBuffer.append("#");
                    stringBuffer.append(str6);
                    stringBuffer.append("#");
                    stringBuffer.append(str);
                }
                if (i10 < browserList.size() - 1) {
                    stringBuffer.append(",");
                }
            }
            if (TextUtils.isEmpty(this.mReportDll) || !TextUtils.equals(this.mReportDll, stringBuffer.toString().trim())) {
                this.mReportDll = stringBuffer.toString().trim();
                SourceLog.debug(TAG, "reportLiveConnect dll = " + this.mReportDll);
                SourceDataReport.getInstance().onReceiverLive(getConnectSession(lelinkServiceInfo), this.mReportDll);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void resetLastConnectBridge(LelinkServiceInfo lelinkServiceInfo) {
        for (ConnectBridge connectBridge : this.mConnectMap.values()) {
            LelinkServiceInfo serviceInfo = connectBridge.getServiceInfo();
            if (TextUtils.equals(lelinkServiceInfo.getName(), serviceInfo.getName()) && TextUtils.equals(lelinkServiceInfo.getIp(), serviceInfo.getIp())) {
                this.mLastConnectBridge = connectBridge;
                return;
            }
        }
    }

    public void sendPassData(LelinkServiceInfo lelinkServiceInfo, int i10, String str, String str2) {
        ConnectBridge connectBridge = this.mConnectMap.get(CastUtil.getKey(lelinkServiceInfo));
        StringBuilder sb = new StringBuilder();
        sb.append("=======sendPassData====== ");
        sb.append(connectBridge == null);
        SourceLog.i(TAG, sb.toString());
        if (connectBridge == null) {
            SourceLog.i(TAG, "sendPassData ignore 1");
        } else if (connectBridge.isSupportPassthrough()) {
            connectBridge.sendPassData(i10, str, str2);
        } else {
            SourceLog.i(TAG, "sendPassData ignore, nonsupport passthrough");
        }
    }

    public void setConnectCheckListener(IConnectListener iConnectListener) {
        this.mConnectCheckListeners.add(iConnectListener);
    }

    public void setConnectDeviceReport(HistoryConfigBean historyConfigBean) {
        this.mHistoryConfigBean = historyConfigBean;
    }

    public void setConnectListener(IConnectListener iConnectListener) {
        this.mOuterListener = iConnectListener;
    }

    public void switchGroupConnection(int i10) {
        ConnectBridge connectBridge = this.mLastConnectBridge;
        if (connectBridge == null || !(connectBridge instanceof GroupConnectBridge)) {
            return;
        }
        ((GroupConnectBridge) connectBridge).switchGroupConnection(i10);
    }

    private void notifyOffline(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
        try {
            this.mConnectListener.onDisconnect(lelinkServiceInfo, i10, i11);
            OnlineManager onlineManager = this.mOnlineManager;
            if (onlineManager != null) {
                onlineManager.remove(lelinkServiceInfo);
            }
            removeBridge(lelinkServiceInfo);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void groupReconnect() {
        ConnectBridge connectBridge = this.mLastConnectBridge;
        if (connectBridge == null || !(connectBridge instanceof GroupConnectBridge)) {
            return;
        }
        ((GroupConnectBridge) connectBridge).groupReconnect();
    }

    public String getConnectSession(LelinkServiceInfo lelinkServiceInfo, boolean z10) {
        try {
            String connectSession = getConnectSession(lelinkServiceInfo);
            if (TextUtils.isEmpty(connectSession)) {
                return null;
            }
            ConnectBridge connectBridge = this.mConnectMap.get(CastUtil.getKey(lelinkServiceInfo));
            SourceLog.i(TAG, " ++++++++  getConnectSession ++++++++" + z10);
            if (connectBridge != null && connectBridge.isGroup == z10) {
                return connectSession;
            }
            SourceLog.i(TAG, " ++++++++ getConnectSession disconnect ++++++++");
            disconnect(lelinkServiceInfo);
            return null;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }
}
