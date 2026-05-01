package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class ds extends du {

    /* renamed from: a, reason: collision with root package name */
    protected InputStream f10304a;

    /* renamed from: b, reason: collision with root package name */
    protected OutputStream f10305b;

    public ds() {
        this.f10304a = null;
        this.f10305b = null;
    }

    @Override // com.umeng.analytics.pro.du
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.du
    public void b() {
    }

    @Override // com.umeng.analytics.pro.du
    public void c() {
        InputStream inputStream = this.f10304a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            this.f10304a = null;
        }
        OutputStream outputStream = this.f10305b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            this.f10305b = null;
        }
    }

    @Override // com.umeng.analytics.pro.du
    public void d() {
        OutputStream outputStream = this.f10305b;
        if (outputStream == null) {
            throw new dv(1, "Cannot flush null outputStream");
        }
        try {
            outputStream.flush();
        } catch (IOException e10) {
            throw new dv(0, e10);
        }
    }

    @Override // com.umeng.analytics.pro.du
    public int a(byte[] bArr, int i10, int i11) {
        InputStream inputStream = this.f10304a;
        if (inputStream == null) {
            throw new dv(1, "Cannot read from null inputStream");
        }
        try {
            int read = inputStream.read(bArr, i10, i11);
            if (read >= 0) {
                return read;
            }
            throw new dv(4);
        } catch (IOException e10) {
            throw new dv(0, e10);
        }
    }

    @Override // com.umeng.analytics.pro.du
    public void b(byte[] bArr, int i10, int i11) {
        OutputStream outputStream = this.f10305b;
        if (outputStream == null) {
            throw new dv(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i10, i11);
        } catch (IOException e10) {
            throw new dv(0, e10);
        }
    }

    public ds(InputStream inputStream) {
        this.f10305b = null;
        this.f10304a = inputStream;
    }

    public ds(OutputStream outputStream) {
        this.f10304a = null;
        this.f10305b = outputStream;
    }

    public ds(InputStream inputStream, OutputStream outputStream) {
        this.f10304a = inputStream;
        this.f10305b = outputStream;
    }
}
