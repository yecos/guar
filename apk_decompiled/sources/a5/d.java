package a5;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f226a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f227b;

    public d(Object obj, Object obj2) {
        this.f226a = obj;
        this.f227b = obj2;
    }

    public static d b(Object obj, Object obj2) {
        return new d(obj, obj2);
    }

    public Object a() {
        return this.f226a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        Object obj2 = this.f226a;
        if (obj2 == null) {
            if (dVar.f226a != null) {
                return false;
            }
        } else if (!obj2.equals(dVar.f226a)) {
            return false;
        }
        Object obj3 = this.f227b;
        if (obj3 == null) {
            if (dVar.f227b != null) {
                return false;
            }
        } else if (!obj3.equals(dVar.f227b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.f226a;
        int hashCode = ((obj == null ? 0 : obj.hashCode()) + 31) * 31;
        Object obj2 = this.f227b;
        return hashCode + (obj2 != null ? obj2.hashCode() : 0);
    }
}
