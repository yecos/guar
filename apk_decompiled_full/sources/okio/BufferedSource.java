package okio;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    @Deprecated
    Buffer buffer();

    boolean exhausted();

    Buffer getBuffer();

    long indexOf(byte b10);

    long indexOf(byte b10, long j10);

    long indexOf(byte b10, long j10, long j11);

    long indexOf(ByteString byteString);

    long indexOf(ByteString byteString, long j10);

    long indexOfElement(ByteString byteString);

    long indexOfElement(ByteString byteString, long j10);

    InputStream inputStream();

    BufferedSource peek();

    boolean rangeEquals(long j10, ByteString byteString);

    boolean rangeEquals(long j10, ByteString byteString, int i10, int i11);

    int read(byte[] bArr);

    int read(byte[] bArr, int i10, int i11);

    long readAll(Sink sink);

    byte readByte();

    byte[] readByteArray();

    byte[] readByteArray(long j10);

    ByteString readByteString();

    ByteString readByteString(long j10);

    long readDecimalLong();

    void readFully(Buffer buffer, long j10);

    void readFully(byte[] bArr);

    long readHexadecimalUnsignedLong();

    int readInt();

    int readIntLe();

    long readLong();

    long readLongLe();

    short readShort();

    short readShortLe();

    String readString(long j10, Charset charset);

    String readString(Charset charset);

    String readUtf8();

    String readUtf8(long j10);

    int readUtf8CodePoint();

    @Nullable
    String readUtf8Line();

    String readUtf8LineStrict();

    String readUtf8LineStrict(long j10);

    boolean request(long j10);

    void require(long j10);

    int select(Options options);

    void skip(long j10);
}
