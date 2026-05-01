package anet.channel.util;

import java.io.InputStream;

/* loaded from: classes.dex */
public class a extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private InputStream f4268a;

    /* renamed from: b, reason: collision with root package name */
    private long f4269b = 0;

    public a(InputStream inputStream) {
        this.f4268a = null;
        if (inputStream == null) {
            throw new NullPointerException("input stream cannot be null");
        }
        this.f4268a = inputStream;
    }

    public long a() {
        return this.f4269b;
    }

    @Override // java.io.InputStream
    public int read() {
        this.f4269b++;
        return this.f4268a.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        int read = this.f4268a.read(bArr, i10, i11);
        if (read != -1) {
            this.f4269b += read;
        }
        return read;
    }
}
