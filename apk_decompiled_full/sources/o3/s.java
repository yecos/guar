package o3;

import b3.k0;
import b3.o0;
import java.io.Serializable;

/* loaded from: classes.dex */
public class s implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final k3.j f17562a;

    /* renamed from: b, reason: collision with root package name */
    public final k3.x f17563b;

    /* renamed from: c, reason: collision with root package name */
    public final k0 f17564c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.k f17565d;

    /* renamed from: e, reason: collision with root package name */
    public final n3.t f17566e;

    public s(k3.j jVar, k3.x xVar, k0 k0Var, k3.k kVar, n3.t tVar, o0 o0Var) {
        this.f17562a = jVar;
        this.f17563b = xVar;
        this.f17564c = k0Var;
        this.f17565d = kVar;
        this.f17566e = tVar;
    }

    public static s a(k3.j jVar, k3.x xVar, k0 k0Var, k3.k kVar, n3.t tVar, o0 o0Var) {
        return new s(jVar, xVar, k0Var, kVar, tVar, o0Var);
    }

    public k3.k b() {
        return this.f17565d;
    }

    public k3.j c() {
        return this.f17562a;
    }

    public boolean d(String str, c3.k kVar) {
        return this.f17564c.e(str, kVar);
    }

    public boolean e() {
        return this.f17564c.g();
    }

    public Object f(c3.k kVar, k3.g gVar) {
        return this.f17565d.deserialize(kVar, gVar);
    }
}
