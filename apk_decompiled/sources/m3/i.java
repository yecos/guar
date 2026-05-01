package m3;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class i implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final i f16668d = new i(a.HEURISTIC);

    /* renamed from: e, reason: collision with root package name */
    public static final i f16669e = new i(a.PROPERTIES);

    /* renamed from: f, reason: collision with root package name */
    public static final i f16670f = new i(a.DELEGATING);

    /* renamed from: g, reason: collision with root package name */
    public static final i f16671g = new i(a.REQUIRE_MODE);

    /* renamed from: a, reason: collision with root package name */
    public final a f16672a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f16673b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16674c;

    public enum a {
        DELEGATING,
        PROPERTIES,
        HEURISTIC,
        REQUIRE_MODE
    }

    public i(a aVar, boolean z10, boolean z11) {
        this.f16672a = aVar;
        this.f16673b = z10;
        this.f16674c = z11;
    }

    public boolean a() {
        return this.f16673b;
    }

    public boolean b(Class cls) {
        if (this.f16673b) {
            return false;
        }
        return this.f16674c || !d4.h.M(cls) || Throwable.class.isAssignableFrom(cls);
    }

    public boolean c() {
        return this.f16672a == a.DELEGATING;
    }

    public boolean d() {
        return this.f16672a == a.PROPERTIES;
    }

    public a e() {
        return this.f16672a;
    }

    public i(a aVar) {
        this(aVar, false, false);
    }
}
