package j3;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class g extends ConcurrentHashMap {

    /* renamed from: b, reason: collision with root package name */
    public static final g f14658b = new g();

    /* renamed from: a, reason: collision with root package name */
    public final Object f14659a;

    public g() {
        super(180, 0.8f, 4);
        this.f14659a = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String a(String str) {
        String str2 = (String) get(str);
        if (str2 != null) {
            return str2;
        }
        if (size() >= 180) {
            synchronized (this.f14659a) {
                if (size() >= 180) {
                    clear();
                }
            }
        }
        String intern = str.intern();
        put(intern, intern);
        return intern;
    }
}
