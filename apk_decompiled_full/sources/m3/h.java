package m3;

import b3.b0;
import b3.k;
import b3.r;
import java.io.Serializable;
import java.util.Map;
import r3.h0;

/* loaded from: classes.dex */
public class h implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public Map f16662a;

    /* renamed from: b, reason: collision with root package name */
    public r.b f16663b;

    /* renamed from: c, reason: collision with root package name */
    public b0.a f16664c;

    /* renamed from: d, reason: collision with root package name */
    public h0 f16665d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f16666e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f16667f;

    public h() {
        this(null, r.b.c(), b0.a.c(), h0.a.o(), null, null);
    }

    public k.d a(Class cls) {
        g gVar;
        k.d b10;
        Map map = this.f16662a;
        if (map != null && (gVar = (g) map.get(cls)) != null && (b10 = gVar.b()) != null) {
            return !b10.k() ? b10.q(this.f16667f) : b10;
        }
        Boolean bool = this.f16667f;
        return bool == null ? k.d.b() : k.d.c(bool.booleanValue());
    }

    public g b(Class cls) {
        Map map = this.f16662a;
        if (map == null) {
            return null;
        }
        return (g) map.get(cls);
    }

    public r.b c() {
        return this.f16663b;
    }

    public Boolean d() {
        return this.f16666e;
    }

    public b0.a e() {
        return this.f16664c;
    }

    public h0 f() {
        return this.f16665d;
    }

    public h(Map map, r.b bVar, b0.a aVar, h0 h0Var, Boolean bool, Boolean bool2) {
        this.f16662a = map;
        this.f16663b = bVar;
        this.f16664c = aVar;
        this.f16665d = h0Var;
        this.f16666e = bool;
        this.f16667f = bool2;
    }
}
