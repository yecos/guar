package com.hpplay.component.common.wifidirect;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public interface IDataTransmitter {
    void closeTransmitter();

    boolean isConnected();

    void sendP2pData(ByteBuffer byteBuffer);
}
