package g8;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import t9.i;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f14068a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static Gson f14069b;

    public final Object a(String str, Class cls) {
        i.g(str, "json");
        i.g(cls, "classOfT");
        try {
            return b().fromJson(str, cls);
        } catch (JsonSyntaxException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final Gson b() {
        if (f14069b == null) {
            f14069b = new GsonBuilder().disableHtmlEscaping().create();
        }
        Gson gson = f14069b;
        i.d(gson);
        return gson;
    }

    public final String c(Object obj) {
        i.g(obj, "jsonObject");
        try {
            String json = b().toJson(obj);
            i.f(json, "getGson().toJson(jsonObject)");
            return json;
        } catch (JsonIOException e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
