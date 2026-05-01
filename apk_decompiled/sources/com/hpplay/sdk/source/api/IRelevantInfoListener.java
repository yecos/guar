package com.hpplay.sdk.source.api;

import com.hpplay.sdk.source.protocol.ProtocolListener;

/* loaded from: classes3.dex */
public abstract class IRelevantInfoListener implements ProtocolListener {
    public static final int LOG_UPLOAD_BADREQUEST = 2;
    public static final int LOG_UPLOAD_FAILED = -1;
    public static final int LOG_UPLOAD_LOADING = 6;
    public static final int LOG_UPLOAD_NOACCEP = 3;
    public static final int LOG_UPLOAD_NOTPOST = 4;
    public static final int LOG_UPLOAD_SUCCESS = 1;
    public static final int LOG_UPLOAD_ZIPFAILED = 5;
    private int mOption;

    @Override // com.hpplay.sdk.source.protocol.ProtocolListener
    public void onResult(String str) {
        onSendRelevantInfoResult(this.mOption, str);
    }

    public void onReverseInfoResult(int i10, String str) {
    }

    public abstract void onSendRelevantInfoResult(int i10, String str);

    public void setOption(int i10) {
        this.mOption = i10;
    }
}
