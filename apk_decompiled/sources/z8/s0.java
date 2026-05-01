package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.Set;

/* loaded from: classes3.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f20913a;

    /* renamed from: b, reason: collision with root package name */
    public final long f20914b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f20915c;

    public s0(int i10, long j10, Set set) {
        this.f20913a = i10;
        this.f20914b = j10;
        this.f20915c = ImmutableSet.copyOf((Collection) set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s0.class != obj.getClass()) {
            return false;
        }
        s0 s0Var = (s0) obj;
        return this.f20913a == s0Var.f20913a && this.f20914b == s0Var.f20914b && Objects.equal(this.f20915c, s0Var.f20915c);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f20913a), Long.valueOf(this.f20914b), this.f20915c);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("maxAttempts", this.f20913a).add("hedgingDelayNanos", this.f20914b).add("nonFatalStatusCodes", this.f20915c).toString();
    }
}
