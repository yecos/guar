package i2;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f14287a = new h();

    /* renamed from: b, reason: collision with root package name */
    public static final String f14288b = "BBVariable";

    /* renamed from: c, reason: collision with root package name */
    public static long f14289c;

    public final long a() {
        if (f14289c == 0) {
            f14289c = i.f14290a.a();
            long longValue = ((Number) e.f14282b.a().b("server_time", 0L)).longValue();
            if (f14289c < longValue) {
                f14289c = longValue;
            }
        }
        return f14289c;
    }

    public final void b(long j10) {
        f14289c = j10;
    }
}
