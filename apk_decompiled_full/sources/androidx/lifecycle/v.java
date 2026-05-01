package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    public final Map f2602a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f2603b = false;

    public static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public final void a() {
        this.f2603b = true;
        Map map = this.f2602a;
        if (map != null) {
            synchronized (map) {
                Iterator it = this.f2602a.values().iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
            }
        }
        d();
    }

    public Object c(String str) {
        Object obj;
        Map map = this.f2602a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            obj = this.f2602a.get(str);
        }
        return obj;
    }

    public void d() {
    }

    public Object e(String str, Object obj) {
        Object obj2;
        synchronized (this.f2602a) {
            obj2 = this.f2602a.get(str);
            if (obj2 == null) {
                this.f2602a.put(str, obj);
            }
        }
        if (obj2 != null) {
            obj = obj2;
        }
        if (this.f2603b) {
            b(obj);
        }
        return obj;
    }
}
