package y8;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import y8.l;

/* loaded from: classes3.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name */
    public static final o f19949b = new o(new l.a(), l.b.f19933a);

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentMap f19950a = new ConcurrentHashMap();

    public o(n... nVarArr) {
        for (n nVar : nVarArr) {
            this.f19950a.put(nVar.a(), nVar);
        }
    }

    public static o a() {
        return f19949b;
    }

    public n b(String str) {
        return (n) this.f19950a.get(str);
    }
}
