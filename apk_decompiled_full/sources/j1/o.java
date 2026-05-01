package j1;

/* loaded from: classes.dex */
public final class o implements n {

    /* renamed from: a, reason: collision with root package name */
    public final q0.e f14574a;

    /* renamed from: b, reason: collision with root package name */
    public final q0.b f14575b;

    /* renamed from: c, reason: collision with root package name */
    public final q0.k f14576c;

    /* renamed from: d, reason: collision with root package name */
    public final q0.k f14577d;

    public class a extends q0.b {
        public a(q0.e eVar) {
            super(eVar);
        }

        @Override // q0.k
        public String d() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }

        @Override // q0.b
        public /* bridge */ /* synthetic */ void g(t0.f fVar, Object obj) {
            androidx.appcompat.app.m.a(obj);
            i(fVar, null);
        }

        public void i(t0.f fVar, m mVar) {
            throw null;
        }
    }

    public class b extends q0.k {
        public b(q0.e eVar) {
            super(eVar);
        }

        @Override // q0.k
        public String d() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    public class c extends q0.k {
        public c(q0.e eVar) {
            super(eVar);
        }

        @Override // q0.k
        public String d() {
            return "DELETE FROM WorkProgress";
        }
    }

    public o(q0.e eVar) {
        this.f14574a = eVar;
        this.f14575b = new a(eVar);
        this.f14576c = new b(eVar);
        this.f14577d = new c(eVar);
    }

    @Override // j1.n
    public void a(String str) {
        this.f14574a.b();
        t0.f a10 = this.f14576c.a();
        if (str == null) {
            a10.bindNull(1);
        } else {
            a10.bindString(1, str);
        }
        this.f14574a.c();
        try {
            a10.executeUpdateDelete();
            this.f14574a.r();
        } finally {
            this.f14574a.g();
            this.f14576c.f(a10);
        }
    }

    @Override // j1.n
    public void b() {
        this.f14574a.b();
        t0.f a10 = this.f14577d.a();
        this.f14574a.c();
        try {
            a10.executeUpdateDelete();
            this.f14574a.r();
        } finally {
            this.f14574a.g();
            this.f14577d.f(a10);
        }
    }
}
