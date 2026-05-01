package com.hpplay.component.protocol.connection;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.IConnector;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;

/* loaded from: classes2.dex */
public class ConnectorImp extends IConnector {
    private static final String TAG = "ConnectorImp";
    private ConnectTask mConnectTask;
    private Thread mConnectThread;

    @Override // com.hpplay.component.common.protocol.IConnector
    public void checkConnection(ProtocolListener protocolListener) {
        CLog.i(TAG, "checkConnection ~~~~");
        ConnectTask connectTask = this.mConnectTask;
        if (connectTask != null) {
            connectTask.checkConnection(protocolListener);
        }
    }

    @Override // com.hpplay.component.common.protocol.IConnector
    public void connect(ParamsMap paramsMap, ProtocolListener protocolListener) {
        CLog.i(TAG, "connect ~~~~");
        ConnectTask connectTask = new ConnectTask();
        this.mConnectTask = connectTask;
        connectTask.connect(paramsMap, protocolListener);
        Thread thread = new Thread(this.mConnectTask);
        this.mConnectThread = thread;
        thread.start();
    }

    @Override // com.hpplay.component.common.protocol.IConnector
    public void disConnect() {
        CLog.i(TAG, "disConnect");
        ConnectTask connectTask = this.mConnectTask;
        if (connectTask != null) {
            connectTask.setProtocolListener(null);
            this.mConnectTask.disConnect();
        }
        Thread thread = this.mConnectThread;
        if (thread != null) {
            thread.interrupt();
            this.mConnectThread = null;
        }
    }

    @Override // com.hpplay.component.common.protocol.IConnector
    public String getConnectSessionId() {
        ConnectTask connectTask = this.mConnectTask;
        return connectTask != null ? connectTask.getConnectSessionId() : "";
    }

    @Override // com.hpplay.component.common.protocol.IConnector
    public void onAppPause() {
        ConnectTask connectTask = this.mConnectTask;
        if (connectTask != null) {
            connectTask.onAppPause();
        }
    }

    @Override // com.hpplay.component.common.protocol.IConnector
    public void onAppResume() {
        ConnectTask connectTask = this.mConnectTask;
        if (connectTask != null) {
            connectTask.onAppResume();
        }
    }

    @Override // com.hpplay.component.common.protocol.IConnector
    public boolean sendPassthroughData(int i10, String str, String str2, ProtocolListener protocolListener) {
        ConnectTask connectTask = this.mConnectTask;
        if (connectTask == null) {
            return false;
        }
        return connectTask.sendPassthroughData(i10, str, str2, protocolListener);
    }
}
