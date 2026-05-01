package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.lang.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class DefaultJwtHeaderBuilder extends DefaultJweHeaderBuilder<Jwts.HeaderBuilder> implements Jwts.HeaderBuilder {
    public DefaultJwtHeaderBuilder() {
    }

    private static ParameterMap sanitizeCrit(ParameterMap parameterMap, boolean z10) {
        Parameter<Set<String>> parameter = DefaultProtectedHeader.CRIT;
        Set<String> set = (Set) parameterMap.get((Parameter) parameter);
        if (set == null) {
            return parameterMap;
        }
        ParameterMap parameterMap2 = new ParameterMap(DefaultJweHeader.PARAMS, parameterMap, true);
        parameterMap2.remove(parameter.getId());
        if (!z10) {
            return parameterMap2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        for (String str : set) {
            if (DefaultJweHeader.PARAMS.containsKey(str) || !parameterMap2.containsKey(str)) {
                linkedHashSet.remove(str);
            }
        }
        if (!Collections.isEmpty(linkedHashSet)) {
            parameterMap2.put((Parameter) DefaultProtectedHeader.CRIT, (Object) linkedHashSet);
        }
        return parameterMap2;
    }

    public DefaultJwtHeaderBuilder(DefaultJweHeaderMutator<?> defaultJweHeaderMutator) {
        super(defaultJweHeaderMutator);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.jsonwebtoken.lang.Builder
    public Header build() {
        this.x509.apply();
        ParameterMap parameterMap = (ParameterMap) this.DELEGATE;
        return DefaultJweHeader.isCandidate(parameterMap) ? new DefaultJweHeader(sanitizeCrit(parameterMap, true)) : DefaultProtectedHeader.isCandidate(parameterMap) ? new DefaultJwsHeader(sanitizeCrit(parameterMap, true)) : new DefaultHeader(sanitizeCrit(parameterMap, false));
    }
}
