package com.hpplay.sdk.source.mdns.xbill.dns.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class HMAC {
    private static final byte IPAD = 54;
    private static final byte OPAD = 92;
    private int blockLength;
    private MessageDigest digest;
    private byte[] ipad;
    private byte[] opad;

    public HMAC(MessageDigest messageDigest, int i10, byte[] bArr) {
        messageDigest.reset();
        this.digest = messageDigest;
        this.blockLength = i10;
        init(bArr);
    }

    private void init(byte[] bArr) {
        if (bArr.length > this.blockLength) {
            bArr = this.digest.digest(bArr);
            this.digest.reset();
        }
        int i10 = this.blockLength;
        this.ipad = new byte[i10];
        this.opad = new byte[i10];
        int i11 = 0;
        while (i11 < bArr.length) {
            this.ipad[i11] = (byte) (54 ^ bArr[i11]);
            this.opad[i11] = (byte) (92 ^ bArr[i11]);
            i11++;
        }
        while (i11 < this.blockLength) {
            this.ipad[i11] = IPAD;
            this.opad[i11] = OPAD;
            i11++;
        }
        this.digest.update(this.ipad);
    }

    public void clear() {
        this.digest.reset();
        this.digest.update(this.ipad);
    }

    public int digestLength() {
        return this.digest.getDigestLength();
    }

    public byte[] sign() {
        byte[] digest = this.digest.digest();
        this.digest.reset();
        this.digest.update(this.opad);
        return this.digest.digest(digest);
    }

    public void update(byte[] bArr, int i10, int i11) {
        this.digest.update(bArr, i10, i11);
    }

    public boolean verify(byte[] bArr) {
        return verify(bArr, false);
    }

    public void update(byte[] bArr) {
        this.digest.update(bArr);
    }

    public boolean verify(byte[] bArr, boolean z10) {
        byte[] sign = sign();
        if (z10 && bArr.length < sign.length) {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(sign, 0, bArr2, 0, length);
            sign = bArr2;
        }
        return Arrays.equals(bArr, sign);
    }

    public HMAC(String str, int i10, byte[] bArr) {
        try {
            this.digest = MessageDigest.getInstance(str);
            this.blockLength = i10;
            init(bArr);
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalArgumentException("unknown digest algorithm " + str);
        }
    }

    public HMAC(MessageDigest messageDigest, byte[] bArr) {
        this(messageDigest, 64, bArr);
    }

    public HMAC(String str, byte[] bArr) {
        this(str, 64, bArr);
    }
}
