package io.jsonwebtoken;

import io.jsonwebtoken.HeaderMutator;
import io.jsonwebtoken.lang.MapMutator;

/* loaded from: classes3.dex */
public interface HeaderMutator<T extends HeaderMutator<T>> extends MapMutator<String, Object, T> {
    T contentType(String str);

    @Deprecated
    T setCompressionAlgorithm(String str);

    @Deprecated
    T setContentType(String str);

    @Deprecated
    T setType(String str);

    T type(String str);
}
