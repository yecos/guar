package a5;

import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class a {
    public static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static d b(FileChannel fileChannel) {
        return c(fileChannel, d(fileChannel));
    }

    public static d c(FileChannel fileChannel, long j10) {
        if (j10 < 32) {
            throw new f("APK too small for APK Signing Block. ZIP Central Directory offset: " + j10);
        }
        fileChannel.position(j10 - 24);
        ByteBuffer allocate = ByteBuffer.allocate(24);
        fileChannel.read(allocate);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        allocate.order(byteOrder);
        if (allocate.getLong(8) != 2334950737559900225L || allocate.getLong(16) != 3617552046287187010L) {
            throw new f("No APK Signing Block before ZIP Central Directory");
        }
        long j11 = allocate.getLong(0);
        if (j11 < allocate.capacity() || j11 > 2147483639) {
            throw new f("APK Signing Block size out of range: " + j11);
        }
        int i10 = (int) (8 + j11);
        long j12 = j10 - i10;
        if (j12 < 0) {
            throw new f("APK Signing Block offset out of range: " + j12);
        }
        fileChannel.position(j12);
        ByteBuffer allocate2 = ByteBuffer.allocate(i10);
        fileChannel.read(allocate2);
        allocate2.order(byteOrder);
        long j13 = allocate2.getLong(0);
        if (j13 == j11) {
            return d.b(allocate2, Long.valueOf(j12));
        }
        throw new f("APK Signing Block sizes in header and footer do not match: " + j13 + " vs " + j11);
    }

    public static long d(FileChannel fileChannel) {
        return e(fileChannel, h(fileChannel));
    }

    public static long e(FileChannel fileChannel, long j10) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        fileChannel.position((fileChannel.size() - j10) - 6);
        fileChannel.read(allocate);
        return allocate.getInt(0);
    }

    public static Map f(ByteBuffer byteBuffer) {
        a(byteBuffer);
        ByteBuffer i10 = i(byteBuffer, 8, byteBuffer.capacity() - 24);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i11 = 0;
        while (i10.hasRemaining()) {
            i11++;
            if (i10.remaining() < 8) {
                throw new f("Insufficient data to read size of APK Signing Block entry #" + i11);
            }
            long j10 = i10.getLong();
            if (j10 < 4 || j10 > TTL.MAX_VALUE) {
                throw new f("APK Signing Block entry #" + i11 + " size out of range: " + j10);
            }
            int i12 = (int) j10;
            int position = i10.position() + i12;
            if (i12 > i10.remaining()) {
                throw new f("APK Signing Block entry #" + i11 + " size out of range: " + i12 + ", available: " + i10.remaining());
            }
            linkedHashMap.put(Integer.valueOf(i10.getInt()), g(i10, i12 - 4));
            i10.position(position);
        }
        return linkedHashMap;
    }

    public static ByteBuffer g(ByteBuffer byteBuffer, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("size: " + i10);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i11 = i10 + position;
        if (i11 < position || i11 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i11);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i11);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    public static long h(FileChannel fileChannel) {
        long size = fileChannel.size();
        if (size < 22) {
            throw new IOException("APK too small for ZIP End of Central Directory (EOCD) record");
        }
        long j10 = size - 22;
        long min = Math.min(j10, 65535L);
        int i10 = 0;
        while (true) {
            long j11 = i10;
            if (j11 > min) {
                throw new IOException("ZIP End of Central Directory (EOCD) record not found");
            }
            long j12 = j10 - j11;
            ByteBuffer allocate = ByteBuffer.allocate(4);
            fileChannel.position(j12);
            fileChannel.read(allocate);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            if (allocate.getInt(0) == 101010256) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2);
                fileChannel.position(j12 + 20);
                fileChannel.read(allocate2);
                allocate2.order(byteOrder);
                short s10 = allocate2.getShort(0);
                if (s10 == i10) {
                    return s10;
                }
            }
            i10++;
        }
    }

    public static ByteBuffer i(ByteBuffer byteBuffer, int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException("start: " + i10);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("end < start: " + i11 + " < " + i10);
        }
        int capacity = byteBuffer.capacity();
        if (i11 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i11 + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i11);
            byteBuffer.position(i10);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }
}
