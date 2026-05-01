package s2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static Gson f18731a;

    public static Gson a() {
        if (f18731a == null) {
            synchronized (b.class) {
                if (f18731a == null) {
                    f18731a = new GsonBuilder().disableHtmlEscaping().create();
                }
            }
        }
        return f18731a;
    }
}
