package b4;

import d4.a0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final a[] f4625a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4626b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4627c;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final k3.o f4628a;

        /* renamed from: b, reason: collision with root package name */
        public final a f4629b;

        /* renamed from: c, reason: collision with root package name */
        public final Class f4630c;

        /* renamed from: d, reason: collision with root package name */
        public final k3.j f4631d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f4632e;

        public a(a aVar, a0 a0Var, k3.o oVar) {
            this.f4629b = aVar;
            this.f4628a = oVar;
            this.f4632e = a0Var.c();
            this.f4630c = a0Var.a();
            this.f4631d = a0Var.b();
        }

        public boolean a(Class cls) {
            return this.f4630c == cls && this.f4632e;
        }

        public boolean b(k3.j jVar) {
            return this.f4632e && jVar.equals(this.f4631d);
        }

        public boolean c(Class cls) {
            return this.f4630c == cls && !this.f4632e;
        }

        public boolean d(k3.j jVar) {
            return !this.f4632e && jVar.equals(this.f4631d);
        }
    }

    public l(Map map) {
        int a10 = a(map.size());
        this.f4626b = a10;
        this.f4627c = a10 - 1;
        a[] aVarArr = new a[a10];
        for (Map.Entry entry : map.entrySet()) {
            a0 a0Var = (a0) entry.getKey();
            int hashCode = a0Var.hashCode() & this.f4627c;
            aVarArr[hashCode] = new a(aVarArr[hashCode], a0Var, (k3.o) entry.getValue());
        }
        this.f4625a = aVarArr;
    }

    public static final int a(int i10) {
        int i11 = 8;
        while (i11 < (i10 <= 64 ? i10 + i10 : i10 + (i10 >> 2))) {
            i11 += i11;
        }
        return i11;
    }

    public static l b(HashMap hashMap) {
        return new l(hashMap);
    }

    public k3.o c(Class cls) {
        a aVar = this.f4625a[a0.d(cls) & this.f4627c];
        if (aVar == null) {
            return null;
        }
        if (aVar.a(cls)) {
            return aVar.f4628a;
        }
        do {
            aVar = aVar.f4629b;
            if (aVar == null) {
                return null;
            }
        } while (!aVar.a(cls));
        return aVar.f4628a;
    }

    public k3.o d(k3.j jVar) {
        a aVar = this.f4625a[a0.e(jVar) & this.f4627c];
        if (aVar == null) {
            return null;
        }
        if (aVar.b(jVar)) {
            return aVar.f4628a;
        }
        do {
            aVar = aVar.f4629b;
            if (aVar == null) {
                return null;
            }
        } while (!aVar.b(jVar));
        return aVar.f4628a;
    }

    public k3.o e(Class cls) {
        a aVar = this.f4625a[a0.f(cls) & this.f4627c];
        if (aVar == null) {
            return null;
        }
        if (aVar.c(cls)) {
            return aVar.f4628a;
        }
        do {
            aVar = aVar.f4629b;
            if (aVar == null) {
                return null;
            }
        } while (!aVar.c(cls));
        return aVar.f4628a;
    }

    public k3.o f(k3.j jVar) {
        a aVar = this.f4625a[a0.g(jVar) & this.f4627c];
        if (aVar == null) {
            return null;
        }
        if (aVar.d(jVar)) {
            return aVar.f4628a;
        }
        do {
            aVar = aVar.f4629b;
            if (aVar == null) {
                return null;
            }
        } while (!aVar.d(jVar));
        return aVar.f4628a;
    }
}
