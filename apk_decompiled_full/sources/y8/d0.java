package y8;

import com.google.android.gms.cast.MediaTrack;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* loaded from: classes3.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f19828a;

    /* renamed from: b, reason: collision with root package name */
    public final b f19829b;

    /* renamed from: c, reason: collision with root package name */
    public final long f19830c;

    /* renamed from: d, reason: collision with root package name */
    public final m0 f19831d;

    /* renamed from: e, reason: collision with root package name */
    public final m0 f19832e;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f19833a;

        /* renamed from: b, reason: collision with root package name */
        public b f19834b;

        /* renamed from: c, reason: collision with root package name */
        public Long f19835c;

        /* renamed from: d, reason: collision with root package name */
        public m0 f19836d;

        /* renamed from: e, reason: collision with root package name */
        public m0 f19837e;

        public d0 a() {
            Preconditions.checkNotNull(this.f19833a, MediaTrack.ROLE_DESCRIPTION);
            Preconditions.checkNotNull(this.f19834b, "severity");
            Preconditions.checkNotNull(this.f19835c, "timestampNanos");
            Preconditions.checkState(this.f19836d == null || this.f19837e == null, "at least one of channelRef and subchannelRef must be null");
            return new d0(this.f19833a, this.f19834b, this.f19835c.longValue(), this.f19836d, this.f19837e);
        }

        public a b(String str) {
            this.f19833a = str;
            return this;
        }

        public a c(b bVar) {
            this.f19834b = bVar;
            return this;
        }

        public a d(m0 m0Var) {
            this.f19837e = m0Var;
            return this;
        }

        public a e(long j10) {
            this.f19835c = Long.valueOf(j10);
            return this;
        }
    }

    public enum b {
        CT_UNKNOWN,
        CT_INFO,
        CT_WARNING,
        CT_ERROR
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return Objects.equal(this.f19828a, d0Var.f19828a) && Objects.equal(this.f19829b, d0Var.f19829b) && this.f19830c == d0Var.f19830c && Objects.equal(this.f19831d, d0Var.f19831d) && Objects.equal(this.f19832e, d0Var.f19832e);
    }

    public int hashCode() {
        return Objects.hashCode(this.f19828a, this.f19829b, Long.valueOf(this.f19830c), this.f19831d, this.f19832e);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add(MediaTrack.ROLE_DESCRIPTION, this.f19828a).add("severity", this.f19829b).add("timestampNanos", this.f19830c).add("channelRef", this.f19831d).add("subchannelRef", this.f19832e).toString();
    }

    public d0(String str, b bVar, long j10, m0 m0Var, m0 m0Var2) {
        this.f19828a = str;
        this.f19829b = (b) Preconditions.checkNotNull(bVar, "severity");
        this.f19830c = j10;
        this.f19831d = m0Var;
        this.f19832e = m0Var2;
    }
}
