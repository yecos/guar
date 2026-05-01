package g0;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import com.google.android.gms.cast.MediaError;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import com.raizlabs.android.dbflow.sql.language.Operator;
import g0.c;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public class b {
    public static SimpleDateFormat T;
    public static SimpleDateFormat U;
    public static final d[] Y;
    public static final d[] Z;

    /* renamed from: a0, reason: collision with root package name */
    public static final d[] f13485a0;

    /* renamed from: b0, reason: collision with root package name */
    public static final d[] f13486b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final d[] f13487c0;

    /* renamed from: d0, reason: collision with root package name */
    public static final d f13488d0;

    /* renamed from: e0, reason: collision with root package name */
    public static final d[] f13489e0;

    /* renamed from: f0, reason: collision with root package name */
    public static final d[] f13490f0;

    /* renamed from: g0, reason: collision with root package name */
    public static final d[] f13491g0;

    /* renamed from: h0, reason: collision with root package name */
    public static final d[] f13492h0;

    /* renamed from: i0, reason: collision with root package name */
    public static final d[][] f13493i0;

    /* renamed from: j0, reason: collision with root package name */
    public static final d[] f13494j0;

    /* renamed from: k0, reason: collision with root package name */
    public static final HashMap[] f13495k0;

    /* renamed from: l0, reason: collision with root package name */
    public static final HashMap[] f13496l0;

    /* renamed from: m0, reason: collision with root package name */
    public static final HashSet f13497m0;

    /* renamed from: n0, reason: collision with root package name */
    public static final HashMap f13498n0;

    /* renamed from: o0, reason: collision with root package name */
    public static final Charset f13499o0;

    /* renamed from: p0, reason: collision with root package name */
    public static final byte[] f13500p0;

    /* renamed from: q0, reason: collision with root package name */
    public static final byte[] f13501q0;

    /* renamed from: r0, reason: collision with root package name */
    public static final Pattern f13502r0;

    /* renamed from: s0, reason: collision with root package name */
    public static final Pattern f13503s0;

    /* renamed from: t0, reason: collision with root package name */
    public static final Pattern f13504t0;

    /* renamed from: u0, reason: collision with root package name */
    public static final Pattern f13506u0;

    /* renamed from: a, reason: collision with root package name */
    public String f13512a;

    /* renamed from: b, reason: collision with root package name */
    public FileDescriptor f13513b;

    /* renamed from: c, reason: collision with root package name */
    public AssetManager.AssetInputStream f13514c;

    /* renamed from: d, reason: collision with root package name */
    public int f13515d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13516e;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap[] f13517f;

    /* renamed from: g, reason: collision with root package name */
    public Set f13518g;

    /* renamed from: h, reason: collision with root package name */
    public ByteOrder f13519h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f13520i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f13521j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f13522k;

    /* renamed from: l, reason: collision with root package name */
    public int f13523l;

    /* renamed from: m, reason: collision with root package name */
    public int f13524m;

    /* renamed from: n, reason: collision with root package name */
    public byte[] f13525n;

    /* renamed from: o, reason: collision with root package name */
    public int f13526o;

    /* renamed from: p, reason: collision with root package name */
    public int f13527p;

    /* renamed from: q, reason: collision with root package name */
    public int f13528q;

    /* renamed from: r, reason: collision with root package name */
    public int f13529r;

    /* renamed from: s, reason: collision with root package name */
    public int f13530s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f13531t;

    /* renamed from: u, reason: collision with root package name */
    public static final boolean f13505u = Log.isLoggable("ExifInterface", 3);

    /* renamed from: v, reason: collision with root package name */
    public static final List f13507v = Arrays.asList(1, 6, 3, 8);

    /* renamed from: w, reason: collision with root package name */
    public static final List f13508w = Arrays.asList(2, 7, 4, 5);

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f13509x = {8, 8, 8};

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f13510y = {4};

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f13511z = {8};
    public static final byte[] A = {-1, -40, -1};
    public static final byte[] B = {102, 116, 121, 112};
    public static final byte[] C = {109, 105, 102, 49};
    public static final byte[] D = {104, 101, 105, 99};
    public static final byte[] E = {79, 76, 89, 77, 80, 0};
    public static final byte[] F = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    public static final byte[] G = {-119, 80, 78, 71, 13, 10, Ascii.SUB, 10};
    public static final byte[] H = {101, 88, 73, 102};
    public static final byte[] I = {73, 72, 68, 82};
    public static final byte[] J = {73, 69, 78, 68};
    public static final byte[] K = {82, 73, 70, 70};
    public static final byte[] L = {87, 69, 66, 80};
    public static final byte[] M = {69, 88, 73, 70};
    public static final byte[] N = {-99, 1, 42};
    public static final byte[] O = "VP8X".getBytes(Charset.defaultCharset());
    public static final byte[] P = "VP8L".getBytes(Charset.defaultCharset());
    public static final byte[] Q = "VP8 ".getBytes(Charset.defaultCharset());
    public static final byte[] R = "ANIM".getBytes(Charset.defaultCharset());
    public static final byte[] S = "ANMF".getBytes(Charset.defaultCharset());
    public static final String[] V = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    public static final int[] W = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    public static final byte[] X = {65, 83, 67, 73, 73, 0, 0, 0};

    public class a extends MediaDataSource {

        /* renamed from: a, reason: collision with root package name */
        public long f13532a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f13533b;

        public a(f fVar) {
            this.f13533b = fVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j10, byte[] bArr, int i10, int i11) {
            if (i11 == 0) {
                return 0;
            }
            if (j10 < 0) {
                return -1;
            }
            try {
                long j11 = this.f13532a;
                if (j11 != j10) {
                    if (j11 >= 0 && j10 >= j11 + this.f13533b.available()) {
                        return -1;
                    }
                    this.f13533b.f(j10);
                    this.f13532a = j10;
                }
                if (i11 > this.f13533b.available()) {
                    i11 = this.f13533b.available();
                }
                int read = this.f13533b.read(bArr, i10, i11);
                if (read >= 0) {
                    this.f13532a += read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.f13532a = -1L;
            return -1;
        }
    }

    /* renamed from: g0.b$b, reason: collision with other inner class name */
    public static class C0220b extends InputStream implements DataInput {

        /* renamed from: e, reason: collision with root package name */
        public static final ByteOrder f13535e = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: f, reason: collision with root package name */
        public static final ByteOrder f13536f = ByteOrder.BIG_ENDIAN;

        /* renamed from: a, reason: collision with root package name */
        public final DataInputStream f13537a;

        /* renamed from: b, reason: collision with root package name */
        public ByteOrder f13538b;

        /* renamed from: c, reason: collision with root package name */
        public int f13539c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f13540d;

        public C0220b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.f13539c;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f13537a.available();
        }

        public long b() {
            return readInt() & 4294967295L;
        }

        public void c(ByteOrder byteOrder) {
            this.f13538b = byteOrder;
        }

        public void e(int i10) {
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i10 - i11;
                int skip = (int) this.f13537a.skip(i12);
                if (skip <= 0) {
                    if (this.f13540d == null) {
                        this.f13540d = new byte[8192];
                    }
                    skip = this.f13537a.read(this.f13540d, 0, Math.min(8192, i12));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i10 + " bytes.");
                    }
                }
                i11 += skip;
            }
            this.f13539c += i11;
        }

        @Override // java.io.InputStream
        public void mark(int i10) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() {
            this.f13539c++;
            return this.f13537a.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f13539c++;
            return this.f13537a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() {
            this.f13539c++;
            int read = this.f13537a.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f13539c += 2;
            return this.f13537a.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i10, int i11) {
            this.f13539c += i11;
            this.f13537a.readFully(bArr, i10, i11);
        }

        @Override // java.io.DataInput
        public int readInt() {
            this.f13539c += 4;
            int read = this.f13537a.read();
            int read2 = this.f13537a.read();
            int read3 = this.f13537a.read();
            int read4 = this.f13537a.read();
            if ((read | read2 | read3 | read4) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f13538b;
            if (byteOrder == f13535e) {
                return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == f13536f) {
                return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
            }
            throw new IOException("Invalid byte order: " + this.f13538b);
        }

        @Override // java.io.DataInput
        public String readLine() {
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() {
            this.f13539c += 8;
            int read = this.f13537a.read();
            int read2 = this.f13537a.read();
            int read3 = this.f13537a.read();
            int read4 = this.f13537a.read();
            int read5 = this.f13537a.read();
            int read6 = this.f13537a.read();
            int read7 = this.f13537a.read();
            int read8 = this.f13537a.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f13538b;
            if (byteOrder == f13535e) {
                return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == f13536f) {
                return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
            }
            throw new IOException("Invalid byte order: " + this.f13538b);
        }

        @Override // java.io.DataInput
        public short readShort() {
            this.f13539c += 2;
            int read = this.f13537a.read();
            int read2 = this.f13537a.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f13538b;
            if (byteOrder == f13535e) {
                return (short) ((read2 << 8) + read);
            }
            if (byteOrder == f13536f) {
                return (short) ((read << 8) + read2);
            }
            throw new IOException("Invalid byte order: " + this.f13538b);
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f13539c += 2;
            return this.f13537a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f13539c++;
            return this.f13537a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() {
            this.f13539c += 2;
            int read = this.f13537a.read();
            int read2 = this.f13537a.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f13538b;
            if (byteOrder == f13535e) {
                return (read2 << 8) + read;
            }
            if (byteOrder == f13536f) {
                return (read << 8) + read2;
            }
            throw new IOException("Invalid byte order: " + this.f13538b);
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public int skipBytes(int i10) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public C0220b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public C0220b(InputStream inputStream, ByteOrder byteOrder) {
            this.f13538b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f13537a = dataInputStream;
            dataInputStream.mark(0);
            this.f13539c = 0;
            this.f13538b = byteOrder;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            int read = this.f13537a.read(bArr, i10, i11);
            this.f13539c += read;
            return read;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) {
            this.f13539c += bArr.length;
            this.f13537a.readFully(bArr);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f13541a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13542b;

        /* renamed from: c, reason: collision with root package name */
        public final long f13543c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f13544d;

        public c(int i10, int i11, byte[] bArr) {
            this(i10, i11, -1L, bArr);
        }

        public static c a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(b.f13499o0);
            return new c(2, bytes.length, bytes);
        }

        public static c b(long j10, ByteOrder byteOrder) {
            return c(new long[]{j10}, byteOrder);
        }

        public static c c(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[b.W[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j10 : jArr) {
                wrap.putInt((int) j10);
            }
            return new c(4, jArr.length, wrap.array());
        }

        public static c d(e eVar, ByteOrder byteOrder) {
            return e(new e[]{eVar}, byteOrder);
        }

        public static c e(e[] eVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[b.W[5] * eVarArr.length]);
            wrap.order(byteOrder);
            for (e eVar : eVarArr) {
                wrap.putInt((int) eVar.f13549a);
                wrap.putInt((int) eVar.f13550b);
            }
            return new c(5, eVarArr.length, wrap.array());
        }

        public static c f(int i10, ByteOrder byteOrder) {
            return g(new int[]{i10}, byteOrder);
        }

        public static c g(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[b.W[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i10 : iArr) {
                wrap.putShort((short) i10);
            }
            return new c(3, iArr.length, wrap.array());
        }

        public double h(ByteOrder byteOrder) {
            Object k10 = k(byteOrder);
            if (k10 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (k10 instanceof String) {
                return Double.parseDouble((String) k10);
            }
            if (k10 instanceof long[]) {
                if (((long[]) k10).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k10 instanceof int[]) {
                if (((int[]) k10).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k10 instanceof double[]) {
                double[] dArr = (double[]) k10;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(k10 instanceof e[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            e[] eVarArr = (e[]) k10;
            if (eVarArr.length == 1) {
                return eVarArr[0].a();
            }
            throw new NumberFormatException("There are more than one component");
        }

        public int i(ByteOrder byteOrder) {
            Object k10 = k(byteOrder);
            if (k10 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (k10 instanceof String) {
                return Integer.parseInt((String) k10);
            }
            if (k10 instanceof long[]) {
                long[] jArr = (long[]) k10;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(k10 instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) k10;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String j(ByteOrder byteOrder) {
            Object k10 = k(byteOrder);
            if (k10 == null) {
                return null;
            }
            if (k10 instanceof String) {
                return (String) k10;
            }
            StringBuilder sb = new StringBuilder();
            int i10 = 0;
            if (k10 instanceof long[]) {
                long[] jArr = (long[]) k10;
                while (i10 < jArr.length) {
                    sb.append(jArr[i10]);
                    i10++;
                    if (i10 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (k10 instanceof int[]) {
                int[] iArr = (int[]) k10;
                while (i10 < iArr.length) {
                    sb.append(iArr[i10]);
                    i10++;
                    if (i10 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (k10 instanceof double[]) {
                double[] dArr = (double[]) k10;
                while (i10 < dArr.length) {
                    sb.append(dArr[i10]);
                    i10++;
                    if (i10 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(k10 instanceof e[])) {
                return null;
            }
            e[] eVarArr = (e[]) k10;
            while (i10 < eVarArr.length) {
                sb.append(eVarArr[i10].f13549a);
                sb.append('/');
                sb.append(eVarArr[i10].f13550b);
                i10++;
                if (i10 != eVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        public Object k(ByteOrder byteOrder) {
            C0220b c0220b;
            byte b10;
            byte b11;
            byte[] bArr;
            C0220b c0220b2 = null;
            try {
                c0220b = new C0220b(this.f13544d);
                try {
                    c0220b.c(byteOrder);
                    int i10 = 0;
                    boolean z10 = true;
                    switch (this.f13541a) {
                        case 1:
                        case 6:
                            byte[] bArr2 = this.f13544d;
                            if (bArr2.length != 1 || (b10 = bArr2[0]) < 0 || b10 > 1) {
                                String str = new String(bArr2, b.f13499o0);
                                try {
                                    c0220b.close();
                                } catch (IOException e10) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e10);
                                }
                                return str;
                            }
                            String str2 = new String(new char[]{(char) (b10 + 48)});
                            try {
                                c0220b.close();
                            } catch (IOException e11) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e11);
                            }
                            return str2;
                        case 2:
                        case 7:
                            if (this.f13542b >= b.X.length) {
                                int i11 = 0;
                                while (true) {
                                    bArr = b.X;
                                    if (i11 < bArr.length) {
                                        if (this.f13544d[i11] != bArr[i11]) {
                                            z10 = false;
                                        } else {
                                            i11++;
                                        }
                                    }
                                }
                                if (z10) {
                                    i10 = bArr.length;
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            while (i10 < this.f13542b && (b11 = this.f13544d[i10]) != 0) {
                                if (b11 >= 32) {
                                    sb.append((char) b11);
                                } else {
                                    sb.append('?');
                                }
                                i10++;
                            }
                            String sb2 = sb.toString();
                            try {
                                c0220b.close();
                            } catch (IOException e12) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e12);
                            }
                            return sb2;
                        case 3:
                            int[] iArr = new int[this.f13542b];
                            while (i10 < this.f13542b) {
                                iArr[i10] = c0220b.readUnsignedShort();
                                i10++;
                            }
                            try {
                                c0220b.close();
                            } catch (IOException e13) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e13);
                            }
                            return iArr;
                        case 4:
                            long[] jArr = new long[this.f13542b];
                            while (i10 < this.f13542b) {
                                jArr[i10] = c0220b.b();
                                i10++;
                            }
                            try {
                                c0220b.close();
                            } catch (IOException e14) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e14);
                            }
                            return jArr;
                        case 5:
                            e[] eVarArr = new e[this.f13542b];
                            while (i10 < this.f13542b) {
                                eVarArr[i10] = new e(c0220b.b(), c0220b.b());
                                i10++;
                            }
                            try {
                                c0220b.close();
                            } catch (IOException e15) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e15);
                            }
                            return eVarArr;
                        case 8:
                            int[] iArr2 = new int[this.f13542b];
                            while (i10 < this.f13542b) {
                                iArr2[i10] = c0220b.readShort();
                                i10++;
                            }
                            try {
                                c0220b.close();
                            } catch (IOException e16) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e16);
                            }
                            return iArr2;
                        case 9:
                            int[] iArr3 = new int[this.f13542b];
                            while (i10 < this.f13542b) {
                                iArr3[i10] = c0220b.readInt();
                                i10++;
                            }
                            try {
                                c0220b.close();
                            } catch (IOException e17) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e17);
                            }
                            return iArr3;
                        case 10:
                            e[] eVarArr2 = new e[this.f13542b];
                            while (i10 < this.f13542b) {
                                eVarArr2[i10] = new e(c0220b.readInt(), c0220b.readInt());
                                i10++;
                            }
                            try {
                                c0220b.close();
                            } catch (IOException e18) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e18);
                            }
                            return eVarArr2;
                        case 11:
                            double[] dArr = new double[this.f13542b];
                            while (i10 < this.f13542b) {
                                dArr[i10] = c0220b.readFloat();
                                i10++;
                            }
                            try {
                                c0220b.close();
                            } catch (IOException e19) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e19);
                            }
                            return dArr;
                        case 12:
                            double[] dArr2 = new double[this.f13542b];
                            while (i10 < this.f13542b) {
                                dArr2[i10] = c0220b.readDouble();
                                i10++;
                            }
                            try {
                                c0220b.close();
                            } catch (IOException e20) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e20);
                            }
                            return dArr2;
                        default:
                            try {
                                c0220b.close();
                            } catch (IOException e21) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e21);
                            }
                            return null;
                    }
                } catch (IOException unused) {
                    if (c0220b != null) {
                        try {
                            c0220b.close();
                        } catch (IOException e22) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e22);
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    c0220b2 = c0220b;
                    if (c0220b2 != null) {
                        try {
                            c0220b2.close();
                        } catch (IOException e23) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e23);
                        }
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                c0220b = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public String toString() {
            return "(" + b.V[this.f13541a] + ", data length:" + this.f13544d.length + ")";
        }

        public c(int i10, int i11, long j10, byte[] bArr) {
            this.f13541a = i10;
            this.f13542b = i11;
            this.f13543c = j10;
            this.f13544d = bArr;
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final long f13549a;

        /* renamed from: b, reason: collision with root package name */
        public final long f13550b;

        public e(long j10, long j11) {
            if (j11 == 0) {
                this.f13549a = 0L;
                this.f13550b = 1L;
            } else {
                this.f13549a = j10;
                this.f13550b = j11;
            }
        }

        public double a() {
            double d10 = this.f13549a;
            double d11 = this.f13550b;
            Double.isNaN(d10);
            Double.isNaN(d11);
            return d10 / d11;
        }

        public String toString() {
            return this.f13549a + Operator.Operation.DIVISION + this.f13550b;
        }
    }

    static {
        d[] dVarArr = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ImageWidth", 256, 3, 4), new d("ImageLength", 257, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", com.umeng.ccg.c.f10692s, 2), new d("DateTime", 306, 2), new d("Artist", MediaError.DetailedErrorCode.HLS_NETWORK_INVALID_SEGMENT, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7), new d("Xmp", 700, 1)};
        Y = dVarArr;
        d[] dVarArr2 = {new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("SpectralSensitivity", 34852, 2), new d("PhotographicSensitivity", 34855, 3), new d("OECF", 34856, 7), new d("SensitivityType", 34864, 3), new d("StandardOutputSensitivity", 34865, 4), new d("RecommendedExposureIndex", 34866, 4), new d("ISOSpeed", 34867, 4), new d("ISOSpeedLatitudeyyy", 34868, 4), new d("ISOSpeedLatitudezzz", 34869, 4), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("OffsetTime", 36880, 2), new d("OffsetTimeOriginal", 36881, 2), new d("OffsetTimeDigitized", 36882, 2), new d("ComponentsConfiguration", 37121, 7), new d("CompressedBitsPerPixel", 37122, 5), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("SubjectDistance", 37382, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubjectArea", 37396, 3), new d("MakerNote", 37500, 7), new d("UserComment", 37510, 7), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", 40960, 7), new d("ColorSpace", 40961, 3), new d("PixelXDimension", 40962, 3, 4), new d("PixelYDimension", 40963, 3, 4), new d("RelatedSoundFile", 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d("FlashEnergy", 41483, 5), new d("SpatialFrequencyResponse", 41484, 7), new d("FocalPlaneXResolution", 41486, 5), new d("FocalPlaneYResolution", 41487, 5), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SubjectLocation", 41492, 3), new d("ExposureIndex", 41493, 5), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CFAPattern", 41730, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("DigitalZoomRatio", 41988, 5), new d("FocalLengthIn35mmFilm", 41989, 3), new d("SceneCaptureType", 41990, 3), new d("GainControl", 41991, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3), new d("DeviceSettingDescription", 41995, 7), new d("SubjectDistanceRange", 41996, 3), new d("ImageUniqueID", 42016, 2), new d("CameraOwnerName", 42032, 2), new d("BodySerialNumber", 42033, 2), new d("LensSpecification", 42034, 5), new d("LensMake", 42035, 2), new d("LensModel", 42036, 2), new d("Gamma", 42240, 5), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        Z = dVarArr2;
        d[] dVarArr3 = {new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d("GPSLatitude", 2, 5, 10), new d("GPSLongitudeRef", 3, 2), new d("GPSLongitude", 4, 5, 10), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSatellites", 8, 2), new d("GPSStatus", 9, 2), new d("GPSMeasureMode", 10, 2), new d("GPSDOP", 11, 5), new d("GPSSpeedRef", 12, 2), new d("GPSSpeed", 13, 5), new d("GPSTrackRef", 14, 2), new d("GPSTrack", 15, 5), new d("GPSImgDirectionRef", 16, 2), new d("GPSImgDirection", 17, 5), new d("GPSMapDatum", 18, 2), new d("GPSDestLatitudeRef", 19, 2), new d("GPSDestLatitude", 20, 5), new d("GPSDestLongitudeRef", 21, 2), new d("GPSDestLongitude", 22, 5), new d("GPSDestBearingRef", 23, 2), new d("GPSDestBearing", 24, 5), new d("GPSDestDistanceRef", 25, 2), new d("GPSDestDistance", 26, 5), new d("GPSProcessingMethod", 27, 7), new d("GPSAreaInformation", 28, 7), new d("GPSDateStamp", 29, 2), new d("GPSDifferential", 30, 3), new d("GPSHPositioningError", 31, 5)};
        f13485a0 = dVarArr3;
        d[] dVarArr4 = {new d("InteroperabilityIndex", 1, 2)};
        f13486b0 = dVarArr4;
        d[] dVarArr5 = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ThumbnailImageWidth", 256, 3, 4), new d("ThumbnailImageLength", 257, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("ThumbnailOrientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", com.umeng.ccg.c.f10692s, 2), new d("DateTime", 306, 2), new d("Artist", MediaError.DetailedErrorCode.HLS_NETWORK_INVALID_SEGMENT, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        f13487c0 = dVarArr5;
        f13488d0 = new d("StripOffsets", 273, 3);
        d[] dVarArr6 = {new d("ThumbnailImage", 256, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4)};
        f13489e0 = dVarArr6;
        d[] dVarArr7 = {new d("PreviewImageStart", 257, 4), new d("PreviewImageLength", 258, 4)};
        f13490f0 = dVarArr7;
        d[] dVarArr8 = {new d("AspectFrame", 4371, 3)};
        f13491g0 = dVarArr8;
        d[] dVarArr9 = {new d("ColorSpace", 55, 3)};
        f13492h0 = dVarArr9;
        d[][] dVarArr10 = {dVarArr, dVarArr2, dVarArr3, dVarArr4, dVarArr5, dVarArr, dVarArr6, dVarArr7, dVarArr8, dVarArr9};
        f13493i0 = dVarArr10;
        f13494j0 = new d[]{new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1)};
        f13495k0 = new HashMap[dVarArr10.length];
        f13496l0 = new HashMap[dVarArr10.length];
        f13497m0 = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f13498n0 = new HashMap();
        Charset forName = Charset.forName("US-ASCII");
        f13499o0 = forName;
        f13500p0 = "Exif\u0000\u0000".getBytes(forName);
        f13501q0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        T = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        U = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i10 = 0;
        while (true) {
            d[][] dVarArr11 = f13493i0;
            if (i10 >= dVarArr11.length) {
                HashMap hashMap = f13498n0;
                d[] dVarArr12 = f13494j0;
                hashMap.put(Integer.valueOf(dVarArr12[0].f13545a), 5);
                hashMap.put(Integer.valueOf(dVarArr12[1].f13545a), 1);
                hashMap.put(Integer.valueOf(dVarArr12[2].f13545a), 2);
                hashMap.put(Integer.valueOf(dVarArr12[3].f13545a), 3);
                hashMap.put(Integer.valueOf(dVarArr12[4].f13545a), 7);
                hashMap.put(Integer.valueOf(dVarArr12[5].f13545a), 8);
                f13502r0 = Pattern.compile(".*[1-9].*");
                f13503s0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f13504t0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f13506u0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            f13495k0[i10] = new HashMap();
            f13496l0[i10] = new HashMap();
            for (d dVar : dVarArr11[i10]) {
                f13495k0[i10].put(Integer.valueOf(dVar.f13545a), dVar);
                f13496l0[i10].put(dVar.f13546b, dVar);
            }
            i10++;
        }
    }

    public b(InputStream inputStream) {
        this(inputStream, 0);
    }

    public static boolean K(int i10) {
        return (i10 == 4 || i10 == 9 || i10 == 13 || i10 == 14) ? false : true;
    }

    public static boolean q(BufferedInputStream bufferedInputStream) {
        byte[] bArr = f13500p0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i10 = 0;
        while (true) {
            byte[] bArr3 = f13500p0;
            if (i10 >= bArr3.length) {
                return true;
            }
            if (bArr2[i10] != bArr3[i10]) {
                return false;
            }
            i10++;
        }
    }

    public static boolean s(byte[] bArr) {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = A;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }

    public static boolean x(FileDescriptor fileDescriptor) {
        int i10;
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                i10 = OsConstants.SEEK_CUR;
                c.a.c(fileDescriptor, 0L, i10);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public final boolean A(byte[] bArr) {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = K;
            if (i10 >= bArr2.length) {
                int i11 = 0;
                while (true) {
                    byte[] bArr3 = L;
                    if (i11 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[K.length + i11 + 4] != bArr3[i11]) {
                        return false;
                    }
                    i11++;
                }
            } else {
                if (bArr[i10] != bArr2[i10]) {
                    return false;
                }
                i10++;
            }
        }
    }

    public final void B(InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException("inputstream shouldn't be null");
        }
        for (int i10 = 0; i10 < f13493i0.length; i10++) {
            try {
                try {
                    this.f13517f[i10] = new HashMap();
                } catch (IOException | UnsupportedOperationException unused) {
                    boolean z10 = f13505u;
                    a();
                    if (!z10) {
                        return;
                    }
                }
            } finally {
                a();
                if (f13505u) {
                    D();
                }
            }
        }
        if (!this.f13516e) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT);
            this.f13515d = g(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        if (K(this.f13515d)) {
            f fVar = new f(inputStream);
            if (this.f13516e) {
                m(fVar);
            } else {
                int i11 = this.f13515d;
                if (i11 == 12) {
                    e(fVar);
                } else if (i11 == 7) {
                    h(fVar);
                } else if (i11 == 10) {
                    l(fVar);
                } else {
                    k(fVar);
                }
            }
            fVar.f(this.f13527p);
            J(fVar);
        } else {
            C0220b c0220b = new C0220b(inputStream);
            int i12 = this.f13515d;
            if (i12 == 4) {
                f(c0220b, 0, 0);
            } else if (i12 == 13) {
                i(c0220b);
            } else if (i12 == 9) {
                j(c0220b);
            } else if (i12 == 14) {
                n(c0220b);
            }
        }
    }

    public final void C(C0220b c0220b) {
        ByteOrder E2 = E(c0220b);
        this.f13519h = E2;
        c0220b.c(E2);
        int readUnsignedShort = c0220b.readUnsignedShort();
        int i10 = this.f13515d;
        if (i10 != 7 && i10 != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = c0220b.readInt();
        if (readInt < 8) {
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        int i11 = readInt - 8;
        if (i11 > 0) {
            c0220b.e(i11);
        }
    }

    public final void D() {
        for (int i10 = 0; i10 < this.f13517f.length; i10++) {
            StringBuilder sb = new StringBuilder();
            sb.append("The size of tag group[");
            sb.append(i10);
            sb.append("]: ");
            sb.append(this.f13517f[i10].size());
            for (Map.Entry entry : this.f13517f[i10].entrySet()) {
                c cVar = (c) entry.getValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("tagName: ");
                sb2.append((String) entry.getKey());
                sb2.append(", tagType: ");
                sb2.append(cVar.toString());
                sb2.append(", tagValue: '");
                sb2.append(cVar.j(this.f13519h));
                sb2.append("'");
            }
        }
    }

    public final ByteOrder E(C0220b c0220b) {
        short readShort = c0220b.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    public final void F(byte[] bArr, int i10) {
        f fVar = new f(bArr);
        C(fVar);
        G(fVar, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0243  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void G(f fVar, int i10) {
        d dVar;
        int i11;
        long j10;
        boolean z10;
        short s10;
        long j11;
        d dVar2;
        short s11;
        int readUnsignedShort;
        long j12;
        int i12 = i10;
        this.f13518g.add(Integer.valueOf(fVar.f13539c));
        short readShort = fVar.readShort();
        if (f13505u) {
            StringBuilder sb = new StringBuilder();
            sb.append("numberOfDirectoryEntry: ");
            sb.append((int) readShort);
        }
        if (readShort <= 0) {
            return;
        }
        char c10 = 0;
        short s12 = 0;
        while (s12 < readShort) {
            int readUnsignedShort2 = fVar.readUnsignedShort();
            int readUnsignedShort3 = fVar.readUnsignedShort();
            int readInt = fVar.readInt();
            long a10 = fVar.a() + 4;
            d dVar3 = (d) f13495k0[i12].get(Integer.valueOf(readUnsignedShort2));
            boolean z11 = f13505u;
            if (z11) {
                Object[] objArr = new Object[5];
                objArr[c10] = Integer.valueOf(i10);
                objArr[1] = Integer.valueOf(readUnsignedShort2);
                objArr[2] = dVar3 != null ? dVar3.f13546b : null;
                objArr[3] = Integer.valueOf(readUnsignedShort3);
                objArr[4] = Integer.valueOf(readInt);
                String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", objArr);
            }
            if (dVar3 != null) {
                if (readUnsignedShort3 > 0) {
                    if (readUnsignedShort3 < W.length) {
                        if (dVar3.a(readUnsignedShort3)) {
                            if (readUnsignedShort3 == 7) {
                                readUnsignedShort3 = dVar3.f13547c;
                            }
                            i11 = readUnsignedShort2;
                            dVar = dVar3;
                            j10 = r4[readUnsignedShort3] * readInt;
                            if (j10 < 0 || j10 > TTL.MAX_VALUE) {
                                if (z11) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("Skip the tag entry since the number of components is invalid: ");
                                    sb2.append(readInt);
                                }
                                z10 = false;
                            } else {
                                z10 = true;
                            }
                            if (z10) {
                                if (j10 > 4) {
                                    int readInt2 = fVar.readInt();
                                    if (z11) {
                                        StringBuilder sb3 = new StringBuilder();
                                        s10 = readShort;
                                        sb3.append("seek to data offset: ");
                                        sb3.append(readInt2);
                                    } else {
                                        s10 = readShort;
                                    }
                                    if (this.f13515d == 7) {
                                        dVar2 = dVar;
                                        s11 = s12;
                                        if ("MakerNote".equals(dVar2.f13546b)) {
                                            this.f13528q = readInt2;
                                        } else if (i12 == 6 && "ThumbnailImage".equals(dVar2.f13546b)) {
                                            this.f13529r = readInt2;
                                            this.f13530s = readInt;
                                            c f10 = c.f(6, this.f13519h);
                                            j11 = a10;
                                            c b10 = c.b(this.f13529r, this.f13519h);
                                            c b11 = c.b(this.f13530s, this.f13519h);
                                            this.f13517f[4].put("Compression", f10);
                                            this.f13517f[4].put("JPEGInterchangeFormat", b10);
                                            this.f13517f[4].put("JPEGInterchangeFormatLength", b11);
                                        }
                                        j11 = a10;
                                    } else {
                                        j11 = a10;
                                        dVar2 = dVar;
                                        s11 = s12;
                                    }
                                    fVar.f(readInt2);
                                } else {
                                    s10 = readShort;
                                    j11 = a10;
                                    dVar2 = dVar;
                                    s11 = s12;
                                }
                                Integer num = (Integer) f13498n0.get(Integer.valueOf(i11));
                                if (z11) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("nextIfdType: ");
                                    sb4.append(num);
                                    sb4.append(" byteCount: ");
                                    sb4.append(j10);
                                }
                                if (num != null) {
                                    if (readUnsignedShort3 != 3) {
                                        if (readUnsignedShort3 == 4) {
                                            j12 = fVar.b();
                                        } else if (readUnsignedShort3 == 8) {
                                            readUnsignedShort = fVar.readShort();
                                        } else if (readUnsignedShort3 == 9 || readUnsignedShort3 == 13) {
                                            readUnsignedShort = fVar.readInt();
                                        } else {
                                            j12 = -1;
                                        }
                                        if (z11) {
                                            String.format("Offset: %d, tagName: %s", Long.valueOf(j12), dVar2.f13546b);
                                        }
                                        if (j12 <= 0) {
                                            if (!this.f13518g.contains(Integer.valueOf((int) j12))) {
                                                fVar.f(j12);
                                                G(fVar, num.intValue());
                                            } else if (z11) {
                                                StringBuilder sb5 = new StringBuilder();
                                                sb5.append("Skip jump into the IFD since it has already been read: IfdType ");
                                                sb5.append(num);
                                                sb5.append(" (at ");
                                                sb5.append(j12);
                                                sb5.append(")");
                                            }
                                        } else if (z11) {
                                            StringBuilder sb6 = new StringBuilder();
                                            sb6.append("Skip jump into the IFD since its offset is invalid: ");
                                            sb6.append(j12);
                                        }
                                        fVar.f(j11);
                                    } else {
                                        readUnsignedShort = fVar.readUnsignedShort();
                                    }
                                    j12 = readUnsignedShort;
                                    if (z11) {
                                    }
                                    if (j12 <= 0) {
                                    }
                                    fVar.f(j11);
                                } else {
                                    long j13 = j11;
                                    int a11 = fVar.a() + this.f13527p;
                                    byte[] bArr = new byte[(int) j10];
                                    fVar.readFully(bArr);
                                    c cVar = new c(readUnsignedShort3, readInt, a11, bArr);
                                    this.f13517f[i10].put(dVar2.f13546b, cVar);
                                    if ("DNGVersion".equals(dVar2.f13546b)) {
                                        this.f13515d = 3;
                                    }
                                    if ((("Make".equals(dVar2.f13546b) || "Model".equals(dVar2.f13546b)) && cVar.j(this.f13519h).contains("PENTAX")) || ("Compression".equals(dVar2.f13546b) && cVar.i(this.f13519h) == 65535)) {
                                        this.f13515d = 8;
                                    }
                                    if (fVar.a() != j13) {
                                        fVar.f(j13);
                                    }
                                }
                            } else {
                                fVar.f(a10);
                                s10 = readShort;
                                s11 = s12;
                            }
                            s12 = (short) (s11 + 1);
                            i12 = i10;
                            readShort = s10;
                            c10 = 0;
                        } else if (z11) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("Skip the tag entry since data format (");
                            sb7.append(V[readUnsignedShort3]);
                            sb7.append(") is unexpected for tag: ");
                            sb7.append(dVar3.f13546b);
                        }
                    }
                }
                dVar = dVar3;
                i11 = readUnsignedShort2;
                if (z11) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("Skip the tag entry since data format is invalid: ");
                    sb8.append(readUnsignedShort3);
                }
                z10 = false;
                j10 = 0;
                if (z10) {
                }
                s12 = (short) (s11 + 1);
                i12 = i10;
                readShort = s10;
                c10 = 0;
            } else if (z11) {
                StringBuilder sb9 = new StringBuilder();
                sb9.append("Skip the tag entry since tag number is not defined: ");
                sb9.append(readUnsignedShort2);
            }
            dVar = dVar3;
            i11 = readUnsignedShort2;
            z10 = false;
            j10 = 0;
            if (z10) {
            }
            s12 = (short) (s11 + 1);
            i12 = i10;
            readShort = s10;
            c10 = 0;
        }
        int readInt3 = fVar.readInt();
        boolean z12 = f13505u;
        if (z12) {
            String.format("nextIfdOffset: %d", Integer.valueOf(readInt3));
        }
        long j14 = readInt3;
        if (j14 <= 0) {
            if (z12) {
                StringBuilder sb10 = new StringBuilder();
                sb10.append("Stop reading file since a wrong offset may cause an infinite loop: ");
                sb10.append(readInt3);
                return;
            }
            return;
        }
        if (this.f13518g.contains(Integer.valueOf(readInt3))) {
            if (z12) {
                StringBuilder sb11 = new StringBuilder();
                sb11.append("Stop reading file since re-reading an IFD may cause an infinite loop: ");
                sb11.append(readInt3);
                return;
            }
            return;
        }
        fVar.f(j14);
        if (this.f13517f[4].isEmpty()) {
            G(fVar, 4);
        } else if (this.f13517f[5].isEmpty()) {
            G(fVar, 5);
        }
    }

    public final void H(int i10, String str, String str2) {
        if (this.f13517f[i10].isEmpty() || this.f13517f[i10].get(str) == null) {
            return;
        }
        HashMap hashMap = this.f13517f[i10];
        hashMap.put(str2, hashMap.get(str));
        this.f13517f[i10].remove(str);
    }

    public final void I(f fVar, int i10) {
        c cVar = (c) this.f13517f[i10].get("ImageLength");
        c cVar2 = (c) this.f13517f[i10].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            c cVar3 = (c) this.f13517f[i10].get("JPEGInterchangeFormat");
            c cVar4 = (c) this.f13517f[i10].get("JPEGInterchangeFormatLength");
            if (cVar3 == null || cVar4 == null) {
                return;
            }
            int i11 = cVar3.i(this.f13519h);
            int i12 = cVar3.i(this.f13519h);
            fVar.f(i11);
            byte[] bArr = new byte[i12];
            fVar.read(bArr);
            f(new C0220b(bArr), i11, i10);
        }
    }

    public final void J(C0220b c0220b) {
        HashMap hashMap = this.f13517f[4];
        c cVar = (c) hashMap.get("Compression");
        if (cVar == null) {
            this.f13526o = 6;
            o(c0220b, hashMap);
            return;
        }
        int i10 = cVar.i(this.f13519h);
        this.f13526o = i10;
        if (i10 != 1) {
            if (i10 == 6) {
                o(c0220b, hashMap);
                return;
            } else if (i10 != 7) {
                return;
            }
        }
        if (y(hashMap)) {
            p(c0220b, hashMap);
        }
    }

    public final void L(int i10, int i11) {
        if (this.f13517f[i10].isEmpty() || this.f13517f[i11].isEmpty()) {
            return;
        }
        c cVar = (c) this.f13517f[i10].get("ImageLength");
        c cVar2 = (c) this.f13517f[i10].get("ImageWidth");
        c cVar3 = (c) this.f13517f[i11].get("ImageLength");
        c cVar4 = (c) this.f13517f[i11].get("ImageWidth");
        if (cVar == null || cVar2 == null || cVar3 == null || cVar4 == null) {
            return;
        }
        int i12 = cVar.i(this.f13519h);
        int i13 = cVar2.i(this.f13519h);
        int i14 = cVar3.i(this.f13519h);
        int i15 = cVar4.i(this.f13519h);
        if (i12 >= i14 || i13 >= i15) {
            return;
        }
        HashMap[] hashMapArr = this.f13517f;
        HashMap hashMap = hashMapArr[i10];
        hashMapArr[i10] = hashMapArr[i11];
        hashMapArr[i11] = hashMap;
    }

    public final void M(f fVar, int i10) {
        c f10;
        c f11;
        c cVar = (c) this.f13517f[i10].get("DefaultCropSize");
        c cVar2 = (c) this.f13517f[i10].get("SensorTopBorder");
        c cVar3 = (c) this.f13517f[i10].get("SensorLeftBorder");
        c cVar4 = (c) this.f13517f[i10].get("SensorBottomBorder");
        c cVar5 = (c) this.f13517f[i10].get("SensorRightBorder");
        if (cVar == null) {
            if (cVar2 == null || cVar3 == null || cVar4 == null || cVar5 == null) {
                I(fVar, i10);
                return;
            }
            int i11 = cVar2.i(this.f13519h);
            int i12 = cVar4.i(this.f13519h);
            int i13 = cVar5.i(this.f13519h);
            int i14 = cVar3.i(this.f13519h);
            if (i12 <= i11 || i13 <= i14) {
                return;
            }
            c f12 = c.f(i12 - i11, this.f13519h);
            c f13 = c.f(i13 - i14, this.f13519h);
            this.f13517f[i10].put("ImageLength", f12);
            this.f13517f[i10].put("ImageWidth", f13);
            return;
        }
        if (cVar.f13541a == 5) {
            e[] eVarArr = (e[]) cVar.k(this.f13519h);
            if (eVarArr == null || eVarArr.length != 2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid crop size values. cropSize=");
                sb.append(Arrays.toString(eVarArr));
                return;
            }
            f10 = c.d(eVarArr[0], this.f13519h);
            f11 = c.d(eVarArr[1], this.f13519h);
        } else {
            int[] iArr = (int[]) cVar.k(this.f13519h);
            if (iArr == null || iArr.length != 2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Invalid crop size values. cropSize=");
                sb2.append(Arrays.toString(iArr));
                return;
            }
            f10 = c.f(iArr[0], this.f13519h);
            f11 = c.f(iArr[1], this.f13519h);
        }
        this.f13517f[i10].put("ImageWidth", f10);
        this.f13517f[i10].put("ImageLength", f11);
    }

    public final void N() {
        L(0, 5);
        L(0, 4);
        L(5, 4);
        c cVar = (c) this.f13517f[1].get("PixelXDimension");
        c cVar2 = (c) this.f13517f[1].get("PixelYDimension");
        if (cVar != null && cVar2 != null) {
            this.f13517f[0].put("ImageWidth", cVar);
            this.f13517f[0].put("ImageLength", cVar2);
        }
        if (this.f13517f[4].isEmpty() && z(this.f13517f[5])) {
            HashMap[] hashMapArr = this.f13517f;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap();
        }
        z(this.f13517f[4]);
        H(0, "ThumbnailOrientation", "Orientation");
        H(0, "ThumbnailImageLength", "ImageLength");
        H(0, "ThumbnailImageWidth", "ImageWidth");
        H(5, "ThumbnailOrientation", "Orientation");
        H(5, "ThumbnailImageLength", "ImageLength");
        H(5, "ThumbnailImageWidth", "ImageWidth");
        H(4, "Orientation", "ThumbnailOrientation");
        H(4, "ImageLength", "ThumbnailImageLength");
        H(4, "ImageWidth", "ThumbnailImageWidth");
    }

    public final void a() {
        String b10 = b("DateTimeOriginal");
        if (b10 != null && b("DateTime") == null) {
            this.f13517f[0].put("DateTime", c.a(b10));
        }
        if (b("ImageWidth") == null) {
            this.f13517f[0].put("ImageWidth", c.b(0L, this.f13519h));
        }
        if (b("ImageLength") == null) {
            this.f13517f[0].put("ImageLength", c.b(0L, this.f13519h));
        }
        if (b("Orientation") == null) {
            this.f13517f[0].put("Orientation", c.b(0L, this.f13519h));
        }
        if (b("LightSource") == null) {
            this.f13517f[1].put("LightSource", c.b(0L, this.f13519h));
        }
    }

    public String b(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        c d10 = d(str);
        if (d10 != null) {
            if (!f13497m0.contains(str)) {
                return d10.j(this.f13519h);
            }
            if (str.equals("GPSTimeStamp")) {
                int i10 = d10.f13541a;
                if (i10 != 5 && i10 != 10) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("GPS Timestamp format is not rational. format=");
                    sb.append(d10.f13541a);
                    return null;
                }
                e[] eVarArr = (e[]) d10.k(this.f13519h);
                if (eVarArr == null || eVarArr.length != 3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid GPS Timestamp array. array=");
                    sb2.append(Arrays.toString(eVarArr));
                    return null;
                }
                e eVar = eVarArr[0];
                e eVar2 = eVarArr[1];
                e eVar3 = eVarArr[2];
                return String.format("%02d:%02d:%02d", Integer.valueOf((int) (eVar.f13549a / eVar.f13550b)), Integer.valueOf((int) (eVar2.f13549a / eVar2.f13550b)), Integer.valueOf((int) (eVar3.f13549a / eVar3.f13550b)));
            }
            try {
                return Double.toString(d10.h(this.f13519h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int c(String str, int i10) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        c d10 = d(str);
        if (d10 == null) {
            return i10;
        }
        try {
            return d10.i(this.f13519h);
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    public final c d(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i10 = 0; i10 < f13493i0.length; i10++) {
            c cVar = (c) this.f13517f[i10].get(str);
            if (cVar != null) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(f fVar) {
        String str;
        String str2;
        String str3;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                c.b.a(mediaMetadataRetriever, new a(fVar));
                String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
                String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(extractMetadata3)) {
                    str = mediaMetadataRetriever.extractMetadata(29);
                    str2 = mediaMetadataRetriever.extractMetadata(30);
                    str3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(extractMetadata4)) {
                    str = mediaMetadataRetriever.extractMetadata(18);
                    str2 = mediaMetadataRetriever.extractMetadata(19);
                    str3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                }
                if (str != null) {
                    this.f13517f[0].put("ImageWidth", c.f(Integer.parseInt(str), this.f13519h));
                }
                if (str2 != null) {
                    this.f13517f[0].put("ImageLength", c.f(Integer.parseInt(str2), this.f13519h));
                }
                if (str3 != null) {
                    int parseInt = Integer.parseInt(str3);
                    this.f13517f[0].put("Orientation", c.f(parseInt != 90 ? parseInt != 180 ? parseInt != 270 ? 1 : 8 : 3 : 6, this.f13519h));
                }
                if (extractMetadata != null && extractMetadata2 != null) {
                    int parseInt2 = Integer.parseInt(extractMetadata);
                    int parseInt3 = Integer.parseInt(extractMetadata2);
                    if (parseInt3 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    fVar.f(parseInt2);
                    byte[] bArr = new byte[6];
                    if (fVar.read(bArr) != 6) {
                        throw new IOException("Can't read identifier");
                    }
                    int i10 = parseInt2 + 6;
                    int i11 = parseInt3 - 6;
                    if (!Arrays.equals(bArr, f13500p0)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i11];
                    if (fVar.read(bArr2) != i11) {
                        throw new IOException("Can't read exif");
                    }
                    this.f13527p = i10;
                    F(bArr2, 0);
                }
                if (f13505u) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Heif meta: ");
                    sb.append(str);
                    sb.append("x");
                    sb.append(str2);
                    sb.append(", rotation ");
                    sb.append(str3);
                }
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0176, code lost:
    
        r20.c(r19.f13519h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x017b, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0162 A[LOOP:0: B:9:0x002f->B:32:0x0162, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x016a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a1 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(C0220b c0220b, int i10, int i11) {
        if (f13505u) {
            StringBuilder sb = new StringBuilder();
            sb.append("getJpegAttributes starting with: ");
            sb.append(c0220b);
        }
        c0220b.c(ByteOrder.BIG_ENDIAN);
        byte readByte = c0220b.readByte();
        byte b10 = -1;
        if (readByte != -1) {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & UnsignedBytes.MAX_VALUE));
        }
        if (c0220b.readByte() != -40) {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & UnsignedBytes.MAX_VALUE));
        }
        int i12 = 2;
        int i13 = 2;
        while (true) {
            byte readByte2 = c0220b.readByte();
            if (readByte2 != b10) {
                throw new IOException("Invalid marker:" + Integer.toHexString(readByte2 & UnsignedBytes.MAX_VALUE));
            }
            int i14 = i13 + 1;
            byte readByte3 = c0220b.readByte();
            boolean z10 = f13505u;
            if (z10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Found JPEG segment indicator: ");
                sb2.append(Integer.toHexString(readByte3 & UnsignedBytes.MAX_VALUE));
            }
            int i15 = i14 + 1;
            if (readByte3 != -39 && readByte3 != -38) {
                int readUnsignedShort = c0220b.readUnsignedShort() - i12;
                int i16 = i15 + i12;
                if (z10) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("JPEG segment: ");
                    sb3.append(Integer.toHexString(readByte3 & UnsignedBytes.MAX_VALUE));
                    sb3.append(" (length: ");
                    sb3.append(readUnsignedShort + 2);
                    sb3.append(")");
                }
                if (readUnsignedShort < 0) {
                    throw new IOException("Invalid length");
                }
                if (readByte3 == -31) {
                    byte[] bArr = new byte[readUnsignedShort];
                    c0220b.readFully(bArr);
                    int i17 = i16 + readUnsignedShort;
                    byte[] bArr2 = f13500p0;
                    if (g0.c.c(bArr, bArr2)) {
                        byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr2.length, readUnsignedShort);
                        this.f13527p = i10 + i16 + bArr2.length;
                        F(copyOfRange, i11);
                        J(new C0220b(copyOfRange));
                    } else {
                        byte[] bArr3 = f13501q0;
                        if (g0.c.c(bArr, bArr3)) {
                            int length = i16 + bArr3.length;
                            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr3.length, readUnsignedShort);
                            if (b("Xmp") == null) {
                                this.f13517f[0].put("Xmp", new c(1, copyOfRange2.length, length, copyOfRange2));
                                this.f13531t = true;
                            }
                        }
                    }
                    i16 = i17;
                } else if (readByte3 != -2) {
                    switch (readByte3) {
                        default:
                            switch (readByte3) {
                                default:
                                    switch (readByte3) {
                                        default:
                                            switch (readByte3) {
                                            }
                                        case -55:
                                        case -54:
                                        case -53:
                                            c0220b.e(1);
                                            this.f13517f[i11].put(i11 != 4 ? "ImageLength" : "ThumbnailImageLength", c.b(c0220b.readUnsignedShort(), this.f13519h));
                                            this.f13517f[i11].put(i11 != 4 ? "ImageWidth" : "ThumbnailImageWidth", c.b(c0220b.readUnsignedShort(), this.f13519h));
                                            readUnsignedShort -= 5;
                                            break;
                                    }
                                case -59:
                                case -58:
                                case -57:
                                    break;
                            }
                        case -64:
                        case -63:
                        case -62:
                        case -61:
                            break;
                    }
                    if (readUnsignedShort >= 0) {
                        throw new IOException("Invalid length");
                    }
                    c0220b.e(readUnsignedShort);
                    i13 = i16 + readUnsignedShort;
                    i12 = 2;
                    b10 = -1;
                } else {
                    byte[] bArr4 = new byte[readUnsignedShort];
                    if (c0220b.read(bArr4) != readUnsignedShort) {
                        throw new IOException("Invalid exif");
                    }
                    if (b("UserComment") == null) {
                        this.f13517f[1].put("UserComment", c.a(new String(bArr4, f13499o0)));
                    }
                }
                readUnsignedShort = 0;
                if (readUnsignedShort >= 0) {
                }
            }
        }
    }

    public final int g(BufferedInputStream bufferedInputStream) {
        bufferedInputStream.mark(com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT);
        byte[] bArr = new byte[com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (s(bArr)) {
            return 4;
        }
        if (v(bArr)) {
            return 9;
        }
        if (r(bArr)) {
            return 12;
        }
        if (t(bArr)) {
            return 7;
        }
        if (w(bArr)) {
            return 10;
        }
        if (u(bArr)) {
            return 13;
        }
        return A(bArr) ? 14 : 0;
    }

    public final void h(f fVar) {
        int i10;
        int i11;
        k(fVar);
        c cVar = (c) this.f13517f[1].get("MakerNote");
        if (cVar != null) {
            f fVar2 = new f(cVar.f13544d);
            fVar2.c(this.f13519h);
            byte[] bArr = E;
            byte[] bArr2 = new byte[bArr.length];
            fVar2.readFully(bArr2);
            fVar2.f(0L);
            byte[] bArr3 = F;
            byte[] bArr4 = new byte[bArr3.length];
            fVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                fVar2.f(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                fVar2.f(12L);
            }
            G(fVar2, 6);
            c cVar2 = (c) this.f13517f[7].get("PreviewImageStart");
            c cVar3 = (c) this.f13517f[7].get("PreviewImageLength");
            if (cVar2 != null && cVar3 != null) {
                this.f13517f[5].put("JPEGInterchangeFormat", cVar2);
                this.f13517f[5].put("JPEGInterchangeFormatLength", cVar3);
            }
            c cVar4 = (c) this.f13517f[8].get("AspectFrame");
            if (cVar4 != null) {
                int[] iArr = (int[]) cVar4.k(this.f13519h);
                if (iArr == null || iArr.length != 4) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid aspect frame values. frame=");
                    sb.append(Arrays.toString(iArr));
                    return;
                }
                int i12 = iArr[2];
                int i13 = iArr[0];
                if (i12 <= i13 || (i10 = iArr[3]) <= (i11 = iArr[1])) {
                    return;
                }
                int i14 = (i12 - i13) + 1;
                int i15 = (i10 - i11) + 1;
                if (i14 < i15) {
                    int i16 = i14 + i15;
                    i15 = i16 - i15;
                    i14 = i16 - i15;
                }
                c f10 = c.f(i14, this.f13519h);
                c f11 = c.f(i15, this.f13519h);
                this.f13517f[0].put("ImageWidth", f10);
                this.f13517f[0].put("ImageLength", f11);
            }
        }
    }

    public final void i(C0220b c0220b) {
        if (f13505u) {
            StringBuilder sb = new StringBuilder();
            sb.append("getPngAttributes starting with: ");
            sb.append(c0220b);
        }
        c0220b.c(ByteOrder.BIG_ENDIAN);
        byte[] bArr = G;
        c0220b.e(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = c0220b.readInt();
                int i10 = length + 4;
                byte[] bArr2 = new byte[4];
                if (c0220b.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i11 = i10 + 4;
                if (i11 == 16 && !Arrays.equals(bArr2, I)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, J)) {
                    return;
                }
                if (Arrays.equals(bArr2, H)) {
                    byte[] bArr3 = new byte[readInt];
                    if (c0220b.read(bArr3) != readInt) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + g0.c.a(bArr2));
                    }
                    int readInt2 = c0220b.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == readInt2) {
                        this.f13527p = i11;
                        F(bArr3, 0);
                        N();
                        J(new C0220b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                }
                int i12 = readInt + 4;
                c0220b.e(i12);
                length = i11 + i12;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void j(C0220b c0220b) {
        boolean z10 = f13505u;
        if (z10) {
            StringBuilder sb = new StringBuilder();
            sb.append("getRafAttributes starting with: ");
            sb.append(c0220b);
        }
        c0220b.e(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        c0220b.read(bArr);
        c0220b.read(bArr2);
        c0220b.read(bArr3);
        int i10 = ByteBuffer.wrap(bArr).getInt();
        int i11 = ByteBuffer.wrap(bArr2).getInt();
        int i12 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i11];
        c0220b.e(i10 - c0220b.a());
        c0220b.read(bArr4);
        f(new C0220b(bArr4), i10, 5);
        c0220b.e(i12 - c0220b.a());
        c0220b.c(ByteOrder.BIG_ENDIAN);
        int readInt = c0220b.readInt();
        if (z10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("numberOfDirectoryEntry: ");
            sb2.append(readInt);
        }
        for (int i13 = 0; i13 < readInt; i13++) {
            int readUnsignedShort = c0220b.readUnsignedShort();
            int readUnsignedShort2 = c0220b.readUnsignedShort();
            if (readUnsignedShort == f13488d0.f13545a) {
                short readShort = c0220b.readShort();
                short readShort2 = c0220b.readShort();
                c f10 = c.f(readShort, this.f13519h);
                c f11 = c.f(readShort2, this.f13519h);
                this.f13517f[0].put("ImageLength", f10);
                this.f13517f[0].put("ImageWidth", f11);
                if (f13505u) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Updated to length: ");
                    sb3.append((int) readShort);
                    sb3.append(", width: ");
                    sb3.append((int) readShort2);
                    return;
                }
                return;
            }
            c0220b.e(readUnsignedShort2);
        }
    }

    public final void k(f fVar) {
        c cVar;
        C(fVar);
        G(fVar, 0);
        M(fVar, 0);
        M(fVar, 5);
        M(fVar, 4);
        N();
        if (this.f13515d != 8 || (cVar = (c) this.f13517f[1].get("MakerNote")) == null) {
            return;
        }
        f fVar2 = new f(cVar.f13544d);
        fVar2.c(this.f13519h);
        fVar2.e(6);
        G(fVar2, 9);
        c cVar2 = (c) this.f13517f[9].get("ColorSpace");
        if (cVar2 != null) {
            this.f13517f[1].put("ColorSpace", cVar2);
        }
    }

    public final void l(f fVar) {
        if (f13505u) {
            StringBuilder sb = new StringBuilder();
            sb.append("getRw2Attributes starting with: ");
            sb.append(fVar);
        }
        k(fVar);
        c cVar = (c) this.f13517f[0].get("JpgFromRaw");
        if (cVar != null) {
            f(new C0220b(cVar.f13544d), (int) cVar.f13543c, 5);
        }
        c cVar2 = (c) this.f13517f[0].get("ISO");
        c cVar3 = (c) this.f13517f[1].get("PhotographicSensitivity");
        if (cVar2 == null || cVar3 != null) {
            return;
        }
        this.f13517f[1].put("PhotographicSensitivity", cVar2);
    }

    public final void m(f fVar) {
        byte[] bArr = f13500p0;
        fVar.e(bArr.length);
        byte[] bArr2 = new byte[fVar.available()];
        fVar.readFully(bArr2);
        this.f13527p = bArr.length;
        F(bArr2, 0);
    }

    public final void n(C0220b c0220b) {
        if (f13505u) {
            StringBuilder sb = new StringBuilder();
            sb.append("getWebpAttributes starting with: ");
            sb.append(c0220b);
        }
        c0220b.c(ByteOrder.LITTLE_ENDIAN);
        c0220b.e(K.length);
        int readInt = c0220b.readInt() + 8;
        byte[] bArr = L;
        c0220b.e(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (c0220b.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int readInt2 = c0220b.readInt();
                int i10 = length + 4 + 4;
                if (Arrays.equals(M, bArr2)) {
                    byte[] bArr3 = new byte[readInt2];
                    if (c0220b.read(bArr3) == readInt2) {
                        this.f13527p = i10;
                        F(bArr3, 0);
                        J(new C0220b(bArr3));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + g0.c.a(bArr2));
                    }
                }
                if (readInt2 % 2 == 1) {
                    readInt2++;
                }
                length = i10 + readInt2;
                if (length == readInt) {
                    return;
                }
                if (length > readInt) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                c0220b.e(readInt2);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void o(C0220b c0220b, HashMap hashMap) {
        c cVar = (c) hashMap.get("JPEGInterchangeFormat");
        c cVar2 = (c) hashMap.get("JPEGInterchangeFormatLength");
        if (cVar == null || cVar2 == null) {
            return;
        }
        int i10 = cVar.i(this.f13519h);
        int i11 = cVar2.i(this.f13519h);
        if (this.f13515d == 7) {
            i10 += this.f13528q;
        }
        if (i10 > 0 && i11 > 0) {
            this.f13520i = true;
            if (this.f13512a == null && this.f13514c == null && this.f13513b == null) {
                byte[] bArr = new byte[i11];
                c0220b.skip(i10);
                c0220b.read(bArr);
                this.f13525n = bArr;
            }
            this.f13523l = i10;
            this.f13524m = i11;
        }
        if (f13505u) {
            StringBuilder sb = new StringBuilder();
            sb.append("Setting thumbnail attributes with offset: ");
            sb.append(i10);
            sb.append(", length: ");
            sb.append(i11);
        }
    }

    public final void p(C0220b c0220b, HashMap hashMap) {
        c cVar = (c) hashMap.get("StripOffsets");
        c cVar2 = (c) hashMap.get("StripByteCounts");
        if (cVar == null || cVar2 == null) {
            return;
        }
        long[] b10 = g0.c.b(cVar.k(this.f13519h));
        long[] b11 = g0.c.b(cVar2.k(this.f13519h));
        if (b10 == null || b10.length == 0 || b11 == null || b11.length == 0 || b10.length != b11.length) {
            return;
        }
        long j10 = 0;
        for (long j11 : b11) {
            j10 += j11;
        }
        int i10 = (int) j10;
        byte[] bArr = new byte[i10];
        int i11 = 1;
        this.f13522k = true;
        this.f13521j = true;
        this.f13520i = true;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < b10.length) {
            int i15 = (int) b10[i12];
            int i16 = (int) b11[i12];
            if (i12 < b10.length - i11 && i15 + i16 != b10[i12 + 1]) {
                this.f13522k = false;
            }
            int i17 = i15 - i13;
            if (i17 < 0) {
                return;
            }
            long j12 = i17;
            if (c0220b.skip(j12) != j12) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to skip ");
                sb.append(i17);
                sb.append(" bytes.");
                return;
            }
            int i18 = i13 + i17;
            byte[] bArr2 = new byte[i16];
            if (c0220b.read(bArr2) != i16) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to read ");
                sb2.append(i16);
                sb2.append(" bytes.");
                return;
            }
            i13 = i18 + i16;
            System.arraycopy(bArr2, 0, bArr, i14, i16);
            i14 += i16;
            i12++;
            i11 = 1;
        }
        this.f13525n = bArr;
        if (this.f13522k) {
            this.f13523l = (int) b10[0];
            this.f13524m = i10;
        }
    }

    public final boolean r(byte[] bArr) {
        C0220b c0220b;
        long readInt;
        byte[] bArr2;
        long j10;
        C0220b c0220b2 = null;
        try {
            try {
                c0220b = new C0220b(bArr);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            readInt = c0220b.readInt();
            bArr2 = new byte[4];
            c0220b.read(bArr2);
        } catch (Exception unused2) {
            c0220b2 = c0220b;
            boolean z10 = f13505u;
            if (c0220b2 != null) {
                c0220b2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            c0220b2 = c0220b;
            if (c0220b2 != null) {
                c0220b2.close();
            }
            throw th;
        }
        if (!Arrays.equals(bArr2, B)) {
            c0220b.close();
            return false;
        }
        if (readInt == 1) {
            readInt = c0220b.readLong();
            j10 = 16;
            if (readInt < 16) {
                c0220b.close();
                return false;
            }
        } else {
            j10 = 8;
        }
        if (readInt > bArr.length) {
            readInt = bArr.length;
        }
        long j11 = readInt - j10;
        if (j11 < 8) {
            c0220b.close();
            return false;
        }
        byte[] bArr3 = new byte[4];
        boolean z11 = false;
        boolean z12 = false;
        for (long j12 = 0; j12 < j11 / 4; j12++) {
            if (c0220b.read(bArr3) != 4) {
                c0220b.close();
                return false;
            }
            if (j12 != 1) {
                if (Arrays.equals(bArr3, C)) {
                    z11 = true;
                } else if (Arrays.equals(bArr3, D)) {
                    z12 = true;
                }
                if (z11 && z12) {
                    c0220b.close();
                    return true;
                }
            }
        }
        c0220b.close();
        return false;
    }

    public final boolean t(byte[] bArr) {
        C0220b c0220b = null;
        try {
            C0220b c0220b2 = new C0220b(bArr);
            try {
                ByteOrder E2 = E(c0220b2);
                this.f13519h = E2;
                c0220b2.c(E2);
                short readShort = c0220b2.readShort();
                boolean z10 = readShort == 20306 || readShort == 21330;
                c0220b2.close();
                return z10;
            } catch (Exception unused) {
                c0220b = c0220b2;
                if (c0220b != null) {
                    c0220b.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                c0220b = c0220b2;
                if (c0220b != null) {
                    c0220b.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean u(byte[] bArr) {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = G;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }

    public final boolean v(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i10 = 0; i10 < bytes.length; i10++) {
            if (bArr[i10] != bytes[i10]) {
                return false;
            }
        }
        return true;
    }

    public final boolean w(byte[] bArr) {
        C0220b c0220b = null;
        try {
            C0220b c0220b2 = new C0220b(bArr);
            try {
                ByteOrder E2 = E(c0220b2);
                this.f13519h = E2;
                c0220b2.c(E2);
                boolean z10 = c0220b2.readShort() == 85;
                c0220b2.close();
                return z10;
            } catch (Exception unused) {
                c0220b = c0220b2;
                if (c0220b != null) {
                    c0220b.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                c0220b = c0220b2;
                if (c0220b != null) {
                    c0220b.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean y(HashMap hashMap) {
        c cVar;
        c cVar2 = (c) hashMap.get("BitsPerSample");
        if (cVar2 == null) {
            return false;
        }
        int[] iArr = (int[]) cVar2.k(this.f13519h);
        int[] iArr2 = f13509x;
        if (Arrays.equals(iArr2, iArr)) {
            return true;
        }
        if (this.f13515d != 3 || (cVar = (c) hashMap.get("PhotometricInterpretation")) == null) {
            return false;
        }
        int i10 = cVar.i(this.f13519h);
        return (i10 == 1 && Arrays.equals(iArr, f13511z)) || (i10 == 6 && Arrays.equals(iArr, iArr2));
    }

    public final boolean z(HashMap hashMap) {
        c cVar = (c) hashMap.get("ImageLength");
        c cVar2 = (c) hashMap.get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            return false;
        }
        return cVar.i(this.f13519h) <= 512 && cVar2.i(this.f13519h) <= 512;
    }

    public static class f extends C0220b {
        public f(byte[] bArr) {
            super(bArr);
            this.f13537a.mark(Integer.MAX_VALUE);
        }

        public void f(long j10) {
            int i10 = this.f13539c;
            if (i10 > j10) {
                this.f13539c = 0;
                this.f13537a.reset();
            } else {
                j10 -= i10;
            }
            e((int) j10);
        }

        public f(InputStream inputStream) {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f13537a.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    public b(InputStream inputStream, int i10) {
        d[][] dVarArr = f13493i0;
        this.f13517f = new HashMap[dVarArr.length];
        this.f13518g = new HashSet(dVarArr.length);
        this.f13519h = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new NullPointerException("inputStream cannot be null");
        }
        this.f13512a = null;
        if (i10 == 1) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, f13500p0.length);
            if (!q(bufferedInputStream)) {
                return;
            }
            this.f13516e = true;
            this.f13514c = null;
            this.f13513b = null;
            inputStream = bufferedInputStream;
        } else if (inputStream instanceof AssetManager.AssetInputStream) {
            this.f13514c = (AssetManager.AssetInputStream) inputStream;
            this.f13513b = null;
        } else {
            if (inputStream instanceof FileInputStream) {
                FileInputStream fileInputStream = (FileInputStream) inputStream;
                if (x(fileInputStream.getFD())) {
                    this.f13514c = null;
                    this.f13513b = fileInputStream.getFD();
                }
            }
            this.f13514c = null;
            this.f13513b = null;
        }
        B(inputStream);
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f13545a;

        /* renamed from: b, reason: collision with root package name */
        public final String f13546b;

        /* renamed from: c, reason: collision with root package name */
        public final int f13547c;

        /* renamed from: d, reason: collision with root package name */
        public final int f13548d;

        public d(String str, int i10, int i11) {
            this.f13546b = str;
            this.f13545a = i10;
            this.f13547c = i11;
            this.f13548d = -1;
        }

        public boolean a(int i10) {
            int i11;
            int i12 = this.f13547c;
            if (i12 == 7 || i10 == 7 || i12 == i10 || (i11 = this.f13548d) == i10) {
                return true;
            }
            if ((i12 == 4 || i11 == 4) && i10 == 3) {
                return true;
            }
            if ((i12 == 9 || i11 == 9) && i10 == 8) {
                return true;
            }
            return (i12 == 12 || i11 == 12) && i10 == 11;
        }

        public d(String str, int i10, int i11, int i12) {
            this.f13546b = str;
            this.f13545a = i10;
            this.f13547c = i11;
            this.f13548d = i12;
        }
    }
}
