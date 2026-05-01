package a0;

/* loaded from: classes.dex */
public class d {
    public final Object first;
    public final Object second;

    public d(Object obj, Object obj2) {
        this.first = obj;
        this.second = obj2;
    }

    public static <A, B> d create(A a10, B b10) {
        return new d(a10, b10);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a(dVar.first, this.first) && c.a(dVar.second, this.second);
    }

    public int hashCode() {
        Object obj = this.first;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.second;
        return hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
