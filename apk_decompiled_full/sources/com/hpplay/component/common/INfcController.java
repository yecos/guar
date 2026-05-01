package com.hpplay.component.common;

import com.hpplay.component.common.protocol.ProtocolListener;

/* loaded from: classes2.dex */
public interface INfcController {
    void close();

    byte[] getDeviceInfo();

    boolean init();

    boolean isSupportNfc();

    void registerNfcListener(ProtocolListener protocolListener);

    void unRegisterNfcListener(ProtocolListener protocolListener);

    boolean writeDeviceInfo(byte[] bArr);
}
