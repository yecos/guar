package j3;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class c extends OutputStream {

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f14637f = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final a f14638a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList f14639b;

    /* renamed from: c, reason: collision with root package name */
    public int f14640c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f14641d;

    /* renamed from: e, reason: collision with root package name */
    public int f14642e;

    public c() {
        this((a) null);
    }

    public static c n(byte[] bArr, int i10) {
        return new c(null, bArr, i10);
    }

    public final void a() {
        int length = this.f14640c + this.f14641d.length;
        if (length < 0) {
            throw new IllegalStateException("Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`");
        }
        this.f14640c = length;
        int max = Math.max(length >> 1, 1000);
        if (max > 131072) {
            max = 131072;
        }
        this.f14639b.add(this.f14641d);
        this.f14641d = new byte[max];
        this.f14642e = 0;
    }

    public void b(int i10) {
        if (this.f14642e >= this.f14641d.length) {
            a();
        }
        byte[] bArr = this.f14641d;
        int i11 = this.f14642e;
        this.f14642e = i11 + 1;
        bArr[i11] = (byte) i10;
    }

    public void c(int i10) {
        int i11 = this.f14642e;
        int i12 = i11 + 2;
        byte[] bArr = this.f14641d;
        if (i12 >= bArr.length) {
            b(i10 >> 16);
            b(i10 >> 8);
            b(i10);
        } else {
            int i13 = i11 + 1;
            bArr[i11] = (byte) (i10 >> 16);
            int i14 = i13 + 1;
            bArr[i13] = (byte) (i10 >> 8);
            this.f14642e = i14 + 1;
            bArr[i14] = (byte) i10;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void e(int i10) {
        int i11 = this.f14642e;
        int i12 = i11 + 1;
        byte[] bArr = this.f14641d;
        if (i12 >= bArr.length) {
            b(i10 >> 8);
            b(i10);
        } else {
            int i13 = i11 + 1;
            bArr[i11] = (byte) (i10 >> 8);
            this.f14642e = i13 + 1;
            bArr[i13] = (byte) i10;
        }
    }

    public byte[] f(int i10) {
        this.f14642e = i10;
        return v();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    public byte[] m() {
        a();
        return this.f14641d;
    }

    public byte[] q() {
        return this.f14641d;
    }

    public void reset() {
        this.f14640c = 0;
        this.f14642e = 0;
        if (this.f14639b.isEmpty()) {
            return;
        }
        this.f14639b.clear();
    }

    public int s() {
        return this.f14642e;
    }

    public void u(int i10) {
        this.f14642e = i10;
    }

    public byte[] v() {
        int i10 = this.f14640c + this.f14642e;
        if (i10 == 0) {
            return f14637f;
        }
        byte[] bArr = new byte[i10];
        Iterator it = this.f14639b.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) it.next();
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i11, length);
            i11 += length;
        }
        System.arraycopy(this.f14641d, 0, bArr, i11, this.f14642e);
        int i12 = i11 + this.f14642e;
        if (i12 == i10) {
            if (!this.f14639b.isEmpty()) {
                reset();
            }
            return bArr;
        }
        throw new RuntimeException("Internal error: total len assumed to be " + i10 + ", copied " + i12 + " bytes");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public c(a aVar) {
        this(aVar, 500);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        while (true) {
            int min = Math.min(this.f14641d.length - this.f14642e, i11);
            if (min > 0) {
                System.arraycopy(bArr, i10, this.f14641d, this.f14642e, min);
                i10 += min;
                this.f14642e += min;
                i11 -= min;
            }
            if (i11 <= 0) {
                return;
            } else {
                a();
            }
        }
    }

    public c(int i10) {
        this(null, i10);
    }

    public c(a aVar, int i10) {
        this.f14639b = new LinkedList();
        this.f14638a = aVar;
        this.f14641d = aVar == null ? new byte[i10 > 131072 ? 131072 : i10] : aVar.a(2);
    }

    @Override // java.io.OutputStream
    public void write(int i10) {
        b(i10);
    }

    public c(a aVar, byte[] bArr, int i10) {
        this.f14639b = new LinkedList();
        this.f14638a = null;
        this.f14641d = bArr;
        this.f14642e = i10;
    }
}
