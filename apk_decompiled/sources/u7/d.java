package u7;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public PrintStream f19070a;

    public abstract int a();

    public abstract int b();

    public String c(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            d(new ByteArrayInputStream(bArr), byteArrayOutputStream);
            return byteArrayOutputStream.toString("8859_1");
        } catch (Exception unused) {
            throw new Error("CharacterEncoder.encode internal error");
        }
    }

    public void d(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[b()];
        f(outputStream);
        while (true) {
            int j10 = j(inputStream, bArr);
            if (j10 == 0) {
                break;
            }
            h(outputStream, j10);
            int i10 = 0;
            while (i10 < j10) {
                if (a() + i10 <= j10) {
                    e(outputStream, bArr, i10, a());
                } else {
                    e(outputStream, bArr, i10, j10 - i10);
                }
                i10 += a();
            }
            if (j10 < b()) {
                break;
            } else {
                i(outputStream);
            }
        }
        g(outputStream);
    }

    public abstract void e(OutputStream outputStream, byte[] bArr, int i10, int i11);

    public void f(OutputStream outputStream) {
        this.f19070a = new PrintStream(outputStream);
    }

    public void g(OutputStream outputStream) {
    }

    public void h(OutputStream outputStream, int i10) {
    }

    public void i(OutputStream outputStream) {
        this.f19070a.println();
    }

    public int j(InputStream inputStream, byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int read = inputStream.read();
            if (read == -1) {
                return i10;
            }
            bArr[i10] = (byte) read;
        }
        return bArr.length;
    }
}
