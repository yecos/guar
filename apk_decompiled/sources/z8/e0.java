package z8;

import com.google.common.base.Preconditions;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import z8.k;

/* loaded from: classes3.dex */
public final class e0 implements k {

    /* renamed from: a, reason: collision with root package name */
    public Random f20435a = new Random();

    /* renamed from: b, reason: collision with root package name */
    public long f20436b = TimeUnit.SECONDS.toNanos(1);

    /* renamed from: c, reason: collision with root package name */
    public long f20437c = TimeUnit.MINUTES.toNanos(2);

    /* renamed from: d, reason: collision with root package name */
    public double f20438d = 1.6d;

    /* renamed from: e, reason: collision with root package name */
    public double f20439e = 0.2d;

    /* renamed from: f, reason: collision with root package name */
    public long f20440f = this.f20436b;

    public static final class a implements k.a {
        @Override // z8.k.a
        public k get() {
            return new e0();
        }
    }

    @Override // z8.k
    public long a() {
        long j10 = this.f20440f;
        double d10 = j10;
        double d11 = this.f20438d;
        Double.isNaN(d10);
        this.f20440f = Math.min((long) (d11 * d10), this.f20437c);
        double d12 = this.f20439e;
        Double.isNaN(d10);
        Double.isNaN(d10);
        return j10 + b((-d12) * d10, d12 * d10);
    }

    public final long b(double d10, double d11) {
        Preconditions.checkArgument(d11 >= d10);
        return (long) ((this.f20435a.nextDouble() * (d11 - d10)) + d10);
    }
}
