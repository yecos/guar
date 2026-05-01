package r3;

import b3.f;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public interface h0 {

    public static class a implements h0, Serializable {

        /* renamed from: f, reason: collision with root package name */
        public static final a f18433f;

        /* renamed from: a, reason: collision with root package name */
        public final f.c f18434a;

        /* renamed from: b, reason: collision with root package name */
        public final f.c f18435b;

        /* renamed from: c, reason: collision with root package name */
        public final f.c f18436c;

        /* renamed from: d, reason: collision with root package name */
        public final f.c f18437d;

        /* renamed from: e, reason: collision with root package name */
        public final f.c f18438e;

        static {
            f.c cVar = f.c.PUBLIC_ONLY;
            f.c cVar2 = f.c.ANY;
            f18433f = new a(cVar, cVar, cVar2, cVar2, cVar);
        }

        public a(f.c cVar, f.c cVar2, f.c cVar3, f.c cVar4, f.c cVar5) {
            this.f18434a = cVar;
            this.f18435b = cVar2;
            this.f18436c = cVar3;
            this.f18437d = cVar4;
            this.f18438e = cVar5;
        }

        public static a o() {
            return f18433f;
        }

        @Override // r3.h0
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public a h(f.c cVar) {
            if (cVar == f.c.DEFAULT) {
                cVar = f18433f.f18436c;
            }
            f.c cVar2 = cVar;
            return this.f18436c == cVar2 ? this : new a(this.f18434a, this.f18435b, cVar2, this.f18437d, this.f18438e);
        }

        @Override // r3.h0
        public boolean d(j jVar) {
            return s(jVar.b());
        }

        @Override // r3.h0
        public boolean e(g gVar) {
            return q(gVar.b());
        }

        @Override // r3.h0
        public boolean f(j jVar) {
            return t(jVar.b());
        }

        @Override // r3.h0
        public boolean g(j jVar) {
            return r(jVar.b());
        }

        @Override // r3.h0
        public boolean j(i iVar) {
            return p(iVar.m());
        }

        public final f.c m(f.c cVar, f.c cVar2) {
            return cVar2 == f.c.DEFAULT ? cVar : cVar2;
        }

        public a n(f.c cVar, f.c cVar2, f.c cVar3, f.c cVar4, f.c cVar5) {
            return (cVar == this.f18434a && cVar2 == this.f18435b && cVar3 == this.f18436c && cVar4 == this.f18437d && cVar5 == this.f18438e) ? this : new a(cVar, cVar2, cVar3, cVar4, cVar5);
        }

        public boolean p(Member member) {
            return this.f18437d.a(member);
        }

        public boolean q(Field field) {
            return this.f18438e.a(field);
        }

        public boolean r(Method method) {
            return this.f18434a.a(method);
        }

        public boolean s(Method method) {
            return this.f18435b.a(method);
        }

        public boolean t(Method method) {
            return this.f18436c.a(method);
        }

        public String toString() {
            return String.format("[Visibility: getter=%s,isGetter=%s,setter=%s,creator=%s,field=%s]", this.f18434a, this.f18435b, this.f18436c, this.f18437d, this.f18438e);
        }

        @Override // r3.h0
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public a a(b3.f fVar) {
            return fVar != null ? n(m(this.f18434a, fVar.getterVisibility()), m(this.f18435b, fVar.isGetterVisibility()), m(this.f18436c, fVar.setterVisibility()), m(this.f18437d, fVar.creatorVisibility()), m(this.f18438e, fVar.fieldVisibility())) : this;
        }

        @Override // r3.h0
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public a l(f.c cVar) {
            if (cVar == f.c.DEFAULT) {
                cVar = f18433f.f18437d;
            }
            f.c cVar2 = cVar;
            return this.f18437d == cVar2 ? this : new a(this.f18434a, this.f18435b, this.f18436c, cVar2, this.f18438e);
        }

        @Override // r3.h0
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public a c(f.c cVar) {
            if (cVar == f.c.DEFAULT) {
                cVar = f18433f.f18438e;
            }
            f.c cVar2 = cVar;
            return this.f18438e == cVar2 ? this : new a(this.f18434a, this.f18435b, this.f18436c, this.f18437d, cVar2);
        }

        @Override // r3.h0
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public a b(f.c cVar) {
            if (cVar == f.c.DEFAULT) {
                cVar = f18433f.f18434a;
            }
            f.c cVar2 = cVar;
            return this.f18434a == cVar2 ? this : new a(cVar2, this.f18435b, this.f18436c, this.f18437d, this.f18438e);
        }

        @Override // r3.h0
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public a k(f.c cVar) {
            if (cVar == f.c.DEFAULT) {
                cVar = f18433f.f18435b;
            }
            f.c cVar2 = cVar;
            return this.f18435b == cVar2 ? this : new a(this.f18434a, cVar2, this.f18436c, this.f18437d, this.f18438e);
        }

        @Override // r3.h0
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public a i(f.b bVar) {
            return this;
        }
    }

    h0 a(b3.f fVar);

    h0 b(f.c cVar);

    h0 c(f.c cVar);

    boolean d(j jVar);

    boolean e(g gVar);

    boolean f(j jVar);

    boolean g(j jVar);

    h0 h(f.c cVar);

    h0 i(f.b bVar);

    boolean j(i iVar);

    h0 k(f.c cVar);

    h0 l(f.c cVar);
}
