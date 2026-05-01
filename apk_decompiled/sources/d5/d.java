package d5;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public class d extends Converter.Factory {
    @Override // retrofit2.Converter.Factory
    public Converter responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new a();
    }
}
