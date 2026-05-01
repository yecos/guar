package r3;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: b, reason: collision with root package name */
    public static final p[] f18484b = new p[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Annotation[] f18485c = new Annotation[0];

    /* renamed from: a, reason: collision with root package name */
    public final k3.b f18486a;

    public u(k3.b bVar) {
        this.f18486a = bVar;
    }

    public static p a() {
        return new p();
    }

    public static p[] b(int i10) {
        if (i10 == 0) {
            return f18484b;
        }
        p[] pVarArr = new p[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            pVarArr[i11] = a();
        }
        return pVarArr;
    }

    public static final boolean c(Annotation annotation) {
        return (annotation instanceof Target) || (annotation instanceof Retention);
    }

    public final o d(o oVar, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            oVar = oVar.a(annotation);
            if (this.f18486a.q0(annotation)) {
                oVar = h(oVar, annotation);
            }
        }
        return oVar;
    }

    public final o e(Annotation[] annotationArr) {
        o e10 = o.e();
        for (Annotation annotation : annotationArr) {
            e10 = e10.a(annotation);
            if (this.f18486a.q0(annotation)) {
                e10 = h(e10, annotation);
            }
        }
        return e10;
    }

    public final o f(o oVar, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            if (!oVar.f(annotation)) {
                oVar = oVar.a(annotation);
                if (this.f18486a.q0(annotation)) {
                    oVar = g(oVar, annotation);
                }
            }
        }
        return oVar;
    }

    public final o g(o oVar, Annotation annotation) {
        for (Annotation annotation2 : d4.h.p(annotation.annotationType())) {
            if (!c(annotation2) && !oVar.f(annotation2)) {
                oVar = oVar.a(annotation2);
                if (this.f18486a.q0(annotation2)) {
                    oVar = h(oVar, annotation2);
                }
            }
        }
        return oVar;
    }

    public final o h(o oVar, Annotation annotation) {
        for (Annotation annotation2 : d4.h.p(annotation.annotationType())) {
            if (!c(annotation2)) {
                if (!this.f18486a.q0(annotation2)) {
                    oVar = oVar.a(annotation2);
                } else if (!oVar.f(annotation2)) {
                    oVar = h(oVar.a(annotation2), annotation2);
                }
            }
        }
        return oVar;
    }
}
