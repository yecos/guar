package io.jsonwebtoken.impl.security;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.jsonwebtoken.impl.ParameterMap;
import io.jsonwebtoken.impl.lang.Converter;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.JwkSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class DefaultJwkSet extends ParameterMap implements JwkSet {
    static final Parameter<Set<Jwk<?>>> KEYS = param(JwkConverter.ANY);
    private static final String NAME = "JWK Set";

    public DefaultJwkSet(Parameter<Set<Jwk<?>>> parameter, Map<String, ?> map) {
        super(Parameters.registry((Parameter<?>[]) new Parameter[]{parameter}), map);
    }

    public static Parameter<Set<Jwk<?>>> param(Converter<Jwk<?>, ?> converter) {
        return (Parameter) Parameters.builder(JwkConverter.JWK_CLASS).setConverter(converter).set().setId(UserMetadata.KEYDATA_FILENAME).setName("JSON Web Keys").setSecret(true).build();
    }

    @Override // io.jsonwebtoken.security.JwkSet
    public Set<Jwk<?>> getKeys() {
        Set set = (Set) get((Parameter) KEYS);
        return Collections.isEmpty(set) ? Collections.emptySet() : Collections.immutable(set);
    }

    @Override // io.jsonwebtoken.impl.ParameterMap, io.jsonwebtoken.impl.lang.Nameable
    public String getName() {
        return NAME;
    }

    @Override // java.lang.Iterable
    public Iterator<Jwk<?>> iterator() {
        return getKeys().iterator();
    }
}
