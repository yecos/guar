package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.impl.lang.Converter;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
public class Codec implements Converter<byte[], CharSequence> {
    public static final Codec BASE64 = new Codec(Encoders.BASE64, Decoders.BASE64);
    public static final Codec BASE64URL = new Codec(Encoders.BASE64URL, Decoders.BASE64URL);
    private final Decoder<CharSequence, byte[]> decoder;
    private final Encoder<byte[], String> encoder;

    public Codec(Encoder<byte[], String> encoder, Decoder<CharSequence, byte[]> decoder) {
        this.encoder = (Encoder) Assert.notNull(encoder, "Encoder cannot be null.");
        this.decoder = (Decoder) Assert.notNull(decoder, "Decoder cannot be null.");
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public byte[] applyFrom(CharSequence charSequence) {
        try {
            return this.decoder.decode(charSequence);
        } catch (DecodingException e10) {
            throw new IllegalArgumentException("Cannot decode input String. Cause: " + e10.getMessage(), e10);
        }
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public String applyTo(byte[] bArr) {
        return this.encoder.encode(bArr);
    }
}
