package y8;

import com.google.common.base.Preconditions;
import com.hpplay.sdk.source.common.global.Constant;
import y8.a;
import y8.o0;

/* loaded from: classes3.dex */
public abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a.c f19843a = a.c.a("internal:io.grpc.config-selector");

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final k1 f19844a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f19845b;

        /* renamed from: c, reason: collision with root package name */
        public h f19846c;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public Object f19847a;

            /* renamed from: b, reason: collision with root package name */
            public h f19848b;

            public a() {
            }

            public b a() {
                Preconditions.checkState(this.f19847a != null, "config is not set");
                return new b(k1.f19889f, this.f19847a, this.f19848b);
            }

            public a b(Object obj) {
                this.f19847a = Preconditions.checkNotNull(obj, "config");
                return this;
            }
        }

        public static a d() {
            return new a();
        }

        public Object a() {
            return this.f19845b;
        }

        public h b() {
            return this.f19846c;
        }

        public k1 c() {
            return this.f19844a;
        }

        public b(k1 k1Var, Object obj, h hVar) {
            this.f19844a = (k1) Preconditions.checkNotNull(k1Var, Constant.KEY_STATUS);
            this.f19845b = obj;
            this.f19846c = hVar;
        }
    }

    public abstract b a(o0.f fVar);
}
