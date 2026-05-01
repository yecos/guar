package y8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import y8.k;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: k, reason: collision with root package name */
    public static final c f19794k;

    /* renamed from: a, reason: collision with root package name */
    public final t f19795a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f19796b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19797c;

    /* renamed from: d, reason: collision with root package name */
    public final y8.b f19798d;

    /* renamed from: e, reason: collision with root package name */
    public final String f19799e;

    /* renamed from: f, reason: collision with root package name */
    public final Object[][] f19800f;

    /* renamed from: g, reason: collision with root package name */
    public final List f19801g;

    /* renamed from: h, reason: collision with root package name */
    public final Boolean f19802h;

    /* renamed from: i, reason: collision with root package name */
    public final Integer f19803i;

    /* renamed from: j, reason: collision with root package name */
    public final Integer f19804j;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public t f19805a;

        /* renamed from: b, reason: collision with root package name */
        public Executor f19806b;

        /* renamed from: c, reason: collision with root package name */
        public String f19807c;

        /* renamed from: d, reason: collision with root package name */
        public y8.b f19808d;

        /* renamed from: e, reason: collision with root package name */
        public String f19809e;

        /* renamed from: f, reason: collision with root package name */
        public Object[][] f19810f;

        /* renamed from: g, reason: collision with root package name */
        public List f19811g;

        /* renamed from: h, reason: collision with root package name */
        public Boolean f19812h;

        /* renamed from: i, reason: collision with root package name */
        public Integer f19813i;

        /* renamed from: j, reason: collision with root package name */
        public Integer f19814j;

        public final c b() {
            return new c(this);
        }
    }

    /* renamed from: y8.c$c, reason: collision with other inner class name */
    public static final class C0345c {

        /* renamed from: a, reason: collision with root package name */
        public final String f19815a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f19816b;

        public C0345c(String str, Object obj) {
            this.f19815a = str;
            this.f19816b = obj;
        }

        public static C0345c b(String str) {
            Preconditions.checkNotNull(str, "debugString");
            return new C0345c(str, null);
        }

        public String toString() {
            return this.f19815a;
        }
    }

    static {
        b bVar = new b();
        bVar.f19810f = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        bVar.f19811g = Collections.emptyList();
        f19794k = bVar.b();
    }

    public static b k(c cVar) {
        b bVar = new b();
        bVar.f19805a = cVar.f19795a;
        bVar.f19806b = cVar.f19796b;
        bVar.f19807c = cVar.f19797c;
        bVar.f19808d = cVar.f19798d;
        bVar.f19809e = cVar.f19799e;
        bVar.f19810f = cVar.f19800f;
        bVar.f19811g = cVar.f19801g;
        bVar.f19812h = cVar.f19802h;
        bVar.f19813i = cVar.f19803i;
        bVar.f19814j = cVar.f19804j;
        return bVar;
    }

    public String a() {
        return this.f19797c;
    }

    public String b() {
        return this.f19799e;
    }

    public y8.b c() {
        return this.f19798d;
    }

    public t d() {
        return this.f19795a;
    }

    public Executor e() {
        return this.f19796b;
    }

    public Integer f() {
        return this.f19803i;
    }

    public Integer g() {
        return this.f19804j;
    }

    public Object h(C0345c c0345c) {
        Preconditions.checkNotNull(c0345c, "key");
        int i10 = 0;
        while (true) {
            Object[][] objArr = this.f19800f;
            if (i10 >= objArr.length) {
                return c0345c.f19816b;
            }
            if (c0345c.equals(objArr[i10][0])) {
                return this.f19800f[i10][1];
            }
            i10++;
        }
    }

    public List i() {
        return this.f19801g;
    }

    public boolean j() {
        return Boolean.TRUE.equals(this.f19802h);
    }

    public c l(y8.b bVar) {
        b k10 = k(this);
        k10.f19808d = bVar;
        return k10.b();
    }

    public c m(String str) {
        b k10 = k(this);
        k10.f19809e = str;
        return k10.b();
    }

    public c n(t tVar) {
        b k10 = k(this);
        k10.f19805a = tVar;
        return k10.b();
    }

    public c o(long j10, TimeUnit timeUnit) {
        return n(t.a(j10, timeUnit));
    }

    public c p(Executor executor) {
        b k10 = k(this);
        k10.f19806b = executor;
        return k10.b();
    }

    public c q(int i10) {
        Preconditions.checkArgument(i10 >= 0, "invalid maxsize %s", i10);
        b k10 = k(this);
        k10.f19813i = Integer.valueOf(i10);
        return k10.b();
    }

    public c r(int i10) {
        Preconditions.checkArgument(i10 >= 0, "invalid maxsize %s", i10);
        b k10 = k(this);
        k10.f19814j = Integer.valueOf(i10);
        return k10.b();
    }

    public c s(C0345c c0345c, Object obj) {
        Preconditions.checkNotNull(c0345c, "key");
        Preconditions.checkNotNull(obj, "value");
        b k10 = k(this);
        int i10 = 0;
        while (true) {
            Object[][] objArr = this.f19800f;
            if (i10 >= objArr.length) {
                i10 = -1;
                break;
            }
            if (c0345c.equals(objArr[i10][0])) {
                break;
            }
            i10++;
        }
        Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.f19800f.length + (i10 == -1 ? 1 : 0), 2);
        k10.f19810f = objArr2;
        Object[][] objArr3 = this.f19800f;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (i10 == -1) {
            k10.f19810f[this.f19800f.length] = new Object[]{c0345c, obj};
        } else {
            k10.f19810f[i10] = new Object[]{c0345c, obj};
        }
        return k10.b();
    }

    public c t(k.a aVar) {
        ArrayList arrayList = new ArrayList(this.f19801g.size() + 1);
        arrayList.addAll(this.f19801g);
        arrayList.add(aVar);
        b k10 = k(this);
        k10.f19811g = Collections.unmodifiableList(arrayList);
        return k10.b();
    }

    public String toString() {
        MoreObjects.ToStringHelper add = MoreObjects.toStringHelper(this).add("deadline", this.f19795a).add("authority", this.f19797c).add("callCredentials", this.f19798d);
        Executor executor = this.f19796b;
        return add.add("executor", executor != null ? executor.getClass() : null).add("compressorName", this.f19799e).add("customOptions", Arrays.deepToString(this.f19800f)).add("waitForReady", j()).add("maxInboundMessageSize", this.f19803i).add("maxOutboundMessageSize", this.f19804j).add("streamTracerFactories", this.f19801g).toString();
    }

    public c u() {
        b k10 = k(this);
        k10.f19812h = Boolean.TRUE;
        return k10.b();
    }

    public c v() {
        b k10 = k(this);
        k10.f19812h = Boolean.FALSE;
        return k10.b();
    }

    public c(b bVar) {
        this.f19795a = bVar.f19805a;
        this.f19796b = bVar.f19806b;
        this.f19797c = bVar.f19807c;
        this.f19798d = bVar.f19808d;
        this.f19799e = bVar.f19809e;
        this.f19800f = bVar.f19810f;
        this.f19801g = bVar.f19811g;
        this.f19802h = bVar.f19812h;
        this.f19803i = bVar.f19813i;
        this.f19804j = bVar.f19814j;
    }
}
