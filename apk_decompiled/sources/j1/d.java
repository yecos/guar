package j1;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f14557a;

    /* renamed from: b, reason: collision with root package name */
    public Long f14558b;

    public d(String str, boolean z10) {
        this(str, z10 ? 1L : 0L);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f14557a.equals(dVar.f14557a)) {
            return false;
        }
        Long l10 = this.f14558b;
        Long l11 = dVar.f14558b;
        return l10 != null ? l10.equals(l11) : l11 == null;
    }

    public int hashCode() {
        int hashCode = this.f14557a.hashCode() * 31;
        Long l10 = this.f14558b;
        return hashCode + (l10 != null ? l10.hashCode() : 0);
    }

    public d(String str, long j10) {
        this.f14557a = str;
        this.f14558b = Long.valueOf(j10);
    }
}
