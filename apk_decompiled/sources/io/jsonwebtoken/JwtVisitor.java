package io.jsonwebtoken;

/* loaded from: classes3.dex */
public interface JwtVisitor<T> {
    T visit(Jwe<?> jwe);

    T visit(Jws<?> jws);

    T visit(Jwt<?, ?> jwt);
}
