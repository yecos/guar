package r3;

import d4.h;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import r3.c;

/* loaded from: classes.dex */
public final class f extends u {

    /* renamed from: d, reason: collision with root package name */
    public final f0 f18418d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f18419e;

    /* renamed from: f, reason: collision with root package name */
    public e f18420f;

    public f(k3.b bVar, f0 f0Var, boolean z10) {
        super(bVar);
        this.f18418d = f0Var;
        this.f18419e = z10;
    }

    public static boolean k(Method method) {
        return Modifier.isStatic(method.getModifiers()) && !method.isSynthetic();
    }

    public static c.a p(k3.b bVar, c4.o oVar, f0 f0Var, k3.j jVar, Class cls, boolean z10) {
        return new f(bVar, f0Var, z10 | (cls != null)).l(oVar, jVar, cls);
    }

    public static boolean t(Constructor constructor) {
        return !constructor.isSynthetic();
    }

    public final List i(k3.j jVar, Class cls) {
        h.a aVar;
        ArrayList arrayList;
        int i10;
        List list;
        if (jVar.F()) {
            aVar = null;
            arrayList = null;
        } else {
            aVar = null;
            arrayList = null;
            for (h.a aVar2 : d4.h.A(jVar.q())) {
                if (t(aVar2.a())) {
                    if (aVar2.d() == 0) {
                        aVar = aVar2;
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(aVar2);
                    }
                }
            }
        }
        if (arrayList == null) {
            list = Collections.emptyList();
            if (aVar == null) {
                return list;
            }
            i10 = 0;
        } else {
            int size = arrayList.size();
            ArrayList arrayList2 = new ArrayList(size);
            for (int i11 = 0; i11 < size; i11++) {
                arrayList2.add(null);
            }
            i10 = size;
            list = arrayList2;
        }
        if (cls != null) {
            y[] yVarArr = null;
            for (h.a aVar3 : d4.h.A(cls)) {
                if (aVar3.d() == 0) {
                    if (aVar != null) {
                        this.f18420f = q(aVar, aVar3);
                        aVar = null;
                    }
                } else if (arrayList != null) {
                    if (yVarArr == null) {
                        yVarArr = new y[i10];
                        for (int i12 = 0; i12 < i10; i12++) {
                            yVarArr[i12] = new y(((h.a) arrayList.get(i12)).a());
                        }
                    }
                    y yVar = new y(aVar3.a());
                    int i13 = 0;
                    while (true) {
                        if (i13 >= i10) {
                            break;
                        }
                        if (yVar.equals(yVarArr[i13])) {
                            list.set(i13, s((h.a) arrayList.get(i13), aVar3));
                            break;
                        }
                        i13++;
                    }
                }
            }
        }
        if (aVar != null) {
            this.f18420f = q(aVar, null);
        }
        for (int i14 = 0; i14 < i10; i14++) {
            if (((e) list.get(i14)) == null) {
                list.set(i14, s((h.a) arrayList.get(i14), null));
            }
        }
        return list;
    }

