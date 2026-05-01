package j3;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public int f14660a;

    public i(int i10) {
        this.f14660a = i10;
    }

    public static i a(h[] hVarArr) {
        if (hVarArr.length > 31) {
            throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", hVarArr[0].getClass().getName(), Integer.valueOf(hVarArr.length)));
        }
        int i10 = 0;
        for (h hVar : hVarArr) {
            if (hVar.a()) {
                i10 |= hVar.b();
            }
        }
        return new i(i10);
    }

    public boolean b(h hVar) {
        return (hVar.b() & this.f14660a) != 0;
    }

    public i c(h hVar) {
        int b10 = hVar.b() | this.f14660a;
        return b10 == this.f14660a ? this : new i(b10);
    }
}
