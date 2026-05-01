package ta;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public Object f18968a;

    /* renamed from: b, reason: collision with root package name */
    public Class f18969b;

    /* renamed from: c, reason: collision with root package name */
    public Class f18970c;

    /* renamed from: d, reason: collision with root package name */
    public ra.a f18971d;

    /* renamed from: e, reason: collision with root package name */
    public Object f18972e;

    /* renamed from: f, reason: collision with root package name */
    public Object f18973f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f18974g = false;

    public e(Object obj, Class cls, Class cls2, ra.a aVar) {
        this.f18968a = obj;
        this.f18969b = cls;
        this.f18970c = cls2;
        this.f18971d = aVar;
    }

    public Object a() {
        if (this.f18973f == null && !this.f18974g) {
            this.f18971d.q(null, this.f18968a, this.f18969b, this.f18970c);
            this.f18974g = true;
        }
        return this.f18973f;
    }

    public Object b() {
        return this.f18972e;
    }

    public void c(Object obj) {
        this.f18973f = obj;
    }

    public void d(Object obj) {
        this.f18972e = obj;
    }
}
