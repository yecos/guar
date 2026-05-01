package u7;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;

/* loaded from: classes3.dex */
public abstract class c {
    public abstract int a();

    public abstract int b();

    public abstract void c(PushbackInputStream pushbackInputStream, OutputStream outputStream, int i10);

    public void d(InputStream inputStream, OutputStream outputStream) {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
        f(pushbackInputStream, outputStream);
        while (true) {
            try {
                int h10 = h(pushbackInputStream, outputStream);
                int i10 = 0;
                while (a() + i10 < h10) {
                    c(pushbackInputStream, outputStream, a());
                    i10 += a();
                }
                if (a() + i10 == h10) {
                    c(pushbackInputStream, outputStream, a());
                } else {
                    c(pushbackInputStream, outputStream, h10 - i10);
                }
                i(pushbackInputStream, outputStream);
            } catch (b unused) {
                g(pushbackInputStream, outputStream);
                return;
            }
        }
    }

    public byte[] e(String str) {
        byte[] bArr = new byte[str.length()];
        str.getBytes(0, str.length(), bArr, 0);
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        d(byteArrayInputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public void f(PushbackInputStream pushbackInputStream, OutputStream outputStream) {
    }

    public void g(PushbackInputStream pushbackInputStream, OutputStream outputStream) {
    }

    public int h(PushbackInputStream pushbackInputStream, OutputStream outputStream) {
        return b();
    }

    public void i(PushbackInputStream pushbackInputStream, OutputStream outputStream) {
    }

    public int j(InputStream inputStream, byte[] bArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            int read = inputStream.read();
            if (read == -1) {
                if (i12 == 0) {
                    return -1;
                }
                return i12;
            }
            bArr[i12 + i10] = (byte) read;
        }
        return i11;
    }
}
