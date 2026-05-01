package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.CheckForNull;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class Murmur3_128HashFunction extends AbstractHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;
    static final HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
    static final HashFunction GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.GOOD_FAST_HASH_SEED);

    public static final class Murmur3_128Hasher extends AbstractStreamingHasher {
        private static final long C1 = -8663945395140668459L;
        private static final long C2 = 5545529020109919103L;
        private static final int CHUNK_SIZE = 16;

        /* renamed from: h1, reason: collision with root package name */
        private long f6882h1;

        /* renamed from: h2, reason: collision with root package name */
        private long f6883h2;
        private int length;

        public Murmur3_128Hasher(int i10) {
            super(16);
            long j10 = i10;
            this.f6882h1 = j10;
            this.f6883h2 = j10;
            this.length = 0;
        }

        private void bmix64(long j10, long j11) {
            long mixK1 = mixK1(j10) ^ this.f6882h1;
            this.f6882h1 = mixK1;
            long rotateLeft = Long.rotateLeft(mixK1, 27);
            long j12 = this.f6883h2;
            this.f6882h1 = ((rotateLeft + j12) * 5) + 1390208809;
            long mixK2 = mixK2(j11) ^ j12;
            this.f6883h2 = mixK2;
            this.f6883h2 = ((Long.rotateLeft(mixK2, 31) + this.f6882h1) * 5) + 944331445;
        }

        private static long fmix64(long j10) {
            long j11 = (j10 ^ (j10 >>> 33)) * (-49064778989728563L);
            long j12 = (j11 ^ (j11 >>> 33)) * (-4265267296055464877L);
            return j12 ^ (j12 >>> 33);
        }

        private static long mixK1(long j10) {
            return Long.rotateLeft(j10 * C1, 31) * C2;
        }

        private static long mixK2(long j10) {
            return Long.rotateLeft(j10 * C2, 33) * C1;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            long j10 = this.f6882h1;
            int i10 = this.length;
            long j11 = this.f6883h2 ^ i10;
            long j12 = (j10 ^ i10) + j11;
            this.f6882h1 = j12;
            this.f6883h2 = j11 + j12;
            this.f6882h1 = fmix64(j12);
            long fmix64 = fmix64(this.f6883h2);
            long j13 = this.f6882h1 + fmix64;
            this.f6882h1 = j13;
            this.f6883h2 = fmix64 + j13;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f6882h1).putLong(this.f6883h2).array());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void process(ByteBuffer byteBuffer) {
            bmix64(byteBuffer.getLong(), byteBuffer.getLong());
            this.length += 16;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void processRemaining(ByteBuffer byteBuffer) {
            long j10;
            long j11;
            long j12;
            long j13;
            long j14;
            long j15;
            long j16;
            long j17;
            long j18;
            long j19;
            long j20;
            long j21;
            long j22;
            long j23;
            this.length += byteBuffer.remaining();
            long j24 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j10 = 0;
                    j16 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j10;
                    this.f6882h1 ^= mixK1(j16);
                    this.f6883h2 ^= mixK2(j24);
                    return;
                case 2:
                    j11 = 0;
                    j10 = j11 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j16 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j10;
                    this.f6882h1 ^= mixK1(j16);
                    this.f6883h2 ^= mixK2(j24);
                    return;
                case 3:
                    j12 = 0;
                    j11 = j12 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j10 = j11 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j16 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j10;
                    this.f6882h1 ^= mixK1(j16);
                    this.f6883h2 ^= mixK2(j24);
                    return;
                case 4:
                    j13 = 0;
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j11 = j12 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j10 = j11 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j16 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j10;
                    this.f6882h1 ^= mixK1(j16);
                    this.f6883h2 ^= mixK2(j24);
                    return;
                case 5:
                    j14 = 0;
                    j13 = j14 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j11 = j12 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j10 = j11 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j16 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j10;
                    this.f6882h1 ^= mixK1(j16);
                    this.f6883h2 ^= mixK2(j24);
                    return;
                case 6:
                    j15 = 0;
                    j14 = j15 ^ (UnsignedBytes.toInt(byteBuffer.get(5)) << 40);
                    j13 = j14 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j11 = j12 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j10 = j11 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j16 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j10;
                    this.f6882h1 ^= mixK1(j16);
                    this.f6883h2 ^= mixK2(j24);
                    return;
                case 7:
                    j15 = (UnsignedBytes.toInt(byteBuffer.get(6)) << 48) ^ 0;
                    j14 = j15 ^ (UnsignedBytes.toInt(byteBuffer.get(5)) << 40);
                    j13 = j14 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j11 = j12 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j10 = j11 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j16 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j10;
                    this.f6882h1 ^= mixK1(j16);
                    this.f6883h2 ^= mixK2(j24);
                    return;
                case 8:
                    j17 = 0;
                    j16 = byteBuffer.getLong() ^ 0;
                    j24 = j17;
                    this.f6882h1 ^= mixK1(j16);
                    this.f6883h2 ^= mixK2(j24);
                    return;
                case 9:
                    j18 = 0;
                    j17 = j18 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j16 = byteBuffer.getLong() ^ 0;
                    j24 = j17;
                    this.f6882h1 ^= mixK1(j16);
                    this.f6883h2 ^= mixK2(j24);
                    return;
                case 10:
                    j19 = 0;
                    j18 = j19 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j17 = j18 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j16 = byteBuffer.getLong() ^ 0;
                    j24 = j17;
                    this.f6882h1 ^= mixK1(j16);
                    this.f6883h2 ^= mixK2(j24);
                    return;
                case 11:
                    j20 = 0;
                    j19 = j20 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j18 = j19 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j17 = j18 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j16 = byteBuffer.getLong() ^ 0;
                    j24 = j17;
                    this.f6882h1 ^= mixK1(j16);
                    this.f6883h2 ^= mixK2(j24);
                    return;
                case 12:
                    j21 = 0;
                    j20 = j21 ^ (UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j19 = j20 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j18 = j19 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j17 = j18 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j16 = byteBuffer.getLong() ^ 0;
                    j24 = j17;
                    this.f6882h1 ^= mixK1(j16);
                    this.f6883h2 ^= mixK2(j24);
                    return;
                case 13:
                    j22 = 0;
                    j21 = j22 ^ (UnsignedBytes.toInt(byteBuffer.get(12)) << 32);
                    j20 = j21 ^ (UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j19 = j20 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j18 = j19 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j17 = j18 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j16 = byteBuffer.getLong() ^ 0;
                    j24 = j17;
                    this.f6882h1 ^= mixK1(j16);
                    this.f6883h2 ^= mixK2(j24);
                    return;
                case 14:
                    j23 = 0;
                    j22 = j23 ^ (UnsignedBytes.toInt(byteBuffer.get(13)) << 40);
                    j21 = j22 ^ (UnsignedBytes.toInt(byteBuffer.get(12)) << 32);
                    j20 = j21 ^ (UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j19 = j20 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j18 = j19 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j17 = j18 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j16 = byteBuffer.getLong() ^ 0;
                    j24 = j17;
                    this.f6882h1 ^= mixK1(j16);
                    this.f6883h2 ^= mixK2(j24);
                    return;
                case 15:
                    j23 = (UnsignedBytes.toInt(byteBuffer.get(14)) << 48) ^ 0;
                    j22 = j23 ^ (UnsignedBytes.toInt(byteBuffer.get(13)) << 40);
                    j21 = j22 ^ (UnsignedBytes.toInt(byteBuffer.get(12)) << 32);
                    j20 = j21 ^ (UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j19 = j20 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j18 = j19 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j17 = j18 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j16 = byteBuffer.getLong() ^ 0;
                    j24 = j17;
                    this.f6882h1 ^= mixK1(j16);
                    this.f6883h2 ^= mixK2(j24);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }
    }

    public Murmur3_128HashFunction(int i10) {
        this.seed = i10;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 128;
    }

    public boolean equals(@CheckForNull Object obj) {
        return (obj instanceof Murmur3_128HashFunction) && this.seed == ((Murmur3_128HashFunction) obj).seed;
    }

    public int hashCode() {
        return Murmur3_128HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_128Hasher(this.seed);
    }

    public String toString() {
        int i10 = this.seed;
        StringBuilder sb = new StringBuilder(32);
        sb.append("Hashing.murmur3_128(");
        sb.append(i10);
        sb.append(")");
        return sb.toString();
    }
}
