package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.Set;

/* loaded from: classes3.dex */
public final class y1 {

    /* renamed from: a, reason: collision with root package name */
    public final int f21141a;

    /* renamed from: b, reason: collision with root package name */
    public final long f21142b;

    /* renamed from: c, reason: collision with root package name */
    public final long f21143c;

    /* renamed from: d, reason: collision with root package name */
    public final double f21144d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f21145e;

    /* renamed from: f, reason: collision with root package name */
    public final Set f21146f;

    public y1(int i10, long j10, long j11, double d10, Long l10, Set set) {
        this.f21141a = i10;
        this.f21142b = j10;
        this.f21143c = j11;
        this.f21144d = d10;
        this.f21145e = l10;
        this.f21146f = ImmutableSet.copyOf((Collection) set);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof y1)) {
            return false;
        }
        y1 y1Var = (y1) obj;
        return this.f21141a == y1Var.f21141a && this.f21142b == y1Var.f21142b && this.f21143c == y1Var.f21143c && Double.compare(this.f21144d, y1Var.f21144d) == 0 && Objects.equal(this.f21145e, y1Var.f21145e) && Objects.equal(this.f21146f, y1Var.f21146f);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f21141a), Long.valueOf(this.f21142b), Long.valueOf(this.f21143c), Double.valueOf(this.f21144d), this.f21145e, this.f21146f);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("maxAttempts", this.f21141a).add("initialBackoffNanos", this.f21142b).add("maxBackoffNanos", this.f21143c).add("backoffMultiplier", this.f21144d).add("perAttemptRecvTimeoutNanos", this.f21145e).add("retryableStatusCodes", this.f21146f).toString();
    }
}
