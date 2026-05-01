package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class Fingerprint2011 extends AbstractNonStreamingHashFunction {
    static final HashFunction FINGERPRINT_2011 = new Fingerprint2011();
    private static final long K0 = -6505348102511208375L;
    private static final long K1 = -8261664234251669945L;
    private static final long K2 = -4288712594273399085L;
    private static final long K3 = -4132994306676758123L;

    @VisibleForTesting
    public static long fingerprint(byte[] bArr, int i10, int i11) {
        long murmurHash64WithSeed = i11 <= 32 ? murmurHash64WithSeed(bArr, i10, i11, -1397348546323613475L) : i11 <= 64 ? hashLength33To64(bArr, i10, i11) : fullFingerprint(bArr, i10, i11);
        long j10 = K0;
        long load64 = i11 >= 8 ? LittleEndianByteArray.load64(bArr, i10) : -6505348102511208375L;
        if (i11 >= 9) {
            j10 = LittleEndianByteArray.load64(bArr, (i10 + i11) - 8);
        }
        long hash128to64 = hash128to64(murmurHash64WithSeed + j10, load64);
        return (hash128to64 == 0 || hash128to64 == 1) ? hash128to64 - 2 : hash128to64;
    }

    private static long fullFingerprint(byte[] bArr, int i10, int i11) {
        long load64 = LittleEndianByteArray.load64(bArr, i10);
        int i12 = i10 + i11;
        long load642 = LittleEndianByteArray.load64(bArr, i12 - 16) ^ K1;
        long load643 = LittleEndianByteArray.load64(bArr, i12 - 56) ^ K0;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long j10 = i11;
        weakHashLength32WithSeeds(bArr, i12 - 64, j10, load642, jArr);
        weakHashLength32WithSeeds(bArr, i12 - 32, j10 * K1, K0, jArr2);
        long shiftMix = load643 + (shiftMix(jArr[1]) * K1);
        long rotateRight = Long.rotateRight(shiftMix + load64, 39) * K1;
        long rotateRight2 = Long.rotateRight(load642, 33) * K1;
        int i13 = i10;
        int i14 = (i11 - 1) & (-64);
        while (true) {
            long rotateRight3 = Long.rotateRight(rotateRight + rotateRight2 + jArr[0] + LittleEndianByteArray.load64(bArr, i13 + 16), 37) * K1;
            long rotateRight4 = Long.rotateRight(rotateRight2 + jArr[1] + LittleEndianByteArray.load64(bArr, i13 + 48), 42) * K1;
            long j11 = rotateRight3 ^ jArr2[1];
            long j12 = rotateRight4 ^ jArr[0];
            long rotateRight5 = Long.rotateRight(shiftMix ^ jArr2[0], 33);
            weakHashLength32WithSeeds(bArr, i13, jArr[1] * K1, j11 + jArr2[0], jArr);
            weakHashLength32WithSeeds(bArr, i13 + 32, jArr2[1] + rotateRight5, j12, jArr2);
            i13 += 64;
            i14 -= 64;
            if (i14 == 0) {
                return hash128to64(hash128to64(jArr[0], jArr2[0]) + (shiftMix(j12) * K1) + j11, hash128to64(jArr[1], jArr2[1]) + rotateRight5);
            }
            rotateRight = rotateRight5;
            shiftMix = j11;
            rotateRight2 = j12;
        }
    }

    @VisibleForTesting
    public static long hash128to64(long j10, long j11) {
        long j12 = (j11 ^ j10) * K3;
        long j13 = (j10 ^ (j12 ^ (j12 >>> 47))) * K3;
        return (j13 ^ (j13 >>> 47)) * K3;
    }

    private static long hashLength33To64(byte[] bArr, int i10, int i11) {
        long load64 = LittleEndianByteArray.load64(bArr, i10 + 24);
        int i12 = i10 + i11;
        int i13 = i12 - 16;
        long load642 = LittleEndianByteArray.load64(bArr, i10) + ((i11 + LittleEndianByteArray.load64(bArr, i13)) * K0);
        long rotateRight = Long.rotateRight(load642 + load64, 52);
        long rotateRight2 = Long.rotateRight(load642, 37);
        long load643 = load642 + LittleEndianByteArray.load64(bArr, i10 + 8);
        long rotateRight3 = rotateRight2 + Long.rotateRight(load643, 7);
        int i14 = i10 + 16;
        long load644 = load643 + LittleEndianByteArray.load64(bArr, i14);
        long j10 = load64 + load644;
        long rotateRight4 = rotateRight + Long.rotateRight(load644, 31) + rotateRight3;
        long load645 = LittleEndianByteArray.load64(bArr, i14) + LittleEndianByteArray.load64(bArr, i12 - 32);
        long load646 = LittleEndianByteArray.load64(bArr, i12 - 8);
        long rotateRight5 = Long.rotateRight(load645 + load646, 52);
        long rotateRight6 = Long.rotateRight(load645, 37);
        long load647 = load645 + LittleEndianByteArray.load64(bArr, i12 - 24);
        long rotateRight7 = rotateRight6 + Long.rotateRight(load647, 7);
        long load648 = load647 + LittleEndianByteArray.load64(bArr, i13);
        return shiftMix((shiftMix(((j10 + rotateRight5 + Long.rotateRight(load648, 31) + rotateRight7) * K2) + ((load646 + load648 + rotateRight4) * K0)) * K0) + rotateRight4) * K2;
    }

    @VisibleForTesting
    public static long murmurHash64WithSeed(byte[] bArr, int i10, int i11, long j10) {
        int i12 = i11 & (-8);
        int i13 = i11 & 7;
        long j11 = j10 ^ (i11 * K3);
        for (int i14 = 0; i14 < i12; i14 += 8) {
            j11 = (j11 ^ (shiftMix(LittleEndianByteArray.load64(bArr, i10 + i14) * K3) * K3)) * K3;
        }
        if (i13 != 0) {
            j11 = (LittleEndianByteArray.load64Safely(bArr, i10 + i12, i13) ^ j11) * K3;
        }
        return shiftMix(shiftMix(j11) * K3);
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
        long rotateRight = Long.rotateRight(j11 + j12 + load644, 51) + Long.rotateRight(j13, 23);
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
        return "Hashing.fingerprint2011()";
    }
}
