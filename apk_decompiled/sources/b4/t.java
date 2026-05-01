package b4;

import b3.k0;
import k3.c0;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final k0 f4643a;

    /* renamed from: b, reason: collision with root package name */
    public Object f4644b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4645c = false;

    public t(k0 k0Var) {
        this.f4643a = k0Var;
    }

    public Object a(Object obj) {
        if (this.f4644b == null) {
            this.f4644b = this.f4643a.c(obj);
        }
        return this.f4644b;
    }

    public void b(c3.h hVar, c0 c0Var, i iVar) {
        this.f4645c = true;
        if (hVar.m()) {
            Object obj = this.f4644b;
            hVar.j0(obj == null ? null : String.valueOf(obj));
            return;
        }
        c3.q qVar = iVar.f4606b;
        if (qVar != null) {
            hVar.Y(qVar);
            iVar.f4608d.serialize(this.f4644b, hVar, c0Var);
        }
    }

    public boolean c(c3.h hVar, c0 c0Var, i iVar) {
        if (this.f4644b == null) {
            return false;
        }
        if (!this.f4645c && !iVar.f4609e) {
            return false;
        }
        if (hVar.m()) {
            hVar.k0(String.valueOf(this.f4644b));
            return true;
        }
        iVar.f4608d.serialize(this.f4644b, hVar, c0Var);
        return true;
    }
}
