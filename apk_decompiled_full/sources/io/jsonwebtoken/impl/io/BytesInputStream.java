package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.impl.lang.Bytes;
import java.io.ByteArrayInputStream;

/* loaded from: classes3.dex */
public final class BytesInputStream extends ByteArrayInputStream {
    public BytesInputStream(byte[] bArr) {
        super(Bytes.isEmpty(bArr) ? Bytes.EMPTY : bArr);
    }

    @Override // java.io.ByteArrayInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        reset();
    }

    public byte[] getBytes() {
        return ((ByteArrayInputStream) this).buf;
    }
}
