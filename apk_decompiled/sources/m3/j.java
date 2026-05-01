package m3;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class j {
    public static j b() {
        return a.b();
    }

    public abstract Object a(Object obj);

    public abstract j c(Object obj, Object obj2);

    public static class a extends j implements Serializable {

        /* renamed from: c, reason: collision with root package name */
        public static final a f16680c = new a(Collections.emptyMap());

        /* renamed from: d, reason: collision with root package name */
        public static final Object f16681d = new Object();

        /* renamed from: a, reason: collision with root package name */
        public final Map f16682a;

        /* renamed from: b, reason: collision with root package name */
        public transient Map f16683b;

        public a(Map map) {
            this.f16682a = map;
            this.f16683b = null;
        }

        public static j b() {
            return f16680c;
        }

        @Override // m3.j
        public Object a(Object obj) {
            Object obj2;
            Map map = this.f16683b;
            if (map == null || (obj2 = map.get(obj)) == null) {
                return this.f16682a.get(obj);
            }
            if (obj2 == f16681d) {
                return null;
            }
            return obj2;
        }

        @Override // m3.j
        public j c(Object obj, Object obj2) {
            if (obj2 == null) {
                if (!this.f16682a.containsKey(obj)) {
                    Map map = this.f16683b;
                    if (map != null && map.containsKey(obj)) {
                        this.f16683b.remove(obj);
                    }
                    return this;
                }
                obj2 = f16681d;
            }
            Map map2 = this.f16683b;
            if (map2 == null) {
                return d(obj, obj2);
            }
            map2.put(obj, obj2);
            return this;
        }

        public j d(Object obj, Object obj2) {
            HashMap hashMap = new HashMap();
            if (obj2 == null) {
                obj2 = f16681d;
            }
            hashMap.put(obj, obj2);
            return new a(this.f16682a, hashMap);
        }

        public a(Map map, Map map2) {
            this.f16682a = map;
            this.f16683b = map2;
        }
    }
}
