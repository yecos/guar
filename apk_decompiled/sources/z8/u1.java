package z8;

import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.cybergarage.http.HTTP;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public abstract class u1 {

    /* renamed from: a, reason: collision with root package name */
    public static final t1 f20952a = new c(new byte[0]);

    public class a extends n0 {
        public a(t1 t1Var) {
            super(t1Var);
        }

        @Override // z8.t1, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    public static class c extends z8.c {

        /* renamed from: a, reason: collision with root package name */
        public int f20954a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20955b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f20956c;

        /* renamed from: d, reason: collision with root package name */
        public int f20957d;

        public c(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // z8.t1
        public void C(byte[] bArr, int i10, int i11) {
            System.arraycopy(this.f20956c, this.f20954a, bArr, i10, i11);
            this.f20954a += i11;
        }

        @Override // z8.c, z8.t1
        public void D() {
            this.f20957d = this.f20954a;
        }

        @Override // z8.t1
        public void H(OutputStream outputStream, int i10) {
            a(i10);
            outputStream.write(this.f20956c, this.f20954a, i10);
            this.f20954a += i10;
        }

        @Override // z8.t1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c j(int i10) {
            a(i10);
            int i11 = this.f20954a;
            this.f20954a = i11 + i10;
            return new c(this.f20956c, i11, i10);
        }

        @Override // z8.t1
        public int h() {
            return this.f20955b - this.f20954a;
        }

        @Override // z8.c, z8.t1
        public boolean markSupported() {
            return true;
        }

        @Override // z8.t1
        public void r(ByteBuffer byteBuffer) {
            Preconditions.checkNotNull(byteBuffer, "dest");
            int remaining = byteBuffer.remaining();
            a(remaining);
            byteBuffer.put(this.f20956c, this.f20954a, remaining);
            this.f20954a += remaining;
        }

        @Override // z8.t1
        public int readUnsignedByte() {
            a(1);
            byte[] bArr = this.f20956c;
            int i10 = this.f20954a;
            this.f20954a = i10 + 1;
            return bArr[i10] & UnsignedBytes.MAX_VALUE;
        }

        @Override // z8.c, z8.t1
        public void reset() {
            int i10 = this.f20957d;
            if (i10 == -1) {
                throw new InvalidMarkException();
            }
            this.f20954a = i10;
        }

        @Override // z8.t1
        public void skipBytes(int i10) {
            a(i10);
            this.f20954a += i10;
        }

        public c(byte[] bArr, int i10, int i11) {
            this.f20957d = -1;
            Preconditions.checkArgument(i10 >= 0, "offset must be >= 0");
            Preconditions.checkArgument(i11 >= 0, "length must be >= 0");
            int i12 = i11 + i10;
            Preconditions.checkArgument(i12 <= bArr.length, "offset + length exceeds array boundary");
            this.f20956c = (byte[]) Preconditions.checkNotNull(bArr, HTTP.CONTENT_RANGE_BYTES);
            this.f20954a = i10;
            this.f20955b = i12;
        }
    }

    public static t1 a() {
        return f20952a;
    }

    public static t1 b(t1 t1Var) {
        return new a(t1Var);
    }

    public static InputStream c(t1 t1Var, boolean z10) {
        if (!z10) {
            t1Var = b(t1Var);
        }
        return new b(t1Var);
    }

    public static byte[] d(t1 t1Var) {
        Preconditions.checkNotNull(t1Var, "buffer");
        int h10 = t1Var.h();
        byte[] bArr = new byte[h10];
        t1Var.C(bArr, 0, h10);
        return bArr;
    }

    public static String e(t1 t1Var, Charset charset) {
        Preconditions.checkNotNull(charset, HTTP.CHARSET);
        return new String(d(t1Var), charset);
    }

    public static t1 f(byte[] bArr, int i10, int i11) {
        return new c(bArr, i10, i11);
    }

    public static final class b extends InputStream implements y8.n0 {

        /* renamed from: a, reason: collision with root package name */
        public t1 f20953a;

        public b(t1 t1Var) {
            this.f20953a = (t1) Preconditions.checkNotNull(t1Var, "buffer");
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f20953a.h();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f20953a.close();
        }

        @Override // java.io.InputStream
        public void mark(int i10) {
            this.f20953a.D();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.f20953a.markSupported();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f20953a.h() == 0) {
                return -1;
            }
            return this.f20953a.readUnsignedByte();
        }

        @Override // java.io.InputStream
        public void reset() {
            this.f20953a.reset();
        }

        @Override // java.io.InputStream
        public long skip(long j10) {
            int min = (int) Math.min(this.f20953a.h(), j10);
            this.f20953a.skipBytes(min);
            return min;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            if (this.f20953a.h() == 0) {
                return -1;
            }
            int min = Math.min(this.f20953a.h(), i11);
            this.f20953a.C(bArr, i10, min);
            return min;
        }
    }
}
