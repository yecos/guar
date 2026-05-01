package t9;

/* loaded from: classes3.dex */
public abstract class s extends c implements z9.g {
    public s(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, (i10 & 1) == 1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s) {
            s sVar = (s) obj;
            return e().equals(sVar.e()) && getName().equals(sVar.getName()) && g().equals(sVar.g()) && i.b(d(), sVar.d());
        }
        if (obj instanceof z9.g) {
            return obj.equals(b());
        }
        return false;
    }

    public z9.g h() {
        return (z9.g) super.f();
    }

    public int hashCode() {
        return (((e().hashCode() * 31) + getName().hashCode()) * 31) + g().hashCode();
    }

    public String toString() {
        z9.a b10 = b();
        if (b10 != this) {
            return b10.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
