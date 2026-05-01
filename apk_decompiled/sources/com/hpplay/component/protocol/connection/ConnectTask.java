package com.hpplay.component.protocol.connection;

import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.SourceModule;
import com.hpplay.component.common.protocol.IConnector;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.component.protocol.passthrough.LelinkPassthroughChannel;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ConnectTask extends IConnector implements Runnable {
    private static final int AUTO_CHECK_INTERVAL = 5000;
    private static final int CHECK_MAX_COUNT = 2;
    private static final int LOCK_LONG_TIME = 0;
    private static final String TAG = "ConnectorImp";
    private boolean isActiveCheck;
    private boolean isDisconnected;
    private ProtocolListener mCheckconnectionListener;
    private IConnection mConnection;
    private DisconnectionMonitor mDiscMonitor;
    private LelinkPassthroughChannel mLelinkPassthroughChannel;
    private ParamsMap mMap;
    private ProtocolListener mProtocolListener;
    private boolean isConnected = false;
    private int mFailedCount = 0;
    private final Object mLock = new Object();
    private AtomicBoolean isLock = new AtomicBoolean();
    private AtomicBoolean isAppPause = new AtomicBoolean();
    private int mConnectType = 0;
    private String mFeature = "";
    private int mConnectionCheckInterval = 0;
    private final ProtocolListener protocolListener = new ProtocolListener() { // from class: com.hpplay.component.protocol.connection.ConnectTask.1
        @Override // com.hpplay.component.common.protocol.ProtocolListener
        public void onResult(int i10, String... strArr) {
            try {
                if (20 != i10 || strArr == null) {
                    CLog.i(ConnectTask.TAG, "requestNewDevice ========>   match current device failed");
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("requestNewDevice ========>");
                    sb.append(strArr[0]);
                    CLog.i(ConnectTask.TAG, sb.toString());
                    ConnectTask.this.mMap = ParamsMap.create(strArr[0]);
                    JSONArray jSONArray = (JSONArray) ConnectTask.this.mMap.getParam(ParamsMap.ConnectParams.KEY_CONNECT_SUPPORT, new JSONArray());
                    if (jSONArray.length() > 0) {
                        int[] iArr = new int[jSONArray.length()];
                        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                            iArr[i11] = ((Integer) jSONArray.get(i11)).intValue();
                        }
                        ConnectTask.this.mMap.putParam(ParamsMap.ConnectParams.KEY_CONNECT_SUPPORT, iArr);
                    }
                }
            } catch (Exception e10) {
                CLog.w(ConnectTask.TAG, e10);
            }
            ConnectTask.this.unLockThread();
        }
    };
    private final ProtocolListener mDisconnectedListener = new ProtocolListener() { // from class: com.hpplay.component.protocol.connection.ConnectTask.2
        @Override // com.hpplay.component.common.protocol.ProtocolListener
        public void onResult(int i10, String... strArr) {
            CLog.i(ConnectTask.TAG, "keep alive disconnect");
            try {
                if (ConnectTask.this.mProtocolListener != null) {
                    ConnectTask.this.mProtocolListener.onResult(i10, strArr);
                }
            } catch (Exception e10) {
                CLog.w(ConnectTask.TAG, e10);
            }
            ConnectTask.this.disConnect();
        }
    };

    private boolean connectByType(int i10) {
        if (1 == i10) {
            if (TextUtils.equals(this.mMap.getVV(), "2")) {
                this.mConnection = new LelinkV2Connection(this.mMap);
            } else {
                this.mConnection = new LelinkConnection(this.mMap);
            }
        } else if (3 == i10) {
            this.mConnection = new DLNAConnection(this.mMap);
        } else if (4 == i10) {
            this.mConnection = new IMConnection(this.mMap, this.mProtocolListener);
        }
        boolean startConnect = this.mConnection.startConnect();
        if (startConnect && 1 == i10) {
            releaseDiscMonitor();
            DisconnectionMonitor disconnectionMonitor = new DisconnectionMonitor(this.mConnection.getProtocolSender(), this.mDisconnectedListener);
            this.mDiscMonitor = disconnectionMonitor;
            disconnectionMonitor.start();
        }
        if (startConnect) {
            IConnection iConnection = this.mConnection;
            if (iConnection instanceof LelinkV2Connection) {
                this.mFeature = ((LelinkV2Connection) iConnection).getFeature();
            }
        }
        return startConnect;
    }

    private void lockThread(long j10) {
        CLog.i(TAG, "lock connect Thread ...");
        if (this.isLock.get()) {
            return;
        }
        synchronized (this.mLock) {
            if (j10 > 0) {
                this.isLock.set(true);
                this.mLock.wait(j10);
            } else {
                this.isLock.set(true);
                this.mLock.wait();
            }
        }
    }

    private void releaseDiscMonitor() {
        DisconnectionMonitor disconnectionMonitor = this.mDiscMonitor;
        if (disconnectionMonitor != null) {
            disconnectionMonitor.release();
            this.mDiscMonitor = null;
        }
    }

    private void requestNewDevice() {
        ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DEVICEADJUSTER_REQUESTNEWDEVICES, this.mMap, this.protocolListener);
    }

    private boolean researchConnect() {
        CLog.i(TAG, "researchConnect ~~~~");
        requestNewDevice();
        unLockThread();
        lockThread(0L);
        this.isLock.set(false);
        boolean startConnect = startConnect();
        this.isConnected = startConnect;
        return startConnect;
    }

    private boolean startConnect() {
        CLog.i(TAG, "startConnect ~~~~");
        int[] iArr = new int[0];
        ParamsMap paramsMap = this.mMap;
        if (paramsMap == null) {
            return false;
        }
        int[] iArr2 = (int[]) paramsMap.getParam(ParamsMap.ConnectParams.KEY_CONNECT_SUPPORT, iArr);
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        for (int i10 : iArr2) {
            if (i10 == 1) {
                z10 = true;
            } else if (i10 == 3) {
                z11 = true;
            } else if (i10 == 4) {
                z12 = true;
            }
        }
        if (z10) {
            this.isConnected = connectByType(1);
            this.mConnectType = 1;
        }
        if (!this.isConnected && z11) {
            this.isConnected = connectByType(3);
            this.mConnectType = 3;
        }
        if (!this.isConnected && z12) {
            this.isConnected = connectByType(4);
            this.mConnectType = 4;
        }
        if (this.isConnected) {
            ProtocolListener protocolListener = this.mProtocolListener;
            if (protocolListener != null) {
                protocolListener.onResult(11, "successful", String.valueOf(this.mConnectType), this.mFeature);
            }
            if (this.mConnectType == 1 && TextUtils.equals(this.mMap.getVV(), "2")) {
                LelinkPassthroughChannel lelinkPassthroughChannel = new LelinkPassthroughChannel(this.mMap, this.mConnection.getSessionId(), 5, this.mProtocolListener);
                this.mLelinkPassthroughChannel = lelinkPassthroughChannel;
                lelinkPassthroughChannel.startPassthroughChannel();
            }
        }
        return this.isConnected;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unLockThread() {
        CLog.i(TAG, "unlock connect Thread ...");
        if (this.isLock.get()) {
            synchronized (this.mLock) {
                this.mLock.notify();
                this.isLock.set(false);
            }
        }
    }

    @Override // com.hpplay.component.common.protocol.IConnector
    public void checkConnection(ProtocolListener protocolListener) {
        CLog.i(TAG, "checkConnection ~~~~" + this.isActiveCheck);
        if (this.isActiveCheck || !this.isConnected) {
            protocolListener.onResult(20, null);
            return;
        }
        this.isActiveCheck = true;
        this.mCheckconnectionListener = protocolListener;
        unLockThread();
    }

    @Override // com.hpplay.component.common.protocol.IConnector
    public void connect(ParamsMap paramsMap, ProtocolListener protocolListener) {
        CLog.i(TAG, "start connect connect ~~~~");
        this.mMap = paramsMap;
        this.mProtocolListener = protocolListener;
    }

    @Override // com.hpplay.component.common.protocol.IConnector
    public void disConnect() {
        CLog.i(TAG, "disConnect");
        unLockThread();
        IConnection iConnection = this.mConnection;
        if (iConnection != null) {
            iConnection.disConnect();
        }
        LelinkPassthroughChannel lelinkPassthroughChannel = this.mLelinkPassthroughChannel;
        if (lelinkPassthroughChannel != null) {
            lelinkPassthroughChannel.release();
        }
        this.isDisconnected = true;
        this.isConnected = false;
        releaseDiscMonitor();
    }

    @Override // com.hpplay.component.common.protocol.IConnector
    public String getConnectSessionId() {
        IConnection iConnection = this.mConnection;
        return iConnection != null ? iConnection.getSessionId() : "";
    }

    @Override // com.hpplay.component.common.protocol.IConnector
    public void onAppPause() {
        CLog.i(TAG, "=========onAppPause=============");
        if (this.isAppPause.get()) {
            return;
        }
        this.isAppPause.set(true);
    }

    @Override // com.hpplay.component.common.protocol.IConnector
    public void onAppResume() {
        if (this.isAppPause.get()) {
            CLog.i(TAG, "=========onAppResume=============");
            this.isAppPause.set(false);
            unLockThread();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String exceptionStr;
        boolean z10;
        try {
            boolean startConnect = startConnect();
            this.isConnected = startConnect;
            if (!startConnect && !this.isDisconnected) {
                CLog.i(TAG, "connect failed try research connect ");
                this.isConnected = researchConnect();
            }
            exceptionStr = "";
        } catch (Exception e10) {
            CLog.w(TAG, e10.toString());
            exceptionStr = CLog.getExceptionStr(e10);
        }
        this.mConnectionCheckInterval = this.mMap.getIntParam(ParamsMap.ConnectParams.KEY_KEEP_ALIVE_INTERVAL);
        CLog.i(TAG, "connect state " + this.isConnected + " errMsg: " + exceptionStr);
        while (true) {
            if (!this.isConnected || this.isDisconnected) {
                break;
            }
            try {
                z10 = this.mConnection.checkConnection();
            } catch (Exception e11) {
                CLog.w(TAG, e11);
                z10 = false;
            }
            if (z10) {
                this.mFailedCount = 0;
                CLog.i(TAG, " state online ");
            } else {
                this.mFailedCount++;
                CLog.i(TAG, "connection keep alive failed " + this.mFailedCount);
            }
            if (this.isActiveCheck) {
                if (!z10) {
                    try {
                        z10 = researchConnect();
                    } catch (Exception e12) {
                        CLog.w(TAG, e12);
                    }
                }
                if (this.mCheckconnectionListener != null) {
                    this.mMap.putParam(ParamsMap.PushParams.KEY_PROTOCOL_TYPE, Integer.valueOf(this.mConnectType));
                    ProtocolListener protocolListener = this.mCheckconnectionListener;
                    String[] strArr = new String[1];
                    strArr[0] = z10 ? this.mMap.toJason() : null;
                    protocolListener.onResult(20, strArr);
                }
                this.isActiveCheck = false;
                if (!z10) {
                    ProtocolListener protocolListener2 = this.mProtocolListener;
                    if (protocolListener2 != null) {
                        protocolListener2.onResult(11, SourceModule.RESULT_CONNECTION_DISCONNECT);
                    }
                }
            }
            if (this.mFailedCount > 2) {
                ProtocolListener protocolListener3 = this.mProtocolListener;
                if (protocolListener3 != null) {
                    protocolListener3.onResult(11, SourceModule.RESULT_CONNECTION_DISCONNECT);
                }
                disConnect();
            } else {
                try {
                    int i10 = this.mConnectionCheckInterval;
                    if (i10 <= 0) {
                        i10 = 5000;
                    }
                    this.mConnectionCheckInterval = i10;
                    lockThread(this.isAppPause.get() ? 0L : this.mConnectionCheckInterval);
                    this.isLock.set(false);
                } catch (InterruptedException e13) {
                    CLog.w(TAG, e13);
                }
            }
        }
        if (this.isConnected || this.mProtocolListener == null) {
            return;
        }
        int i11 = this.mConnectType;
        int i12 = ParamsMap.ConnectParams.ERROR_CODE_LELINK_V2;
        if (i11 != 1) {
            if (i11 == 3) {
                i12 = ParamsMap.ConnectParams.ERROR_CODE_DLNA;
            }
        } else if (i11 != 1 || !TextUtils.equals(this.mMap.getVV(), "2")) {
            i12 = ParamsMap.ConnectParams.ERROR_CODE_LELINK;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", i12);
            jSONObject.put("errMsg", exceptionStr);
        } catch (JSONException e14) {
            e14.printStackTrace();
        }
        this.mProtocolListener.onResult(11, "failed", String.valueOf(this.mConnectType), jSONObject.toString());
    }

    @Override // com.hpplay.component.common.protocol.IConnector
    public boolean sendPassthroughData(int i10, String str, String str2, ProtocolListener protocolListener) {
        LelinkPassthroughChannel lelinkPassthroughChannel = this.mLelinkPassthroughChannel;
        if (lelinkPassthroughChannel == null) {
            return false;
        }
        return lelinkPassthroughChannel.sendPassthData(i10, str, str2, protocolListener);
    }

    public void setProtocolListener(ProtocolListener protocolListener) {
        this.mProtocolListener = protocolListener;
    }
}
