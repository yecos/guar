package y8;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class t implements Comparable {

    /* renamed from: d, reason: collision with root package name */
    public static final b f20009d = new b();

    /* renamed from: e, reason: collision with root package name */
    public static final long f20010e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f20011f;

    /* renamed from: g, reason: collision with root package name */
    public static final long f20012g;

    /* renamed from: a, reason: collision with root package name */
    public final c f20013a;

    /* renamed from: b, reason: collision with root package name */
    public final long f20014b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f20015c;

    public static class b extends c {
        public b() {
        }

        @Override // y8.t.c
        public long a() {
            return System.nanoTime();
        }
    }

    public static abstract class c {
        public abstract long a();
    }

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        f20010e = nanos;
        f20011f = -nanos;
        f20012g = TimeUnit.SECONDS.toNanos(1L);
    }

    public t(c cVar, long j10, boolean z10) {
        this(cVar, cVar.a(), j10, z10);
    }

    public static t a(long j10, TimeUnit timeUnit) {
        return b(j10, timeUnit, f20009d);
    }

    public static t b(long j10, TimeUnit timeUnit, c cVar) {
        c(timeUnit, "units");
        return new t(cVar, timeUnit.toNanos(j10), true);
    }

    public static Object c(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public final void d(t tVar) {
        if (this.f20013a == tVar.f20013a) {
            return;
        }
        throw new AssertionError("Tickers (" + this.f20013a + " and " + tVar.f20013a + ") don't match. Custom Ticker should only be used in tests!");
    }

    @Override // java.lang.Comparable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(t tVar) {
        d(tVar);
        long j10 = this.f20014b - tVar.f20014b;
        if (j10 < 0) {
            return -1;
        }
        return j10 > 0 ? 1 : 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        c cVar = this.f20013a;
        if (cVar != null ? cVar == tVar.f20013a : tVar.f20013a == null) {
            return this.f20014b == tVar.f20014b;
        }
        return false;
    }

    public boolean f(t tVar) {
        d(tVar);
        return this.f20014b - tVar.f20014b < 0;
    }

    public boolean g() {
        if (!this.f20015c) {
            if (this.f20014b - this.f20013a.a() > 0) {
                return false;
            }
            this.f20015c = true;
        }
        return true;
    }

    public t h(t tVar) {
        d(tVar);
        return f(tVar) ? this : tVar;
    }

    public int hashCode() {
        return Arrays.asList(this.f20013a, Long.valueOf(this.f20014b)).hashCode();
    }

    public long i(TimeUnit timeUnit) {
        long a10 = this.f20013a.a();
        if (!this.f20015c && this.f20014b - a10 <= 0) {
            this.f20015c = true;
        }
        return timeUnit.convert(this.f20014b - a10, TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long i10 = i(TimeUnit.NANOSECONDS);
        long abs = Math.abs(i10);
        long j10 = f20012g;
        long j11 = abs / j10;
        long abs2 = Math.abs(i10) % j10;
        StringBuilder sb = new StringBuilder();
        if (i10 < 0) {
            sb.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
        }
        sb.append(j11);
        if (abs2 > 0) {
            sb.append(String.format(Locale.US, ".%09d", Long.valueOf(abs2)));
        }
        sb.append("s from now");
        if (this.f20013a != f20009d) {
            sb.append(" (ticker=" + this.f20013a + ")");
        }
        return sb.toString();
    }

    public t(c cVar, long j10, long j11, boolean z10) {
        this.f20013a = cVar;
        long min = Math.min(f20010e, Math.max(f20011f, j11));
        this.f20014b = j10 + min;
        this.f20015c = z10 && min <= 0;
    }
}
