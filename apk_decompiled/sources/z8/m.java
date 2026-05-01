package z8;

/* loaded from: classes3.dex */
public final class m {

    /* renamed from: f, reason: collision with root package name */
    public static final b f20731f = new a();

    /* renamed from: a, reason: collision with root package name */
    public final j2 f20732a;

    /* renamed from: b, reason: collision with root package name */
    public final d1 f20733b = e1.a();

    /* renamed from: c, reason: collision with root package name */
    public final d1 f20734c = e1.a();

    /* renamed from: d, reason: collision with root package name */
    public final d1 f20735d = e1.a();

    /* renamed from: e, reason: collision with root package name */
    public volatile long f20736e;

    public class a implements b {
        @Override // z8.m.b
        public m create() {
            return new m(j2.f20666a);
        }
    }

    public interface b {
        m create();
    }

    public m(j2 j2Var) {
        this.f20732a = j2Var;
    }

    public void a(boolean z10) {
        if (z10) {
            this.f20734c.add(1L);
        } else {
            this.f20735d.add(1L);
        }
    }

    public void b() {
        this.f20733b.add(1L);
        this.f20736e = this.f20732a.a();
    }
}
