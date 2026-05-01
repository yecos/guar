package com.umeng.message.api;

/* loaded from: classes3.dex */
public interface UPushMessageNotifyApi {

    public interface Callback {
        void onNotified();

        void onNotifying();
    }

    boolean isEnabled();

    void setCallback(Callback callback);

    void setEnable(boolean z10);
}
