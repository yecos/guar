package com.alibaba.sdk.android.httpdns.probe;

/* loaded from: classes.dex */
class c {
    private String hostName;
    private String[] ips;

    /* renamed from: k, reason: collision with root package name */
    private long f5939k;

    /* renamed from: l, reason: collision with root package name */
    private long f5940l;

    /* renamed from: r, reason: collision with root package name */
    private String f5941r;

    /* renamed from: s, reason: collision with root package name */
    private String f5942s;

    public c(String str, String[] strArr, String str2, String str3, long j10, long j11) {
        this.hostName = str;
        this.ips = strArr;
        this.f5941r = str2;
        this.f5942s = str3;
        this.f5939k = j10;
        this.f5940l = j11;
    }

    public long c() {
        return this.f5939k;
    }

    public long d() {
        return this.f5940l;
    }

    public String getHostName() {
        return this.hostName;
    }

    public String[] getIps() {
        return this.ips;
    }

    public String j() {
        return this.f5941r;
    }

    public String k() {
        return this.f5942s;
    }
}
