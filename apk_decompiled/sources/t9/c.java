package t9;

import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class c implements z9.a, Serializable {

    /* renamed from: g, reason: collision with root package name */
    public static final Object f18940g = a.f18947a;

    /* renamed from: a, reason: collision with root package name */
    public transient z9.a f18941a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f18942b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f18943c;

    /* renamed from: d, reason: collision with root package name */
    public final String f18944d;

    /* renamed from: e, reason: collision with root package name */
    public final String f18945e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f18946f;

    public static class a implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public static final a f18947a = new a();
    }

    public c(Object obj, Class cls, String str, String str2, boolean z10) {
        this.f18942b = obj;
        this.f18943c = cls;
        this.f18944d = str;
        this.f18945e = str2;
        this.f18946f = z10;
    }

    public z9.a b() {
        z9.a aVar = this.f18941a;
        if (aVar != null) {
            return aVar;
        }
        z9.a c10 = c();
        this.f18941a = c10;
        return c10;
    }

    public abstract z9.a c();

    public Object d() {
        return this.f18942b;
    }

    public z9.c e() {
        Class cls = this.f18943c;
        if (cls == null) {
            return null;
        }
        return this.f18946f ? x.b(cls) : x.a(cls);
    }

    public z9.a f() {
        z9.a b10 = b();
        if (b10 != this) {
            return b10;
        }
        throw new r9.b();
    }

    public String g() {
        return this.f18945e;
    }

    @Override // z9.a
    public String getName() {
        return this.f18944d;
    }
}
