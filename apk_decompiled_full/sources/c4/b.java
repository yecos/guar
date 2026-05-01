package c4;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class b implements Comparable, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public String f5528a;

    /* renamed from: b, reason: collision with root package name */
    public Class f5529b;

    /* renamed from: c, reason: collision with root package name */
    public int f5530c;

    public b(Class cls) {
        this.f5529b = cls;
        String name = cls.getName();
        this.f5528a = name;
        this.f5530c = name.hashCode();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        return this.f5528a.compareTo(bVar.f5528a);
    }

    public void b(Class cls) {
        this.f5529b = cls;
        String name = cls.getName();
        this.f5528a = name;
        this.f5530c = name.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass() == b.class && ((b) obj).f5529b == this.f5529b;
    }

    public int hashCode() {
        return this.f5530c;
    }

    public String toString() {
        return this.f5528a;
    }
}
