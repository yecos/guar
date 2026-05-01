package m8;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Gson f16834a;

    public static Gson a() {
        if (f16834a == null) {
            synchronized (a.class) {
                if (f16834a == null) {
                    f16834a = new GsonBuilder().disableHtmlEscaping().create();
                }
            }
        }
        return f16834a;
    }
}
