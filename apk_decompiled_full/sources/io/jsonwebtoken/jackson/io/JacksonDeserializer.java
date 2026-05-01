package io.jsonwebtoken.jackson.io;

import c3.k;
import com.fasterxml.jackson.databind.deser.std.m0;
import io.jsonwebtoken.io.AbstractDeserializer;
import io.jsonwebtoken.lang.Assert;
import java.io.Reader;
import java.util.Collections;
import java.util.Map;
import k3.g;
import k3.j;
import k3.t;
import y3.b;

/* loaded from: classes3.dex */
public class JacksonDeserializer<T> extends AbstractDeserializer<T> {
    private final t objectMapper;
    private final Class<T> returnType;

    public static class MappedTypeDeserializer extends m0 {
        private final Map<String, Class<?>> claimTypeMap;

        @Override // com.fasterxml.jackson.databind.deser.std.m0, k3.k
        public Object deserialize(k kVar, g gVar) {
            String m10 = kVar.m();
            Map<String, Class<?>> map = this.claimTypeMap;
            if (map == null || m10 == null || !map.containsKey(m10)) {
                return super.deserialize(kVar, gVar);
            }
            return kVar.y0().c(kVar.y()).x0(this.claimTypeMap.get(m10));
        }

        private MappedTypeDeserializer(Map<String, Class<?>> map) {
            super((j) null, (j) null);
            this.claimTypeMap = map;
        }
    }

    public JacksonDeserializer() {
        this(JacksonSerializer.DEFAULT_OBJECT_MAPPER);
    }

    @Override // io.jsonwebtoken.io.AbstractDeserializer
    public T doDeserialize(Reader reader) {
        return (T) this.objectMapper.z(reader, this.returnType);
    }

    public JacksonDeserializer(Map<String, Class<?>> map) {
        this(JacksonSerializer.newObjectMapper(), map);
    }

    public JacksonDeserializer(t tVar) {
        this(tVar, Object.class);
    }

    private JacksonDeserializer(t tVar, Map<String, Class<?>> map) {
        this(tVar);
        Assert.notNull(map, "Claim type map cannot be null.");
        b bVar = new b();
        bVar.g(Object.class, new MappedTypeDeserializer(Collections.unmodifiableMap(map)));
        tVar.B(bVar);
    }

    private JacksonDeserializer(t tVar, Class<T> cls) {
        Assert.notNull(tVar, "ObjectMapper cannot be null.");
        Assert.notNull(cls, "Return type cannot be null.");
        this.objectMapper = tVar;
        this.returnType = cls;
    }
}
