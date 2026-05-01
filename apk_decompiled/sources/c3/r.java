package c3;

/* loaded from: classes.dex */
public enum r implements j3.h {
    DUPLICATE_PROPERTIES(false),
    SCALARS_AS_OBJECTS(false),
    UNTYPED_SCALARS(false);


    /* renamed from: a, reason: collision with root package name */
    public final boolean f5512a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5513b = 1 << ordinal();

    r(boolean z10) {
        this.f5512a = z10;
    }

    @Override // j3.h
    public boolean a() {
        return this.f5512a;
    }

    @Override // j3.h
    public int b() {
        return this.f5513b;
    }
}
