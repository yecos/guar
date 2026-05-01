package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import java.io.InputStream;

@Deprecated
/* loaded from: classes3.dex */
public class DelegateStringDecoder implements Decoder<InputStream, InputStream> {
    private final Decoder<CharSequence, byte[]> delegate;

    public DelegateStringDecoder(Decoder<CharSequence, byte[]> decoder) {
        this.delegate = (Decoder) Assert.notNull(decoder, "delegate cannot be null.");
    }

    @Override // io.jsonwebtoken.io.Decoder
    public InputStream decode(InputStream inputStream) {
        try {
            return Streams.of(this.delegate.decode(Strings.utf8(Streams.bytes(inputStream, "Unable to Base64URL-decode input."))));
        } catch (Throwable th) {
            throw new DecodingException("Unable to Base64Url-decode InputStream: " + th.getMessage(), th);
        }
    }
}
