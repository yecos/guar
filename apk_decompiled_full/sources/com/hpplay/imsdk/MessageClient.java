package com.hpplay.imsdk;

import com.hpplay.common.log.LeLog;

/* loaded from: classes2.dex */
public class MessageClient extends AbstractBlockingClient {
    private final String TAG;
    private OnReceiveMessageListener mMsgReceiver;

    public MessageClient(String str, int i10, String str2, String str3, String str4, String str5) {
        super(str, i10, str2, str3, str4, str5);
        this.TAG = "IM_MessageClient";
    }

    @Override // com.hpplay.imsdk.AbstractBlockingClient
    public void connected(boolean z10) {
        LeLog.i("IM_MessageClient", "connected");
    }

    @Override // com.hpplay.imsdk.AbstractBlockingClient
    public void disconnected() {
    }

    @Override // com.hpplay.imsdk.AbstractBlockingClient
    public void heartBeatReceived() {
        LeLog.i("IM_MessageClient", "heartBeatReceived");
    }

    @Override // com.hpplay.imsdk.AbstractBlockingClient
    public void messageReceived(Long l10, Long l11, Long l12, Long l13, Long l14, String str) {
    }

    public void setMsgReceiver(OnReceiveMessageListener onReceiveMessageListener) {
        this.mMsgReceiver = onReceiveMessageListener;
    }

    @Override // com.hpplay.imsdk.AbstractBlockingClient
    public void messageReceived(String str) {
    }

    @Override // com.hpplay.imsdk.AbstractBlockingClient
    public void messageReceived(long j10, String str) {
        OnReceiveMessageListener onReceiveMessageListener = this.mMsgReceiver;
        if (onReceiveMessageListener != null) {
            onReceiveMessageListener.onMsg(j10, str);
        }
    }
}
