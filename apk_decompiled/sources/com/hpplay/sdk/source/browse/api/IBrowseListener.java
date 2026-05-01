package com.hpplay.sdk.source.browse.api;

import java.util.List;

/* loaded from: classes3.dex */
public interface IBrowseListener {
    public static final int BROWSE_ERROR_AUTH = -1;
    public static final int BROWSE_ERROR_AUTH_TIME = -2;
    public static final int BROWSE_NETWORK_DISCONNECTED = 4;
    public static final int BROWSE_STOP = 2;
    public static final int BROWSE_SUCCESS = 1;
    public static final int BROWSE_TIMEOUT = 3;

    void onBrowse(int i10, List<LelinkServiceInfo> list);
}
