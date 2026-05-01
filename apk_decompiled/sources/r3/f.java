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
        To view partially-correct add '--show-bad-code' argument
    */
    public r3.e s(d4.h.a r9, d4.h.a r10) {
        /*
            r8 = this;
            int r0 = r9.d()
            k3.b r1 = r8.f18486a
            if (r1 != 0) goto L1c
            r3.e r10 = new r3.e
            r3.f0 r1 = r8.f18418d
            java.lang.reflect.Constructor r9 = r9.a()
            r3.p r2 = r3.u.a()
            r3.p[] r0 = r3.u.b(r0)
            r10.<init>(r1, r9, r2, r0)
            return r10
        L1c:
            if (r0 != 0) goto L30
            r3.e r0 = new r3.e
            r3.f0 r1 = r8.f18418d
            java.lang.reflect.Constructor r2 = r9.a()
            r3.p r9 = r8.m(r9, r10)
            r3.p[] r10 = r3.u.f18484b
            r0.<init>(r1, r2, r9, r10)
            return r0
        L30:
            java.lang.annotation.Annotation[][] r1 = r9.e()
            int r2 = r1.length
            r3 = 0
            if (r0 == r2) goto L9b
            java.lang.Class r2 = r9.c()
            boolean r4 = d4.h.L(r2)
            r5 = 0
            r6 = 1
            r7 = 2
            if (r4 == 0) goto L57
            int r4 = r1.length
            int r4 = r4 + r7
            if (r0 != r4) goto L57
            int r2 = r1.length
            int r2 = r2 + r7
            java.lang.annotation.Annotation[][] r2 = new java.lang.annotation.Annotation[r2][]
            int r4 = r1.length
            java.lang.System.arraycopy(r1, r5, r2, r7, r4)
            r3.p[] r3 = r8.o(r2, r3)
        L55:
            r1 = r2
            goto L72
        L57:
            boolean r2 = r2.isMemberClass()
            if (r2 == 0) goto L72
            int r2 = r1.length
            int r2 = r2 + r6
            if (r0 != r2) goto L72
            int r2 = r1.length
            int r2 = r2 + r6
            java.lang.annotation.Annotation[][] r2 = new java.lang.annotation.Annotation[r2][]
            int r4 = r1.length
            java.lang.System.arraycopy(r1, r5, r2, r6, r4)
            java.lang.annotation.Annotation[] r1 = r3.u.f18485c
            r2[r5] = r1
            r3.p[] r3 = r8.o(r2, r3)
            goto L55
        L72:
            if (r3 == 0) goto L75
            goto La6
        L75:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Class r9 = r9.c()
            java.lang.String r9 = r9.getName()
            r2[r5] = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)
            r2[r6] = r9
            int r9 = r1.length
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r2[r7] = r9
            java.lang.String r9 = "Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations"
            java.lang.String r9 = java.lang.String.format(r9, r2)
            r10.<init>(r9)
            throw r10
        L9b:
            if (r10 != 0) goto L9e
            goto La2
        L9e:
            java.lang.annotation.Annotation[][] r3 = r10.e()
        La2:
            r3.p[] r3 = r8.o(r1, r3)
        La6:
            r3.e r0 = new r3.e
            r3.f0 r1 = r8.f18418d
            java.lang.reflect.Constructor r2 = r9.a()
            r3.p r9 = r8.m(r9, r10)
            r0.<init>(r1, r2, r9, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.f.s(d4.h$a, d4.h$a):r3.e");
    }
}
