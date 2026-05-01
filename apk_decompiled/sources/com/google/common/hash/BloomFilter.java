package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.math.DoubleMath;
import com.google.common.math.LongMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import javax.annotation.CheckForNull;

@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    private final BloomFilterStrategies.LockFreeBitArray bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    public static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        public SerialForm(BloomFilter<T> bloomFilter) {
            this.data = BloomFilterStrategies.LockFreeBitArray.toPlainArray(((BloomFilter) bloomFilter).bits.data);
            this.numHashFunctions = ((BloomFilter) bloomFilter).numHashFunctions;
            this.funnel = ((BloomFilter) bloomFilter).funnel;
            this.strategy = ((BloomFilter) bloomFilter).strategy;
        }

        public Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.LockFreeBitArray(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    public interface Strategy extends Serializable {
        <T> boolean mightContain(@ParametricNullness T t10, Funnel<? super T> funnel, int i10, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);

        int ordinal();

        <T> boolean put(@ParametricNullness T t10, Funnel<? super T> funnel, int i10, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i10, double d10) {
        return create(funnel, i10, d10);
    }

    @VisibleForTesting
    public static long optimalNumOfBits(long j10, double d10) {
        if (d10 == 0.0d) {
            d10 = Double.MIN_VALUE;
        }
        double d11 = -j10;
        double log = Math.log(d10);
        Double.isNaN(d11);
        return (long) ((d11 * log) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    @VisibleForTesting
    public static int optimalNumOfHashFunctions(long j10, long j11) {
        double d10 = j11;
        double d11 = j10;
        Double.isNaN(d10);
        Double.isNaN(d11);
        return Math.max(1, (int) Math.round((d10 / d11) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel) {
        int i10;
        int i11;
        Preconditions.checkNotNull(inputStream, "InputStream");
        Preconditions.checkNotNull(funnel, "Funnel");
        byte b10 = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte readByte = dataInputStream.readByte();
            try {
                i11 = UnsignedBytes.toInt(dataInputStream.readByte());
                try {
                    int readInt = dataInputStream.readInt();
                    try {
                        BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[readByte];
                        BloomFilterStrategies.LockFreeBitArray lockFreeBitArray = new BloomFilterStrategies.LockFreeBitArray(LongMath.checkedMultiply(readInt, 64L));
                        for (int i12 = 0; i12 < readInt; i12++) {
                            lockFreeBitArray.putData(i12, dataInputStream.readLong());
                        }
                        return new BloomFilter<>(lockFreeBitArray, i11, funnel, bloomFilterStrategies);
                    } catch (RuntimeException e10) {
                        e = e10;
                        b10 = readByte;
                        i10 = readInt;
                        StringBuilder sb = new StringBuilder(134);
                        sb.append("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ");
                        sb.append((int) b10);
                        sb.append(" numHashFunctions: ");
                        sb.append(i11);
                        sb.append(" dataLength: ");
                        sb.append(i10);
                        throw new IOException(sb.toString(), e);
                    }
                } catch (RuntimeException e11) {
                    e = e11;
                    b10 = readByte;
                    i10 = -1;
                    StringBuilder sb2 = new StringBuilder(134);
                    sb2.append("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ");
                    sb2.append((int) b10);
                    sb2.append(" numHashFunctions: ");
                    sb2.append(i11);
                    sb2.append(" dataLength: ");
                    sb2.append(i10);
                    throw new IOException(sb2.toString(), e);
                }
            } catch (RuntimeException e12) {
                e = e12;
                i11 = -1;
            }
        } catch (RuntimeException e13) {
            e = e13;
            i10 = -1;
            i11 = -1;
        }
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(@ParametricNullness T t10) {
        return mightContain(t10);
    }

    public long approximateElementCount() {
        long bitSize = this.bits.bitSize();
        double bitCount = this.bits.bitCount();
        double d10 = bitSize;
        Double.isNaN(bitCount);
        Double.isNaN(d10);
        double d11 = -Math.log1p(-(bitCount / d10));
        Double.isNaN(d10);
        double d12 = d11 * d10;
        double d13 = this.numHashFunctions;
        Double.isNaN(d13);
        return DoubleMath.roundToLong(d12 / d13, RoundingMode.HALF_UP);
    }

    @VisibleForTesting
    public long bitSize() {
        return this.bits.bitSize();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
    }

    public double expectedFpp() {
        double bitCount = this.bits.bitCount();
        double bitSize = bitSize();
        Double.isNaN(bitCount);
        Double.isNaN(bitSize);
        return Math.pow(bitCount / bitSize, this.numHashFunctions);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }

    public boolean mightContain(@ParametricNullness T t10) {
        return this.strategy.mightContain(t10, this.funnel, this.numHashFunctions, this.bits);
    }

    @CanIgnoreReturnValue
    public boolean put(@ParametricNullness T t10) {
        return this.strategy.put(t10, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        Preconditions.checkArgument(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        int i10 = this.numHashFunctions;
        int i11 = bloomFilter.numHashFunctions;
        Preconditions.checkArgument(i10 == i11, "BloomFilters must have the same number of hash functions (%s != %s)", i10, i11);
        Preconditions.checkArgument(bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), bloomFilter.bitSize());
        Preconditions.checkArgument(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        Preconditions.checkArgument(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.putAll(bloomFilter.bits);
    }

    public void writeTo(OutputStream outputStream) {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.checkedCast(this.strategy.ordinal()));
        dataOutputStream.writeByte(UnsignedBytes.checkedCast(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.data.length());
        for (int i10 = 0; i10 < this.bits.data.length(); i10++) {
            dataOutputStream.writeLong(this.bits.data.get(i10));
        }
    }

    private BloomFilter(BloomFilterStrategies.LockFreeBitArray lockFreeBitArray, int i10, Funnel<? super T> funnel, Strategy strategy) {
        Preconditions.checkArgument(i10 > 0, "numHashFunctions (%s) must be > 0", i10);
        Preconditions.checkArgument(i10 <= 255, "numHashFunctions (%s) must be <= 255", i10);
        this.bits = (BloomFilterStrategies.LockFreeBitArray) Preconditions.checkNotNull(lockFreeBitArray);
        this.numHashFunctions = i10;
        this.funnel = (Funnel) Preconditions.checkNotNull(funnel);
        this.strategy = (Strategy) Preconditions.checkNotNull(strategy);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j10, double d10) {
        return create(funnel, j10, d10, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    @VisibleForTesting
    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j10, double d10, Strategy strategy) {
        Preconditions.checkNotNull(funnel);
        Preconditions.checkArgument(j10 >= 0, "Expected insertions (%s) must be >= 0", j10);
        Preconditions.checkArgument(d10 > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d10));
        Preconditions.checkArgument(d10 < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d10));
        Preconditions.checkNotNull(strategy);
        if (j10 == 0) {
            j10 = 1;
        }
        long optimalNumOfBits = optimalNumOfBits(j10, d10);
        try {
            return new BloomFilter<>(new BloomFilterStrategies.LockFreeBitArray(optimalNumOfBits), optimalNumOfHashFunctions(j10, optimalNumOfBits), funnel, strategy);
        } catch (IllegalArgumentException e10) {
            StringBuilder sb = new StringBuilder(57);
            sb.append("Could not create BloomFilter of ");
            sb.append(optimalNumOfBits);
            sb.append(" bits");
            throw new IllegalArgumentException(sb.toString(), e10);
        }
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i10) {
        return create(funnel, i10);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j10) {
        return create(funnel, j10, 0.03d);
    }
}
