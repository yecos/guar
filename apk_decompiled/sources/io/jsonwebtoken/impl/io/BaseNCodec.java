package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.lang.Strings;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes3.dex */
abstract class BaseNCodec {
    private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    static final int EOF = -1;
    protected static final int MASK_8BITS = 255;
    private static final int MAX_BUFFER_SIZE = 2147483639;
    public static final int MIME_CHUNK_SIZE = 76;
    protected static final byte PAD_DEFAULT = 61;
    private final int chunkSeparatorLength;
    private final CodecPolicy decodingPolicy;
    private final int encodedBlockSize;
    protected final int lineLength;
    protected final byte pad;
    private final int unencodedBlockSize;
    protected static final CodecPolicy DECODING_POLICY_DEFAULT = CodecPolicy.LENIENT;
    static final byte[] CHUNK_SEPARATOR = {13, 10};

    public static class Context {
        byte[] buffer;
        int currentLinePos;
        boolean eof;
        int ibitWorkArea;
        long lbitWorkArea;
        int modulus;
        int pos;
        int readPos;

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.currentLinePos), Boolean.valueOf(this.eof), Integer.valueOf(this.ibitWorkArea), Long.valueOf(this.lbitWorkArea), Integer.valueOf(this.modulus), Integer.valueOf(this.pos), Integer.valueOf(this.readPos));
        }
    }

    public BaseNCodec(int i10, int i11, int i12, int i13) {
        this(i10, i11, i12, i13, PAD_DEFAULT);
    }

    private static int compareUnsigned(int i10, int i11) {
        return Integer.compare(i10 - 2147483648, i11 - 2147483648);
    }

    private static int createPositiveCapacity(int i10) {
        if (i10 >= 0) {
            return Math.max(i10, MAX_BUFFER_SIZE);
        }
        throw new OutOfMemoryError("Unable to allocate array size: " + (i10 & 4294967295L));
    }

    public static boolean isEmpty(byte[] bArr) {
        return length(bArr) == 0;
    }

    @Deprecated
    public static boolean isWhiteSpace(byte b10) {
        return Character.isWhitespace(b10);
    }

    public static int length(byte[] bArr) {
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    private static byte[] resizeBuffer(Context context, int i10) {
        int length = context.buffer.length * 2;
        if (compareUnsigned(length, i10) < 0) {
            length = i10;
        }
        if (compareUnsigned(length, MAX_BUFFER_SIZE) > 0) {
            length = createPositiveCapacity(i10);
        }
        byte[] copyOf = Arrays.copyOf(context.buffer, length);
        context.buffer = copyOf;
        return copyOf;
    }

    public int available(Context context) {
        if (hasData(context)) {
            return context.pos - context.readPos;
        }
        return 0;
    }

    public boolean containsAlphabetOrPad(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b10 : bArr) {
            if (this.pad == b10 || isInAlphabet(b10)) {
                return true;
            }
        }
        return false;
    }

    public abstract void decode(byte[] bArr, int i10, int i11, Context context);

    public byte[] decode(byte[] bArr) {
        if (isEmpty(bArr)) {
            return bArr;
        }
        Context context = new Context();
        decode(bArr, 0, bArr.length, context);
        decode(bArr, 0, -1, context);
        int i10 = context.pos;
        byte[] bArr2 = new byte[i10];
        readResults(bArr2, 0, i10, context);
        return bArr2;
    }

    public abstract void encode(byte[] bArr, int i10, int i11, Context context);

    public byte[] encode(byte[] bArr) {
        return isEmpty(bArr) ? bArr : encode(bArr, 0, bArr.length);
    }

    public String encodeAsString(byte[] bArr) {
        return Strings.utf8(encode(bArr));
    }

    public String encodeToString(byte[] bArr) {
        return Strings.utf8(encode(bArr));
    }

    public byte[] ensureBufferSize(int i10, Context context) {
        byte[] bArr = context.buffer;
        if (bArr == null) {
            context.buffer = new byte[Math.max(i10, getDefaultBufferSize())];
            context.pos = 0;
            context.readPos = 0;
        } else {
            int i11 = context.pos;
            if ((i11 + i10) - bArr.length > 0) {
                return resizeBuffer(context, i11 + i10);
            }
        }
        return context.buffer;
    }

    public int getDefaultBufferSize() {
        return 8192;
    }

    public long getEncodedLength(byte[] bArr) {
        int length = bArr.length;
        int i10 = this.unencodedBlockSize;
        long j10 = (((length + i10) - 1) / i10) * this.encodedBlockSize;
        int i11 = this.lineLength;
        return i11 > 0 ? j10 + ((((i11 + j10) - 1) / i11) * this.chunkSeparatorLength) : j10;
    }

    public boolean hasData(Context context) {
        return context.pos > context.readPos;
    }

    public abstract boolean isInAlphabet(byte b10);

    public boolean isInAlphabet(byte[] bArr, boolean z10) {
        for (byte b10 : bArr) {
            if (!isInAlphabet(b10) && (!z10 || (b10 != this.pad && !Character.isWhitespace(b10)))) {
                return false;
            }
        }
        return true;
    }

    public boolean isStrictDecoding() {
        return this.decodingPolicy == CodecPolicy.STRICT;
    }

    public int readResults(byte[] bArr, int i10, int i11, Context context) {
        if (!hasData(context)) {
            return context.eof ? -1 : 0;
        }
        int min = Math.min(available(context), i11);
        System.arraycopy(context.buffer, context.readPos, bArr, i10, min);
        context.readPos += min;
        if (!hasData(context)) {
            context.readPos = 0;
            context.pos = 0;
        }
        return min;
    }

    public BaseNCodec(int i10, int i11, int i12, int i13, byte b10) {
        this(i10, i11, i12, i13, b10, DECODING_POLICY_DEFAULT);
    }

    public BaseNCodec(int i10, int i11, int i12, int i13, byte b10, CodecPolicy codecPolicy) {
        this.unencodedBlockSize = i10;
        this.encodedBlockSize = i11;
        this.lineLength = i12 > 0 && i13 > 0 ? (i12 / i11) * i11 : 0;
        this.chunkSeparatorLength = i13;
        this.pad = b10;
        Objects.requireNonNull(codecPolicy, "codecPolicy");
        this.decodingPolicy = codecPolicy;
    }

    public byte[] encode(byte[] bArr, int i10, int i11) {
        if (isEmpty(bArr)) {
            return bArr;
        }
        Context context = new Context();
        encode(bArr, i10, i11, context);
        encode(bArr, i10, -1, context);
        int i12 = context.pos - context.readPos;
        byte[] bArr2 = new byte[i12];
        readResults(bArr2, 0, i12, context);
        return bArr2;
    }

    public boolean isInAlphabet(String str) {
        return isInAlphabet(Strings.utf8(str), true);
    }

    public byte[] decode(String str) {
        return decode(Strings.utf8(str));
    }
}
