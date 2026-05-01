package ca;

/* loaded from: classes3.dex */
public final class x1 extends y {

    /* renamed from: c, reason: collision with root package name */
    public static final x1 f5816c = new x1();

    @Override // ca.y
    public void L(k9.f fVar, Runnable runnable) {
        androidx.appcompat.app.m.a(fVar.a(a2.f5736b));
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // ca.y
    public boolean M(k9.f fVar) {
        return false;
    }

    @Override // ca.y
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
