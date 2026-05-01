package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Converter;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Supplier;
import io.jsonwebtoken.security.DynamicJwkBuilder;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.JwkSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class JwkSetConverter implements Converter<JwkSet, Object> {
    private final Converter<Jwk<?>, Object> JWK_CONVERTER;
    private final Parameter<Set<Jwk<?>>> PARAM;
    private final boolean ignoreUnsupported;

    public JwkSetConverter() {
        this((Supplier<DynamicJwkBuilder<?, ?>>) JwkBuilderSupplier.DEFAULT, true);
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public Object applyTo(JwkSet jwkSet) {
        return jwkSet;
    }

    public boolean isIgnoreUnsupported() {
        return this.ignoreUnsupported;
    }

    public JwkSetConverter(boolean z10) {
        this(JwkBuilderSupplier.DEFAULT, z10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f8 A[SYNTHETIC] */
    @Override // io.jsonwebtoken.impl.lang.Converter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.jsonwebtoken.security.JwkSet applyFrom(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.JwkSetConverter.applyFrom(java.lang.Object):io.jsonwebtoken.security.JwkSet");
    }

    public JwkSetConverter(Supplier<DynamicJwkBuilder<?, ?>> supplier, boolean z10) {
        this(new JwkConverter(supplier), z10);
    }

    public JwkSetConverter(Converter<Jwk<?>, Object> converter, boolean z10) {
        this.JWK_CONVERTER = (Converter) Assert.notNull(converter, "JWK converter cannot be null.");
        this.PARAM = DefaultJwkSet.param(converter);
        this.ignoreUnsupported = z10;
    }
}
