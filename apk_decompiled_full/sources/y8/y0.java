package y8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.hpplay.sdk.source.common.global.Constant;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes3.dex */
public abstract class y0 {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f20071a;

        /* renamed from: b, reason: collision with root package name */
        public final d1 f20072b;

        /* renamed from: c, reason: collision with root package name */
        public final o1 f20073c;

        /* renamed from: d, reason: collision with root package name */
        public final f f20074d;

        /* renamed from: e, reason: collision with root package name */
        public final ScheduledExecutorService f20075e;

        /* renamed from: f, reason: collision with root package name */
        public final y8.f f20076f;

        /* renamed from: g, reason: collision with root package name */
        public final Executor f20077g;

        /* renamed from: h, reason: collision with root package name */
        public final String f20078h;

        /* renamed from: y8.y0$a$a, reason: collision with other inner class name */
        public static final class C0346a {

            /* renamed from: a, reason: collision with root package name */
            public Integer f20079a;

            /* renamed from: b, reason: collision with root package name */
            public d1 f20080b;

            /* renamed from: c, reason: collision with root package name */
            public o1 f20081c;

            /* renamed from: d, reason: collision with root package name */
            public f f20082d;

            /* renamed from: e, reason: collision with root package name */
            public ScheduledExecutorService f20083e;

            /* renamed from: f, reason: collision with root package name */
            public y8.f f20084f;

            /* renamed from: g, reason: collision with root package name */
            public Executor f20085g;

            /* renamed from: h, reason: collision with root package name */
            public String f20086h;

            public a a() {
                return new a(this.f20079a, this.f20080b, this.f20081c, this.f20082d, this.f20083e, this.f20084f, this.f20085g, this.f20086h, null);
            }

            public C0346a b(y8.f fVar) {
                this.f20084f = (y8.f) Preconditions.checkNotNull(fVar);
                return this;
            }

            public C0346a c(int i10) {
                this.f20079a = Integer.valueOf(i10);
                return this;
            }

            public C0346a d(Executor executor) {
                this.f20085g = executor;
                return this;
            }

            public C0346a e(String str) {
                this.f20086h = str;
                return this;
            }

            public C0346a f(d1 d1Var) {
                this.f20080b = (d1) Preconditions.checkNotNull(d1Var);
                return this;
            }

            public C0346a g(ScheduledExecutorService scheduledExecutorService) {
                this.f20083e = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
                return this;
            }

            public C0346a h(f fVar) {
                this.f20082d = (f) Preconditions.checkNotNull(fVar);
                return this;
            }

            public C0346a i(o1 o1Var) {
                this.f20081c = (o1) Preconditions.checkNotNull(o1Var);
                return this;
            }
        }

        public /* synthetic */ a(Integer num, d1 d1Var, o1 o1Var, f fVar, ScheduledExecutorService scheduledExecutorService, y8.f fVar2, Executor executor, String str, x0 x0Var) {
            this(num, d1Var, o1Var, fVar, scheduledExecutorService, fVar2, executor, str);
        }

        public static C0346a f() {
            return new C0346a();
        }

        public int a() {
            return this.f20071a;
        }

        public Executor b() {
            return this.f20077g;
        }

        public d1 c() {
            return this.f20072b;
        }

        public f d() {
            return this.f20074d;
        }

        public o1 e() {
            return this.f20073c;
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("defaultPort", this.f20071a).add("proxyDetector", this.f20072b).add("syncContext", this.f20073c).add("serviceConfigParser", this.f20074d).add("scheduledExecutorService", this.f20075e).add("channelLogger", this.f20076f).add("executor", this.f20077g).add("overrideAuthority", this.f20078h).toString();
        }

        public a(Integer num, d1 d1Var, o1 o1Var, f fVar, ScheduledExecutorService scheduledExecutorService, y8.f fVar2, Executor executor, String str) {
            this.f20071a = ((Integer) Preconditions.checkNotNull(num, "defaultPort not set")).intValue();
            this.f20072b = (d1) Preconditions.checkNotNull(d1Var, "proxyDetector not set");
            this.f20073c = (o1) Preconditions.checkNotNull(o1Var, "syncContext not set");
            this.f20074d = (f) Preconditions.checkNotNull(fVar, "serviceConfigParser not set");
            this.f20075e = scheduledExecutorService;
            this.f20076f = fVar2;
            this.f20077g = executor;
            this.f20078h = str;
        }
    }

    public static abstract class c {
        public abstract String a();

        public abstract y0 b(URI uri, a aVar);
    }

    public static abstract class d {
        public abstract void a(k1 k1Var);

        public abstract void b(e eVar);
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final List f20089a;

        /* renamed from: b, reason: collision with root package name */
        public final y8.a f20090b;

        /* renamed from: c, reason: collision with root package name */
        public final b f20091c;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public List f20092a = Collections.emptyList();

            /* renamed from: b, reason: collision with root package name */
            public y8.a f20093b = y8.a.f19771c;

            /* renamed from: c, reason: collision with root package name */
            public b f20094c;

            public e a() {
                return new e(this.f20092a, this.f20093b, this.f20094c);
            }

            public a b(List list) {
                this.f20092a = list;
                return this;
            }

            public a c(y8.a aVar) {
                this.f20093b = aVar;
                return this;
            }

            public a d(b bVar) {
                this.f20094c = bVar;
                return this;
            }
        }

        public e(List list, y8.a aVar, b bVar) {
            this.f20089a = Collections.unmodifiableList(new ArrayList(list));
            this.f20090b = (y8.a) Preconditions.checkNotNull(aVar, "attributes");
            this.f20091c = bVar;
        }

        public static a d() {
            return new a();
        }

        public List a() {
            return this.f20089a;
        }

        public y8.a b() {
            return this.f20090b;
        }

        public b c() {
            return this.f20091c;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return Objects.equal(this.f20089a, eVar.f20089a) && Objects.equal(this.f20090b, eVar.f20090b) && Objects.equal(this.f20091c, eVar.f20091c);
        }

        public int hashCode() {
            return Objects.hashCode(this.f20089a, this.f20090b, this.f20091c);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("addresses", this.f20089a).add("attributes", this.f20090b).add("serviceConfig", this.f20091c).toString();
        }
    }

    public static abstract class f {
        public abstract b a(Map map);
    }

    public abstract String a();

    public abstract void b();

    public abstract void c();

    public abstract void d(d dVar);

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final k1 f20087a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f20088b;

        public b(Object obj) {
            this.f20088b = Preconditions.checkNotNull(obj, "config");
            this.f20087a = null;
        }

        public static b a(Object obj) {
            return new b(obj);
        }

        public static b b(k1 k1Var) {
            return new b(k1Var);
        }

        public Object c() {
            return this.f20088b;
        }

        public k1 d() {
            return this.f20087a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return Objects.equal(this.f20087a, bVar.f20087a) && Objects.equal(this.f20088b, bVar.f20088b);
        }

        public int hashCode() {
            return Objects.hashCode(this.f20087a, this.f20088b);
        }

        public String toString() {
            return this.f20088b != null ? MoreObjects.toStringHelper(this).add("config", this.f20088b).toString() : MoreObjects.toStringHelper(this).add("error", this.f20087a).toString();
        }

        public b(k1 k1Var) {
            this.f20088b = null;
            this.f20087a = (k1) Preconditions.checkNotNull(k1Var, Constant.KEY_STATUS);
            Preconditions.checkArgument(!k1Var.p(), "cannot use OK status: %s", k1Var);
        }
    }
}
