package r3;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public interface f0 {

    public static class a implements f0 {

        /* renamed from: a, reason: collision with root package name */
        public final c4.o f18421a;

        /* renamed from: b, reason: collision with root package name */
        public final c4.n f18422b;

        public a(c4.o oVar, c4.n nVar) {
            this.f18421a = oVar;
            this.f18422b = nVar;
        }

        @Override // r3.f0
        public k3.j a(Type type) {
            return this.f18421a.M(type, this.f18422b);
        }
    }

    k3.j a(Type type);
}
