package okio;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    Buffer buffer();

    BufferedSink emit();

    BufferedSink emitCompleteSegments();

    @Override // okio.Sink, java.io.Flushable
    void flush();

    OutputStream outputStream();

    BufferedSink write(ByteString byteString);

    BufferedSink write(Source source, long j10);

    BufferedSink write(byte[] bArr);

    BufferedSink write(byte[] bArr, int i10, int i11);

    long writeAll(Source source);

    BufferedSink writeByte(int i10);

    BufferedSink writeDecimalLong(long j10);

    BufferedSink writeHexadecimalUnsignedLong(long j10);

    BufferedSink writeInt(int i10);

    BufferedSink writeIntLe(int i10);

    BufferedSink writeLong(long j10);

    BufferedSink writeLongLe(long j10);

    BufferedSink writeShort(int i10);

    BufferedSink writeShortLe(int i10);

    BufferedSink writeString(String str, int i10, int i11, Charset charset);

    BufferedSink writeString(String str, Charset charset);

    BufferedSink writeUtf8(String str);

    BufferedSink writeUtf8(String str, int i10, int i11);

    BufferedSink writeUtf8CodePoint(int i10);
}
