package j1;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f14562a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14563b;

    public g(String str, int i10) {
        this.f14562a = str;
        this.f14563b = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f14563b != gVar.f14563b) {
            return false;
        }
        return this.f14562a.equals(gVar.f14562a);
    }

    public int hashCode() {
        return (this.f14562a.hashCode() * 31) + this.f14563b;
    }
}
