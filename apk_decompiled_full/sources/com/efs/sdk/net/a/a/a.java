package com.efs.sdk.net.a.a;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class a extends FilterOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private long f6373a;

    public a(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i10) {
        ((FilterOutputStream) this).out.write(i10);
        this.f6373a++;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i10, int i11) {
        ((FilterOutputStream) this).out.write(bArr, i10, i11);
        this.f6373a += i11;
    }
}
