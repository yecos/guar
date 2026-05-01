package com.hpplay.sdk.source.transceiver;

import com.hpplay.sdk.source.transceiver.bean.RemoteServerBean;

/* loaded from: classes3.dex */
public interface IRemoteServerListener {
    void onServerFailed(int i10);

    void onServerStarted(RemoteServerBean remoteServerBean);
}
