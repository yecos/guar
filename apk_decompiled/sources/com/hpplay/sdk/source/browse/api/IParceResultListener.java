package com.hpplay.sdk.source.browse.api;

@Deprecated
/* loaded from: classes3.dex */
public interface IParceResultListener {
    public static final int AUDTH_FAILED = 3;
    public static final int PARCE_CODE_INVALID = 8;
    public static final int PARCE_CODE_NON_EXISTENT = 7;
    public static final int PARCE_ERROR = 0;
    public static final int PARCE_NETWORK_ERROR = 6;
    public static final int PARCE_SERVER_ERROR = 5;
    public static final int PARCE_SHORTURL_INVALID = 4;
    public static final int PARCE_SUCCESS = 1;
    public static final int REQUEST_ERROR = 2;

    void onParceResult(int i10, LelinkServiceInfo lelinkServiceInfo);
}
