package com.hpplay.sdk.source.protocol.connect;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.component.common.protocol.IConnector;
import com.hpplay.sdk.source.api.IConnectListener;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.business.BusinessEntity;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.bean.BaseBean;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import com.hpplay.sdk.source.protocol.connect.AbsConnectBridge;
import com.hpplay.sdk.source.utils.BrowseResultOnlineCheck;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.CheckDisconnect;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public class ConnectBridge {
    private static final String TAG = "ConnectBridge";
    private IConnectListener mAppListener;
    public AbsConnectBridge mConnectBridge;
    private Context mContext;
    public int mConnectProtocol = -1;
    public boolean isGroup = false;
    private IConnectListener mConnectListener = new IConnectListener() { // from class: com.hpplay.sdk.source.protocol.connect.ConnectBridge.1
        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onConnect(LelinkServiceInfo lelinkServiceInfo, int i10) {
            SourceLog.i(ConnectBridge.TAG, "onConnect");
            ConnectBridge connectBridge = ConnectBridge.this;
            connectBridge.mConnectProtocol = i10;
            if (connectBridge.mAppListener != null) {
                ConnectBridge.this.mAppListener.onConnect(lelinkServiceInfo, i10);
            }
        }

        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
            SourceLog.i(ConnectBridge.TAG, "onDisconnect " + i10 + Operator.Operation.DIVISION + i11 + " " + lelinkServiceInfo);
            if (ConnectBridge.this.isGroup) {
                SourceLog.i(ConnectBridge.TAG, "group onDisconnect " + i10 + Operator.Operation.DIVISION + i11 + " " + lelinkServiceInfo);
                return;
            }
            if (CheckDisconnect.disableRetry(i10, i11)) {
                ConnectBridge.this.callbackDisconnect(lelinkServiceInfo, i10, i11);
                return;
            }
            if (i11 == 212018) {
                ConnectManager.getInstance().notifyOffline(lelinkServiceInfo);
                return;
            }
            if (!(ConnectBridge.this.mConnectBridge instanceof LocalConnectBridge) || CastUtil.getBrowserInfo(lelinkServiceInfo, 4) == null) {
                SourceLog.i(ConnectBridge.TAG, "onDisconnect go to online check " + lelinkServiceInfo);
                BrowseResultOnlineCheck.getInstance().checkDeviceOnline(lelinkServiceInfo, i10, i11);
                return;
            }
            SourceLog.w(ConnectBridge.TAG, "connect retry by im");
            ConnectBridge.this.mConnectBridge = new CloudConnectBridge(ConnectBridge.this.mContext);
            ConnectBridge connectBridge = ConnectBridge.this;
            connectBridge.mConnectBridge.setConnectListener(connectBridge.mConnectListener);
            ConnectBridge.this.mConnectBridge.connect(lelinkServiceInfo);
        }
    };

    public ConnectBridge(Context context, LelinkServiceInfo lelinkServiceInfo) {
        this.mContext = context;
        if (CastUtil.isUseLocalCast(lelinkServiceInfo)) {
            this.mConnectBridge = new LocalConnectBridge(context);
        } else {
            this.mConnectBridge = new CloudConnectBridge(context);
        }
        this.mConnectBridge.setConnectListener(this.mConnectListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
        LelinkServiceInfo lelinkServiceInfo2;
        IConnectListener iConnectListener = this.mAppListener;
        if (iConnectListener != null) {
            iConnectListener.onDisconnect(lelinkServiceInfo, i10, i11);
        }
        try {
            OutParameter lastPlayInfo = BusinessEntity.getInstance().getLastPlayInfo();
            if (lastPlayInfo == null || lastPlayInfo.castType != 2 || (lelinkServiceInfo2 = lastPlayInfo.serviceInfo) == null || !TextUtils.equals(lelinkServiceInfo2.getUid(), lelinkServiceInfo.getUid())) {
                return;
            }
            LelinkSdkManager.getInstance().stopPlayWithCallback(Constant.STOP_FROM_DISCONNECT);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void addOnPassReceivedListener(Object obj, AbsConnectBridge.OnPassReceivedListener onPassReceivedListener) {
        this.mConnectBridge.addOnPassReceivedListener(obj, onPassReceivedListener);
    }

    public void addOnPassSendCompleteListener(Object obj, AbsConnectBridge.OnPassSendCompleteListener onPassSendCompleteListener) {
        this.mConnectBridge.addOnPassSendCompleteListener(obj, onPassSendCompleteListener);
    }

    public boolean checkBridge(LelinkServiceInfo lelinkServiceInfo) {
        return CastUtil.isUseLocalCast(lelinkServiceInfo) ? this.mConnectBridge instanceof LocalConnectBridge : this.mConnectBridge instanceof CloudConnectBridge;
    }

    public void connect(LelinkServiceInfo lelinkServiceInfo) {
        this.mConnectProtocol = -1;
        this.mConnectBridge.connect(lelinkServiceInfo);
    }

    public void disconnect(int i10) {
        this.mConnectProtocol = -1;
        this.mConnectBridge.disconnect(i10);
    }

    public String getConnectBean() {
        return this.mConnectBridge.getConnectBean();
    }

    public int getConnectProtocol() {
        return this.mConnectProtocol;
    }

    public String getConnectSession() {
        return this.mConnectBridge.getConnectSession();
    }

    public IConnector getConnector() {
        AbsConnectBridge absConnectBridge = this.mConnectBridge;
        if (absConnectBridge instanceof LocalConnectBridge) {
            return ((LocalConnectBridge) absConnectBridge).getConnector();
        }
        return null;
    }

    public LelinkServiceInfo getServiceInfo() {
        return this.mConnectBridge.getServiceInfo();
    }

    public boolean isConnected() {
        return this.mConnectBridge.isConnected();
    }

    public boolean isLocalBridge() {
        return this.mConnectBridge instanceof LocalConnectBridge;
    }

    public boolean isSupportPassMsg(int i10) {
        return this.mConnectBridge.isSupportPassMsg(i10);
    }

    public boolean isSupportPassthrough() {
        AbsConnectBridge absConnectBridge = this.mConnectBridge;
        return absConnectBridge != null && (CastUtil.isSupportLelinkV2(absConnectBridge.getServiceInfo()) || CastUtil.isSupportIM(this.mConnectBridge.getServiceInfo()));
    }

    public boolean isSupportTrack() {
        return this.mConnectBridge.isSupportTrack();
    }

    public boolean isSupportUrlList() {
        return this.mConnectBridge.isSupportUrlList();
    }

    public void notifyPassReceivedData(int i10, BaseBean baseBean) {
        this.mConnectBridge.notifyPassReceivedData(i10, baseBean);
    }

    public void release() {
        this.mAppListener = null;
        this.mConnectBridge.release();
    }

    public void removeOnPassReceivedListener(Object obj) {
        this.mConnectBridge.removeOnPassReceivedListener(obj);
    }

    public void removeOnPassSendCompleteListener(Object obj) {
        this.mConnectBridge.removeOnPassSendCompleteListener(obj);
    }

    public void saveConnectBean(String str) {
        this.mConnectBridge.saveConnectBean(str);
    }

    public void sendPassData(int i10, String str, String str2) {
        if (this.mConnectBridge == null) {
            SourceLog.w(TAG, "sendPassData ignore");
            return;
        }
        SourceLog.i(TAG, " ============sendPassData is local :" + (this.mConnectBridge instanceof LocalConnectBridge));
        this.mConnectBridge.sendPassData(i10, str, str2);
    }

    public void setConnectListener(IConnectListener iConnectListener) {
        this.mAppListener = iConnectListener;
    }

    public void setGroupConnect(boolean z10) {
        this.isGroup = z10;
    }

    public void setSinkSM(String str) {
        this.mConnectBridge.setSinkSM(str);
    }

    public ConnectBridge(Context context, int i10) {
        this.mContext = context;
        if (i10 == 1) {
            this.mConnectBridge = new LocalConnectBridge(context);
        } else {
            this.mConnectBridge = new CloudConnectBridge(context);
        }
        this.mConnectBridge.setConnectListener(this.mConnectListener);
    }

    public ConnectBridge() {
    }
}
