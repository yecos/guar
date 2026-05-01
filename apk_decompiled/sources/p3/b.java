package p3;

import c3.k;
import k3.j;
import k3.l;
import r3.s;

/* loaded from: classes.dex */
public class b extends l {

    /* renamed from: d, reason: collision with root package name */
    public final j f18049d;

    /* renamed from: e, reason: collision with root package name */
    public transient k3.c f18050e;

    /* renamed from: f, reason: collision with root package name */
    public transient s f18051f;

    public b(k kVar, String str, j jVar) {
        super(kVar, str);
        this.f18049d = jVar;
        this.f18050e = null;
        this.f18051f = null;
    }

    public static b s(c3.h hVar, String str, k3.c cVar, s sVar) {
        return new b(hVar, str, cVar, sVar);
    }

    public static b t(c3.h hVar, String str, j jVar) {
        return new b(hVar, str, jVar);
    }

    public static b u(k kVar, String str, k3.c cVar, s sVar) {
        return new b(kVar, str, cVar, sVar);
    }

    public static b v(k kVar, String str, j jVar) {
        return new b(kVar, str, jVar);
    }

    public b(c3.h hVar, String str, j jVar) {
        super(hVar, str);
        this.f18049d = jVar;
        this.f18050e = null;
        this.f18051f = null;
    }

    public b(k kVar, String str, k3.c cVar, s sVar) {
        super(kVar, str);
        this.f18049d = cVar == null ? null : cVar.z();
        this.f18050e = cVar;
        this.f18051f = sVar;
    }

    public b(c3.h hVar, String str, k3.c cVar, s sVar) {
        super(hVar, str);
        this.f18049d = cVar == null ? null : cVar.z();
        this.f18050e = cVar;
        this.f18051f = sVar;
    }
}
