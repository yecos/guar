package retrofit2.converter.simplexml;

import java.io.OutputStreamWriter;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import org.simpleframework.xml.Serializer;
import retrofit2.Converter;

/* loaded from: classes2.dex */
final class SimpleXmlRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final String CHARSET = "UTF-8";
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/xml; charset=UTF-8");
    private final Serializer serializer;

    public SimpleXmlRequestBodyConverter(Serializer serializer) {
        this.serializer = serializer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ RequestBody convert(Object obj) {
        return convert((SimpleXmlRequestBodyConverter<T>) obj);
    }

    @Override // retrofit2.Converter
    public RequestBody convert(T t10) {
        Buffer buffer = new Buffer();
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(buffer.outputStream(), "UTF-8");
            this.serializer.write(t10, outputStreamWriter);
            outputStreamWriter.flush();
            return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }
}
