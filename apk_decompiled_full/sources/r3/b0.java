package r3;

import b3.r0;

/* loaded from: classes.dex */
public class b0 {

    /* renamed from: f, reason: collision with root package name */
    public static final b0 f18331f = new b0(k3.x.f15007e, Object.class, null, false, null);

    /* renamed from: a, reason: collision with root package name */
    public final k3.x f18332a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f18333b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f18334c;

    /* renamed from: d, reason: collision with root package name */
    public final Class f18335d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f18336e;

    public b0(k3.x xVar, Class cls, Class cls2, Class cls3) {
        this(xVar, cls, cls2, false, cls3);
    }

    public static b0 a() {
        return f18331f;
    }

    public boolean b() {
        return this.f18336e;
    }

    public Class c() {
        return this.f18333b;
    }

    public k3.x d() {
        return this.f18332a;
    }

    public Class e() {
        return this.f18334c;
    }

    public Class f() {
        return this.f18335d;
    }

    public b0 g(boolean z10) {
        return this.f18336e == z10 ? this : new b0(this.f18332a, this.f18335d, this.f18333b, z10, this.f18334c);
    }

    public String toString() {
        return "ObjectIdInfo: propName=" + this.f18332a + ", scope=" + d4.h.X(this.f18335d) + ", generatorType=" + d4.h.X(this.f18333b) + ", alwaysAsId=" + this.f18336e;
    }

    public b0(k3.x xVar, Class cls, Class cls2, boolean z10, Class cls3) {
        this.f18332a = xVar;
        this.f18335d = cls;
        this.f18333b = cls2;
        this.f18336e = z10;
        this.f18334c = cls3 == null ? r0.class : cls3;
    }
}
