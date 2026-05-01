package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.z;

/* loaded from: classes3.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final long f15820a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f15821b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f15822c;

    /* renamed from: d, reason: collision with root package name */
    public static final long f15823d;

    /* renamed from: e, reason: collision with root package name */
    public static g f15824e;

    /* renamed from: f, reason: collision with root package name */
    public static final i f15825f;

    /* renamed from: g, reason: collision with root package name */
    public static final i f15826g;

    static {
        long e10;
        int d10;
        int d11;
        long e11;
        e10 = b0.e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        f15820a = e10;
        d10 = b0.d("kotlinx.coroutines.scheduler.core.pool.size", y9.e.a(z.a(), 2), 1, 0, 8, null);
        f15821b = d10;
        d11 = b0.d("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
        f15822c = d11;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e11 = b0.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f15823d = timeUnit.toNanos(e11);
        f15824e = e.f15810a;
        f15825f = new j(0);
        f15826g = new j(1);
    }
}
