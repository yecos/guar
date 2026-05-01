package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.io.Parser;
import io.jsonwebtoken.lang.Assert;
import java.io.InputStream;

/* loaded from: classes3.dex */
public abstract class AbstractParser<T> implements Parser<T> {
    @Override // io.jsonwebtoken.io.Parser
    public final T parse(CharSequence charSequence) {
        Assert.hasText(charSequence, "CharSequence cannot be null or empty.");
        return parse(charSequence, 0, charSequence.length());
    }

    @Override // io.jsonwebtoken.io.Parser
    public T parse(CharSequence charSequence, int i10, int i11) {
        Assert.hasText(charSequence, "CharSequence cannot be null or empty.");
        return parse(new CharSequenceReader(charSequence, i10, i11));
    }

    @Override // io.jsonwebtoken.io.Parser
    public final T parse(InputStream inputStream) {
        Assert.notNull(inputStream, "InputStream cannot be null.");
        return parse(Streams.reader(inputStream));
    }
}
