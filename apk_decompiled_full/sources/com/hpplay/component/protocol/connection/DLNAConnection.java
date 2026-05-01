package com.hpplay.component.protocol.connection;

import com.hpplay.component.common.ParamsMap;

/* loaded from: classes2.dex */
public class DLNAConnection extends IConnection {
    public DLNAConnection(ParamsMap paramsMap) {
        super(paramsMap);
    }

    @Override // com.hpplay.component.protocol.connection.IConnection
    public boolean checkConnection() {
        return this.mProtocolSender.tcpCheckTvState(this.mIp, this.mPort);
    }

    @Override // com.hpplay.component.protocol.connection.IConnection
    public boolean startConnect() {
        boolean connectServer = this.mProtocolSender.connectServer(this.mTimeout);
        this.mProtocolSender.release();
        return connectServer;
    }
}
