package z8;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import y8.o0;

/* loaded from: classes3.dex */
public final class r1 extends o0.f {

    /* renamed from: a, reason: collision with root package name */
    public final y8.c f20910a;

    /* renamed from: b, reason: collision with root package name */
    public final y8.v0 f20911b;

    /* renamed from: c, reason: collision with root package name */
    public final y8.w0 f20912c;

    public r1(y8.w0 w0Var, y8.v0 v0Var, y8.c cVar) {
        this.f20912c = (y8.w0) Preconditions.checkNotNull(w0Var, FirebaseAnalytics.Param.METHOD);
        this.f20911b = (y8.v0) Preconditions.checkNotNull(v0Var, "headers");
        this.f20910a = (y8.c) Preconditions.checkNotNull(cVar, "callOptions");
    }

    @Override // y8.o0.f
    public y8.c a() {
        return this.f20910a;
    }

    @Override // y8.o0.f
    public y8.v0 b() {
        return this.f20911b;
    }

    @Override // y8.o0.f
    public y8.w0 c() {
        return this.f20912c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r1.class != obj.getClass()) {
            return false;
        }
        r1 r1Var = (r1) obj;
        return Objects.equal(this.f20910a, r1Var.f20910a) && Objects.equal(this.f20911b, r1Var.f20911b) && Objects.equal(this.f20912c, r1Var.f20912c);
    }

    public int hashCode() {
        return Objects.hashCode(this.f20910a, this.f20911b, this.f20912c);
    }

    public final String toString() {
        return "[method=" + this.f20912c + " headers=" + this.f20911b + " callOptions=" + this.f20910a + "]";
    }
}
