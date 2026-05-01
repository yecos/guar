package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.CheckForNull;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* renamed from: c, reason: collision with root package name */
    private final int f6885c;

    /* renamed from: d, reason: collision with root package name */
    private final int f6886d;

    /* renamed from: k0, reason: collision with root package name */
    private final long f6887k0;

    /* renamed from: k1, reason: collision with root package name */
    private final long f6888k1;

    public static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* renamed from: b, reason: collision with root package name */
        private long f6889b;

        /* renamed from: c, reason: collision with root package name */
        private final int f6890c;

        /* renamed from: d, reason: collision with root package name */
        private final int f6891d;
        private long finalM;

        /* renamed from: v0, reason: collision with root package name */
        private long f6892v0;

        /* renamed from: v1, reason: collision with root package name */
        private long f6893v1;

        /* renamed from: v2, reason: collision with root package name */
        private long f6894v2;

        /* renamed from: v3, reason: collision with root package name */
        private long f6895v3;

        public SipHasher(int i10, int i11, long j10, long j11) {
            super(8);
            this.f6889b = 0L;
            this.finalM = 0L;
            this.f6890c = i10;
            this.f6891d = i11;
            this.f6892v0 = 8317987319222330741L ^ j10;
            this.f6893v1 = 7237128888997146477L ^ j11;
            this.f6894v2 = 7816392313619706465L ^ j10;
            this.f6895v3 = 8387220255154660723L ^ j11;
        }

        private void processM(long j10) {
            this.f6895v3 ^= j10;
            sipRound(this.f6890c);
            this.f6892v0 = j10 ^ this.f6892v0;
        }

        private void sipRound(int i10) {
            for (int i11 = 0; i11 < i10; i11++) {
                long j10 = this.f6892v0;
                long j11 = this.f6893v1;
                this.f6892v0 = j10 + j11;
                this.f6894v2 += this.f6895v3;
                this.f6893v1 = Long.rotateLeft(j11, 13);
                long rotateLeft = Long.rotateLeft(this.f6895v3, 16);
                long j12 = this.f6893v1;
                long j13 = this.f6892v0;
                this.f6893v1 = j12 ^ j13;
                this.f6895v3 = rotateLeft ^ this.f6894v2;
                long rotateLeft2 = Long.rotateLeft(j13, 32);
                long j14 = this.f6894v2;
                long j15 = this.f6893v1;
                this.f6894v2 = j14 + j15;
                this.f6892v0 = rotateLeft2 + this.f6895v3;
                this.f6893v1 = Long.rotateLeft(j15, 17);
                long rotateLeft3 = Long.rotateLeft(this.f6895v3, 21);
                long j16 = this.f6893v1;
                long j17 = this.f6894v2;
                this.f6893v1 = j16 ^ j17;
                this.f6895v3 = rotateLeft3 ^ this.f6892v0;
                this.f6894v2 = Long.rotateLeft(j17, 32);
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            long j10 = this.finalM ^ (this.f6889b << 56);
            this.finalM = j10;
            processM(j10);
            this.f6894v2 ^= 255;
            sipRound(this.f6891d);
            return HashCode.fromLong(((this.f6892v0 ^ this.f6893v1) ^ this.f6894v2) ^ this.f6895v3);
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void process(ByteBuffer byteBuffer) {
            this.f6889b += 8;
            processM(byteBuffer.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void processRemaining(ByteBuffer byteBuffer) {
            this.f6889b += byteBuffer.remaining();
            int i10 = 0;
            while (byteBuffer.hasRemaining()) {
                this.finalM ^= (byteBuffer.get() & 255) << i10;
                i10 += 8;
            }
        }
    }

    public SipHashFunction(int i10, int i11, long j10, long j11) {
        Preconditions.checkArgument(i10 > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i10);
        Preconditions.checkArgument(i11 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i11);
        this.f6885c = i10;
        this.f6886d = i11;
        this.f6887k0 = j10;
        this.f6888k1 = j11;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        return this.f6885c == sipHashFunction.f6885c && this.f6886d == sipHashFunction.f6886d && this.f6887k0 == sipHashFunction.f6887k0 && this.f6888k1 == sipHashFunction.f6888k1;
    }

    public int hashCode() {
        return (int) ((((SipHashFunction.class.hashCode() ^ this.f6885c) ^ this.f6886d) ^ this.f6887k0) ^ this.f6888k1);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.f6885c, this.f6886d, this.f6887k0, this.f6888k1);
    }

    public String toString() {
        int i10 = this.f6885c;
        int i11 = this.f6886d;
        long j10 = this.f6887k0;
        long j11 = this.f6888k1;
        StringBuilder sb = new StringBuilder(81);
        sb.append("Hashing.sipHash");
        sb.append(i10);
        sb.append(i11);
        sb.append("(");
        sb.append(j10);
        sb.append(", ");
        sb.append(j11);
        sb.append(")");
        return sb.toString();
    }
}
