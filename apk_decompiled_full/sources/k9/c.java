package k9;

import java.io.Serializable;
import k9.f;
import s9.p;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class c implements f, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final f f15702a;

    /* renamed from: b, reason: collision with root package name */
    public final f.b f15703b;

    public static final class a extends j implements p {

        /* renamed from: a, reason: collision with root package name */
        public static final a f15704a = new a();

        public a() {
            super(2);
        }

        @Override // s9.p
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str, f.b bVar) {
            i.g(str, "acc");
            i.g(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public c(f fVar, f.b bVar) {
        i.g(fVar, "left");
        i.g(bVar, "element");
        this.f15702a = fVar;
        this.f15703b = bVar;
    }

    @Override // k9.f
    public f E(f.c cVar) {
        i.g(cVar, "key");
        if (this.f15703b.a(cVar) != null) {
            return this.f15702a;
        }
        f E = this.f15702a.E(cVar);
        return E == this.f15702a ? this : E == g.f15708a ? this.f15703b : new c(E, this.f15703b);
    }

    @Override // k9.f
    public f.b a(f.c cVar) {
        i.g(cVar, "key");
        c cVar2 = this;
        while (true) {
            f.b a10 = cVar2.f15703b.a(cVar);
            if (a10 != null) {
                return a10;
            }
            f fVar = cVar2.f15702a;
            if (!(fVar instanceof c)) {
                return fVar.a(cVar);
            }
            cVar2 = (c) fVar;
        }
    }

    public final boolean d(f.b bVar) {
        return i.b(a(bVar.getKey()), bVar);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.h() != h() || !cVar.g(this)) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean g(c cVar) {
        while (d(cVar.f15703b)) {
            f fVar = cVar.f15702a;
            if (!(fVar instanceof c)) {
                i.e(fVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return d((f.b) fVar);
            }
            cVar = (c) fVar;
        }
        return false;
    }

    public final int h() {
        int i10 = 2;
        c cVar = this;
        while (true) {
            f fVar = cVar.f15702a;
            cVar = fVar instanceof c ? (c) fVar : null;
            if (cVar == null) {
                return i10;
            }
            i10++;
        }
    }

    public int hashCode() {
        return this.f15702a.hashCode() + this.f15703b.hashCode();
    }

    @Override // k9.f
    public Object m(Object obj, p pVar) {
        i.g(pVar, "operation");
        return pVar.invoke(this.f15702a.m(obj, pVar), this.f15703b);
    }

    @Override // k9.f
    public f s(f fVar) {
        return f.a.a(this, fVar);
    }

    public String toString() {
        return '[' + ((String) m("", a.f15704a)) + ']';
    }
}