    public final List j(c4.o oVar, k3.j jVar, Class cls) {
        ArrayList arrayList = null;
        for (Method method : d4.h.z(jVar.q())) {
            if (k(method)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(method);
            }
        }
        if (arrayList == null) {
            return Collections.emptyList();
        }
        f0 f0Var = this.f18418d;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            arrayList2.add(null);
        }
        if (cls != null) {
            y[] yVarArr = null;
            for (Method method2 : cls.getDeclaredMethods()) {
                if (k(method2)) {
                    if (yVarArr == null) {
                        yVarArr = new y[size];
                        for (int i11 = 0; i11 < size; i11++) {
                            yVarArr[i11] = new y((Method) arrayList.get(i11));
                        }
                    }
                    y yVar = new y(method2);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= size) {
                            break;
                        }
                        if (yVar.equals(yVarArr[i12])) {
                            arrayList2.set(i12, r((Method) arrayList.get(i12), f0Var, method2));
                            break;
                        }
                        i12++;
                    }
                }
            }
        }
        for (int i13 = 0; i13 < size; i13++) {
            if (((j) arrayList2.get(i13)) == null) {
                Method method3 = (Method) arrayList.get(i13);
                arrayList2.set(i13, r(method3, z.e(method3, jVar, oVar, f0Var), null));
            }
        }
        return arrayList2;
    }

    public c.a l(c4.o oVar, k3.j jVar, Class cls) {
        List i10 = i(jVar, cls);
        List j10 = j(oVar, jVar, cls);
        if (this.f18419e) {
            e eVar = this.f18420f;
            if (eVar != null && this.f18486a.o0(eVar)) {
                this.f18420f = null;
            }
            int size = i10.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                if (this.f18486a.o0((i) i10.get(size))) {
                    i10.remove(size);
                }
            }
            int size2 = j10.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    break;
                }
                if (this.f18486a.o0((i) j10.get(size2))) {
                    j10.remove(size2);
                }
            }
        }
        return new c.a(this.f18420f, i10, j10);
    }

    public final p m(h.a aVar, h.a aVar2) {
        if (!this.f18419e) {
            return u.a();
        }
        o e10 = e(aVar.b());
        if (aVar2 != null) {
            e10 = d(e10, aVar2.b());
        }
        return e10.b();
    }

    public final p n(AnnotatedElement annotatedElement, AnnotatedElement annotatedElement2) {
        o e10 = e(annotatedElement.getDeclaredAnnotations());
        if (annotatedElement2 != null) {
            e10 = d(e10, annotatedElement2.getDeclaredAnnotations());
        }
        return e10.b();
    }

    public final p[] o(Annotation[][] annotationArr, Annotation[][] annotationArr2) {
        if (!this.f18419e) {
            return u.f18484b;
        }
        int length = annotationArr.length;
        p[] pVarArr = new p[length];
        for (int i10 = 0; i10 < length; i10++) {
            o d10 = d(o.e(), annotationArr[i10]);
            if (annotationArr2 != null) {
                d10 = d(d10, annotationArr2[i10]);
            }
            pVarArr[i10] = d10.b();
        }
        return pVarArr;
    }

    public e q(h.a aVar, h.a aVar2) {
        return new e(this.f18418d, aVar.a(), m(aVar, aVar2), u.f18484b);
    }

    public j r(Method method, f0 f0Var, Method method2) {
        int length = method.getParameterTypes().length;
        if (this.f18486a == null) {
            return new j(f0Var, method, u.a(), u.b(length));
        }
        if (length == 0) {
            return new j(f0Var, method, n(method, method2), u.f18484b);
        }
        return new j(f0Var, method, n(method, method2), o(method.getParameterAnnotations(), method2 == null ? null : method2.getParameterAnnotations()));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e s(h.a aVar, h.a aVar2) {
        Annotation[][] annotationArr;
        int d10 = aVar.d();
        if (this.f18486a == null) {
            return new e(this.f18418d, aVar.a(), u.a(), u.b(d10));
        }
        if (d10 == 0) {
            return new e(this.f18418d, aVar.a(), m(aVar, aVar2), u.f18484b);
        }
        Annotation[][] e10 = aVar.e();
        r3 = null;
        p[] o10 = null;
        if (d10 != e10.length) {
            Class c10 = aVar.c();
            if (d4.h.L(c10) && d10 == e10.length + 2) {
                annotationArr = new Annotation[e10.length + 2][];
                System.arraycopy(e10, 0, annotationArr, 2, e10.length);
                o10 = o(annotationArr, null);
            } else {
                if (c10.isMemberClass() && d10 == e10.length + 1) {
                    annotationArr = new Annotation[e10.length + 1][];
                    System.arraycopy(e10, 0, annotationArr, 1, e10.length);
                    annotationArr[0] = u.f18485c;
                    o10 = o(annotationArr, null);
                }
                if (o10 == null) {
                    throw new IllegalStateException(String.format("Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations", aVar.c().getName(), Integer.valueOf(d10), Integer.valueOf(e10.length)));
                }
            }
            e10 = annotationArr;
            if (o10 == null) {
            }
        } else {
            o10 = o(e10, aVar2 != null ? aVar2.e() : null);
        }
        return new e(this.f18418d, aVar.a(), m(aVar, aVar2), o10);
    }
}
