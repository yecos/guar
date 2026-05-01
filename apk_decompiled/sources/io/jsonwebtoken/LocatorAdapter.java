package io.jsonwebtoken;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
public abstract class LocatorAdapter<T> implements Locator<T> {
    public T doLocate(Header header) {
        return null;
    }

    public T locate(JweHeader jweHeader) {
        return null;
    }

    public T locate(JwsHeader jwsHeader) {
        return null;
    }

    @Override // io.jsonwebtoken.Locator
    public final T locate(Header header) {
        Assert.notNull(header, "Header cannot be null.");
        if (header instanceof ProtectedHeader) {
            return locate((ProtectedHeader) header);
        }
        return doLocate(header);
    }

    public T locate(ProtectedHeader protectedHeader) {
        if (protectedHeader instanceof JwsHeader) {
            return locate((JwsHeader) protectedHeader);
        }
        Assert.isInstanceOf(JweHeader.class, protectedHeader, "Unrecognized ProtectedHeader type.");
        return locate((JweHeader) protectedHeader);
    }
}
