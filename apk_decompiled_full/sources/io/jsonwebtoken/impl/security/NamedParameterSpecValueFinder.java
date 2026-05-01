package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.impl.lang.Functions;
import io.jsonwebtoken.impl.lang.OptionalMethodInvoker;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: classes3.dex */
public class NamedParameterSpecValueFinder implements Function<Key, String> {
    private static final Function<Key, String> COMPOSED;
    private static final Function<Key, AlgorithmParameterSpec> EDEC_KEY_GET_PARAMS;
    private static final Function<Object, String> GET_NAME;
    private static final Function<Key, AlgorithmParameterSpec> XEC_KEY_GET_PARAMS;

    static {
        OptionalMethodInvoker optionalMethodInvoker = new OptionalMethodInvoker("java.security.interfaces.EdECKey", "getParams");
        EDEC_KEY_GET_PARAMS = optionalMethodInvoker;
        OptionalMethodInvoker optionalMethodInvoker2 = new OptionalMethodInvoker("java.security.interfaces.XECKey", "getParams");
        XEC_KEY_GET_PARAMS = optionalMethodInvoker2;
        OptionalMethodInvoker optionalMethodInvoker3 = new OptionalMethodInvoker("java.security.spec.NamedParameterSpec", "getName");
        GET_NAME = optionalMethodInvoker3;
        COMPOSED = Functions.andThen(Functions.firstResult(optionalMethodInvoker, optionalMethodInvoker2), optionalMethodInvoker3);
    }

    @Override // io.jsonwebtoken.impl.lang.Function
    public String apply(Key key) {
        return COMPOSED.apply(key);
    }
}
