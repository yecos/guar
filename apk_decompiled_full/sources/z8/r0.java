package z8;

import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

/* loaded from: classes3.dex */
public class r0 implements Closeable {

    /* renamed from: e, reason: collision with root package name */
    public int f20886e;

    /* renamed from: f, reason: collision with root package name */
    public int f20887f;

    /* renamed from: g, reason: collision with root package name */
    public Inflater f20888g;

    /* renamed from: j, reason: collision with root package name */
    public int f20891j;

    /* renamed from: k, reason: collision with root package name */
    public int f20892k;

    /* renamed from: l, reason: collision with root package name */
    public long f20893l;

    /* renamed from: a, reason: collision with root package name */
    public final u f20882a = new u();

    /* renamed from: b, reason: collision with root package name */
    public final CRC32 f20883b = new CRC32();

    /* renamed from: c, reason: collision with root package name */
    public final b f20884c = new b(this, null);

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f20885d = new byte[512];

    /* renamed from: h, reason: collision with root package name */
    public c f20889h = c.HEADER;

    /* renamed from: i, reason: collision with root package name */
    public boolean f20890i = false;

    /* renamed from: m, reason: collision with root package name */
    public int f20894m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f20895n = 0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f20896o = true;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20897a;

        static {
            int[] iArr = new int[c.values().length];
            f20897a = iArr;
            try {
                iArr[c.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20897a[c.HEADER_EXTRA_LEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20897a[c.HEADER_EXTRA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20897a[c.HEADER_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20897a[c.HEADER_COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20897a[c.HEADER_CRC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f20897a[c.INITIALIZE_INFLATER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f20897a[c.INFLATING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f20897a[c.INFLATER_NEEDS_INPUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f20897a[c.TRAILER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public class b {
        public b() {
        }

        public final boolean g() {
            while (k() > 0) {
                if (h() == 0) {
                    return true;
                }
            }
            return false;
        }

        public final int h() {
            int readUnsignedByte;
            if (r0.this.f20887f - r0.this.f20886e > 0) {
                readUnsignedByte = r0.this.f20885d[r0.this.f20886e] & UnsignedBytes.MAX_VALUE;
                r0.c(r0.this, 1);
            } else {
                readUnsignedByte = r0.this.f20882a.readUnsignedByte();
            }
            r0.this.f20883b.update(readUnsignedByte);
            r0.n(r0.this, 1);
            return readUnsignedByte;
        }

        public final long i() {
            return j() | (j() << 16);
        }

        public final int j() {
            return h() | (h() << 8);
        }

        public final int k() {
            return (r0.this.f20887f - r0.this.f20886e) + r0.this.f20882a.h();
        }

        public final void l(int i10) {
            int i11;
            int i12 = r0.this.f20887f - r0.this.f20886e;
            if (i12 > 0) {
                int min = Math.min(i12, i10);
                r0.this.f20883b.update(r0.this.f20885d, r0.this.f20886e, min);
                r0.c(r0.this, min);
                i11 = i10 - min;
            } else {
                i11 = i10;
            }
            if (i11 > 0) {
                byte[] bArr = new byte[512];
                int i13 = 0;
                while (i13 < i11) {
                    int min2 = Math.min(i11 - i13, 512);
                    r0.this.f20882a.C(bArr, 0, min2);
                    r0.this.f20883b.update(bArr, 0, min2);
                    i13 += min2;
                }
            }
            r0.n(r0.this, i10);
        }

        public /* synthetic */ b(r0 r0Var, a aVar) {
            this();
        }
    }

    public enum c {
        HEADER,
        HEADER_EXTRA_LEN,
        HEADER_EXTRA,
        HEADER_NAME,
        HEADER_COMMENT,
        HEADER_CRC,
        INITIALIZE_INFLATER,
        INFLATING,
        INFLATER_NEEDS_INPUT,
        TRAILER
    }

    public static /* synthetic */ int c(r0 r0Var, int i10) {
        int i11 = r0Var.f20886e + i10;
        r0Var.f20886e = i11;
        return i11;
    }

    public static /* synthetic */ int n(r0 r0Var, int i10) {
        int i11 = r0Var.f20894m + i10;
        r0Var.f20894m = i11;
        return i11;
    }

    public final boolean E() {
        Inflater inflater = this.f20888g;
        if (inflater == null) {
            this.f20888g = new Inflater(true);
        } else {
            inflater.reset();
        }
        this.f20883b.reset();
        int i10 = this.f20887f;
        int i11 = this.f20886e;
        int i12 = i10 - i11;
        if (i12 > 0) {
            this.f20888g.setInput(this.f20885d, i11, i12);
            this.f20889h = c.INFLATING;
        } else {
            this.f20889h = c.INFLATER_NEEDS_INPUT;
        }
        return true;
    }

    public boolean I() {
        Preconditions.checkState(!this.f20890i, "GzipInflatingBuffer is closed");
        return this.f20896o;
    }

    public final boolean L() {
        if (this.f20884c.k() < 10) {
            return false;
        }
        if (this.f20884c.j() != 35615) {
            throw new ZipException("Not in GZIP format");
        }
        if (this.f20884c.h() != 8) {
            throw new ZipException("Unsupported compression method");
        }
        this.f20891j = this.f20884c.h();
        this.f20884c.l(6);
        this.f20889h = c.HEADER_EXTRA_LEN;
        return true;
    }

    public final boolean M() {
        if ((this.f20891j & 16) != 16) {
            this.f20889h = c.HEADER_CRC;
            return true;
        }
        if (!this.f20884c.g()) {
            return false;
        }
        this.f20889h = c.HEADER_CRC;
        return true;
    }

    public final boolean N() {
        if ((this.f20891j & 2) != 2) {
            this.f20889h = c.INITIALIZE_INFLATER;
            return true;
        }
        if (this.f20884c.k() < 2) {
            return false;
        }
        if ((65535 & ((int) this.f20883b.getValue())) != this.f20884c.j()) {
            throw new ZipException("Corrupt GZIP header");
        }
        this.f20889h = c.INITIALIZE_INFLATER;
        return true;
    }

    public final boolean O() {
        int k10 = this.f20884c.k();
        int i10 = this.f20892k;
        if (k10 < i10) {
            return false;
        }
        this.f20884c.l(i10);
        this.f20889h = c.HEADER_NAME;
        return true;
    }

    public final boolean P() {
        if ((this.f20891j & 4) != 4) {
            this.f20889h = c.HEADER_NAME;
            return true;
        }
        if (this.f20884c.k() < 2) {
            return false;
        }
        this.f20892k = this.f20884c.j();
        this.f20889h = c.HEADER_EXTRA;
        return true;
    }

    public final boolean Q() {
        if ((this.f20891j & 8) != 8) {
            this.f20889h = c.HEADER_COMMENT;
            return true;
        }
        if (!this.f20884c.g()) {
            return false;
        }
        this.f20889h = c.HEADER_COMMENT;
        return true;
    }

    public final boolean R() {
        if (this.f20888g != null && this.f20884c.k() <= 18) {
            this.f20888g.end();
            this.f20888g = null;
        }
        if (this.f20884c.k() < 8) {
            return false;
        }
        if (this.f20883b.getValue() != this.f20884c.i() || this.f20893l != this.f20884c.i()) {
            throw new ZipException("Corrupt GZIP trailer");
        }
        this.f20883b.reset();
        this.f20889h = c.HEADER;
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f20890i) {
            return;
        }
        this.f20890i = true;
        this.f20882a.close();
        Inflater inflater = this.f20888g;
        if (inflater != null) {
            inflater.end();
            this.f20888g = null;
        }
    }

    public void q(t1 t1Var) {
        Preconditions.checkState(!this.f20890i, "GzipInflatingBuffer is closed");
        this.f20882a.b(t1Var);
        this.f20896o = false;
    }

    public final boolean s() {
        Preconditions.checkState(this.f20888g != null, "inflater is null");
        Preconditions.checkState(this.f20886e == this.f20887f, "inflaterInput has unconsumed bytes");
        int min = Math.min(this.f20882a.h(), 512);
        if (min == 0) {
            return false;
        }
        this.f20886e = 0;
        this.f20887f = min;
        this.f20882a.C(this.f20885d, 0, min);
        this.f20888g.setInput(this.f20885d, this.f20886e, min);
        this.f20889h = c.INFLATING;
        return true;
    }

    public int u() {
        int i10 = this.f20894m;
        this.f20894m = 0;
        return i10;
    }

    public int v() {
        int i10 = this.f20895n;
        this.f20895n = 0;
        return i10;
    }

    public boolean x() {
        Preconditions.checkState(!this.f20890i, "GzipInflatingBuffer is closed");
        return (this.f20884c.k() == 0 && this.f20889h == c.HEADER) ? false : true;
    }

    public final int y(byte[] bArr, int i10, int i11) {
        Preconditions.checkState(this.f20888g != null, "inflater is null");
        try {
            int totalIn = this.f20888g.getTotalIn();
            int inflate = this.f20888g.inflate(bArr, i10, i11);
            int totalIn2 = this.f20888g.getTotalIn() - totalIn;
            this.f20894m += totalIn2;
            this.f20895n += totalIn2;
            this.f20886e += totalIn2;
            this.f20883b.update(bArr, i10, inflate);
            if (this.f20888g.finished()) {
                this.f20893l = this.f20888g.getBytesWritten() & 4294967295L;
                this.f20889h = c.TRAILER;
            } else if (this.f20888g.needsInput()) {
                this.f20889h = c.INFLATER_NEEDS_INPUT;
            }
            return inflate;
        } catch (DataFormatException e10) {
            throw new DataFormatException("Inflater data format exception: " + e10.getMessage());
        }
    }

    public int z(byte[] bArr, int i10, int i11) {
        boolean z10 = true;
        Preconditions.checkState(!this.f20890i, "GzipInflatingBuffer is closed");
        boolean z11 = true;
        int i12 = 0;
        while (z11) {
            int i13 = i11 - i12;
            if (i13 <= 0) {
                if (z11 && (this.f20889h != c.HEADER || this.f20884c.k() >= 10)) {
                    z10 = false;
                }
                this.f20896o = z10;
                return i12;
            }
            switch (a.f20897a[this.f20889h.ordinal()]) {
                case 1:
                    z11 = L();
                    break;
                case 2:
                    z11 = P();
                    break;
                case 3:
                    z11 = O();
                    break;
                case 4:
                    z11 = Q();
                    break;
                case 5:
                    z11 = M();
                    break;
                case 6:
                    z11 = N();
                    break;
                case 7:
                    z11 = E();
                    break;
                case 8:
                    i12 += y(bArr, i10 + i12, i13);
                    if (this.f20889h != c.TRAILER) {
                        z11 = true;
                        break;
                    } else {
                        z11 = R();
                        break;
                    }
                case 9:
                    z11 = s();
                    break;
                case 10:
                    z11 = R();
                    break;
                default:
                    throw new AssertionError("Invalid state: " + this.f20889h);
            }
        }
        if (z11) {
            z10 = false;
        }
        this.f20896o = z10;
        return i12;
    }
}
