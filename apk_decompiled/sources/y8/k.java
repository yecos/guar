package y8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

/* loaded from: classes3.dex */
public abstract class k extends n1 {

    public static abstract class a {
        public abstract k a(b bVar, v0 v0Var);
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final c f19881a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19882b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f19883c;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public c f19884a = c.f19794k;

            /* renamed from: b, reason: collision with root package name */
            public int f19885b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f19886c;

            public b a() {
                return new b(this.f19884a, this.f19885b, this.f19886c);
            }

            public a b(c cVar) {
                this.f19884a = (c) Preconditions.checkNotNull(cVar, "callOptions cannot be null");
                return this;
            }

            public a c(boolean z10) {
                this.f19886c = z10;
                return this;
            }

            public a d(int i10) {
                this.f19885b = i10;
                return this;
            }
        }

        public b(c cVar, int i10, boolean z10) {
            this.f19881a = (c) Preconditions.checkNotNull(cVar, "callOptions");
            this.f19882b = i10;
            this.f19883c = z10;
        }

        public static a a() {
            return new a();
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("callOptions", this.f19881a).add("previousAttempts", this.f19882b).add("isTransparentRetry", this.f19883c).toString();
        }
    }

    public void j() {
    }

    public void k(v0 v0Var) {
    }

    public void l() {
    }

    public void m(y8.a aVar, v0 v0Var) {
    }
}
