package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.impl.io.StandardCompressionAlgorithms;
import io.jsonwebtoken.impl.lang.CompactMediaTypeIdConverter;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.lang.Strings;
import java.util.Map;

/* loaded from: classes3.dex */
public class DefaultHeader extends ParameterMap implements Header {
    static final Parameter<String> ALGORITHM;
    static final Parameter<String> COMPRESSION_ALGORITHM;
    static final Parameter<String> CONTENT_TYPE;

    @Deprecated
    static final Parameter<String> DEPRECATED_COMPRESSION_ALGORITHM;
    static final Registry<String, Parameter<?>> PARAMS;
    static final Parameter<String> TYPE;

    static {
        Parameter<String> string = Parameters.string(Header.TYPE, "Type");
        TYPE = string;
        Parameter<String> parameter = (Parameter) Parameters.builder(String.class).setId(Header.CONTENT_TYPE).setName("Content Type").setConverter(CompactMediaTypeIdConverter.INSTANCE).build();
        CONTENT_TYPE = parameter;
        Parameter<String> string2 = Parameters.string("alg", "Algorithm");
        ALGORITHM = string2;
        Parameter<String> string3 = Parameters.string(Header.COMPRESSION_ALGORITHM, StandardCompressionAlgorithms.NAME);
        COMPRESSION_ALGORITHM = string3;
        Parameter<String> string4 = Parameters.string(Header.DEPRECATED_COMPRESSION_ALGORITHM, "Deprecated Compression Algorithm");
        DEPRECATED_COMPRESSION_ALGORITHM = string4;
        PARAMS = Parameters.registry((Parameter<?>[]) new Parameter[]{string, parameter, string2, string3, string4});
    }

    public DefaultHeader(Map<String, ?> map) {
        super(PARAMS, map);
    }

    @Override // io.jsonwebtoken.Header
    public String getAlgorithm() {
        return (String) get((Parameter) ALGORITHM);
    }

    @Override // io.jsonwebtoken.Header
    public String getCompressionAlgorithm() {
        String str = (String) get((Parameter) COMPRESSION_ALGORITHM);
        return !Strings.hasText(str) ? (String) get((Parameter) DEPRECATED_COMPRESSION_ALGORITHM) : str;
    }

    @Override // io.jsonwebtoken.Header
    public String getContentType() {
        return (String) get((Parameter) CONTENT_TYPE);
    }

    @Override // io.jsonwebtoken.impl.ParameterMap, io.jsonwebtoken.impl.lang.Nameable
    public String getName() {
        return "JWT header";
    }

    @Override // io.jsonwebtoken.Header
    public String getType() {
        return (String) get((Parameter) TYPE);
    }

    public DefaultHeader(Registry<String, Parameter<?>> registry, Map<String, ?> map) {
        super(registry, map);
    }
}
