package z8;

import com.google.common.base.Preconditions;
import com.taobao.accs.common.Constants;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import y8.y0;
import z8.e0;

/* loaded from: classes3.dex */
public final class g1 extends y8.s0 {
    public static final Logger H = Logger.getLogger(g1.class.getName());
    public static final long I = TimeUnit.MINUTES.toMillis(30);
    public static final long J = TimeUnit.SECONDS.toMillis(1);
    public static final o1 K = e2.c(q0.f20853u);
    public static final y8.v L = y8.v.c();
    public static final y8.o M = y8.o.a();
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public final c F;
    public final b G;

    /* renamed from: a, reason: collision with root package name */
    public o1 f20599a;

    /* renamed from: b, reason: collision with root package name */
    public o1 f20600b;

    /* renamed from: c, reason: collision with root package name */
    public final List f20601c;

    /* renamed from: d, reason: collision with root package name */
    public final y8.a1 f20602d;

    /* renamed from: e, reason: collision with root package name */
    public y0.c f20603e;

    /* renamed from: f, reason: collision with root package name */
    public final String f20604f;

    /* renamed from: g, reason: collision with root package name */
    public final y8.b f20605g;

    /* renamed from: h, reason: collision with root package name */
    public final SocketAddress f20606h;

    /* renamed from: i, reason: collision with root package name */
    public String f20607i;

    /* renamed from: j, reason: collision with root package name */
    public String f20608j;

    /* renamed from: k, reason: collision with root package name */
    public String f20609k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20610l;

    /* renamed from: m, reason: collision with root package name */
    public y8.v f20611m;

    /* renamed from: n, reason: collision with root package name */
    public y8.o f20612n;

    /* renamed from: o, reason: collision with root package name */
    public long f20613o;

    /* renamed from: p, reason: collision with root package name */
    public int f20614p;

    /* renamed from: q, reason: collision with root package name */
    public int f20615q;

    /* renamed from: r, reason: collision with root package name */
    public long f20616r;

    /* renamed from: s, reason: collision with root package name */
    public long f20617s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f20618t;

    /* renamed from: u, reason: collision with root package name */
    public y8.c0 f20619u;

    /* renamed from: v, reason: collision with root package name */
    public int f20620v;

    /* renamed from: w, reason: collision with root package name */
    public Map f20621w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f20622x;

    /* renamed from: y, reason: collision with root package name */
    public y8.d1 f20623y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f20624z;

    public interface b {
        int a();
    }

    public interface c {
        t a();
    }

    public static final class d implements b {
        public d() {
        }

        @Override // z8.g1.b
        public int a() {
            return Constants.PORT;
        }
    }

    public g1(String str, c cVar, b bVar) {
        this(str, null, null, cVar, bVar);
    }

    @Override // y8.s0
    public y8.r0 a() {
        return new h1(new f1(this, this.F.a(), new e0.a(), e2.c(q0.f20853u), q0.f20855w, d(), j2.f20666a));
    }

    public int c() {
        return this.G.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List d() {
        /*
            Method dump skipped, instructions count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.g1.d():java.util.List");
    }

    public g1(String str, y8.e eVar, y8.b bVar, c cVar, b bVar2) {
        o1 o1Var = K;
        this.f20599a = o1Var;
        this.f20600b = o1Var;
        this.f20601c = new ArrayList();
        y8.a1 d10 = y8.a1.d();
        this.f20602d = d10;
        this.f20603e = d10.c();
        this.f20609k = "pick_first";
        this.f20611m = L;
        this.f20612n = M;
        this.f20613o = I;
        this.f20614p = 5;
        this.f20615q = 5;
        this.f20616r = 16777216L;
        this.f20617s = 1048576L;
        this.f20618t = true;
        this.f20619u = y8.c0.g();
        this.f20622x = true;
        this.f20624z = true;
        this.A = true;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.f20604f = (String) Preconditions.checkNotNull(str, "target");
        this.f20605g = bVar;
        this.F = (c) Preconditions.checkNotNull(cVar, "clientTransportFactoryBuilder");
        this.f20606h = null;
        if (bVar2 != null) {
            this.G = bVar2;
        } else {
            this.G = new d();
        }
    }
}
