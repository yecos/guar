package com.hpplay.sdk.source.pass.sinktouch;

import android.text.TextUtils;
import com.hpplay.sdk.source.bean.SinkTouchEvent;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.ByteUtils;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class SinkTouchEventIMChannel {
    private static final String TAG = "SinkTouchEventIMChannel";
    private static SinkTouchEventIMChannel sInstance;
    private ISinkTouchEventCallback mCallback;

    private SinkTouchEventIMChannel() {
    }

    public static synchronized SinkTouchEventIMChannel getInstance() {
        SinkTouchEventIMChannel sinkTouchEventIMChannel;
        synchronized (SinkTouchEventIMChannel.class) {
            if (sInstance == null) {
                synchronized (SinkTouchEventIMChannel.class) {
                    if (sInstance == null) {
                        sInstance = new SinkTouchEventIMChannel();
                    }
                }
            }
            sinkTouchEventIMChannel = sInstance;
        }
        return sinkTouchEventIMChannel;
    }

    public void onReceiveIMTouchEvent(String str) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.e(TAG, "onReceiveIMTouchEvent msg is null");
            return;
        }
        byte[] hexToBytes = ByteUtils.hexToBytes(str);
        SourceLog.i(TAG, "onReceiveIMTouchEvent eventBytes : " + str + " / " + Arrays.toString(hexToBytes));
        ISinkTouchEventCallback iSinkTouchEventCallback = this.mCallback;
        if (iSinkTouchEventCallback != null) {
            iSinkTouchEventCallback.onEventReceived(SinkTouchEvent.parseProtocolData(hexToBytes));
        }
    }

    public void onReceiveYouMeTouchEvent(byte[] bArr) {
        if (bArr == null) {
            SourceLog.e(TAG, "onReceiveYouMeTouchEvent msg is null");
            return;
        }
        ISinkTouchEventCallback iSinkTouchEventCallback = this.mCallback;
        if (iSinkTouchEventCallback != null) {
            iSinkTouchEventCallback.onEventReceived(SinkTouchEvent.parseProtocolData(bArr));
        }
    }

    public void setCallback(ISinkTouchEventCallback iSinkTouchEventCallback) {
        this.mCallback = iSinkTouchEventCallback;
    }
}
