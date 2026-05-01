package t9;

/* loaded from: classes3.dex */
public final class n implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Class f18956a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18957b;

    public n(Class cls, String str) {
        i.g(cls, "jClass");
        i.g(str, "moduleName");
        this.f18956a = cls;
        this.f18957b = str;
    }

    @Override // t9.d
    public Class a() {
        return this.f18956a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof n) && i.b(a(), ((n) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
