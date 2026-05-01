package com.hpplay.sdk.source.browse.api;

/* loaded from: classes3.dex */
public interface IServiceInfoParseListener {
    public static final int PARSE_AUTH_FAILED = 3;
    public static final int PARSE_CODE_INVALID = 8;
    public static final int PARSE_CODE_NON_EXISTENT = 7;
    public static final int PARSE_DEVICE_NONSUPPORT = 9;
    public static final int PARSE_DEVICE_OFFLINE = 10;
    public static final int PARSE_ERROR = 0;
    public static final int PARSE_INVALID_INPUT = 11;

    @Deprecated
    public static final int PARSE_NETWORK_ERROR = 6;

    @Deprecated
    public static final int PARSE_REQUEST_ERROR = 2;
    public static final int PARSE_SERVER_ERROR = 5;
    public static final int PARSE_SHORT_URL_INVALID = 4;
    public static final int PARSE_SUCCESS = 1;

    void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo);
}
