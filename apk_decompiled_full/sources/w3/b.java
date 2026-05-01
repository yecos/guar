package w3;

import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes.dex */
public final class b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Class f19150a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19151b;

    /* renamed from: c, reason: collision with root package name */
    public String f19152c;

    public b(Class cls) {
        this(cls, null);
    }

    public String a() {
        return this.f19152c;
    }

    public Class b() {
        return this.f19150a;
    }

    public boolean c() {
        return this.f19152c != null;
    }

    public void d(String str) {
        if (str == null || str.isEmpty()) {
            str = null;
        }
        this.f19152c = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != b.class) {
            return false;
        }
        b bVar = (b) obj;
        return this.f19150a == bVar.f19150a && Objects.equals(this.f19152c, bVar.f19152c);
    }

    public int hashCode() {
        return this.f19151b;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[NamedType, class ");
        sb.append(this.f19150a.getName());
        sb.append(", name: ");
        if (this.f19152c == null) {
            str = "null";
        } else {
            str = "'" + this.f19152c + "'";
        }
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }

    public b(Class cls, String str) {
        this.f19150a = cls;
        this.f19151b = cls.getName().hashCode() + (str == null ? 0 : str.hashCode());
        d(str);
    }
}
