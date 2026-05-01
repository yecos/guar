package com.hpplay.component.protocol.push;

import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;

/* loaded from: classes2.dex */
public class RequestNewDevRetryListener extends ProtocolListener {
    private static final int RETRY_PLAY_MAX_COUNT = 2;
    private static final String TAG = "RequestNewDevRetryListener";
    private PushControllerImpl mPushController;
    private String[] mResult;

    public RequestNewDevRetryListener(PushControllerImpl pushControllerImpl, String... strArr) {
        CLog.i(TAG, "new RequestNewDevRetryListener");
        this.mPushController = pushControllerImpl;
        this.mResult = strArr;
    }

    @Override // com.hpplay.component.common.protocol.ProtocolListener
    public void onResult(int i10, String... strArr) {
        try {
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        if (this.mPushController.getConnectionState()) {
            if (strArr == null || TextUtils.isEmpty(strArr[0]) || this.mPushController.retryCount >= 2) {
                CLog.i(TAG, " reconnect push failed ");
                this.mPushController.eventCallback(1, this.mResult);
            } else {
                CLog.i(TAG, " reconnect push success ");
                this.mPushController.retryCount++;
                ParamsMap create = ParamsMap.create(strArr[0]);
                this.mPushController.mParams.putParam(ParamsMap.PushParams.KEY_PROTOCOL_TYPE, create.getParam(ParamsMap.PushParams.KEY_PROTOCOL_TYPE, 0));
                this.mPushController.mParams.putParam("ip", create.getIp());
                this.mPushController.mParams.putParam(ParamsMap.PushParams.KEY_LOCATION_URI, create.getStringParam(ParamsMap.PushParams.KEY_LOCATION_URI));
                this.mPushController.mParams.putParam(ParamsMap.DeviceParams.KEY_LELINK_PORT, Integer.valueOf(create.getPort()));
                PushControllerImpl pushControllerImpl = this.mPushController;
                pushControllerImpl.genPushConnection(pushControllerImpl.mUrl, pushControllerImpl.mParams);
            }
            this.mPushController = null;
            this.mResult = null;
        }
    }
}
