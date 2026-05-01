package com.alibaba.sdk.android.httpdns.probe;

/* loaded from: classes.dex */
public class IPProbeItem {
    String hostName;
    int port;

    public IPProbeItem(String str, int i10) {
        this.hostName = str;
        this.port = i10;
    }

    public String getHostName() {
        return this.hostName;
    }

    public int getPort() {
        return this.port;
    }
}
