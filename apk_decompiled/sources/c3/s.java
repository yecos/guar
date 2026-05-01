package c3;

/* loaded from: classes.dex */
public enum s implements j3.h {
    CAN_WRITE_BINARY_NATIVELY(false),
    CAN_WRITE_FORMATTED_NUMBERS(false);


    /* renamed from: a, reason: collision with root package name */
    public final boolean f5517a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5518b = 1 << ordinal();

    s(boolean z10) {
        this.f5517a = z10;
    }

    @Override // j3.h
    public boolean a() {
        return this.f5517a;
    }

    @Override // j3.h
    public int b() {
        return this.f5518b;
    }
}
