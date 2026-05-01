package o7;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f17620a;

    /* renamed from: b, reason: collision with root package name */
    public final int f17621b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17622c;

    /* renamed from: d, reason: collision with root package name */
    public final long f17623d;

    /* renamed from: e, reason: collision with root package name */
    public final a f17624e;

    public enum a {
        Unknown,
        DnspodFree,
        DnspodEnterprise,
        System
    }

    public f(String str, int i10, int i11, long j10, a aVar) {
        this.f17620a = str;
        this.f17621b = i10;
        this.f17622c = i11 < 600 ? 600 : i11;
        this.f17623d = j10;
        this.f17624e = aVar;
    }

    public boolean a() {
        return b(System.currentTimeMillis() / 1000);
    }

    public boolean b(long j10) {
        return this.f17623d + ((long) this.f17622c) < j10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f17620a.equals(fVar.f17620a) && this.f17621b == fVar.f17621b && this.f17622c == fVar.f17622c && this.f17623d == fVar.f17623d;
    }
}
