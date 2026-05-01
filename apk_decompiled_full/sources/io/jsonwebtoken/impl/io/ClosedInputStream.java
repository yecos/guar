package io.jsonwebtoken.impl.io;

import java.io.InputStream;

/* loaded from: classes3.dex */
public final class ClosedInputStream extends InputStream {
    public static final ClosedInputStream INSTANCE = new ClosedInputStream();

    private ClosedInputStream() {
    }

    @Override // java.io.InputStream
    public int read() {
        return -1;
    }
}
