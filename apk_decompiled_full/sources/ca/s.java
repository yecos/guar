package ca;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes3.dex */
public class s {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5801b = AtomicIntegerFieldUpdater.newUpdater(s.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f5802a;

    public s(Throwable th, boolean z10) {
        this.f5802a = th;
        this._handled = z10 ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return f5801b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return g0.a(this) + '[' + this.f5802a + ']';
    }

    public /* synthetic */ s(Throwable th, boolean z10, int i10, t9.g gVar) {
        this(th, (i10 & 2) != 0 ? false : z10);
    }
}
