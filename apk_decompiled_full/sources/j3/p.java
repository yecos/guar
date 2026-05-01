package j3;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final Object f14683a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Map f14684b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ReferenceQueue f14685c = new ReferenceQueue();

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final p f14686a = new p();
    }

    public static p a() {
        return a.f14686a;
    }

    public final void b() {
        while (true) {
            SoftReference softReference = (SoftReference) this.f14685c.poll();
            if (softReference == null) {
                return;
            } else {
                this.f14684b.remove(softReference);
            }
        }
    }

    public SoftReference c(j3.a aVar) {
        SoftReference softReference = new SoftReference(aVar, this.f14685c);
        this.f14684b.put(softReference, Boolean.TRUE);
        b();
        return softReference;
    }
}
