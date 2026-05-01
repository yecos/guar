package io.jsonwebtoken.impl.io;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class UncloseableInputStream extends FilterInputStream {
    public UncloseableInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterInputStream) this).in = ClosedInputStream.INSTANCE;
    }
}
