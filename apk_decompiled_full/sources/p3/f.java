package p3;

import c3.k;
import k3.j;
import k3.l;

/* loaded from: classes.dex */
public class f extends l {

    /* renamed from: d, reason: collision with root package name */
    public Class f18056d;

    public f(k kVar, String str) {
        this(kVar, str, (j) null);
    }

    public static f s(k kVar, Class cls, String str) {
        return new f(kVar, str, cls);
    }

    public static f t(k kVar, j jVar, String str) {
        return new f(kVar, str, jVar);
    }

    public f u(j jVar) {
        this.f18056d = jVar.q();
        return this;
    }

    public f(k kVar, String str, c3.i iVar) {
        super(kVar, str, iVar);
    }

    public f(k kVar, String str, Class cls) {
        super(kVar, str);
        this.f18056d = cls;
    }

    public f(k kVar, String str, j jVar) {
        super(kVar, str);
        this.f18056d = d4.h.d0(jVar);
    }
}
