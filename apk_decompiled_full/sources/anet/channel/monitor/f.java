package anet.channel.monitor;

/* loaded from: classes.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    protected long f4042b;

    /* renamed from: c, reason: collision with root package name */
    private final double f4043c = 40.0d;

    /* renamed from: a, reason: collision with root package name */
    boolean f4041a = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4044d = true;

    public int a() {
        return 0;
    }

    public final boolean b() {
        if (!this.f4044d) {
            return false;
        }
        if (System.currentTimeMillis() - this.f4042b <= a() * 1000) {
            return true;
        }
        this.f4044d = false;
        return false;
    }

    public boolean a(double d10) {
        return d10 < 40.0d;
    }
}
