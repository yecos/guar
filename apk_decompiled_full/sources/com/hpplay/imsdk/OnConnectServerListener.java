package com.hpplay.imsdk;

/* loaded from: classes2.dex */
public interface OnConnectServerListener {
    void onAuthCallback(String str);

    void onConnectFailed();

    void onConnectSuccess();

    void onRestart();
}
