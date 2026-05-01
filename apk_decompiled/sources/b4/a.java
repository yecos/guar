package b4;

import b3.r;
import k3.c0;

/* loaded from: classes.dex */
public class a extends a4.s {

    /* renamed from: u, reason: collision with root package name */
    public final String f4584u;

    public a(String str, r3.s sVar, d4.b bVar, k3.j jVar) {
        this(str, sVar, bVar, jVar, sVar.g());
    }

    public static a J(String str, r3.s sVar, d4.b bVar, k3.j jVar) {
        return new a(str, sVar, bVar, jVar);
    }

    @Override // a4.s
    public Object H(Object obj, c3.h hVar, c0 c0Var) {
        return c0Var.X(this.f4584u);
    }

    @Override // a4.s
    public a4.s I(m3.m mVar, r3.c cVar, r3.s sVar, k3.j jVar) {
        throw new IllegalStateException("Should not be called on this type");
    }

    public a(String str, r3.s sVar, d4.b bVar, k3.j jVar, r.b bVar2) {
        super(sVar, bVar, jVar, null, null, null, bVar2, null);
        this.f4584u = str;
    }
}
