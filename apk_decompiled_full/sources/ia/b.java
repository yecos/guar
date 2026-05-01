package ia;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import ma.i;
import mobile.com.requestframe.utils.bean.EncryptJsonBean;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: classes3.dex */
public final class b implements Converter {

    /* renamed from: a, reason: collision with root package name */
    public final String f14407a = b.class.getName();

    /* renamed from: b, reason: collision with root package name */
    public final Gson f14408b;

    /* renamed from: c, reason: collision with root package name */
    public final TypeAdapter f14409c;

    /* renamed from: d, reason: collision with root package name */
    public final Type f14410d;

    /* renamed from: e, reason: collision with root package name */
    public final String f14411e;

    public b(Gson gson, TypeAdapter typeAdapter, Type type, String str, Annotation[] annotationArr) {
        this.f14408b = gson;
        this.f14409c = typeAdapter;
        this.f14410d = type;
        this.f14411e = b(annotationArr, str);
    }

    @Override // retrofit2.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object convert(ResponseBody responseBody) {
        String string = responseBody.string();
        try {
            if (!i.h()) {
                return this.f14408b.fromJson(string, this.f14410d);
            }
            EncryptJsonBean encryptJsonBean = (EncryptJsonBean) this.f14408b.fromJson(string, EncryptJsonBean.class);
            return this.f14408b.fromJson(string.replace("\"" + encryptJsonBean.getData() + "\"", i.a(encryptJsonBean.getData(), this.f14411e)), this.f14410d);
        } finally {
            responseBody.close();
        }
    }

    public final String b(Annotation[] annotationArr, String str) {
        if (annotationArr != null && annotationArr.length > 0) {
            for (Annotation annotation : annotationArr) {
                String annotation2 = annotation.toString();
                if (annotation2.contains("responseKey:")) {
                    return annotation2.substring(annotation2.indexOf("responseKey:") + 12).replace("])", "");
                }
            }
        }
        return str;
    }
}
