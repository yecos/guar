package com.hpplay.component.protocol.srp6;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.SecureRandom;

/* loaded from: classes2.dex */
public class SRP6VerifierGenerator {
    private SRP6CryptoParams config;
    protected final SRP6Routines srp6Routines;
    private XRoutine xRoutine;

    public SRP6VerifierGenerator(SRP6CryptoParams sRP6CryptoParams) {
        this(sRP6CryptoParams, new SRP6Routines());
    }

    public byte[] generateRandomSalt(int i10) {
        return this.srp6Routines.generateRandomSalt(i10);
    }

    public BigInteger generateVerifier(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            throw new IllegalArgumentException("The salt 's' must not be null");
        }
        if (bArr3 == null) {
            throw new IllegalArgumentException("The password 'P' must not be null");
        }
        XRoutine xRoutine = this.xRoutine;
        BigInteger computeX = xRoutine != null ? xRoutine.computeX(this.config.getMessageDigestInstance(), bArr, bArr2, bArr3) : this.srp6Routines.computeX(this.config.getMessageDigestInstance(), bArr, bArr3);
        SRP6Routines sRP6Routines = this.srp6Routines;
        SRP6CryptoParams sRP6CryptoParams = this.config;
        return sRP6Routines.computeVerifier(sRP6CryptoParams.N, sRP6CryptoParams.f7365g, computeX);
    }

    public XRoutine getXRoutine() {
        return this.xRoutine;
    }

    public void setXRoutine(XRoutine xRoutine) {
        this.xRoutine = xRoutine;
    }

    public SRP6VerifierGenerator(SRP6CryptoParams sRP6CryptoParams, SRP6Routines sRP6Routines) {
        this.xRoutine = null;
        if (sRP6CryptoParams == null) {
            throw new IllegalArgumentException("The SRP-6a crypto parameters must not be null");
        }
        this.config = sRP6CryptoParams;
        this.srp6Routines = sRP6Routines;
    }

    public byte[] generateRandomSalt(int i10, SecureRandom secureRandom) {
        return this.srp6Routines.generateRandomSalt(i10, secureRandom);
    }

    public byte[] generateRandomSalt() {
        return this.srp6Routines.generateRandomSalt(16);
    }

    public BigInteger generateVerifier(BigInteger bigInteger, String str, String str2) {
        return generateVerifier(BigIntegerUtils.bigIntegerToBytes(bigInteger), str != null ? str.getBytes(Charset.forName("UTF-8")) : null, str2.getBytes(Charset.forName("UTF-8")));
    }

    public BigInteger generateVerifier(byte[] bArr, byte[] bArr2) {
        return generateVerifier(bArr, (byte[]) null, bArr2);
    }

    public BigInteger generateVerifier(BigInteger bigInteger, String str) {
        return generateVerifier(bigInteger, (String) null, str);
    }
}
