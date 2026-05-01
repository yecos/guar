package com.hpplay.component.common.protocol;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.SourceModule;

/* loaded from: classes2.dex */
public abstract class IConnector implements SourceModule {
    public abstract void checkConnection(ProtocolListener protocolListener);

    public abstract void connect(ParamsMap paramsMap, ProtocolListener protocolListener);

    public abstract void disConnect();

    public abstract String getConnectSessionId();

    public abstract void onAppPause();

    public abstract void onAppResume();

    public abstract boolean sendPassthroughData(int i10, String str, String str2, ProtocolListener protocolListener);
}
