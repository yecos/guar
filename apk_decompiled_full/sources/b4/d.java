package b4;

import k3.c0;

/* loaded from: classes.dex */
public abstract class d {

    public static final class a extends a4.c {

        /* renamed from: u, reason: collision with root package name */
        public final a4.c f4587u;

        /* renamed from: v, reason: collision with root package name */
        public final Class[] f4588v;

        public a(a4.c cVar, Class[] clsArr) {
            super(cVar);
            this.f4587u = cVar;
            this.f4588v = clsArr;
        }

        public final boolean F(Class cls) {
            if (cls == null) {
                return true;
            }
            int length = this.f4588v.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (this.f4588v[i10].isAssignableFrom(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // a4.c
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public a w(d4.q qVar) {
            return new a(this.f4587u.w(qVar), this.f4588v);
        }

        @Override // a4.c
        public void k(k3.o oVar) {
            this.f4587u.k(oVar);
        }

        @Override // a4.c
        public void l(k3.o oVar) {
            this.f4587u.l(oVar);
        }

        @Override // a4.c
        public void x(Object obj, c3.h hVar, c0 c0Var) {
            if (F(c0Var.V())) {
                this.f4587u.x(obj, hVar, c0Var);
            } else {
                this.f4587u.A(obj, hVar, c0Var);
            }
        }

        @Override // a4.c
        public void y(Object obj, c3.h hVar, c0 c0Var) {
            if (F(c0Var.V())) {
                this.f4587u.y(obj, hVar, c0Var);
            } else {
                this.f4587u.z(obj, hVar, c0Var);
            }
        }
    }

    public static final class b extends a4.c {

        /* renamed from: u, reason: collision with root package name */
        public final a4.c f4589u;

        /* renamed from: v, reason: collision with root package name */
        public final Class f4590v;

        public b(a4.c cVar, Class cls) {
            super(cVar);
            this.f4589u = cVar;
            this.f4590v = cls;
        }

        @Override // a4.c
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public b w(d4.q qVar) {
            return new b(this.f4589u.w(qVar), this.f4590v);
        }

        @Override // a4.c
        public void k(k3.o oVar) {
            this.f4589u.k(oVar);
        }

        @Override // a4.c
        public void l(k3.o oVar) {
            this.f4589u.l(oVar);
        }

        @Override // a4.c
        public void x(Object obj, c3.h hVar, c0 c0Var) {
            Class<?> V = c0Var.V();
            if (V == null || this.f4590v.isAssignableFrom(V)) {
                this.f4589u.x(obj, hVar, c0Var);
            } else {
                this.f4589u.A(obj, hVar, c0Var);
            }
        }

        @Override // a4.c
        public void y(Object obj, c3.h hVar, c0 c0Var) {
            Class<?> V = c0Var.V();
            if (V == null || this.f4590v.isAssignableFrom(V)) {
                this.f4589u.y(obj, hVar, c0Var);
            } else {
                this.f4589u.z(obj, hVar, c0Var);
            }
        }
    }

    public static a4.c a(a4.c cVar, Class[] clsArr) {
        return clsArr.length == 1 ? new b(cVar, clsArr[0]) : new a(cVar, clsArr);
    }
}
