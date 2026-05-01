package com.hpplay.a.a.a.e;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    private final File f7324a;

    /* renamed from: b, reason: collision with root package name */
    private final OutputStream f7325b;

    public a(File file) {
        File createTempFile = File.createTempFile("NanoHTTPD-", "", file);
        this.f7324a = createTempFile;
        this.f7325b = new FileOutputStream(createTempFile);
    }

    @Override // com.hpplay.a.a.a.e.d
    public void a() {
        com.hpplay.a.a.a.d.safeClose(this.f7325b);
        if (this.f7324a.delete()) {
            return;
        }
        throw new Exception("could not delete temporary file: " + this.f7324a.getAbsolutePath());
    }

    @Override // com.hpplay.a.a.a.e.d
    public String b() {
        return this.f7324a.getAbsolutePath();
    }

    @Override // com.hpplay.a.a.a.e.d
    public OutputStream c() {
        return this.f7325b;
    }
}
