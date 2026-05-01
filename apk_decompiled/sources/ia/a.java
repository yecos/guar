package ia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class a extends Converter.Factory {

    /* renamed from: a, reason: collision with root package name */
    public final Gson f14404a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f14405b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14406c;

    public a(Gson gson, boolean z10, String str) {
        if (gson == null) {
            throw new NullPointerException("gson == null");
        }
        this.f14404a = gson;
        this.f14405b = z10;
        this.f14406c = str;
    }

    public static a a(Gson gson, boolean z10, String str) {
        return new a(gson, z10, str);
    }

    public static a b(boolean z10) {
        return a(new GsonBuilder().disableHtmlEscaping().create(), z10, v7.b.f19124a);
    }

    @Override // retrofit2.Converter.Factory
    public Converter requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new c(this.f14404a, this.f14404a.getAdapter(TypeToken.get(type)));
    }

    @Override // retrofit2.Converter.Factory
    public Converter responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        TypeAdapter adapter = this.f14404a.getAdapter(TypeToken.get(type));
        return this.f14405b ? new d(this.f14404a, adapter, type, this.f14406c, annotationArr) : new b(this.f14404a, adapter, type, this.f14406c, annotationArr);
    }
}
