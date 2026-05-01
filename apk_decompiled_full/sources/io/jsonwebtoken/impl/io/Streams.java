package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.io.IOException;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Strings;
import java.io.ByteArrayOutputStream;
import java.io.Flushable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public class Streams {
    public static final int EOF = -1;

    public static byte[] bytes(InputStream inputStream, String str) {
        if (inputStream instanceof BytesInputStream) {
            return ((BytesInputStream) inputStream).getBytes();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        copy(inputStream, byteArrayOutputStream, new byte[8192], str);
        return byteArrayOutputStream.toByteArray();
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        Assert.notNull(inputStream, "inputStream cannot be null.");
        Assert.notNull(outputStream, "outputStream cannot be null.");
        Assert.notEmpty(bArr, "buffer cannot be null or empty.");
        long j10 = 0;
        int i10 = 0;
        while (i10 != -1) {
            i10 = inputStream.read(bArr);
            if (i10 > 0) {
                outputStream.write(bArr, 0, i10);
            }
            j10 += i10;
        }
        return j10;
    }

    public static void flush(Flushable... flushableArr) {
        Objects.nullSafeFlush(flushableArr);
    }

    public static InputStream of(byte[] bArr) {
        return new BytesInputStream(bArr);
    }

    public static Reader reader(byte[] bArr) {
        return reader(of(bArr));
    }

    public static void reset(final InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            new Callable<Object>() { // from class: io.jsonwebtoken.impl.io.Streams.2
                @Override // java.util.concurrent.Callable
                public Object call() {
                    try {
                        inputStream.reset();
                        return null;
                    } catch (Throwable unused) {
                        return null;
                    }
                }
            }.call();
        } catch (Throwable unused) {
        }
    }

    public static <V> V run(Callable<V> callable, String str) {
        Assert.hasText(str, "IO Exception Message cannot be null or empty.");
        try {
            return callable.call();
        } catch (Throwable th) {
            String str2 = "IO failure: " + str;
            if (!str2.endsWith(".")) {
                str2 = str2 + ".";
            }
            throw new IOException(str2 + " Cause: " + th.getMessage(), th);
        }
    }

    public static void write(OutputStream outputStream, byte[] bArr, String str) {
        write(outputStream, bArr, 0, Bytes.length(bArr), str);
    }

    public static void writeAndClose(OutputStream outputStream, byte[] bArr, String str) {
        try {
            write(outputStream, bArr, str);
            Objects.nullSafeClose(outputStream);
        } catch (Throwable th) {
            Objects.nullSafeClose(outputStream);
            throw th;
        }
    }

    public static InputStream of(CharSequence charSequence) {
        return of(Strings.utf8(charSequence));
    }

    public static Reader reader(InputStream inputStream) {
        return new InputStreamReader(inputStream, Strings.UTF_8);
    }

    public static void write(final OutputStream outputStream, final byte[] bArr, final int i10, final int i11, String str) {
        if (outputStream == null || Bytes.isEmpty(bArr) || i11 <= 0) {
            return;
        }
        run(new Callable<Object>() { // from class: io.jsonwebtoken.impl.io.Streams.3
            @Override // java.util.concurrent.Callable
            public Object call() {
                outputStream.write(bArr, i10, i11);
                return null;
            }
        }, str);
    }

    public static Reader reader(CharSequence charSequence) {
        return new CharSequenceReader(charSequence);
    }

    public static long copy(final InputStream inputStream, final OutputStream outputStream, final byte[] bArr, String str) {
        return ((Long) run(new Callable<Long>() { // from class: io.jsonwebtoken.impl.io.Streams.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Long call() {
                try {
                    Streams.reset(inputStream);
                    Long valueOf = Long.valueOf(Streams.copy(inputStream, outputStream, bArr));
                    Objects.nullSafeFlush(outputStream);
                    Streams.reset(inputStream);
                    return valueOf;
                } catch (Throwable th) {
                    Objects.nullSafeFlush(outputStream);
                    Streams.reset(inputStream);
                    throw th;
                }
            }
        }, str)).longValue();
    }
}
