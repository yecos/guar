package anet.channel.entity;

import anet.channel.strategy.IConnStrategy;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final IConnStrategy f3964a;

    /* renamed from: b, reason: collision with root package name */
    public int f3965b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f3966c = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f3967d;

    /* renamed from: e, reason: collision with root package name */
    private String f3968e;

    public a(String str, String str2, IConnStrategy iConnStrategy) {
        this.f3964a = iConnStrategy;
        this.f3967d = str;
        this.f3968e = str2;
    }

    public String a() {
        IConnStrategy iConnStrategy = this.f3964a;
        if (iConnStrategy != null) {
            return iConnStrategy.getIp();
        }
        return null;
    }

    public int b() {
        IConnStrategy iConnStrategy = this.f3964a;
        if (iConnStrategy != null) {
            return iConnStrategy.getPort();
        }
        return 0;
    }

    public ConnType c() {
        IConnStrategy iConnStrategy = this.f3964a;
        return iConnStrategy != null ? ConnType.valueOf(iConnStrategy.getProtocol()) : ConnType.HTTP;
    }

    public int d() {
        IConnStrategy iConnStrategy = this.f3964a;
        if (iConnStrategy == null || iConnStrategy.getConnectionTimeout() == 0) {
            return 20000;
        }
        return this.f3964a.getConnectionTimeout();
    }

    public int e() {
        IConnStrategy iConnStrategy = this.f3964a;
        if (iConnStrategy == null || iConnStrategy.getReadTimeout() == 0) {
            return 20000;
        }
        return this.f3964a.getReadTimeout();
    }

    public String f() {
        return this.f3967d;
    }

    public int g() {
        IConnStrategy iConnStrategy = this.f3964a;
        if (iConnStrategy != null) {
            return iConnStrategy.getHeartbeat();
        }
        return 45000;
    }

    public String h() {
        return this.f3968e;
    }

    public String toString() {
        return "ConnInfo [ip=" + a() + ",port=" + b() + ",type=" + c() + ",hb" + g() + "]";
    }
}
