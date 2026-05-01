package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Locator;
import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
public class LocatorFunction<T> implements Function<Header, T> {
    private final Locator<T> locator;

    public LocatorFunction(Locator<T> locator) {
        this.locator = (Locator) Assert.notNull(locator, "Locator instance cannot be null.");
    }

    @Override // io.jsonwebtoken.impl.lang.Function
    public T apply(Header header) {
        return this.locator.locate(header);
    }
}
