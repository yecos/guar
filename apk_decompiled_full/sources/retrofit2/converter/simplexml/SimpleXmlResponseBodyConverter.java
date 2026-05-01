package retrofit2.converter.simplexml;

import java.io.IOException;
import okhttp3.ResponseBody;
import org.simpleframework.xml.Serializer;
import retrofit2.Converter;

/* loaded from: classes2.dex */
final class SimpleXmlResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Class<T> cls;
    private final Serializer serializer;
    private final boolean strict;

    public SimpleXmlResponseBodyConverter(Class<T> cls, Serializer serializer, boolean z10) {
        this.cls = cls;
        this.serializer = serializer;
        this.strict = z10;
    }

    @Override // retrofit2.Converter
    public T convert(ResponseBody responseBody) {
        try {
            try {
                T t10 = (T) this.serializer.read((Class) this.cls, responseBody.charStream(), this.strict);
                if (t10 != null) {
                    return t10;
                }
                throw new IllegalStateException("Could not deserialize body as " + this.cls);
            } catch (IOException e10) {
                throw e10;
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception e12) {
                throw new RuntimeException(e12);
            }
        } finally {
            responseBody.close();
        }
    }
}
