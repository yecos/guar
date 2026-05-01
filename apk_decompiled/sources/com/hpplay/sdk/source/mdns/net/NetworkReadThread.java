package com.hpplay.sdk.source.mdns.net;

/* loaded from: classes3.dex */
public class NetworkReadThread extends Thread {
    public NetworkReadThread(Runnable runnable) {
        super(runnable);
        setName("NetworkReadThread");
    }
}
