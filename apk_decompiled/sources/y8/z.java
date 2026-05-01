package y8;

import java.util.List;

/* loaded from: classes3.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static List f20095a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f20096b;

    public static synchronized List a() {
        List list;
        synchronized (z.class) {
            f20096b = true;
            list = f20095a;
        }
        return list;
    }
}
