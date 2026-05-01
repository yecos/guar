package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {
    static final HashFunction FARMHASH_FINGERPRINT_64 = new FarmHashFingerprint64();
    private static final long K0 = -4348849565147123417L;
    private static final long K1 = -5435081209227447693L;
    private static final long K2 = -7286425919675154353L;

    @VisibleForTesting
    public static long fingerprint(byte[] bArr, int i10, int i11) {
        return i11 <= 32 ? i11 <= 16 ? hashLength0to16(bArr, i10, i11) : hashLength17to32(bArr, i10, i11) : i11 <= 64 ? hashLength33To64(bArr, i10, i11) : hashLength65Plus(bArr, i10, i11);
    }

    private static long hashLength0to16(byte[] bArr, int i10, int i11) {
        if (i11 >= 8) {
            long j10 = (i11 * 2) + K2;
            long load64 = LittleEndianByteArray.load64(bArr, i10) + K2;
            long load642 = LittleEndianByteArray.load64(bArr, (i10 + i11) - 8);
            return hashLength16((Long.rotateRight(load642, 37) * j10) + load64, (Long.rotateRight(load64, 25) + load642) * j10, j10);
        }
        if (i11 >= 4) {
            return hashLength16(i11 + ((LittleEndianByteArray.load32(bArr, i10) & 4294967295L) << 3), LittleEndianByteArray.load32(bArr, (i10 + i11) - 4) & 4294967295L, (i11 * 2) + K2);
        }
        if (i11 <= 0) {
            return K2;
        }
        return shiftMix((((bArr[i10] & UnsignedBytes.MAX_VALUE) + ((bArr[(i11 >> 1) + i10] & UnsignedBytes.MAX_VALUE) << 8)) * K2) ^ ((i11 + ((bArr[i10 + (i11 - 1)] & 255) << 2)) * K0)) * K2;
    }

    private static long hashLength16(long j10, long j11, long j12) {
        long j13 = (j10 ^ j11) * j12;
        long j14 = ((j13 ^ (j13 >>> 47)) ^ j11) * j12;
        return (j14 ^ (j14 >>> 47)) * j12;
    }

    private static long hashLength17to32(byte[] bArr, int i10, int i11) {
        long j10 = (i11 * 2) + K2;
        long load64 = LittleEndianByteArray.load64(bArr, i10) * K1;
        long load642 = LittleEndianByteArray.load64(bArr, i10 + 8);
        int i12 = i10 + i11;
        long load643 = LittleEndianByteArray.load64(bArr, i12 - 8) * j10;
        return hashLength16((LittleEndianByteArray.load64(bArr, i12 - 16) * K2) + Long.rotateRight(load64 + load642, 43) + Long.rotateRight(load643, 30), load64 + Long.rotateRight(load642 + K2, 18) + load643, j10);
    }

    private static long hashLength33To64(byte[] bArr, int i10, int i11) {
        long j10 = (i11 * 2) + K2;
        long load64 = LittleEndianByteArray.load64(bArr, i10) * K2;
        long load642 = LittleEndianByteArray.load64(bArr, i10 + 8);
        int i12 = i10 + i11;
        long load643 = LittleEndianByteArray.load64(bArr, i12 - 8) * j10;
        long rotateRight = Long.rotateRight(load64 + load642, 43) + Long.rotateRight(load643, 30) + (LittleEndianByteArray.load64(bArr, i12 - 16) * K2);
        long hashLength16 = hashLength16(rotateRight, load643 + Long.rotateRight(load642 + K2, 18) + load64, j10);
        long load644 = LittleEndianByteArray.load64(bArr, i10 + 16) * j10;
        long load645 = LittleEndianByteArray.load64(bArr, i10 + 24);
        long load646 = (rotateRight + LittleEndianByteArray.load64(bArr, i12 - 32)) * j10;
        return hashLength16(((hashLength16 + LittleEndianByteArray.load64(bArr, i12 - 24)) * j10) + Long.rotateRight(load644 + load645, 43) + Long.rotateRight(load646, 30), load644 + Long.rotateRight(load645 + load64, 18) + load646, j10);
    }

    private static long hashLength65Plus(byte[] bArr, int i10, int i11) {
        long j10 = 81;
        long j11 = (j10 * K1) + 113;
        long shiftMix = shiftMix((j11 * K2) + 113) * K2;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long load64 = (j10 * K2) + LittleEndianByteArray.load64(bArr, i10);
        int i12 = i11 - 1;
        int i13 = i10 + ((i12 / 64) * 64);
        int i14 = i12 & 63;
        int i15 = (i13 + i14) - 63;
        int i16 = i10;
        while (true) {
            long rotateRight = Long.rotateRight(load64 + j11 + jArr[0] + LittleEndianByteArray.load64(bArr, i16 + 8), 37) * K1;
            long rotateRight2 = Long.rotateRight(j11 + jArr[1] + LittleEndianByteArray.load64(bArr, i16 + 48), 42) * K1;
            long j12 = rotateRight ^ jArr2[1];
            long load642 = rotateRight2 + jArr[0] + LittleEndianByteArray.load64(bArr, i16 + 40);
            long rotateRight3 = Long.rotateRight(shiftMix + jArr2[0], 33) * K1;
            weakHashLength32WithSeeds(bArr, i16, jArr[1] * K1, j12 + jArr2[0], jArr);
            weakHashLength32WithSeeds(bArr, i16 + 32, rotateRight3 + jArr2[1], load642 + LittleEndianByteArray.load64(bArr, i16 + 16), jArr2);
            int i17 = i16 + 64;
            if (i17 == i13) {
                long j13 = K1 + ((j12 & 255) << 1);
                long j14 = jArr2[0] + i14;
                jArr2[0] = j14;
                long j15 = jArr[0] + j14;
                jArr[0] = j15;
                jArr2[0] = jArr2[0] + j15;
                long rotateRight4 = Long.rotateRight(rotateRight3 + load642 + jArr[0] + LittleEndianByteArray.load64(bArr, i15 + 8), 37) * j13;
                long rotateRight5 = Long.rotateRight(load642 + jArr[1] + LittleEndianByteArray.load64(bArr, i15 + 48), 42) * j13;
                long j16 = rotateRight4 ^ (jArr2[1] * 9);
                long load643 = rotateRight5 + (jArr[0] * 9) + LittleEndianByteArray.load64(bArr, i15 + 40);
                long rotateRight6 = Long.rotateRight(j12 + jArr2[0], 33) * j13;
                weakHashLength32WithSeeds(bArr, i15, jArr[1] * j13, j16 + jArr2[0], jArr);
                weakHashLength32WithSeeds(bArr, i15 + 32, rotateRight6 + jArr2[1], load643 + LittleEndianByteArray.load64(bArr, i15 + 16), jArr2);
                return hashLength16(hashLength16(jArr[0], jArr2[0], j13) + (shiftMix(load643) * K0) + j16, hashLength16(jArr[1], jArr2[1], j13) + rotateRight6, j13);
            }
            i16 = i17;
            shiftMix = j12;
            j11 = load642;
            load64 = rotateRight3;
        }
    }

    private static long shiftMix(long j10) {
        return j10 ^ (j10 >>> 47);
    }

    private static void weakHashLength32WithSeeds(byte[] bArr, int i10, long j10, long j11, long[] jArr) {
        long load64 = LittleEndianByteArray.load64(bArr, i10);
        long load642 = LittleEndianByteArray.load64(bArr, i10 + 8);
        long load643 = LittleEndianByteArray.load64(bArr, i10 + 16);
        long load644 = LittleEndianByteArray.load64(bArr, i10 + 24);
        long j12 = j10 + load64;
        long j13 = load642 + j12 + load643;
        long rotateRight = Long.rotateRight(j11 + j12 + load644, 21) + Long.rotateRight(j13, 44);
        jArr[0] = j13 + load644;
        jArr[1] = rotateRight + j12;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    @Override // com.google.common.hash.AbstractNonStreamingHashFunction, com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i10, int i11) {
        Preconditions.checkPositionIndexes(i10, i10 + i11, bArr.length);
        return HashCode.fromLong(fingerprint(bArr, i10, i11));
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}
