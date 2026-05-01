package z8;

import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class h {

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f20628c = Logger.getLogger(h.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final String f20629a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicLong f20630b;

    public final class b {

        /* renamed from: a, reason: collision with root package name */
        public final long f20631a;

        public void a() {
            long j10 = this.f20631a;
            long max = Math.max(2 * j10, j10);
            if (h.this.f20630b.compareAndSet(this.f20631a, max)) {
                h.f20628c.log(Level.WARNING, "Increased {0} to {1}", new Object[]{h.this.f20629a, Long.valueOf(max)});
            }
        }

        public long b() {
            return this.f20631a;
        }

        public b(long j10) {
            this.f20631a = j10;
        }
    }

    public h(String str, long j10) {
        AtomicLong atomicLong = new AtomicLong();
        this.f20630b = atomicLong;
        Preconditions.checkArgument(j10 > 0, "value must be positive");
        this.f20629a = str;
        atomicLong.set(j10);
    }

    public b d() {
        return new b(this.f20630b.get());
    }
}
