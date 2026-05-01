package f1;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f13014a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13015b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13016c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13017d;

    public b(boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f13014a = z10;
        this.f13015b = z11;
        this.f13016c = z12;
        this.f13017d = z13;
    }

    public boolean a() {
        return this.f13014a;
    }

    public boolean b() {
        return this.f13016c;
    }

    public boolean c() {
        return this.f13017d;
    }

    public boolean d() {
        return this.f13015b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f13014a == bVar.f13014a && this.f13015b == bVar.f13015b && this.f13016c == bVar.f13016c && this.f13017d == bVar.f13017d;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public int hashCode() {
        ?? r02 = this.f13014a;
        int i10 = r02;
        if (this.f13015b) {
            i10 = r02 + 16;
        }
        int i11 = i10;
        if (this.f13016c) {
            i11 = i10 + 256;
        }
        return this.f13017d ? i11 + 4096 : i11;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", Boolean.valueOf(this.f13014a), Boolean.valueOf(this.f13015b), Boolean.valueOf(this.f13016c), Boolean.valueOf(this.f13017d));
    }
}
