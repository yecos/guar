package io.jsonwebtoken.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.io.Streams;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.io.CompressionAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Strings;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
class Payload {
    static final Payload EMPTY = new Payload(Bytes.EMPTY, (String) null);
    private final byte[] bytes;
    private final Claims claims;
    private boolean claimsExpected;
    private final String contentType;
    private final InputStream inputStream;
    private final boolean inputStreamEmpty;
    private final CharSequence string;
    private CompressionAlgorithm zip;

    public Payload(Claims claims) {
        this(claims, null, null, null, null);
    }

    public OutputStream compress(OutputStream outputStream) {
        CompressionAlgorithm compressionAlgorithm = this.zip;
        return compressionAlgorithm != null ? compressionAlgorithm.compress(outputStream) : outputStream;
    }

    public Payload decompress(CompressionAlgorithm compressionAlgorithm) {
        Payload payload;
        Assert.notNull(compressionAlgorithm, "CompressionAlgorithm cannot be null.");
        if (isString() || !isConsumable()) {
            return this;
        }
        if (!compressionAlgorithm.equals(Jwts.ZIP.DEF) || Bytes.isEmpty(this.bytes)) {
            payload = new Payload(this.claims, this.string, this.bytes, compressionAlgorithm.decompress(toInputStream()), getContentType());
        } else {
            payload = new Payload(this.claims, this.string, ((CompressionCodec) compressionAlgorithm).decompress(this.bytes), null, getContentType());
        }
        payload.setClaimsExpected(this.claimsExpected);
        return payload;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public String getContentType() {
        return this.contentType;
    }

    public Claims getRequiredClaims() {
        return (Claims) Assert.notEmpty(this.claims, "Claims cannot be null or empty when calling this method.");
    }

    public boolean isClaims() {
        return !Collections.isEmpty(this.claims);
    }

    public boolean isCompressed() {
        return this.zip != null;
    }

    public boolean isConsumable() {
        return !isClaims() && (isString() || !Bytes.isEmpty(this.bytes) || (this.inputStream != null && this.claimsExpected));
    }

    public boolean isEmpty() {
        return !isClaims() && !isString() && Bytes.isEmpty(this.bytes) && this.inputStreamEmpty;
    }

    public boolean isString() {
        return Strings.hasText(this.string);
    }

    public void setClaimsExpected(boolean z10) {
        this.claimsExpected = z10;
    }

    public void setZip(CompressionAlgorithm compressionAlgorithm) {
        this.zip = compressionAlgorithm;
    }

    public InputStream toInputStream() {
        Assert.state(!isClaims(), "Claims exist, cannot convert to InputStream directly.");
        return this.inputStream;
    }

    public Payload(CharSequence charSequence, String str) {
        this(null, charSequence, null, null, str);
    }

    public Payload(byte[] bArr, String str) {
        this(null, null, bArr, null, str);
    }

    public Payload(InputStream inputStream, String str) {
        this(null, null, null, inputStream, str);
    }

    private Payload(Claims claims, CharSequence charSequence, byte[] bArr, InputStream inputStream, String str) {
        this.claims = claims;
        CharSequence clean = Strings.clean(charSequence);
        this.string = clean;
        this.contentType = Strings.clean(str);
        byte[] utf8 = Strings.hasText(clean) ? Strings.utf8(clean) : Bytes.nullSafe(bArr);
        this.bytes = utf8;
        if (inputStream == null && !Bytes.isEmpty(utf8)) {
            inputStream = Streams.of(utf8);
        }
        boolean z10 = inputStream == null;
        this.inputStreamEmpty = z10;
        this.inputStream = z10 ? Streams.of(Bytes.EMPTY) : inputStream;
    }
}
