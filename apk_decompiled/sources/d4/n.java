package d4;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class n implements p, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final transient int f12555a;

    /* renamed from: b, reason: collision with root package name */
    public final transient ConcurrentHashMap f12556b;

    public n(int i10, int i11) {
        this.f12556b = new ConcurrentHashMap(i10, 0.8f, 4);
        this.f12555a = i11;
    }

    public Object a(Object obj, Object obj2) {
        if (this.f12556b.size() >= this.f12555a) {
            synchronized (this) {
                if (this.f12556b.size() >= this.f12555a) {
                    clear();
                }
            }
        }
        return this.f12556b.put(obj, obj2);
    }

    public void clear() {
        this.f12556b.clear();
    }

    @Override // d4.p
    public Object get(Object obj) {
        return this.f12556b.get(obj);
    }

    @Override // d4.p
    public Object putIfAbsent(Object obj, Object obj2) {
        if (this.f12556b.size() >= this.f12555a) {
            synchronized (this) {
                if (this.f12556b.size() >= this.f12555a) {
                    clear();
                }
            }
        }
        return this.f12556b.putIfAbsent(obj, obj2);
    }
}
