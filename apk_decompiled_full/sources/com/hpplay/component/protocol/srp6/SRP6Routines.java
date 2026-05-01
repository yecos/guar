package com.hpplay.component.protocol.srp6;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;

/* loaded from: classes2.dex */
public class SRP6Routines implements Serializable {
    protected SecureRandom random = new SecureRandom();

    public BigInteger computeClientEvidence(MessageDigest messageDigest, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        messageDigest.update(BigIntegerUtils.bigIntegerToBytes(bigInteger));
        messageDigest.update(BigIntegerUtils.bigIntegerToBytes(bigInteger2));
        messageDigest.update(BigIntegerUtils.bigIntegerToBytes(bigInteger3));
        return BigIntegerUtils.bigIntegerFromBytes(messageDigest.digest());
    }

    public BigInteger computeK(MessageDigest messageDigest, BigInteger bigInteger, BigInteger bigInteger2) {
        return hashPaddedPair(messageDigest, bigInteger, bigInteger, bigInteger2);
    }

    public BigInteger computePublicClientValue(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return bigInteger2.modPow(bigInteger3, bigInteger);
    }

    public BigInteger computePublicServerValue(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        return bigInteger2.modPow(bigInteger5, bigInteger).add(bigInteger4.multiply(bigInteger3)).mod(bigInteger);
    }

    public BigInteger computeServerEvidence(MessageDigest messageDigest, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        messageDigest.update(BigIntegerUtils.bigIntegerToBytes(bigInteger));
        messageDigest.update(BigIntegerUtils.bigIntegerToBytes(bigInteger2));
        messageDigest.update(BigIntegerUtils.bigIntegerToBytes(bigInteger3));
        return BigIntegerUtils.bigIntegerFromBytes(messageDigest.digest());
    }

    public BigInteger computeSessionKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7) {
        return bigInteger7.subtract(bigInteger2.modPow(bigInteger4, bigInteger).multiply(bigInteger3)).modPow(bigInteger5.multiply(bigInteger4).add(bigInteger6), bigInteger);
    }

    public BigInteger computeU(MessageDigest messageDigest, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return hashPaddedPair(messageDigest, bigInteger, bigInteger2, bigInteger3);
    }

    public BigInteger computeVerifier(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return bigInteger2.modPow(bigInteger3, bigInteger);
    }

    public BigInteger computeX(MessageDigest messageDigest, byte[] bArr, byte[] bArr2) {
        byte[] digest = messageDigest.digest(bArr2);
        messageDigest.update(bArr);
        messageDigest.update(digest);
        return BigIntegerUtils.bigIntegerFromBytes(messageDigest.digest());
    }

    public BigInteger generatePrivateValue(BigInteger bigInteger, SecureRandom secureRandom) {
        int max = Math.max(256, bigInteger.bitLength());
        BigInteger bigInteger2 = BigInteger.ZERO;
        while (BigInteger.ZERO.equals(bigInteger2)) {
            bigInteger2 = new BigInteger(max, secureRandom).mod(bigInteger);
        }
        return bigInteger2;
    }

    public byte[] generateRandomSalt(int i10) {
        return generateRandomSalt(i10, this.random);
    }

    public byte[] getPadded(BigInteger bigInteger, int i10) {
        byte[] bigIntegerToBytes = BigIntegerUtils.bigIntegerToBytes(bigInteger);
        if (bigIntegerToBytes.length >= i10) {
            return bigIntegerToBytes;
        }
        byte[] bArr = new byte[i10];
        System.arraycopy(bigIntegerToBytes, 0, bArr, i10 - bigIntegerToBytes.length, bigIntegerToBytes.length);
        return bArr;
    }

    public BigInteger hashPaddedPair(MessageDigest messageDigest, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        int bitLength = (bigInteger.bitLength() + 7) / 8;
        byte[] padded = getPadded(bigInteger2, bitLength);
        byte[] padded2 = getPadded(bigInteger3, bitLength);
        messageDigest.update(padded);
        messageDigest.update(padded2);
        return BigIntegerUtils.bigIntegerFromBytes(messageDigest.digest());
    }

    public boolean isValidPublicValue(BigInteger bigInteger, BigInteger bigInteger2) {
        return !bigInteger2.mod(bigInteger).equals(BigInteger.ZERO);
    }

    public byte[] generateRandomSalt(int i10, SecureRandom secureRandom) {
        byte[] bArr = new byte[i10];
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    public BigInteger computeSessionKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        return bigInteger2.modPow(bigInteger3, bigInteger).multiply(bigInteger4).modPow(bigInteger5, bigInteger);
    }
}
