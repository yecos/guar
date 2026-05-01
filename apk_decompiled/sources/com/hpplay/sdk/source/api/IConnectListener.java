package com.hpplay.sdk.source.api;

import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;

/* loaded from: classes3.dex */
public interface IConnectListener {

    @Deprecated
    public static final int CONNECT_CONFRENCE_CHECK_LAN = 212017;

    @Deprecated
    public static final int CONNECT_ERROR_BAD_REQUEST = 212016;

    @Deprecated
    public static final int CONNECT_ERROR_FAILED = 212010;

    @Deprecated
    public static final int CONNECT_ERROR_IM_BLACKLIST = 212015;

    @Deprecated
    public static final int CONNECT_ERROR_IM_DEV_OFFLINE = 212018;

    @Deprecated
    public static final int CONNECT_ERROR_IM_REJECT = 212013;

    @Deprecated
    public static final int CONNECT_ERROR_IM_TIMEOUT = 212014;

    @Deprecated
    public static final int CONNECT_ERROR_IM_WAITTING = 212012;

    @Deprecated
    public static final int CONNECT_ERROR_IO = 212011;

    @Deprecated
    public static final int CONNECT_INFO_DISCONNECT = 212000;

    @Deprecated
    public static final int CONNECT_INFO_DISCONNECT_SUCCESS = 212001;

    @Deprecated
    public static final int CONNECT_PINCODE_ERROR = 212019;

    @Deprecated
    public static final int CONNECT_REQUEST_FAILED = 212018;
    public static final int EXTRA_CONNECT_DEVICE_OFFLINE = 212018;
    public static final int EXTRA_CONNECT_ERROR_IO = 212011;
    public static final int EXTRA_CONNECT_INVALID_DEVICE = 212100;
    public static final int EXTRA_DISCONNECT_SUCCESS = 212001;
    public static final int EXTRA_HARASS_BLACKLIST = 212015;
    public static final int EXTRA_HARASS_REJECT = 212013;
    public static final int EXTRA_HARASS_TIMEOUT = 212014;
    public static final int TYPE_DLNA = 3;
    public static final int TYPE_GROUP = 6;
    public static final int TYPE_IM = 4;
    public static final int TYPE_LELINK = 1;

    @Deprecated
    public static final int TYPE_NEW_LELINK = 1;
    public static final int WHAT_CONNECT_FAILED = 212010;
    public static final int WHAT_DISCONNECT = 212000;
    public static final int WHAT_HARASS_WAITING = 212012;

    void onConnect(LelinkServiceInfo lelinkServiceInfo, int i10);

    void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11);
}
