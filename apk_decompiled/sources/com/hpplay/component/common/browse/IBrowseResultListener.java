package com.hpplay.component.common.browse;

/* loaded from: classes2.dex */
public interface IBrowseResultListener {
    public static final int TYPE_DLNA = 1;
    public static final int TYPE_MDNS = 2;
    public static final int TYPE_SONIC = 3;
    public static final int TYPE_WIFIP2P_DEV = 4;
    public static final int TYPE_WIFIP2P_MDNS = 5;
    public static final int TYPE_WIFIP2P_PIN = 6;

    void onBrowseResultCallback(int i10, Object obj);
}
