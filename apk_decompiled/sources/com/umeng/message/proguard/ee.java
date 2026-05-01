package com.umeng.message.proguard;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

/* loaded from: classes3.dex */
public final class ee {
    public static void a(byte[] bArr, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2 = null;
        try {
            gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read == -1) {
                    eb.a(gZIPInputStream);
                    return;
                }
                outputStream.write(bArr2, 0, read);
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPInputStream2 = gZIPInputStream;
            try {
                ce.d("unzip", th.getMessage());
            } finally {
                eb.a(gZIPInputStream2);
            }
        }
    }
}
