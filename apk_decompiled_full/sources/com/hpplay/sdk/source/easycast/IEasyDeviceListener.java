package com.hpplay.sdk.source.easycast;

import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import java.util.List;

/* loaded from: classes3.dex */
public interface IEasyDeviceListener {
    public static final int BROWSE_ERROR_AUTH = -1;
    public static final int BROWSE_ERROR_AUTH_TIME = -2;
    public static final int BROWSE_NETWORK_DISCONNECTED = 4;
    public static final int BROWSE_STOP = 2;
    public static final int BROWSE_SUCCESS = 1;
    public static final int BROWSE_TIMEOUT = 3;

    void onBrowserResult(int i10);

    void onConnect(LelinkServiceInfo lelinkServiceInfo);

    void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11);

    void onUpdateDevices(List<LelinkServiceInfo> list);
}
