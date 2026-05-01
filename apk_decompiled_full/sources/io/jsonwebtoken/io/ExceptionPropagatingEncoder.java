package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
class ExceptionPropagatingEncoder<T, R> implements Encoder<T, R> {
    private final Encoder<T, R> encoder;

    public ExceptionPropagatingEncoder(Encoder<T, R> encoder) {
        Assert.notNull(encoder, "Encoder cannot be null.");
        this.encoder = encoder;
    }

    @Override // io.jsonwebtoken.io.Encoder
    public R encode(T t10) {
        Assert.notNull(t10, "Encode argument cannot be null.");
        try {
            return this.encoder.encode(t10);
        } catch (EncodingException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new EncodingException("Unable to encode input: " + e11.getMessage(), e11);
        }
    }
}
