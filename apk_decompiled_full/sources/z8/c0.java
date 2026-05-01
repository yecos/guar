package z8;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Throwables;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import com.hpplay.cybergarage.soap.SOAP;
import com.uc.crashsdk.export.LogType;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.y0;
import z8.d2;

/* loaded from: classes3.dex */
public class c0 extends y8.y0 {
    public static String A;

    /* renamed from: s, reason: collision with root package name */
    public static final Logger f20371s = Logger.getLogger(c0.class.getName());

    /* renamed from: t, reason: collision with root package name */
    public static final Set f20372t = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));

    /* renamed from: u, reason: collision with root package name */
    public static final String f20373u;

    /* renamed from: v, reason: collision with root package name */
    public static final String f20374v;

    /* renamed from: w, reason: collision with root package name */
    public static final String f20375w;

    /* renamed from: x, reason: collision with root package name */
    public static boolean f20376x;

    /* renamed from: y, reason: collision with root package name */
    public static boolean f20377y;

    /* renamed from: z, reason: collision with root package name */
    public static boolean f20378z;

    /* renamed from: a, reason: collision with root package name */
    public final y8.d1 f20379a;

    /* renamed from: b, reason: collision with root package name */
    public final Random f20380b = new Random();

    /* renamed from: c, reason: collision with root package name */
    public volatile b f20381c = d.INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f20382d = new AtomicReference();

    /* renamed from: e, reason: collision with root package name */
    public final String f20383e;

    /* renamed from: f, reason: collision with root package name */
    public final String f20384f;

    /* renamed from: g, reason: collision with root package name */
    public final int f20385g;

    /* renamed from: h, reason: collision with root package name */
    public final d2.d f20386h;

    /* renamed from: i, reason: collision with root package name */
    public final long f20387i;

    /* renamed from: j, reason: collision with root package name */
    public final y8.o1 f20388j;

    /* renamed from: k, reason: collision with root package name */
    public final Stopwatch f20389k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20390l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20391m;

    /* renamed from: n, reason: collision with root package name */
    public Executor f20392n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f20393o;

    /* renamed from: p, reason: collision with root package name */
    public final y0.f f20394p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f20395q;

    /* renamed from: r, reason: collision with root package name */
    public y0.d f20396r;

    public interface b {
        List a(String str);
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public y8.k1 f20397a;

        /* renamed from: b, reason: collision with root package name */
        public List f20398b;

        /* renamed from: c, reason: collision with root package name */
        public y0.b f20399c;

        /* renamed from: d, reason: collision with root package name */
        public y8.a f20400d;

        public c() {
        }
    }

    public enum d implements b {
        INSTANCE;

        @Override // z8.c0.b
        public List a(String str) {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
        }
    }

    public final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final y0.d f20403a;

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f20405a;

            public a(boolean z10) {
                this.f20405a = z10;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f20405a) {
                    c0 c0Var = c0.this;
                    c0Var.f20390l = true;
                    if (c0Var.f20387i > 0) {
                        c0.this.f20389k.reset().start();
                    }
                }
                c0.this.f20395q = false;
            }
        }

        public e(y0.d dVar) {
            this.f20403a = (y0.d) Preconditions.checkNotNull(dVar, "savedListener");
        }

        @Override // java.lang.Runnable
        public void run() {
            y8.o1 o1Var;
            a aVar;
            Logger logger = c0.f20371s;
            Level level = Level.FINER;
            if (logger.isLoggable(level)) {
                c0.f20371s.finer("Attempting DNS resolution of " + c0.this.f20384f);
            }
            c cVar = null;
            try {
                try {
                    y8.x m10 = c0.this.m();
                    y0.e.a d10 = y0.e.d();
                    if (m10 != null) {
                        if (c0.f20371s.isLoggable(level)) {
                            c0.f20371s.finer("Using proxy address " + m10);
                        }
                        d10.b(Collections.singletonList(m10));
                    } else {
                        cVar = c0.this.n(false);
                        if (cVar.f20397a != null) {
                            this.f20403a.a(cVar.f20397a);
                            return;
                        }
                        if (cVar.f20398b != null) {
                            d10.b(cVar.f20398b);
                        }
                        if (cVar.f20399c != null) {
                            d10.d(cVar.f20399c);
                        }
                        y8.a aVar2 = cVar.f20400d;
                        if (aVar2 != null) {
                            d10.c(aVar2);
                        }
                    }
                    this.f20403a.b(d10.a());
                    r0 = cVar != null && cVar.f20397a == null;
                    o1Var = c0.this.f20388j;
                    aVar = new a(r0);
                } catch (IOException e10) {
                    this.f20403a.a(y8.k1.f19904u.r("Unable to resolve host " + c0.this.f20384f).q(e10));
                    r0 = 0 != 0 && null.f20397a == null;
                    o1Var = c0.this.f20388j;
                    aVar = new a(r0);
                }
                o1Var.execute(aVar);
            } finally {
                c0.this.f20388j.execute(new a(0 != 0 && null.f20397a == null));
            }
        }
    }

    public interface f {
    }

    public interface g {
    }

    static {
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        f20373u = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        f20374v = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        f20375w = property3;
        f20376x = Boolean.parseBoolean(property);
        f20377y = Boolean.parseBoolean(property2);
        f20378z = Boolean.parseBoolean(property3);
        u(c0.class.getClassLoader());
    }

    public c0(String str, String str2, y0.a aVar, d2.d dVar, Stopwatch stopwatch, boolean z10) {
        Preconditions.checkNotNull(aVar, "args");
        this.f20386h = dVar;
        URI create = URI.create("//" + ((String) Preconditions.checkNotNull(str2, "name")));
        Preconditions.checkArgument(create.getHost() != null, "Invalid DNS name: %s", str2);
        this.f20383e = (String) Preconditions.checkNotNull(create.getAuthority(), "nameUri (%s) doesn't have an authority", create);
        this.f20384f = create.getHost();
        if (create.getPort() == -1) {
            this.f20385g = aVar.a();
        } else {
            this.f20385g = create.getPort();
        }
        this.f20379a = (y8.d1) Preconditions.checkNotNull(aVar.c(), "proxyDetector");
        this.f20387i = r(z10);
        this.f20389k = (Stopwatch) Preconditions.checkNotNull(stopwatch, "stopwatch");
        this.f20388j = (y8.o1) Preconditions.checkNotNull(aVar.e(), "syncContext");
        Executor b10 = aVar.b();
        this.f20392n = b10;
        this.f20393o = b10 == null;
        this.f20394p = (y0.f) Preconditions.checkNotNull(aVar.d(), "serviceConfigParser");
    }

    public static boolean B(boolean z10, boolean z11, String str) {
        if (!z10) {
            return false;
        }
        if ("localhost".equalsIgnoreCase(str)) {
            return z11;
        }
        if (str.contains(SOAP.DELIM)) {
            return false;
        }
        boolean z12 = true;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt != '.') {
                z12 &= charAt >= '0' && charAt <= '9';
            }
        }
        return true ^ z12;
    }

    public static final List o(Map map) {
        return a1.g(map, "clientLanguage");
    }

    public static final List p(Map map) {
        return a1.g(map, "clientHostname");
    }

    public static String q() {
        if (A == null) {
            try {
                A = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e10) {
                throw new RuntimeException(e10);
            }
        }
        return A;
    }

    public static long r(boolean z10) {
        if (z10) {
            return 0L;
        }
        String property = System.getProperty("networkaddress.cache.ttl");
        long j10 = 30;
        if (property != null) {
            try {
                j10 = Long.parseLong(property);
            } catch (NumberFormatException unused) {
                f20371s.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, 30L});
            }
        }
        return j10 > 0 ? TimeUnit.SECONDS.toNanos(j10) : j10;
    }

    public static final Double s(Map map) {
        return a1.h(map, "percentage");
    }

    public static g u(ClassLoader classLoader) {
        try {
            try {
                try {
                    androidx.appcompat.app.m.a(Class.forName("z8.y0", true, classLoader).asSubclass(g.class).getConstructor(new Class[0]).newInstance(new Object[0]));
                    throw null;
                } catch (Exception e10) {
                    f20371s.log(Level.FINE, "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e10);
                    return null;
                }
            } catch (Exception e11) {
                f20371s.log(Level.FINE, "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e11);
                return null;
            }
        } catch (ClassCastException e12) {
            f20371s.log(Level.FINE, "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e12);
            return null;
        } catch (ClassNotFoundException e13) {
            f20371s.log(Level.FINE, "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e13);
            return null;
        }
    }

    public static Map v(Map map, Random random, String str) {
        boolean z10;
        boolean z11;
        for (Map.Entry entry : map.entrySet()) {
            Verify.verify(f20372t.contains(entry.getKey()), "Bad key: %s", entry);
        }
        List o10 = o(map);
        if (o10 != null && !o10.isEmpty()) {
            Iterator it = o10.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z11 = false;
                    break;
                }
                if (LogType.JAVA_TYPE.equalsIgnoreCase((String) it.next())) {
                    z11 = true;
                    break;
                }
            }
            if (!z11) {
                return null;
            }
        }
        Double s10 = s(map);
        if (s10 != null) {
            int intValue = s10.intValue();
            Verify.verify(intValue >= 0 && intValue <= 100, "Bad percentage: %s", s10);
            if (random.nextInt(100) >= intValue) {
                return null;
            }
        }
        List p10 = p(map);
        if (p10 != null && !p10.isEmpty()) {
            Iterator it2 = p10.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z10 = false;
                    break;
                }
                if (((String) it2.next()).equals(str)) {
                    z10 = true;
                    break;
                }
            }
            if (!z10) {
                return null;
            }
        }
        Map j10 = a1.j(map, "serviceConfig");
        if (j10 != null) {
            return j10;
        }
        throw new VerifyException(String.format("key '%s' missing in '%s'", map, "serviceConfig"));
    }

    public static y0.b w(List list, Random random, String str) {
        try {
            Iterator it = x(list).iterator();
            Map map = null;
            while (it.hasNext()) {
                try {
                    map = v((Map) it.next(), random, str);
                    if (map != null) {
                        break;
                    }
                } catch (RuntimeException e10) {
                    return y0.b.b(y8.k1.f19891h.r("failed to pick service config choice").q(e10));
                }
            }
            if (map == null) {
                return null;
            }
            return y0.b.a(map);
        } catch (IOException | RuntimeException e11) {
            return y0.b.b(y8.k1.f19891h.r("failed to parse TXT records").q(e11));
        }
    }

    public static List x(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.startsWith("grpc_config=")) {
                Object a10 = z0.a(str.substring(12));
                if (!(a10 instanceof List)) {
                    throw new ClassCastException("wrong type " + a10);
                }
                arrayList.addAll(a1.a((List) a10));
            } else {
                f20371s.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            }
        }
        return arrayList;
    }

    public final y0.b A() {
        List emptyList = Collections.emptyList();
        t();
        if (emptyList.isEmpty()) {
            f20371s.log(Level.FINE, "No TXT records found for {0}", new Object[]{this.f20384f});
            return null;
        }
        y0.b w10 = w(emptyList, this.f20380b, q());
        if (w10 != null) {
            return w10.d() != null ? y0.b.b(w10.d()) : this.f20394p.a((Map) w10.c());
        }
        return null;
    }

    @Override // y8.y0
    public String a() {
        return this.f20383e;
    }

    @Override // y8.y0
    public void b() {
        Preconditions.checkState(this.f20396r != null, "not started");
        y();
    }

    @Override // y8.y0
    public void c() {
        if (this.f20391m) {
            return;
        }
        this.f20391m = true;
        Executor executor = this.f20392n;
        if (executor == null || !this.f20393o) {
            return;
        }
        this.f20392n = (Executor) d2.f(this.f20386h, executor);
    }

    @Override // y8.y0
    public void d(y0.d dVar) {
        Preconditions.checkState(this.f20396r == null, "already started");
        if (this.f20393o) {
            this.f20392n = (Executor) d2.d(this.f20386h);
        }
        this.f20396r = (y0.d) Preconditions.checkNotNull(dVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        y();
    }

    public final boolean l() {
        if (this.f20390l) {
            long j10 = this.f20387i;
            if (j10 != 0 && (j10 <= 0 || this.f20389k.elapsed(TimeUnit.NANOSECONDS) <= this.f20387i)) {
                return false;
            }
        }
        return true;
    }

    public final y8.x m() {
        y8.c1 a10 = this.f20379a.a(InetSocketAddress.createUnresolved(this.f20384f, this.f20385g));
        if (a10 != null) {
            return new y8.x(a10);
        }
        return null;
    }

    public c n(boolean z10) {
        c cVar = new c();
        try {
            cVar.f20398b = z();
        } catch (Exception e10) {
            if (!z10) {
                cVar.f20397a = y8.k1.f19904u.r("Unable to resolve host " + this.f20384f).q(e10);
                return cVar;
            }
        }
        if (f20378z) {
            cVar.f20399c = A();
        }
        return cVar;
    }

    public f t() {
        if (!B(f20376x, f20377y, this.f20384f)) {
            return null;
        }
        androidx.appcompat.app.m.a(this.f20382d.get());
        return null;
    }

    public final void y() {
        if (this.f20395q || this.f20391m || !l()) {
            return;
        }
        this.f20395q = true;
        this.f20392n.execute(new e(this.f20396r));
    }

    public final List z() {
        Exception e10 = null;
        try {
            try {
                List a10 = this.f20381c.a(this.f20384f);
                ArrayList arrayList = new ArrayList(a10.size());
                Iterator it = a10.iterator();
                while (it.hasNext()) {
                    arrayList.add(new y8.x(new InetSocketAddress((InetAddress) it.next(), this.f20385g)));
                }
                return Collections.unmodifiableList(arrayList);
            } catch (Exception e11) {
                e10 = e11;
                Throwables.throwIfUnchecked(e10);
                throw new RuntimeException(e10);
            }
        } catch (Throwable th) {
            if (e10 != null) {
                f20371s.log(Level.FINE, "Address resolution failure", (Throwable) e10);
            }
            throw th;
        }
    }
}
