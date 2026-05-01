package r3;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import r3.t;

/* loaded from: classes.dex */
public class e0 implements t.a, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final t.a f18416a;

    /* renamed from: b, reason: collision with root package name */
    public Map f18417b;

    public e0(t.a aVar) {
        this.f18416a = aVar;
    }

    @Override // r3.t.a
    public Class a(Class cls) {
        Map map;
        t.a aVar = this.f18416a;
        Class a10 = aVar == null ? null : aVar.a(cls);
        return (a10 != null || (map = this.f18417b) == null) ? a10 : (Class) map.get(new c4.b(cls));
    }

    public void b(Class cls, Class cls2) {
        if (this.f18417b == null) {
            this.f18417b = new HashMap();
        }
        this.f18417b.put(new c4.b(cls), cls2);
    }

    public boolean c() {
        if (this.f18417b != null) {
            return true;
        }
        t.a aVar = this.f18416a;
        if (aVar == null) {
            return false;
        }
        if (aVar instanceof e0) {
            return ((e0) aVar).c();
        }
        return true;
    }
}
