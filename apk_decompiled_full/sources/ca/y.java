package ca;

import k9.d;
import k9.f;
import kotlin.coroutines.Continuation;

/* loaded from: classes3.dex */
public abstract class y extends k9.a implements k9.d {

    /* renamed from: b, reason: collision with root package name */
    public static final a f5817b = new a(null);

    public static final class a extends k9.b {

        /* renamed from: ca.y$a$a, reason: collision with other inner class name */
        public static final class C0085a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final C0085a f5818a = new C0085a();

            public C0085a() {
                super(1);
            }

            @Override // s9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final y invoke(f.b bVar) {
                if (bVar instanceof y) {
                    return (y) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public a() {
            super(k9.d.f15705e0, C0085a.f5818a);
        }
    }

    public y() {
        super(k9.d.f15705e0);
    }

    @Override // k9.a, k9.f
    public k9.f E(f.c cVar) {
        return d.a.b(this, cVar);
    }

    public abstract void L(k9.f fVar, Runnable runnable);

    public boolean M(k9.f fVar) {
        return true;
    }

    public y N(int i10) {
        kotlinx.coroutines.internal.k.a(i10);
        return new kotlinx.coroutines.internal.j(this, i10);
    }

    @Override // k9.a, k9.f.b, k9.f
    public f.b a(f.c cVar) {
        return d.a.a(this, cVar);
    }

    @Override // k9.d
    public final void b(Continuation continuation) {
        ((kotlinx.coroutines.internal.f) continuation).l();
    }

    @Override // k9.d
    public final Continuation c(Continuation continuation) {
        return new kotlinx.coroutines.internal.f(this, continuation);
    }

    public String toString() {
        return g0.a(this) + '@' + g0.b(this);
    }
}
