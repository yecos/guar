package ia;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/* loaded from: classes3.dex */
public final class c implements Converter {

    /* renamed from: c, reason: collision with root package name */
    public static final MediaType f14412c = MediaType.parse("application/json; charset=UTF-8");

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f14413d = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final Gson f14414a;

    /* renamed from: b, reason: collision with root package name */
    public final TypeAdapter f14415b;

    public c(Gson gson, TypeAdapter typeAdapter) {
        this.f14414a = gson;
        this.f14415b = typeAdapter;
    }

    @Override // retrofit2.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RequestBody convert(Object obj) {
        return RequestBody.create(f14412c, String.valueOf(obj));
    }
}
