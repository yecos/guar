package com.hpplay.component.protocol;

import com.hpplay.component.common.protocol.ProtocolListener;

/* loaded from: classes2.dex */
public class ProtocolInfo {
    private byte[][] protocolData;
    private ProtocolListener protocolListener;

    public byte[][] getProtocolData() {
        return this.protocolData;
    }

    public ProtocolListener getProtocolListener() {
        return this.protocolListener;
    }

    public void setProtocolData(byte[][] bArr) {
        this.protocolData = bArr;
    }

    public void setProtocolListener(ProtocolListener protocolListener) {
        this.protocolListener = protocolListener;
    }
}
