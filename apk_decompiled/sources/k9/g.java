package k9;

import java.io.Serializable;
import k9.f;
import s9.p;
import t9.i;

/* loaded from: classes3.dex */
public final class g implements f, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final g f15708a = new g();

    @Override // k9.f
    public f E(f.c cVar) {
        i.g(cVar, "key");
        return this;
    }

    @Override // k9.f
    public f.b a(f.c cVar) {
        i.g(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // k9.f
    public Object m(Object obj, p pVar) {
        i.g(pVar, "operation");
        return obj;
    }

    @Override // k9.f
    public f s(f fVar) {
        i.g(fVar, com.umeng.analytics.pro.f.X);
        return fVar;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
