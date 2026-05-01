package t;

import android.content.Context;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f18785b = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Context f18786a;

    public a(Context context) {
        this.f18786a = context;
    }

    public static a a(Context context) {
        a aVar;
        WeakHashMap weakHashMap = f18785b;
        synchronized (weakHashMap) {
            aVar = (a) weakHashMap.get(context);
            if (aVar == null) {
                aVar = new a(context);
                weakHashMap.put(context, aVar);
            }
        }
        return aVar;
    }
}
