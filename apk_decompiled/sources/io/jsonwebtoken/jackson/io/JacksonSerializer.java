package io.jsonwebtoken.jackson.io;

import c3.h;
import c3.k;
import io.jsonwebtoken.io.AbstractSerializer;
import io.jsonwebtoken.lang.Assert;
import java.io.OutputStream;
import k3.h;
import k3.s;
import k3.t;
import y3.b;

/* loaded from: classes3.dex */
public class JacksonSerializer<T> extends AbstractSerializer<T> {
    static final t DEFAULT_OBJECT_MAPPER;
    static final s MODULE;
    static final String MODULE_ID = "jjwt-jackson";
    protected final t objectMapper;

    static {
        b bVar = new b(MODULE_ID);
        bVar.h(JacksonSupplierSerializer.INSTANCE);
        MODULE = bVar;
        DEFAULT_OBJECT_MAPPER = newObjectMapper();
    }

    public JacksonSerializer() {
        this(DEFAULT_OBJECT_MAPPER);
    }

    public static t newObjectMapper() {
        return new t().B(MODULE).o(k.a.STRICT_DUPLICATE_DETECTION, true).p(h.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override // io.jsonwebtoken.io.AbstractSerializer
    public void doSerialize(T t10, OutputStream outputStream) {
        Assert.notNull(outputStream, "OutputStream cannot be null.");
        this.objectMapper.D().l(h.b.AUTO_CLOSE_TARGET).m(outputStream, t10);
    }

    public JacksonSerializer(t tVar) {
        Assert.notNull(tVar, "ObjectMapper cannot be null.");
        this.objectMapper = tVar.B(MODULE);
    }
}
