package ia;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import ma.i;
import mobile.com.requestframe.utils.bean.BaseResponse;
import mobile.com.requestframe.utils.bean.EncryptJsonBean;
import mobile.com.requestframe.utils.bean.ResultException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: classes3.dex */
public final class d implements Converter {

    /* renamed from: a, reason: collision with root package name */
    public final String f14416a = "response";

    /* renamed from: b, reason: collision with root package name */
    public final Gson f14417b;

    /* renamed from: c, reason: collision with root package name */
    public final TypeAdapter f14418c;

    /* renamed from: d, reason: collision with root package name */
    public final Type f14419d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f14420e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14421f;

    /* renamed from: g, reason: collision with root package name */
    public final String f14422g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f14423h;

    public d(Gson gson, TypeAdapter typeAdapter, Type type, String str, Annotation[] annotationArr) {
        this.f14417b = gson;
        this.f14418c = typeAdapter;
        this.f14419d = type;
        this.f14420e = d(annotationArr);
        this.f14421f = f(annotationArr);
        this.f14422g = c(annotationArr, str);
        this.f14423h = e(annotationArr);
    }

    @Override // retrofit2.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object convert(ResponseBody responseBody) {
        String string = responseBody.string();
        try {
            if (this.f14420e) {
                return this.f14417b.fromJson(string, this.f14419d);
            }
            BaseResponse baseResponse = (BaseResponse) this.f14417b.fromJson(string, BaseResponse.class);
            if (!this.f14421f) {
                return b(string);
            }
            if ("0".equals(baseResponse.getReturnCode())) {
                return b(string);
            }
            EncryptJsonBean encryptJsonBean = (EncryptJsonBean) this.f14417b.fromJson(string, EncryptJsonBean.class);
            throw new ResultException(baseResponse.getReturnCode(), baseResponse.getErrorMessage(), !TextUtils.isEmpty(encryptJsonBean.getData()) ? i.a(encryptJsonBean.getData(), this.f14422g) : null);
        } finally {
            responseBody.close();
        }
    }

    public final Object b(String str) {
        if (!i.h() || !this.f14423h) {
            return this.f14417b.fromJson(str, this.f14419d);
        }
        EncryptJsonBean encryptJsonBean = (EncryptJsonBean) this.f14417b.fromJson(str, EncryptJsonBean.class);
        return this.f14417b.fromJson(str.replace("\"" + encryptJsonBean.getData() + "\"", i.a(encryptJsonBean.getData(), this.f14422g)), this.f14419d);
    }

    public final String c(Annotation[] annotationArr, String str) {
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

    public final boolean d(Annotation[] annotationArr) {
        boolean z10 = false;
        for (Annotation annotation : annotationArr) {
            z10 = annotation.toString().contains("@retrofit2.http.GET");
            if (z10) {
                break;
            }
        }
        return z10;
    }

    public final boolean e(Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            if (annotation.toString().contains("needEncrypt:false")) {
                return false;
            }
        }
        return true;
    }

    public final boolean f(Annotation[] annotationArr) {
        if (annotationArr == null || annotationArr.length <= 0) {
            return true;
        }
        for (Annotation annotation : annotationArr) {
            if (annotation.toString().contains("ProcessResult:false")) {
                return false;
            }
        }
        return true;
    }
}
