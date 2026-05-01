package y8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.hpplay.sdk.source.common.global.Constant;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import y8.a;
import y8.k;

/* loaded from: classes3.dex */
public abstract class o0 {

    /* renamed from: b, reason: collision with root package name */
    public static final a.c f19951b = a.c.a("internal:health-checking-config");

    /* renamed from: a, reason: collision with root package name */
    public int f19952a;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final List f19953a;

        /* renamed from: b, reason: collision with root package name */
        public final y8.a f19954b;

        /* renamed from: c, reason: collision with root package name */
        public final Object[][] f19955c;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public List f19956a;

            /* renamed from: b, reason: collision with root package name */
            public y8.a f19957b = y8.a.f19771c;

            /* renamed from: c, reason: collision with root package name */
            public Object[][] f19958c = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);

            public b b() {
                return new b(this.f19956a, this.f19957b, this.f19958c);
            }

            public final a c(Object[][] objArr) {
                Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, objArr.length, 2);
                this.f19958c = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                return this;
            }

            public a d(List list) {
                Preconditions.checkArgument(!list.isEmpty(), "addrs is empty");
                this.f19956a = Collections.unmodifiableList(new ArrayList(list));
                return this;
            }

            public a e(x xVar) {
                this.f19956a = Collections.singletonList(xVar);
                return this;
            }

            public a f(y8.a aVar) {
                this.f19957b = (y8.a) Preconditions.checkNotNull(aVar, "attrs");
                return this;
            }
        }

        public static a c() {
            return new a();
        }

        public List a() {
            return this.f19953a;
        }

        public y8.a b() {
            return this.f19954b;
        }

        public a d() {
            return c().d(this.f19953a).f(this.f19954b).c(this.f19955c);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("addrs", this.f19953a).add("attrs", this.f19954b).add("customOptions", Arrays.deepToString(this.f19955c)).toString();
        }

        public b(List list, y8.a aVar, Object[][] objArr) {
            this.f19953a = (List) Preconditions.checkNotNull(list, "addresses are not set");
            this.f19954b = (y8.a) Preconditions.checkNotNull(aVar, "attrs");
            this.f19955c = (Object[][]) Preconditions.checkNotNull(objArr, "customOptions");
        }
    }

    public static abstract class c {
        public abstract o0 a(d dVar);
    }

    public static abstract class d {
        public abstract h a(b bVar);

        public abstract y8.f b();

        public abstract ScheduledExecutorService c();

        public abstract o1 d();

        public abstract void e();

        public abstract void f(p pVar, i iVar);
    }

    public static final class e {

        /* renamed from: e, reason: collision with root package name */
        public static final e f19959e = new e(null, null, k1.f19889f, false);

        /* renamed from: a, reason: collision with root package name */
        public final h f19960a;

        /* renamed from: b, reason: collision with root package name */
        public final k.a f19961b;

        /* renamed from: c, reason: collision with root package name */
        public final k1 f19962c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f19963d;

        public e(h hVar, k.a aVar, k1 k1Var, boolean z10) {
            this.f19960a = hVar;
            this.f19961b = aVar;
            this.f19962c = (k1) Preconditions.checkNotNull(k1Var, Constant.KEY_STATUS);
            this.f19963d = z10;
        }

        public static e e(k1 k1Var) {
            Preconditions.checkArgument(!k1Var.p(), "drop status shouldn't be OK");
            return new e(null, null, k1Var, true);
        }

        public static e f(k1 k1Var) {
            Preconditions.checkArgument(!k1Var.p(), "error status shouldn't be OK");
            return new e(null, null, k1Var, false);
        }

        public static e g() {
            return f19959e;
        }

        public static e h(h hVar) {
            return i(hVar, null);
        }

        public static e i(h hVar, k.a aVar) {
            return new e((h) Preconditions.checkNotNull(hVar, "subchannel"), aVar, k1.f19889f, false);
        }

        public k1 a() {
            return this.f19962c;
        }

        public k.a b() {
            return this.f19961b;
        }

        public h c() {
            return this.f19960a;
        }

        public boolean d() {
            return this.f19963d;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return Objects.equal(this.f19960a, eVar.f19960a) && Objects.equal(this.f19962c, eVar.f19962c) && Objects.equal(this.f19961b, eVar.f19961b) && this.f19963d == eVar.f19963d;
        }

        public int hashCode() {
            return Objects.hashCode(this.f19960a, this.f19962c, this.f19961b, Boolean.valueOf(this.f19963d));
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("subchannel", this.f19960a).add("streamTracerFactory", this.f19961b).add(Constant.KEY_STATUS, this.f19962c).add("drop", this.f19963d).toString();
        }
    }

    public static abstract class f {
        public abstract y8.c a();

        public abstract v0 b();

        public abstract w0 c();
    }

    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final List f19964a;

        /* renamed from: b, reason: collision with root package name */
        public final y8.a f19965b;

        /* renamed from: c, reason: collision with root package name */
        public final Object f19966c;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public List f19967a;

            /* renamed from: b, reason: collision with root package name */
            public y8.a f19968b = y8.a.f19771c;

            /* renamed from: c, reason: collision with root package name */
            public Object f19969c;

            public g a() {
                return new g(this.f19967a, this.f19968b, this.f19969c);
            }

            public a b(List list) {
                this.f19967a = list;
                return this;
            }

            public a c(y8.a aVar) {
                this.f19968b = aVar;
                return this;
            }

            public a d(Object obj) {
                this.f19969c = obj;
                return this;
            }
        }

        public static a d() {
            return new a();
        }

        public List a() {
            return this.f19964a;
        }

        public y8.a b() {
            return this.f19965b;
        }

        public Object c() {
            return this.f19966c;
        }

        public a e() {
            return d().b(this.f19964a).c(this.f19965b).d(this.f19966c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return Objects.equal(this.f19964a, gVar.f19964a) && Objects.equal(this.f19965b, gVar.f19965b) && Objects.equal(this.f19966c, gVar.f19966c);
        }

        public int hashCode() {
            return Objects.hashCode(this.f19964a, this.f19965b, this.f19966c);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("addresses", this.f19964a).add("attributes", this.f19965b).add("loadBalancingPolicyConfig", this.f19966c).toString();
        }

        public g(List list, y8.a aVar, Object obj) {
            this.f19964a = Collections.unmodifiableList(new ArrayList((Collection) Preconditions.checkNotNull(list, "addresses")));
            this.f19965b = (y8.a) Preconditions.checkNotNull(aVar, "attributes");
            this.f19966c = obj;
        }
    }

    public static abstract class h {
        public final x a() {
            List b10 = b();
            Preconditions.checkState(b10.size() == 1, "%s does not have exactly one group", b10);
            return (x) b10.get(0);
        }

        public abstract List b();

        public abstract y8.a c();

        public abstract Object d();

        public abstract void e();

        public abstract void f();

        public abstract void g(j jVar);

        public abstract void h(List list);
    }

    public static abstract class i {
        public abstract e a(f fVar);
    }

    public interface j {
        void a(q qVar);
    }

    public boolean a(g gVar) {
        if (!gVar.a().isEmpty() || b()) {
            int i10 = this.f19952a;
            this.f19952a = i10 + 1;
            if (i10 == 0) {
                d(gVar);
            }
            this.f19952a = 0;
            return true;
        }
        c(k1.f19904u.r("NameResolver returned no usable address. addrs=" + gVar.a() + ", attrs=" + gVar.b()));
        return false;
    }

    public boolean b() {
        return false;
    }

    public abstract void c(k1 k1Var);

    public void d(g gVar) {
        int i10 = this.f19952a;
        this.f19952a = i10 + 1;
        if (i10 == 0) {
            a(gVar);
        }
        this.f19952a = 0;
    }

    public abstract void e();
}
