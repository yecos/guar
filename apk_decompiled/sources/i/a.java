package i;

import i.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: e, reason: collision with root package name */
    public HashMap f14247e = new HashMap();

    @Override // i.b
    public b.c b(Object obj) {
        return (b.c) this.f14247e.get(obj);
    }

    public boolean contains(Object obj) {
        return this.f14247e.containsKey(obj);
    }

    @Override // i.b
    public Object f(Object obj, Object obj2) {
        b.c b10 = b(obj);
        if (b10 != null) {
            return b10.f14253b;
        }
        this.f14247e.put(obj, e(obj, obj2));
        return null;
    }

    @Override // i.b
    public Object g(Object obj) {
        Object g10 = super.g(obj);
        this.f14247e.remove(obj);
        return g10;
    }

    public Map.Entry h(Object obj) {
        if (contains(obj)) {
            return ((b.c) this.f14247e.get(obj)).f14255d;
        }
        return null;
    }
}
