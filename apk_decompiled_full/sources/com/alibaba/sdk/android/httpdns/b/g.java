package com.alibaba.sdk.android.httpdns.b;

/* loaded from: classes.dex */
public class g {

    /* renamed from: i, reason: collision with root package name */
    public long f5854i;
    public long id;

    /* renamed from: o, reason: collision with root package name */
    public String f5855o;

    /* renamed from: p, reason: collision with root package name */
    public String f5856p;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("[IpRecord] ");
        sb.append("id:");
        sb.append(this.id);
        sb.append("|");
        sb.append("host_id:");
        sb.append(this.f5854i);
        sb.append("|");
        sb.append("ip:");
        sb.append(this.f5855o);
        sb.append("|");
        sb.append("ttl:");
        sb.append(this.f5856p);
        sb.append("|");
        return sb.toString();
    }
}
