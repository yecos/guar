package xa;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: d, reason: collision with root package name */
    public static final List f19631d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public Object f19632a;

    /* renamed from: b, reason: collision with root package name */
    public n f19633b;

    /* renamed from: c, reason: collision with root package name */
    public h f19634c;

    public h(Object obj, n nVar) {
        this.f19632a = obj;
        this.f19633b = nVar;
    }

    public static h a(n nVar, Object obj) {
        List list = f19631d;
        synchronized (list) {
            int size = list.size();
            if (size <= 0) {
                return new h(obj, nVar);
            }
            h hVar = (h) list.remove(size - 1);
            hVar.f19632a = obj;
            hVar.f19633b = nVar;
            hVar.f19634c = null;
            return hVar;
        }
    }

    public static void b(h hVar) {
        hVar.f19632a = null;
        hVar.f19633b = null;
        hVar.f19634c = null;
        List list = f19631d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(hVar);
            }
        }
    }
}
