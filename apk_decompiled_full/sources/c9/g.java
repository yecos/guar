package c9;

import c9.b;
import c9.f;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* loaded from: classes3.dex */
public final class g implements j {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f5702a = Logger.getLogger(b.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final ByteString f5703b = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    public static final class a implements Source {

        /* renamed from: a, reason: collision with root package name */
        public final BufferedSource f5704a;

        /* renamed from: b, reason: collision with root package name */
        public int f5705b;

        /* renamed from: c, reason: collision with root package name */
        public byte f5706c;

        /* renamed from: d, reason: collision with root package name */
        public int f5707d;

        /* renamed from: e, reason: collision with root package name */
        public int f5708e;

        /* renamed from: f, reason: collision with root package name */
        public short f5709f;

        public a(BufferedSource bufferedSource) {
            this.f5704a = bufferedSource;
        }

        public final void a() {
            int i10 = this.f5707d;
            int m10 = g.m(this.f5704a);
            this.f5708e = m10;
            this.f5705b = m10;
            byte readByte = (byte) (this.f5704a.readByte() & UnsignedBytes.MAX_VALUE);
            this.f5706c = (byte) (this.f5704a.readByte() & UnsignedBytes.MAX_VALUE);
            if (g.f5702a.isLoggable(Level.FINE)) {
                g.f5702a.fine(b.b(true, this.f5707d, this.f5705b, readByte, this.f5706c));
            }
            int readInt = this.f5704a.readInt() & Integer.MAX_VALUE;
            this.f5707d = readInt;
            if (readByte != 9) {
                throw g.k("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            }
            if (readInt != i10) {
                throw g.k("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j10) {
            while (true) {
                int i10 = this.f5708e;
                if (i10 != 0) {
                    long read = this.f5704a.read(buffer, Math.min(j10, i10));
                    if (read == -1) {
                        return -1L;
                    }
                    this.f5708e -= (int) read;
                    return read;
                }
                this.f5704a.skip(this.f5709f);
                this.f5709f = (short) 0;
                if ((this.f5706c & 4) != 0) {
                    return -1L;
                }
                a();
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.f5704a.timeout();
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f5710a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f5711b = new String[64];

        /* renamed from: c, reason: collision with root package name */
        public static final String[] f5712c = new String[256];

        static {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                String[] strArr = f5712c;
                if (i11 >= strArr.length) {
                    break;
                }
                strArr[i11] = String.format("%8s", Integer.toBinaryString(i11)).replace(' ', '0');
                i11++;
            }
            String[] strArr2 = f5711b;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            int i12 = iArr[0];
            strArr2[i12 | 8] = strArr2[i12] + "|PADDED";
            strArr2[4] = "END_HEADERS";
            strArr2[32] = "PRIORITY";
            strArr2[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i13 = 0; i13 < 3; i13++) {
                int i14 = iArr2[i13];
                int i15 = iArr[0];
                String[] strArr3 = f5711b;
                int i16 = i15 | i14;
                strArr3[i16] = strArr3[i15] + '|' + strArr3[i14];
                strArr3[i16 | 8] = strArr3[i15] + '|' + strArr3[i14] + "|PADDED";
            }
            while (true) {
                String[] strArr4 = f5711b;
                if (i10 >= strArr4.length) {
                    return;
                }
                if (strArr4[i10] == null) {
                    strArr4[i10] = f5712c[i10];
                }
                i10++;
            }
        }

        public static String a(byte b10, byte b11) {
            if (b11 == 0) {
                return "";
            }
            if (b10 != 2 && b10 != 3) {
                if (b10 == 4 || b10 == 6) {
                    return b11 == 1 ? "ACK" : f5712c[b11];
                }
                if (b10 != 7 && b10 != 8) {
                    String[] strArr = f5711b;
                    String str = b11 < strArr.length ? strArr[b11] : f5712c[b11];
                    return (b10 != 5 || (b11 & 4) == 0) ? (b10 != 0 || (b11 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            return f5712c[b11];
        }

        public static String b(boolean z10, int i10, int i11, byte b10, byte b11) {
            String[] strArr = f5710a;
            String format = b10 < strArr.length ? strArr[b10] : String.format("0x%02x", Byte.valueOf(b10));
            String a10 = a(b10, b11);
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = z10 ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i10);
            objArr[2] = Integer.valueOf(i11);
            objArr[3] = format;
            objArr[4] = a10;
            return String.format(locale, "%s 0x%08x %5d %-13s %s", objArr);
        }
    }

    public static final class c implements c9.b {

        /* renamed from: a, reason: collision with root package name */
        public final BufferedSource f5713a;

        /* renamed from: b, reason: collision with root package name */
        public final a f5714b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f5715c;

        /* renamed from: d, reason: collision with root package name */
        public final f.a f5716d;

        public c(BufferedSource bufferedSource, int i10, boolean z10) {
            this.f5713a = bufferedSource;
            this.f5715c = z10;
            a aVar = new a(bufferedSource);
            this.f5714b = aVar;
            this.f5716d = new f.a(i10, aVar);
        }

        public final void a(b.a aVar, int i10, byte b10, int i11) {
            boolean z10 = (b10 & 1) != 0;
            if ((b10 & 32) != 0) {
                throw g.k("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            short readByte = (b10 & 8) != 0 ? (short) (this.f5713a.readByte() & UnsignedBytes.MAX_VALUE) : (short) 0;
            aVar.data(z10, i11, this.f5713a, g.l(i10, b10, readByte));
            this.f5713a.skip(readByte);
        }

        public final void b(b.a aVar, int i10, byte b10, int i11) {
            if (i10 < 8) {
                throw g.k("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i10));
            }
            if (i11 != 0) {
                throw g.k("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            int readInt = this.f5713a.readInt();
            int readInt2 = this.f5713a.readInt();
            int i12 = i10 - 8;
            c9.a a10 = c9.a.a(readInt2);
            if (a10 == null) {
                throw g.k("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            }
            ByteString byteString = ByteString.EMPTY;
            if (i12 > 0) {
                byteString = this.f5713a.readByteString(i12);
            }
            aVar.f(readInt, a10, byteString);
        }

        public final List c(int i10, short s10, byte b10, int i11) {
            a aVar = this.f5714b;
            aVar.f5708e = i10;
            aVar.f5705b = i10;
            aVar.f5709f = s10;
            aVar.f5706c = b10;
            aVar.f5707d = i11;
            this.f5716d.l();
            return this.f5716d.e();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f5713a.close();
        }

        public final void e(b.a aVar, int i10, byte b10, int i11) {
            if (i11 == 0) {
                throw g.k("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            boolean z10 = (b10 & 1) != 0;
            short readByte = (b10 & 8) != 0 ? (short) (this.f5713a.readByte() & UnsignedBytes.MAX_VALUE) : (short) 0;
            if ((b10 & 32) != 0) {
                m(aVar, i11);
                i10 -= 5;
            }
            aVar.e(false, z10, i11, -1, c(g.l(i10, b10, readByte), readByte, b10, i11), e.HTTP_20_HEADERS);
        }

        public final void f(b.a aVar, int i10, byte b10, int i11) {
            if (i10 != 8) {
                throw g.k("TYPE_PING length != 8: %s", Integer.valueOf(i10));
            }
            if (i11 != 0) {
                throw g.k("TYPE_PING streamId != 0", new Object[0]);
            }
            aVar.ping((b10 & 1) != 0, this.f5713a.readInt(), this.f5713a.readInt());
        }

        public final void m(b.a aVar, int i10) {
            int readInt = this.f5713a.readInt();
            aVar.priority(i10, readInt & Integer.MAX_VALUE, (this.f5713a.readByte() & UnsignedBytes.MAX_VALUE) + 1, (Integer.MIN_VALUE & readInt) != 0);
        }

        public final void n(b.a aVar, int i10, byte b10, int i11) {
            if (i10 != 5) {
                throw g.k("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i10));
            }
            if (i11 == 0) {
                throw g.k("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            m(aVar, i11);
        }

        public final void q(b.a aVar, int i10, byte b10, int i11) {
            if (i11 == 0) {
                throw g.k("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            short readByte = (b10 & 8) != 0 ? (short) (this.f5713a.readByte() & UnsignedBytes.MAX_VALUE) : (short) 0;
            aVar.pushPromise(i11, this.f5713a.readInt() & Integer.MAX_VALUE, c(g.l(i10 - 4, b10, readByte), readByte, b10, i11));
        }

        public final void s(b.a aVar, int i10, byte b10, int i11) {
            if (i10 != 4) {
                throw g.k("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i10));
            }
            if (i11 == 0) {
                throw g.k("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            int readInt = this.f5713a.readInt();
            c9.a a10 = c9.a.a(readInt);
            if (a10 == null) {
                throw g.k("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            }
            aVar.d(i11, a10);
        }

        @Override // c9.b
        public boolean t(b.a aVar) {
            try {
                this.f5713a.require(9L);
                int m10 = g.m(this.f5713a);
                if (m10 < 0 || m10 > 16384) {
                    throw g.k("FRAME_SIZE_ERROR: %s", Integer.valueOf(m10));
                }
                byte readByte = (byte) (this.f5713a.readByte() & UnsignedBytes.MAX_VALUE);
                byte readByte2 = (byte) (this.f5713a.readByte() & UnsignedBytes.MAX_VALUE);
                int readInt = this.f5713a.readInt() & Integer.MAX_VALUE;
                if (g.f5702a.isLoggable(Level.FINE)) {
                    g.f5702a.fine(b.b(true, readInt, m10, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        a(aVar, m10, readByte2, readInt);
                        return true;
                    case 1:
                        e(aVar, m10, readByte2, readInt);
                        return true;
                    case 2:
                        n(aVar, m10, readByte2, readInt);
                        return true;
                    case 3:
                        s(aVar, m10, readByte2, readInt);
                        return true;
                    case 4:
                        u(aVar, m10, readByte2, readInt);
                        return true;
                    case 5:
                        q(aVar, m10, readByte2, readInt);
                        return true;
                    case 6:
                        f(aVar, m10, readByte2, readInt);
                        return true;
                    case 7:
                        b(aVar, m10, readByte2, readInt);
                        return true;
                    case 8:
                        v(aVar, m10, readByte2, readInt);
                        return true;
                    default:
                        this.f5713a.skip(m10);
                        return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public final void u(b.a aVar, int i10, byte b10, int i11) {
            if (i11 != 0) {
                throw g.k("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((b10 & 1) != 0) {
                if (i10 != 0) {
                    throw g.k("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                aVar.ackSettings();
                return;
            }
            if (i10 % 6 != 0) {
                throw g.k("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i10));
            }
            i iVar = new i();
            for (int i12 = 0; i12 < i10; i12 += 6) {
                short readShort = this.f5713a.readShort();
                int readInt = this.f5713a.readInt();
                switch (readShort) {
                    case 1:
                    case 6:
                        iVar.e(readShort, 0, readInt);
                    case 2:
                        if (readInt != 0 && readInt != 1) {
                            throw g.k("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                        iVar.e(readShort, 0, readInt);
                    case 3:
                        readShort = 4;
                        iVar.e(readShort, 0, readInt);
                    case 4:
                        if (readInt < 0) {
                            throw g.k("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                        readShort = 7;
                        iVar.e(readShort, 0, readInt);
                    case 5:
                        if (readInt < 16384 || readInt > 16777215) {
                            throw g.k("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        }
                        iVar.e(readShort, 0, readInt);
                        break;
                    default:
                }
            }
            aVar.g(false, iVar);
            if (iVar.b() >= 0) {
                this.f5716d.g(iVar.b());
            }
        }

        public final void v(b.a aVar, int i10, byte b10, int i11) {
            if (i10 != 4) {
                throw g.k("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i10));
            }
            long readInt = this.f5713a.readInt() & TTL.MAX_VALUE;
            if (readInt == 0) {
                throw g.k("windowSizeIncrement was 0", new Object[0]);
            }
            aVar.windowUpdate(i11, readInt);
        }
    }

    public static final class d implements c9.c {

        /* renamed from: a, reason: collision with root package name */
        public final BufferedSink f5717a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f5718b;

        /* renamed from: c, reason: collision with root package name */
        public final Buffer f5719c;

        /* renamed from: d, reason: collision with root package name */
        public final f.b f5720d;

        /* renamed from: e, reason: collision with root package name */
        public int f5721e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f5722f;

        public d(BufferedSink bufferedSink, boolean z10) {
            this.f5717a = bufferedSink;
            this.f5718b = z10;
            Buffer buffer = new Buffer();
            this.f5719c = buffer;
            this.f5720d = new f.b(buffer);
            this.f5721e = 16384;
        }

        @Override // c9.c
        public synchronized void F(i iVar) {
            if (this.f5722f) {
                throw new IOException("closed");
            }
            int i10 = 0;
            b(0, iVar.f() * 6, (byte) 4, (byte) 0);
            while (i10 < 10) {
                if (iVar.d(i10)) {
                    this.f5717a.writeShort(i10 == 4 ? 3 : i10 == 7 ? 4 : i10);
                    this.f5717a.writeInt(iVar.a(i10));
                }
                i10++;
            }
            this.f5717a.flush();
        }

        @Override // c9.c
        public synchronized void K(boolean z10, boolean z11, int i10, int i11, List list) {
            try {
                if (z11) {
                    throw new UnsupportedOperationException();
                }
                if (this.f5722f) {
                    throw new IOException("closed");
                }
                c(z10, i10, list);
            } catch (Throwable th) {
                throw th;
            }
        }

        public void a(int i10, byte b10, Buffer buffer, int i11) {
            b(i10, i11, (byte) 0, b10);
            if (i11 > 0) {
                this.f5717a.write(buffer, i11);
            }
        }

        public void b(int i10, int i11, byte b10, byte b11) {
            if (g.f5702a.isLoggable(Level.FINE)) {
                g.f5702a.fine(b.b(false, i10, i11, b10, b11));
            }
            int i12 = this.f5721e;
            if (i11 > i12) {
                throw g.j("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i12), Integer.valueOf(i11));
            }
            if ((Integer.MIN_VALUE & i10) != 0) {
                throw g.j("reserved bit set: %s", Integer.valueOf(i10));
            }
            g.n(this.f5717a, i11);
            this.f5717a.writeByte(b10 & UnsignedBytes.MAX_VALUE);
            this.f5717a.writeByte(b11 & UnsignedBytes.MAX_VALUE);
            this.f5717a.writeInt(i10 & Integer.MAX_VALUE);
        }

        public void c(boolean z10, int i10, List list) {
            if (this.f5722f) {
                throw new IOException("closed");
            }
            this.f5720d.e(list);
            long size = this.f5719c.size();
            int min = (int) Math.min(this.f5721e, size);
            long j10 = min;
            byte b10 = size == j10 ? (byte) 4 : (byte) 0;
            if (z10) {
                b10 = (byte) (b10 | 1);
            }
            b(i10, min, (byte) 1, b10);
            this.f5717a.write(this.f5719c, j10);
            if (size > j10) {
                e(i10, size - j10);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            this.f5722f = true;
            this.f5717a.close();
        }

        @Override // c9.c
        public synchronized void connectionPreface() {
            if (this.f5722f) {
                throw new IOException("closed");
            }
            if (this.f5718b) {
                if (g.f5702a.isLoggable(Level.FINE)) {
                    g.f5702a.fine(String.format(">> CONNECTION %s", g.f5703b.hex()));
                }
                this.f5717a.write(g.f5703b.toByteArray());
                this.f5717a.flush();
            }
        }

        @Override // c9.c
        public synchronized void d(int i10, c9.a aVar) {
            if (this.f5722f) {
                throw new IOException("closed");
            }
            if (aVar.f5663a == -1) {
                throw new IllegalArgumentException();
            }
            b(i10, 4, (byte) 3, (byte) 0);
            this.f5717a.writeInt(aVar.f5663a);
            this.f5717a.flush();
        }

        @Override // c9.c
        public synchronized void data(boolean z10, int i10, Buffer buffer, int i11) {
            if (this.f5722f) {
                throw new IOException("closed");
            }
            a(i10, z10 ? (byte) 1 : (byte) 0, buffer, i11);
        }

        public final void e(int i10, long j10) {
            while (j10 > 0) {
                int min = (int) Math.min(this.f5721e, j10);
                long j11 = min;
                j10 -= j11;
                b(i10, min, (byte) 9, j10 == 0 ? (byte) 4 : (byte) 0);
                this.f5717a.write(this.f5719c, j11);
            }
        }

        @Override // c9.c
        public synchronized void flush() {
            if (this.f5722f) {
                throw new IOException("closed");
            }
            this.f5717a.flush();
        }

        @Override // c9.c
        public synchronized void g(i iVar) {
            if (this.f5722f) {
                throw new IOException("closed");
            }
            this.f5721e = iVar.c(this.f5721e);
            b(0, 0, (byte) 4, (byte) 1);
            this.f5717a.flush();
        }

        @Override // c9.c
        public int maxDataLength() {
            return this.f5721e;
        }

        @Override // c9.c
        public synchronized void o(int i10, c9.a aVar, byte[] bArr) {
            if (this.f5722f) {
                throw new IOException("closed");
            }
            if (aVar.f5663a == -1) {
                throw g.j("errorCode.httpCode == -1", new Object[0]);
            }
            b(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f5717a.writeInt(i10);
            this.f5717a.writeInt(aVar.f5663a);
            if (bArr.length > 0) {
                this.f5717a.write(bArr);
            }
            this.f5717a.flush();
        }

        @Override // c9.c
        public synchronized void ping(boolean z10, int i10, int i11) {
            if (this.f5722f) {
                throw new IOException("closed");
            }
            b(0, 8, (byte) 6, z10 ? (byte) 1 : (byte) 0);
            this.f5717a.writeInt(i10);
            this.f5717a.writeInt(i11);
            this.f5717a.flush();
        }

        @Override // c9.c
        public synchronized void windowUpdate(int i10, long j10) {
            if (this.f5722f) {
                throw new IOException("closed");
            }
            if (j10 == 0 || j10 > TTL.MAX_VALUE) {
                throw g.j("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j10));
            }
            b(i10, 4, (byte) 8, (byte) 0);
            this.f5717a.writeInt((int) j10);
            this.f5717a.flush();
        }
    }

    public static IllegalArgumentException j(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(Locale.US, str, objArr));
    }

    public static IOException k(String str, Object... objArr) {
        throw new IOException(String.format(Locale.US, str, objArr));
    }

    public static int l(int i10, byte b10, short s10) {
        if ((b10 & 8) != 0) {
            i10--;
        }
        if (s10 <= i10) {
            return (short) (i10 - s10);
        }
        throw k("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s10), Integer.valueOf(i10));
    }

    public static int m(BufferedSource bufferedSource) {
        return (bufferedSource.readByte() & UnsignedBytes.MAX_VALUE) | ((bufferedSource.readByte() & UnsignedBytes.MAX_VALUE) << 16) | ((bufferedSource.readByte() & UnsignedBytes.MAX_VALUE) << 8);
    }

    public static void n(BufferedSink bufferedSink, int i10) {
        bufferedSink.writeByte((i10 >>> 16) & 255);
        bufferedSink.writeByte((i10 >>> 8) & 255);
        bufferedSink.writeByte(i10 & 255);
    }

    @Override // c9.j
    public c9.b a(BufferedSource bufferedSource, boolean z10) {
        return new c(bufferedSource, 4096, z10);
    }

    @Override // c9.j
    public c9.c b(BufferedSink bufferedSink, boolean z10) {
        return new d(bufferedSink, z10);
    }
}
