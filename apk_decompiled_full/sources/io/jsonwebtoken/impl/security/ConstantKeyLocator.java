package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.JweHeader;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.LocatorAdapter;
import io.jsonwebtoken.impl.lang.Function;
import java.security.Key;

/* loaded from: classes3.dex */
public class ConstantKeyLocator extends LocatorAdapter<Key> implements Function<Header, Key> {
    private final Key jweKey;
    private final Key jwsKey;

    public ConstantKeyLocator(Key key, Key key2) {
        this.jwsKey = key;
        this.jweKey = key2;
    }

    @Override // io.jsonwebtoken.impl.lang.Function
    public Key apply(Header header) {
        return locate(header);
    }

    @Override // io.jsonwebtoken.LocatorAdapter
    public Key locate(JwsHeader jwsHeader) {
        return this.jwsKey;
    }

    @Override // io.jsonwebtoken.LocatorAdapter
    public Key locate(JweHeader jweHeader) {
        return this.jweKey;
    }
}
