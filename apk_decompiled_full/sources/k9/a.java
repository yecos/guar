package k9;

import k9.f;
import s9.p;
import t9.i;

/* loaded from: classes3.dex */
public abstract class a implements f.b {

    /* renamed from: a, reason: collision with root package name */
    public final f.c f15699a;

    public a(f.c cVar) {
        i.g(cVar, "key");
        this.f15699a = cVar;
    }

    @Override // k9.f
    public f E(f.c cVar) {
        return f.b.a.c(this, cVar);
    }

    @Override // k9.f.b, k9.f
    public f.b a(f.c cVar) {
        return f.b.a.b(this, cVar);
    }

    @Override // k9.f.b
    public f.c getKey() {
        return this.f15699a;
    }

    @Override // k9.f
    public Object m(Object obj, p pVar) {
        return f.b.a.a(this, obj, pVar);
    }

    @Override // k9.f
    public f s(f fVar) {
        return f.b.a.d(this, fVar);
    }
}
