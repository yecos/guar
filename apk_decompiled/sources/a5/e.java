package a5;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class e {
    public static byte[] a(File file, int i10) {
        ByteBuffer byteBuffer;
        Map b10 = b(file);
        if (b10 == null || (byteBuffer = (ByteBuffer) b10.get(Integer.valueOf(i10))) == null) {
            return null;
        }
        return c(byteBuffer);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        if (r1 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map b(java.io.File r3) {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L3a
            java.lang.String r2 = "r"
            r1.<init>(r3, r2)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L3a
            java.nio.channels.FileChannel r3 = r1.getChannel()     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L28
            a5.d r2 = a5.a.b(r3)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L3c
            java.lang.Object r2 = r2.a()     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L3c
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L3c
            java.util.Map r0 = a5.a.f(r2)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L3c
            if (r3 == 0) goto L1f
            r3.close()     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L46
        L1f:
            r1.close()     // Catch: java.lang.Throwable -> L46
            goto L46
        L23:
            r2 = move-exception
            goto L2d
        L25:
            r2 = move-exception
            r3 = r0
            goto L2d
        L28:
            r3 = r0
            goto L3c
        L2a:
            r2 = move-exception
            r3 = r0
            r1 = r3
        L2d:
            if (r3 == 0) goto L34
            r3.close()     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L46
            goto L34
        L33:
        L34:
            if (r1 == 0) goto L39
            r1.close()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L46
        L39:
            throw r2     // Catch: java.lang.Throwable -> L46
        L3a:
            r3 = r0
            r1 = r3
        L3c:
            if (r3 == 0) goto L43
            r3.close()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L46
            goto L43
        L42:
        L43:
            if (r1 == 0) goto L46
            goto L1f
        L46:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.e.b(java.io.File):java.util.Map");
    }

    public static byte[] c(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        return Arrays.copyOfRange(array, byteBuffer.position() + arrayOffset, arrayOffset + byteBuffer.limit());
    }

    public static String d(File file, int i10) {
        byte[] a10 = a(file, i10);
        if (a10 == null) {
            return null;
        }
        try {
            return new String(a10, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
