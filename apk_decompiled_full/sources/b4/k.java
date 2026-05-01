package b4;

import java.util.Arrays;
import k3.c0;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4611a;

    public static final class a extends k {

        /* renamed from: b, reason: collision with root package name */
        public final Class f4612b;

        /* renamed from: c, reason: collision with root package name */
        public final Class f4613c;

        /* renamed from: d, reason: collision with root package name */
        public final k3.o f4614d;

        /* renamed from: e, reason: collision with root package name */
        public final k3.o f4615e;

        public a(k kVar, Class cls, k3.o oVar, Class cls2, k3.o oVar2) {
            super(kVar);
            this.f4612b = cls;
            this.f4614d = oVar;
            this.f4613c = cls2;
            this.f4615e = oVar2;
        }

        @Override // b4.k
        public k i(Class cls, k3.o oVar) {
            return new c(this, new f[]{new f(this.f4612b, this.f4614d), new f(this.f4613c, this.f4615e), new f(cls, oVar)});
        }

        @Override // b4.k
        public k3.o j(Class cls) {
            if (cls == this.f4612b) {
                return this.f4614d;
            }
            if (cls == this.f4613c) {
                return this.f4615e;
            }
            return null;
        }
    }

    public static final class b extends k {

        /* renamed from: b, reason: collision with root package name */
        public static final b f4616b = new b(false);

        /* renamed from: c, reason: collision with root package name */
        public static final b f4617c = new b(true);

        public b(boolean z10) {
            super(z10);
        }

        @Override // b4.k
        public k i(Class cls, k3.o oVar) {
            return new e(this, cls, oVar);
        }

        @Override // b4.k
        public k3.o j(Class cls) {
            return null;
        }
    }

    public static final class c extends k {

        /* renamed from: b, reason: collision with root package name */
        public final f[] f4618b;

        public c(k kVar, f[] fVarArr) {
            super(kVar);
            this.f4618b = fVarArr;
        }

        @Override // b4.k
        public k i(Class cls, k3.o oVar) {
            f[] fVarArr = this.f4618b;
            int length = fVarArr.length;
            if (length == 8) {
                return this.f4611a ? new e(this, cls, oVar) : this;
            }
            f[] fVarArr2 = (f[]) Arrays.copyOf(fVarArr, length + 1);
            fVarArr2[length] = new f(cls, oVar);
            return new c(this, fVarArr2);
        }

        @Override // b4.k
        public k3.o j(Class cls) {
            f[] fVarArr = this.f4618b;
            f fVar = fVarArr[0];
            if (fVar.f4623a == cls) {
                return fVar.f4624b;
            }
            f fVar2 = fVarArr[1];
            if (fVar2.f4623a == cls) {
                return fVar2.f4624b;
            }
            f fVar3 = fVarArr[2];
            if (fVar3.f4623a == cls) {
                return fVar3.f4624b;
            }
            switch (fVarArr.length) {
                case 8:
                    f fVar4 = fVarArr[7];
                    if (fVar4.f4623a == cls) {
                        return fVar4.f4624b;
                    }
                case 7:
                    f fVar5 = fVarArr[6];
                    if (fVar5.f4623a == cls) {
                        return fVar5.f4624b;
                    }
                case 6:
                    f fVar6 = fVarArr[5];
                    if (fVar6.f4623a == cls) {
                        return fVar6.f4624b;
                    }
                case 5:
                    f fVar7 = fVarArr[4];
                    if (fVar7.f4623a == cls) {
                        return fVar7.f4624b;
                    }
                case 4:
                    f fVar8 = fVarArr[3];
                    if (fVar8.f4623a == cls) {
                        return fVar8.f4624b;
                    }
                    return null;
                default:
                    return null;
            }
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final k3.o f4619a;

        /* renamed from: b, reason: collision with root package name */
        public final k f4620b;

        public d(k3.o oVar, k kVar) {
            this.f4619a = oVar;
            this.f4620b = kVar;
        }
    }

    public static final class e extends k {

        /* renamed from: b, reason: collision with root package name */
        public final Class f4621b;

        /* renamed from: c, reason: collision with root package name */
        public final k3.o f4622c;

        public e(k kVar, Class cls, k3.o oVar) {
            super(kVar);
            this.f4621b = cls;
            this.f4622c = oVar;
        }

        @Override // b4.k
        public k i(Class cls, k3.o oVar) {
            return new a(this, this.f4621b, this.f4622c, cls, oVar);
        }

        @Override // b4.k
        public k3.o j(Class cls) {
            if (cls == this.f4621b) {
                return this.f4622c;
            }
            return null;
        }
    }

    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final Class f4623a;

        /* renamed from: b, reason: collision with root package name */
        public final k3.o f4624b;

        public f(Class cls, k3.o oVar) {
            this.f4623a = cls;
            this.f4624b = oVar;
        }
    }

    public k(boolean z10) {
        this.f4611a = z10;
    }

    public static k c() {
        return b.f4616b;
    }

    public final d a(Class cls, k3.o oVar) {
        return new d(oVar, i(cls, oVar));
    }

    public final d b(k3.j jVar, k3.o oVar) {
        return new d(oVar, i(jVar.q(), oVar));
    }

    public final d d(Class cls, c0 c0Var, k3.d dVar) {
        k3.o I = c0Var.I(cls, dVar);
        return new d(I, i(cls, I));
    }

    public final d e(Class cls, c0 c0Var, k3.d dVar) {
        k3.o N = c0Var.N(cls, dVar);
        return new d(N, i(cls, N));
    }

    public final d f(k3.j jVar, c0 c0Var, k3.d dVar) {
        k3.o O = c0Var.O(jVar, dVar);
        return new d(O, i(jVar.q(), O));
    }

    public final d g(Class cls, c0 c0Var, k3.d dVar) {
        k3.o G = c0Var.G(cls, dVar);
        return new d(G, i(cls, G));
    }

    public final d h(k3.j jVar, c0 c0Var, k3.d dVar) {
        k3.o H = c0Var.H(jVar, dVar);
        return new d(H, i(jVar.q(), H));
    }

    public abstract k i(Class cls, k3.o oVar);

    public abstract k3.o j(Class cls);

    public k(k kVar) {
        this.f4611a = kVar.f4611a;
    }
}
